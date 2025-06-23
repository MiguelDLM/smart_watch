package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleLocationGga.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleLocationGga.kt\ncom/szabh/smable3/entity/BleLocationGga\n+ 2 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable\n*L\n1#1,38:1\n222#2,4:39\n*S KotlinDebug\n*F\n+ 1 BleLocationGga.kt\ncom/szabh/smable3/entity/BleLocationGga\n*L\n21#1:39,4\n*E\n"})
/* loaded from: classes13.dex */
public final class BleLocationGga extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 64;
    private float altitude;
    private float mHorizontalDilutionPrecision;
    private float mLatitude;
    private float mLongitude;

    @OOXIXo
    private BleLocationUTC mTime;
    private int positioningQuality;
    private int satelliteCount;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleLocationGga() {
        this(null, 0.0f, 0.0f, 0, 0, 0.0f, 0.0f, 127, null);
    }

    public static /* synthetic */ BleLocationGga copy$default(BleLocationGga bleLocationGga, BleLocationUTC bleLocationUTC, float f, float f2, int i, int i2, float f3, float f4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bleLocationUTC = bleLocationGga.mTime;
        }
        if ((i3 & 2) != 0) {
            f = bleLocationGga.mLatitude;
        }
        float f5 = f;
        if ((i3 & 4) != 0) {
            f2 = bleLocationGga.mLongitude;
        }
        float f6 = f2;
        if ((i3 & 8) != 0) {
            i = bleLocationGga.positioningQuality;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            i2 = bleLocationGga.satelliteCount;
        }
        int i5 = i2;
        if ((i3 & 32) != 0) {
            f3 = bleLocationGga.mHorizontalDilutionPrecision;
        }
        float f7 = f3;
        if ((i3 & 64) != 0) {
            f4 = bleLocationGga.altitude;
        }
        return bleLocationGga.copy(bleLocationUTC, f5, f6, i4, i5, f7, f4);
    }

    @OOXIXo
    public final BleLocationUTC component1() {
        return this.mTime;
    }

    public final float component2() {
        return this.mLatitude;
    }

    public final float component3() {
        return this.mLongitude;
    }

    public final int component4() {
        return this.positioningQuality;
    }

    public final int component5() {
        return this.satelliteCount;
    }

    public final float component6() {
        return this.mHorizontalDilutionPrecision;
    }

    public final float component7() {
        return this.altitude;
    }

    @OOXIXo
    public final BleLocationGga copy(@OOXIXo BleLocationUTC mTime, float f, float f2, int i, int i2, float f3, float f4) {
        IIX0o.x0xO0oo(mTime, "mTime");
        return new BleLocationGga(mTime, f, f2, i, i2, f3, f4);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        BleReadable bleReadable = (BleReadable) BleLocationUTC.class.newInstance();
        bleReadable.setMBytes(readBytes(8));
        bleReadable.decode();
        IIX0o.ooOOo0oXI(bleReadable);
        this.mTime = (BleLocationUTC) bleReadable;
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mLatitude = readFloat(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mLongitude = readFloat(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.positioningQuality = readInt32(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.satelliteCount = readInt32(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mHorizontalDilutionPrecision = readFloat(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.altitude = readFloat(LITTLE_ENDIAN);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleLocationGga)) {
            return false;
        }
        BleLocationGga bleLocationGga = (BleLocationGga) obj;
        return IIX0o.Oxx0IOOO(this.mTime, bleLocationGga.mTime) && Float.compare(this.mLatitude, bleLocationGga.mLatitude) == 0 && Float.compare(this.mLongitude, bleLocationGga.mLongitude) == 0 && this.positioningQuality == bleLocationGga.positioningQuality && this.satelliteCount == bleLocationGga.satelliteCount && Float.compare(this.mHorizontalDilutionPrecision, bleLocationGga.mHorizontalDilutionPrecision) == 0 && Float.compare(this.altitude, bleLocationGga.altitude) == 0;
    }

    public final float getAltitude() {
        return this.altitude;
    }

    public final float getMHorizontalDilutionPrecision() {
        return this.mHorizontalDilutionPrecision;
    }

    public final float getMLatitude() {
        return this.mLatitude;
    }

    public final float getMLongitude() {
        return this.mLongitude;
    }

    @OOXIXo
    public final BleLocationUTC getMTime() {
        return this.mTime;
    }

    public final int getPositioningQuality() {
        return this.positioningQuality;
    }

    public final int getSatelliteCount() {
        return this.satelliteCount;
    }

    public int hashCode() {
        return (((((((((((this.mTime.hashCode() * 31) + Float.floatToIntBits(this.mLatitude)) * 31) + Float.floatToIntBits(this.mLongitude)) * 31) + this.positioningQuality) * 31) + this.satelliteCount) * 31) + Float.floatToIntBits(this.mHorizontalDilutionPrecision)) * 31) + Float.floatToIntBits(this.altitude);
    }

    public final void setAltitude(float f) {
        this.altitude = f;
    }

    public final void setMHorizontalDilutionPrecision(float f) {
        this.mHorizontalDilutionPrecision = f;
    }

    public final void setMLatitude(float f) {
        this.mLatitude = f;
    }

    public final void setMLongitude(float f) {
        this.mLongitude = f;
    }

    public final void setMTime(@OOXIXo BleLocationUTC bleLocationUTC) {
        IIX0o.x0xO0oo(bleLocationUTC, "<set-?>");
        this.mTime = bleLocationUTC;
    }

    public final void setPositioningQuality(int i) {
        this.positioningQuality = i;
    }

    public final void setSatelliteCount(int i) {
        this.satelliteCount = i;
    }

    @OOXIXo
    public String toString() {
        return "BleLocationGga(mTime=" + this.mTime + ", mLatitude=" + this.mLatitude + ", mLongitude=" + this.mLongitude + ", positioningQuality=" + this.positioningQuality + ", satelliteCount=" + this.satelliteCount + ", mHorizontalDilutionPrecision=" + this.mHorizontalDilutionPrecision + ", altitude=" + this.altitude + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleLocationGga(BleLocationUTC bleLocationUTC, float f, float f2, int i, int i2, float f3, float f4, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? new BleLocationUTC(0, 0, 0, 0, 15, null) : bleLocationUTC, (i3 & 2) != 0 ? 0.0f : f, (i3 & 4) != 0 ? 0.0f : f2, (i3 & 8) != 0 ? 0 : i, (i3 & 16) == 0 ? i2 : 0, (i3 & 32) != 0 ? 0.0f : f3, (i3 & 64) == 0 ? f4 : 0.0f);
    }

    public BleLocationGga(@OOXIXo BleLocationUTC mTime, float f, float f2, int i, int i2, float f3, float f4) {
        IIX0o.x0xO0oo(mTime, "mTime");
        this.mTime = mTime;
        this.mLatitude = f;
        this.mLongitude = f2;
        this.positioningQuality = i;
        this.satelliteCount = i2;
        this.mHorizontalDilutionPrecision = f3;
        this.altitude = f4;
    }
}
