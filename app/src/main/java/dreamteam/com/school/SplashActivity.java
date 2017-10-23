package dreamteam.com.school;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import dreamteam.com.school.ui.schools.SchoolListActivity;

/**
 * Created by dima on 11.07.17.
 */

public class SplashActivity extends AppCompatActivity {
    private static final String LOG_TAG = SplashActivity.class.getName();

    private static final int SPLASH_TIMEOUT = 2000;
    private final Handler handler = new Handler();
    private final Runnable closeSplashRunnable = this::startSchoolListActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        performDelayedStartSchoolListActivity();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(closeSplashRunnable);
    }

    private void startSchoolListActivity() {
        Intent intent = new Intent(this, SchoolListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

    private void performDelayedStartSchoolListActivity() {
        long threadTime = SystemClock.currentThreadTimeMillis();

        if (threadTime >= SPLASH_TIMEOUT) {
            startSchoolListActivity();
        } else {
            handler.postDelayed(closeSplashRunnable, SPLASH_TIMEOUT - threadTime);
        }
    }
}
