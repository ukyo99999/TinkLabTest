package net.ukyo.tinklabscodingtest.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by ukyo on 2017/7/12.
 * <p>
 * Utility of View
 */

public class ViewUtility {

    /**
     * Show Toast message
     *
     * @param context
     * @param showText
     */
    public static void showToast(Context context, String showText) {
        Toast.makeText(context, showText, Toast.LENGTH_SHORT).show();
    }

    /**
     * Show Dialog
     *
     * @param title   title for this dialog
     * @param message message for this dialog
     * @param confirm text for this positive button
     */
    public static void showDialog(Context context, String title, String message, String confirm,
                                  DialogInterface.OnClickListener positiveListener) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle(title).setMessage(message).setPositiveButton(confirm, positiveListener)
                .show();
    }
}
