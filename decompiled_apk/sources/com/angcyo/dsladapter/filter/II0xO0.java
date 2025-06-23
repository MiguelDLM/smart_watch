package com.angcyo.dsladapter.filter;

import OXOo.OOXIXo;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterItem;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class II0xO0 extends oxoX {
    public static final void oxoX(DslAdapter this_apply) {
        IIX0o.x0xO0oo(this_apply, "$this_apply");
        this_apply.updateAdapterStatus(1);
    }

    @Override // com.angcyo.dsladapter.filter.II0XooXoX
    @OOXIXo
    public List<DslAdapterItem> II0xO0(@OOXIXo XO chain) {
        IIX0o.x0xO0oo(chain, "chain");
        if (chain.oOoXoXO().isEmpty() && !chain.OOXIXo().isEmpty()) {
            chain.ooOOo0oXI(true);
            final DslAdapter II0XooXoX2 = chain.II0XooXoX();
            RecyclerView recyclerView = II0XooXoX2.get_recyclerView();
            if (recyclerView != null) {
                recyclerView.post(new Runnable() { // from class: com.angcyo.dsladapter.filter.oIX0oI
                    @Override // java.lang.Runnable
                    public final void run() {
                        II0xO0.oxoX(DslAdapter.this);
                    }
                });
            }
        }
        return chain.oOoXoXO();
    }
}
