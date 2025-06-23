package oI;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.VideoView;
import com.octopus.ad.AdActivity;
import com.octopus.ad.R;
import com.octopus.ad.internal.view.AdViewImpl;
import com.octopus.ad.internal.view.II0XooXoX;
import java.util.Iterator;
import java.util.LinkedList;
import x0.I0oOoX;
import x0.x0o;

/* loaded from: classes11.dex */
public class oIX0oI implements AdActivity.I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public static LinkedList<WebView> f31320I0Io = new LinkedList<>();

    /* renamed from: II0xO0, reason: collision with root package name */
    public WebView f31321II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Activity f31322oIX0oI;

    /* loaded from: classes11.dex */
    public class I0Io extends II0XooXoX {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ ProgressBar f31324XO;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public I0Io(Activity activity, ProgressBar progressBar) {
            super(activity);
            this.f31324XO = progressBar;
        }

        @Override // com.octopus.ad.internal.view.oIX0oI, android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18702oOoXoXO, com.octopus.ad.internal.utilities.oIX0oI.IXxxXO(R.string.console_message, consoleMessage.message(), consoleMessage.lineNumber(), consoleMessage.sourceId()));
            return true;
        }

        @Override // com.octopus.ad.internal.view.oIX0oI, android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18702oOoXoXO, com.octopus.ad.internal.utilities.oIX0oI.Oxx0xo(R.string.js_alert, str2, str));
            jsResult.confirm();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (i < 100 && this.f31324XO.getVisibility() == 8) {
                this.f31324XO.setVisibility(0);
            }
            this.f31324XO.setProgress(i);
            if (i == 100) {
                this.f31324XO.setVisibility(8);
            }
        }

        @Override // com.octopus.ad.internal.view.II0XooXoX, android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            super.onShowCustomView(view, customViewCallback);
            if (view instanceof FrameLayout) {
                FrameLayout frameLayout = (FrameLayout) view;
                if (frameLayout.getFocusedChild() instanceof VideoView) {
                    VideoView videoView = (VideoView) frameLayout.getFocusedChild();
                    frameLayout.removeView(videoView);
                    ((Activity) oIX0oI.this.f31321II0xO0.getContext()).setContentView(videoView);
                    videoView.start();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class II0xO0 extends WebViewClient {
        public II0xO0() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
            if (cookieSyncManager != null) {
                cookieSyncManager.sync();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            com.octopus.ad.internal.utilities.oIX0oI.ooXIXxIX(com.octopus.ad.internal.utilities.oIX0oI.f18702oOoXoXO, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.opening_url, str));
            if (!str.startsWith("http")) {
                oIX0oI.this.II0xO0(str);
                return true;
            }
            return false;
        }
    }

    /* renamed from: oI.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C1121oIX0oI implements DownloadListener {
        public C1121oIX0oI() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            oIX0oI.this.f31321II0xO0.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            oIX0oI.this.X0o0xo();
        }
    }

    /* loaded from: classes11.dex */
    public class oxoX implements View.OnClickListener {
        public oxoX() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            oIX0oI.this.X0o0xo();
        }
    }

    public oIX0oI(Activity activity) {
        this.f31322oIX0oI = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0o0xo() {
        Activity activity = this.f31322oIX0oI;
        if (activity != null) {
            activity.finish();
        }
    }

    public final void II0xO0(String str) {
        Uri parse;
        if (x0o.II0XooXoX(str)) {
            parse = null;
        } else {
            parse = Uri.parse(str);
        }
        if (parse == null) {
            com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18702oOoXoXO, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.opening_url_failed, str));
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", parse);
        intent.setFlags(268435456);
        try {
            this.f31322oIX0oI.startActivity(intent);
            d();
            X0o0xo();
        } catch (Exception unused) {
            com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18702oOoXoXO, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.opening_url_failed, str));
        }
    }

    @Override // com.octopus.ad.AdActivity.I0Io
    @SuppressLint({"SetJavaScriptEnabled", "NewApi"})
    @TargetApi(17)
    public void a() {
        this.f31322oIX0oI.setTheme(R.style.OctopusTheme);
        this.f31322oIX0oI.setContentView(R.layout.oct_activity_in_app_browser);
        WebView poll = f31320I0Io.poll();
        this.f31321II0xO0 = poll;
        if (poll == null) {
            X0o0xo();
            return;
        }
        poll.getSettings();
        if (this.f31321II0xO0.getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) this.f31321II0xO0.getContext()).setBaseContext(this.f31322oIX0oI);
        }
        WindowManager.LayoutParams attributes = this.f31322oIX0oI.getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        this.f31322oIX0oI.getWindow().setAttributes(attributes);
        WebView webView = (WebView) this.f31322oIX0oI.findViewById(R.id.web_view);
        webView.getSettings().setSavePassword(false);
        ViewGroup.LayoutParams layoutParams = webView.getLayoutParams();
        ViewGroup viewGroup = (ViewGroup) webView.getParent();
        int indexOfChild = viewGroup.indexOfChild(webView);
        viewGroup.removeView(webView);
        I0oOoX.O0xOxO(this.f31321II0xO0);
        this.f31321II0xO0.setLayoutParams(layoutParams);
        this.f31321II0xO0.getSettings().setUseWideViewPort(true);
        this.f31321II0xO0.getSettings().setLoadWithOverviewMode(true);
        WebView.setWebContentsDebuggingEnabled(false);
        viewGroup.addView(this.f31321II0xO0, indexOfChild);
        ProgressBar progressBar = (ProgressBar) this.f31322oIX0oI.findViewById(R.id.progress_bar);
        String stringExtra = this.f31322oIX0oI.getIntent().getStringExtra("bridgeid");
        if (stringExtra != null) {
            Iterator<Pair<String, AdViewImpl.oo0xXOI0I>> it = AdViewImpl.oo0xXOI0I.f18881oIX0oI.iterator();
            while (it.hasNext()) {
                Pair<String, AdViewImpl.oo0xXOI0I> next = it.next();
                if (((String) next.first).equals(stringExtra)) {
                    AdViewImpl.oo0xXOI0I.f18881oIX0oI.remove(next);
                }
            }
        }
        this.f31321II0xO0.setDownloadListener(new C1121oIX0oI());
        this.f31321II0xO0.setWebViewClient(new II0xO0());
        this.f31321II0xO0.setWebChromeClient(new I0Io(this.f31322oIX0oI, progressBar));
        ((ImageView) this.f31322oIX0oI.findViewById(R.id.close_iv)).setOnClickListener(new oxoX());
    }

    @Override // com.octopus.ad.AdActivity.I0Io
    public void d() {
        WebView webView = this.f31321II0xO0;
        if (webView == null) {
            return;
        }
        I0oOoX.O0xOxO(webView);
        this.f31321II0xO0.destroy();
    }

    @Override // com.octopus.ad.AdActivity.I0Io
    public void e() {
        o0IXXIx.II0XooXoX.oIX0oI("octopus", "...........................backPressed...........................");
        if (this.f31321II0xO0.canGoBack()) {
            this.f31321II0xO0.goBack();
            o0IXXIx.II0XooXoX.oIX0oI("octopus", " mWebView.goBack()");
        } else {
            X0o0xo();
        }
    }

    @Override // com.octopus.ad.AdActivity.I0Io
    public WebView h() {
        return this.f31321II0xO0;
    }

    @Override // com.octopus.ad.AdActivity.I0Io
    public void b() {
    }

    @Override // com.octopus.ad.AdActivity.I0Io
    public void c() {
    }

    @Override // com.octopus.ad.AdActivity.I0Io
    public void f() {
    }

    @Override // com.octopus.ad.AdActivity.I0Io
    public void g() {
    }
}
