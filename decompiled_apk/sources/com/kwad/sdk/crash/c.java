package com.kwad.sdk.crash;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class c {
    private static final String TAG = "c";
    public final String aAC;
    public final String[] aGA;
    public final String[] aGB;
    public final boolean aGC;
    public final f aGD;
    public final String aGE;
    public final String aGF;
    public final String aGG;
    public final String aGH;
    public final String aGI;
    public final String aGJ;
    public final String aGK;
    public final String aGL;
    public final List<com.kwad.sdk.crash.a> aGM;
    public final double aGp;
    public final boolean aGt;
    public final boolean aGu;
    public final com.kwad.sdk.crash.model.c aGx;
    public final com.kwad.sdk.crash.model.a aGy;
    public final h aGz;
    public final boolean alT;
    public final String channel;
    public final Context context;
    public final String platform;
    public final String sdkVersion;

    /* loaded from: classes11.dex */
    public static class a {
        private String XB;
        private int XC;
        private String aAC;
        private f aGD;
        private String aGE;
        private String aGF;
        private String aGG;
        private String aGH;
        private String aGN;
        private h aGO;
        private String[] aGP;
        public String[] aGQ;
        private String appId;
        private String appName;
        private String appPackageName;
        private String appVersion;
        private int azZ;
        private String channel;
        private Context context;
        private String platform;
        public int sdkType;
        private String sdkVersion;
        private boolean aGC = false;
        private boolean aGt = false;
        private boolean aGu = false;
        private boolean alT = false;
        private String aGI = "";
        private String aGJ = "";
        private String aGK = "";
        private String aGL = "";
        private List<com.kwad.sdk.crash.a> aGM = new ArrayList();
        private double aGp = 1.0d;

        public final a E(List<String> list) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        com.kwad.sdk.crash.a aVar = new com.kwad.sdk.crash.a();
                        aVar.parseJson(jSONObject);
                        this.aGM.add(aVar);
                    } catch (Exception e) {
                        com.kwad.sdk.core.e.c.w(c.TAG, Log.getStackTraceString(e));
                    }
                }
            }
            return this;
        }

        public final c Ie() {
            return new c(this, (byte) 0);
        }

        public final a bI(Context context) {
            this.context = context;
            return this;
        }

        public final a bx(boolean z) {
            this.aGt = z;
            return this;
        }

        public final a by(boolean z) {
            this.aGu = z;
            return this;
        }

        public final a bz(boolean z) {
            this.alT = z;
            return this;
        }

        public final a dA(int i) {
            this.sdkType = 1;
            return this;
        }

        public final a dy(int i) {
            this.azZ = i;
            return this;
        }

        public final a dz(int i) {
            this.XC = i;
            return this;
        }

        public final a fj(String str) {
            this.aGI = str;
            return this;
        }

        public final a fk(String str) {
            this.aGJ = str;
            return this;
        }

        public final a fl(String str) {
            this.platform = str;
            return this;
        }

        public final a fm(String str) {
            this.aGE = str;
            return this;
        }

        public final a fn(String str) {
            this.aAC = str;
            return this;
        }

        public final a fo(String str) {
            this.channel = str;
            return this;
        }

        public final a fp(String str) {
            this.aGH = str;
            return this;
        }

        public final a fq(String str) {
            this.aGN = str;
            return this;
        }

        public final a fr(String str) {
            this.sdkVersion = str;
            return this;
        }

        public final a fs(String str) {
            this.XB = str;
            return this;
        }

        public final a ft(String str) {
            this.appPackageName = str;
            return this;
        }

        public final a fu(String str) {
            this.appId = str;
            return this;
        }

        public final a fv(String str) {
            this.appName = str;
            return this;
        }

        public final a fw(String str) {
            this.appVersion = str;
            return this;
        }

        public final a fx(String str) {
            this.aGF = str;
            return this;
        }

        public final a fy(String str) {
            this.aGK = str;
            return this;
        }

        public final a fz(String str) {
            this.aGL = str;
            return this;
        }

        public final a a(f fVar) {
            this.aGD = fVar;
            return this;
        }

        public final a d(String[] strArr) {
            this.aGP = strArr;
            return this;
        }

        public final a e(String[] strArr) {
            this.aGQ = strArr;
            return this;
        }

        public final a m(double d) {
            this.aGp = d;
            return this;
        }

        public final a a(h hVar) {
            this.aGO = hVar;
            return this;
        }
    }

    public /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    public final f Ib() {
        return this.aGD;
    }

    public final boolean Ic() {
        return this.aGC;
    }

    private c(a aVar) {
        com.kwad.sdk.crash.model.c cVar = new com.kwad.sdk.crash.model.c();
        this.aGx = cVar;
        com.kwad.sdk.crash.model.a aVar2 = new com.kwad.sdk.crash.model.a();
        this.aGy = aVar2;
        ArrayList arrayList = new ArrayList();
        this.aGM = arrayList;
        this.aGC = aVar.aGC;
        this.aGt = aVar.aGt;
        this.aGu = aVar.aGu;
        this.alT = aVar.alT;
        this.aGI = aVar.aGI;
        this.aGJ = aVar.aGJ;
        this.aGK = aVar.aGK;
        this.aGL = aVar.aGL;
        this.context = aVar.context;
        this.aGD = aVar.aGD;
        this.platform = aVar.platform;
        this.aGE = aVar.aGE;
        this.aGF = aVar.aGF;
        this.sdkVersion = aVar.sdkVersion;
        this.aAC = aVar.aAC;
        this.channel = aVar.channel;
        this.aGG = aVar.aGG;
        this.aGH = aVar.aGH;
        aVar2.aHr = aVar.appId;
        aVar2.mAppName = aVar.appName;
        aVar2.aHt = aVar.appVersion;
        aVar2.aHs = aVar.appPackageName;
        cVar.aHC = aVar.XB;
        cVar.aHD = aVar.XC;
        cVar.mSdkVersion = aVar.sdkVersion;
        cVar.aHB = aVar.azZ;
        cVar.aHA = aVar.aGN;
        cVar.aHE = aVar.sdkType;
        this.aGz = aVar.aGO;
        this.aGA = aVar.aGP;
        this.aGB = aVar.aGQ;
        arrayList.addAll(aVar.aGM);
        this.aGp = aVar.aGp;
    }
}
