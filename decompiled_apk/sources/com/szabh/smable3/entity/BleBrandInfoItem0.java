package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.oxoX;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes13.dex */
public final class BleBrandInfoItem0 extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 128;
    private static final int NAME_LENGTH = 126;

    @OOXIXo
    private String mBleName;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BleBrandInfoItem0() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleBrandInfoItem0 copy$default(BleBrandInfoItem0 bleBrandInfoItem0, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bleBrandInfoItem0.mBleName;
        }
        return bleBrandInfoItem0.copy(str);
    }

    @OOXIXo
    public final String component1() {
        return this.mBleName;
    }

    @OOXIXo
    public final BleBrandInfoItem0 copy(@OOXIXo String mBleName) {
        IIX0o.x0xO0oo(mBleName, "mBleName");
        return new BleBrandInfoItem0(mBleName);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(Math.min(this.mBleName.length(), 126) + 1);
        writeStringWithFix(this.mBleName, 126, oxoX.f29584XO);
        writeInt8(0);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BleBrandInfoItem0) && IIX0o.Oxx0IOOO(this.mBleName, ((BleBrandInfoItem0) obj).mBleName);
    }

    @OOXIXo
    public final String getMBleName() {
        return this.mBleName;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 128;
    }

    public int hashCode() {
        return this.mBleName.hashCode();
    }

    public final void setMBleName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mBleName = str;
    }

    @OOXIXo
    public String toString() {
        return "BleBrandInfoItem0(mBleName=" + this.mBleName + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleBrandInfoItem0(String str, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str);
    }

    public BleBrandInfoItem0(@OOXIXo String mBleName) {
        IIX0o.x0xO0oo(mBleName, "mBleName");
        this.mBleName = mBleName;
    }
}
