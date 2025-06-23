package org.apache.log4j.lf5;

import org.apache.log4j.lf5.viewer.IoOoX;

/* loaded from: classes6.dex */
public class oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public IoOoX f33342oIX0oI;

    public oIX0oI(IoOoX ioOoX) {
        this.f33342oIX0oI = ioOoX;
    }

    public void finalize() throws Throwable {
        System.out.println("Disposing of the default LogBrokerMonitor instance");
        this.f33342oIX0oI.xII();
    }
}
