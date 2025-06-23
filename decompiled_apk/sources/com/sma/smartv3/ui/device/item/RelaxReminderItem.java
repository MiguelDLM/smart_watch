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
import com.szabh.smable3.entity.BleRelaxReminder;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class RelaxReminderItem extends BaseDeviceItem {
    private final boolean initEvent = true;

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public boolean getInitEvent() {
        return this.initEvent;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        setItemHidden(!ProductManager.f20544oIX0oI.XXO0());
        if (BleConnector.INSTANCE.isBound()) {
            BleRelaxReminder bleRelaxReminder = (BleRelaxReminder) BleCache.getObjectNotNull$default(BleCache.INSTANCE, BleKey.RELAX_REMINDER, BleRelaxReminder.class, null, null, 12, null);
            TextView tvRight = getTvRight();
            if (tvRight != null) {
                tvRight.setText(TextConvertKt.IXxxXO(bleRelaxReminder.getMBleTimeRange().getMEnabled()));
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
        return R.layout.device_item_relax_reminder;
    }

    @XO0.XO(tag = x0xO0oo.f24606XI0IXoo)
    public final void onRelaxReminderChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("onRelaxReminderChange");
        initView();
    }
}
