package com.sma.smartv3.util;

import com.sma.smartv3.ui.contactpicker.ContactResult;
import java.util.Comparator;

/* loaded from: classes12.dex */
public final class xoIxX implements Comparator<ContactResult> {
    @Override // java.util.Comparator
    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
    public int compare(@OXOo.OOXIXo ContactResult o1, @OXOo.OOXIXo ContactResult o2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(o1, "o1");
        kotlin.jvm.internal.IIX0o.x0xO0oo(o2, "o2");
        if (!o1.getItemGroups().equals("@") && !o2.getItemGroups().equals(OoOoXO0.xoXoI.f2670oxoX)) {
            if (!o1.getItemGroups().equals(OoOoXO0.xoXoI.f2670oxoX) && !o2.getItemGroups().equals("@")) {
                String itemGroups = o1.getItemGroups();
                String itemGroups2 = o2.getItemGroups();
                kotlin.jvm.internal.IIX0o.oO(itemGroups2, "getItemGroups(...)");
                return itemGroups.compareTo(itemGroups2);
            }
            return 1;
        }
        return -1;
    }
}
