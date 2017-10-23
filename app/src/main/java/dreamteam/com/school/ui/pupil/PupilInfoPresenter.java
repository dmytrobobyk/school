package dreamteam.com.school.ui.pupil;

import dreamteam.com.school.Injector;
import dreamteam.com.school.common.mvp.BasePresenter;
import dreamteam.com.school.dao.PupilDao;
import dreamteam.com.school.entity.DbPupil;
import dreamteam.com.school.util.Logger;

/**
 * Created by dima on 20.09.17.
 */

public class PupilInfoPresenter extends BasePresenter<PupilInfoView> {
    private static final String LOG_TAG = Logger.getClassTag(PupilInfoPresenter.class);

    private PupilDao pupilDao = new PupilDao();

    public void getPupil(long pupilId){
        pupilDao.getPupilByIdAsync(pupilId)
                .subscribeOn(Injector.getIoScheduler())
                .observeOn(Injector.getMainScheduler())
                .subscribe(this::onSuccessGetPupil, this::onErrorGetPupil);
    }

    private void onSuccessGetPupil(DbPupil dbPupil) {
        performOnView(view -> view.onPupilLoaded(dbPupil));
    }

    private void onErrorGetPupil(Throwable throwable) {

    }

}
