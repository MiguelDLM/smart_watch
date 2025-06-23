package com.angcyo.dsladapter.internal;

import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class II0XooXoX extends com.angcyo.dsladapter.filter.X0o0xo {
    public final int I0Io(DslAdapter dslAdapter, List<? extends DslAdapterItem> list, int i) {
        int size = list.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            DslAdapterItem dslAdapterItem = list.get(i2);
            if (!dslAdapterItem.getItemIsGroupHead() && dslAdapter.getFooterItems().indexOf(dslAdapterItem) == -1) {
                if (i2 == list.size() - 1) {
                    return i2 - i;
                }
            } else {
                return (i2 - i) - 1;
            }
        }
        return 0;
    }

    @Override // com.angcyo.dsladapter.filter.xxIXOIIO
    @OXOo.OOXIXo
    public List<DslAdapterItem> II0xO0(@OXOo.OOXIXo com.angcyo.dsladapter.filter.Oxx0IOOO chain) {
        int i;
        IIX0o.x0xO0oo(chain, "chain");
        DslAdapter xxIXOIIO2 = chain.xxIXOIIO();
        List<DslAdapterItem> x0XOIxOo2 = chain.x0XOIxOo();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < x0XOIxOo2.size()) {
            DslAdapterItem dslAdapterItem = x0XOIxOo2.get(i2);
            arrayList.add(dslAdapterItem);
            if (dslAdapterItem.getItemIsGroupHead()) {
                int I0Io2 = I0Io(xxIXOIIO2, x0XOIxOo2, i2);
                int i3 = i2 + 1;
                if (I0Io2 > 0) {
                    if (dslAdapterItem.getItemGroupExtend() && !dslAdapterItem.getItemHidden() && i3 <= (i = i2 + I0Io2)) {
                        int i4 = i3;
                        while (true) {
                            arrayList.add(x0XOIxOo2.get(i4));
                            if (i4 == i) {
                                break;
                            }
                            i4++;
                        }
                    }
                    i2 = i3 + I0Io2;
                } else {
                    i2 = i3;
                }
            } else {
                i2++;
            }
        }
        return arrayList;
    }
}
