package dreamteam.com.school.ui.school.pupils;

import java.util.List;

import dreamteam.com.school.Injector;
import dreamteam.com.school.common.mvp.BasePresenter;
import dreamteam.com.school.dao.PupilDao;
import dreamteam.com.school.entity.DbPupil;
import dreamteam.com.school.util.Logger;

/**
 * Created by dima on 15.09.17.
 */

public class PupilListPresenter extends BasePresenter<PupilListView> {
    private static final String LOG_TAG = Logger.getClassTag(PupilListPresenter.class);

    private PupilDao pupilDao = new PupilDao();

    public void getAllSchoolPupils(int schoolId) {
        pupilDao.getPupilsBySchoolIdAsync(schoolId)
                .subscribeOn(Injector.getIoScheduler())
                .observeOn(Injector.getMainScheduler())
                .subscribe(this::onSuccessGetAllSchoolPupils, this::onErrorGetAllSchoolPupils);
    }

    private void onSuccessGetAllSchoolPupils(List<DbPupil> dbPupils) {
        performOnView(view -> view.onPupilsLoaded(dbPupils));
    }

    private void onErrorGetAllSchoolPupils(Throwable throwable) {
        Logger.t(LOG_TAG, throwable);
    }
}
