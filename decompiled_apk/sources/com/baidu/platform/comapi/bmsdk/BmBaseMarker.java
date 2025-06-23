package com.baidu.platform.comapi.bmsdk;

import XIXIX.OOXIXo;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.bmsdk.ui.BmRichView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes8.dex */
public abstract class BmBaseMarker extends BmDrawItem {

    /* renamed from: a, reason: collision with root package name */
    private double f9572a;
    private double i;
    private double j;
    private int k;
    private int l;
    private int m;
    private float n;
    private float o;
    private float p;
    private float q;
    private String r;
    private String s;
    private String t;
    private ArrayList<BmRichView> u;

    private BmBaseMarker() {
        super(3, 0L);
        this.f9572a = OOXIXo.f3760XO;
        this.i = OOXIXo.f3760XO;
        this.j = OOXIXo.f3760XO;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0.0f;
        this.o = 1.0f;
        this.p = 1.0f;
        this.q = 1.0f;
        this.r = "";
        this.s = "";
        this.t = "";
        this.u = new ArrayList<>();
    }

    private static native boolean nativeAddRichView(long j, long j2);

    private static native boolean nativeClearRichViews(long j);

    private static native boolean nativeRemoveRichView(long j, long j2);

    private static native boolean nativeSetBuildingId(long j, String str);

    private static native boolean nativeSetCollisionBehavior(long j, int i);

    private static native boolean nativeSetCollisionPriority(long j, short s);

    private static native boolean nativeSetDrawFullscreenMaskFlag(long j, boolean z);

    private static native boolean nativeSetFloorId(long j, String str);

    private static native boolean nativeSetFollowMapRotateAxis(long j, int i);

    private static native boolean nativeSetHeight(long j, int i);

    private static native boolean nativeSetLocated(long j, int i);

    private static native boolean nativeSetOffsetX(long j, int i, int i2);

    private static native boolean nativeSetOffsetY(long j, int i, int i2);

    private static native boolean nativeSetRotate(long j, float f);

    private static native boolean nativeSetRotateFeature(long j, int i);

    private static native boolean nativeSetScale(long j, float f);

    private static native boolean nativeSetScaleX(long j, float f);

    private static native boolean nativeSetScaleY(long j, float f);

    private static native boolean nativeSetTrackBy(long j, int i);

    private static native boolean nativeSetWidth(long j, int i);

    private static native boolean nativeSetX(long j, double d);

    private static native boolean nativeSetXYZ(long j, double d, double d2, double d3);

    private static native boolean nativeSetY(long j, double d);

    private static native boolean nativeSetZ(long j, double d);

    public BmBaseUI a(long j) {
        if (j != 0) {
            Iterator<BmRichView> it = this.u.iterator();
            while (it.hasNext()) {
                BmBaseUI a2 = it.next().a(j);
                if (a2 != null) {
                    return a2;
                }
            }
            return null;
        }
        return null;
    }

    public BmBaseMarker(int i, long j) {
        super(i, j);
        this.f9572a = OOXIXo.f3760XO;
        this.i = OOXIXo.f3760XO;
        this.j = OOXIXo.f3760XO;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0.0f;
        this.o = 1.0f;
        this.p = 1.0f;
        this.q = 1.0f;
        this.r = "";
        this.s = "";
        this.t = "";
        this.u = new ArrayList<>();
    }
}
