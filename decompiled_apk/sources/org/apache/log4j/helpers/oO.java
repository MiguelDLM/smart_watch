package org.apache.log4j.helpers;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes6.dex */
public class oO extends FilterWriter {

    /* renamed from: XO, reason: collision with root package name */
    public org.apache.log4j.spi.X0o0xo f33274XO;

    public oO(Writer writer, org.apache.log4j.spi.X0o0xo x0o0xo) {
        super(writer);
        oIX0oI(x0o0xo);
    }

    @Override // java.io.FilterWriter, java.io.Writer, java.io.Flushable
    public void flush() {
        try {
            ((FilterWriter) this).out.flush();
        } catch (IOException e) {
            this.f33274XO.OxxIIOOXO("Failed to flush writer,", e, 2);
        }
    }

    public void oIX0oI(org.apache.log4j.spi.X0o0xo x0o0xo) {
        if (x0o0xo != null) {
            this.f33274XO = x0o0xo;
            return;
        }
        throw new IllegalArgumentException("Attempted to set null ErrorHandler.");
    }

    @Override // java.io.Writer
    public void write(String str) {
        try {
            ((FilterWriter) this).out.write(str);
        } catch (IOException e) {
            org.apache.log4j.spi.X0o0xo x0o0xo = this.f33274XO;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Failed to write [");
            stringBuffer.append(str);
            stringBuffer.append("].");
            x0o0xo.OxxIIOOXO(stringBuffer.toString(), e, 1);
        }
    }
}
