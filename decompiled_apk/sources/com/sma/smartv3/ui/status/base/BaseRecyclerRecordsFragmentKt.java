package com.sma.smartv3.ui.status.base;

import OXOo.OOXIXo;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterItem;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class BaseRecyclerRecordsFragmentKt {
    @OOXIXo
    public static final GridLayoutManager.SpanSizeLookup II0xO0(@OOXIXo GridLayoutManager gridLayoutManager, @OOXIXo final DslAdapter dslAdapter) {
        IIX0o.x0xO0oo(gridLayoutManager, "<this>");
        IIX0o.x0xO0oo(dslAdapter, "dslAdapter");
        final int spanCount = gridLayoutManager.getSpanCount();
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() { // from class: com.sma.smartv3.ui.status.base.BaseRecyclerRecordsFragmentKt$dslSpanSizeLookup$spanSizeLookup$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                if (DslAdapter.this.isAdapterStatus()) {
                    return spanCount;
                }
                DslAdapterItem itemData$default = DslAdapter.getItemData$default(DslAdapter.this, i, false, 2, null);
                if (itemData$default != null) {
                    int i2 = spanCount;
                    if (itemData$default.getItemSpanCount() == -1) {
                        return i2;
                    }
                    return itemData$default.getItemSpanCount();
                }
                return 1;
            }
        };
        gridLayoutManager.setSpanSizeLookup(spanSizeLookup);
        return spanSizeLookup;
    }

    @OOXIXo
    public static final GridLayoutManager.SpanSizeLookup oIX0oI(@OOXIXo GridLayoutManager gridLayoutManager, @OOXIXo final RecyclerView recyclerView) {
        IIX0o.x0xO0oo(gridLayoutManager, "<this>");
        IIX0o.x0xO0oo(recyclerView, "recyclerView");
        final int spanCount = gridLayoutManager.getSpanCount();
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() { // from class: com.sma.smartv3.ui.status.base.BaseRecyclerRecordsFragmentKt$dslSpanSizeLookup$spanSizeLookup$2
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                DslAdapter dslAdapter;
                DslAdapterItem itemData$default;
                RecyclerView.Adapter adapter = RecyclerView.this.getAdapter();
                if (adapter instanceof DslAdapter) {
                    dslAdapter = (DslAdapter) adapter;
                } else {
                    dslAdapter = null;
                }
                if (dslAdapter != null && dslAdapter.isAdapterStatus()) {
                    return spanCount;
                }
                if (dslAdapter == null || (itemData$default = DslAdapter.getItemData$default(dslAdapter, i, false, 2, null)) == null) {
                    return 1;
                }
                int i2 = spanCount;
                if (itemData$default.getItemSpanCount() == -1) {
                    return i2;
                }
                return itemData$default.getItemSpanCount();
            }
        };
        gridLayoutManager.setSpanSizeLookup(spanSizeLookup);
        return spanSizeLookup;
    }
}
