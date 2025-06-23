package com.angcyo.dsladapter.internal;

import com.angcyo.dsladapter.DslAdapterItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class xoIox extends com.angcyo.dsladapter.filter.X0o0xo {
    @Override // com.angcyo.dsladapter.filter.xxIXOIIO
    @OXOo.OOXIXo
    public List<DslAdapterItem> II0xO0(@OXOo.OOXIXo com.angcyo.dsladapter.filter.Oxx0IOOO chain) {
        IIX0o.x0xO0oo(chain, "chain");
        if (!chain.xxIXOIIO().isAdapterStatus() && chain.xxIXOIIO().getDslLoadMoreItem().getItemStateEnable()) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(chain.x0XOIxOo());
            arrayList.add(chain.xxIXOIIO().getDslLoadMoreItem());
            return arrayList;
        }
        return chain.x0XOIxOo();
    }
}
