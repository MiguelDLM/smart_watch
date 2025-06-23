package com.kwad.sdk.core.download;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.LruHashMap;
import com.kwad.sdk.utils.ae;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes11.dex */
public final class b {
    private final com.kwad.sdk.app.a avB;
    private final WeakHashMap<c, AdTemplate> avx;
    private final Map<c, AdTemplate> avy;
    private volatile boolean mHasInit;
    private static final Map<String, Integer> avz = Collections.synchronizedMap(new LruHashMap(10));
    private static final Map<String, String> avA = new LruHashMap(10);

    /* loaded from: classes11.dex */
    public static final class a {
        static final b avJ = new b(0);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static b DO() {
        return a.avJ;
    }

    private void P(final String str) {
        final e eVar = new e();
        b(str, new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.download.b.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.f.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                String ow = cVar.ow();
                b.avz.put(ow, 0);
                cVar.f(ow, eVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        P(str);
    }

    public static int dJ(String str) {
        Integer num;
        if (!TextUtils.isEmpty(str) && (num = avz.get(str)) != null) {
            return num.intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        O(str);
        com.kwad.sdk.d ys = com.kwad.sdk.c.yq().ys();
        if (ys != null) {
            ys.bX(str);
        }
    }

    public final void O(final String str, final String str2) {
        final e eVar = new e();
        avz.put(str, 8);
        a(str, new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.download.b.9
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.f.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(str, str2, eVar);
            }
        });
    }

    public final synchronized void bk(Context context) {
        if (this.mHasInit && context != null) {
            try {
                com.kwad.sdk.app.b.AW().b(this.avB);
                this.avy.clear();
                this.mHasInit = false;
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            }
        }
    }

    public final void c(final String str, int i, final String str2) {
        avz.put(str, 7);
        final e eVar = new e();
        final int i2 = 0;
        a(str, new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.download.b.10
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.f.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(str, i2, str2, eVar);
            }
        });
    }

    public final void dK(final String str) {
        avz.put(str, 1);
        final e eVar = new e();
        a(str, new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.download.b.7
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.f.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(str, eVar);
            }
        });
    }

    public final void dL(final String str) {
        final e eVar = new e();
        avz.put(str, 4);
        a(str, new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.download.b.11
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.f.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.b(str, eVar);
            }
        });
    }

    public final void dM(final String str) {
        final e eVar = new e();
        avz.put(str, 1);
        a(str, new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.download.b.12
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.f.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.c(str, eVar);
            }
        });
    }

    public final void dN(final String str) {
        final e eVar = new e();
        avz.put(str, 5);
        a(str, new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.download.b.13
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.f.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.d(str, eVar);
            }
        });
    }

    public final void dO(final String str) {
        final e eVar = new e();
        avz.put(str, 9);
        a(str, new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.download.b.14
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.f.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.e(str, eVar);
            }
        });
    }

    public final void dP(final String str) {
        final e eVar = new e();
        a(str, new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.download.b.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.f.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.g(str, eVar);
            }
        });
    }

    public final void f(final String str, final Throwable th) {
        final e eVar = new e();
        avz.put(str, 11);
        a(str, new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.download.b.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.f.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(str, th, eVar);
            }
        });
    }

    public final synchronized void init(Context context) {
        if (!this.mHasInit && context != null) {
            com.kwad.sdk.c.yq().a(new com.kwad.sdk.b() { // from class: com.kwad.sdk.core.download.b.1
                private static String l(DownloadTask downloadTask) {
                    String url = downloadTask.getUrl();
                    String str = (String) b.avA.get(url);
                    if (TextUtils.isEmpty(str)) {
                        String bx = ae.bx(downloadTask.getUrl());
                        b.avA.put(url, bx);
                        return bx;
                    }
                    return str;
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void a(DownloadTask downloadTask, int i, int i2) {
                    b.this.a(l(downloadTask), i2 > 0 ? (int) ((i * 100.0f) / i2) : 0, i, i2);
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void b(DownloadTask downloadTask) {
                    if (downloadTask.getSmallFileSoFarBytes() == 0) {
                        if (com.kwad.framework.a.a.md.booleanValue()) {
                            com.kwad.sdk.core.e.c.d("DownloadStatusManager", "onDownloadStart(), id=" + l(downloadTask));
                        }
                        b.this.dK(l(downloadTask));
                    }
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void c(DownloadTask downloadTask) {
                    b.this.dL(l(downloadTask));
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void d(DownloadTask downloadTask) {
                    b.this.dN(l(downloadTask));
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void e(DownloadTask downloadTask) {
                    b.this.dM(l(downloadTask));
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void f(DownloadTask downloadTask) {
                    b.this.dP(l(downloadTask));
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void a(DownloadTask downloadTask) {
                    b.this.O(l(downloadTask), downloadTask.getTargetFilePath());
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void a(DownloadTask downloadTask, Throwable th) {
                    String str;
                    if (th != null && th.getStackTrace().length > 0) {
                        str = th.getMessage() + " @ " + th.getStackTrace()[0].getFileName() + th.getStackTrace()[0].getClassName() + th.getStackTrace()[0].getLineNumber();
                    } else {
                        str = "";
                    }
                    b.this.c(l(downloadTask), 0, str);
                }
            });
            com.kwad.sdk.app.b.AW().a(this.avB);
            this.mHasInit = true;
        }
    }

    public final List<AdTemplate> zb() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.avy) {
            try {
                for (AdTemplate adTemplate : this.avy.values()) {
                    if (adTemplate != null) {
                        arrayList.add(adTemplate);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    private b() {
        WeakHashMap<c, AdTemplate> weakHashMap = new WeakHashMap<>();
        this.avx = weakHashMap;
        this.avy = Collections.synchronizedMap(weakHashMap);
        this.mHasInit = false;
        this.avB = new com.kwad.sdk.app.a() { // from class: com.kwad.sdk.core.download.b.6
            @Override // com.kwad.sdk.app.a
            public final void O(String str) {
                b.this.dQ(str);
            }

            @Override // com.kwad.sdk.app.a
            public final void P(String str) {
                b.this.cp(str);
            }
        };
    }

    private void b(String str, com.kwad.sdk.f.a<c> aVar) {
        Set<c> keySet = this.avy.keySet();
        synchronized (this.avy) {
            for (c cVar : keySet) {
                if (cVar != null && TextUtils.equals(str, cVar.ox())) {
                    try {
                        aVar.accept(cVar);
                    } catch (Exception e) {
                        com.kwad.sdk.core.e.c.printStackTrace(e);
                    }
                }
            }
        }
    }

    public final void a(c cVar, AdTemplate adTemplate) {
        this.avy.put(cVar, adTemplate);
    }

    public final void a(c cVar) {
        this.avy.remove(cVar);
    }

    private void O(final String str) {
        final e eVar = new e();
        b(str, new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.download.b.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.f.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                String ow = cVar.ow();
                b.avz.put(ow, 12);
                cVar.b(ow, str, eVar);
            }
        });
    }

    public final void a(final String str, final int i, final int i2, final int i3) {
        avz.put(str, 2);
        a(str, new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.download.b.8
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.f.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(str, i, i2, i3);
            }
        });
    }

    private void a(String str, com.kwad.sdk.f.a<c> aVar) {
        Set<c> keySet = this.avy.keySet();
        synchronized (this.avy) {
            for (c cVar : keySet) {
                if (cVar != null && TextUtils.equals(cVar.ow(), str)) {
                    try {
                        aVar.accept(cVar);
                    } catch (Exception e) {
                        com.kwad.sdk.core.e.c.printStackTrace(e);
                    }
                }
            }
        }
    }
}
