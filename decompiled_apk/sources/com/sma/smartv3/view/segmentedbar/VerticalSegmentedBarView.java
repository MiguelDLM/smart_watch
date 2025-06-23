package com.sma.smartv3.view.segmentedbar;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.Xo0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import o0Xo.oIX0oI;

@XX({"SMAP\nVerticalSegmentedBarView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerticalSegmentedBarView.kt\ncom/sma/smartv3/view/segmentedbar/VerticalSegmentedBarView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,73:1\n1864#2,3:74\n1864#2,3:77\n*S KotlinDebug\n*F\n+ 1 VerticalSegmentedBarView.kt\ncom/sma/smartv3/view/segmentedbar/VerticalSegmentedBarView\n*L\n40#1:74,3\n47#1:77,3\n*E\n"})
/* loaded from: classes12.dex */
public final class VerticalSegmentedBarView extends View {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OOXIXo
    public final Paint f25733IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OOXIXo
    public final Set<Pair<Integer, RectF>> f25734Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OOXIXo
    public final RectF f25735Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public float f25736OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public List<? extends oIX0oI> f25737XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f25738oI0IIXIo;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @xoIox
    public VerticalSegmentedBarView(@OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    @Override // android.view.View
    public void onDraw(@OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        super.onDraw(canvas);
        if (this.f25737XO.isEmpty()) {
            return;
        }
        this.f25734Oo.clear();
        this.f25735Oxx0xo.set(0.0f, 0.0f, getWidth(), getHeight());
        float oxoX2 = ((oIX0oI) CollectionsKt___CollectionsKt.O0O0Io00X(this.f25737XO)).oxoX();
        float X0o0xo2 = ((oIX0oI) CollectionsKt___CollectionsKt.O0OOX0IIx(this.f25737XO)).X0o0xo();
        RectF rectF = this.f25735Oxx0xo;
        float f = (rectF.bottom - rectF.top) / (oxoX2 - X0o0xo2);
        int i = 0;
        int i2 = 0;
        for (Object obj : this.f25737XO) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            oIX0oI oix0oi = (oIX0oI) obj;
            float oxoX3 = this.f25735Oxx0xo.bottom - ((oix0oi.oxoX() - X0o0xo2) * f);
            float X0o0xo3 = this.f25735Oxx0xo.bottom - ((oix0oi.X0o0xo() - X0o0xo2) * f);
            RectF rectF2 = this.f25735Oxx0xo;
            this.f25734Oo.add(Xo0.oIX0oI(Integer.valueOf(oix0oi.oIX0oI()), new RectF(rectF2.left, oxoX3, rectF2.right, X0o0xo3)));
            i2 = i3;
        }
        int size = this.f25734Oo.size();
        for (Object obj2 : this.f25734Oo) {
            int i4 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            Pair pair = (Pair) obj2;
            this.f25733IXxxXO.setColor(((Number) pair.getFirst()).intValue());
            RectF rectF3 = new RectF((RectF) pair.getSecond());
            if (i != 0 && i != size - 1) {
                canvas.drawRect(rectF3, this.f25733IXxxXO);
            } else {
                float f2 = this.f25736OxxIIOOXO;
                canvas.drawRoundRect(rectF3, f2, f2, this.f25733IXxxXO);
                if (size > 1) {
                    if (i == 0) {
                        canvas.drawRect(rectF3.left, rectF3.top, rectF3.right, rectF3.bottom - this.f25736OxxIIOOXO, this.f25733IXxxXO);
                    } else if (i == size - 1) {
                        canvas.drawRect(rectF3.left, rectF3.top + this.f25736OxxIIOOXO, rectF3.right, rectF3.bottom, this.f25733IXxxXO);
                    }
                }
            }
            i = i4;
        }
    }

    public final void setSegments(@OOXIXo List<? extends oIX0oI> segments) {
        IIX0o.x0xO0oo(segments, "segments");
        this.f25737XO = segments;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @xoIox
    public VerticalSegmentedBarView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ VerticalSegmentedBarView(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public VerticalSegmentedBarView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.f25737XO = CollectionsKt__CollectionsKt.ooXIXxIX();
        this.f25734Oo = new LinkedHashSet();
        Paint paint = new Paint(1);
        this.f25733IXxxXO = paint;
        this.f25735Oxx0xo = new RectF();
        this.f25738oI0IIXIo = -16776961;
        this.f25736OxxIIOOXO = 20.0f;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.f25738oI0IIXIo);
    }
}
