package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleCoachingSegment extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 21;
    private static final int LENGTH_NAME = 15;
    private int mActivity;
    private int mCompletionCondition;
    private int mCompletionValue;
    private int mHrZone;

    @OOXIXo
    private String mName;
    private int mStage;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleCoachingSegment() {
        this(0, null, 0, 0, 0, 0, 63, null);
    }

    public static /* synthetic */ BleCoachingSegment copy$default(BleCoachingSegment bleCoachingSegment, int i, String str, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = bleCoachingSegment.mCompletionCondition;
        }
        if ((i6 & 2) != 0) {
            str = bleCoachingSegment.mName;
        }
        String str2 = str;
        if ((i6 & 4) != 0) {
            i2 = bleCoachingSegment.mActivity;
        }
        int i7 = i2;
        if ((i6 & 8) != 0) {
            i3 = bleCoachingSegment.mStage;
        }
        int i8 = i3;
        if ((i6 & 16) != 0) {
            i4 = bleCoachingSegment.mCompletionValue;
        }
        int i9 = i4;
        if ((i6 & 32) != 0) {
            i5 = bleCoachingSegment.mHrZone;
        }
        return bleCoachingSegment.copy(i, str2, i7, i8, i9, i5);
    }

    public final int component1() {
        return this.mCompletionCondition;
    }

    @OOXIXo
    public final String component2() {
        return this.mName;
    }

    public final int component3() {
        return this.mActivity;
    }

    public final int component4() {
        return this.mStage;
    }

    public final int component5() {
        return this.mCompletionValue;
    }

    public final int component6() {
        return this.mHrZone;
    }

    @OOXIXo
    public final BleCoachingSegment copy(int i, @OOXIXo String mName, int i2, int i3, int i4, int i5) {
        IIX0o.x0xO0oo(mName, "mName");
        return new BleCoachingSegment(i, mName, i2, i3, i4, i5);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mStage = readInt8();
        this.mName = BleReadable.readString$default(this, 15, null, 2, null);
        this.mActivity = readInt8();
        this.mCompletionCondition = readInt8();
        this.mCompletionValue = BleReadable.readInt16$default(this, null, 1, null);
        this.mHrZone = readInt8();
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mStage);
        BleWritable.writeStringWithFix$default(this, this.mName, 15, null, 4, null);
        writeInt8(this.mActivity);
        writeInt8(this.mCompletionCondition);
        BleWritable.writeInt16$default(this, this.mCompletionValue, null, 2, null);
        writeInt8(this.mHrZone);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleCoachingSegment)) {
            return false;
        }
        BleCoachingSegment bleCoachingSegment = (BleCoachingSegment) obj;
        return this.mCompletionCondition == bleCoachingSegment.mCompletionCondition && IIX0o.Oxx0IOOO(this.mName, bleCoachingSegment.mName) && this.mActivity == bleCoachingSegment.mActivity && this.mStage == bleCoachingSegment.mStage && this.mCompletionValue == bleCoachingSegment.mCompletionValue && this.mHrZone == bleCoachingSegment.mHrZone;
    }

    public final int getMActivity() {
        return this.mActivity;
    }

    public final int getMCompletionCondition() {
        return this.mCompletionCondition;
    }

    public final int getMCompletionValue() {
        return this.mCompletionValue;
    }

    public final int getMHrZone() {
        return this.mHrZone;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 21;
    }

    @OOXIXo
    public final String getMName() {
        return this.mName;
    }

    public final int getMStage() {
        return this.mStage;
    }

    public int hashCode() {
        return (((((((((this.mCompletionCondition * 31) + this.mName.hashCode()) * 31) + this.mActivity) * 31) + this.mStage) * 31) + this.mCompletionValue) * 31) + this.mHrZone;
    }

    public final void setMActivity(int i) {
        this.mActivity = i;
    }

    public final void setMCompletionCondition(int i) {
        this.mCompletionCondition = i;
    }

    public final void setMCompletionValue(int i) {
        this.mCompletionValue = i;
    }

    public final void setMHrZone(int i) {
        this.mHrZone = i;
    }

    public final void setMName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mName = str;
    }

    public final void setMStage(int i) {
        this.mStage = i;
    }

    @OOXIXo
    public String toString() {
        return "BleCoachingSegment(mCompletionCondition=" + this.mCompletionCondition + ", mName='" + this.mName + "', mActivity=" + this.mActivity + ", mStage=" + this.mStage + ", mCompletionValue=" + this.mCompletionValue + ", mHrZone=" + this.mHrZone + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleCoachingSegment(int i, String str, int i2, int i3, int i4, int i5, int i6, IIXOooo iIXOooo) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? "" : str, (i6 & 4) != 0 ? 0 : i2, (i6 & 8) != 0 ? 0 : i3, (i6 & 16) != 0 ? 0 : i4, (i6 & 32) != 0 ? 0 : i5);
    }

    public BleCoachingSegment(int i, @OOXIXo String mName, int i2, int i3, int i4, int i5) {
        IIX0o.x0xO0oo(mName, "mName");
        this.mCompletionCondition = i;
        this.mName = mName;
        this.mActivity = i2;
        this.mStage = i3;
        this.mCompletionValue = i4;
        this.mHrZone = i5;
    }
}
