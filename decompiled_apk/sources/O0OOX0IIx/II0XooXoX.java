package O0OOX0IIx;

import O0OOX0IIx.XO;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.open.b.a;
import com.tencent.open.b.b;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import xoX.x0XOIxOo;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class II0XooXoX extends Oxx0IOOO implements a.oIX0oI {

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static Toast f1321O0xOxO;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public a f1322IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public String f1323IXxxXO;

    /* renamed from: OxI, reason: collision with root package name */
    public int f1324OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public o0Oo.II0xO0 f1325Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public Handler f1326OxxIIOOXO;

    /* renamed from: o00, reason: collision with root package name */
    public WeakReference<Context> f1327o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public oxoX f1328oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public b f1329xoXoI;

    /* loaded from: classes13.dex */
    public class I0Io extends XO.II0xO0 {
        public I0Io() {
        }
    }

    /* loaded from: classes13.dex */
    public class II0xO0 extends WebViewClient {
        public II0xO0() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            II0XooXoX.this.f1329xoXoI.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            xxIXOIIO.IXxxXO("openSDK_LOG.PKDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            II0XooXoX.this.f1328oI0IIXIo.oIX0oI(new o0Oo.I0Io(i, str, str2));
            if (II0XooXoX.this.f1327o00 != null && II0XooXoX.this.f1327o00.get() != null) {
                Toast.makeText((Context) II0XooXoX.this.f1327o00.get(), "网络连接异常或系统错误", 0).show();
            }
            II0XooXoX.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            xxIXOIIO.IXxxXO("openSDK_LOG.PKDialog", "Redirect URL: " + str);
            if (str.startsWith(XxXX.XO.oIX0oI().II0xO0((Context) II0XooXoX.this.f1327o00.get(), "auth://tauth.qq.com/"))) {
                II0XooXoX.this.f1328oI0IIXIo.onComplete(com.tencent.open.utils.II0xO0.xxX(str));
                II0XooXoX.this.dismiss();
                return true;
            }
            if (str.startsWith(com.tencent.connect.common.II0xO0.f26855oXX0IoI)) {
                II0XooXoX.this.f1328oI0IIXIo.onCancel();
                II0XooXoX.this.dismiss();
                return true;
            }
            if (str.startsWith(com.tencent.connect.common.II0xO0.f26820XXXI)) {
                II0XooXoX.this.dismiss();
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes13.dex */
    public class X0o0xo extends Handler {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public oxoX f1333oIX0oI;

        public X0o0xo(oxoX oxox, Looper looper) {
            super(looper);
            this.f1333oIX0oI = oxox;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            xxIXOIIO.XO("openSDK_LOG.PKDialog", "msg = " + message.what);
            int i = message.what;
            if (i == 1) {
                this.f1333oIX0oI.I0Io((String) message.obj);
                return;
            }
            if (i != 2) {
                if (i != 3) {
                    if (i == 5 && II0XooXoX.this.f1327o00 != null && II0XooXoX.this.f1327o00.get() != null) {
                        II0XooXoX.xoIox((Context) II0XooXoX.this.f1327o00.get(), (String) message.obj);
                        return;
                    }
                    return;
                }
                if (II0XooXoX.this.f1327o00 != null && II0XooXoX.this.f1327o00.get() != null) {
                    II0XooXoX.xxIXOIIO((Context) II0XooXoX.this.f1327o00.get(), (String) message.obj);
                    return;
                }
                return;
            }
            this.f1333oIX0oI.onCancel();
        }
    }

    /* loaded from: classes13.dex */
    public static class oxoX implements o0Oo.II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public String f1334I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public String f1335II0xO0;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public o0Oo.II0xO0 f1336X0o0xo;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public WeakReference<Context> f1337oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public String f1338oxoX;

        public oxoX(Context context, String str, String str2, String str3, o0Oo.II0xO0 iI0xO0) {
            this.f1337oIX0oI = new WeakReference<>(context);
            this.f1335II0xO0 = str;
            this.f1334I0Io = str2;
            this.f1338oxoX = str3;
            this.f1336X0o0xo = iI0xO0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void I0Io(String str) {
            try {
                onComplete(com.tencent.open.utils.II0xO0.xXxxox0I(str));
            } catch (JSONException e) {
                e.printStackTrace();
                oIX0oI(new o0Oo.I0Io(-4, com.tencent.connect.common.II0xO0.f26896xXOx, str));
            }
        }

        @Override // o0Oo.II0xO0
        public void oIX0oI(o0Oo.I0Io i0Io) {
            String str;
            if (i0Io.f31122II0xO0 != null) {
                str = i0Io.f31122II0xO0 + this.f1334I0Io;
            } else {
                str = this.f1334I0Io;
            }
            String str2 = str;
            x0XOIxOo.II0xO0().X0o0xo(this.f1335II0xO0 + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, i0Io.f31123oIX0oI, str2, false);
            o0Oo.II0xO0 iI0xO0 = this.f1336X0o0xo;
            if (iI0xO0 != null) {
                iI0xO0.oIX0oI(i0Io);
                this.f1336X0o0xo = null;
            }
        }

        @Override // o0Oo.II0xO0
        public void onCancel() {
            o0Oo.II0xO0 iI0xO0 = this.f1336X0o0xo;
            if (iI0xO0 != null) {
                iI0xO0.onCancel();
                this.f1336X0o0xo = null;
            }
        }

        @Override // o0Oo.II0xO0
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            x0XOIxOo.II0xO0().X0o0xo(this.f1335II0xO0 + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f1334I0Io, false);
            o0Oo.II0xO0 iI0xO0 = this.f1336X0o0xo;
            if (iI0xO0 != null) {
                iI0xO0.onComplete(jSONObject);
                this.f1336X0o0xo = null;
            }
        }
    }

    public II0XooXoX(Context context, String str, String str2, o0Oo.II0xO0 iI0xO0, xIxooxXX.II0xO0 iI0xO02) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f1327o00 = new WeakReference<>(context);
        this.f1323IXxxXO = str2;
        this.f1328oI0IIXIo = new oxoX(context, str, str2, iI0xO02.X0o0xo(), iI0xO0);
        this.f1326OxxIIOOXO = new X0o0xo(this.f1328oI0IIXIo, context.getMainLooper());
        this.f1325Oxx0xo = iI0xO0;
        this.f1324OxI = Math.round(context.getResources().getDisplayMetrics().density * 185.0f);
        xxIXOIIO.II0XooXoX("openSDK_LOG.PKDialog", "density=" + context.getResources().getDisplayMetrics().density + "; webviewHeight=" + this.f1324OxI);
    }

    private void X0o0xo() {
        a aVar = new a(this.f1327o00.get());
        this.f1322IIXOooo = aVar;
        aVar.setBackgroundColor(1711276032);
        this.f1322IIXOooo.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        b bVar = new b(this.f1327o00.get());
        this.f1329xoXoI = bVar;
        bVar.setBackgroundColor(0);
        this.f1329xoXoI.setBackgroundDrawable(null);
        try {
            View.class.getMethod("setLayerType", Integer.TYPE, Paint.class).invoke(this.f1329xoXoI, 1, new Paint());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f1324OxI);
        layoutParams.addRule(13, -1);
        this.f1329xoXoI.setLayoutParams(layoutParams);
        this.f1322IIXOooo.addView(this.f1329xoXoI);
        this.f1322IIXOooo.oIX0oI(this);
        setContentView(this.f1322IIXOooo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xoIox(Context context, String str) {
        if (context != null && str != null) {
            try {
                JSONObject xXxxox0I2 = com.tencent.open.utils.II0xO0.xXxxox0I(str);
                xXxxox0I2.getInt("action");
                xXxxox0I2.getString("msg");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xxIXOIIO(Context context, String str) {
        try {
            JSONObject xXxxox0I2 = com.tencent.open.utils.II0xO0.xXxxox0I(str);
            int i = xXxxox0I2.getInt("type");
            String string = xXxxox0I2.getString("msg");
            if (i == 0) {
                Toast toast = f1321O0xOxO;
                if (toast == null) {
                    f1321O0xOxO = Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    f1321O0xOxO.setText(string);
                    f1321O0xOxO.setDuration(0);
                }
                f1321O0xOxO.show();
                return;
            }
            if (i == 1) {
                Toast toast2 = f1321O0xOxO;
                if (toast2 == null) {
                    f1321O0xOxO = Toast.makeText(context, string, 1);
                } else {
                    toast2.setView(toast2.getView());
                    f1321O0xOxO.setText(string);
                    f1321O0xOxO.setDuration(1);
                }
                f1321O0xOxO.show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void II0XooXoX() {
        this.f1329xoXoI.setVerticalScrollBarEnabled(false);
        this.f1329xoXoI.setHorizontalScrollBarEnabled(false);
        this.f1329xoXoI.setWebViewClient(new II0xO0());
        this.f1329xoXoI.setWebChromeClient(this.f1346Oo);
        this.f1329xoXoI.clearFormData();
        WebSettings settings = this.f1329xoXoI.getSettings();
        if (settings == null) {
            return;
        }
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        WeakReference<Context> weakReference = this.f1327o00;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.f1327o00.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f1347XO.oIX0oI(new I0Io(), "sdk_js_if");
        this.f1329xoXoI.clearView();
        this.f1329xoXoI.loadUrl(this.f1323IXxxXO);
        this.f1329xoXoI.getSettings().setSavePassword(false);
    }

    @Override // com.tencent.open.b.a.oIX0oI
    public void a(int i) {
        WeakReference<Context> weakReference = this.f1327o00;
        if (weakReference != null && weakReference.get() != null) {
            if (i < this.f1324OxI && 2 == this.f1327o00.get().getResources().getConfiguration().orientation) {
                this.f1329xoXoI.getLayoutParams().height = i;
            } else {
                this.f1329xoXoI.getLayoutParams().height = this.f1324OxI;
            }
        }
        xxIXOIIO.II0XooXoX("openSDK_LOG.PKDialog", "onKeyboardShown keyboard show");
    }

    @Override // O0OOX0IIx.Oxx0IOOO
    public void oIX0oI(String str) {
        xxIXOIIO.XO("openSDK_LOG.PKDialog", "--onConsoleMessage--");
        try {
            this.f1347XO.I0Io(this.f1329xoXoI, str);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // O0OOX0IIx.Oxx0IOOO, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setSoftInputMode(16);
        getWindow().setSoftInputMode(1);
        X0o0xo();
        II0XooXoX();
    }

    @Override // com.tencent.open.b.a.oIX0oI
    public void a() {
        this.f1329xoXoI.getLayoutParams().height = this.f1324OxI;
        xxIXOIIO.II0XooXoX("openSDK_LOG.PKDialog", "onKeyboardHidden keyboard hide");
    }
}
