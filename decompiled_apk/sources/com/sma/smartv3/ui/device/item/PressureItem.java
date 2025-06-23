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
import com.szabh.smable3.entity.BlePressureTimingMeasurement;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class PressureItem extends BaseDeviceItem {
    private final boolean initEvent = true;

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public boolean getInitEvent() {
        return this.initEvent;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        setItemHidden(!ProductManager.f20544oIX0oI.xIXoO0Xx());
        if (BleConnector.INSTANCE.isBound()) {
            BlePressureTimingMeasurement blePressureTimingMeasurement = (BlePressureTimingMeasurement) BleCache.getObjectNotNull$default(BleCache.INSTANCE, BleKey.PRESSURE_TIMING_MEASUREMENT, BlePressureTimingMeasurement.class, null, null, 12, null);
            TextView tvRight = getTvRight();
            if (tvRight != null) {
                tvRight.setText(TextConvertKt.IXxxXO(blePressureTimingMeasurement.getMBleTimeRange().getMEnabled()));
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
        return R.layout.device_item_pressure;
    }

    @XO0.XO(tag = x0xO0oo.f24671xxX)
    public final void onPressureSetChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("onPressureSetChange");
        initView();
    }
}
