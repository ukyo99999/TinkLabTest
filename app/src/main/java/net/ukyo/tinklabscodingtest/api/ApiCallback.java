package net.ukyo.tinklabscodingtest.api;

/**
 * Created by ukyo on 2017/7/12.
 * <p>
 * This interface for the next process after API load completed
 */

public interface ApiCallback {

    /**
     * show Toast message
     *
     * @param msg message
     */
    void showMsg(String msg);

    /**
     * show Dialog
     *
     * @param title title of this dialog
     * @param msg   message of this dialog
     */
    void showDialog(String title, String msg);

    /**
     * api load completed
     */
    void loadComplete();
}
