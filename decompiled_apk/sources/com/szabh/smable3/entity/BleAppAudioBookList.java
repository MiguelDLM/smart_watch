package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleFilePath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleFilePath.kt\ncom/szabh/smable3/entity/BleAppAudioBookList\n+ 2 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable\n*L\n1#1,87:1\n222#2,4:88\n*S KotlinDebug\n*F\n+ 1 BleFilePath.kt\ncom/szabh/smable3/entity/BleAppAudioBookList\n*L\n76#1:88,4\n*E\n"})
/* loaded from: classes13.dex */
public final class BleAppAudioBookList extends BleReadable {
    private int mCount;

    @OOXIXo
    private List<BleFilePath> mList;

    /* JADX WARN: Multi-variable type inference failed */
    public BleAppAudioBookList() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BleAppAudioBookList copy$default(BleAppAudioBookList bleAppAudioBookList, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleAppAudioBookList.mCount;
        }
        if ((i2 & 2) != 0) {
            list = bleAppAudioBookList.mList;
        }
        return bleAppAudioBookList.copy(i, list);
    }

    public final int component1() {
        return this.mCount;
    }

    @OOXIXo
    public final List<BleFilePath> component2() {
        return this.mList;
    }

    @OOXIXo
    public final BleAppAudioBookList copy(int i, @OOXIXo List<BleFilePath> mList) {
        IIX0o.x0xO0oo(mList, "mList");
        return new BleAppAudioBookList(i, mList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        try {
            byte readInt8 = readInt8();
            this.mCount = readInt8;
            if (readInt8 > 0) {
                for (int i = 0; i < readInt8; i++) {
                    byte[] readBytes = readBytes(5);
                    byte[] readBytesUtil = readBytesUtil((byte) 0);
                    skip((-(readBytes.length + readBytesUtil.length + 1)) * 8);
                    List<BleFilePath> list = this.mList;
                    int length = readBytes.length + readBytesUtil.length + 1;
                    BleReadable bleReadable = (BleReadable) BleFilePath.class.newInstance();
                    bleReadable.setMBytes(readBytes(length));
                    bleReadable.decode();
                    IIX0o.ooOOo0oXI(bleReadable);
                    list.add(bleReadable);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleAppAudioBookList)) {
            return false;
        }
        BleAppAudioBookList bleAppAudioBookList = (BleAppAudioBookList) obj;
        return this.mCount == bleAppAudioBookList.mCount && IIX0o.Oxx0IOOO(this.mList, bleAppAudioBookList.mList);
    }

    public final int getMCount() {
        return this.mCount;
    }

    @OOXIXo
    public final List<BleFilePath> getMList() {
        return this.mList;
    }

    public int hashCode() {
        return (this.mCount * 31) + this.mList.hashCode();
    }

    public final void setMCount(int i) {
        this.mCount = i;
    }

    public final void setMList(@OOXIXo List<BleFilePath> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mList = list;
    }

    @OOXIXo
    public String toString() {
        return "BleAppAudioBookList(mSize=" + this.mCount + ", mList=" + this.mList + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleAppAudioBookList(int i, List list, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new ArrayList() : list);
    }

    public BleAppAudioBookList(int i, @OOXIXo List<BleFilePath> mList) {
        IIX0o.x0xO0oo(mList, "mList");
        this.mCount = i;
        this.mList = mList;
    }
}
