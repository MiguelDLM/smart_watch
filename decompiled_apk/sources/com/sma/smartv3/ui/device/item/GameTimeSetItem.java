package com.sma.smartv3.ui.device.item;

import android.widget.TextView;
import com.blankj.utilcode.util.Utils;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleGameTimeReminder;

/* loaded from: classes12.dex */
public final class GameTimeSetItem extends BaseDeviceItem {
    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        String string;
        setItemHidden(!ProductManager.f20544oIX0oI.OIIXOxo());
        if (BleConnector.INSTANCE.isBound()) {
            BleGameTimeReminder bleGameTimeReminder = (BleGameTimeReminder) BleCache.getObjectNotNull$default(BleCache.INSTANCE, BleKey.GAME_TIME_REMINDER, BleGameTimeReminder.class, null, null, 12, null);
            TextView tvRight = getTvRight();
            if (tvRight != null) {
                if (bleGameTimeReminder.getMEnabled() == 0) {
                    string = Utils.getApp().getString(R.string.off);
                } else {
                    string = Utils.getApp().getString(R.string.d_minutes, Integer.valueOf(bleGameTimeReminder.getMMinute()));
                }
                tvRight.setText(string);
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
        return R.layout.device_item_game_time_set;
    }
}
