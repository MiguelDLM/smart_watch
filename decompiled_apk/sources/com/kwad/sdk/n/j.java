package com.kwad.sdk.n;

import android.app.Application;
import android.content.Context;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class j {
    /* JADX WARN: Multi-variable type inference failed */
    public static Context aB(Context context) {
        return ((ResContext) context).getDelegatedContext();
    }

    public static boolean aC(Context context) {
        return context instanceof ResContext;
    }

    public static Context dz(Context context) {
        Context applicationContext = unwrapContextIfNeed(context).getApplicationContext();
        if (applicationContext instanceof Application) {
            return applicationContext;
        }
        for (int i = 0; i < 10; i++) {
            applicationContext = applicationContext.getApplicationContext();
            if (applicationContext instanceof Application) {
                return applicationContext;
            }
            if (aC(applicationContext)) {
                applicationContext = aB(applicationContext);
            }
        }
        return applicationContext;
    }

    public static void onDestroy(Context context) {
        Wrapper.onDestroy(context);
    }

    public static Context unwrapContextIfNeed(Context context) {
        if (aC(context)) {
            context = aB(context);
        }
        if (!aC(context)) {
            return context;
        }
        RuntimeException runtimeException = null;
        for (int i = 0; i < 10; i++) {
            if (runtimeException == null) {
                RuntimeException runtimeException2 = new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).yY());
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(runtimeException2);
                runtimeException = runtimeException2;
            }
            context = aB(context);
            if (!aC(context)) {
                return context;
            }
        }
        return context;
    }

    public static Context wrapContextIfNeed(Context context) {
        return Wrapper.wrapContextIfNeed(context);
    }
}
