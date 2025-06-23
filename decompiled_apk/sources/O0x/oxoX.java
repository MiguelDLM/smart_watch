package O0x;

import O0OOX0IIx.XO;
import OoOoXO0.xoXoI;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class oxoX extends XO {
    @Override // O0OOX0IIx.XO
    public boolean I0Io(WebView webView, String str) {
        xxIXOIIO.IXxxXO("openSDK_LOG.SecureJsBridge", "-->canHandleUrl---url = " + str);
        if (str == null || !Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList((str + xoXoI.f2669XO).split("/")));
        if (arrayList.size() < 7) {
            return false;
        }
        String str2 = (String) arrayList.get(2);
        String str3 = (String) arrayList.get(3);
        String str4 = (String) arrayList.get(4);
        String str5 = (String) arrayList.get(5);
        xxIXOIIO.IXxxXO("openSDK_LOG.SecureJsBridge", "-->canHandleUrl, objectName: " + str2 + " | methodName: " + str3 + " | snStr: " + str4);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            try {
                II0xO0(str2, str3, arrayList.subList(6, arrayList.size() - 1), new X0o0xo(webView, Long.parseLong(str4), str, str5));
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @Override // O0OOX0IIx.XO
    public void II0xO0(String str, String str2, List<String> list, XO.oIX0oI oix0oi) {
        xxIXOIIO.IXxxXO("openSDK_LOG.SecureJsBridge", "-->getResult, objectName: " + str + " | methodName: " + str2);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, URLDecoder.decode(list.get(i), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        XO.II0xO0 iI0xO0 = this.f1370oIX0oI.get(str);
        if (iI0xO0 != null) {
            xxIXOIIO.XO("openSDK_LOG.SecureJsBridge", "-->handler != null");
            iI0xO0.oIX0oI(str2, list, oix0oi);
        } else {
            xxIXOIIO.XO("openSDK_LOG.SecureJsBridge", "-->handler == null");
            if (oix0oi != null) {
                oix0oi.oIX0oI();
            }
        }
    }
}
