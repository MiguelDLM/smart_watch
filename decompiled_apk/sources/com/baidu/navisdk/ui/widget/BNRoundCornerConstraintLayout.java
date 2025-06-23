package com.baidu.navisdk.ui.widget;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.navisdk.embed.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;

/* loaded from: classes8.dex */
public class BNRoundCornerConstraintLayout extends ConstraintLayout {
    private final Paint mPaint;
    private final Path mPath;
    private float mRadius;
    private final RectF mRectF;

    @xoIox
    public BNRoundCornerConstraintLayout(@OOXIXo Context context) {
        this(context, null, 0, 6, null);
    }

    private final void dispatchDraw27(Canvas canvas) {
        if (canvas != null) {
            canvas.saveLayer(this.mRectF, null, 31);
            super.dispatchDraw(canvas);
            canvas.drawPath(genPath(), this.mPaint);
            canvas.restore();
        }
    }

    private final void dispatchDraw28(Canvas canvas) {
        if (canvas != null) {
            canvas.save();
            canvas.clipPath(genPath());
            super.dispatchDraw(canvas);
            canvas.restore();
        }
    }

    private final void draw27(Canvas canvas) {
        if (canvas != null) {
            canvas.saveLayer(this.mRectF, null, 31);
            super.draw(canvas);
            canvas.drawPath(genPath(), this.mPaint);
        }
    }

    private final void draw28(Canvas canvas) {
        if (canvas != null) {
            canvas.save();
            canvas.clipPath(genPath());
            super.draw(canvas);
            canvas.restore();
        }
    }

    private final Path genPath() {
        Path path = this.mPath;
        path.reset();
        RectF rectF = this.mRectF;
        float f = this.mRadius;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        return path;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(@oOoXoXO Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 28) {
            dispatchDraw28(canvas);
        } else {
            dispatchDraw27(canvas);
        }
    }

    @Override // android.view.View
    public void draw(@oOoXoXO Canvas canvas) {
        super.draw(canvas);
        if (Build.VERSION.SDK_INT >= 28) {
            draw28(canvas);
        } else {
            draw27(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mRectF.set(0.0f, 0.0f, i, i2);
    }

    public final void setRadius(float f) {
        this.mRadius = f;
        postInvalidate();
    }

    @xoIox
    public BNRoundCornerConstraintLayout(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ BNRoundCornerConstraintLayout(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public BNRoundCornerConstraintLayout(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.mPath = new Path();
        this.mRectF = new RectF();
        Paint paint = new Paint(1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        this.mPaint = paint;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BNRoundCornerConstraintLayout);
        IIX0o.oO(obtainStyledAttributes, "context.obtainStyledAttr…ndCornerConstraintLayout)");
        this.mRadius = obtainStyledAttributes.getDimension(R.styleable.BNRoundCornerConstraintLayout_corner_radiuss, 0.0f);
        obtainStyledAttributes.recycle();
    }
}
