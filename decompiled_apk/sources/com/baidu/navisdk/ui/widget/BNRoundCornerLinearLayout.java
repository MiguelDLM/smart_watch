package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

/* loaded from: classes8.dex */
public class BNRoundCornerLinearLayout extends LinearLayout {
    private int mCornerR;

    public BNRoundCornerLinearLayout(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        setWillNotDraw(false);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        setLayerType(1, null);
        super.draw(canvas);
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-1);
        float width = getWidth();
        float height = getHeight();
        float f = this.mCornerR;
        canvas2.drawRoundRect(0.0f, 0.0f, width, height, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, paint);
    }

    public void setCornerRs(int i) {
        this.mCornerR = i;
        if (i < 0) {
            this.mCornerR = 0;
        }
        invalidate();
    }

    public BNRoundCornerLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public BNRoundCornerLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
