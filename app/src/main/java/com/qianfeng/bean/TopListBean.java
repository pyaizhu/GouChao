package com.qianfeng.bean;

import java.util.List;

/**
 * 分类模块下右侧选择栏的数据源实体类
 * Created by Administrator on 2016/8/21 0021.
 */
public class TopListBean {

    /**
     * message : 成功
     * statusCode : 0000
     * addDatas : {"resultlist":[{"id":45,"goodName":"外套","ntype":0,"picPath":"","npos":10},{"id":1,"goodName":"上装","ntype":0,"picPath":"","npos":9},{"id":2,"goodName":"裤装","ntype":0,"picPath":"","npos":8},{"id":3,"goodName":"裙装","ntype":0,"picPath":"","npos":7},{"id":6,"goodName":"鞋履","ntype":0,"picPath":"","npos":6},{"id":5,"goodName":"包","ntype":0,"picPath":"","npos":5},{"id":4,"goodName":"配件","ntype":0,"picPath":"","npos":4},{"id":7,"goodName":"女式美妆","ntype":0,"picPath":null,"npos":null}],"totalrecord":8,"count":8}
     */

    private String message;
    private String statusCode;
    /**
     * resultlist : [{"id":45,"goodName":"外套","ntype":0,"picPath":"","npos":10},{"id":1,"goodName":"上装","ntype":0,"picPath":"","npos":9},{"id":2,"goodName":"裤装","ntype":0,"picPath":"","npos":8},{"id":3,"goodName":"裙装","ntype":0,"picPath":"","npos":7},{"id":6,"goodName":"鞋履","ntype":0,"picPath":"","npos":6},{"id":5,"goodName":"包","ntype":0,"picPath":"","npos":5},{"id":4,"goodName":"配件","ntype":0,"picPath":"","npos":4},{"id":7,"goodName":"女式美妆","ntype":0,"picPath":null,"npos":null}]
     * totalrecord : 8
     * count : 8
     */

    private AddDatasBean addDatas;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public AddDatasBean getAddDatas() {
        return addDatas;
    }

    public void setAddDatas(AddDatasBean addDatas) {
        this.addDatas = addDatas;
    }

    public static class AddDatasBean {
        private int totalrecord;
        private int count;
        /**
         * id : 45
         * goodName : 外套
         * ntype : 0
         * picPath :
         * npos : 10
         */

        private List<ResultlistBean> resultlist;

        public int getTotalrecord() {
            return totalrecord;
        }

        public void setTotalrecord(int totalrecord) {
            this.totalrecord = totalrecord;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<ResultlistBean> getResultlist() {
            return resultlist;
        }

        public void setResultlist(List<ResultlistBean> resultlist) {
            this.resultlist = resultlist;
        }

        public static class ResultlistBean {
            private int id;
            private String goodName;
            private int ntype;
            private String picPath;
            private int npos;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getGoodName() {
                return goodName;
            }

            public void setGoodName(String goodName) {
                this.goodName = goodName;
            }

            public int getNtype() {
                return ntype;
            }

            public void setNtype(int ntype) {
                this.ntype = ntype;
            }

            public String getPicPath() {
                return picPath;
            }

            public void setPicPath(String picPath) {
                this.picPath = picPath;
            }

            public int getNpos() {
                return npos;
            }

            public void setNpos(int npos) {
                this.npos = npos;
            }
        }
    }
}
