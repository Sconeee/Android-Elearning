package com.example.home.bean;

import java.util.List;

public class ResultBeanData {


    /**
     * code : 200
     * msg : 请求成功
     * result : {"banner_info":[{"image":"/banner1.jpg","option":1,"type":0,"value":{"url":"/act20161111?cyc_app=1"}},{"image":"/banner2.png","option":2,"type":0,"value":{"url":"/act20161111?cyc_app=1"}}],"channel_info":[{"channel_name":"国家精品","image":"/app/img/menu-gjjp.png","option":2,"type":1,"value":{"channel_id":"8"}},{"channel_name":"21考研","image":"/app/img/menu-考研.png","option":2,"type":1,"value":{"channel_id":"4"}},{"channel_name":"名师专栏","image":"/app/img/menu-mszl.png","option":2,"type":1,"value":{"channel_id":"3"}},{"channel_name":"四六级","image":"/app/img/menu-cosplay.png","option":2,"type":1,"value":{"channel_id":"5"}},{"channel_name":"更多","image":"/app/img/menu-more.png","option":6,"type":1,"value":{"channel_id":"13"}}],"hot_info":[{"cover_price":"xxx老师","figure":"/weijifen.jpg","name":"微积分","product_id":"9356"},{"cover_price":"xxx老师","figure":"/xianxingdaishu.jpg","name":"线性代数","product_id":"10391"}],"recommend_info":[{"cover_price":"xxx老师","figure":"/supplier/shujujiegou.jpg","name":"数据结构","product_id":"10659"},{"cover_price":"xx老师","figure":"/supplier/jsjwl.jpg","name":"计算机网络","product_id":"10658"}]}
     */

    private int code;
    private String msg;
    private ResultBean result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private List<BannerInfoBean> banner_info;
        private List<ChannelInfoBean> channel_info;
        private List<HotInfoBean> hot_info;
        private List<RecommendInfoBean> recommend_info;

        public List<BannerInfoBean> getBanner_info() {
            return banner_info;
        }

        public void setBanner_info(List<BannerInfoBean> banner_info) {
            this.banner_info = banner_info;
        }

        public List<ChannelInfoBean> getChannel_info() {
            return channel_info;
        }

        public void setChannel_info(List<ChannelInfoBean> channel_info) {
            this.channel_info = channel_info;
        }

        public List<HotInfoBean> getHot_info() {
            return hot_info;
        }

        public void setHot_info(List<HotInfoBean> hot_info) {
            this.hot_info = hot_info;
        }

        public List<RecommendInfoBean> getRecommend_info() {
            return recommend_info;
        }

        public void setRecommend_info(List<RecommendInfoBean> recommend_info) {
            this.recommend_info = recommend_info;
        }

        public static class BannerInfoBean {
            /**
             * image : /banner1.jpg
             * option : 1
             * type : 0
             * value : {"url":"/act20161111?cyc_app=1"}
             */

            private String image;
            private int option;
            private int type;
            private ValueBean value;

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getOption() {
                return option;
            }

            public void setOption(int option) {
                this.option = option;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public ValueBean getValue() {
                return value;
            }

            public void setValue(ValueBean value) {
                this.value = value;
            }

            public static class ValueBean {
                /**
                 * url : /act20161111?cyc_app=1
                 */

                private String url;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }

        public static class ChannelInfoBean {
            /**
             * channel_name : 国家精品
             * image : /menu-gjjp.png
             * option : 2
             * type : 1
             * value : {"channel_id":"8"}
             */

            private String channel_name;
            private String image;
            private int option;
            private int type;
            private ValueBeanX value;

            public String getChannel_name() {
                return channel_name;
            }

            public void setChannel_name(String channel_name) {
                this.channel_name = channel_name;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getOption() {
                return option;
            }

            public void setOption(int option) {
                this.option = option;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public ValueBeanX getValue() {
                return value;
            }

            public void setValue(ValueBeanX value) {
                this.value = value;
            }

            public static class ValueBeanX {
                /**
                 * channel_id : 8
                 */

                private String channel_id;

                public String getChannel_id() {
                    return channel_id;
                }

                public void setChannel_id(String channel_id) {
                    this.channel_id = channel_id;
                }
            }
        }

        public static class HotInfoBean {
            /**
             * cover_price : xxx老师
             * figure : /weijifen.jpg
             * name : 微积分
             * product_id : 9356
             */

            private String cover_price;
            private String figure;
            private String name;
            private String product_id;

            public String getCover_price() {
                return cover_price;
            }

            public void setCover_price(String cover_price) {
                this.cover_price = cover_price;
            }

            public String getFigure() {
                return figure;
            }

            public void setFigure(String figure) {
                this.figure = figure;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getProduct_id() {
                return product_id;
            }

            public void setProduct_id(String product_id) {
                this.product_id = product_id;
            }
        }

        public static class RecommendInfoBean {
            /**
             * cover_price : xxx老师
             * figure : /shujujiegou.jpg
             * name : 数据结构
             * product_id : 10659
             */

            private String cover_price;
            private String figure;
            private String name;
            private String product_id;

            public String getCover_price() {
                return cover_price;
            }

            public void setCover_price(String cover_price) {
                this.cover_price = cover_price;
            }

            public String getFigure() {
                return figure;
            }

            public void setFigure(String figure) {
                this.figure = figure;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getProduct_id() {
                return product_id;
            }

            public void setProduct_id(String product_id) {
                this.product_id = product_id;
            }
        }
    }
}
