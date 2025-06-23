package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes13.dex */
public final class BleRepeat {
    public static final int EVERYDAY = 127;
    public static final int FRIDAY = 16;
    public static final int MONDAY = 1;
    public static final int ONCE = 0;
    public static final int SATURDAY = 32;
    public static final int SUNDAY = 64;
    public static final int THURSDAY = 8;
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 4;
    public static final int WEEKEND = 96;
    public static final int WORKDAY = 31;

    @OOXIXo
    public static final BleRepeat INSTANCE = new BleRepeat();

    @OOXIXo
    private static final List<Integer> WEEKDAYS = CollectionsKt__CollectionsKt.X00IoxXI(1, 2, 4, 8, 16, 32, 64);

    private BleRepeat() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ int indicesToRepeat$default(BleRepeat bleRepeat, Set set, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            oooxoxo = new oOoXoXO<Integer, Integer>() { // from class: com.szabh.smable3.entity.BleRepeat$indicesToRepeat$1
                @OOXIXo
                public final Integer invoke(int i2) {
                    return BleRepeat.INSTANCE.getWEEKDAYS().get(i2);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return bleRepeat.indicesToRepeat(set, oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Set toIndices$default(BleRepeat bleRepeat, int i, oOoXoXO oooxoxo, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            oooxoxo = new oOoXoXO<Integer, Integer>() { // from class: com.szabh.smable3.entity.BleRepeat$toIndices$1
                @OOXIXo
                public final Integer invoke(int i3) {
                    return Integer.valueOf(BleRepeat.INSTANCE.getWEEKDAYS().indexOf(Integer.valueOf(i3)));
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return bleRepeat.toIndices(i, oooxoxo);
    }

    @OOXIXo
    public final List<Integer> getWEEKDAYS() {
        return WEEKDAYS;
    }

    public final int indicesToRepeat(@OOXIXo Set<Integer> indices, @OOXIXo oOoXoXO<? super Integer, Integer> transfer) {
        IIX0o.x0xO0oo(indices, "indices");
        IIX0o.x0xO0oo(transfer, "transfer");
        Iterator<Integer> it = indices.iterator();
        int i = 0;
        while (it.hasNext()) {
            i |= transfer.invoke(Integer.valueOf(it.next().intValue())).intValue();
        }
        return i;
    }

    @OOXIXo
    public final Set<Integer> toIndices(int i, @OOXIXo oOoXoXO<? super Integer, Integer> transfer) {
        IIX0o.x0xO0oo(transfer, "transfer");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<Integer> it = WEEKDAYS.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if ((i & 127 & intValue) > 0) {
                linkedHashSet.add(transfer.invoke(Integer.valueOf(intValue)));
            }
        }
        return linkedHashSet;
    }

    @OOXIXo
    public final String toWeekdayText(int i, @OOXIXo oOoXoXO<? super Integer, String> transfer) {
        IIX0o.x0xO0oo(transfer, "transfer");
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it = WEEKDAYS.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if ((i & 127 & intValue) > 0) {
                sb.append(transfer.invoke(Integer.valueOf(intValue)));
            }
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "toString(...)");
        return sb2;
    }
}
