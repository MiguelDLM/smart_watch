package com.jd.ad.sdk.jad_hu;

import android.content.Context;
import com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView;
import com.jd.ad.sdk.bl.dynamicrender.ShakeListener;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.logger.Logger;

/* loaded from: classes10.dex */
public class jad_jw extends ShakeListener {
    public final /* synthetic */ DynamicRenderView jad_pc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jad_jw(DynamicRenderView dynamicRenderView, Context context, float f, float f2, float f3) {
        super(context, f, f2, f3);
        this.jad_pc = dynamicRenderView;
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.ShakeListener
    public void onShake() {
        Logger.d("==== 摇一摇");
        DynamicRenderView dynamicRenderView = this.jad_pc;
        jad_an jad_anVar = dynamicRenderView.jad_wj.get(dynamicRenderView.jad_xk);
        if (jad_anVar != null) {
            DynamicRenderView dynamicRenderView2 = this.jad_pc;
            float f = dynamicRenderView2.jad_ju;
            float f2 = dynamicRenderView2.jad_lw;
            float f3 = dynamicRenderView2.jad_mx;
            CommonConstants.AdTriggerSourceType adTriggerSourceType = CommonConstants.AdTriggerSourceType.SHAKE;
            int ordinal = adTriggerSourceType.ordinal();
            if (f3 > 0.0f) {
                if (f > 0.0f && f2 > 0.0f) {
                    ordinal = CommonConstants.AdTriggerSourceType.SHAKE_ALL.ordinal();
                } else if (f > 0.0f) {
                    ordinal = CommonConstants.AdTriggerSourceType.SHAKE_ACCELERATION_TIME.ordinal();
                } else if (f2 > 0.0f) {
                    ordinal = CommonConstants.AdTriggerSourceType.SHAKE_ANGLE_TIME.ordinal();
                }
            } else if (f > 0.0f && f2 > 0.0f) {
                ordinal = CommonConstants.AdTriggerSourceType.SHAKE_ACCELERATION_ANGLE.ordinal();
            } else if (f > 0.0f) {
                ordinal = adTriggerSourceType.ordinal();
            } else if (f2 > 0.0f) {
                ordinal = CommonConstants.AdTriggerSourceType.SHAKE_ANGLE.ordinal();
            }
            jad_anVar.jad_dq = ordinal;
            jad_anVar.jad_an(this.jad_pc.jad_sf);
        }
    }
}
