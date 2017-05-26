package com.example.apen.mvp_rxjava_retrofit.view.imle;

import com.example.apen.mvp_rxjava_retrofit.model.MainModel;

/**
 * 作者 Y_MS
 * Created by ${APEN} on 2017/5/26.
 * GitHub：https://github.com/cxydxpx
 */

public interface RxJavaDemoView extends BaseView {

    void getDataSuccess(MainModel model);

    void getDataFaild(String str);

}
