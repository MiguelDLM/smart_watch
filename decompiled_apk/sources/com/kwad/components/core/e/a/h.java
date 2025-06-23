package com.kwad.components.core.e.a;

import android.R;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import java.lang.ref.WeakReference;

/* loaded from: classes11.dex */
public final class h implements d {
    private static WeakReference<Window> KA;
    private g Kx;
    private b Ky;
    private WeakReference<Activity> Kz;
    private ViewGroup nZ;
    private boolean oa;
    private final com.kwad.sdk.core.c.c<Activity> wU = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.e.a.h.1
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityDestroyed */
        public final void b(Activity activity) {
            super.b(activity);
            com.kwad.sdk.core.c.b.En();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            if (activity.equals((Activity) h.this.Kz.get())) {
                h.this.eR();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void eR() {
        g gVar;
        if (this.oa) {
            return;
        }
        this.oa = true;
        this.Ky.eQ();
        ViewGroup viewGroup = this.nZ;
        if (viewGroup != null && (gVar = this.Kx) != null) {
            viewGroup.removeView(gVar);
        }
        com.kwad.sdk.core.c.b.En();
        com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this.wU);
    }

    public static void nL() {
        WeakReference<Window> weakReference = KA;
        if (weakReference != null) {
            weakReference.clear();
        }
        KA = null;
    }

    @Override // com.kwad.components.core.e.a.d
    public final void nD() {
        eR();
    }

    public static void a(Window window) {
        KA = new WeakReference<>(window);
    }

    public final boolean b(AdTemplate adTemplate, b bVar) {
        Window window;
        try {
            this.Ky = bVar;
            com.kwad.sdk.core.c.b.En();
            Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
            if (currentActivity != null && !currentActivity.isFinishing()) {
                WeakReference<Window> weakReference = KA;
                if (weakReference != null) {
                    window = weakReference.get();
                } else {
                    window = currentActivity.getWindow();
                }
                View findViewById = window.getDecorView().findViewById(R.id.content);
                if (!(findViewById instanceof ViewGroup)) {
                    return false;
                }
                this.Kz = new WeakReference<>(currentActivity);
                this.Kx = new g(l.wrapContextIfNeed(currentActivity), adTemplate, this);
                com.kwad.sdk.core.c.b.En();
                com.kwad.sdk.core.c.b.a(this.wU);
                this.nZ = (ViewGroup) findViewById;
                this.nZ.addView(this.Kx, new ViewGroup.LayoutParams(-1, -1));
                bVar.nC();
                return true;
            }
            com.kwad.sdk.core.e.c.d("InstalledActivateViewHelper", "showInWindow fail activity:" + currentActivity);
            return false;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.d("InstalledActivateViewHelper", "showInWindow fail error:" + th);
            com.kwad.sdk.core.e.c.printStackTrace(th);
            return false;
        }
    }
}
