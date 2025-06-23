package com.huawei.openalliance.ad.inter.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.df;
import com.huawei.hms.ads.dh;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.iz;
import com.huawei.hms.ads.ja;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.listeners.INonwifiActionListener;
import com.huawei.openalliance.ad.utils.w;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class q extends a implements i {
    private com.huawei.openalliance.ad.beans.metadata.VideoInfo B;
    private boolean C;
    private boolean D;
    private transient INonwifiActionListener F;
    private RewardItem L;
    private transient com.huawei.openalliance.ad.inter.listeners.g S;
    private com.huawei.openalliance.ad.inter.listeners.h c;
    private int d;
    private boolean e;
    private boolean f;
    private VideoConfiguration g;

    public q(AdContentData adContentData) {
        super(adContentData);
        this.C = false;
        this.d = 1;
        this.e = true;
        this.f = true;
        if (adContentData.N() == null || adContentData.O() == 0) {
            return;
        }
        this.L = new RewardItem(adContentData.N(), adContentData.O());
    }

    private void V(Context context) {
        fb.V("RewardAd", "startRewardViaAidl");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content_id", a());
            jSONObject.put("slotid", o());
            jSONObject.put("sdk_version", "13.4.72.300");
            jSONObject.put("request_id", q());
            jSONObject.put(bb.i, this.d);
            jSONObject.put(bb.j, Code());
            jSONObject.put(bb.e, r());
            jSONObject.put(bb.P, J());
            jSONObject.put(bb.M, af());
            jSONObject.put(bb.Q, n_());
            jSONObject.put("apiVer", this.Code.aF());
            jSONObject.put("templateId", ac());
            if (this.F != null) {
                if (ag() != null) {
                    jSONObject.put("reward_key_nonwifi_action_play", this.F.Code(r2.B()));
                }
                AppInfo y = y();
                if (y != null) {
                    jSONObject.put("reward_key_nonwifi_action_download", this.F.Code(y, y.B()));
                }
            }
            AppInfo y2 = y();
            if (y2 != null && !TextUtils.isEmpty(y2.e())) {
                jSONObject.put("unique_id", y2.e());
            }
            com.huawei.openalliance.ad.ipc.g.V(context).Code("showReward", jSONObject.toString(), null, null);
        } catch (JSONException e) {
            fb.I("RewardAd", "startRewardViaAidl, e:" + e.getClass().getSimpleName());
        }
    }

    private com.huawei.openalliance.ad.beans.metadata.VideoInfo ag() {
        MetaData i_;
        if (this.B == null && (i_ = i_()) != null) {
            this.B = i_.V();
        }
        return this.B;
    }

    @Override // com.huawei.openalliance.ad.inter.data.a, com.huawei.openalliance.ad.inter.data.e
    public boolean B() {
        return this.C;
    }

    @Override // com.huawei.openalliance.ad.inter.data.a, com.huawei.openalliance.ad.inter.data.e
    public RewardItem C() {
        return this.L;
    }

    public void Code(int i) {
        this.d = i;
    }

    public com.huawei.openalliance.ad.inter.listeners.h I() {
        return this.c;
    }

    @Override // com.huawei.openalliance.ad.inter.data.a
    public boolean S() {
        return this.D;
    }

    public com.huawei.openalliance.ad.inter.listeners.g Z() {
        return this.S;
    }

    public void a_(boolean z) {
        this.f = z;
    }

    public boolean af() {
        if (!ja.c(m_())) {
            return this.f;
        }
        fb.V("RewardAd", "server switch first, need data alert.");
        return true;
    }

    private void Code(Activity activity) {
        fb.V("RewardAd", "startRewardViaActivity");
        Intent intent = new Intent();
        intent.setAction(x.ai);
        intent.setPackage(w.Z(activity));
        intent.putExtra("content_id", a());
        intent.putExtra("slotid", o());
        intent.putExtra("sdk_version", "13.4.72.300");
        intent.putExtra("request_id", q());
        intent.putExtra(bb.i, this.d);
        intent.putExtra(bb.j, Code());
        intent.putExtra(bb.e, r());
        intent.putExtra(bb.M, af());
        intent.putExtra(bb.P, J());
        intent.putExtra(bb.Q, n_());
        intent.putExtra("apiVer", this.Code.aF());
        intent.putExtra("templateId", ac());
        if (this.F != null) {
            if (ag() != null) {
                intent.putExtra("reward_key_nonwifi_action_play", this.F.Code(r1.B()));
            }
            AppInfo y = y();
            if (y != null) {
                intent.putExtra("reward_key_nonwifi_action_download", this.F.Code(y, y.B()));
            }
        }
        Code(activity, intent);
        AppInfo y2 = y();
        if (y2 != null && !TextUtils.isEmpty(y2.e())) {
            intent.putExtra("unique_id", y2.e());
        }
        intent.setClipData(x.cM);
        activity.startActivityForResult(intent, 1);
    }

    private void V(Context context, com.huawei.openalliance.ad.inter.listeners.g gVar) {
        fb.V("RewardAd", "showAd");
        if (context == null) {
            return;
        }
        Code(gVar);
        dh.Code(context).Code();
        df.Code(this);
        AppInfo y = y();
        if (y != null) {
            fb.Code("RewardAd", "appName:" + y.L() + ", uniqueId:" + x() + ", appuniqueId:" + y.e());
        }
        if (!(context instanceof Activity)) {
            V(context);
        } else {
            Code((Activity) context);
            iz.Code(context).V(context);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.data.a
    public void I(boolean z) {
        this.C = z;
    }

    public void Code(Activity activity, com.huawei.openalliance.ad.inter.listeners.g gVar) {
        V(activity, gVar);
    }

    @Override // com.huawei.openalliance.ad.inter.data.a
    public void V(boolean z) {
        this.D = z;
    }

    private void Code(Context context, Intent intent) {
        String v = this.Code.v();
        if (w.B(context) && v != null && ja.F(v)) {
            intent.addFlags(268959744);
            intent.putExtra(bb.ai, true);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.data.a, com.huawei.openalliance.ad.inter.data.e
    public boolean V() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            this.B = adContentData.t();
        }
        return this.B != null || ab();
    }

    public void Code(Context context, com.huawei.openalliance.ad.inter.listeners.g gVar) {
        V(context, gVar);
    }

    public void Code(VideoConfiguration videoConfiguration) {
        if (videoConfiguration == null) {
            return;
        }
        if (videoConfiguration.getAutoPlayNetwork() == 1) {
            a_(false);
        } else {
            a_(true);
        }
        this.g = videoConfiguration;
        Code(videoConfiguration.isStartMuted());
    }

    public void Code(com.huawei.openalliance.ad.inter.listeners.g gVar) {
        this.S = gVar;
    }

    public void Code(com.huawei.openalliance.ad.inter.listeners.h hVar) {
        this.c = hVar;
    }

    public void Code(boolean z) {
        this.e = z;
    }

    public boolean Code() {
        if (!ja.d(m_())) {
            return this.e;
        }
        fb.V("RewardAd", "server switch first, mute.");
        return true;
    }
}
