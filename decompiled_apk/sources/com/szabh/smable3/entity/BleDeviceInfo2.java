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
public final class BleDeviceInfo2 extends BleReadable {

    @OOXIXo
    private String mBleAddress;

    @OOXIXo
    private String mBleName;

    @OOXIXo
    private String mClassicAddress;

    @OOXIXo
    private String mFirmwareFlag;

    @OOXIXo
    private String mFirmwareVersion;

    @OOXIXo
    private String mFullVersion;
    private int mLanguageCode;

    @OOXIXo
    private String mLanguageVersion;

    @OOXIXo
    private String mPlatform;

    @OOXIXo
    private String mPrototype;

    @OOXIXo
    private String mUiVersion;

    public BleDeviceInfo2() {
        this(null, null, null, null, null, 0, null, null, null, null, null, 2047, null);
    }

    private final String toVersion(byte[] bArr, CharSequence charSequence) {
        return ArraysKt___ArraysKt.XoXoOo(bArr, charSequence, null, null, 0, null, new oOoXoXO<Byte, CharSequence>() { // from class: com.szabh.smable3.entity.BleDeviceInfo2$toVersion$1
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
    public final String component10() {
        return this.mFirmwareFlag;
    }

    @OOXIXo
    public final String component11() {
        return this.mFullVersion;
    }

    @OOXIXo
    public final String component2() {
        return this.mClassicAddress;
    }

    @OOXIXo
    public final String component3() {
        return this.mFirmwareVersion;
    }

    @OOXIXo
    public final String component4() {
        return this.mUiVersion;
    }

    @OOXIXo
    public final String component5() {
        return this.mLanguageVersion;
    }

    public final int component6() {
        return this.mLanguageCode;
    }

    @OOXIXo
    public final String component7() {
        return this.mBleName;
    }

    @OOXIXo
    public final String component8() {
        return this.mPlatform;
    }

    @OOXIXo
    public final String component9() {
        return this.mPrototype;
    }

    @OOXIXo
    public final BleDeviceInfo2 copy(@OOXIXo String mBleAddress, @OOXIXo String mClassicAddress, @OOXIXo String mFirmwareVersion, @OOXIXo String mUiVersion, @OOXIXo String mLanguageVersion, int i, @OOXIXo String mBleName, @OOXIXo String mPlatform, @OOXIXo String mPrototype, @OOXIXo String mFirmwareFlag, @OOXIXo String mFullVersion) {
        IIX0o.x0xO0oo(mBleAddress, "mBleAddress");
        IIX0o.x0xO0oo(mClassicAddress, "mClassicAddress");
        IIX0o.x0xO0oo(mFirmwareVersion, "mFirmwareVersion");
        IIX0o.x0xO0oo(mUiVersion, "mUiVersion");
        IIX0o.x0xO0oo(mLanguageVersion, "mLanguageVersion");
        IIX0o.x0xO0oo(mBleName, "mBleName");
        IIX0o.x0xO0oo(mPlatform, "mPlatform");
        IIX0o.x0xO0oo(mPrototype, "mPrototype");
        IIX0o.x0xO0oo(mFirmwareFlag, "mFirmwareFlag");
        IIX0o.x0xO0oo(mFullVersion, "mFullVersion");
        return new BleDeviceInfo2(mBleAddress, mClassicAddress, mFirmwareVersion, mUiVersion, mLanguageVersion, i, mBleName, mPlatform, mPrototype, mFirmwareFlag, mFullVersion);
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
        String readStringUtil$default2 = BleReadable.readStringUtil$default(this, (byte) 0, null, 2, null);
        Locale locale2 = Locale.getDefault();
        IIX0o.oO(locale2, "getDefault(...)");
        String upperCase2 = readStringUtil$default2.toUpperCase(locale2);
        IIX0o.oO(upperCase2, "toUpperCase(...)");
        this.mClassicAddress = upperCase2;
        this.mFirmwareVersion = toVersion(readBytes(3), FileUtils.FILE_EXTENSION_SEPARATOR);
        this.mUiVersion = toVersion(readBytes(3), FileUtils.FILE_EXTENSION_SEPARATOR);
        this.mLanguageVersion = toVersion(readBytes(3), FileUtils.FILE_EXTENSION_SEPARATOR);
        this.mLanguageCode = readUInt8();
        this.mBleName = BleReadable.readStringUtil$default(this, (byte) 0, null, 2, null);
        this.mPlatform = BleReadable.readStringUtil$default(this, (byte) 0, null, 2, null);
        this.mPrototype = BleReadable.readStringUtil$default(this, (byte) 0, null, 2, null);
        this.mFirmwareFlag = BleReadable.readStringUtil$default(this, (byte) 0, null, 2, null);
        this.mFullVersion = BleReadable.readStringUtil$default(this, (byte) 0, null, 2, null);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleDeviceInfo2)) {
            return false;
        }
        BleDeviceInfo2 bleDeviceInfo2 = (BleDeviceInfo2) obj;
        return IIX0o.Oxx0IOOO(this.mBleAddress, bleDeviceInfo2.mBleAddress) && IIX0o.Oxx0IOOO(this.mClassicAddress, bleDeviceInfo2.mClassicAddress) && IIX0o.Oxx0IOOO(this.mFirmwareVersion, bleDeviceInfo2.mFirmwareVersion) && IIX0o.Oxx0IOOO(this.mUiVersion, bleDeviceInfo2.mUiVersion) && IIX0o.Oxx0IOOO(this.mLanguageVersion, bleDeviceInfo2.mLanguageVersion) && this.mLanguageCode == bleDeviceInfo2.mLanguageCode && IIX0o.Oxx0IOOO(this.mBleName, bleDeviceInfo2.mBleName) && IIX0o.Oxx0IOOO(this.mPlatform, bleDeviceInfo2.mPlatform) && IIX0o.Oxx0IOOO(this.mPrototype, bleDeviceInfo2.mPrototype) && IIX0o.Oxx0IOOO(this.mFirmwareFlag, bleDeviceInfo2.mFirmwareFlag) && IIX0o.Oxx0IOOO(this.mFullVersion, bleDeviceInfo2.mFullVersion);
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
    public final String getMClassicAddress() {
        return this.mClassicAddress;
    }

    @OOXIXo
    public final String getMFirmwareFlag() {
        return this.mFirmwareFlag;
    }

    @OOXIXo
    public final String getMFirmwareVersion() {
        return this.mFirmwareVersion;
    }

    @OOXIXo
    public final String getMFullVersion() {
        return this.mFullVersion;
    }

    public final int getMLanguageCode() {
        return this.mLanguageCode;
    }

    @OOXIXo
    public final String getMLanguageVersion() {
        return this.mLanguageVersion;
    }

    @OOXIXo
    public final String getMPlatform() {
        return this.mPlatform;
    }

    @OOXIXo
    public final String getMPrototype() {
        return this.mPrototype;
    }

    @OOXIXo
    public final String getMUiVersion() {
        return this.mUiVersion;
    }

    public int hashCode() {
        return (((((((((((((((((((this.mBleAddress.hashCode() * 31) + this.mClassicAddress.hashCode()) * 31) + this.mFirmwareVersion.hashCode()) * 31) + this.mUiVersion.hashCode()) * 31) + this.mLanguageVersion.hashCode()) * 31) + this.mLanguageCode) * 31) + this.mBleName.hashCode()) * 31) + this.mPlatform.hashCode()) * 31) + this.mPrototype.hashCode()) * 31) + this.mFirmwareFlag.hashCode()) * 31) + this.mFullVersion.hashCode();
    }

    public final void setMBleAddress(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mBleAddress = str;
    }

    public final void setMBleName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mBleName = str;
    }

    public final void setMClassicAddress(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mClassicAddress = str;
    }

    public final void setMFirmwareFlag(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mFirmwareFlag = str;
    }

    public final void setMFirmwareVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mFirmwareVersion = str;
    }

    public final void setMFullVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mFullVersion = str;
    }

    public final void setMLanguageCode(int i) {
        this.mLanguageCode = i;
    }

    public final void setMLanguageVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mLanguageVersion = str;
    }

    public final void setMPlatform(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mPlatform = str;
    }

    public final void setMPrototype(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mPrototype = str;
    }

    public final void setMUiVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mUiVersion = str;
    }

    @OOXIXo
    public String toString() {
        return "BleDeviceInfo2(mBleName='" + this.mBleName + "', mBleAddress='" + this.mBleAddress + "', mClassicAddress='" + this.mClassicAddress + "', mFirmwareVersion='" + this.mFirmwareVersion + "', mUiVersion='" + this.mUiVersion + "', mLanguageVersion='" + this.mLanguageVersion + "', mLanguageCode='" + this.mLanguageCode + "', mPlatform='" + this.mPlatform + "', mPrototype='" + this.mPrototype + "', mFirmwareFlag='" + this.mFirmwareFlag + "', mFullVersion='" + this.mFullVersion + "')";
    }

    public /* synthetic */ BleDeviceInfo2(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8, String str9, String str10, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? bq.e : str3, (i2 & 8) != 0 ? bq.e : str4, (i2 & 16) == 0 ? str5 : bq.e, (i2 & 32) != 0 ? 1 : i, (i2 & 64) != 0 ? "" : str6, (i2 & 128) != 0 ? "" : str7, (i2 & 256) != 0 ? "" : str8, (i2 & 512) != 0 ? "" : str9, (i2 & 1024) == 0 ? str10 : "");
    }

    public BleDeviceInfo2(@OOXIXo String mBleAddress, @OOXIXo String mClassicAddress, @OOXIXo String mFirmwareVersion, @OOXIXo String mUiVersion, @OOXIXo String mLanguageVersion, int i, @OOXIXo String mBleName, @OOXIXo String mPlatform, @OOXIXo String mPrototype, @OOXIXo String mFirmwareFlag, @OOXIXo String mFullVersion) {
        IIX0o.x0xO0oo(mBleAddress, "mBleAddress");
        IIX0o.x0xO0oo(mClassicAddress, "mClassicAddress");
        IIX0o.x0xO0oo(mFirmwareVersion, "mFirmwareVersion");
        IIX0o.x0xO0oo(mUiVersion, "mUiVersion");
        IIX0o.x0xO0oo(mLanguageVersion, "mLanguageVersion");
        IIX0o.x0xO0oo(mBleName, "mBleName");
        IIX0o.x0xO0oo(mPlatform, "mPlatform");
        IIX0o.x0xO0oo(mPrototype, "mPrototype");
        IIX0o.x0xO0oo(mFirmwareFlag, "mFirmwareFlag");
        IIX0o.x0xO0oo(mFullVersion, "mFullVersion");
        this.mBleAddress = mBleAddress;
        this.mClassicAddress = mClassicAddress;
        this.mFirmwareVersion = mFirmwareVersion;
        this.mUiVersion = mUiVersion;
        this.mLanguageVersion = mLanguageVersion;
        this.mLanguageCode = i;
        this.mBleName = mBleName;
        this.mPlatform = mPlatform;
        this.mPrototype = mPrototype;
        this.mFirmwareFlag = mFirmwareFlag;
        this.mFullVersion = mFullVersion;
    }
}
