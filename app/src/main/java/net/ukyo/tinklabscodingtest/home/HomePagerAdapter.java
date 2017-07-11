package net.ukyo.tinklabscodingtest.home;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by ukyo on 2017/7/11.
 * <p>
 * PagerAdapter for HomeActivity
 */

public class HomePagerAdapter extends FragmentPagerAdapter {

    private List<String> mCategoryList;

    public HomePagerAdapter(FragmentManager fragmentManager, List<String> categoryList) {
        super(fragmentManager);

        this.mCategoryList = categoryList;
    }

    @Override
    public Fragment getItem(int position) {
        return HomePagerFragment.newInstance(mCategoryList.get(position));
    }

    @Override
    public int getCount() {
        return mCategoryList.size() > 0 ? mCategoryList.size() : 0;
    }
}
