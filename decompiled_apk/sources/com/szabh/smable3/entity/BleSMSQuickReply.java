package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleSMSQuickReply extends BleWritable {
    private int mId;

    @OOXIXo
    private String mPhone;

    /* JADX WARN: Multi-variable type inference failed */
    public BleSMSQuickReply() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleSMSQuickReply copy$default(BleSMSQuickReply bleSMSQuickReply, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleSMSQuickReply.mId;
        }
        if ((i2 & 2) != 0) {
            str = bleSMSQuickReply.mPhone;
        }
        return bleSMSQuickReply.copy(i, str);
    }

    public final int component1() {
        return this.mId;
    }

    @OOXIXo
    public final String component2() {
        return this.mPhone;
    }

    @OOXIXo
    public final BleSMSQuickReply copy(int i, @OOXIXo String mPhone) {
        IIX0o.x0xO0oo(mPhone, "mPhone");
        return new BleSMSQuickReply(i, mPhone);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mId = readUInt8();
        this.mPhone = BleReadable.readString$default(this, 32, null, 2, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleSMSQuickReply)) {
            return false;
        }
        BleSMSQuickReply bleSMSQuickReply = (BleSMSQuickReply) obj;
        return this.mId == bleSMSQuickReply.mId && IIX0o.Oxx0IOOO(this.mPhone, bleSMSQuickReply.mPhone);
    }

    public final int getMId() {
        return this.mId;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 33;
    }

    @OOXIXo
    public final String getMPhone() {
        return this.mPhone;
    }

    public int hashCode() {
        return (this.mId * 31) + this.mPhone.hashCode();
    }

    public final void setMId(int i) {
        this.mId = i;
    }

    public final void setMPhone(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mPhone = str;
    }

    @OOXIXo
    public String toString() {
        return "BleSMSQuickReply(mId=" + this.mId + ", mPhone='" + this.mPhone + "')";
    }

    public /* synthetic */ BleSMSQuickReply(int i, String str, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str);
    }

    public BleSMSQuickReply(int i, @OOXIXo String mPhone) {
        IIX0o.x0xO0oo(mPhone, "mPhone");
        this.mId = i;
        this.mPhone = mPhone;
    }
}
