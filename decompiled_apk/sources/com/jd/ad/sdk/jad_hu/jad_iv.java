package com.jd.ad.sdk.jad_hu;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView;
import com.jd.ad.sdk.dl.common.CommonConstants;

/* loaded from: classes10.dex */
public class jad_iv implements View.OnTouchListener {
    public String jad_an = "";
    public String jad_bo = "";
    public int jad_cp;
    public int jad_dq;
    public final /* synthetic */ Context jad_er;
    public final /* synthetic */ DynamicRenderView jad_fs;

    public jad_iv(DynamicRenderView dynamicRenderView, Context context) {
        this.jad_fs = dynamicRenderView;
        this.jad_er = context;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                DynamicRenderView dynamicRenderView = this.jad_fs;
                boolean jad_an = DynamicRenderView.jad_an(dynamicRenderView, this.jad_er, this.jad_cp, this.jad_dq, x, y, (int) dynamicRenderView.jad_kv);
                this.jad_bo = DynamicRenderView.jad_an(this.jad_fs, x, y);
                if (!TextUtils.isEmpty(this.jad_an) && !TextUtils.isEmpty(this.jad_bo) && this.jad_an.equals(this.jad_bo)) {
                    if (this.jad_bo.equals("sdkInteractiveShake")) {
                        return false;
                    }
                    jad_an jad_anVar = this.jad_fs.jad_wj.get(this.jad_bo);
                    int ordinal = CommonConstants.AdTriggerSourceType.CLICK.ordinal();
                    if (!TextUtils.isEmpty(this.jad_an) && this.jad_an.equals(this.jad_fs.jad_xk) && this.jad_fs.jad_jt == 3 && jad_an) {
                        ordinal = CommonConstants.AdTriggerSourceType.SLIDE_UP.ordinal();
                    }
                    if (jad_anVar != null) {
                        jad_anVar.jad_dq = ordinal;
                        jad_anVar.jad_an(view);
                        return true;
                    }
                } else if (this.jad_fs.jad_jt == 3 && jad_an) {
                    int ordinal2 = CommonConstants.AdTriggerSourceType.SLIDE_UP.ordinal();
                    DynamicRenderView dynamicRenderView2 = this.jad_fs;
                    jad_an jad_anVar2 = dynamicRenderView2.jad_wj.get(dynamicRenderView2.jad_xk);
                    if (jad_anVar2 != null) {
                        jad_anVar2.jad_dq = ordinal2;
                        jad_anVar2.jad_an(view);
                        return true;
                    }
                }
            }
        } else {
            this.jad_an = DynamicRenderView.jad_an(this.jad_fs, x, y);
            this.jad_cp = x;
            this.jad_dq = y;
        }
        return false;
    }
}
