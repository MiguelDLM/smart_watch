package com.octopus.ad.internal.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import android.util.Pair;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.octopus.ad.AdActivity;
import com.octopus.ad.R;
import com.octopus.ad.internal.utilities.DeviceInfo;
import com.octopus.ad.internal.view.AdViewImpl;
import com.octopus.ad.internal.xoIox;
import com.octopus.ad.model.I0Io;
import com.octopus.ad.model.e;
import com.sma.smartv3.ui.me.O0OOX0IIx;
import java.util.LinkedList;
import java.util.List;
import x0.o0;
import x0.oxXx0IX;

/* loaded from: classes11.dex */
public class Oxx0IOOO {

    /* loaded from: classes11.dex */
    public class II0xO0 extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "RecordEvent completed loading: " + str);
            CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
            if (cookieSyncManager != null) {
                cookieSyncManager.sync();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ AdWebView f19010XO;

        public oIX0oI(AdWebView adWebView) {
            this.f19010XO = adWebView;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f19010XO.f18916Oo.xoxXI()) {
                this.f19010XO.f18916Oo.getAdDispatcher().a();
                Activity activity = (Activity) this.f19010XO.getContextFromMutableContext();
                if (activity != null && !activity.isFinishing() && (activity instanceof AdActivity)) {
                    activity.finish();
                    return;
                }
                return;
            }
            this.f19010XO.O0xOxO();
        }
    }

    public static void I0Io(AdWebView adWebView, Uri uri) {
        boolean z;
        String queryParameter = uri.getQueryParameter("cb");
        if (adWebView.XX0(Integer.parseInt(uri.getQueryParameter(MapBundleKey.MapObjKey.OBJ_SL_INDEX)))) {
            AdViewImpl adViewImpl = adWebView.f18916Oo;
            if (adViewImpl instanceof InterstitialAdViewImpl) {
                ((oI.II0xO0) ((InterstitialAdViewImpl) adViewImpl).getAdImplementation()).II0xO0();
            }
            z = true;
        } else {
            z = false;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "GotoPage"));
        linkedList.add(new Pair("success", String.valueOf(z)));
        II0xO0(adWebView, queryParameter, linkedList);
    }

    public static void II0XooXoX(AdWebView adWebView, Uri uri) {
        String queryParameter = uri.getQueryParameter("cb");
        uri.getQueryParameter(O0OOX0IIx.I0Io.f1309x0XOIxOo);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "CallNo"));
        linkedList.add(new Pair("success", String.valueOf(false)));
        II0xO0(adWebView, queryParameter, linkedList);
    }

    public static void II0xO0(WebView webView, String str, List<Pair<String, String>> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("cb=");
        if (str == null) {
            str = "-1";
        }
        sb.append(str);
        if (list != null) {
            for (Pair<String, String> pair : list) {
                if (pair.first != null && pair.second != null) {
                    sb.append("&");
                    sb.append((String) pair.first);
                    sb.append("=");
                    sb.append(Uri.encode((String) pair.second));
                }
            }
        }
        webView.evaluateJavascript(String.format("javascript:window.sdkjs.client.result(\"%s\")", sb.toString()), null);
    }

    public static void OOXIXo(WebView webView, Uri uri) {
        String queryParameter = uri.getQueryParameter("cb");
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "GetDeviceID"));
        linkedList.add(new Pair("idname", O0OOX0IIx.f23381X0o0xo));
        II0xO0(webView, queryParameter, linkedList);
    }

    public static void Oo(AdWebView adWebView, Uri uri) {
        adWebView.f18916Oo.getAdDispatcher().a(uri.getQueryParameter(NotificationCompat.CATEGORY_EVENT), uri.getQueryParameter("data"));
    }

    public static void Oxx0IOOO(WebView webView, Uri uri) {
        String queryParameter = uri.getQueryParameter("cb");
        String queryParameter2 = uri.getQueryParameter("url");
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "DeepLink"));
        if (webView.getContext() != null && queryParameter2 != null) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(queryParameter2)));
                intent.setFlags(268435456);
                webView.getContext().startActivity(intent);
                return;
            } catch (ActivityNotFoundException unused) {
                II0xO0(webView, queryParameter, linkedList);
                return;
            }
        }
        II0xO0(webView, queryParameter, linkedList);
    }

    public static void X0o0xo(WebView webView, Uri uri) {
        String queryParameter = uri.getQueryParameter("cb");
        String queryParameter2 = uri.getQueryParameter("url");
        boolean z = false;
        if (webView.getContext() != null && webView.getContext().getPackageManager() != null && queryParameter2 != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(queryParameter2)));
            intent.setFlags(268435456);
            if (intent.resolveActivity(webView.getContext().getPackageManager()) != null) {
                z = true;
            }
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "MayDeepLink"));
        linkedList.add(new Pair("mayDeepLink", String.valueOf(z)));
        II0xO0(webView, queryParameter, linkedList);
    }

    public static void XO(AdWebView adWebView, Uri uri) {
        String queryParameter = uri.getQueryParameter("cb");
        uri.getQueryParameter("msg");
        uri.getQueryParameter(O0OOX0IIx.I0Io.f1309x0XOIxOo);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "SendMsg"));
        linkedList.add(new Pair("success", String.valueOf(false)));
        II0xO0(adWebView, queryParameter, linkedList);
    }

    public static void oIX0oI(WebView webView, Uri uri) {
        String queryParameter = uri.getQueryParameter("cb");
        DeviceInfo oxoX2 = DeviceInfo.oxoX();
        I0Io.II0xO0 X0o0xo2 = new I0Io.II0xO0.oIX0oI().I0Io(oxoX2.f18674oIX0oI).oO(DeviceInfo.f18662OxxIIOOXO).x0xO0oo(DeviceInfo.f18658IIXOooo).XO(oXxOI0oIx.II0xO0.II0xO0(xoIox.oIX0oI().f19082x0xO0oo)).Oo(oXxOI0oIx.II0xO0.II0XooXoX(xoIox.oIX0oI().x0xO0oo())).Oxx0xo(o0IXXIx.xxIXOIIO.oIX0oI(xoIox.oIX0oI().f19082x0xO0oo)).oI0IIXIo(o0IXXIx.xxIXOIIO.II0xO0(xoIox.oIX0oI().f19082x0xO0oo)).OxxIIOOXO(oxoX2.f18676oOoXoXO).IIXOooo(oxoX2.f18677ooOOo0oXI).Oxx0IOOO("").II0XooXoX(oxoX2.f18678oxoX).II0xO0(e.EnumC0897e.PLATFORM_ANDROID).oIX0oI(oxoX2.f18672X0o0xo).xxIXOIIO(oxoX2.f18673XO).xoIox(oxoX2.f18671Oxx0IOOO).OOXIXo(oxoX2.f18667II0XooXoX).oOoXoXO(oxoX2.f18682xxIXOIIO).ooOOo0oXI(oxoX2.f18681xoIox).x0XOIxOo(oxoX2.f18669OOXIXo).IXxxXO(oxoX2.f18666I0Io).xoXoI(oxoX2.f18679x0XOIxOo).o00(oxoX2.f18675oO).oxoX(oxoX2.f18680x0xO0oo).OxI(DeviceInfo.f18665xoXoI).O0xOxO(DeviceInfo.f18663o00).X0IIOO(oxoX2.f18670Oo).X0o0xo();
        o0 oIX0oI2 = o0.oIX0oI();
        I0Io.oxoX I0Io2 = new I0Io.oxoX.oIX0oI().II0xO0(oIX0oI2.f33740oIX0oI).oIX0oI(oIX0oI2.f33738II0xO0).I0Io();
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "GetDeviceID"));
        linkedList.add(new Pair("deviceInfo", Base64.encodeToString(X0o0xo2.II0XooXoX(), 0)));
        linkedList.add(new Pair("userEnvInfo", Base64.encodeToString(I0Io2.X0o0xo(), 0)));
        II0xO0(webView, queryParameter, linkedList);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static void oO(AdWebView adWebView, Uri uri) {
        String queryParameter = uri.getQueryParameter("url");
        if (adWebView.getContext() != null && queryParameter != null && queryParameter.startsWith("http")) {
            String decode = Uri.decode(queryParameter);
            Class<AdActivity> oIX0oI2 = AdActivity.oIX0oI();
            Intent intent = new Intent(adWebView.getContext(), oIX0oI2);
            intent.putExtra("ACTIVITY_TYPE", "BROWSER");
            WebView webView = new WebView(adWebView.getContext());
            oxXx0IX.XO(webView);
            oI.oIX0oI.f31320I0Io.add(webView);
            webView.loadUrl(decode);
            if (adWebView.f18916Oo.getBrowserStyle() != null) {
                String str = "" + webView.hashCode();
                intent.putExtra("bridgeid", str);
                AdViewImpl.oo0xXOI0I.f18881oIX0oI.add(new Pair<>(str, adWebView.f18916Oo.getBrowserStyle()));
            }
            try {
                adWebView.getContext().startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(adWebView.getContext(), R.string.action_cant_be_completed, 0).show();
                com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.adactivity_missing, oIX0oI2.getName()));
                oI.oIX0oI.f31320I0Io.remove();
            }
        }
    }

    public static void oOoXoXO(AdWebView adWebView, Uri uri) {
        String queryParameter = uri.getQueryParameter("url");
        String queryParameter2 = uri.getQueryParameter("cb");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(queryParameter)));
            if (adWebView != null) {
                adWebView.getContext().startActivity(intent);
            }
        } catch (Exception unused) {
            Toast.makeText(adWebView.getContext(), R.string.action_cant_be_completed, 0).show();
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "Download"));
        linkedList.add(new Pair("success", String.valueOf(true)));
        II0xO0(adWebView, queryParameter2, linkedList);
    }

    public static void ooOOo0oXI(AdWebView adWebView, Uri uri) {
        String queryParameter = uri.getQueryParameter("url");
        String queryParameter2 = uri.getQueryParameter("cb");
        adWebView.f18916Oo.x0OIX00oO(queryParameter);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "PingClick"));
        linkedList.add(new Pair("success", String.valueOf(true)));
        II0xO0(adWebView, queryParameter2, linkedList);
    }

    public static void oxoX(AdWebView adWebView, String str) {
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        if ("GotoPage".equals(host)) {
            I0Io(adWebView, parse);
            return;
        }
        if ("SendMsg".equals(host)) {
            XO(adWebView, parse);
            return;
        }
        if ("CallNo".equals(host)) {
            II0XooXoX(adWebView, parse);
            return;
        }
        if ("ClosePage".equals(host)) {
            xoIox(adWebView, parse);
            return;
        }
        if ("GetDeviceID".equals(host)) {
            OOXIXo(adWebView, parse);
            return;
        }
        if ("Download".equals(host)) {
            oOoXoXO(adWebView, parse);
            return;
        }
        if ("PingClick".equals(host)) {
            ooOOo0oXI(adWebView, parse);
            return;
        }
        if ("PingConvertion".equals(host)) {
            x0XOIxOo(adWebView, parse);
            return;
        }
        if ("GetCommonInfo".equals(host)) {
            oIX0oI(adWebView, parse);
            return;
        }
        if ("MayDeepLink".equals(host)) {
            X0o0xo(adWebView, parse);
            return;
        }
        if ("DeepLink".equals(host)) {
            if (adWebView.getUserInteraction()) {
                Oxx0IOOO(adWebView, parse);
                return;
            } else {
                com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18707xoIox, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.no_user_interaction, str));
                return;
            }
        }
        if ("ExternalBrowser".equals(host)) {
            if (adWebView.getUserInteraction()) {
                xxIXOIIO(adWebView, parse);
                return;
            } else {
                com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18707xoIox, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.no_user_interaction, str));
                return;
            }
        }
        if ("InternalBrowser".equals(host)) {
            if (adWebView.getUserInteraction()) {
                oO(adWebView, parse);
                return;
            } else {
                com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18707xoIox, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.no_user_interaction, str));
                return;
            }
        }
        if ("RecordEvent".equals(host)) {
            x0xO0oo(adWebView, parse);
            return;
        }
        if ("DispatchAppEvent".equals(host)) {
            Oo(adWebView, parse);
            return;
        }
        if ("GetDeviceID".equals(host)) {
            OOXIXo(adWebView, parse);
            return;
        }
        com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "OctopusSdk called with unsupported function: " + host);
    }

    public static void x0XOIxOo(AdWebView adWebView, Uri uri) {
        String queryParameter = uri.getQueryParameter("url");
        String queryParameter2 = uri.getQueryParameter("cb");
        adWebView.f18916Oo.XXoOx0(queryParameter);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "PingConvertion"));
        linkedList.add(new Pair("success", String.valueOf(true)));
        II0xO0(adWebView, queryParameter2, linkedList);
    }

    public static void x0xO0oo(AdWebView adWebView, Uri uri) {
        String queryParameter = uri.getQueryParameter("url");
        if (queryParameter != null && queryParameter.startsWith("http")) {
            WebView webView = new WebView(adWebView.getContext());
            webView.setWebViewClient(new II0xO0());
            webView.loadUrl(queryParameter);
            webView.setVisibility(8);
            adWebView.addView(webView);
        }
    }

    public static void xoIox(AdWebView adWebView, Uri uri) {
        String queryParameter = uri.getQueryParameter("cb");
        adWebView.f18916Oo.getMyHandler().post(new oIX0oI(adWebView));
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Pair("caller", "ClosePage"));
        linkedList.add(new Pair("success", String.valueOf(true)));
        II0xO0(adWebView, queryParameter, linkedList);
    }

    public static void xxIXOIIO(WebView webView, Uri uri) {
        String queryParameter = uri.getQueryParameter("url");
        if (webView.getContext() != null && queryParameter != null && queryParameter.startsWith("http")) {
            try {
                webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(queryParameter))));
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(webView.getContext(), R.string.action_cant_be_completed, 0).show();
            }
        }
    }
}
