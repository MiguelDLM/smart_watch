package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleFilePath extends BleReadable {
    private int mAttribute;

    @OOXIXo
    private String mName;
    private int mSize;

    public BleFilePath() {
        this(0, 0, null, 7, null);
    }

    public static /* synthetic */ BleFilePath copy$default(BleFilePath bleFilePath, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bleFilePath.mSize;
        }
        if ((i3 & 2) != 0) {
            i2 = bleFilePath.mAttribute;
        }
        if ((i3 & 4) != 0) {
            str = bleFilePath.mName;
        }
        return bleFilePath.copy(i, i2, str);
    }

    public final int component1() {
        return this.mSize;
    }

    public final int component2() {
        return this.mAttribute;
    }

    @OOXIXo
    public final String component3() {
        return this.mName;
    }

    @OOXIXo
    public final BleFilePath copy(int i, int i2, @OOXIXo String mName) {
        IIX0o.x0xO0oo(mName, "mName");
        return new BleFilePath(i, i2, mName);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        boolean z;
        super.decode();
        if (getMBytes() != null) {
            byte[] mBytes = getMBytes();
            IIX0o.ooOOo0oXI(mBytes);
            if (mBytes.length == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
                IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
                this.mSize = readInt32(LITTLE_ENDIAN);
                this.mAttribute = readInt8();
                this.mName = BleReadable.readStringUtil$default(this, (byte) 0, null, 2, null);
            }
        }
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleFilePath)) {
            return false;
        }
        BleFilePath bleFilePath = (BleFilePath) obj;
        return this.mSize == bleFilePath.mSize && this.mAttribute == bleFilePath.mAttribute && IIX0o.Oxx0IOOO(this.mName, bleFilePath.mName);
    }

    public final int getMAttribute() {
        return this.mAttribute;
    }

    @OOXIXo
    public final String getMName() {
        return this.mName;
    }

    public final int getMSize() {
        return this.mSize;
    }

    public int hashCode() {
        return (((this.mSize * 31) + this.mAttribute) * 31) + this.mName.hashCode();
    }

    public final void setMAttribute(int i) {
        this.mAttribute = i;
    }

    public final void setMName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mName = str;
    }

    public final void setMSize(int i) {
        this.mSize = i;
    }

    @OOXIXo
    public String toString() {
        return "BleFilePath(mSize='" + this.mSize + "', mAttribute='" + this.mAttribute + "', mName='" + this.mName + "')";
    }

    public /* synthetic */ BleFilePath(int i, int i2, String str, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? "" : str);
    }

    public BleFilePath(int i, int i2, @OOXIXo String mName) {
        IIX0o.x0xO0oo(mName, "mName");
        this.mSize = i;
        this.mAttribute = i2;
        this.mName = mName;
    }
}
