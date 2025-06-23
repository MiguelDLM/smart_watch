package com.baidu.navisdk.ugc.eventdetails.model;

import XIXIX.OOXIXo;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.mapcontrol.MapParams;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.nplatform.comapi.MapItem;

/* loaded from: classes8.dex */
public final class a {
    public String t;
    public String u;
    public int v;
    public int w;
    public String x;
    public int y;

    /* renamed from: a, reason: collision with root package name */
    public String f8066a = null;
    public String b = null;
    public int c = -1;
    public int d = -1;
    public String e = null;
    public int f = 10;
    public int g = 4;
    private int h = 0;
    private int i = 0;
    private int j = -1;
    public int k = 1;
    private boolean l = false;
    private boolean m = true;
    private boolean n = true;
    public int o = -1;
    public int p = -1;
    public int q = 1;
    public double r = OOXIXo.f3760XO;
    public double s = OOXIXo.f3760XO;
    private boolean z = false;
    private boolean A = false;

    private void b(Bundle bundle) {
        this.o = bundle.getInt("yellow_id", -1);
        this.m = true;
        this.n = bundle.getBoolean("is_jump_flag", true);
        this.p = bundle.getInt("road_no", -1);
    }

    private int c(int i) {
        if (i == 12) {
            return 5;
        }
        if (i == 13) {
            return 3;
        }
        switch (i) {
            case 1:
            case 3:
            case 4:
                return 1;
            case 2:
                return 2;
            case 5:
            case 6:
                return 3;
            default:
                return 4;
        }
    }

    private boolean d(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        this.m = true;
        this.n = true;
        if (bundle.containsKey(MapItem.KEY_BZID)) {
            this.w = bundle.getInt(MapItem.KEY_BZID);
        } else {
            this.w = 0;
        }
        if (bundle.containsKey("clickType")) {
            this.v = bundle.getInt("clickType");
        } else {
            this.v = 0;
        }
        if (bundle.containsKey(MapParams.PanoramaKeys.EVENT_TYPE)) {
            this.h = bundle.getInt(MapParams.PanoramaKeys.EVENT_TYPE);
        } else {
            this.h = 0;
        }
        if (bundle.containsKey("source")) {
            this.f = bundle.getInt("source");
        } else {
            this.f = 10;
        }
        if (com.baidu.navisdk.module.ugc.a.b(this.h)) {
            this.f = 15;
        }
        if (bundle.containsKey("page")) {
            this.g = bundle.getInt("page");
        } else {
            this.g = c(this.f);
        }
        if (bundle.containsKey("inter_role")) {
            this.j = bundle.getInt("inter_role", 0);
        } else {
            this.j = -1;
        }
        this.c = bundle.getInt(MapItem.KEY_JAM_INDEX, -1);
        this.d = bundle.getInt("jamVersion", -1);
        if (bundle.containsKey("routeMD5")) {
            this.e = bundle.getString("routeMD5", "");
        } else {
            this.e = null;
        }
        if (bundle.containsKey("pass")) {
            this.l = bundle.getBoolean("pass", false);
        } else {
            this.l = false;
        }
        if (bundle.containsKey("x") && bundle.containsKey("y")) {
            this.r = bundle.getDouble("x");
            this.s = bundle.getDouble("y");
        } else {
            this.r = OOXIXo.f3760XO;
            this.s = OOXIXo.f3760XO;
        }
        if (this.f == 13) {
            b(bundle);
        }
        this.k = com.baidu.navisdk.ugc.eventdetails.control.b.b(this.h);
        if (bundle.containsKey("notShowAvoidCongestion")) {
            this.z = bundle.getBoolean("notShowAvoidCongestion", false);
        } else {
            this.z = false;
        }
        if (com.baidu.navisdk.ugc.eventdetails.control.b.d(this.h)) {
            this.z = true;
        }
        if (this.f == 15) {
            this.k = 5;
        }
        if (bundle.containsKey("onroute")) {
            this.i = bundle.getInt("onroute");
        } else if (this.f != 4 && this.h != 3101) {
            this.i = 0;
        } else {
            this.i = 1;
        }
        if (bundle.containsKey("eventName")) {
            this.t = bundle.getString("eventName", null);
        } else {
            this.t = null;
        }
        if (bundle.containsKey("uid")) {
            this.u = bundle.getString("uid", null);
        } else {
            this.u = null;
        }
        if (com.baidu.navisdk.module.ugc.a.b(this.h)) {
            this.m = false;
        } else if (bundle.containsKey("isHighlightedState")) {
            this.m = bundle.getBoolean("isHighlightedState", this.m);
        }
        if (bundle.containsKey("chatId")) {
            this.x = bundle.getString("chatId");
        }
        if (bundle.containsKey("nType")) {
            bundle.getInt("nType");
        }
        if (bundle.containsKey("nFrom")) {
            this.y = bundle.getInt("nFrom");
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", toString());
        }
        return true;
    }

    private int s() {
        if (this.f == 13) {
            return 3;
        }
        int i = this.q;
        if (i == 2 || i == 3 || com.baidu.navisdk.ugc.eventdetails.control.b.c(this.h)) {
            return 2;
        }
        return 1;
    }

    public boolean a(String str, Bundle bundle, String str2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "initBaseData: " + bundle + ",eventId: " + str + ", " + str2);
        }
        b();
        this.f8066a = str;
        if (str2 == null) {
            str2 = "";
        }
        this.b = str2;
        return a(bundle);
    }

    public int e() {
        if (this.k == 2) {
            return 1;
        }
        if (!TextUtils.isEmpty(this.x) && !"0".equals(this.x)) {
            return 0;
        }
        int i = this.k;
        if (i == 3) {
            if (!a(this.f8066a)) {
                return 1;
            }
            return 0;
        }
        if (i == 4) {
            return 1;
        }
        if (i == 5) {
            return 2;
        }
        return 0;
    }

    public int f() {
        return com.baidu.navisdk.module.ugc.a.a(this.h);
    }

    public int g() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "getTruckViaEndPointBtnType mEventId: " + this.f8066a + ", uid: " + this.u + ", eventName:" + this.t + ", locX:" + this.r + ", locY:" + this.s);
        }
        if (TextUtils.isEmpty(this.u)) {
            double d = this.r;
            if ((d == OOXIXo.f3760XO && this.s == OOXIXo.f3760XO) || d == Double.MIN_VALUE || this.s == Double.MIN_VALUE) {
                return 0;
            }
        }
        int i = this.h;
        if (i == 3104 || i == 3105) {
            return 0;
        }
        if (m()) {
            return 1;
        }
        int i2 = this.g;
        if (i2 != 8 && i2 != 3) {
            return 0;
        }
        return 3;
    }

    public Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putInt("page", this.g);
        bundle.putBoolean("isHighlightedState", this.m);
        bundle.putBoolean("isZoomBaseMap", this.n);
        bundle.putBoolean("isImPanel", true);
        return bundle;
    }

    public Bundle i() {
        Bundle bundle = new Bundle();
        bundle.putInt(MapItem.KEY_JAM_INDEX, this.c);
        bundle.putInt("jamVersion", this.d);
        bundle.putString("event_id", this.f8066a);
        bundle.putString("routeMD5", this.e);
        bundle.putInt("page", this.g);
        bundle.putBoolean("isHighlightedState", this.m);
        bundle.putBoolean("isOrientationChange", this.A);
        bundle.putInt("source", this.f);
        return bundle;
    }

    public int j() {
        if (this.w == 999 && this.v == 8) {
            if (com.baidu.navisdk.ugc.eventdetails.control.b.c(this.h)) {
                return 2;
            }
            return s();
        }
        return s();
    }

    public boolean k() {
        int i = this.q;
        if (i != 2 && i != 3) {
            return false;
        }
        return true;
    }

    public boolean l() {
        if (this.g == 4) {
            return true;
        }
        return false;
    }

    public boolean m() {
        int i = this.g;
        if (i == 1 || i == 2) {
            return true;
        }
        return false;
    }

    public boolean n() {
        if (this.f == 10) {
            return true;
        }
        return false;
    }

    public boolean o() {
        int i = this.i;
        if (i == 1 || i == 2) {
            return true;
        }
        if (this.f == 13 && this.p != -1) {
            return true;
        }
        return false;
    }

    public boolean p() {
        int i;
        int i2;
        int i3;
        if (this.z || (i = this.f) == 11 || i == 13 || i == 5 || i == 14 || (i2 = this.g) == 4 || (i3 = this.q) == 3 || i3 == 2) {
            return false;
        }
        if (i2 != 1 && i2 != 2 && i2 != 7) {
            if ((i2 != 3 && i2 != 6) || this.l || this.i != 1) {
                return false;
            }
            return true;
        }
        if (this.l || this.i != 1 || this.k == 2) {
            return false;
        }
        return true;
    }

    public boolean q() {
        if (this.k == 4) {
            return true;
        }
        return false;
    }

    public boolean r() {
        if (this.k == 2) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "BNEventBaseDataModel{mEventId='" + this.f8066a + "', mBduss='" + this.b + "', mJamIndex=" + this.c + ", mJamVersion=" + this.d + ", mRouteMD5='" + this.e + "', mSource=" + this.f + ", mPage=" + this.g + ", mVirtualType=" + this.h + ", onRoute=" + this.i + ", mInteractionRole=" + this.j + ", mPanelType=" + this.k + ", isPassEvent=" + this.l + ", isNeedHighLighted=" + this.m + ", isZoomBaseMap=" + this.n + ", yellowId=" + this.o + ", roadNo=" + this.p + ", eventName=" + this.t + ", uid=" + this.u + '}';
    }

    private boolean c(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        if (bundle.containsKey(MapParams.PanoramaKeys.EVENT_TYPE)) {
            this.h = bundle.getInt(MapParams.PanoramaKeys.EVENT_TYPE);
        }
        if (bundle.containsKey("source")) {
            this.f = bundle.getInt("source");
        }
        if (bundle.containsKey("page")) {
            this.g = bundle.getInt("page");
        }
        this.k = 4;
        return true;
    }

    public void b() {
        this.f8066a = null;
        this.b = null;
        this.h = 0;
        this.f = 10;
        this.g = 4;
        this.i = 0;
        this.j = -1;
        this.k = 1;
        this.c = -1;
        this.d = -1;
        this.e = null;
        this.l = false;
        this.m = true;
        this.n = true;
        this.o = -1;
        this.p = -1;
        this.q = 1;
        this.r = OOXIXo.f3760XO;
        this.s = OOXIXo.f3760XO;
        this.t = null;
        this.u = null;
        this.v = 0;
        this.w = 0;
        this.z = false;
        this.A = false;
        this.x = null;
        this.y = 0;
    }

    private boolean a(Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "parseBundle: " + bundle);
        }
        if (bundle == null) {
            return false;
        }
        if (bundle.containsKey("source")) {
            this.f = bundle.getInt("source");
        }
        if (this.f == 11) {
            return c(bundle);
        }
        return d(bundle);
    }

    public int c() {
        return this.h;
    }

    public Bundle a(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(MapItem.KEY_JAM_INDEX, this.c);
        bundle.putInt("jamVersion", this.d);
        bundle.putString("event_id", this.f8066a);
        bundle.putString("routeMD5", this.e);
        bundle.putInt("page", this.g);
        bundle.putInt("ugcPanelHeight", i);
        bundle.putBoolean("isHighlightedState", this.m);
        bundle.putBoolean("isZoomBaseMap", this.n);
        return bundle;
    }

    public boolean a() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "checkBaseParams: " + toString());
        }
        if (this.f == 13 && this.o < 0) {
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetails", "点击黄条 getView: return null yellowId:" + this.o);
            }
            return false;
        }
        int i = this.k;
        if ((i == 1 || i == 2) && TextUtils.isEmpty(this.f8066a)) {
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetails", "ugc 面板 getView: return null； eventId is null");
            }
            return false;
        }
        if (this.k != 3 || this.c >= 0 || !TextUtils.isEmpty(this.f8066a)) {
            return true;
        }
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "拥堵详情面板 getView: return null； mJamIndex：" + this.c + ", mEventId:" + this.f8066a);
        }
        return false;
    }

    public void b(int i) {
        if (this.h <= 0) {
            this.h = i;
        }
    }

    private boolean a(String str) {
        return (TextUtils.isEmpty(str) || JNIGuidanceControl.getInstance().uidCodecDecode(str) == 0 || "0".equals(str)) ? false : true;
    }

    public void a(boolean z) {
        this.A = z;
    }

    public int d() {
        int i;
        int i2 = this.g;
        if (i2 == 4 || (i = this.f) == 5 || i == 14 || i == 15) {
            return 0;
        }
        int i3 = this.k;
        if (i3 == 4) {
            return 3;
        }
        int i4 = this.y;
        if (i4 == 1) {
            return 1;
        }
        if (i4 == 2) {
            return 0;
        }
        if (i3 == 3) {
            return this.h == 3101 ? 2 : 1;
        }
        int i5 = this.q;
        return (i5 == 2 || i5 == 3) ? i2 == 3 ? 2 : 0 : (!TextUtils.isEmpty(this.f8066a) || this.c >= 0) ? 2 : 0;
    }
}
