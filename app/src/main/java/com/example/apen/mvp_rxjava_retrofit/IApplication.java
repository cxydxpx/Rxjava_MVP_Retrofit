package com.example.apen.mvp_rxjava_retrofit;

import android.app.Application;
import com.orhanobut.logger.Logger;

/**
 * 作者 Y_MS
 * Created by ${APEN} on 2017-09-21.
 * GitHub：https://github.com/cxydxpx
 */

public class IApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Logger
                .init("apen");
    }
}
