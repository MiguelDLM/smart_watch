package com.sma.smartv3.ui.device.guide;

import OXOo.oOoXoXO;
import android.os.Bundle;
import android.widget.Button;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.permission.PermissionHelper;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class BgRunGuideFragment extends BaseGuideFragment {
    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.sma.smartv3.ui.device.guide.BaseGuideFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        int i;
        super.initView();
        getIvPic().setImageResource(R.drawable.pic_guide_bg_run);
        getTvTitle().setText(R.string.battery_permissions);
        getTvTip().setText(R.string.guide_battery_tip);
        Button btnSet = getBtnSet();
        if (PermissionHelper.f24522oIX0oI.o00(getMActivity())) {
            i = 8;
        } else {
            i = 0;
        }
        btnSet.setVisibility(i);
    }

    @Override // com.sma.smartv3.ui.device.guide.BaseGuideFragment
    public void onSetClick() {
        PermissionHelper.f24522oIX0oI.II0XooXoX(getMActivity(), new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.guide.BgRunGuideFragment$onSetClick$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(boolean z) {
                BgRunGuideFragment.this.initView();
            }
        });
    }
}
