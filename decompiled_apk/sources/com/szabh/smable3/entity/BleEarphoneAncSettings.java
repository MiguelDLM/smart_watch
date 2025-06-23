package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleEarphoneAncSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleEarphoneAncSettings.kt\ncom/szabh/smable3/entity/BleEarphoneAncSettings\n+ 2 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable\n*L\n1#1,98:1\n232#2,3:99\n222#2,15:102\n*S KotlinDebug\n*F\n+ 1 BleEarphoneAncSettings.kt\ncom/szabh/smable3/entity/BleEarphoneAncSettings\n*L\n83#1:99,3\n83#1:102,15\n*E\n"})
/* loaded from: classes13.dex */
public final class BleEarphoneAncSettings extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 26;
    public static final int MODE_CLOSE = 0;
    public static final int MODE_DENOISE = 1;
    public static final int MODE_TRANSPARENT = 2;

    @OOXIXo
    private List<BleAncMode> mAncModeList;
    private int mMode;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BleEarphoneAncSettings() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BleEarphoneAncSettings copy$default(BleEarphoneAncSettings bleEarphoneAncSettings, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleEarphoneAncSettings.mMode;
        }
        if ((i2 & 2) != 0) {
            list = bleEarphoneAncSettings.mAncModeList;
        }
        return bleEarphoneAncSettings.copy(i, list);
    }

    public final int component1() {
        return this.mMode;
    }

    @OOXIXo
    public final List<BleAncMode> component2() {
        return this.mAncModeList;
    }

    @OOXIXo
    public final BleEarphoneAncSettings copy(int i, @OOXIXo List<BleAncMode> mAncModeList) {
        IIX0o.x0xO0oo(mAncModeList, "mAncModeList");
        return new BleEarphoneAncSettings(i, mAncModeList);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mMode = readInt8();
        readInt8();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            BleReadable bleReadable = (BleReadable) BleAncMode.class.newInstance();
            bleReadable.setMBytes(readBytes(8));
            bleReadable.decode();
            IIX0o.ooOOo0oXI(bleReadable);
            arrayList.add(bleReadable);
        }
        this.mAncModeList = arrayList;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mMode);
        writeInt8(0);
        writeList(this.mAncModeList);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleEarphoneAncSettings)) {
            return false;
        }
        BleEarphoneAncSettings bleEarphoneAncSettings = (BleEarphoneAncSettings) obj;
        return this.mMode == bleEarphoneAncSettings.mMode && IIX0o.Oxx0IOOO(this.mAncModeList, bleEarphoneAncSettings.mAncModeList);
    }

    @OOXIXo
    public final List<BleAncMode> getMAncModeList() {
        return this.mAncModeList;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 26;
    }

    public final int getMMode() {
        return this.mMode;
    }

    public int hashCode() {
        return (this.mMode * 31) + this.mAncModeList.hashCode();
    }

    public final void setMAncModeList(@OOXIXo List<BleAncMode> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mAncModeList = list;
    }

    public final void setMMode(int i) {
        this.mMode = i;
    }

    @OOXIXo
    public String toString() {
        return "BleEarphoneAncSettings(mMode=" + this.mMode + ", mAncModeList=" + this.mAncModeList + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleEarphoneAncSettings(int i, List list, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? CollectionsKt__CollectionsKt.XOxIOxOx(new BleAncMode(0, 0, 0, 0), new BleAncMode(16384, 16384, 8000, 8000), new BleAncMode(16384, 16384, 8000, 8000)) : list);
    }

    public BleEarphoneAncSettings(int i, @OOXIXo List<BleAncMode> mAncModeList) {
        IIX0o.x0xO0oo(mAncModeList, "mAncModeList");
        this.mMode = i;
        this.mAncModeList = mAncModeList;
    }
}
