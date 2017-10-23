package dreamteam.com.school.ui.school.school;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import dreamteam.com.school.R;
import dreamteam.com.school.common.mvp.MvpFragment;
import dreamteam.com.school.entity.DbSchool;
import dreamteam.com.school.util.Logger;
import dreamteam.com.school.util.TextUtils;

/**
 * Created by dima on 01.09.17.
 */
public class SchoolFragment extends MvpFragment<SchoolFragmentPresenter> implements SchoolView {
    private static final String LOG_TAG = Logger.getClassTag(SchoolFragment.class);
    public static final String SCHOOL_ID = "schoolId";

    @BindView(R.id.schoolImageView)
    ImageView schoolImageView;
    @BindView(R.id.schoolNameTextView)
    TextView schoolNameTextView;
    @BindView(R.id.schoolLogoImageView)
    ImageView schoolLogoImageView;
    @BindView(R.id.schoolLocationTextView)
    TextView schoolLocationTextView;
    @BindView(R.id.schoolDescriptionTextView)
    TextView schoolDescriptionTextView;
    @BindView(R.id.schoolWebSiteTextView)
    TextView schoolWebSiteTextView;

    public static SchoolFragment newInstance(int schoolId) {
        SchoolFragment schoolFragment = new SchoolFragment();
        Bundle args = new Bundle();
        args.putInt(SCHOOL_ID, schoolId);
        schoolFragment.setArguments(args);
        return schoolFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_school_info, null);

        setUnbinder(ButterKnife.bind(this, view));
        schoolWebSiteTextView.setOnClickListener(this::openSchoolWebsite);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPresenter().getSchoolById(getArguments().getInt(SCHOOL_ID));
    }

    @Override
    public SchoolFragmentPresenter createPresenter() {
        return new SchoolFragmentPresenter();
    }

    @Override
    public void onSchoolLoaded(DbSchool dbSchool) {
        setSchoolData(dbSchool);
    }

    private void setSchoolData(DbSchool dbSchool) {
        Glide.with(this)
                .load(dbSchool.getPhotoUrl())
                .centerCrop()
                .placeholder(R.drawable.ic_drawer_profile)
                .error(R.drawable.splash_image)
                .into(schoolImageView);
        schoolNameTextView.setText(dbSchool.getSchoolName());
        TextUtils.setWrappedText(
                schoolLogoImageView,
                dbSchool.getLogoUrl(),
                schoolDescriptionTextView,
                dbSchool.getSchoolDescription());
        schoolLocationTextView.setText(String.format(
                getString(R.string.school_location),
                dbSchool.getSchoolCity(),
                dbSchool.getSchoolCountry()));
        TextUtils.setSpannableString(schoolWebSiteTextView, dbSchool.getWebsiteUrl());
    }

    public void openSchoolWebsite(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(schoolWebSiteTextView.getText().toString()));
        startActivity(intent);
    }

    @Override
    public void showError(Throwable throwable) {

    }
}
