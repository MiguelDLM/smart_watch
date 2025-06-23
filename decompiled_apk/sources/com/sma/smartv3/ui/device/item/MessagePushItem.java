package com.sma.smartv3.ui.device.item;

import OXOo.OOXIXo;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class MessagePushItem extends BaseDslItem {
    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        setItemHidden(!ProductManager.f20544oIX0oI.oOo());
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.device_item_message_push;
    }
}
