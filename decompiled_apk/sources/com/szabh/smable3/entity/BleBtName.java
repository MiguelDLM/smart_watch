package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.oxoX;

/* loaded from: classes13.dex */
public final class BleBtName extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 31;
    private static final int NAME_LENGTH = 29;

    @OOXIXo
    private String mName;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BleBtName() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleBtName copy$default(BleBtName bleBtName, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bleBtName.mName;
        }
        return bleBtName.copy(str);
    }

    @OOXIXo
    public final String component1() {
        return this.mName;
    }

    @OOXIXo
    public final BleBtName copy(@OOXIXo String mName) {
        IIX0o.x0xO0oo(mName, "mName");
        return new BleBtName(mName);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mName.length());
        writeStringWithFix(this.mName, 29, oxoX.f29584XO);
        writeInt8(0);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BleBtName) && IIX0o.Oxx0IOOO(this.mName, ((BleBtName) obj).mName);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 31;
    }

    @OOXIXo
    public final String getMName() {
        return this.mName;
    }

    public int hashCode() {
        return this.mName.hashCode();
    }

    public final void setMName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mName = str;
    }

    @OOXIXo
    public String toString() {
        return "BleBtName(mName='" + this.mName + "')";
    }

    public /* synthetic */ BleBtName(String str, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str);
    }

    public BleBtName(@OOXIXo String mName) {
        IIX0o.x0xO0oo(mName, "mName");
        this.mName = mName;
    }
}
