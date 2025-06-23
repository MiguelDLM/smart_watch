package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleWeatherForecast2 extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 212;
    public static final int NAME_LENGTH = 66;

    @OOXIXo
    private String mCityName;
    private int mTime;

    @oOoXoXO
    private BleWeather2 mWeather1;

    @oOoXoXO
    private BleWeather2 mWeather2;

    @oOoXoXO
    private BleWeather2 mWeather3;

    @oOoXoXO
    private BleWeather2 mWeather4;

    @oOoXoXO
    private BleWeather2 mWeather5;

    @oOoXoXO
    private BleWeather2 mWeather6;

    @oOoXoXO
    private BleWeather2 mWeather7;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleWeatherForecast2() {
        this(0, null, null, null, null, null, null, null, null, 511, null);
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
        return this.mWeather1;
    }

    @oOoXoXO
    public final BleWeather2 component4() {
        return this.mWeather2;
    }

    @oOoXoXO
    public final BleWeather2 component5() {
        return this.mWeather3;
    }

    @oOoXoXO
    public final BleWeather2 component6() {
        return this.mWeather4;
    }

    @oOoXoXO
    public final BleWeather2 component7() {
        return this.mWeather5;
    }

    @oOoXoXO
    public final BleWeather2 component8() {
        return this.mWeather6;
    }

    @oOoXoXO
    public final BleWeather2 component9() {
        return this.mWeather7;
    }

    @OOXIXo
    public final BleWeatherForecast2 copy(int i, @OOXIXo String mCityName, @oOoXoXO BleWeather2 bleWeather2, @oOoXoXO BleWeather2 bleWeather22, @oOoXoXO BleWeather2 bleWeather23, @oOoXoXO BleWeather2 bleWeather24, @oOoXoXO BleWeather2 bleWeather25, @oOoXoXO BleWeather2 bleWeather26, @oOoXoXO BleWeather2 bleWeather27) {
        IIX0o.x0xO0oo(mCityName, "mCityName");
        return new BleWeatherForecast2(i, mCityName, bleWeather2, bleWeather22, bleWeather23, bleWeather24, bleWeather25, bleWeather26, bleWeather27);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeObject(BleTime.Companion.ofLocal(this.mTime * 1000));
        BleWritable.writeStringWithFix$default(this, this.mCityName, 66, null, 4, null);
        writeObject(this.mWeather1);
        writeObject(this.mWeather2);
        writeObject(this.mWeather3);
        writeObject(this.mWeather4);
        writeObject(this.mWeather5);
        writeObject(this.mWeather6);
        writeObject(this.mWeather7);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleWeatherForecast2)) {
            return false;
        }
        BleWeatherForecast2 bleWeatherForecast2 = (BleWeatherForecast2) obj;
        return this.mTime == bleWeatherForecast2.mTime && IIX0o.Oxx0IOOO(this.mCityName, bleWeatherForecast2.mCityName) && IIX0o.Oxx0IOOO(this.mWeather1, bleWeatherForecast2.mWeather1) && IIX0o.Oxx0IOOO(this.mWeather2, bleWeatherForecast2.mWeather2) && IIX0o.Oxx0IOOO(this.mWeather3, bleWeatherForecast2.mWeather3) && IIX0o.Oxx0IOOO(this.mWeather4, bleWeatherForecast2.mWeather4) && IIX0o.Oxx0IOOO(this.mWeather5, bleWeatherForecast2.mWeather5) && IIX0o.Oxx0IOOO(this.mWeather6, bleWeatherForecast2.mWeather6) && IIX0o.Oxx0IOOO(this.mWeather7, bleWeatherForecast2.mWeather7);
    }

    @OOXIXo
    public final String getMCityName() {
        return this.mCityName;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 212;
    }

    public final int getMTime() {
        return this.mTime;
    }

    @oOoXoXO
    public final BleWeather2 getMWeather1() {
        return this.mWeather1;
    }

    @oOoXoXO
    public final BleWeather2 getMWeather2() {
        return this.mWeather2;
    }

    @oOoXoXO
    public final BleWeather2 getMWeather3() {
        return this.mWeather3;
    }

    @oOoXoXO
    public final BleWeather2 getMWeather4() {
        return this.mWeather4;
    }

    @oOoXoXO
    public final BleWeather2 getMWeather5() {
        return this.mWeather5;
    }

    @oOoXoXO
    public final BleWeather2 getMWeather6() {
        return this.mWeather6;
    }

    @oOoXoXO
    public final BleWeather2 getMWeather7() {
        return this.mWeather7;
    }

    public int hashCode() {
        int hashCode = ((this.mTime * 31) + this.mCityName.hashCode()) * 31;
        BleWeather2 bleWeather2 = this.mWeather1;
        int hashCode2 = (hashCode + (bleWeather2 == null ? 0 : bleWeather2.hashCode())) * 31;
        BleWeather2 bleWeather22 = this.mWeather2;
        int hashCode3 = (hashCode2 + (bleWeather22 == null ? 0 : bleWeather22.hashCode())) * 31;
        BleWeather2 bleWeather23 = this.mWeather3;
        int hashCode4 = (hashCode3 + (bleWeather23 == null ? 0 : bleWeather23.hashCode())) * 31;
        BleWeather2 bleWeather24 = this.mWeather4;
        int hashCode5 = (hashCode4 + (bleWeather24 == null ? 0 : bleWeather24.hashCode())) * 31;
        BleWeather2 bleWeather25 = this.mWeather5;
        int hashCode6 = (hashCode5 + (bleWeather25 == null ? 0 : bleWeather25.hashCode())) * 31;
        BleWeather2 bleWeather26 = this.mWeather6;
        int hashCode7 = (hashCode6 + (bleWeather26 == null ? 0 : bleWeather26.hashCode())) * 31;
        BleWeather2 bleWeather27 = this.mWeather7;
        return hashCode7 + (bleWeather27 != null ? bleWeather27.hashCode() : 0);
    }

    public final void setMCityName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mCityName = str;
    }

    public final void setMTime(int i) {
        this.mTime = i;
    }

    public final void setMWeather1(@oOoXoXO BleWeather2 bleWeather2) {
        this.mWeather1 = bleWeather2;
    }

    public final void setMWeather2(@oOoXoXO BleWeather2 bleWeather2) {
        this.mWeather2 = bleWeather2;
    }

    public final void setMWeather3(@oOoXoXO BleWeather2 bleWeather2) {
        this.mWeather3 = bleWeather2;
    }

    public final void setMWeather4(@oOoXoXO BleWeather2 bleWeather2) {
        this.mWeather4 = bleWeather2;
    }

    public final void setMWeather5(@oOoXoXO BleWeather2 bleWeather2) {
        this.mWeather5 = bleWeather2;
    }

    public final void setMWeather6(@oOoXoXO BleWeather2 bleWeather2) {
        this.mWeather6 = bleWeather2;
    }

    public final void setMWeather7(@oOoXoXO BleWeather2 bleWeather2) {
        this.mWeather7 = bleWeather2;
    }

    @OOXIXo
    public String toString() {
        return "BleWeatherForecast2(mTime=" + BleTime.Companion.ofLocal(this.mTime * 1000) + ", mCityName=" + this.mCityName + ", mWeather1=" + this.mWeather1 + ", mWeather2=" + this.mWeather2 + ", mWeather3=" + this.mWeather3 + ", mWeather4=" + this.mWeather4 + ", mWeather5=" + this.mWeather5 + ", mWeather6=" + this.mWeather6 + ", mWeather7=" + this.mWeather7 + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleWeatherForecast2(int i, String str, BleWeather2 bleWeather2, BleWeather2 bleWeather22, BleWeather2 bleWeather23, BleWeather2 bleWeather24, BleWeather2 bleWeather25, BleWeather2 bleWeather26, BleWeather2 bleWeather27, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? null : bleWeather2, (i2 & 8) != 0 ? null : bleWeather22, (i2 & 16) != 0 ? null : bleWeather23, (i2 & 32) != 0 ? null : bleWeather24, (i2 & 64) != 0 ? null : bleWeather25, (i2 & 128) != 0 ? null : bleWeather26, (i2 & 256) == 0 ? bleWeather27 : null);
    }

    public BleWeatherForecast2(int i, @OOXIXo String mCityName, @oOoXoXO BleWeather2 bleWeather2, @oOoXoXO BleWeather2 bleWeather22, @oOoXoXO BleWeather2 bleWeather23, @oOoXoXO BleWeather2 bleWeather24, @oOoXoXO BleWeather2 bleWeather25, @oOoXoXO BleWeather2 bleWeather26, @oOoXoXO BleWeather2 bleWeather27) {
        IIX0o.x0xO0oo(mCityName, "mCityName");
        this.mTime = i;
        this.mCityName = mCityName;
        this.mWeather1 = bleWeather2;
        this.mWeather2 = bleWeather22;
        this.mWeather3 = bleWeather23;
        this.mWeather4 = bleWeather24;
        this.mWeather5 = bleWeather25;
        this.mWeather6 = bleWeather26;
        this.mWeather7 = bleWeather27;
    }
}
