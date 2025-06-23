package com.huawei.openalliance.ad.views;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowMetrics;
import android.widget.LinearLayout;
import com.huawei.hms.ads.ey;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.n;
import java.util.Arrays;

/* loaded from: classes10.dex */
public abstract class PPSBaseDialogContentView extends LinearLayout {
    public static final float Code = 6.0f;

    /* renamed from: a, reason: collision with root package name */
    public static final float f17420a = 0.8f;
    private static final String f = "PPSBaseDialogContentView";
    private static final float g = 0.86f;
    private static final float h = 0.6f;
    private static final float i = 0.6f;
    protected View B;
    protected float C;
    protected int D;
    protected int[] F;
    protected View I;
    protected int L;
    protected int[] S;
    protected View V;
    protected int b;
    protected int c;
    protected Boolean d;
    protected ViewTreeObserver.OnGlobalLayoutListener e;

    public PPSBaseDialogContentView(Context context) {
        super(context);
        this.D = (int) (com.huawei.openalliance.ad.utils.d.Code(getContext()) * 0.8f);
        this.e = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.openalliance.ad.views.PPSBaseDialogContentView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = PPSBaseDialogContentView.this.I;
                    if (view == null) {
                        return;
                    }
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredHeight = PPSBaseDialogContentView.this.I.getMeasuredHeight();
                    PPSBaseDialogContentView pPSBaseDialogContentView = PPSBaseDialogContentView.this;
                    pPSBaseDialogContentView.Code(pPSBaseDialogContentView.I, Math.min(measuredHeight, pPSBaseDialogContentView.D));
                } catch (Throwable th) {
                    fb.I(PPSBaseDialogContentView.f, "onGlobalLayout error: %s", th.getClass().getSimpleName());
                }
            }
        };
        B(context);
    }

    private void B(Context context) {
        try {
            Code(context);
            I(context);
            Z(context);
            V(context);
            Code();
        } catch (Throwable th) {
            fb.I(f, "init ex: %s", th.getClass().getSimpleName());
        }
    }

    public abstract void Code();

    public void Code(int i2) {
        int i3 = this.b;
        if (i3 > i2) {
            this.b = i3 - i2;
        }
        int i4 = this.c;
        if (i4 > i2) {
            this.c = i4 - i2;
        }
        Code();
    }

    public abstract void Code(Context context);

    public void I(Context context) {
        if (n.B(context) || (n.S(context) && n.F(context))) {
            this.C = 0.6f;
        } else {
            this.C = g;
        }
    }

    public abstract void V(Context context);

    public boolean V() {
        return (this.F == null || this.S == null) ? false : true;
    }

    public void Z(Context context) {
        int i2;
        int i3;
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        WindowMetrics currentWindowMetrics2;
        Rect bounds2;
        if (this.B != null) {
            int V = com.huawei.openalliance.ad.utils.d.V(context);
            int Code2 = com.huawei.openalliance.ad.utils.d.Code(context);
            if (context instanceof Activity) {
                if (Build.VERSION.SDK_INT >= 30) {
                    Activity activity = (Activity) context;
                    currentWindowMetrics = activity.getWindowManager().getCurrentWindowMetrics();
                    bounds = currentWindowMetrics.getBounds();
                    i2 = bounds.width();
                    currentWindowMetrics2 = activity.getWindowManager().getCurrentWindowMetrics();
                    bounds2 = currentWindowMetrics2.getBounds();
                    i3 = bounds2.height();
                } else {
                    Point point = new Point();
                    ((Activity) context).getWindowManager().getDefaultDisplay().getSize(point);
                    i2 = point.x;
                    i3 = point.y;
                }
                int i4 = i2;
                Code2 = i3;
                V = i4;
            }
            ViewGroup.LayoutParams layoutParams = this.B.getLayoutParams();
            this.L = (int) ((bc.c(context) == 1 ? V : Math.min(V, Code2)) * this.C);
            layoutParams.width = this.L;
            this.B.setLayoutParams(layoutParams);
        }
    }

    public float getViewWidthPercent() {
        return this.C;
    }

    public int getViewWith() {
        return this.L;
    }

    public void setAdContentData(AdContentData adContentData) {
    }

    public void setFeedbackListener(com.huawei.openalliance.ad.compliance.a aVar) {
    }

    public void setPaddingStart(int i2) {
        if (bc.I()) {
            this.b = 0;
            this.c = i2;
        } else {
            this.b = i2;
            this.c = 0;
        }
        Code();
    }

    public void setShowWhyThisAd(boolean z) {
        this.d = Boolean.valueOf(z);
    }

    public void setViewClickListener(ey eyVar) {
    }

    public PPSBaseDialogContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = (int) (com.huawei.openalliance.ad.utils.d.Code(getContext()) * 0.8f);
        this.e = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.openalliance.ad.views.PPSBaseDialogContentView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = PPSBaseDialogContentView.this.I;
                    if (view == null) {
                        return;
                    }
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredHeight = PPSBaseDialogContentView.this.I.getMeasuredHeight();
                    PPSBaseDialogContentView pPSBaseDialogContentView = PPSBaseDialogContentView.this;
                    pPSBaseDialogContentView.Code(pPSBaseDialogContentView.I, Math.min(measuredHeight, pPSBaseDialogContentView.D));
                } catch (Throwable th) {
                    fb.I(PPSBaseDialogContentView.f, "onGlobalLayout error: %s", th.getClass().getSimpleName());
                }
            }
        };
        B(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(View view, int i2) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    public PPSBaseDialogContentView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.D = (int) (com.huawei.openalliance.ad.utils.d.Code(getContext()) * 0.8f);
        this.e = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.openalliance.ad.views.PPSBaseDialogContentView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = PPSBaseDialogContentView.this.I;
                    if (view == null) {
                        return;
                    }
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredHeight = PPSBaseDialogContentView.this.I.getMeasuredHeight();
                    PPSBaseDialogContentView pPSBaseDialogContentView = PPSBaseDialogContentView.this;
                    pPSBaseDialogContentView.Code(pPSBaseDialogContentView.I, Math.min(measuredHeight, pPSBaseDialogContentView.D));
                } catch (Throwable th) {
                    fb.I(PPSBaseDialogContentView.f, "onGlobalLayout error: %s", th.getClass().getSimpleName());
                }
            }
        };
        B(context);
    }

    @SuppressLint({"NewApi"})
    public PPSBaseDialogContentView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.D = (int) (com.huawei.openalliance.ad.utils.d.Code(getContext()) * 0.8f);
        this.e = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.openalliance.ad.views.PPSBaseDialogContentView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = PPSBaseDialogContentView.this.I;
                    if (view == null) {
                        return;
                    }
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredHeight = PPSBaseDialogContentView.this.I.getMeasuredHeight();
                    PPSBaseDialogContentView pPSBaseDialogContentView = PPSBaseDialogContentView.this;
                    pPSBaseDialogContentView.Code(pPSBaseDialogContentView.I, Math.min(measuredHeight, pPSBaseDialogContentView.D));
                } catch (Throwable th) {
                    fb.I(PPSBaseDialogContentView.f, "onGlobalLayout error: %s", th.getClass().getSimpleName());
                }
            }
        };
        B(context);
    }

    public void Code(int[] iArr, int[] iArr2) {
        if (iArr == null || iArr2 == null) {
            return;
        }
        this.S = Arrays.copyOf(iArr, iArr.length);
        this.F = Arrays.copyOf(iArr2, iArr2.length);
    }
}
