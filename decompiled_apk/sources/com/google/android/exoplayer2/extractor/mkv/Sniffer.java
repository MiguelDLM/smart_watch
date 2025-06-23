package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* loaded from: classes9.dex */
final class Sniffer {
    private static final int ID_EBML = 440786851;
    private static final int SEARCH_LENGTH = 1024;
    private int peekLength;
    private final ParsableByteArray scratch = new ParsableByteArray(8);

    private long readUint(ExtractorInput extractorInput) throws IOException {
        int i = 0;
        extractorInput.peekFully(this.scratch.getData(), 0, 1);
        int i2 = this.scratch.getData()[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (~i3);
        extractorInput.peekFully(this.scratch.getData(), 1, i4);
        while (i < i4) {
            i++;
            i5 = (this.scratch.getData()[i] & 255) + (i5 << 8);
        }
        this.peekLength += i4 + 1;
        return i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0098, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput r15) throws java.io.IOException {
        /*
            r14 = this;
            long r0 = r15.getLength()
            r2 = -1
            r4 = 1024(0x400, double:5.06E-321)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L12
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 <= 0) goto L11
            goto L12
        L11:
            r4 = r0
        L12:
            int r2 = (int) r4
            com.google.android.exoplayer2.util.ParsableByteArray r3 = r14.scratch
            byte[] r3 = r3.getData()
            r4 = 0
            r5 = 4
            r15.peekFully(r3, r4, r5)
            com.google.android.exoplayer2.util.ParsableByteArray r3 = r14.scratch
            long r7 = r3.readUnsignedInt()
            r14.peekLength = r5
        L26:
            r9 = 440786851(0x1a45dfa3, double:2.1777764E-315)
            r3 = 1
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 == 0) goto L52
            int r5 = r14.peekLength
            int r5 = r5 + r3
            r14.peekLength = r5
            if (r5 != r2) goto L36
            return r4
        L36:
            com.google.android.exoplayer2.util.ParsableByteArray r5 = r14.scratch
            byte[] r5 = r5.getData()
            r15.peekFully(r5, r4, r3)
            r3 = 8
            long r7 = r7 << r3
            r9 = -256(0xffffffffffffff00, double:NaN)
            long r7 = r7 & r9
            com.google.android.exoplayer2.util.ParsableByteArray r3 = r14.scratch
            byte[] r3 = r3.getData()
            r3 = r3[r4]
            r3 = r3 & 255(0xff, float:3.57E-43)
            long r9 = (long) r3
            long r7 = r7 | r9
            goto L26
        L52:
            long r7 = r14.readUint(r15)
            int r2 = r14.peekLength
            long r9 = (long) r2
            r11 = -9223372036854775808
            int r2 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r2 == 0) goto L9f
            if (r6 == 0) goto L68
            long r5 = r9 + r7
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 < 0) goto L68
            goto L9f
        L68:
            int r0 = r14.peekLength
            long r1 = (long) r0
            long r5 = r9 + r7
            int r13 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r13 >= 0) goto L99
            long r0 = r14.readUint(r15)
            int r2 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r2 != 0) goto L7a
            return r4
        L7a:
            long r0 = r14.readUint(r15)
            r5 = 0
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 < 0) goto L98
            r5 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r13 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r13 <= 0) goto L8c
            goto L98
        L8c:
            if (r2 == 0) goto L68
            int r1 = (int) r0
            r15.advancePeekPosition(r1)
            int r0 = r14.peekLength
            int r0 = r0 + r1
            r14.peekLength = r0
            goto L68
        L98:
            return r4
        L99:
            long r0 = (long) r0
            int r15 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r15 != 0) goto L9f
            r4 = 1
        L9f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mkv.Sniffer.sniff(com.google.android.exoplayer2.extractor.ExtractorInput):boolean");
    }
}
