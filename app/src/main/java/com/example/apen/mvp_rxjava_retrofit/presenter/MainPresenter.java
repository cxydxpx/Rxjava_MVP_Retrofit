package com.example.apen.mvp_rxjava_retrofit.presenter;

import com.example.apen.mvp_rxjava_retrofit.model.MainModel;
import com.example.apen.mvp_rxjava_retrofit.retrofit.ApiCallBack;
import com.example.apen.mvp_rxjava_retrofit.view.imle.RxJavaDemoView;

/**
 * 作者 Y_MS
 * Created by ${APEN} on 2017/5/26.
 * GitHub：https://github.com/cxydxpx
 */

public class MainPresenter extends BasePresenter<RxJavaDemoView>{

    public MainPresenter(RxJavaDemoView mViews) {
        attachView(mViews);
    }

    public void loadDataByRetrofitRxjava(String s) {
        mViews.showLoading();
        subscribe(api.loadDataByRetrofitRxjava(s),new ApiCallBack<MainModel>(){
            @Override
            public void onSuccess(MainModel model) {
                mViews.getDataSuccess(model);
            }

            @Override
            public void onFailure(String msg) {
                mViews.getDataFaild(msg);
            }

            @Override
            public void onFinish() {
                mViews.hideLoading();
            }
        });
// bieluandong
    }

}
