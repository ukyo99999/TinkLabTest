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
import net.ukyo.tinklabscodingtest.datamodel.CategoryBean;
import net.ukyo.tinklabscodingtest.datamodel.CategoryGson;
import net.ukyo.tinklabscodingtest.utils.EndlessRecyclerOnScrollListener;
import net.ukyo.tinklabscodingtest.utils.ViewUtility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ukyo on 2017/7/11.
 * <p>
 * PagerFragment displayed with ViewPager in HomeActivity
 */

public class HomePagerFragment extends Fragment implements ApiCallback {

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private CategoryApi categoryApi;
    private List<CategoryBean> mDataList; //for RecyclerView data set use
    private int currentPage = 1; //current page of api retrieve
    private int totalPages; //total pages for api retrieve constraint

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
        mDataList = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(layoutManager) {
            @Override
            public void onLoadMore() {

                if (currentPage < totalPages) {
                    currentPage++;
                    loadApi(currentPage);
                }
            }
        });

        loadApi(currentPage);

        return view;
    }

    private void loadApi(int page) {
        categoryApi = new CategoryApi(getActivity(), this);
        categoryApi.load(page);
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

        totalPages = categoryApi.getCategoryGson().total_pages;

        if (currentPage == 1) {
            mAdapter = new RecyclerViewAdapter(mDataList);
            mRecyclerView.setAdapter(mAdapter);
        }

        int itemCount = mAdapter.getItemCount();
        mDataList.addAll(getListData(categoryApi.getCategoryGson()));
        mAdapter.notifyItemRangeInserted(itemCount, mDataList.size() - 1);
    }

    /**
     * get retrieve data from api, then set gson format data into List<JavaBean>
     *
     * @return
     */
    private List<CategoryBean> getListData(CategoryGson data) {

        List<CategoryBean> dataList = new ArrayList<>();

        for (int i = 0; i < data.results.size(); i++) {
            CategoryBean bean = new CategoryBean();
            bean.setImagePath(data.results.get(i).backdrop_path);
            bean.setTitle(data.results.get(i).title);
            bean.setDescription(data.results.get(i).overview);
            dataList.add(bean);
        }

        return dataList;
    }
}
