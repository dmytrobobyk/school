package dreamteam.com.school.common.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.Unbinder;
import dreamteam.com.school.R;
import dreamteam.com.school.util.Logger;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by dima on 24.07.17.
 */

public abstract class BaseActivity extends AppCompatActivity {
    public final String LOG_TAG = Logger.getClassTag(BaseActivity.class);

    private Toolbar toolbar;
    private TextView titleTextView;

    @Nullable
    private Unbinder unbinder;

    @Nullable
    private CompositeSubscription subscriptions;

    protected final void setUnBinder(Unbinder unBinder) {
        this.unbinder = unBinder;
    }

    protected final void addSubscription(@NonNull Subscription s) {
        if (subscriptions != null) {
            subscriptions.add(s);
        }
    }

    protected final void addSubscriptions(@NonNull Subscription... s) {
        if (subscriptions != null) {
            subscriptions.addAll(s);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subscriptions = new CompositeSubscription();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (subscriptions != null) {
            subscriptions.unsubscribe();
            subscriptions = null;
        }
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
    }

    protected final void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        titleTextView = (TextView) findViewById(R.id.toolbarTitle);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    protected void setToolbarTitle(String title) {
        if (toolbar != null && titleTextView != null) {
            titleTextView.setText(title);
        }
    }

    protected void setToolbarTitle(@StringRes int titleRes) {
        if (toolbar != null && titleTextView != null) {
            titleTextView.setText(getString(titleRes));
        }
    }
}
