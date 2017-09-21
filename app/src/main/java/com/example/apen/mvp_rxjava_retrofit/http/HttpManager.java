package com.example.apen.mvp_rxjava_retrofit.http;

import android.util.Log;

import com.example.apen.mvp_rxjava_retrofit.model.BaseBean;
import com.example.apen.mvp_rxjava_retrofit.model.ClientStarBean;

import cn.f_ms.network.okhttp.intercepter.globalrequestparams.GlobalHttpParamsIntercepter;
import cn.f_ms.network.okhttp.intercepter.globalrequestparams.HttpParams;
import cn.f_ms.network.okhttp.intercepter.globalrequestparams.UrlQuerys;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者 Y_MS
 * Created by ${APEN} on 2017/5/26.
 * GitHub：https://github.com/cxydxpx
 */

public class HttpManager {

    private static Api mApi;

    private static class SingleInstance {
        private final static HttpManager INSTANCE = new HttpManager();
    }

    private HttpManager() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        GlobalHttpParamsIntercepter globalHttpParamsIntercepter = new GlobalHttpParamsIntercepter(new GlobalHttpParamsIntercepter.OnNeedHttpParams() {
            @Override
            public HttpParams getParams(Request request) {
                return new HttpParams.Builder().setUrlQuerys(
                        new UrlQuerys.Builder()
                                .addQueryParameter("_v", "1.0")
                                .addQueryParameter("_r", "android")
                                .addQueryParameter("_username", "199")//
                                .addQueryParameter("_password", "000000")
                                .build()
                ).build();
            }
        });

        httpClient.addInterceptor(globalHttpParamsIntercepter);

//            if (BuildConfig.DEBUG) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClient.addInterceptor(logging);
//            }

        OkHttpClient okHttpClient = httpClient.build();
        mApi = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
                .create(Api.class);
    }

    public static HttpManager instance() {
        return SingleInstance.INSTANCE;
    }

    public static final String TAG = "TAG";

    public void getClientStarLists(String id, String siz) {

        mApi.getClientStarLists(id, siz)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean<ClientStarBean>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.i(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(@NonNull BaseBean<ClientStarBean> clientStarBeanBaseBean) {
                Log.i(TAG, "onNext: " + clientStarBeanBaseBean.getMess().getData().get(0).getName());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i(TAG, "onError: "+e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete: ");
            }
        });

    }

}
