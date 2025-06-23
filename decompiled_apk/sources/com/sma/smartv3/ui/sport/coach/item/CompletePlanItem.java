package com.sma.smartv3.ui.sport.coach.item;

import OXOo.OOXIXo;
import android.view.View;
import android.widget.Button;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.x0xO0oo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public class CompletePlanItem extends BaseDslItem {
    private Button mButton;

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.coach_item_create_plan);
        IIX0o.ooOOo0oXI(v);
        this.mButton = (Button) v;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        Button button = this.mButton;
        if (button == null) {
            IIX0o.XOxIOxOx("mButton");
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.coach.item.oIX0oI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x0xO0oo.II0xO0(x0xO0oo.f24617XXoOx0, null, 2, null);
            }
        });
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.coach_item_complete;
    }
}
