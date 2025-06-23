package com.sma.smartv3.ui.device.item;

import OXOo.OOXIXo;
import android.widget.TextView;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.x0xO0oo;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleGirlCareSettings;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class HealthCareItem extends BaseDeviceItem {
    private final boolean initEvent = true;

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public boolean getInitEvent() {
        return this.initEvent;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        setItemHidden(!ProjectManager.f19822oIX0oI.I0oOIX());
        if (!getItemHidden()) {
            if (BleConnector.INSTANCE.isBound()) {
                BleGirlCareSettings bleGirlCareSettings = (BleGirlCareSettings) BleCache.getObjectNotNull$default(BleCache.INSTANCE, BleKey.GIRL_CARE, BleGirlCareSettings.class, null, null, 12, null);
                TextView tvRight = getTvRight();
                if (tvRight != null) {
                    tvRight.setText(TextConvertKt.IXxxXO(bleGirlCareSettings.getMEnabled()));
                }
            } else {
                TextView tvRight2 = getTvRight();
                if (tvRight2 != null) {
                    tvRight2.setText("");
                }
            }
        }
        TextView tvLeft = getTvLeft();
        if (tvLeft != null) {
            tvLeft.setText(ProductManager.f20544oIX0oI.xxX());
        }
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.device_item_health_care;
    }

    @XO0.XO(tag = x0xO0oo.f24599OxI)
    public final void onGirlCareChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        initView();
    }
}
