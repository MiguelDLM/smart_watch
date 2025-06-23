package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.ByteArrayExtKt;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleAudioPacket extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 40;

    @OOXIXo
    private byte[] mData;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BleAudioPacket() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleAudioPacket copy$default(BleAudioPacket bleAudioPacket, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = bleAudioPacket.mData;
        }
        return bleAudioPacket.copy(bArr);
    }

    @OOXIXo
    public final byte[] component1() {
        return this.mData;
    }

    @OOXIXo
    public final BleAudioPacket copy(@OOXIXo byte[] mData) {
        IIX0o.x0xO0oo(mData, "mData");
        return new BleAudioPacket(mData);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        readInt8();
        readInt8();
        this.mData = readBytes(readInt8());
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BleAudioPacket) && IIX0o.Oxx0IOOO(this.mData, ((BleAudioPacket) obj).mData);
    }

    @OOXIXo
    public final byte[] getMData() {
        return this.mData;
    }

    public int hashCode() {
        return Arrays.hashCode(this.mData);
    }

    public final void setMData(@OOXIXo byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "<set-?>");
        this.mData = bArr;
    }

    @OOXIXo
    public String toString() {
        return "BleAudioPacket(mData=" + ByteArrayExtKt.getMHexString(this.mData) + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleAudioPacket(byte[] bArr, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new byte[0] : bArr);
    }

    public BleAudioPacket(@OOXIXo byte[] mData) {
        IIX0o.x0xO0oo(mData, "mData");
        this.mData = mData;
    }
}
