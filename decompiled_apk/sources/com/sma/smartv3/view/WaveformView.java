package com.sma.smartv3.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.blankj.utilcode.util.SizeUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nWaveformView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WaveformView.kt\ncom/sma/smartv3/view/WaveformView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,89:1\n1864#2,3:90\n*S KotlinDebug\n*F\n+ 1 WaveformView.kt\ncom/sma/smartv3/view/WaveformView\n*L\n66#1:90,3\n*E\n"})
/* loaded from: classes12.dex */
public final class WaveformView extends View {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final int f25389IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final List<Float> f25390Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25391XO;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @XO0OX.xoIox
    public WaveformView(@OXOo.OOXIXo Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        IIX0o.x0xO0oo(context, "context");
    }

    public final void I0Io(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WaveformView);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            this.f25391XO.setColor(obtainStyledAttributes.getColor(0, Color.parseColor("#FF8C33")));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final float II0xO0(int i) {
        return SizeUtils.dp2px(i);
    }

    public final void oIX0oI(float f) {
        this.f25390Oo.add(Float.valueOf(f));
        if (this.f25390Oo.size() > this.f25389IXxxXO) {
            this.f25390Oo.remove(0);
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("WaveformView amplitudes: " + this.f25390Oo.size() + TokenParser.SP + this.f25390Oo.get(0).floatValue());
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(@OXOo.OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        super.onDraw(canvas);
        if (this.f25390Oo.isEmpty()) {
            return;
        }
        Path path = new Path();
        float width = getWidth() / this.f25389IXxxXO;
        int i = 0;
        for (Object obj : this.f25390Oo) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            float f = i * width;
            float floatValue = (((Number) obj).floatValue() % getHeight()) / 2;
            path.moveTo(f, ((getHeight() / 2) - II0xO0(4)) - floatValue);
            path.lineTo(f, (getHeight() / 2) + II0xO0(4) + floatValue);
            i = i2;
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("WaveformView amplitudes: " + this.f25390Oo.size() + " width " + getWidth() + " height " + getHeight());
        canvas.drawPath(path, this.f25391XO);
    }

    public final float oxoX(int i) {
        return SizeUtils.sp2px(i);
    }

    public /* synthetic */ WaveformView(Context context, AttributeSet attributeSet, int i, IIXOooo iIXOooo) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public WaveformView(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        super(context, attributeSet);
        IIX0o.x0xO0oo(context, "context");
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#FF8C33"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(II0xO0(2));
        paint.setAntiAlias(true);
        this.f25391XO = paint;
        this.f25390Oo = new ArrayList();
        this.f25389IXxxXO = 25;
        I0Io(context, attributeSet);
        for (int i = 0; i < 25; i++) {
            this.f25390Oo.add(Float.valueOf(0.0f));
        }
    }
}
