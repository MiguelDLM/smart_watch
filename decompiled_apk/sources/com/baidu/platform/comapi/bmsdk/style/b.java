package com.baidu.platform.comapi.bmsdk.style;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int[] f9588a = new int[4];
    public int[] b;
    public int[] c;
    public int[] d;

    private static void a(int[] iArr, ByteBuffer byteBuffer) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = byteBuffer.getInt();
        }
    }

    private static void a(int i) {
        if (i == 0 || (i & 1) != 0) {
            throw new RuntimeException("invalid nine-patch: " + i);
        }
    }

    public static b a(byte[] bArr) {
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.nativeOrder());
        if (order.get() == 0) {
            return null;
        }
        b bVar = new b();
        bVar.b = new int[order.get()];
        bVar.c = new int[order.get()];
        bVar.d = new int[order.get()];
        a(bVar.b.length);
        a(bVar.c.length);
        order.getInt();
        order.getInt();
        bVar.f9588a[0] = order.getInt();
        bVar.f9588a[1] = order.getInt();
        bVar.f9588a[2] = order.getInt();
        bVar.f9588a[3] = order.getInt();
        order.getInt();
        a(bVar.b, order);
        a(bVar.c, order);
        a(bVar.d, order);
        return bVar;
    }
}
