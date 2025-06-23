package com.fd.aliiot.core.entity;

import IXX.oIX0oI;

/* loaded from: classes8.dex */
public class VersionReply {
    private String method;
    private ParamsBean params;
    private String id = String.valueOf(oIX0oI.oIX0oI());
    private String version = "1.0.0";

    /* loaded from: classes8.dex */
    public static class ParamsBean {
        private String AppSdkVersion;

        public ParamsBean(String str) {
            this.AppSdkVersion = str;
        }

        public String getAppSdkVersion() {
            return this.AppSdkVersion;
        }

        public void setAppSdkVersion(String str) {
            this.AppSdkVersion = str;
        }
    }

    public String getId() {
        return this.id;
    }

    public String getMethod() {
        return this.method;
    }

    public ParamsBean getParams() {
        return this.params;
    }

    public String getVersion() {
        return this.version;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setParams(ParamsBean paramsBean) {
        this.params = paramsBean;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
