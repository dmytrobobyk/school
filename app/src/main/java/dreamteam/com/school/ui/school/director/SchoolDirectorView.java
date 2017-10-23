package dreamteam.com.school.ui.school.director;

import dreamteam.com.school.common.mvp.MvpView;
import dreamteam.com.school.entity.DbDirector;

/**
 * Created by dima on 10.09.17.
 */

public interface SchoolDirectorView extends MvpView<SchoolDirectorPresenter> {

    void onDirectorDataLoad(DbDirector dbDirector);
}
