package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.mobads.sdk.internal.bv;
import com.baidu.mobads.sdk.internal.m;
import java.util.List;

/* loaded from: classes7.dex */
public class CpuChannelListManager {
    private static final String TAG = "CpuChannelListManager";
    private m mCPUChannelListProd;
    private CpuChannelListListener mChannelIdListListener;

    /* loaded from: classes7.dex */
    public interface CpuChannelListListener {
        void onChannelListError(String str, int i);

        void onChannelListLoaded(List<CpuChannelResponse> list);
    }

    public CpuChannelListManager(Context context, CpuChannelListListener cpuChannelListListener) {
        m mVar = new m(context);
        this.mCPUChannelListProd = mVar;
        this.mChannelIdListListener = cpuChannelListListener;
        mVar.a(cpuChannelListListener);
    }

    public void loadChannelList(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            bv.a().c(TAG, "SubChannelId is null!");
            CpuChannelListListener cpuChannelListListener = this.mChannelIdListListener;
            if (cpuChannelListListener != null) {
                cpuChannelListListener.onChannelListError("SubChannelId is null.", br.INTERFACE_USE_PROBLEM.b());
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            bv.a().c(TAG, "appsid is null!");
            CpuChannelListListener cpuChannelListListener2 = this.mChannelIdListListener;
            if (cpuChannelListListener2 != null) {
                cpuChannelListListener2.onChannelListError("appsid is null.", br.INTERFACE_USE_PROBLEM.b());
                return;
            }
            return;
        }
        try {
            int parseInt = Integer.parseInt(str2);
            m mVar = this.mCPUChannelListProd;
            if (mVar != null) {
                mVar.a(str, parseInt);
                this.mCPUChannelListProd.a();
            }
        } catch (Exception unused) {
            bv.a().c(TAG, "SubChannelId is not Integer!");
            if (this.mChannelIdListListener != null) {
                this.mChannelIdListListener.onChannelListError("SubChannelId is not Integer!", br.INTERFACE_USE_PROBLEM.b());
            }
        }
    }
}
