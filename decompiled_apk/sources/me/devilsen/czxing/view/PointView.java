package me.devilsen.czxing.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import me.devilsen.czxing.R;
import oI00o.II0xO0;
import oI00o.oxoX;

/* loaded from: classes6.dex */
public class PointView extends View {

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final /* synthetic */ boolean f30858X0IIOO = false;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public int f30859IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public Paint f30860IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public boolean f30861O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public Paint f30862Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public Bitmap f30863OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f30864Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f30865OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public Context f30866XO;

    /* renamed from: o00, reason: collision with root package name */
    public int f30867o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f30868oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public int f30869xoXoI;

    public PointView(Context context) {
        this(context, null);
    }

    public final void I0Io(Context context) {
        this.f30866XO = context;
        this.f30865OxxIIOOXO = II0xO0.II0xO0(context, 15.0f);
        this.f30859IIXOooo = II0xO0.II0xO0(context, 12.0f);
        this.f30864Oxx0xo = context.getResources().getColor(R.color.czxing_point_green);
        this.f30868oI0IIXIo = context.getResources().getColor(R.color.czxing_point_white);
        Paint paint = new Paint(1);
        this.f30862Oo = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.f30862Oo.setColor(this.f30864Oxx0xo);
        Paint paint2 = new Paint(1);
        this.f30860IXxxXO = paint2;
        paint2.setStyle(style);
    }

    public final void II0xO0(Canvas canvas) {
        if (this.f30863OxI == null) {
            this.f30863OxI = oxoX.oxoX(getContext(), R.drawable.ic_baseline_arrow_forward_24);
        }
        canvas.drawBitmap(this.f30863OxI, this.f30869xoXoI - (this.f30863OxI.getWidth() / 2), this.f30867o00 - (this.f30863OxI.getHeight() / 2), this.f30860IXxxXO);
    }

    public void oIX0oI() {
        this.f30861O0xOxO = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.f30862Oo.setColor(this.f30868oI0IIXIo);
        canvas.drawCircle(this.f30869xoXoI, this.f30867o00, this.f30865OxxIIOOXO, this.f30862Oo);
        this.f30862Oo.setColor(this.f30864Oxx0xo);
        canvas.drawCircle(this.f30869xoXoI, this.f30867o00, this.f30859IIXOooo, this.f30862Oo);
        if (this.f30861O0xOxO) {
            II0xO0(canvas);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.f30869xoXoI = (i3 - i) / 2;
            this.f30867o00 = (i4 - i2) / 2;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f30865OxxIIOOXO * 2, 1073741824);
        setMeasuredDimension(makeMeasureSpec, makeMeasureSpec);
    }

    public void setColor(@ColorRes int i) {
        this.f30864Oxx0xo = this.f30866XO.getResources().getColor(i);
    }

    public PointView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PointView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f30865OxxIIOOXO = 15;
        this.f30859IIXOooo = 12;
        I0Io(context);
    }
}
