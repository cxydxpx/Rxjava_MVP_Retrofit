package com.example.apen.mvp_rxjava_retrofit.rxjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.apen.mvp_rxjava_retrofit.R;

/**
 * 作者 Y_MS
 * Created by ${APEN} on 2017-09-21.
 * GitHub：https://github.com/cxydxpx
 */

public class RxjavaAll extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_all);
    }

    public void btn(View v) {
        startActivity(new Intent(this, RxJavaDemo1.class));
    }

}
