package com.sina.weibo.sdk.web.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.facebook.internal.NativeProtocol;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.b.e;
import com.sina.weibo.sdk.common.UiError;

/* loaded from: classes11.dex */
public final class a extends b {
    public a(Activity activity, com.sina.weibo.sdk.web.a aVar, com.sina.weibo.sdk.web.b.b bVar) {
        super(activity, aVar, bVar);
    }

    private boolean l(String str) {
        Bundle g;
        AuthInfo a2 = this.aA.u().a();
        if (a2 == null || !str.startsWith(a2.getRedirectUrl()) || (g = e.g(str)) == null || TextUtils.isEmpty(g.getString("access_token"))) {
            return false;
        }
        return true;
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        AuthInfo a2 = this.aA.u().a();
        if (a2 != null && str.startsWith(a2.getRedirectUrl())) {
            String r = this.aA.u().r();
            if (!TextUtils.isEmpty(r)) {
                WbAuthListener a3 = this.ax.a(r);
                this.aB = a3;
                if (a3 != null) {
                    Bundle g = e.g(str);
                    if (g != null) {
                        String string = g.getString("error");
                        String string2 = g.getString("error_code");
                        String string3 = g.getString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
                        if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                            Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(g);
                            AccessTokenHelper.writeAccessToken(this.ay, parseAccessToken);
                            this.aB.onComplete(parseAccessToken);
                        } else {
                            this.aB.onError(new UiError(-1, string2, string3));
                        }
                    } else {
                        this.aB.onError(new UiError(-1, "bundle is null", "parse url error"));
                    }
                    this.ax.b(r);
                }
            }
            com.sina.weibo.sdk.web.a aVar = this.az;
            if (aVar != null) {
                aVar.q();
            }
        }
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.sina.weibo.sdk.web.a.b
    public final void q() {
        super.q();
        String r = this.aA.u().r();
        if (!TextUtils.isEmpty(r)) {
            WbAuthListener a2 = this.ax.a(r);
            this.aB = a2;
            if (a2 != null) {
                a2.onCancel();
            }
            this.ax.b(r);
        }
        com.sina.weibo.sdk.web.a aVar = this.az;
        if (aVar != null) {
            aVar.q();
        }
    }

    @Override // com.sina.weibo.sdk.web.a.b
    public final boolean s() {
        q();
        return true;
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return l(webResourceRequest.getUrl().toString());
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return l(str);
    }
}
