package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.a.f;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.q;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class f implements com.kwad.library.solder.lib.a.f {
    private f.a aka;
    private final Context mContext;

    public f(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private static void e(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.xP().xG().o(eVar);
    }

    private static void f(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.bO(0);
        eVar.xP().xG().n(eVar);
    }

    private static void l(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.xP().xG().p(eVar);
    }

    @Override // com.kwad.library.solder.lib.a.f
    public final com.kwad.library.solder.lib.a.f a(f.a aVar) {
        this.aka = aVar;
        return this;
    }

    @Override // com.kwad.library.solder.lib.a.f
    public final boolean k(@NonNull com.kwad.library.solder.lib.a.e eVar) {
        eVar.xT();
        eVar.bP("Update");
        e(eVar);
        if (eVar.xU()) {
            eVar.xP().xF().bH(eVar.xT());
        }
        if (eVar.isCanceled()) {
            f(eVar);
            return false;
        }
        try {
            eVar.xP().xF().xA();
            if (eVar.xY()) {
                try {
                    File e = eVar.xP().xF().e(eVar.xZ(), false);
                    if (eVar.isCanceled()) {
                        f(eVar);
                        return false;
                    }
                    try {
                        q.a(this.mContext, eVar.xZ(), e);
                        eVar.bQ(e.getAbsolutePath());
                        eVar.bO(3);
                        l(eVar);
                    } catch (Throwable th) {
                        a.e("PluginUpdaterImpl", th);
                        a(eVar, new PluginError.UpdateError(th, 2004));
                    }
                } catch (Throwable th2) {
                    th2.getLocalizedMessage();
                    a(eVar, new PluginError.UpdateError(th2, 2003));
                    return false;
                }
            } else {
                eVar.xT();
                eVar.getDownloadUrl();
                try {
                    File e2 = eVar.xP().xF().e(eVar.getDownloadUrl(), eVar.xP().xC().yl());
                    if (eVar.ya() != null && e2.exists() && TextUtils.equals(ae.ab(e2), eVar.ya())) {
                        eVar.bQ(e2.getAbsolutePath());
                        eVar.bO(4);
                        l(eVar);
                        return true;
                    }
                    try {
                        a(eVar, e2);
                        eVar.bQ(e2.getAbsolutePath());
                        eVar.bO(4);
                        l(eVar);
                    } catch (PluginError.CancelError unused) {
                        f(eVar);
                        return false;
                    } catch (PluginError.UpdateError e3) {
                        a.e("PluginUpdaterImpl", "Download plugin fail, error = " + e3.getLocalizedMessage());
                        eVar.j(e3);
                        a(eVar, e3);
                        return false;
                    }
                } catch (Throwable th3) {
                    a.e("PluginUpdaterImpl", "Can not get temp file, error = " + th3.getLocalizedMessage());
                    a(eVar, new PluginError.UpdateError(th3, 2003));
                    return false;
                }
            }
            return true;
        } catch (Throwable th4) {
            a.e("PluginUpdaterImpl", th4);
            a(eVar, new PluginError.UpdateError(th4, 2005));
            return false;
        }
    }

    private static void a(com.kwad.library.solder.lib.a.e eVar, PluginError.UpdateError updateError) {
        eVar.getState();
        eVar.bO(1);
        eVar.j(updateError);
        eVar.xP().xG().c(eVar, updateError);
    }

    private void a(com.kwad.library.solder.lib.a.e eVar, File file) {
        long currentTimeMillis = System.currentTimeMillis();
        Log.d("PluginUpdaterImpl", "start download pluginId: " + eVar.xT());
        f.a aVar = this.aka;
        if (aVar != null) {
            aVar.a(eVar, file);
            Log.i("PluginUpdaterImpl", "finish download pluginId: " + eVar.xT() + " cost:" + (System.currentTimeMillis() - currentTimeMillis));
            return;
        }
        throw new PluginError.UpdateError("update ", 2008);
    }
}
