package com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.utils.CountDownComponent;
import com.alimm.tanx.core.utils.LogUtils;

/* loaded from: classes.dex */
public abstract class tanxc_do {
    protected CountDownComponent tanxc_byte;
    protected boolean tanxc_case = true;
    protected boolean tanxc_char = false;
    protected Context tanxc_do;
    protected View tanxc_else;
    protected BidInfo tanxc_for;
    protected View tanxc_goto;
    protected ViewGroup tanxc_if;
    protected ITanxAd tanxc_int;
    protected ViewStub tanxc_new;
    protected com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do tanxc_try;

    public tanxc_do(@NonNull com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do tanxc_doVar, @NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull ITanxAd iTanxAd) {
        if (iTanxAd != null && iTanxAd.getBidInfo() != null) {
            this.tanxc_do = context;
            this.tanxc_if = viewGroup;
            this.tanxc_int = iTanxAd;
            this.tanxc_for = iTanxAd.getBidInfo();
            this.tanxc_try = tanxc_doVar;
            this.tanxc_if.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do.1
                @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                public void onWindowFocusChanged(boolean z) {
                    LogUtils.d("BaseTemplate", "onWindowFocusChanged:" + z);
                    if (z) {
                        tanxc_do.this.tanxc_int();
                    } else {
                        tanxc_do.this.tanxc_for();
                    }
                }
            });
            if (this.tanxc_new == null) {
                ViewStub viewStub = (ViewStub) this.tanxc_if.findViewById(tanxc_try());
                this.tanxc_new = viewStub;
                viewStub.inflate();
                this.tanxc_new.setVisibility(4);
            }
            tanxc_byte();
            tanxc_case();
        }
    }

    private void tanxc_void() {
        if (this.tanxc_byte == null) {
            this.tanxc_byte = new CountDownComponent((TextView) this.tanxc_if.findViewById(R.id.splash_ad_txt_count_down), 5, new CountDownComponent.OnFinishListener() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do.2
                @Override // com.alimm.tanx.core.utils.CountDownComponent.OnFinishListener
                public void onFinish() {
                    tanxc_do.this.tanxc_try.tanxc_new();
                }
            });
        }
        this.tanxc_byte.tanxc_do();
    }

    public void tanxc_byte() {
        this.tanxc_goto = tanxc_else();
        this.tanxc_else = tanxc_goto();
        LogUtils.d("BaseTemplate", "initView mTemplateViewStub.getVisibility" + this.tanxc_new.getVisibility());
    }

    public void tanxc_case() {
        this.tanxc_goto.setOnClickListener(new View.OnClickListener() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    public abstract View tanxc_char();

    public void tanxc_do() {
        if (this.tanxc_new != null) {
            LogUtils.d("BaseTemplate", "onContentShowStart mTemplateViewStub.getVisibility" + this.tanxc_new.getVisibility());
            this.tanxc_new.setVisibility(0);
            tanxc_void();
        }
    }

    public abstract View tanxc_else();

    public void tanxc_for() {
        CountDownComponent countDownComponent = this.tanxc_byte;
        if (countDownComponent != null) {
            countDownComponent.tanxc_for();
        }
    }

    public abstract View tanxc_goto();

    public void tanxc_if() {
        this.tanxc_try.tanxc_else();
    }

    public void tanxc_int() {
        CountDownComponent countDownComponent = this.tanxc_byte;
        if (countDownComponent != null) {
            countDownComponent.tanxc_int();
        }
    }

    public abstract View tanxc_long();

    public void tanxc_new() {
        CountDownComponent countDownComponent = this.tanxc_byte;
        if (countDownComponent != null) {
            countDownComponent.tanxc_if();
        }
    }

    public void tanxc_this() {
        LogUtils.d("BaseTemplate", "notifyViewClick: mClickedOnce = " + this.tanxc_char + "mAdClickable = " + this.tanxc_case);
        if (!this.tanxc_char) {
            this.tanxc_char = true;
            if (this.tanxc_case) {
                tanxc_for();
            }
        }
    }

    public abstract int tanxc_try();
}
