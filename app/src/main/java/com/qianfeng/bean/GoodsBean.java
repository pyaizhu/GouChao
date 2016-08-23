package com.qianfeng.bean;

import java.util.List;

/**
 * 分类模块下衣服的实体类
 * Created by Administrator on 2016/8/20 0020.
 */
public class GoodsBean {

    /**
     * message : 成功
     * statusCode : 0000
     * addDatas : {"resultlist":[{"id":183,"parentID":45,"goodName":"棉衣","picPath":"http://www.vip119.com:7080/GCUpload/goodType/02eb24ac4-3730-4c2e-b76a-a9209abe45db.jpg","bHotType":false,"npos":100},{"id":64,"parentID":45,"goodName":"大衣","picPath":"http://www.vip119.com:7080/GCUpload/goodType/06a5af955-c1b6-4cb8-88a9-5988eec55709.jpg","bHotType":false,"npos":99},{"id":72,"parentID":45,"goodName":"西装外套","picPath":"http://www.vip119.com:7080/GCUpload/goodType/023bc628f-31d8-42fe-9d4f-f95c84a6064b.jpg","bHotType":true,"npos":98},{"id":68,"parentID":45,"goodName":"风衣","picPath":"http://www.vip119.com:7080/GCUpload/goodType/089a9c9d9-6772-452e-a4f7-6eeaf8c0d168.jpg","bHotType":false,"npos":97},{"id":179,"parentID":45,"goodName":"皮衣","picPath":"http://www.vip119.com:7080/GCUpload/goodType/04d75d360-0912-421b-8a94-acd4e6a14db1.jpg","bHotType":false,"npos":96},{"id":70,"parentID":45,"goodName":"夹克","picPath":"http://www.vip119.com:7080/GCUpload/goodType/0b7a8bb73-2319-4820-a7db-5e4514bd9ef0.jpg","bHotType":false,"npos":94},{"id":196,"parentID":45,"goodName":"皮草","picPath":"http://www.vip119.com:7080/GCUpload/goodType/0198ad22e-8989-4260-adb3-01e050c68ee1.jpg","bHotType":false,"npos":39},{"id":71,"parentID":45,"goodName":"马甲","picPath":"http://www.vip119.com:7080/GCUpload/goodType/0c2199b45-9fab-45b3-b017-427a19dcf73d.jpg","bHotType":false,"npos":null}],"totalrecord":8,"count":8}
     */

    private String message;
    private String statusCode;
    /**
     * resultlist : [{"id":183,"parentID":45,"goodName":"棉衣","picPath":"http://www.vip119.com:7080/GCUpload/goodType/02eb24ac4-3730-4c2e-b76a-a9209abe45db.jpg","bHotType":false,"npos":100},{"id":64,"parentID":45,"goodName":"大衣","picPath":"http://www.vip119.com:7080/GCUpload/goodType/06a5af955-c1b6-4cb8-88a9-5988eec55709.jpg","bHotType":false,"npos":99},{"id":72,"parentID":45,"goodName":"西装外套","picPath":"http://www.vip119.com:7080/GCUpload/goodType/023bc628f-31d8-42fe-9d4f-f95c84a6064b.jpg","bHotType":true,"npos":98},{"id":68,"parentID":45,"goodName":"风衣","picPath":"http://www.vip119.com:7080/GCUpload/goodType/089a9c9d9-6772-452e-a4f7-6eeaf8c0d168.jpg","bHotType":false,"npos":97},{"id":179,"parentID":45,"goodName":"皮衣","picPath":"http://www.vip119.com:7080/GCUpload/goodType/04d75d360-0912-421b-8a94-acd4e6a14db1.jpg","bHotType":false,"npos":96},{"id":70,"parentID":45,"goodName":"夹克","picPath":"http://www.vip119.com:7080/GCUpload/goodType/0b7a8bb73-2319-4820-a7db-5e4514bd9ef0.jpg","bHotType":false,"npos":94},{"id":196,"parentID":45,"goodName":"皮草","picPath":"http://www.vip119.com:7080/GCUpload/goodType/0198ad22e-8989-4260-adb3-01e050c68ee1.jpg","bHotType":false,"npos":39},{"id":71,"parentID":45,"goodName":"马甲","picPath":"http://www.vip119.com:7080/GCUpload/goodType/0c2199b45-9fab-45b3-b017-427a19dcf73d.jpg","bHotType":false,"npos":null}]
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
         * id : 183
         * parentID : 45
         * goodName : 棉衣
         * picPath : http://www.vip119.com:7080/GCUpload/goodType/02eb24ac4-3730-4c2e-b76a-a9209abe45db.jpg
         * bHotType : false
         * npos : 100
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
            private int parentID;
            private String goodName;
            private String picPath;
            private boolean bHotType;
            private int npos;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getParentID() {
                return parentID;
            }

            public void setParentID(int parentID) {
                this.parentID = parentID;
            }

            public String getGoodName() {
                return goodName;
            }

            public void setGoodName(String goodName) {
                this.goodName = goodName;
            }

            public String getPicPath() {
                return picPath;
            }

            public void setPicPath(String picPath) {
                this.picPath = picPath;
            }

            public boolean isBHotType() {
                return bHotType;
            }

            public void setBHotType(boolean bHotType) {
                this.bHotType = bHotType;
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
