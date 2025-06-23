package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.oxoX;

/* loaded from: classes13.dex */
public final class BleWorldClock extends BleIdObject {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 68;
    private static final int NAME_MAX_LENGTH = 62;
    private int isLocal;

    @OOXIXo
    private String mCityName;
    private int mTimeZoneOffset;
    private int reversed;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleWorldClock() {
        this(0, 0, 0, null, 15, null);
    }

    public static /* synthetic */ BleWorldClock copy$default(BleWorldClock bleWorldClock, int i, int i2, int i3, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = bleWorldClock.isLocal;
        }
        if ((i4 & 2) != 0) {
            i2 = bleWorldClock.mTimeZoneOffset;
        }
        if ((i4 & 4) != 0) {
            i3 = bleWorldClock.reversed;
        }
        if ((i4 & 8) != 0) {
            str = bleWorldClock.mCityName;
        }
        return bleWorldClock.copy(i, i2, i3, str);
    }

    public final int component1() {
        return this.isLocal;
    }

    public final int component2() {
        return this.mTimeZoneOffset;
    }

    public final int component3() {
        return this.reversed;
    }

    @OOXIXo
    public final String component4() {
        return this.mCityName;
    }

    @OOXIXo
    public final BleWorldClock copy(int i, int i2, int i3, @OOXIXo String mCityName) {
        IIX0o.x0xO0oo(mCityName, "mCityName");
        return new BleWorldClock(i, i2, i3, mCityName);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.isLocal = readIntN(1);
        setMId(readIntN(7));
        this.mTimeZoneOffset = readInt8();
        this.reversed = BleReadable.readInt16$default(this, null, 1, null);
        this.mCityName = readString(62, oxoX.f29583X0o0xo);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeIntN(this.isLocal, 1);
        writeIntN(getMId(), 7);
        writeInt8(this.mTimeZoneOffset);
        BleWritable.writeInt16$default(this, this.reversed, null, 2, null);
        writeStringWithFix(this.mCityName, 62, oxoX.f29583X0o0xo);
        BleWritable.writeInt16$default(this, 0, null, 2, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleWorldClock)) {
            return false;
        }
        BleWorldClock bleWorldClock = (BleWorldClock) obj;
        return this.isLocal == bleWorldClock.isLocal && this.mTimeZoneOffset == bleWorldClock.mTimeZoneOffset && this.reversed == bleWorldClock.reversed && IIX0o.Oxx0IOOO(this.mCityName, bleWorldClock.mCityName);
    }

    @OOXIXo
    public final String getMCityName() {
        return this.mCityName;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 68;
    }

    public final int getMTimeZoneOffset() {
        return this.mTimeZoneOffset;
    }

    public final int getReversed() {
        return this.reversed;
    }

    public int hashCode() {
        return (((((this.isLocal * 31) + this.mTimeZoneOffset) * 31) + this.reversed) * 31) + this.mCityName.hashCode();
    }

    public final int isLocal() {
        return this.isLocal;
    }

    public final void setLocal(int i) {
        this.isLocal = i;
    }

    public final void setMCityName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mCityName = str;
    }

    public final void setMTimeZoneOffset(int i) {
        this.mTimeZoneOffset = i;
    }

    public final void setReversed(int i) {
        this.reversed = i;
    }

    @OOXIXo
    public String toString() {
        return "BleWorldClock(mId=" + getMId() + ", isLocal=" + this.isLocal + ", mTimeZoneOffset=" + this.mTimeZoneOffset + ", mCityName='" + this.mCityName + "')";
    }

    public /* synthetic */ BleWorldClock(int i, int i2, int i3, String str, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3, (i4 & 8) != 0 ? "" : str);
    }

    public BleWorldClock(int i, int i2, int i3, @OOXIXo String mCityName) {
        IIX0o.x0xO0oo(mCityName, "mCityName");
        this.isLocal = i;
        this.mTimeZoneOffset = i2;
        this.reversed = i3;
        this.mCityName = mCityName;
    }
}
