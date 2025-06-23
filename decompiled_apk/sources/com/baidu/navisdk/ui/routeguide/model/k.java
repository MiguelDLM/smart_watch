package com.baidu.navisdk.ui.routeguide.model;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class k {
    private String b;
    private Drawable f;
    private String g;

    /* renamed from: a, reason: collision with root package name */
    private int f8949a = 0;
    private int c = 1000;
    private boolean d = false;
    private boolean e = false;

    public void a(Bundle bundle, HashMap<String, Integer> hashMap) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFollowGuideModel", "update: " + bundle);
        }
        this.f8949a = 0;
        this.b = null;
        this.c = 1000;
        this.d = false;
        this.f = null;
        this.g = null;
        if (bundle == null) {
            return;
        }
        if (bundle.containsKey(RouteGuideParams.RGKey.SimpleGuideInfo.NextTurnKind)) {
            this.f8949a = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.NextTurnKind, 0);
        }
        if (bundle.containsKey(RouteGuideParams.RGKey.SimpleGuideInfo.NextNextRoadName)) {
            this.b = bundle.getString(RouteGuideParams.RGKey.SimpleGuideInfo.NextNextRoadName, null);
        }
        if (this.f8949a == 24 && TextUtils.isEmpty(this.b)) {
            this.b = "目的地";
        }
        if (bundle.containsKey(RouteGuideParams.RGKey.SimpleGuideInfo.DistCur2NextGP)) {
            this.c = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.DistCur2NextGP, 1000);
        }
        if (bundle.containsKey(RouteGuideParams.RGKey.SimpleGuideInfo.HighwayExCur2NextGP)) {
            this.d = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.HighwayExCur2NextGP) > 0;
        }
        int a2 = a(hashMap);
        if (a2 != -1) {
            if (com.baidu.navisdk.ui.routeguide.subview.util.b.a()) {
                this.f = JarUtils.getResources().getDrawable(a2);
            } else {
                this.f = com.baidu.navisdk.ui.routeguide.subview.util.b.a(a2);
            }
        }
        if (gVar.d()) {
            gVar.e("RGFollowGuideModel", "update: " + toString());
        }
    }

    public String b() {
        return this.b;
    }

    public int c() {
        return this.f8949a;
    }

    public Drawable d() {
        return this.f;
    }

    public boolean e() {
        return this.e;
    }

    public void f() {
        this.f8949a = 0;
        this.b = null;
        this.c = 1000;
        this.d = false;
        this.e = false;
        this.f = null;
        this.g = null;
    }

    public String toString() {
        return "RGFollowGuideModel{mNextTurnKind=" + this.f8949a + ", mFollowRoadName='" + this.b + "', mDistCur2NextGP=" + this.c + ", mIsHighwayExCur2NextGP=" + this.d + ", mNextTurnVisible=" + this.e + ", mExitCode=" + this.g + "， mTurnNextIcon" + this.f + '}';
    }

    public void a(Drawable drawable, String str) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFollowGuideModel", "update: " + str);
        }
        this.f8949a = 0;
        this.c = 1000;
        this.d = false;
        this.g = null;
        this.b = str;
        this.f = drawable;
        if (gVar.d()) {
            gVar.e("RGFollowGuideModel", "update: " + toString());
        }
    }

    public boolean a(int i) {
        int i2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFollowGuideModel", "isShowFollowInfo() remainDist=" + i + ", mIsHighwayExCur2NextGP=" + this.d + ", mDistCur2NextGP=" + this.c + ", " + this.b);
        }
        if (i < 0 || (i2 = this.f8949a) <= 0 || i2 >= RouteGuideParams.sManeuverKindEnum.length || i > 2000) {
            return false;
        }
        if (this.d) {
            int i3 = this.c;
            return i3 >= 0 && i3 <= 300;
        }
        int i4 = this.c;
        return i4 >= 0 && i4 <= 200;
    }

    private int a(HashMap<String, Integer> hashMap) {
        int i;
        String str;
        if (hashMap != null && !hashMap.isEmpty() && (i = this.f8949a) > 0) {
            String[] strArr = RouteGuideParams.sManeuverKindEnum;
            if (i < strArr.length && (str = strArr[i]) != null && hashMap.containsKey(str)) {
                return hashMap.get(strArr[this.f8949a]).intValue();
            }
        }
        return -1;
    }

    public String a() {
        return this.g;
    }

    public void a(boolean z) {
        this.e = z;
    }
}
