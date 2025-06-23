package com.baidu.navisdk.framework.interfaces.opendatasturct;

import android.os.Bundle;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class a {
    public static String A = "nViaductYawPosition";
    public static String B = "bIsOriPosInPOI";
    public static String C = "bIsMatchPosInPOI";
    public static String D = "unHARResult";
    public static String E = "nCurViaductState";
    public static String F = "LongitudeOri";
    public static String G = "LatitudeOri";
    public static String H = "LongitudeDest";
    public static String I = "LatitudeDest";
    public static String J = "fPrjDist";
    public static String K = "bIsVehicleFree";
    public static String L = "bIsYawState";
    public static String M = "fSpeed";
    public static String N = "sExt";
    public static String u = "enOriDRType";
    public static String v = "nNextCrossDist";
    public static String w = "bIsViaductYaw";
    public static String x = "bIsMatchAtViaductArea";
    public static String y = "bIsMatchAtTunnelArea";
    public static String z = "nMatchPoiAreaType";

    /* renamed from: a, reason: collision with root package name */
    public int f6815a;
    public int b;
    public boolean c;

    @Deprecated
    public boolean d;

    @Deprecated
    public boolean e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public double l;
    public double m;
    public double n;
    public double o;
    public float p;
    public boolean q;
    public boolean r;
    public float s;
    public String t;

    public static a a(Bundle bundle) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMatchResultForVDR", "parseInstance bundle:" + bundle.toString());
        }
        a aVar = new a();
        aVar.f6815a = bundle.getInt(u, -1);
        aVar.b = bundle.getInt(v, -1);
        aVar.c = bundle.getBoolean(w, false);
        aVar.d = bundle.getBoolean(x, false);
        aVar.e = bundle.getBoolean(y, false);
        aVar.f = bundle.getInt(z, 0);
        aVar.g = bundle.getInt(A, -1);
        aVar.h = bundle.getBoolean(B, false);
        aVar.i = bundle.getBoolean(C, false);
        aVar.j = bundle.getInt(D, -1);
        aVar.k = bundle.getInt(E, -1);
        aVar.l = bundle.getDouble(F, -1.0d);
        aVar.m = bundle.getDouble(G, -1.0d);
        aVar.n = bundle.getDouble(H, -1.0d);
        aVar.o = bundle.getDouble(I, -1.0d);
        aVar.p = bundle.getFloat(J, -1.0f);
        aVar.q = bundle.getBoolean(K, false);
        aVar.r = bundle.getBoolean(L, false);
        aVar.s = bundle.getFloat(M, -1.0f);
        aVar.t = bundle.getString(N, null);
        return aVar;
    }

    public String toString() {
        return "mEnOriDRType=" + this.f6815a + ",mNextCrossDist=" + this.b + ",isViaductYaw=" + this.c + ",isMatchAtViaductArea=" + this.d + ",isMatchAtTunnelArea=" + this.e + ",mMatchPoiAreaType=" + this.f + ",mViaductYawPosition=" + this.g + ",isOriPosInPOI=" + this.h + ",isMatchPosInPOI=" + this.i + ",mHARResult=" + this.j + ",mCurViaductState=" + this.k + ",mLongitudeOri=" + this.l + ",mLatitudeOri=" + this.m + ",mLongitudeDest=" + this.n + ",mLatitudeDest=" + this.o + ",mPrjDist=" + this.p + ",isVehicleFree=" + this.q + ",isYawState=" + this.r + ",mSpeed=" + this.s + ",mExt=" + this.t;
    }
}
