package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.oxoX;

/* loaded from: classes13.dex */
public final class BleContactSortItem extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 4;

    @OOXIXo
    private String mCat;
    private int mSize;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BleContactSortItem() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleContactSortItem copy$default(BleContactSortItem bleContactSortItem, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bleContactSortItem.mCat;
        }
        if ((i2 & 2) != 0) {
            i = bleContactSortItem.mSize;
        }
        return bleContactSortItem.copy(str, i);
    }

    @OOXIXo
    public final String component1() {
        return this.mCat;
    }

    public final int component2() {
        return this.mSize;
    }

    @OOXIXo
    public final BleContactSortItem copy(@OOXIXo String mCat, int i) {
        IIX0o.x0xO0oo(mCat, "mCat");
        return new BleContactSortItem(mCat, i);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeStringWithFix(this.mCat, 2, oxoX.f29583X0o0xo);
        int i = this.mSize;
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt16(i, LITTLE_ENDIAN);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleContactSortItem)) {
            return false;
        }
        BleContactSortItem bleContactSortItem = (BleContactSortItem) obj;
        return IIX0o.Oxx0IOOO(this.mCat, bleContactSortItem.mCat) && this.mSize == bleContactSortItem.mSize;
    }

    @OOXIXo
    public final String getMCat() {
        return this.mCat;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 4;
    }

    public final int getMSize() {
        return this.mSize;
    }

    public int hashCode() {
        return (this.mCat.hashCode() * 31) + this.mSize;
    }

    public final void setMCat(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mCat = str;
    }

    public final void setMSize(int i) {
        this.mSize = i;
    }

    @OOXIXo
    public String toString() {
        return "BleContactSortItem(mCat=" + this.mCat + ", mSize=" + this.mSize + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleContactSortItem(String str, int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i);
    }

    public BleContactSortItem(@OOXIXo String mCat, int i) {
        IIX0o.x0xO0oo(mCat, "mCat");
        this.mCat = mCat;
        this.mSize = i;
    }
}
