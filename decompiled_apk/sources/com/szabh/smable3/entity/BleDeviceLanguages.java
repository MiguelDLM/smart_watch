package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.oxxXoxO;

@XX({"SMAP\nBleDeviceLanguages.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleDeviceLanguages.kt\ncom/szabh/smable3/entity/BleDeviceLanguages\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,26:1\n11075#2:27\n11410#2,3:28\n1549#3:31\n1620#3,3:32\n*S KotlinDebug\n*F\n+ 1 BleDeviceLanguages.kt\ncom/szabh/smable3/entity/BleDeviceLanguages\n*L\n19#1:27\n19#1:28,3\n23#1:31\n23#1:32,3\n*E\n"})
/* loaded from: classes13.dex */
public final class BleDeviceLanguages extends BleReadable {
    private int mCode;

    @OOXIXo
    private List<Integer> mList;
    private int mSize;

    public BleDeviceLanguages() {
        this(0, 0, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BleDeviceLanguages copy$default(BleDeviceLanguages bleDeviceLanguages, int i, int i2, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bleDeviceLanguages.mCode;
        }
        if ((i3 & 2) != 0) {
            i2 = bleDeviceLanguages.mSize;
        }
        if ((i3 & 4) != 0) {
            list = bleDeviceLanguages.mList;
        }
        return bleDeviceLanguages.copy(i, i2, list);
    }

    public final int component1() {
        return this.mCode;
    }

    public final int component2() {
        return this.mSize;
    }

    @OOXIXo
    public final List<Integer> component3() {
        return this.mList;
    }

    @OOXIXo
    public final BleDeviceLanguages copy(int i, int i2, @OOXIXo List<Integer> mList) {
        IIX0o.x0xO0oo(mList, "mList");
        return new BleDeviceLanguages(i, i2, mList);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mCode = readInt8();
        readBytes(4);
        byte readInt8 = readInt8();
        this.mSize = readInt8;
        byte[] readBytes = readBytes(readInt8);
        ArrayList arrayList = new ArrayList(readBytes.length);
        for (byte b : readBytes) {
            arrayList.add(Integer.valueOf(b));
        }
        this.mList = arrayList;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleDeviceLanguages)) {
            return false;
        }
        BleDeviceLanguages bleDeviceLanguages = (BleDeviceLanguages) obj;
        return this.mCode == bleDeviceLanguages.mCode && this.mSize == bleDeviceLanguages.mSize && IIX0o.Oxx0IOOO(this.mList, bleDeviceLanguages.mList);
    }

    public final int getMCode() {
        return this.mCode;
    }

    @OOXIXo
    public final List<Integer> getMList() {
        return this.mList;
    }

    public final int getMSize() {
        return this.mSize;
    }

    public int hashCode() {
        return (((this.mCode * 31) + this.mSize) * 31) + this.mList.hashCode();
    }

    public final void setMCode(int i) {
        this.mCode = i;
    }

    public final void setMList(@OOXIXo List<Integer> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mList = list;
    }

    public final void setMSize(int i) {
        this.mSize = i;
    }

    @OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BleDeviceLanguages(mCode=");
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("0x%02X", Arrays.copyOf(new Object[]{Integer.valueOf(this.mCode)}, 1));
        IIX0o.oO(format, "format(...)");
        sb.append(format);
        sb.append(", mSize=");
        sb.append(this.mSize);
        sb.append(", mList=");
        List<Integer> list = this.mList;
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            oxxXoxO oxxxoxo2 = oxxXoxO.f29356oIX0oI;
            String format2 = String.format("0x%02X", Arrays.copyOf(new Object[]{Integer.valueOf(intValue)}, 1));
            IIX0o.oO(format2, "format(...)");
            arrayList.add(format2);
        }
        sb.append(arrayList);
        sb.append(HexStringBuilder.COMMENT_END_CHAR);
        return sb.toString();
    }

    public /* synthetic */ BleDeviceLanguages(int i, int i2, List list, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list);
    }

    public BleDeviceLanguages(int i, int i2, @OOXIXo List<Integer> mList) {
        IIX0o.x0xO0oo(mList, "mList");
        this.mCode = i;
        this.mSize = i2;
        this.mList = mList;
    }
}
