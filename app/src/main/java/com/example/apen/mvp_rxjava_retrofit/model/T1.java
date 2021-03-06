package com.example.apen.mvp_rxjava_retrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 作者 Y_MS
 * Created by ${APEN} on 2017/6/22.
 * GitHub：https://github.com/cxydxpx
 */

public class T1{

    /**
     * rs : true
     * mess : {"pagetotal":1,"rowtotal":"4","data":[{"name":"一个","id":"270"},{"name":"萝卜","id":"261"},{"name":"零售类","id":"206"},{"name":"萧山农都批发客户","id":"197"}]}
     */

    private boolean rs;
    private MessBean mess;

    public boolean isRs() {
        return rs;
    }

    public void setRs(boolean rs) {
        this.rs = rs;
    }

    public MessBean getMess() {
        return mess;
    }

    public void setMess(MessBean mess) {
        this.mess = mess;
    }

    public static class MessBean{

        /**
         * pagetotal : 1
         * rowtotal : 4
         * data : [{"name":"一个","id":"270"},{"name":"萝卜","id":"261"},{"name":"零售类","id":"206"},{"name":"萧山农都批发客户","id":"197"}]
         */

        private int pagetotal;
        private String rowtotal;
        private List<DataBean> data;

        public int getPagetotal() {
            return pagetotal;
        }

        public void setPagetotal(int pagetotal) {
            this.pagetotal = pagetotal;
        }

        public String getRowtotal() {
            return rowtotal;
        }

        public void setRowtotal(String rowtotal) {
            this.rowtotal = rowtotal;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * name : 一个
             * id : 270
             */

            @SerializedName("errorInfo")
            private List<String> errorInfoX;

            public List<String> getErrorInfoX() {
                return errorInfoX;
            }

            public void setErrorInfoX(List<String> errorInfoX) {
                this.errorInfoX = errorInfoX;
            }

            private String name;
            private String id;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }

}
