package com.baidu.mapclient.liteapp.pop.base;

import OXOo.OOXIXo;
import android.app.Activity;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.blankj.utilcode.util.BarUtils;
import com.szabh.navi.R;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public class BottomPopup extends BasePopup {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomPopup(@OOXIXo Activity activity) {
        super(activity);
        IIX0o.x0xO0oo(activity, "activity");
        setClippingEnabled(false);
        getMRoot().setPadding(0, BarUtils.getStatusBarHeight(), 0, BarUtils.getNavBarHeight());
    }

    @Override // com.baidu.mapclient.liteapp.pop.base.BasePopup
    public void showAlignBottom(@OOXIXo View anchor) {
        IIX0o.x0xO0oo(anchor, "anchor");
        super.showAlignBottom(anchor);
        oOXoIIIo.oIX0oI.I0Io(getMActivity(), 1.0f);
        getMRoot().setBackgroundResource(R.color.popup_root_bg_color);
        getMLayout().startAnimation(AnimationUtils.loadAnimation(getMActivity(), R.anim.pop_bottom_show_2));
    }
}
