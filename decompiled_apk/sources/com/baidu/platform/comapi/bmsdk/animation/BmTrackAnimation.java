package com.baidu.platform.comapi.bmsdk.animation;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class BmTrackAnimation extends BmAnimation {
    private static Object e = new Object();
    private static List<WeakReference<BmTrackAnimation>> f = new ArrayList();
    private a d;

    /* loaded from: classes8.dex */
    public interface a {
    }

    public BmTrackAnimation() {
        super(85, nativeCreate());
        this.d = null;
    }

    private static native long nativeCreate();

    private static native boolean nativeSetTrackEndPos(long j, double d, double d2);

    private static native boolean nativeSetTrackEndRadio(long j, float f2);

    private static native boolean nativeSetTrackLine(long j, long j2);

    private static native boolean nativeSetTrackPath(long j, long j2);

    private static native boolean nativeSetTrackPos(long j, double d, double d2, double d3, double d4);

    private static native boolean nativeSetTrackPosRadio(long j, float f2, float f3);

    private static native boolean nativeSetTrackUpdateListener(long j, boolean z);
}
