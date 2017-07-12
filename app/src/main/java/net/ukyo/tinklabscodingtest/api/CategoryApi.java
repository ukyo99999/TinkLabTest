package net.ukyo.tinklabscodingtest.api;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import net.ukyo.tinklabscodingtest.Constant;
import net.ukyo.tinklabscodingtest.datamodel.CategoryGson;
import net.ukyo.tinklabscodingtest.network.CustomStringRequest;
import net.ukyo.tinklabscodingtest.network.ResponseListener;
import net.ukyo.tinklabscodingtest.network.VolleyErrorHelper;
import net.ukyo.tinklabscodingtest.network.VolleyUtility;

/**
 * Created by ukyo on 2017/7/12.
 * <p>
 * Category API
 */

public class CategoryApi {

    private static final String API_URL = Constant.API_CATEGORY; //define api url
    private static final int REQUEST_METHOD = Request.Method.GET; //define api request method
    private Context mContext;
    private ApiCallback mCallback;
    private CategoryGson gsonData;

    //constructor
    public CategoryApi(Context context, ApiCallback callback) {
        this.mContext = context;
        this.mCallback = callback;
    }

    //api execute
    public void load(int page) {

        StringRequest request = new CustomStringRequest(REQUEST_METHOD,
                API_URL + "&page=" + String.valueOf(page), null,
                new ResponseListener() {
                    @Override
                    public void onResponse(String str) {
                        super.onResponse(str);
                        setGsonData(str);
                        mCallback.loadComplete();
                    }

                    @Override
                    public void onError(VolleyError error) {
                        super.onError(error);
                        mCallback.showMsg(VolleyErrorHelper.getMessage(error, mContext));
                        mCallback.loadComplete();
                    }
                });

        request.setTag("category");
        request.setRetryPolicy(new DefaultRetryPolicy(5 * 1000, 2, 1.0f));
        VolleyUtility.getInstance(mContext).addToRequestQueue(request);
    }

    private void setGsonData(String response) {
        Gson gson = new Gson();
        gsonData = gson.fromJson(response, CategoryGson.class);
    }

    public CategoryGson getCategoryGson() {
        return gsonData;
    }
}
