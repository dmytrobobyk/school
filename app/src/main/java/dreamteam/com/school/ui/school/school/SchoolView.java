package dreamteam.com.school.ui.school.school;

import dreamteam.com.school.common.mvp.MvpView;
import dreamteam.com.school.entity.DbSchool;

/**
 * Created by dima on 07.09.17.
 */

public interface SchoolView extends MvpView<SchoolFragmentPresenter> {

    void onSchoolLoaded(DbSchool dbSchool);
}
