package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.AdSize;
import com.facebook.login.widget.ToolTipPopup;

/* loaded from: classes7.dex */
public class dp {
    private static final int f = 5;
    private RelativeLayout c;
    private TextView d;
    private CountDownTimer e;
    private ds g;
    private Activity j;
    private Boolean k;

    /* renamed from: a, reason: collision with root package name */
    public final String f6316a = "html5_intersitial";
    private boolean h = false;
    private boolean i = false;
    protected final bv b = bv.a();

    public dp(Context context, RelativeLayout relativeLayout, Boolean bool, AdSize adSize, String str) {
    }

    private boolean e() {
        return b();
    }

    private View f() {
        this.e = new dr(this, ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME, 1000L).start();
        return this.c;
    }

    private void g() {
        RelativeLayout relativeLayout = this.c;
        if (relativeLayout != null && relativeLayout.getParent() != null) {
            ((ViewGroup) this.c.getParent()).removeView(this.c);
        }
        if (this.e != null) {
            this.b.a("cancel countDownTimer before it finished");
            try {
                this.e.cancel();
            } catch (Exception e) {
                this.b.a(e);
            }
        }
    }

    private RelativeLayout.LayoutParams h() {
        return null;
    }

    public void a() {
    }

    public boolean b() {
        if (AdSize.InterstitialForVideoBeforePlay.getValue() == 0) {
            return true;
        }
        return false;
    }

    public void c() {
        Activity activity = this.j;
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new dq(this));
    }

    public boolean d() {
        return this.h;
    }

    public void a(int i, int i2) {
    }

    public boolean a(int i, KeyEvent keyEvent) {
        return true;
    }

    public void a(Activity activity, RelativeLayout relativeLayout) {
        try {
            this.b.a("showInterstitialAdInit");
            boolean z = this.h;
            if (z && !this.i) {
                this.i = true;
                this.h = false;
                this.j = activity;
                a();
                c();
                return;
            }
            if (this.i) {
                this.b.b("interstitial ad is showing now");
            } else {
                if (z) {
                    return;
                }
                this.b.b("interstitial ad is not ready");
            }
        } catch (Exception e) {
            this.b.a(e);
        }
    }
}
