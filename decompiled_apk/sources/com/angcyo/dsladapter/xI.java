package com.angcyo.dsladapter;

import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;

/* loaded from: classes7.dex */
public final class xI {
    public static /* synthetic */ List II0xO0(int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = -1;
        }
        return oIX0oI(i, i2);
    }

    @OXOo.OOXIXo
    public static final List<StackTraceElement> oIX0oI(int i, int i2) {
        int i3;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        kotlin.jvm.internal.IIX0o.oO(stackTrace, "stackTrace");
        ArraysKt___ArraysKt.Xo0xoOxI0(stackTrace);
        int length = (stackTrace.length - 3) - i;
        if (i2 > 0) {
            i3 = length - i2;
        } else {
            i3 = 0;
        }
        return ArraysKt___ArraysKt.OOXOX(stackTrace, X0.IIXOooo.X00xOoXI(i3, length));
    }
}
