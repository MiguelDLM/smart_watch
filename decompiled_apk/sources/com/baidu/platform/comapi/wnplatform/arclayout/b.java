package com.baidu.platform.comapi.wnplatform.arclayout;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewOutlineProvider;
import android.widget.RelativeLayout;
import com.baidu.platform.comapi.wnplatform.arclayout.a.b;

/* loaded from: classes8.dex */
public abstract class b extends RelativeLayout {
    private Bitmap clipBitmap;
    private com.baidu.platform.comapi.wnplatform.arclayout.a.a clipManager;
    private final Paint clipPaint;
    private final Path clipPath;
    protected Drawable drawable;
    protected PorterDuffXfermode pdMode;
    final Path rectView;
    private boolean requiersShapeUpdate;

    public b(Context context) {
        super(context);
        this.clipPaint = new Paint(1);
        this.clipPath = new Path();
        this.pdMode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.drawable = null;
        this.clipManager = new com.baidu.platform.comapi.wnplatform.arclayout.a.b();
        this.requiersShapeUpdate = true;
        this.rectView = new Path();
        init(context, null);
    }

    private void calculateLayout(int i, int i2) {
        this.rectView.reset();
        this.rectView.addRect(0.0f, 0.0f, getWidth() * 1.0f, getHeight() * 1.0f, Path.Direction.CW);
        com.baidu.platform.comapi.wnplatform.arclayout.a.a aVar = this.clipManager;
        if (aVar != null && i > 0 && i2 > 0) {
            aVar.b(i, i2);
            this.clipPath.reset();
            this.clipPath.set(this.clipManager.a(i, i2));
            if (requiresBitmap()) {
                Bitmap bitmap = this.clipBitmap;
                if (bitmap != null) {
                    bitmap.recycle();
                }
                this.clipBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.clipBitmap);
                Drawable drawable = this.drawable;
                if (drawable != null) {
                    drawable.setBounds(0, 0, i, i2);
                    this.drawable.draw(canvas);
                } else {
                    canvas.drawPath(this.clipPath, this.clipManager.b());
                }
            }
            if (Build.VERSION.SDK_INT > 27) {
                this.rectView.op(this.clipPath, Path.Op.DIFFERENCE);
            }
        }
        postInvalidate();
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.clipPaint.setAntiAlias(true);
        setDrawingCacheEnabled(true);
        setWillNotDraw(false);
        this.clipPaint.setColor(-16776961);
        this.clipPaint.setStyle(Paint.Style.FILL);
        this.clipPaint.setStrokeWidth(1.0f);
        if (Build.VERSION.SDK_INT <= 27) {
            this.clipPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            setLayerType(1, this.clipPaint);
        } else {
            this.clipPaint.setXfermode(this.pdMode);
            setLayerType(1, null);
        }
    }

    private boolean requiresBitmap() {
        com.baidu.platform.comapi.wnplatform.arclayout.a.a aVar;
        if (!isInEditMode() && (((aVar = this.clipManager) == null || !aVar.c()) && this.drawable == null)) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.requiersShapeUpdate) {
            calculateLayout(canvas.getWidth(), canvas.getHeight());
            this.requiersShapeUpdate = false;
        }
        if (requiresBitmap()) {
            this.clipPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawBitmap(this.clipBitmap, 0.0f, 0.0f, this.clipPaint);
        } else if (Build.VERSION.SDK_INT <= 27) {
            canvas.drawPath(this.clipPath, this.clipPaint);
        } else {
            canvas.drawPath(this.rectView, this.clipPaint);
        }
        setLayerType(2, null);
    }

    public int dpToPx(float f) {
        return (int) TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
    }

    @Override // android.view.View
    @TargetApi(21)
    public ViewOutlineProvider getOutlineProvider() {
        return new c(this);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            requiresShapeUpdate();
        }
    }

    public void requiresShapeUpdate() {
        this.requiersShapeUpdate = true;
        postInvalidate();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
    }

    public void setClipPathCreator(b.a aVar) {
        ((com.baidu.platform.comapi.wnplatform.arclayout.a.b) this.clipManager).a(aVar);
        requiresShapeUpdate();
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
        requiresShapeUpdate();
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clipPaint = new Paint(1);
        this.clipPath = new Path();
        this.pdMode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.drawable = null;
        this.clipManager = new com.baidu.platform.comapi.wnplatform.arclayout.a.b();
        this.requiersShapeUpdate = true;
        this.rectView = new Path();
        init(context, attributeSet);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.clipPaint = new Paint(1);
        this.clipPath = new Path();
        this.pdMode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.drawable = null;
        this.clipManager = new com.baidu.platform.comapi.wnplatform.arclayout.a.b();
        this.requiersShapeUpdate = true;
        this.rectView = new Path();
        init(context, attributeSet);
    }
}
