package com.angcyo.dsladapter;

import android.util.SparseArray;

/* loaded from: classes7.dex */
public final class X0o0xo {
    public static final void II0xO0(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i, @OXOo.oOoXoXO Object obj) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        SparseArray<Object> itemTags = dslAdapterItem.getItemTags();
        if (itemTags == null) {
            itemTags = new SparseArray<>();
        }
        itemTags.put(i, obj);
        dslAdapterItem.setItemTags(itemTags);
    }

    @OXOo.oOoXoXO
    public static final Object oIX0oI(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        SparseArray<Object> itemTags = dslAdapterItem.getItemTags();
        if (itemTags != null) {
            return itemTags.get(i);
        }
        return null;
    }
}
