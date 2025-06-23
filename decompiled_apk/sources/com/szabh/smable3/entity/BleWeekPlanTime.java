package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.X0IIOO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleAICoachPlan.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleAICoachPlan.kt\ncom/szabh/smable3/entity/BleWeekPlanTime\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,337:1\n37#2,2:338\n37#2,2:340\n*S KotlinDebug\n*F\n+ 1 BleAICoachPlan.kt\ncom/szabh/smable3/entity/BleWeekPlanTime\n*L\n231#1:338,2\n253#1:340,2\n*E\n"})
/* loaded from: classes13.dex */
public final class BleWeekPlanTime extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 4;

    @OOXIXo
    private Integer[] mList;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final BleWeekPlanTime ofPlanTime(@OOXIXo List<Integer> list) {
            IIX0o.x0xO0oo(list, "list");
            return new BleWeekPlanTime(list, null);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BleWeekPlanTime() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleWeekPlanTime copy$default(BleWeekPlanTime bleWeekPlanTime, Integer[] numArr, int i, Object obj) {
        if ((i & 1) != 0) {
            numArr = bleWeekPlanTime.mList;
        }
        return bleWeekPlanTime.copy(numArr);
    }

    @OOXIXo
    public final Integer[] component1() {
        return this.mList;
    }

    @OOXIXo
    public final BleWeekPlanTime copy(@OOXIXo Integer[] mList) {
        IIX0o.x0xO0oo(mList, "mList");
        return new BleWeekPlanTime(mList);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 32; i++) {
            arrayList.add(Integer.valueOf(readIntN(1)));
        }
        X0IIOO.oXX0IoI(arrayList);
        this.mList = (Integer[]) arrayList.toArray(new Integer[0]);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        for (int i = 31; -1 < i; i--) {
            Integer[] numArr = this.mList;
            if (i < numArr.length) {
                writeIntN(numArr[i].intValue(), 1);
            } else {
                writeIntN(0, 1);
            }
        }
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BleWeekPlanTime) && IIX0o.Oxx0IOOO(this.mList, ((BleWeekPlanTime) obj).mList);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 4;
    }

    @OOXIXo
    public final Integer[] getMList() {
        return this.mList;
    }

    public int hashCode() {
        return Arrays.hashCode(this.mList);
    }

    public final void setMList(@OOXIXo Integer[] numArr) {
        IIX0o.x0xO0oo(numArr, "<set-?>");
        this.mList = numArr;
    }

    @OOXIXo
    public String toString() {
        return "BleWeekPlanTime(mList=" + this.mList + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleWeekPlanTime(List list, IIXOooo iIXOooo) {
        this((List<Integer>) list);
    }

    public /* synthetic */ BleWeekPlanTime(Integer[] numArr, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new Integer[0] : numArr);
    }

    public BleWeekPlanTime(@OOXIXo Integer[] mList) {
        IIX0o.x0xO0oo(mList, "mList");
        this.mList = mList;
    }

    private BleWeekPlanTime(List<Integer> list) {
        this((Integer[]) list.toArray(new Integer[0]));
    }
}
