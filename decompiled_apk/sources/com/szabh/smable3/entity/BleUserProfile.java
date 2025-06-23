package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleUserProfile extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int FEMALE = 0;
    public static final int IMPERIAL = 1;
    public static final int ITEM_LENGTH = 11;
    public static final int MALE = 1;
    public static final int METRIC = 0;
    public static final int SECRECY = 0;
    public static final int UNKNOWN = 2;
    private int mAge;
    private int mGender;
    private float mHeight;
    private int mUnit;
    private float mWeight;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @kotlin.OOXIXo(message = "主要是针对没定义保密性别的设备，早期的传音项目才用到，客户自己开发app")
        public static /* synthetic */ void getSECRECY$annotations() {
        }

        private Companion() {
        }
    }

    public BleUserProfile() {
        this(0, 0, 0, 0.0f, 0.0f, 31, null);
    }

    public static /* synthetic */ BleUserProfile copy$default(BleUserProfile bleUserProfile, int i, int i2, int i3, float f, float f2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = bleUserProfile.mUnit;
        }
        if ((i4 & 2) != 0) {
            i2 = bleUserProfile.mGender;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = bleUserProfile.mAge;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            f = bleUserProfile.mHeight;
        }
        float f3 = f;
        if ((i4 & 16) != 0) {
            f2 = bleUserProfile.mWeight;
        }
        return bleUserProfile.copy(i, i5, i6, f3, f2);
    }

    public final int component1() {
        return this.mUnit;
    }

    public final int component2() {
        return this.mGender;
    }

    public final int component3() {
        return this.mAge;
    }

    public final float component4() {
        return this.mHeight;
    }

    public final float component5() {
        return this.mWeight;
    }

    @OOXIXo
    public final BleUserProfile copy(int i, int i2, int i3, float f, float f2) {
        return new BleUserProfile(i, i2, i3, f, f2);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mUnit = readUInt8();
        this.mGender = readUInt8();
        this.mAge = readUInt8();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mHeight = readFloat(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mWeight = readFloat(LITTLE_ENDIAN);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mUnit);
        writeInt8(this.mGender);
        writeInt8(this.mAge);
        float f = this.mHeight;
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeFloat(f, LITTLE_ENDIAN);
        float f2 = this.mWeight;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeFloat(f2, LITTLE_ENDIAN);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleUserProfile)) {
            return false;
        }
        BleUserProfile bleUserProfile = (BleUserProfile) obj;
        return this.mUnit == bleUserProfile.mUnit && this.mGender == bleUserProfile.mGender && this.mAge == bleUserProfile.mAge && Float.compare(this.mHeight, bleUserProfile.mHeight) == 0 && Float.compare(this.mWeight, bleUserProfile.mWeight) == 0;
    }

    public final int getMAge() {
        return this.mAge;
    }

    public final int getMGender() {
        return this.mGender;
    }

    public final float getMHeight() {
        return this.mHeight;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 11;
    }

    public final int getMUnit() {
        return this.mUnit;
    }

    public final float getMWeight() {
        return this.mWeight;
    }

    public int hashCode() {
        return (((((((this.mUnit * 31) + this.mGender) * 31) + this.mAge) * 31) + Float.floatToIntBits(this.mHeight)) * 31) + Float.floatToIntBits(this.mWeight);
    }

    public final void setMAge(int i) {
        this.mAge = i;
    }

    public final void setMGender(int i) {
        this.mGender = i;
    }

    public final void setMHeight(float f) {
        this.mHeight = f;
    }

    public final void setMUnit(int i) {
        this.mUnit = i;
    }

    public final void setMWeight(float f) {
        this.mWeight = f;
    }

    @OOXIXo
    public String toString() {
        return "BleUserProfile(mUnit=" + this.mUnit + ", mGender=" + this.mGender + ", mAge=" + this.mAge + ", mHeight=" + this.mHeight + ", mWeight=" + this.mWeight + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleUserProfile(int i, int i2, int i3, float f, float f2, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) == 0 ? i2 : 0, (i4 & 4) != 0 ? 20 : i3, (i4 & 8) != 0 ? 170.0f : f, (i4 & 16) != 0 ? 60.0f : f2);
    }

    public BleUserProfile(int i, int i2, int i3, float f, float f2) {
        this.mUnit = i;
        this.mGender = i2;
        this.mAge = i3;
        this.mHeight = f;
        this.mWeight = f2;
    }
}
