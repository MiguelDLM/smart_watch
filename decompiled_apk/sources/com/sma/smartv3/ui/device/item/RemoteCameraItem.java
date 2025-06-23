package com.sma.smartv3.ui.device.item;

import OXOo.OOXIXo;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.szabh.smable3.component.BleConnector;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class RemoteCameraItem extends BaseDslItem {
    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        boolean z;
        if (ProductManager.f20544oIX0oI.XI0oooXX() && BleConnector.INSTANCE.isBound()) {
            z = false;
        } else {
            z = true;
        }
        setItemHidden(z);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.device_item_remote_camera;
    }
}
