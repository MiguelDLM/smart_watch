package com.sma.smartv3.dsl;

import OXOo.OOXIXo;
import android.widget.TextView;
import com.angcyo.dsladapter.DslAdapterStatusItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.sma.smartv3.co_fit.R;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class AdapterStatusItem extends DslAdapterStatusItem {
    @Override // com.angcyo.dsladapter.DslAdapterStatusItem, com.angcyo.dsladapter.BaseDslStateItem
    public void _onBindStateLayout(@OOXIXo DslViewHolder itemHolder, int i) {
        TextView textView;
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        super._onBindStateLayout(itemHolder, i);
        if (i == 2 && (textView = (TextView) itemHolder.v(R.id.text_view)) != null) {
            textView.setText("");
            textView.setTextColor(0);
        }
    }
}
