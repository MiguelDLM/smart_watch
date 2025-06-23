package com.baidu.tts;

import com.baidu.speechsynthesizer.utility.SpeechDecoder;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.tools.Utility;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class c4 {
    public static volatile c4 c;

    /* renamed from: a, reason: collision with root package name */
    public String f10048a = "2";
    public HashMap<String, a> b = new HashMap<>();

    /* loaded from: classes8.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public long f10049a = 0;
        public String b = "";
        public String c = "";

        public a(c4 c4Var) {
        }
    }

    public static c4 a() {
        if (c == null) {
            synchronized (c4.class) {
                try {
                    if (c == null) {
                        c = new c4();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public final String b() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && !nextElement.isLinkLocalAddress()) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return null;
        } catch (SocketException e) {
            LoggerProxy.e("HttpDNS", e.toString());
            return null;
        }
    }

    public final boolean c() {
        try {
            return SpeechDecoder.isIpv4Reachable();
        } catch (Throwable th) {
            th.toString();
            return true;
        }
    }

    public final boolean d() {
        try {
            return SpeechDecoder.isIpv6Reachable();
        } catch (Throwable th) {
            th.toString();
            return false;
        }
    }

    public String a(String str, boolean z) {
        if (str.isEmpty()) {
            return "";
        }
        System.currentTimeMillis();
        try {
            int netType = Utility.getNetType(Utility.getContext());
            String host = new URL(str).getHost();
            String a2 = a(host, netType);
            if (z && a2.isEmpty()) {
                a2 = a(host);
            }
            if (a2.isEmpty()) {
                try {
                    a2 = InetAddress.getByName(host).getHostAddress();
                    if (Utility.isIPv6Address(a2)) {
                        a2 = "[" + a2 + "]";
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    a2 = "";
                }
            }
            return !a2.isEmpty() ? str.replace(host, a2) : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00de, code lost:
    
        if (r7.b.get(r8).f10049a < java.lang.System.currentTimeMillis()) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean a(java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.c4.a(java.lang.String, java.lang.String):boolean");
    }

    public synchronized String a(String str, int i) {
        if (!this.f10048a.equals("2")) {
            return "";
        }
        String str2 = str + "_" + i;
        if (this.b.containsKey(str2)) {
            a aVar = this.b.get(str2);
            if (aVar == null) {
                return "";
            }
            String b = b();
            LoggerProxy.d("HttpDNS", "currentLocalAdd: " + b + " cacheLocalAdd: " + aVar.c);
            if (!b.equals(aVar.c)) {
                this.b.clear();
                return "";
            }
            if (aVar.f10049a > System.currentTimeMillis()) {
                return aVar.b;
            }
        }
        return "";
    }

    public String a(String str) {
        String str2;
        String str3;
        if (!this.f10048a.equals("2")) {
            return "";
        }
        if (String.format("%s.", str).matches("^((\\d|[1-9]\\d|1\\d\\d|2([0-4]\\d|5[0-5]))\\.){4}$") || String.format("%s:", str).matches("^(([\\da-fA-F]{1,4}):){8}$")) {
            return str;
        }
        String[] strArr = {""};
        String decryptBASE64 = Utility.decryptBASE64("aHR0cHM6Ly8xODAuNzYuNzYuMTEyL3Y2Lw==");
        boolean c2 = c();
        boolean d = d();
        LoggerProxy.d("HttpDNS", "isIpv4Reachable: " + c2 + " isIpv6Reachable:" + d());
        if (d && c2) {
            decryptBASE64 = Utility.decryptBASE64("aHR0cHM6Ly8xODAuNzYuNzYuMTEyL3Y2Lw==");
            str2 = "ipv4,ipv6";
            str3 = "&group=ipv6_11_23";
        } else if (c2 || !d) {
            str2 = "ipv4";
            str3 = "";
        } else {
            decryptBASE64 = Utility.decryptBASE64("aHR0cHM6Ly9bMjQwYzo0MDA2Ojo2NjY2XS92Ni8=");
            str2 = "ipv6";
            str3 = "&group=ipv6";
        }
        String format = String.format("%s%s/?dn=%s&type=%s%s", decryptBASE64, "0012", str, str2, str3);
        LoggerProxy.d("HttpDNS", "HttpDNS url: " + format);
        a4 a4Var = new a4();
        HashMap hashMap = new HashMap();
        hashMap.put("Host", "httpsdns.baidu.com");
        hashMap.put("Accept-Encoding", "identity");
        a4Var.f = hashMap;
        a4Var.b = 3000;
        a4Var.a(format, "", "GET", new b4(this, str, strArr));
        return strArr[0];
    }
}
