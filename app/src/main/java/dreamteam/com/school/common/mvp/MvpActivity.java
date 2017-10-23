package dreamteam.com.school.common.mvp;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;

/**
 * Created by dima on 06.09.17.
 */

public abstract class MvpActivity<P extends Presenter> extends BaseActivity implements MvpView<P> {

    P presenter;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        presenter = createPresenter();
        presenter.attachView(this);
    }

    public P getPresenter() {
        return presenter;
    }

    @CallSuper
    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (presenter != null) {
            presenter.detachView();
        }
    }
}
