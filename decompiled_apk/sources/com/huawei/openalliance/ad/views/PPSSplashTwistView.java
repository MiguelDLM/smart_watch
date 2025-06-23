package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.splash.R;

/* loaded from: classes10.dex */
public class PPSSplashTwistView extends PPSBaseTwistView {
    public PPSSplashTwistView(Context context) {
        super(context);
        Code(context);
    }

    private void Code(Context context) {
        String str;
        fb.V("PPSSplashTwistView", "init");
        try {
            View inflate = View.inflate(context, R.layout.hiad_layout_splash_twist, this);
            this.Code = inflate;
            this.F = (ImageView) inflate.findViewById(R.id.hiad_phone_jpg);
            this.V = (TextView) this.Code.findViewById(R.id.hiad_twist_string);
            this.I = (TextView) this.Code.findViewById(R.id.hiad_twist_desc);
        } catch (RuntimeException unused) {
            str = "init RuntimeException";
            fb.I("PPSSplashTwistView", str);
        } catch (Exception unused2) {
            str = "init error";
            fb.I("PPSSplashTwistView", str);
        }
    }

    public PPSSplashTwistView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    public PPSSplashTwistView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code(context);
    }
}
