package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleMeasurementPPG extends BleReadable {

    @OOXIXo
    private List<Integer> mPpgData;

    /* JADX WARN: Multi-variable type inference failed */
    public BleMeasurementPPG() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BleMeasurementPPG copy$default(BleMeasurementPPG bleMeasurementPPG, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = bleMeasurementPPG.mPpgData;
        }
        return bleMeasurementPPG.copy(list);
    }

    @OOXIXo
    public final List<Integer> component1() {
        return this.mPpgData;
    }

    @OOXIXo
    public final BleMeasurementPPG copy(@OOXIXo List<Integer> mPpgData) {
        IIX0o.x0xO0oo(mPpgData, "mPpgData");
        return new BleMeasurementPPG(mPpgData);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        int i;
        super.decode();
        try {
            byte[] mBytes = getMBytes();
            if (mBytes != null) {
                i = mBytes.length;
            } else {
                i = 0;
            }
            int i2 = i / 4;
            for (int i3 = 0; i3 < i2; i3++) {
                List<Integer> list = this.mPpgData;
                ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
                IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
                list.add(Integer.valueOf(readInt32(LITTLE_ENDIAN)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BleMeasurementPPG) && IIX0o.Oxx0IOOO(this.mPpgData, ((BleMeasurementPPG) obj).mPpgData);
    }

    @OOXIXo
    public final List<Integer> getMPpgData() {
        return this.mPpgData;
    }

    public int hashCode() {
        return this.mPpgData.hashCode();
    }

    public final void setMPpgData(@OOXIXo List<Integer> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mPpgData = list;
    }

    @OOXIXo
    public String toString() {
        return "BleMeasurementPPG(mSize=" + this.mPpgData.size() + ", mPpgData=" + this.mPpgData + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleMeasurementPPG(List list, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }

    public BleMeasurementPPG(@OOXIXo List<Integer> mPpgData) {
        IIX0o.x0xO0oo(mPpgData, "mPpgData");
        this.mPpgData = mPpgData;
    }
}
