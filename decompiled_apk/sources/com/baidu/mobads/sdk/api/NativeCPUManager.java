package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.ae;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.mobads.sdk.internal.bv;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class NativeCPUManager {
    private static final String TAG = "NativeCPUManager";
    private CPUAdListener mCPUAdListener;
    private ae mCPUAdProd;
    private Context mContext;
    private int mPageSize = 10;
    private HashMap<String, Object> mParams = new HashMap<>();

    /* loaded from: classes7.dex */
    public interface CPUAdListener {
        void onAdError(String str, int i);

        void onAdLoaded(List<IBasicCPUData> list);

        void onDisLikeAdClick(int i, String str);

        void onExitLp();

        void onLpCustomEventCallBack(HashMap<String, Object> hashMap, DataPostBackListener dataPostBackListener);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    /* loaded from: classes7.dex */
    public interface DataPostBackListener {
        void postback(JSONObject jSONObject);
    }

    public NativeCPUManager(Context context, String str, CPUAdListener cPUAdListener) {
        this.mCPUAdProd = null;
        if (context != null && !TextUtils.isEmpty(str)) {
            this.mCPUAdListener = cPUAdListener;
            this.mContext = context;
            ae aeVar = new ae(context, str, this);
            this.mCPUAdProd = aeVar;
            aeVar.a(cPUAdListener);
            return;
        }
        bv.a().c(TAG, "Init params error!");
        if (cPUAdListener != null) {
            cPUAdListener.onAdError("Input params error.", br.INTERFACE_USE_PROBLEM.b());
        }
    }

    public void loadAd(int i, int i2, boolean z) {
        loadAd(i, new int[]{i2}, z);
    }

    public void openAppActivity(String str) {
        ae aeVar = this.mCPUAdProd;
        if (aeVar != null) {
            aeVar.a(str);
            this.mCPUAdProd.a();
        }
    }

    public void setPageSize(int i) {
        if (i > 0 && i <= 20) {
            this.mPageSize = i;
        } else {
            bv.a().c(TAG, "Input page size is wrong which should be in (0,20]!");
        }
    }

    public void setRequestParameter(CPUAdRequest cPUAdRequest) {
        if (cPUAdRequest != null && cPUAdRequest.getExtras() != null) {
            this.mParams = cPUAdRequest.getExtras();
        }
    }

    public void setRequestTimeoutMillis(int i) {
        ae aeVar = this.mCPUAdProd;
        if (aeVar != null) {
            aeVar.a(i);
        }
    }

    private void loadAd(int i, int[] iArr, boolean z) {
        if (i > 0 && iArr != null) {
            ae aeVar = this.mCPUAdProd;
            if (aeVar != null) {
                aeVar.a(i, this.mPageSize, iArr, z, this.mParams);
                this.mCPUAdProd.f();
                this.mCPUAdProd.a();
                return;
            }
            return;
        }
        bv.a().c(TAG, "LoadAd with terrible params!");
    }
}
