package com.baidu.navisdk.widget.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: classes8.dex */
public class PhotoView extends AppCompatImageView {

    /* renamed from: a, reason: collision with root package name */
    private k f9423a;
    private ImageView.ScaleType b;

    public PhotoView(Context context) {
        this(context, null);
    }

    private void a() {
        this.f9423a = new k(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.b = null;
        }
    }

    public k getAttacher() {
        return this.f9423a;
    }

    public RectF getDisplayRect() {
        return this.f9423a.a();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f9423a.b();
    }

    public float getMaximumScale() {
        return this.f9423a.c();
    }

    public float getMediumScale() {
        return this.f9423a.d();
    }

    public float getMinimumScale() {
        return this.f9423a.e();
    }

    public float getScale() {
        return this.f9423a.f();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f9423a.g();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f9423a.a(z);
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (frame) {
            this.f9423a.h();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        k kVar = this.f9423a;
        if (kVar != null) {
            kVar.h();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        k kVar = this.f9423a;
        if (kVar != null) {
            kVar.h();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        k kVar = this.f9423a;
        if (kVar != null) {
            kVar.h();
        }
    }

    public void setMaximumScale(float f) {
        this.f9423a.a(f);
    }

    public void setMediumScale(float f) {
        this.f9423a.b(f);
    }

    public void setMinimumScale(float f) {
        this.f9423a.c(f);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f9423a.a(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f9423a.a(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f9423a.a(onLongClickListener);
    }

    public void setOnMatrixChangeListener(d dVar) {
        this.f9423a.a(dVar);
    }

    public void setOnOutsidePhotoTapListener(e eVar) {
        this.f9423a.a(eVar);
    }

    public void setOnPhotoTapListener(f fVar) {
        this.f9423a.a(fVar);
    }

    public void setOnScaleChangeListener(g gVar) {
        this.f9423a.a(gVar);
    }

    public void setOnSingleFlingListener(h hVar) {
        this.f9423a.a(hVar);
    }

    public void setOnViewDragListener(i iVar) {
        this.f9423a.a(iVar);
    }

    public void setOnViewTapListener(j jVar) {
        this.f9423a.a(jVar);
    }

    public void setRotationBy(float f) {
        this.f9423a.d(f);
    }

    public void setRotationTo(float f) {
        this.f9423a.e(f);
    }

    public void setScale(float f) {
        this.f9423a.f(f);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        k kVar = this.f9423a;
        if (kVar == null) {
            this.b = scaleType;
        } else {
            kVar.a(scaleType);
        }
    }

    public void setZoomTransitionDuration(int i) {
        this.f9423a.a(i);
    }

    public void setZoomable(boolean z) {
        this.f9423a.b(z);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
