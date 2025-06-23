package org.apache.log4j.lf5.viewer;

import org.apache.log4j.lf5.LogRecord;

/* loaded from: classes6.dex */
public class O0xOxO implements Runnable {

    /* renamed from: Oo, reason: collision with root package name */
    public final /* synthetic */ IoOoX f33383Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final /* synthetic */ LogRecord f33384XO;

    public O0xOxO(IoOoX ioOoX, LogRecord logRecord) {
        this.f33383Oo = ioOoX;
        this.f33384XO = logRecord;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f33383Oo.f33366X0o0xo.I0Io().I0Io(this.f33384XO);
        this.f33383Oo.f33375oxoX.oxoX().oIX0oI(this.f33384XO);
        this.f33383Oo.XXoOx0();
    }
}
