package com.sma.smartv3.ui.ai;

import android.app.Activity;
import android.view.View;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.ai.AIAnswerActivity;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class AIAnswerActivity$addReyclerView$mAdapter$1 extends CommonAdapter<String> {
    final /* synthetic */ AIAnswerActivity.oIX0oI $tabData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIAnswerActivity$addReyclerView$mAdapter$1(List<String> list, AIAnswerActivity.oIX0oI oix0oi, Activity activity) {
        super(activity, R.layout.item_ai_answer_tab, list);
        this.$tabData = oix0oi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$1(AIAnswerActivity.oIX0oI tabData, String item, AIAnswerActivity$addReyclerView$mAdapter$1 this$0, View view) {
        IIX0o.x0xO0oo(tabData, "$tabData");
        IIX0o.x0xO0oo(item, "$item");
        IIX0o.x0xO0oo(this$0, "this$0");
        tabData.Oxx0IOOO(item);
        this$0.notifyDataSetChanged();
    }

    @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
    public void convert(@OXOo.OOXIXo ViewHolder viewHolder, @OXOo.OOXIXo final String item, int i) {
        IIX0o.x0xO0oo(viewHolder, "viewHolder");
        IIX0o.x0xO0oo(item, "item");
        viewHolder.setText(R.id.tv, item);
        viewHolder.itemView.setBackgroundResource(IIX0o.Oxx0IOOO(item, this.$tabData.XO()) ? R.drawable.shape_ai_tab_selected_bg : R.drawable.ripple_ai_tab_not_selected);
        final AIAnswerActivity.oIX0oI oix0oi = this.$tabData;
        viewHolder.setOnClickListener(R.id.ll_item_panel, new View.OnClickListener() { // from class: com.sma.smartv3.ui.ai.II0xO0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIAnswerActivity$addReyclerView$mAdapter$1.convert$lambda$1(AIAnswerActivity.oIX0oI.this, item, this, view);
            }
        });
    }
}
