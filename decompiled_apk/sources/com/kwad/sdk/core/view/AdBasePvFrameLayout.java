package com.kwad.sdk.core.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.widget.j;

/* loaded from: classes11.dex */
public class AdBasePvFrameLayout extends AdBaseFrameLayout {
    private long aDV;
    private float aDW;
    private boolean aDX;
    private boolean aDY;
    private ViewTreeObserver.OnScrollChangedListener aDZ;
    private ViewTreeObserver aEa;
    private bq aEb;
    private j cD;
    private int mf;

    public AdBasePvFrameLayout(@NonNull Context context) {
        super(context);
        this.aDV = 500L;
        this.aDW = 0.1f;
        this.aDY = true;
        init();
    }

    private void Hr() {
        if (Ht()) {
            Hs();
        } else {
            Hu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ht() {
        if (this.aEb.Od() && Math.abs(this.aEb.aSf.height() - getHeight()) <= getHeight() * (1.0f - this.aDW) && getHeight() > 0 && getWidth() > 0) {
            Rect rect = this.aEb.aSf;
            if (rect.bottom > 0 && rect.top < this.mf) {
                return true;
            }
            return false;
        }
        return false;
    }

    private void Hu() {
        if (this.aDZ == null) {
            this.aDZ = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.core.view.AdBasePvFrameLayout.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (AdBasePvFrameLayout.this.Ht()) {
                        AdBasePvFrameLayout.this.Hs();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            this.aEa = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.aDZ);
            }
        }
    }

    private void Hv() {
        ViewTreeObserver viewTreeObserver;
        try {
            if (this.aDZ != null && (viewTreeObserver = this.aEa) != null && viewTreeObserver.isAlive()) {
                this.aEa.removeOnScrollChangedListener(this.aDZ);
            }
            this.aDZ = null;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
    }

    private void init() {
        this.aEb = new bq(this);
        this.mf = k.getScreenHeight(getContext());
        this.aDY = true;
    }

    private void pc() {
        if (this.aDY) {
            Hr();
        }
    }

    public final void Hs() {
        Hv();
        j jVar = this.cD;
        if (jVar != null) {
            jVar.ao();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Hu();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Hv();
        this.aDX = false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z;
        if (!this.aDX && (i3 | i4) == 0 && (i | i2) != 0) {
            z = true;
            this.aDX = true;
        } else {
            z = false;
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (z) {
            pc();
        }
    }

    public void setCheckDefaultImpressionLogThreshold(float f) {
        this.aDW = f;
    }

    public void setVisibleListener(j jVar) {
        this.cD = jVar;
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDV = 500L;
        this.aDW = 0.1f;
        this.aDY = true;
        init();
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDV = 500L;
        this.aDW = 0.1f;
        this.aDY = true;
        init();
    }
}
