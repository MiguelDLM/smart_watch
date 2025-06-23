package com.kwad.components.core.c;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.az;

/* loaded from: classes11.dex */
public class d {
    private static volatile d Jv = null;
    private static boolean Jw = true;

    @NonNull
    private final SparseArray<c> Ju;

    private d() {
        SparseArray<c> sparseArray = new SparseArray<>();
        this.Ju = sparseArray;
        sparseArray.append(0, new n());
        sparseArray.append(1, new m());
        sparseArray.append(2, new l());
    }

    public static /* synthetic */ void a(d dVar, com.kwad.components.core.request.model.a aVar, c cVar) {
        a(aVar, cVar);
    }

    public static /* synthetic */ SparseArray b(d dVar) {
        return dVar.Ju;
    }

    public static d mX() {
        if (Jv == null) {
            synchronized (d.class) {
                try {
                    if (Jv == null) {
                        Jv = new d();
                    }
                } finally {
                }
            }
        }
        return Jv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean mY() {
        if (!Jw) {
            return false;
        }
        try {
        } catch (ClassNotFoundException unused) {
            Jw = false;
        }
        if (com.kwad.sdk.components.f.cZ("KEY_ENABLE_FORCE_ENABLE_AD_CACHE")) {
            return false;
        }
        Class.forName("com.kwad.devTools.PosConfigFetcher");
        Jw = true;
        return Jw;
    }

    public final void c(final com.kwad.components.core.request.model.a aVar) {
        GlobalThreadPools.Gr().submit(new az() { // from class: com.kwad.components.core.c.d.1
            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.components.core.c.d.a(com.kwad.components.core.c.d):boolean
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
                Caused by: java.lang.IndexOutOfBoundsException: Index: 0
                	at java.base/java.util.Collections$EmptyList.get(Collections.java:4807)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:103)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:63)
                	... 1 more
                */
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                /*
                    r3 = this;
                    com.kwad.components.core.request.model.a r0 = r2
                    long r0 = r0.getPosId()
                    com.kwad.components.core.c.e r0 = com.kwad.components.core.c.e.s(r0)
                    com.kwad.components.core.c.d$1$1 r1 = new com.kwad.components.core.c.d$1$1
                    r1.<init>()
                    com.kwad.sdk.utils.bo.runOnUiThread(r1)
                    com.kwad.components.core.c.d r1 = com.kwad.components.core.c.d.this
                    boolean r1 = com.kwad.components.core.c.d.a(r1)
                    if (r1 != 0) goto L38
                    boolean r1 = r0.isDefault()
                    if (r1 != 0) goto L27
                    boolean r1 = r0.isEnable()
                    if (r1 != 0) goto L27
                    goto L38
                L27:
                    com.kwad.components.core.c.d r1 = com.kwad.components.core.c.d.this
                    android.util.SparseArray r1 = com.kwad.components.core.c.d.b(r1)
                    int r0 = r0.na()
                    java.lang.Object r0 = r1.get(r0)
                    com.kwad.components.core.c.c r0 = (com.kwad.components.core.c.c) r0
                    goto L45
                L38:
                    com.kwad.components.core.c.d r0 = com.kwad.components.core.c.d.this
                    android.util.SparseArray r0 = com.kwad.components.core.c.d.b(r0)
                    r1 = 0
                    java.lang.Object r0 = r0.get(r1)
                    com.kwad.components.core.c.c r0 = (com.kwad.components.core.c.c) r0
                L45:
                    if (r0 != 0) goto L54
                    com.kwad.components.core.c.d r0 = com.kwad.components.core.c.d.this
                    android.util.SparseArray r0 = com.kwad.components.core.c.d.b(r0)
                    r1 = 1
                    java.lang.Object r0 = r0.get(r1)
                    com.kwad.components.core.c.c r0 = (com.kwad.components.core.c.c) r0
                L54:
                    com.kwad.components.core.request.model.a r1 = r2
                    com.kwad.components.core.request.i r1 = r1.qY()
                    if (r1 == 0) goto L62
                    r0.getName()
                    r1.bK()
                L62:
                    com.kwad.components.core.c.d r1 = com.kwad.components.core.c.d.this
                    com.kwad.components.core.request.model.a r2 = r2
                    com.kwad.components.core.c.d.a(r1, r2, r0)
                    com.kwad.components.core.request.model.a r1 = r2
                    com.kwad.components.core.request.model.ImpInfo r2 = r1.MX
                    com.kwad.sdk.internal.api.SceneImpl r2 = r2.adScene
                    java.lang.String r1 = r1.qZ()
                    com.kwad.sdk.commercial.d.d.b(r2, r1)
                    com.kwad.components.core.request.model.a r1 = r2
                    r0.c(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.c.d.AnonymousClass1.doTask():void");
            }
        });
    }

    public static /* synthetic */ boolean a(d dVar) {
        return mY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.kwad.components.core.request.model.a aVar, c cVar) {
        String name = cVar.getName();
        name.hashCode();
        if (name.equals("StrategyNetworkFirst")) {
            aVar.ay("network_first");
        } else if (!name.equals("StrategyLocalCacheFirst")) {
            aVar.ay("network_only");
        } else {
            aVar.ay("cache_first");
        }
    }
}
