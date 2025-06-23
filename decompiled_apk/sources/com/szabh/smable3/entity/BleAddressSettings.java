package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Arrays;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleAddressSettings extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 6;

    @OOXIXo
    private byte[] mAddress;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BleAddressSettings() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleAddressSettings copy$default(BleAddressSettings bleAddressSettings, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = bleAddressSettings.mAddress;
        }
        return bleAddressSettings.copy(bArr);
    }

    @OOXIXo
    public final byte[] component1() {
        return this.mAddress;
    }

    @OOXIXo
    public final BleAddressSettings copy(@OOXIXo byte[] mAddress) {
        IIX0o.x0xO0oo(mAddress, "mAddress");
        return new BleAddressSettings(mAddress);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        BleWritable.writeBytes$default(this, ArraysKt___ArraysKt.OXXO(this.mAddress), null, 2, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BleAddressSettings) && IIX0o.Oxx0IOOO(this.mAddress, ((BleAddressSettings) obj).mAddress);
    }

    @OOXIXo
    public final byte[] getMAddress() {
        return this.mAddress;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 6;
    }

    public int hashCode() {
        return Arrays.hashCode(this.mAddress);
    }

    public final void setMAddress(@OOXIXo byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "<set-?>");
        this.mAddress = bArr;
    }

    @OOXIXo
    public String toString() {
        return "BleAddressSettings(mAddress=" + Arrays.toString(this.mAddress) + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleAddressSettings(byte[] bArr, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new byte[6] : bArr);
    }

    public BleAddressSettings(@OOXIXo byte[] mAddress) {
        IIX0o.x0xO0oo(mAddress, "mAddress");
        this.mAddress = mAddress;
    }
}
