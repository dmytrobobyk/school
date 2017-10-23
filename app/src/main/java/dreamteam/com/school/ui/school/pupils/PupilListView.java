package dreamteam.com.school.ui.school.pupils;

import java.util.List;

import dreamteam.com.school.common.mvp.MvpView;
import dreamteam.com.school.entity.DbPupil;

/**
 * Created by dima on 15.09.17.
 */

public interface PupilListView extends MvpView<PupilListPresenter> {

    void onPupilsLoaded(List<DbPupil> dbPupils);
}
