package com.example.apen.mvp_rxjava_retrofit.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apen.mvp_rxjava_retrofit.R;
import com.example.apen.mvp_rxjava_retrofit.model.MainModel;
import com.example.apen.mvp_rxjava_retrofit.presenter.MainPresenter;
import com.example.apen.mvp_rxjava_retrofit.view.imle.RxJavaDemoView;

/**
 * 作者 Y_MS
 * Created by ${APEN} on 2017/5/25.
 * GitHub：https://github.com/cxydxpx
 */

public class RxJavaDemo1 extends BaseActivity<MainPresenter> implements RxJavaDemoView{

    private TextView text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_demo1);

        text = (TextView) findViewById(R.id.text);

        initRxJava();

    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    private void initRxJava() {
        mPresenter.loadDataByRetrofitRxjava("101310222");
    }

    @Override
    public void getDataSuccess(MainModel model) {
        MainModel.WeatherinfoBean weatherinfo = model.getWeatherinfo();
        String showData = getResources().getString(R.string.city) + weatherinfo.getCity()
                + getResources().getString(R.string.wd) + weatherinfo.getWD()
                + getResources().getString(R.string.ws) + weatherinfo.getWS()
                + getResources().getString(R.string.time) + weatherinfo.getTime();
        text.setText(showData);
    }

    @Override
    public void getDataFaild(String str) {
        Toast.makeText(this, "网络不给力", Toast.LENGTH_SHORT).show();
    }
}
