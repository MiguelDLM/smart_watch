package com.kwad.library.solder.lib.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.i;
import java.io.File;

/* loaded from: classes11.dex */
public abstract class a {
    protected File aki;
    protected String akj;
    protected String akk;
    private final String akn;
    protected com.kwad.library.solder.lib.c.b ako;
    protected String mVersion;
    private final byte[] akm = new byte[0];
    private boolean akl = false;
    protected com.kwad.library.solder.lib.ext.c ajN = i.xI().xC();

    public a(String str) {
        this.akn = str;
        this.akj = str;
    }

    private void xM() {
        if (this.akl) {
            return;
        }
        synchronized (this.akm) {
            this.akl = true;
        }
    }

    public final a a(@NonNull com.kwad.library.solder.lib.c.b bVar) {
        this.ako = bVar;
        return this;
    }

    public final void bM(String str) {
        this.mVersion = str;
    }

    public final void bN(String str) {
        this.akk = str;
    }

    public final void bO(String str) {
        this.akj = str;
    }

    public final String getId() {
        return this.akk;
    }

    public final String getVersion() {
        return this.mVersion;
    }

    public abstract void h(Context context, String str);

    public final boolean isLoaded() {
        boolean z;
        if (this.akl) {
            return true;
        }
        synchronized (this.akm) {
            z = this.akl;
        }
        return z;
    }

    public final void m(Context context, String str) {
        h(context, str);
        xM();
    }

    public String toString() {
        return "Plugin{, ApkPath = '" + this.akn + "'}";
    }

    public final String xN() {
        return this.akn;
    }

    public final String xO() {
        com.kwad.library.solder.lib.c.b bVar = this.ako;
        if (bVar != null) {
            return bVar.akY;
        }
        return null;
    }
}
