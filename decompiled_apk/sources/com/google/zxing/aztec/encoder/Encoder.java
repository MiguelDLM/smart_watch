package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;

/* loaded from: classes10.dex */
public final class Encoder {
    public static final int DEFAULT_AZTEC_LAYERS = 0;
    public static final int DEFAULT_EC_PERCENT = 33;
    private static final int MAX_NB_BITS = 32;
    private static final int MAX_NB_BITS_COMPACT = 4;
    private static final int[] WORD_SIZE = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private Encoder() {
    }

    private static int[] bitsToWords(BitArray bitArray, int i, int i2) {
        int i3;
        int[] iArr = new int[i2];
        int size = bitArray.getSize() / i;
        for (int i4 = 0; i4 < size; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < i; i6++) {
                if (bitArray.get((i4 * i) + i6)) {
                    i3 = 1 << ((i - i6) - 1);
                } else {
                    i3 = 0;
                }
                i5 |= i3;
            }
            iArr[i4] = i5;
        }
        return iArr;
    }

    private static void drawBullsEye(BitMatrix bitMatrix, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 <= i6) {
                    bitMatrix.set(i5, i4);
                    bitMatrix.set(i5, i6);
                    bitMatrix.set(i4, i5);
                    bitMatrix.set(i6, i5);
                    i5++;
                }
            }
        }
        int i7 = i - i2;
        bitMatrix.set(i7, i7);
        int i8 = i7 + 1;
        bitMatrix.set(i8, i7);
        bitMatrix.set(i7, i8);
        int i9 = i + i2;
        bitMatrix.set(i9, i7);
        bitMatrix.set(i9, i8);
        bitMatrix.set(i9, i9 - 1);
    }

    private static void drawModeMessage(BitMatrix bitMatrix, boolean z, int i, BitArray bitArray) {
        int i2 = i / 2;
        int i3 = 0;
        if (z) {
            while (i3 < 7) {
                int i4 = (i2 - 3) + i3;
                if (bitArray.get(i3)) {
                    bitMatrix.set(i4, i2 - 5);
                }
                if (bitArray.get(i3 + 7)) {
                    bitMatrix.set(i2 + 5, i4);
                }
                if (bitArray.get(20 - i3)) {
                    bitMatrix.set(i4, i2 + 5);
                }
                if (bitArray.get(27 - i3)) {
                    bitMatrix.set(i2 - 5, i4);
                }
                i3++;
            }
            return;
        }
        while (i3 < 10) {
            int i5 = (i2 - 5) + i3 + (i3 / 5);
            if (bitArray.get(i3)) {
                bitMatrix.set(i5, i2 - 7);
            }
            if (bitArray.get(i3 + 10)) {
                bitMatrix.set(i2 + 7, i5);
            }
            if (bitArray.get(29 - i3)) {
                bitMatrix.set(i5, i2 + 7);
            }
            if (bitArray.get(39 - i3)) {
                bitMatrix.set(i2 - 7, i5);
            }
            i3++;
        }
    }

    public static AztecCode encode(byte[] bArr) {
        return encode(bArr, 33, 0);
    }

    private static BitArray generateCheckWords(BitArray bitArray, int i, int i2) {
        int size = bitArray.getSize() / i2;
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(getGF(i2));
        int i3 = i / i2;
        int[] bitsToWords = bitsToWords(bitArray, i2, i3);
        reedSolomonEncoder.encode(bitsToWords, i3 - size);
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(0, i % i2);
        for (int i4 : bitsToWords) {
            bitArray2.appendBits(i4, i2);
        }
        return bitArray2;
    }

    public static BitArray generateModeMessage(boolean z, int i, int i2) {
        BitArray bitArray = new BitArray();
        if (z) {
            bitArray.appendBits(i - 1, 2);
            bitArray.appendBits(i2 - 1, 6);
            return generateCheckWords(bitArray, 28, 4);
        }
        bitArray.appendBits(i - 1, 5);
        bitArray.appendBits(i2 - 1, 11);
        return generateCheckWords(bitArray, 40, 4);
    }

    private static GenericGF getGF(int i) {
        if (i != 4) {
            if (i != 6) {
                if (i != 8) {
                    if (i != 10) {
                        if (i == 12) {
                            return GenericGF.AZTEC_DATA_12;
                        }
                        throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i)));
                    }
                    return GenericGF.AZTEC_DATA_10;
                }
                return GenericGF.AZTEC_DATA_8;
            }
            return GenericGF.AZTEC_DATA_6;
        }
        return GenericGF.AZTEC_PARAM;
    }

    public static BitArray stuffBits(BitArray bitArray, int i) {
        BitArray bitArray2 = new BitArray();
        int size = bitArray.getSize();
        int i2 = (1 << i) - 2;
        int i3 = 0;
        while (i3 < size) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i3 + i5;
                if (i6 >= size || bitArray.get(i6)) {
                    i4 |= 1 << ((i - 1) - i5);
                }
            }
            int i7 = i4 & i2;
            if (i7 == i2) {
                bitArray2.appendBits(i7, i);
            } else if (i7 == 0) {
                bitArray2.appendBits(i4 | 1, i);
            } else {
                bitArray2.appendBits(i4, i);
                i3 += i;
            }
            i3--;
            i3 += i;
        }
        return bitArray2;
    }

    private static int totalBitsInLayer(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }

    public static AztecCode encode(byte[] bArr, int i, int i2) {
        int i3;
        BitArray bitArray;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        BitArray encode = new HighLevelEncoder(bArr).encode();
        int size = ((encode.getSize() * i) / 100) + 11;
        int size2 = encode.getSize() + size;
        int i11 = 0;
        int i12 = 1;
        if (i2 != 0) {
            z = i2 < 0;
            i5 = Math.abs(i2);
            if (i5 <= (z ? 4 : 32)) {
                i6 = totalBitsInLayer(i5, z);
                i4 = WORD_SIZE[i5];
                int i13 = i6 - (i6 % i4);
                bitArray = stuffBits(encode, i4);
                if (bitArray.getSize() + size <= i13) {
                    if (z && bitArray.getSize() > (i4 << 6)) {
                        throw new IllegalArgumentException("Data to large for user specified layer");
                    }
                } else {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                }
            } else {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i2)));
            }
        } else {
            BitArray bitArray2 = null;
            int i14 = 0;
            int i15 = 0;
            while (i14 <= r6) {
                boolean z2 = i14 <= 3;
                int i16 = z2 ? i14 + 1 : i14;
                int i17 = totalBitsInLayer(i16, z2);
                if (size2 <= i17) {
                    if (bitArray2 == null || i15 != WORD_SIZE[i16]) {
                        int i18 = WORD_SIZE[i16];
                        i15 = i18;
                        bitArray2 = stuffBits(encode, i18);
                    }
                    int i19 = i17 - (i17 % i15);
                    if ((!z2 || bitArray2.getSize() <= (i15 << 6)) && bitArray2.getSize() + size <= i19) {
                        bitArray = bitArray2;
                        i4 = i15;
                        z = z2;
                        i5 = i16;
                        i6 = i17;
                    } else {
                        i3 = 1;
                    }
                } else {
                    i3 = 1;
                }
                i14 += i3;
                i10 = 2;
                r6 = 32;
                i11 = 0;
                i12 = 1;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        BitArray generateCheckWords = generateCheckWords(bitArray, i6, i4);
        int size3 = bitArray.getSize() / i4;
        BitArray generateModeMessage = generateModeMessage(z, i5, size3);
        int i20 = (z ? 11 : 14) + (i5 << 2);
        int[] iArr = new int[i20];
        if (z) {
            for (int i21 = 0; i21 < i20; i21 += i12) {
                iArr[i21] = i21;
            }
            i7 = i20;
        } else {
            int i22 = i20 / 2;
            i7 = i20 + 1 + (((i22 - 1) / 15) * 2);
            int i23 = i7 / 2;
            for (int i24 = 0; i24 < i22; i24 += i12) {
                iArr[(i22 - i24) - 1] = (i23 - r15) - 1;
                iArr[i22 + i24] = (i24 / 15) + i24 + i23 + i12;
            }
        }
        BitMatrix bitMatrix = new BitMatrix(i7);
        int i25 = 0;
        int i26 = 0;
        while (i25 < i5) {
            int i27 = ((i5 - i25) << i10) + (z ? 9 : 12);
            while (i11 < i27) {
                int i28 = i11 << 1;
                int i29 = 0;
                while (i29 < i10) {
                    if (generateCheckWords.get(i26 + i28 + i29)) {
                        int i30 = i25 << 1;
                        bitMatrix.set(iArr[i30 + i29], iArr[i30 + i11]);
                    }
                    if (generateCheckWords.get((i27 << 1) + i26 + i28 + i29)) {
                        int i31 = i25 << 1;
                        i8 = size3;
                        bitMatrix.set(iArr[i31 + i11], iArr[((i20 - 1) - i31) - i29]);
                    } else {
                        i8 = size3;
                    }
                    if (generateCheckWords.get((i27 << 2) + i26 + i28 + i29)) {
                        int i32 = (i20 - 1) - (i25 << 1);
                        bitMatrix.set(iArr[i32 - i29], iArr[i32 - i11]);
                    }
                    if (generateCheckWords.get((i27 * 6) + i26 + i28 + i29)) {
                        i9 = 1;
                        int i33 = i25 << 1;
                        bitMatrix.set(iArr[((i20 - 1) - i33) - i11], iArr[i33 + i29]);
                    } else {
                        i9 = 1;
                    }
                    i29 += i9;
                    size3 = i8;
                    i10 = 2;
                }
                i11++;
                i10 = 2;
            }
            i26 += i27 << 3;
            i25++;
            size3 = size3;
            i10 = 2;
            i11 = 0;
        }
        int i34 = size3;
        drawModeMessage(bitMatrix, z, i7, generateModeMessage);
        if (z) {
            drawBullsEye(bitMatrix, i7 / 2, 5);
        } else {
            int i35 = i7 / 2;
            drawBullsEye(bitMatrix, i35, 7);
            int i36 = 0;
            int i37 = 0;
            while (i36 < (i20 / 2) - 1) {
                for (int i38 = i35 & 1; i38 < i7; i38 += 2) {
                    int i39 = i35 - i37;
                    bitMatrix.set(i39, i38);
                    int i40 = i35 + i37;
                    bitMatrix.set(i40, i38);
                    bitMatrix.set(i38, i39);
                    bitMatrix.set(i38, i40);
                }
                i36 += 15;
                i37 += 16;
            }
        }
        AztecCode aztecCode = new AztecCode();
        aztecCode.setCompact(z);
        aztecCode.setSize(i7);
        aztecCode.setLayers(i5);
        aztecCode.setCodeWords(i34);
        aztecCode.setMatrix(bitMatrix);
        return aztecCode;
    }
}
