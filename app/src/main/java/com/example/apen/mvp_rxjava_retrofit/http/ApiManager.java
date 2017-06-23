package com.example.apen.mvp_rxjava_retrofit.http;

import cn.f_ms.network.okhttp.intercepter.globalrequestparams.GlobalHttpParamsIntercepter;
import cn.f_ms.network.okhttp.intercepter.globalrequestparams.HttpParams;
import cn.f_ms.network.okhttp.intercepter.globalrequestparams.UrlQuerys;
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

public class ApiManager {

    public static Retrofit mRetrofit;

    public static Retrofit retrofit() {
        if (mRetrofit == null) {

//            OkHttpClient.Builder builder = new OkHttpClient.Builder();
//
//            OkHttpClient okHttpClient = builder.build();
//            mRetrofit = new Retrofit.Builder()
//                    .baseUrl(Api.API_SERVER_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                    .client(okHttpClient)
//                    .build();
        }
        return mRetrofit;
    }

    public static Retrofit retrofit2() {
        if (mRetrofit == null) {
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
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Api.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return mRetrofit;
    }


}
