package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleWeatherForecast3 extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 212;
    public static final int NAME_LENGTH = 66;
    private final int mYear;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleWeatherForecast3() {
        this(0, 1, null);
    }

    public static /* synthetic */ BleWeatherForecast3 copy$default(BleWeatherForecast3 bleWeatherForecast3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleWeatherForecast3.mYear;
        }
        return bleWeatherForecast3.copy(i);
    }

    public final int component1() {
        return this.mYear;
    }

    @OOXIXo
    public final BleWeatherForecast3 copy(int i) {
        return new BleWeatherForecast3(i);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BleWeatherForecast3) && this.mYear == ((BleWeatherForecast3) obj).mYear;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 212;
    }

    public final int getMYear() {
        return this.mYear;
    }

    public int hashCode() {
        return this.mYear;
    }

    @OOXIXo
    public String toString() {
        return "BleWeatherForecast3()";
    }

    public /* synthetic */ BleWeatherForecast3(int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public BleWeatherForecast3(int i) {
        this.mYear = i;
    }
}
