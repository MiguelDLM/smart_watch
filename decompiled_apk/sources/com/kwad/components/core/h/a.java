package com.kwad.components.core.h;

import android.content.Context;
import com.huawei.hms.ads.dynamicloader.b;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.TimeUnit;

/* loaded from: classes11.dex */
public final class a {

    /* renamed from: com.kwad.components.core.h.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C0791a {
        private static final a Mv = new a(0);
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    private static File ak(Context context) {
        return new File(context.getApplicationInfo().dataDir, "ksad_dynamic");
    }

    public static a pd() {
        return C0791a.Mv;
    }

    public final void aj(final Context context) {
        final long currentTimeMillis = System.currentTimeMillis();
        g.schedule(new Runnable() { // from class: com.kwad.components.core.h.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.a(context, currentTimeMillis);
                } catch (Throwable th) {
                    c.printStackTraceOnly(th);
                }
            }
        }, 10L, TimeUnit.SECONDS);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, long j) {
        File[] listFiles = ak(context).listFiles(new FileFilter() { // from class: com.kwad.components.core.h.a.2
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                String name = file.getName();
                if (name.startsWith("dynamic-") && name.endsWith(b.b)) {
                    return true;
                }
                return false;
            }
        });
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        long j2 = 0;
        for (File file : listFiles) {
            j2 = Math.max(j2, file.lastModified());
        }
        long min = Math.min(j, j2);
        for (File file2 : listFiles) {
            if (file2.exists() && file2.lastModified() < min) {
                file2.delete();
            }
        }
    }
}
