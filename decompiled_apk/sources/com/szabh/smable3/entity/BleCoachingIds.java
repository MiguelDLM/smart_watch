package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleCoachingIds extends BleReadable {
    private int mCount;

    @OOXIXo
    private List<Integer> mIds;

    /* JADX WARN: Multi-variable type inference failed */
    public BleCoachingIds() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mIds.clear();
        byte readInt8 = readInt8();
        this.mCount = readInt8;
        for (int i = 0; i < readInt8; i++) {
            this.mIds.add(Integer.valueOf(readInt8()));
        }
    }

    public final int getMCount() {
        return this.mCount;
    }

    @OOXIXo
    public final List<Integer> getMIds() {
        return this.mIds;
    }

    public final void setMCount(int i) {
        this.mCount = i;
    }

    public final void setMIds(@OOXIXo List<Integer> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mIds = list;
    }

    @OOXIXo
    public String toString() {
        return "BleCoachingIds(mCount=" + this.mCount + ", mIds=" + this.mIds + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleCoachingIds(int i, List list, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new ArrayList() : list);
    }

    public BleCoachingIds(int i, @OOXIXo List<Integer> mIds) {
        IIX0o.x0xO0oo(mIds, "mIds");
        this.mCount = i;
        this.mIds = mIds;
    }
}
