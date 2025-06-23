package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.oIX0oI;
import com.bestmafen.baseble.data.BleWritable;
import java.nio.charset.Charset;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.oxoX;

/* loaded from: classes13.dex */
public final class BleBWNaviInfo extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int DISTANCE_MAX_LENGTH = 32;
    public static final int NAVI_END = 4;
    public static final int NAVI_GOING = 1;
    public static final int NAVI_GUIDE_END = 5;
    public static final int NAVI_MODE_BIKE = 1;
    public static final int NAVI_MODE_WALK = 0;
    public static final int NAVI_PAUSE = 2;
    public static final int NAVI_RESUME = 3;
    public static final int NAVI_START = 0;
    public static final int ROAD_MAX_LENGTH = 164;
    public static final int TIME_MAX_LENGTH = 32;
    private int mAltitude;
    private int mMode;

    @OOXIXo
    private String mRemainDistance;

    @OOXIXo
    private String mRemainTime;

    @OOXIXo
    private String mRoadGuide;
    private int mSpeed;
    private int mState;
    private long mTime;
    private int mTurnType;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleBWNaviInfo() {
        this(0, 0L, 0, 0, 0, 0, null, null, null, 511, null);
    }

    public final int component1() {
        return this.mState;
    }

    public final long component2() {
        return this.mTime;
    }

    public final int component3() {
        return this.mMode;
    }

    public final int component4() {
        return this.mSpeed;
    }

    public final int component5() {
        return this.mAltitude;
    }

    public final int component6() {
        return this.mTurnType;
    }

    @OOXIXo
    public final String component7() {
        return this.mRemainTime;
    }

    @OOXIXo
    public final String component8() {
        return this.mRemainDistance;
    }

    @OOXIXo
    public final String component9() {
        return this.mRoadGuide;
    }

    @OOXIXo
    public final BleBWNaviInfo copy(int i, long j, int i2, int i3, int i4, int i5, @OOXIXo String mRemainTime, @OOXIXo String mRemainDistance, @OOXIXo String mRoadGuide) {
        IIX0o.x0xO0oo(mRemainTime, "mRemainTime");
        IIX0o.x0xO0oo(mRemainDistance, "mRemainDistance");
        IIX0o.x0xO0oo(mRoadGuide, "mRoadGuide");
        return new BleBWNaviInfo(i, j, i2, i3, i4, i5, mRemainTime, mRemainDistance, mRoadGuide);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mState = readInt8();
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mState);
        writeObject(BleTime.Companion.ofLocal(this.mTime));
        writeInt8(this.mMode);
        BleWritable.writeInt32$default(this, this.mSpeed, null, 2, null);
        BleWritable.writeInt32$default(this, this.mAltitude, null, 2, null);
        BleWritable.writeLong$default(this, 0L, null, 2, null);
        writeInt8(this.mTurnType);
        String str = this.mRemainTime;
        Charset charset = oxoX.f29581II0xO0;
        byte[] bytes = str.getBytes(charset);
        IIX0o.oO(bytes, "getBytes(...)");
        writeInt8(Math.min(bytes.length, 32));
        byte[] bytes2 = this.mRemainDistance.getBytes(charset);
        IIX0o.oO(bytes2, "getBytes(...)");
        writeInt8(Math.min(bytes2.length, 32));
        byte[] bytes3 = this.mRoadGuide.getBytes(charset);
        IIX0o.oO(bytes3, "getBytes(...)");
        writeInt8(Math.min(bytes3.length, 164));
        BleWritable.writeStringWithFix$default(this, this.mRemainTime, 32, null, 4, null);
        BleWritable.writeStringWithFix$default(this, this.mRemainDistance, 32, null, 4, null);
        BleWritable.writeStringWithLimit$default(this, this.mRoadGuide, 164, null, true, 4, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleBWNaviInfo)) {
            return false;
        }
        BleBWNaviInfo bleBWNaviInfo = (BleBWNaviInfo) obj;
        return this.mState == bleBWNaviInfo.mState && this.mTime == bleBWNaviInfo.mTime && this.mMode == bleBWNaviInfo.mMode && this.mSpeed == bleBWNaviInfo.mSpeed && this.mAltitude == bleBWNaviInfo.mAltitude && this.mTurnType == bleBWNaviInfo.mTurnType && IIX0o.Oxx0IOOO(this.mRemainTime, bleBWNaviInfo.mRemainTime) && IIX0o.Oxx0IOOO(this.mRemainDistance, bleBWNaviInfo.mRemainDistance) && IIX0o.Oxx0IOOO(this.mRoadGuide, bleBWNaviInfo.mRoadGuide);
    }

    public final int getMAltitude() {
        return this.mAltitude;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        byte[] bytes = this.mRoadGuide.getBytes(oxoX.f29581II0xO0);
        IIX0o.oO(bytes, "getBytes(...)");
        return Math.min(bytes.length, 164) + 92;
    }

    public final int getMMode() {
        return this.mMode;
    }

    @OOXIXo
    public final String getMRemainDistance() {
        return this.mRemainDistance;
    }

    @OOXIXo
    public final String getMRemainTime() {
        return this.mRemainTime;
    }

    @OOXIXo
    public final String getMRoadGuide() {
        return this.mRoadGuide;
    }

    public final int getMSpeed() {
        return this.mSpeed;
    }

    public final int getMState() {
        return this.mState;
    }

    public final long getMTime() {
        return this.mTime;
    }

    public final int getMTurnType() {
        return this.mTurnType;
    }

    public int hashCode() {
        return (((((((((((((((this.mState * 31) + oIX0oI.oIX0oI(this.mTime)) * 31) + this.mMode) * 31) + this.mSpeed) * 31) + this.mAltitude) * 31) + this.mTurnType) * 31) + this.mRemainTime.hashCode()) * 31) + this.mRemainDistance.hashCode()) * 31) + this.mRoadGuide.hashCode();
    }

    public final void setMAltitude(int i) {
        this.mAltitude = i;
    }

    public final void setMMode(int i) {
        this.mMode = i;
    }

    public final void setMRemainDistance(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mRemainDistance = str;
    }

    public final void setMRemainTime(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mRemainTime = str;
    }

    public final void setMRoadGuide(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mRoadGuide = str;
    }

    public final void setMSpeed(int i) {
        this.mSpeed = i;
    }

    public final void setMState(int i) {
        this.mState = i;
    }

    public final void setMTime(long j) {
        this.mTime = j;
    }

    public final void setMTurnType(int i) {
        this.mTurnType = i;
    }

    @OOXIXo
    public String toString() {
        return "BleBWNaviInfo(mState=" + this.mState + ", mTime=" + this.mTime + ", mMode=" + this.mMode + ", mSpeed=" + this.mSpeed + ", mAltitude=" + this.mAltitude + ", mTurnType=" + this.mTurnType + ", mRemainDistance='" + this.mRemainDistance + "', mRemainTime='" + this.mRemainTime + "', mRoadGuide='" + this.mRoadGuide + "')";
    }

    public /* synthetic */ BleBWNaviInfo(int i, long j, int i2, int i3, int i4, int i5, String str, String str2, String str3, int i6, IIXOooo iIXOooo) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? 0L : j, (i6 & 4) != 0 ? 0 : i2, (i6 & 8) != 0 ? 0 : i3, (i6 & 16) != 0 ? 0 : i4, (i6 & 32) == 0 ? i5 : 0, (i6 & 64) != 0 ? "" : str, (i6 & 128) != 0 ? "" : str2, (i6 & 256) == 0 ? str3 : "");
    }

    public BleBWNaviInfo(int i, long j, int i2, int i3, int i4, int i5, @OOXIXo String mRemainTime, @OOXIXo String mRemainDistance, @OOXIXo String mRoadGuide) {
        IIX0o.x0xO0oo(mRemainTime, "mRemainTime");
        IIX0o.x0xO0oo(mRemainDistance, "mRemainDistance");
        IIX0o.x0xO0oo(mRoadGuide, "mRoadGuide");
        this.mState = i;
        this.mTime = j;
        this.mMode = i2;
        this.mSpeed = i3;
        this.mAltitude = i4;
        this.mTurnType = i5;
        this.mRemainTime = mRemainTime;
        this.mRemainDistance = mRemainDistance;
        this.mRoadGuide = mRoadGuide;
    }
}
