package dreamteam.com.school.ui.about;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dreamteam.com.school.BuildConfig;
import dreamteam.com.school.R;
import dreamteam.com.school.common.mvp.BaseActivity;

/**
 * Created by dima on 28.09.17.
 */

public class AboutActivity extends BaseActivity {

    @BindView(R.id.appVersionTextView)
    TextView appVersionTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        setUnBinder(ButterKnife.bind(this));
        initToolbar();
        setToolbarTitle(R.string.about_app);
        setVersionOnView();
    }

    public String getAppVersionName() {
        return BuildConfig.VERSION_NAME;
    }

    private void setVersionOnView() {
        appVersionTextView.setText(getAppVersionName());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
