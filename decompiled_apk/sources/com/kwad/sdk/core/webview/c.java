package com.kwad.sdk.core.webview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.n.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bt;

/* loaded from: classes11.dex */
public class c extends WebView {
    private boolean aFb;
    private com.kwad.sdk.core.webview.a.a aFc;

    public c(Context context) {
        super(bA(context));
        this.aFb = true;
        init();
    }

    private static Context bA(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            context = context.createConfigurationContext(new Configuration());
        }
        Context dD = l.dD(context);
        if (!l.dG(dD)) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSApiWebView context not except--context:" + dD.getClass().getName() + "--classloader:" + dD.getClass().getClassLoader() + "--context2:" + l.dD(ServiceProvider.Lw()).getClass().getName()));
            return l.dD(ServiceProvider.Lw());
        }
        return dD;
    }

    private void init() {
        bt.a(this);
        com.kwad.sdk.core.webview.a.a aVar = new com.kwad.sdk.core.webview.a.a();
        this.aFc = aVar;
        setWebViewClient(aVar);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        if (this.aFb) {
            release();
        }
    }

    public final void release() {
        try {
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this);
            }
            removeAllViews();
            super.destroy();
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    public void setEnableDestroy(boolean z) {
        this.aFb = z;
    }

    public void setNeedHybridLoad(boolean z) {
        this.aFc.setNeedHybridLoad(z);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(bA(context), attributeSet);
        this.aFb = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(bA(context), attributeSet, i);
        this.aFb = true;
        init();
    }

    @RequiresApi(api = 21)
    public c(Context context, AttributeSet attributeSet, int i, int i2) {
        super(bA(context), attributeSet, i, i2);
        this.aFb = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(bA(context), attributeSet, i, z);
        this.aFb = true;
        init();
    }
}
