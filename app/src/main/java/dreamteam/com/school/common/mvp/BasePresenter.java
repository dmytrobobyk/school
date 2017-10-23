package dreamteam.com.school.common.mvp;

import android.support.annotation.Nullable;

import dreamteam.com.school.util.Logger;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by dima on 05.09.17.
 */

public abstract class BasePresenter<V extends MvpView> implements Presenter<V> {
    private static final String LOG_TAG = Logger.getClassTag(BasePresenter.class);

    @Nullable
    private V view;
    private CompositeSubscription subscriptions;

    public BasePresenter() {
        subscriptions = new CompositeSubscription();
    }

    public void addSubscription(Subscription s) {
        if (subscriptions != null && subscriptions.isUnsubscribed()) {
            Logger.d(LOG_TAG, "Composite subscription is null");
        }
        subscriptions.add(s);
    }

    protected interface ViewAction<V extends MvpView> {
        void run(V view);
    }

    protected void performOnView(ViewAction<V> viewAction) {
        V view = getView();
        if(view == null) {
            Logger.d(LOG_TAG, "performOnView: View is null");
            return;
        }
        viewAction.run(view);
    }

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
        onDestroy();
    }

    @Override
    public void onDestroy() {
        if (subscriptions != null) {
            subscriptions.unsubscribe();
        }
    }

    @Nullable
    public V getView() {
        return view;
    }
}
