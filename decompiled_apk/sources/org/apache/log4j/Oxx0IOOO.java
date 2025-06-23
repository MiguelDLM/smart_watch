package org.apache.log4j;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes6.dex */
public class Oxx0IOOO extends X0IIOO {

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final String f33192ooOOo0oXI = "System.out";

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final String f33193x0XOIxOo = "System.err";

    /* renamed from: OOXIXo, reason: collision with root package name */
    public String f33194OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public boolean f33195oOoXoXO;

    /* loaded from: classes6.dex */
    public static class II0xO0 extends OutputStream {
        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            System.out.flush();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            System.out.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            System.out.write(bArr, i, i2);
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            System.out.write(i);
        }
    }

    /* loaded from: classes6.dex */
    public static class oIX0oI extends OutputStream {
        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            System.err.flush();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            System.err.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            System.err.write(bArr, i, i2);
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            System.err.write(i);
        }
    }

    public Oxx0IOOO() {
        this.f33194OOXIXo = f33192ooOOo0oXI;
        this.f33195oOoXoXO = false;
    }

    public void IO(String str) {
        String trim = str.trim();
        if (f33192ooOOo0oXI.equalsIgnoreCase(trim)) {
            this.f33194OOXIXo = f33192ooOOo0oXI;
        } else if (f33193x0XOIxOo.equalsIgnoreCase(trim)) {
            this.f33194OOXIXo = f33193x0XOIxOo;
        } else {
            xII(str);
        }
    }

    public final void X00IoxXI(boolean z) {
        this.f33195oOoXoXO = z;
    }

    @Override // org.apache.log4j.X0IIOO
    public final void XI0IXoo() {
        if (this.f33195oOoXoXO) {
            super.XI0IXoo();
        }
    }

    public String Xx000oIo() {
        return this.f33194OOXIXo;
    }

    @Override // org.apache.log4j.X0IIOO, org.apache.log4j.II0xO0, org.apache.log4j.spi.OOXIXo
    public void oI0IIXIo() {
        if (this.f33195oOoXoXO) {
            if (this.f33194OOXIXo.equals(f33193x0XOIxOo)) {
                xI(XIxXXX0x0(new oIX0oI()));
            } else {
                xI(XIxXXX0x0(new II0xO0()));
            }
        } else if (this.f33194OOXIXo.equals(f33193x0XOIxOo)) {
            xI(XIxXXX0x0(System.err));
        } else {
            xI(XIxXXX0x0(System.out));
        }
        super.oI0IIXIo();
    }

    public final boolean oOXoIIIo() {
        return this.f33195oOoXoXO;
    }

    public void xII(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        stringBuffer.append(str);
        stringBuffer.append("] should be System.out or System.err.");
        org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO(stringBuffer.toString());
        org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO("Using previously set target, System.out by default.");
    }

    public Oxx0IOOO(x0XOIxOo x0xoixoo) {
        this(x0xoixoo, f33192ooOOo0oXI);
    }

    public Oxx0IOOO(x0XOIxOo x0xoixoo, String str) {
        this.f33194OOXIXo = f33192ooOOo0oXI;
        this.f33195oOoXoXO = false;
        oxoX(x0xoixoo);
        IO(str);
        oI0IIXIo();
    }
}
