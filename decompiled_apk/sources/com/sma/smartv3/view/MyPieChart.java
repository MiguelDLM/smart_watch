package com.sma.smartv3.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.co_fit.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nMyPieChart.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyPieChart.kt\ncom/sma/smartv3/view/MyPieChart\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,101:1\n1855#2,2:102\n*S KotlinDebug\n*F\n+ 1 MyPieChart.kt\ncom/sma/smartv3/view/MyPieChart\n*L\n82#1:102,2\n*E\n"})
/* loaded from: classes12.dex */
public final class MyPieChart extends View {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f25077IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ArrayList<oIX0oI> f25078Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f25079Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Paint f25080XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public RectF f25081oI0IIXIo;

    /* loaded from: classes12.dex */
    public static final class oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        public float f25082I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public int f25083II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public long f25084oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public float f25085oxoX;

        public oIX0oI(long j, int i, float f, float f2) {
            this.f25084oIX0oI = j;
            this.f25083II0xO0 = i;
            this.f25082I0Io = f;
            this.f25085oxoX = f2;
        }

        public static /* synthetic */ oIX0oI XO(oIX0oI oix0oi, long j, int i, float f, float f2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = oix0oi.f25084oIX0oI;
            }
            long j2 = j;
            if ((i2 & 2) != 0) {
                i = oix0oi.f25083II0xO0;
            }
            int i3 = i;
            if ((i2 & 4) != 0) {
                f = oix0oi.f25082I0Io;
            }
            float f3 = f;
            if ((i2 & 8) != 0) {
                f2 = oix0oi.f25085oxoX;
            }
            return oix0oi.X0o0xo(j2, i3, f3, f2);
        }

        public final float I0Io() {
            return this.f25082I0Io;
        }

        public final int II0XooXoX() {
            return this.f25083II0xO0;
        }

        public final int II0xO0() {
            return this.f25083II0xO0;
        }

        public final void OOXIXo(float f) {
            this.f25085oxoX = f;
        }

        public final float Oxx0IOOO() {
            return this.f25085oxoX;
        }

        @OXOo.OOXIXo
        public final oIX0oI X0o0xo(long j, int i, float f, float f2) {
            return new oIX0oI(j, i, f, f2);
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof oIX0oI)) {
                return false;
            }
            oIX0oI oix0oi = (oIX0oI) obj;
            return this.f25084oIX0oI == oix0oi.f25084oIX0oI && this.f25083II0xO0 == oix0oi.f25083II0xO0 && Float.compare(this.f25082I0Io, oix0oi.f25082I0Io) == 0 && Float.compare(this.f25085oxoX, oix0oi.f25085oxoX) == 0;
        }

        public int hashCode() {
            return (((((androidx.collection.oIX0oI.oIX0oI(this.f25084oIX0oI) * 31) + this.f25083II0xO0) * 31) + Float.floatToIntBits(this.f25082I0Io)) * 31) + Float.floatToIntBits(this.f25085oxoX);
        }

        public final long oIX0oI() {
            return this.f25084oIX0oI;
        }

        public final void oOoXoXO(int i) {
            this.f25083II0xO0 = i;
        }

        public final void ooOOo0oXI(float f) {
            this.f25082I0Io = f;
        }

        public final float oxoX() {
            return this.f25085oxoX;
        }

        @OXOo.OOXIXo
        public String toString() {
            return "PieChartViewData(value=" + this.f25084oIX0oI + ", color=" + this.f25083II0xO0 + ", percentage=" + this.f25082I0Io + ", angle=" + this.f25085oxoX + HexStringBuilder.COMMENT_END_CHAR;
        }

        public final void x0XOIxOo(long j) {
            this.f25084oIX0oI = j;
        }

        public final long xoIox() {
            return this.f25084oIX0oI;
        }

        public final float xxIXOIIO() {
            return this.f25082I0Io;
        }

        public /* synthetic */ oIX0oI(long j, int i, float f, float f2, int i2, IIXOooo iIXOooo) {
            this(j, (i2 & 2) != 0 ? -16711936 : i, (i2 & 4) != 0 ? 0.0f : f, (i2 & 8) != 0 ? 0.0f : f2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public MyPieChart(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public final void oIX0oI(@OXOo.OOXIXo ArrayList<oIX0oI> datas) {
        IIX0o.x0xO0oo(datas, "datas");
        if (datas.size() == 0) {
            invalidate();
            return;
        }
        int size = datas.size();
        float f = 0.0f;
        for (int i = 0; i < size; i++) {
            oIX0oI oix0oi = datas.get(i);
            IIX0o.oO(oix0oi, "get(...)");
            f += (float) oix0oi.xoIox();
        }
        if (f == 0.0f) {
            for (oIX0oI oix0oi2 : datas) {
                oix0oi2.x0XOIxOo(1L);
                f += (float) oix0oi2.xoIox();
            }
        }
        Iterator<oIX0oI> it = datas.iterator();
        while (it.hasNext()) {
            oIX0oI next = it.next();
            float xoIox2 = ((float) next.xoIox()) / f;
            next.ooOOo0oXI(xoIox2);
            next.OOXIXo(360 * xoIox2);
        }
        this.f25078Oo.clear();
        this.f25078Oo.addAll(datas);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(@OXOo.OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        super.onDraw(canvas);
        canvas.translate(this.f25077IXxxXO / 2.0f, this.f25079Oxx0xo / 2.0f);
        float min = Math.min(this.f25077IXxxXO, this.f25079Oxx0xo) / 4;
        float f = 2;
        float size = (min / this.f25078Oo.size()) / f;
        int size2 = this.f25078Oo.size();
        float f2 = 100.0f;
        for (int i = 0; i < size2; i++) {
            oIX0oI oix0oi = this.f25078Oo.get(i);
            IIX0o.oO(oix0oi, "get(...)");
            oIX0oI oix0oi2 = oix0oi;
            Paint paint = this.f25080XO;
            if (paint != null) {
                paint.setColor(oix0oi2.II0XooXoX());
            }
            RectF rectF = this.f25081oI0IIXIo;
            if (rectF != null) {
                float f3 = i * size;
                float f4 = ((-min) * f) + f3;
                float f5 = (min * f) - f3;
                rectF.set(f4, f4, f5, f5);
            }
            RectF rectF2 = this.f25081oI0IIXIo;
            IIX0o.ooOOo0oXI(rectF2);
            float f6 = -oix0oi2.Oxx0IOOO();
            Paint paint2 = this.f25080XO;
            IIX0o.ooOOo0oXI(paint2);
            canvas.drawArc(rectF2, 360 - f2, f6, true, paint2);
            f2 += oix0oi2.Oxx0IOOO();
        }
        Paint paint3 = this.f25080XO;
        if (paint3 != null) {
            paint3.setColor(oIxOXo.oxoX.I0Io(getContext(), R.color.view_page_secondary_bg));
        }
        RectF rectF3 = this.f25081oI0IIXIo;
        if (rectF3 != null) {
            float f7 = (-min) - 15.0f;
            float f8 = min - (-15.0f);
            rectF3.set(f7, f7, f8, f8);
        }
        RectF rectF4 = this.f25081oI0IIXIo;
        IIX0o.ooOOo0oXI(rectF4);
        Paint paint4 = this.f25080XO;
        IIX0o.ooOOo0oXI(paint4);
        canvas.drawArc(rectF4, 0.0f, 360.0f, true, paint4);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f25077IXxxXO = i;
        this.f25079Oxx0xo = i2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public MyPieChart(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ MyPieChart(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public MyPieChart(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        ArrayList<oIX0oI> arrayList = new ArrayList<>();
        this.f25078Oo = arrayList;
        Paint paint = new Paint();
        this.f25080XO = paint;
        paint.setColor(-1);
        Paint paint2 = this.f25080XO;
        if (paint2 != null) {
            paint2.setStyle(Paint.Style.FILL);
        }
        Paint paint3 = this.f25080XO;
        if (paint3 != null) {
            paint3.setTextSize(30.0f);
        }
        this.f25081oI0IIXIo = new RectF();
        arrayList.add(new oIX0oI(1L, getResources().getColor(R.color.hr_scope_color_4), 0.0f, 0.0f, 12, null));
    }
}
