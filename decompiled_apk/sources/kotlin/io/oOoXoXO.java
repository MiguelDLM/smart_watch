package kotlin.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nConsole.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Console.kt\nkotlin/io/LineReader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,299:1\n1#2:300\n*E\n"})
/* loaded from: classes6.dex */
public final class oOoXoXO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static CharsetDecoder f29225I0Io = null;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final CharBuffer f29226II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f29227II0xO0 = 32;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final ByteBuffer f29228Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final byte[] f29229X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final char[] f29230XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oOoXoXO f29231oIX0oI = new oOoXoXO();

    /* renamed from: oxoX, reason: collision with root package name */
    public static boolean f29232oxoX;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final StringBuilder f29233xxIXOIIO;

    static {
        byte[] bArr = new byte[32];
        f29229X0o0xo = bArr;
        char[] cArr = new char[32];
        f29230XO = cArr;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        IIX0o.oO(wrap, "wrap(...)");
        f29228Oxx0IOOO = wrap;
        CharBuffer wrap2 = CharBuffer.wrap(cArr);
        IIX0o.oO(wrap2, "wrap(...)");
        f29226II0XooXoX = wrap2;
        f29233xxIXOIIO = new StringBuilder();
    }

    public final int I0Io(int i, int i2) {
        ByteBuffer byteBuffer = f29228Oxx0IOOO;
        byteBuffer.limit(i);
        f29226II0XooXoX.position(i2);
        int II0xO02 = II0xO0(true);
        CharsetDecoder charsetDecoder = f29225I0Io;
        if (charsetDecoder == null) {
            IIX0o.XOxIOxOx("decoder");
            charsetDecoder = null;
        }
        charsetDecoder.reset();
        byteBuffer.position(0);
        return II0xO02;
    }

    public final int II0xO0(boolean z) {
        while (true) {
            CharsetDecoder charsetDecoder = f29225I0Io;
            if (charsetDecoder == null) {
                IIX0o.XOxIOxOx("decoder");
                charsetDecoder = null;
            }
            ByteBuffer byteBuffer = f29228Oxx0IOOO;
            CharBuffer charBuffer = f29226II0XooXoX;
            CoderResult decode = charsetDecoder.decode(byteBuffer, charBuffer, z);
            IIX0o.oO(decode, "decode(...)");
            if (decode.isError()) {
                X0o0xo();
                decode.throwException();
            }
            int position = charBuffer.position();
            if (!decode.isOverflow()) {
                return position;
            }
            StringBuilder sb = f29233xxIXOIIO;
            char[] cArr = f29230XO;
            int i = position - 1;
            sb.append(cArr, 0, i);
            charBuffer.position(0);
            charBuffer.limit(32);
            charBuffer.put(cArr[i]);
        }
    }

    public final void Oxx0IOOO(Charset charset) {
        CharsetDecoder newDecoder = charset.newDecoder();
        IIX0o.oO(newDecoder, "newDecoder(...)");
        f29225I0Io = newDecoder;
        ByteBuffer byteBuffer = f29228Oxx0IOOO;
        byteBuffer.clear();
        CharBuffer charBuffer = f29226II0XooXoX;
        charBuffer.clear();
        byteBuffer.put((byte) 10);
        byteBuffer.flip();
        CharsetDecoder charsetDecoder = f29225I0Io;
        if (charsetDecoder == null) {
            IIX0o.XOxIOxOx("decoder");
            charsetDecoder = null;
        }
        boolean z = false;
        charsetDecoder.decode(byteBuffer, charBuffer, false);
        if (charBuffer.position() == 1 && charBuffer.get(0) == '\n') {
            z = true;
        }
        f29232oxoX = z;
        X0o0xo();
    }

    public final void X0o0xo() {
        CharsetDecoder charsetDecoder = f29225I0Io;
        if (charsetDecoder == null) {
            IIX0o.XOxIOxOx("decoder");
            charsetDecoder = null;
        }
        charsetDecoder.reset();
        f29228Oxx0IOOO.position(0);
        f29233xxIXOIIO.setLength(0);
    }

    public final void XO() {
        StringBuilder sb = f29233xxIXOIIO;
        sb.setLength(32);
        sb.trimToSize();
    }

    public final int oIX0oI() {
        ByteBuffer byteBuffer = f29228Oxx0IOOO;
        byteBuffer.compact();
        int position = byteBuffer.position();
        byteBuffer.position(0);
        return position;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0078, code lost:
    
        if (r10 <= 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007a, code lost:
    
        r0 = kotlin.io.oOoXoXO.f29230XO;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0080, code lost:
    
        if (r0[r10 - 1] != '\n') goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0082, code lost:
    
        r1 = r10 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0084, code lost:
    
        if (r1 <= 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008c, code lost:
    
        if (r0[r10 - 2] != '\r') goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008e, code lost:
    
        r10 = r10 - 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0091, code lost:
    
        r10 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0092, code lost:
    
        r0 = kotlin.io.oOoXoXO.f29233xxIXOIIO;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0098, code lost:
    
        if (r0.length() != 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a2, code lost:
    
        return new java.lang.String(kotlin.io.oOoXoXO.f29230XO, 0, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a3, code lost:
    
        r0.append(kotlin.io.oOoXoXO.f29230XO, 0, r10);
        r10 = r0.toString();
        kotlin.jvm.internal.IIX0o.oO(r10, "toString(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b5, code lost:
    
        if (r0.length() <= 32) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b7, code lost:
    
        XO();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ba, code lost:
    
        r0.setLength(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00be, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
    
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0.charset(), r11) == false) goto L11;
     */
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized java.lang.String oxoX(@OXOo.OOXIXo java.io.InputStream r10, @OXOo.OOXIXo java.nio.charset.Charset r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.String r0 = "inputStream"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r10, r0)     // Catch: java.lang.Throwable -> L19
            java.lang.String r0 = "charset"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r11, r0)     // Catch: java.lang.Throwable -> L19
            java.nio.charset.CharsetDecoder r0 = kotlin.io.oOoXoXO.f29225I0Io     // Catch: java.lang.Throwable -> L19
            r1 = 0
            if (r0 == 0) goto L26
            if (r0 != 0) goto L1c
            java.lang.String r0 = "decoder"
            kotlin.jvm.internal.IIX0o.XOxIOxOx(r0)     // Catch: java.lang.Throwable -> L19
            r0 = r1
            goto L1c
        L19:
            r10 = move-exception
            goto Lc5
        L1c:
            java.nio.charset.Charset r0 = r0.charset()     // Catch: java.lang.Throwable -> L19
            boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r11)     // Catch: java.lang.Throwable -> L19
            if (r0 != 0) goto L29
        L26:
            r9.Oxx0IOOO(r11)     // Catch: java.lang.Throwable -> L19
        L29:
            r11 = 0
            r0 = 0
            r2 = 0
        L2c:
            int r3 = r10.read()     // Catch: java.lang.Throwable -> L19
            r4 = 32
            r5 = -1
            r6 = 10
            if (r3 != r5) goto L4a
            java.lang.StringBuilder r10 = kotlin.io.oOoXoXO.f29233xxIXOIIO     // Catch: java.lang.Throwable -> L19
            int r10 = r10.length()     // Catch: java.lang.Throwable -> L19
            if (r10 != 0) goto L45
            if (r0 != 0) goto L45
            if (r2 != 0) goto L45
            monitor-exit(r9)
            return r1
        L45:
            int r10 = r9.I0Io(r0, r2)     // Catch: java.lang.Throwable -> L19
            goto L78
        L4a:
            byte[] r5 = kotlin.io.oOoXoXO.f29229X0o0xo     // Catch: java.lang.Throwable -> L19
            int r7 = r0 + 1
            byte r8 = (byte) r3     // Catch: java.lang.Throwable -> L19
            r5[r0] = r8     // Catch: java.lang.Throwable -> L19
            if (r3 == r6) goto L5c
            if (r7 == r4) goto L5c
            boolean r0 = kotlin.io.oOoXoXO.f29232oxoX     // Catch: java.lang.Throwable -> L19
            if (r0 != 0) goto L5a
            goto L5c
        L5a:
            r0 = r7
            goto L2c
        L5c:
            java.nio.ByteBuffer r0 = kotlin.io.oOoXoXO.f29228Oxx0IOOO     // Catch: java.lang.Throwable -> L19
            r0.limit(r7)     // Catch: java.lang.Throwable -> L19
            java.nio.CharBuffer r3 = kotlin.io.oOoXoXO.f29226II0XooXoX     // Catch: java.lang.Throwable -> L19
            r3.position(r2)     // Catch: java.lang.Throwable -> L19
            int r2 = r9.II0xO0(r11)     // Catch: java.lang.Throwable -> L19
            if (r2 <= 0) goto Lbf
            char[] r3 = kotlin.io.oOoXoXO.f29230XO     // Catch: java.lang.Throwable -> L19
            int r5 = r2 + (-1)
            char r3 = r3[r5]     // Catch: java.lang.Throwable -> L19
            if (r3 != r6) goto Lbf
            r0.position(r11)     // Catch: java.lang.Throwable -> L19
            r10 = r2
        L78:
            if (r10 <= 0) goto L92
            char[] r0 = kotlin.io.oOoXoXO.f29230XO     // Catch: java.lang.Throwable -> L19
            int r1 = r10 + (-1)
            char r1 = r0[r1]     // Catch: java.lang.Throwable -> L19
            if (r1 != r6) goto L92
            int r1 = r10 + (-1)
            if (r1 <= 0) goto L91
            int r2 = r10 + (-2)
            char r0 = r0[r2]     // Catch: java.lang.Throwable -> L19
            r2 = 13
            if (r0 != r2) goto L91
            int r10 = r10 + (-2)
            goto L92
        L91:
            r10 = r1
        L92:
            java.lang.StringBuilder r0 = kotlin.io.oOoXoXO.f29233xxIXOIIO     // Catch: java.lang.Throwable -> L19
            int r1 = r0.length()     // Catch: java.lang.Throwable -> L19
            if (r1 != 0) goto La3
            java.lang.String r0 = new java.lang.String     // Catch: java.lang.Throwable -> L19
            char[] r1 = kotlin.io.oOoXoXO.f29230XO     // Catch: java.lang.Throwable -> L19
            r0.<init>(r1, r11, r10)     // Catch: java.lang.Throwable -> L19
            monitor-exit(r9)
            return r0
        La3:
            char[] r1 = kotlin.io.oOoXoXO.f29230XO     // Catch: java.lang.Throwable -> L19
            r0.append(r1, r11, r10)     // Catch: java.lang.Throwable -> L19
            java.lang.String r10 = r0.toString()     // Catch: java.lang.Throwable -> L19
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.IIX0o.oO(r10, r1)     // Catch: java.lang.Throwable -> L19
            int r1 = r0.length()     // Catch: java.lang.Throwable -> L19
            if (r1 <= r4) goto Lba
            r9.XO()     // Catch: java.lang.Throwable -> L19
        Lba:
            r0.setLength(r11)     // Catch: java.lang.Throwable -> L19
            monitor-exit(r9)
            return r10
        Lbf:
            int r0 = r9.oIX0oI()     // Catch: java.lang.Throwable -> L19
            goto L2c
        Lc5:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L19
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.oOoXoXO.oxoX(java.io.InputStream, java.nio.charset.Charset):java.lang.String");
    }
}
