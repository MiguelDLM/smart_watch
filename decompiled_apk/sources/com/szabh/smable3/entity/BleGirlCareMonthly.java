package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleGirlCareMonthly.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleGirlCareMonthly.kt\ncom/szabh/smable3/entity/BleGirlCareMonthly\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,33:1\n11075#2:34\n11410#2,3:35\n*S KotlinDebug\n*F\n+ 1 BleGirlCareMonthly.kt\ncom/szabh/smable3/entity/BleGirlCareMonthly\n*L\n15#1:34\n15#1:35,3\n*E\n"})
/* loaded from: classes13.dex */
public final class BleGirlCareMonthly extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT = 0;
    public static final int EASY_PREGNANCY = 4;
    public static final int MENSTRUATING = 2;
    public static final int MENSTRUATION_END = 3;
    public static final int MENSTRUATION_START = 1;
    public static final int OVULATION_DATE = 5;

    @OOXIXo
    private List<Integer> mList;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BleGirlCareMonthly() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BleGirlCareMonthly copy$default(BleGirlCareMonthly bleGirlCareMonthly, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = bleGirlCareMonthly.mList;
        }
        return bleGirlCareMonthly.copy(list);
    }

    @OOXIXo
    public final List<Integer> component1() {
        return this.mList;
    }

    @OOXIXo
    public final BleGirlCareMonthly copy(@OOXIXo List<Integer> mList) {
        IIX0o.x0xO0oo(mList, "mList");
        return new BleGirlCareMonthly(mList);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        if (getMBytes() != null) {
            byte[] mBytes = getMBytes();
            IIX0o.ooOOo0oXI(mBytes);
            ArrayList arrayList = new ArrayList(mBytes.length);
            for (byte b : mBytes) {
                arrayList.add(Integer.valueOf(b));
            }
            this.mList = arrayList;
        }
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BleGirlCareMonthly) && IIX0o.Oxx0IOOO(this.mList, ((BleGirlCareMonthly) obj).mList);
    }

    @OOXIXo
    public final List<Integer> getMList() {
        return this.mList;
    }

    public int hashCode() {
        return this.mList.hashCode();
    }

    public final void setMList(@OOXIXo List<Integer> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mList = list;
    }

    @OOXIXo
    public String toString() {
        return "BleGirlCareMonthly(mSize=" + this.mList.size() + ", mList=" + this.mList + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleGirlCareMonthly(List list, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list);
    }

    public BleGirlCareMonthly(@OOXIXo List<Integer> mList) {
        IIX0o.x0xO0oo(mList, "mList");
        this.mList = mList;
    }
}
