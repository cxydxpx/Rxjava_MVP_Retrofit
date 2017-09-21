package com.example.apen.mvp_rxjava_retrofit.rxjava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.apen.mvp_rxjava_retrofit.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者 Y_MS
 * Created by ${APEN} on 2017/5/25.
 * GitHub：https://github.com/cxydxpx
 */

public class RxJavaDemo1 extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_demo1);

        text = (TextView) findViewById(R.id.text);

        initRxJava();

    }

    public final static String TAG = "rxjava";

    private void initRxJava() {

        Observable.create(new ObservableOnSubscribe() {
                              @Override
                              public void subscribe(@NonNull ObservableEmitter e) throws Exception {
                                  e.onNext("before Rxjava1");
                                  Log.i(TAG, "before Rxjava1: ");
                                  e.onNext("before Rxjava2");
                                  Log.i(TAG, "before Rxjava2");
                                  e.onNext("before Rxjava3");
                                  Log.i(TAG, "before Rxjava3");
                                  e.onNext("before Rxjava4");
                                  Log.i(TAG, "before Rxjava4");
                                  Log.i(TAG, "subscribe: " + Thread.currentThread().getName());
                                  e.onComplete();
                              }
                          }
        )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {

                               @Override
                               public void onSubscribe(@NonNull Disposable d) {
                                   Log.i(TAG, "onSubscribe");
                                   Log.i(TAG, "subscribe: " + Thread.currentThread().getName());
                               }

                               @Override
                               public void onNext(@NonNull String s) {
                                   Log.i(TAG, "onNext : " + s);
                                   Log.i(TAG, "subscribe: " + Thread.currentThread().getName());
                               }


                               @Override
                               public void onError(@NonNull Throwable e) {
                                   Log.i(TAG, "onError");
                                   Log.i(TAG, "subscribe: " + Thread.currentThread().getName());
                               }

                               @Override
                               public void onComplete() {
                                   Log.i(TAG, "onComplete");
                                   Log.i(TAG, "subscribe: " + Thread.currentThread().getName());
                               }
                           }
                );
    }
}
