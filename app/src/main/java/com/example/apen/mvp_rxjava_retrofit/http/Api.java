package com.example.apen.mvp_rxjava_retrofit.http;

import com.example.apen.mvp_rxjava_retrofit.model.BaseBean;
import com.example.apen.mvp_rxjava_retrofit.model.ClientStarBean;
import com.example.apen.mvp_rxjava_retrofit.model.MainModel;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
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

    String BASE_URL = "http://api.vpaidian.com/";

    /**
     * http://api.vpaidian.com/?_v=1.0&_r=weixin&_n=unit.star&_otype=list&_username=188&_password=000000&pageid=1&pagesiz=20
     * ?_v=1.0&_r=weixin&_username=188&_password=000000&
     */
    @FormUrlEncoded
    @POST("?_n=unit.star&_otype=list&_v=1.0")
    Observable<BaseBean<ClientStarBean>> getClientStarLists(
            @Field("pageid") String id,
            @Field("pagesiz") String siz);

//    Call<BaseBean<ClientStarBean>> getClientStarLists(@Query("pageid") String pageid, @Query("pagesiz") String pagesiz);

}
