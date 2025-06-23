package com.sma.smartv3.ui.device.item;

import OXOo.OOXIXo;
import android.widget.TextView;
import com.blankj.utilcode.util.LogUtils;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.x0xO0oo;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleHrMonitoringSettings;
import com.szabh.smable3.entity.BleHrWarningSettings;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class HrMonitoringItem extends BaseDeviceItem {
    private final boolean initEvent = true;

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public boolean getInitEvent() {
        return this.initEvent;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        boolean z;
        int i;
        int i2;
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (!productManager.Ox0O() && !productManager.XIxO()) {
            z = true;
        } else {
            z = false;
        }
        setItemHidden(z);
        if (!getItemHidden()) {
            BleConnector bleConnector = BleConnector.INSTANCE;
            if (bleConnector.isBound() && productManager.Ox0O() && productManager.OOOox()) {
                BleCache bleCache = BleCache.INSTANCE;
                BleHrMonitoringSettings bleHrMonitoringSettings = (BleHrMonitoringSettings) BleCache.getObjectNotNull$default(bleCache, BleKey.HR_MONITORING, BleHrMonitoringSettings.class, null, null, 12, null);
                if (productManager.XIxO()) {
                    BleHrWarningSettings bleHrWarningSettings = (BleHrWarningSettings) BleCache.getObjectNotNull$default(bleCache, BleKey.HR_WARNING_SET, BleHrWarningSettings.class, null, null, 12, null);
                    int mHighSwitch = bleHrWarningSettings.getMHighSwitch();
                    int mLowSwitch = bleHrWarningSettings.getMLowSwitch();
                    boolean oX0I0O2 = productManager.oX0I0O(bleHrMonitoringSettings.getMBleTimeRange().getMEnabled());
                    TextView tvRight = getTvRight();
                    if (tvRight != null) {
                        if (mHighSwitch != 1 && mLowSwitch != 1 && !oX0I0O2) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        tvRight.setText(TextConvertKt.IXxxXO(i2));
                    }
                    LogUtils.i("HrMonitoringItem", String.valueOf(mHighSwitch), Integer.valueOf(mLowSwitch), Boolean.valueOf(oX0I0O2));
                    return;
                }
                TextView tvRight2 = getTvRight();
                if (tvRight2 != null) {
                    tvRight2.setText(TextConvertKt.IXxxXO(productManager.oX0I0O(bleHrMonitoringSettings.getMBleTimeRange().getMEnabled()) ? 1 : 0));
                }
                LogUtils.i("HrMonitoringItem", Integer.valueOf(bleHrMonitoringSettings.getMBleTimeRange().getMEnabled()));
                return;
            }
            if (bleConnector.isBound() && productManager.XIxO()) {
                BleHrWarningSettings bleHrWarningSettings2 = (BleHrWarningSettings) BleCache.getObjectNotNull$default(BleCache.INSTANCE, BleKey.HR_WARNING_SET, BleHrWarningSettings.class, null, null, 12, null);
                int mHighSwitch2 = bleHrWarningSettings2.getMHighSwitch();
                int mLowSwitch2 = bleHrWarningSettings2.getMLowSwitch();
                TextView tvRight3 = getTvRight();
                if (tvRight3 != null) {
                    if (mHighSwitch2 != 1 && mLowSwitch2 != 1) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    tvRight3.setText(TextConvertKt.IXxxXO(i));
                }
                LogUtils.i("HrMonitoringItem2", String.valueOf(mHighSwitch2), Integer.valueOf(mLowSwitch2));
                return;
            }
            TextView tvRight4 = getTvRight();
            if (tvRight4 != null) {
                tvRight4.setText("");
            }
        }
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.device_item_heart_rate_monitoring;
    }

    @XO0.XO(tag = x0xO0oo.f24570IIXOooo)
    public final void onHrMonitoringChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("onHrMonitoringChange");
        initView();
    }
}
