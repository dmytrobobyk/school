package dreamteam.com.school.ui.schools;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dreamteam.com.school.MockData;
import dreamteam.com.school.R;
import dreamteam.com.school.common.mvp.MvpActivity;
import dreamteam.com.school.entity.DbSchool;
import dreamteam.com.school.ui.SchoolActivity;
import dreamteam.com.school.ui.about.AboutActivity;
import dreamteam.com.school.ui.schools.adapter.SchoolListAdapter;

/**
 * Created by dima on 07.04.17.
 */

public class SchoolListActivity extends MvpActivity<SchoolListPresenter> implements SchoolListView, SchoolListAdapter.SchoolActionListener {
    public final String LOG_TAG = this.getClass().getName();

    @BindView(R.id.schoolsListRecyclerView)
    RecyclerView schoolsListRecyclerView;
    @BindView(R.id.navigation_drawer)
    DrawerLayout navigationDrawer;
    @BindView(R.id.mainNavigationView)
    NavigationView mainNavigationView;

    private MenuItem actionMenu;
    private SchoolListAdapter adapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        actionMenu = (MenuItem) findViewById(R.id.action_menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                navigationDrawer.openDrawer(GravityCompat.START);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_list);
        setUnBinder(ButterKnife.bind(this));

        MockData.saveSchools();
        MockData.savePupils();
        MockData.saveDirector();
        initToolbar();
        initAdapter();
        setToolbarTitle(getString(R.string.schools_list));
        initNavigationDrawer();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getPresenter().getAllSchools();
    }

    private void initAdapter() {
        schoolsListRecyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        schoolsListRecyclerView.setLayoutManager(llm);

        adapter = new SchoolListAdapter(this);
        adapter.setOnSchoolActionListener(this);
        schoolsListRecyclerView.setAdapter(adapter);
    }

    private final NavigationView.OnNavigationItemSelectedListener navigationListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.actionAboutApp:
                    Intent intent = new Intent(SchoolListActivity.this, AboutActivity.class);
                    startActivity(intent);
                    break;
            }
            return true;
        }
    };

    private void initNavigationDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, navigationDrawer, R.string.menu_open, R.string.menu_close);
        navigationDrawer.addDrawerListener(toggle);
        toggle.syncState();

        mainNavigationView.setNavigationItemSelectedListener(navigationListener);
    }

    @Override
    public void onSchoolItemClicked(DbSchool dbSchool) {
        startActivity(SchoolActivity.openSchoolActivity(this, dbSchool.getSchoolId()));
    }

    @Override
    public void onSchoolLoaded(List<DbSchool> schools) {
        if (adapter == null) {
            adapter = new SchoolListAdapter(this);
            schoolsListRecyclerView.setAdapter(adapter);
        }
        adapter.addSchools(schools);
        adapter.notifyDataSetChanged();
    }

    @Override
    public SchoolListPresenter createPresenter() {
        return new SchoolListPresenter();
    }

    @Override
    public void showError(Throwable throwable) {
        Log.d(LOG_TAG, throwable.toString());

    }
}
