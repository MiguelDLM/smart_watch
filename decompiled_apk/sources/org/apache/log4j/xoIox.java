package org.apache.log4j;

/* loaded from: classes6.dex */
public class xoIox extends Thread {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f33506IXxxXO = false;

    /* renamed from: Oo, reason: collision with root package name */
    public org.apache.log4j.helpers.oIX0oI f33507Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public I0Io f33508Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public org.apache.log4j.helpers.II0xO0 f33509XO;

    public xoIox(org.apache.log4j.helpers.II0xO0 iI0xO0, I0Io i0Io) {
        this.f33509XO = iI0xO0;
        this.f33508Oxx0xo = i0Io;
        this.f33507Oo = i0Io.f33128OOXIXo;
        setDaemon(true);
        setPriority(1);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Dispatcher-");
        stringBuffer.append(getName());
        setName(stringBuffer.toString());
    }

    public void oIX0oI() {
        synchronized (this.f33509XO) {
            try {
                this.f33506IXxxXO = true;
                if (this.f33509XO.oxoX() == 0) {
                    this.f33509XO.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        r0 = r3.f33508Oxx0xo.f33128OOXIXo;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
    
        monitor-enter(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        r2 = r3.f33507Oo;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003b, code lost:
    
        if (r2 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
    
        if (r1 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
    
        r2.II0xO0(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0043, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0048, code lost:
    
        throw r1;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r3 = this;
        L0:
            org.apache.log4j.helpers.II0xO0 r0 = r3.f33509XO
            monitor-enter(r0)
            org.apache.log4j.helpers.II0xO0 r1 = r3.f33509XO     // Catch: java.lang.Throwable -> L11
            int r1 = r1.oxoX()     // Catch: java.lang.Throwable -> L11
            if (r1 != 0) goto L20
            boolean r1 = r3.f33506IXxxXO     // Catch: java.lang.Throwable -> L11
            if (r1 == 0) goto L13
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L11
            goto L1a
        L11:
            r1 = move-exception
            goto L49
        L13:
            org.apache.log4j.helpers.II0xO0 r1 = r3.f33509XO     // Catch: java.lang.Throwable -> L11 java.lang.InterruptedException -> L19
            r1.wait()     // Catch: java.lang.Throwable -> L11 java.lang.InterruptedException -> L19
            goto L20
        L19:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L11
        L1a:
            org.apache.log4j.helpers.oIX0oI r0 = r3.f33507Oo
            r0.oO()
            return
        L20:
            org.apache.log4j.helpers.II0xO0 r1 = r3.f33509XO     // Catch: java.lang.Throwable -> L11
            org.apache.log4j.spi.LoggingEvent r1 = r1.oIX0oI()     // Catch: java.lang.Throwable -> L11
            org.apache.log4j.helpers.II0xO0 r2 = r3.f33509XO     // Catch: java.lang.Throwable -> L11
            boolean r2 = r2.xxIXOIIO()     // Catch: java.lang.Throwable -> L11
            if (r2 == 0) goto L33
            org.apache.log4j.helpers.II0xO0 r2 = r3.f33509XO     // Catch: java.lang.Throwable -> L11
            r2.notify()     // Catch: java.lang.Throwable -> L11
        L33:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L11
            org.apache.log4j.I0Io r0 = r3.f33508Oxx0xo
            org.apache.log4j.helpers.oIX0oI r0 = r0.f33128OOXIXo
            monitor-enter(r0)
            org.apache.log4j.helpers.oIX0oI r2 = r3.f33507Oo     // Catch: java.lang.Throwable -> L43
            if (r2 == 0) goto L45
            if (r1 == 0) goto L45
            r2.II0xO0(r1)     // Catch: java.lang.Throwable -> L43
            goto L45
        L43:
            r1 = move-exception
            goto L47
        L45:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L43
            goto L0
        L47:
            monitor-exit(r0)
            throw r1
        L49:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.log4j.xoIox.run():void");
    }
}
