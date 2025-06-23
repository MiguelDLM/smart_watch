package com.sma.smartv3.ui.device.item;

import OXOo.OOXIXo;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.FileTransmissionKt;
import com.szabh.smable3.entity.BleAppInfo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class HardWareAlipayItem extends BaseDslItem {
    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        ProductManager productManager = ProductManager.f20544oIX0oI;
        boolean z = false;
        if (!productManager.OIxOX() ? !productManager.xooxxX() : !FileTransmissionKt.appStoreIsShowCurrentCategory(BleAppInfo.PACKAGE_ALIPAY)) {
            z = true;
        }
        setItemHidden(z);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.device_item_hard_ware_alipay;
    }
}
