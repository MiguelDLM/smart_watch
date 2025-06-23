package com.alimm.tanx.core.ad.browser;

import android.content.Context;
import android.content.Intent;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.bridge.JsBridgeBean;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.AdClickUtAnalytics;
import com.alimm.tanx.core.utils.LogUtils;

/* loaded from: classes.dex */
public class TanxBrowserActivity extends tanxc_do {
    private static JsBridgeBean tanxc_byte;
    private TanxBrowserContainer tanxc_try;

    public static void tanxc_do(Context context, String str, JsBridgeBean jsBridgeBean) {
        tanxc_byte = jsBridgeBean;
        Intent intent = new Intent();
        intent.setClass(context, TanxBrowserActivity.class);
        intent.putExtra("url", str);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        TanxBrowserContainer tanxBrowserContainer = this.tanxc_try;
        if (tanxBrowserContainer != null && !tanxBrowserContainer.tanxc_byte()) {
            super.onBackPressed();
        }
    }

    @Override // com.alimm.tanx.core.ad.browser.tanxc_do
    public void tanxc_byte() {
        TanxBrowserContainer tanxBrowserContainer = this.tanxc_try;
        if (tanxBrowserContainer != null) {
            tanxBrowserContainer.tanxc_int();
        }
    }

    @Override // com.alimm.tanx.core.ad.browser.tanxc_do
    public void tanxc_case() {
        TanxBrowserContainer tanxBrowserContainer = this.tanxc_try;
        if (tanxBrowserContainer != null) {
            tanxBrowserContainer.tanxc_try();
        }
    }

    @Override // com.alimm.tanx.core.ad.browser.tanxc_do
    public boolean tanxc_for() {
        try {
            TanxBrowserContainer tanxBrowserContainer = (TanxBrowserContainer) findViewById(R.id.xadclick_webview_container);
            this.tanxc_try = tanxBrowserContainer;
            tanxBrowserContainer.tanxc_do(this.tanxc_if, tanxc_byte, null, null);
            if (!this.tanxc_try.tanxc_do()) {
                LogUtils.i("AdSystemWebViewActivity", "initView: failed to create WebView.");
                AdClickUtAnalytics.recordActivityCreateFail(null, "AdSystemWebViewActivity", "webview_init_fail");
                finish();
                return false;
            }
            this.tanxc_try.tanxc_do(this.tanxc_int);
            this.tanxc_try.tanxc_do(this.tanxc_new);
            tanxc_do();
            return true;
        } catch (Exception e) {
            LogUtils.e("AdSystemWebViewActivity", e);
            finish();
            TanxBaseUt.utError(1, "AdSystemWebViewActivity", e, "");
            return false;
        }
    }

    @Override // com.alimm.tanx.core.ad.browser.tanxc_do
    public int tanxc_if() {
        return R.layout.tanx_layout_activity_browser;
    }

    @Override // com.alimm.tanx.core.ad.browser.tanxc_do
    public String tanxc_int() {
        TanxBrowserContainer tanxBrowserContainer = this.tanxc_try;
        if (tanxBrowserContainer != null) {
            return tanxBrowserContainer.tanxc_if();
        }
        return "";
    }

    @Override // com.alimm.tanx.core.ad.browser.tanxc_do
    public void tanxc_new() {
        TanxBrowserContainer tanxBrowserContainer = this.tanxc_try;
        if (tanxBrowserContainer != null) {
            tanxBrowserContainer.tanxc_for();
        }
    }

    @Override // com.alimm.tanx.core.ad.browser.tanxc_do
    public void tanxc_try() {
        TanxBrowserContainer tanxBrowserContainer = this.tanxc_try;
        if (tanxBrowserContainer != null) {
            tanxBrowserContainer.tanxc_new();
        }
    }
}
