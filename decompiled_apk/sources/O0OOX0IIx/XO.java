package O0OOX0IIx;

import OoOoXO0.xoXoI;
import android.net.Uri;
import android.webkit.WebView;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class XO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public HashMap<String, II0xO0> f1370oIX0oI = new HashMap<>();

    /* loaded from: classes13.dex */
    public static class II0xO0 {
        public boolean II0xO0() {
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x0150, code lost:
        
            r20.II0xO0(null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0154, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void oIX0oI(java.lang.String r18, java.util.List<java.lang.String> r19, O0OOX0IIx.XO.oIX0oI r20) {
            /*
                Method dump skipped, instructions count: 373
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: O0OOX0IIx.XO.II0xO0.oIX0oI(java.lang.String, java.util.List, O0OOX0IIx.XO$oIX0oI):void");
        }
    }

    /* loaded from: classes13.dex */
    public static class oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        public String f1371I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public long f1372II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public WeakReference<WebView> f1373oIX0oI;

        public oIX0oI(WebView webView, long j, String str) {
            this.f1373oIX0oI = new WeakReference<>(webView);
            this.f1372II0xO0 = j;
            this.f1371I0Io = str;
        }

        public void I0Io(String str) {
            WebView webView = this.f1373oIX0oI.get();
            if (webView != null) {
                webView.loadUrl(x0xO.II0xO0.f34059xoIox + str);
            }
        }

        public void II0xO0(Object obj) {
            String obj2;
            WebView webView = this.f1373oIX0oI.get();
            if (webView == null) {
                return;
            }
            if (obj instanceof String) {
                obj2 = "'" + ((Object) ((String) obj).replace("\\", "\\\\").replace("'", "\\'")) + "'";
            } else if (!(obj instanceof Number) && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Double) && !(obj instanceof Float)) {
                if (obj instanceof Boolean) {
                    obj2 = obj.toString();
                } else {
                    obj2 = "'undefined'";
                }
            } else {
                obj2 = obj.toString();
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f1372II0xO0 + ",{'r':0,'result':" + obj2 + "});");
        }

        public void oIX0oI() {
            WebView webView = this.f1373oIX0oI.get();
            if (webView == null) {
                return;
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f1372II0xO0 + ",{'r':1,'result':'no such method'})");
        }
    }

    public boolean I0Io(WebView webView, String str) {
        xxIXOIIO.IXxxXO("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
        if (str == null || !Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList((str + xoXoI.f2669XO).split("/")));
        if (arrayList.size() < 6) {
            return false;
        }
        String str2 = (String) arrayList.get(2);
        String str3 = (String) arrayList.get(3);
        List<String> subList = arrayList.subList(4, arrayList.size() - 1);
        oIX0oI oix0oi = new oIX0oI(webView, 4L, str);
        webView.getUrl();
        II0xO0(str2, str3, subList, oix0oi);
        return true;
    }

    public void II0xO0(String str, String str2, List<String> list, oIX0oI oix0oi) {
        xxIXOIIO.IXxxXO("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, URLDecoder.decode(list.get(i), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        II0xO0 iI0xO0 = this.f1370oIX0oI.get(str);
        if (iI0xO0 != null) {
            xxIXOIIO.XO("openSDK_LOG.JsBridge", "call----");
            iI0xO0.oIX0oI(str2, list, oix0oi);
        } else {
            xxIXOIIO.XO("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
            if (oix0oi != null) {
                oix0oi.oIX0oI();
            }
        }
    }

    public void oIX0oI(II0xO0 iI0xO0, String str) {
        this.f1370oIX0oI.put(str, iI0xO0);
    }
}
