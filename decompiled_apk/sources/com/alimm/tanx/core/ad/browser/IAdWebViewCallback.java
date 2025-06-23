package com.alimm.tanx.core.ad.browser;

import android.view.View;

/* loaded from: classes.dex */
public interface IAdWebViewCallback {
    void onHideCustomView();

    void onShowCustomView(View view);

    void onTitleLoaded(String str);
}
