package com.baidu.ar.base;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.ARController;
import com.baidu.ar.DuMixSource;
import com.baidu.ar.baidumap.MapDuMix;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.kq;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class RequestController {
    private DuMixSource h;
    private MapDuMix l;
    private WeakReference<ARController> lW;
    private Context mContext;

    public RequestController(Context context, ARController aRController, DuMixSource duMixSource) {
        this.mContext = context;
        this.lW = new WeakReference<>(aRController);
        this.h = duMixSource;
        if (this.l == null && aRController != null) {
            this.l = aRController.getMapDuMix();
        }
        DuMixSource duMixSource2 = this.h;
        if (duMixSource2 != null) {
            ARConfig.setARKey(duMixSource2.getArKey());
        }
    }

    public void start() {
        if (TextUtils.isEmpty(ARConfig.getARKey())) {
            if (this.lW.get() != null) {
                this.lW.get().outputStateMessage(MsgField.MSG_NO_NETWORK_FOR_START_QUERY_RES, this);
            }
        } else if (!kq.p(this.mContext)) {
            if (this.lW.get() != null) {
                this.lW.get().outputStateMessage(MsgField.MSG_NO_NETWORK_FOR_START_QUERY_RES, this);
            }
        } else if (kq.q(this.mContext)) {
            startRequest();
        } else {
            if (!kq.s(this.mContext) || this.lW.get() == null) {
                return;
            }
            this.lW.get().outputStateMessage(MsgField.MSG_MOBILE_NETWORK_FOR_START_QUERY_RES, this);
        }
    }

    public void startRequest() {
        this.l.loadCase(this.h.getArKey());
    }
}
