package com.baidu.platform.comapi.bmsdk;

import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.bmsdk.ui.BmRichView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes8.dex */
public class Bm3DModel extends BmDrawItem {

    /* renamed from: a, reason: collision with root package name */
    private a f9569a;
    private ArrayList<BmRichView> i;
    private String j;

    public Bm3DModel() {
        super(20, nativeCreate());
        this.i = new ArrayList<>();
        this.j = "";
        this.f9569a = new a();
    }

    private static native boolean nativeAddRichView(long j, long j2);

    private static native boolean nativeClearRichViews(long j);

    private static native long nativeCreate();

    private static native boolean nativeLoad(long j, String str, int i);

    private static native boolean nativeRemoveRichView(long j, long j2);

    private static native boolean nativeSetAlwaysShowFront(long j, boolean z);

    private static native boolean nativeSetBuildingId(long j, String str);

    private static native boolean nativeSetCollisionBehavior(long j, int i);

    private static native boolean nativeSetCollisionPriority(long j, short s);

    private static native boolean nativeSetFloorId(long j, String str);

    private static native boolean nativeSetPosition(long j, double d, double d2, double d3);

    private static native boolean nativeSetRotation(long j, float f, float f2, float f3);

    private static native boolean nativeSetScale(long j, float f);

    private static native boolean nativeSetScaleByLevel(long j, boolean z);

    public BmBaseUI a(long j) {
        if (j != 0) {
            Iterator<BmRichView> it = this.i.iterator();
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
}
