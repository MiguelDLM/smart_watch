package com.kwad.library.solder.lib.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.library.solder.lib.a.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes11.dex */
public abstract class e<P extends a> {
    protected String ajH;
    protected d ajX;
    protected long akA;
    protected String akB;
    protected List<com.kwad.library.solder.lib.c.a> akC;
    protected com.kwad.library.solder.lib.c.b akD;
    protected int akq;
    protected String aks;
    protected String akt;
    protected boolean aku;
    protected P akv;
    protected com.kwad.library.solder.lib.ext.b akw;
    protected Throwable akx;
    protected String aky;
    protected boolean akz;
    protected String mDownloadUrl;
    protected String mVersion;
    protected int mState = -1;
    protected int akp = 0;
    private final byte[] akm = new byte[0];
    protected StringBuffer akr = new StringBuffer(String.valueOf(-1));

    public e(com.kwad.library.solder.lib.c.b bVar) {
        this.akD = bVar;
        this.ajH = bVar.akV;
        this.mVersion = bVar.version;
        this.akB = bVar.akY;
        this.akz = bVar.akz;
        this.aky = bVar.aky;
        this.akA = bVar.akX;
        this.mDownloadUrl = bVar.akW;
    }

    private List<com.kwad.library.solder.lib.c.a> b(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(this.ajX.xF().bI(str));
            if (!file.exists()) {
                return arrayList;
            }
            String[] list = file.list();
            if (list != null && list.length != 0) {
                for (String str4 : list) {
                    if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str2) && str2.equals(str4)) {
                        if (this.ajX.xF().a(str, str4, str3)) {
                            com.kwad.library.solder.lib.c.a aVar = new com.kwad.library.solder.lib.c.a();
                            aVar.akV = str;
                            aVar.version = str4;
                            aVar.qt = true;
                            arrayList.add(aVar);
                        } else {
                            this.ajX.xF().D(str, str4);
                        }
                    } else {
                        this.ajX.xF().D(str, str4);
                    }
                }
                Collections.sort(arrayList);
            }
        }
        return arrayList;
    }

    public final e a(d dVar) {
        this.ajX = dVar;
        return this;
    }

    public final void bM(String str) {
        this.mVersion = str;
    }

    public final e bO(int i) {
        synchronized (this.akm) {
            this.mState = i;
        }
        return bP(String.valueOf(i));
    }

    public final e bP(String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuffer stringBuffer = this.akr;
            stringBuffer.append(" --> ");
            stringBuffer.append(str);
        }
        return this;
    }

    public final void bQ(String str) {
        this.aks = str;
    }

    public final void bR(String str) {
        this.akt = str;
    }

    public abstract P bS(String str);

    public final void c(P p) {
        this.akv = p;
    }

    public final void cancel() {
        synchronized (this.akm) {
            bO(0);
        }
    }

    @Nullable
    public final String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public final int getState() {
        int i;
        synchronized (this.akm) {
            i = this.mState;
        }
        return i;
    }

    public final String getVersion() {
        return this.mVersion;
    }

    public final boolean isCanceled() {
        if (this.mState == 0) {
            return true;
        }
        return false;
    }

    public final e j(@NonNull Throwable th) {
        this.akx = th;
        return bP(th.getLocalizedMessage());
    }

    @NonNull
    public String toString() {
        return "PluginRequest{mId='" + this.ajH + "'}";
    }

    public final d xP() {
        return this.ajX;
    }

    public final String xQ() {
        return this.akr.toString();
    }

    @Nullable
    public final Throwable xR() {
        return this.akx;
    }

    public final boolean xS() {
        bO(-1);
        this.akC = null;
        int i = this.akp + 1;
        this.akp = i;
        if (i <= this.akq) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String xT() {
        return this.ajH;
    }

    public final boolean xU() {
        return this.aku;
    }

    public final int xV() {
        return this.akp;
    }

    @Nullable
    public final String xW() {
        if (!TextUtils.isEmpty(this.aks)) {
            return this.aks;
        }
        return this.akt;
    }

    @Nullable
    public final com.kwad.library.solder.lib.ext.b xX() {
        return this.akw;
    }

    public final boolean xY() {
        return this.akz;
    }

    public final String xZ() {
        return this.aky;
    }

    public final String ya() {
        return this.akB;
    }

    public final com.kwad.library.solder.lib.c.b yb() {
        return this.akD;
    }

    public final List<com.kwad.library.solder.lib.c.a> yc() {
        String xT = xT();
        if (!TextUtils.isEmpty(xT) && this.akC == null) {
            this.akC = b(xT, getVersion(), ya());
        }
        return this.akC;
    }

    public final void a(com.kwad.library.solder.lib.ext.b bVar) {
        this.akw = bVar;
    }

    public final void bP(int i) {
        if (i > 0) {
            this.akq = i;
        }
    }
}
