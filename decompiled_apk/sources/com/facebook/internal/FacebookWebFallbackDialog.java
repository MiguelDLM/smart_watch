package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.facebook.internal.WebDialog;
import kotlin.jvm.internal.IIX0o;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class FacebookWebFallbackDialog extends WebDialog {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);
    private static final int OS_BACK_BUTTON_RESPONSE_TIMEOUT_MILLISECONDS = 1500;

    @OXOo.OOXIXo
    private static final String TAG;
    private boolean waitingForDialogToClose;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final FacebookWebFallbackDialog newInstance(@OXOo.OOXIXo Context context, @OXOo.OOXIXo String url, @OXOo.OOXIXo String expectedRedirectUrl) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(url, "url");
            IIX0o.x0xO0oo(expectedRedirectUrl, "expectedRedirectUrl");
            WebDialog.Companion companion = WebDialog.Companion;
            WebDialog.initDefaultTheme(context);
            return new FacebookWebFallbackDialog(context, url, expectedRedirectUrl, null);
        }

        private Companion() {
        }
    }

    static {
        String name = FacebookWebFallbackDialog.class.getName();
        IIX0o.oO(name, "FacebookWebFallbackDialog::class.java.name");
        TAG = name;
    }

    public /* synthetic */ FacebookWebFallbackDialog(Context context, String str, String str2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(context, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cancel$lambda-0, reason: not valid java name */
    public static final void m198cancel$lambda0(FacebookWebFallbackDialog this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        super.cancel();
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final FacebookWebFallbackDialog newInstance(@OXOo.OOXIXo Context context, @OXOo.OOXIXo String str, @OXOo.OOXIXo String str2) {
        return Companion.newInstance(context, str, str2);
    }

    @Override // com.facebook.internal.WebDialog, android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        WebView webView = getWebView();
        if (isPageFinished() && !isListenerCalled() && webView != null && webView.isShown()) {
            if (this.waitingForDialogToClose) {
                return;
            }
            this.waitingForDialogToClose = true;
            webView.loadUrl(IIX0o.XIxXXX0x0(x0xO.II0xO0.f34059xoIox, "(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();"));
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.facebook.internal.oxoX
                @Override // java.lang.Runnable
                public final void run() {
                    FacebookWebFallbackDialog.m198cancel$lambda0(FacebookWebFallbackDialog.this);
                }
            }, 1500L);
            return;
        }
        super.cancel();
    }

    @Override // com.facebook.internal.WebDialog
    @OXOo.OOXIXo
    public Bundle parseResponseUri(@OXOo.oOoXoXO String str) {
        Uri parse = Uri.parse(str);
        Utility utility = Utility.INSTANCE;
        Bundle parseUrlQueryString = Utility.parseUrlQueryString(parse.getQuery());
        String string = parseUrlQueryString.getString(ServerProtocol.FALLBACK_DIALOG_PARAM_BRIDGE_ARGS);
        parseUrlQueryString.remove(ServerProtocol.FALLBACK_DIALOG_PARAM_BRIDGE_ARGS);
        if (!Utility.isNullOrEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                BundleJSONConverter bundleJSONConverter = BundleJSONConverter.INSTANCE;
                parseUrlQueryString.putBundle(NativeProtocol.EXTRA_PROTOCOL_BRIDGE_ARGS, BundleJSONConverter.convertToBundle(jSONObject));
            } catch (JSONException e) {
                Utility utility2 = Utility.INSTANCE;
                Utility.logd(TAG, "Unable to parse bridge_args JSON", e);
            }
        }
        String string2 = parseUrlQueryString.getString(ServerProtocol.FALLBACK_DIALOG_PARAM_METHOD_RESULTS);
        parseUrlQueryString.remove(ServerProtocol.FALLBACK_DIALOG_PARAM_METHOD_RESULTS);
        Utility utility3 = Utility.INSTANCE;
        if (!Utility.isNullOrEmpty(string2)) {
            try {
                JSONObject jSONObject2 = new JSONObject(string2);
                BundleJSONConverter bundleJSONConverter2 = BundleJSONConverter.INSTANCE;
                parseUrlQueryString.putBundle(NativeProtocol.EXTRA_PROTOCOL_METHOD_RESULTS, BundleJSONConverter.convertToBundle(jSONObject2));
            } catch (JSONException e2) {
                Utility utility4 = Utility.INSTANCE;
                Utility.logd(TAG, "Unable to parse bridge_args JSON", e2);
            }
        }
        parseUrlQueryString.remove("version");
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        parseUrlQueryString.putInt(NativeProtocol.EXTRA_PROTOCOL_VERSION, NativeProtocol.getLatestKnownVersion());
        return parseUrlQueryString;
    }

    private FacebookWebFallbackDialog(Context context, String str, String str2) {
        super(context, str);
        setExpectedRedirectUrl(str2);
    }
}
