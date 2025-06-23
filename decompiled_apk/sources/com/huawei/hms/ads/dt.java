package com.huawei.hms.ads;

import android.graphics.Bitmap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class dt {
    int Code;
    int I;
    Bitmap V;

    public dt() {
    }

    public dt Code() {
        dt dtVar = new dt();
        dtVar.Code = this.Code;
        dtVar.I = this.I;
        return dtVar;
    }

    public String toString() {
        return "GifFrame{frameIndex=" + this.Code + ", delay=" + this.I + '}';
    }

    public dt(int i, Bitmap bitmap, int i2) {
        this.Code = i;
        this.V = bitmap;
        this.I = i2;
    }
}
