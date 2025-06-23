package com.airbnb.lottie.parser.moshi;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;

/* loaded from: classes.dex */
public abstract class JsonReader implements Closeable {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final String[] f5030IIXOooo = new String[128];

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f5034OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public int f5035XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public boolean f5036oI0IIXIo;

    /* renamed from: Oo, reason: collision with root package name */
    public int[] f5032Oo = new int[32];

    /* renamed from: IXxxXO, reason: collision with root package name */
    public String[] f5031IXxxXO = new String[32];

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int[] f5033Oxx0xo = new int[32];

    /* loaded from: classes.dex */
    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    /* loaded from: classes.dex */
    public static final class oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final Options f5037II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final String[] f5038oIX0oI;

        public oIX0oI(String[] strArr, Options options) {
            this.f5038oIX0oI = strArr;
            this.f5037II0xO0 = options;
        }

        public static oIX0oI oIX0oI(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i = 0; i < strArr.length; i++) {
                    JsonReader.oI0IIXIo(buffer, strArr[i]);
                    buffer.readByte();
                    byteStringArr[i] = buffer.readByteString();
                }
                return new oIX0oI((String[]) strArr.clone(), Options.of(byteStringArr));
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    static {
        for (int i = 0; i <= 31; i++) {
            f5030IIXOooo[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = f5030IIXOooo;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void oI0IIXIo(okio.BufferedSink r7, java.lang.String r8) throws java.io.IOException {
        /*
            java.lang.String[] r0 = com.airbnb.lottie.parser.moshi.JsonReader.f5030IIXOooo
            r1 = 34
            r7.writeByte(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = 0
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r7.writeUtf8(r8, r4, r3)
        L2e:
            r7.writeUtf8(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r7.writeUtf8(r8, r4, r2)
        L3b:
            r7.writeByte(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.JsonReader.oI0IIXIo(okio.BufferedSink, java.lang.String):void");
    }

    public static JsonReader oOoXoXO(BufferedSource bufferedSource) {
        return new II0xO0(bufferedSource);
    }

    public abstract void I0Io() throws IOException;

    public abstract double II0XooXoX() throws IOException;

    public abstract void II0xO0() throws IOException;

    public abstract void IXxxXO() throws IOException;

    public abstract String OOXIXo() throws IOException;

    public abstract int Oo(oIX0oI oix0oi) throws IOException;

    public abstract boolean Oxx0IOOO() throws IOException;

    public abstract void Oxx0xo() throws IOException;

    public final JsonEncodingException OxxIIOOXO(String str) throws JsonEncodingException {
        throw new JsonEncodingException(str + " at path " + getPath());
    }

    public abstract void X0o0xo() throws IOException;

    public abstract boolean XO() throws IOException;

    public final String getPath() {
        return com.airbnb.lottie.parser.moshi.oIX0oI.oIX0oI(this.f5035XO, this.f5032Oo, this.f5031IXxxXO, this.f5033Oxx0xo);
    }

    public final void oO(int i) {
        int i2 = this.f5035XO;
        int[] iArr = this.f5032Oo;
        if (i2 == iArr.length) {
            if (i2 != 256) {
                this.f5032Oo = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f5031IXxxXO;
                this.f5031IXxxXO = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f5033Oxx0xo;
                this.f5033Oxx0xo = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
        }
        int[] iArr3 = this.f5032Oo;
        int i3 = this.f5035XO;
        this.f5035XO = i3 + 1;
        iArr3[i3] = i;
    }

    public abstract void oxoX() throws IOException;

    public abstract Token x0XOIxOo() throws IOException;

    public abstract String xoIox() throws IOException;

    public abstract int xxIXOIIO() throws IOException;
}
