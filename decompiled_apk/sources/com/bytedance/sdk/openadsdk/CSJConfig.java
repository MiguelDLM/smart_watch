package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class CSJConfig implements AdConfig {

    /* renamed from: a, reason: collision with root package name */
    private String f10644a;
    private String b;
    private boolean c;
    private String d;
    private String e;
    private int f;
    private boolean g;
    private boolean h;
    private int[] i;
    private boolean j;
    private Map<String, Object> k;
    private TTCustomController l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private IMediationConfig q;

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f10645a;
        private String b;
        private String d;
        private String e;
        private int[] i;
        private TTCustomController k;
        private int l;
        private boolean o;
        private IMediationConfig p;
        private boolean c = false;
        private int f = 0;
        private boolean g = true;
        private boolean h = false;
        private boolean j = false;
        private int m = 2;
        private int n = 0;
        private Map<String, Object> q = null;

        public a a(String str) {
            this.f10645a = str;
            return this;
        }

        public a b(String str) {
            this.b = str;
            return this;
        }

        public a c(String str) {
            this.d = str;
            return this;
        }

        public a d(String str) {
            this.e = str;
            return this;
        }

        public a e(boolean z) {
            this.o = z;
            return this;
        }

        public a a(boolean z) {
            this.c = z;
            return this;
        }

        public a b(boolean z) {
            this.g = z;
            return this;
        }

        public a c(boolean z) {
            this.h = z;
            return this;
        }

        public a d(boolean z) {
            this.j = z;
            return this;
        }

        public a a(int i) {
            this.f = i;
            return this;
        }

        public a b(int i) {
            this.l = i;
            return this;
        }

        public a c(int i) {
            this.m = i;
            return this;
        }

        public a d(int i) {
            this.n = i;
            return this;
        }

        public a a(int... iArr) {
            this.i = iArr;
            return this;
        }

        public a a(TTCustomController tTCustomController) {
            this.k = tTCustomController;
            return this;
        }

        public a a(IMediationConfig iMediationConfig) {
            this.p = iMediationConfig;
            return this;
        }

        public a a(String str, Object obj) {
            if (this.q == null) {
                this.q = new HashMap();
            }
            this.q.put(str, obj);
            return this;
        }
    }

    public CSJConfig(a aVar) {
        this.c = false;
        this.f = 0;
        this.g = true;
        this.h = false;
        this.j = false;
        this.f10644a = aVar.f10645a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.l = aVar.k;
        this.m = aVar.l;
        this.o = aVar.n;
        this.n = aVar.m;
        this.p = aVar.o;
        this.q = aVar.p;
        this.k = aVar.q;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getAgeGroup() {
        return this.o;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppId() {
        return this.f10644a;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppName() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public TTCustomController getCustomController() {
        return this.l;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getData() {
        return this.e;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.i;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Object getExtra(String str) {
        Map<String, Object> map = this.k;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Map<String, Object> getInitExtra() {
        return this.k;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getKeywords() {
        return this.d;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public IMediationConfig getMediationConfig() {
        return this.q;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getPluginUpdateConfig() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getThemeStatus() {
        return this.m;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getTitleBarTheme() {
        return this.f;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isDebug() {
        return this.h;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isSupportMultiProcess() {
        return this.j;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isUseMediation() {
        return this.p;
    }

    public void setAgeGroup(int i) {
        this.o = i;
    }

    public void setAllowShowNotify(boolean z) {
        this.g = z;
    }

    public void setAppId(String str) {
        this.f10644a = str;
    }

    public void setAppName(String str) {
        this.b = str;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.l = tTCustomController;
    }

    public void setData(String str) {
        this.e = str;
    }

    public void setDebug(boolean z) {
        this.h = z;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.i = iArr;
    }

    public void setKeywords(String str) {
        this.d = str;
    }

    public void setPaid(boolean z) {
        this.c = z;
    }

    public void setSupportMultiProcess(boolean z) {
        this.j = z;
    }

    public void setThemeStatus(int i) {
        this.m = i;
    }

    public void setTitleBarTheme(int i) {
        this.f = i;
    }
}
