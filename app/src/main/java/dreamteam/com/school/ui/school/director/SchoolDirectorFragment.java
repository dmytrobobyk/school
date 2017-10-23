package dreamteam.com.school.ui.school.director;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dreamteam.com.school.R;
import dreamteam.com.school.common.mvp.MvpFragment;
import dreamteam.com.school.entity.DbDirector;
import dreamteam.com.school.ui.school.school.SchoolFragment;
import dreamteam.com.school.util.GlideUtil;
import dreamteam.com.school.util.Logger;
import dreamteam.com.school.util.TextUtils;

/**
 * Created by dima on 10.09.17.
 */

public class SchoolDirectorFragment extends MvpFragment<SchoolDirectorPresenter> implements SchoolDirectorView {
    private static final String LOG_TAG = Logger.getClassTag(SchoolDirectorFragment.class);

    @BindView(R.id.directorImageView)
    ImageView directorImageView;
    @BindView(R.id.titleLayout)
    TextView titleLayout;
    @BindView(R.id.directorNameTextView)
    TextView directorNameTextView;
    @BindView(R.id.directorDescriptionTextView)
    TextView directorDescriptionTextView;

    public static SchoolDirectorFragment newInstance(int schoolId) {
        SchoolDirectorFragment schoolDirectorFragment = new SchoolDirectorFragment();
        Bundle args = new Bundle();
        args.putInt(SchoolFragment.SCHOOL_ID, schoolId);
        schoolDirectorFragment.setArguments(args);
        return schoolDirectorFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_school_director, null);

        setUnbinder(ButterKnife.bind(this, view));
        TextUtils.setSpannableString(titleLayout, getString(R.string.director_info_title));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPresenter().getDirectorBySchoolId(getArguments().getInt(SchoolFragment.SCHOOL_ID));
    }

    @Override
    public void onDirectorDataLoad(DbDirector dbDirector) {
        setDirectorData(dbDirector);
    }

    private void setDirectorData(DbDirector dbDirector) {
        GlideUtil.setRoundedImage(dbDirector.getDirectorPhoto(), directorImageView);
        directorNameTextView.setText(String.format(getString(R.string.two_words_with_space),
                dbDirector.getFirstName(), dbDirector.getLastName()));
        directorDescriptionTextView.setText(dbDirector.getDirectorDescription());
    }

    @Override
    public SchoolDirectorPresenter createPresenter() {
        return new SchoolDirectorPresenter();
    }

    @Override
    public void showError(Throwable throwable) {

    }
}
