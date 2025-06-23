package com.jd.ad.sdk.bl.dynamicrender;

import android.animation.Animator;
import android.content.Context;
import com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView;
import com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicCountdownListener;
import com.jd.ad.sdk.jad_hu.jad_jw;
import com.jd.ad.sdk.logger.Logger;

/* loaded from: classes10.dex */
public class jad_an implements Animator.AnimatorListener {
    public final /* synthetic */ Context jad_an;
    public final /* synthetic */ DynamicRenderView jad_bo;

    public jad_an(DynamicRenderView dynamicRenderView, Context context) {
        this.jad_bo = dynamicRenderView;
        this.jad_an = context;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Logger.d("onAnimationCancel动画取消");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Logger.d("onAnimationEnd动画结束");
        DynamicRenderView dynamicRenderView = this.jad_bo;
        IDynamicCountdownListener iDynamicCountdownListener = dynamicRenderView.jad_do;
        if (iDynamicCountdownListener != null && dynamicRenderView.jad_ep >= 0) {
            dynamicRenderView.jad_ep = -1;
            iDynamicCountdownListener.onAdCountdown(0);
        }
        DynamicRenderView.IDynamicRenderCallback iDynamicRenderCallback = this.jad_bo.jad_cn;
        if (iDynamicRenderCallback != null) {
            iDynamicRenderCallback.onAnimationEnd();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Logger.d("onAnimationRepeat动画重复");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        if (this.jad_an == null) {
            return;
        }
        Logger.d("onAnimationStart动画开始");
        DynamicRenderView dynamicRenderView = this.jad_bo;
        if (dynamicRenderView.jad_jt == 2) {
            Context context = this.jad_an;
            if (dynamicRenderView.jad_ju == 0.0f && dynamicRenderView.jad_lw == 0.0f) {
                dynamicRenderView.jad_ju = 15.0f;
            }
            jad_jw jad_jwVar = new jad_jw(dynamicRenderView, context, dynamicRenderView.jad_ju, dynamicRenderView.jad_lw, dynamicRenderView.jad_mx);
            dynamicRenderView.jad_hu = jad_jwVar;
            jad_jwVar.register();
        }
    }
}
