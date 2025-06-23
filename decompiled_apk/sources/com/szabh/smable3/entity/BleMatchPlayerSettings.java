package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleMatchPlayerSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleMatchPlayerSettings.kt\ncom/szabh/smable3/entity/BleMatchPlayerSettings\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,25:1\n1855#2,2:26\n*S KotlinDebug\n*F\n+ 1 BleMatchPlayerSettings.kt\ncom/szabh/smable3/entity/BleMatchPlayerSettings\n*L\n20#1:26,2\n*E\n"})
/* loaded from: classes13.dex */
public final class BleMatchPlayerSettings extends BleWritable {
    private int mMatchSetType;

    @OOXIXo
    private List<BleMatchPlayer> mPlayerList;

    /* JADX WARN: Multi-variable type inference failed */
    public BleMatchPlayerSettings() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BleMatchPlayerSettings copy$default(BleMatchPlayerSettings bleMatchPlayerSettings, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleMatchPlayerSettings.mMatchSetType;
        }
        if ((i2 & 2) != 0) {
            list = bleMatchPlayerSettings.mPlayerList;
        }
        return bleMatchPlayerSettings.copy(i, list);
    }

    public final int component1() {
        return this.mMatchSetType;
    }

    @OOXIXo
    public final List<BleMatchPlayer> component2() {
        return this.mPlayerList;
    }

    @OOXIXo
    public final BleMatchPlayerSettings copy(int i, @OOXIXo List<BleMatchPlayer> mPlayerList) {
        IIX0o.x0xO0oo(mPlayerList, "mPlayerList");
        return new BleMatchPlayerSettings(i, mPlayerList);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mMatchSetType);
        writeInt8(this.mPlayerList.size());
        Iterator<T> it = this.mPlayerList.iterator();
        while (it.hasNext()) {
            writeObject((BleMatchPlayer) it.next());
        }
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleMatchPlayerSettings)) {
            return false;
        }
        BleMatchPlayerSettings bleMatchPlayerSettings = (BleMatchPlayerSettings) obj;
        return this.mMatchSetType == bleMatchPlayerSettings.mMatchSetType && IIX0o.Oxx0IOOO(this.mPlayerList, bleMatchPlayerSettings.mPlayerList);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return (this.mPlayerList.size() * 28) + 2;
    }

    public final int getMMatchSetType() {
        return this.mMatchSetType;
    }

    @OOXIXo
    public final List<BleMatchPlayer> getMPlayerList() {
        return this.mPlayerList;
    }

    public int hashCode() {
        return (this.mMatchSetType * 31) + this.mPlayerList.hashCode();
    }

    public final void setMMatchSetType(int i) {
        this.mMatchSetType = i;
    }

    public final void setMPlayerList(@OOXIXo List<BleMatchPlayer> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mPlayerList = list;
    }

    @OOXIXo
    public String toString() {
        return "BleMatchPlayerSettings(mMatchSetType=" + this.mMatchSetType + ", mPlayerList=" + this.mPlayerList + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleMatchPlayerSettings(int i, List list, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 4 : i, (i2 & 2) != 0 ? new ArrayList() : list);
    }

    public BleMatchPlayerSettings(int i, @OOXIXo List<BleMatchPlayer> mPlayerList) {
        IIX0o.x0xO0oo(mPlayerList, "mPlayerList");
        this.mMatchSetType = i;
        this.mPlayerList = mPlayerList;
    }
}
