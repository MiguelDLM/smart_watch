package com.kwad.sdk.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.k;

/* loaded from: classes11.dex */
public final class g {
    private final bq aEb;
    private final i aUa;
    private boolean aUc;
    private boolean aUd;
    private ViewTreeObserver.OnScrollChangedListener aUf;
    private final View mView;
    private final int mf;
    private float aUb = 0.1f;
    private boolean aUe = true;

    public g(View view, i iVar) {
        this.mView = view;
        this.aUa = iVar;
        this.aEb = new bq(view);
        this.mf = k.getScreenHeight(view.getContext());
    }

    private void Hu() {
        if (this.aUf == null) {
            this.aUf = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.g.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (g.this.OG()) {
                        g.this.ao();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.aUf);
            }
        }
    }

    private void Hv() {
        if (this.aUf == null) {
            return;
        }
        try {
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnScrollChangedListener(this.aUf);
            }
            this.aUf = null;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
    }

    private void OF() {
        if (OG()) {
            ao();
        } else {
            Hv();
            Hu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean OG() {
        if (this.aEb.Od() && Math.abs(this.aEb.aSf.height() - this.mView.getHeight()) <= this.mView.getHeight() * (1.0f - this.aUb) && this.mView.getHeight() > 0 && this.mView.getWidth() > 0) {
            Rect rect = this.aEb.aSf;
            if (rect.bottom > 0 && rect.top < this.mf) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao() {
        try {
            Hv();
            i iVar = this.aUa;
            if (iVar != null) {
                iVar.A(this.mView);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void pc() {
        if (this.aUe) {
            OF();
        }
    }

    public final void OE() {
        if (this.aUd) {
            pc();
        }
    }

    public final void ce(boolean z) {
        this.aUe = z;
    }

    public final float getVisiblePercent() {
        return this.aUb;
    }

    public final void onAttachedToWindow() {
        Hu();
    }

    public final void onDetachedFromWindow() {
        Hv();
        this.aUc = false;
    }

    public final void setVisiblePercent(float f) {
        this.aUb = f;
    }

    public final void b(int i, int i2, int i3, int i4) {
        this.aUd = false;
        if (this.aUc || (i3 | i4) != 0 || (i | i2) == 0) {
            return;
        }
        this.aUd = true;
        this.aUc = true;
    }
}
