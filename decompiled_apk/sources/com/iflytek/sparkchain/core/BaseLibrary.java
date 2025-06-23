package com.iflytek.sparkchain.core;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.iflytek.sparkchain.media.PcmPlayerHelper;
import com.iflytek.sparkchain.media.RecorderHelper;
import com.iflytek.sparkchain.media.SimplePlayerHelper;

/* loaded from: classes10.dex */
public abstract class BaseLibrary {

    /* loaded from: classes10.dex */
    public enum AuthType implements Const {
        DEVICE(0),
        APP(1);

        private final int value;

        AuthType(int i) {
            this.value = i;
        }

        public static AuthType valueOf(int i) {
            if (i == 0) {
                return DEVICE;
            }
            if (i == 1) {
                return APP;
            }
            throw new IllegalArgumentException("type not supported");
        }

        @Override // com.iflytek.sparkchain.core.Const
        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes10.dex */
    public static class BaseParams {
        protected String ability;
        protected String apiKey;
        protected String apiSecret;
        protected String appId;
        protected String cfgFile;
        protected String licenseFile;
        protected String workDir;
        protected int authType = AuthType.DEVICE.getValue();
        protected boolean logOpen = false;
        protected boolean iLogOpen = true;
        protected int iLogMaxCount = 20;
        protected int iLogMaxSize = 1048576;
        protected boolean recordOpen = false;
        protected String customDeviceId = "";
        protected String batchID = "";
        protected String resDir = "";
        protected int authInterval = 300;
    }

    /* loaded from: classes10.dex */
    public static class Params extends BaseParams {

        /* loaded from: classes10.dex */
        public static class Builder extends BaseParams {
            public Builder ability(String str) {
                this.ability = str;
                return this;
            }

            public Builder apiKey(String str) {
                this.apiKey = str;
                return this;
            }

            public Builder apiSecret(String str) {
                this.apiSecret = str;
                return this;
            }

            public Builder appId(String str) {
                this.appId = str;
                return this;
            }

            public Builder authInterval(int i) {
                this.authInterval = i;
                return this;
            }

            public Builder authType(AuthType authType) {
                this.authType = authType.getValue();
                return this;
            }

            public Builder batchID(String str) {
                this.batchID = str;
                return this;
            }

            public Params build() {
                return new Params(this);
            }

            public Builder cfgFile(String str) {
                this.cfgFile = str;
                return this;
            }

            public Builder customDeviceId(String str) {
                this.customDeviceId = str;
                return this;
            }

            public Builder iLogMaxCount(int i) {
                this.iLogMaxCount = i;
                return this;
            }

            public Builder iLogMaxSize(int i) {
                this.iLogMaxSize = i;
                return this;
            }

            public Builder iLogOpen(boolean z) {
                this.iLogOpen = z;
                return this;
            }

            public Builder licenseFile(String str) {
                this.licenseFile = str;
                return this;
            }

            @Deprecated
            public Builder logOpen(boolean z) {
                this.logOpen = z;
                return this;
            }

            public Builder recordOpen(boolean z) {
                this.recordOpen = z;
                return this;
            }

            public Builder resDir(String str) {
                this.resDir = str;
                return this;
            }

            public Builder workDir(String str) {
                this.workDir = str;
                return this;
            }
        }

        private Params(Builder builder) {
            this.appId = builder.appId;
            this.apiKey = builder.apiKey;
            this.apiSecret = builder.apiSecret;
            this.authType = builder.authType;
            this.licenseFile = builder.licenseFile;
            this.workDir = builder.workDir;
            this.logOpen = builder.logOpen;
            this.iLogOpen = builder.iLogOpen;
            this.iLogMaxCount = builder.iLogMaxCount;
            this.iLogMaxSize = builder.iLogMaxSize;
            this.customDeviceId = builder.customDeviceId;
            this.batchID = builder.batchID;
            this.resDir = builder.resDir;
            this.cfgFile = builder.cfgFile;
            this.authInterval = builder.authInterval;
            this.recordOpen = builder.recordOpen;
            this.ability = builder.ability;
        }

        public static Builder builder() {
            return new Builder();
        }

        public String getAbility() {
            return this.ability;
        }

        public String getApiKey() {
            return this.apiKey;
        }

        public String getApiSecret() {
            return this.apiSecret;
        }

        public String getAppId() {
            return this.appId;
        }

        public int getAuthInterval() {
            return this.authInterval;
        }

        public int getAuthType() {
            return this.authType;
        }

        public String getBatchID() {
            return this.batchID;
        }

        public String getCfgFile() {
            return this.cfgFile;
        }

        public String getCustomDeviceId() {
            return this.customDeviceId;
        }

        public String getLicenseFile() {
            return this.licenseFile;
        }

        public String getResDir() {
            return this.resDir;
        }

        public String getWorkDir() {
            return this.workDir;
        }

        public int getiLogMaxCount() {
            return this.iLogMaxCount;
        }

        public long getiLogMaxSize() {
            return this.iLogMaxSize;
        }

        public boolean isLogOpen() {
            return this.logOpen;
        }

        public boolean isRecordOpen() {
            return this.recordOpen;
        }

        public boolean isiLogOpen() {
            return this.iLogOpen;
        }
    }

    public Context getContext() {
        return Auth.d().a();
    }

    public String getDeviceId() {
        return Auth.d().b();
    }

    public void init(Activity activity, Params params) {
        init(activity.getBaseContext(), params);
    }

    @Deprecated
    public void initEntry(Activity activity, Params params) {
        Auth.d().a(activity);
        Auth.d().a(activity.getApplicationContext(), params);
    }

    public abstract void registerListener(AiResponseListener aiResponseListener);

    public void unInit() {
        RecorderHelper.getInst().stop();
        PcmPlayerHelper.getInst().release();
        SimplePlayerHelper.getInst().release();
        Auth.d().a((Context) null);
        Auth.d().release();
    }

    public void init(Context context, Params params) {
        Auth.d().a(context);
        if (Build.VERSION.SDK_INT >= 29) {
            Auth.d().b(context, params);
        } else {
            Auth.d().a(context, params);
        }
    }

    @Deprecated
    public void initEntry(Context context, Params params) {
        init(context, params);
    }
}
