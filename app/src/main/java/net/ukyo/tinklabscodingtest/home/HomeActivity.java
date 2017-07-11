package net.ukyo.tinklabscodingtest.home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import net.ukyo.tinklabscodingtest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ukyo on 2017/7/11.
 * <p>
 * Home Activity. this activity as a home page in this app.
 */

public class HomeActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private String[] categoryTitles; //TabLayout titles
    private List<String> mCategoryId; //different category id for API parameters

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViews();
        dataInit();
        setToolbar();
        setTabLayout();
        setViewPager();
    }

    /**
     * get layout UI component resource
     */
    private void findViews() {
        mTabLayout = (TabLayout) findViewById(R.id.tab);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
    }

    /**
     * data initialize
     */
    private void dataInit() {
        categoryTitles = getResources().getStringArray(R.array.tab_category);

        // Category Id initialize
        mCategoryId = new ArrayList<>();
        mCategoryId.add("city_guide");
        mCategoryId.add("shop");
        mCategoryId.add("eat");
    }

    /**
     * set Toolbar UI component
     */
    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /**
     * set TabLayout UI component
     */
    private void setTabLayout() {
        for (int i = 0; i < categoryTitles.length; i++) {
            mTabLayout.addTab(mTabLayout.newTab()
                    .setText(categoryTitles[i]));
        }

        mTabLayout.addOnTabSelectedListener(tabSelectedListener);
    }

    /**
     * set ViewPager UI component
     */
    private void setViewPager() {
        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(getFragmentManager(), mCategoryId);
        mViewPager.setAdapter(homePagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    }

    /**
     * TabLayout Listener
     */
    private TabLayout.OnTabSelectedListener tabSelectedListener =
            new TabLayout.OnTabSelectedListener() {

                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    mViewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                }
            };
}
