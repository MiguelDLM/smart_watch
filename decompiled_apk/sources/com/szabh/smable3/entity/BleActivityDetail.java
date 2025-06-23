package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleActivityDetail extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int TYPE_CAL = 1;
    public static final int TYPE_DISTANCE = 2;
    public static final int TYPE_STEP = 0;

    @OOXIXo
    private List<Integer> mList;
    private int mType;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BleActivityDetail() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BleActivityDetail copy$default(BleActivityDetail bleActivityDetail, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleActivityDetail.mType;
        }
        if ((i2 & 2) != 0) {
            list = bleActivityDetail.mList;
        }
        return bleActivityDetail.copy(i, list);
    }

    public final int component1() {
        return this.mType;
    }

    @OOXIXo
    public final List<Integer> component2() {
        return this.mList;
    }

    @OOXIXo
    public final BleActivityDetail copy(int i, @OOXIXo List<Integer> mList) {
        IIX0o.x0xO0oo(mList, "mList");
        return new BleActivityDetail(i, mList);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mType = readUInt8();
        BleReadable.readInt24$default(this, null, 1, null);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 24; i++) {
            ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
            IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
            arrayList.add(Integer.valueOf(readUInt16(LITTLE_ENDIAN)));
        }
        this.mList = arrayList;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleActivityDetail)) {
            return false;
        }
        BleActivityDetail bleActivityDetail = (BleActivityDetail) obj;
        return this.mType == bleActivityDetail.mType && IIX0o.Oxx0IOOO(this.mList, bleActivityDetail.mList);
    }

    @OOXIXo
    public final List<Integer> getMList() {
        return this.mList;
    }

    public final int getMType() {
        return this.mType;
    }

    public int hashCode() {
        return (this.mType * 31) + this.mList.hashCode();
    }

    public final void setMList(@OOXIXo List<Integer> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mList = list;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    @OOXIXo
    public String toString() {
        return "BleActivityDetail(mType=" + this.mType + ", mList=" + this.mList + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleActivityDetail(int i, List list, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list);
    }

    public BleActivityDetail(int i, @OOXIXo List<Integer> mList) {
        IIX0o.x0xO0oo(mList, "mList");
        this.mType = i;
        this.mList = mList;
    }
}
