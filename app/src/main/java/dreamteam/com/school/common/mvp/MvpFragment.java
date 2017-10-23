package dreamteam.com.school.common.mvp;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by dima on 07.09.17.
 */

public abstract class MvpFragment<P extends Presenter> extends BaseSupportFragment implements MvpView<P> {

    private P presenter;

    @CallSuper
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = createPresenter();
        presenter.attachView(this);
    }

    public P getPresenter() {
        return presenter;
    }

    @CallSuper
    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (presenter != null) {
            presenter.detachView();
            presenter = null;
        }
    }
}
