package O0OOX0IIx;

import O0OOX0IIx.XO;
import android.R;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.open.b.b;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import xoX.x0XOIxOo;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class X0o0xo extends Oxx0IOOO {

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static WeakReference<ProgressDialog> f1350XI0IXoo;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public FrameLayout f1352IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public WeakReference<Context> f1353IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public xIxooxXX.II0xO0 f1354O0xOxO;

    /* renamed from: OxI, reason: collision with root package name */
    public boolean f1355OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public String f1356Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public o0Oo.II0xO0 f1357OxxIIOOXO;

    /* renamed from: o00, reason: collision with root package name */
    public Handler f1358o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public oxoX f1359oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public b f1360xoXoI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final FrameLayout.LayoutParams f1349X0IIOO = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static Toast f1351XIxXXX0x0 = null;

    /* loaded from: classes13.dex */
    public class I0Io extends XO.II0xO0 {
        public I0Io() {
        }

        public void I0Io(String str) {
            xxIXOIIO.XO("openSDK_LOG.TDialog", "JsListener onAddShare");
            II0XooXoX(str);
        }

        public void II0XooXoX(String str) {
            X0o0xo.this.f1358o00.obtainMessage(1, str).sendToTarget();
            xxIXOIIO.II0XooXoX("openSDK_LOG.TDialog", "JsListener onComplete" + str);
            X0o0xo.this.dismiss();
        }

        public void OOXIXo(String str) {
            X0o0xo.this.f1358o00.obtainMessage(3, str).sendToTarget();
        }

        public void Oxx0IOOO() {
            oxoX("");
        }

        public void X0o0xo(String str) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.TDialog", "JsListener onCancelAddShare" + str);
            oxoX("cancel");
        }

        public void XO() {
            xxIXOIIO.II0XooXoX("openSDK_LOG.TDialog", "JsListener onCancelInvite");
            oxoX("");
        }

        public void oxoX(String str) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.TDialog", "JsListener onCancel --msg = " + str);
            X0o0xo.this.f1358o00.obtainMessage(2, str).sendToTarget();
            X0o0xo.this.dismiss();
        }

        public void xoIox(String str) {
            X0o0xo.this.f1358o00.obtainMessage(4, str).sendToTarget();
        }

        public void xxIXOIIO(String str) {
            II0XooXoX(str);
        }
    }

    /* loaded from: classes13.dex */
    public class II0xO0 extends WebViewClient {
        public II0xO0() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            X0o0xo.this.f1360xoXoI.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            xxIXOIIO.IXxxXO("openSDK_LOG.TDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            X0o0xo.this.f1359oI0IIXIo.oIX0oI(new o0Oo.I0Io(i, str, str2));
            if (X0o0xo.this.f1353IXxxXO != null && X0o0xo.this.f1353IXxxXO.get() != null) {
                Toast.makeText((Context) X0o0xo.this.f1353IXxxXO.get(), "网络连接异常或系统错误", 0).show();
            }
            X0o0xo.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse;
            xxIXOIIO.IXxxXO("openSDK_LOG.TDialog", "Redirect URL: " + str);
            if (str.startsWith(XxXX.XO.oIX0oI().II0xO0((Context) X0o0xo.this.f1353IXxxXO.get(), "auth://tauth.qq.com/"))) {
                X0o0xo.this.f1359oI0IIXIo.onComplete(com.tencent.open.utils.II0xO0.xxX(str));
                if (X0o0xo.this.isShowing()) {
                    X0o0xo.this.dismiss();
                }
                return true;
            }
            if (str.startsWith(com.tencent.connect.common.II0xO0.f26855oXX0IoI)) {
                X0o0xo.this.f1359oI0IIXIo.onCancel();
                if (X0o0xo.this.isShowing()) {
                    X0o0xo.this.dismiss();
                }
                return true;
            }
            if (str.startsWith(com.tencent.connect.common.II0xO0.f26820XXXI)) {
                if (X0o0xo.this.isShowing()) {
                    X0o0xo.this.dismiss();
                }
                return true;
            }
            if (!str.startsWith(com.tencent.connect.common.II0xO0.f26735I0xX0) && !str.endsWith(com.huawei.hms.ads.dynamicloader.b.b)) {
                if (str.startsWith("auth://progress")) {
                    return true;
                }
                return false;
            }
            try {
                if (str.startsWith(com.tencent.connect.common.II0xO0.f26735I0xX0)) {
                    parse = Uri.parse(Uri.decode(str.substring(11)));
                } else {
                    parse = Uri.parse(Uri.decode(str));
                }
                Intent intent = new Intent("android.intent.action.VIEW", parse);
                intent.addFlags(268435456);
                if (X0o0xo.this.f1353IXxxXO != null && X0o0xo.this.f1353IXxxXO.get() != null) {
                    ((Context) X0o0xo.this.f1353IXxxXO.get()).startActivity(intent);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    /* renamed from: O0OOX0IIx.X0o0xo$X0o0xo, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class HandlerC0031X0o0xo extends Handler {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public oxoX f1364oIX0oI;

        public HandlerC0031X0o0xo(oxoX oxox, Looper looper) {
            super(looper);
            this.f1364oIX0oI = oxox;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            xxIXOIIO.XO("openSDK_LOG.TDialog", "--handleMessage--msg.WHAT = " + message.what);
            int i = message.what;
            if (i == 1) {
                this.f1364oIX0oI.I0Io((String) message.obj);
                return;
            }
            if (i != 2) {
                if (i != 3) {
                    if (i == 5 && X0o0xo.this.f1353IXxxXO != null && X0o0xo.this.f1353IXxxXO.get() != null) {
                        X0o0xo.xoIox((Context) X0o0xo.this.f1353IXxxXO.get(), (String) message.obj);
                        return;
                    }
                    return;
                }
                if (X0o0xo.this.f1353IXxxXO != null && X0o0xo.this.f1353IXxxXO.get() != null) {
                    X0o0xo.II0XooXoX((Context) X0o0xo.this.f1353IXxxXO.get(), (String) message.obj);
                    return;
                }
                return;
            }
            this.f1364oIX0oI.onCancel();
        }
    }

    /* loaded from: classes13.dex */
    public static class oxoX implements o0Oo.II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public String f1365I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public String f1366II0xO0;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public o0Oo.II0xO0 f1367X0o0xo;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public WeakReference<Context> f1368oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public String f1369oxoX;

        public oxoX(Context context, String str, String str2, String str3, o0Oo.II0xO0 iI0xO0) {
            this.f1368oIX0oI = new WeakReference<>(context);
            this.f1366II0xO0 = str;
            this.f1365I0Io = str2;
            this.f1369oxoX = str3;
            this.f1367X0o0xo = iI0xO0;
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
                str = i0Io.f31122II0xO0 + this.f1365I0Io;
            } else {
                str = this.f1365I0Io;
            }
            String str2 = str;
            x0XOIxOo.II0xO0().X0o0xo(this.f1366II0xO0 + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, i0Io.f31123oIX0oI, str2, false);
            o0Oo.II0xO0 iI0xO0 = this.f1367X0o0xo;
            if (iI0xO0 != null) {
                iI0xO0.oIX0oI(i0Io);
                this.f1367X0o0xo = null;
            }
        }

        @Override // o0Oo.II0xO0
        public void onCancel() {
            o0Oo.II0xO0 iI0xO0 = this.f1367X0o0xo;
            if (iI0xO0 != null) {
                iI0xO0.onCancel();
                this.f1367X0o0xo = null;
            }
        }

        @Override // o0Oo.II0xO0
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            x0XOIxOo.II0xO0().X0o0xo(this.f1366II0xO0 + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f1365I0Io, false);
            o0Oo.II0xO0 iI0xO0 = this.f1367X0o0xo;
            if (iI0xO0 != null) {
                iI0xO0.onComplete(jSONObject);
                this.f1367X0o0xo = null;
            }
        }
    }

    public X0o0xo(Context context, String str, String str2, o0Oo.II0xO0 iI0xO0, xIxooxXX.II0xO0 iI0xO02) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f1355OxI = false;
        this.f1354O0xOxO = null;
        this.f1353IXxxXO = new WeakReference<>(context);
        this.f1356Oxx0xo = str2;
        this.f1359oI0IIXIo = new oxoX(context, str, str2, iI0xO02.X0o0xo(), iI0xO0);
        this.f1358o00 = new HandlerC0031X0o0xo(this.f1359oI0IIXIo, context.getMainLooper());
        this.f1357OxxIIOOXO = iI0xO0;
        this.f1354O0xOxO = iI0xO02;
    }

    public static void II0XooXoX(Context context, String str) {
        try {
            JSONObject xXxxox0I2 = com.tencent.open.utils.II0xO0.xXxxox0I(str);
            int i = xXxxox0I2.getInt("type");
            String string = xXxxox0I2.getString("msg");
            if (i == 0) {
                Toast toast = f1351XIxXXX0x0;
                if (toast == null) {
                    f1351XIxXXX0x0 = Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    f1351XIxXXX0x0.setText(string);
                    f1351XIxXXX0x0.setDuration(0);
                }
                f1351XIxXXX0x0.show();
                return;
            }
            if (i == 1) {
                Toast toast2 = f1351XIxXXX0x0;
                if (toast2 == null) {
                    f1351XIxXXX0x0 = Toast.makeText(context, string, 1);
                } else {
                    toast2.setView(toast2.getView());
                    f1351XIxXXX0x0.setText(string);
                    f1351XIxXXX0x0.setDuration(1);
                }
                f1351XIxXXX0x0.show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void a() {
        new TextView(this.f1353IXxxXO.get()).setText("test");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        b bVar = new b(this.f1353IXxxXO.get());
        this.f1360xoXoI = bVar;
        bVar.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(this.f1353IXxxXO.get());
        this.f1352IIXOooo = frameLayout;
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        this.f1352IIXOooo.addView(this.f1360xoXoI);
        setContentView(this.f1352IIXOooo);
    }

    public static void xoIox(Context context, String str) {
        if (context != null && str != null) {
            try {
                JSONObject xXxxox0I2 = com.tencent.open.utils.II0xO0.xXxxox0I(str);
                int i = xXxxox0I2.getInt("action");
                String string = xXxxox0I2.getString("msg");
                if (i == 1) {
                    WeakReference<ProgressDialog> weakReference = f1350XI0IXoo;
                    if (weakReference != null && weakReference.get() != null) {
                        f1350XI0IXoo.get().setMessage(string);
                        if (!f1350XI0IXoo.get().isShowing()) {
                            f1350XI0IXoo.get().show();
                        }
                    }
                    ProgressDialog progressDialog = new ProgressDialog(context);
                    progressDialog.setMessage(string);
                    f1350XI0IXoo = new WeakReference<>(progressDialog);
                    progressDialog.show();
                } else if (i == 0) {
                    WeakReference<ProgressDialog> weakReference2 = f1350XI0IXoo;
                    if (weakReference2 == null) {
                        return;
                    }
                    if (weakReference2.get() != null && f1350XI0IXoo.get().isShowing()) {
                        f1350XI0IXoo.get().dismiss();
                        f1350XI0IXoo = null;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void X0o0xo() {
        this.f1360xoXoI.setVerticalScrollBarEnabled(false);
        this.f1360xoXoI.setHorizontalScrollBarEnabled(false);
        this.f1360xoXoI.setWebViewClient(new II0xO0());
        this.f1360xoXoI.setWebChromeClient(this.f1346Oo);
        this.f1360xoXoI.clearFormData();
        WebSettings settings = this.f1360xoXoI.getSettings();
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
        WeakReference<Context> weakReference = this.f1353IXxxXO;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.f1353IXxxXO.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f1347XO.oIX0oI(new I0Io(), "sdk_js_if");
        this.f1360xoXoI.loadUrl(this.f1356Oxx0xo);
        this.f1360xoXoI.setLayoutParams(f1349X0IIOO);
        this.f1360xoXoI.setVisibility(4);
        this.f1360xoXoI.getSettings().setSavePassword(false);
    }

    @Override // O0OOX0IIx.Oxx0IOOO
    public void oIX0oI(String str) {
        xxIXOIIO.XO("openSDK_LOG.TDialog", "--onConsoleMessage--");
        try {
            this.f1347XO.I0Io(this.f1360xoXoI, str);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        oxoX oxox = this.f1359oI0IIXIo;
        if (oxox != null) {
            oxox.onCancel();
        }
        super.onBackPressed();
    }

    @Override // O0OOX0IIx.Oxx0IOOO, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        a();
        X0o0xo();
    }
}
