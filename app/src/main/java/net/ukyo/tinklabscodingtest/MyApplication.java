package net.ukyo.tinklabscodingtest;

import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by ukyo on 2017/7/12.
 */

public class MyApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(getApplicationContext());

        /* Fresco initialize */
        Fresco.initialize(this);
    }
}
