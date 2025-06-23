package com.adp.sdk.dto;

/* loaded from: classes.dex */
public class ADPConfig {
    private String oaid;
    private boolean enablePersonalRecommend = false;
    private boolean permissionAppListBoolean = true;
    private boolean debug = false;

    /* loaded from: classes.dex */
    public static class Builder {
        private String oaid;
        private boolean enablePersonalRecommend = false;
        private boolean permissionAppListBoolean = true;
        private boolean debug = false;

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

    /* JADX INFO: Access modifiers changed from: private */
    public void disablePersonalRecommand(boolean z) {
        this.enablePersonalRecommend = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
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
