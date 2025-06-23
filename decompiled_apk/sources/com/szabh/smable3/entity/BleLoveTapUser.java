package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleLoveTapUser extends BleIdObject {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 28;
    private static final int NAME_LENGTH = 24;

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
    public BleLoveTapUser() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleLoveTapUser copy$default(BleLoveTapUser bleLoveTapUser, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bleLoveTapUser.mName;
        }
        return bleLoveTapUser.copy(str);
    }

    @OOXIXo
    public final String component1() {
        return this.mName;
    }

    @OOXIXo
    public final BleLoveTapUser copy(@OOXIXo String mName) {
        IIX0o.x0xO0oo(mName, "mName");
        return new BleLoveTapUser(mName);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        setMId(readUInt8());
        BleReadable.readInt24$default(this, null, 1, null);
        this.mName = BleReadable.readString$default(this, 24, null, 2, null);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(getMId());
        BleWritable.writeInt24$default(this, 0, null, 2, null);
        BleWritable.writeStringWithFix$default(this, this.mName, 24, null, 4, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BleLoveTapUser) && IIX0o.Oxx0IOOO(this.mName, ((BleLoveTapUser) obj).mName);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 28;
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
        return "BleLoveTapUser(mId=" + getMId() + ", mName='" + this.mName + "')";
    }

    public /* synthetic */ BleLoveTapUser(String str, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str);
    }

    public BleLoveTapUser(@OOXIXo String mName) {
        IIX0o.x0xO0oo(mName, "mName");
        this.mName = mName;
    }
}
