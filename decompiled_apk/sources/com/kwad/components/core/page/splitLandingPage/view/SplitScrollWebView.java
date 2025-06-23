package com.kwad.components.core.page.splitLandingPage.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.kwad.components.core.s.d;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: classes11.dex */
public class SplitScrollWebView extends KsAdWebView {
    private int QA;
    private boolean QX;
    private a QY;
    private float QZ;
    private boolean Ra;

    /* loaded from: classes11.dex */
    public interface a {
        void f(float f);

        boolean qy();
    }

    public SplitScrollWebView(Context context) {
        super(context);
        this.QX = false;
        qs();
    }

    private void qs() {
        this.QA = 0;
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int screenHeight;
        if (this.QA != 0) {
            if (d.rG()) {
                i3 = com.kwad.sdk.c.a.a.getStatusBarHeight(getContext());
            } else {
                i3 = 0;
            }
            if (getContext() instanceof Activity) {
                screenHeight = com.kwad.sdk.c.a.a.e((Activity) getContext());
            } else {
                screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
            }
            i2 = View.MeasureSpec.makeMeasureSpec((screenHeight - i3) - this.QA, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (this.QX) {
            return super.onTouchEvent(obtain);
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        float y = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        return false;
                    }
                } else {
                    float f = this.QZ;
                    float f2 = f - y;
                    a aVar = this.QY;
                    if (aVar != null && y <= f) {
                        this.Ra = true;
                        aVar.f(f2);
                    }
                    return super.onTouchEvent(obtain);
                }
            }
            a aVar2 = this.QY;
            if (aVar2 == null) {
                return false;
            }
            if ((this.QZ - y < 0.0f && !this.Ra) || !aVar2.qy()) {
                return false;
            }
            this.QX = true;
            return false;
        }
        this.QZ = y;
        this.Ra = false;
        return super.onTouchEvent(motionEvent);
    }

    public void setDisableAnimation(boolean z) {
        this.QX = z;
    }

    public void setSplitScrollWebViewListener(a aVar) {
        this.QY = aVar;
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.QX = false;
        qs();
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.QX = false;
        qs();
    }
}
