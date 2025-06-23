package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;

/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int[] f9835a;
    public int[] b;
    public char[] c;
    public int[] d;

    public c(char[] cArr, int[] iArr) {
        this.c = cArr;
        this.d = iArr;
        this.f9835a = new int[cArr.length];
        this.b = new int[cArr.length];
    }

    public static c b(c cVar, int i) {
        int length = cVar.c.length - i;
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "getTail originLen:" + cVar.c.length);
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "getTail tailLen:" + length);
        int[] iArr = new int[length];
        int[] iArr2 = new int[length];
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + i2;
            iArr[i2] = cVar.f9835a[i3];
            iArr2[i2] = cVar.b[i3];
            cArr[i2] = cVar.c[i3];
        }
        return new c(cArr, iArr, iArr2);
    }

    public c a() {
        int[] iArr = this.f9835a;
        int[] iArr2 = new int[iArr.length];
        int[] iArr3 = new int[iArr.length];
        char[] cArr = new char[iArr.length];
        int[] iArr4 = new int[this.c.length];
        int[] iArr5 = (int[]) iArr.clone();
        int[] iArr6 = (int[]) this.b.clone();
        char[] cArr2 = (char[]) this.c.clone();
        this.d.clone();
        return new c(cArr2, iArr5, iArr6);
    }

    public c(char[] cArr, int[] iArr, int[] iArr2) {
        this.f9835a = iArr;
        this.b = iArr2;
        this.c = cArr;
        this.d = new int[cArr.length];
    }

    public static c a(c cVar, c cVar2) {
        int[] iArr = cVar.f9835a;
        int length = iArr.length;
        int[] iArr2 = cVar2.f9835a;
        int[] iArr3 = new int[length + iArr2.length];
        int[] iArr4 = new int[iArr.length + iArr2.length];
        char[] cArr = new char[iArr.length + iArr2.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr5 = cVar.f9835a;
            if (i2 >= iArr5.length) {
                break;
            }
            iArr3[i2] = iArr5[i2];
            iArr4[i2] = cVar.b[i2];
            cArr[i2] = cVar.c[i2];
            i2++;
        }
        while (true) {
            int[] iArr6 = cVar2.f9835a;
            if (i < iArr6.length) {
                int[] iArr7 = cVar.f9835a;
                iArr3[iArr7.length + i] = iArr6[i];
                iArr4[iArr7.length + i] = cVar2.b[i];
                cArr[iArr7.length + i] = cVar2.c[i];
                i++;
            } else {
                return new c(cArr, iArr3, iArr4);
            }
        }
    }

    public static c a(c cVar, int i) {
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = cVar.f9835a[i2];
            iArr2[i2] = cVar.b[i2];
            cArr[i2] = cVar.c[i2];
        }
        return new c(cArr, iArr, iArr2);
    }
}
