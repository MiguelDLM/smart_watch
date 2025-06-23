package x0xO;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;

/* loaded from: classes9.dex */
public class I0Io extends WebViewClient {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public BridgeWebView f34050oIX0oI;

    public I0Io(BridgeWebView bridgeWebView) {
        this.f34050oIX0oI = bridgeWebView;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        II0xO0.XO(webView, "WebViewJavascriptBridge.js");
        if (this.f34050oIX0oI.getStartupMessage() != null) {
            Iterator<XO> it = this.f34050oIX0oI.getStartupMessage().iterator();
            while (it.hasNext()) {
                this.f34050oIX0oI.oxoX(it.next());
            }
            this.f34050oIX0oI.setStartupMessage(null);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            str = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (str.startsWith(II0xO0.f34053II0xO0)) {
            this.f34050oIX0oI.II0XooXoX(str);
            return true;
        }
        if (str.startsWith(II0xO0.f34057oIX0oI)) {
            this.f34050oIX0oI.XO();
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
