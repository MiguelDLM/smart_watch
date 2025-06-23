package com.sma.smartv3.ui.device.item;

import android.widget.TextView;
import com.blankj.utilcode.util.Utils;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;

/* loaded from: classes12.dex */
public final class DateFormatItem extends BaseDeviceItem {
    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        setItemHidden(!projectManager.oX());
        if (BleConnector.INSTANCE.isBound()) {
            TextView tvRight = getTvRight();
            if (tvRight != null) {
                tvRight.setText(Utils.getApp().getResources().getStringArray(R.array.date_format)[BleCache.getInt$default(BleCache.INSTANCE, BleKey.DATE_FORMAT, projectManager.x0XOIxOo().getType(), null, 4, null)]);
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
        return R.layout.device_item_date_format;
    }
}
