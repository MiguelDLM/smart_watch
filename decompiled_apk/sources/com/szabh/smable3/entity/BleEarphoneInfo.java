package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.kuaishou.weapon.p0.bq;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.Locale;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleEarphoneInfo extends BleReadable {

    @OOXIXo
    private String mBleAddress;

    @OOXIXo
    private String mBleName;

    @OOXIXo
    private String mFirmwareFlag;

    @OOXIXo
    private String mFirmwareVersion;

    public BleEarphoneInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ BleEarphoneInfo copy$default(BleEarphoneInfo bleEarphoneInfo, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bleEarphoneInfo.mBleAddress;
        }
        if ((i & 2) != 0) {
            str2 = bleEarphoneInfo.mFirmwareVersion;
        }
        if ((i & 4) != 0) {
            str3 = bleEarphoneInfo.mBleName;
        }
        if ((i & 8) != 0) {
            str4 = bleEarphoneInfo.mFirmwareFlag;
        }
        return bleEarphoneInfo.copy(str, str2, str3, str4);
    }

    private final String toVersion(byte[] bArr, CharSequence charSequence) {
        return ArraysKt___ArraysKt.XoXoOo(bArr, charSequence, null, null, 0, null, new oOoXoXO<Byte, CharSequence>() { // from class: com.szabh.smable3.entity.BleEarphoneInfo$toVersion$1
            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ CharSequence invoke(Byte b) {
                return invoke(b.byteValue());
            }

            @OOXIXo
            public final CharSequence invoke(byte b) {
                int i = b & 255;
                return i > 9 ? "0" : String.valueOf(i);
            }
        }, 30, null);
    }

    @OOXIXo
    public final String component1() {
        return this.mBleAddress;
    }

    @OOXIXo
    public final String component2() {
        return this.mFirmwareVersion;
    }

    @OOXIXo
    public final String component3() {
        return this.mBleName;
    }

    @OOXIXo
    public final String component4() {
        return this.mFirmwareFlag;
    }

    @OOXIXo
    public final BleEarphoneInfo copy(@OOXIXo String mBleAddress, @OOXIXo String mFirmwareVersion, @OOXIXo String mBleName, @OOXIXo String mFirmwareFlag) {
        IIX0o.x0xO0oo(mBleAddress, "mBleAddress");
        IIX0o.x0xO0oo(mFirmwareVersion, "mFirmwareVersion");
        IIX0o.x0xO0oo(mBleName, "mBleName");
        IIX0o.x0xO0oo(mFirmwareFlag, "mFirmwareFlag");
        return new BleEarphoneInfo(mBleAddress, mFirmwareVersion, mBleName, mFirmwareFlag);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        String readStringUtil$default = BleReadable.readStringUtil$default(this, (byte) 0, null, 2, null);
        Locale locale = Locale.getDefault();
        IIX0o.oO(locale, "getDefault(...)");
        String upperCase = readStringUtil$default.toUpperCase(locale);
        IIX0o.oO(upperCase, "toUpperCase(...)");
        this.mBleAddress = upperCase;
        this.mFirmwareVersion = toVersion(readBytes(3), FileUtils.FILE_EXTENSION_SEPARATOR);
        this.mBleName = BleReadable.readStringUtil$default(this, (byte) 0, null, 2, null);
        this.mFirmwareFlag = BleReadable.readStringUtil$default(this, (byte) 0, null, 2, null);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleEarphoneInfo)) {
            return false;
        }
        BleEarphoneInfo bleEarphoneInfo = (BleEarphoneInfo) obj;
        return IIX0o.Oxx0IOOO(this.mBleAddress, bleEarphoneInfo.mBleAddress) && IIX0o.Oxx0IOOO(this.mFirmwareVersion, bleEarphoneInfo.mFirmwareVersion) && IIX0o.Oxx0IOOO(this.mBleName, bleEarphoneInfo.mBleName) && IIX0o.Oxx0IOOO(this.mFirmwareFlag, bleEarphoneInfo.mFirmwareFlag);
    }

    @OOXIXo
    public final String getMBleAddress() {
        return this.mBleAddress;
    }

    @OOXIXo
    public final String getMBleName() {
        return this.mBleName;
    }

    @OOXIXo
    public final String getMFirmwareFlag() {
        return this.mFirmwareFlag;
    }

    @OOXIXo
    public final String getMFirmwareVersion() {
        return this.mFirmwareVersion;
    }

    public int hashCode() {
        return (((((this.mBleAddress.hashCode() * 31) + this.mFirmwareVersion.hashCode()) * 31) + this.mBleName.hashCode()) * 31) + this.mFirmwareFlag.hashCode();
    }

    public final void setMBleAddress(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mBleAddress = str;
    }

    public final void setMBleName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mBleName = str;
    }

    public final void setMFirmwareFlag(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mFirmwareFlag = str;
    }

    public final void setMFirmwareVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mFirmwareVersion = str;
    }

    @OOXIXo
    public String toString() {
        return "BleEarphoneInfo(mBleName='" + this.mBleName + "', mBleAddress='" + this.mBleAddress + "', mFirmwareVersion='" + this.mFirmwareVersion + "', mFirmwareFlag='" + this.mFirmwareFlag + "')";
    }

    public /* synthetic */ BleEarphoneInfo(String str, String str2, String str3, String str4, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? bq.e : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }

    public BleEarphoneInfo(@OOXIXo String mBleAddress, @OOXIXo String mFirmwareVersion, @OOXIXo String mBleName, @OOXIXo String mFirmwareFlag) {
        IIX0o.x0xO0oo(mBleAddress, "mBleAddress");
        IIX0o.x0xO0oo(mFirmwareVersion, "mFirmwareVersion");
        IIX0o.x0xO0oo(mBleName, "mBleName");
        IIX0o.x0xO0oo(mFirmwareFlag, "mFirmwareFlag");
        this.mBleAddress = mBleAddress;
        this.mFirmwareVersion = mFirmwareVersion;
        this.mBleName = mBleName;
        this.mFirmwareFlag = mFirmwareFlag;
    }
}
