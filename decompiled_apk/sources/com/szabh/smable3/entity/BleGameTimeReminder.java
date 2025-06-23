package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleGameTimeReminder extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 4;
    private int mEnabled;
    private int mMinute;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public BleGameTimeReminder() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szabh.smable3.entity.BleGameTimeReminder.<init>():void");
    }

    public static /* synthetic */ BleGameTimeReminder copy$default(BleGameTimeReminder bleGameTimeReminder, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bleGameTimeReminder.mEnabled;
        }
        if ((i3 & 2) != 0) {
            i2 = bleGameTimeReminder.mMinute;
        }
        return bleGameTimeReminder.copy(i, i2);
    }

    public final int component1() {
        return this.mEnabled;
    }

    public final int component2() {
        return this.mMinute;
    }

    @OOXIXo
    public final BleGameTimeReminder copy(int i, int i2) {
        return new BleGameTimeReminder(i, i2);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mEnabled);
        writeInt8(this.mMinute);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleGameTimeReminder)) {
            return false;
        }
        BleGameTimeReminder bleGameTimeReminder = (BleGameTimeReminder) obj;
        return this.mEnabled == bleGameTimeReminder.mEnabled && this.mMinute == bleGameTimeReminder.mMinute;
    }

    public final int getMEnabled() {
        return this.mEnabled;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 4;
    }

    public final int getMMinute() {
        return this.mMinute;
    }

    public int hashCode() {
        return (this.mEnabled * 31) + this.mMinute;
    }

    public final void setMEnabled(int i) {
        this.mEnabled = i;
    }

    public final void setMMinute(int i) {
        this.mMinute = i;
    }

    @OOXIXo
    public String toString() {
        return "BleGameTimeReminder(mEnabled=" + this.mEnabled + ", mMinute=" + this.mMinute + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleGameTimeReminder(int i, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public BleGameTimeReminder(int i, int i2) {
        this.mEnabled = i;
        this.mMinute = i2;
    }
}
