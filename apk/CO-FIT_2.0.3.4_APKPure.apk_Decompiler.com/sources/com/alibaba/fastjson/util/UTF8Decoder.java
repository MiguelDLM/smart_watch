package com.alibaba.fastjson.util;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

public class UTF8Decoder extends CharsetDecoder {
    private static final Charset charset = Charset.forName("UTF-8");

    public UTF8Decoder() {
        super(charset, 1.0f, 1.0f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0090, code lost:
        return xflow(r13, r5, r6, r14, r8, 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c7, code lost:
        return xflow(r13, r5, r6, r14, r8, 3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x012c, code lost:
        return xflow(r13, r5, r6, r14, r8, 4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.nio.charset.CoderResult decodeArrayLoop(java.nio.ByteBuffer r13, java.nio.CharBuffer r14) {
        /*
            r12 = this;
            byte[] r0 = r13.array()
            int r1 = r13.arrayOffset()
            int r2 = r13.position()
            int r1 = r1 + r2
            int r2 = r13.arrayOffset()
            int r3 = r13.limit()
            int r6 = r2 + r3
            char[] r2 = r14.array()
            int r3 = r14.arrayOffset()
            int r4 = r14.position()
            int r3 = r3 + r4
            int r4 = r14.arrayOffset()
            int r5 = r14.limit()
            int r4 = r4 + r5
            int r5 = r6 - r1
            int r7 = r4 - r3
            int r5 = java.lang.Math.min(r5, r7)
            int r5 = r5 + r3
        L_0x0036:
            if (r3 >= r5) goto L_0x0045
            byte r7 = r0[r1]
            if (r7 < 0) goto L_0x0045
            int r8 = r3 + 1
            int r1 = r1 + 1
            char r7 = (char) r7
            r2[r3] = r7
            r3 = r8
            goto L_0x0036
        L_0x0045:
            r5 = r1
        L_0x0046:
            r8 = r3
        L_0x0047:
            if (r5 >= r6) goto L_0x0133
            byte r1 = r0[r5]
            if (r1 < 0) goto L_0x005f
            if (r8 < r4) goto L_0x0057
            r9 = 1
            r4 = r13
            r7 = r14
            java.nio.charset.CoderResult r13 = xflow(r4, r5, r6, r7, r8, r9)
            return r13
        L_0x0057:
            int r3 = r8 + 1
            char r1 = (char) r1
            r2[r8] = r1
            int r5 = r5 + 1
            goto L_0x0046
        L_0x005f:
            int r3 = r1 >> 5
            r7 = -2
            r9 = 2
            if (r3 != r7) goto L_0x0091
            int r3 = r6 - r5
            if (r3 < r9) goto L_0x0089
            if (r8 < r4) goto L_0x006c
            goto L_0x0089
        L_0x006c:
            int r3 = r5 + 1
            byte r3 = r0[r3]
            boolean r7 = isMalformed2(r1, r3)
            if (r7 == 0) goto L_0x007b
            java.nio.charset.CoderResult r13 = malformed(r13, r5, r14, r8, r9)
            return r13
        L_0x007b:
            int r7 = r8 + 1
            int r1 = r1 << 6
            r1 = r1 ^ r3
            r1 = r1 ^ 3968(0xf80, float:5.56E-42)
            char r1 = (char) r1
            r2[r8] = r1
            int r5 = r5 + 2
        L_0x0087:
            r8 = r7
            goto L_0x0047
        L_0x0089:
            r9 = 2
            r4 = r13
            r7 = r14
            java.nio.charset.CoderResult r13 = xflow(r4, r5, r6, r7, r8, r9)
            return r13
        L_0x0091:
            int r3 = r1 >> 4
            if (r3 != r7) goto L_0x00c8
            int r3 = r6 - r5
            r7 = 3
            if (r3 < r7) goto L_0x00c0
            if (r8 < r4) goto L_0x009d
            goto L_0x00c0
        L_0x009d:
            int r3 = r5 + 1
            byte r3 = r0[r3]
            int r9 = r5 + 2
            byte r9 = r0[r9]
            boolean r10 = isMalformed3(r1, r3, r9)
            if (r10 == 0) goto L_0x00b0
            java.nio.charset.CoderResult r13 = malformed(r13, r5, r14, r8, r7)
            return r13
        L_0x00b0:
            int r7 = r8 + 1
            int r1 = r1 << 12
            int r3 = r3 << 6
            r1 = r1 ^ r3
            r1 = r1 ^ r9
            r1 = r1 ^ 8064(0x1f80, float:1.13E-41)
            char r1 = (char) r1
            r2[r8] = r1
            int r5 = r5 + 3
            goto L_0x0087
        L_0x00c0:
            r9 = 3
            r4 = r13
            r7 = r14
            java.nio.charset.CoderResult r13 = xflow(r4, r5, r6, r7, r8, r9)
            return r13
        L_0x00c8:
            int r3 = r1 >> 3
            if (r3 != r7) goto L_0x012d
            int r3 = r6 - r5
            r7 = 4
            if (r3 < r7) goto L_0x0125
            int r3 = r4 - r8
            if (r3 >= r9) goto L_0x00d6
            goto L_0x0125
        L_0x00d6:
            int r3 = r5 + 1
            byte r3 = r0[r3]
            int r9 = r5 + 2
            byte r9 = r0[r9]
            int r10 = r5 + 3
            byte r10 = r0[r10]
            r1 = r1 & 7
            int r1 = r1 << 18
            r11 = r3 & 63
            int r11 = r11 << 12
            r1 = r1 | r11
            r11 = r9 & 63
            int r11 = r11 << 6
            r1 = r1 | r11
            r11 = r10 & 63
            r1 = r1 | r11
            boolean r3 = isMalformed4(r3, r9, r10)
            if (r3 != 0) goto L_0x0120
            r3 = 65536(0x10000, float:9.18355E-41)
            if (r1 < r3) goto L_0x0120
            r9 = 1114111(0x10ffff, float:1.561202E-39)
            if (r1 <= r9) goto L_0x0103
            goto L_0x0120
        L_0x0103:
            int r7 = r8 + 1
            int r1 = r1 - r3
            int r3 = r1 >> 10
            r3 = r3 & 1023(0x3ff, float:1.434E-42)
            r9 = 55296(0xd800, float:7.7486E-41)
            r3 = r3 | r9
            char r3 = (char) r3
            r2[r8] = r3
            int r8 = r8 + 2
            r3 = 56320(0xdc00, float:7.8921E-41)
            r1 = r1 & 1023(0x3ff, float:1.434E-42)
            r1 = r1 | r3
            char r1 = (char) r1
            r2[r7] = r1
            int r5 = r5 + 4
            goto L_0x0047
        L_0x0120:
            java.nio.charset.CoderResult r13 = malformed(r13, r5, r14, r8, r7)
            return r13
        L_0x0125:
            r9 = 4
            r4 = r13
            r7 = r14
            java.nio.charset.CoderResult r13 = xflow(r4, r5, r6, r7, r8, r9)
            return r13
        L_0x012d:
            r0 = 1
            java.nio.charset.CoderResult r13 = malformed(r13, r5, r14, r8, r0)
            return r13
        L_0x0133:
            r9 = 0
            r4 = r13
            r7 = r14
            java.nio.charset.CoderResult r13 = xflow(r4, r5, r6, r7, r8, r9)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.UTF8Decoder.decodeArrayLoop(java.nio.ByteBuffer, java.nio.CharBuffer):java.nio.charset.CoderResult");
    }

    private static boolean isMalformed2(int i, int i2) {
        return (i & 30) == 0 || (i2 & 192) != 128;
    }

    private static boolean isMalformed3(int i, int i2, int i3) {
        return ((i != -32 || (i2 & 224) != 128) && (i2 & 192) == 128 && (i3 & 192) == 128) ? false : true;
    }

    private static boolean isMalformed4(int i, int i2, int i3) {
        return ((i & 192) == 128 && (i2 & 192) == 128 && (i3 & 192) == 128) ? false : true;
    }

    private static boolean isNotContinuation(int i) {
        return (i & 192) != 128;
    }

    private static CoderResult lookupN(ByteBuffer byteBuffer, int i) {
        for (int i2 = 1; i2 < i; i2++) {
            if (isNotContinuation(byteBuffer.get())) {
                return CoderResult.malformedForLength(i2);
            }
        }
        return CoderResult.malformedForLength(i);
    }

    private static CoderResult malformed(ByteBuffer byteBuffer, int i, CharBuffer charBuffer, int i2, int i3) {
        byteBuffer.position(i - byteBuffer.arrayOffset());
        CoderResult malformedN = malformedN(byteBuffer, i3);
        byteBuffer.position(i);
        charBuffer.position(i2);
        return malformedN;
    }

    public static CoderResult malformedN(ByteBuffer byteBuffer, int i) {
        int i2 = 1;
        if (i == 1) {
            byte b = byteBuffer.get();
            if ((b >> 2) == -2) {
                if (byteBuffer.remaining() < 4) {
                    return CoderResult.UNDERFLOW;
                }
                return lookupN(byteBuffer, 5);
            } else if ((b >> 1) != -2) {
                return CoderResult.malformedForLength(1);
            } else {
                if (byteBuffer.remaining() < 5) {
                    return CoderResult.UNDERFLOW;
                }
                return lookupN(byteBuffer, 6);
            }
        } else if (i == 2) {
            return CoderResult.malformedForLength(1);
        } else {
            if (i == 3) {
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                if (!(b2 == -32 && (b3 & 224) == 128) && !isNotContinuation(b3)) {
                    i2 = 2;
                }
                return CoderResult.malformedForLength(i2);
            } else if (i == 4) {
                byte b4 = byteBuffer.get() & 255;
                byte b5 = byteBuffer.get();
                byte b6 = b5 & 255;
                if (b4 > 244 || ((b4 == 240 && (b6 < 144 || b6 > 191)) || ((b4 == 244 && (b5 & 240) != 128) || isNotContinuation(b6)))) {
                    return CoderResult.malformedForLength(1);
                }
                if (isNotContinuation(byteBuffer.get())) {
                    return CoderResult.malformedForLength(2);
                }
                return CoderResult.malformedForLength(3);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    private static CoderResult xflow(Buffer buffer, int i, int i2, Buffer buffer2, int i3, int i4) {
        buffer.position(i);
        buffer2.position(i3);
        if (i4 == 0 || i2 - i < i4) {
            return CoderResult.UNDERFLOW;
        }
        return CoderResult.OVERFLOW;
    }

    public CoderResult decodeLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        return decodeArrayLoop(byteBuffer, charBuffer);
    }
}
