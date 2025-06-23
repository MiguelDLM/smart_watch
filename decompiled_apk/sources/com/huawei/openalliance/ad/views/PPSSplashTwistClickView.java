package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.splash.R;

/* loaded from: classes10.dex */
public class PPSSplashTwistClickView extends PPSBaseTwistView {
    private LinearLayout L;

    public PPSSplashTwistClickView(Context context) {
        super(context);
        Code(context);
    }

    private void Code(Context context) {
        String str;
        fb.V("PPSSplashTwistClickView", "init");
        try {
            View inflate = View.inflate(context, R.layout.hiad_layout_splash_twist_click, this);
            this.Code = inflate;
            this.F = (ImageView) inflate.findViewById(R.id.hiad_click_phone_jpg);
            this.L = (LinearLayout) this.Code.findViewById(R.id.twist_click_area);
            this.V = (TextView) this.Code.findViewById(R.id.hiad_click_twist_string);
            this.I = (TextView) this.Code.findViewById(R.id.hiad_click_twist_desc);
        } catch (RuntimeException unused) {
            str = "init RuntimeException";
            fb.I("PPSSplashTwistClickView", str);
        } catch (Exception unused2) {
            str = "init error";
            fb.I("PPSSplashTwistClickView", str);
        }
    }

    public LinearLayout getClickAreaView() {
        return this.L;
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseTwistView
    public String getViewTag() {
        return "PPSSplashTwistClickView";
    }

    public PPSSplashTwistClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    public PPSSplashTwistClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code(context);
    }
}
