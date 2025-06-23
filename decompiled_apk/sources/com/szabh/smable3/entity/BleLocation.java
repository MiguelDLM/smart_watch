package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleLocation extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 16;
    private int mActivityMode;
    private int mAltitude;
    private float mLatitude;
    private float mLongitude;
    private int mTime;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleLocation() {
        this(0, 0, 0, 0.0f, 0.0f, 31, null);
    }

    public static /* synthetic */ BleLocation copy$default(BleLocation bleLocation, int i, int i2, int i3, float f, float f2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = bleLocation.mTime;
        }
        if ((i4 & 2) != 0) {
            i2 = bleLocation.mActivityMode;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = bleLocation.mAltitude;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            f = bleLocation.mLongitude;
        }
        float f3 = f;
        if ((i4 & 16) != 0) {
            f2 = bleLocation.mLatitude;
        }
        return bleLocation.copy(i, i5, i6, f3, f2);
    }

    public final int component1() {
        return this.mTime;
    }

    public final int component2() {
        return this.mActivityMode;
    }

    public final int component3() {
        return this.mAltitude;
    }

    public final float component4() {
        return this.mLongitude;
    }

    public final float component5() {
        return this.mLatitude;
    }

    @OOXIXo
    public final BleLocation copy(int i, int i2, int i3, float f, float f2) {
        return new BleLocation(i, i2, i3, f, f2);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mTime = BleReadable.readInt32$default(this, null, 1, null);
        this.mActivityMode = readUInt8();
        skip(8);
        this.mAltitude = BleReadable.readInt16$default(this, null, 1, null);
        this.mLongitude = BleReadable.readFloat$default(this, null, 1, null);
        this.mLatitude = BleReadable.readFloat$default(this, null, 1, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleLocation)) {
            return false;
        }
        BleLocation bleLocation = (BleLocation) obj;
        return this.mTime == bleLocation.mTime && this.mActivityMode == bleLocation.mActivityMode && this.mAltitude == bleLocation.mAltitude && Float.compare(this.mLongitude, bleLocation.mLongitude) == 0 && Float.compare(this.mLatitude, bleLocation.mLatitude) == 0;
    }

    public final int getMActivityMode() {
        return this.mActivityMode;
    }

    public final int getMAltitude() {
        return this.mAltitude;
    }

    public final float getMLatitude() {
        return this.mLatitude;
    }

    public final float getMLongitude() {
        return this.mLongitude;
    }

    public final int getMTime() {
        return this.mTime;
    }

    public int hashCode() {
        return (((((((this.mTime * 31) + this.mActivityMode) * 31) + this.mAltitude) * 31) + Float.floatToIntBits(this.mLongitude)) * 31) + Float.floatToIntBits(this.mLatitude);
    }

    public final void setMActivityMode(int i) {
        this.mActivityMode = i;
    }

    public final void setMAltitude(int i) {
        this.mAltitude = i;
    }

    public final void setMLatitude(float f) {
        this.mLatitude = f;
    }

    public final void setMLongitude(float f) {
        this.mLongitude = f;
    }

    public final void setMTime(int i) {
        this.mTime = i;
    }

    @OOXIXo
    public String toString() {
        return "BleLocation(mTime=" + this.mTime + ", mActivityMode=" + this.mActivityMode + ", mAltitude=" + this.mAltitude + ", mLongitude=" + this.mLongitude + ", mLatitude=" + this.mLatitude + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleLocation(int i, int i2, int i3, float f, float f2, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) == 0 ? i3 : 0, (i4 & 8) != 0 ? 0.0f : f, (i4 & 16) != 0 ? 0.0f : f2);
    }

    public BleLocation(int i, int i2, int i3, float f, float f2) {
        this.mTime = i;
        this.mActivityMode = i2;
        this.mAltitude = i3;
        this.mLongitude = f;
        this.mLatitude = f2;
    }
}
