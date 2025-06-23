package com.sma.smartv3.ui.device.guide;

import OXOo.oOoXoXO;
import android.os.Bundle;
import android.widget.Button;
import com.sma.smartv3.ble.MyNotificationListenerService;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public final class NotificationGuideFragment extends BaseGuideFragment {
    private final void refresh() {
        int i;
        Button btnSet = getBtnSet();
        if (MyNotificationListenerService.f20319OxI.X0o0xo(getMActivity())) {
            i = 8;
        } else {
            i = 0;
        }
        btnSet.setVisibility(i);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.sma.smartv3.ui.device.guide.BaseGuideFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getIvPic().setImageResource(R.drawable.pic_guide_notification);
        getTvTitle().setText(R.string.notification_permissions);
        getTvTip().setText(R.string.guide_notification_tip);
        refresh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        refresh();
    }

    @Override // com.sma.smartv3.ui.device.guide.BaseGuideFragment
    public void onSetClick() {
        MyNotificationListenerService.f20319OxI.II0XooXoX(getMActivity());
    }
}
