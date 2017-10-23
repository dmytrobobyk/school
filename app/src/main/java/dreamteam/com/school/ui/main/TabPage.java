package dreamteam.com.school.ui.main;

import android.support.v4.app.Fragment;

/**
 * Created by dima on 15.08.17.
 */

public class TabPage {
    private final String LOG_TAG = this.getClass().getName();

    private String title;
    private Fragment fragment;

    public TabPage(String title, Fragment fragment) {
        this.title = title;
        this.fragment = fragment;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public String getTitle() {
        return title;
    }
}
