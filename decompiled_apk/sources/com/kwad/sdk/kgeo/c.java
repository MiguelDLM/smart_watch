package com.kwad.sdk.kgeo;

import android.content.Context;
import android.os.Build;
import com.kwad.library.solder.lib.a.e;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.o;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes11.dex */
public final class c {
    private static final AtomicBoolean sHasInit = new AtomicBoolean(false);

    /* loaded from: classes11.dex */
    public interface a {
        void HZ();

        void onSuccess(String str);
    }

    public static void a(final Context context, final a aVar) {
        String str;
        String str2;
        String str3;
        if (av.MY()) {
            aVar.HZ();
            return;
        }
        if (!o.LR()) {
            aVar.HZ();
            return;
        }
        if (Build.VERSION.SDK_INT < 23) {
            aVar.HZ();
            return;
        }
        AtomicBoolean atomicBoolean = sHasInit;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        boolean isArm64 = AbiUtil.isArm64(context);
        com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
        bVar.version = "1.0.3";
        if (isArm64) {
            str = "kmc-v8a";
        } else {
            str = "kmc-v7a";
        }
        bVar.akV = str;
        com.kwad.sdk.core.network.idc.a EE = com.kwad.sdk.core.network.idc.a.EE();
        if (isArm64) {
            str2 = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/kmac/ks_kmac64";
        } else {
            str2 = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/kmac/ks_kmac32";
        }
        bVar.akW = EE.ee(str2);
        if (isArm64) {
            str3 = "db9a8da62a0354ec5710ec03e2743f07";
        } else {
            str3 = "2440a8221230913d4287c6b1e02b49f1";
        }
        bVar.akY = str3;
        bVar.JE = true;
        com.kwad.library.solder.a.a.a(context, bVar, new b.c() { // from class: com.kwad.sdk.kgeo.c.1
            private void uk() {
                com.kwad.sdk.core.e.c.d("KGeoSoHelper", "onPostLoad");
                try {
                    System.loadLibrary("ipneigh-android");
                    a.this.onSuccess(com.kwai.library.ipneigh.c.dK(context).aVF);
                } catch (Throwable unused) {
                    com.kwad.sdk.core.e.c.d("KGeoSoHelper", "loadLibrary fail");
                    a.this.HZ();
                }
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0836b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(e eVar, com.kwad.library.solder.lib.a.a aVar2) {
                uk();
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0836b, com.kwad.library.solder.lib.ext.b
            public final /* bridge */ /* synthetic */ void a(e eVar, PluginError pluginError) {
                a(pluginError);
            }

            private void a(PluginError pluginError) {
                com.kwad.sdk.core.e.c.d("KGeoSoHelper", "onFail error:" + pluginError.getMessage());
                a.this.HZ();
            }
        });
    }
}
