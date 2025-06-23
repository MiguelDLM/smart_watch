package com.baidu.navisdk.framework.vmsr;

/* loaded from: classes7.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public float[][] f6843a;
    public float[][] b;
    public float[][] c;
    public float[][] d;

    public h(float[][] fArr, float[][] fArr2, float[][] fArr3, float[][] fArr4, q qVar) throws Exception {
        if (fArr.length == fArr2.length && fArr3.length == fArr4.length) {
            this.f6843a = fArr;
            this.b = fArr2;
            this.c = fArr3;
            this.d = fArr4;
            return;
        }
        throw new Exception("The number of input sets provided for training/validation must equal the number of answer sets provided.");
    }
}
