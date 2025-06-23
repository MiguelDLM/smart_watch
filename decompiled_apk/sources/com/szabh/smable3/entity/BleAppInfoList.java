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
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleAppStore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleAppStore.kt\ncom/szabh/smable3/entity/BleAppInfoList\n+ 2 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable\n*L\n1#1,174:1\n232#2,3:175\n222#2,15:178\n*S KotlinDebug\n*F\n+ 1 BleAppStore.kt\ncom/szabh/smable3/entity/BleAppInfoList\n*L\n106#1:175,3\n106#1:178,15\n*E\n"})
/* loaded from: classes13.dex */
public final class BleAppInfoList extends BleReadable {
    private int mAppInfoLength;

    @OOXIXo
    private List<BleAppInfo> mList;

    /* JADX WARN: Multi-variable type inference failed */
    public BleAppInfoList() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BleAppInfoList copy$default(BleAppInfoList bleAppInfoList, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = bleAppInfoList.mList;
        }
        return bleAppInfoList.copy(list);
    }

    @OOXIXo
    public final List<BleAppInfo> component1() {
        return this.mList;
    }

    @OOXIXo
    public final BleAppInfoList copy(@OOXIXo List<BleAppInfo> mList) {
        IIX0o.x0xO0oo(mList, "mList");
        return new BleAppInfoList(mList);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        try {
            ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
            IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
            this.mAppInfoLength = readInt32(LITTLE_ENDIAN);
            byte[] mBytes = getMBytes();
            IIX0o.ooOOo0oXI(mBytes);
            int length = mBytes.length - 4;
            int i = this.mAppInfoLength;
            int i2 = length / i;
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < i2; i3++) {
                BleReadable bleReadable = (BleReadable) BleAppInfo.class.newInstance();
                bleReadable.setMBytes(readBytes(i));
                bleReadable.decode();
                IIX0o.ooOOo0oXI(bleReadable);
                arrayList.add(bleReadable);
            }
            this.mList = arrayList;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BleAppInfoList) && IIX0o.Oxx0IOOO(this.mList, ((BleAppInfoList) obj).mList);
    }

    @OOXIXo
    public final List<BleAppInfo> getMList() {
        return this.mList;
    }

    public int hashCode() {
        return this.mList.hashCode();
    }

    public final void setMList(@OOXIXo List<BleAppInfo> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mList = list;
    }

    @OOXIXo
    public String toString() {
        return "BleAppInfoList(mSize=" + this.mList.size() + ", mAppInfoLength=" + this.mAppInfoLength + ", mList=" + this.mList + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleAppInfoList(List list, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }

    public BleAppInfoList(@OOXIXo List<BleAppInfo> mList) {
        IIX0o.x0xO0oo(mList, "mList");
        this.mList = mList;
    }
}
