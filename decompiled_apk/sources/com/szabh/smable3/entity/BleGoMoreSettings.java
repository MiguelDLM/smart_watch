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
public final class BleGoMoreSettings extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int TYPE_DEFAULT = 0;
    public static final int TYPE_LITE = 1;
    public static final int TYPE_PRO = 2;

    @OOXIXo
    private String mKey;

    @OOXIXo
    private byte[] mKeyBytes;
    private int mKeyLength;
    private int mType;

    @OOXIXo
    private String mUuid;

    @OOXIXo
    private byte[] mUuidBytes;
    private int mUuidLength;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleGoMoreSettings() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ BleGoMoreSettings copy$default(BleGoMoreSettings bleGoMoreSettings, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bleGoMoreSettings.mUuid;
        }
        if ((i2 & 2) != 0) {
            str2 = bleGoMoreSettings.mKey;
        }
        if ((i2 & 4) != 0) {
            i = bleGoMoreSettings.mType;
        }
        return bleGoMoreSettings.copy(str, str2, i);
    }

    @OOXIXo
    public final String component1() {
        return this.mUuid;
    }

    @OOXIXo
    public final String component2() {
        return this.mKey;
    }

    public final int component3() {
        return this.mType;
    }

    @OOXIXo
    public final BleGoMoreSettings copy(@OOXIXo String mUuid, @OOXIXo String mKey, int i) {
        IIX0o.x0xO0oo(mUuid, "mUuid");
        IIX0o.x0xO0oo(mKey, "mKey");
        return new BleGoMoreSettings(mUuid, mKey, i);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        char readUInt8 = readUInt8();
        this.mUuidLength = readUInt8;
        Charset charset = oxoX.f29581II0xO0;
        this.mUuid = readString(readUInt8, charset);
        char readUInt82 = readUInt8();
        this.mKeyLength = readUInt82;
        this.mKey = readString(readUInt82, charset);
        readInt8();
        this.mType = readUInt8();
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mUuidLength);
        BleWritable.writeBytes$default(this, this.mUuidBytes, null, 2, null);
        writeInt8(this.mKeyLength);
        BleWritable.writeBytes$default(this, this.mKeyBytes, null, 2, null);
        writeInt8(1);
        writeInt8(this.mType);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleGoMoreSettings)) {
            return false;
        }
        BleGoMoreSettings bleGoMoreSettings = (BleGoMoreSettings) obj;
        return IIX0o.Oxx0IOOO(this.mUuid, bleGoMoreSettings.mUuid) && IIX0o.Oxx0IOOO(this.mKey, bleGoMoreSettings.mKey) && this.mType == bleGoMoreSettings.mType;
    }

    @OOXIXo
    public final String getMKey() {
        return this.mKey;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return this.mUuidLength + 4 + this.mKeyLength;
    }

    public final int getMType() {
        return this.mType;
    }

    @OOXIXo
    public final String getMUuid() {
        return this.mUuid;
    }

    public int hashCode() {
        return (((this.mUuid.hashCode() * 31) + this.mKey.hashCode()) * 31) + this.mType;
    }

    public final void setMKey(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mKey = str;
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
        return "BleGoMoreSettings(mUuidLength=" + this.mUuidLength + ", mUuid=" + this.mUuid + ", mKeyLength=" + this.mKeyLength + ", mKey=" + this.mKey + ", mType=" + this.mType + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleGoMoreSettings(String str, String str2, int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0 : i);
    }

    public BleGoMoreSettings(@OOXIXo String mUuid, @OOXIXo String mKey, int i) {
        IIX0o.x0xO0oo(mUuid, "mUuid");
        IIX0o.x0xO0oo(mKey, "mKey");
        this.mUuid = mUuid;
        this.mKey = mKey;
        this.mType = i;
        Charset charset = oxoX.f29581II0xO0;
        byte[] bytes = mUuid.getBytes(charset);
        IIX0o.oO(bytes, "getBytes(...)");
        this.mUuidBytes = bytes;
        this.mUuidLength = bytes.length;
        byte[] bytes2 = this.mKey.getBytes(charset);
        IIX0o.oO(bytes2, "getBytes(...)");
        this.mKeyBytes = bytes2;
        this.mKeyLength = bytes2.length;
    }
}
