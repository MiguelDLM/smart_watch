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
import com.szabh.smable3.entity.BleEcgSettings;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class EcgMonitoringItem extends BaseDeviceItem {
    private final boolean initEvent = true;

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public boolean getInitEvent() {
        return this.initEvent;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        ProductManager productManager = ProductManager.f20544oIX0oI;
        setItemHidden(!productManager.I0());
        if (!getItemHidden()) {
            if (BleConnector.INSTANCE.isBound()) {
                BleEcgSettings bleEcgSettings = (BleEcgSettings) BleCache.getObjectNotNull$default(BleCache.INSTANCE, BleKey.ECG_SET, BleEcgSettings.class, null, null, 12, null);
                TextView tvRight = getTvRight();
                if (tvRight != null) {
                    tvRight.setText(TextConvertKt.IXxxXO(productManager.oX0I0O(bleEcgSettings.getMBleTimeRange().getMEnabled()) ? 1 : 0));
                    return;
                }
                return;
            }
            TextView tvRight2 = getTvRight();
            if (tvRight2 != null) {
                tvRight2.setText("");
            }
        }
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.device_item_ecg_monitoring;
    }

    @XO0.XO(tag = x0xO0oo.f24665xoXoI)
    public final void onEcgMonitoringChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        initView();
    }
}
