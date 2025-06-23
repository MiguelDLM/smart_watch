package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.charset.Charset;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.oxoX;

/* loaded from: classes13.dex */
public final class BleTuyaKey extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 61;
    private static final int KEY_LENGTH = 32;
    private static final int MAC_LENGTH = 12;
    private static final int UUID_LENGTH = 16;

    @OOXIXo
    private String mKey;

    @OOXIXo
    private String mMac;
    private int mType;

    @OOXIXo
    private String mUuid;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleTuyaKey() {
        this(0, null, null, null, 15, null);
    }

    public static /* synthetic */ BleTuyaKey copy$default(BleTuyaKey bleTuyaKey, int i, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleTuyaKey.mType;
        }
        if ((i2 & 2) != 0) {
            str = bleTuyaKey.mUuid;
        }
        if ((i2 & 4) != 0) {
            str2 = bleTuyaKey.mKey;
        }
        if ((i2 & 8) != 0) {
            str3 = bleTuyaKey.mMac;
        }
        return bleTuyaKey.copy(i, str, str2, str3);
    }

    public final int component1() {
        return this.mType;
    }

    @OOXIXo
    public final String component2() {
        return this.mUuid;
    }

    @OOXIXo
    public final String component3() {
        return this.mKey;
    }

    @OOXIXo
    public final String component4() {
        return this.mMac;
    }

    @OOXIXo
    public final BleTuyaKey copy(int i, @OOXIXo String mUuid, @OOXIXo String mKey, @OOXIXo String mMac) {
        IIX0o.x0xO0oo(mUuid, "mUuid");
        IIX0o.x0xO0oo(mKey, "mKey");
        IIX0o.x0xO0oo(mMac, "mMac");
        return new BleTuyaKey(i, mUuid, mKey, mMac);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mType = readInt8();
        Charset charset = oxoX.f29584XO;
        this.mUuid = readString(16, charset);
        this.mKey = readString(32, charset);
        this.mMac = readString(12, charset);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mType);
        String str = this.mUuid;
        Charset charset = oxoX.f29584XO;
        writeStringWithFix(str, 16, charset);
        writeStringWithFix(this.mKey, 32, charset);
        writeStringWithFix(this.mMac, 12, charset);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleTuyaKey)) {
            return false;
        }
        BleTuyaKey bleTuyaKey = (BleTuyaKey) obj;
        return this.mType == bleTuyaKey.mType && IIX0o.Oxx0IOOO(this.mUuid, bleTuyaKey.mUuid) && IIX0o.Oxx0IOOO(this.mKey, bleTuyaKey.mKey) && IIX0o.Oxx0IOOO(this.mMac, bleTuyaKey.mMac);
    }

    @OOXIXo
    public final String getMKey() {
        return this.mKey;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 61;
    }

    @OOXIXo
    public final String getMMac() {
        return this.mMac;
    }

    public final int getMType() {
        return this.mType;
    }

    @OOXIXo
    public final String getMUuid() {
        return this.mUuid;
    }

    public int hashCode() {
        return (((((this.mType * 31) + this.mUuid.hashCode()) * 31) + this.mKey.hashCode()) * 31) + this.mMac.hashCode();
    }

    public final void setMKey(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mKey = str;
    }

    public final void setMMac(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mMac = str;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    public final void setMUuid(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mUuid = str;
    }

    @OOXIXo
    public String toString() {
        return "BleTuyaKey(key=" + this.mUuid + this.mKey + this.mMac + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleTuyaKey(int i, String str, String str2, String str3, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3);
    }

    public BleTuyaKey(int i, @OOXIXo String mUuid, @OOXIXo String mKey, @OOXIXo String mMac) {
        IIX0o.x0xO0oo(mUuid, "mUuid");
        IIX0o.x0xO0oo(mKey, "mKey");
        IIX0o.x0xO0oo(mMac, "mMac");
        this.mType = i;
        this.mUuid = mUuid;
        this.mKey = mKey;
        this.mMac = mMac;
    }
}
