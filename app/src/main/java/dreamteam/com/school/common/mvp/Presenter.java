package dreamteam.com.school.common.mvp;

/**
 * Created by dima on 05.09.17.
 */

public interface Presenter<V extends MvpView> {

    void attachView(V view);

    void detachView();

    void onDestroy();
}
