package net.ukyo.tinklabscodingtest.network;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;

import net.ukyo.tinklabscodingtest.R;

/**
 * Created by ukyo on 2017/7/12.
 * <p>
 * Network error handler for volley library
 */

public class VolleyErrorHelper {

    /**
     * Returns appropriate message which is to be displayed to the user
     * against the specified error object.
     *
     * @param error
     * @param context
     * @return
     */
    public static String getMessage(Object error, Context context) {

        if (error instanceof NoConnectionError) {

            return context.getResources().getString(R.string.volley_no_connection);

        } else if (error instanceof NetworkError) {

            return context.getResources().getString(R.string.volley_network_error);

        } else if (error instanceof AuthFailureError) {

            return context.getResources().getString(R.string.volley_auth_failure);

        } else if (error instanceof ServerError) {

            return context.getResources().getString(R.string.volley_server_error);

        } else if (error instanceof ParseError) {

            return context.getResources().getString(R.string.volley_parse_error);

        } else if (error instanceof TimeoutError) {

            return context.getResources().getString(R.string.volley_timeout);

        }

        return context.getResources().getString(R.string.volley_timeout);
    }

}
