package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes10.dex */
public final /* synthetic */ class oxoX {
    public static /* synthetic */ boolean oIX0oI(AtomicReferenceArray atomicReferenceArray, int i, Object obj, Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i, obj, obj2)) {
            if (atomicReferenceArray.get(i) != obj) {
                return false;
            }
        }
        return true;
    }
}
