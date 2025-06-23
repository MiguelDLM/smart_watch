package com.huawei.hms.ads.inter.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.e;
import com.huawei.hms.ads.f;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener;
import com.huawei.hms.ads.iz;
import com.huawei.hms.ads.ja;
import com.huawei.hms.ads.reward.RewardAdListener;
import com.huawei.openalliance.ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.listeners.INonwifiActionListener;
import com.huawei.openalliance.ad.ipc.g;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.w;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class a extends com.huawei.openalliance.ad.inter.data.a implements IInterstitialAd {
    private transient INonwifiActionListener B;
    private RewardAdListener C;
    private boolean D;
    private VideoConfiguration F;
    private List<ImageInfo> L;
    private VideoInfo S;
    private transient IInterstitialAdStatusListener Z;

    /* renamed from: a, reason: collision with root package name */
    private boolean f17306a;

    public a(AdContentData adContentData) {
        super(adContentData);
        this.D = true;
        this.f17306a = true;
    }

    private void V(Context context) {
        fb.V("InnerInterstitialAd", "startInterstitialViaAidl");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content_id", a());
            jSONObject.put("sdk_version", "13.4.72.300");
            jSONObject.put("request_id", q());
            jSONObject.put(bb.e, r());
            jSONObject.put(bb.P, J());
            jSONObject.put(bb.Q, n_());
            jSONObject.put("slotid", o());
            jSONObject.put(bb.j, this.D);
            jSONObject.put(bb.M, Z());
            if (getVideoConfiguration() != null) {
                jSONObject.put(bb.n, getVideoConfiguration().getAutoPlayNetwork());
                jSONObject.put(bb.o, getVideoConfiguration().isStartMuted());
            }
            if (this.B != null) {
                if (af() != null) {
                    jSONObject.put("reward_key_nonwifi_action_play", this.B.Code(r2.B()));
                }
                AppInfo y = y();
                if (y != null) {
                    jSONObject.put("reward_key_nonwifi_action_download", this.B.Code(y, y.B()));
                }
            }
            AppInfo y2 = y();
            if (y2 != null && !TextUtils.isEmpty(y2.e())) {
                jSONObject.put("unique_id", y2.e());
            }
            g.V(context).Code("interstitial_ad_show", jSONObject.toString(), null, null);
        } catch (JSONException e) {
            fb.I("InnerInterstitialAd", "startInterstitialViaAidl, e:" + e.getClass().getSimpleName());
        }
    }

    private VideoInfo af() {
        MetaData i_;
        if (this.S == null && (i_ = i_()) != null) {
            this.S = i_.V();
        }
        return this.S;
    }

    public RewardAdListener Code() {
        return this.C;
    }

    public IInterstitialAdStatusListener I() {
        return this.Z;
    }

    public boolean Z() {
        if (!ja.c(m_())) {
            return this.f17306a;
        }
        fb.V("InnerInterstitialAd", "server switch first, need data alert.");
        return true;
    }

    @Override // com.huawei.hms.ads.inter.data.IInterstitialAd
    public VideoConfiguration getVideoConfiguration() {
        return this.F;
    }

    @Override // com.huawei.hms.ads.inter.data.IInterstitialAd
    public void setMobileDataAlertSwitch(boolean z) {
        this.f17306a = z;
    }

    @Override // com.huawei.hms.ads.inter.data.IInterstitialAd
    public void setNonwifiActionListener(INonwifiActionListener iNonwifiActionListener) {
        this.B = iNonwifiActionListener;
    }

    @Override // com.huawei.hms.ads.inter.data.IInterstitialAd
    public void setRewardAdListener(RewardAdListener rewardAdListener) {
        this.C = rewardAdListener;
    }

    @Override // com.huawei.hms.ads.inter.data.IInterstitialAd
    public void setVideoConfiguration(VideoConfiguration videoConfiguration) {
        if (videoConfiguration == null) {
            return;
        }
        if (videoConfiguration.getAutoPlayNetwork() == 1) {
            setMobileDataAlertSwitch(false);
        } else {
            setMobileDataAlertSwitch(true);
        }
        this.F = videoConfiguration;
        Code(videoConfiguration.isStartMuted());
    }

    @Override // com.huawei.hms.ads.inter.data.IInterstitialAd
    public void show(Context context, IInterstitialAdStatusListener iInterstitialAdStatusListener) {
        if (context == null) {
            return;
        }
        I(true);
        Code(iInterstitialAdStatusListener);
        e.Code(context).Code();
        f.Code(this);
        AppInfo y = y();
        if (y != null) {
            fb.Code("InnerInterstitialAd", "appName:" + y.L() + ", uniqueId:" + x() + ", appuniqueId:" + y.e());
        }
        if (!(context instanceof Activity)) {
            V(context);
        } else {
            Code((Activity) context);
            iz.Code(context).V(context);
        }
    }

    private void Code(Activity activity) {
        fb.V("InnerInterstitialAd", "startInterstitialViaActivity");
        Intent intent = new Intent();
        intent.setAction(x.am);
        intent.setPackage(w.Z(activity));
        intent.putExtra("content_id", a());
        intent.putExtra("sdk_version", "13.4.72.300");
        intent.putExtra("request_id", q());
        intent.putExtra(bb.e, r());
        intent.putExtra(bb.P, J());
        intent.putExtra(bb.Q, n_());
        intent.putExtra("slotid", o());
        intent.putExtra(bb.j, this.D);
        intent.putExtra(bb.M, Z());
        if (getVideoConfiguration() != null) {
            intent.putExtra(bb.n, getVideoConfiguration().getAutoPlayNetwork());
            intent.putExtra(bb.o, getVideoConfiguration().isStartMuted());
        }
        if (this.B != null) {
            if (af() != null) {
                intent.putExtra("reward_key_nonwifi_action_play", this.B.Code(r1.B()));
            }
            AppInfo y = y();
            if (y != null) {
                intent.putExtra("reward_key_nonwifi_action_download", this.B.Code(y, y.B()));
            }
        }
        AppInfo y2 = y();
        if (y2 != null && !TextUtils.isEmpty(y2.e())) {
            intent.putExtra("unique_id", y2.e());
        }
        intent.setClipData(x.cM);
        activity.startActivityForResult(intent, 1);
    }

    @Override // com.huawei.openalliance.ad.inter.data.a, com.huawei.openalliance.ad.inter.data.e
    public boolean V() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            this.S = adContentData.t();
            MetaData S = this.Code.S();
            if (S != null) {
                this.L = S.d();
            }
            if (this.Code.l() == 9) {
                return this.S != null;
            }
            if (this.Code.l() == 2 || this.Code.l() == 4) {
                return !ad.Code(this.L);
            }
        }
        return false;
    }

    private void Code(IInterstitialAdStatusListener iInterstitialAdStatusListener) {
        this.Z = iInterstitialAdStatusListener;
    }

    public void Code(boolean z) {
        this.D = z;
    }
}
