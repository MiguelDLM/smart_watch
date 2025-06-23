package org.apache.log4j;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public class X0IIOO extends II0xO0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public boolean f33201II0XooXoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public org.apache.log4j.helpers.oO f33202xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public String f33203xxIXOIIO;

    public X0IIOO() {
        this.f33201II0XooXoX = true;
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.oIX0oI
    public synchronized void I0Io(org.apache.log4j.spi.X0o0xo x0o0xo) {
        try {
            if (x0o0xo == null) {
                org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO("You have tried to set a null error-handler.");
            } else {
                this.f33162oxoX = x0o0xo;
                org.apache.log4j.helpers.oO oOVar = this.f33202xoIox;
                if (oOVar != null) {
                    oOVar.oIX0oI(x0o0xo);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void IIX0o(String str) {
        this.f33203xxIXOIIO = str;
    }

    @Override // org.apache.log4j.II0xO0
    public void IIXOooo(LoggingEvent loggingEvent) {
        if (!X0IIOO()) {
            return;
        }
        oo0xXOI0I(loggingEvent);
    }

    public void IoOoX() {
        String X0o0xo2;
        org.apache.log4j.helpers.oO oOVar;
        x0XOIxOo x0xoixoo = this.f33161oIX0oI;
        if (x0xoixoo != null && (X0o0xo2 = x0xoixoo.X0o0xo()) != null && (oOVar = this.f33202xoIox) != null) {
            oOVar.write(X0o0xo2);
        }
    }

    public boolean X0IIOO() {
        if (this.f33158Oxx0IOOO) {
            org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO("Not allowed to write to a closed appender.");
            return false;
        }
        if (this.f33202xoIox == null) {
            org.apache.log4j.spi.X0o0xo x0o0xo = this.f33162oxoX;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("No output stream or file set for the appender named [");
            stringBuffer.append(this.f33157II0xO0);
            stringBuffer.append("].");
            x0o0xo.error(stringBuffer.toString());
            return false;
        }
        if (this.f33161oIX0oI == null) {
            org.apache.log4j.spi.X0o0xo x0o0xo2 = this.f33162oxoX;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("No layout set for the appender named [");
            stringBuffer2.append(this.f33157II0xO0);
            stringBuffer2.append("].");
            x0o0xo2.error(stringBuffer2.toString());
            return false;
        }
        return true;
    }

    public void XI0IXoo() {
        org.apache.log4j.helpers.oO oOVar = this.f33202xoIox;
        if (oOVar != null) {
            try {
                oOVar.close();
            } catch (IOException e) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Could not close ");
                stringBuffer.append(this.f33202xoIox);
                org.apache.log4j.helpers.xxIXOIIO.oxoX(stringBuffer.toString(), e);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.io.OutputStreamWriter XIxXXX0x0(java.io.OutputStream r3) {
        /*
            r2 = this;
            java.lang.String r0 = r2.xxX()
            if (r0 == 0) goto L16
            java.io.OutputStreamWriter r1 = new java.io.OutputStreamWriter     // Catch: java.io.IOException -> Lc
            r1.<init>(r3, r0)     // Catch: java.io.IOException -> Lc
            goto L17
        Lc:
            java.lang.String r0 = "Error initializing output writer."
            org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO(r0)
            java.lang.String r0 = "Unsupported encoding?"
            org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO(r0)
        L16:
            r1 = 0
        L17:
            if (r1 != 0) goto L1e
            java.io.OutputStreamWriter r1 = new java.io.OutputStreamWriter
            r1.<init>(r3)
        L1e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.log4j.X0IIOO.XIxXXX0x0(java.io.OutputStream):java.io.OutputStreamWriter");
    }

    public boolean XxX0x0xxx() {
        return this.f33201II0XooXoX;
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.oIX0oI
    public synchronized void close() {
        if (this.f33158Oxx0IOOO) {
            return;
        }
        this.f33158Oxx0IOOO = true;
        oo();
        xXxxox0I();
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.spi.OOXIXo
    public void oI0IIXIo() {
    }

    public void oo() {
        String oxoX2;
        org.apache.log4j.helpers.oO oOVar;
        x0XOIxOo x0xoixoo = this.f33161oIX0oI;
        if (x0xoixoo != null && (oxoX2 = x0xoixoo.oxoX()) != null && (oOVar = this.f33202xoIox) != null) {
            oOVar.write(oxoX2);
            this.f33202xoIox.flush();
        }
    }

    public void oo0xXOI0I(LoggingEvent loggingEvent) {
        String[] throwableStrRep;
        this.f33202xoIox.write(this.f33161oIX0oI.oIX0oI(loggingEvent));
        if (this.f33161oIX0oI.Oxx0IOOO() && (throwableStrRep = loggingEvent.getThrowableStrRep()) != null) {
            for (String str : throwableStrRep) {
                this.f33202xoIox.write(str);
                this.f33202xoIox.write(x0XOIxOo.f33503oIX0oI);
            }
        }
        if (this.f33201II0XooXoX) {
            this.f33202xoIox.flush();
        }
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.oIX0oI
    public boolean ooOOo0oXI() {
        return true;
    }

    public void ooXIXxIX(boolean z) {
        this.f33201II0XooXoX = z;
    }

    public synchronized void xI(Writer writer) {
        xXxxox0I();
        this.f33202xoIox = new org.apache.log4j.helpers.oO(writer, this.f33162oxoX);
        IoOoX();
    }

    public void xXxxox0I() {
        XI0IXoo();
        this.f33202xoIox = null;
    }

    public String xxX() {
        return this.f33203xxIXOIIO;
    }

    public X0IIOO(x0XOIxOo x0xoixoo, OutputStream outputStream) {
        this(x0xoixoo, new OutputStreamWriter(outputStream));
    }

    public X0IIOO(x0XOIxOo x0xoixoo, Writer writer) {
        this.f33201II0XooXoX = true;
        this.f33161oIX0oI = x0xoixoo;
        xI(writer);
    }
}
