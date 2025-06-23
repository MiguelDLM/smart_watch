package com.adp.sdk.dto;

public class ADPConfig {
    private boolean debug = false;
    private boolean enablePersonalRecommend = false;
    private String oaid;
    private boolean permissionAppListBoolean = true;

    public static class Builder {
        private boolean debug = false;
        private boolean enablePersonalRecommend = false;
        private String oaid;
        private boolean permissionAppListBoolean = true;

        public ADPConfig build() {
            ADPConfig aDPConfig = new ADPConfig();
            aDPConfig.disablePersonalRecommand(this.enablePersonalRecommend);
            aDPConfig.setPermissionAppListBoolean(this.permissionAppListBoolean);
            aDPConfig.setDebug(this.debug);
            aDPConfig.setOaid(this.oaid);
            return aDPConfig;
        }

        public Builder disablePersonalRecommand(boolean z) {
            this.enablePersonalRecommend = z;
            return this;
        }

        public Builder setDebug(boolean z) {
            this.debug = z;
            return this;
        }

        public Builder setOaid(String str) {
            this.oaid = str;
            return this;
        }

        public Builder setPermissionAppList(boolean z) {
            this.permissionAppListBoolean = z;
            return this;
        }
    }

    /* access modifiers changed from: private */
    public void disablePersonalRecommand(boolean z) {
        this.enablePersonalRecommend = z;
    }

    /* access modifiers changed from: private */
    public void setPermissionAppListBoolean(boolean z) {
        this.permissionAppListBoolean = z;
    }

    public boolean getDebug() {
        return this.debug;
    }

    public String getOaid() {
        return this.oaid;
    }

    public boolean getPermissionAppListBoolean() {
        return this.permissionAppListBoolean;
    }

    public boolean isEnablePersonalRecommend() {
        return this.enablePersonalRecommend;
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public void setOaid(String str) {
        this.oaid = str;
    }
}
