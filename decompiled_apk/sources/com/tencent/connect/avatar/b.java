package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import com.baidu.navisdk.util.common.ScreenUtil;

/* loaded from: classes13.dex */
public class b extends View {

    /* renamed from: Oo, reason: collision with root package name */
    public Paint f26696Oo;

    /* renamed from: XO, reason: collision with root package name */
    public Rect f26697XO;

    public b(Context context) {
        super(context);
        II0xO0();
    }

    public final void II0xO0() {
        this.f26696Oo = new Paint();
    }

    public Rect oIX0oI() {
        if (this.f26697XO == null) {
            this.f26697XO = new Rect();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int min = Math.min(Math.min(measuredHeight - 140, measuredWidth), ScreenUtil.SCREEN_SIZE_Y_LARGE);
            int i = (measuredWidth - min) / 2;
            int i2 = (measuredHeight - min) / 2;
            this.f26697XO.set(i, i2, i + min, min + i2);
        }
        return this.f26697XO;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect oIX0oI2 = oIX0oI();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f26696Oo.setStyle(Paint.Style.FILL);
        this.f26696Oo.setColor(Color.argb(100, 0, 0, 0));
        float f = measuredWidth;
        canvas.drawRect(0.0f, 0.0f, f, oIX0oI2.top, this.f26696Oo);
        canvas.drawRect(0.0f, oIX0oI2.bottom, f, measuredHeight, this.f26696Oo);
        canvas.drawRect(0.0f, oIX0oI2.top, oIX0oI2.left, oIX0oI2.bottom, this.f26696Oo);
        canvas.drawRect(oIX0oI2.right, oIX0oI2.top, f, oIX0oI2.bottom, this.f26696Oo);
        canvas.drawColor(Color.argb(100, 0, 0, 0));
        this.f26696Oo.setStyle(Paint.Style.STROKE);
        this.f26696Oo.setColor(-1);
        canvas.drawRect(oIX0oI2.left, oIX0oI2.top, oIX0oI2.right - 1, oIX0oI2.bottom, this.f26696Oo);
    }
}
