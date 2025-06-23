package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleSettingWatchPassword extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 5;
    private static final int PWD_LENGTH = 4;
    private int mEnabled;

    @OOXIXo
    private String mPassword;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BleSettingWatchPassword() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleSettingWatchPassword copy$default(BleSettingWatchPassword bleSettingWatchPassword, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleSettingWatchPassword.mEnabled;
        }
        if ((i2 & 2) != 0) {
            str = bleSettingWatchPassword.mPassword;
        }
        return bleSettingWatchPassword.copy(i, str);
    }

    public final int component1() {
        return this.mEnabled;
    }

    @OOXIXo
    public final String component2() {
        return this.mPassword;
    }

    @OOXIXo
    public final BleSettingWatchPassword copy(int i, @OOXIXo String mPassword) {
        IIX0o.x0xO0oo(mPassword, "mPassword");
        return new BleSettingWatchPassword(i, mPassword);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mEnabled = readUInt8();
        this.mPassword = BleReadable.readString$default(this, 4, null, 2, null);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mEnabled);
        BleWritable.writeStringWithFix$default(this, this.mPassword, 4, null, 4, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleSettingWatchPassword)) {
            return false;
        }
        BleSettingWatchPassword bleSettingWatchPassword = (BleSettingWatchPassword) obj;
        return this.mEnabled == bleSettingWatchPassword.mEnabled && IIX0o.Oxx0IOOO(this.mPassword, bleSettingWatchPassword.mPassword);
    }

    public final int getMEnabled() {
        return this.mEnabled;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 5;
    }

    @OOXIXo
    public final String getMPassword() {
        return this.mPassword;
    }

    public int hashCode() {
        return (this.mEnabled * 31) + this.mPassword.hashCode();
    }

    public final void setMEnabled(int i) {
        this.mEnabled = i;
    }

    public final void setMPassword(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mPassword = str;
    }

    @OOXIXo
    public String toString() {
        return "BleSettingWatchPassword(mEnabled=" + this.mEnabled + ", mPassword='" + this.mPassword + "')";
    }

    public /* synthetic */ BleSettingWatchPassword(int i, String str, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str);
    }

    public BleSettingWatchPassword(int i, @OOXIXo String mPassword) {
        IIX0o.x0xO0oo(mPassword, "mPassword");
        this.mEnabled = i;
        this.mPassword = mPassword;
    }
}
