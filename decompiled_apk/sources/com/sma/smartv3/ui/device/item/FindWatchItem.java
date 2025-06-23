package com.sma.smartv3.ui.device.item;

import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.szabh.smable3.component.BleConnector;

/* loaded from: classes12.dex */
public final class FindWatchItem extends BaseDeviceItem {
    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        boolean z;
        if (BleConnector.INSTANCE.isBound() && ProductManager.f20544oIX0oI.xo()) {
            z = false;
        } else {
            z = true;
        }
        setItemHidden(z);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.device_item_find_watch;
    }
}
