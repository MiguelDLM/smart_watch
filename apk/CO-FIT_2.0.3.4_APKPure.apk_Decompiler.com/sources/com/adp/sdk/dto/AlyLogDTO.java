package com.adp.sdk.dto;

public class AlyLogDTO {
    private String ad_type;
    private String app_id;
    private String app_version;
    private String client_id;
    private String device = "2";
    private String quantity_click;
    private String quantity_request;
    private String quantity_request_valid;
    private String quantity_reward;
    private String quantity_show;
    private String real_click;
    private String real_exposured;
    private String real_request;
    private String real_request_valid;
    private String real_reward;
    private String real_show;
    private String request_error;
    private String sdk_version;
    private String service_id;
    private String show_ad;
    private String source_id;
    private String space_id;

    public String getAd_type() {
        return this.ad_type;
    }

    public String getApp_id() {
        return this.app_id;
    }

    public String getApp_version() {
        return this.app_version;
    }

    public String getClient_id() {
        return this.client_id;
    }

    public String getDevice() {
        return this.device;
    }

    public String getQuantity_click() {
        return this.quantity_click;
    }

    public String getQuantity_request() {
        return this.quantity_request;
    }

    public String getQuantity_request_valid() {
        return this.quantity_request_valid;
    }

    public String getQuantity_reward() {
        return this.quantity_reward;
    }

    public String getQuantity_show() {
        return this.quantity_show;
    }

    public String getReal_click() {
        return this.real_click;
    }

    public String getReal_exposured() {
        return this.real_exposured;
    }

    public String getReal_request() {
        return this.real_request;
    }

    public String getReal_request_valid() {
        return this.real_request_valid;
    }

    public String getReal_reward() {
        return this.real_reward;
    }

    public String getReal_show() {
        return this.real_show;
    }

    public String getRequest_error() {
        return this.request_error;
    }

    public String getSdk_version() {
        return this.sdk_version;
    }

    public String getService_id() {
        return this.service_id;
    }

    public String getShow_ad() {
        return this.show_ad;
    }

    public String getSource_id() {
        return this.source_id;
    }

    public String getSpace_id() {
        return this.space_id;
    }

    public void setAd_type(String str) {
        this.ad_type = str;
    }

    public void setApp_id(String str) {
        this.app_id = str;
    }

    public void setApp_version(String str) {
        this.app_version = str;
    }

    public void setClient_id(String str) {
        this.client_id = str;
    }

    public void setDevice(String str) {
        this.device = str;
    }

    public void setQuantity_click(String str) {
        this.quantity_click = str;
    }

    public void setQuantity_request(String str) {
        this.quantity_request = str;
    }

    public void setQuantity_request_valid(String str) {
        this.quantity_request_valid = str;
    }

    public void setQuantity_reward(String str) {
        this.quantity_reward = str;
    }

    public void setQuantity_show(String str) {
        this.quantity_show = str;
    }

    public void setReal_click(String str) {
        this.real_click = str;
    }

    public void setReal_exposured(String str) {
        this.real_exposured = str;
    }

    public void setReal_request(String str) {
        this.real_request = str;
    }

    public void setReal_request_valid(String str) {
        this.real_request_valid = str;
    }

    public void setReal_reward(String str) {
        this.real_reward = str;
    }

    public void setReal_show(String str) {
        this.real_show = str;
    }

    public void setRequest_error(String str) {
        this.request_error = str;
    }

    public void setSdk_version(String str) {
        this.sdk_version = str;
    }

    public void setService_id(String str) {
        this.service_id = str;
    }

    public void setShow_ad(String str) {
        this.show_ad = str;
    }

    public void setSource_id(String str) {
        this.source_id = str;
    }

    public void setSpace_id(String str) {
        this.space_id = str;
    }

    public String toString() {
        String str = this.service_id;
        String str2 = "";
        if (str != null && str.length() > 0) {
            str2 = str2 + "\tservice_id:" + this.service_id;
        }
        String str3 = this.source_id;
        if (str3 != null && str3.length() > 0) {
            str2 = str2 + "\tsource_id:" + this.source_id;
        }
        if (this.quantity_request != null) {
            str2 = str2 + "\t用户请求广告数:" + this.quantity_request;
        }
        if (this.real_request != null) {
            str2 = str2 + "\t实际请求广告数:" + this.real_request;
        }
        if (this.quantity_request_valid != null) {
            str2 = str2 + "\t用户加载成功:" + this.quantity_request_valid;
        }
        if (this.real_request_valid != null) {
            str2 = str2 + "\t实际加载成功:" + this.real_request_valid;
        }
        if (this.quantity_show != null) {
            str2 = str2 + "\t用户展示数:" + this.quantity_show;
        }
        if (this.real_show != null) {
            str2 = str2 + "\t实际展示数:" + this.real_show;
        }
        if (this.quantity_click != null) {
            str2 = str2 + "\t用户点击数:" + this.quantity_click;
        }
        if (this.real_click != null) {
            str2 = str2 + "\t实际点击数:" + this.real_click;
        }
        if (this.quantity_reward != null) {
            str2 = str2 + "\t用户返回激励数::" + this.quantity_reward;
        }
        if (this.real_reward != null) {
            str2 = str2 + "\t实际返回激励数::" + this.real_reward;
        }
        if (this.show_ad != null) {
            str2 = str2 + "\t广告厂家:" + this.show_ad;
        }
        if (this.request_error != null) {
            str2 = str2 + "\terror:" + this.request_error;
        }
        if (this.ad_type == null) {
            return str2;
        }
        return str2 + "\t广告类型:" + this.ad_type;
    }
}
