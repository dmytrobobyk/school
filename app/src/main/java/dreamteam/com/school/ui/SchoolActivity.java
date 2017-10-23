package dreamteam.com.school.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import dreamteam.com.school.R;
import dreamteam.com.school.common.mvp.BaseActivity;
import dreamteam.com.school.ui.school.director.SchoolDirectorFragment;
import dreamteam.com.school.ui.school.pupils.PupilListFragment;
import dreamteam.com.school.ui.school.school.SchoolFragment;
import dreamteam.com.school.util.Logger;
import dreamteam.com.school.view.CustomTabLayout;
import dreamteam.com.school.view.TabInfo;
import dreamteam.com.school.view.TabsAdapter;

/**
 * Created by dima on 18.08.17.
 */

public class SchoolActivity extends BaseActivity {
    private static final String LOG_TAG = Logger.getClassTag(SchoolActivity.class);

    @BindView(R.id.schoolViewPager)
    ViewPager schoolViewPager;
    @BindView(R.id.schoolTabs)
    CustomTabLayout tabLayout;

    private TabsAdapter tabsAdapter;
    private int schoolId;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public static Intent openSchoolActivity(Context context, int schoolId) {
        Intent intent = new Intent(context, SchoolActivity.class);
        intent.putExtra(SchoolFragment.SCHOOL_ID, schoolId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);
        setUnBinder(ButterKnife.bind(this));

        schoolId = getIntent().getIntExtra(SchoolFragment.SCHOOL_ID, 0);

        initToolbar();
        initTabLayout();
        initViewPager();
    }

    private void initTabLayout() {
        tabLayout.setupWithViewPager(schoolViewPager);
        tabLayout.setCustomView(R.layout.tab_layout);
    }

    protected void initViewPager() {
        tabsAdapter = new TabsAdapter(getSupportFragmentManager(),
                new TabInfo(getString(R.string.school_fragment_title),
                        SchoolFragment.newInstance(schoolId)),
                new TabInfo(getString(R.string.school_director_title),
                        SchoolDirectorFragment.newInstance(schoolId)),
                new TabInfo(getString(R.string.school_pupils_title),
                        PupilListFragment.newInstance(schoolId)));

        schoolViewPager.setAdapter(tabsAdapter);
        schoolViewPager.setOffscreenPageLimit(3);
    }

    // TODO: 21.08.17 add navigation drawer and load user photo into navigation drawer

}
