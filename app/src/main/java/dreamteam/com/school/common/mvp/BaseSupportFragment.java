package dreamteam.com.school.common.mvp;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import butterknife.Unbinder;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by dima on 01.09.17.
 */

public class BaseSupportFragment extends Fragment {

    @Nullable
    Unbinder unbinder;

    @Nullable
    CompositeSubscription subscriptions;

    protected final void setUnbinder(Unbinder unbinder) {
        this.unbinder = unbinder;
    }

    protected final void addSubscription(@NonNull Subscription subscription) {
        if (subscriptions != null) {
            subscriptions.add(subscription);
        }
    }

    protected final void addSubscriptions(@NonNull Subscription... subscription) {
        if (subscriptions != null) {
            subscriptions.addAll(subscription);
        }
    }

    @CallSuper
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        subscriptions = new CompositeSubscription();
    }

    @CallSuper
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (subscriptions != null) {
            subscriptions.unsubscribe();
            subscriptions = null;
        }
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
    }
}
