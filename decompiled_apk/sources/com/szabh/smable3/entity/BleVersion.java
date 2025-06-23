package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.tenmeter.smlibrary.utils.FileUtils;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleVersion extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 3;

    @OOXIXo
    private String mVersion;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BleVersion() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleVersion copy$default(BleVersion bleVersion, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bleVersion.mVersion;
        }
        return bleVersion.copy(str);
    }

    @OOXIXo
    public final String component1() {
        return this.mVersion;
    }

    @OOXIXo
    public final BleVersion copy(@OOXIXo String mVersion) {
        IIX0o.x0xO0oo(mVersion, "mVersion");
        return new BleVersion(mVersion);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        String str;
        super.decode();
        byte[] mBytes = getMBytes();
        if (mBytes == null || (str = ArraysKt___ArraysKt.XoXoOo(mBytes, FileUtils.FILE_EXTENSION_SEPARATOR, null, null, 0, null, new oOoXoXO<Byte, CharSequence>() { // from class: com.szabh.smable3.entity.BleVersion$decode$1
            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ CharSequence invoke(Byte b) {
                return invoke(b.byteValue());
            }

            @OOXIXo
            public final CharSequence invoke(byte b) {
                int i = b & 255;
                return i > 9 ? "0" : String.valueOf(i);
            }
        }, 30, null)) == null) {
            str = "";
        }
        this.mVersion = str;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BleVersion) && IIX0o.Oxx0IOOO(this.mVersion, ((BleVersion) obj).mVersion);
    }

    @OOXIXo
    public final String getMVersion() {
        return this.mVersion;
    }

    public int hashCode() {
        return this.mVersion.hashCode();
    }

    public final void setMVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mVersion = str;
    }

    @OOXIXo
    public String toString() {
        return "BleVersion(mVersion=" + this.mVersion + HexStringBuilder.COMMENT_END_CHAR;
    }

    public BleVersion(@OOXIXo String mVersion) {
        IIX0o.x0xO0oo(mVersion, "mVersion");
        this.mVersion = mVersion;
    }

    public /* synthetic */ BleVersion(String str, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str);
    }
}
