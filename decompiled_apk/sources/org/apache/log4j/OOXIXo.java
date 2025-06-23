package org.apache.log4j;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes6.dex */
public class OOXIXo extends X0IIOO {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public boolean f33187OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public String f33188oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public boolean f33189ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public int f33190x0XOIxOo;

    public OOXIXo() {
        this.f33187OOXIXo = true;
        this.f33188oOoXoXO = null;
        this.f33189ooOOo0oXI = false;
        this.f33190x0XOIxOo = 8192;
    }

    public boolean IO() {
        return this.f33189ooOOo0oXI;
    }

    public void Io(String str) {
        this.f33188oOoXoXO = str.trim();
    }

    public void OI0(boolean z) {
        this.f33189ooOOo0oXI = z;
        if (z) {
            this.f33201II0XooXoX = false;
        }
    }

    public int X00IoxXI() {
        return this.f33190x0XOIxOo;
    }

    public void XOxIOxOx(int i) {
        this.f33190x0XOIxOo = i;
    }

    public void XX(Writer writer) {
        this.f33202xoIox = new org.apache.log4j.helpers.oO(writer, this.f33162oxoX);
    }

    public boolean Xx000oIo() {
        return this.f33187OOXIXo;
    }

    public synchronized void o0(String str, boolean z, boolean z2, int i) throws IOException {
        FileOutputStream fileOutputStream;
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("setFile called: ");
            stringBuffer.append(str);
            stringBuffer.append(", ");
            stringBuffer.append(z);
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
            if (z2) {
                ooXIXxIX(false);
            }
            xXxxox0I();
            try {
                fileOutputStream = new FileOutputStream(str, z);
            } catch (FileNotFoundException e) {
                String parent = new File(str).getParent();
                if (parent != null) {
                    File file = new File(parent);
                    if (!file.exists() && file.mkdirs()) {
                        fileOutputStream = new FileOutputStream(str, z);
                    } else {
                        throw e;
                    }
                } else {
                    throw e;
                }
            }
            Writer XIxXXX0x02 = XIxXXX0x0(fileOutputStream);
            if (z2) {
                XIxXXX0x02 = new BufferedWriter(XIxXXX0x02, i);
            }
            XX(XIxXXX0x02);
            this.f33188oOoXoXO = str;
            this.f33187OOXIXo = z;
            this.f33189ooOOo0oXI = z2;
            this.f33190x0XOIxOo = i;
            IoOoX();
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI("setFile ended");
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.apache.log4j.X0IIOO, org.apache.log4j.II0xO0, org.apache.log4j.spi.OOXIXo
    public void oI0IIXIo() {
        String str = this.f33188oOoXoXO;
        if (str != null) {
            try {
                o0(str, this.f33187OOXIXo, this.f33189ooOOo0oXI, this.f33190x0XOIxOo);
                return;
            } catch (IOException e) {
                org.apache.log4j.spi.X0o0xo x0o0xo = this.f33162oxoX;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("setFile(");
                stringBuffer.append(this.f33188oOoXoXO);
                stringBuffer.append(",");
                stringBuffer.append(this.f33187OOXIXo);
                stringBuffer.append(") call failed.");
                x0o0xo.OxxIIOOXO(stringBuffer.toString(), e, 4);
                return;
            }
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("File option not set for appender [");
        stringBuffer2.append(this.f33157II0xO0);
        stringBuffer2.append("].");
        org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO(stringBuffer2.toString());
        org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO("Are you using FileAppender instead of ConsoleAppender?");
    }

    public void oOXoIIIo() {
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

    public void x0o(boolean z) {
        this.f33187OOXIXo = z;
    }

    public String xII() {
        return this.f33188oOoXoXO;
    }

    @Override // org.apache.log4j.X0IIOO
    public void xXxxox0I() {
        oOXoIIIo();
        this.f33188oOoXoXO = null;
        super.xXxxox0I();
    }

    public OOXIXo(x0XOIxOo x0xoixoo, String str, boolean z, boolean z2, int i) throws IOException {
        this.f33187OOXIXo = true;
        this.f33188oOoXoXO = null;
        this.f33189ooOOo0oXI = false;
        this.f33190x0XOIxOo = 8192;
        this.f33161oIX0oI = x0xoixoo;
        o0(str, z, z2, i);
    }

    public OOXIXo(x0XOIxOo x0xoixoo, String str, boolean z) throws IOException {
        this.f33187OOXIXo = true;
        this.f33188oOoXoXO = null;
        this.f33189ooOOo0oXI = false;
        this.f33190x0XOIxOo = 8192;
        this.f33161oIX0oI = x0xoixoo;
        o0(str, z, false, 8192);
    }

    public OOXIXo(x0XOIxOo x0xoixoo, String str) throws IOException {
        this(x0xoixoo, str, true);
    }
}
