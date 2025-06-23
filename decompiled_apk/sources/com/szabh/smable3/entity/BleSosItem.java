package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleSosItem extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 46;
    private static final int NAME_LENGTH = 24;
    private static final int PHONE_LENGTH = 18;
    private int mEnabled;

    @OOXIXo
    private String mName;

    @OOXIXo
    private String mPhone;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleSosItem() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ BleSosItem copy$default(BleSosItem bleSosItem, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleSosItem.mEnabled;
        }
        if ((i2 & 2) != 0) {
            str = bleSosItem.mPhone;
        }
        if ((i2 & 4) != 0) {
            str2 = bleSosItem.mName;
        }
        return bleSosItem.copy(i, str, str2);
    }

    public final int component1() {
        return this.mEnabled;
    }

    @OOXIXo
    public final String component2() {
        return this.mPhone;
    }

    @OOXIXo
    public final String component3() {
        return this.mName;
    }

    @OOXIXo
    public final BleSosItem copy(int i, @OOXIXo String mPhone, @OOXIXo String mName) {
        IIX0o.x0xO0oo(mPhone, "mPhone");
        IIX0o.x0xO0oo(mName, "mName");
        return new BleSosItem(i, mPhone, mName);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mEnabled = readInt8();
        readInt8();
        readInt8();
        this.mPhone = BleReadable.readString$default(this, 18, null, 2, null);
        readInt8();
        this.mName = BleReadable.readString$default(this, 24, null, 2, null);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mEnabled);
        writeInt8(0);
        writeInt8(this.mPhone.length());
        BleWritable.writeStringWithFix$default(this, this.mPhone, 18, null, 4, null);
        writeInt8(this.mName.length());
        BleWritable.writeStringWithFix$default(this, this.mName, 24, null, 4, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleSosItem)) {
            return false;
        }
        BleSosItem bleSosItem = (BleSosItem) obj;
        return this.mEnabled == bleSosItem.mEnabled && IIX0o.Oxx0IOOO(this.mPhone, bleSosItem.mPhone) && IIX0o.Oxx0IOOO(this.mName, bleSosItem.mName);
    }

    public final int getMEnabled() {
        return this.mEnabled;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 46;
    }

    @OOXIXo
    public final String getMName() {
        return this.mName;
    }

    @OOXIXo
    public final String getMPhone() {
        return this.mPhone;
    }

    public int hashCode() {
        return (((this.mEnabled * 31) + this.mPhone.hashCode()) * 31) + this.mName.hashCode();
    }

    public final void setMEnabled(int i) {
        this.mEnabled = i;
    }

    public final void setMName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mName = str;
    }

    public final void setMPhone(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mPhone = str;
    }

    @OOXIXo
    public String toString() {
        return "BleSosItem(mEnabled=" + this.mEnabled + ", mPhone='" + this.mPhone + "', mName='" + this.mName + "')";
    }

    public /* synthetic */ BleSosItem(int i, String str, String str2, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2);
    }

    public BleSosItem(int i, @OOXIXo String mPhone, @OOXIXo String mName) {
        IIX0o.x0xO0oo(mPhone, "mPhone");
        IIX0o.x0xO0oo(mName, "mName");
        this.mEnabled = i;
        this.mPhone = mPhone;
        this.mName = mName;
    }
}
