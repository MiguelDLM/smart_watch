package org.apache.log4j.helpers;

/* loaded from: classes6.dex */
public class Oxx0IOOO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f33251oIX0oI = -1;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f33250II0xO0 = Integer.MAX_VALUE;

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f33249I0Io = false;

    public void II0xO0() {
        this.f33251oIX0oI = -1;
        this.f33250II0xO0 = Integer.MAX_VALUE;
        this.f33249I0Io = false;
    }

    public void oIX0oI() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("min=");
        stringBuffer.append(this.f33251oIX0oI);
        stringBuffer.append(", max=");
        stringBuffer.append(this.f33250II0xO0);
        stringBuffer.append(", leftAlign=");
        stringBuffer.append(this.f33249I0Io);
        xxIXOIIO.oIX0oI(stringBuffer.toString());
    }
}
