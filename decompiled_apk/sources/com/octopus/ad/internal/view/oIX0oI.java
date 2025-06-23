package com.octopus.ad.internal.view;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.octopus.ad.R;

/* loaded from: classes11.dex */
public class oIX0oI extends WebChromeClient {
    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        com.octopus.ad.internal.utilities.oIX0oI.ooXIXxIX(com.octopus.ad.internal.utilities.oIX0oI.f18707xoIox, com.octopus.ad.internal.utilities.oIX0oI.IXxxXO(R.string.console_message, consoleMessage.message(), consoleMessage.lineNumber(), consoleMessage.sourceId()));
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        com.octopus.ad.internal.utilities.oIX0oI.ooXIXxIX(com.octopus.ad.internal.utilities.oIX0oI.f18707xoIox, com.octopus.ad.internal.utilities.oIX0oI.Oxx0xo(R.string.js_alert, str2, str));
        jsResult.confirm();
        return true;
    }
}
