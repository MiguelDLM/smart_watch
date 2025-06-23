package com.baidu.navisdk.module.carlogo.views;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingExplainImageItem;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public final class BNSettingExplainCarLogoItem extends BNSettingExplainImageItem {
    public BNSettingExplainCarLogoItem(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MotorSettingLayoutExplainImage", "onFinishInflate: " + f.c().s.d);
        }
        if (f.c().s.d) {
            setTipImage(R.drawable.nsdk_icon_3d_car_logo_tip);
        }
    }

    public BNSettingExplainCarLogoItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BNSettingExplainCarLogoItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
