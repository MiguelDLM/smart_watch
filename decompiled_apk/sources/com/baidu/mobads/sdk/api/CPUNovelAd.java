package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.internal.de;

/* loaded from: classes7.dex */
public class CPUNovelAd {
    private de mCpuNovelProd;

    /* loaded from: classes7.dex */
    public interface CpuNovelListener {
        void onAdClick();

        void onAdImpression();

        void onReadTime(long j);
    }

    public CPUNovelAd(Context context, String str, CPUWebAdRequestParam cPUWebAdRequestParam, CpuNovelListener cpuNovelListener) {
        de deVar = new de(context, str, cPUWebAdRequestParam);
        this.mCpuNovelProd = deVar;
        deVar.a(cpuNovelListener);
        this.mCpuNovelProd.a();
    }

    public void destory() {
        de deVar = this.mCpuNovelProd;
        if (deVar != null) {
            deVar.y();
        }
    }

    public View getNovelView() {
        return this.mCpuNovelProd.w();
    }
}
