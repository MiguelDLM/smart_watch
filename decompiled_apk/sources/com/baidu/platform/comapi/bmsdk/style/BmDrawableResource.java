package com.baidu.platform.comapi.bmsdk.style;

import com.baidu.platform.comapi.bmsdk.BmObject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class BmDrawableResource extends BmObject {
    private static Object b = new Object();
    private static List<WeakReference<BmDrawableResource>> c = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    private a f9584a;

    /* loaded from: classes8.dex */
    public interface a {
    }

    private BmDrawableResource() {
        super(55, 0L);
        this.f9584a = null;
    }

    private static native boolean nativeSetListener(long j, boolean z);

    public BmDrawableResource(int i, long j) {
        super(i, j);
        this.f9584a = null;
    }
}
