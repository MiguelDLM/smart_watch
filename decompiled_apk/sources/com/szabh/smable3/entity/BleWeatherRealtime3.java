package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleWeatherRealtime3 extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 92;
    public static final int NAME_LENGTH = 66;
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

    /* JADX WARN: Multi-variable type inference failed */
    public BleWeatherRealtime3() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleWeatherRealtime3 copy$default(BleWeatherRealtime3 bleWeatherRealtime3, int i, BleWeather2 bleWeather2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleWeatherRealtime3.mTime;
        }
        if ((i2 & 2) != 0) {
            bleWeather2 = bleWeatherRealtime3.mWeather;
        }
        return bleWeatherRealtime3.copy(i, bleWeather2);
    }

    public final int component1() {
        return this.mTime;
    }

    @oOoXoXO
    public final BleWeather2 component2() {
        return this.mWeather;
    }

    @OOXIXo
    public final BleWeatherRealtime3 copy(int i, @oOoXoXO BleWeather2 bleWeather2) {
        return new BleWeatherRealtime3(i, bleWeather2);
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
        if (!(obj instanceof BleWeatherRealtime3)) {
            return false;
        }
        BleWeatherRealtime3 bleWeatherRealtime3 = (BleWeatherRealtime3) obj;
        return this.mTime == bleWeatherRealtime3.mTime && IIX0o.Oxx0IOOO(this.mWeather, bleWeatherRealtime3.mWeather);
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
        int i = this.mTime * 31;
        BleWeather2 bleWeather2 = this.mWeather;
        return i + (bleWeather2 == null ? 0 : bleWeather2.hashCode());
    }

    public final void setMTime(int i) {
        this.mTime = i;
    }

    public final void setMWeather(@oOoXoXO BleWeather2 bleWeather2) {
        this.mWeather = bleWeather2;
    }

    @OOXIXo
    public String toString() {
        return "BleWeatherRealtime3()";
    }

    public /* synthetic */ BleWeatherRealtime3(int i, BleWeather2 bleWeather2, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : bleWeather2);
    }

    public BleWeatherRealtime3(int i, @oOoXoXO BleWeather2 bleWeather2) {
        this.mTime = i;
        this.mWeather = bleWeather2;
    }
}
