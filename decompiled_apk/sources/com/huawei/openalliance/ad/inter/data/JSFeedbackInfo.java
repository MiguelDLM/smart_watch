package com.huawei.openalliance.ad.inter.data;

import com.huawei.openalliance.ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes10.dex */
public class JSFeedbackInfo extends FeedbackInfo {
    private String idStr;

    public JSFeedbackInfo(FeedbackInfo feedbackInfo) {
        if (feedbackInfo != null) {
            Code(feedbackInfo.I());
            Code(feedbackInfo.V());
            Code(feedbackInfo.Code());
            V(String.valueOf(feedbackInfo.I()));
        }
    }

    public String B() {
        return this.idStr;
    }

    public void V(String str) {
        this.idStr = str;
    }
}
