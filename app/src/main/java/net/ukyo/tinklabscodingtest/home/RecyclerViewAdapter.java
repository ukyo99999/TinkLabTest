package net.ukyo.tinklabscodingtest.home;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import net.ukyo.tinklabscodingtest.R;
import net.ukyo.tinklabscodingtest.datamodel.CategoryBean;

import java.util.List;

/**
 * Created by ukyo on 2017/7/11.
 * <p>
 * RecyclerView Adapter for HomePagerFragment
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<CategoryBean> mDataList;

    public RecyclerViewAdapter(List<CategoryBean> dataList) {
        this.mDataList = dataList;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class InfoHolder extends ViewHolder {

        public SimpleDraweeView imageInfo;
        public TextView textTitle;
        public TextView textDescription;

        public InfoHolder(View view) {
            super(view);
            imageInfo = (SimpleDraweeView) view.findViewById(R.id.image_info);
            textTitle = (TextView) view.findViewById(R.id.text_title);
            textDescription = (TextView) view.findViewById(R.id.text_description);
        }
    }

    public class AdHolder extends ViewHolder {

        public SimpleDraweeView imageAd;

        public AdHolder(View view) {
            super(view);
            imageAd = (SimpleDraweeView) view.findViewById(R.id.image_ad);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case 0:
                ViewGroup vgInfo = (ViewGroup) mInflater.inflate(R.layout.item_info,
                        parent, false);
                return new InfoHolder(vgInfo);

            case 1:
                ViewGroup vgAd = (ViewGroup) mInflater.inflate(R.layout.item_ad,
                        parent, false);
                return new AdHolder(vgAd);

            default:
                return new ViewHolder(parent);
        }
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        int listType = getItemViewType(position);

        switch (listType) {
            case 0:
                InfoHolder infoHolder = (InfoHolder) holder;
                infoHolder.imageInfo.setImageURI(getImageUrl(mDataList.get(position).getImagePath()));
                infoHolder.textTitle.setText(mDataList.get(position).getTitle());
                infoHolder.textDescription.setText(mDataList.get(position).getDescription());
                break;

            case 1:
                AdHolder adHolder = (AdHolder) holder;
                adHolder.imageAd.setImageURI(getImageUrl(mDataList.get(position).getImagePath()));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mDataList == null || mDataList.size() == 0 ? 0 : mDataList.size();
    }

    @Override
    public int getItemViewType(int position) {

        int viewType = 0;

        if (position != 1) { //Type 1:Item with image, title, and description
            viewType = 0;
        } else {
            viewType = 1; //Type 2: Item with just an image
        }

        return viewType;
    }

    /**
     * get complete image path
     *
     * @param urlFromApi
     * @return
     */
    private String getImageUrl(String urlFromApi) {
        String prefix = "https://image.tmdb.org/t/p/w780";
        String urlArray = "";

        if (!TextUtils.isEmpty(urlFromApi)) {
            urlArray = urlFromApi.substring(0, urlFromApi.length());
        }

        return prefix + urlArray;
    }
}
