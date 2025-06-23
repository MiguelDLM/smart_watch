package com.sma.smartv3.ui.device.guide;

import OXOo.oOoXoXO;
import android.os.Bundle;
import android.widget.Button;
import com.blankj.utilcode.util.AppUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.permission.PermissionHelper;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class BgLocationGuideFragment extends BaseGuideFragment {
    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.sma.smartv3.ui.device.guide.BaseGuideFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getIvPic().setImageResource(R.drawable.pic_guide_location);
        getTvTitle().setText(R.string.location_permissions);
        int i = 0;
        getTvTip().setText(getString(R.string.location_permissions_tip, AppUtils.getAppName(), AppUtils.getAppName()));
        Button btnSet = getBtnSet();
        if (PermissionHelper.f24522oIX0oI.OxI(getMActivity())) {
            i = 8;
        }
        btnSet.setVisibility(i);
    }

    @Override // com.sma.smartv3.ui.device.guide.BaseGuideFragment
    public void onSetClick() {
        PermissionHelper.xoIox(PermissionHelper.f24522oIX0oI, getMActivity(), false, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.guide.BgLocationGuideFragment$onSetClick$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(boolean z) {
                BgLocationGuideFragment.this.initView();
            }
        }, 2, null);
    }
}
