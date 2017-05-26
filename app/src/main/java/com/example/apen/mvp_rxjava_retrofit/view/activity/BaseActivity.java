package com.example.apen.mvp_rxjava_retrofit.view.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.apen.mvp_rxjava_retrofit.presenter.BasePresenter;

/**
 * 作者 Y_MS
 * Created by ${APEN} on 2017/5/26.
 * GitHub：https://github.com/cxydxpx
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    public P mPresenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = createPresenter();
        super.onCreate(savedInstanceState);
    }

    protected abstract P createPresenter();


    public void showLoading() {
        showProgressDialog();
    }

    public void hideLoading() {
        dismissProgressDialog();
    }

    private void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            // progressDialog.hide();会导致android.view.WindowLeaked
            progressDialog.dismiss();
        }
    }


    public ProgressDialog showProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("加载中");
        progressDialog.show();
        return progressDialog;
    }

}
