package com.sma.smartv3.ui.device.item;

import OXOo.OOXIXo;
import android.widget.TextView;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.x0xO0oo;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleDrinkWaterSettings;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class DrinkWaterItem extends BaseDeviceItem {
    private final boolean initEvent = true;

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public boolean getInitEvent() {
        return this.initEvent;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        setItemHidden(!ProductManager.f20544oIX0oI.XOo0());
        if (BleConnector.INSTANCE.isBound()) {
            BleDrinkWaterSettings bleDrinkWaterSettings = (BleDrinkWaterSettings) BleCache.getObjectNotNull$default(BleCache.INSTANCE, BleKey.DRINK_WATER, BleDrinkWaterSettings.class, null, null, 12, null);
            TextView tvRight = getTvRight();
            if (tvRight != null) {
                tvRight.setText(TextConvertKt.IXxxXO(bleDrinkWaterSettings.getMEnabled()));
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
        return R.layout.device_item_drink_water;
    }

    @XO0.XO(tag = x0xO0oo.f24588O0xOxO)
    public final void onDrinkWaterChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        initView();
    }
}
