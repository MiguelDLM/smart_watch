package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.kuaishou.weapon.p0.bq;
import com.tenmeter.smlibrary.utils.FileUtils;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleLanguagePackVersion extends BleReadable {
    private int mLanguageCode;

    @OOXIXo
    private String mVersion;

    /* JADX WARN: Multi-variable type inference failed */
    public BleLanguagePackVersion() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleLanguagePackVersion copy$default(BleLanguagePackVersion bleLanguagePackVersion, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bleLanguagePackVersion.mVersion;
        }
        if ((i2 & 2) != 0) {
            i = bleLanguagePackVersion.mLanguageCode;
        }
        return bleLanguagePackVersion.copy(str, i);
    }

    @OOXIXo
    public final String component1() {
        return this.mVersion;
    }

    public final int component2() {
        return this.mLanguageCode;
    }

    @OOXIXo
    public final BleLanguagePackVersion copy(@OOXIXo String mVersion, int i) {
        IIX0o.x0xO0oo(mVersion, "mVersion");
        return new BleLanguagePackVersion(mVersion, i);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        if (getMBytes() != null) {
            byte[] mBytes = getMBytes();
            IIX0o.ooOOo0oXI(mBytes);
            if (mBytes.length == 4) {
                this.mVersion = ArraysKt___ArraysKt.XoXoOo(readBytes(3), FileUtils.FILE_EXTENSION_SEPARATOR, null, null, 0, null, new oOoXoXO<Byte, CharSequence>() { // from class: com.szabh.smable3.entity.BleLanguagePackVersion$decode$1
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
                this.mLanguageCode = readUInt8();
            }
        }
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleLanguagePackVersion)) {
            return false;
        }
        BleLanguagePackVersion bleLanguagePackVersion = (BleLanguagePackVersion) obj;
        return IIX0o.Oxx0IOOO(this.mVersion, bleLanguagePackVersion.mVersion) && this.mLanguageCode == bleLanguagePackVersion.mLanguageCode;
    }

    public final int getMLanguageCode() {
        return this.mLanguageCode;
    }

    @OOXIXo
    public final String getMVersion() {
        return this.mVersion;
    }

    public int hashCode() {
        return (this.mVersion.hashCode() * 31) + this.mLanguageCode;
    }

    public final void setMLanguageCode(int i) {
        this.mLanguageCode = i;
    }

    public final void setMVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mVersion = str;
    }

    @OOXIXo
    public String toString() {
        return "BleLanguagePackVersion(mVersion=" + this.mVersion + ", mLanguageCode=" + this.mLanguageCode + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleLanguagePackVersion(String str, int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? bq.e : str, (i2 & 2) != 0 ? 1 : i);
    }

    public BleLanguagePackVersion(@OOXIXo String mVersion, int i) {
        IIX0o.x0xO0oo(mVersion, "mVersion");
        this.mVersion = mVersion;
        this.mLanguageCode = i;
    }
}
