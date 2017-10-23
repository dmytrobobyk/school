package dreamteam.com.school.ui.school.director;

import dreamteam.com.school.Injector;
import dreamteam.com.school.common.mvp.BasePresenter;
import dreamteam.com.school.dao.DirectorDao;
import dreamteam.com.school.entity.DbDirector;
import dreamteam.com.school.util.Logger;

/**
 * Created by dima on 10.09.17.
 */

public class SchoolDirectorPresenter extends BasePresenter<SchoolDirectorView> {
    private static final String LOG_TAG = Logger.getClassTag(SchoolDirectorPresenter.class);

    private DirectorDao directorDao = new DirectorDao();

    public void getDirectorBySchoolId(int schoolId){
        directorDao.getDbDirectorBySchoolIdAsync(schoolId)
                .subscribeOn(Injector.getIoScheduler())
                .observeOn(Injector.getMainScheduler())
                .subscribe(this::onSuccessGetDirectorBySchoolId, this::onErrorGetDirectorBySchoolId);
    }

    private void onSuccessGetDirectorBySchoolId(DbDirector dbDirector) {
        performOnView(view -> view.onDirectorDataLoad(dbDirector));
    }

    private void onErrorGetDirectorBySchoolId(Throwable throwable) {
        Logger.t(LOG_TAG, throwable);
    }
}
