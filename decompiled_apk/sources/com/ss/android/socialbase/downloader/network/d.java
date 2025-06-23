package com.ss.android.socialbase.downloader.network;

import XIXIX.OOXIXo;

/* loaded from: classes13.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private final double f26414a;
    private final int b;
    private double c = -1.0d;
    private int d;

    public d(double d) {
        int ceil;
        this.f26414a = d;
        if (d == OOXIXo.f3760XO) {
            ceil = Integer.MAX_VALUE;
        } else {
            ceil = (int) Math.ceil(1.0d / d);
        }
        this.b = ceil;
    }

    public void a(double d) {
        double d2 = 1.0d - this.f26414a;
        int i = this.d;
        if (i > this.b) {
            this.c = Math.exp((d2 * Math.log(this.c)) + (this.f26414a * Math.log(d)));
        } else if (i > 0) {
            double d3 = (d2 * i) / (i + 1.0d);
            this.c = Math.exp((d3 * Math.log(this.c)) + ((1.0d - d3) * Math.log(d)));
        } else {
            this.c = d;
        }
        this.d++;
    }

    public double a() {
        return this.c;
    }
}
