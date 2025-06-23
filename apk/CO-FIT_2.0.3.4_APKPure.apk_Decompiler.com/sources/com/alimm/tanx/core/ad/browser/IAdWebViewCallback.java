package com.alimm.tanx.core.ad.browser;

import android.view.View;

public interface IAdWebViewCallback {
    void onHideCustomView();

    void onShowCustomView(View view);

    void onTitleLoaded(String str);
}
