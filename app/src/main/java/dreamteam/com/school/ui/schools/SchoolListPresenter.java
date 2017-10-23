package dreamteam.com.school.ui.schools;

import java.util.List;

import dreamteam.com.school.Injector;
import dreamteam.com.school.common.mvp.BasePresenter;
import dreamteam.com.school.dao.SchoolDao;
import dreamteam.com.school.entity.DbSchool;
import dreamteam.com.school.util.Logger;

/**
 * Created by dima on 20.04.17.
 */

public class SchoolListPresenter extends BasePresenter<SchoolListView> {
    private static final String LOG_TAG = Logger.getClassTag(SchoolListPresenter.class);

    private SchoolDao schoolDao = new SchoolDao();

    public SchoolListPresenter() {
    }

    public void getAllSchools() {
        schoolDao.getAllSchoolsAsync()
                .subscribeOn(Injector.getIoScheduler())
                .observeOn(Injector.getMainScheduler())
                .subscribe(this::onSuccessGetAllSchools, this::onErrorGetAllSchools);
    }

    private void onSuccessGetAllSchools(List<DbSchool> schools) {
        performOnView(view -> view.onSchoolLoaded(schools));
    }

    private void onErrorGetAllSchools(Throwable throwable) {
        performOnView(view -> view.showError(throwable));
    }
}