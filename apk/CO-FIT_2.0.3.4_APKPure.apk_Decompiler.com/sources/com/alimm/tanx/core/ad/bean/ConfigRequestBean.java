package com.alimm.tanx.core.ad.bean;

import com.alimm.tanx.core.ad.bean.RequestBaseBean;

public class ConfigRequestBean extends RequestBaseBean {
    private Long config_id;
    public AdDeviceBean device;
    public String ext = "";
    public String md5_app_key;
    public String req_Id;
    public AdUserBean user;
    private Long version;

    public static class AdDeviceBean extends RequestBaseBean.AdDeviceBean {
        public Integer os;
    }

    public static class AdUserBean extends BaseBean {
        public String app_key;
    }
}
