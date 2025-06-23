package org.apache.log4j.helpers;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes6.dex */
public class I0Io extends oO {

    /* renamed from: Oo, reason: collision with root package name */
    public long f33230Oo;

    public I0Io(Writer writer, org.apache.log4j.spi.X0o0xo x0o0xo) {
        super(writer, x0o0xo);
    }

    public void I0Io(long j) {
        this.f33230Oo = j;
    }

    public long II0xO0() {
        return this.f33230Oo;
    }

    @Override // org.apache.log4j.helpers.oO, java.io.Writer
    public void write(String str) {
        try {
            ((FilterWriter) this).out.write(str);
            this.f33230Oo += str.length();
        } catch (IOException e) {
            this.f33274XO.OxxIIOOXO("Write failure.", e, 1);
        }
    }
}
