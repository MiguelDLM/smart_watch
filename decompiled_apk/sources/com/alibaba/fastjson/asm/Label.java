package com.alibaba.fastjson.asm;

/* loaded from: classes.dex */
public class Label {
    static final int FORWARD_REFERENCE_HANDLE_MASK = 268435455;
    static final int FORWARD_REFERENCE_TYPE_MASK = -268435456;
    static final int FORWARD_REFERENCE_TYPE_SHORT = 268435456;
    static final int FORWARD_REFERENCE_TYPE_WIDE = 536870912;
    int inputStackTop;
    Label next;
    int outputStackMax;
    int position;
    private int referenceCount;
    private int[] srcAndRefPositions;
    int status;
    Label successor;

    private void addReference(int i, int i2, int i3) {
        if (this.srcAndRefPositions == null) {
            this.srcAndRefPositions = new int[6];
        }
        int i4 = this.referenceCount;
        int[] iArr = this.srcAndRefPositions;
        if (i4 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 6];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.srcAndRefPositions = iArr2;
        }
        int[] iArr3 = this.srcAndRefPositions;
        int i5 = this.referenceCount;
        int i6 = i5 + 1;
        this.referenceCount = i6;
        iArr3[i5] = i;
        this.referenceCount = i5 + 2;
        iArr3[i6] = i2 | i3;
    }

    public void put(MethodWriter methodWriter, ByteVector byteVector, int i, boolean z) {
        if ((this.status & 2) == 0) {
            if (z) {
                addReference(i, byteVector.length, 536870912);
                byteVector.putInt(-1);
                return;
            } else {
                addReference(i, byteVector.length, 268435456);
                byteVector.putShort(-1);
                return;
            }
        }
        if (z) {
            byteVector.putInt(this.position - i);
        } else {
            byteVector.putShort(this.position - i);
        }
    }

    public void resolve(MethodWriter methodWriter, int i, byte[] bArr) {
        this.status |= 2;
        this.position = i;
        int i2 = 0;
        while (i2 < this.referenceCount) {
            int[] iArr = this.srcAndRefPositions;
            int i3 = i2 + 1;
            int i4 = iArr[i2];
            i2 += 2;
            int i5 = iArr[i3];
            int i6 = FORWARD_REFERENCE_HANDLE_MASK & i5;
            int i7 = i - i4;
            if ((i5 & FORWARD_REFERENCE_TYPE_MASK) == 268435456) {
                bArr[i6] = (byte) (i7 >>> 8);
                bArr[i6 + 1] = (byte) i7;
            } else {
                bArr[i6] = (byte) (i7 >>> 24);
                bArr[i6 + 1] = (byte) (i7 >>> 16);
                bArr[i6 + 2] = (byte) (i7 >>> 8);
                bArr[i6 + 3] = (byte) i7;
            }
        }
    }
}
