package com.sma.smartv3.ui.ai.item;

import OXOo.OOXIXo;
import android.content.Context;
import android.view.View;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.ai.item.AISearchTopItem$setRecyclerView$mAdapter$1;
import com.sma.smartv3.util.x0xO0oo;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class AISearchTopItem$setRecyclerView$mAdapter$1 extends CommonAdapter<String> {
    public AISearchTopItem$setRecyclerView$mAdapter$1(List<String> list, Context context) {
        super(context, R.layout.item_ai_search_tab, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$1(String item, View view) {
        IIX0o.x0xO0oo(item, "$item");
        x0xO0oo.oIX0oI(x0xO0oo.f24575Io, item);
    }

    @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
    public void convert(@OOXIXo ViewHolder viewHolder, @OOXIXo final String item, int i) {
        IIX0o.x0xO0oo(viewHolder, "viewHolder");
        IIX0o.x0xO0oo(item, "item");
        viewHolder.setText(R.id.tv, item);
        viewHolder.itemView.setBackgroundResource(R.drawable.ripple_ai_tab_seach_bg);
        viewHolder.setOnClickListener(R.id.ll_item_panel, new View.OnClickListener() { // from class: o0oxo0oI.XO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AISearchTopItem$setRecyclerView$mAdapter$1.convert$lambda$1(item, view);
            }
        });
    }
}
