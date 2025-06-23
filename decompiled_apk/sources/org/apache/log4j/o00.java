package org.apache.log4j;

import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public class o00 extends OOXIXo {

    /* renamed from: oO, reason: collision with root package name */
    public long f33453oO;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public int f33454x0xO0oo;

    public o00() {
        this.f33453oO = 10485760L;
        this.f33454x0xO0oo = 1;
    }

    public int I0oOoX() {
        return this.f33454x0xO0oo;
    }

    @Override // org.apache.log4j.OOXIXo
    public void XX(Writer writer) {
        this.f33202xoIox = new org.apache.log4j.helpers.I0Io(writer, this.f33162oxoX);
    }

    public void XoX() {
        if (this.f33202xoIox != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("rolling over count=");
            stringBuffer.append(((org.apache.log4j.helpers.I0Io) this.f33202xoIox).II0xO0());
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("maxBackupIndex=");
        stringBuffer2.append(this.f33454x0xO0oo);
        org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer2.toString());
        if (this.f33454x0xO0oo > 0) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(this.f33188oOoXoXO);
            stringBuffer3.append('.');
            stringBuffer3.append(this.f33454x0xO0oo);
            File file = new File(stringBuffer3.toString());
            if (file.exists()) {
                file.delete();
            }
            for (int i = this.f33454x0xO0oo - 1; i >= 1; i--) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append(this.f33188oOoXoXO);
                stringBuffer4.append(FileUtils.FILE_EXTENSION_SEPARATOR);
                stringBuffer4.append(i);
                File file2 = new File(stringBuffer4.toString());
                if (file2.exists()) {
                    StringBuffer stringBuffer5 = new StringBuffer();
                    stringBuffer5.append(this.f33188oOoXoXO);
                    stringBuffer5.append('.');
                    stringBuffer5.append(i + 1);
                    File file3 = new File(stringBuffer5.toString());
                    StringBuffer stringBuffer6 = new StringBuffer();
                    stringBuffer6.append("Renaming file ");
                    stringBuffer6.append(file2);
                    stringBuffer6.append(" to ");
                    stringBuffer6.append(file3);
                    org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer6.toString());
                    file2.renameTo(file3);
                }
            }
            StringBuffer stringBuffer7 = new StringBuffer();
            stringBuffer7.append(this.f33188oOoXoXO);
            stringBuffer7.append(FileUtils.FILE_EXTENSION_SEPARATOR);
            stringBuffer7.append(1);
            File file4 = new File(stringBuffer7.toString());
            oOXoIIIo();
            File file5 = new File(this.f33188oOoXoXO);
            StringBuffer stringBuffer8 = new StringBuffer();
            stringBuffer8.append("Renaming file ");
            stringBuffer8.append(file5);
            stringBuffer8.append(" to ");
            stringBuffer8.append(file4);
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer8.toString());
            file5.renameTo(file4);
        }
        try {
            o0(this.f33188oOoXoXO, false, this.f33189ooOOo0oXI, this.f33190x0XOIxOo);
        } catch (IOException e) {
            StringBuffer stringBuffer9 = new StringBuffer();
            stringBuffer9.append("setFile(");
            stringBuffer9.append(this.f33188oOoXoXO);
            stringBuffer9.append(", false) call failed.");
            org.apache.log4j.helpers.xxIXOIIO.oxoX(stringBuffer9.toString(), e);
        }
    }

    @Override // org.apache.log4j.OOXIXo
    public synchronized void o0(String str, boolean z, boolean z2, int i) throws IOException {
        super.o0(str, z, this.f33189ooOOo0oXI, this.f33190x0XOIxOo);
        if (z) {
            ((org.apache.log4j.helpers.I0Io) this.f33202xoIox).I0Io(new File(str).length());
        }
    }

    @Override // org.apache.log4j.X0IIOO
    public void oo0xXOI0I(LoggingEvent loggingEvent) {
        super.oo0xXOI0I(loggingEvent);
        if (this.f33188oOoXoXO != null && ((org.apache.log4j.helpers.I0Io) this.f33202xoIox).II0xO0() >= this.f33453oO) {
            XoX();
        }
    }

    public void oxXx0IX(int i) {
        this.f33454x0xO0oo = i;
    }

    public long oxxXoxO() {
        return this.f33453oO;
    }

    public void xXOx(long j) {
        this.f33453oO = j;
    }

    public void xo0x(String str) {
        this.f33453oO = org.apache.log4j.helpers.oOoXoXO.OOXIXo(str, this.f33453oO + 1);
    }

    public o00(x0XOIxOo x0xoixoo, String str, boolean z) throws IOException {
        super(x0xoixoo, str, z);
        this.f33453oO = 10485760L;
        this.f33454x0xO0oo = 1;
    }

    public o00(x0XOIxOo x0xoixoo, String str) throws IOException {
        super(x0xoixoo, str);
        this.f33453oO = 10485760L;
        this.f33454x0xO0oo = 1;
    }
}
