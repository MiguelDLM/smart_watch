package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleWeatherRealtime2 extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 92;
    public static final int NAME_LENGTH = 66;

    @OOXIXo
    private String mCityName;
    private int mTime;

    @oOoXoXO
    private BleWeather2 mWeather;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleWeatherRealtime2() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ BleWeatherRealtime2 copy$default(BleWeatherRealtime2 bleWeatherRealtime2, int i, String str, BleWeather2 bleWeather2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleWeatherRealtime2.mTime;
        }
        if ((i2 & 2) != 0) {
            str = bleWeatherRealtime2.mCityName;
        }
        if ((i2 & 4) != 0) {
            bleWeather2 = bleWeatherRealtime2.mWeather;
        }
        return bleWeatherRealtime2.copy(i, str, bleWeather2);
    }

    public final int component1() {
        return this.mTime;
    }

    @OOXIXo
    public final String component2() {
        return this.mCityName;
    }

    @oOoXoXO
    public final BleWeather2 component3() {
        return this.mWeather;
    }

    @OOXIXo
    public final BleWeatherRealtime2 copy(int i, @OOXIXo String mCityName, @oOoXoXO BleWeather2 bleWeather2) {
        IIX0o.x0xO0oo(mCityName, "mCityName");
        return new BleWeatherRealtime2(i, mCityName, bleWeather2);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeObject(BleTime.Companion.ofLocal(this.mTime * 1000));
        BleWritable.writeStringWithFix$default(this, this.mCityName, 66, null, 4, null);
        writeObject(this.mWeather);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleWeatherRealtime2)) {
            return false;
        }
        BleWeatherRealtime2 bleWeatherRealtime2 = (BleWeatherRealtime2) obj;
        return this.mTime == bleWeatherRealtime2.mTime && IIX0o.Oxx0IOOO(this.mCityName, bleWeatherRealtime2.mCityName) && IIX0o.Oxx0IOOO(this.mWeather, bleWeatherRealtime2.mWeather);
    }

    @OOXIXo
    public final String getMCityName() {
        return this.mCityName;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 92;
    }

    public final int getMTime() {
        return this.mTime;
    }

    @oOoXoXO
    public final BleWeather2 getMWeather() {
        return this.mWeather;
    }

    public int hashCode() {
        int hashCode = ((this.mTime * 31) + this.mCityName.hashCode()) * 31;
        BleWeather2 bleWeather2 = this.mWeather;
        return hashCode + (bleWeather2 == null ? 0 : bleWeather2.hashCode());
    }

    public final void setMCityName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mCityName = str;
    }

    public final void setMTime(int i) {
        this.mTime = i;
    }

    public final void setMWeather(@oOoXoXO BleWeather2 bleWeather2) {
        this.mWeather = bleWeather2;
    }

    @OOXIXo
    public String toString() {
        return "BleWeatherRealtime2(mTime=" + BleTime.Companion.ofLocal(this.mTime * 1000) + ", mCityName=" + this.mCityName + ", mWeather=" + this.mWeather + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleWeatherRealtime2(int i, String str, BleWeather2 bleWeather2, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? null : bleWeather2);
    }

    public BleWeatherRealtime2(int i, @OOXIXo String mCityName, @oOoXoXO BleWeather2 bleWeather2) {
        IIX0o.x0xO0oo(mCityName, "mCityName");
        this.mTime = i;
        this.mCityName = mCityName;
        this.mWeather = bleWeather2;
    }
}
