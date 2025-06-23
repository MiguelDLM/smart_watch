package com.huawei.hms.ads;

import android.content.ComponentName;
import android.content.Intent;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: classes10.dex */
public class jn {
    private String Code;
    private String I;
    private String V;
    private String Z;

    /* loaded from: classes10.dex */
    public static class a {
        private static final String Code = "RedirectionMatchParam.Builder";
        private String B;
        private String I;
        private String V;
        private String Z;

        public a Code(Intent intent) {
            if (intent == null) {
                return this;
            }
            if (com.huawei.openalliance.ad.utils.ay.Code(this.Z)) {
                this.Z = intent.getPackage();
            }
            ComponentName component = intent.getComponent();
            if (component != null && com.huawei.openalliance.ad.utils.ay.Code(this.B)) {
                this.B = component.getClassName();
            }
            return this;
        }

        public a I(String str) {
            this.Z = str;
            return this;
        }

        public a V(String str) {
            this.I = str;
            return this;
        }

        public a Z(String str) {
            this.B = str;
            return this;
        }

        public a Code(ApkInfo apkInfo) {
            if (apkInfo == null) {
                return this;
            }
            String Code2 = apkInfo.Code();
            String v = apkInfo.v();
            if (!com.huawei.openalliance.ad.utils.ay.Code(Code2)) {
                this.Z = Code2;
            }
            if (!com.huawei.openalliance.ad.utils.ay.Code(v)) {
                this.B = v;
            }
            return this;
        }

        public a Code(AdContentData adContentData) {
            if (adContentData == null) {
                fb.I(Code, "send param by content record,record is null.");
                return this;
            }
            this.V = adContentData.a();
            this.I = adContentData.b();
            return this;
        }

        public a Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
            if (appInfo == null) {
                return this;
            }
            String Code2 = appInfo.Code();
            String A = appInfo.A();
            if (!com.huawei.openalliance.ad.utils.ay.Code(Code2)) {
                this.Z = Code2;
            }
            if (!com.huawei.openalliance.ad.utils.ay.Code(A)) {
                this.B = A;
            }
            return this;
        }

        public a Code(String str) {
            this.V = str;
            return this;
        }

        public jn Code() {
            return new jn(this);
        }
    }

    public jn(a aVar) {
        this.I = aVar.Z;
        this.Z = aVar.B;
        this.Code = aVar.V;
        this.V = aVar.I;
    }

    public String Code() {
        return this.Code;
    }

    public String I() {
        return this.I;
    }

    public String V() {
        return this.V;
    }

    public String Z() {
        return this.Z;
    }

    public void Code(Intent intent) {
        if (intent == null) {
            return;
        }
        if (this.I == null) {
            this.I = intent.getPackage();
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            Z(component.getClassName());
        }
    }

    public void I(String str) {
        this.I = str;
    }

    public void V(String str) {
        this.V = str;
    }

    public void Z(String str) {
        this.Z = str;
    }

    public void Code(AdContentData adContentData) {
        if (adContentData == null) {
            return;
        }
        this.V = adContentData.b();
        this.Code = adContentData.a();
    }

    public void Code(String str) {
        this.Code = str;
    }
}
