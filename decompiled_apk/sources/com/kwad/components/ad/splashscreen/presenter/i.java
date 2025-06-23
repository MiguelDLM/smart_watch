package com.kwad.components.ad.splashscreen.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Vibrator;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bo;

/* loaded from: classes11.dex */
public abstract class i extends e implements com.kwad.sdk.core.h.c {
    private static long le = 400;
    private com.kwad.components.ad.splashscreen.e.a Dy;
    private Vibrator eh;

    private void lq() {
        com.kwad.components.ad.splashscreen.h hVar = this.Di;
        if (hVar != null) {
            com.kwad.components.ad.splashscreen.e.a aVar = this.Dy;
            if (aVar == null) {
                this.Dy = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.Di.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.presenter.i.1
                    {
                        super(r3);
                    }

                    @Override // com.kwad.components.ad.splashscreen.e.a
                    @SuppressLint({"SetTextI18n"})
                    public final void k(int i, String str) {
                        i.this.j(i, str);
                    }
                };
            } else {
                aVar.setAdTemplate(hVar.mAdTemplate);
            }
            com.kwad.components.core.e.d.c cVar = this.Di.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(this.Dy);
            }
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        if (!this.Di.Cw) {
            ln();
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        lo();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        com.kwad.components.ad.splashscreen.h hVar = this.Di;
        if (hVar == null) {
            return;
        }
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(hVar.mAdTemplate);
        lm();
        lk();
        if (com.kwad.sdk.core.response.b.a.aE(dS)) {
            lq();
        }
        ll();
        lp();
        this.Di.Ct.a(this);
    }

    public abstract void initView();

    public abstract void j(int i, String str);

    public abstract void lk();

    public abstract void ll();

    public abstract void lm();

    public abstract void ln();

    public abstract void lo();

    public abstract void lp();

    public final void lr() {
        Context context = getContext();
        if (context != null) {
            this.eh = (Vibrator) context.getSystemService("vibrator");
        }
        bo.a(getContext(), this.eh);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.Di.Ct.b(this);
        lo();
        bo.b(getContext(), this.eh);
    }
}
