package com.retrofitdemo.bean;

import java.util.List;

/**
 * <p>作者   wurui</p>
 * <p>时间   2018/11/23 0023</p>
 * <p>包名   com.retrofitdemo.bean</p>
 * <p>描述   TODO</p>
 */
public class BannerBean {

    /**
     * total : 5
     * code : 1
     * preUrl : https://www.spaimy.top/
     * message : 查询成功。
     * rows : [{"pkId":361,"url":"banner/index-banner.png","typeDes":"首页轮播图","type":"1"},{"pkId":362,"url":"banner/index-banner.png","typeDes":"首页轮播图","type":"1"},{"pkId":363,"url":"banner/index-banner.png","typeDes":"首页轮播图","type":"1"},{"pkId":364,"url":"banner/index-banner.png","typeDes":"首页轮播图","type":"1"},{"pkId":365,"url":"banner/index-banner.png","typeDes":"首页轮播图","type":"1"}]
     */

    private int total;
    private String code;
    private String preUrl;
    private String message;
    private List<RowsBean> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPreUrl() {
        return preUrl;
    }

    public void setPreUrl(String preUrl) {
        this.preUrl = preUrl;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * "pkId": 11198,
         "url": "banner/20181112/2018111219200817420181024红包BannerPC.jpg",
         "typeDes": "20181024红包BannerPC",
         "type": "3",
         "sort": 10,
         "status": 1
         */

        private int pkId;
        private String url;
        private String typeDes;
        private String type;
        private int sort;
        private int status;

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getPkId() {
            return pkId;
        }

        public void setPkId(int pkId) {
            this.pkId = pkId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTypeDes() {
            return typeDes;
        }

        public void setTypeDes(String typeDes) {
            this.typeDes = typeDes;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

}
