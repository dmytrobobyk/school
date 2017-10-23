package dreamteam.com.school.view;

import android.support.v4.app.Fragment;

import dreamteam.com.school.util.Logger;

/**
 * Created by dima on 01.09.17.
 */

public class TabInfo {
    private static final String LOG_TAG = Logger.getClassTag(TabInfo.class);

    private String title;
    private Fragment fragment;

    public TabInfo(String title, Fragment fragment) {
        this.title = title;
        this.fragment = fragment;
    }


    public String getTitle() {
        return title;
    }

    public Fragment getFragment() {
        return fragment;
    }
}
