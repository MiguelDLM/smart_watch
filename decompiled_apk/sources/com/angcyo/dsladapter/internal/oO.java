package com.angcyo.dsladapter.internal;

import com.angcyo.dsladapter.DslAdapterItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nSubItemFilterInterceptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SubItemFilterInterceptor.kt\ncom/angcyo/dsladapter/internal/SubItemFilterInterceptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,52:1\n1855#2,2:53\n1855#2,2:55\n*S KotlinDebug\n*F\n+ 1 SubItemFilterInterceptor.kt\ncom/angcyo/dsladapter/internal/SubItemFilterInterceptor\n*L\n20#1:53,2\n44#1:55,2\n*E\n"})
/* loaded from: classes7.dex */
public final class oO extends com.angcyo.dsladapter.filter.X0o0xo {
    public final void I0Io(DslAdapterItem dslAdapterItem, List<DslAdapterItem> list, List<DslAdapterItem> list2) {
        if (!dslAdapterItem.getItemHidden()) {
            dslAdapterItem.setItemParentList(list);
            list2.add(dslAdapterItem);
            if (dslAdapterItem.getItemGroupExtend()) {
                dslAdapterItem.getItemLoadSubList().invoke();
                for (DslAdapterItem dslAdapterItem2 : dslAdapterItem.getItemSubList()) {
                    ArrayList arrayList = new ArrayList(list);
                    arrayList.add(dslAdapterItem);
                    I0Io(dslAdapterItem2, arrayList, list2);
                }
            }
        }
    }

    @Override // com.angcyo.dsladapter.filter.xxIXOIIO
    @OXOo.OOXIXo
    public List<DslAdapterItem> II0xO0(@OXOo.OOXIXo com.angcyo.dsladapter.filter.Oxx0IOOO chain) {
        IIX0o.x0xO0oo(chain, "chain");
        ArrayList arrayList = new ArrayList();
        for (DslAdapterItem dslAdapterItem : chain.x0XOIxOo()) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            I0Io(dslAdapterItem, arrayList2, arrayList3);
            arrayList.addAll(arrayList3);
        }
        return arrayList;
    }
}
