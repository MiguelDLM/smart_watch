package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleWeatherRealtime extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 16;
    private int mTime;

    @oOoXoXO
    private BleWeather mWeather;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BleWeatherRealtime() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleWeatherRealtime copy$default(BleWeatherRealtime bleWeatherRealtime, int i, BleWeather bleWeather, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleWeatherRealtime.mTime;
        }
        if ((i2 & 2) != 0) {
            bleWeather = bleWeatherRealtime.mWeather;
        }
        return bleWeatherRealtime.copy(i, bleWeather);
    }

    public final int component1() {
        return this.mTime;
    }

    @oOoXoXO
    public final BleWeather component2() {
        return this.mWeather;
    }

    @OOXIXo
    public final BleWeatherRealtime copy(int i, @oOoXoXO BleWeather bleWeather) {
        return new BleWeatherRealtime(i, bleWeather);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeObject(BleTime.Companion.ofLocal(this.mTime * 1000));
        writeObject(this.mWeather);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleWeatherRealtime)) {
            return false;
        }
        BleWeatherRealtime bleWeatherRealtime = (BleWeatherRealtime) obj;
        return this.mTime == bleWeatherRealtime.mTime && IIX0o.Oxx0IOOO(this.mWeather, bleWeatherRealtime.mWeather);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 16;
    }

    public final int getMTime() {
        return this.mTime;
    }

    @oOoXoXO
    public final BleWeather getMWeather() {
        return this.mWeather;
    }

    public int hashCode() {
        int i = this.mTime * 31;
        BleWeather bleWeather = this.mWeather;
        return i + (bleWeather == null ? 0 : bleWeather.hashCode());
    }

    public final void setMTime(int i) {
        this.mTime = i;
    }

    public final void setMWeather(@oOoXoXO BleWeather bleWeather) {
        this.mWeather = bleWeather;
    }

    @OOXIXo
    public String toString() {
        return "BleWeatherRealtime(mTime=" + BleTime.Companion.ofLocal(this.mTime * 1000) + ", mWeather=" + this.mWeather + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleWeatherRealtime(int i, BleWeather bleWeather, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : bleWeather);
    }

    public BleWeatherRealtime(int i, @oOoXoXO BleWeather bleWeather) {
        this.mTime = i;
        this.mWeather = bleWeather;
    }
}
