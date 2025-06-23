package com.kwad.sdk.a.a;

import android.content.Context;
import com.baidu.mobads.sdk.internal.bn;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.q;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Stack;

/* loaded from: classes11.dex */
public class b {
    private static volatile b amv;
    private Stack<AdTemplate> amt = new Stack<>();
    private File amu;
    private boolean mHasInit;

    /* loaded from: classes11.dex */
    public interface a {
        void At();

        void gp();
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized File Aq() {
        try {
            File file = this.amu;
            if (file != null) {
                return file;
            }
            String dc = ax.dc(ServiceProvider.getContext());
            File file2 = new File(dc);
            if (!file2.exists()) {
                file2.mkdir();
            }
            File file3 = new File(dc + File.separator + "uninstall_ad");
            this.amu = file3;
            if (!file3.exists()) {
                try {
                    this.amu.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return this.amu;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static b Ar() {
        if (amv == null) {
            synchronized (b.class) {
                try {
                    if (amv == null) {
                        amv = new b();
                    }
                } finally {
                }
            }
        }
        return amv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.Closeable] */
    public synchronized void aH(AdTemplate adTemplate) {
        Throwable th;
        ObjectOutputStream objectOutputStream;
        Exception e;
        ?? it = this.amt.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (com.kwad.sdk.core.response.b.e.ec((AdTemplate) it.next()) == com.kwad.sdk.core.response.b.e.ec(adTemplate)) {
                it.remove();
                z = true;
            }
        }
        if (!z) {
            return;
        }
        try {
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.amu));
                try {
                    objectOutputStream.writeObject(this.amt);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    com.kwad.sdk.core.e.c.d("InstallTipsDataManager", " removeApkDownloadedData e" + e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                }
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) it);
                throw th;
            }
        } catch (Exception e3) {
            objectOutputStream = null;
            e = e3;
        } catch (Throwable th3) {
            it = 0;
            th = th3;
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) it);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.AbstractCollection, java.util.Stack<com.kwad.sdk.core.response.model.AdTemplate>] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable] */
    public synchronized void aI(AdTemplate adTemplate) {
        Throwable th;
        ObjectOutputStream objectOutputStream;
        Exception e;
        ?? r0 = this.amt;
        r0.add(adTemplate);
        try {
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(Aq()));
                try {
                    objectOutputStream.writeObject(this.amt);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    com.kwad.sdk.core.e.c.printStackTrace(e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                }
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r0);
                throw th;
            }
        } catch (Exception e3) {
            objectOutputStream = null;
            e = e3;
        } catch (Throwable th3) {
            r0 = 0;
            th = th3;
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r0);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File aL(AdTemplate adTemplate) {
        File file = new File(com.kwad.sdk.core.download.a.H(com.kwad.sdk.core.response.b.e.dS(adTemplate)));
        if (q.L(file)) {
            return file;
        }
        return null;
    }

    public final synchronized AdTemplate As() {
        AdTemplate adTemplate;
        Stack stack = (Stack) this.amt.clone();
        while (true) {
            if (!stack.isEmpty()) {
                adTemplate = (AdTemplate) stack.pop();
                if (adTemplate != null) {
                    String str = com.kwad.sdk.core.response.b.e.dS(adTemplate).adBaseInfo.appPackageName;
                    Context context = ServiceProvider.getContext();
                    File aL = aL(adTemplate);
                    if (aL != null && aL.exists() && aL.lastModified() + bn.d > System.currentTimeMillis() && !al.an(context, str)) {
                        break;
                    }
                }
            } else {
                adTemplate = null;
                break;
            }
        }
        return adTemplate;
    }

    public final void aJ(final AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        g.execute(new az() { // from class: com.kwad.sdk.a.a.b.2
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                b.this.aI(adTemplate);
            }
        });
    }

    public final void aK(final AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        g.execute(new az() { // from class: com.kwad.sdk.a.a.b.3
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                b.this.aH(adTemplate);
            }
        });
    }

    public final synchronized void a(final a aVar) {
        if (this.mHasInit) {
            return;
        }
        this.mHasInit = true;
        g.execute(new az() { // from class: com.kwad.sdk.a.a.b.1
            /* JADX WARN: Not initialized variable reg: 4, insn: 0x00a1: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:162), block:B:84:0x00a1 */
            /* JADX WARN: Removed duplicated region for block: B:57:0x011f A[Catch: all -> 0x00c6, TryCatch #3 {all -> 0x00c6, blocks: (B:3:0x0002, B:7:0x0009, B:10:0x0010, B:48:0x00c2, B:54:0x00fa, B:55:0x011b, B:57:0x011f, B:71:0x0123, B:72:0x0126, B:66:0x0114, B:68:0x0118, B:85:0x0127, B:86:0x012a, B:80:0x00e3), top: B:2:0x0002 }] */
            /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
            @Override // com.kwad.sdk.utils.az
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void doTask() {
                /*
                    Method dump skipped, instructions count: 303
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.a.a.b.AnonymousClass1.doTask():void");
            }
        });
    }
}
