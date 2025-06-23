package com.baidu.platform.comapi.wnplatform.arclayout;

import android.graphics.Path;
import com.baidu.platform.comapi.wnplatform.arclayout.a.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class a implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArcLayout f9890a;

    public a(ArcLayout arcLayout) {
        this.f9890a = arcLayout;
    }

    @Override // com.baidu.platform.comapi.wnplatform.arclayout.a.b.a
    public boolean a() {
        return false;
    }

    @Override // com.baidu.platform.comapi.wnplatform.arclayout.a.b.a
    public Path a(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        Path path = new Path();
        i3 = this.f9890a.cropDirection;
        boolean z = i3 == 1;
        i4 = this.f9890a.arcPosition;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 == 4) {
                        if (z) {
                            path.moveTo(0.0f, 0.0f);
                            float f = i;
                            path.lineTo(f, 0.0f);
                            i19 = this.f9890a.arcHeight;
                            float f2 = i - (i19 * 2);
                            float f3 = i2 / 2;
                            float f4 = i2;
                            path.quadTo(f2, f3, f, f4);
                            path.lineTo(0.0f, f4);
                            path.close();
                        } else {
                            path.moveTo(0.0f, 0.0f);
                            i16 = this.f9890a.arcHeight;
                            path.lineTo(i - i16, 0.0f);
                            i17 = this.f9890a.arcHeight;
                            i18 = this.f9890a.arcHeight;
                            float f5 = i2;
                            path.quadTo(i17 + i, i2 / 2, i - i18, f5);
                            path.lineTo(0.0f, f5);
                            path.close();
                        }
                    }
                } else if (z) {
                    float f6 = i;
                    path.moveTo(f6, 0.0f);
                    path.lineTo(0.0f, 0.0f);
                    i15 = this.f9890a.arcHeight;
                    float f7 = i2 / 2;
                    float f8 = i2;
                    path.quadTo(i15 * 2, f7, 0.0f, f8);
                    path.lineTo(f6, f8);
                    path.close();
                } else {
                    float f9 = i;
                    path.moveTo(f9, 0.0f);
                    i12 = this.f9890a.arcHeight;
                    path.lineTo(i12, 0.0f);
                    i13 = this.f9890a.arcHeight;
                    i14 = this.f9890a.arcHeight;
                    float f10 = i2;
                    path.quadTo(-i13, i2 / 2, i14, f10);
                    path.lineTo(f9, f10);
                    path.close();
                }
            } else if (!z) {
                i9 = this.f9890a.arcHeight;
                path.moveTo(0.0f, i9);
                i10 = this.f9890a.arcHeight;
                float f11 = i;
                i11 = this.f9890a.arcHeight;
                path.quadTo(i / 2, -i10, f11, i11);
                float f12 = i2;
                path.lineTo(f11, f12);
                path.lineTo(0.0f, f12);
                path.close();
            }
        } else if (z) {
            path.moveTo(0.0f, 0.0f);
            float f13 = i2;
            path.lineTo(0.0f, f13);
            i8 = this.f9890a.arcHeight;
            float f14 = i;
            path.quadTo(i / 2, i2 - (i8 * 2), f14, f13);
            path.lineTo(f14, 0.0f);
            path.close();
        } else {
            path.moveTo(0.0f, 0.0f);
            i5 = this.f9890a.arcHeight;
            path.lineTo(0.0f, i2 - i5);
            i6 = this.f9890a.arcHeight;
            float f15 = i;
            i7 = this.f9890a.arcHeight;
            path.quadTo(i / 2, i6 + i2, f15, i2 - i7);
            path.lineTo(f15, 0.0f);
            path.close();
        }
        return path;
    }
}
