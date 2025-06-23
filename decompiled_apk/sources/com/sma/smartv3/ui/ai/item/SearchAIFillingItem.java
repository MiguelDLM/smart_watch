package com.sma.smartv3.ui.ai.item;

import OXOo.OOXIXo;
import android.widget.TextView;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AIFunction;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class SearchAIFillingItem extends BaseDslItem {
    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        Object itemData = getItemData();
        IIX0o.x0XOIxOo(itemData, "null cannot be cast to non-null type com.sma.smartv3.model.AIFunction");
        AIFunction aIFunction = (AIFunction) itemData;
        TextView tv = itemHolder.tv(R.id.tv_title);
        if (tv != null) {
            tv.setText(aIFunction.getTitle());
        }
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.ai_item_function_filling;
    }
}
