package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.oxxXoxO;

/* loaded from: classes13.dex */
public final class BleBleAddress extends BleReadable {

    @OOXIXo
    private String mAddress;

    /* JADX WARN: Multi-variable type inference failed */
    public BleBleAddress() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleBleAddress copy$default(BleBleAddress bleBleAddress, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bleBleAddress.mAddress;
        }
        return bleBleAddress.copy(str);
    }

    @OOXIXo
    public final String component1() {
        return this.mAddress;
    }

    @OOXIXo
    public final BleBleAddress copy(@OOXIXo String mAddress) {
        IIX0o.x0xO0oo(mAddress, "mAddress");
        return new BleBleAddress(mAddress);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        if (getMBytes() != null) {
            byte[] mBytes = getMBytes();
            IIX0o.ooOOo0oXI(mBytes);
            if (mBytes.length >= 6) {
                oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                String format = String.format("%02X:%02X:%02X:%02X:%02X:%02X", Arrays.copyOf(new Object[]{Byte.valueOf(readInt8()), Byte.valueOf(readInt8()), Byte.valueOf(readInt8()), Byte.valueOf(readInt8()), Byte.valueOf(readInt8()), Byte.valueOf(readInt8())}, 6));
                IIX0o.oO(format, "format(...)");
                this.mAddress = format;
            }
        }
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BleBleAddress) && IIX0o.Oxx0IOOO(this.mAddress, ((BleBleAddress) obj).mAddress);
    }

    @OOXIXo
    public final String getMAddress() {
        return this.mAddress;
    }

    public int hashCode() {
        return this.mAddress.hashCode();
    }

    public final void setMAddress(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mAddress = str;
    }

    @OOXIXo
    public String toString() {
        return "BleBleAddress(mAddress=" + this.mAddress + HexStringBuilder.COMMENT_END_CHAR;
    }

    public BleBleAddress(@OOXIXo String mAddress) {
        IIX0o.x0xO0oo(mAddress, "mAddress");
        this.mAddress = mAddress;
    }

    public /* synthetic */ BleBleAddress(String str, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str);
    }
}
