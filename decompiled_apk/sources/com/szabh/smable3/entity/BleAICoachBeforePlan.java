package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleAICoachBeforePlan extends BleReadable {
    public static final int CHECKSUM_LENGTH = 128;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private String mCurrentChecksum;
    private int mCurrentChecksumLength;
    private int mDayMET;

    @OOXIXo
    private float[] mExerciseMET;
    private int mIsFirst;

    @OOXIXo
    private String mLastChecksum;
    private int mLastChecksumLength;

    @OOXIXo
    private float[] mRoutineMET;

    @OOXIXo
    private float[] mWeekExerciseMET;

    @OOXIXo
    private float[] mWeekRoutineMET;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleAICoachBeforePlan() {
        this(null, 0, null, 0, null, null, 0, 0, null, null, 1023, null);
    }

    @OOXIXo
    public final String component1() {
        return this.mCurrentChecksum;
    }

    @OOXIXo
    public final float[] component10() {
        return this.mWeekExerciseMET;
    }

    public final int component2() {
        return this.mCurrentChecksumLength;
    }

    @OOXIXo
    public final String component3() {
        return this.mLastChecksum;
    }

    public final int component4() {
        return this.mLastChecksumLength;
    }

    @OOXIXo
    public final float[] component5() {
        return this.mRoutineMET;
    }

    @OOXIXo
    public final float[] component6() {
        return this.mExerciseMET;
    }

    public final int component7() {
        return this.mDayMET;
    }

    public final int component8() {
        return this.mIsFirst;
    }

    @OOXIXo
    public final float[] component9() {
        return this.mWeekRoutineMET;
    }

    @OOXIXo
    public final BleAICoachBeforePlan copy(@OOXIXo String mCurrentChecksum, int i, @OOXIXo String mLastChecksum, int i2, @OOXIXo float[] mRoutineMET, @OOXIXo float[] mExerciseMET, int i3, int i4, @OOXIXo float[] mWeekRoutineMET, @OOXIXo float[] mWeekExerciseMET) {
        IIX0o.x0xO0oo(mCurrentChecksum, "mCurrentChecksum");
        IIX0o.x0xO0oo(mLastChecksum, "mLastChecksum");
        IIX0o.x0xO0oo(mRoutineMET, "mRoutineMET");
        IIX0o.x0xO0oo(mExerciseMET, "mExerciseMET");
        IIX0o.x0xO0oo(mWeekRoutineMET, "mWeekRoutineMET");
        IIX0o.x0xO0oo(mWeekExerciseMET, "mWeekExerciseMET");
        return new BleAICoachBeforePlan(mCurrentChecksum, i, mLastChecksum, i2, mRoutineMET, mExerciseMET, i3, i4, mWeekRoutineMET, mWeekExerciseMET);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mCurrentChecksum = BleReadable.readString$default(this, 128, null, 2, null);
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mCurrentChecksumLength = readInt32(LITTLE_ENDIAN);
        this.mLastChecksum = BleReadable.readString$default(this, 128, null, 2, null);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mLastChecksumLength = readInt32(LITTLE_ENDIAN);
        int length = this.mRoutineMET.length;
        for (int i = 0; i < length; i++) {
            float[] fArr = this.mRoutineMET;
            ByteOrder LITTLE_ENDIAN2 = ByteOrder.LITTLE_ENDIAN;
            IIX0o.oO(LITTLE_ENDIAN2, "LITTLE_ENDIAN");
            fArr[i] = readFloat(LITTLE_ENDIAN2);
        }
        int length2 = this.mExerciseMET.length;
        for (int i2 = 0; i2 < length2; i2++) {
            float[] fArr2 = this.mExerciseMET;
            ByteOrder LITTLE_ENDIAN3 = ByteOrder.LITTLE_ENDIAN;
            IIX0o.oO(LITTLE_ENDIAN3, "LITTLE_ENDIAN");
            fArr2[i2] = readFloat(LITTLE_ENDIAN3);
        }
        ByteOrder LITTLE_ENDIAN4 = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN4, "LITTLE_ENDIAN");
        this.mDayMET = readInt32(LITTLE_ENDIAN4);
        IIX0o.oO(LITTLE_ENDIAN4, "LITTLE_ENDIAN");
        this.mIsFirst = readInt32(LITTLE_ENDIAN4);
        int length3 = this.mWeekRoutineMET.length;
        for (int i3 = 0; i3 < length3; i3++) {
            float[] fArr3 = this.mWeekRoutineMET;
            ByteOrder LITTLE_ENDIAN5 = ByteOrder.LITTLE_ENDIAN;
            IIX0o.oO(LITTLE_ENDIAN5, "LITTLE_ENDIAN");
            fArr3[i3] = readFloat(LITTLE_ENDIAN5);
        }
        int length4 = this.mWeekExerciseMET.length;
        for (int i4 = 0; i4 < length4; i4++) {
            float[] fArr4 = this.mWeekExerciseMET;
            ByteOrder LITTLE_ENDIAN6 = ByteOrder.LITTLE_ENDIAN;
            IIX0o.oO(LITTLE_ENDIAN6, "LITTLE_ENDIAN");
            fArr4[i4] = readFloat(LITTLE_ENDIAN6);
        }
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleAICoachBeforePlan)) {
            return false;
        }
        BleAICoachBeforePlan bleAICoachBeforePlan = (BleAICoachBeforePlan) obj;
        return IIX0o.Oxx0IOOO(this.mCurrentChecksum, bleAICoachBeforePlan.mCurrentChecksum) && this.mCurrentChecksumLength == bleAICoachBeforePlan.mCurrentChecksumLength && IIX0o.Oxx0IOOO(this.mLastChecksum, bleAICoachBeforePlan.mLastChecksum) && this.mLastChecksumLength == bleAICoachBeforePlan.mLastChecksumLength && IIX0o.Oxx0IOOO(this.mRoutineMET, bleAICoachBeforePlan.mRoutineMET) && IIX0o.Oxx0IOOO(this.mExerciseMET, bleAICoachBeforePlan.mExerciseMET) && this.mDayMET == bleAICoachBeforePlan.mDayMET && this.mIsFirst == bleAICoachBeforePlan.mIsFirst && IIX0o.Oxx0IOOO(this.mWeekRoutineMET, bleAICoachBeforePlan.mWeekRoutineMET) && IIX0o.Oxx0IOOO(this.mWeekExerciseMET, bleAICoachBeforePlan.mWeekExerciseMET);
    }

    @OOXIXo
    public final String getMCurrentChecksum() {
        return this.mCurrentChecksum;
    }

    public final int getMCurrentChecksumLength() {
        return this.mCurrentChecksumLength;
    }

    public final int getMDayMET() {
        return this.mDayMET;
    }

    @OOXIXo
    public final float[] getMExerciseMET() {
        return this.mExerciseMET;
    }

    public final int getMIsFirst() {
        return this.mIsFirst;
    }

    @OOXIXo
    public final String getMLastChecksum() {
        return this.mLastChecksum;
    }

    public final int getMLastChecksumLength() {
        return this.mLastChecksumLength;
    }

    @OOXIXo
    public final float[] getMRoutineMET() {
        return this.mRoutineMET;
    }

    @OOXIXo
    public final float[] getMWeekExerciseMET() {
        return this.mWeekExerciseMET;
    }

    @OOXIXo
    public final float[] getMWeekRoutineMET() {
        return this.mWeekRoutineMET;
    }

    public int hashCode() {
        return (((((((((((((((((this.mCurrentChecksum.hashCode() * 31) + this.mCurrentChecksumLength) * 31) + this.mLastChecksum.hashCode()) * 31) + this.mLastChecksumLength) * 31) + Arrays.hashCode(this.mRoutineMET)) * 31) + Arrays.hashCode(this.mExerciseMET)) * 31) + this.mDayMET) * 31) + this.mIsFirst) * 31) + Arrays.hashCode(this.mWeekRoutineMET)) * 31) + Arrays.hashCode(this.mWeekExerciseMET);
    }

    public final void setMCurrentChecksum(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mCurrentChecksum = str;
    }

    public final void setMCurrentChecksumLength(int i) {
        this.mCurrentChecksumLength = i;
    }

    public final void setMDayMET(int i) {
        this.mDayMET = i;
    }

    public final void setMExerciseMET(@OOXIXo float[] fArr) {
        IIX0o.x0xO0oo(fArr, "<set-?>");
        this.mExerciseMET = fArr;
    }

    public final void setMIsFirst(int i) {
        this.mIsFirst = i;
    }

    public final void setMLastChecksum(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mLastChecksum = str;
    }

    public final void setMLastChecksumLength(int i) {
        this.mLastChecksumLength = i;
    }

    public final void setMRoutineMET(@OOXIXo float[] fArr) {
        IIX0o.x0xO0oo(fArr, "<set-?>");
        this.mRoutineMET = fArr;
    }

    public final void setMWeekExerciseMET(@OOXIXo float[] fArr) {
        IIX0o.x0xO0oo(fArr, "<set-?>");
        this.mWeekExerciseMET = fArr;
    }

    public final void setMWeekRoutineMET(@OOXIXo float[] fArr) {
        IIX0o.x0xO0oo(fArr, "<set-?>");
        this.mWeekRoutineMET = fArr;
    }

    @OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BleAICoachPlan(mCurrentChecksum=");
        sb.append(this.mCurrentChecksum);
        sb.append(", mCurrentChecksumLength=");
        sb.append(this.mCurrentChecksumLength);
        sb.append(", mLastChecksum=");
        sb.append(this.mLastChecksum);
        sb.append(", mLastChecksumLength=");
        sb.append(this.mLastChecksumLength);
        sb.append(", mRoutineMET=");
        String arrays = Arrays.toString(this.mRoutineMET);
        IIX0o.oO(arrays, "toString(...)");
        sb.append(arrays);
        sb.append(", mExerciseMET=");
        String arrays2 = Arrays.toString(this.mExerciseMET);
        IIX0o.oO(arrays2, "toString(...)");
        sb.append(arrays2);
        sb.append(", mDayMET=");
        sb.append(this.mDayMET);
        sb.append(", mIsFirst=");
        sb.append(this.mIsFirst);
        sb.append(", mWeekRoutineMET=");
        String arrays3 = Arrays.toString(this.mWeekRoutineMET);
        IIX0o.oO(arrays3, "toString(...)");
        sb.append(arrays3);
        sb.append(", mWeekExerciseMET=");
        String arrays4 = Arrays.toString(this.mWeekExerciseMET);
        IIX0o.oO(arrays4, "toString(...)");
        sb.append(arrays4);
        sb.append(HexStringBuilder.COMMENT_END_CHAR);
        return sb.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ BleAICoachBeforePlan(java.lang.String r18, int r19, java.lang.String r20, int r21, float[] r22, float[] r23, int r24, int r25, float[] r26, float[] r27, int r28, kotlin.jvm.internal.IIXOooo r29) {
        /*
            r17 = this;
            r0 = r28
            r1 = r0 & 1
            java.lang.String r2 = "-999"
            if (r1 == 0) goto La
            r1 = r2
            goto Lc
        La:
            r1 = r18
        Lc:
            r3 = r0 & 2
            r4 = 0
            if (r3 == 0) goto L13
            r3 = 0
            goto L15
        L13:
            r3 = r19
        L15:
            r5 = r0 & 4
            if (r5 == 0) goto L1a
            goto L1c
        L1a:
            r2 = r20
        L1c:
            r5 = r0 & 8
            if (r5 == 0) goto L22
            r5 = 0
            goto L24
        L22:
            r5 = r21
        L24:
            r6 = r0 & 16
            r7 = 5
            r8 = 3
            r9 = 4
            r10 = 2
            r11 = 0
            r12 = 1
            if (r6 == 0) goto L3b
            float[] r6 = new float[r7]
            r6[r4] = r11
            r6[r12] = r11
            r6[r10] = r11
            r6[r8] = r11
            r6[r9] = r11
            goto L3d
        L3b:
            r6 = r22
        L3d:
            r13 = r0 & 32
            if (r13 == 0) goto L4e
            float[] r13 = new float[r7]
            r13[r4] = r11
            r13[r12] = r11
            r13[r10] = r11
            r13[r8] = r11
            r13[r9] = r11
            goto L50
        L4e:
            r13 = r23
        L50:
            r14 = r0 & 64
            if (r14 == 0) goto L56
            r14 = 3
            goto L58
        L56:
            r14 = r24
        L58:
            r15 = r0 & 128(0x80, float:1.8E-43)
            if (r15 == 0) goto L5e
            r15 = 0
            goto L60
        L5e:
            r15 = r25
        L60:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L73
            float[] r9 = new float[r7]
            r9[r4] = r11
            r9[r12] = r11
            r9[r10] = r11
            r9[r8] = r11
            r16 = 4
            r9[r16] = r11
            goto L77
        L73:
            r16 = 4
            r9 = r26
        L77:
            r0 = r0 & 512(0x200, float:7.17E-43)
            if (r0 == 0) goto L88
            float[] r0 = new float[r7]
            r0[r4] = r11
            r0[r12] = r11
            r0[r10] = r11
            r0[r8] = r11
            r0[r16] = r11
            goto L8a
        L88:
            r0 = r27
        L8a:
            r18 = r17
            r19 = r1
            r20 = r3
            r21 = r2
            r22 = r5
            r23 = r6
            r24 = r13
            r25 = r14
            r26 = r15
            r27 = r9
            r28 = r0
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szabh.smable3.entity.BleAICoachBeforePlan.<init>(java.lang.String, int, java.lang.String, int, float[], float[], int, int, float[], float[], int, kotlin.jvm.internal.IIXOooo):void");
    }

    public BleAICoachBeforePlan(@OOXIXo String mCurrentChecksum, int i, @OOXIXo String mLastChecksum, int i2, @OOXIXo float[] mRoutineMET, @OOXIXo float[] mExerciseMET, int i3, int i4, @OOXIXo float[] mWeekRoutineMET, @OOXIXo float[] mWeekExerciseMET) {
        IIX0o.x0xO0oo(mCurrentChecksum, "mCurrentChecksum");
        IIX0o.x0xO0oo(mLastChecksum, "mLastChecksum");
        IIX0o.x0xO0oo(mRoutineMET, "mRoutineMET");
        IIX0o.x0xO0oo(mExerciseMET, "mExerciseMET");
        IIX0o.x0xO0oo(mWeekRoutineMET, "mWeekRoutineMET");
        IIX0o.x0xO0oo(mWeekExerciseMET, "mWeekExerciseMET");
        this.mCurrentChecksum = mCurrentChecksum;
        this.mCurrentChecksumLength = i;
        this.mLastChecksum = mLastChecksum;
        this.mLastChecksumLength = i2;
        this.mRoutineMET = mRoutineMET;
        this.mExerciseMET = mExerciseMET;
        this.mDayMET = i3;
        this.mIsFirst = i4;
        this.mWeekRoutineMET = mWeekRoutineMET;
        this.mWeekExerciseMET = mWeekExerciseMET;
    }
}
