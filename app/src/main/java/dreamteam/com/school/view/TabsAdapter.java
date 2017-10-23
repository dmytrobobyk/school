package dreamteam.com.school.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Arrays;
import java.util.List;

import dreamteam.com.school.util.Logger;

/**
 * Created by dima on 30.08.17.
 */

public class TabsAdapter extends FragmentPagerAdapter {
    private static final String LOG_TAG = Logger.getClassTag(TabsAdapter.class);

    List<TabInfo> tabInfoList;

    public TabsAdapter(FragmentManager fragmentManager, TabInfo... tabs) {
        super(fragmentManager);
        this.tabInfoList = Arrays.asList(tabs);
    }

    @Override
    public Fragment getItem(int position) {
        try {
            return tabInfoList.get(position).getFragment();
        } catch (Exception e) {
            Logger.e(LOG_TAG, e);
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabInfoList.get(position).getTitle();
    }

    @Override
    public int getCount() {
        return tabInfoList.size();
    }
}
