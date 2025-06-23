package com.alimm.tanx.core.net.okhttp.tanxc_if;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

/* loaded from: classes.dex */
public class tanxc_if implements Interceptor {
    private static tanxc_if tanxc_do;
    private int tanxc_if;

    private tanxc_if() {
    }

    public static tanxc_if tanxc_do() {
        if (tanxc_do == null) {
            synchronized (tanxc_if.class) {
                try {
                    if (tanxc_do == null) {
                        tanxc_do = new tanxc_if();
                    }
                } finally {
                }
            }
        }
        return tanxc_do;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request().newBuilder().build());
        int i = this.tanxc_if;
        if (i != 0) {
            Response build = proceed.newBuilder().header("Cache-Control", "public, max-age=" + i).removeHeader("Pragma").build();
            this.tanxc_if = 0;
            return build;
        }
        return proceed.newBuilder().header("Cache-Control", "no-cache").removeHeader("Pragma").build();
    }

    public void tanxc_do(int i) {
        this.tanxc_if = i;
    }
}
