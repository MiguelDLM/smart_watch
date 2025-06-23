package com.baidu.mshield.utility;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.ac.F;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class d {
    public static String a(Context context, String str, boolean z, boolean z2) throws Throwable {
        return a(context, str, "", z, z2, true, null);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr2 != null) {
            return c(bArr, bArr2);
        }
        return null;
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        byte[] a2 = a(bArr2);
        byte[] bArr3 = new byte[bArr.length];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            byte b = a2[i];
            i2 = ((b & 255) + i2) & 255;
            a2[i] = a2[i2];
            a2[i2] = b;
            int i4 = ((a2[i] & 255) + (b & 255)) & 255;
            byte b2 = (byte) (a2[i4] ^ bArr[i3]);
            bArr3[i3] = b2;
            bArr3[i3] = (byte) (b2 ^ 42);
        }
        return bArr3;
    }

    public static String a(Context context, String str, String str2, boolean z, boolean z2) throws Throwable {
        return a(context, str, str2, z, z2, false, "");
    }

    public static String a(Context context, String str, String str2, boolean z, boolean z2, String str3) throws Throwable {
        return a(context, str, str2, z, z2, false, str3);
    }

    public static String a(Context context, String str, String str2, boolean z, boolean z2, boolean z3, String str3) throws Throwable {
        byte[] bytes;
        String a2;
        String str4 = "";
        if (!com.baidu.mshield.b.e.a.c(context)) {
            return "";
        }
        String[] b = a.b(context);
        String str5 = b[0];
        String str6 = b[1];
        String valueOf = String.valueOf(new Date().getTime() / 1000);
        String a3 = com.baidu.mshield.b.f.e.a(str5 + valueOf + str6);
        byte[] a4 = com.baidu.mshield.core.c.a();
        com.baidu.mshield.b.c.a.b("after get aesKey:" + new String(a4));
        com.baidu.mshield.b.c.a.b("after get aesKey:base64:" + Base64.encode(a4, 0));
        if (!TextUtils.isEmpty(str2)) {
            byte[] a5 = com.baidu.mshield.b.a.c.a(str2.getBytes());
            com.baidu.mshield.b.c.a.b("afterGzipPostBody,length=" + a5.length);
            bytes = F.getInstance().ae(a5, a4);
        } else {
            bytes = "".getBytes();
        }
        com.baidu.mshield.b.c.a.b("afterEncryptPostBody length=" + bytes.length + "," + new String(bytes));
        byte[] bytes2 = com.baidu.mshield.b.f.e.a(c.a(context)).getBytes();
        StringBuilder sb = new StringBuilder();
        sb.append("afterLoadRc4Key:");
        sb.append(new String(bytes2));
        com.baidu.mshield.b.c.a.b(sb.toString());
        byte[] re = F.getInstance().re(a4, bytes2);
        com.baidu.mshield.b.c.a.b("after ar:sKey length=" + re.length);
        String encodeToString = Base64.encodeToString(re, 0);
        com.baidu.mshield.b.c.a.b("after Base64:sKey=" + encodeToString);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("/");
        sb2.append("250");
        sb2.append("/");
        sb2.append(str5);
        sb2.append("/");
        sb2.append(valueOf);
        sb2.append("/");
        sb2.append(a3);
        if (!TextUtils.isEmpty(encodeToString)) {
            sb2.append("?skey=");
            sb2.append(URLEncoder.encode(encodeToString, "utf-8"));
        }
        com.baidu.mshield.b.c.a.b(sb2.toString());
        try {
            if (z3) {
                a2 = new com.baidu.mshield.b.d.b(context, null).a(sb2.toString());
            } else {
                a2 = new com.baidu.mshield.b.d.b(context, null).a(sb2.toString(), bytes);
            }
            str4 = a2;
        } catch (Throwable th) {
            a.a(th);
        }
        com.baidu.mshield.b.c.a.b("r:" + str4);
        if (z && TextUtils.isEmpty(str4)) {
            a(context);
            throw new NetworkErrorException("response is empty");
        }
        if (!z2) {
            return str4;
        }
        JSONObject jSONObject = new JSONObject(str4);
        String optString = jSONObject.optString("skey");
        com.baidu.mshield.b.c.a.b("base sKey from server:" + optString);
        byte[] decode = Base64.decode(optString, 0);
        com.baidu.mshield.b.c.a.b("after Base64 decode:server aeskey size=" + decode.length);
        byte[] rd = F.getInstance().rd(decode, bytes2);
        com.baidu.mshield.b.c.a.b("after dr aes key:size=" + new String(rd));
        String optString2 = jSONObject.optString("response");
        com.baidu.mshield.b.c.a.b("plugins:requestId:" + jSONObject.optString("request_id"));
        com.baidu.mshield.b.c.a.b("plugins:response Base64:" + optString2);
        byte[] decode2 = Base64.decode(optString2, 0);
        com.baidu.mshield.b.c.a.b("after Base64 decode:server aeskey size=" + decode2.length);
        byte[] ad = F.getInstance().ad(decode2, rd);
        if (decode2.length > 0 && (ad == null || ad.length == 0)) {
            a.d(context);
            throw new NetworkErrorException("aes is fail");
        }
        String str7 = new String(ad);
        com.baidu.mshield.b.c.a.b("sdk res:" + str7);
        return str7;
    }

    public static void a(Context context) {
        try {
            com.baidu.mshield.sharedpreferences.a a2 = com.baidu.mshield.sharedpreferences.a.a(context);
            if (System.currentTimeMillis() - a2.f() > 86400000) {
                HashMap hashMap = new HashMap();
                if (com.baidu.mshield.b.a.d.a(context)) {
                    hashMap.put("0", Integer.valueOf(a2.j() + 1));
                    hashMap.put("1", Integer.valueOf(a2.k()));
                } else {
                    hashMap.put("0", Integer.valueOf(a2.j()));
                    hashMap.put("1", Integer.valueOf(a2.k() + 1));
                }
                a2.d(0);
                a2.c(0);
                a2.g();
                a.a(context, "1067112", hashMap);
                return;
            }
            if (com.baidu.mshield.b.a.d.a(context)) {
                a2.a(a2.j() + 1);
            } else {
                a2.b(a2.k() + 1);
            }
        } catch (Throwable th) {
            a.a(th);
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        return c(bArr, bArr2);
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr2[i] = (byte) i;
        }
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            int i5 = bArr[i2] & 255;
            byte b = bArr2[i4];
            i3 = (i5 + (b & 255) + i3) & 255;
            bArr2[i4] = bArr2[i3];
            bArr2[i3] = b;
            i2 = (i2 + 1) % bArr.length;
        }
        return bArr2;
    }
}
