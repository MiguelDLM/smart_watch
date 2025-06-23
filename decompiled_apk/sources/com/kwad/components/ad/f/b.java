package com.kwad.components.ad.f;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.br;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes11.dex */
public final class b {
    private com.kwad.sdk.core.g.d eg;

    /* renamed from: me, reason: collision with root package name */
    private CopyOnWriteArrayList<C0730b> f18432me = new CopyOnWriteArrayList<>();
    private int mf;

    /* loaded from: classes11.dex */
    public static final class a {
        private static final b mi = new b();
    }

    /* renamed from: com.kwad.components.ad.f.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0730b {
        private final c mj;
        private final WeakReference<View> mk;

        public C0730b(c cVar, View view) {
            this.mk = new WeakReference<>(view);
            this.mj = cVar;
        }
    }

    /* loaded from: classes11.dex */
    public interface c {
        void f(double d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(double d) {
        CopyOnWriteArrayList<C0730b> copyOnWriteArrayList = this.f18432me;
        int CV = (int) (com.kwad.sdk.core.config.d.CV() * 100.0f);
        if (!copyOnWriteArrayList.isEmpty()) {
            Iterator<C0730b> it = copyOnWriteArrayList.iterator();
            C0730b c0730b = null;
            C0730b c0730b2 = null;
            int i = Integer.MAX_VALUE;
            while (it.hasNext()) {
                C0730b next = it.next();
                WeakReference weakReference = next.mk;
                if (weakReference != null) {
                    Rect rect = new Rect();
                    if (((View) weakReference.get()).getGlobalVisibleRect(rect) && br.o((View) weakReference.get(), CV)) {
                        int i2 = this.mf / 2;
                        int min = Math.min(Math.abs(rect.top - i2), Math.abs(rect.bottom - i2));
                        if (min < i) {
                            c0730b = next;
                            i = min;
                        } else if (min == i) {
                            c0730b2 = next;
                        }
                    }
                }
            }
            if (c0730b != null) {
                if (c0730b2 != null) {
                    Rect rect2 = new Rect();
                    ((View) c0730b.mk.get()).getGlobalVisibleRect(rect2);
                    Rect rect3 = new Rect();
                    ((View) c0730b2.mk.get()).getGlobalVisibleRect(rect2);
                    if (rect2.top < rect3.top) {
                        c0730b = c0730b2;
                    }
                }
                c0730b.mj.f(d);
            }
        }
    }

    public static b em() {
        return a.mi;
    }

    public final void a(float f, View view, c cVar) {
        if (view == null || view.getContext() == null) {
            return;
        }
        if (this.eg == null) {
            this.mf = com.kwad.sdk.c.a.a.aV(view.getContext());
            a(f, view.getContext());
        }
        this.f18432me.add(new C0730b(cVar, view));
    }

    public final void a(c cVar) {
        Iterator<C0730b> it = this.f18432me.iterator();
        while (it.hasNext()) {
            C0730b next = it.next();
            if (next.mj == cVar) {
                this.f18432me.remove(next);
            }
        }
        com.kwad.sdk.core.e.c.d("KSNativeAdShakeManager", "sShakeItems size " + this.f18432me.size());
    }

    private void a(float f, Context context) {
        this.eg = new com.kwad.sdk.core.g.d(f);
        this.f18432me = new CopyOnWriteArrayList<>();
        this.eg.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.f.b.1
            @Override // com.kwad.sdk.core.g.b
            public final void a(double d) {
                if (b.this.f18432me != null) {
                    b.this.e(d);
                    bo.a(new az() { // from class: com.kwad.components.ad.f.b.1.1
                        @Override // com.kwad.sdk.utils.az
                        public final void doTask() {
                            com.kwad.sdk.core.e.c.d("KSNativeAdShakeManager", "onShakeEvent openGate2");
                            b.this.eg.Ge();
                        }
                    }, null, 500L);
                }
            }

            @Override // com.kwad.sdk.core.g.b
            public final void aV() {
            }
        });
        this.eg.g(f);
        this.eg.bv(context);
    }
}
