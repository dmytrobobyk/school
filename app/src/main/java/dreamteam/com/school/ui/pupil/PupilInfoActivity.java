package dreamteam.com.school.ui.pupil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dreamteam.com.school.R;
import dreamteam.com.school.common.mvp.MvpActivity;
import dreamteam.com.school.entity.DbPupil;
import dreamteam.com.school.util.ClassUtil;
import dreamteam.com.school.util.GlideUtil;
import dreamteam.com.school.util.TextUtils;

/**
 * Created by dima on 20.09.17.
 */

public class PupilInfoActivity extends MvpActivity<PupilInfoPresenter> implements PupilInfoView {
    public static final String PUPIL_ID = "pupilId";

    @BindView(R.id.pupilImageView)
    ImageView pupilImageView;
    @BindView(R.id.pupilNameTextView)
    TextView pupilNameTextView;
    @BindView(R.id.pupilClassNameTextView)
    TextView pupilClassNameTextView;
    @BindView(R.id.ratingTextView)
    TextView ratingTextView;
    @BindView(R.id.titleLayout)
    TextView titleLayout;
    @BindView(R.id.pupilDescriptionTextView)
    TextView pupilDescriptionTextView;

    public static Intent newInstance(Context context, long pupilId) {
        Intent intent = new Intent(context, PupilInfoActivity.class);
        intent.putExtra(PUPIL_ID, pupilId);
        return intent;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pupil_info);
        setUnBinder(ButterKnife.bind(this));
        initToolbar();
        setToolbarTitle(getString(R.string.pupil_info_activity_title));
        TextUtils.setSpannableString(titleLayout, getString(R.string.title_description));
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getPresenter().getPupil(getIntent().getLongExtra(PUPIL_ID, 0));
    }

    @Override
    public void onPupilLoaded(DbPupil dbPupil) {
        setData(dbPupil);
    }

    private void setData(DbPupil dbPupil) {
        GlideUtil.setRoundedImage(dbPupil.getPhotoUrl(), pupilImageView);
        pupilNameTextView.setText(String.format(getString(R.string.two_words_with_space), dbPupil.getFirstName(), dbPupil.getLastName()));
        pupilClassNameTextView.setText(String.valueOf(dbPupil.getSchoolClassId()));
        ratingTextView.setText(ClassUtil.formatRating(dbPupil.getRating()));
        pupilDescriptionTextView.setText(dbPupil.getPersonalInfo());
    }

    @Override
    public PupilInfoPresenter createPresenter() {
        return new PupilInfoPresenter();
    }

    @Override
    public void showError(Throwable throwable) {

    }
}
