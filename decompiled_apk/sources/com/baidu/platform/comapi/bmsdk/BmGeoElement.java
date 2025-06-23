package com.baidu.platform.comapi.bmsdk;

import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class BmGeoElement extends BmObject {

    /* renamed from: a, reason: collision with root package name */
    private final int f9574a;
    private BmLineStyle b;
    private List<b> c;
    private String d;
    private int e;

    public BmGeoElement() {
        super(70, nativeCreate(0));
        this.c = new ArrayList();
        this.f9574a = 0;
    }

    private static native boolean nativeAddPoint(long j, double d, double d2, double d3);

    private static native boolean nativeAddStyleOption(long j, long j2);

    private static native boolean nativeClearGradientColors(long j);

    private static native long nativeCreate(int i);

    private static native boolean nativeDelGradientColors(long j, int i);

    private static native boolean nativeRemoveStyleOption(long j, long j2);

    private static native boolean nativeSetCoordChainHandle(long j, long j2);

    private static native boolean nativeSetCoordChainType(long j, int i);

    private static native boolean nativeSetGradientColors(long j, int i, int[] iArr, int i2);

    private static native boolean nativeSetPoints(long j, double[] dArr, int i, int i2);

    private static native boolean nativeSetStyle(long j, long j2);

    public boolean a(BmLineStyle bmLineStyle) {
        this.b = bmLineStyle;
        return nativeSetStyle(this.g, bmLineStyle.e());
    }

    public boolean a(List<b> list) {
        double[] dArr;
        this.c.clear();
        this.c.addAll(list);
        int i = 0;
        if (list == null || list.size() <= 0) {
            dArr = null;
        } else {
            int size = list.size() * 2;
            dArr = new double[size];
            while (i < list.size()) {
                int i2 = i * 2;
                dArr[i2] = list.get(i).f9581a;
                dArr[i2 + 1] = list.get(i).b;
                i++;
            }
            i = size;
        }
        return nativeSetPoints(this.g, dArr, i, 2);
    }

    public BmGeoElement(int i) {
        super(70, nativeCreate(i));
        this.c = new ArrayList();
        this.f9574a = i;
    }

    public void a(String str) {
        this.d = str;
    }

    public String a() {
        return this.d;
    }

    public void a(int i) {
        this.e = i;
    }

    public boolean a(int i, List<Integer> list) {
        int[] iArr;
        int i2 = 0;
        if (list == null || list.size() <= 0) {
            iArr = null;
        } else {
            iArr = new int[list.size()];
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                iArr[i2] = com.baidu.platform.comapi.bmsdk.style.a.a(it.next().intValue());
                i2++;
            }
        }
        return nativeSetGradientColors(this.g, i, iArr, i2);
    }
}
