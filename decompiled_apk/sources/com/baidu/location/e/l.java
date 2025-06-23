package com.baidu.location.e;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/* loaded from: classes7.dex */
class l extends Authenticator {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f5743a;
    final /* synthetic */ String b;
    final /* synthetic */ k c;

    public l(k kVar, String str, String str2) {
        this.c = kVar;
        this.f5743a = str;
        this.b = str2;
    }

    @Override // java.net.Authenticator
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(this.f5743a, this.b.toCharArray());
    }
}
