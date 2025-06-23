package com.kwad.components.ad.reward.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.kwad.components.core.widget.d;
import com.kwad.components.core.widget.e;
import com.kwad.sdk.R;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes11.dex */
public class KSCouponLabelTextView extends TextView implements d {
    private Path AA;
    private boolean AB;
    private final Rect An;
    private final RectF Ao;
    private final RectF Ar;
    private float At;
    private float Au;
    private float Av;
    private final RectF Aw;
    private final RectF Ax;
    private final Path Ay;
    private Path Az;
    private final Paint mPaint;

    @ColorInt
    private int strokeColor;

    public KSCouponLabelTextView(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.An = new Rect();
        this.Ao = new RectF();
        this.Aw = new RectF();
        this.Ax = new RectF();
        this.Ay = new Path();
        this.Ar = new RectF();
        this.AB = true;
        a(context, null, 0);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSCouponLabelTextView, i, 0);
        int color = context.getResources().getColor(R.color.ksad_reward_main_color);
        this.At = obtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_labelRadius, 8.0f);
        this.Au = obtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_strokeSize, 2.0f);
        this.strokeColor = obtainStyledAttributes.getColor(R.styleable.ksad_KSCouponLabelTextView_ksad_strokeColor, color);
        this.Av = obtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_sideRadius, 16.0f);
        obtainStyledAttributes.recycle();
        ke();
    }

    private void b(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        path.moveTo(rectF.left, rectF.top + this.At);
        this.Ar.set(rectF);
        RectF rectF4 = this.Ar;
        float f = rectF4.top;
        float f2 = this.At;
        rectF4.bottom = f + (f2 * 2.0f);
        rectF4.right = rectF4.left + (f2 * 2.0f);
        path.arcTo(rectF4, 180.0f, 90.0f);
        path.lineTo(rectF.width() - this.At, rectF.top);
        this.Ar.set(rectF);
        RectF rectF5 = this.Ar;
        float f3 = rectF5.right;
        float f4 = this.At;
        rectF5.left = f3 - (f4 * 2.0f);
        rectF5.bottom = rectF5.top + (f4 * 2.0f);
        path.arcTo(rectF5, 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF3.top);
        path.arcTo(rectF3, 270.0f, -180.0f);
        path.lineTo(rectF.right, rectF.bottom - this.At);
        this.Ar.set(rectF);
        RectF rectF6 = this.Ar;
        float f5 = rectF6.right;
        float f6 = this.At;
        rectF6.left = f5 - (f6 * 2.0f);
        rectF6.top = rectF6.bottom - (f6 * 2.0f);
        path.arcTo(rectF6, 0.0f, 90.0f);
        path.lineTo(rectF.left + this.At, rectF.bottom);
        this.Ar.set(rectF);
        RectF rectF7 = this.Ar;
        float f7 = rectF7.left;
        float f8 = this.At;
        rectF7.right = f7 + (f8 * 2.0f);
        rectF7.top = rectF7.bottom - (f8 * 2.0f);
        path.arcTo(rectF7, 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF2.bottom);
        path.arcTo(rectF2, 90.0f, -180.0f);
        path.close();
    }

    private void ke() {
        this.mPaint.setColor(this.strokeColor);
        this.mPaint.setStrokeWidth(this.Au);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.An.setEmpty();
        getDrawingRect(this.An);
        float f = this.Au / 2.0f;
        this.Ao.set(this.An);
        RectF rectF = this.Ao;
        rectF.left += f;
        rectF.top += f;
        rectF.right -= f;
        rectF.bottom -= f;
        a(rectF, this.Aw);
        b(this.Ao, this.Ax);
        Path path = this.Az;
        if (path == null) {
            this.Az = new Path();
        } else {
            path.reset();
        }
        Path path2 = this.AA;
        if (path2 == null) {
            this.AA = new Path();
        } else {
            path2.reset();
        }
        a(this.Ay, this.Az, this.AA, this.Ao, this.Aw, this.Ax);
        canvas.drawPath(this.Ay, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.AB) {
            if (getPaddingLeft() + getPaddingRight() + getPaint().measureText(getText().toString()) > getMeasuredWidth()) {
                setVisibility(8);
            }
        }
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.An = new Rect();
        this.Ao = new RectF();
        this.Aw = new RectF();
        this.Ax = new RectF();
        this.Ay = new Path();
        this.Ar = new RectF();
        this.AB = true;
        a(context, attributeSet, 0);
    }

    @RequiresApi(api = 19)
    private void a(Path path, Path path2, Path path3, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        float f = this.At;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        path2.addArc(rectF2, 90.0f, -180.0f);
        path3.addArc(rectF3, 90.0f, 180.0f);
        Path path4 = this.Az;
        Path.Op op = Path.Op.DIFFERENCE;
        path.op(path4, op);
        path.op(this.AA, op);
    }

    private void a(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        float f = rectF2.left;
        float f2 = this.Av;
        float f3 = f - f2;
        rectF2.left = f3;
        rectF2.right = f3 + (f2 * 2.0f);
        float height = rectF.height();
        float f4 = this.Av;
        float f5 = rectF2.top + ((height - (f4 * 2.0f)) / 2.0f);
        rectF2.top = f5;
        rectF2.bottom = f5 + (f4 * 2.0f);
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.An = new Rect();
        this.Ao = new RectF();
        this.Aw = new RectF();
        this.Ax = new RectF();
        this.Ay = new Path();
        this.Ar = new RectF();
        this.AB = true;
        a(context, attributeSet, i);
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        int color = getResources().getColor(R.color.ksad_reward_main_color);
        this.strokeColor = color;
        setTextColor(color);
        ke();
        invalidate();
    }

    private void b(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        float f = rectF2.right;
        float f2 = this.Av;
        float f3 = f + f2;
        rectF2.right = f3;
        rectF2.left = f3 - (f2 * 2.0f);
        float height = rectF.height();
        float f4 = this.Av;
        float f5 = rectF2.top + ((height - (f4 * 2.0f)) / 2.0f);
        rectF2.top = f5;
        rectF2.bottom = f5 + (f4 * 2.0f);
    }
}
