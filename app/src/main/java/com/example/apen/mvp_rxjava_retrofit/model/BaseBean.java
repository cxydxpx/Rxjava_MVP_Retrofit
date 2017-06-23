package com.example.apen.mvp_rxjava_retrofit.model;

/**
 * 作者 Y_MS
 * Created by ${APEN} on 2017/6/8.
 * GitHub：https://github.com/cxydxpx
 */

public class BaseBean<T> {
    /**
     * rs : true
     * Bean : 1
     */

    private boolean rs;
    private T mess;

    public boolean isRs() {
        return rs;
    }

    public void setRs(boolean rs) {
        this.rs = rs;
    }

    public  T getMess() {
        return mess;
    }

    public void setMess(T mess) {
        this.mess = mess;
    }

}
