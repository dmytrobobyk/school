package dreamteam.com.school.view;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import rx.functions.Action1;


/**
 * Created by dima on 21.08.17.
 */

public class CustomTabLayout extends TabLayout implements TabLayout.OnTabSelectedListener {

    @Nullable
    private ViewPager viewPager;
    private int customResourceLayout;

    public CustomTabLayout(Context context) {
        super(context);
    }

    public CustomTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        super.setupWithViewPager(viewPager);
        this.viewPager = viewPager;
        addOnTabSelectedListener(this);
    }


    private void setCustomLayout() {
        if (customResourceLayout != 0) {
            for (int i = 0; i < getTabCount(); i++) {
                Tab tab = getTabAt(i);
                if (tab != null) {
                    tab.setCustomView(LayoutInflater.from(getContext()).inflate(customResourceLayout, this, false));
                    View view = tab.getCustomView();
                    if (view != null) {
                        TextView textView = view.findViewById(android.R.id.text1);
                        textView.setTextColor(getTabTextColors());
                        textView.setText(viewPager.getAdapter().getPageTitle(i));
                    }
                }
            }
        }
    }

    public void setCustomView(@LayoutRes int customResourceLayout) {
        this.customResourceLayout = customResourceLayout;
        setCustomLayout();
    }

    @Override
    public void onTabSelected(Tab tab) {
        viewPagerAction(viewPager1 -> viewPager1.setCurrentItem(tab.getPosition(), true));
    }

    @Override
    public void onTabUnselected(Tab tab) {

    }

    @Override
    public void onTabReselected(Tab tab) {

    }

    public void viewPagerAction(Action1<ViewPager> action1) {
        if (viewPager != null) {
            action1.call(viewPager);
        }
    }
}
