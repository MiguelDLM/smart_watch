package com.sma.smartv3.ui.device.item;

import android.widget.TextView;
import com.blankj.utilcode.util.Utils;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;

/* loaded from: classes12.dex */
public final class WearWayItem extends BaseDeviceItem {
    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        setItemHidden(!ProductManager.f20544oIX0oI.IoxX());
        if (BleConnector.INSTANCE.isBound()) {
            TextView tvRight = getTvRight();
            if (tvRight != null) {
                tvRight.setText(Utils.getApp().getResources().getStringArray(R.array.wear_way)[BleCache.getInt$default(BleCache.INSTANCE, BleKey.WEAR_WAY, 0, null, 6, null)]);
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
        return R.layout.device_item_wear_way;
    }
}
