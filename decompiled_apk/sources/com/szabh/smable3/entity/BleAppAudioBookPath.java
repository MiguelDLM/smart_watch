package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleFilePath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleFilePath.kt\ncom/szabh/smable3/entity/BleAppAudioBookPath\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,87:1\n1855#2,2:88\n1855#2,2:90\n*S KotlinDebug\n*F\n+ 1 BleFilePath.kt\ncom/szabh/smable3/entity/BleAppAudioBookPath\n*L\n38#1:88,2\n46#1:90,2\n*E\n"})
/* loaded from: classes13.dex */
public final class BleAppAudioBookPath extends BleWritable {
    private int mCount;

    @OOXIXo
    private List<String> mList;

    /* JADX WARN: Multi-variable type inference failed */
    public BleAppAudioBookPath() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BleAppAudioBookPath copy$default(BleAppAudioBookPath bleAppAudioBookPath, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleAppAudioBookPath.mCount;
        }
        if ((i2 & 2) != 0) {
            list = bleAppAudioBookPath.mList;
        }
        return bleAppAudioBookPath.copy(i, list);
    }

    public final int component1() {
        return this.mCount;
    }

    @OOXIXo
    public final List<String> component2() {
        return this.mList;
    }

    @OOXIXo
    public final BleAppAudioBookPath copy(int i, @OOXIXo List<String> mList) {
        IIX0o.x0xO0oo(mList, "mList");
        return new BleAppAudioBookPath(i, mList);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mCount);
        Iterator<T> it = this.mList.iterator();
        while (it.hasNext()) {
            BleWritable.writeString$default(this, (String) it.next(), null, 2, null);
            writeInt8(0);
        }
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleAppAudioBookPath)) {
            return false;
        }
        BleAppAudioBookPath bleAppAudioBookPath = (BleAppAudioBookPath) obj;
        return this.mCount == bleAppAudioBookPath.mCount && IIX0o.Oxx0IOOO(this.mList, bleAppAudioBookPath.mList);
    }

    public final int getListSize() {
        int i = 0;
        for (String str : this.mList) {
            Charset defaultCharset = Charset.defaultCharset();
            IIX0o.oO(defaultCharset, "defaultCharset(...)");
            byte[] bytes = str.getBytes(defaultCharset);
            IIX0o.oO(bytes, "getBytes(...)");
            i += bytes.length + 1;
        }
        return i + 1;
    }

    public final int getMCount() {
        return this.mCount;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return getListSize();
    }

    @OOXIXo
    public final List<String> getMList() {
        return this.mList;
    }

    public int hashCode() {
        return (this.mCount * 31) + this.mList.hashCode();
    }

    public final void setMCount(int i) {
        this.mCount = i;
    }

    public final void setMList(@OOXIXo List<String> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mList = list;
    }

    @OOXIXo
    public String toString() {
        return "BleAppAudioBookPath(mCount=" + this.mCount + ", mList=" + this.mList + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleAppAudioBookPath(int i, List list, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new ArrayList() : list);
    }

    public BleAppAudioBookPath(int i, @OOXIXo List<String> mList) {
        IIX0o.x0xO0oo(mList, "mList");
        this.mCount = i;
        this.mList = mList;
    }
}
