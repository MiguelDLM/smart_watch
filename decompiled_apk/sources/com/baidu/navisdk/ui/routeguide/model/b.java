package com.baidu.navisdk.ui.routeguide.model;

import android.graphics.Bitmap;
import com.baidu.mobads.sdk.internal.cn;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.text.DecimalFormat;

/* loaded from: classes8.dex */
public class b {
    private static long h;

    /* renamed from: a, reason: collision with root package name */
    private long f8929a;
    private int b;
    private String c;
    private long d;
    private long e;
    private int f;
    private Bitmap g;

    private long i() {
        String currentUUID = JNITrajectoryControl.sInstance.getCurrentUUID();
        if (currentUUID != null && currentUUID.length() > 0) {
            return JNITrajectoryControl.sInstance.getTrajectoryLength(currentUUID);
        }
        return 0L;
    }

    private String j() {
        String str;
        long currentTimeMillis = System.currentTimeMillis() - h;
        if (currentTimeMillis <= 0) {
            this.f8929a = 0L;
            return "00:00:00.000";
        }
        int i = (int) (currentTimeMillis / 1000);
        int i2 = i / 60;
        this.f8929a = i;
        if (i < 60) {
            str = "00:00:" + a(i);
        } else if (i2 < 60) {
            str = "00:" + a(i2) + ":" + a(i % 60);
        } else {
            int i3 = i2 / 60;
            int i4 = i2 % 60;
            str = a(i3) + ":" + a(i4) + ":" + a((i - (i3 * 3600)) - (i4 * 60));
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveReminderModel - DestRemind", "timeStr = " + str);
        }
        return str;
    }

    public String a() {
        String str;
        long j = this.d;
        if (j > 0) {
            float f = (((float) j) * 1.0f) / 1000.0f;
            if (f >= 100.0f) {
                str = ((int) f) + "";
            } else {
                str = new DecimalFormat(cn.d).format(f);
                if (str.endsWith(".0")) {
                    str = str.substring(0, str.indexOf(FileUtils.FILE_EXTENSION_SEPARATOR));
                }
            }
        } else {
            str = "0.1";
        }
        return str.equals("0") ? "0.1" : str;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.f;
    }

    public String d() {
        return this.c;
    }

    public Bitmap e() {
        return this.g;
    }

    public void f() {
        this.e = i();
        h = System.currentTimeMillis();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveReminderModel - DestRemind", "naviStarted! mStartNaviTravelDistance = " + this.e);
        }
    }

    public void g() {
        long i = i();
        this.d = i - this.e;
        this.c = j();
        if (this.d > 0) {
            if (this.f8929a > 0) {
                this.b = (int) Math.round(((((float) r2) * 1.0f) / ((float) r6)) * 3.6d);
            }
        }
        int i2 = this.b;
        if (i2 <= 0) {
            i2 = 1;
        }
        this.b = i2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveReminderModel - DestRemind", "notifiViaArrive -> curDesitence = " + i + ", mAleadyTravelDistance = " + this.d + ", mConsumptionTimeString = " + this.c + ", mAverageSpeed = " + this.b);
        }
    }

    public void h() {
        Bitmap bitmap = this.g;
        if (bitmap != null) {
            if (com.baidu.navisdk.k.f6861a && !bitmap.isRecycled()) {
                this.g.recycle();
            }
            this.g = null;
        }
    }

    public static String a(int i) {
        if (i >= 0 && i < 10) {
            return "0" + Integer.toString(i);
        }
        return "" + i;
    }

    public com.baidu.navisdk.module.nearbysearch.model.a a(RoutePlanNode routePlanNode) {
        return com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.a(routePlanNode.getName(), routePlanNode.getGeoPoint());
    }

    public void a(Bitmap bitmap) {
        this.g = bitmap;
    }
}
