package com.baidu.location.b;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ac implements Authenticator {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f5612a;
    final /* synthetic */ String b;
    final /* synthetic */ ab c;

    public ac(ab abVar, String str, String str2) {
        this.c = abVar;
        this.f5612a = str;
        this.b = str2;
    }

    @Override // okhttp3.Authenticator
    public Request authenticate(Route route, Response response) {
        return response.request().newBuilder().header("Proxy-Authorization", Credentials.basic(this.f5612a, this.b)).build();
    }
}
