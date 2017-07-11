package net.ukyo.tinklabscodingtest.home;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.ukyo.tinklabscodingtest.R;

/**
 * Created by ukyo on 2017/7/11.
 * <p>
 * PagerFragment displayed with ViewPager in HomeActivity
 */

public class HomePagerFragment extends Fragment {

    private String mCategoryId; //the category id of this fragment
    private TextView textFragmentId;

    public static HomePagerFragment newInstance(String categoryId) {
        HomePagerFragment homeFragment = new HomePagerFragment();
        Bundle bundle = new Bundle();
        bundle.putString("category_id", categoryId);
        homeFragment.setArguments(bundle);

        return homeFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCategoryId = getArguments().getString("category_id");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, null);
        textFragmentId = (TextView) view.findViewById(R.id.text_fragment_id);
        textFragmentId.setText(mCategoryId);

        return view;
    }
}
