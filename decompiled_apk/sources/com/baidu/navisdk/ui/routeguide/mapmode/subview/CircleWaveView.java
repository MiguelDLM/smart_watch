package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.ScreenUtil;

/* loaded from: classes8.dex */
public class CircleWaveView extends View {

    /* renamed from: a, reason: collision with root package name */
    private int f8707a;
    private Paint b;

    public CircleWaveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, this.f8707a, this.b);
    }

    public void setCircleRadius(int i) {
        int i2 = i + 10;
        if (i2 > 80) {
            this.f8707a = (int) (ScreenUtil.getInstance().getDensity() * 80.0f);
        } else {
            this.f8707a = (int) (i2 * ScreenUtil.getInstance().getDensity());
        }
        invalidate();
    }

    public CircleWaveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8707a = 0;
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_asr_voice_wave));
        this.b.setStyle(Paint.Style.FILL);
    }
}
