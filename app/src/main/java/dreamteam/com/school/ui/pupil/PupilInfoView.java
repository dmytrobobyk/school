package dreamteam.com.school.ui.pupil;

import dreamteam.com.school.common.mvp.MvpView;
import dreamteam.com.school.entity.DbPupil;

/**
 * Created by dima on 20.09.17.
 */

public interface PupilInfoView extends MvpView<PupilInfoPresenter> {

    void onPupilLoaded(DbPupil dbPupil);
}
