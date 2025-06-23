package org.apache.log4j.helpers;

import java.io.Writer;

/* loaded from: classes6.dex */
public class x0xO0oo extends oO {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f33328IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public int f33329Oo;

    public x0xO0oo(Writer writer, int i, org.apache.log4j.spi.X0o0xo x0o0xo) {
        super(writer, x0o0xo);
        this.f33329Oo = i;
    }

    public void I0Io(int i) {
        this.f33329Oo = i;
    }

    public void II0xO0(int i) {
        this.f33328IXxxXO = i;
    }

    @Override // org.apache.log4j.helpers.oO, java.io.Writer
    public void write(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<");
        stringBuffer.append(this.f33329Oo | this.f33328IXxxXO);
        stringBuffer.append(">");
        stringBuffer.append(str);
        super.write(stringBuffer.toString());
    }
}
