package com.alimm.tanx.core.ad.bean;

import java.util.List;

/* loaded from: classes.dex */
public class RequestBaseBean extends BaseBean {
    public AdAppBean app;
    public AdDeviceBean device;
    public String id;

    /* loaded from: classes.dex */
    public static class AdAppBean extends BaseBean {
        public String app_name;
        public String app_version;
        public String package_name;
        public String sdk_version;
    }

    /* loaded from: classes.dex */
    public static class AdDeviceBean extends BaseBean {
        public String ali_aaid;
        public String android_id;
        public String brand;
        public String clientId;
        public int device_type;
        public String guid;
        public int height;
        public String imei;
        public List<String> installed_app;
        public String model;
        public int network;
        public String oaid;
        public int operator;
        public int orientation;
        public String os;
        public String osv;
        public int pixel_ratio;
        public String pseudoId;
        public String user_agent;
        public String widevineId;
        public int width;
    }
}
