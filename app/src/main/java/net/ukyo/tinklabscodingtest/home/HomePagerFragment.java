package net.ukyo.tinklabscodingtest.home;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.ukyo.tinklabscodingtest.R;

/**
 * Created by ukyo on 2017/7/11.
 * <p>
 * PagerFragment displayed with ViewPager in HomeActivity
 */

public class HomePagerFragment extends Fragment {

    private String mCategoryId; //the category id of this fragment

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

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        setRecyclerView(view);

        return view;
    }

    /**
     * Set RecyclerView
     */
    private void setRecyclerView(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }
}
