package com.baidu.lbsapi.auth;

import android.text.TextUtils;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class j extends Authenticator {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f5591a;

    public j(i iVar) {
        this.f5591a = iVar;
    }

    @Override // java.net.Authenticator
    public PasswordAuthentication getPasswordAuthentication() {
        String str;
        String str2;
        String str3;
        String str4;
        str = this.f5591a.g;
        if (!TextUtils.isEmpty(str)) {
            str2 = this.f5591a.h;
            if (!TextUtils.isEmpty(str2)) {
                str3 = this.f5591a.g;
                str4 = this.f5591a.h;
                return new PasswordAuthentication(str3, str4.toCharArray());
            }
        }
        b.a("Proxy Username or Password is null");
        return null;
    }
}
