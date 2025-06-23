package com.ss.android.downloadlib.addownload.compliance;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.R;
import com.ss.android.downloadlib.g.k;

/* loaded from: classes11.dex */
public class AppPrivacyPolicyActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f25988a;
    private WebView b;
    private long c;
    private long d;
    private String e;

    private void b() {
        this.f25988a = (ImageView) findViewById(R.id.iv_privacy_back);
        this.b = (WebView) findViewById(R.id.privacy_webview);
        this.f25988a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.a("lp_app_privacy_click_close", AppPrivacyPolicyActivity.this.d);
                AppPrivacyPolicyActivity.this.finish();
            }
        });
        WebSettings settings = this.b.getSettings();
        settings.setDefaultFontSize(16);
        settings.setCacheMode(-1);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMixedContentMode(0);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        this.b.setWebViewClient(new WebViewClient() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.2
            private boolean a(Uri uri) {
                String scheme = uri.getScheme();
                if (!"http".equals(scheme) && !"https".equals(scheme)) {
                    return true;
                }
                return false;
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                boolean didCrash;
                if (Build.VERSION.SDK_INT >= 26) {
                    didCrash = renderProcessGoneDetail.didCrash();
                    if (!didCrash) {
                        k.a("System killed the WebView rendering process to reclaim memory. Recreating...");
                        if (webView != null) {
                            ((ViewGroup) webView.getParent()).removeView(webView);
                            webView.destroy();
                        }
                        return true;
                    }
                    k.a("The WebView rendering process crashed!");
                    if (webView != null) {
                        ((ViewGroup) webView.getParent()).removeView(webView);
                        webView.destroy();
                    }
                    return true;
                }
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }

            @Override // android.webkit.WebViewClient
            @TargetApi(21)
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return a(webResourceRequest.getUrl());
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return a(Uri.parse(str));
            }
        });
        a(this.b);
        this.b.setScrollBarStyle(0);
        this.b.loadUrl(this.e);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        g.a("lp_app_privacy_click_close", this.d);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_privacy_policy);
        if (a()) {
            b();
        } else {
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
        }
    }

    public static void a(Activity activity, long j) {
        Intent intent = new Intent(activity, (Class<?>) AppPrivacyPolicyActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    private boolean a() {
        this.c = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.b.b a2 = c.a().a(this.c);
        if (a2 == null) {
            return false;
        }
        this.d = a2.b;
        String str = a2.i;
        this.e = str;
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        this.e = com.ss.android.downloadlib.addownload.k.j().optString("ad_privacy_backup_url", "https://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html");
        return true;
    }

    private void a(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }
}
