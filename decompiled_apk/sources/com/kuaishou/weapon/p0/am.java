package com.kuaishou.weapon.p0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.text.TextUtils;
import com.google.firebase.crashlytics.buildtools.api.net.proxy.Constants;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import org.json.JSONArray;

/* loaded from: classes11.dex */
public class am {

    /* renamed from: a, reason: collision with root package name */
    private static final String f18307a = "tun";
    private static final String b = "ppp";
    private static int c;

    public static boolean a(Context context) {
        ConnectivityManager connectivityManager;
        Network activeNetwork;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Throwable unused) {
        }
        if (connectivityManager == null) {
            return false;
        }
        activeNetwork = connectivityManager.getActiveNetwork();
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        if (networkCapabilities != null) {
            if (networkCapabilities.hasTransport(4)) {
                return true;
            }
        }
        return false;
    }

    public static String b(Context context) {
        JSONArray a2;
        try {
            a2 = a();
        } catch (Throwable unused) {
        }
        if (a2 != null) {
            return a2.toString();
        }
        if (!a(context)) {
            return "";
        }
        return "[\"con\"]";
    }

    public static int c() {
        return c;
    }

    public static String d() {
        StringBuilder sb = new StringBuilder();
        try {
            c = 0;
            KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
            if (keyStore != null) {
                keyStore.load(null, null);
                Enumeration<String> aliases = keyStore.aliases();
                while (aliases.hasMoreElements()) {
                    c++;
                    X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate(aliases.nextElement());
                    if (x509Certificate.getIssuerDN().getName().contains("2022") || x509Certificate.getIssuerDN().getName().contains("2023") || x509Certificate.getIssuerDN().getName().contains("HttpCanary") || x509Certificate.getIssuerDN().getName().contains("macbook") || x509Certificate.getIssuerDN().getName().contains("proxy") || x509Certificate.getIssuerDN().getName().contains("Proxy") || x509Certificate.getIssuerDN().getName().contains("local") || x509Certificate.getIssuerDN().getName().contains("github")) {
                        sb.append(x509Certificate.getIssuerDN().getName());
                        sb.append("|");
                    }
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0079, code lost:
    
        if (r2 == null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONArray a() {
        /*
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L70
            java.lang.String r3 = "cat /proc/net/route"
            java.lang.Process r2 = r2.exec(r3)     // Catch: java.lang.Throwable -> L70
            java.io.DataInputStream r3 = new java.io.DataInputStream     // Catch: java.lang.Throwable -> L70
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L70
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L70
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L6d
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L6d
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L6d
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L6d
            java.util.HashSet r1 = new java.util.HashSet     // Catch: java.lang.Throwable -> L43
            r1.<init>()     // Catch: java.lang.Throwable -> L43
        L28:
            java.lang.String r4 = r2.readLine()     // Catch: java.lang.Throwable -> L43
            if (r4 == 0) goto L52
            java.lang.String r4 = com.kuaishou.weapon.p0.bo.a(r4)     // Catch: java.lang.Throwable -> L43
            java.lang.String r5 = "tun"
            boolean r5 = r4.contains(r5)     // Catch: java.lang.Throwable -> L43
            if (r5 != 0) goto L45
            java.lang.String r5 = "ppp"
            boolean r5 = r4.contains(r5)     // Catch: java.lang.Throwable -> L43
            if (r5 == 0) goto L28
            goto L45
        L43:
            goto L6b
        L45:
            java.lang.String r5 = "\t"
            java.lang.String[] r4 = r4.split(r5)     // Catch: java.lang.Throwable -> L43
            r5 = 0
            r4 = r4[r5]     // Catch: java.lang.Throwable -> L43
            r1.add(r4)     // Catch: java.lang.Throwable -> L43
            goto L28
        L52:
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L43
        L56:
            boolean r4 = r1.hasNext()     // Catch: java.lang.Throwable -> L43
            if (r4 == 0) goto L64
            java.lang.Object r4 = r1.next()     // Catch: java.lang.Throwable -> L43
            r0.put(r4)     // Catch: java.lang.Throwable -> L43
            goto L56
        L64:
            r3.close()     // Catch: java.io.IOException -> L67
        L67:
            r2.close()     // Catch: java.io.IOException -> L7c
            goto L7c
        L6b:
            r1 = r3
            goto L72
        L6d:
            r2 = r1
            goto L6b
        L70:
            r2 = r1
        L72:
            if (r1 == 0) goto L79
            r1.close()     // Catch: java.io.IOException -> L78
            goto L79
        L78:
        L79:
            if (r2 == 0) goto L7c
            goto L67
        L7c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.am.a():org.json.JSONArray");
    }

    public static String b() {
        String property = System.getProperty(Constants.HTTP_PROXY_HOST_PROP);
        return TextUtils.isEmpty(property) ? "" : property;
    }
}
