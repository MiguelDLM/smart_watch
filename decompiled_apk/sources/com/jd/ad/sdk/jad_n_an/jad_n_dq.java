package com.jd.ad.sdk.jad_n_an;

import com.jd.ad.sdk.dl.event.JADVideoReporter;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class jad_n_dq implements JADVideoReporter {
    public JADSlot jad_n_an;

    public jad_n_dq(JADSlot jADSlot) {
        this.jad_n_an = jADSlot;
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoCompleted(float f) {
        if (this.jad_n_an == null) {
            return;
        }
        JADMediator.getInstance().getEventService().reportVideoEvent(this.jad_n_an.getRequestId(), this.jad_n_an.getSlotID(), this.jad_n_an.getAdType(), this.jad_n_an.getTemplateId(), this.jad_n_an.getSen(), this.jad_n_an.getRem(), this.jad_n_an.getScdu(), this.jad_n_an.getDcdu(), this.jad_n_an.getEcdu(), this.jad_n_an.getSspt(), this.jad_n_an.getScav(), this.jad_n_an.getEventInteractionType(), this.jad_n_an.getAtst(), this.jad_n_an.getModelClickAreaType(), this.jad_n_an.getDstp(), this.jad_n_an.getSrtp(), 4, f);
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoError(float f, int i, int i2) {
        String str;
        JADSlot jADSlot = this.jad_n_an;
        if (jADSlot != null) {
            str = jADSlot.getRequestId();
        } else {
            str = "";
        }
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, "duration", Float.valueOf(f));
        JsonUtils.put(jSONObject, "errorCode", Integer.valueOf(i));
        JsonUtils.put(jSONObject, "extraCode", Integer.valueOf(i2));
        JADMediator.getInstance().getEventService().reportVideoExceptionEvent(str, 11, jSONObject.toString());
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoPause(float f) {
        if (this.jad_n_an == null) {
            return;
        }
        JADMediator.getInstance().getEventService().reportVideoEvent(this.jad_n_an.getRequestId(), this.jad_n_an.getSlotID(), this.jad_n_an.getAdType(), this.jad_n_an.getTemplateId(), this.jad_n_an.getSen(), this.jad_n_an.getRem(), this.jad_n_an.getScdu(), this.jad_n_an.getDcdu(), this.jad_n_an.getEcdu(), this.jad_n_an.getSspt(), this.jad_n_an.getScav(), this.jad_n_an.getEventInteractionType(), this.jad_n_an.getAtst(), this.jad_n_an.getModelClickAreaType(), this.jad_n_an.getDstp(), this.jad_n_an.getSrtp(), 3, f);
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoResume(float f) {
        if (this.jad_n_an == null) {
            return;
        }
        JADMediator.getInstance().getEventService().reportVideoEvent(this.jad_n_an.getRequestId(), this.jad_n_an.getSlotID(), this.jad_n_an.getAdType(), this.jad_n_an.getTemplateId(), this.jad_n_an.getSen(), this.jad_n_an.getRem(), this.jad_n_an.getScdu(), this.jad_n_an.getDcdu(), this.jad_n_an.getEcdu(), this.jad_n_an.getSspt(), this.jad_n_an.getScav(), this.jad_n_an.getEventInteractionType(), this.jad_n_an.getAtst(), this.jad_n_an.getModelClickAreaType(), this.jad_n_an.getDstp(), this.jad_n_an.getSrtp(), 5, f);
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoStart(float f) {
        if (this.jad_n_an == null) {
            return;
        }
        JADMediator.getInstance().getEventService().reportVideoEvent(this.jad_n_an.getRequestId(), this.jad_n_an.getSlotID(), this.jad_n_an.getAdType(), this.jad_n_an.getTemplateId(), this.jad_n_an.getSen(), this.jad_n_an.getRem(), this.jad_n_an.getScdu(), this.jad_n_an.getDcdu(), this.jad_n_an.getEcdu(), this.jad_n_an.getSspt(), this.jad_n_an.getScav(), this.jad_n_an.getEventInteractionType(), this.jad_n_an.getAtst(), this.jad_n_an.getModelClickAreaType(), this.jad_n_an.getDstp(), this.jad_n_an.getSrtp(), 2, f);
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoWillStart() {
        if (this.jad_n_an == null) {
            return;
        }
        JADMediator.getInstance().getEventService().reportVideoEvent(this.jad_n_an.getRequestId(), this.jad_n_an.getSlotID(), this.jad_n_an.getAdType(), this.jad_n_an.getTemplateId(), this.jad_n_an.getSen(), this.jad_n_an.getRem(), this.jad_n_an.getScdu(), this.jad_n_an.getDcdu(), this.jad_n_an.getEcdu(), this.jad_n_an.getSspt(), this.jad_n_an.getScav(), this.jad_n_an.getEventInteractionType(), this.jad_n_an.getAtst(), this.jad_n_an.getModelClickAreaType(), this.jad_n_an.getDstp(), this.jad_n_an.getSrtp(), 1, 0.0f);
    }
}
