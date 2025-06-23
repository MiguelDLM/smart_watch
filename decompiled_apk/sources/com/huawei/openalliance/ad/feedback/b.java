package com.huawei.openalliance.ad.feedback;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.w;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class b {
    private List<FeedbackInfo> B;
    private FeedbackInfo C;
    private AdContentData I;
    private Context S;
    private d V;
    private List<FeedbackInfo> Z;

    public b(FeedbackView feedbackView) {
        this.V = feedbackView;
    }

    public boolean B() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.aQ();
        }
        return false;
    }

    public String C() {
        AdContentData adContentData = this.I;
        return adContentData != null ? adContentData.aP() : "";
    }

    public List<FeedbackInfo> Code() {
        return this.Z;
    }

    public FeedbackInfo I() {
        return this.C;
    }

    public List<FeedbackInfo> V() {
        return this.B;
    }

    public boolean Z() {
        fb.V("FeedbackPresenter", "click complain");
        if (this.C == null || this.S == null || this.I == null) {
            return false;
        }
        try {
            Intent intent = new Intent();
            intent.putExtra(bb.G, this.S.getPackageName());
            intent.putExtra("slotid", this.I.L());
            intent.putExtra("content_id", this.I.a());
            intent.putExtra("apiVer", this.I.aF());
            intent.putExtra(bb.aB, this.C.Code());
            intent.setAction(x.cS);
            intent.setPackage(w.Z(this.S));
            if (!(this.S instanceof Activity)) {
                intent.addFlags(268435456);
            }
            bc.Code(this.S, intent);
        } catch (Throwable th) {
            fb.I("FeedbackPresenter", "start ac failed: %s", th.getClass().getSimpleName());
        }
        return true;
    }

    public void Code(Context context, AdContentData adContentData) {
        List<FeedbackInfo> list;
        this.S = context;
        if (adContentData == null || ad.Code(adContentData.aC())) {
            return;
        }
        this.I = adContentData;
        List<FeedbackInfo> aC = adContentData.aC();
        this.B = new ArrayList();
        this.Z = new ArrayList();
        for (FeedbackInfo feedbackInfo : aC) {
            if (feedbackInfo != null) {
                int V = feedbackInfo.V();
                if (V == 1) {
                    list = this.B;
                } else if (V == 2) {
                    list = this.Z;
                } else if (V != 3) {
                    fb.Code("FeedbackPresenter", "invalid feedback type");
                } else {
                    this.C = feedbackInfo;
                }
                list.add(feedbackInfo);
            }
        }
        this.V.Code();
    }

    public boolean Code(Context context) {
        AdContentData adContentData = this.I;
        if (adContentData == null) {
            return false;
        }
        return w.Code(context, adContentData);
    }
}
