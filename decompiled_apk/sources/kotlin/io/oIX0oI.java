package kotlin.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.NoSuchElementException;
import kotlin.XX;
import kotlin.collections.x0xO0oo;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;

@XO0OX.xxIXOIIO(name = "ByteStreamsKt")
/* loaded from: classes6.dex */
public final class oIX0oI {

    /* renamed from: kotlin.io.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1108oIX0oI extends x0xO0oo {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public boolean f29221IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public boolean f29222Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ BufferedInputStream f29223Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public int f29224XO = -1;

        public C1108oIX0oI(BufferedInputStream bufferedInputStream) {
            this.f29223Oxx0xo = bufferedInputStream;
        }

        public final void II0XooXoX(boolean z) {
            this.f29221IXxxXO = z;
        }

        @Override // kotlin.collections.x0xO0oo
        public byte II0xO0() {
            Oxx0IOOO();
            if (!this.f29221IXxxXO) {
                byte b = (byte) this.f29224XO;
                this.f29222Oo = false;
                return b;
            }
            throw new NoSuchElementException("Input stream is over.");
        }

        public final void Oxx0IOOO() {
            if (!this.f29222Oo && !this.f29221IXxxXO) {
                int read = this.f29223Oxx0xo.read();
                this.f29224XO = read;
                boolean z = true;
                this.f29222Oo = true;
                if (read != -1) {
                    z = false;
                }
                this.f29221IXxxXO = z;
            }
        }

        public final int X0o0xo() {
            return this.f29224XO;
        }

        public final boolean XO() {
            return this.f29222Oo;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Oxx0IOOO();
            return !this.f29221IXxxXO;
        }

        public final boolean oxoX() {
            return this.f29221IXxxXO;
        }

        public final void xoIox(boolean z) {
            this.f29222Oo = z;
        }

        public final void xxIXOIIO(int i) {
            this.f29224XO = i;
        }
    }

    public static /* synthetic */ BufferedInputStream I0Io(InputStream inputStream, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8192;
        }
        IIX0o.x0xO0oo(inputStream, "<this>");
        if (inputStream instanceof BufferedInputStream) {
            return (BufferedInputStream) inputStream;
        }
        return new BufferedInputStream(inputStream, i);
    }

    public static /* synthetic */ BufferedWriter II0XooXoX(OutputStream outputStream, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        IIX0o.x0xO0oo(outputStream, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        return new BufferedWriter(new OutputStreamWriter(outputStream, charset), 8192);
    }

    @xx0o0O.XO
    public static final BufferedOutputStream II0xO0(OutputStream outputStream, int i) {
        IIX0o.x0xO0oo(outputStream, "<this>");
        if (outputStream instanceof BufferedOutputStream) {
            return (BufferedOutputStream) outputStream;
        }
        return new BufferedOutputStream(outputStream, i);
    }

    public static /* synthetic */ OutputStreamWriter IIXOooo(OutputStream outputStream, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        IIX0o.x0xO0oo(outputStream, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        return new OutputStreamWriter(outputStream, charset);
    }

    public static /* synthetic */ byte[] IXxxXO(InputStream inputStream, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8192;
        }
        return Oo(inputStream, i);
    }

    public static final long OOXIXo(@OXOo.OOXIXo InputStream inputStream, @OXOo.OOXIXo OutputStream out, int i) {
        IIX0o.x0xO0oo(inputStream, "<this>");
        IIX0o.x0xO0oo(out, "out");
        byte[] bArr = new byte[i];
        int read = inputStream.read(bArr);
        long j = 0;
        while (read >= 0) {
            out.write(bArr, 0, read);
            j += read;
            read = inputStream.read(bArr);
        }
        return j;
    }

    @kotlin.OOXIXo(message = "Use readBytes() overload without estimatedSize parameter", replaceWith = @XX(expression = "readBytes()", imports = {}))
    @OXOo.OOXIXo
    @kotlin.oOoXoXO(errorSince = "1.5", warningSince = "1.3")
    public static final byte[] Oo(@OXOo.OOXIXo InputStream inputStream, int i) {
        IIX0o.x0xO0oo(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(i, inputStream.available()));
        oOoXoXO(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        IIX0o.oO(byteArray, "toByteArray(...)");
        return byteArray;
    }

    @xx0o0O.XO
    public static final BufferedWriter Oxx0IOOO(OutputStream outputStream, Charset charset) {
        IIX0o.x0xO0oo(outputStream, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        return new BufferedWriter(new OutputStreamWriter(outputStream, charset), 8192);
    }

    @xx0o0O.XO
    public static final InputStreamReader Oxx0xo(InputStream inputStream, Charset charset) {
        IIX0o.x0xO0oo(inputStream, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        return new InputStreamReader(inputStream, charset);
    }

    @xx0o0O.XO
    public static final OutputStreamWriter OxxIIOOXO(OutputStream outputStream, Charset charset) {
        IIX0o.x0xO0oo(outputStream, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        return new OutputStreamWriter(outputStream, charset);
    }

    @xx0o0O.XO
    public static final BufferedReader X0o0xo(InputStream inputStream, Charset charset) {
        IIX0o.x0xO0oo(inputStream, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        return new BufferedReader(new InputStreamReader(inputStream, charset), 8192);
    }

    public static /* synthetic */ BufferedReader XO(InputStream inputStream, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        IIX0o.x0xO0oo(inputStream, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        return new BufferedReader(new InputStreamReader(inputStream, charset), 8192);
    }

    public static /* synthetic */ InputStreamReader oI0IIXIo(InputStream inputStream, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        IIX0o.x0xO0oo(inputStream, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        return new InputStreamReader(inputStream, charset);
    }

    @xx0o0O.XO
    public static final BufferedInputStream oIX0oI(InputStream inputStream, int i) {
        IIX0o.x0xO0oo(inputStream, "<this>");
        if (inputStream instanceof BufferedInputStream) {
            return (BufferedInputStream) inputStream;
        }
        return new BufferedInputStream(inputStream, i);
    }

    @OXOo.OOXIXo
    public static final x0xO0oo oO(@OXOo.OOXIXo BufferedInputStream bufferedInputStream) {
        IIX0o.x0xO0oo(bufferedInputStream, "<this>");
        return new C1108oIX0oI(bufferedInputStream);
    }

    public static /* synthetic */ long oOoXoXO(InputStream inputStream, OutputStream outputStream, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return OOXIXo(inputStream, outputStream, i);
    }

    @xx0o0O.XO
    public static final ByteArrayInputStream ooOOo0oXI(byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "<this>");
        return new ByteArrayInputStream(bArr);
    }

    public static /* synthetic */ BufferedOutputStream oxoX(OutputStream outputStream, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8192;
        }
        IIX0o.x0xO0oo(outputStream, "<this>");
        if (outputStream instanceof BufferedOutputStream) {
            return (BufferedOutputStream) outputStream;
        }
        return new BufferedOutputStream(outputStream, i);
    }

    @xx0o0O.XO
    public static final ByteArrayInputStream x0XOIxOo(byte[] bArr, int i, int i2) {
        IIX0o.x0xO0oo(bArr, "<this>");
        return new ByteArrayInputStream(bArr, i, i2);
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.3")
    public static final byte[] x0xO0oo(@OXOo.OOXIXo InputStream inputStream) {
        IIX0o.x0xO0oo(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        oOoXoXO(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        IIX0o.oO(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public static /* synthetic */ ByteArrayInputStream xoIox(String str, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        IIX0o.oO(bytes, "getBytes(...)");
        return new ByteArrayInputStream(bytes);
    }

    @xx0o0O.XO
    public static final ByteArrayInputStream xxIXOIIO(String str, Charset charset) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        IIX0o.oO(bytes, "getBytes(...)");
        return new ByteArrayInputStream(bytes);
    }
}
