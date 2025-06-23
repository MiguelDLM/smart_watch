package com.baidu.navisdk.framework.vmsr;

import com.baidu.navisdk.util.common.LogUtil;
import java.util.Arrays;
import java.util.Random;

/* loaded from: classes7.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public q f6852a;
    public a b;
    public a c;
    public g d;
    public float e;
    public float f;
    private e g;

    public o(q qVar, f fVar) throws Exception {
        this(qVar, fVar, null);
    }

    private float b() {
        return a(this.f6852a.d);
    }

    private void d() {
        int i = this.f6852a.f;
        this.g.b = new float[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.g.b[i2] = b();
        }
        int i3 = this.f6852a.g;
        this.g.d = new float[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            this.g.d[i4] = c();
        }
    }

    public float[] a() {
        e eVar = this.g;
        return a(eVar.b, eVar.d);
    }

    public void c(float[] fArr) throws Exception {
        int length = fArr.length;
        q qVar = this.f6852a;
        int i = qVar.f;
        if (length == qVar.g + i) {
            this.g.b = Arrays.copyOf(fArr, i);
            this.g.d = Arrays.copyOfRange(fArr, i, fArr.length);
            return;
        }
        throw new Exception("Invalid number of weights provided: (weights.count). Expected: (structure.numHiddenWeights + structure.numOutputWeights).");
    }

    public o(q qVar, f fVar, float[] fArr) throws Exception {
        this.f6852a = qVar;
        this.b = fVar.f6841a;
        this.c = fVar.b;
        this.d = fVar.c;
        this.e = fVar.e;
        this.f = 0.0f;
        this.g = new e(qVar, fVar);
        if (fArr != null) {
            c(fArr);
        } else {
            d();
        }
    }

    public static float[] a(float[] fArr, float[] fArr2) {
        float[] copyOf = Arrays.copyOf(fArr, fArr.length + fArr2.length);
        System.arraycopy(fArr2, 0, copyOf, fArr.length, fArr2.length);
        return copyOf;
    }

    public float[] b(float[] fArr) throws Exception {
        int length = fArr.length;
        q qVar = this.f6852a;
        if (length == qVar.f6853a) {
            this.g.h[0] = 1.0f;
            int i = qVar.d;
            for (int i2 = 1; i2 < i; i2++) {
                this.g.h[i2] = fArr[i2 - 1];
            }
            e eVar = this.g;
            float[] fArr2 = eVar.b;
            float[] fArr3 = eVar.h;
            float[] fArr4 = eVar.i;
            q qVar2 = this.f6852a;
            i.a(fArr2, 1, fArr3, 1, fArr4, 1, qVar2.b, 1, qVar2.d);
            for (int i3 = this.f6852a.b; i3 > 0; i3--) {
                float[] fArr5 = this.g.i;
                fArr5[i3] = this.b.a(Float.valueOf(fArr5[i3 - 1]));
            }
            e eVar2 = this.g;
            float[] fArr6 = eVar2.i;
            fArr6[0] = 1.0f;
            float[] fArr7 = eVar2.d;
            float[] fArr8 = eVar2.j;
            q qVar3 = this.f6852a;
            i.a(fArr7, 1, fArr6, 1, fArr8, 1, qVar3.c, 1, qVar3.e);
            int i4 = this.f6852a.c;
            for (int i5 = 0; i5 < i4; i5++) {
                float[] fArr9 = this.g.j;
                fArr9[i5] = this.c.a(Float.valueOf(fArr9[i5]));
            }
            return this.g.j;
        }
        throw new Exception("Invalid number of inputs provided: (inputs.count). Expected: (structure.inputs).");
    }

    private float a(int i) {
        int sqrt = (int) ((1.0d / Math.sqrt(i)) * 2000000.0d);
        return (new Random().nextInt(sqrt) - (sqrt / 2)) / 1000000.0f;
    }

    private float c() {
        return a(this.f6852a.e);
    }

    public void a(float[] fArr) throws Exception {
        int i;
        if (fArr.length == this.f6852a.c) {
            int length = this.g.j.length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                e eVar = this.g;
                eVar.l[i3] = this.c.a(eVar.j[i3]) * this.d.a(Float.valueOf(this.g.j[i3]), Float.valueOf(fArr[i3]));
            }
            e eVar2 = this.g;
            float[] fArr2 = eVar2.l;
            float[] fArr3 = eVar2.d;
            float[] fArr4 = eVar2.m;
            q qVar = this.f6852a;
            i.a(fArr2, 1, fArr3, 1, fArr4, 1, 1, qVar.e, qVar.c);
            int length2 = this.g.m.length;
            for (int i4 = 0; i4 < length2; i4++) {
                e eVar3 = this.g;
                eVar3.k[i4] = this.b.a(eVar3.i[i4]) * this.g.m[i4];
            }
            int i5 = 0;
            while (true) {
                i = this.f6852a.g;
                if (i5 >= i) {
                    break;
                }
                e eVar4 = this.g;
                int i6 = eVar4.n[i5];
                int i7 = eVar4.o[i5];
                float[] fArr5 = eVar4.g;
                float f = eVar4.d[i5];
                fArr5[i5] = (f - ((eVar4.f6840a * eVar4.l[i6]) * eVar4.i[i7])) + (this.e * (f - eVar4.e[i5]));
                i5++;
            }
            e eVar5 = this.g;
            i.a(eVar5.d, eVar5.e, 1, i, 1, 1);
            e eVar6 = this.g;
            i.a(eVar6.g, eVar6.d, 1, this.f6852a.g, 1, 1);
            while (true) {
                int i8 = this.f6852a.f;
                if (i2 < i8) {
                    e eVar7 = this.g;
                    int i9 = eVar7.p[i2];
                    int i10 = eVar7.q[i2];
                    float[] fArr6 = eVar7.f;
                    float f2 = eVar7.b[i2];
                    fArr6[i2] = (f2 - ((eVar7.f6840a * eVar7.k[i9 + 1]) * eVar7.h[i10])) + (this.e * (f2 - eVar7.c[i2]));
                    i2++;
                } else {
                    e eVar8 = this.g;
                    i.a(eVar8.b, eVar8.c, 1, i8, 1, 1);
                    e eVar9 = this.g;
                    i.a(eVar9.f, eVar9.b, 1, this.f6852a.f, 1, 1);
                    return;
                }
            }
        } else {
            throw new Exception("Invalid number of labels provided: (labels.count). Expected: (structure.outputs).");
        }
    }

    public float[] a(h hVar, float f, int i) throws Exception {
        if (f > 0.0f) {
            while (true) {
                int length = hVar.f6843a.length;
                for (int i2 = 0; i2 < length; i2++) {
                    b(hVar.f6843a[i2]);
                    a(hVar.b[i2]);
                }
                int length2 = hVar.c.length;
                float f2 = 0.0f;
                for (int i3 = 0; i3 < length2; i3++) {
                    f2 += this.d.a(b(hVar.c[i3]), hVar.d[i3]);
                }
                float length3 = f2 / hVar.c.length;
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("Vmsr", "error:" + length3);
                }
                this.f = length3;
                int i4 = (length3 >= f && i4 < i) ? i4 + 1 : 0;
            }
            return a();
        }
        throw new Exception("Training error threshold must be greater than zero.");
    }
}
