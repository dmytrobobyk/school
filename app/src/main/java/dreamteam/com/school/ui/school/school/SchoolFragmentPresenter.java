package dreamteam.com.school.ui.school.school;

import dreamteam.com.school.Injector;
import dreamteam.com.school.common.mvp.BasePresenter;
import dreamteam.com.school.dao.SchoolDao;
import dreamteam.com.school.entity.DbSchool;
import dreamteam.com.school.util.Logger;

/**
 * Created by dima on 07.09.17.
 */

public class SchoolFragmentPresenter extends BasePresenter<SchoolView> {
    private static final String LOG_TAG = Logger.getClassTag(SchoolFragmentPresenter.class);

    private SchoolDao schoolDao = new SchoolDao();

    public void getSchoolById(int schoolId){
        schoolDao.getSchoolByIdAsync(schoolId)
                .subscribeOn(Injector.getIoScheduler())
                .observeOn(Injector.getMainScheduler())
                .subscribe(this::onSuccessGetSchoolById, this::onErrorGetSchoolById);
    }

    private void onSuccessGetSchoolById(DbSchool dbSchool) {
        performOnView(view -> view.onSchoolLoaded(dbSchool));
    }

    private void onErrorGetSchoolById(Throwable throwable) {
        performOnView(view -> view.showError(throwable));
    }

}
