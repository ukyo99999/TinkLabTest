package net.ukyo.tinklabscodingtest.network;

import com.android.volley.VolleyError;

/**
 * Created by ukyo on 2017/7/12.
 * <p>
 * ResponseListener for volley library
 */

public abstract class ResponseListener {
    public void onResponse(String str) {
    }

    public void onError(VolleyError error) {
    }
}
