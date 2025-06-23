package xIxooxXX;

import XXO0.oIX0oI;
import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.hms.ads.dynamicloader.b;
import com.sma.smartv3.initializer.IXxxXO;
import com.szabh.smable3.entity.Languages;
import com.tencent.open.b.c;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.web.security.JniInterface;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.apache.log4j.spi.LocationInfo;
import org.json.JSONException;
import org.json.JSONObject;
import xIxooxXX.oxoX;
import xoX.x0XOIxOo;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class I0Io extends Dialog {

    /* renamed from: IIX0o, reason: collision with root package name */
    public long f34359IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public FrameLayout f34360IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public o0Oo.II0xO0 f34361IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public c f34362O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public XO f34363Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public String f34364OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public Handler f34365Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public LinearLayout f34366OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public Context f34367X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public O0x.oxoX f34368XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public boolean f34369XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public String f34370XO;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public String f34371XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public Button f34372o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public FrameLayout f34373oI0IIXIo;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public long f34374ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public HashMap<String, Runnable> f34375xI;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public String f34376xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    public ProgressBar f34377xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public int f34378xxX;

    /* renamed from: xIxooxXX.I0Io$I0Io, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class ViewOnTouchListenerC1152I0Io implements View.OnTouchListener {
        public ViewOnTouchListenerC1152I0Io() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if ((action == 0 || action == 1) && !view.hasFocus()) {
                view.requestFocus();
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes13.dex */
    public class II0XooXoX implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public String f34381XO;

        public II0XooXoX(String str) {
            this.f34381XO = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            xxIXOIIO.IXxxXO("openSDK_LOG.AuthDialog", "-->timeoutUrl: " + this.f34381XO + " | mRetryUrl: " + I0Io.this.f34371XxX0x0xxx);
            if (this.f34381XO.equals(I0Io.this.f34371XxX0x0xxx)) {
                I0Io.this.f34363Oo.oIX0oI(new o0Oo.I0Io(9002, "请求页面超时，请稍后重试！", I0Io.this.f34371XxX0x0xxx));
                I0Io.this.dismiss();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class II0xO0 implements View.OnLongClickListener {
        public II0xO0() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return true;
        }
    }

    /* loaded from: classes13.dex */
    public class Oxx0IOOO extends Handler {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public XO f34384oIX0oI;

        public Oxx0IOOO(XO xo2, Looper looper) {
            super(looper);
            this.f34384oIX0oI = xo2;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                this.f34384oIX0oI.II0xO0((String) message.obj);
            } else {
                if (i != 2) {
                    if (i == 3) {
                        I0Io.OOXIXo(I0Io.this.f34367X0IIOO, (String) message.obj);
                        return;
                    }
                    return;
                }
                this.f34384oIX0oI.onCancel();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class X0o0xo extends WebViewClient {

        /* renamed from: xIxooxXX.I0Io$X0o0xo$I0Io, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class DialogInterfaceOnClickListenerC1153I0Io implements DialogInterface.OnClickListener {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ SslErrorHandler f34387XO;

            public DialogInterfaceOnClickListenerC1153I0Io(SslErrorHandler sslErrorHandler) {
                this.f34387XO = sslErrorHandler;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                this.f34387XO.cancel();
                I0Io.this.dismiss();
            }
        }

        /* loaded from: classes13.dex */
        public class II0xO0 implements DialogInterface.OnClickListener {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ SslErrorHandler f34389XO;

            public II0xO0(SslErrorHandler sslErrorHandler) {
                this.f34389XO = sslErrorHandler;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                this.f34389XO.proceed();
            }
        }

        /* loaded from: classes13.dex */
        public class oIX0oI implements Runnable {
            public oIX0oI() {
            }

            @Override // java.lang.Runnable
            public void run() {
                I0Io.this.f34362O0xOxO.loadUrl(I0Io.this.f34371XxX0x0xxx);
            }
        }

        public X0o0xo() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            xxIXOIIO.IXxxXO("openSDK_LOG.AuthDialog", "-->onPageFinished, url: " + str);
            I0Io.this.f34360IIXOooo.setVisibility(8);
            if (I0Io.this.f34362O0xOxO != null) {
                I0Io.this.f34362O0xOxO.setVisibility(0);
            }
            if (!TextUtils.isEmpty(str)) {
                I0Io.this.f34365Oxx0xo.removeCallbacks((Runnable) I0Io.this.f34375xI.remove(str));
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            xxIXOIIO.IXxxXO("openSDK_LOG.AuthDialog", "-->onPageStarted, url: " + str);
            super.onPageStarted(webView, str, bitmap);
            I0Io.this.f34360IIXOooo.setVisibility(0);
            I0Io.this.f34359IIX0o = SystemClock.elapsedRealtime();
            if (!TextUtils.isEmpty(I0Io.this.f34371XxX0x0xxx)) {
                I0Io.this.f34365Oxx0xo.removeCallbacks((Runnable) I0Io.this.f34375xI.remove(I0Io.this.f34371XxX0x0xxx));
            }
            I0Io.this.f34371XxX0x0xxx = str;
            I0Io i0Io = I0Io.this;
            II0XooXoX iI0XooXoX = new II0XooXoX(i0Io.f34371XxX0x0xxx);
            I0Io.this.f34375xI.put(str, iI0XooXoX);
            I0Io.this.f34365Oxx0xo.postDelayed(iI0XooXoX, 120000L);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            xxIXOIIO.oOoXoXO("openSDK_LOG.AuthDialog", "-->onReceivedError, errorCode: " + i + " | description: " + str);
            if (!com.tencent.open.utils.II0xO0.OxI(I0Io.this.f34367X0IIOO)) {
                I0Io.this.f34363Oo.oIX0oI(new o0Oo.I0Io(9001, "当前网络不可用，请稍后重试！", str2));
                I0Io.this.dismiss();
                return;
            }
            if (!I0Io.this.f34371XxX0x0xxx.startsWith("https://login.imgcache.qq.com/ptlogin/static/qzsjump.html?")) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - I0Io.this.f34359IIX0o;
                if (I0Io.this.f34378xxX < 1 && elapsedRealtime < I0Io.this.f34374ooXIXxIX) {
                    I0Io.XIxXXX0x0(I0Io.this);
                    I0Io.this.f34365Oxx0xo.postDelayed(new oIX0oI(), 500L);
                    return;
                } else {
                    I0Io.this.f34362O0xOxO.loadUrl(I0Io.this.I0Io());
                    return;
                }
            }
            I0Io.this.f34363Oo.oIX0oI(new o0Oo.I0Io(i, str, str2));
            I0Io.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String str;
            String str2;
            String str3;
            xxIXOIIO.II0XooXoX("openSDK_LOG.AuthDialog", "-->onReceivedSslError " + sslError.getPrimaryError() + "请求不合法，请检查手机安全设置，如系统时间、代理等");
            if (Locale.getDefault().getLanguage().equals(Languages.DEFAULT_LANGUAGE_ZH)) {
                str = "ssl证书无效，是否继续访问？";
                str2 = "是";
                str3 = "否";
            } else {
                str = "The SSL certificate is invalid,do you countinue?";
                str2 = "yes";
                str3 = "no";
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(I0Io.this.f34367X0IIOO);
            builder.setMessage(str);
            builder.setPositiveButton(str2, new II0xO0(sslErrorHandler));
            builder.setNegativeButton(str3, new DialogInterfaceOnClickListenerC1153I0Io(sslErrorHandler));
            builder.create().show();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse;
            List<String> pathSegments;
            xxIXOIIO.IXxxXO("openSDK_LOG.AuthDialog", "-->Redirect URL: " + str);
            if (str.startsWith("auth://browser")) {
                JSONObject xxX2 = com.tencent.open.utils.II0xO0.xxX(str);
                I0Io i0Io = I0Io.this;
                i0Io.f34369XIxXXX0x0 = i0Io.IIXOooo();
                if (!I0Io.this.f34369XIxXXX0x0) {
                    if (xxX2.optString("fail_cb", null) != null) {
                        I0Io.this.Oxx0IOOO(xxX2.optString("fail_cb"), "");
                    } else if (xxX2.optInt("fall_to_wv") == 1) {
                        I0Io i0Io2 = I0Io.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append(I0Io.this.f34370XO);
                        String str2 = I0Io.this.f34370XO;
                        String str3 = LocationInfo.NA;
                        if (str2.indexOf(LocationInfo.NA) > -1) {
                            str3 = "&";
                        }
                        sb.append(str3);
                        i0Io2.f34370XO = sb.toString();
                        I0Io.this.f34370XO = I0Io.this.f34370XO + "browser_error=1";
                        I0Io.this.f34362O0xOxO.loadUrl(I0Io.this.f34370XO);
                    } else {
                        String optString = xxX2.optString("redir", null);
                        if (optString != null) {
                            I0Io.this.f34362O0xOxO.loadUrl(optString);
                        }
                    }
                }
                return true;
            }
            if (str.startsWith("auth://tauth.qq.com/")) {
                I0Io.this.f34363Oo.onComplete(com.tencent.open.utils.II0xO0.xxX(str));
                I0Io.this.dismiss();
                return true;
            }
            if (str.startsWith(com.tencent.connect.common.II0xO0.f26855oXX0IoI)) {
                I0Io.this.f34363Oo.onCancel();
                I0Io.this.dismiss();
                return true;
            }
            if (str.startsWith(com.tencent.connect.common.II0xO0.f26820XXXI)) {
                I0Io.this.dismiss();
                return true;
            }
            if (!str.startsWith(com.tencent.connect.common.II0xO0.f26735I0xX0) && !str.endsWith(b.b)) {
                if (str.startsWith("auth://progress")) {
                    try {
                        pathSegments = Uri.parse(str).getPathSegments();
                    } catch (Exception unused) {
                    }
                    if (pathSegments.isEmpty()) {
                        return true;
                    }
                    int intValue = Integer.valueOf(pathSegments.get(0)).intValue();
                    if (intValue == 0) {
                        I0Io.this.f34360IIXOooo.setVisibility(8);
                        I0Io.this.f34362O0xOxO.setVisibility(0);
                    } else if (intValue == 1) {
                        I0Io.this.f34360IIXOooo.setVisibility(0);
                    }
                    return true;
                }
                if (str.startsWith("auth://onLoginSubmit")) {
                    try {
                        List<String> pathSegments2 = Uri.parse(str).getPathSegments();
                        if (!pathSegments2.isEmpty()) {
                            I0Io.this.f34376xXxxox0I = pathSegments2.get(0);
                        }
                    } catch (Exception unused2) {
                    }
                    return true;
                }
                if (I0Io.this.f34368XI0IXoo.I0Io(I0Io.this.f34362O0xOxO, str)) {
                    return true;
                }
                xxIXOIIO.oOoXoXO("openSDK_LOG.AuthDialog", "-->Redirect URL: return false");
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
                I0Io.this.f34367X0IIOO.startActivity(intent);
            } catch (Exception e) {
                xxIXOIIO.xxIXOIIO("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", e);
            }
            return true;
        }

        public /* synthetic */ X0o0xo(I0Io i0Io, oIX0oI oix0oi) {
            this();
        }
    }

    /* loaded from: classes13.dex */
    public class XO implements o0Oo.II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public String f34391I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public String f34392II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public String f34394oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public o0Oo.II0xO0 f34395oxoX;

        public XO(String str, String str2, String str3, o0Oo.II0xO0 iI0xO0) {
            this.f34394oIX0oI = str;
            this.f34392II0xO0 = str2;
            this.f34391I0Io = str3;
            this.f34395oxoX = iI0xO0;
        }

        public final void II0xO0(String str) {
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
                str = i0Io.f31122II0xO0 + this.f34392II0xO0;
            } else {
                str = this.f34392II0xO0;
            }
            x0XOIxOo.II0xO0().X0o0xo(this.f34394oIX0oI + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, i0Io.f31123oIX0oI, str, false);
            I0Io.this.oxoX(str);
            o0Oo.II0xO0 iI0xO0 = this.f34395oxoX;
            if (iI0xO0 != null) {
                iI0xO0.oIX0oI(i0Io);
                this.f34395oxoX = null;
            }
        }

        @Override // o0Oo.II0xO0
        public void onCancel() {
            o0Oo.II0xO0 iI0xO0 = this.f34395oxoX;
            if (iI0xO0 != null) {
                iI0xO0.onCancel();
                this.f34395oxoX = null;
            }
        }

        @Override // o0Oo.II0xO0
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            x0XOIxOo.II0xO0().X0o0xo(this.f34394oIX0oI + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f34392II0xO0, false);
            o0Oo.II0xO0 iI0xO0 = this.f34395oxoX;
            if (iI0xO0 != null) {
                iI0xO0.onComplete(jSONObject);
                this.f34395oxoX = null;
            }
        }
    }

    /* loaded from: classes13.dex */
    public class oIX0oI implements View.OnClickListener {
        public oIX0oI() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            I0Io.this.dismiss();
            if (!I0Io.this.f34369XIxXXX0x0 && I0Io.this.f34363Oo != null) {
                I0Io.this.f34363Oo.onCancel();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class oxoX implements DialogInterface.OnDismissListener {
        public oxoX() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            try {
                if (JniInterface.f26980oIX0oI) {
                    JniInterface.clearAllPWD();
                }
            } catch (Exception unused) {
            }
        }
    }

    public I0Io(Context context, String str, String str2, o0Oo.II0xO0 iI0xO0, xIxooxXX.II0xO0 iI0xO02) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f34369XIxXXX0x0 = false;
        this.f34359IIX0o = 0L;
        this.f34374ooXIXxIX = 30000L;
        this.f34367X0IIOO = context;
        this.f34370XO = str2;
        this.f34363Oo = new XO(str, str2, iI0xO02.X0o0xo(), iI0xO0);
        this.f34365Oxx0xo = new Oxx0IOOO(this.f34363Oo, context.getMainLooper());
        this.f34361IXxxXO = iI0xO0;
        this.f34364OxI = str;
        this.f34368XI0IXoo = new O0x.oxoX();
        getWindow().setSoftInputMode(32);
    }

    public static void OOXIXo(Context context, String str) {
        try {
            JSONObject xXxxox0I2 = com.tencent.open.utils.II0xO0.xXxxox0I(str);
            int i = xXxxox0I2.getInt("type");
            Toast.makeText(context.getApplicationContext(), xXxxox0I2.getString("msg"), i).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static /* synthetic */ int XIxXXX0x0(I0Io i0Io) {
        int i = i0Io.f34378xxX;
        i0Io.f34378xxX = i + 1;
        return i;
    }

    public final String I0Io() {
        String str = this.f34370XO;
        String str2 = "https://login.imgcache.qq.com/ptlogin/static/qzsjump.html?" + str.substring(str.indexOf(LocationInfo.NA) + 1);
        xxIXOIIO.oOoXoXO("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: https://login.imgcache.qq.com/ptlogin/static/qzsjump.html?");
        return str2;
    }

    public final boolean IIXOooo() {
        xIxooxXX.oxoX II0xO02 = xIxooxXX.oxoX.II0xO0();
        String oxoX2 = II0xO02.oxoX();
        oxoX.oIX0oI oix0oi = new oxoX.oIX0oI();
        oix0oi.f34453oIX0oI = this.f34361IXxxXO;
        oix0oi.f34452II0xO0 = this;
        oix0oi.f34451I0Io = oxoX2;
        String oIX0oI2 = II0xO02.oIX0oI(oix0oi);
        String str = this.f34370XO;
        String substring = str.substring(0, str.indexOf(LocationInfo.NA));
        Bundle OxxIIOOXO2 = com.tencent.open.utils.II0xO0.OxxIIOOXO(this.f34370XO);
        OxxIIOOXO2.putString("token_key", oxoX2);
        OxxIIOOXO2.putString("serial", oIX0oI2);
        OxxIIOOXO2.putString("browser", "1");
        String str2 = substring + LocationInfo.NA + HttpUtils.XO(OxxIIOOXO2);
        this.f34370XO = str2;
        return com.tencent.open.utils.II0xO0.x0xO0oo(this.f34367X0IIOO, str2);
    }

    public final void IXxxXO() {
        TextView textView;
        this.f34377xoXoI = new ProgressBar(this.f34367X0IIOO);
        this.f34377xoXoI.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f34366OxxIIOOXO = new LinearLayout(this.f34367X0IIOO);
        if (this.f34364OxI.equals("action_login")) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.leftMargin = 5;
            textView = new TextView(this.f34367X0IIOO);
            if (Locale.getDefault().getLanguage().equals(Languages.DEFAULT_LANGUAGE_ZH)) {
                textView.setText("登录中...");
            } else {
                textView.setText("Logging in...");
            }
            textView.setTextColor(Color.rgb(255, 255, 255));
            textView.setTextSize(18.0f);
            textView.setLayoutParams(layoutParams);
        } else {
            textView = null;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.f34366OxxIIOOXO.setLayoutParams(layoutParams2);
        this.f34366OxxIIOOXO.addView(this.f34377xoXoI);
        if (textView != null) {
            this.f34366OxxIIOOXO.addView(textView);
        }
        this.f34360IIXOooo = new FrameLayout(this.f34367X0IIOO);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams3.gravity = 17;
        this.f34360IIXOooo.setLayoutParams(layoutParams3);
        this.f34360IIXOooo.setBackgroundColor(Color.parseColor("#B3000000"));
        this.f34360IIXOooo.addView(this.f34366OxxIIOOXO);
    }

    public void Oxx0IOOO(String str, String str2) {
        this.f34362O0xOxO.loadUrl(x0xO.II0xO0.f34059xoIox + str + oIX0oI.I0Io.f4096II0xO0 + str2 + ");void(" + System.currentTimeMillis() + ");");
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f34375xI.clear();
        this.f34365Oxx0xo.removeCallbacksAndMessages(null);
        try {
            Context context = this.f34367X0IIOO;
            if ((context instanceof Activity) && !((Activity) context).isFinishing() && isShowing()) {
                super.dismiss();
                xxIXOIIO.oOoXoXO("openSDK_LOG.AuthDialog", "-->dismiss dialog");
            }
        } catch (Exception e) {
            xxIXOIIO.xxIXOIIO("openSDK_LOG.AuthDialog", "-->dismiss dialog exception:", e);
        }
        c cVar = this.f34362O0xOxO;
        if (cVar != null) {
            cVar.destroy();
            this.f34362O0xOxO = null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void oI0IIXIo() {
        this.f34362O0xOxO.setVerticalScrollBarEnabled(false);
        this.f34362O0xOxO.setHorizontalScrollBarEnabled(false);
        this.f34362O0xOxO.setWebViewClient(new X0o0xo(this, null));
        this.f34362O0xOxO.setWebChromeClient(new WebChromeClient());
        this.f34362O0xOxO.clearFormData();
        this.f34362O0xOxO.clearSslPreferences();
        this.f34362O0xOxO.setOnLongClickListener(new II0xO0());
        this.f34362O0xOxO.setOnTouchListener(new ViewOnTouchListenerC1152I0Io());
        WebSettings settings = this.f34362O0xOxO.getSettings();
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.f34367X0IIOO.getDir("databases", 0).getPath());
        settings.setDomStorageEnabled(true);
        xxIXOIIO.IXxxXO("openSDK_LOG.AuthDialog", "-->mUrl : " + this.f34370XO);
        String str = this.f34370XO;
        this.f34371XxX0x0xxx = str;
        this.f34362O0xOxO.loadUrl(str);
        this.f34362O0xOxO.setVisibility(4);
        this.f34362O0xOxO.getSettings().setSavePassword(false);
        this.f34368XI0IXoo.oIX0oI(new O0x.II0xO0(), "SecureJsInterface");
        O0x.II0xO0.f1495II0xO0 = false;
        super.setOnDismissListener(new oxoX());
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (!this.f34369XIxXXX0x0) {
            this.f34363Oo.onCancel();
        }
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        Window window = getWindow();
        if (window != null) {
            window.setFlags(1024, 1024);
        }
        super.onCreate(bundle);
        if (window != null) {
            window.getDecorView().setSystemUiVisibility(1280);
        }
        xoIox();
        oI0IIXIo();
        this.f34375xI = new HashMap<>();
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
    }

    public final String oxoX(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.f34376xXxxox0I) && this.f34376xXxxox0I.length() >= 4) {
            String str2 = this.f34376xXxxox0I;
            String substring = str2.substring(str2.length() - 4);
            sb.append("_u_");
            sb.append(substring);
        }
        return sb.toString();
    }

    public final void x0XOIxOo() {
        Button button = new Button(this.f34367X0IIOO);
        this.f34372o00 = button;
        button.setBackgroundDrawable(com.tencent.open.utils.II0xO0.II0xO0("h5_qr_back.png", this.f34367X0IIOO));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = XxIo.II0xO0.oIX0oI(this.f34367X0IIOO, 20.0f);
        layoutParams.topMargin = XxIo.II0xO0.oIX0oI(this.f34367X0IIOO, 10.0f);
        this.f34372o00.setLayoutParams(layoutParams);
        this.f34372o00.setOnClickListener(new oIX0oI());
    }

    public final void xoIox() {
        IXxxXO();
        x0XOIxOo();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        c cVar = new c(this.f34367X0IIOO);
        this.f34362O0xOxO = cVar;
        cVar.setLayerType(1, null);
        this.f34362O0xOxO.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(this.f34367X0IIOO);
        this.f34373oI0IIXIo = frameLayout;
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        this.f34373oI0IIXIo.addView(this.f34362O0xOxO);
        this.f34373oI0IIXIo.addView(this.f34360IIXOooo);
        String string = com.tencent.open.utils.II0xO0.OxxIIOOXO(this.f34370XO).getString("style");
        if (string != null && IXxxXO.f20845OI0.equals(string)) {
            this.f34373oI0IIXIo.addView(this.f34372o00);
        }
        setContentView(this.f34373oI0IIXIo);
    }
}
