package com.github.lzyzsd.jsbridge;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import x0xO.I0Io;
import x0xO.II0xO0;
import x0xO.Oxx0IOOO;
import x0xO.X0o0xo;
import x0xO.XO;
import x0xO.oxoX;

@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes9.dex */
public class BridgeWebView extends WebView implements Oxx0IOOO {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final String f15799IIXOooo = "WebViewJavascriptBridge.js";

    /* renamed from: IXxxXO, reason: collision with root package name */
    public Map<String, x0xO.oIX0oI> f15800IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public Map<String, oxoX> f15801Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public x0xO.oIX0oI f15802Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public long f15803OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public final String f15804XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public List<XO> f15805oI0IIXIo;

    /* loaded from: classes9.dex */
    public class oIX0oI implements oxoX {

        /* loaded from: classes9.dex */
        public class II0xO0 implements oxoX {
            public II0xO0() {
            }

            @Override // x0xO.oxoX
            public void oIX0oI(String str) {
            }
        }

        /* renamed from: com.github.lzyzsd.jsbridge.BridgeWebView$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0573oIX0oI implements oxoX {

            /* renamed from: oIX0oI, reason: collision with root package name */
            public final /* synthetic */ String f15809oIX0oI;

            public C0573oIX0oI(String str) {
                this.f15809oIX0oI = str;
            }

            @Override // x0xO.oxoX
            public void oIX0oI(String str) {
                XO xo2 = new XO();
                xo2.xoIox(this.f15809oIX0oI);
                xo2.xxIXOIIO(str);
                BridgeWebView.this.OOXIXo(xo2);
            }
        }

        public oIX0oI() {
        }

        @Override // x0xO.oxoX
        public void oIX0oI(String str) {
            oxoX iI0xO0;
            x0xO.oIX0oI oix0oi;
            try {
                List<XO> OOXIXo2 = XO.OOXIXo(str);
                if (OOXIXo2 != null && OOXIXo2.size() != 0) {
                    for (int i = 0; i < OOXIXo2.size(); i++) {
                        XO xo2 = OOXIXo2.get(i);
                        String X0o0xo2 = xo2.X0o0xo();
                        if (!TextUtils.isEmpty(X0o0xo2)) {
                            BridgeWebView.this.f15801Oo.get(X0o0xo2).oIX0oI(xo2.oxoX());
                            BridgeWebView.this.f15801Oo.remove(X0o0xo2);
                        } else {
                            String oIX0oI2 = xo2.oIX0oI();
                            if (!TextUtils.isEmpty(oIX0oI2)) {
                                iI0xO0 = new C0573oIX0oI(oIX0oI2);
                            } else {
                                iI0xO0 = new II0xO0();
                            }
                            if (!TextUtils.isEmpty(xo2.I0Io())) {
                                oix0oi = BridgeWebView.this.f15800IXxxXO.get(xo2.I0Io());
                            } else {
                                oix0oi = BridgeWebView.this.f15802Oxx0xo;
                            }
                            if (oix0oi != null) {
                                oix0oi.oIX0oI(xo2.II0xO0(), iI0xO0);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public BridgeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15804XO = "BridgeWebView";
        this.f15801Oo = new HashMap();
        this.f15800IXxxXO = new HashMap();
        this.f15802Oxx0xo = new X0o0xo();
        this.f15805oI0IIXIo = new ArrayList();
        this.f15803OxxIIOOXO = 0L;
        xxIXOIIO();
    }

    public void I0Io(String str, String str2, oxoX oxox) {
        X0o0xo(str, str2, oxox);
    }

    public void II0XooXoX(String str) {
        String I0Io2 = II0xO0.I0Io(str);
        oxoX oxox = this.f15801Oo.get(I0Io2);
        String II0xO02 = II0xO0.II0xO0(str);
        if (oxox != null) {
            oxox.oIX0oI(II0xO02);
            this.f15801Oo.remove(I0Io2);
        }
    }

    public final void OOXIXo(XO xo2) {
        List<XO> list = this.f15805oI0IIXIo;
        if (list != null) {
            list.add(xo2);
        } else {
            oxoX(xo2);
        }
    }

    public I0Io Oxx0IOOO() {
        return new I0Io(this);
    }

    public final void X0o0xo(String str, String str2, oxoX oxox) {
        XO xo2 = new XO();
        if (!TextUtils.isEmpty(str2)) {
            xo2.Oxx0IOOO(str2);
        }
        if (oxox != null) {
            StringBuilder sb = new StringBuilder();
            long j = this.f15803OxxIIOOXO + 1;
            this.f15803OxxIIOOXO = j;
            sb.append(j);
            sb.append("_");
            sb.append(SystemClock.currentThreadTimeMillis());
            String format = String.format("JAVA_CB_%s", sb.toString());
            this.f15801Oo.put(format, oxox);
            xo2.XO(format);
        }
        if (!TextUtils.isEmpty(str)) {
            xo2.II0XooXoX(str);
        }
        OOXIXo(xo2);
    }

    public void XO() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            xoIox(II0xO0.f34060xxIXOIIO, new oIX0oI());
        }
    }

    public List<XO> getStartupMessage() {
        return this.f15805oI0IIXIo;
    }

    @Override // x0xO.Oxx0IOOO
    public void oIX0oI(String str, oxoX oxox) {
        X0o0xo(null, str, oxox);
    }

    public void oOoXoXO(String str, x0xO.oIX0oI oix0oi) {
        if (oix0oi != null) {
            this.f15800IXxxXO.put(str, oix0oi);
        }
    }

    public void oxoX(XO xo2) {
        String format = String.format("javascript:WebViewJavascriptBridge._handleMessageFromNative('%s');", xo2.oOoXoXO().replaceAll("(\\\\)([^utrn])", "\\\\\\\\$1$2").replaceAll("(?<=[^\\\\])(\")", "\\\\\""));
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            loadUrl(format);
        }
    }

    @Override // x0xO.Oxx0IOOO
    public void send(String str) {
        oIX0oI(str, null);
    }

    public void setDefaultHandler(x0xO.oIX0oI oix0oi) {
        this.f15802Oxx0xo = oix0oi;
    }

    public void setStartupMessage(List<XO> list) {
        this.f15805oI0IIXIo = list;
    }

    public void xoIox(String str, oxoX oxox) {
        loadUrl(str);
        this.f15801Oo.put(II0xO0.oxoX(str), oxox);
    }

    public final void xxIXOIIO() {
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        getSettings().setJavaScriptEnabled(true);
        WebView.setWebContentsDebuggingEnabled(true);
        setWebViewClient(Oxx0IOOO());
    }

    public BridgeWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15804XO = "BridgeWebView";
        this.f15801Oo = new HashMap();
        this.f15800IXxxXO = new HashMap();
        this.f15802Oxx0xo = new X0o0xo();
        this.f15805oI0IIXIo = new ArrayList();
        this.f15803OxxIIOOXO = 0L;
        xxIXOIIO();
    }

    public BridgeWebView(Context context) {
        super(context);
        this.f15804XO = "BridgeWebView";
        this.f15801Oo = new HashMap();
        this.f15800IXxxXO = new HashMap();
        this.f15802Oxx0xo = new X0o0xo();
        this.f15805oI0IIXIo = new ArrayList();
        this.f15803OxxIIOOXO = 0L;
        xxIXOIIO();
    }
}
