package com.sma.smartv3.ui.device.item;

import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public final class BacCalibrationItem extends BaseDeviceItem {
    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        setItemHidden(!ProductManager.f20544oIX0oI.x0oox0());
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.device_item_bac_calibration;
    }
}
