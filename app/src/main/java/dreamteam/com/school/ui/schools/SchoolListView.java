package dreamteam.com.school.ui.schools;

import java.util.List;

import dreamteam.com.school.common.mvp.MvpView;
import dreamteam.com.school.entity.DbSchool;

/**
 * Created by dima on 24.04.17.
 */

public interface SchoolListView extends MvpView<SchoolListPresenter> {

    void onSchoolLoaded(List<DbSchool> schools);

}
