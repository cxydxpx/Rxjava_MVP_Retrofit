package com.example.apen.mvp_rxjava_retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.apen.mvp_rxjava_retrofit.view.activity.RxJavaDemo1;
import com.example.apen.mvp_rxjava_retrofit.view.activity.RxJavaDemo2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void rxJavaDemo1(View view){
        startActivity(new Intent(this, RxJavaDemo1.class));
    }

    public void rxJavaDemo2(View view){
        startActivity(new Intent(this, RxJavaDemo2.class));
    }

}
