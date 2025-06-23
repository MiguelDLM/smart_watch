package com.airbnb.lottie.parser.moshi;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;

public abstract class JsonReader implements Closeable {

    /* renamed from: IIXOooo  reason: collision with root package name */
    public static final String[] f1036IIXOooo = new String[128];

    /* renamed from: IXxxXO  reason: collision with root package name */
    public String[] f1037IXxxXO = new String[32];

    /* renamed from: Oo  reason: collision with root package name */
    public int[] f1038Oo = new int[32];

    /* renamed from: Oxx0xo  reason: collision with root package name */
    public int[] f1039Oxx0xo = new int[32];

    /* renamed from: OxxIIOOXO  reason: collision with root package name */
    public boolean f1040OxxIIOOXO;

    /* renamed from: XO  reason: collision with root package name */
    public int f1041XO;

    /* renamed from: oI0IIXIo  reason: collision with root package name */
    public boolean f1042oI0IIXIo;

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

    public static final class oIX0oI {

        /* renamed from: II0xO0  reason: collision with root package name */
        public final Options f1043II0xO0;

        /* renamed from: oIX0oI  reason: collision with root package name */
        public final String[] f1044oIX0oI;

        public oIX0oI(String[] strArr, Options options) {
            this.f1044oIX0oI = strArr;
            this.f1043II0xO0 = options;
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
            f1036IIXOooo[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        String[] strArr = f1036IIXOooo;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public static void oI0IIXIo(BufferedSink bufferedSink, String str) throws IOException {
        String str2;
        String[] strArr = f1036IIXOooo;
        bufferedSink.writeByte(34);
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i < i2) {
                bufferedSink.writeUtf8(str, i, i2);
            }
            bufferedSink.writeUtf8(str2);
            i = i2 + 1;
        }
        if (i < length) {
            bufferedSink.writeUtf8(str, i, length);
        }
        bufferedSink.writeByte(34);
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
        return oIX0oI.oIX0oI(this.f1041XO, this.f1038Oo, this.f1037IXxxXO, this.f1039Oxx0xo);
    }

    public final void oO(int i) {
        int i2 = this.f1041XO;
        int[] iArr = this.f1038Oo;
        if (i2 == iArr.length) {
            if (i2 != 256) {
                this.f1038Oo = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f1037IXxxXO;
                this.f1037IXxxXO = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f1039Oxx0xo;
                this.f1039Oxx0xo = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
        }
        int[] iArr3 = this.f1038Oo;
        int i3 = this.f1041XO;
        this.f1041XO = i3 + 1;
        iArr3[i3] = i;
    }

    public abstract void oxoX() throws IOException;

    public abstract Token x0XOIxOo() throws IOException;

    public abstract String xoIox() throws IOException;

    public abstract int xxIXOIIO() throws IOException;
}
