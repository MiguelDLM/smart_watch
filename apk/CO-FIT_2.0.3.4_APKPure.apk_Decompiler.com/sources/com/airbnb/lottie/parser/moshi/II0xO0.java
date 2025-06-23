package com.airbnb.lottie.parser.moshi;

import XXO0.oIX0oI;
import androidx.annotation.Nullable;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.BasicHeaderValueFormatter;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.apache.log4j.helpers.X0o0xo;

public final class II0xO0 extends JsonReader {

    /* renamed from: I0X0x0oIo  reason: collision with root package name */
    public static final int f997I0X0x0oIo = 3;

    /* renamed from: I0oOoX  reason: collision with root package name */
    public static final int f998I0oOoX = 15;

    /* renamed from: IIX0o  reason: collision with root package name */
    public static final ByteString f999IIX0o = ByteString.encodeUtf8("\n\r");

    /* renamed from: IO  reason: collision with root package name */
    public static final int f1000IO = 7;

    /* renamed from: Io  reason: collision with root package name */
    public static final int f1001Io = 12;

    /* renamed from: IoOoX  reason: collision with root package name */
    public static final int f1002IoOoX = 3;

    /* renamed from: O0Xx  reason: collision with root package name */
    public static final int f1003O0Xx = 7;

    /* renamed from: OI0  reason: collision with root package name */
    public static final int f1004OI0 = 11;

    /* renamed from: X00IoxXI  reason: collision with root package name */
    public static final int f1005X00IoxXI = 6;

    /* renamed from: XIxXXX0x0  reason: collision with root package name */
    public static final long f1006XIxXXX0x0 = -922337203685477580L;

    /* renamed from: XOxIOxOx  reason: collision with root package name */
    public static final int f1007XOxIOxOx = 10;

    /* renamed from: XX  reason: collision with root package name */
    public static final int f1008XX = 14;

    /* renamed from: XX0  reason: collision with root package name */
    public static final int f1009XX0 = 2;

    /* renamed from: Xo0  reason: collision with root package name */
    public static final int f1010Xo0 = 5;

    /* renamed from: XoI0Ixx0  reason: collision with root package name */
    public static final int f1011XoI0Ixx0 = 6;

    /* renamed from: XoX  reason: collision with root package name */
    public static final int f1012XoX = 17;

    /* renamed from: Xx000oIo  reason: collision with root package name */
    public static final int f1013Xx000oIo = 5;

    /* renamed from: XxX0x0xxx  reason: collision with root package name */
    public static final ByteString f1014XxX0x0xxx = ByteString.encodeUtf8(BasicHeaderValueFormatter.UNSAFE_CHARS);

    /* renamed from: o0  reason: collision with root package name */
    public static final int f1015o0 = 13;

    /* renamed from: oOXoIIIo  reason: collision with root package name */
    public static final int f1016oOXoIIIo = 4;

    /* renamed from: oX  reason: collision with root package name */
    public static final int f1017oX = 4;

    /* renamed from: oo  reason: collision with root package name */
    public static final int f1018oo = 2;

    /* renamed from: oo0xXOI0I  reason: collision with root package name */
    public static final int f1019oo0xXOI0I = 1;

    /* renamed from: ooXIXxIX  reason: collision with root package name */
    public static final ByteString f1020ooXIXxIX = ByteString.encodeUtf8("*/");

    /* renamed from: oxXx0IX  reason: collision with root package name */
    public static final int f1021oxXx0IX = 18;

    /* renamed from: oxxXoxO  reason: collision with root package name */
    public static final int f1022oxxXoxO = 16;

    /* renamed from: x0o  reason: collision with root package name */
    public static final int f1023x0o = 9;

    /* renamed from: xI  reason: collision with root package name */
    public static final int f1024xI = 0;

    /* renamed from: xII  reason: collision with root package name */
    public static final int f1025xII = 8;

    /* renamed from: xXOx  reason: collision with root package name */
    public static final int f1026xXOx = 1;

    /* renamed from: xXxxox0I  reason: collision with root package name */
    public static final ByteString f1027xXxxox0I = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");

    /* renamed from: xo0x  reason: collision with root package name */
    public static final int f1028xo0x = 0;

    /* renamed from: xxX  reason: collision with root package name */
    public static final ByteString f1029xxX = ByteString.encodeUtf8("'\\");

    /* renamed from: O0xOxO  reason: collision with root package name */
    public long f1030O0xOxO;

    /* renamed from: OxI  reason: collision with root package name */
    public int f1031OxI = 0;

    /* renamed from: X0IIOO  reason: collision with root package name */
    public int f1032X0IIOO;
    @Nullable

    /* renamed from: XI0IXoo  reason: collision with root package name */
    public String f1033XI0IXoo;

    /* renamed from: o00  reason: collision with root package name */
    public final Buffer f1034o00;

    /* renamed from: xoXoI  reason: collision with root package name */
    public final BufferedSource f1035xoXoI;

    public II0xO0(BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            this.f1035xoXoI = bufferedSource;
            this.f1034o00 = bufferedSource.buffer();
            oO(6);
            return;
        }
        throw new NullPointerException("source == null");
    }

    public void I0Io() throws IOException {
        int i = this.f1031OxI;
        if (i == 0) {
            i = xoXoI();
        }
        if (i == 1) {
            oO(3);
            this.f1031OxI = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + x0XOIxOo() + " at path " + getPath());
    }

    public double II0XooXoX() throws IOException {
        int i = this.f1031OxI;
        if (i == 0) {
            i = xoXoI();
        }
        if (i == 16) {
            this.f1031OxI = 0;
            int[] iArr = this.f1039Oxx0xo;
            int i2 = this.f1041XO - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.f1030O0xOxO;
        }
        if (i == 17) {
            this.f1033XI0IXoo = this.f1034o00.readUtf8((long) this.f1032X0IIOO);
        } else if (i == 9) {
            this.f1033XI0IXoo = XI0IXoo(f1014XxX0x0xxx);
        } else if (i == 8) {
            this.f1033XI0IXoo = XI0IXoo(f1029xxX);
        } else if (i == 10) {
            this.f1033XI0IXoo = XIxXXX0x0();
        } else if (i != 11) {
            throw new JsonDataException("Expected a double but was " + x0XOIxOo() + " at path " + getPath());
        }
        this.f1031OxI = 11;
        try {
            double parseDouble = Double.parseDouble(this.f1033XI0IXoo);
            if (this.f1042oI0IIXIo || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
                this.f1033XI0IXoo = null;
                this.f1031OxI = 0;
                int[] iArr2 = this.f1039Oxx0xo;
                int i3 = this.f1041XO - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseDouble;
            }
            throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.f1033XI0IXoo + " at path " + getPath());
        }
    }

    public void II0xO0() throws IOException {
        int i = this.f1031OxI;
        if (i == 0) {
            i = xoXoI();
        }
        if (i == 3) {
            oO(1);
            this.f1039Oxx0xo[this.f1041XO - 1] = 0;
            this.f1031OxI = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_ARRAY but was " + x0XOIxOo() + " at path " + getPath());
    }

    public final void IIX0o(ByteString byteString) throws IOException {
        while (true) {
            long indexOfElement = this.f1035xoXoI.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw OxxIIOOXO("Unterminated string");
            } else if (this.f1034o00.getByte(indexOfElement) == 92) {
                this.f1034o00.skip(indexOfElement + 1);
                xXxxox0I();
            } else {
                this.f1034o00.skip(indexOfElement + 1);
                return;
            }
        }
    }

    public final void IIXOooo() throws IOException {
        if (!this.f1042oI0IIXIo) {
            throw OxxIIOOXO("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    public void IXxxXO() throws IOException {
        if (!this.f1040OxxIIOOXO) {
            int i = this.f1031OxI;
            if (i == 0) {
                i = xoXoI();
            }
            if (i == 14) {
                oo0xXOI0I();
            } else if (i == 13) {
                IIX0o(f1014XxX0x0xxx);
            } else if (i == 12) {
                IIX0o(f1029xxX);
            } else if (i != 15) {
                throw new JsonDataException("Expected a name but was " + x0XOIxOo() + " at path " + getPath());
            }
            this.f1031OxI = 0;
            this.f1037IXxxXO[this.f1041XO - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + x0XOIxOo() + " at " + getPath());
    }

    public final boolean O0xOxO(int i) throws IOException {
        if (i == 9 || i == 10 || i == 12 || i == 13 || i == 32) {
            return false;
        }
        if (i != 35) {
            if (i == 44) {
                return false;
            }
            if (!(i == 47 || i == 61)) {
                if (i == 123 || i == 125 || i == 58) {
                    return false;
                }
                if (i != 59) {
                    switch (i) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        IIXOooo();
        return false;
    }

    public String OOXIXo() throws IOException {
        String str;
        int i = this.f1031OxI;
        if (i == 0) {
            i = xoXoI();
        }
        if (i == 10) {
            str = XIxXXX0x0();
        } else if (i == 9) {
            str = XI0IXoo(f1014XxX0x0xxx);
        } else if (i == 8) {
            str = XI0IXoo(f1029xxX);
        } else if (i == 11) {
            str = this.f1033XI0IXoo;
            this.f1033XI0IXoo = null;
        } else if (i == 16) {
            str = Long.toString(this.f1030O0xOxO);
        } else if (i == 17) {
            str = this.f1034o00.readUtf8((long) this.f1032X0IIOO);
        } else {
            throw new JsonDataException("Expected a string but was " + x0XOIxOo() + " at path " + getPath());
        }
        this.f1031OxI = 0;
        int[] iArr = this.f1039Oxx0xo;
        int i2 = this.f1041XO - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public int Oo(JsonReader.oIX0oI oix0oi) throws IOException {
        int i = this.f1031OxI;
        if (i == 0) {
            i = xoXoI();
        }
        if (i < 12 || i > 15) {
            return -1;
        }
        if (i == 15) {
            return o00(this.f1033XI0IXoo, oix0oi);
        }
        int select = this.f1035xoXoI.select(oix0oi.f1043II0xO0);
        if (select != -1) {
            this.f1031OxI = 0;
            this.f1037IXxxXO[this.f1041XO - 1] = oix0oi.f1044oIX0oI[select];
            return select;
        }
        String str = this.f1037IXxxXO[this.f1041XO - 1];
        String xoIox2 = xoIox();
        int o002 = o00(xoIox2, oix0oi);
        if (o002 == -1) {
            this.f1031OxI = 15;
            this.f1033XI0IXoo = xoIox2;
            this.f1037IXxxXO[this.f1041XO - 1] = str;
        }
        return o002;
    }

    public final int OxI(String str, JsonReader.oIX0oI oix0oi) {
        int length = oix0oi.f1044oIX0oI.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(oix0oi.f1044oIX0oI[i])) {
                this.f1031OxI = 0;
                int[] iArr = this.f1039Oxx0xo;
                int i2 = this.f1041XO - 1;
                iArr[i2] = iArr[i2] + 1;
                return i;
            }
        }
        return -1;
    }

    public boolean Oxx0IOOO() throws IOException {
        int i = this.f1031OxI;
        if (i == 0) {
            i = xoXoI();
        }
        if (i == 5) {
            this.f1031OxI = 0;
            int[] iArr = this.f1039Oxx0xo;
            int i2 = this.f1041XO - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.f1031OxI = 0;
            int[] iArr2 = this.f1039Oxx0xo;
            int i3 = this.f1041XO - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new JsonDataException("Expected a boolean but was " + x0XOIxOo() + " at path " + getPath());
        }
    }

    public void Oxx0xo() throws IOException {
        if (!this.f1040OxxIIOOXO) {
            int i = 0;
            do {
                int i2 = this.f1031OxI;
                if (i2 == 0) {
                    i2 = xoXoI();
                }
                if (i2 == 3) {
                    oO(1);
                } else if (i2 == 1) {
                    oO(3);
                } else {
                    if (i2 == 4) {
                        i--;
                        if (i >= 0) {
                            this.f1041XO--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + x0XOIxOo() + " at path " + getPath());
                        }
                    } else if (i2 == 2) {
                        i--;
                        if (i >= 0) {
                            this.f1041XO--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + x0XOIxOo() + " at path " + getPath());
                        }
                    } else if (i2 == 14 || i2 == 10) {
                        oo0xXOI0I();
                    } else if (i2 == 9 || i2 == 13) {
                        IIX0o(f1014XxX0x0xxx);
                    } else if (i2 == 8 || i2 == 12) {
                        IIX0o(f1029xxX);
                    } else if (i2 == 17) {
                        this.f1034o00.skip((long) this.f1032X0IIOO);
                    } else if (i2 == 18) {
                        throw new JsonDataException("Expected a value but was " + x0XOIxOo() + " at path " + getPath());
                    }
                    this.f1031OxI = 0;
                }
                i++;
                this.f1031OxI = 0;
            } while (i != 0);
            int[] iArr = this.f1039Oxx0xo;
            int i3 = this.f1041XO;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.f1037IXxxXO[i3 - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + x0XOIxOo() + " at " + getPath());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        r6.f1034o00.skip((long) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        if (r2 != 47) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0037, code lost:
        if (r6.f1035xoXoI.request(2) != false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        IIXOooo();
        r3 = r6.f1034o00.getByte(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
        if (r3 == 42) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
        if (r3 == 47) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004b, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        r6.f1034o00.readByte();
        r6.f1034o00.readByte();
        xI();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        r6.f1034o00.readByte();
        r6.f1034o00.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0068, code lost:
        if (ooXIXxIX() == false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0071, code lost:
        throw OxxIIOOXO("Unterminated comment");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0074, code lost:
        if (r2 != 35) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0076, code lost:
        IIXOooo();
        xI();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007d, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int X0IIOO(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
        L_0x0001:
            r1 = 0
        L_0x0002:
            okio.BufferedSource r2 = r6.f1035xoXoI
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.request(r4)
            if (r2 == 0) goto L_0x0080
            okio.Buffer r2 = r6.f1034o00
            long r4 = (long) r1
            byte r2 = r2.getByte(r4)
            r4 = 10
            if (r2 == r4) goto L_0x007e
            r4 = 32
            if (r2 == r4) goto L_0x007e
            r4 = 13
            if (r2 == r4) goto L_0x007e
            r4 = 9
            if (r2 != r4) goto L_0x0025
            goto L_0x007e
        L_0x0025:
            okio.Buffer r3 = r6.f1034o00
            long r4 = (long) r1
            r3.skip(r4)
            r1 = 47
            if (r2 != r1) goto L_0x0072
            okio.BufferedSource r3 = r6.f1035xoXoI
            r4 = 2
            boolean r3 = r3.request(r4)
            if (r3 != 0) goto L_0x003a
            return r2
        L_0x003a:
            r6.IIXOooo()
            okio.Buffer r3 = r6.f1034o00
            r4 = 1
            byte r3 = r3.getByte(r4)
            r4 = 42
            if (r3 == r4) goto L_0x005a
            if (r3 == r1) goto L_0x004c
            return r2
        L_0x004c:
            okio.Buffer r1 = r6.f1034o00
            r1.readByte()
            okio.Buffer r1 = r6.f1034o00
            r1.readByte()
            r6.xI()
            goto L_0x0001
        L_0x005a:
            okio.Buffer r1 = r6.f1034o00
            r1.readByte()
            okio.Buffer r1 = r6.f1034o00
            r1.readByte()
            boolean r1 = r6.ooXIXxIX()
            if (r1 == 0) goto L_0x006b
            goto L_0x0001
        L_0x006b:
            java.lang.String r7 = "Unterminated comment"
            com.airbnb.lottie.parser.moshi.JsonEncodingException r7 = r6.OxxIIOOXO(r7)
            throw r7
        L_0x0072:
            r1 = 35
            if (r2 != r1) goto L_0x007d
            r6.IIXOooo()
            r6.xI()
            goto L_0x0001
        L_0x007d:
            return r2
        L_0x007e:
            r1 = r3
            goto L_0x0002
        L_0x0080:
            if (r7 != 0) goto L_0x0084
            r7 = -1
            return r7
        L_0x0084:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.II0xO0.X0IIOO(boolean):int");
    }

    public void X0o0xo() throws IOException {
        int i = this.f1031OxI;
        if (i == 0) {
            i = xoXoI();
        }
        if (i == 2) {
            int i2 = this.f1041XO;
            int i3 = i2 - 1;
            this.f1041XO = i3;
            this.f1037IXxxXO[i3] = null;
            int[] iArr = this.f1039Oxx0xo;
            int i4 = i2 - 2;
            iArr[i4] = iArr[i4] + 1;
            this.f1031OxI = 0;
            return;
        }
        throw new JsonDataException("Expected END_OBJECT but was " + x0XOIxOo() + " at path " + getPath());
    }

    public final String XI0IXoo(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long indexOfElement = this.f1035xoXoI.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw OxxIIOOXO("Unterminated string");
            } else if (this.f1034o00.getByte(indexOfElement) == 92) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.f1034o00.readUtf8(indexOfElement));
                this.f1034o00.readByte();
                sb.append(xXxxox0I());
            } else if (sb == null) {
                String readUtf8 = this.f1034o00.readUtf8(indexOfElement);
                this.f1034o00.readByte();
                return readUtf8;
            } else {
                sb.append(this.f1034o00.readUtf8(indexOfElement));
                this.f1034o00.readByte();
                return sb.toString();
            }
        }
    }

    public final String XIxXXX0x0() throws IOException {
        long indexOfElement = this.f1035xoXoI.indexOfElement(f1027xXxxox0I);
        if (indexOfElement != -1) {
            return this.f1034o00.readUtf8(indexOfElement);
        }
        return this.f1034o00.readUtf8();
    }

    public boolean XO() throws IOException {
        int i = this.f1031OxI;
        if (i == 0) {
            i = xoXoI();
        }
        if (i == 2 || i == 4 || i == 18) {
            return false;
        }
        return true;
    }

    public final int XxX0x0xxx() throws IOException {
        byte b;
        boolean z;
        boolean z2 = true;
        long j = 0;
        int i = 0;
        char c = 0;
        boolean z3 = true;
        boolean z4 = false;
        while (true) {
            int i2 = i + 1;
            if (!this.f1035xoXoI.request((long) i2)) {
                break;
            }
            b = this.f1034o00.getByte((long) i);
            if (b != 43) {
                if (b != 69 && b != 101) {
                    if (b != 45) {
                        if (b != 46) {
                            if (b >= 48 && b <= 57) {
                                if (c == z2 || c == 0) {
                                    j = (long) (-(b - 48));
                                    c = 2;
                                } else if (c == 2) {
                                    if (j == 0) {
                                        return 0;
                                    }
                                    long j2 = (10 * j) - ((long) (b - 48));
                                    int i3 = (j > -922337203685477580L ? 1 : (j == -922337203685477580L ? 0 : -1));
                                    if (i3 > 0 || (i3 == 0 && j2 < j)) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    z3 &= z;
                                    j = j2;
                                } else if (c == 3) {
                                    c = 4;
                                } else if (c == 5 || c == 6) {
                                    c = 7;
                                }
                            }
                        } else if (c != 2) {
                            return 0;
                        } else {
                            c = 3;
                        }
                    } else if (c == 0) {
                        c = 1;
                        z4 = true;
                    } else if (c != 5) {
                        return 0;
                    }
                    i = i2;
                    z2 = true;
                } else if (c != 2 && c != 4) {
                    return 0;
                } else {
                    c = 5;
                    i = i2;
                    z2 = true;
                }
            } else if (c != 5) {
                return 0;
            }
            c = 6;
            i = i2;
            z2 = true;
        }
        if (O0xOxO(b)) {
            return 0;
        }
        if (c == 2 && z3 && ((j != Long.MIN_VALUE || z4) && (j != 0 || !z4))) {
            if (!z4) {
                j = -j;
            }
            this.f1030O0xOxO = j;
            this.f1034o00.skip((long) i);
            this.f1031OxI = 16;
            return 16;
        } else if (c != 2 && c != 4 && c != 7) {
            return 0;
        } else {
            this.f1032X0IIOO = i;
            this.f1031OxI = 17;
            return 17;
        }
    }

    public void close() throws IOException {
        this.f1031OxI = 0;
        this.f1038Oo[0] = 8;
        this.f1041XO = 1;
        this.f1034o00.clear();
        this.f1035xoXoI.close();
    }

    public final int o00(String str, JsonReader.oIX0oI oix0oi) {
        int length = oix0oi.f1044oIX0oI.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(oix0oi.f1044oIX0oI[i])) {
                this.f1031OxI = 0;
                this.f1037IXxxXO[this.f1041XO - 1] = str;
                return i;
            }
        }
        return -1;
    }

    public final void oo0xXOI0I() throws IOException {
        long indexOfElement = this.f1035xoXoI.indexOfElement(f1027xXxxox0I);
        Buffer buffer = this.f1034o00;
        if (indexOfElement == -1) {
            indexOfElement = buffer.size();
        }
        buffer.skip(indexOfElement);
    }

    public final boolean ooXIXxIX() throws IOException {
        boolean z;
        long j;
        BufferedSource bufferedSource = this.f1035xoXoI;
        ByteString byteString = f1020ooXIXxIX;
        long indexOf = bufferedSource.indexOf(byteString);
        if (indexOf != -1) {
            z = true;
        } else {
            z = false;
        }
        Buffer buffer = this.f1034o00;
        if (z) {
            j = indexOf + ((long) byteString.size());
        } else {
            j = buffer.size();
        }
        buffer.skip(j);
        return z;
    }

    public void oxoX() throws IOException {
        int i = this.f1031OxI;
        if (i == 0) {
            i = xoXoI();
        }
        if (i == 4) {
            int i2 = this.f1041XO;
            this.f1041XO = i2 - 1;
            int[] iArr = this.f1039Oxx0xo;
            int i3 = i2 - 2;
            iArr[i3] = iArr[i3] + 1;
            this.f1031OxI = 0;
            return;
        }
        throw new JsonDataException("Expected END_ARRAY but was " + x0XOIxOo() + " at path " + getPath());
    }

    public String toString() {
        return "JsonReader(" + this.f1035xoXoI + oIX0oI.I0Io.f17331I0Io;
    }

    public JsonReader.Token x0XOIxOo() throws IOException {
        int i = this.f1031OxI;
        if (i == 0) {
            i = xoXoI();
        }
        switch (i) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void xI() throws IOException {
        long j;
        long indexOfElement = this.f1035xoXoI.indexOfElement(f999IIX0o);
        Buffer buffer = this.f1034o00;
        if (indexOfElement != -1) {
            j = indexOfElement + 1;
        } else {
            j = buffer.size();
        }
        buffer.skip(j);
    }

    public final char xXxxox0I() throws IOException {
        int i;
        if (this.f1035xoXoI.request(1)) {
            byte readByte = this.f1034o00.readByte();
            if (readByte == 10 || readByte == 34 || readByte == 39 || readByte == 47 || readByte == 92) {
                return (char) readByte;
            }
            if (readByte == 98) {
                return 8;
            }
            if (readByte == 102) {
                return 12;
            }
            if (readByte == 110) {
                return 10;
            }
            if (readByte == 114) {
                return 13;
            }
            if (readByte == 116) {
                return 9;
            }
            if (readByte != 117) {
                if (this.f1042oI0IIXIo) {
                    return (char) readByte;
                }
                throw OxxIIOOXO("Invalid escape sequence: \\" + ((char) readByte));
            } else if (this.f1035xoXoI.request(4)) {
                char c = 0;
                for (int i2 = 0; i2 < 4; i2++) {
                    byte b = this.f1034o00.getByte((long) i2);
                    char c2 = (char) (c << 4);
                    if (b >= 48 && b <= 57) {
                        i = b - 48;
                    } else if (b >= 97 && b <= 102) {
                        i = b - 87;
                    } else if (b < 65 || b > 70) {
                        throw OxxIIOOXO("\\u" + this.f1034o00.readUtf8(4));
                    } else {
                        i = b - 55;
                    }
                    c = (char) (c2 + i);
                }
                this.f1034o00.skip(4);
                return c;
            } else {
                throw new EOFException("Unterminated escape sequence at path " + getPath());
            }
        } else {
            throw OxxIIOOXO("Unterminated escape sequence");
        }
    }

    public String xoIox() throws IOException {
        String str;
        int i = this.f1031OxI;
        if (i == 0) {
            i = xoXoI();
        }
        if (i == 14) {
            str = XIxXXX0x0();
        } else if (i == 13) {
            str = XI0IXoo(f1014XxX0x0xxx);
        } else if (i == 12) {
            str = XI0IXoo(f1029xxX);
        } else if (i == 15) {
            str = this.f1033XI0IXoo;
        } else {
            throw new JsonDataException("Expected a name but was " + x0XOIxOo() + " at path " + getPath());
        }
        this.f1031OxI = 0;
        this.f1037IXxxXO[this.f1041XO - 1] = str;
        return str;
    }

    public final int xoXoI() throws IOException {
        int[] iArr = this.f1038Oo;
        int i = this.f1041XO;
        int i2 = iArr[i - 1];
        if (i2 == 1) {
            iArr[i - 1] = 2;
        } else if (i2 == 2) {
            int X0IIOO2 = X0IIOO(true);
            this.f1034o00.readByte();
            if (X0IIOO2 != 44) {
                if (X0IIOO2 == 59) {
                    IIXOooo();
                } else if (X0IIOO2 == 93) {
                    this.f1031OxI = 4;
                    return 4;
                } else {
                    throw OxxIIOOXO("Unterminated array");
                }
            }
        } else if (i2 == 3 || i2 == 5) {
            iArr[i - 1] = 4;
            if (i2 == 5) {
                int X0IIOO3 = X0IIOO(true);
                this.f1034o00.readByte();
                if (X0IIOO3 != 44) {
                    if (X0IIOO3 == 59) {
                        IIXOooo();
                    } else if (X0IIOO3 == 125) {
                        this.f1031OxI = 2;
                        return 2;
                    } else {
                        throw OxxIIOOXO("Unterminated object");
                    }
                }
            }
            int X0IIOO4 = X0IIOO(true);
            if (X0IIOO4 == 34) {
                this.f1034o00.readByte();
                this.f1031OxI = 13;
                return 13;
            } else if (X0IIOO4 == 39) {
                this.f1034o00.readByte();
                IIXOooo();
                this.f1031OxI = 12;
                return 12;
            } else if (X0IIOO4 != 125) {
                IIXOooo();
                if (O0xOxO((char) X0IIOO4)) {
                    this.f1031OxI = 14;
                    return 14;
                }
                throw OxxIIOOXO("Expected name");
            } else if (i2 != 5) {
                this.f1034o00.readByte();
                this.f1031OxI = 2;
                return 2;
            } else {
                throw OxxIIOOXO("Expected name");
            }
        } else if (i2 == 4) {
            iArr[i - 1] = 5;
            int X0IIOO5 = X0IIOO(true);
            this.f1034o00.readByte();
            if (X0IIOO5 != 58) {
                if (X0IIOO5 == 61) {
                    IIXOooo();
                    if (this.f1035xoXoI.request(1) && this.f1034o00.getByte(0) == 62) {
                        this.f1034o00.readByte();
                    }
                } else {
                    throw OxxIIOOXO("Expected ':'");
                }
            }
        } else if (i2 == 6) {
            iArr[i - 1] = 7;
        } else if (i2 == 7) {
            if (X0IIOO(false) == -1) {
                this.f1031OxI = 18;
                return 18;
            }
            IIXOooo();
        } else if (i2 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int X0IIOO6 = X0IIOO(true);
        if (X0IIOO6 == 34) {
            this.f1034o00.readByte();
            this.f1031OxI = 9;
            return 9;
        } else if (X0IIOO6 != 39) {
            if (!(X0IIOO6 == 44 || X0IIOO6 == 59)) {
                if (X0IIOO6 == 91) {
                    this.f1034o00.readByte();
                    this.f1031OxI = 3;
                    return 3;
                } else if (X0IIOO6 != 93) {
                    if (X0IIOO6 != 123) {
                        int xxX2 = xxX();
                        if (xxX2 != 0) {
                            return xxX2;
                        }
                        int XxX0x0xxx2 = XxX0x0xxx();
                        if (XxX0x0xxx2 != 0) {
                            return XxX0x0xxx2;
                        }
                        if (O0xOxO(this.f1034o00.getByte(0))) {
                            IIXOooo();
                            this.f1031OxI = 10;
                            return 10;
                        }
                        throw OxxIIOOXO("Expected value");
                    }
                    this.f1034o00.readByte();
                    this.f1031OxI = 1;
                    return 1;
                } else if (i2 == 1) {
                    this.f1034o00.readByte();
                    this.f1031OxI = 4;
                    return 4;
                }
            }
            if (i2 == 1 || i2 == 2) {
                IIXOooo();
                this.f1031OxI = 7;
                return 7;
            }
            throw OxxIIOOXO("Unexpected value");
        } else {
            IIXOooo();
            this.f1034o00.readByte();
            this.f1031OxI = 8;
            return 8;
        }
    }

    public int xxIXOIIO() throws IOException {
        String str;
        int i = this.f1031OxI;
        if (i == 0) {
            i = xoXoI();
        }
        if (i == 16) {
            long j = this.f1030O0xOxO;
            int i2 = (int) j;
            if (j == ((long) i2)) {
                this.f1031OxI = 0;
                int[] iArr = this.f1039Oxx0xo;
                int i3 = this.f1041XO - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new JsonDataException("Expected an int but was " + this.f1030O0xOxO + " at path " + getPath());
        }
        if (i == 17) {
            this.f1033XI0IXoo = this.f1034o00.readUtf8((long) this.f1032X0IIOO);
        } else if (i == 9 || i == 8) {
            if (i == 9) {
                str = XI0IXoo(f1014XxX0x0xxx);
            } else {
                str = XI0IXoo(f1029xxX);
            }
            this.f1033XI0IXoo = str;
            try {
                int parseInt = Integer.parseInt(str);
                this.f1031OxI = 0;
                int[] iArr2 = this.f1039Oxx0xo;
                int i4 = this.f1041XO - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i != 11) {
            throw new JsonDataException("Expected an int but was " + x0XOIxOo() + " at path " + getPath());
        }
        this.f1031OxI = 11;
        try {
            double parseDouble = Double.parseDouble(this.f1033XI0IXoo);
            int i5 = (int) parseDouble;
            if (((double) i5) == parseDouble) {
                this.f1033XI0IXoo = null;
                this.f1031OxI = 0;
                int[] iArr3 = this.f1039Oxx0xo;
                int i6 = this.f1041XO - 1;
                iArr3[i6] = iArr3[i6] + 1;
                return i5;
            }
            throw new JsonDataException("Expected an int but was " + this.f1033XI0IXoo + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.f1033XI0IXoo + " at path " + getPath());
        }
    }

    public final int xxX() throws IOException {
        int i;
        String str;
        String str2;
        byte b = this.f1034o00.getByte(0);
        if (b == 116 || b == 84) {
            str2 = "true";
            str = "TRUE";
            i = 5;
        } else if (b == 102 || b == 70) {
            str2 = "false";
            str = "FALSE";
            i = 6;
        } else if (b != 110 && b != 78) {
            return 0;
        } else {
            str2 = "null";
            str = X0o0xo.f22232II0XooXoX;
            i = 7;
        }
        int length = str2.length();
        int i2 = 1;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (!this.f1035xoXoI.request((long) i3)) {
                return 0;
            }
            byte b2 = this.f1034o00.getByte((long) i2);
            if (b2 != str2.charAt(i2) && b2 != str.charAt(i2)) {
                return 0;
            }
            i2 = i3;
        }
        if (this.f1035xoXoI.request((long) (length + 1)) && O0xOxO(this.f1034o00.getByte((long) length))) {
            return 0;
        }
        this.f1034o00.skip((long) length);
        this.f1031OxI = i;
        return i;
    }
}
