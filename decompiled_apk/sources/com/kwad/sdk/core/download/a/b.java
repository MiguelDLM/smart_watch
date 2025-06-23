package com.kwad.sdk.core.download.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import java.util.List;

/* loaded from: classes11.dex */
public final class b {

    /* loaded from: classes11.dex */
    public interface a {
        void oN();

        void onError(Throwable th);

        void onPreStart();

        void onStart();

        void onSuccess();
    }

    /* renamed from: com.kwad.sdk.core.download.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0852b implements a {
        @Override // com.kwad.sdk.core.download.a.b.a
        public final void oN() {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public void onError(Throwable th) {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public final void onPreStart() {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public void onStart() {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public void onSuccess() {
        }
    }

    public static int E(Context context, String str) {
        return a(context, str, new C0852b());
    }

    public static int a(Context context, String str, @NonNull a aVar) {
        int i;
        if (TextUtils.isEmpty(str) || context == null) {
            return 0;
        }
        try {
            aVar.onPreStart();
            com.kwad.sdk.core.e.c.d("DeepLinkUtil", "handleDeepLink: " + str);
            Uri parse = Uri.parse(str);
            h hVar = (h) ServiceProvider.get(h.class);
            if (hVar != null) {
                i = hVar.cb(parse.getScheme());
            } else {
                i = -1;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(parse);
            com.kwad.sdk.core.e.c.d("DeepLinkUtil", "handleDeepLink: configFlags: " + i);
            if (i > 0) {
                intent.setFlags(i);
            } else {
                intent.setFlags(268435456);
            }
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                aVar.onStart();
                context.startActivity(intent);
                aVar.onSuccess();
                return 1;
            }
            aVar.oN();
            return 0;
        } catch (Throwable th) {
            aVar.onError(th);
            return -1;
        }
    }
}
