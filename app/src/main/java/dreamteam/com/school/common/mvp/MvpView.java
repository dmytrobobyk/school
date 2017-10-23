package dreamteam.com.school.common.mvp;

/**
 * Created by dima on 05.09.17.
 */

public interface MvpView<P> {

    P createPresenter();

    void showError(Throwable throwable);
}
