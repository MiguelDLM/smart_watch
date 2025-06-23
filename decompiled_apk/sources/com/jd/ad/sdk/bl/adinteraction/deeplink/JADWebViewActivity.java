package com.jd.ad.sdk.bl.adinteraction.deeplink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ZoomButtonsController;
import com.google.android.exoplayer2.C;
import com.huawei.hms.ads.dynamicloader.b;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.multi.R;
import java.lang.reflect.Field;

/* loaded from: classes10.dex */
public class JADWebViewActivity extends Activity {
    public static final String mUrlIntent = "urlIntent";
    private WebView mWebView;

    /* loaded from: classes10.dex */
    public class jad_an implements DownloadListener {
        public jad_an() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (str.endsWith(b.b)) {
                try {
                    JADWebViewActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class jad_bo extends WebChromeClient {
        public final /* synthetic */ TextView jad_an;

        public jad_bo(JADWebViewActivity jADWebViewActivity, TextView textView) {
            this.jad_an = textView;
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (!TextUtils.isEmpty(str)) {
                this.jad_an.setText(str);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class jad_cp implements View.OnClickListener {
        public jad_cp() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            JADWebViewActivity.this.finish();
        }
    }

    /* loaded from: classes10.dex */
    public class jad_dq implements View.OnClickListener {
        public jad_dq() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            JADWebViewActivity.this.onBackClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBackClick() {
        WebView webView = this.mWebView;
        if (webView != null && webView.canGoBack()) {
            this.mWebView.goBack();
        } else {
            finish();
        }
    }

    public static boolean startActivity(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent(context, (Class<?>) JADWebViewActivity.class);
            intent.putExtra(mUrlIntent, new String[]{str});
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            return true;
        }
        return false;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            setContentView(R.layout.jad_activity_webview);
            TextView textView = (TextView) findViewById(R.id.jad_toolbar_title);
            getWindow().addFlags(C.BUFFER_FLAG_FIRST_SAMPLE);
            textView.setSelected(true);
            String[] stringArrayExtra = getIntent().getStringArrayExtra(mUrlIntent);
            WebView webView = (WebView) findViewById(R.id.jad_webView);
            this.mWebView = webView;
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            this.mWebView.removeJavascriptInterface("accessibility");
            this.mWebView.removeJavascriptInterface("accessibilityTraversal");
            this.mWebView.setScrollBarStyle(0);
            WebSettings settings = this.mWebView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setAllowFileAccess(false);
            settings.setSavePassword(false);
            settings.setDomStorageEnabled(true);
            settings.setAppCachePath(getCacheDir().getAbsolutePath());
            settings.setAppCacheEnabled(true);
            settings.setAllowContentAccess(false);
            this.mWebView.setDownloadListener(new jad_an());
            this.mWebView.setWebViewClient(new jad_er());
            this.mWebView.setWebChromeClient(new jad_bo(this, textView));
            if (stringArrayExtra != null && stringArrayExtra.length > 0) {
                this.mWebView.loadUrl(stringArrayExtra[0]);
            }
            ImageView imageView = (ImageView) findViewById(R.id.jad_toolbar_back);
            int i = R.color.jad_common_half_alpha;
            imageView.setColorFilter(i);
            imageView.setOnClickListener(new jad_cp());
            ImageView imageView2 = (ImageView) findViewById(R.id.jad_toolbar_back_1);
            imageView2.setColorFilter(i);
            imageView2.setOnClickListener(new jad_dq());
        } catch (Exception e) {
            Logger.w(e.getMessage(), new Object[0]);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        try {
            super.onDestroy();
            WebView webView = this.mWebView;
            if (webView != null) {
                webView.destroy();
            }
        } catch (Exception e) {
            StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while webview activity onDestroy:");
            jad_an2.append(e.getMessage());
            Logger.w(jad_an2.toString(), new Object[0]);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        WebView webView = this.mWebView;
        if (webView != null && i == 4 && webView.canGoBack()) {
            this.mWebView.goBack();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onPause() {
        try {
            super.onPause();
            WebView webView = this.mWebView;
            if (webView != null) {
                webView.onPause();
            }
        } catch (Exception e) {
            StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while webview activity onPause:");
            jad_an2.append(e.getMessage());
            Logger.w(jad_an2.toString(), new Object[0]);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        try {
            super.onResume();
            WebView webView = this.mWebView;
            if (webView != null) {
                webView.onResume();
            }
        } catch (Exception e) {
            StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while webview activity onResume:");
            jad_an2.append(e.getMessage());
            Logger.w(jad_an2.toString(), new Object[0]);
        }
    }

    public void setZoomControlGone(View view) {
        try {
            Field declaredField = WebView.class.getDeclaredField("mZoomButtonsController");
            declaredField.setAccessible(true);
            ZoomButtonsController zoomButtonsController = new ZoomButtonsController(view);
            zoomButtonsController.getZoomControls().setVisibility(8);
            declaredField.set(view, zoomButtonsController);
        } catch (Exception e) {
            StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while load webview activity:");
            jad_an2.append(e.getMessage());
            Logger.w(jad_an2.toString(), new Object[0]);
        }
    }

    /* loaded from: classes10.dex */
    public static class jad_er extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            Uri uri = Uri.EMPTY;
            Uri url = webResourceRequest.getUrl();
            String uri2 = url.toString();
            if (!TextUtils.isEmpty(uri2) && !uri2.startsWith("http")) {
                try {
                    Context context = webView.getContext();
                    Intent intent = new Intent("android.intent.action.VIEW", url);
                    if (!(context instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    context.startActivity(intent);
                    return true;
                } catch (Throwable unused) {
                }
            }
            return false;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith("http")) {
                return false;
            }
            try {
                Context context = webView.getContext();
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
