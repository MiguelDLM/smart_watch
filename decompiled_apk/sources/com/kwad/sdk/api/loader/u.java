package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.n;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes11.dex */
public final class u {
    private static final AtomicBoolean aon = new AtomicBoolean();

    private static String AT() {
        String cf = com.kwad.sdk.api.c.cf("https://open.e.kuaishou.com/rest/e/v3/open/sdk2");
        if (TextUtils.isEmpty(cf)) {
            return "https://open.e.kuaishou.com/rest/e/v3/open/sdk2";
        }
        return cf;
    }

    public static void a(final Context context, final IKsAdSDK iKsAdSDK) {
        if (!com.kwad.sdk.api.c.AE()) {
            AtomicBoolean atomicBoolean = aon;
            if (!atomicBoolean.get() && context != null && iKsAdSDK != null) {
                atomicBoolean.set(true);
                com.kwad.sdk.api.a.a.a(new com.kwad.sdk.api.a.b() { // from class: com.kwad.sdk.api.loader.u.1
                    @Override // com.kwad.sdk.api.a.b
                    public final void doTask() {
                        try {
                            if (Math.abs(System.currentTimeMillis() - b.n(context, "lastUpdateTime")) < b.n(context, "interval") * 1000) {
                                return;
                            }
                            n.AS().a(new v() { // from class: com.kwad.sdk.api.loader.u.1.1
                                @Override // com.kwad.sdk.api.loader.v
                                public final String AU() {
                                    return u.access$000();
                                }

                                @Override // com.kwad.sdk.api.loader.v
                                public final IKsAdSDK AV() {
                                    return iKsAdSDK;
                                }

                                @Override // com.kwad.sdk.api.loader.v
                                public final Context getContext() {
                                    return context;
                                }
                            }, new n.c<Boolean>() { // from class: com.kwad.sdk.api.loader.u.1.2
                                private static void c(Boolean bool) {
                                }

                                @Override // com.kwad.sdk.api.loader.n.c
                                public final /* synthetic */ void i(Boolean bool) {
                                    c(bool);
                                }
                            });
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        }
    }

    public static void aS(Context context) {
        h.o(context, "");
    }

    public static /* synthetic */ String access$000() {
        return AT();
    }
}
