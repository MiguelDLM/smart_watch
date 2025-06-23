package com.kwad.library.b;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import com.kwad.library.b.a.b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.h;
import com.kwad.sdk.utils.q;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/* loaded from: classes11.dex */
public final class a extends h {
    private b ajq;
    private Resources ajr;

    public a(String str) {
        super(str);
    }

    private b a(File file, File file2) {
        if (Build.VERSION.SDK_INT < 26) {
            if (!file.canRead()) {
                file.setReadable(true);
            }
            if (!file.canWrite()) {
                file.setWritable(true);
            }
            if (!file.canRead() || !file.canWrite()) {
                file = null;
            }
        }
        File file3 = file;
        com.kwad.library.b.a.a aVar = new com.kwad.library.b.a.a((BaseDexClassLoader) a.class.getClassLoader());
        String absolutePath = file2.getAbsolutePath();
        String absolutePath2 = this.aki.getAbsolutePath();
        com.kwad.library.solder.lib.c.b bVar = this.ako;
        return new b(aVar, absolutePath, file3, absolutePath2, bVar.ald, bVar.alc);
    }

    private File d(File file) {
        File file2 = new File(file.getParentFile(), this.ajN.yf());
        q.X(file2);
        return file2;
    }

    public final Resources getResources() {
        return this.ajr;
    }

    @Override // com.kwad.library.solder.lib.h, com.kwad.library.solder.lib.g, com.kwad.library.solder.lib.a.a
    public final void h(Context context, String str) {
        super.h(context, str);
        File file = new File(str);
        try {
            File d = d(file);
            try {
                if (Build.VERSION.SDK_INT >= 34 && context != null && context.getApplicationInfo().targetSdkVersion >= 34) {
                    file.setReadOnly();
                    d.setReadOnly();
                }
            } catch (Throwable unused) {
            }
            this.ajq = a(d, file);
            try {
                this.ajr = com.kwad.library.b.b.a.a(context, context.getResources(), str);
                Objects.toString(this.ajq);
                Objects.toString(this.ajr);
            } catch (Exception e) {
                Log.getStackTraceString(e);
                throw new PluginError.LoadError(e, 4006);
            }
        } catch (IOException e2) {
            throw new PluginError.LoadError(e2, 4002);
        }
    }

    public final b xy() {
        return this.ajq;
    }
}
