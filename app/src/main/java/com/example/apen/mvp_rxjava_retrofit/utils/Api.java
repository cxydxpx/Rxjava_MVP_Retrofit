package com.example.apen.mvp_rxjava_retrofit.utils;
import com.example.apen.mvp_rxjava_retrofit.model.MainModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 作者 Y_MS
 * Created by ${APEN} on 2017/5/26.
 * GitHub：https://github.com/cxydxpx
 */

public interface Api {
    //baseUrl
    String API_SERVER_URL = "http://www.weather.com.cn/";
    //加载天气
    @GET("adat/sk/{cityId}.html")
    Observable<MainModel> loadDataByRetrofitRxjava(@Path("cityId") String cityId);

}
