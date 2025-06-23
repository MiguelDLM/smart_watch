package com.bytedance.android.live.base.api;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.bytedance.android.live.base.api.param.IUserIdGetter;
import com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public interface ILiveHostContextParam {

    /* loaded from: classes8.dex */
    public static class Builder {
        private int aid;
        private int appIcon;
        private String appName;
        private String channel;
        private Application context;
        private String generalAppId;
        private ILiveHostActionParam hostActionParam;
        private boolean isBoe;
        private boolean isDebug;
        private MethodChannelService methodChannelService;
        private String partner;
        private String partnerSecret;
        private boolean runInLiveProcess;
        private String ttSDKAppId;
        private String ttSDKCertAssetsPath;
        private String version;
        private int versionCode;
        private String cjAppId = "";
        private String cjMerchantId = "";
        private String nativeLibraryDir = "";
        private Map<String, String> feParamsExtra = null;
        private String ecHostAppId = null;
        private String clientKey = "";
        private JSONObject paramsExtraSettings = null;
        private HashMap<String, String> hostInitExtra = null;
        private IHostTokenInjectionAuth injectionAuth = null;
        private IUserIdGetter userIdGetter = new IUserIdGetter() { // from class: com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.1
            @Override // com.bytedance.android.live.base.api.param.IUserIdGetter
            public String getUserId() {
                return "";
            }
        };
        private IHostPermission hostPermission = new DefaultHostPermission();

        /* JADX INFO: Access modifiers changed from: private */
        public Builder copy(Builder builder) {
            Builder builder2 = new Builder();
            for (Field field : Builder.class.getDeclaredFields()) {
                boolean isAccessible = field.isAccessible();
                if (!isAccessible) {
                    field.setAccessible(true);
                }
                field.set(builder2, field.get(builder));
                field.setAccessible(isAccessible);
            }
            return builder2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public PackageInfo getPackageInfo(Application application) {
            try {
                return application.getPackageManager().getPackageInfo(application.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }

        public Builder addHostInitExtra(Map<String, String> map) {
            if (map != null) {
                if (this.hostInitExtra == null) {
                    this.hostInitExtra = new HashMap<>();
                }
                this.hostInitExtra.putAll(map);
            }
            return this;
        }

        public ILiveHostContextParam build() {
            return new ILiveHostContextParam() { // from class: com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.2
                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public int getAid() {
                    return Builder.this.aid;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public int getAppIcon() {
                    ApplicationInfo applicationInfo;
                    if (Builder.this.appIcon == 0) {
                        Builder builder = Builder.this;
                        PackageInfo packageInfo = builder.getPackageInfo(builder.context);
                        if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                            return applicationInfo.icon;
                        }
                    }
                    return Builder.this.appIcon;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getAppName() {
                    ApplicationInfo applicationInfo;
                    if (Builder.this.appName == null) {
                        Builder builder = Builder.this;
                        PackageInfo packageInfo = builder.getPackageInfo(builder.context);
                        if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                            return applicationInfo.name;
                        }
                    }
                    return Builder.this.appName;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getCJAppId() {
                    return Builder.this.cjAppId;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getCJMerchantId() {
                    return Builder.this.cjMerchantId;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getChannel() {
                    return Builder.this.channel;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getClientKey() {
                    return Builder.this.clientKey;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public Application getContext() {
                    return Builder.this.context;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public boolean getDebug() {
                    return Builder.this.isDebug;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getECHostAppId() {
                    return Builder.this.ecHostAppId;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public Map<String, String> getFEParamsExtra() {
                    return Builder.this.feParamsExtra;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getGeneralAppId() {
                    return Builder.this.generalAppId;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public ILiveHostActionParam getHostAction() {
                    return Builder.this.hostActionParam;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public Map<String, String> getHostInitExtra() {
                    return Builder.this.hostInitExtra;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public IHostPermission getHostPermission() {
                    return Builder.this.hostPermission;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getNativeLibraryDir() {
                    return Builder.this.nativeLibraryDir;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public JSONObject getParamsExtraSettings() {
                    return Builder.this.paramsExtraSettings;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getPartner() {
                    return Builder.this.partner;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getPartnerSecret() {
                    return Builder.this.partnerSecret;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public boolean getRunInLiveProcess() {
                    return Builder.this.runInLiveProcess;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getTtSDKAppId() {
                    return Builder.this.ttSDKAppId;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getTtSDKCertAssetsPath() {
                    return Builder.this.ttSDKCertAssetsPath;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getVersion() {
                    String str;
                    if (Builder.this.version != null) {
                        return Builder.this.version;
                    }
                    Builder builder = Builder.this;
                    PackageInfo packageInfo = builder.getPackageInfo(builder.context);
                    return (packageInfo == null || (str = packageInfo.versionName) == null) ? "1.0.0-default" : str;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public int getVersionCode() {
                    if (Builder.this.versionCode != 0) {
                        return Builder.this.versionCode;
                    }
                    Builder builder = Builder.this;
                    PackageInfo packageInfo = builder.getPackageInfo(builder.context);
                    if (packageInfo != null) {
                        return packageInfo.versionCode;
                    }
                    return 1;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public IHostTokenInjectionAuth injectAccount() {
                    return Builder.this.injectionAuth;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public boolean isBoe() {
                    return Builder.this.isBoe;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public MethodChannelService provideMethodChannel() {
                    return Builder.this.methodChannelService;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public IUserIdGetter provideUserIdGetter() {
                    return Builder.this.userIdGetter;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public Builder toBuilder() {
                    try {
                        return Builder.this.copy(this);
                    } catch (Exception unused) {
                        return this;
                    }
                }
            };
        }

        public Builder provideMethodChannel(MethodChannelService methodChannelService) {
            this.methodChannelService = methodChannelService;
            return this;
        }

        public Builder setAid(int i) {
            this.aid = i;
            return this;
        }

        public Builder setAppIcon(int i) {
            this.appIcon = i;
            return this;
        }

        public Builder setAppName(String str) {
            this.appName = str;
            return this;
        }

        public Builder setChannel(String str) {
            this.channel = str;
            return this;
        }

        public Builder setCjAppId(String str) {
            this.cjAppId = str;
            return this;
        }

        public Builder setCjMerchantId(String str) {
            this.cjMerchantId = str;
            return this;
        }

        public Builder setClientKey(String str) {
            this.clientKey = str;
            return this;
        }

        public Builder setContext(Application application) {
            this.context = application;
            return this;
        }

        public Builder setECHostAppId(String str) {
            this.ecHostAppId = str;
            return this;
        }

        public Builder setFeParamsExtra(Map<String, String> map) {
            this.feParamsExtra = map;
            return this;
        }

        public Builder setGeneralAppId(String str) {
            this.generalAppId = str;
            return this;
        }

        public Builder setHostActionParam(ILiveHostActionParam iLiveHostActionParam) {
            this.hostActionParam = iLiveHostActionParam;
            return this;
        }

        public Builder setHostPermission(IHostPermission iHostPermission) {
            if (iHostPermission != null) {
                this.hostPermission = iHostPermission;
            }
            return this;
        }

        public Builder setInjectionAuth(IHostTokenInjectionAuth iHostTokenInjectionAuth) {
            this.injectionAuth = iHostTokenInjectionAuth;
            return this;
        }

        public Builder setIsBoe(boolean z) {
            this.isBoe = z;
            return this;
        }

        public Builder setIsDebug(boolean z) {
            this.isDebug = z;
            return this;
        }

        public Builder setNativeLibraryDir(String str) {
            this.nativeLibraryDir = str;
            return this;
        }

        public Builder setParamsExtraSettings(JSONObject jSONObject) {
            this.paramsExtraSettings = jSONObject;
            return this;
        }

        public Builder setPartner(String str) {
            this.partner = str;
            return this;
        }

        public Builder setPartnerSecret(String str) {
            this.partnerSecret = str;
            return this;
        }

        public Builder setRunInLiveProcess(boolean z) {
            this.runInLiveProcess = z;
            return this;
        }

        public Builder setTtSDKAppId(String str) {
            this.ttSDKAppId = str;
            return this;
        }

        public Builder setTtSDKCertAssetsPath(String str) {
            this.ttSDKCertAssetsPath = str;
            return this;
        }

        public Builder setUserIdGetter(IUserIdGetter iUserIdGetter) {
            this.userIdGetter = iUserIdGetter;
            return this;
        }

        public Builder setVersion(String str) {
            this.version = str;
            return this;
        }

        public Builder setVersionCode(int i) {
            this.versionCode = i;
            return this;
        }
    }

    int getAid();

    int getAppIcon();

    String getAppName();

    String getCJAppId();

    String getCJMerchantId();

    String getChannel();

    String getClientKey();

    Application getContext();

    boolean getDebug();

    String getECHostAppId();

    Map<String, String> getFEParamsExtra();

    String getGeneralAppId();

    ILiveHostActionParam getHostAction();

    Map<String, String> getHostInitExtra();

    IHostPermission getHostPermission();

    String getNativeLibraryDir();

    JSONObject getParamsExtraSettings();

    String getPartner();

    String getPartnerSecret();

    boolean getRunInLiveProcess();

    String getTtSDKAppId();

    String getTtSDKCertAssetsPath();

    String getVersion();

    int getVersionCode();

    IHostTokenInjectionAuth injectAccount();

    boolean isBoe();

    MethodChannelService provideMethodChannel();

    IUserIdGetter provideUserIdGetter();

    Builder toBuilder();
}
