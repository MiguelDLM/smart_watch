package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.navisdk.embed.R;

/* loaded from: classes8.dex */
public class BNRoundCornerRelativelayout extends RelativeLayout {
    public static final int CORNER_ALL = 15;
    public static final int CORNER_BOTTOM_LEFT = 4;
    public static final int CORNER_BOTTOM_RIGHT = 8;
    public static final int CORNER_TOP_LEFT = 1;
    public static final int CORNER_TOP_RIGHT = 2;
    public static final String TAG = "CornerView";
    private final Paint maskPaint;
    private int partCorners;
    private float rectRadius;
    private final RectF roundRect;
    private final Paint zonePaint;

    public BNRoundCornerRelativelayout(Context context) {
        this(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (context == null) {
            return;
        }
        setWillNotDraw(false);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BNRoundCornerRelativelayout);
            this.rectRadius = obtainStyledAttributes.getDimension(R.styleable.BNRoundCornerRelativelayout_radius, 10.0f);
            this.partCorners = 15;
            if (!obtainStyledAttributes.getBoolean(R.styleable.BNRoundCornerRelativelayout_TopLeft, true)) {
                this.partCorners ^= 1;
            }
            if (!obtainStyledAttributes.getBoolean(R.styleable.BNRoundCornerRelativelayout_TopRight, true)) {
                this.partCorners ^= 2;
            }
            if (!obtainStyledAttributes.getBoolean(R.styleable.BNRoundCornerRelativelayout_BottomLeft, true)) {
                this.partCorners ^= 4;
            }
            if (!obtainStyledAttributes.getBoolean(R.styleable.BNRoundCornerRelativelayout_BottomRight, true)) {
                this.partCorners ^= 8;
            }
            obtainStyledAttributes.recycle();
        }
        this.maskPaint.setAntiAlias(true);
        this.maskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.zonePaint.setAntiAlias(true);
        this.zonePaint.setColor(-1);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(this.roundRect, this.zonePaint, 31);
        RectF rectF = this.roundRect;
        float f = this.rectRadius;
        canvas.drawRoundRect(rectF, f, f, this.zonePaint);
        int i = this.partCorners ^ 15;
        if ((i & 1) != 0) {
            float f2 = this.rectRadius;
            canvas.drawRect(0.0f, 0.0f, f2, f2, this.zonePaint);
        }
        if ((i & 2) != 0) {
            canvas.drawRect(canvas.getWidth() - this.rectRadius, 0.0f, canvas.getWidth(), this.rectRadius, this.zonePaint);
        }
        if ((i & 4) != 0) {
            float height = canvas.getHeight();
            float f3 = this.rectRadius;
            canvas.drawRect(0.0f, height - f3, f3, canvas.getHeight(), this.zonePaint);
        }
        if ((i & 8) != 0) {
            canvas.drawRect(canvas.getWidth() - this.rectRadius, canvas.getHeight() - this.rectRadius, canvas.getWidth(), canvas.getHeight(), this.zonePaint);
        }
        canvas.saveLayer(this.roundRect, this.maskPaint, 31);
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.roundRect.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    public void setCorner(float f) {
        this.rectRadius = f;
        invalidate();
    }

    public BNRoundCornerRelativelayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BNRoundCornerRelativelayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.roundRect = new RectF();
        this.rectRadius = 7.0f;
        this.maskPaint = new Paint();
        this.zonePaint = new Paint();
        this.partCorners = 15;
        init(context, attributeSet);
    }
}
