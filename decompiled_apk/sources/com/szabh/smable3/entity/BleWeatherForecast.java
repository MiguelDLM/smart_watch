package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleWeatherForecast extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 36;
    private int mTime;

    @oOoXoXO
    private BleWeather mWeather1;

    @oOoXoXO
    private BleWeather mWeather2;

    @oOoXoXO
    private BleWeather mWeather3;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleWeatherForecast() {
        this(0, null, null, null, 15, null);
    }

    public static /* synthetic */ BleWeatherForecast copy$default(BleWeatherForecast bleWeatherForecast, int i, BleWeather bleWeather, BleWeather bleWeather2, BleWeather bleWeather3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleWeatherForecast.mTime;
        }
        if ((i2 & 2) != 0) {
            bleWeather = bleWeatherForecast.mWeather1;
        }
        if ((i2 & 4) != 0) {
            bleWeather2 = bleWeatherForecast.mWeather2;
        }
        if ((i2 & 8) != 0) {
            bleWeather3 = bleWeatherForecast.mWeather3;
        }
        return bleWeatherForecast.copy(i, bleWeather, bleWeather2, bleWeather3);
    }

    public final int component1() {
        return this.mTime;
    }

    @oOoXoXO
    public final BleWeather component2() {
        return this.mWeather1;
    }

    @oOoXoXO
    public final BleWeather component3() {
        return this.mWeather2;
    }

    @oOoXoXO
    public final BleWeather component4() {
        return this.mWeather3;
    }

    @OOXIXo
    public final BleWeatherForecast copy(int i, @oOoXoXO BleWeather bleWeather, @oOoXoXO BleWeather bleWeather2, @oOoXoXO BleWeather bleWeather3) {
        return new BleWeatherForecast(i, bleWeather, bleWeather2, bleWeather3);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeObject(BleTime.Companion.ofLocal(this.mTime * 1000));
        writeObject(this.mWeather1);
        writeObject(this.mWeather2);
        writeObject(this.mWeather3);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleWeatherForecast)) {
            return false;
        }
        BleWeatherForecast bleWeatherForecast = (BleWeatherForecast) obj;
        return this.mTime == bleWeatherForecast.mTime && IIX0o.Oxx0IOOO(this.mWeather1, bleWeatherForecast.mWeather1) && IIX0o.Oxx0IOOO(this.mWeather2, bleWeatherForecast.mWeather2) && IIX0o.Oxx0IOOO(this.mWeather3, bleWeatherForecast.mWeather3);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 36;
    }

    public final int getMTime() {
        return this.mTime;
    }

    @oOoXoXO
    public final BleWeather getMWeather1() {
        return this.mWeather1;
    }

    @oOoXoXO
    public final BleWeather getMWeather2() {
        return this.mWeather2;
    }

    @oOoXoXO
    public final BleWeather getMWeather3() {
        return this.mWeather3;
    }

    public int hashCode() {
        int i = this.mTime * 31;
        BleWeather bleWeather = this.mWeather1;
        int hashCode = (i + (bleWeather == null ? 0 : bleWeather.hashCode())) * 31;
        BleWeather bleWeather2 = this.mWeather2;
        int hashCode2 = (hashCode + (bleWeather2 == null ? 0 : bleWeather2.hashCode())) * 31;
        BleWeather bleWeather3 = this.mWeather3;
        return hashCode2 + (bleWeather3 != null ? bleWeather3.hashCode() : 0);
    }

    public final void setMTime(int i) {
        this.mTime = i;
    }

    public final void setMWeather1(@oOoXoXO BleWeather bleWeather) {
        this.mWeather1 = bleWeather;
    }

    public final void setMWeather2(@oOoXoXO BleWeather bleWeather) {
        this.mWeather2 = bleWeather;
    }

    public final void setMWeather3(@oOoXoXO BleWeather bleWeather) {
        this.mWeather3 = bleWeather;
    }

    @OOXIXo
    public String toString() {
        return "BleWeatherForecast(mTime=" + BleTime.Companion.ofLocal(this.mTime * 1000) + ", mWeather1=" + this.mWeather1 + ", mWeather2=" + this.mWeather2 + ", mWeather3=" + this.mWeather3 + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleWeatherForecast(int i, BleWeather bleWeather, BleWeather bleWeather2, BleWeather bleWeather3, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : bleWeather, (i2 & 4) != 0 ? null : bleWeather2, (i2 & 8) != 0 ? null : bleWeather3);
    }

    public BleWeatherForecast(int i, @oOoXoXO BleWeather bleWeather, @oOoXoXO BleWeather bleWeather2, @oOoXoXO BleWeather bleWeather3) {
        this.mTime = i;
        this.mWeather1 = bleWeather;
        this.mWeather2 = bleWeather2;
        this.mWeather3 = bleWeather3;
    }
}
