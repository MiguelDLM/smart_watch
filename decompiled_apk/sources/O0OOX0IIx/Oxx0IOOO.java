package O0OOX0IIx;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public abstract class Oxx0IOOO extends Dialog {

    /* renamed from: Oo, reason: collision with root package name */
    @SuppressLint({"NewApi"})
    public final WebChromeClient f1346Oo;

    /* renamed from: XO, reason: collision with root package name */
    public XO f1347XO;

    public Oxx0IOOO(Context context, int i) {
        super(context, i);
        this.f1346Oo = new oIX0oI();
    }

    public abstract void oIX0oI(String str);

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1347XO = new XO();
    }

    /* loaded from: classes13.dex */
    public class oIX0oI extends WebChromeClient {
        public oIX0oI() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (consoleMessage == null) {
                return false;
            }
            xxIXOIIO.oOoXoXO("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + consoleMessage.message() + " -- From  111 line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
            Oxx0IOOO.this.oIX0oI(consoleMessage.message());
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onConsoleMessage(String str, int i, String str2) {
            xxIXOIIO.oOoXoXO("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + str + " -- From 222 line " + i + " of " + str2);
        }
    }
}
