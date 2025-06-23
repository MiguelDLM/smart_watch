package O0x;

import O0OOX0IIx.XO;
import XXO0.oIX0oI;
import android.webkit.WebView;
import com.tencent.open.b.c;
import org.json.JSONException;
import org.json.JSONObject;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class X0o0xo extends XO.oIX0oI {

    /* renamed from: oxoX, reason: collision with root package name */
    public String f1497oxoX;

    public X0o0xo(WebView webView, long j, String str, String str2) {
        super(webView, j, str);
        this.f1497oxoX = str2;
    }

    @Override // O0OOX0IIx.XO.oIX0oI
    public void I0Io(String str) {
        int i;
        xxIXOIIO.IXxxXO("openSDK_LOG.SecureJsListener", "-->onCustomCallback, js: " + str);
        JSONObject jSONObject = new JSONObject();
        if (!c.f26947IXxxXO) {
            i = -4;
        } else {
            i = 0;
        }
        try {
            jSONObject.put("result", i);
            jSONObject.put("sn", this.f1372II0xO0);
            jSONObject.put("data", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        oxoX(jSONObject.toString());
    }

    @Override // O0OOX0IIx.XO.oIX0oI
    public void II0xO0(Object obj) {
        xxIXOIIO.IXxxXO("openSDK_LOG.SecureJsListener", "-->onComplete, result: " + obj);
    }

    @Override // O0OOX0IIx.XO.oIX0oI
    public void oIX0oI() {
        xxIXOIIO.XO("openSDK_LOG.SecureJsListener", "-->onNoMatchMethod...");
    }

    public final void oxoX(String str) {
        WebView webView = this.f1373oIX0oI.get();
        if (webView != null) {
            StringBuffer stringBuffer = new StringBuffer(x0xO.II0xO0.f34059xoIox);
            stringBuffer.append("if(!!");
            stringBuffer.append(this.f1497oxoX);
            stringBuffer.append("){");
            stringBuffer.append(this.f1497oxoX);
            stringBuffer.append(oIX0oI.I0Io.f4096II0xO0);
            stringBuffer.append(str);
            stringBuffer.append(")}");
            String stringBuffer2 = stringBuffer.toString();
            xxIXOIIO.IXxxXO("openSDK_LOG.SecureJsListener", "-->callback, callback: " + stringBuffer2);
            webView.loadUrl(stringBuffer2);
        }
    }
}
