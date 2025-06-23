package com.angcyo.dsladapter.internal;

import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.L;
import com.angcyo.dsladapter.XxX0x0xxx;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nHideItemFilterInterceptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HideItemFilterInterceptor.kt\ncom/angcyo/dsladapter/internal/HideItemFilterInterceptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,66:1\n1855#2:67\n1864#2,3:68\n1856#2:71\n1864#2,3:72\n*S KotlinDebug\n*F\n+ 1 HideItemFilterInterceptor.kt\ncom/angcyo/dsladapter/internal/HideItemFilterInterceptor\n*L\n25#1:67\n27#1:68,3\n25#1:71\n48#1:72,3\n*E\n"})
/* loaded from: classes7.dex */
public final class xxIXOIIO extends com.angcyo.dsladapter.filter.X0o0xo {
    @Override // com.angcyo.dsladapter.filter.xxIXOIIO
    @OXOo.OOXIXo
    public List<DslAdapterItem> II0xO0(@OXOo.OOXIXo com.angcyo.dsladapter.filter.Oxx0IOOO chain) {
        IIX0o.x0xO0oo(chain, "chain");
        List<DslAdapterItem> x0XOIxOo2 = chain.x0XOIxOo();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<DslAdapterItem> list = x0XOIxOo2;
        for (DslAdapterItem dslAdapterItem : list) {
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.XoX();
                }
                DslAdapterItem dslAdapterItem2 = (DslAdapterItem) obj;
                if (dslAdapterItem.isItemInHiddenList().invoke(dslAdapterItem2, Integer.valueOf(i)).booleanValue()) {
                    XxX0x0xxx OOXIXo2 = chain.OOXIXo();
                    if (IIX0o.Oxx0IOOO(OOXIXo2.x0xO0oo(), dslAdapterItem)) {
                        OOXIXo2.ooXIXxIX(true);
                    }
                    arrayList2.add(dslAdapterItem2);
                }
                i = i2;
            }
            if (dslAdapterItem.getItemHidden()) {
                arrayList2.add(dslAdapterItem);
            }
        }
        int i3 = 0;
        int i4 = 0;
        for (Object obj2 : list) {
            int i5 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            DslAdapterItem dslAdapterItem3 = (DslAdapterItem) obj2;
            if (arrayList2.contains(dslAdapterItem3)) {
                L l = L.f5267oIX0oI;
                StringBuilder sb = new StringBuilder();
                int i6 = i4 + 1;
                sb.append(i4);
                sb.append(". 隐藏表单:");
                sb.append(dslAdapterItem3.getClass().getSimpleName());
                sb.append(TokenParser.SP);
                String itemTag = dslAdapterItem3.getItemTag();
                if (itemTag == null) {
                    itemTag = "";
                }
                sb.append(itemTag);
                sb.append(" index:");
                sb.append(i3);
                l.ooXIXxIX(sb.toString());
                i4 = i6;
            } else {
                arrayList.add(dslAdapterItem3);
            }
            i3 = i5;
        }
        return arrayList;
    }
}
