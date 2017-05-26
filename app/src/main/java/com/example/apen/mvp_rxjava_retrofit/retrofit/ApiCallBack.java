package com.example.apen.mvp_rxjava_retrofit.retrofit;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * 作者 Y_MS
 * Created by ${APEN} on 2017/5/26.
 * GitHub：https://github.com/cxydxpx
 */

public abstract class ApiCallBack<M> implements Observer<M> {


    public abstract void onSuccess(M model);

    public abstract void onFailure(String msg);

    public abstract void onFinish();

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull M m) {
        onSuccess(m);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        onFailure(e.getMessage());
    }

    @Override
    public void onComplete() {
        onFinish();
    }
}
