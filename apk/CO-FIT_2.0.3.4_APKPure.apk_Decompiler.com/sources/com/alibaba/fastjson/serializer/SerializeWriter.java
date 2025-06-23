package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.RyuDouble;
import com.alibaba.fastjson.util.RyuFloat;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.List;
import okhttp3.HttpUrl;
import okio.Utf8;

public final class SerializeWriter extends Writer {
    private static int BUFFER_THRESHOLD;
    private static final char[] VALUE_FALSE = ":false".toCharArray();
    private static final char[] VALUE_TRUE = ":true".toCharArray();
    private static final ThreadLocal<char[]> bufLocal = new ThreadLocal<>();
    private static final ThreadLocal<byte[]> bytesBufLocal = new ThreadLocal<>();
    static final int nonDirectFeatures = ((((((((SerializerFeature.UseSingleQuotes.mask | SerializerFeature.BrowserCompatible.mask) | SerializerFeature.PrettyFormat.mask) | SerializerFeature.WriteEnumUsingToString.mask) | SerializerFeature.WriteNonStringValueAsString.mask) | SerializerFeature.WriteSlashAsSpecial.mask) | SerializerFeature.IgnoreErrorGetter.mask) | SerializerFeature.WriteClassName.mask) | SerializerFeature.NotWriteDefaultValue.mask);
    protected boolean beanToArray;
    protected boolean browserSecure;
    protected char[] buf;
    protected int count;
    protected boolean disableCircularReferenceDetect;
    protected int features;
    protected char keySeperator;
    protected int maxBufSize;
    protected boolean notWriteDefaultValue;
    protected boolean quoteFieldNames;
    protected long sepcialBits;
    protected boolean sortField;
    protected boolean useSingleQuotes;
    protected boolean writeDirect;
    protected boolean writeEnumUsingName;
    protected boolean writeEnumUsingToString;
    protected boolean writeNonStringValueAsString;
    private final Writer writer;

    static {
        int parseInt;
        BUFFER_THRESHOLD = 131072;
        try {
            String stringProperty = IOUtils.getStringProperty("fastjson.serializer_buffer_threshold");
            if (stringProperty != null && stringProperty.length() > 0 && (parseInt = Integer.parseInt(stringProperty)) >= 64 && parseInt <= 65536) {
                BUFFER_THRESHOLD = parseInt * 1024;
            }
        } catch (Throwable unused) {
        }
    }

    public SerializeWriter() {
        this((Writer) null);
    }

    private int encodeToUTF8(OutputStream outputStream) throws IOException {
        byte[] bArr;
        int i = (int) (((double) this.count) * 3.0d);
        ThreadLocal<byte[]> threadLocal = bytesBufLocal;
        byte[] bArr2 = threadLocal.get();
        if (bArr2 == null) {
            bArr2 = new byte[8192];
            threadLocal.set(bArr2);
        }
        if (bArr2.length < i) {
            bArr = new byte[i];
        } else {
            bArr = bArr2;
        }
        int encodeUTF8 = IOUtils.encodeUTF8(this.buf, 0, this.count, bArr);
        outputStream.write(bArr, 0, encodeUTF8);
        if (bArr != bArr2 && bArr.length <= BUFFER_THRESHOLD) {
            threadLocal.set(bArr);
        }
        return encodeUTF8;
    }

    private byte[] encodeToUTF8Bytes() {
        byte[] bArr;
        int i = (int) (((double) this.count) * 3.0d);
        ThreadLocal<byte[]> threadLocal = bytesBufLocal;
        byte[] bArr2 = threadLocal.get();
        if (bArr2 == null) {
            bArr2 = new byte[8192];
            threadLocal.set(bArr2);
        }
        if (bArr2.length < i) {
            bArr = new byte[i];
        } else {
            bArr = bArr2;
        }
        int encodeUTF8 = IOUtils.encodeUTF8(this.buf, 0, this.count, bArr);
        byte[] bArr3 = new byte[encodeUTF8];
        System.arraycopy(bArr, 0, bArr3, 0, encodeUTF8);
        if (bArr != bArr2 && bArr.length <= BUFFER_THRESHOLD) {
            threadLocal.set(bArr);
        }
        return bArr3;
    }

    private void writeEnumFieldValue(char c, String str, String str2) {
        if (this.useSingleQuotes) {
            writeFieldValue(c, str, str2);
        } else {
            writeFieldValueStringWithDoubleQuote(c, str, str2);
        }
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(String str) {
        String str2 = str;
        byte[] bArr = IOUtils.specicalFlags_singleQuotes;
        int length = str.length();
        boolean z = true;
        int i = this.count + length + 1;
        int i2 = 0;
        if (i > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i);
            } else if (length == 0) {
                write(39);
                write(39);
                write(58);
                return;
            } else {
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        char charAt = str2.charAt(i3);
                        if (charAt < bArr.length && bArr[charAt] != 0) {
                            break;
                        }
                        i3++;
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    write(39);
                }
                while (i2 < length) {
                    char charAt2 = str2.charAt(i2);
                    if (charAt2 >= bArr.length || bArr[charAt2] == 0) {
                        write((int) charAt2);
                    } else {
                        write(92);
                        write((int) IOUtils.replaceChars[charAt2]);
                    }
                    i2++;
                }
                if (z) {
                    write(39);
                }
                write(58);
                return;
            }
        }
        if (length == 0) {
            int i4 = this.count;
            if (i4 + 3 > this.buf.length) {
                expandCapacity(i4 + 3);
            }
            char[] cArr = this.buf;
            int i5 = this.count;
            int i6 = i5 + 1;
            this.count = i6;
            cArr[i5] = '\'';
            int i7 = i5 + 2;
            this.count = i7;
            cArr[i6] = '\'';
            this.count = i5 + 3;
            cArr[i7] = ':';
            return;
        }
        int i8 = this.count;
        int i9 = i8 + length;
        str2.getChars(0, length, this.buf, i8);
        this.count = i;
        int i10 = i8;
        boolean z2 = false;
        while (i10 < i9) {
            char[] cArr2 = this.buf;
            char c = cArr2[i10];
            if (c < bArr.length && bArr[c] != 0) {
                if (!z2) {
                    i += 3;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr3 = this.buf;
                    int i11 = i10 + 1;
                    System.arraycopy(cArr3, i11, cArr3, i10 + 3, (i9 - i10) - 1);
                    char[] cArr4 = this.buf;
                    System.arraycopy(cArr4, i2, cArr4, 1, i10);
                    char[] cArr5 = this.buf;
                    cArr5[i8] = '\'';
                    cArr5[i11] = '\\';
                    i10 += 2;
                    cArr5[i10] = IOUtils.replaceChars[c];
                    i9 += 2;
                    cArr5[this.count - 2] = '\'';
                    z2 = true;
                } else {
                    i++;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr6 = this.buf;
                    int i12 = i10 + 1;
                    System.arraycopy(cArr6, i12, cArr6, i10 + 2, i9 - i10);
                    char[] cArr7 = this.buf;
                    cArr7[i10] = '\\';
                    cArr7[i12] = IOUtils.replaceChars[c];
                    i9++;
                    i10 = i12;
                }
            }
            i10++;
            i2 = 0;
        }
        this.buf[i - 1] = ':';
    }

    public void close() {
        if (this.writer != null && this.count > 0) {
            flush();
        }
        char[] cArr = this.buf;
        if (cArr.length <= BUFFER_THRESHOLD) {
            bufLocal.set(cArr);
        }
        this.buf = null;
    }

    public void computeFeatures() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        char c;
        long j;
        int i = this.features;
        boolean z11 = false;
        if ((SerializerFeature.QuoteFieldNames.mask & i) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.quoteFieldNames = z;
        if ((SerializerFeature.UseSingleQuotes.mask & i) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.useSingleQuotes = z2;
        if ((SerializerFeature.SortField.mask & i) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.sortField = z3;
        if ((SerializerFeature.DisableCircularReferenceDetect.mask & i) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.disableCircularReferenceDetect = z4;
        if ((SerializerFeature.BeanToArray.mask & i) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.beanToArray = z5;
        if ((SerializerFeature.WriteNonStringValueAsString.mask & i) != 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        this.writeNonStringValueAsString = z6;
        if ((SerializerFeature.NotWriteDefaultValue.mask & i) != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.notWriteDefaultValue = z7;
        if ((SerializerFeature.WriteEnumUsingName.mask & i) != 0) {
            z8 = true;
        } else {
            z8 = false;
        }
        this.writeEnumUsingName = z8;
        if ((SerializerFeature.WriteEnumUsingToString.mask & i) != 0) {
            z9 = true;
        } else {
            z9 = false;
        }
        this.writeEnumUsingToString = z9;
        if (!z || (nonDirectFeatures & i) != 0 || (!z5 && !z8)) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.writeDirect = z10;
        if (z2) {
            c = '\'';
        } else {
            c = '\"';
        }
        this.keySeperator = c;
        if ((SerializerFeature.BrowserSecure.mask & i) != 0) {
            z11 = true;
        }
        this.browserSecure = z11;
        if (z11) {
            j = 5764610843043954687L;
        } else if ((i & SerializerFeature.WriteSlashAsSpecial.mask) != 0) {
            j = 140758963191807L;
        } else {
            j = 21474836479L;
        }
        this.sepcialBits = j;
    }

    public void config(SerializerFeature serializerFeature, boolean z) {
        if (z) {
            int mask = this.features | serializerFeature.getMask();
            this.features = mask;
            SerializerFeature serializerFeature2 = SerializerFeature.WriteEnumUsingToString;
            if (serializerFeature == serializerFeature2) {
                this.features = (~SerializerFeature.WriteEnumUsingName.getMask()) & mask;
            } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                this.features = (~serializerFeature2.getMask()) & mask;
            }
        } else {
            this.features = (~serializerFeature.getMask()) & this.features;
        }
        computeFeatures();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0045, code lost:
        r0 = bufLocal;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void expandCapacity(int r4) {
        /*
            r3 = this;
            int r0 = r3.maxBufSize
            r1 = -1
            if (r0 == r1) goto L_0x0029
            if (r4 >= r0) goto L_0x0008
            goto L_0x0029
        L_0x0008:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "serialize exceeded MAX_OUTPUT_LENGTH="
            r1.append(r2)
            int r2 = r3.maxBufSize
            r1.append(r2)
            java.lang.String r2 = ", minimumCapacity="
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        L_0x0029:
            char[] r0 = r3.buf
            int r1 = r0.length
            int r2 = r0.length
            int r2 = r2 >> 1
            int r1 = r1 + r2
            int r1 = r1 + 1
            if (r1 >= r4) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r4 = r1
        L_0x0036:
            char[] r4 = new char[r4]
            int r1 = r3.count
            r2 = 0
            java.lang.System.arraycopy(r0, r2, r4, r2, r1)
            char[] r0 = r3.buf
            int r0 = r0.length
            int r1 = BUFFER_THRESHOLD
            if (r0 >= r1) goto L_0x005a
            java.lang.ThreadLocal<char[]> r0 = bufLocal
            java.lang.Object r1 = r0.get()
            char[] r1 = (char[]) r1
            if (r1 == 0) goto L_0x0055
            int r1 = r1.length
            char[] r2 = r3.buf
            int r2 = r2.length
            if (r1 >= r2) goto L_0x005a
        L_0x0055:
            char[] r1 = r3.buf
            r0.set(r1)
        L_0x005a:
            r3.buf = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.expandCapacity(int):void");
    }

    public void flush() {
        Writer writer2 = this.writer;
        if (writer2 != null) {
            try {
                writer2.write(this.buf, 0, this.count);
                this.writer.flush();
                this.count = 0;
            } catch (IOException e) {
                throw new JSONException(e.getMessage(), e);
            }
        }
    }

    public int getBufferLength() {
        return this.buf.length;
    }

    public int getMaxBufSize() {
        return this.maxBufSize;
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        return (serializerFeature.mask & this.features) != 0;
    }

    public boolean isNotWriteDefaultValue() {
        return this.notWriteDefaultValue;
    }

    public boolean isSortField() {
        return this.sortField;
    }

    public void reset() {
        this.count = 0;
    }

    public void setMaxBufSize(int i) {
        if (i >= this.buf.length) {
            this.maxBufSize = i;
            return;
        }
        throw new JSONException("must > " + this.buf.length);
    }

    public int size() {
        return this.count;
    }

    public byte[] toBytes(String str) {
        Charset charset;
        if (str == null || "UTF-8".equals(str)) {
            charset = IOUtils.UTF8;
        } else {
            charset = Charset.forName(str);
        }
        return toBytes(charset);
    }

    public char[] toCharArray() {
        if (this.writer == null) {
            int i = this.count;
            char[] cArr = new char[i];
            System.arraycopy(this.buf, 0, cArr, 0, i);
            return cArr;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public char[] toCharArrayForSpringWebSocket() {
        if (this.writer == null) {
            int i = this.count;
            char[] cArr = new char[(i - 2)];
            System.arraycopy(this.buf, 1, cArr, 0, i - 2);
            return cArr;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    public void write(int i) {
        int i2 = 1;
        int i3 = this.count + 1;
        if (i3 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i3);
            } else {
                flush();
                this.buf[this.count] = (char) i;
                this.count = i2;
            }
        }
        i2 = i3;
        this.buf[this.count] = (char) i;
        this.count = i2;
    }

    public void writeByteArray(byte[] bArr) {
        char c;
        char c2;
        char c3;
        String str;
        byte[] bArr2 = bArr;
        if (isEnabled(SerializerFeature.WriteClassName.mask)) {
            writeHex(bArr);
            return;
        }
        int length = bArr2.length;
        boolean z = this.useSingleQuotes;
        if (z) {
            c = '\'';
        } else {
            c = '\"';
        }
        if (length == 0) {
            if (z) {
                str = "''";
            } else {
                str = "\"\"";
            }
            write(str);
            return;
        }
        char[] cArr = IOUtils.CA;
        int i = (length / 3) * 3;
        int i2 = length - 1;
        int i3 = this.count;
        int i4 = (((i2 / 3) + 1) << 2) + i3;
        int i5 = i4 + 2;
        int i6 = 0;
        if (i5 > this.buf.length) {
            if (this.writer != null) {
                write((int) c);
                int i7 = 0;
                while (i7 < i) {
                    int i8 = i7 + 2;
                    int i9 = (bArr2[i7 + 1] & 255) << 8;
                    i7 += 3;
                    byte b = i9 | ((bArr2[i7] & 255) << 16) | (bArr2[i8] & 255);
                    write((int) cArr[(b >>> 18) & 63]);
                    write((int) cArr[(b >>> 12) & 63]);
                    write((int) cArr[(b >>> 6) & 63]);
                    write((int) cArr[b & Utf8.REPLACEMENT_BYTE]);
                }
                int i10 = length - i;
                if (i10 > 0) {
                    int i11 = (bArr2[i] & 255) << 10;
                    if (i10 == 2) {
                        i6 = (bArr2[i2] & 255) << 2;
                    }
                    int i12 = i11 | i6;
                    write((int) cArr[i12 >> 12]);
                    write((int) cArr[(i12 >>> 6) & 63]);
                    if (i10 == 2) {
                        c3 = cArr[i12 & 63];
                    } else {
                        c3 = '=';
                    }
                    write((int) c3);
                    write(61);
                }
                write((int) c);
                return;
            }
            expandCapacity(i5);
        }
        this.count = i5;
        int i13 = i3 + 1;
        this.buf[i3] = c;
        int i14 = 0;
        while (i14 < i) {
            int i15 = i14 + 2;
            int i16 = (bArr2[i14 + 1] & 255) << 8;
            i14 += 3;
            byte b2 = i16 | ((bArr2[i14] & 255) << 16) | (bArr2[i15] & 255);
            char[] cArr2 = this.buf;
            cArr2[i13] = cArr[(b2 >>> 18) & 63];
            cArr2[i13 + 1] = cArr[(b2 >>> 12) & 63];
            int i17 = i13 + 3;
            cArr2[i13 + 2] = cArr[(b2 >>> 6) & 63];
            i13 += 4;
            cArr2[i17] = cArr[b2 & Utf8.REPLACEMENT_BYTE];
        }
        int i18 = length - i;
        if (i18 > 0) {
            int i19 = (bArr2[i] & 255) << 10;
            if (i18 == 2) {
                i6 = (bArr2[i2] & 255) << 2;
            }
            int i20 = i19 | i6;
            char[] cArr3 = this.buf;
            cArr3[i4 - 3] = cArr[i20 >> 12];
            cArr3[i4 - 2] = cArr[(i20 >>> 6) & 63];
            int i21 = i4 - 1;
            if (i18 == 2) {
                c2 = cArr[i20 & 63];
            } else {
                c2 = '=';
            }
            cArr3[i21] = c2;
            cArr3[i4] = '=';
        }
        this.buf[i4 + 1] = c;
    }

    public void writeDouble(double d, boolean z) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            writeNull();
            return;
        }
        int i = this.count + 24;
        if (i > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i);
            } else {
                String ryuDouble = RyuDouble.toString(d);
                write(ryuDouble, 0, ryuDouble.length());
                if (z && isEnabled(SerializerFeature.WriteClassName)) {
                    write(68);
                    return;
                }
                return;
            }
        }
        this.count += RyuDouble.toString(d, this.buf, this.count);
        if (z && isEnabled(SerializerFeature.WriteClassName)) {
            write(68);
        }
    }

    public void writeEnum(Enum<?> enumR) {
        String str;
        int i;
        if (enumR == null) {
            writeNull();
            return;
        }
        if (this.writeEnumUsingName && !this.writeEnumUsingToString) {
            str = enumR.name();
        } else if (this.writeEnumUsingToString) {
            str = enumR.toString();
        } else {
            str = null;
        }
        if (str != null) {
            if (isEnabled(SerializerFeature.UseSingleQuotes)) {
                i = 39;
            } else {
                i = 34;
            }
            write(i);
            write(str);
            write(i);
            return;
        }
        writeInt(enumR.ordinal());
    }

    public void writeFieldName(String str) {
        writeFieldName(str, false);
    }

    public void writeFieldNameDirect(String str) {
        int length = str.length();
        int i = this.count + length;
        int i2 = i + 3;
        if (i2 > this.buf.length) {
            expandCapacity(i2);
        }
        int i3 = this.count;
        char[] cArr = this.buf;
        cArr[i3] = '\"';
        str.getChars(0, length, cArr, i3 + 1);
        this.count = i2;
        char[] cArr2 = this.buf;
        cArr2[i + 1] = '\"';
        cArr2[i + 2] = ':';
    }

    public void writeFieldValue(char c, String str, char c2) {
        write((int) c);
        writeFieldName(str);
        if (c2 == 0) {
            writeString("\u0000");
        } else {
            writeString(Character.toString(c2));
        }
    }

    public void writeFieldValueStringWithDoubleQuote(char c, String str, String str2) {
        int length = str.length();
        int i = this.count;
        int length2 = str2.length();
        int i2 = i + length + length2 + 6;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                write((int) c);
                writeStringWithDoubleQuote(str, ':');
                writeStringWithDoubleQuote(str2, 0);
                return;
            }
            expandCapacity(i2);
        }
        char[] cArr = this.buf;
        int i3 = this.count;
        cArr[i3] = c;
        int i4 = i3 + 2;
        int i5 = i4 + length;
        cArr[i3 + 1] = '\"';
        str.getChars(0, length, cArr, i4);
        this.count = i2;
        char[] cArr2 = this.buf;
        cArr2[i5] = '\"';
        cArr2[i5 + 1] = ':';
        cArr2[i5 + 2] = '\"';
        str2.getChars(0, length2, cArr2, i5 + 3);
        this.buf[this.count - 1] = '\"';
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00cd, code lost:
        if (r1[r3] == 4) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0220, code lost:
        if (r3 != '>') goto L_0x0266;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeFieldValueStringWithDoubleQuoteCheck(char r22, java.lang.String r23, java.lang.String r24) {
        /*
            r21 = this;
            r0 = r21
            r1 = r23
            r2 = r24
            int r3 = r23.length()
            int r4 = r0.count
            if (r2 != 0) goto L_0x0013
            int r6 = r3 + 8
            int r4 = r4 + r6
            r6 = 4
            goto L_0x001c
        L_0x0013:
            int r6 = r24.length()
            int r7 = r3 + r6
            int r7 = r7 + 6
            int r4 = r4 + r7
        L_0x001c:
            char[] r7 = r0.buf
            int r7 = r7.length
            r8 = 58
            r9 = 0
            if (r4 <= r7) goto L_0x0035
            java.io.Writer r7 = r0.writer
            if (r7 == 0) goto L_0x0032
            r21.write((int) r22)
            r0.writeStringWithDoubleQuote((java.lang.String) r1, (char) r8)
            r0.writeStringWithDoubleQuote((java.lang.String) r2, (char) r9)
            return
        L_0x0032:
            r0.expandCapacity(r4)
        L_0x0035:
            char[] r7 = r0.buf
            int r10 = r0.count
            r7[r10] = r22
            int r11 = r10 + 2
            int r12 = r11 + r3
            r13 = 1
            int r10 = r10 + r13
            r14 = 34
            r7[r10] = r14
            r1.getChars(r9, r3, r7, r11)
            r0.count = r4
            char[] r1 = r0.buf
            r1[r12] = r14
            int r3 = r12 + 1
            int r7 = r12 + 2
            r1[r3] = r8
            r3 = 117(0x75, float:1.64E-43)
            if (r2 != 0) goto L_0x006b
            int r2 = r12 + 3
            r4 = 110(0x6e, float:1.54E-43)
            r1[r7] = r4
            int r4 = r12 + 4
            r1[r2] = r3
            int r12 = r12 + 5
            r2 = 108(0x6c, float:1.51E-43)
            r1[r4] = r2
            r1[r12] = r2
            return
        L_0x006b:
            int r12 = r12 + 3
            r1[r7] = r14
            int r7 = r12 + r6
            r2.getChars(r9, r6, r1, r12)
            r1 = -1
            r8 = r12
            r6 = 0
            r10 = -1
            r11 = -1
        L_0x0079:
            r5 = 8233(0x2029, float:1.1537E-41)
            r15 = 8232(0x2028, float:1.1535E-41)
            r14 = 92
            if (r8 >= r7) goto L_0x00e6
            char[] r3 = r0.buf
            char r3 = r3[r8]
            r13 = 93
            if (r3 < r13) goto L_0x009f
            r13 = 127(0x7f, float:1.78E-43)
            if (r3 < r13) goto L_0x00dc
            if (r3 == r15) goto L_0x0095
            if (r3 == r5) goto L_0x0095
            r5 = 160(0xa0, float:2.24E-43)
            if (r3 >= r5) goto L_0x00dc
        L_0x0095:
            if (r10 != r1) goto L_0x0098
            r10 = r8
        L_0x0098:
            int r9 = r9 + 1
            int r4 = r4 + 4
            r6 = r3
        L_0x009d:
            r11 = r8
            goto L_0x00dc
        L_0x009f:
            r5 = 64
            if (r3 >= r5) goto L_0x00b1
            long r1 = r0.sepcialBits
            r19 = 1
            long r19 = r19 << r3
            long r1 = r1 & r19
            r19 = 0
            int r5 = (r1 > r19 ? 1 : (r1 == r19 ? 0 : -1))
            if (r5 != 0) goto L_0x00b3
        L_0x00b1:
            if (r3 != r14) goto L_0x00db
        L_0x00b3:
            int r9 = r9 + 1
            r1 = 40
            if (r3 == r1) goto L_0x00d2
            r1 = 41
            if (r3 == r1) goto L_0x00d2
            r1 = 60
            if (r3 == r1) goto L_0x00d2
            r1 = 62
            if (r3 == r1) goto L_0x00d2
            byte[] r1 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r2 = r1.length
            if (r3 >= r2) goto L_0x00d0
            byte r1 = r1[r3]
            r2 = 4
            if (r1 != r2) goto L_0x00d0
            goto L_0x00d2
        L_0x00d0:
            r1 = -1
            goto L_0x00d5
        L_0x00d2:
            int r4 = r4 + 4
            goto L_0x00d0
        L_0x00d5:
            r6 = r3
            if (r10 != r1) goto L_0x009d
            r10 = r8
            r11 = r10
            goto L_0x00dc
        L_0x00db:
            r1 = -1
        L_0x00dc:
            int r8 = r8 + 1
            r2 = r24
            r3 = 117(0x75, float:1.64E-43)
            r13 = 1
            r14 = 34
            goto L_0x0079
        L_0x00e6:
            if (r9 <= 0) goto L_0x0304
            int r4 = r4 + r9
            char[] r1 = r0.buf
            int r1 = r1.length
            if (r4 <= r1) goto L_0x00f1
            r0.expandCapacity(r4)
        L_0x00f1:
            r0.count = r4
            r1 = 1
            if (r9 != r1) goto L_0x01fe
            r2 = 50
            if (r6 != r15) goto L_0x0123
            int r3 = r11 + 1
            int r4 = r11 + 6
            int r7 = r7 - r11
            int r7 = r7 - r1
            char[] r1 = r0.buf
            java.lang.System.arraycopy(r1, r3, r1, r4, r7)
            char[] r1 = r0.buf
            r1[r11] = r14
            r4 = 117(0x75, float:1.64E-43)
            r1[r3] = r4
            int r3 = r11 + 2
            r1[r3] = r2
            int r3 = r11 + 3
            r4 = 48
            r1[r3] = r4
            int r3 = r11 + 4
            r1[r3] = r2
            int r11 = r11 + 5
            r2 = 56
            r1[r11] = r2
            goto L_0x0304
        L_0x0123:
            if (r6 != r5) goto L_0x014f
            int r1 = r11 + 1
            int r3 = r11 + 6
            int r7 = r7 - r11
            r4 = 1
            int r7 = r7 - r4
            char[] r4 = r0.buf
            java.lang.System.arraycopy(r4, r1, r4, r3, r7)
            char[] r3 = r0.buf
            r3[r11] = r14
            r4 = 117(0x75, float:1.64E-43)
            r3[r1] = r4
            int r1 = r11 + 2
            r3[r1] = r2
            int r1 = r11 + 3
            r4 = 48
            r3[r1] = r4
            int r1 = r11 + 4
            r3[r1] = r2
            int r11 = r11 + 5
            r1 = 57
            r3[r11] = r1
            goto L_0x0304
        L_0x014f:
            r1 = 40
            if (r6 == r1) goto L_0x01c0
            r1 = 41
            if (r6 == r1) goto L_0x01c0
            r1 = 60
            if (r6 == r1) goto L_0x01c0
            r1 = 62
            if (r6 != r1) goto L_0x0160
            goto L_0x01c0
        L_0x0160:
            byte[] r1 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r2 = r1.length
            if (r6 >= r2) goto L_0x01a8
            byte r1 = r1[r6]
            r2 = 4
            if (r1 != r2) goto L_0x01a8
            int r1 = r11 + 1
            int r2 = r11 + 6
            int r7 = r7 - r11
            r3 = 1
            int r7 = r7 - r3
            char[] r3 = r0.buf
            java.lang.System.arraycopy(r3, r1, r3, r2, r7)
            char[] r2 = r0.buf
            r2[r11] = r14
            int r3 = r11 + 2
            r4 = 117(0x75, float:1.64E-43)
            r2[r1] = r4
            int r1 = r11 + 3
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r5 = r6 >>> 12
            r5 = r5 & 15
            char r5 = r4[r5]
            r2[r3] = r5
            int r3 = r11 + 4
            int r5 = r6 >>> 8
            r5 = r5 & 15
            char r5 = r4[r5]
            r2[r1] = r5
            int r11 = r11 + 5
            int r1 = r6 >>> 4
            r1 = r1 & 15
            char r1 = r4[r1]
            r2[r3] = r1
            r1 = r6 & 15
            char r1 = r4[r1]
            r2[r11] = r1
            goto L_0x0304
        L_0x01a8:
            int r1 = r11 + 1
            int r2 = r11 + 2
            int r7 = r7 - r11
            r3 = 1
            int r7 = r7 - r3
            char[] r3 = r0.buf
            java.lang.System.arraycopy(r3, r1, r3, r2, r7)
            char[] r2 = r0.buf
            r2[r11] = r14
            char[] r3 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r3 = r3[r6]
            r2[r1] = r3
            goto L_0x0304
        L_0x01c0:
            int r1 = r11 + 1
            int r2 = r11 + 6
            int r7 = r7 - r11
            r3 = 1
            int r7 = r7 - r3
            char[] r3 = r0.buf
            java.lang.System.arraycopy(r3, r1, r3, r2, r7)
            char[] r2 = r0.buf
            r2[r11] = r14
            int r3 = r11 + 2
            r4 = 117(0x75, float:1.64E-43)
            r2[r1] = r4
            int r1 = r11 + 3
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r5 = r6 >>> 12
            r5 = r5 & 15
            char r5 = r4[r5]
            r2[r3] = r5
            int r3 = r11 + 4
            int r5 = r6 >>> 8
            r5 = r5 & 15
            char r5 = r4[r5]
            r2[r1] = r5
            int r11 = r11 + 5
            int r1 = r6 >>> 4
            r1 = r1 & 15
            char r1 = r4[r1]
            r2[r3] = r1
            r1 = r6 & 15
            char r1 = r4[r1]
            r2[r11] = r1
            goto L_0x0304
        L_0x01fe:
            if (r9 <= r1) goto L_0x0304
            int r1 = r10 - r12
        L_0x0202:
            int r2 = r24.length()
            if (r1 >= r2) goto L_0x0304
            r2 = r24
            char r3 = r2.charAt(r1)
            boolean r4 = r0.browserSecure
            if (r4 == 0) goto L_0x025e
            r4 = 40
            r6 = 41
            r7 = 60
            if (r3 == r4) goto L_0x0223
            if (r3 == r6) goto L_0x0223
            r8 = 62
            if (r3 == r7) goto L_0x0225
            if (r3 != r8) goto L_0x0266
            goto L_0x0225
        L_0x0223:
            r8 = 62
        L_0x0225:
            char[] r9 = r0.buf
            int r11 = r10 + 1
            r9[r10] = r14
            int r12 = r10 + 2
            r13 = 117(0x75, float:1.64E-43)
            r9[r11] = r13
            int r11 = r10 + 3
            char[] r13 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r17 = r3 >>> 12
            r17 = r17 & 15
            char r17 = r13[r17]
            r9[r12] = r17
            int r12 = r10 + 4
            int r17 = r3 >>> 8
            r17 = r17 & 15
            char r17 = r13[r17]
            r9[r11] = r17
            int r11 = r10 + 5
            int r17 = r3 >>> 4
            r17 = r17 & 15
            char r17 = r13[r17]
            r9[r12] = r17
            int r10 = r10 + 6
            r3 = r3 & 15
            char r3 = r13[r3]
            r9[r11] = r3
            r13 = 4
        L_0x025a:
            r16 = 117(0x75, float:1.64E-43)
            goto L_0x0300
        L_0x025e:
            r4 = 40
            r6 = 41
            r7 = 60
            r8 = 62
        L_0x0266:
            byte[] r9 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r11 = r9.length
            if (r3 >= r11) goto L_0x026f
            byte r11 = r9[r3]
            if (r11 != 0) goto L_0x027b
        L_0x026f:
            r11 = 47
            if (r3 != r11) goto L_0x02be
            com.alibaba.fastjson.serializer.SerializerFeature r11 = com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial
            boolean r11 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r11)
            if (r11 == 0) goto L_0x02be
        L_0x027b:
            char[] r11 = r0.buf
            int r12 = r10 + 1
            r11[r10] = r14
            byte r9 = r9[r3]
            r13 = 4
            if (r9 != r13) goto L_0x02b5
            int r9 = r10 + 2
            r16 = 117(0x75, float:1.64E-43)
            r11[r12] = r16
            int r12 = r10 + 3
            char[] r16 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r17 = r3 >>> 12
            r17 = r17 & 15
            char r17 = r16[r17]
            r11[r9] = r17
            int r9 = r10 + 4
            int r17 = r3 >>> 8
            r17 = r17 & 15
            char r17 = r16[r17]
            r11[r12] = r17
            int r12 = r10 + 5
            int r17 = r3 >>> 4
            r17 = r17 & 15
            char r17 = r16[r17]
            r11[r9] = r17
            int r10 = r10 + 6
            r3 = r3 & 15
            char r3 = r16[r3]
            r11[r12] = r3
            goto L_0x025a
        L_0x02b5:
            int r10 = r10 + 2
            char[] r9 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r3 = r9[r3]
            r11[r12] = r3
            goto L_0x025a
        L_0x02be:
            r13 = 4
            if (r3 == r15) goto L_0x02cc
            if (r3 != r5) goto L_0x02c4
            goto L_0x02cc
        L_0x02c4:
            char[] r9 = r0.buf
            int r11 = r10 + 1
            r9[r10] = r3
            r10 = r11
            goto L_0x025a
        L_0x02cc:
            char[] r9 = r0.buf
            int r11 = r10 + 1
            r9[r10] = r14
            int r12 = r10 + 2
            r16 = 117(0x75, float:1.64E-43)
            r9[r11] = r16
            int r11 = r10 + 3
            char[] r17 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r18 = r3 >>> 12
            r18 = r18 & 15
            char r18 = r17[r18]
            r9[r12] = r18
            int r12 = r10 + 4
            int r18 = r3 >>> 8
            r18 = r18 & 15
            char r18 = r17[r18]
            r9[r11] = r18
            int r11 = r10 + 5
            int r18 = r3 >>> 4
            r18 = r18 & 15
            char r18 = r17[r18]
            r9[r12] = r18
            int r10 = r10 + 6
            r3 = r3 & 15
            char r3 = r17[r3]
            r9[r11] = r3
        L_0x0300:
            int r1 = r1 + 1
            goto L_0x0202
        L_0x0304:
            char[] r1 = r0.buf
            int r2 = r0.count
            r3 = 1
            int r2 = r2 - r3
            r3 = 34
            r1[r2] = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeFieldValueStringWithDoubleQuoteCheck(char, java.lang.String, java.lang.String):void");
    }

    public void writeFloat(float f, boolean z) {
        if (f != f || f == Float.POSITIVE_INFINITY || f == Float.NEGATIVE_INFINITY) {
            writeNull();
            return;
        }
        int i = this.count + 15;
        if (i > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i);
            } else {
                String ryuFloat = RyuFloat.toString(f);
                write(ryuFloat, 0, ryuFloat.length());
                if (z && isEnabled(SerializerFeature.WriteClassName)) {
                    write(70);
                    return;
                }
                return;
            }
        }
        this.count += RyuFloat.toString(f, this.buf, this.count);
        if (z && isEnabled(SerializerFeature.WriteClassName)) {
            write(70);
        }
    }

    public void writeHex(byte[] bArr) {
        int i;
        int length = this.count + (bArr.length * 2) + 3;
        if (length > this.buf.length) {
            expandCapacity(length);
        }
        char[] cArr = this.buf;
        int i2 = this.count;
        int i3 = i2 + 1;
        this.count = i3;
        cArr[i2] = 'x';
        this.count = i2 + 2;
        cArr[i3] = '\'';
        for (byte b : bArr) {
            int i4 = (b & 255) >> 4;
            byte b2 = b & 15;
            char[] cArr2 = this.buf;
            int i5 = this.count;
            int i6 = i5 + 1;
            this.count = i6;
            byte b3 = 55;
            if (i4 < 10) {
                i = 48;
            } else {
                i = 55;
            }
            cArr2[i5] = (char) (i4 + i);
            this.count = i5 + 2;
            if (b2 < 10) {
                b3 = 48;
            }
            cArr2[i6] = (char) (b2 + b3);
        }
        char[] cArr3 = this.buf;
        int i7 = this.count;
        this.count = i7 + 1;
        cArr3[i7] = '\'';
    }

    public void writeInt(int i) {
        int i2;
        if (i == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        if (i < 0) {
            i2 = IOUtils.stringSize(-i) + 1;
        } else {
            i2 = IOUtils.stringSize(i);
        }
        int i3 = this.count + i2;
        if (i3 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i3);
            } else {
                char[] cArr = new char[i2];
                IOUtils.getChars(i, i2, cArr);
                write(cArr, 0, i2);
                return;
            }
        }
        IOUtils.getChars(i, i3, this.buf);
        this.count = i3;
    }

    public void writeLong(long j) {
        boolean z;
        int i;
        if (!isEnabled(SerializerFeature.BrowserCompatible) || isEnabled(SerializerFeature.WriteClassName) || (j <= 9007199254740991L && j >= -9007199254740991L)) {
            z = false;
        } else {
            z = true;
        }
        if (j != Long.MIN_VALUE) {
            if (j < 0) {
                i = IOUtils.stringSize(-j) + 1;
            } else {
                i = IOUtils.stringSize(j);
            }
            int i2 = this.count + i;
            if (z) {
                i2 += 2;
            }
            if (i2 > this.buf.length) {
                if (this.writer == null) {
                    expandCapacity(i2);
                } else {
                    char[] cArr = new char[i];
                    IOUtils.getChars(j, i, cArr);
                    if (z) {
                        write(34);
                        write(cArr, 0, i);
                        write(34);
                        return;
                    }
                    write(cArr, 0, i);
                    return;
                }
            }
            if (z) {
                char[] cArr2 = this.buf;
                cArr2[this.count] = '\"';
                int i3 = i2 - 1;
                IOUtils.getChars(j, i3, cArr2);
                this.buf[i3] = '\"';
            } else {
                IOUtils.getChars(j, i2, this.buf);
            }
            this.count = i2;
        } else if (z) {
            write("\"-9223372036854775808\"");
        } else {
            write("-9223372036854775808");
        }
    }

    public void writeLongAndChar(long j, char c) throws IOException {
        writeLong(j);
        write((int) c);
    }

    public void writeNull() {
        write("null");
    }

    public void writeString(String str, char c) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(str);
            write((int) c);
            return;
        }
        writeStringWithDoubleQuote(str, c);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02e5, code lost:
        if (r4[r14] == 4) goto L_0x02ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0439, code lost:
        if (r4 != '>') goto L_0x0481;
     */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeStringWithDoubleQuote(java.lang.String r24, char r25) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            if (r1 != 0) goto L_0x0011
            r23.writeNull()
            if (r2 == 0) goto L_0x0010
            r0.write((int) r2)
        L_0x0010:
            return
        L_0x0011:
            int r3 = r24.length()
            int r4 = r0.count
            int r4 = r4 + r3
            int r5 = r4 + 2
            if (r2 == 0) goto L_0x001e
            int r5 = r4 + 3
        L_0x001e:
            char[] r4 = r0.buf
            int r4 = r4.length
            r7 = 62
            r8 = 60
            r9 = 41
            r10 = 40
            r14 = 34
            r15 = 8
            r11 = 12
            r6 = 117(0x75, float:1.64E-43)
            r13 = 92
            r12 = 1
            if (r5 <= r4) goto L_0x0164
            java.io.Writer r4 = r0.writer
            if (r4 == 0) goto L_0x0161
            r0.write((int) r14)
            r3 = 0
        L_0x003e:
            int r4 = r24.length()
            if (r3 >= r4) goto L_0x0158
            char r4 = r1.charAt(r3)
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserSecure
            boolean r5 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r5)
            if (r5 == 0) goto L_0x0084
            if (r4 == r10) goto L_0x0058
            if (r4 == r9) goto L_0x0058
            if (r4 == r8) goto L_0x0058
            if (r4 != r7) goto L_0x0084
        L_0x0058:
            r0.write((int) r13)
            r0.write((int) r6)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r16 = r4 >>> 12
            r16 = r16 & 15
            char r7 = r5[r16]
            r0.write((int) r7)
            int r7 = r4 >>> 8
            r7 = r7 & 15
            char r7 = r5[r7]
            r0.write((int) r7)
            int r7 = r4 >>> 4
            r7 = r7 & 15
            char r7 = r5[r7]
            r0.write((int) r7)
            r4 = r4 & 15
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x0152
        L_0x0084:
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserCompatible
            boolean r5 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r5)
            if (r5 == 0) goto L_0x0102
            if (r4 == r15) goto L_0x00f7
            if (r4 == r11) goto L_0x00f7
            r5 = 10
            if (r4 == r5) goto L_0x00f7
            r5 = 13
            if (r4 == r5) goto L_0x00f7
            r5 = 9
            if (r4 == r5) goto L_0x00f7
            if (r4 == r14) goto L_0x00f7
            r5 = 47
            if (r4 == r5) goto L_0x00f7
            if (r4 != r13) goto L_0x00a5
            goto L_0x00f7
        L_0x00a5:
            r5 = 32
            if (r4 >= r5) goto L_0x00c8
            r0.write((int) r13)
            r0.write((int) r6)
            r5 = 48
            r0.write((int) r5)
            r0.write((int) r5)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.ASCII_CHARS
            int r4 = r4 * 2
            char r7 = r5[r4]
            r0.write((int) r7)
            int r4 = r4 + r12
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x0152
        L_0x00c8:
            r5 = 127(0x7f, float:1.78E-43)
            if (r4 < r5) goto L_0x014f
            r0.write((int) r13)
            r0.write((int) r6)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r7 = r4 >>> 12
            r7 = r7 & 15
            char r7 = r5[r7]
            r0.write((int) r7)
            int r7 = r4 >>> 8
            r7 = r7 & 15
            char r7 = r5[r7]
            r0.write((int) r7)
            int r7 = r4 >>> 4
            r7 = r7 & 15
            char r7 = r5[r7]
            r0.write((int) r7)
            r4 = r4 & 15
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x0152
        L_0x00f7:
            r0.write((int) r13)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x0152
        L_0x0102:
            byte[] r5 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r7 = r5.length
            if (r4 >= r7) goto L_0x010b
            byte r7 = r5[r4]
            if (r7 != 0) goto L_0x0117
        L_0x010b:
            r7 = 47
            if (r4 != r7) goto L_0x014f
            com.alibaba.fastjson.serializer.SerializerFeature r7 = com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial
            boolean r7 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r7)
            if (r7 == 0) goto L_0x014f
        L_0x0117:
            r0.write((int) r13)
            byte r5 = r5[r4]
            r7 = 4
            if (r5 != r7) goto L_0x0147
            r0.write((int) r6)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r7 = r4 >>> 12
            r7 = r7 & 15
            char r7 = r5[r7]
            r0.write((int) r7)
            int r7 = r4 >>> 8
            r7 = r7 & 15
            char r7 = r5[r7]
            r0.write((int) r7)
            int r7 = r4 >>> 4
            r7 = r7 & 15
            char r7 = r5[r7]
            r0.write((int) r7)
            r4 = r4 & 15
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x0152
        L_0x0147:
            char[] r5 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x0152
        L_0x014f:
            r0.write((int) r4)
        L_0x0152:
            int r3 = r3 + 1
            r7 = 62
            goto L_0x003e
        L_0x0158:
            r0.write((int) r14)
            if (r2 == 0) goto L_0x0160
            r0.write((int) r2)
        L_0x0160:
            return
        L_0x0161:
            r0.expandCapacity(r5)
        L_0x0164:
            int r4 = r0.count
            int r7 = r4 + 1
            int r8 = r7 + r3
            char[] r9 = r0.buf
            r9[r4] = r14
            r4 = 0
            r1.getChars(r4, r3, r9, r7)
            r0.count = r5
            com.alibaba.fastjson.serializer.SerializerFeature r3 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserCompatible
            boolean r3 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r3)
            r9 = -1
            if (r3 == 0) goto L_0x028d
            r1 = r7
        L_0x017e:
            if (r1 >= r8) goto L_0x01b1
            char[] r3 = r0.buf
            char r3 = r3[r1]
            if (r3 == r14) goto L_0x01ab
            r4 = 47
            if (r3 == r4) goto L_0x01ab
            if (r3 != r13) goto L_0x018d
            goto L_0x01ab
        L_0x018d:
            if (r3 == r15) goto L_0x01ab
            if (r3 == r11) goto L_0x01ab
            r4 = 10
            if (r3 == r4) goto L_0x01ab
            r4 = 13
            if (r3 == r4) goto L_0x01ab
            r4 = 9
            if (r3 != r4) goto L_0x019e
            goto L_0x01ab
        L_0x019e:
            r4 = 32
            if (r3 >= r4) goto L_0x01a6
        L_0x01a2:
            int r5 = r5 + 5
        L_0x01a4:
            r9 = r1
            goto L_0x01ae
        L_0x01a6:
            r4 = 127(0x7f, float:1.78E-43)
            if (r3 < r4) goto L_0x01ae
            goto L_0x01a2
        L_0x01ab:
            int r5 = r5 + 1
            goto L_0x01a4
        L_0x01ae:
            int r1 = r1 + 1
            goto L_0x017e
        L_0x01b1:
            char[] r1 = r0.buf
            int r1 = r1.length
            if (r5 <= r1) goto L_0x01b9
            r0.expandCapacity(r5)
        L_0x01b9:
            r0.count = r5
        L_0x01bb:
            if (r9 < r7) goto L_0x0277
            char[] r1 = r0.buf
            char r3 = r1[r9]
            if (r3 == r15) goto L_0x025e
            if (r3 == r11) goto L_0x025e
            r4 = 10
            if (r3 == r4) goto L_0x025e
            r4 = 13
            if (r3 == r4) goto L_0x025e
            r4 = 9
            if (r3 != r4) goto L_0x01d3
            goto L_0x025e
        L_0x01d3:
            if (r3 == r14) goto L_0x024b
            r4 = 47
            if (r3 == r4) goto L_0x024b
            if (r3 != r13) goto L_0x01dc
            goto L_0x024b
        L_0x01dc:
            r4 = 32
            if (r3 >= r4) goto L_0x020e
            int r4 = r9 + 1
            int r5 = r9 + 6
            int r10 = r8 - r9
            int r10 = r10 - r12
            java.lang.System.arraycopy(r1, r4, r1, r5, r10)
            char[] r1 = r0.buf
            r1[r9] = r13
            r1[r4] = r6
            int r4 = r9 + 2
            r5 = 48
            r1[r4] = r5
            int r4 = r9 + 3
            r1[r4] = r5
            int r4 = r9 + 4
            char[] r5 = com.alibaba.fastjson.util.IOUtils.ASCII_CHARS
            int r3 = r3 * 2
            char r10 = r5[r3]
            r1[r4] = r10
            int r4 = r9 + 5
            int r3 = r3 + r12
            char r3 = r5[r3]
            r1[r4] = r3
        L_0x020b:
            int r8 = r8 + 5
            goto L_0x0273
        L_0x020e:
            r4 = 127(0x7f, float:1.78E-43)
            if (r3 < r4) goto L_0x0273
            int r4 = r9 + 1
            int r5 = r9 + 6
            int r10 = r8 - r9
            int r10 = r10 - r12
            java.lang.System.arraycopy(r1, r4, r1, r5, r10)
            char[] r1 = r0.buf
            r1[r9] = r13
            r1[r4] = r6
            int r4 = r9 + 2
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r10 = r3 >>> 12
            r10 = r10 & 15
            char r10 = r5[r10]
            r1[r4] = r10
            int r4 = r9 + 3
            int r10 = r3 >>> 8
            r10 = r10 & 15
            char r10 = r5[r10]
            r1[r4] = r10
            int r4 = r9 + 4
            int r10 = r3 >>> 4
            r10 = r10 & 15
            char r10 = r5[r10]
            r1[r4] = r10
            int r4 = r9 + 5
            r3 = r3 & 15
            char r3 = r5[r3]
            r1[r4] = r3
            goto L_0x020b
        L_0x024b:
            int r4 = r9 + 1
            int r5 = r9 + 2
            int r10 = r8 - r9
            int r10 = r10 - r12
            java.lang.System.arraycopy(r1, r4, r1, r5, r10)
            char[] r1 = r0.buf
            r1[r9] = r13
            r1[r4] = r3
        L_0x025b:
            int r8 = r8 + 1
            goto L_0x0273
        L_0x025e:
            int r4 = r9 + 1
            int r5 = r9 + 2
            int r10 = r8 - r9
            int r10 = r10 - r12
            java.lang.System.arraycopy(r1, r4, r1, r5, r10)
            char[] r1 = r0.buf
            r1[r9] = r13
            char[] r5 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r3 = r5[r3]
            r1[r4] = r3
            goto L_0x025b
        L_0x0273:
            int r9 = r9 + -1
            goto L_0x01bb
        L_0x0277:
            if (r2 == 0) goto L_0x0285
            char[] r1 = r0.buf
            int r3 = r0.count
            int r4 = r3 + -2
            r1[r4] = r14
            int r3 = r3 - r12
            r1[r3] = r2
            goto L_0x028c
        L_0x0285:
            char[] r1 = r0.buf
            int r2 = r0.count
            int r2 = r2 - r12
            r1[r2] = r14
        L_0x028c:
            return
        L_0x028d:
            r3 = r7
            r11 = 0
            r15 = -1
            r16 = -1
        L_0x0292:
            if (r3 >= r8) goto L_0x02fd
            char[] r14 = r0.buf
            char r14 = r14[r3]
            r6 = 93
            if (r14 < r6) goto L_0x02b7
            r6 = 127(0x7f, float:1.78E-43)
            if (r14 < r6) goto L_0x02f4
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r14 == r6) goto L_0x02ac
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r14 == r6) goto L_0x02ac
            r6 = 160(0xa0, float:2.24E-43)
            if (r14 >= r6) goto L_0x02f4
        L_0x02ac:
            if (r15 != r9) goto L_0x02af
            r15 = r3
        L_0x02af:
            int r11 = r11 + 1
            int r5 = r5 + 4
        L_0x02b3:
            r16 = r3
        L_0x02b5:
            r4 = r14
            goto L_0x02f4
        L_0x02b7:
            r6 = 64
            if (r14 >= r6) goto L_0x02c9
            long r9 = r0.sepcialBits
            r20 = 1
            long r20 = r20 << r14
            long r9 = r9 & r20
            r20 = 0
            int r22 = (r9 > r20 ? 1 : (r9 == r20 ? 0 : -1))
            if (r22 != 0) goto L_0x02cb
        L_0x02c9:
            if (r14 != r13) goto L_0x02f3
        L_0x02cb:
            int r11 = r11 + 1
            r4 = 40
            if (r14 == r4) goto L_0x02ea
            r4 = 41
            if (r14 == r4) goto L_0x02ea
            r4 = 60
            if (r14 == r4) goto L_0x02ea
            r4 = 62
            if (r14 == r4) goto L_0x02ea
            byte[] r4 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r9 = r4.length
            if (r14 >= r9) goto L_0x02e8
            byte r4 = r4[r14]
            r9 = 4
            if (r4 != r9) goto L_0x02e8
            goto L_0x02ea
        L_0x02e8:
            r9 = -1
            goto L_0x02ed
        L_0x02ea:
            int r5 = r5 + 4
            goto L_0x02e8
        L_0x02ed:
            if (r15 != r9) goto L_0x02b3
            r15 = r3
            r16 = r15
            goto L_0x02b5
        L_0x02f3:
            r9 = -1
        L_0x02f4:
            int r3 = r3 + 1
            r6 = 117(0x75, float:1.64E-43)
            r10 = 40
            r14 = 34
            goto L_0x0292
        L_0x02fd:
            if (r11 <= 0) goto L_0x0527
            int r5 = r5 + r11
            char[] r3 = r0.buf
            int r3 = r3.length
            if (r5 <= r3) goto L_0x0308
            r0.expandCapacity(r5)
        L_0x0308:
            r0.count = r5
            if (r11 != r12) goto L_0x0419
            r1 = 8232(0x2028, float:1.1535E-41)
            r3 = 50
            if (r4 != r1) goto L_0x033c
            int r1 = r16 + 1
            int r4 = r16 + 6
            int r8 = r8 - r16
            int r8 = r8 - r12
            char[] r5 = r0.buf
            java.lang.System.arraycopy(r5, r1, r5, r4, r8)
            char[] r4 = r0.buf
            r4[r16] = r13
            r5 = 117(0x75, float:1.64E-43)
            r4[r1] = r5
            int r1 = r16 + 2
            r4[r1] = r3
            int r1 = r16 + 3
            r5 = 48
            r4[r1] = r5
            int r1 = r16 + 4
            r4[r1] = r3
            int r16 = r16 + 5
            r1 = 56
            r4[r16] = r1
            goto L_0x0527
        L_0x033c:
            r1 = 8233(0x2029, float:1.1537E-41)
            if (r4 != r1) goto L_0x036a
            int r1 = r16 + 1
            int r4 = r16 + 6
            int r8 = r8 - r16
            int r8 = r8 - r12
            char[] r5 = r0.buf
            java.lang.System.arraycopy(r5, r1, r5, r4, r8)
            char[] r4 = r0.buf
            r4[r16] = r13
            r5 = 117(0x75, float:1.64E-43)
            r4[r1] = r5
            int r1 = r16 + 2
            r4[r1] = r3
            int r1 = r16 + 3
            r5 = 48
            r4[r1] = r5
            int r1 = r16 + 4
            r4[r1] = r3
            int r16 = r16 + 5
            r1 = 57
            r4[r16] = r1
            goto L_0x0527
        L_0x036a:
            r1 = 40
            if (r4 == r1) goto L_0x03db
            r1 = 41
            if (r4 == r1) goto L_0x03db
            r1 = 60
            if (r4 == r1) goto L_0x03db
            r1 = 62
            if (r4 != r1) goto L_0x037b
            goto L_0x03db
        L_0x037b:
            byte[] r1 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r3 = r1.length
            if (r4 >= r3) goto L_0x03c3
            byte r1 = r1[r4]
            r3 = 4
            if (r1 != r3) goto L_0x03c3
            int r1 = r16 + 1
            int r3 = r16 + 6
            int r8 = r8 - r16
            int r8 = r8 - r12
            char[] r5 = r0.buf
            java.lang.System.arraycopy(r5, r1, r5, r3, r8)
            char[] r3 = r0.buf
            r3[r16] = r13
            int r5 = r16 + 2
            r6 = 117(0x75, float:1.64E-43)
            r3[r1] = r6
            int r1 = r16 + 3
            char[] r6 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r7 = r4 >>> 12
            r7 = r7 & 15
            char r7 = r6[r7]
            r3[r5] = r7
            int r5 = r16 + 4
            int r7 = r4 >>> 8
            r7 = r7 & 15
            char r7 = r6[r7]
            r3[r1] = r7
            int r16 = r16 + 5
            int r1 = r4 >>> 4
            r1 = r1 & 15
            char r1 = r6[r1]
            r3[r5] = r1
            r1 = r4 & 15
            char r1 = r6[r1]
            r3[r16] = r1
            goto L_0x0527
        L_0x03c3:
            int r1 = r16 + 1
            int r3 = r16 + 2
            int r8 = r8 - r16
            int r8 = r8 - r12
            char[] r5 = r0.buf
            java.lang.System.arraycopy(r5, r1, r5, r3, r8)
            char[] r3 = r0.buf
            r3[r16] = r13
            char[] r5 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r4 = r5[r4]
            r3[r1] = r4
            goto L_0x0527
        L_0x03db:
            int r1 = r16 + 1
            int r3 = r16 + 6
            int r8 = r8 - r16
            int r8 = r8 - r12
            char[] r5 = r0.buf
            java.lang.System.arraycopy(r5, r1, r5, r3, r8)
            char[] r3 = r0.buf
            r3[r16] = r13
            r5 = 117(0x75, float:1.64E-43)
            r3[r1] = r5
            int r1 = r16 + 2
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r6 = r4 >>> 12
            r6 = r6 & 15
            char r6 = r5[r6]
            r3[r1] = r6
            int r1 = r16 + 3
            int r6 = r4 >>> 8
            r6 = r6 & 15
            char r6 = r5[r6]
            r3[r1] = r6
            int r1 = r16 + 4
            int r6 = r4 >>> 4
            r6 = r6 & 15
            char r6 = r5[r6]
            r3[r1] = r6
            int r16 = r16 + 5
            r1 = r4 & 15
            char r1 = r5[r1]
            r3[r16] = r1
            goto L_0x0527
        L_0x0419:
            if (r11 <= r12) goto L_0x0527
            int r3 = r15 - r7
        L_0x041d:
            int r4 = r24.length()
            if (r3 >= r4) goto L_0x0527
            char r4 = r1.charAt(r3)
            boolean r5 = r0.browserSecure
            if (r5 == 0) goto L_0x0479
            r5 = 40
            r6 = 41
            r7 = 60
            if (r4 == r5) goto L_0x043c
            if (r4 == r6) goto L_0x043c
            r8 = 62
            if (r4 == r7) goto L_0x043e
            if (r4 != r8) goto L_0x0481
            goto L_0x043e
        L_0x043c:
            r8 = 62
        L_0x043e:
            char[] r9 = r0.buf
            int r10 = r15 + 1
            r9[r15] = r13
            int r11 = r15 + 2
            r14 = 117(0x75, float:1.64E-43)
            r9[r10] = r14
            int r10 = r15 + 3
            char[] r14 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r16 = r4 >>> 12
            r16 = r16 & 15
            char r16 = r14[r16]
            r9[r11] = r16
            int r11 = r15 + 4
            int r16 = r4 >>> 8
            r16 = r16 & 15
            char r16 = r14[r16]
            r9[r10] = r16
            int r10 = r15 + 5
            int r16 = r4 >>> 4
            r16 = r16 & 15
            char r16 = r14[r16]
            r9[r11] = r16
            int r15 = r15 + 6
            r4 = r4 & 15
            char r4 = r14[r4]
            r9[r10] = r4
            r5 = 4
            r10 = 47
        L_0x0475:
            r17 = 117(0x75, float:1.64E-43)
            goto L_0x0523
        L_0x0479:
            r5 = 40
            r6 = 41
            r7 = 60
            r8 = 62
        L_0x0481:
            byte[] r9 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r10 = r9.length
            if (r4 >= r10) goto L_0x048a
            byte r10 = r9[r4]
            if (r10 != 0) goto L_0x048d
        L_0x048a:
            r10 = 47
            goto L_0x0490
        L_0x048d:
            r10 = 47
            goto L_0x049a
        L_0x0490:
            if (r4 != r10) goto L_0x04dd
            com.alibaba.fastjson.serializer.SerializerFeature r11 = com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial
            boolean r11 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r11)
            if (r11 == 0) goto L_0x04dd
        L_0x049a:
            char[] r11 = r0.buf
            int r14 = r15 + 1
            r11[r15] = r13
            byte r9 = r9[r4]
            r5 = 4
            if (r9 != r5) goto L_0x04d4
            int r9 = r15 + 2
            r17 = 117(0x75, float:1.64E-43)
            r11[r14] = r17
            int r14 = r15 + 3
            char[] r17 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r18 = r4 >>> 12
            r18 = r18 & 15
            char r18 = r17[r18]
            r11[r9] = r18
            int r9 = r15 + 4
            int r18 = r4 >>> 8
            r18 = r18 & 15
            char r18 = r17[r18]
            r11[r14] = r18
            int r14 = r15 + 5
            int r18 = r4 >>> 4
            r18 = r18 & 15
            char r18 = r17[r18]
            r11[r9] = r18
            int r15 = r15 + 6
            r4 = r4 & 15
            char r4 = r17[r4]
            r11[r14] = r4
            goto L_0x0475
        L_0x04d4:
            int r15 = r15 + 2
            char[] r9 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r4 = r9[r4]
            r11[r14] = r4
            goto L_0x0475
        L_0x04dd:
            r5 = 4
            r9 = 8232(0x2028, float:1.1535E-41)
            if (r4 == r9) goto L_0x04ef
            r9 = 8233(0x2029, float:1.1537E-41)
            if (r4 != r9) goto L_0x04e7
            goto L_0x04ef
        L_0x04e7:
            char[] r9 = r0.buf
            int r11 = r15 + 1
            r9[r15] = r4
            r15 = r11
            goto L_0x0475
        L_0x04ef:
            char[] r9 = r0.buf
            int r11 = r15 + 1
            r9[r15] = r13
            int r14 = r15 + 2
            r17 = 117(0x75, float:1.64E-43)
            r9[r11] = r17
            int r11 = r15 + 3
            char[] r18 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r19 = r4 >>> 12
            r19 = r19 & 15
            char r19 = r18[r19]
            r9[r14] = r19
            int r14 = r15 + 4
            int r19 = r4 >>> 8
            r19 = r19 & 15
            char r19 = r18[r19]
            r9[r11] = r19
            int r11 = r15 + 5
            int r19 = r4 >>> 4
            r19 = r19 & 15
            char r19 = r18[r19]
            r9[r14] = r19
            int r15 = r15 + 6
            r4 = r4 & 15
            char r4 = r18[r4]
            r9[r11] = r4
        L_0x0523:
            int r3 = r3 + 1
            goto L_0x041d
        L_0x0527:
            if (r2 == 0) goto L_0x0537
            char[] r1 = r0.buf
            int r3 = r0.count
            int r4 = r3 + -2
            r5 = 34
            r1[r4] = r5
            int r3 = r3 - r12
            r1[r3] = r2
            goto L_0x0540
        L_0x0537:
            r5 = 34
            char[] r1 = r0.buf
            int r2 = r0.count
            int r2 = r2 - r12
            r1[r2] = r5
        L_0x0540:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeStringWithDoubleQuote(java.lang.String, char):void");
    }

    public void writeStringWithSingleQuote(String str) {
        int i = 0;
        if (str == null) {
            int i2 = this.count + 4;
            if (i2 > this.buf.length) {
                expandCapacity(i2);
            }
            "null".getChars(0, 4, this.buf, this.count);
            this.count = i2;
            return;
        }
        int length = str.length();
        int i3 = this.count + length + 2;
        if (i3 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                while (i < str.length()) {
                    char charAt = str.charAt(i);
                    if (charAt <= 13 || charAt == '\\' || charAt == '\'' || (charAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        write(92);
                        write((int) IOUtils.replaceChars[charAt]);
                    } else {
                        write((int) charAt);
                    }
                    i++;
                }
                write(39);
                return;
            }
            expandCapacity(i3);
        }
        int i4 = this.count;
        int i5 = i4 + 1;
        int i6 = i5 + length;
        char[] cArr = this.buf;
        cArr[i4] = '\'';
        str.getChars(0, length, cArr, i5);
        this.count = i3;
        char c = 0;
        int i7 = -1;
        for (int i8 = i5; i8 < i6; i8++) {
            char c2 = this.buf[i8];
            if (c2 <= 13 || c2 == '\\' || c2 == '\'' || (c2 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                i++;
                i7 = i8;
                c = c2;
            }
        }
        int i9 = i3 + i;
        if (i9 > this.buf.length) {
            expandCapacity(i9);
        }
        this.count = i9;
        if (i == 1) {
            char[] cArr2 = this.buf;
            int i10 = i7 + 1;
            System.arraycopy(cArr2, i10, cArr2, i7 + 2, (i6 - i7) - 1);
            char[] cArr3 = this.buf;
            cArr3[i7] = '\\';
            cArr3[i10] = IOUtils.replaceChars[c];
        } else if (i > 1) {
            char[] cArr4 = this.buf;
            int i11 = i7 + 1;
            System.arraycopy(cArr4, i11, cArr4, i7 + 2, (i6 - i7) - 1);
            char[] cArr5 = this.buf;
            cArr5[i7] = '\\';
            cArr5[i11] = IOUtils.replaceChars[c];
            int i12 = i6 + 1;
            for (int i13 = i7 - 1; i13 >= i5; i13--) {
                char c3 = this.buf[i13];
                if (c3 <= 13 || c3 == '\\' || c3 == '\'' || (c3 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr6 = this.buf;
                    int i14 = i13 + 1;
                    System.arraycopy(cArr6, i14, cArr6, i13 + 2, (i12 - i13) - 1);
                    char[] cArr7 = this.buf;
                    cArr7[i13] = '\\';
                    cArr7[i14] = IOUtils.replaceChars[c3];
                    i12++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeTo(Writer writer2) throws IOException {
        if (this.writer == null) {
            writer2.write(this.buf, 0, this.count);
            return;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public int writeToEx(OutputStream outputStream, Charset charset) throws IOException {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        } else if (charset == IOUtils.UTF8) {
            return encodeToUTF8(outputStream);
        } else {
            byte[] bytes = new String(this.buf, 0, this.count).getBytes(charset);
            outputStream.write(bytes);
            return bytes.length;
        }
    }

    public SerializeWriter(Writer writer2) {
        this(writer2, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
    }

    public boolean isEnabled(int i) {
        return (i & this.features) != 0;
    }

    public void writeFieldName(String str, boolean z) {
        if (str == null) {
            write("null:");
        } else if (this.useSingleQuotes) {
            if (this.quoteFieldNames) {
                writeStringWithSingleQuote(str);
                write(58);
                return;
            }
            writeKeyWithSingleQuoteIfHasSpecial(str);
        } else if (this.quoteFieldNames) {
            writeStringWithDoubleQuote(str, ':');
        } else {
            int i = 0;
            boolean z2 = true;
            boolean z3 = str.length() == 0;
            while (true) {
                if (i >= str.length()) {
                    z2 = z3;
                    break;
                }
                char charAt = str.charAt(i);
                if ((charAt < '@' && (this.sepcialBits & (1 << charAt)) != 0) || charAt == '\\') {
                    break;
                }
                i++;
            }
            if (z2) {
                writeStringWithDoubleQuote(str, ':');
                return;
            }
            write(str);
            write(58);
        }
    }

    public void writeNull(SerializerFeature serializerFeature) {
        writeNull(0, serializerFeature.mask);
    }

    public SerializeWriter(SerializerFeature... serializerFeatureArr) {
        this((Writer) null, serializerFeatureArr);
    }

    public void writeNull(int i, int i2) {
        if ((i & i2) == 0 && (this.features & i2) == 0) {
            writeNull();
            return;
        }
        int i3 = SerializerFeature.WriteMapNullValue.mask;
        if ((i & i3) != 0 && (i & (~i3) & SerializerFeature.WRITE_MAP_NULL_FEATURES) == 0) {
            writeNull();
        } else if (i2 == SerializerFeature.WriteNullListAsEmpty.mask) {
            write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        } else if (i2 == SerializerFeature.WriteNullStringAsEmpty.mask) {
            writeString("");
        } else if (i2 == SerializerFeature.WriteNullBooleanAsFalse.mask) {
            write("false");
        } else if (i2 == SerializerFeature.WriteNullNumberAsZero.mask) {
            write(48);
        } else {
            writeNull();
        }
    }

    public SerializeWriter(Writer writer2, SerializerFeature... serializerFeatureArr) {
        this(writer2, 0, serializerFeatureArr);
    }

    public byte[] toBytes(Charset charset) {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        } else if (charset == IOUtils.UTF8) {
            return encodeToUTF8Bytes();
        } else {
            return new String(this.buf, 0, this.count).getBytes(charset);
        }
    }

    public void writeTo(OutputStream outputStream, String str) throws IOException {
        writeTo(outputStream, Charset.forName(str));
    }

    public SerializeWriter(Writer writer2, int i, SerializerFeature... serializerFeatureArr) {
        this.maxBufSize = -1;
        this.writer = writer2;
        ThreadLocal<char[]> threadLocal = bufLocal;
        char[] cArr = threadLocal.get();
        this.buf = cArr;
        if (cArr != null) {
            threadLocal.set((Object) null);
        } else {
            this.buf = new char[2048];
        }
        for (SerializerFeature mask : serializerFeatureArr) {
            i |= mask.getMask();
        }
        this.features = i;
        computeFeatures();
    }

    public void writeFieldValue(char c, String str, boolean z) {
        if (!this.quoteFieldNames) {
            write((int) c);
            writeFieldName(str);
            write(z);
            return;
        }
        int i = z ? 4 : 5;
        int length = str.length();
        int i2 = this.count + length + 4 + i;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                write((int) c);
                writeString(str);
                write(58);
                write(z);
                return;
            }
            expandCapacity(i2);
        }
        int i3 = this.count;
        this.count = i2;
        char[] cArr = this.buf;
        cArr[i3] = c;
        int i4 = i3 + length;
        cArr[i3 + 1] = this.keySeperator;
        str.getChars(0, length, cArr, i3 + 2);
        char[] cArr2 = this.buf;
        cArr2[i4 + 2] = this.keySeperator;
        if (z) {
            System.arraycopy(VALUE_TRUE, 0, cArr2, i4 + 3, 5);
        } else {
            System.arraycopy(VALUE_FALSE, 0, cArr2, i4 + 3, 6);
        }
    }

    public void writeString(String str) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(str);
        } else {
            writeStringWithDoubleQuote(str, 0);
        }
    }

    public void writeTo(OutputStream outputStream, Charset charset) throws IOException {
        writeToEx(outputStream, charset);
    }

    public SerializeWriter append(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "null" : charSequence.toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    public void write(char[] cArr, int i, int i2) {
        int i3;
        if (i < 0 || i > cArr.length || i2 < 0 || (i3 = i + i2) > cArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 != 0) {
            int i4 = this.count + i2;
            if (i4 > this.buf.length) {
                if (this.writer == null) {
                    expandCapacity(i4);
                } else {
                    do {
                        char[] cArr2 = this.buf;
                        int length = cArr2.length;
                        int i5 = this.count;
                        int i6 = length - i5;
                        System.arraycopy(cArr, i, cArr2, i5, i6);
                        this.count = this.buf.length;
                        flush();
                        i2 -= i6;
                        i += i6;
                    } while (i2 > this.buf.length);
                    i4 = i2;
                }
            }
            System.arraycopy(cArr, i, this.buf, this.count, i2);
            this.count = i4;
        }
    }

    public void writeString(char[] cArr) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(cArr);
        } else {
            writeStringWithDoubleQuote(new String(cArr), 0);
        }
    }

    public SerializeWriter append(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String charSequence2 = charSequence.subSequence(i, i2).toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    public SerializeWriter append(char c) {
        write((int) c);
        return this;
    }

    public SerializeWriter(int i) {
        this((Writer) null, i);
    }

    public SerializeWriter(Writer writer2, int i) {
        this.maxBufSize = -1;
        this.writer = writer2;
        if (i > 0) {
            this.buf = new char[i];
            computeFeatures();
            return;
        }
        throw new IllegalArgumentException("Negative initial size: " + i);
    }

    public void write(String str, int i, int i2) {
        int i3;
        int i4 = this.count + i2;
        if (i4 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i4);
            } else {
                while (true) {
                    char[] cArr = this.buf;
                    int length = cArr.length;
                    int i5 = this.count;
                    int i6 = length - i5;
                    i3 = i + i6;
                    str.getChars(i, i3, cArr, i5);
                    this.count = this.buf.length;
                    flush();
                    i2 -= i6;
                    if (i2 <= this.buf.length) {
                        break;
                    }
                    i = i3;
                }
                i4 = i2;
                i = i3;
            }
        }
        str.getChars(i, i2 + i, this.buf, this.count);
        this.count = i4;
    }

    public void writeFieldValue(char c, String str, int i) {
        if (i == Integer.MIN_VALUE || !this.quoteFieldNames) {
            write((int) c);
            writeFieldName(str);
            writeInt(i);
            return;
        }
        int stringSize = i < 0 ? IOUtils.stringSize(-i) + 1 : IOUtils.stringSize(i);
        int length = str.length();
        int i2 = this.count + length + 4 + stringSize;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                write((int) c);
                writeFieldName(str);
                writeInt(i);
                return;
            }
            expandCapacity(i2);
        }
        int i3 = this.count;
        this.count = i2;
        char[] cArr = this.buf;
        cArr[i3] = c;
        int i4 = i3 + length;
        cArr[i3 + 1] = this.keySeperator;
        str.getChars(0, length, cArr, i3 + 2);
        char[] cArr2 = this.buf;
        cArr2[i4 + 2] = this.keySeperator;
        cArr2[i4 + 3] = ':';
        IOUtils.getChars(i, this.count, cArr2);
    }

    public void write(String str) {
        if (str == null) {
            writeNull();
        } else {
            write(str, 0, str.length());
        }
    }

    public void write(List<String> list) {
        boolean z;
        int i;
        if (list.isEmpty()) {
            write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        int i2 = this.count;
        int size = list.size();
        int i3 = i2;
        int i4 = 0;
        while (i4 < size) {
            String str = list.get(i4);
            if (str == null) {
                z = true;
            } else {
                int length = str.length();
                z = false;
                for (int i5 = 0; i5 < length; i5++) {
                    char charAt = str.charAt(i5);
                    z = charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\\';
                    if (z) {
                        break;
                    }
                }
            }
            if (z) {
                this.count = i2;
                write(91);
                for (int i6 = 0; i6 < list.size(); i6++) {
                    String str2 = list.get(i6);
                    if (i6 != 0) {
                        write(44);
                    }
                    if (str2 == null) {
                        write("null");
                    } else {
                        writeStringWithDoubleQuote(str2, 0);
                    }
                }
                write(93);
                return;
            }
            int length2 = str.length() + i3;
            int i7 = length2 + 3;
            if (i4 == list.size() - 1) {
                i7 = length2 + 4;
            }
            if (i7 > this.buf.length) {
                this.count = i3;
                expandCapacity(i7);
            }
            if (i4 == 0) {
                i = i3 + 1;
                this.buf[i3] = '[';
            } else {
                i = i3 + 1;
                this.buf[i3] = ',';
            }
            int i8 = i + 1;
            this.buf[i] = '\"';
            str.getChars(0, str.length(), this.buf, i8);
            int length3 = i8 + str.length();
            this.buf[length3] = '\"';
            i4++;
            i3 = length3 + 1;
        }
        this.buf[i3] = ']';
        this.count = i3 + 1;
    }

    public void writeStringWithSingleQuote(char[] cArr) {
        int i = 0;
        if (cArr == null) {
            int i2 = this.count + 4;
            if (i2 > this.buf.length) {
                expandCapacity(i2);
            }
            "null".getChars(0, 4, this.buf, this.count);
            this.count = i2;
            return;
        }
        int length = cArr.length;
        int i3 = this.count + length + 2;
        if (i3 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                while (i < cArr.length) {
                    char c = cArr[i];
                    if (c <= 13 || c == '\\' || c == '\'' || (c == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        write(92);
                        write((int) IOUtils.replaceChars[c]);
                    } else {
                        write((int) c);
                    }
                    i++;
                }
                write(39);
                return;
            }
            expandCapacity(i3);
        }
        int i4 = this.count;
        int i5 = i4 + 1;
        int i6 = length + i5;
        char[] cArr2 = this.buf;
        cArr2[i4] = '\'';
        System.arraycopy(cArr, 0, cArr2, i5, cArr.length);
        this.count = i3;
        char c2 = 0;
        int i7 = -1;
        for (int i8 = i5; i8 < i6; i8++) {
            char c3 = this.buf[i8];
            if (c3 <= 13 || c3 == '\\' || c3 == '\'' || (c3 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                i++;
                i7 = i8;
                c2 = c3;
            }
        }
        int i9 = i3 + i;
        if (i9 > this.buf.length) {
            expandCapacity(i9);
        }
        this.count = i9;
        if (i == 1) {
            char[] cArr3 = this.buf;
            int i10 = i7 + 1;
            System.arraycopy(cArr3, i10, cArr3, i7 + 2, (i6 - i7) - 1);
            char[] cArr4 = this.buf;
            cArr4[i7] = '\\';
            cArr4[i10] = IOUtils.replaceChars[c2];
        } else if (i > 1) {
            char[] cArr5 = this.buf;
            int i11 = i7 + 1;
            System.arraycopy(cArr5, i11, cArr5, i7 + 2, (i6 - i7) - 1);
            char[] cArr6 = this.buf;
            cArr6[i7] = '\\';
            cArr6[i11] = IOUtils.replaceChars[c2];
            int i12 = i6 + 1;
            for (int i13 = i7 - 1; i13 >= i5; i13--) {
                char c4 = this.buf[i13];
                if (c4 <= 13 || c4 == '\\' || c4 == '\'' || (c4 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr7 = this.buf;
                    int i14 = i13 + 1;
                    System.arraycopy(cArr7, i14, cArr7, i13 + 2, (i12 - i13) - 1);
                    char[] cArr8 = this.buf;
                    cArr8[i13] = '\\';
                    cArr8[i14] = IOUtils.replaceChars[c4];
                    i12++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeFieldValue(char c, String str, long j) {
        if (j == Long.MIN_VALUE || !this.quoteFieldNames || isEnabled(SerializerFeature.BrowserCompatible.mask)) {
            write((int) c);
            writeFieldName(str);
            writeLong(j);
            return;
        }
        int stringSize = j < 0 ? IOUtils.stringSize(-j) + 1 : IOUtils.stringSize(j);
        int length = str.length();
        int i = this.count + length + 4 + stringSize;
        if (i > this.buf.length) {
            if (this.writer != null) {
                write((int) c);
                writeFieldName(str);
                writeLong(j);
                return;
            }
            expandCapacity(i);
        }
        int i2 = this.count;
        this.count = i;
        char[] cArr = this.buf;
        cArr[i2] = c;
        int i3 = i2 + length;
        cArr[i2 + 1] = this.keySeperator;
        str.getChars(0, length, cArr, i2 + 2);
        char[] cArr2 = this.buf;
        cArr2[i3 + 2] = this.keySeperator;
        cArr2[i3 + 3] = ':';
        IOUtils.getChars(j, this.count, cArr2);
    }

    public void write(boolean z) {
        if (z) {
            write("true");
        } else {
            write("false");
        }
    }

    public void writeFieldValue(char c, String str, float f) {
        write((int) c);
        writeFieldName(str);
        writeFloat(f, false);
    }

    public void writeFieldValue(char c, String str, double d) {
        write((int) c);
        writeFieldName(str);
        writeDouble(d, false);
    }

    public void writeFieldValue(char c, String str, String str2) {
        if (!this.quoteFieldNames) {
            write((int) c);
            writeFieldName(str);
            if (str2 == null) {
                writeNull();
            } else {
                writeString(str2);
            }
        } else if (this.useSingleQuotes) {
            write((int) c);
            writeFieldName(str);
            if (str2 == null) {
                writeNull();
            } else {
                writeString(str2);
            }
        } else if (isEnabled(SerializerFeature.BrowserCompatible)) {
            write((int) c);
            writeStringWithDoubleQuote(str, ':');
            writeStringWithDoubleQuote(str2, 0);
        } else {
            writeFieldValueStringWithDoubleQuoteCheck(c, str, str2);
        }
    }

    public void writeFieldValue(char c, String str, Enum<?> enumR) {
        if (enumR == null) {
            write((int) c);
            writeFieldName(str);
            writeNull();
        } else if (this.writeEnumUsingName && !this.writeEnumUsingToString) {
            writeEnumFieldValue(c, str, enumR.name());
        } else if (this.writeEnumUsingToString) {
            writeEnumFieldValue(c, str, enumR.toString());
        } else {
            writeFieldValue(c, str, enumR.ordinal());
        }
    }

    public void writeFieldValue(char c, String str, BigDecimal bigDecimal) {
        String str2;
        write((int) c);
        writeFieldName(str);
        if (bigDecimal == null) {
            writeNull();
            return;
        }
        int scale = bigDecimal.scale();
        if (!isEnabled(SerializerFeature.WriteBigDecimalAsPlain) || scale < -100 || scale >= 100) {
            str2 = bigDecimal.toString();
        } else {
            str2 = bigDecimal.toPlainString();
        }
        write(str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02e3, code lost:
        if (r8[r14] == 4) goto L_0x02e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0436, code lost:
        if (r4 != '>') goto L_0x047c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02ed  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02f2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeStringWithDoubleQuote(char[] r24, char r25) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            if (r1 != 0) goto L_0x0011
            r23.writeNull()
            if (r2 == 0) goto L_0x0010
            r0.write((int) r2)
        L_0x0010:
            return
        L_0x0011:
            int r3 = r1.length
            int r4 = r0.count
            int r4 = r4 + r3
            int r5 = r4 + 2
            if (r2 == 0) goto L_0x001b
            int r5 = r4 + 3
        L_0x001b:
            char[] r4 = r0.buf
            int r4 = r4.length
            r7 = 62
            r8 = 60
            r9 = 41
            r10 = 40
            r14 = 34
            r15 = 8
            r11 = 12
            r6 = 117(0x75, float:1.64E-43)
            r13 = 92
            r12 = 1
            if (r5 <= r4) goto L_0x015c
            java.io.Writer r4 = r0.writer
            if (r4 == 0) goto L_0x0159
            r0.write((int) r14)
            r3 = 0
        L_0x003b:
            int r4 = r1.length
            if (r3 >= r4) goto L_0x0150
            char r4 = r1[r3]
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserSecure
            boolean r5 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r5)
            if (r5 == 0) goto L_0x007c
            if (r4 == r10) goto L_0x0050
            if (r4 == r9) goto L_0x0050
            if (r4 == r8) goto L_0x0050
            if (r4 != r7) goto L_0x007c
        L_0x0050:
            r0.write((int) r13)
            r0.write((int) r6)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r16 = r4 >>> 12
            r16 = r16 & 15
            char r7 = r5[r16]
            r0.write((int) r7)
            int r7 = r4 >>> 8
            r7 = r7 & 15
            char r7 = r5[r7]
            r0.write((int) r7)
            int r7 = r4 >>> 4
            r7 = r7 & 15
            char r7 = r5[r7]
            r0.write((int) r7)
            r4 = r4 & 15
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x014a
        L_0x007c:
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserCompatible
            boolean r5 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r5)
            if (r5 == 0) goto L_0x00fa
            if (r4 == r15) goto L_0x00ef
            if (r4 == r11) goto L_0x00ef
            r5 = 10
            if (r4 == r5) goto L_0x00ef
            r5 = 13
            if (r4 == r5) goto L_0x00ef
            r5 = 9
            if (r4 == r5) goto L_0x00ef
            if (r4 == r14) goto L_0x00ef
            r5 = 47
            if (r4 == r5) goto L_0x00ef
            if (r4 != r13) goto L_0x009d
            goto L_0x00ef
        L_0x009d:
            r5 = 32
            if (r4 >= r5) goto L_0x00c0
            r0.write((int) r13)
            r0.write((int) r6)
            r5 = 48
            r0.write((int) r5)
            r0.write((int) r5)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.ASCII_CHARS
            int r4 = r4 * 2
            char r7 = r5[r4]
            r0.write((int) r7)
            int r4 = r4 + r12
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x014a
        L_0x00c0:
            r5 = 127(0x7f, float:1.78E-43)
            if (r4 < r5) goto L_0x0147
            r0.write((int) r13)
            r0.write((int) r6)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r7 = r4 >>> 12
            r7 = r7 & 15
            char r7 = r5[r7]
            r0.write((int) r7)
            int r7 = r4 >>> 8
            r7 = r7 & 15
            char r7 = r5[r7]
            r0.write((int) r7)
            int r7 = r4 >>> 4
            r7 = r7 & 15
            char r7 = r5[r7]
            r0.write((int) r7)
            r4 = r4 & 15
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x014a
        L_0x00ef:
            r0.write((int) r13)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x014a
        L_0x00fa:
            byte[] r5 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r7 = r5.length
            if (r4 >= r7) goto L_0x0103
            byte r7 = r5[r4]
            if (r7 != 0) goto L_0x010f
        L_0x0103:
            r7 = 47
            if (r4 != r7) goto L_0x0147
            com.alibaba.fastjson.serializer.SerializerFeature r7 = com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial
            boolean r7 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r7)
            if (r7 == 0) goto L_0x0147
        L_0x010f:
            r0.write((int) r13)
            byte r5 = r5[r4]
            r7 = 4
            if (r5 != r7) goto L_0x013f
            r0.write((int) r6)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r7 = r4 >>> 12
            r7 = r7 & 15
            char r7 = r5[r7]
            r0.write((int) r7)
            int r7 = r4 >>> 8
            r7 = r7 & 15
            char r7 = r5[r7]
            r0.write((int) r7)
            int r7 = r4 >>> 4
            r7 = r7 & 15
            char r7 = r5[r7]
            r0.write((int) r7)
            r4 = r4 & 15
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x014a
        L_0x013f:
            char[] r5 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x014a
        L_0x0147:
            r0.write((int) r4)
        L_0x014a:
            int r3 = r3 + 1
            r7 = 62
            goto L_0x003b
        L_0x0150:
            r0.write((int) r14)
            if (r2 == 0) goto L_0x0158
            r0.write((int) r2)
        L_0x0158:
            return
        L_0x0159:
            r0.expandCapacity(r5)
        L_0x015c:
            int r4 = r0.count
            int r7 = r4 + 1
            int r3 = r3 + r7
            char[] r8 = r0.buf
            r8[r4] = r14
            int r4 = r1.length
            r9 = 0
            java.lang.System.arraycopy(r1, r9, r8, r7, r4)
            r0.count = r5
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserCompatible
            boolean r4 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r4)
            r8 = -1
            if (r4 == 0) goto L_0x0285
            r1 = r7
        L_0x0176:
            if (r1 >= r3) goto L_0x01a9
            char[] r4 = r0.buf
            char r4 = r4[r1]
            if (r4 == r14) goto L_0x01a3
            r9 = 47
            if (r4 == r9) goto L_0x01a3
            if (r4 != r13) goto L_0x0185
            goto L_0x01a3
        L_0x0185:
            if (r4 == r15) goto L_0x01a3
            if (r4 == r11) goto L_0x01a3
            r9 = 10
            if (r4 == r9) goto L_0x01a3
            r9 = 13
            if (r4 == r9) goto L_0x01a3
            r9 = 9
            if (r4 != r9) goto L_0x0196
            goto L_0x01a3
        L_0x0196:
            r9 = 32
            if (r4 >= r9) goto L_0x019e
        L_0x019a:
            int r5 = r5 + 5
        L_0x019c:
            r8 = r1
            goto L_0x01a6
        L_0x019e:
            r9 = 127(0x7f, float:1.78E-43)
            if (r4 < r9) goto L_0x01a6
            goto L_0x019a
        L_0x01a3:
            int r5 = r5 + 1
            goto L_0x019c
        L_0x01a6:
            int r1 = r1 + 1
            goto L_0x0176
        L_0x01a9:
            char[] r1 = r0.buf
            int r1 = r1.length
            if (r5 <= r1) goto L_0x01b1
            r0.expandCapacity(r5)
        L_0x01b1:
            r0.count = r5
        L_0x01b3:
            if (r8 < r7) goto L_0x026f
            char[] r1 = r0.buf
            char r4 = r1[r8]
            if (r4 == r15) goto L_0x0256
            if (r4 == r11) goto L_0x0256
            r5 = 10
            if (r4 == r5) goto L_0x0256
            r5 = 13
            if (r4 == r5) goto L_0x0256
            r5 = 9
            if (r4 != r5) goto L_0x01cb
            goto L_0x0256
        L_0x01cb:
            if (r4 == r14) goto L_0x0243
            r5 = 47
            if (r4 == r5) goto L_0x0243
            if (r4 != r13) goto L_0x01d4
            goto L_0x0243
        L_0x01d4:
            r5 = 32
            if (r4 >= r5) goto L_0x0206
            int r5 = r8 + 1
            int r9 = r8 + 6
            int r10 = r3 - r8
            int r10 = r10 - r12
            java.lang.System.arraycopy(r1, r5, r1, r9, r10)
            char[] r1 = r0.buf
            r1[r8] = r13
            r1[r5] = r6
            int r5 = r8 + 2
            r9 = 48
            r1[r5] = r9
            int r5 = r8 + 3
            r1[r5] = r9
            int r5 = r8 + 4
            char[] r9 = com.alibaba.fastjson.util.IOUtils.ASCII_CHARS
            int r4 = r4 * 2
            char r10 = r9[r4]
            r1[r5] = r10
            int r5 = r8 + 5
            int r4 = r4 + r12
            char r4 = r9[r4]
            r1[r5] = r4
        L_0x0203:
            int r3 = r3 + 5
            goto L_0x026b
        L_0x0206:
            r5 = 127(0x7f, float:1.78E-43)
            if (r4 < r5) goto L_0x026b
            int r5 = r8 + 1
            int r9 = r8 + 6
            int r10 = r3 - r8
            int r10 = r10 - r12
            java.lang.System.arraycopy(r1, r5, r1, r9, r10)
            char[] r1 = r0.buf
            r1[r8] = r13
            r1[r5] = r6
            int r5 = r8 + 2
            char[] r9 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r10 = r4 >>> 12
            r10 = r10 & 15
            char r10 = r9[r10]
            r1[r5] = r10
            int r5 = r8 + 3
            int r10 = r4 >>> 8
            r10 = r10 & 15
            char r10 = r9[r10]
            r1[r5] = r10
            int r5 = r8 + 4
            int r10 = r4 >>> 4
            r10 = r10 & 15
            char r10 = r9[r10]
            r1[r5] = r10
            int r5 = r8 + 5
            r4 = r4 & 15
            char r4 = r9[r4]
            r1[r5] = r4
            goto L_0x0203
        L_0x0243:
            int r5 = r8 + 1
            int r9 = r8 + 2
            int r10 = r3 - r8
            int r10 = r10 - r12
            java.lang.System.arraycopy(r1, r5, r1, r9, r10)
            char[] r1 = r0.buf
            r1[r8] = r13
            r1[r5] = r4
        L_0x0253:
            int r3 = r3 + 1
            goto L_0x026b
        L_0x0256:
            int r5 = r8 + 1
            int r9 = r8 + 2
            int r10 = r3 - r8
            int r10 = r10 - r12
            java.lang.System.arraycopy(r1, r5, r1, r9, r10)
            char[] r1 = r0.buf
            r1[r8] = r13
            char[] r9 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r4 = r9[r4]
            r1[r5] = r4
            goto L_0x0253
        L_0x026b:
            int r8 = r8 + -1
            goto L_0x01b3
        L_0x026f:
            if (r2 == 0) goto L_0x027d
            char[] r1 = r0.buf
            int r3 = r0.count
            int r4 = r3 + -2
            r1[r4] = r14
            int r3 = r3 - r12
            r1[r3] = r2
            goto L_0x0284
        L_0x027d:
            char[] r1 = r0.buf
            int r2 = r0.count
            int r2 = r2 - r12
            r1[r2] = r14
        L_0x0284:
            return
        L_0x0285:
            r4 = r7
            r11 = 0
            r15 = -1
            r16 = -1
        L_0x028a:
            if (r4 >= r3) goto L_0x02ff
            char[] r14 = r0.buf
            char r14 = r14[r4]
            r6 = 93
            if (r14 < r6) goto L_0x02b5
            r6 = 127(0x7f, float:1.78E-43)
            if (r14 < r6) goto L_0x02a5
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r14 == r6) goto L_0x02a9
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r14 == r6) goto L_0x02a9
            r6 = 160(0xa0, float:2.24E-43)
            if (r14 >= r6) goto L_0x02a5
            goto L_0x02a9
        L_0x02a5:
            r19 = r9
        L_0x02a7:
            r6 = -1
            goto L_0x02f5
        L_0x02a9:
            if (r15 != r8) goto L_0x02ac
            r15 = r4
        L_0x02ac:
            int r11 = r11 + 1
            int r5 = r5 + 4
            r16 = r4
            r9 = r14
            r6 = -1
            goto L_0x02f7
        L_0x02b5:
            r6 = 64
            r19 = r9
            if (r14 >= r6) goto L_0x02c9
            long r8 = r0.sepcialBits
            r20 = 1
            long r20 = r20 << r14
            long r8 = r8 & r20
            r20 = 0
            int r22 = (r8 > r20 ? 1 : (r8 == r20 ? 0 : -1))
            if (r22 != 0) goto L_0x02cb
        L_0x02c9:
            if (r14 != r13) goto L_0x02a7
        L_0x02cb:
            int r11 = r11 + 1
            if (r14 == r10) goto L_0x02e8
            r8 = 41
            if (r14 == r8) goto L_0x02e8
            r8 = 60
            if (r14 == r8) goto L_0x02e8
            r8 = 62
            if (r14 == r8) goto L_0x02e8
            byte[] r8 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r9 = r8.length
            if (r14 >= r9) goto L_0x02e6
            byte r8 = r8[r14]
            r9 = 4
            if (r8 != r9) goto L_0x02e6
            goto L_0x02e8
        L_0x02e6:
            r6 = -1
            goto L_0x02eb
        L_0x02e8:
            int r5 = r5 + 4
            goto L_0x02e6
        L_0x02eb:
            if (r15 != r6) goto L_0x02f2
            r15 = r4
            r16 = r15
        L_0x02f0:
            r9 = r14
            goto L_0x02f7
        L_0x02f2:
            r16 = r4
            goto L_0x02f0
        L_0x02f5:
            r9 = r19
        L_0x02f7:
            int r4 = r4 + 1
            r6 = 117(0x75, float:1.64E-43)
            r8 = -1
            r14 = 34
            goto L_0x028a
        L_0x02ff:
            r19 = r9
            if (r11 <= 0) goto L_0x0522
            int r5 = r5 + r11
            char[] r4 = r0.buf
            int r4 = r4.length
            if (r5 <= r4) goto L_0x030c
            r0.expandCapacity(r5)
        L_0x030c:
            r0.count = r5
            if (r11 != r12) goto L_0x041d
            r1 = 8232(0x2028, float:1.1535E-41)
            r4 = 50
            r9 = r19
            if (r9 != r1) goto L_0x0342
            int r1 = r16 + 1
            int r5 = r16 + 6
            int r3 = r3 - r16
            int r3 = r3 - r12
            char[] r6 = r0.buf
            java.lang.System.arraycopy(r6, r1, r6, r5, r3)
            char[] r3 = r0.buf
            r3[r16] = r13
            r5 = 117(0x75, float:1.64E-43)
            r3[r1] = r5
            int r1 = r16 + 2
            r3[r1] = r4
            int r1 = r16 + 3
            r5 = 48
            r3[r1] = r5
            int r1 = r16 + 4
            r3[r1] = r4
            int r16 = r16 + 5
            r1 = 56
            r3[r16] = r1
            goto L_0x0522
        L_0x0342:
            r1 = 8233(0x2029, float:1.1537E-41)
            if (r9 != r1) goto L_0x0370
            int r1 = r16 + 1
            int r5 = r16 + 6
            int r3 = r3 - r16
            int r3 = r3 - r12
            char[] r6 = r0.buf
            java.lang.System.arraycopy(r6, r1, r6, r5, r3)
            char[] r3 = r0.buf
            r3[r16] = r13
            r5 = 117(0x75, float:1.64E-43)
            r3[r1] = r5
            int r1 = r16 + 2
            r3[r1] = r4
            int r1 = r16 + 3
            r5 = 48
            r3[r1] = r5
            int r1 = r16 + 4
            r3[r1] = r4
            int r16 = r16 + 5
            r1 = 57
            r3[r16] = r1
            goto L_0x0522
        L_0x0370:
            if (r9 == r10) goto L_0x03df
            r1 = 41
            if (r9 == r1) goto L_0x03df
            r1 = 60
            if (r9 == r1) goto L_0x03df
            r1 = 62
            if (r9 != r1) goto L_0x037f
            goto L_0x03df
        L_0x037f:
            byte[] r1 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r4 = r1.length
            if (r9 >= r4) goto L_0x03c7
            byte r1 = r1[r9]
            r4 = 4
            if (r1 != r4) goto L_0x03c7
            int r1 = r16 + 1
            int r4 = r16 + 6
            int r3 = r3 - r16
            int r3 = r3 - r12
            char[] r5 = r0.buf
            java.lang.System.arraycopy(r5, r1, r5, r4, r3)
            char[] r3 = r0.buf
            r3[r16] = r13
            int r4 = r16 + 2
            r5 = 117(0x75, float:1.64E-43)
            r3[r1] = r5
            int r1 = r16 + 3
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r6 = r9 >>> 12
            r6 = r6 & 15
            char r6 = r5[r6]
            r3[r4] = r6
            int r4 = r16 + 4
            int r6 = r9 >>> 8
            r6 = r6 & 15
            char r6 = r5[r6]
            r3[r1] = r6
            int r16 = r16 + 5
            int r1 = r9 >>> 4
            r1 = r1 & 15
            char r1 = r5[r1]
            r3[r4] = r1
            r1 = r9 & 15
            char r1 = r5[r1]
            r3[r16] = r1
            goto L_0x0522
        L_0x03c7:
            int r1 = r16 + 1
            int r4 = r16 + 2
            int r3 = r3 - r16
            int r3 = r3 - r12
            char[] r5 = r0.buf
            java.lang.System.arraycopy(r5, r1, r5, r4, r3)
            char[] r3 = r0.buf
            r3[r16] = r13
            char[] r4 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r4 = r4[r9]
            r3[r1] = r4
            goto L_0x0522
        L_0x03df:
            int r1 = r16 + 1
            int r4 = r16 + 6
            int r3 = r3 - r16
            int r3 = r3 - r12
            char[] r5 = r0.buf
            java.lang.System.arraycopy(r5, r1, r5, r4, r3)
            char[] r3 = r0.buf
            r3[r16] = r13
            r4 = 117(0x75, float:1.64E-43)
            r3[r1] = r4
            int r1 = r16 + 2
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r5 = r9 >>> 12
            r5 = r5 & 15
            char r5 = r4[r5]
            r3[r1] = r5
            int r1 = r16 + 3
            int r5 = r9 >>> 8
            r5 = r5 & 15
            char r5 = r4[r5]
            r3[r1] = r5
            int r1 = r16 + 4
            int r5 = r9 >>> 4
            r5 = r5 & 15
            char r5 = r4[r5]
            r3[r1] = r5
            int r16 = r16 + 5
            r1 = r9 & 15
            char r1 = r4[r1]
            r3[r16] = r1
            goto L_0x0522
        L_0x041d:
            if (r11 <= r12) goto L_0x0522
            int r3 = r15 - r7
        L_0x0421:
            int r4 = r1.length
            if (r3 >= r4) goto L_0x0522
            char r4 = r1[r3]
            boolean r5 = r0.browserSecure
            if (r5 == 0) goto L_0x0476
            r5 = 41
            r6 = 60
            if (r4 == r10) goto L_0x0439
            if (r4 == r5) goto L_0x0439
            r7 = 62
            if (r4 == r6) goto L_0x043b
            if (r4 != r7) goto L_0x047c
            goto L_0x043b
        L_0x0439:
            r7 = 62
        L_0x043b:
            char[] r8 = r0.buf
            int r9 = r15 + 1
            r8[r15] = r13
            int r11 = r15 + 2
            r14 = 117(0x75, float:1.64E-43)
            r8[r9] = r14
            int r9 = r15 + 3
            char[] r14 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r16 = r4 >>> 12
            r16 = r16 & 15
            char r16 = r14[r16]
            r8[r11] = r16
            int r11 = r15 + 4
            int r16 = r4 >>> 8
            r16 = r16 & 15
            char r16 = r14[r16]
            r8[r9] = r16
            int r9 = r15 + 5
            int r16 = r4 >>> 4
            r16 = r16 & 15
            char r16 = r14[r16]
            r8[r11] = r16
            int r15 = r15 + 6
            r4 = r4 & 15
            char r4 = r14[r4]
            r8[r9] = r4
            r5 = 4
            r9 = 47
        L_0x0472:
            r16 = 117(0x75, float:1.64E-43)
            goto L_0x051e
        L_0x0476:
            r5 = 41
            r6 = 60
            r7 = 62
        L_0x047c:
            byte[] r8 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r9 = r8.length
            if (r4 >= r9) goto L_0x0485
            byte r9 = r8[r4]
            if (r9 != 0) goto L_0x0488
        L_0x0485:
            r9 = 47
            goto L_0x048b
        L_0x0488:
            r9 = 47
            goto L_0x0495
        L_0x048b:
            if (r4 != r9) goto L_0x04d8
            com.alibaba.fastjson.serializer.SerializerFeature r11 = com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial
            boolean r11 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r11)
            if (r11 == 0) goto L_0x04d8
        L_0x0495:
            char[] r11 = r0.buf
            int r14 = r15 + 1
            r11[r15] = r13
            byte r8 = r8[r4]
            r5 = 4
            if (r8 != r5) goto L_0x04cf
            int r8 = r15 + 2
            r16 = 117(0x75, float:1.64E-43)
            r11[r14] = r16
            int r14 = r15 + 3
            char[] r16 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r17 = r4 >>> 12
            r17 = r17 & 15
            char r17 = r16[r17]
            r11[r8] = r17
            int r8 = r15 + 4
            int r17 = r4 >>> 8
            r17 = r17 & 15
            char r17 = r16[r17]
            r11[r14] = r17
            int r14 = r15 + 5
            int r17 = r4 >>> 4
            r17 = r17 & 15
            char r17 = r16[r17]
            r11[r8] = r17
            int r15 = r15 + 6
            r4 = r4 & 15
            char r4 = r16[r4]
            r11[r14] = r4
            goto L_0x0472
        L_0x04cf:
            int r15 = r15 + 2
            char[] r8 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r4 = r8[r4]
            r11[r14] = r4
            goto L_0x0472
        L_0x04d8:
            r5 = 4
            r8 = 8232(0x2028, float:1.1535E-41)
            if (r4 == r8) goto L_0x04ea
            r8 = 8233(0x2029, float:1.1537E-41)
            if (r4 != r8) goto L_0x04e2
            goto L_0x04ea
        L_0x04e2:
            char[] r8 = r0.buf
            int r11 = r15 + 1
            r8[r15] = r4
            r15 = r11
            goto L_0x0472
        L_0x04ea:
            char[] r8 = r0.buf
            int r11 = r15 + 1
            r8[r15] = r13
            int r14 = r15 + 2
            r16 = 117(0x75, float:1.64E-43)
            r8[r11] = r16
            int r11 = r15 + 3
            char[] r17 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r18 = r4 >>> 12
            r18 = r18 & 15
            char r18 = r17[r18]
            r8[r14] = r18
            int r14 = r15 + 4
            int r18 = r4 >>> 8
            r18 = r18 & 15
            char r18 = r17[r18]
            r8[r11] = r18
            int r11 = r15 + 5
            int r18 = r4 >>> 4
            r18 = r18 & 15
            char r18 = r17[r18]
            r8[r14] = r18
            int r15 = r15 + 6
            r4 = r4 & 15
            char r4 = r17[r4]
            r8[r11] = r4
        L_0x051e:
            int r3 = r3 + 1
            goto L_0x0421
        L_0x0522:
            if (r2 == 0) goto L_0x0532
            char[] r1 = r0.buf
            int r3 = r0.count
            int r4 = r3 + -2
            r5 = 34
            r1[r4] = r5
            int r3 = r3 - r12
            r1[r3] = r2
            goto L_0x053b
        L_0x0532:
            r5 = 34
            char[] r1 = r0.buf
            int r2 = r0.count
            int r2 = r2 - r12
            r1[r2] = r5
        L_0x053b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeStringWithDoubleQuote(char[], char):void");
    }
}
