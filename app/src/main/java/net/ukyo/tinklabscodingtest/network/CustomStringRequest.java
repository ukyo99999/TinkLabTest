package net.ukyo.tinklabscodingtest.network;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

/**
 * Created by ukyo on 2017/7/12.
 * <p>
 * Custom StringRequest for volley library
 */

public class CustomStringRequest extends StringRequest {
    private Map<String, String> mParams;

    public CustomStringRequest(int method, String url, Map<String, String> params, final ResponseListener res) {
        super(method, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        res.onResponse(response);
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        res.onError(error);
                    }
                });

        this.mParams = params;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return mParams;
    }
}
