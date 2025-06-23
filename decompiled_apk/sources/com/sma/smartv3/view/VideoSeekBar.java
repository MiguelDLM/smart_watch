package com.sma.smartv3.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatSeekBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nVideoSeekBar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VideoSeekBar.kt\ncom/sma/smartv3/view/VideoSeekBar\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,71:1\n1855#2,2:72\n*S KotlinDebug\n*F\n+ 1 VideoSeekBar.kt\ncom/sma/smartv3/view/VideoSeekBar\n*L\n56#1:72,2\n*E\n"})
/* loaded from: classes12.dex */
public final class VideoSeekBar extends AppCompatSeekBar {
    private int mScaleColor;

    @OXOo.OOXIXo
    private List<Integer> mScaleCount;

    @OXOo.oOoXoXO
    private Paint mScalePaint;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public VideoSeekBar(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(@OXOo.OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        super.onDraw(canvas);
        if (getWidth() > 0 && !this.mScaleCount.isEmpty()) {
            Iterator<T> it = this.mScaleCount.iterator();
            while (it.hasNext()) {
                Paint paint = this.mScalePaint;
                IIX0o.ooOOo0oXI(paint);
                canvas.drawCircle((getWidth() * ((Number) it.next()).intValue()) / getMax(), getHeight() / 2.0f, getMinimumHeight() / 2.0f, paint);
            }
        }
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(@OXOo.oOoXoXO MotionEvent motionEvent) {
        return true;
    }

    public final void setRulerCount(@OXOo.OOXIXo List<Integer> mRulerCount) {
        IIX0o.x0xO0oo(mRulerCount, "mRulerCount");
        this.mScaleCount = CollectionsKt___CollectionsKt.o0Xo0XII(mRulerCount);
        requestLayout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public VideoSeekBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ VideoSeekBar(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public VideoSeekBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.mScaleCount = new ArrayList();
        this.mScaleColor = -1;
        Paint paint = new Paint();
        this.mScalePaint = paint;
        IIX0o.ooOOo0oXI(paint);
        paint.setColor(this.mScaleColor);
        Paint paint2 = this.mScalePaint;
        IIX0o.ooOOo0oXI(paint2);
        paint2.setAntiAlias(true);
    }
}
