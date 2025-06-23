package com.kwad.sdk.a.a;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.google.firebase.crashlytics.buildtools.ndk.internal.elf.EMachine;
import com.kwad.sdk.a.a.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class c {
    private e amA;
    private final Map<String, Integer> amB;
    private final Map<String, Integer> amC;
    private final Stack<AdTemplate> amD;
    private volatile boolean amE;
    public volatile boolean amF;
    public volatile boolean amG;

    /* loaded from: classes11.dex */
    public static final class a {
        static final c amL = new c(0);
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    public static c Au() {
        return a.amL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ay() {
        if (this.amF || com.kwad.sdk.a.a.a.b.cM() > 0) {
            return;
        }
        bo.runOnUiThread(new Runnable() { // from class: com.kwad.sdk.a.a.c.6
            @Override // java.lang.Runnable
            @SuppressLint({"WrongConstant"})
            public final void run() {
                try {
                    AdTemplate As = b.Ar().As();
                    if (As == null || com.kwad.sdk.core.config.d.Cy() == 0) {
                        return;
                    }
                    c.this.amF = true;
                    com.kwad.sdk.core.c.b.En();
                    com.kwad.sdk.a.a.a.b.G(com.kwad.sdk.core.c.b.getCurrentActivity());
                    c.this.aS(As);
                } catch (Throwable th) {
                    com.kwad.components.core.d.a.reportSdkCaughtException(th);
                }
            }
        });
    }

    public static /* synthetic */ e a(c cVar, e eVar) {
        cVar.amA = null;
        return null;
    }

    private static boolean aN(AdTemplate adTemplate) {
        String H;
        if (adTemplate == null) {
            return false;
        }
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        if (al.an(ServiceProvider.getContext(), com.kwad.sdk.core.response.b.a.ax(dS)) || (H = com.kwad.sdk.core.download.a.H(dS)) == null || TextUtils.isEmpty(H)) {
            return false;
        }
        return new File(H).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(final AdTemplate adTemplate) {
        a(adTemplate, (DialogInterface.OnDismissListener) null, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.a.a.c.7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                try {
                    if (i == -1) {
                        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                        bVar.cM(29);
                        bVar.cT(23);
                        com.kwad.sdk.core.adlog.c.e(adTemplate, (JSONObject) null, bVar);
                        com.kwad.sdk.a.a.a.Ap();
                    } else if (i == -2) {
                        c cVar = c.this;
                        c.g(adTemplate, 1);
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        bo.runOnUiThreadDelay(new az() { // from class: com.kwad.sdk.a.a.c.8
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                if (com.kwad.sdk.a.a.a.Ap()) {
                    c cVar = c.this;
                    c.g(adTemplate, 2);
                }
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final AdTemplate adTemplate, final boolean z) {
        bo.runOnUiThread(new az() { // from class: com.kwad.sdk.a.a.c.3
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                int Cx = com.kwad.sdk.core.config.d.Cx();
                boolean z2 = z;
                if (z2 && Cx == 2) {
                    c.this.a(adTemplate, (DialogInterface.OnDismissListener) null, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.a.a.c.3.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (i == -1) {
                                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                                bVar.cM(29);
                                bVar.cT(23);
                                com.kwad.sdk.core.adlog.c.e(adTemplate, (JSONObject) null, bVar);
                                com.kwad.sdk.a.a.a.Ap();
                                return;
                            }
                            if (i == -2) {
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                c cVar = c.this;
                                c.g(adTemplate, 1);
                            }
                        }
                    });
                } else {
                    c.this.a(adTemplate, z2, Cx, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.e(adTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cM(69).cT(23).cX(i));
    }

    @Nullable
    public final AdTemplate Av() {
        AdTemplate adTemplate = null;
        while (!this.amD.isEmpty()) {
            AdTemplate pop = this.amD.pop();
            if (aN(pop)) {
                adTemplate = pop;
            }
        }
        if (adTemplate != null) {
            this.amD.add(0, adTemplate);
        }
        return adTemplate;
    }

    @SuppressLint({"WrongConstant"})
    public final void Aw() {
        b.Ar().a(new b.a() { // from class: com.kwad.sdk.a.a.c.4
            @Override // com.kwad.sdk.a.a.b.a
            public final void At() {
                com.kwad.sdk.core.e.c.d("InstallTipsManager", "showInitDelayDialog failed");
            }

            @Override // com.kwad.sdk.a.a.b.a
            public final void gp() {
                bo.runOnUiThreadDelay(new az() { // from class: com.kwad.sdk.a.a.c.4.1
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        if (!c.this.amE) {
                            c.this.Ay();
                        } else {
                            c.this.amG = true;
                        }
                    }
                }, com.kwad.sdk.core.config.d.Cz());
            }
        });
    }

    public final void Ax() {
        bj(false);
        if (!this.amF && this.amG) {
            bo.runOnUiThreadDelay(new az() { // from class: com.kwad.sdk.a.a.c.5
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    c.this.Ay();
                }
            }, 5000L);
        }
    }

    public final void Az() {
        this.amA = null;
    }

    public final void aO(AdTemplate adTemplate) {
        if (aN(adTemplate)) {
            this.amD.add(adTemplate);
        }
    }

    public final void aP(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        this.amD.remove(adTemplate);
    }

    public final void aQ(final AdTemplate adTemplate) {
        int i;
        int Cw = com.kwad.sdk.core.config.d.Cw();
        if (adTemplate != null && Cw > 0) {
            final AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
            if (adTemplate.mAdScene.getAdStyle() == 0) {
                return;
            }
            String valueOf = String.valueOf(com.kwad.sdk.core.response.b.e.ec(adTemplate));
            if (this.amB.containsKey(valueOf)) {
                Integer num = this.amB.get(valueOf);
                i = num.intValue();
                this.amB.put(valueOf, num);
            } else {
                i = 0;
            }
            if (i > 0) {
                return;
            }
            g.schedule(new az() { // from class: com.kwad.sdk.a.a.c.1
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    int i2 = dS.status;
                    if (i2 != 12 && i2 != 10 && q.gB(com.kwad.sdk.core.download.a.H(com.kwad.sdk.core.response.b.e.dS(adTemplate)))) {
                        c.this.e(adTemplate, true);
                    }
                }
            }, Cw, TimeUnit.SECONDS);
        }
    }

    public final void aR(final AdTemplate adTemplate) {
        int i;
        int CJ = com.kwad.sdk.core.config.d.CJ();
        if (CJ < 0) {
            return;
        }
        final AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        String valueOf = String.valueOf(dS.adBaseInfo.creativeId);
        if (this.amC.containsKey(valueOf)) {
            Integer num = this.amC.get(valueOf);
            i = num.intValue();
            this.amC.put(valueOf, num);
        } else {
            i = 0;
        }
        if (i > 0) {
            return;
        }
        g.schedule(new Runnable() { // from class: com.kwad.sdk.a.a.c.2
            @Override // java.lang.Runnable
            public final void run() {
                if (al.ao(ServiceProvider.getContext(), com.kwad.sdk.core.response.b.a.ax(dS)) != 1) {
                    c.this.e(adTemplate, false);
                }
            }
        }, CJ, TimeUnit.SECONDS);
    }

    public final void bj(boolean z) {
        this.amE = z;
    }

    public final void dismiss() {
        com.kwad.sdk.a.a.a.Ap();
        e eVar = this.amA;
        if (eVar != null) {
            eVar.dismiss();
            this.amA = null;
        }
    }

    private c() {
        this.amB = new HashMap();
        this.amC = new HashMap();
        this.amD = new Stack<>();
        this.amE = false;
        this.amF = false;
        this.amG = false;
    }

    private static void b(Map<String, Integer> map, String str) {
        if (map.containsKey(str)) {
            map.put(str, Integer.valueOf(map.get(str).intValue() + 1));
        } else {
            map.put(str, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void a(AdTemplate adTemplate, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        if (com.kwad.sdk.a.a.a.nQ()) {
            return;
        }
        com.kwad.sdk.core.c.b.En();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        if (currentActivity != null && com.kwad.sdk.a.a.a.a(currentActivity, adTemplate, onDismissListener, onClickListener)) {
            a(adTemplate, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
    
        if (r4 == 1) goto L12;
     */
    @androidx.annotation.MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.kwad.sdk.core.response.model.AdTemplate r2, boolean r3, int r4, boolean r5) {
        /*
            r1 = this;
            com.kwad.sdk.a.a.e r0 = r1.amA
            if (r0 != 0) goto L15
            boolean r0 = com.kwad.components.core.e.c.b.nQ()
            if (r0 == 0) goto Lb
            goto L15
        Lb:
            if (r3 == 0) goto L11
            r0 = 1
            if (r4 != r0) goto L11
            goto L12
        L11:
            r0 = 0
        L12:
            r1.a(r2, r3, r0, r5)
        L15:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.a.a.c.a(com.kwad.sdk.core.response.model.AdTemplate, boolean, int, boolean):void");
    }

    @UiThread
    private void a(final AdTemplate adTemplate, boolean z, boolean z2, boolean z3) {
        Context context;
        Context wrapContextIfNeed;
        com.kwad.sdk.core.c.b.En();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        if (currentActivity == null || (context = ((f) ServiceProvider.get(f.class)).getContext()) == null || (wrapContextIfNeed = l.wrapContextIfNeed(context)) == null) {
            return;
        }
        e eVar = new e(wrapContextIfNeed, adTemplate, z, z2, z3);
        View findViewById = currentActivity.getWindow().getDecorView().findViewById(R.id.content);
        if (findViewById instanceof FrameLayout) {
            eVar.b((FrameLayout) findViewById);
            this.amA = eVar;
            a(adTemplate, z, z3);
        }
        if (z3) {
            com.kwad.sdk.core.c.b.En();
            com.kwad.sdk.a.a.a.b.G(com.kwad.sdk.core.c.b.getCurrentActivity());
            bo.runOnUiThreadDelay(new az() { // from class: com.kwad.sdk.a.a.c.9
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    if (c.this.amA != null) {
                        c.this.amA.dismiss();
                        c.a(c.this, (e) null);
                        c cVar = c.this;
                        c.g(adTemplate, 2);
                    }
                }
            }, 5000L);
        }
    }

    private void a(AdTemplate adTemplate, boolean z, boolean z2) {
        String valueOf = String.valueOf(com.kwad.sdk.core.response.b.e.ec(adTemplate));
        if (z) {
            b(this.amB, valueOf);
            com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
            if (z2) {
                bVar.cT(23);
                bVar.cM(EMachine.EM_TILEGX);
            } else {
                bVar.cM(92);
            }
            com.kwad.sdk.core.adlog.c.d(adTemplate, (JSONObject) null, bVar);
            return;
        }
        com.kwad.sdk.core.adlog.c.c(adTemplate, 93, (JSONObject) null);
        b(this.amC, valueOf);
    }
}
