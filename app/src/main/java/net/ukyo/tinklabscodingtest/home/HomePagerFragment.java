package net.ukyo.tinklabscodingtest.home;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.ukyo.tinklabscodingtest.R;
import net.ukyo.tinklabscodingtest.api.ApiCallback;
import net.ukyo.tinklabscodingtest.api.CategoryApi;
import net.ukyo.tinklabscodingtest.utils.ViewUtility;

/**
 * Created by ukyo on 2017/7/11.
 * <p>
 * PagerFragment displayed with ViewPager in HomeActivity
 */

public class HomePagerFragment extends Fragment implements ApiCallback {

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private CategoryApi categoryApi;

    //category id of this fragment(if fragment need to load different category id in the future)
    private String mCategoryId;

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
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        loadApi();

        return view;
    }

    private void loadApi() {
        categoryApi = new CategoryApi(getActivity(), this);
        categoryApi.load();
    }

    @Override
    public void showMsg(String msg) {
        ViewUtility.showToast(getActivity(), msg);
    }

    @Override
    public void showDialog(String title, String msg) {

    }

    @Override
    public void loadComplete() {
        if (getActivity() != null) {
            mAdapter = new RecyclerViewAdapter(categoryApi.getCategoryGson());
            mRecyclerView.setAdapter(mAdapter);
        }
    }
}
