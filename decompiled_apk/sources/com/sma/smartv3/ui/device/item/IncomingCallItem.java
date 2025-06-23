package com.sma.smartv3.ui.device.item;

import android.widget.TextView;
import com.blankj.utilcode.util.PermissionUtils;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.device.X00xOoXI;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.szabh.smable3.component.BleConnector;
import java.util.Arrays;

/* loaded from: classes12.dex */
public final class IncomingCallItem extends BaseDeviceItem {
    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        boolean z;
        int i = 0;
        if (!ProjectManager.f19822oIX0oI.xoIxX() || !ProductManager.f20544oIX0oI.IoIOOxIIo()) {
            z = true;
        } else {
            z = false;
        }
        setItemHidden(z);
        if (BleConnector.INSTANCE.isBound()) {
            boolean z2 = Xo0.f24349oIX0oI.I0Io().getBoolean(XoI0Ixx0.f24358II0xO0, false);
            TextView tvRight = getTvRight();
            if (tvRight != null) {
                if (z2) {
                    String[] oIX0oI2 = X00xOoXI.oIX0oI();
                    if (PermissionUtils.isGranted((String[]) Arrays.copyOf(oIX0oI2, oIX0oI2.length))) {
                        i = 1;
                    }
                }
                tvRight.setText(TextConvertKt.IXxxXO(i));
                return;
            }
            return;
        }
        setItemHidden(true);
        TextView tvRight2 = getTvRight();
        if (tvRight2 != null) {
            tvRight2.setText("");
        }
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.device_item_incoming_call;
    }
}
