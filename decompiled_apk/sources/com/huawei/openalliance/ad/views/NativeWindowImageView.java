package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.huawei.hms.ads.ds;
import com.huawei.hms.ads.du;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.ke;
import com.huawei.hms.ads.nativead.NativeView;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import com.huawei.openalliance.ad.utils.an;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.utils.z;
import java.util.Iterator;

/* loaded from: classes10.dex */
public class NativeWindowImageView extends AutoScaleSizeRelativeLayout implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, ke, an {
    private View B;
    private ImageView C;
    private Drawable D;
    private com.huawei.openalliance.ad.inter.data.g F;
    private Rect L;
    private ProgressBar S;

    /* renamed from: a, reason: collision with root package name */
    private Rect f17419a;
    private float b;
    private int c;
    private boolean d;

    public NativeWindowImageView(Context context) {
        super(context);
        this.f17419a = new Rect();
        this.b = 1.3007812f;
        this.c = 0;
        this.d = true;
        Code(context);
    }

    private void B() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeOnGlobalLayoutListener(this);
        }
    }

    private void C() {
        if (S()) {
            V();
            D();
            L();
            a();
            F();
        }
    }

    private void D() {
        Object parent = this.B.getParent();
        if (parent == null) {
            fb.Z("NativeWindowImageView", "invalid parent obj");
        } else {
            ((View) parent).getGlobalVisibleRect(this.L);
        }
    }

    private void F() {
        if (this.D == null) {
            return;
        }
        this.C.setScaleType(ImageView.ScaleType.MATRIX);
        int intrinsicWidth = this.D.getIntrinsicWidth();
        float width = intrinsicWidth != 0 ? getWidth() / intrinsicWidth : 1.0f;
        Matrix matrix = new Matrix();
        matrix.setScale(width, width);
        matrix.postTranslate(0.0f, this.c);
        this.C.setImageMatrix(matrix);
        this.C.invalidate();
    }

    private void I() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.removeOnGlobalLayoutListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
    }

    private void L() {
        Rect rect = new Rect();
        getLocalVisibleRect(rect);
        Rect rect2 = new Rect();
        getGlobalVisibleRect(rect2);
        Rect rect3 = this.f17419a;
        int i = rect2.left - rect.left;
        rect3.left = i;
        rect3.right = i + getWidth();
        Rect rect4 = this.f17419a;
        int i2 = rect2.top - rect.top;
        rect4.top = i2;
        rect4.bottom = i2 + getHeight();
    }

    private boolean S() {
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        return rect.width() > 0 && rect.height() > 0;
    }

    private void a() {
        int width = (int) (getWidth() * this.b);
        if (Code(width)) {
            int height = (this.L.height() - width) / 2;
            Rect rect = this.f17419a;
            int i = rect.top;
            Rect rect2 = this.L;
            int i2 = rect2.top;
            if (i - i2 <= height) {
                this.c = 0;
            } else if (rect2.bottom - rect.bottom <= height) {
                this.c = rect.height() - width;
            } else {
                this.c = (i2 + height) - i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int intrinsicWidth = this.D.getIntrinsicWidth();
        int intrinsicHeight = this.D.getIntrinsicHeight();
        if (intrinsicHeight != 0 && intrinsicWidth != 0) {
            this.b = intrinsicHeight / intrinsicWidth;
        }
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageDrawable(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof ds) {
                ((ds) drawable).Code(new du() { // from class: com.huawei.openalliance.ad.views.NativeWindowImageView.1
                    @Override // com.huawei.hms.ads.du
                    public void Code() {
                        NativeWindowImageView.this.b();
                    }

                    @Override // com.huawei.hms.ads.du
                    public void I() {
                    }

                    @Override // com.huawei.hms.ads.du
                    public void V() {
                    }
                });
            } else {
                b();
            }
            this.C.setImageDrawable(drawable);
            this.S.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        I();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        B();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        C();
    }

    @Override // com.huawei.openalliance.ad.views.AutoScaleSizeRelativeLayout, android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ImageView imageView = this.C;
        imageView.layout(0, 0, imageView.getMeasuredWidth(), this.C.getMeasuredHeight());
    }

    @Override // com.huawei.openalliance.ad.views.AutoScaleSizeRelativeLayout, android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = getMeasuredWidth();
        this.C.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (measuredWidth * this.b), 1073741824));
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        C();
    }

    @Override // com.huawei.hms.ads.ke
    public void setDisplayView(View view) {
        if (view != null) {
            this.d = false;
            this.B = view;
        }
    }

    @Override // com.huawei.hms.ads.ke
    public void setNativeAd(com.huawei.openalliance.ad.inter.data.g gVar) {
        this.F = gVar;
        if (gVar != null) {
            Iterator<ImageInfo> it = gVar.B().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ImageInfo next = it.next();
                if (next != null) {
                    String Z = next.Z();
                    SourceParam sourceParam = new SourceParam();
                    sourceParam.I(Z);
                    sourceParam.V(next.I());
                    sourceParam.V(next.S());
                    z.Code(getContext(), sourceParam, this);
                    break;
                }
            }
            requestLayout();
        }
    }

    public NativeWindowImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17419a = new Rect();
        this.b = 1.3007812f;
        this.c = 0;
        this.d = true;
        Code(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void V() {
        if (this.d) {
            ViewParent viewParent = this.B.getParent();
            while (viewParent != 0 && !Code(viewParent)) {
                viewParent = viewParent.getParent();
            }
            if (Code(viewParent)) {
                this.B = (View) viewParent;
            }
        }
    }

    @Override // com.huawei.openalliance.ad.utils.an
    public void Code() {
        fb.Z("NativeWindowImageView", "load image fail");
    }

    public NativeWindowImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17419a = new Rect();
        this.b = 1.3007812f;
        this.c = 0;
        this.d = true;
        Code(context);
    }

    private void Code(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hiad_window_image_layout, this);
        this.B = this;
        this.C = (ImageView) findViewById(R.id.window_image_content);
        this.S = (ProgressBar) findViewById(R.id.window_image_progress);
        setRatio(Float.valueOf(1.7777778f));
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.L = new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    @Override // com.huawei.openalliance.ad.utils.an
    public void Code(String str, final Drawable drawable) {
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.NativeWindowImageView.2
            @Override // java.lang.Runnable
            public void run() {
                NativeWindowImageView.this.D = drawable;
                NativeWindowImageView nativeWindowImageView = NativeWindowImageView.this;
                nativeWindowImageView.setImageDrawable(nativeWindowImageView.D);
            }
        });
    }

    private boolean Code(int i) {
        return this.L.height() >= i;
    }

    private boolean Code(Object obj) {
        return (obj instanceof PPSNativeView) || (obj instanceof NativeView);
    }
}
