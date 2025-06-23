package com.sma.smartv3.ui.device.item;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.view.View;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.sma.smartv3.co_fit.R;
import com.szabh.smable3.component.BleConnector;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class UnpairItem extends BaseDslItem {

    @oOoXoXO
    private Oox.oIX0oI<oXIO0o0XI> mOnUnbindListener;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$0(UnpairItem this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        Oox.oIX0oI<oXIO0o0XI> oix0oi = this$0.mOnUnbindListener;
        if (oix0oi != null) {
            oix0oi.invoke();
        }
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View view = itemHolder.view(R.id.btn_bottom);
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.item.Oxx0IOOO
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    UnpairItem.bindView$lambda$0(UnpairItem.this, view2);
                }
            });
        }
    }

    @oOoXoXO
    public final Oox.oIX0oI<oXIO0o0XI> getMOnUnbindListener() {
        return this.mOnUnbindListener;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        setItemHidden(!BleConnector.INSTANCE.isBound());
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.device_item_unpair;
    }

    public final void setMOnUnbindListener(@oOoXoXO Oox.oIX0oI<oXIO0o0XI> oix0oi) {
        this.mOnUnbindListener = oix0oi;
    }
}
