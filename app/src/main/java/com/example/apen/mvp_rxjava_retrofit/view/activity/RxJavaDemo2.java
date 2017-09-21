package com.example.apen.mvp_rxjava_retrofit.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.apen.mvp_rxjava_retrofit.R;
import com.example.apen.mvp_rxjava_retrofit.http.HttpManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

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
        initRxjava();
//        initData();

        map();
//        flatMap();
//        zip();
    }

    private void zip() {

    }

    private void flatMap() {

    }

    private void map() {

    }

    private void initRxjava() {

        Observable.create(new ObservableOnSubscribe<Integer>() {
            /**
             * @param e ObservableEmitter 发射器
             * @throws Exception
             */
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {

                e.onNext(1);//上游可以发送无数个onNext 下游也可以接收无数个onNext
                e.onNext(2);//上游可以不发送onComplete onError
                e.onNext(3);//onComplete onError互斥 onComplete可以发送多次 切仅第一次起作用 onError只能发送一次
                e.onComplete();//上游发送onComplete以后，onNext可以继续发送 下游接收过onComplete以后将不再继续接收
            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(@NonNull Integer integer) throws Exception {
                return integer + " 转换为 ： " + "'" + integer + "'";
            }
        }).concatMap(new Function<String, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(@NonNull String s) throws Exception {
                List<String> list = new ArrayList<String>();

                for (int i = 0; i < 3; i++) {
                    list.add("i am " + s);
                }
                return Observable.fromIterable(list).delay(10, TimeUnit.MILLISECONDS);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                Log.i(TAG, "accept: "+s);
            }
        });
// subscribe(new Observer<String>() {
//
//            private Disposable mDisposable;
//
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//                Log.i(TAG, "onSubscribe: ");
//                mDisposable = d;
//            }
//
//            @Override
//            public void onNext(@NonNull String o) {
//                Log.i(TAG, "onNext: " + o);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                Log.i(TAG, "onError: ");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.i(TAG, "onComplete: ");
//            }
//        });

    }

    private void initData() {

        HttpManager.instance().getClientStarLists("1", "20");


    }
//                new Consumer<Integer>() {
//            @Override
//            public void accept(@NonNull Integer integer) throws Exception {
//                Log.i(TAG, "accept: -  "+integer);
//            }
//        });
}
