package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.ak;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.mobads.sdk.internal.bv;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public class CPUAggregationManager {
    private static final String TAG = "CPUAggregationManager";
    private CPUAggregationListener mCPUListener;
    private Context mContext;
    private ak mNativeCpuAggregation;
    private int mPageSize = 3;
    private HashMap<String, Object> mParams = new HashMap<>();

    /* loaded from: classes7.dex */
    public interface CPUAggregationListener {
        void onExitLp();

        void onHotContentError(String str, int i);

        void onHotContentLoaded(List<IBasicCPUAggregation> list);
    }

    public CPUAggregationManager(Context context, String str, CPUAggregationListener cPUAggregationListener) {
        this.mNativeCpuAggregation = null;
        if (context != null && !TextUtils.isEmpty(str)) {
            this.mCPUListener = cPUAggregationListener;
            this.mContext = context;
            ak akVar = new ak(context, str);
            this.mNativeCpuAggregation = akVar;
            akVar.a(cPUAggregationListener);
            return;
        }
        bv.a().c(TAG, "Init params error!");
        if (cPUAggregationListener != null) {
            cPUAggregationListener.onHotContentError("Input params error.", br.INTERFACE_USE_PROBLEM.b());
        }
    }

    public void loadAd(int i) {
        if (i > 0) {
            ak akVar = this.mNativeCpuAggregation;
            if (akVar != null) {
                akVar.a(i, this.mPageSize, this.mParams);
                this.mNativeCpuAggregation.a();
                return;
            }
            return;
        }
        bv.a().c(TAG, "Load with terrible params!");
    }

    public void setPageSize(int i) {
        if (i > 0 && i <= 10) {
            this.mPageSize = i;
        } else {
            bv.a().c(TAG, "Input page size is wrong which should be in (0,10]!");
        }
    }

    public void setRequestParameter(CPUAggregationRequest cPUAggregationRequest) {
        if (cPUAggregationRequest != null && cPUAggregationRequest.getExtras() != null) {
            this.mParams = cPUAggregationRequest.getExtras();
        }
    }

    public void setRequestTimeoutMillis(int i) {
        ak akVar = this.mNativeCpuAggregation;
        if (akVar != null) {
            akVar.a(i);
        }
    }
}
