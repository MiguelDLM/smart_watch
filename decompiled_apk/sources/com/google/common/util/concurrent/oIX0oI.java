package com.google.common.util.concurrent;

import sun.misc.Unsafe;

/* loaded from: classes10.dex */
public final /* synthetic */ class oIX0oI {
    public static /* synthetic */ boolean oIX0oI(Unsafe unsafe, Object obj, long j, Object obj2, Object obj3) {
        while (!unsafe.compareAndSwapObject(obj, j, obj2, obj3)) {
            if (unsafe.getObject(obj, j) != obj2) {
                return false;
            }
        }
        return true;
    }
}
