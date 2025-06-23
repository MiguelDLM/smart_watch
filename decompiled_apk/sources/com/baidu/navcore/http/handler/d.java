package com.baidu.navcore.http.handler;

import java.io.UnsupportedEncodingException;

/* loaded from: classes7.dex */
public abstract class d extends a {
    public abstract void a(int i, String str);

    public abstract void a(int i, String str, Throwable th);

    @Override // com.baidu.navcore.http.handler.a
    public void a(int i, byte[] bArr) {
        a(i, a(bArr, "UTF-8"));
    }

    @Override // com.baidu.navcore.http.handler.a
    public void a(int i, byte[] bArr, Throwable th) {
        a(i, a(bArr, "UTF-8"), th);
    }

    public static String a(byte[] bArr, String str) {
        String str2;
        if (bArr == null) {
            str2 = null;
        } else {
            try {
                str2 = new String(bArr, str);
            } catch (UnsupportedEncodingException unused) {
                return null;
            }
        }
        return (str2 == null || !str2.startsWith("\ufeff")) ? str2 : str2.substring(1);
    }
}
