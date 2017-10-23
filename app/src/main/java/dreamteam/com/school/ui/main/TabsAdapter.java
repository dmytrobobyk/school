package dreamteam.com.school.ui.main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dima on 15.08.17.
 */

public class TabsAdapter extends FragmentPagerAdapter {
    private final String LOG_TAG = this.getClass().getName();

    private List<TabPage> tabs;
    private Context context;

    public TabsAdapter(FragmentManager fm, Context context, TabPage... tabs) {
        super(fm);
        this.context = context;
        this.tabs = Arrays.asList(tabs);
    }

    @Override
    public Fragment getItem(int position) {
        try {
            return tabs.get(position).getFragment();
        } catch (Exception e) {
            Log.e(LOG_TAG, e.toString());
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabs.size();
    }
}
