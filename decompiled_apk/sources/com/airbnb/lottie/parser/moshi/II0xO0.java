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

/* loaded from: classes.dex */
public final class II0xO0 extends JsonReader {

    /* renamed from: I0X0x0oIo, reason: collision with root package name */
    public static final int f4991I0X0x0oIo = 3;

    /* renamed from: I0oOoX, reason: collision with root package name */
    public static final int f4992I0oOoX = 15;

    /* renamed from: IO, reason: collision with root package name */
    public static final int f4994IO = 7;

    /* renamed from: Io, reason: collision with root package name */
    public static final int f4995Io = 12;

    /* renamed from: IoOoX, reason: collision with root package name */
    public static final int f4996IoOoX = 3;

    /* renamed from: O0Xx, reason: collision with root package name */
    public static final int f4997O0Xx = 7;

    /* renamed from: OI0, reason: collision with root package name */
    public static final int f4998OI0 = 11;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public static final int f4999X00IoxXI = 6;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final long f5000XIxXXX0x0 = -922337203685477580L;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public static final int f5001XOxIOxOx = 10;

    /* renamed from: XX, reason: collision with root package name */
    public static final int f5002XX = 14;

    /* renamed from: XX0, reason: collision with root package name */
    public static final int f5003XX0 = 2;

    /* renamed from: Xo0, reason: collision with root package name */
    public static final int f5004Xo0 = 5;

    /* renamed from: XoI0Ixx0, reason: collision with root package name */
    public static final int f5005XoI0Ixx0 = 6;

    /* renamed from: XoX, reason: collision with root package name */
    public static final int f5006XoX = 17;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public static final int f5007Xx000oIo = 5;

    /* renamed from: o0, reason: collision with root package name */
    public static final int f5009o0 = 13;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public static final int f5010oOXoIIIo = 4;

    /* renamed from: oX, reason: collision with root package name */
    public static final int f5011oX = 4;

    /* renamed from: oo, reason: collision with root package name */
    public static final int f5012oo = 2;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public static final int f5013oo0xXOI0I = 1;

    /* renamed from: oxXx0IX, reason: collision with root package name */
    public static final int f5015oxXx0IX = 18;

    /* renamed from: oxxXoxO, reason: collision with root package name */
    public static final int f5016oxxXoxO = 16;

    /* renamed from: x0o, reason: collision with root package name */
    public static final int f5017x0o = 9;

    /* renamed from: xI, reason: collision with root package name */
    public static final int f5018xI = 0;

    /* renamed from: xII, reason: collision with root package name */
    public static final int f5019xII = 8;

    /* renamed from: xXOx, reason: collision with root package name */
    public static final int f5020xXOx = 1;

    /* renamed from: xo0x, reason: collision with root package name */
    public static final int f5022xo0x = 0;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public long f5024O0xOxO;

    /* renamed from: OxI, reason: collision with root package name */
    public int f5025OxI = 0;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public int f5026X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    @Nullable
    public String f5027XI0IXoo;

    /* renamed from: o00, reason: collision with root package name */
    public final Buffer f5028o00;

    /* renamed from: xoXoI, reason: collision with root package name */
    public final BufferedSource f5029xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public static final ByteString f5023xxX = ByteString.encodeUtf8("'\\");

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final ByteString f5008XxX0x0xxx = ByteString.encodeUtf8(BasicHeaderValueFormatter.UNSAFE_CHARS);

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final ByteString f5021xXxxox0I = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");

    /* renamed from: IIX0o, reason: collision with root package name */
    public static final ByteString f4993IIX0o = ByteString.encodeUtf8("\n\r");

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public static final ByteString f5014ooXIXxIX = ByteString.encodeUtf8("*/");

    public II0xO0(BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            this.f5029xoXoI = bufferedSource;
            this.f5028o00 = bufferedSource.buffer();
            oO(6);
            return;
        }
        throw new NullPointerException("source == null");
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void I0Io() throws IOException {
        int i = this.f5025OxI;
        if (i == 0) {
            i = xoXoI();
        }
        if (i == 1) {
            oO(3);
            this.f5025OxI = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + x0XOIxOo() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public double II0XooXoX() throws IOException {
        int i = this.f5025OxI;
        if (i == 0) {
            i = xoXoI();
        }
        if (i == 16) {
            this.f5025OxI = 0;
            int[] iArr = this.f5033Oxx0xo;
            int i2 = this.f5035XO - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f5024O0xOxO;
        }
        if (i == 17) {
            this.f5027XI0IXoo = this.f5028o00.readUtf8(this.f5026X0IIOO);
        } else if (i == 9) {
            this.f5027XI0IXoo = XI0IXoo(f5008XxX0x0xxx);
        } else if (i == 8) {
            this.f5027XI0IXoo = XI0IXoo(f5023xxX);
        } else if (i == 10) {
            this.f5027XI0IXoo = XIxXXX0x0();
        } else if (i != 11) {
            throw new JsonDataException("Expected a double but was " + x0XOIxOo() + " at path " + getPath());
        }
        this.f5025OxI = 11;
        try {
            double parseDouble = Double.parseDouble(this.f5027XI0IXoo);
            if (!this.f5036oI0IIXIo && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
            }
            this.f5027XI0IXoo = null;
            this.f5025OxI = 0;
            int[] iArr2 = this.f5033Oxx0xo;
            int i3 = this.f5035XO - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.f5027XI0IXoo + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void II0xO0() throws IOException {
        int i = this.f5025OxI;
        if (i == 0) {
            i = xoXoI();
        }
        if (i == 3) {
            oO(1);
            this.f5033Oxx0xo[this.f5035XO - 1] = 0;
            this.f5025OxI = 0;
        } else {
            throw new JsonDataException("Expected BEGIN_ARRAY but was " + x0XOIxOo() + " at path " + getPath());
        }
    }

    public final void IIX0o(ByteString byteString) throws IOException {
        while (true) {
            long indexOfElement = this.f5029xoXoI.indexOfElement(byteString);
            if (indexOfElement != -1) {
                if (this.f5028o00.getByte(indexOfElement) == 92) {
                    this.f5028o00.skip(indexOfElement + 1);
                    xXxxox0I();
                } else {
                    this.f5028o00.skip(indexOfElement + 1);
                    return;
                }
            } else {
                throw OxxIIOOXO("Unterminated string");
            }
        }
    }

    public final void IIXOooo() throws IOException {
        if (this.f5036oI0IIXIo) {
        } else {
            throw OxxIIOOXO("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void IXxxXO() throws IOException {
        if (!this.f5034OxxIIOOXO) {
            int i = this.f5025OxI;
            if (i == 0) {
                i = xoXoI();
            }
            if (i == 14) {
                oo0xXOI0I();
            } else if (i == 13) {
                IIX0o(f5008XxX0x0xxx);
            } else if (i == 12) {
                IIX0o(f5023xxX);
            } else if (i != 15) {
                throw new JsonDataException("Expected a name but was " + x0XOIxOo() + " at path " + getPath());
            }
            this.f5025OxI = 0;
            this.f5031IXxxXO[this.f5035XO - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + x0XOIxOo() + " at " + getPath());
    }

    public final boolean O0xOxO(int i) throws IOException {
        if (i != 9 && i != 10 && i != 12 && i != 13 && i != 32) {
            if (i != 35) {
                if (i != 44) {
                    if (i != 47 && i != 61) {
                        if (i != 123 && i != 125 && i != 58) {
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
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
            IIXOooo();
            return false;
        }
        return false;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String OOXIXo() throws IOException {
        String readUtf8;
        int i = this.f5025OxI;
        if (i == 0) {
            i = xoXoI();
        }
        if (i == 10) {
            readUtf8 = XIxXXX0x0();
        } else if (i == 9) {
            readUtf8 = XI0IXoo(f5008XxX0x0xxx);
        } else if (i == 8) {
            readUtf8 = XI0IXoo(f5023xxX);
        } else if (i == 11) {
            readUtf8 = this.f5027XI0IXoo;
            this.f5027XI0IXoo = null;
        } else if (i == 16) {
            readUtf8 = Long.toString(this.f5024O0xOxO);
        } else if (i == 17) {
            readUtf8 = this.f5028o00.readUtf8(this.f5026X0IIOO);
        } else {
            throw new JsonDataException("Expected a string but was " + x0XOIxOo() + " at path " + getPath());
        }
        this.f5025OxI = 0;
        int[] iArr = this.f5033Oxx0xo;
        int i2 = this.f5035XO - 1;
        iArr[i2] = iArr[i2] + 1;
        return readUtf8;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int Oo(JsonReader.oIX0oI oix0oi) throws IOException {
        int i = this.f5025OxI;
        if (i == 0) {
            i = xoXoI();
        }
        if (i < 12 || i > 15) {
            return -1;
        }
        if (i == 15) {
            return o00(this.f5027XI0IXoo, oix0oi);
        }
        int select = this.f5029xoXoI.select(oix0oi.f5037II0xO0);
        if (select != -1) {
            this.f5025OxI = 0;
            this.f5031IXxxXO[this.f5035XO - 1] = oix0oi.f5038oIX0oI[select];
            return select;
        }
        String str = this.f5031IXxxXO[this.f5035XO - 1];
        String xoIox2 = xoIox();
        int o002 = o00(xoIox2, oix0oi);
        if (o002 == -1) {
            this.f5025OxI = 15;
            this.f5027XI0IXoo = xoIox2;
            this.f5031IXxxXO[this.f5035XO - 1] = str;
        }
        return o002;
    }

    public final int OxI(String str, JsonReader.oIX0oI oix0oi) {
        int length = oix0oi.f5038oIX0oI.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(oix0oi.f5038oIX0oI[i])) {
                this.f5025OxI = 0;
                int[] iArr = this.f5033Oxx0xo;
                int i2 = this.f5035XO - 1;
                iArr[i2] = iArr[i2] + 1;
                return i;
            }
        }
        return -1;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean Oxx0IOOO() throws IOException {
        int i = this.f5025OxI;
        if (i == 0) {
            i = xoXoI();
        }
        if (i == 5) {
            this.f5025OxI = 0;
            int[] iArr = this.f5033Oxx0xo;
            int i2 = this.f5035XO - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (i == 6) {
            this.f5025OxI = 0;
            int[] iArr2 = this.f5033Oxx0xo;
            int i3 = this.f5035XO - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        }
        throw new JsonDataException("Expected a boolean but was " + x0XOIxOo() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void Oxx0xo() throws IOException {
        if (!this.f5034OxxIIOOXO) {
            int i = 0;
            do {
                int i2 = this.f5025OxI;
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
                            this.f5035XO--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + x0XOIxOo() + " at path " + getPath());
                        }
                    } else if (i2 == 2) {
                        i--;
                        if (i >= 0) {
                            this.f5035XO--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + x0XOIxOo() + " at path " + getPath());
                        }
                    } else if (i2 != 14 && i2 != 10) {
                        if (i2 != 9 && i2 != 13) {
                            if (i2 != 8 && i2 != 12) {
                                if (i2 == 17) {
                                    this.f5028o00.skip(this.f5026X0IIOO);
                                } else if (i2 == 18) {
                                    throw new JsonDataException("Expected a value but was " + x0XOIxOo() + " at path " + getPath());
                                }
                            } else {
                                IIX0o(f5023xxX);
                            }
                        } else {
                            IIX0o(f5008XxX0x0xxx);
                        }
                    } else {
                        oo0xXOI0I();
                    }
                    this.f5025OxI = 0;
                }
                i++;
                this.f5025OxI = 0;
            } while (i != 0);
            int[] iArr = this.f5033Oxx0xo;
            int i3 = this.f5035XO;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.f5031IXxxXO[i3 - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + x0XOIxOo() + " at " + getPath());
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
    
        r6.f5028o00.skip(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        if (r2 != 47) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0074, code lost:
    
        if (r2 != 35) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0076, code lost:
    
        IIXOooo();
        xI();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007d, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0037, code lost:
    
        if (r6.f5029xoXoI.request(2) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003a, code lost:
    
        IIXOooo();
        r3 = r6.f5028o00.getByte(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        if (r3 == 42) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
    
        r6.f5028o00.readByte();
        r6.f5028o00.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0068, code lost:
    
        if (ooXIXxIX() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0071, code lost:
    
        throw OxxIIOOXO("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0049, code lost:
    
        if (r3 == 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x004c, code lost:
    
        r6.f5028o00.readByte();
        r6.f5028o00.readByte();
        xI();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x004b, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0039, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int X0IIOO(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            okio.BufferedSource r2 = r6.f5029xoXoI
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.request(r4)
            if (r2 == 0) goto L80
            okio.Buffer r2 = r6.f5028o00
            long r4 = (long) r1
            byte r2 = r2.getByte(r4)
            r4 = 10
            if (r2 == r4) goto L7e
            r4 = 32
            if (r2 == r4) goto L7e
            r4 = 13
            if (r2 == r4) goto L7e
            r4 = 9
            if (r2 != r4) goto L25
            goto L7e
        L25:
            okio.Buffer r3 = r6.f5028o00
            long r4 = (long) r1
            r3.skip(r4)
            r1 = 47
            if (r2 != r1) goto L72
            okio.BufferedSource r3 = r6.f5029xoXoI
            r4 = 2
            boolean r3 = r3.request(r4)
            if (r3 != 0) goto L3a
            return r2
        L3a:
            r6.IIXOooo()
            okio.Buffer r3 = r6.f5028o00
            r4 = 1
            byte r3 = r3.getByte(r4)
            r4 = 42
            if (r3 == r4) goto L5a
            if (r3 == r1) goto L4c
            return r2
        L4c:
            okio.Buffer r1 = r6.f5028o00
            r1.readByte()
            okio.Buffer r1 = r6.f5028o00
            r1.readByte()
            r6.xI()
            goto L1
        L5a:
            okio.Buffer r1 = r6.f5028o00
            r1.readByte()
            okio.Buffer r1 = r6.f5028o00
            r1.readByte()
            boolean r1 = r6.ooXIXxIX()
            if (r1 == 0) goto L6b
            goto L1
        L6b:
            java.lang.String r7 = "Unterminated comment"
            com.airbnb.lottie.parser.moshi.JsonEncodingException r7 = r6.OxxIIOOXO(r7)
            throw r7
        L72:
            r1 = 35
            if (r2 != r1) goto L7d
            r6.IIXOooo()
            r6.xI()
            goto L1
        L7d:
            return r2
        L7e:
            r1 = r3
            goto L2
        L80:
            if (r7 != 0) goto L84
            r7 = -1
            return r7
        L84:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.II0xO0.X0IIOO(boolean):int");
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void X0o0xo() throws IOException {
        int i = this.f5025OxI;
        if (i == 0) {
            i = xoXoI();
        }
        if (i == 2) {
            int i2 = this.f5035XO;
            int i3 = i2 - 1;
            this.f5035XO = i3;
            this.f5031IXxxXO[i3] = null;
            int[] iArr = this.f5033Oxx0xo;
            int i4 = i2 - 2;
            iArr[i4] = iArr[i4] + 1;
            this.f5025OxI = 0;
            return;
        }
        throw new JsonDataException("Expected END_OBJECT but was " + x0XOIxOo() + " at path " + getPath());
    }

    public final String XI0IXoo(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long indexOfElement = this.f5029xoXoI.indexOfElement(byteString);
            if (indexOfElement != -1) {
                if (this.f5028o00.getByte(indexOfElement) == 92) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    sb.append(this.f5028o00.readUtf8(indexOfElement));
                    this.f5028o00.readByte();
                    sb.append(xXxxox0I());
                } else {
                    if (sb == null) {
                        String readUtf8 = this.f5028o00.readUtf8(indexOfElement);
                        this.f5028o00.readByte();
                        return readUtf8;
                    }
                    sb.append(this.f5028o00.readUtf8(indexOfElement));
                    this.f5028o00.readByte();
                    return sb.toString();
                }
            } else {
                throw OxxIIOOXO("Unterminated string");
            }
        }
    }

    public final String XIxXXX0x0() throws IOException {
        long indexOfElement = this.f5029xoXoI.indexOfElement(f5021xXxxox0I);
        if (indexOfElement != -1) {
            return this.f5028o00.readUtf8(indexOfElement);
        }
        return this.f5028o00.readUtf8();
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean XO() throws IOException {
        int i = this.f5025OxI;
        if (i == 0) {
            i = xoXoI();
        }
        if (i != 2 && i != 4 && i != 18) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0081, code lost:
    
        if (O0xOxO(r11) != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0083, code lost:
    
        if (r6 != 2) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0085, code lost:
    
        if (r7 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x008b, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008d, code lost:
    
        if (r10 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0091, code lost:
    
        if (r8 != 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0093, code lost:
    
        if (r10 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0095, code lost:
    
        if (r10 == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0098, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0099, code lost:
    
        r16.f5024O0xOxO = r8;
        r16.f5028o00.skip(r5);
        r16.f5025OxI = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a5, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a6, code lost:
    
        if (r6 == 2) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00a9, code lost:
    
        if (r6 == 4) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ac, code lost:
    
        if (r6 != 7) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00af, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b0, code lost:
    
        r16.f5026X0IIOO = r5;
        r16.f5025OxI = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b6, code lost:
    
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00b7, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int XxX0x0xxx() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.II0xO0.XxX0x0xxx():int");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5025OxI = 0;
        this.f5032Oo[0] = 8;
        this.f5035XO = 1;
        this.f5028o00.clear();
        this.f5029xoXoI.close();
    }

    public final int o00(String str, JsonReader.oIX0oI oix0oi) {
        int length = oix0oi.f5038oIX0oI.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(oix0oi.f5038oIX0oI[i])) {
                this.f5025OxI = 0;
                this.f5031IXxxXO[this.f5035XO - 1] = str;
                return i;
            }
        }
        return -1;
    }

    public final void oo0xXOI0I() throws IOException {
        long indexOfElement = this.f5029xoXoI.indexOfElement(f5021xXxxox0I);
        Buffer buffer = this.f5028o00;
        if (indexOfElement == -1) {
            indexOfElement = buffer.size();
        }
        buffer.skip(indexOfElement);
    }

    public final boolean ooXIXxIX() throws IOException {
        boolean z;
        long size;
        long indexOf = this.f5029xoXoI.indexOf(f5014ooXIXxIX);
        if (indexOf != -1) {
            z = true;
        } else {
            z = false;
        }
        Buffer buffer = this.f5028o00;
        if (z) {
            size = indexOf + r1.size();
        } else {
            size = buffer.size();
        }
        buffer.skip(size);
        return z;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void oxoX() throws IOException {
        int i = this.f5025OxI;
        if (i == 0) {
            i = xoXoI();
        }
        if (i == 4) {
            int i2 = this.f5035XO;
            this.f5035XO = i2 - 1;
            int[] iArr = this.f5033Oxx0xo;
            int i3 = i2 - 2;
            iArr[i3] = iArr[i3] + 1;
            this.f5025OxI = 0;
            return;
        }
        throw new JsonDataException("Expected END_ARRAY but was " + x0XOIxOo() + " at path " + getPath());
    }

    public String toString() {
        return "JsonReader(" + this.f5029xoXoI + oIX0oI.I0Io.f4095I0Io;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public JsonReader.Token x0XOIxOo() throws IOException {
        int i = this.f5025OxI;
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
        long size;
        long indexOfElement = this.f5029xoXoI.indexOfElement(f4993IIX0o);
        Buffer buffer = this.f5028o00;
        if (indexOfElement != -1) {
            size = indexOfElement + 1;
        } else {
            size = buffer.size();
        }
        buffer.skip(size);
    }

    public final char xXxxox0I() throws IOException {
        int i;
        if (this.f5029xoXoI.request(1L)) {
            byte readByte = this.f5028o00.readByte();
            if (readByte != 10 && readByte != 34 && readByte != 39 && readByte != 47 && readByte != 92) {
                if (readByte != 98) {
                    if (readByte != 102) {
                        if (readByte == 110) {
                            return '\n';
                        }
                        if (readByte != 114) {
                            if (readByte != 116) {
                                if (readByte != 117) {
                                    if (this.f5036oI0IIXIo) {
                                        return (char) readByte;
                                    }
                                    throw OxxIIOOXO("Invalid escape sequence: \\" + ((char) readByte));
                                }
                                if (this.f5029xoXoI.request(4L)) {
                                    char c = 0;
                                    for (int i2 = 0; i2 < 4; i2++) {
                                        byte b = this.f5028o00.getByte(i2);
                                        char c2 = (char) (c << 4);
                                        if (b >= 48 && b <= 57) {
                                            i = b - 48;
                                        } else if (b >= 97 && b <= 102) {
                                            i = b - 87;
                                        } else {
                                            if (b < 65 || b > 70) {
                                                throw OxxIIOOXO("\\u" + this.f5028o00.readUtf8(4L));
                                            }
                                            i = b - 55;
                                        }
                                        c = (char) (c2 + i);
                                    }
                                    this.f5028o00.skip(4L);
                                    return c;
                                }
                                throw new EOFException("Unterminated escape sequence at path " + getPath());
                            }
                            return '\t';
                        }
                        return '\r';
                    }
                    return '\f';
                }
                return '\b';
            }
            return (char) readByte;
        }
        throw OxxIIOOXO("Unterminated escape sequence");
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String xoIox() throws IOException {
        String str;
        int i = this.f5025OxI;
        if (i == 0) {
            i = xoXoI();
        }
        if (i == 14) {
            str = XIxXXX0x0();
        } else if (i == 13) {
            str = XI0IXoo(f5008XxX0x0xxx);
        } else if (i == 12) {
            str = XI0IXoo(f5023xxX);
        } else if (i == 15) {
            str = this.f5027XI0IXoo;
        } else {
            throw new JsonDataException("Expected a name but was " + x0XOIxOo() + " at path " + getPath());
        }
        this.f5025OxI = 0;
        this.f5031IXxxXO[this.f5035XO - 1] = str;
        return str;
    }

    public final int xoXoI() throws IOException {
        int[] iArr = this.f5032Oo;
        int i = this.f5035XO;
        int i2 = iArr[i - 1];
        if (i2 == 1) {
            iArr[i - 1] = 2;
        } else if (i2 == 2) {
            int X0IIOO2 = X0IIOO(true);
            this.f5028o00.readByte();
            if (X0IIOO2 != 44) {
                if (X0IIOO2 != 59) {
                    if (X0IIOO2 == 93) {
                        this.f5025OxI = 4;
                        return 4;
                    }
                    throw OxxIIOOXO("Unterminated array");
                }
                IIXOooo();
            }
        } else if (i2 != 3 && i2 != 5) {
            if (i2 == 4) {
                iArr[i - 1] = 5;
                int X0IIOO3 = X0IIOO(true);
                this.f5028o00.readByte();
                if (X0IIOO3 != 58) {
                    if (X0IIOO3 == 61) {
                        IIXOooo();
                        if (this.f5029xoXoI.request(1L) && this.f5028o00.getByte(0L) == 62) {
                            this.f5028o00.readByte();
                        }
                    } else {
                        throw OxxIIOOXO("Expected ':'");
                    }
                }
            } else if (i2 == 6) {
                iArr[i - 1] = 7;
            } else if (i2 == 7) {
                if (X0IIOO(false) == -1) {
                    this.f5025OxI = 18;
                    return 18;
                }
                IIXOooo();
            } else if (i2 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        } else {
            iArr[i - 1] = 4;
            if (i2 == 5) {
                int X0IIOO4 = X0IIOO(true);
                this.f5028o00.readByte();
                if (X0IIOO4 != 44) {
                    if (X0IIOO4 != 59) {
                        if (X0IIOO4 == 125) {
                            this.f5025OxI = 2;
                            return 2;
                        }
                        throw OxxIIOOXO("Unterminated object");
                    }
                    IIXOooo();
                }
            }
            int X0IIOO5 = X0IIOO(true);
            if (X0IIOO5 != 34) {
                if (X0IIOO5 != 39) {
                    if (X0IIOO5 != 125) {
                        IIXOooo();
                        if (O0xOxO((char) X0IIOO5)) {
                            this.f5025OxI = 14;
                            return 14;
                        }
                        throw OxxIIOOXO("Expected name");
                    }
                    if (i2 != 5) {
                        this.f5028o00.readByte();
                        this.f5025OxI = 2;
                        return 2;
                    }
                    throw OxxIIOOXO("Expected name");
                }
                this.f5028o00.readByte();
                IIXOooo();
                this.f5025OxI = 12;
                return 12;
            }
            this.f5028o00.readByte();
            this.f5025OxI = 13;
            return 13;
        }
        int X0IIOO6 = X0IIOO(true);
        if (X0IIOO6 != 34) {
            if (X0IIOO6 != 39) {
                if (X0IIOO6 != 44 && X0IIOO6 != 59) {
                    if (X0IIOO6 != 91) {
                        if (X0IIOO6 != 93) {
                            if (X0IIOO6 != 123) {
                                int xxX2 = xxX();
                                if (xxX2 != 0) {
                                    return xxX2;
                                }
                                int XxX0x0xxx2 = XxX0x0xxx();
                                if (XxX0x0xxx2 != 0) {
                                    return XxX0x0xxx2;
                                }
                                if (O0xOxO(this.f5028o00.getByte(0L))) {
                                    IIXOooo();
                                    this.f5025OxI = 10;
                                    return 10;
                                }
                                throw OxxIIOOXO("Expected value");
                            }
                            this.f5028o00.readByte();
                            this.f5025OxI = 1;
                            return 1;
                        }
                        if (i2 == 1) {
                            this.f5028o00.readByte();
                            this.f5025OxI = 4;
                            return 4;
                        }
                    } else {
                        this.f5028o00.readByte();
                        this.f5025OxI = 3;
                        return 3;
                    }
                }
                if (i2 != 1 && i2 != 2) {
                    throw OxxIIOOXO("Unexpected value");
                }
                IIXOooo();
                this.f5025OxI = 7;
                return 7;
            }
            IIXOooo();
            this.f5028o00.readByte();
            this.f5025OxI = 8;
            return 8;
        }
        this.f5028o00.readByte();
        this.f5025OxI = 9;
        return 9;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int xxIXOIIO() throws IOException {
        String XI0IXoo2;
        int i = this.f5025OxI;
        if (i == 0) {
            i = xoXoI();
        }
        if (i == 16) {
            long j = this.f5024O0xOxO;
            int i2 = (int) j;
            if (j == i2) {
                this.f5025OxI = 0;
                int[] iArr = this.f5033Oxx0xo;
                int i3 = this.f5035XO - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new JsonDataException("Expected an int but was " + this.f5024O0xOxO + " at path " + getPath());
        }
        if (i == 17) {
            this.f5027XI0IXoo = this.f5028o00.readUtf8(this.f5026X0IIOO);
        } else if (i != 9 && i != 8) {
            if (i != 11) {
                throw new JsonDataException("Expected an int but was " + x0XOIxOo() + " at path " + getPath());
            }
        } else {
            if (i == 9) {
                XI0IXoo2 = XI0IXoo(f5008XxX0x0xxx);
            } else {
                XI0IXoo2 = XI0IXoo(f5023xxX);
            }
            this.f5027XI0IXoo = XI0IXoo2;
            try {
                int parseInt = Integer.parseInt(XI0IXoo2);
                this.f5025OxI = 0;
                int[] iArr2 = this.f5033Oxx0xo;
                int i4 = this.f5035XO - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f5025OxI = 11;
        try {
            double parseDouble = Double.parseDouble(this.f5027XI0IXoo);
            int i5 = (int) parseDouble;
            if (i5 == parseDouble) {
                this.f5027XI0IXoo = null;
                this.f5025OxI = 0;
                int[] iArr3 = this.f5033Oxx0xo;
                int i6 = this.f5035XO - 1;
                iArr3[i6] = iArr3[i6] + 1;
                return i5;
            }
            throw new JsonDataException("Expected an int but was " + this.f5027XI0IXoo + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.f5027XI0IXoo + " at path " + getPath());
        }
    }

    public final int xxX() throws IOException {
        String str;
        String str2;
        int i;
        byte b = this.f5028o00.getByte(0L);
        if (b != 116 && b != 84) {
            if (b != 102 && b != 70) {
                if (b != 110 && b != 78) {
                    return 0;
                }
                str = "null";
                str2 = X0o0xo.f33252II0XooXoX;
                i = 7;
            } else {
                str = "false";
                str2 = "FALSE";
                i = 6;
            }
        } else {
            str = "true";
            str2 = "TRUE";
            i = 5;
        }
        int length = str.length();
        int i2 = 1;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (!this.f5029xoXoI.request(i3)) {
                return 0;
            }
            byte b2 = this.f5028o00.getByte(i2);
            if (b2 != str.charAt(i2) && b2 != str2.charAt(i2)) {
                return 0;
            }
            i2 = i3;
        }
        if (this.f5029xoXoI.request(length + 1) && O0xOxO(this.f5028o00.getByte(length))) {
            return 0;
        }
        this.f5028o00.skip(length);
        this.f5025OxI = i;
        return i;
    }
}
