package com.alibaba.fastjson.util;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

/* loaded from: classes.dex */
public class UTF8Decoder extends CharsetDecoder {
    private static final Charset charset = Charset.forName("UTF-8");

    public UTF8Decoder() {
        super(charset, 1.0f, 1.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x012c, code lost:
    
        return xflow(r13, r5, r6, r14, r8, 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00c7, code lost:
    
        return xflow(r13, r5, r6, r14, r8, 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0090, code lost:
    
        return xflow(r13, r5, r6, r14, r8, 2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.nio.charset.CoderResult decodeArrayLoop(java.nio.ByteBuffer r13, java.nio.CharBuffer r14) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
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
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        int i3 = byteBuffer.get() & 255;
                        byte b = byteBuffer.get();
                        int i4 = b & 255;
                        if (i3 <= 244 && ((i3 != 240 || (i4 >= 144 && i4 <= 191)) && ((i3 != 244 || (b & 240) == 128) && !isNotContinuation(i4)))) {
                            if (isNotContinuation(byteBuffer.get())) {
                                return CoderResult.malformedForLength(2);
                            }
                            return CoderResult.malformedForLength(3);
                        }
                        return CoderResult.malformedForLength(1);
                    }
                    throw new IllegalStateException();
                }
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                if ((b2 != -32 || (b3 & 224) != 128) && !isNotContinuation(b3)) {
                    i2 = 2;
                }
                return CoderResult.malformedForLength(i2);
            }
            return CoderResult.malformedForLength(1);
        }
        byte b4 = byteBuffer.get();
        if ((b4 >> 2) == -2) {
            if (byteBuffer.remaining() < 4) {
                return CoderResult.UNDERFLOW;
            }
            return lookupN(byteBuffer, 5);
        }
        if ((b4 >> 1) == -2) {
            if (byteBuffer.remaining() < 5) {
                return CoderResult.UNDERFLOW;
            }
            return lookupN(byteBuffer, 6);
        }
        return CoderResult.malformedForLength(1);
    }

    private static CoderResult xflow(Buffer buffer, int i, int i2, Buffer buffer2, int i3, int i4) {
        buffer.position(i);
        buffer2.position(i3);
        if (i4 != 0 && i2 - i >= i4) {
            return CoderResult.OVERFLOW;
        }
        return CoderResult.UNDERFLOW;
    }

    @Override // java.nio.charset.CharsetDecoder
    public CoderResult decodeLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        return decodeArrayLoop(byteBuffer, charBuffer);
    }
}
