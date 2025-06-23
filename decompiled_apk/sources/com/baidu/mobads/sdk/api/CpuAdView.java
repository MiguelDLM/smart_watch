package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.ct;
import com.baidu.mobads.sdk.internal.cv;
import java.util.Map;

/* loaded from: classes7.dex */
public final class CpuAdView extends RelativeLayout {
    private cv mAdProd;

    /* loaded from: classes7.dex */
    public interface CpuAdViewInternalStatusListener {
        void loadDataError(String str);

        void onAdClick();

        void onAdImpression(String str);

        void onContentClick();

        void onContentImpression(String str);

        void onExitLp();

        void onLpContentStatus(Map<String, Object> map);
    }

    public CpuAdView(Context context) {
        super(context);
    }

    public boolean canGoBack() {
        try {
            WebView webView = (WebView) this.mAdProd.w();
            if (webView == null) {
                return false;
            }
            return webView.canGoBack();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void goBack() {
        try {
            WebView webView = (WebView) this.mAdProd.w();
            if (webView != null) {
                webView.goBack();
            }
        } catch (Throwable unused) {
        }
    }

    public void onDestroy() {
        View w = this.mAdProd.w();
        if (w instanceof WebView) {
            ((WebView) w).destroy();
        }
    }

    public boolean onKeyBackDown(int i, KeyEvent keyEvent) {
        if (i == 4 && canGoBack()) {
            goBack();
            return true;
        }
        return false;
    }

    public void onPause() {
        View w = this.mAdProd.w();
        if (w instanceof WebView) {
            ((WebView) w).onPause();
        }
    }

    public void onResume() {
        View w = this.mAdProd.w();
        if (w instanceof WebView) {
            ((WebView) w).onResume();
        }
    }

    public void requestData() {
        cv cvVar = this.mAdProd;
        if (cvVar != null) {
            cvVar.a();
        }
    }

    public CpuAdView(Context context, String str, int i, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        ct ctVar = new ct(context);
        this.mAdProd = new cv(context, ctVar, str, i, cPUWebAdRequestParam);
        addView(ctVar, new ViewGroup.LayoutParams(-1, -1));
    }

    public CpuAdView(Context context, String str, int i, CPUWebAdRequestParam cPUWebAdRequestParam, CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener) {
        super(context);
        ct ctVar = new ct(context);
        cv cvVar = new cv(context, ctVar, str, i, cPUWebAdRequestParam);
        this.mAdProd = cvVar;
        cvVar.a(cpuAdViewInternalStatusListener);
        addView(ctVar, new ViewGroup.LayoutParams(-1, -1));
    }
}
