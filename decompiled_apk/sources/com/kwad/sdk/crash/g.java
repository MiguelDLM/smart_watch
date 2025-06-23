package com.kwad.sdk.crash;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.utils.AbiUtil;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes11.dex */
public final class g {
    private static final AtomicBoolean aHc = new AtomicBoolean(false);

    /* loaded from: classes11.dex */
    public interface a {
        void HY();

        void HZ();
    }

    public static void a(@NonNull c cVar, a aVar) {
        String str;
        String str2;
        String str3;
        AtomicBoolean atomicBoolean = aHc;
        if (atomicBoolean.get()) {
            aVar.HY();
            return;
        }
        if (cVar.sdkVersion.compareTo(cVar.aGF) < 0) {
            com.kwad.sdk.core.e.c.d("ExceptionSoLoadHelper", "sdkVersion:" + cVar.sdkVersion + "*supportAppVersion:" + cVar.aGF);
            aVar.HZ();
            return;
        }
        Context context = cVar.context;
        atomicBoolean.set(true);
        if (AbiUtil.isArm64(context)) {
            str = cVar.aGI;
            if (TextUtils.isEmpty(str)) {
                str = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/so/exception/202305301754/ks_so-exceptionArm64v8aRelease-3.3.47-e8fbb3a5f8-666.apk";
            }
            str2 = cVar.aGK;
            str3 = "exception-v8a";
        } else {
            str = cVar.aGJ;
            if (TextUtils.isEmpty(str)) {
                str = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/so/exception/202305301754/ks_so-exceptionArmeabiv7aRelease-3.3.47-e8fbb3a5f8-666.apk";
            }
            str2 = cVar.aGL;
            str3 = "exception-v7a";
        }
        com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
        bVar.akW = com.kwad.sdk.core.network.idc.a.EE().ee(str);
        bVar.JE = true;
        bVar.akV = str3;
        bVar.version = cVar.aGE;
        bVar.akY = str2;
        bVar.akZ = false;
        a(context, bVar, aVar);
    }

    private static void a(Context context, com.kwad.library.solder.lib.c.b bVar, @Nullable final a aVar) {
        com.kwad.library.solder.a.a.a(context, bVar, new b.c() { // from class: com.kwad.sdk.crash.g.1
            private void Io() {
                com.kwad.sdk.core.e.c.d("ExceptionSoLoadHelper", "onFail thread=" + Thread.currentThread().getName());
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.HZ();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0836b, com.kwad.library.solder.lib.ext.b
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void d(com.kwad.library.solder.lib.b.c cVar) {
                super.d(cVar);
                com.kwad.sdk.core.e.c.d("ExceptionSoLoadHelper", "onPostUpdate thread=" + Thread.currentThread().getName());
            }

            private void uk() {
                com.kwad.sdk.core.e.c.d("ExceptionSoLoadHelper", "onPostLoad");
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.HY();
                }
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0836b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(com.kwad.library.solder.lib.a.e eVar, com.kwad.library.solder.lib.a.a aVar2) {
                uk();
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0836b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(com.kwad.library.solder.lib.a.e eVar, PluginError pluginError) {
                Io();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0836b, com.kwad.library.solder.lib.ext.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void f(com.kwad.library.solder.lib.b.c cVar) {
                super.f(cVar);
                com.kwad.sdk.core.e.c.d("ExceptionSoLoadHelper", "onCanceled thread=" + Thread.currentThread().getName());
            }
        });
    }
}
