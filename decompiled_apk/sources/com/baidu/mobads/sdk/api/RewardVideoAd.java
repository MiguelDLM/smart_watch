package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.az;
import com.baidu.mobads.sdk.internal.bv;
import com.baidu.mobads.sdk.internal.dv;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class RewardVideoAd {
    public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
    public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;
    private static final String TAG = "RewardVideoAd";
    private dv mAdProd;
    private final Context mContext;
    private RequestParameters mRequestParameters;

    /* loaded from: classes7.dex */
    public interface RewardVideoAdListener extends ScreenVideoAdListener {
        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClick();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClose(float f);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdFailed(String str);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdLoaded();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdShow();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdSkip(float f);

        void onRewardVerify(boolean z);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadFailed();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadSuccess();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void playCompletion();
    }

    public RewardVideoAd(Context context, String str, RewardVideoAdListener rewardVideoAdListener) {
        this(context, str, rewardVideoAdListener, false);
    }

    public void biddingFail(String str) {
        biddingFail(str, null);
    }

    public void biddingSuccess(String str) {
        biddingSuccess(str, null);
    }

    public Object getAdDataForKey(String str) {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            return dvVar.k(str);
        }
        return null;
    }

    public String getBiddingToken() {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            return dvVar.m();
        }
        return null;
    }

    public String getECPMLevel() {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            return dvVar.h();
        }
        return "";
    }

    public boolean isReady() {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            return dvVar.g();
        }
        return false;
    }

    public synchronized void load() {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            dvVar.a();
        }
    }

    public void loadBiddingAd(String str) {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            dvVar.c(str);
        }
    }

    public void setAppSid(String str) {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            dvVar.h(str);
        }
    }

    public void setBidFloor(int i) {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            dvVar.p = i;
        }
    }

    @Deprecated
    public void setBiddingData(String str) {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            dvVar.b(str);
        }
    }

    public void setDownloadAppConfirmPolicy(int i) {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            dvVar.a(i);
        }
    }

    public void setExtraInfo(String str) {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            dvVar.j(str);
        }
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        dv dvVar;
        this.mRequestParameters = requestParameters;
        if (requestParameters != null && (dvVar = this.mAdProd) != null) {
            dvVar.a(requestParameters);
        }
    }

    public void setShowDialogOnSkip(boolean z) {
        if (this.mAdProd != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("showDialogOnSkip", z);
                this.mAdProd.a(jSONObject);
            } catch (Throwable th) {
                bv.a().c(th);
            }
        }
    }

    public void setUserId(String str) {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            dvVar.a(str);
        }
    }

    public synchronized void show() {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            dvVar.f();
        }
    }

    public RewardVideoAd(Context context, String str, RewardVideoAdListener rewardVideoAdListener, boolean z) {
        this.mContext = context;
        dv dvVar = new dv(context, str, z);
        this.mAdProd = dvVar;
        dvVar.a(rewardVideoAdListener);
        if (TextUtils.isEmpty(str)) {
            az.c().e("RewardVideoAd初始化异常：广告位为空");
        }
    }

    public void biddingFail(String str, LinkedHashMap<String, Object> linkedHashMap) {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            dvVar.a(false, str, linkedHashMap);
        }
    }

    public void biddingSuccess(String str, LinkedHashMap<String, Object> linkedHashMap) {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            dvVar.a(true, str, linkedHashMap);
        }
    }

    public synchronized void show(Context context) {
        dv dvVar = this.mAdProd;
        if (dvVar != null) {
            dvVar.a(context);
        }
    }
}
