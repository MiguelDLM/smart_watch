package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleSOSSettings extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 20;
    private static final int PHONE_LENGTH = 18;
    private int mEnabled;

    @OOXIXo
    private String mPhone;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BleSOSSettings() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleSOSSettings copy$default(BleSOSSettings bleSOSSettings, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleSOSSettings.mEnabled;
        }
        if ((i2 & 2) != 0) {
            str = bleSOSSettings.mPhone;
        }
        return bleSOSSettings.copy(i, str);
    }

    public final int component1() {
        return this.mEnabled;
    }

    @OOXIXo
    public final String component2() {
        return this.mPhone;
    }

    @OOXIXo
    public final BleSOSSettings copy(int i, @OOXIXo String mPhone) {
        IIX0o.x0xO0oo(mPhone, "mPhone");
        return new BleSOSSettings(i, mPhone);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mEnabled = readInt8();
        this.mPhone = BleReadable.readString$default(this, readInt8(), null, 2, null);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mEnabled);
        writeInt8(this.mPhone.length());
        BleWritable.writeStringWithFix$default(this, this.mPhone, 18, null, 4, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleSOSSettings)) {
            return false;
        }
        BleSOSSettings bleSOSSettings = (BleSOSSettings) obj;
        return this.mEnabled == bleSOSSettings.mEnabled && IIX0o.Oxx0IOOO(this.mPhone, bleSOSSettings.mPhone);
    }

    public final int getMEnabled() {
        return this.mEnabled;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 20;
    }

    @OOXIXo
    public final String getMPhone() {
        return this.mPhone;
    }

    public int hashCode() {
        return (this.mEnabled * 31) + this.mPhone.hashCode();
    }

    public final void setMEnabled(int i) {
        this.mEnabled = i;
    }

    public final void setMPhone(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mPhone = str;
    }

    @OOXIXo
    public String toString() {
        return "BleSosSettings(mEnabled=" + this.mEnabled + ", mPhone='" + this.mPhone + "')";
    }

    public /* synthetic */ BleSOSSettings(int i, String str, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str);
    }

    public BleSOSSettings(int i, @OOXIXo String mPhone) {
        IIX0o.x0xO0oo(mPhone, "mPhone");
        this.mEnabled = i;
        this.mPhone = mPhone;
    }
}
