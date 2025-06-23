package com.sma.smartv3.ui.device.item;

import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.FileTransmissionKt;
import com.szabh.smable3.entity.BleAppInfo;

/* loaded from: classes12.dex */
public final class ReceiptCode2Item extends BaseDeviceItem {
    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        ProductManager productManager = ProductManager.f20544oIX0oI;
        boolean z = true;
        if (!productManager.OIxOX() ? productManager.oxOIoIx() : FileTransmissionKt.appStoreIsShowCurrentCategory(BleAppInfo.PACKAGE_CARD_WALLET) && productManager.oxOIoIx()) {
            z = false;
        }
        setItemHidden(z);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.device_item_receipt_code;
    }
}
