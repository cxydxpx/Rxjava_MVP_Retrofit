package com.example.apen.mvp_rxjava_retrofit.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.apen.mvp_rxjava_retrofit.R;
import com.example.apen.mvp_rxjava_retrofit.http.Api;
import com.example.apen.mvp_rxjava_retrofit.http.ApiManager;
import com.example.apen.mvp_rxjava_retrofit.model.BaseBean;
import com.example.apen.mvp_rxjava_retrofit.model.ClientStarBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 作者 Y_MS
 * Created by ${APEN} on 2017/6/22.
 * GitHub：https://github.com/cxydxpx
 */

public class RxJavaDemo2 extends AppCompatActivity {

    private static final String TAG = "tag";
    private TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_demo2);
        tv = (TextView) findViewById(R.id.tv);
        initData();
    }

    private void initData() {
        Api api = ApiManager
                .retrofit2()
                .create(Api.class);

        Call<BaseBean<ClientStarBean>> clientStarLists = api.getClientStarLists("1", "20");
        clientStarLists.enqueue(new Callback<BaseBean<ClientStarBean>>() {
            @Override
            public void onResponse(Call<BaseBean<ClientStarBean>> call, Response<BaseBean<ClientStarBean>> response) {
                BaseBean<ClientStarBean> body = response.body();
                if (body.isRs()) {
                    for (int i = 0; i < body.getMess().getData().size(); i++) {
                        Log.i(TAG, "onResponse: " + body.getMess().getData().get(i).getName());
                    }
                } else {

                }
            }
            @Override
            public void onFailure(Call<BaseBean<ClientStarBean>> call, Throwable t) {
                Log.i(TAG, "onFailure: 失败" + t.getMessage().toString());
            }
        });
    }
}
