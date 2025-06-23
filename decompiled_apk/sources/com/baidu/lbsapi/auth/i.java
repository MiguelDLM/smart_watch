package com.baidu.lbsapi.auth;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes7.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private Context f5590a;
    private String e;
    private String g;
    private String h;
    private String b = null;
    private HashMap<String, String> c = null;
    private String d = null;
    private int f = -1;

    public i(Context context) {
        this.f5590a = context;
    }

    private String a(Context context) {
        Network activeNetwork;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                activeNetwork = connectivityManager.getActiveNetwork();
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                if (networkCapabilities != null) {
                    return networkCapabilities.hasTransport(1) ? "WIFI" : networkCapabilities.hasTransport(0) ? "CELLULAR" : networkCapabilities.hasTransport(3) ? "ETHERNET" : networkCapabilities.hasTransport(6) ? "LoWPAN" : networkCapabilities.hasTransport(4) ? "VPN" : networkCapabilities.hasTransport(5) ? "WifiAware" : "wifi";
                }
                return "wifi";
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                String extraInfo = activeNetworkInfo.getExtraInfo();
                return (extraInfo == null || !(extraInfo.trim().toLowerCase().equals("cmwap") || extraInfo.trim().toLowerCase().equals("uniwap") || extraInfo.trim().toLowerCase().equals("3gwap") || extraInfo.trim().toLowerCase().equals("ctwap"))) ? "wifi" : extraInfo.trim().toLowerCase().equals("ctwap") ? "ctwap" : "cmwap";
            }
            return null;
        } catch (Exception e) {
            if (b.f5584a) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private HashMap<String, String> b(HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2 = new HashMap<>();
        Iterator<String> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            String str = it.next().toString();
            hashMap2.put(str, hashMap.get(str));
        }
        return hashMap2;
    }

    private static String a(HashMap<String, String> hashMap) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            sb.append("=");
            sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        return sb.toString();
    }

    private HttpsURLConnection b() {
        String str;
        URLConnection openConnection;
        try {
            URL url = new URL(this.b);
            b.a("https URL: " + this.b);
            String a2 = a(this.f5590a);
            if (a2 != null && !a2.equals("")) {
                if (TextUtils.isEmpty(this.e) || this.f == -1) {
                    b.a("checkNetwork = " + a2);
                    openConnection = "cmwap".equals(a2) ? url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80))) : "ctwap".equals(a2) ? url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80))) : url.openConnection();
                } else {
                    b.a("Proxy mProxyHost: = " + this.e + " mProxyPort: " + this.f);
                    Proxy proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(this.e, this.f));
                    Authenticator.setDefault(new j(this));
                    openConnection = url.openConnection(proxy);
                }
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
                httpsURLConnection.setHostnameVerifier(new k(this));
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setConnectTimeout(50000);
                httpsURLConnection.setReadTimeout(50000);
                return httpsURLConnection;
            }
            b.c("Current network is not available.");
            this.d = ErrorMessage.a(-10, "Current network is not available.");
            return null;
        } catch (MalformedURLException e) {
            if (b.f5584a) {
                e.printStackTrace();
                b.a(e.getMessage());
            }
            str = "Auth server could not be parsed as a URL.";
            this.d = ErrorMessage.a(-11, str);
            return null;
        } catch (Exception e2) {
            if (b.f5584a) {
                e2.printStackTrace();
                b.a(e2.getMessage());
            }
            str = "Init httpsurlconnection failed.";
            this.d = ErrorMessage.a(-11, str);
            return null;
        }
    }

    public String a(HashMap<String, String> hashMap, String str, int i, String str2, String str3) {
        HashMap<String, String> b = b(hashMap);
        this.c = b;
        this.b = b.get("url");
        this.e = str;
        this.f = i;
        this.g = str2;
        this.h = str3;
        HttpsURLConnection b2 = b();
        if (b2 == null) {
            b.c("syncConnect failed,httpsURLConnection is null");
        } else {
            a(b2);
        }
        return this.d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x01c2, code lost:
    
        if (com.baidu.lbsapi.auth.b.f5584a == false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0192, code lost:
    
        if (com.baidu.lbsapi.auth.b.f5584a == false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0164, code lost:
    
        if (com.baidu.lbsapi.auth.b.f5584a == false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0113, code lost:
    
        if (com.baidu.lbsapi.auth.b.f5584a == false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0115, code lost:
    
        r13.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x019b A[Catch: all -> 0x0134, TryCatch #12 {all -> 0x0134, blocks: (B:8:0x002e, B:128:0x0139, B:130:0x013d, B:131:0x0140, B:115:0x0169, B:117:0x016d, B:118:0x0170, B:102:0x0197, B:104:0x019b, B:105:0x019e), top: B:7:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x016d A[Catch: all -> 0x0134, TryCatch #12 {all -> 0x0134, blocks: (B:8:0x002e, B:128:0x0139, B:130:0x013d, B:131:0x0140, B:115:0x0169, B:117:0x016d, B:118:0x0170, B:102:0x0197, B:104:0x019b, B:105:0x019e), top: B:7:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x018b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x013d A[Catch: all -> 0x0134, TryCatch #12 {all -> 0x0134, blocks: (B:8:0x002e, B:128:0x0139, B:130:0x013d, B:131:0x0140, B:115:0x0169, B:117:0x016d, B:118:0x0170, B:102:0x0197, B:104:0x019b, B:105:0x019e), top: B:7:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x015d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x010b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c5 A[Catch: all -> 0x00e1, TryCatch #0 {all -> 0x00e1, blocks: (B:55:0x00c1, B:57:0x00c5, B:58:0x00e3), top: B:54:0x00c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011c A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(javax.net.ssl.HttpsURLConnection r13) {
        /*
            Method dump skipped, instructions count: 556
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.i.a(javax.net.ssl.HttpsURLConnection):void");
    }

    public boolean a() {
        Network activeNetwork;
        b.a("checkNetwork start");
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f5590a.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                activeNetwork = connectivityManager.getActiveNetwork();
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                return networkCapabilities != null && networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16);
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return false;
            }
            b.a("checkNetwork end");
            return true;
        } catch (Exception e) {
            if (b.f5584a) {
                e.printStackTrace();
            }
            return false;
        }
    }
}
