package com.alibaba.fastjson;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public abstract class JSONValidator implements Cloneable, Closeable {
    protected char ch;
    protected int count = 0;
    protected boolean eof;
    protected int pos = -1;
    protected boolean supportMultiValue = false;
    protected Type type;
    private Boolean validateResult;

    public static class ReaderValidator extends JSONValidator {
        private static final ThreadLocal<char[]> bufLocal = new ThreadLocal<>();
        private char[] buf;
        private int end = -1;
        final Reader r;
        private int readCount = 0;

        public ReaderValidator(Reader reader) {
            this.r = reader;
            ThreadLocal<char[]> threadLocal = bufLocal;
            char[] cArr = threadLocal.get();
            this.buf = cArr;
            if (cArr != null) {
                threadLocal.set((Object) null);
            } else {
                this.buf = new char[8192];
            }
            next();
            skipWhiteSpace();
        }

        public void close() throws IOException {
            bufLocal.set(this.buf);
            this.r.close();
        }

        public void next() {
            int i = this.pos;
            if (i < this.end) {
                char[] cArr = this.buf;
                int i2 = i + 1;
                this.pos = i2;
                this.ch = cArr[i2];
            } else if (!this.eof) {
                try {
                    Reader reader = this.r;
                    char[] cArr2 = this.buf;
                    int read = reader.read(cArr2, 0, cArr2.length);
                    this.readCount++;
                    if (read > 0) {
                        this.ch = this.buf[0];
                        this.pos = 0;
                        this.end = read - 1;
                    } else if (read == -1) {
                        this.pos = 0;
                        this.end = 0;
                        this.buf = null;
                        this.ch = 0;
                        this.eof = true;
                    } else {
                        this.pos = 0;
                        this.end = 0;
                        this.buf = null;
                        this.ch = 0;
                        this.eof = true;
                        throw new JSONException("read error");
                    }
                } catch (IOException unused) {
                    throw new JSONException("read error");
                }
            }
        }
    }

    public enum Type {
        Object,
        Array,
        Value
    }

    public static class UTF16Validator extends JSONValidator {
        private final String str;

        public UTF16Validator(String str2) {
            this.str = str2;
            next();
            skipWhiteSpace();
        }

        public final void fieldName() {
            char charAt;
            int i = this.pos;
            do {
                i++;
                if (i >= this.str.length() || (charAt = this.str.charAt(i)) == '\\') {
                    next();
                    while (true) {
                        char c = this.ch;
                        if (c == '\\') {
                            next();
                            if (this.ch == 'u') {
                                next();
                                next();
                                next();
                                next();
                                next();
                            } else {
                                next();
                            }
                        } else if (c == '\"') {
                            next();
                            return;
                        } else if (!this.eof) {
                            next();
                        } else {
                            return;
                        }
                    }
                }
            } while (charAt != '\"');
            int i2 = i + 1;
            this.ch = this.str.charAt(i2);
            this.pos = i2;
        }

        public void next() {
            int i = this.pos + 1;
            this.pos = i;
            if (i >= this.str.length()) {
                this.ch = 0;
                this.eof = true;
                return;
            }
            this.ch = this.str.charAt(this.pos);
        }
    }

    public static class UTF8InputStreamValidator extends JSONValidator {
        private static final ThreadLocal<byte[]> bufLocal = new ThreadLocal<>();
        private byte[] buf;
        private int end = -1;
        private final InputStream is;
        private int readCount = 0;

        public UTF8InputStreamValidator(InputStream inputStream) {
            this.is = inputStream;
            ThreadLocal<byte[]> threadLocal = bufLocal;
            byte[] bArr = threadLocal.get();
            this.buf = bArr;
            if (bArr != null) {
                threadLocal.set((Object) null);
            } else {
                this.buf = new byte[8192];
            }
            next();
            skipWhiteSpace();
        }

        public void close() throws IOException {
            bufLocal.set(this.buf);
            this.is.close();
        }

        public void next() {
            int i = this.pos;
            if (i < this.end) {
                byte[] bArr = this.buf;
                int i2 = i + 1;
                this.pos = i2;
                this.ch = (char) bArr[i2];
            } else if (!this.eof) {
                try {
                    InputStream inputStream = this.is;
                    byte[] bArr2 = this.buf;
                    int read = inputStream.read(bArr2, 0, bArr2.length);
                    this.readCount++;
                    if (read > 0) {
                        this.ch = (char) this.buf[0];
                        this.pos = 0;
                        this.end = read - 1;
                    } else if (read == -1) {
                        this.pos = 0;
                        this.end = 0;
                        this.buf = null;
                        this.ch = 0;
                        this.eof = true;
                    } else {
                        this.pos = 0;
                        this.end = 0;
                        this.buf = null;
                        this.ch = 0;
                        this.eof = true;
                        throw new JSONException("read error");
                    }
                } catch (IOException unused) {
                    throw new JSONException("read error");
                }
            }
        }
    }

    public static class UTF8Validator extends JSONValidator {
        private final byte[] bytes;

        public UTF8Validator(byte[] bArr) {
            this.bytes = bArr;
            next();
            skipWhiteSpace();
        }

        public void next() {
            int i = this.pos + 1;
            this.pos = i;
            byte[] bArr = this.bytes;
            if (i >= bArr.length) {
                this.ch = 0;
                this.eof = true;
                return;
            }
            this.ch = (char) bArr[i];
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0173, code lost:
        if (r0 <= '9') goto L_0x0176;
     */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0183  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean any() {
        /*
            r13 = this;
            char r0 = r13.ch
            r1 = 117(0x75, float:1.64E-43)
            r2 = 34
            r3 = 1
            r4 = 0
            if (r0 == r2) goto L_0x01c5
            r5 = 101(0x65, float:1.42E-43)
            r6 = 45
            r7 = 43
            if (r0 == r7) goto L_0x0161
            if (r0 == r6) goto L_0x0161
            r8 = 91
            r9 = 93
            r10 = 44
            if (r0 == r8) goto L_0x012f
            r8 = 102(0x66, float:1.43E-43)
            r11 = 108(0x6c, float:1.51E-43)
            r12 = 125(0x7d, float:1.75E-43)
            if (r0 == r8) goto L_0x00ef
            r8 = 110(0x6e, float:1.54E-43)
            if (r0 == r8) goto L_0x00bb
            r8 = 116(0x74, float:1.63E-43)
            if (r0 == r8) goto L_0x0085
            r1 = 123(0x7b, float:1.72E-43)
            if (r0 == r1) goto L_0x0034
            switch(r0) {
                case 48: goto L_0x0161;
                case 49: goto L_0x0161;
                case 50: goto L_0x0161;
                case 51: goto L_0x0161;
                case 52: goto L_0x0161;
                case 53: goto L_0x0161;
                case 54: goto L_0x0161;
                case 55: goto L_0x0161;
                case 56: goto L_0x0161;
                case 57: goto L_0x0161;
                default: goto L_0x0033;
            }
        L_0x0033:
            return r4
        L_0x0034:
            r13.next()
        L_0x0037:
            char r0 = r13.ch
            boolean r0 = isWhiteSpace(r0)
            if (r0 == 0) goto L_0x0043
            r13.next()
            goto L_0x0037
        L_0x0043:
            char r0 = r13.ch
            if (r0 != r12) goto L_0x004f
            r13.next()
            com.alibaba.fastjson.JSONValidator$Type r0 = com.alibaba.fastjson.JSONValidator.Type.Object
            r13.type = r0
            return r3
        L_0x004f:
            char r0 = r13.ch
            if (r0 != r2) goto L_0x0084
            r13.fieldName()
            r13.skipWhiteSpace()
            char r0 = r13.ch
            r1 = 58
            if (r0 != r1) goto L_0x0084
            r13.next()
            r13.skipWhiteSpace()
            boolean r0 = r13.any()
            if (r0 != 0) goto L_0x006c
            return r4
        L_0x006c:
            r13.skipWhiteSpace()
            char r0 = r13.ch
            if (r0 != r10) goto L_0x007a
            r13.next()
            r13.skipWhiteSpace()
            goto L_0x004f
        L_0x007a:
            if (r0 != r12) goto L_0x0084
            r13.next()
            com.alibaba.fastjson.JSONValidator$Type r0 = com.alibaba.fastjson.JSONValidator.Type.Object
            r13.type = r0
            return r3
        L_0x0084:
            return r4
        L_0x0085:
            r13.next()
            char r0 = r13.ch
            r2 = 114(0x72, float:1.6E-43)
            if (r0 == r2) goto L_0x008f
            return r4
        L_0x008f:
            r13.next()
            char r0 = r13.ch
            if (r0 == r1) goto L_0x0097
            return r4
        L_0x0097:
            r13.next()
            char r0 = r13.ch
            if (r0 == r5) goto L_0x009f
            return r4
        L_0x009f:
            r13.next()
            char r0 = r13.ch
            boolean r0 = isWhiteSpace(r0)
            if (r0 != 0) goto L_0x00b6
            char r0 = r13.ch
            if (r0 == r10) goto L_0x00b6
            if (r0 == r9) goto L_0x00b6
            if (r0 == r12) goto L_0x00b6
            if (r0 != 0) goto L_0x00b5
            goto L_0x00b6
        L_0x00b5:
            return r4
        L_0x00b6:
            com.alibaba.fastjson.JSONValidator$Type r0 = com.alibaba.fastjson.JSONValidator.Type.Value
            r13.type = r0
            return r3
        L_0x00bb:
            r13.next()
            char r0 = r13.ch
            if (r0 == r1) goto L_0x00c3
            return r4
        L_0x00c3:
            r13.next()
            char r0 = r13.ch
            if (r0 == r11) goto L_0x00cb
            return r4
        L_0x00cb:
            r13.next()
            char r0 = r13.ch
            if (r0 == r11) goto L_0x00d3
            return r4
        L_0x00d3:
            r13.next()
            char r0 = r13.ch
            boolean r0 = isWhiteSpace(r0)
            if (r0 != 0) goto L_0x00ea
            char r0 = r13.ch
            if (r0 == r10) goto L_0x00ea
            if (r0 == r9) goto L_0x00ea
            if (r0 == r12) goto L_0x00ea
            if (r0 != 0) goto L_0x00e9
            goto L_0x00ea
        L_0x00e9:
            return r4
        L_0x00ea:
            com.alibaba.fastjson.JSONValidator$Type r0 = com.alibaba.fastjson.JSONValidator.Type.Value
            r13.type = r0
            return r3
        L_0x00ef:
            r13.next()
            char r0 = r13.ch
            r1 = 97
            if (r0 == r1) goto L_0x00f9
            return r4
        L_0x00f9:
            r13.next()
            char r0 = r13.ch
            if (r0 == r11) goto L_0x0101
            return r4
        L_0x0101:
            r13.next()
            char r0 = r13.ch
            r1 = 115(0x73, float:1.61E-43)
            if (r0 == r1) goto L_0x010b
            return r4
        L_0x010b:
            r13.next()
            char r0 = r13.ch
            if (r0 == r5) goto L_0x0113
            return r4
        L_0x0113:
            r13.next()
            char r0 = r13.ch
            boolean r0 = isWhiteSpace(r0)
            if (r0 != 0) goto L_0x012a
            char r0 = r13.ch
            if (r0 == r10) goto L_0x012a
            if (r0 == r9) goto L_0x012a
            if (r0 == r12) goto L_0x012a
            if (r0 != 0) goto L_0x0129
            goto L_0x012a
        L_0x0129:
            return r4
        L_0x012a:
            com.alibaba.fastjson.JSONValidator$Type r0 = com.alibaba.fastjson.JSONValidator.Type.Value
            r13.type = r0
            return r3
        L_0x012f:
            r13.next()
            r13.skipWhiteSpace()
            char r0 = r13.ch
            if (r0 != r9) goto L_0x0141
            r13.next()
            com.alibaba.fastjson.JSONValidator$Type r0 = com.alibaba.fastjson.JSONValidator.Type.Array
            r13.type = r0
            return r3
        L_0x0141:
            boolean r0 = r13.any()
            if (r0 != 0) goto L_0x0148
            return r4
        L_0x0148:
            r13.skipWhiteSpace()
            char r0 = r13.ch
            if (r0 != r10) goto L_0x0156
            r13.next()
            r13.skipWhiteSpace()
            goto L_0x0141
        L_0x0156:
            if (r0 != r9) goto L_0x0160
            r13.next()
            com.alibaba.fastjson.JSONValidator$Type r0 = com.alibaba.fastjson.JSONValidator.Type.Array
            r13.type = r0
            return r3
        L_0x0160:
            return r4
        L_0x0161:
            r1 = 57
            r2 = 48
            if (r0 == r6) goto L_0x0169
            if (r0 != r7) goto L_0x0176
        L_0x0169:
            r13.next()
            r13.skipWhiteSpace()
            char r0 = r13.ch
            if (r0 < r2) goto L_0x01c4
            if (r0 <= r1) goto L_0x0176
            goto L_0x01c4
        L_0x0176:
            r13.next()
            char r0 = r13.ch
            if (r0 < r2) goto L_0x017f
            if (r0 <= r1) goto L_0x0176
        L_0x017f:
            r8 = 46
            if (r0 != r8) goto L_0x0198
            r13.next()
            char r0 = r13.ch
            if (r0 < r2) goto L_0x0197
            if (r0 <= r1) goto L_0x018d
            goto L_0x0197
        L_0x018d:
            char r0 = r13.ch
            if (r0 < r2) goto L_0x0198
            if (r0 > r1) goto L_0x0198
            r13.next()
            goto L_0x018d
        L_0x0197:
            return r4
        L_0x0198:
            char r0 = r13.ch
            if (r0 == r5) goto L_0x01a0
            r5 = 69
            if (r0 != r5) goto L_0x01bf
        L_0x01a0:
            r13.next()
            char r0 = r13.ch
            if (r0 == r6) goto L_0x01a9
            if (r0 != r7) goto L_0x01ac
        L_0x01a9:
            r13.next()
        L_0x01ac:
            char r0 = r13.ch
            if (r0 < r2) goto L_0x01c4
            if (r0 > r1) goto L_0x01c4
            r13.next()
        L_0x01b5:
            char r0 = r13.ch
            if (r0 < r2) goto L_0x01bf
            if (r0 > r1) goto L_0x01bf
            r13.next()
            goto L_0x01b5
        L_0x01bf:
            com.alibaba.fastjson.JSONValidator$Type r0 = com.alibaba.fastjson.JSONValidator.Type.Value
            r13.type = r0
            return r3
        L_0x01c4:
            return r4
        L_0x01c5:
            r13.next()
        L_0x01c8:
            boolean r0 = r13.eof
            if (r0 == 0) goto L_0x01cd
            return r4
        L_0x01cd:
            char r0 = r13.ch
            r5 = 92
            if (r0 != r5) goto L_0x01ee
            r13.next()
            char r0 = r13.ch
            if (r0 != r1) goto L_0x01ea
            r13.next()
            r13.next()
            r13.next()
            r13.next()
            r13.next()
            goto L_0x01c8
        L_0x01ea:
            r13.next()
            goto L_0x01c8
        L_0x01ee:
            if (r0 != r2) goto L_0x01f8
            r13.next()
            com.alibaba.fastjson.JSONValidator$Type r0 = com.alibaba.fastjson.JSONValidator.Type.Value
            r13.type = r0
            return r3
        L_0x01f8:
            r13.next()
            goto L_0x01c8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONValidator.any():boolean");
    }

    public static JSONValidator from(String str) {
        return new UTF16Validator(str);
    }

    public static JSONValidator fromUtf8(byte[] bArr) {
        return new UTF8Validator(bArr);
    }

    public static final boolean isWhiteSpace(char c) {
        return c == ' ' || c == 9 || c == 13 || c == 10 || c == 12 || c == 8;
    }

    public void close() throws IOException {
    }

    public void fieldName() {
        next();
        while (true) {
            char c = this.ch;
            if (c == '\\') {
                next();
                if (this.ch == 'u') {
                    next();
                    next();
                    next();
                    next();
                    next();
                } else {
                    next();
                }
            } else if (c == '\"') {
                next();
                return;
            } else {
                next();
            }
        }
    }

    public Type getType() {
        if (this.type == null) {
            validate();
        }
        return this.type;
    }

    public boolean isSupportMultiValue() {
        return this.supportMultiValue;
    }

    public abstract void next();

    public JSONValidator setSupportMultiValue(boolean z) {
        this.supportMultiValue = z;
        return this;
    }

    public void skipWhiteSpace() {
        while (isWhiteSpace(this.ch)) {
            next();
        }
    }

    public boolean string() {
        next();
        while (!this.eof) {
            char c = this.ch;
            if (c == '\\') {
                next();
                if (this.ch == 'u') {
                    next();
                    next();
                    next();
                    next();
                    next();
                } else {
                    next();
                }
            } else if (c == '\"') {
                next();
                return true;
            } else {
                next();
            }
        }
        return false;
    }

    public boolean validate() {
        Boolean bool = this.validateResult;
        if (bool != null) {
            return bool.booleanValue();
        }
        while (any()) {
            skipWhiteSpace();
            this.count++;
            if (this.eof) {
                this.validateResult = Boolean.TRUE;
                return true;
            } else if (this.supportMultiValue) {
                skipWhiteSpace();
                if (this.eof) {
                    this.validateResult = Boolean.TRUE;
                    return true;
                }
            } else {
                this.validateResult = Boolean.FALSE;
                return false;
            }
        }
        this.validateResult = Boolean.FALSE;
        return false;
    }

    public static JSONValidator from(Reader reader) {
        return new ReaderValidator(reader);
    }

    public static JSONValidator fromUtf8(InputStream inputStream) {
        return new UTF8InputStreamValidator(inputStream);
    }
}
