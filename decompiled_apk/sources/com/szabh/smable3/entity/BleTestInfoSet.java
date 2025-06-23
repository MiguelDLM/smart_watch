package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.oxoX;

/* loaded from: classes13.dex */
public final class BleTestInfoSet extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int TYPE_WIFI_NAME = 1;
    public static final int TYPE_WIFI_PASSWORD = 2;

    @OOXIXo
    private String mWifiName;

    @OOXIXo
    private String mWifiPassword;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BleTestInfoSet() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleTestInfoSet copy$default(BleTestInfoSet bleTestInfoSet, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bleTestInfoSet.mWifiName;
        }
        if ((i & 2) != 0) {
            str2 = bleTestInfoSet.mWifiPassword;
        }
        return bleTestInfoSet.copy(str, str2);
    }

    @OOXIXo
    public final String component1() {
        return this.mWifiName;
    }

    @OOXIXo
    public final String component2() {
        return this.mWifiPassword;
    }

    @OOXIXo
    public final BleTestInfoSet copy(@OOXIXo String mWifiName, @OOXIXo String mWifiPassword) {
        IIX0o.x0xO0oo(mWifiName, "mWifiName");
        IIX0o.x0xO0oo(mWifiPassword, "mWifiPassword");
        return new BleTestInfoSet(mWifiName, mWifiPassword);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        char readUInt8 = readUInt8();
        do {
            char readUInt82 = readUInt8();
            if (readUInt8 != 1) {
                if (readUInt8 == 2) {
                    this.mWifiPassword = readString(readUInt82, oxoX.f29584XO);
                }
            } else {
                this.mWifiName = readString(readUInt82, oxoX.f29584XO);
            }
            readUInt8 = readUInt8();
        } while (readUInt8 > 0);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        if (this.mWifiName.length() > 0) {
            writeInt8(1);
            byte[] bytes = this.mWifiName.getBytes(oxoX.f29581II0xO0);
            IIX0o.oO(bytes, "getBytes(...)");
            writeInt8(bytes.length);
            writeString(this.mWifiName, oxoX.f29584XO);
        }
        if (this.mWifiPassword.length() > 0) {
            writeInt8(2);
            byte[] bytes2 = this.mWifiPassword.getBytes(oxoX.f29581II0xO0);
            IIX0o.oO(bytes2, "getBytes(...)");
            writeInt8(bytes2.length);
            writeString(this.mWifiPassword, oxoX.f29584XO);
        }
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleTestInfoSet)) {
            return false;
        }
        BleTestInfoSet bleTestInfoSet = (BleTestInfoSet) obj;
        return IIX0o.Oxx0IOOO(this.mWifiName, bleTestInfoSet.mWifiName) && IIX0o.Oxx0IOOO(this.mWifiPassword, bleTestInfoSet.mWifiPassword);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        int i;
        if (this.mWifiName.length() > 0) {
            byte[] bytes = this.mWifiName.getBytes(oxoX.f29581II0xO0);
            IIX0o.oO(bytes, "getBytes(...)");
            i = 2 + bytes.length;
        } else {
            i = 0;
        }
        if (this.mWifiPassword.length() > 0) {
            byte[] bytes2 = this.mWifiPassword.getBytes(oxoX.f29581II0xO0);
            IIX0o.oO(bytes2, "getBytes(...)");
            return i + 2 + bytes2.length;
        }
        return i;
    }

    @OOXIXo
    public final String getMWifiName() {
        return this.mWifiName;
    }

    @OOXIXo
    public final String getMWifiPassword() {
        return this.mWifiPassword;
    }

    public int hashCode() {
        return (this.mWifiName.hashCode() * 31) + this.mWifiPassword.hashCode();
    }

    public final void setMWifiName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mWifiName = str;
    }

    public final void setMWifiPassword(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mWifiPassword = str;
    }

    @OOXIXo
    public String toString() {
        return "BleTestInfoSet(mWifiName=" + this.mWifiName + ", mWifiPassword=" + this.mWifiPassword + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleTestInfoSet(String str, String str2, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public BleTestInfoSet(@OOXIXo String mWifiName, @OOXIXo String mWifiPassword) {
        IIX0o.x0xO0oo(mWifiName, "mWifiName");
        IIX0o.x0xO0oo(mWifiPassword, "mWifiPassword");
        this.mWifiName = mWifiName;
        this.mWifiPassword = mWifiPassword;
    }
}
