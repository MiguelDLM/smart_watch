package com.baidu.ar;

import android.R;
import android.content.Context;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.ar.arplay.core.engine.ARPDataInteraction;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.ar.av;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public class aw {
    private static volatile aw iq;
    private ViewGroup ir;
    private View.OnTouchListener is;
    private View.OnTouchListener it;
    private String iu;
    private ViewGroup iw;
    private WebView ix;
    private Context mContext;
    private List<av> iv = new ArrayList();
    private volatile boolean iy = true;
    private Handler iz = new Handler(Looper.getMainLooper()) { // from class: com.baidu.ar.aw.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            final av k;
            String str;
            super.handleMessage(message);
            Object obj = message.obj;
            av.a aVar = obj instanceof av.a ? (av.a) obj : null;
            switch (message.what) {
                case 103:
                    aw.this.a(aVar);
                    return;
                case 104:
                    if (aVar == null || (k = aw.this.k(aVar.gb)) == null || (str = aVar.ip) == null) {
                        return;
                    }
                    k.evaluateJavascript(str, new ValueCallback<String>() { // from class: com.baidu.ar.aw.1.1
                        @Override // android.webkit.ValueCallback
                        /* renamed from: I, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str2) {
                            k.invalidate();
                            k.setIsNeedRender(true);
                            aw.this.j(((Integer) k.getTag()).intValue());
                        }
                    });
                    return;
                case 105:
                    av k2 = aw.this.k(message.arg1);
                    if (k2 != null) {
                        k2.setIsNeedRender(true);
                        k2.invalidate();
                        return;
                    }
                    return;
                case 106:
                    aw.this.b(aVar);
                    return;
                default:
                    return;
            }
        }
    };
    WebViewClient iA = new WebViewClient() { // from class: com.baidu.ar.aw.6
        @Override // android.webkit.WebViewClient
        public void onPageCommitVisible(WebView webView, String str) {
            super.onPageCommitVisible(webView, str);
            int intValue = ((Integer) webView.getTag()).intValue();
            aw.this.i(intValue);
            aw.this.l(intValue);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            int errorCode;
            CharSequence description;
            CharSequence description2;
            if (webResourceError != null) {
                a aVar = new a();
                errorCode = webResourceError.getErrorCode();
                aVar.gm = errorCode;
                description = webResourceError.getDescription();
                if (description != null) {
                    description2 = webResourceError.getDescription();
                    aVar.iG = description2.toString();
                }
                aw.this.a(((Integer) webView.getTag()).intValue(), aVar);
            }
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            if (webResourceResponse != null) {
                a aVar = new a();
                aVar.gm = webResourceResponse.getStatusCode();
                aVar.iG = webResourceResponse.getReasonPhrase();
                aw.this.a(((Integer) webView.getTag()).intValue(), aVar);
            }
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (sslError != null) {
                a aVar = new a();
                aVar.gm = sslError.getPrimaryError();
                aVar.iG = "ssl error!";
                aw.this.a(((Integer) webView.getTag()).intValue(), aVar);
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    };
    private WebChromeClient iB = new WebChromeClient() { // from class: com.baidu.ar.aw.7
        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (i == 100) {
                aw.this.l(((av) webView).getWebViewData().gb);
            }
        }
    };

    /* loaded from: classes7.dex */
    public class a {
        public String iG;
        public String iF = "android";
        public int gm = 0;

        public a() {
        }
    }

    public static aw bi() {
        if (iq == null) {
            synchronized (aw.class) {
                try {
                    if (iq == null) {
                        iq = new aw();
                    }
                } finally {
                }
            }
        }
        return iq;
    }

    private boolean bj() {
        if (this.mContext != null && this.iw != null) {
            return true;
        }
        Log.e("GLWebView", "Native WebView context or root is null!");
        return false;
    }

    private av g(int i, int i2) {
        final av avVar = new av(this.mContext);
        ViewGroup viewGroup = this.ir;
        ViewGroup.LayoutParams layoutParams = viewGroup instanceof FrameLayout ? new FrameLayout.LayoutParams(i, i2) : viewGroup instanceof LinearLayout ? new LinearLayout.LayoutParams(i, i2) : viewGroup instanceof RelativeLayout ? new RelativeLayout.LayoutParams(i, i2) : null;
        avVar.setBackgroundColor(R.color.transparent);
        avVar.setWebViewClient(this.iA);
        avVar.setWebChromeClient(this.iB);
        avVar.setHorizontalScrollBarEnabled(false);
        avVar.setVerticalScrollBarEnabled(false);
        WebSettings settings = avVar.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setJavaScriptEnabled(true);
        avVar.addJavascriptInterface(new Object() { // from class: com.baidu.ar.aw.4
            @JavascriptInterface
            public void updateFinish(String str) {
                av avVar2 = avVar;
                if (avVar2 == null) {
                    return;
                }
                aw.this.l(((Integer) avVar2.getTag()).intValue());
            }
        }, "NativeCallback");
        avVar.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.ar.aw.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (aw.this.is != null) {
                    return aw.this.is.onTouch(view, motionEvent);
                }
                return false;
            }
        });
        this.ir.addView(avVar, layoutParams);
        this.iv.add(avVar);
        return avVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_name", "webView_operation_load_finish");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("texture_id", Integer.valueOf(i));
        hashMap.put("event_data", hashMap2);
        ARPMessage.getInstance().sendMessage(1902, hashMap);
    }

    private boolean isValid() {
        if (this.mContext != null && this.ir != null) {
            return true;
        }
        Log.e("GLWebView", "GLWebView context or root is null!");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_name", "webView_operation_update_finish");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("texture_id", Integer.valueOf(i));
        hashMap.put("event_data", hashMap2);
        ARPMessage.getInstance().sendMessage(1902, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public av k(int i) {
        for (av avVar : this.iv) {
            if (avVar != null && avVar.getWebViewData() != null && avVar.getWebViewData().gb == i) {
                return avVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i) {
        if (this.iy) {
            Message obtainMessage = this.iz.obtainMessage();
            obtainMessage.what = 105;
            obtainMessage.arg1 = i;
            this.iz.sendMessage(obtainMessage);
        }
    }

    public void H(String str) {
        this.iu = str;
    }

    public void e(av.a aVar) {
        if (this.iy) {
            Message obtainMessage = this.iz.obtainMessage();
            obtainMessage.what = 104;
            obtainMessage.obj = aVar;
            av k = k(aVar.gb);
            if (k != null) {
                k.setWebViewData(aVar);
                this.iz.sendMessage(obtainMessage);
            }
        }
    }

    public void release() {
        this.mContext = null;
        ay.bl().release();
        ARPEngine.getInstance().setHtmlUpdateCallback(null);
        Handler handler = this.iz;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            runOnUiThread(new Runnable() { // from class: com.baidu.ar.aw.8
                @Override // java.lang.Runnable
                public void run() {
                    ar.b(aw.class.getName(), "remove webviewList in ui thread");
                    if (aw.this.iv != null) {
                        for (av avVar : aw.this.iv) {
                            if (avVar != null) {
                                if (avVar.getParent() == aw.this.ir) {
                                    aw.this.ir.removeView(avVar);
                                }
                                avVar.destroy();
                            }
                        }
                        aw.this.iv.clear();
                        aw.this.iv = null;
                    }
                }
            });
            this.iz = null;
        }
        this.iy = false;
        iq = null;
        this.ix = null;
        this.it = null;
    }

    public void runOnUiThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            this.iz.post(runnable);
        }
    }

    public void b(Context context, ViewGroup viewGroup, View.OnTouchListener onTouchListener) {
        this.mContext = context;
        this.iw = viewGroup;
        this.it = onTouchListener;
    }

    public void c(av.a aVar) {
        if (this.iy) {
            Message obtainMessage = this.iz.obtainMessage();
            obtainMessage.what = 103;
            obtainMessage.obj = aVar;
            this.iz.sendMessage(obtainMessage);
        }
    }

    public void d(av.a aVar) {
        if (this.iy) {
            Message obtainMessage = this.iz.obtainMessage();
            obtainMessage.what = 106;
            obtainMessage.obj = aVar;
            this.iz.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(av.a aVar) {
        if (aVar == null || !bj()) {
            return;
        }
        if (this.ix == null) {
            WebView webView = new WebView(this.mContext);
            this.ix = webView;
            webView.setBackgroundColor(R.color.transparent);
            WebSettings settings = this.ix.getSettings();
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            settings.setJavaScriptEnabled(true);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.ix.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.ar.aw.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (aw.this.it != null) {
                        return aw.this.it.onTouch(view, motionEvent);
                    }
                    return false;
                }
            });
            this.iw.addView(this.ix, layoutParams);
        }
        String str = aVar.url;
        if (!aVar.f5562io) {
            str = "file://" + this.mContext.getFilesDir().getAbsolutePath().concat(File.separator) + "ar/" + str;
        }
        this.ix.loadUrl(str);
        this.ix.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, a aVar) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_name", "webView_operation_load_failed");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("texture_id", Integer.valueOf(i));
        HashMap hashMap3 = new HashMap();
        hashMap3.put("platform", aVar.iF);
        hashMap3.put("error_code", Integer.valueOf(aVar.gm));
        hashMap3.put("error_msg", aVar.iG);
        hashMap2.put("data", hashMap3);
        hashMap.put("event_data", hashMap2);
        ARPMessage.getInstance().sendMessage(1902, hashMap);
        l(i);
    }

    public void a(Context context, ViewGroup viewGroup, View.OnTouchListener onTouchListener) {
        this.mContext = context;
        this.ir = viewGroup;
        this.is = onTouchListener;
        ARPEngine.getInstance().setHtmlUpdateCallback(new ARPDataInteraction.a() { // from class: com.baidu.ar.aw.2
            @Override // com.baidu.ar.arplay.core.engine.ARPDataInteraction.a
            public boolean e(int i, int i2) {
                aw.this.l(i);
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(av.a aVar) {
        if (aVar == null || !isValid()) {
            return;
        }
        av g = g(aVar.width, aVar.height);
        g.setWebViewData(aVar);
        ay.bl().b(aVar.gb, aVar.width, aVar.height);
        g.setTag(Integer.valueOf(aVar.gb));
        String str = aVar.url;
        if (!aVar.f5562io) {
            str = "file://" + this.mContext.getFilesDir().getAbsolutePath().concat(File.separator) + "ar/" + str;
        }
        g.loadUrl(str);
        g.invalidate();
        g.setIsNeedRender(true);
        e(aVar);
    }
}
