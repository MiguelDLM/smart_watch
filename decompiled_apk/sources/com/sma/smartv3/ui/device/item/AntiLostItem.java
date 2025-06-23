package com.sma.smartv3.ui.device.item;

import android.widget.TextView;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.TextConvertKt;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;

/* loaded from: classes12.dex */
public final class AntiLostItem extends BaseDeviceItem {
    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        setItemHidden(!ProductManager.f20544oIX0oI.XOxoX());
        if (BleConnector.INSTANCE.isBound()) {
            TextView tvRight = getTvRight();
            if (tvRight != null) {
                tvRight.setText(TextConvertKt.IXxxXO(BleCache.getInt$default(BleCache.INSTANCE, BleKey.ANTI_LOST, 0, null, 6, null)));
                return;
            }
            return;
        }
        TextView tvRight2 = getTvRight();
        if (tvRight2 != null) {
            tvRight2.setText("");
        }
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.device_item_anti_lost;
    }
}
