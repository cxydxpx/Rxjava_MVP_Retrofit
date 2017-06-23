package com.example.apen.mvp_rxjava_retrofit.presenter;

import com.example.apen.mvp_rxjava_retrofit.http.Api;
import com.example.apen.mvp_rxjava_retrofit.http.ApiManager;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者 Y_MS
 * Created by ${APEN} on 2017/5/26.
 * GitHub：https://github.com/cxydxpx
 */

public class BasePresenter<V> {

    public V mViews;
    public Api api;
    public void attachView(V view){
        this.mViews = view;
        api = ApiManager.retrofit().create(Api.class);
    }

    public void detachView(){
        this.mViews = null;
    }

    public void subscribe(Observable observable, Observer observer){
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


}
