package com.alimm.tanx.core.ad.browser;

import android.content.Context;
import android.content.Intent;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.bridge.JsBridgeBean;
import com.alimm.tanx.core.bridge.JsBridgeUtil;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.AdClickUtAnalytics;
import com.alimm.tanx.core.utils.LogUtils;

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

    public void onBackPressed() {
        TanxBrowserContainer tanxBrowserContainer = this.tanxc_try;
        if (tanxBrowserContainer != null && !tanxBrowserContainer.tanxc_byte()) {
            super.onBackPressed();
        }
    }

    public void tanxc_byte() {
        TanxBrowserContainer tanxBrowserContainer = this.tanxc_try;
        if (tanxBrowserContainer != null) {
            tanxBrowserContainer.tanxc_int();
        }
    }

    public void tanxc_case() {
        TanxBrowserContainer tanxBrowserContainer = this.tanxc_try;
        if (tanxBrowserContainer != null) {
            tanxBrowserContainer.tanxc_try();
        }
    }

    public boolean tanxc_for() {
        try {
            TanxBrowserContainer tanxBrowserContainer = (TanxBrowserContainer) findViewById(R.id.xadclick_webview_container);
            this.tanxc_try = tanxBrowserContainer;
            tanxBrowserContainer.tanxc_do(this.tanxc_if, tanxc_byte, (JsBridgeUtil.BaseWebInterface) null, (JsBridgeUtil.AdInterface) null);
            if (!this.tanxc_try.tanxc_do()) {
                LogUtils.i("AdSystemWebViewActivity", "initView: failed to create WebView.");
                AdClickUtAnalytics.recordActivityCreateFail((BidInfo) null, "AdSystemWebViewActivity", "webview_init_fail");
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

    public int tanxc_if() {
        return R.layout.tanx_layout_activity_browser;
    }

    public String tanxc_int() {
        TanxBrowserContainer tanxBrowserContainer = this.tanxc_try;
        if (tanxBrowserContainer != null) {
            return tanxBrowserContainer.tanxc_if();
        }
        return "";
    }

    public void tanxc_new() {
        TanxBrowserContainer tanxBrowserContainer = this.tanxc_try;
        if (tanxBrowserContainer != null) {
            tanxBrowserContainer.tanxc_for();
        }
    }

    public void tanxc_try() {
        TanxBrowserContainer tanxBrowserContainer = this.tanxc_try;
        if (tanxBrowserContainer != null) {
            tanxBrowserContainer.tanxc_new();
        }
    }
}
