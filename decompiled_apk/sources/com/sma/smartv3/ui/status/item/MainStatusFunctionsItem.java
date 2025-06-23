package com.sma.smartv3.ui.status.item;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.sma.smartv3.co_fit.R;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nMainStatusFunctionsItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainStatusFunctionsItem.kt\ncom/sma/smartv3/ui/status/item/MainStatusFunctionsItem\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,33:1\n1#2:34\n*E\n"})
/* loaded from: classes12.dex */
public final class MainStatusFunctionsItem extends BaseDslItem {

    @OXOo.oOoXoXO
    private Context context;

    @OXOo.oOoXoXO
    private DslAdapter dslAdapter;
    public List<DslAdapterItem> items;

    @OXOo.oOoXoXO
    private RecyclerView mRecyclerView;

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OXOo.OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        this.context = itemHolder.getContext();
        RecyclerView rv = itemHolder.rv(R.id.rv);
        IIX0o.x0XOIxOo(rv, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        this.mRecyclerView = rv;
        if (rv != null) {
            rv.setItemViewCacheSize(30);
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.setItemAnimator(null);
        }
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new GridLayoutManager(itemHolder.getContext(), 2));
        }
        DslAdapter dslAdapter = new DslAdapter(getItems());
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(dslAdapter);
        }
        this.dslAdapter = dslAdapter;
    }

    @OXOo.OOXIXo
    public final List<DslAdapterItem> getItems() {
        List<DslAdapterItem> list = this.items;
        if (list != null) {
            return list;
        }
        IIX0o.XOxIOxOx("items");
        return null;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.status_item_functions;
    }

    public final void setItems(@OXOo.OOXIXo List<DslAdapterItem> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.items = list;
    }
}
