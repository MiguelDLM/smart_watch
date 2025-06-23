package org.apache.log4j.helpers;

import java.io.File;

/* loaded from: classes6.dex */
public abstract class XO extends Thread {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final long f33261IIXOooo = 60000;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public File f33262IXxxXO;

    /* renamed from: XO, reason: collision with root package name */
    public String f33266XO;

    /* renamed from: Oo, reason: collision with root package name */
    public long f33263Oo = 60000;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public long f33264Oxx0xo = 0;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public boolean f33267oI0IIXIo = false;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f33265OxxIIOOXO = false;

    public XO(String str) {
        this.f33266XO = str;
        this.f33262IXxxXO = new File(str);
        setDaemon(true);
        oIX0oI();
    }

    public void I0Io(long j) {
        this.f33263Oo = j;
    }

    public abstract void II0xO0();

    public void oIX0oI() {
        try {
            if (this.f33262IXxxXO.exists()) {
                long lastModified = this.f33262IXxxXO.lastModified();
                if (lastModified > this.f33264Oxx0xo) {
                    this.f33264Oxx0xo = lastModified;
                    II0xO0();
                    this.f33267oI0IIXIo = false;
                    return;
                }
                return;
            }
            if (!this.f33267oI0IIXIo) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("[");
                stringBuffer.append(this.f33266XO);
                stringBuffer.append("] does not exist.");
                xxIXOIIO.oIX0oI(stringBuffer.toString());
                this.f33267oI0IIXIo = true;
            }
        } catch (SecurityException unused) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Was not allowed to read check file existance, file:[");
            stringBuffer2.append(this.f33266XO);
            stringBuffer2.append("].");
            xxIXOIIO.Oxx0IOOO(stringBuffer2.toString());
            this.f33265OxxIIOOXO = true;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (!this.f33265OxxIIOOXO) {
            try {
                Thread.currentThread();
                Thread.sleep(this.f33263Oo);
            } catch (InterruptedException unused) {
            }
            oIX0oI();
        }
    }
}
