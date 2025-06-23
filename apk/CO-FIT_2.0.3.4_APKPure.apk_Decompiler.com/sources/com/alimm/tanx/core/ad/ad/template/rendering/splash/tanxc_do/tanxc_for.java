package com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.InteractiveCallback;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeBean;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.utils.DimenUtil;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.HashMap;
import java.util.Map;

public class tanxc_for extends tanxc_if {
    private long tanxc_break;
    private ShakeView tanxc_catch;
    protected ViewGroup tanxc_this;
    protected LinearLayout tanxc_void;

    public tanxc_for(@NonNull tanxc_do tanxc_do, @NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull ITanxAd iTanxAd) {
        super(tanxc_do, context, viewGroup, iTanxAd);
    }

    private void tanxc_catch() {
        HashMap hashMap = new HashMap();
        hashMap.put("add_interaction_view_time", String.valueOf(SystemClock.elapsedRealtime() - this.tanxc_break));
        TanxBaseUt.shake("add_interaction_view_time", (BidInfo) null, hashMap);
    }

    private void tanxc_if(@NonNull ViewGroup viewGroup) {
        ShakeBean shakeBean;
        LogUtils.d("ShakeInteractionTemplate", "showNativeShakeView");
        BidInfo bidInfo = this.tanxc_for;
        if (bidInfo == null || bidInfo.getTemplateConf() == null) {
            shakeBean = null;
        } else {
            shakeBean = new ShakeBean().build(this.tanxc_for.getTemplateConf());
        }
        if (this.tanxc_catch == null) {
            this.tanxc_catch = new ShakeView(this.tanxc_do, shakeBean);
        }
        this.tanxc_this.setVisibility(0);
        tanxc_catch();
        this.tanxc_catch.setClickable(false);
        this.tanxc_catch.setOnTouchListener((View.OnTouchListener) null);
        this.tanxc_catch.load(new InteractiveCallback() {
            public void destroy(String str) {
                TanxCommonUt.utShakeDestroy(tanxc_for.this.tanxc_int, str);
            }

            public void onShake() {
                LogUtils.d("ShakeInteractionTemplate", "showNativeShakeView 互动成功摇一摇跳转");
                tanxc_for.this.tanxc_break();
            }
        }, true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, DimenUtil.dp2px(this.tanxc_do, 280.0f));
        layoutParams.gravity = 80;
        viewGroup.addView(this.tanxc_catch, layoutParams);
    }

    public void tanxc_break() {
        if (!this.tanxc_char) {
            this.tanxc_char = true;
            ITanxSplashInteractionListener iTanxSplashInteractionListener = this.tanxc_long;
            if (iTanxSplashInteractionListener != null) {
                iTanxSplashInteractionListener.onAdShake();
                return;
            }
            return;
        }
        LogUtils.d("ShakeInteractionTemplate", "mClickedOnce = true");
    }

    public void tanxc_byte() {
        super.tanxc_byte();
        this.tanxc_void = (LinearLayout) this.tanxc_if.findViewById(R.id.splash_ad_interaction_root);
        this.tanxc_this = (ViewGroup) this.tanxc_if.findViewById(R.id.splash_ad_interaction_container);
        if (tanxc_void()) {
            this.tanxc_void.setVisibility(0);
            this.tanxc_this.setVisibility(0);
            tanxc_do(this.tanxc_this);
        }
    }

    public View tanxc_char() {
        return this.tanxc_catch;
    }

    public void tanxc_do(@NonNull ViewGroup viewGroup) {
        this.tanxc_break = SystemClock.elapsedRealtime();
        tanxc_if(viewGroup);
        tanxc_do(this.tanxc_for, "add_interaction_view", (Map<String, String>) null);
    }

    public void tanxc_new() {
        super.tanxc_new();
    }

    public int tanxc_try() {
        return R.id.xadsdk_splash_ad_stub_interaction;
    }

    public boolean tanxc_void() {
        return true;
    }

    public static void tanxc_do(BidInfo bidInfo, String str, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        TanxBaseUt.shake(str, bidInfo, (HashMap<String, Object>) null);
    }
}
