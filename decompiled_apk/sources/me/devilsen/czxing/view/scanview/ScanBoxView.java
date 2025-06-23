package me.devilsen.czxing.view.scanview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import java.util.List;
import me.devilsen.czxing.R;
import oI00o.oxoX;

/* loaded from: classes6.dex */
public class ScanBoxView extends View {

    /* renamed from: IoOoo, reason: collision with root package name */
    public static final int f30888IoOoo = 1;

    /* renamed from: OO, reason: collision with root package name */
    public static final int f30889OO = 0;

    /* renamed from: I0X0x0oIo, reason: collision with root package name */
    public int f30890I0X0x0oIo;

    /* renamed from: I0oOIX, reason: collision with root package name */
    public String f30891I0oOIX;

    /* renamed from: I0oOoX, reason: collision with root package name */
    public int f30892I0oOoX;

    /* renamed from: IIX0o, reason: collision with root package name */
    public int f30893IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public Rect f30894IIXOooo;

    /* renamed from: IO, reason: collision with root package name */
    public float f30895IO;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public Paint f30896IXxxXO;

    /* renamed from: Io, reason: collision with root package name */
    public boolean f30897Io;

    /* renamed from: IoOoX, reason: collision with root package name */
    public float f30898IoOoX;

    /* renamed from: O0Xx, reason: collision with root package name */
    public String f30899O0Xx;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public int f30900O0xOxO;

    /* renamed from: OI0, reason: collision with root package name */
    public I0Io f30901OI0;

    /* renamed from: Oo, reason: collision with root package name */
    public final int f30902Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public int f30903OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public Paint f30904Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public Rect f30905OxxIIOOXO;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public LinearGradient f30906X00IoxXI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public int f30907X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public int f30908XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public int f30909XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public final int f30910XO;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public int f30911XOxIOxOx;

    /* renamed from: XX, reason: collision with root package name */
    public boolean f30912XX;

    /* renamed from: XX0, reason: collision with root package name */
    public int f30913XX0;

    /* renamed from: Xo0, reason: collision with root package name */
    public int f30914Xo0;

    /* renamed from: XoI0Ixx0, reason: collision with root package name */
    public boolean f30915XoI0Ixx0;

    /* renamed from: XoX, reason: collision with root package name */
    public int f30916XoX;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public int f30917Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public int f30918XxX0x0xxx;

    /* renamed from: o0, reason: collision with root package name */
    public boolean f30919o0;

    /* renamed from: o00, reason: collision with root package name */
    public Canvas f30920o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public Paint f30921oI0IIXIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public int f30922oOXoIIIo;

    /* renamed from: oX, reason: collision with root package name */
    public int f30923oX;

    /* renamed from: oo, reason: collision with root package name */
    public int f30924oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f30925oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public float f30926ooXIXxIX;

    /* renamed from: oxXx0IX, reason: collision with root package name */
    public int f30927oxXx0IX;

    /* renamed from: oxxXoxO, reason: collision with root package name */
    public int f30928oxxXoxO;

    /* renamed from: x0o, reason: collision with root package name */
    public int f30929x0o;

    /* renamed from: xI, reason: collision with root package name */
    public int f30930xI;

    /* renamed from: xII, reason: collision with root package name */
    public ValueAnimator f30931xII;

    /* renamed from: xXOx, reason: collision with root package name */
    public Bitmap f30932xXOx;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public int f30933xXxxox0I;

    /* renamed from: xo0x, reason: collision with root package name */
    public Bitmap f30934xo0x;

    /* renamed from: xoXoI, reason: collision with root package name */
    public Rect f30935xoXoI;

    /* renamed from: xoxXI, reason: collision with root package name */
    public String f30936xoxXI;

    /* renamed from: xxX, reason: collision with root package name */
    public int f30937xxX;

    /* loaded from: classes6.dex */
    public interface I0Io {
        void oIX0oI();
    }

    /* loaded from: classes6.dex */
    public class II0xO0 implements ValueAnimator.AnimatorUpdateListener {
        public II0xO0() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ScanBoxView.this.f30895IO = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ScanBoxView.this.postInvalidateOnAnimation();
        }
    }

    /* loaded from: classes6.dex */
    public class oIX0oI implements ValueAnimator.AnimatorUpdateListener {
        public oIX0oI() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ScanBoxView.this.f30895IO = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ScanBoxView.this.postInvalidateOnAnimation();
        }
    }

    public ScanBoxView(Context context) {
        this(context, null);
    }

    public final void I0Io(int i, int i2) {
        int i3 = this.f30933xXxxox0I;
        this.f30922oOXoIIIo = (i - i3) / 2;
        int i4 = ((i2 - this.f30893IIX0o) / 2) + this.f30908XI0IXoo;
        this.f30917Xx000oIo = i4;
        if (i4 < 0) {
            i4 = 0;
        }
        this.f30917Xx000oIo = i4;
        this.f30918XxX0x0xxx = i3;
        int i5 = this.f30922oOXoIIIo;
        int i6 = this.f30917Xx000oIo;
        this.f30905OxxIIOOXO = new Rect(i5, i6, this.f30933xXxxox0I + i5, this.f30893IIX0o + i6);
    }

    public final void II0XooXoX(Canvas canvas) {
        if (this.f30912XX) {
            Bitmap bitmap = this.f30934xo0x;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, this.f30913XX0, this.f30890I0X0x0oIo, this.f30896IXxxXO);
                return;
            }
            return;
        }
        Bitmap bitmap2 = this.f30932xXOx;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, this.f30913XX0, this.f30890I0X0x0oIo, this.f30896IXxxXO);
        }
    }

    public final void II0xO0() {
        if (this.f30905OxxIIOOXO != null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int min = Math.min(height, width);
        if (this.f30918XxX0x0xxx != 0) {
            oxoX(width, height, min);
        } else if (this.f30933xXxxox0I != 0 && this.f30893IIX0o != 0) {
            I0Io(width, height);
        } else {
            oxoX(width, height, min);
        }
    }

    public void IIXOooo() {
        this.f30897Io = false;
        this.f30912XX = false;
    }

    public void IXxxXO(int i, int i2) {
        if (i2 >= 0 && i >= 0) {
            this.f30893IIX0o = i2;
            this.f30933xXxxox0I = i;
            oI00o.II0xO0.oIX0oI("border size: height = " + i2 + " width = " + i);
        }
    }

    public final void OOXIXo(Canvas canvas) {
        if (this.f30906X00IoxXI == null) {
            if (this.f30927oxXx0IX == 0) {
                int i = this.f30922oOXoIIIo;
                float f = i;
                int i2 = this.f30917Xx000oIo;
                float f2 = i2;
                float f3 = i + this.f30933xXxxox0I;
                float f4 = i2;
                int i3 = this.f30892I0oOoX;
                int i4 = this.f30928oxxXoxO;
                this.f30906X00IoxXI = new LinearGradient(f, f2, f3, f4, new int[]{i3, i4, this.f30916XoX, i4, i3}, (float[]) null, Shader.TileMode.CLAMP);
            } else {
                int i5 = this.f30922oOXoIIIo;
                float f5 = i5;
                int i6 = this.f30917Xx000oIo;
                float f6 = i6;
                float f7 = i5;
                float f8 = i6 + this.f30893IIX0o;
                int i7 = this.f30892I0oOoX;
                int i8 = this.f30928oxxXoxO;
                this.f30906X00IoxXI = new LinearGradient(f5, f6, f7, f8, new int[]{i7, i8, this.f30916XoX, i8, i7}, (float[]) null, Shader.TileMode.CLAMP);
            }
            this.f30921oI0IIXIo.setShader(this.f30906X00IoxXI);
        }
        if (this.f30927oxXx0IX == 0) {
            int i9 = this.f30922oOXoIIIo;
            int i10 = this.f30917Xx000oIo;
            float f9 = this.f30895IO;
            canvas.drawRect(i9, i10 + f9, i9 + this.f30933xXxxox0I, i10 + f9 + this.f30902Oo, this.f30921oI0IIXIo);
            return;
        }
        int i11 = this.f30922oOXoIIIo;
        float f10 = this.f30895IO;
        canvas.drawRect(i11 + f10, this.f30917Xx000oIo, i11 + f10 + this.f30902Oo, r2 + this.f30893IIX0o, this.f30921oI0IIXIo);
    }

    public void Oo() {
        ValueAnimator valueAnimator = this.f30931xII;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
        }
    }

    public final void Oxx0IOOO(Canvas canvas) {
        if (this.f30915XoI0Ixx0) {
            return;
        }
        if (this.f30932xXOx == null) {
            this.f30932xXOx = oxoX.oxoX(getContext(), R.drawable.ic_highlight_close_24dp);
        }
        if (this.f30934xo0x == null) {
            this.f30934xo0x = oxoX.oxoX(getContext(), R.drawable.ic_highlight_open_24dp);
        }
        if (this.f30913XX0 == 0 && this.f30932xXOx != null) {
            Rect rect = this.f30905OxxIIOOXO;
            int width = rect.left + ((rect.width() - this.f30932xXOx.getWidth()) >> 1);
            this.f30913XX0 = width;
            this.f30890I0X0x0oIo = this.f30905OxxIIOOXO.bottom - (this.f30929x0o << 2);
            this.f30923oX = width + this.f30932xXOx.getWidth();
            this.f30914Xo0 = this.f30890I0X0x0oIo + this.f30932xXOx.getHeight();
        }
        II0XooXoX(canvas);
    }

    public void Oxx0xo() {
        this.f30927oxXx0IX = 1;
    }

    public void OxxIIOOXO() {
        ValueAnimator valueAnimator = this.f30931xII;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f30931xII.cancel();
        }
    }

    public final void X0o0xo(Canvas canvas) {
        this.f30896IXxxXO.setStyle(Paint.Style.STROKE);
        this.f30896IXxxXO.setColor(this.f30937xxX);
        this.f30896IXxxXO.setStrokeWidth(this.f30926ooXIXxIX);
        canvas.drawRect(this.f30905OxxIIOOXO, this.f30896IXxxXO);
    }

    public final void XO(Canvas canvas) {
        if (this.f30898IoOoX <= 0.0f) {
            return;
        }
        this.f30896IXxxXO.setStyle(Paint.Style.STROKE);
        this.f30896IXxxXO.setColor(this.f30930xI);
        this.f30896IXxxXO.setStrokeWidth(this.f30924oo);
        Rect rect = this.f30905OxxIIOOXO;
        int i = rect.left;
        float f = this.f30898IoOoX;
        int i2 = rect.top;
        canvas.drawLine(i - f, i2, (i - f) + this.f30925oo0xXOI0I, i2, this.f30896IXxxXO);
        Rect rect2 = this.f30905OxxIIOOXO;
        int i3 = rect2.left;
        int i4 = rect2.top;
        float f2 = this.f30898IoOoX;
        canvas.drawLine(i3, i4 - f2, i3, (i4 - f2) + this.f30925oo0xXOI0I, this.f30896IXxxXO);
        Rect rect3 = this.f30905OxxIIOOXO;
        int i5 = rect3.right;
        float f3 = this.f30898IoOoX;
        int i6 = rect3.top;
        canvas.drawLine(i5 + f3, i6, (i5 + f3) - this.f30925oo0xXOI0I, i6, this.f30896IXxxXO);
        Rect rect4 = this.f30905OxxIIOOXO;
        int i7 = rect4.right;
        int i8 = rect4.top;
        float f4 = this.f30898IoOoX;
        canvas.drawLine(i7, i8 - f4, i7, (i8 - f4) + this.f30925oo0xXOI0I, this.f30896IXxxXO);
        Rect rect5 = this.f30905OxxIIOOXO;
        int i9 = rect5.left;
        float f5 = this.f30898IoOoX;
        int i10 = rect5.bottom;
        canvas.drawLine(i9 - f5, i10, (i9 - f5) + this.f30925oo0xXOI0I, i10, this.f30896IXxxXO);
        Rect rect6 = this.f30905OxxIIOOXO;
        int i11 = rect6.left;
        int i12 = rect6.bottom;
        float f6 = this.f30898IoOoX;
        canvas.drawLine(i11, i12 + f6, i11, (i12 + f6) - this.f30925oo0xXOI0I, this.f30896IXxxXO);
        Rect rect7 = this.f30905OxxIIOOXO;
        int i13 = rect7.right;
        float f7 = this.f30898IoOoX;
        int i14 = rect7.bottom;
        canvas.drawLine(i13 + f7, i14, (i13 + f7) - this.f30925oo0xXOI0I, i14, this.f30896IXxxXO);
        Rect rect8 = this.f30905OxxIIOOXO;
        int i15 = rect8.right;
        int i16 = rect8.bottom;
        float f8 = this.f30898IoOoX;
        canvas.drawLine(i15, i16 + f8, i15, (i16 + f8) - this.f30925oo0xXOI0I, this.f30896IXxxXO);
    }

    public int getExpandTop() {
        return this.f30909XIxXXX0x0;
    }

    public Point getScanBoxCenter() {
        return new Point(this.f30922oOXoIIIo + (this.f30933xXxxox0I >> 1), this.f30917Xx000oIo + (this.f30893IIX0o >> 1));
    }

    public int getScanBoxHeightExpand() {
        return this.f30893IIX0o + this.f30909XIxXXX0x0;
    }

    public Rect getScanBoxRect() {
        return this.f30905OxxIIOOXO;
    }

    public int getScanBoxSize() {
        return this.f30918XxX0x0xxx;
    }

    public int getScanBoxSizeExpand() {
        return this.f30918XxX0x0xxx + this.f30909XIxXXX0x0;
    }

    public int getScanBoxWidthExpand() {
        return this.f30933xXxxox0I + this.f30909XIxXXX0x0;
    }

    public void oI0IIXIo() {
        ValueAnimator valueAnimator = this.f30931xII;
        if (valueAnimator != null && !valueAnimator.isRunning()) {
            this.f30931xII.start();
        }
    }

    public void oO() {
        this.f30915XoI0Ixx0 = true;
    }

    public final void oOoXoXO(Canvas canvas) {
        String str;
        this.f30904Oxx0xo.setTextSize(this.f30929x0o);
        this.f30904Oxx0xo.setColor(this.f30900O0xOxO);
        if (!this.f30915XoI0Ixx0 && (this.f30897Io || this.f30912XX)) {
            if (this.f30912XX) {
                str = this.f30891I0oOIX;
            } else {
                str = this.f30899O0Xx;
            }
            Rect rect = this.f30905OxxIIOOXO;
            canvas.drawText(str, rect.left + (this.f30933xXxxox0I >> 1), rect.bottom - this.f30929x0o, this.f30904Oxx0xo);
            Oxx0IOOO(canvas);
        }
        String str2 = this.f30936xoxXI;
        Rect rect2 = this.f30905OxxIIOOXO;
        canvas.drawText(str2, rect2.left + (this.f30933xXxxox0I >> 1), rect2.bottom + (this.f30929x0o * 2), this.f30904Oxx0xo);
        if (!this.f30919o0) {
            return;
        }
        this.f30904Oxx0xo.setTextSize(this.f30911XOxIOxOx);
        this.f30904Oxx0xo.setColor(this.f30907X0IIOO);
        Rect rect3 = this.f30905OxxIIOOXO;
        canvas.drawText("我的名片", rect3.left + (this.f30933xXxxox0I >> 1), rect3.bottom + (this.f30929x0o * 6), this.f30904Oxx0xo);
        if (this.f30935xoXoI == null) {
            Rect rect4 = new Rect();
            this.f30935xoXoI = rect4;
            this.f30904Oxx0xo.getTextBounds("我的名片", 0, 3, rect4);
            int width = this.f30935xoXoI.width();
            int height = this.f30935xoXoI.height();
            Rect rect5 = this.f30935xoXoI;
            Rect rect6 = this.f30905OxxIIOOXO;
            int i = (rect6.left + (this.f30933xXxxox0I >> 1)) - 10;
            rect5.left = i;
            rect5.right = i + width + 10;
            int i2 = (rect6.bottom + (this.f30929x0o * 6)) - 10;
            rect5.top = i2;
            rect5.bottom = i2 + height + 10;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f30905OxxIIOOXO == null) {
            return;
        }
        this.f30920o00 = canvas;
        xoIox(canvas);
        X0o0xo(canvas);
        XO(canvas);
        OOXIXo(canvas);
        oOoXoXO(canvas);
        x0xO0oo();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        II0xO0();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (x > this.f30913XX0 && x < this.f30923oX && y > this.f30890I0X0x0oIo && y < this.f30914Xo0) {
                I0Io i0Io = this.f30901OI0;
                if (i0Io != null && (this.f30897Io || this.f30912XX)) {
                    i0Io.oIX0oI();
                    this.f30912XX = !this.f30912XX;
                    invalidate();
                }
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void ooOOo0oXI() {
        this.f30919o0 = false;
    }

    public final void oxoX(int i, int i2, int i3) {
        int i4 = this.f30918XxX0x0xxx;
        if (i4 == 0) {
            this.f30918XxX0x0xxx = Math.min((i3 * 3) / 5, this.f30910XO);
        } else if (i4 > i3) {
            this.f30918XxX0x0xxx = i3;
        }
        int i5 = this.f30918XxX0x0xxx;
        this.f30922oOXoIIIo = (i - i5) / 2;
        int i6 = ((i2 - i5) / 2) + this.f30908XI0IXoo;
        this.f30917Xx000oIo = i6;
        if (i6 < 0) {
            i6 = 0;
        }
        this.f30917Xx000oIo = i6;
        this.f30933xXxxox0I = i5;
        this.f30893IIX0o = i5;
        int i7 = this.f30922oOXoIIIo;
        int i8 = this.f30917Xx000oIo;
        int i9 = this.f30918XxX0x0xxx;
        this.f30905OxxIIOOXO = new Rect(i7, i8, i7 + i9, i9 + i8);
    }

    public void setBorderColor(int i) {
        if (i == 0) {
            return;
        }
        this.f30937xxX = i;
    }

    public void setBorderSize(int i) {
        if (i <= 0) {
            return;
        }
        this.f30918XxX0x0xxx = i;
    }

    public void setBorderStrokeWidth(int i) {
        if (i <= 0) {
            return;
        }
        this.f30926ooXIXxIX = i;
    }

    public void setBoxTopOffset(int i) {
        this.f30908XI0IXoo = i;
    }

    public void setCornerColor(int i) {
        if (i == 0) {
            return;
        }
        this.f30930xI = i;
    }

    public void setDark(boolean z) {
        if (this.f30897Io != z) {
            postInvalidate();
        }
        this.f30897Io = z;
    }

    public void setFlashLightOffDrawable(int i) {
        if (i == 0) {
            return;
        }
        this.f30932xXOx = oxoX.oxoX(getContext(), i);
    }

    public void setFlashLightOffText(String str) {
        if (str != null) {
            this.f30891I0oOIX = str;
        }
    }

    public void setFlashLightOnDrawable(int i) {
        if (i == 0) {
            return;
        }
        this.f30934xo0x = oxoX.oxoX(getContext(), i);
    }

    public void setFlashLightOnText(String str) {
        if (str != null) {
            this.f30899O0Xx = str;
        }
    }

    public void setMaskColor(int i) {
        if (i == 0) {
            return;
        }
        this.f30903OxI = i;
    }

    public void setScanBoxClickListener(I0Io i0Io) {
        this.f30901OI0 = i0Io;
    }

    public void setScanLineColor(List<Integer> list) {
        if (list != null && list.size() >= 3) {
            this.f30892I0oOoX = list.get(0).intValue();
            this.f30928oxxXoxO = list.get(1).intValue();
            this.f30916XoX = list.get(2).intValue();
            this.f30906X00IoxXI = null;
        }
    }

    public void setScanNoticeText(String str) {
        if (str != null) {
            this.f30936xoxXI = str;
        }
    }

    public final void x0XOIxOo() {
        Context context = getContext();
        Paint paint = new Paint();
        this.f30896IXxxXO = paint;
        paint.setAntiAlias(true);
        this.f30921oI0IIXIo = new Paint();
        Paint paint2 = new Paint();
        this.f30904Oxx0xo = paint2;
        paint2.setAntiAlias(true);
        Resources resources = getResources();
        this.f30903OxI = resources.getColor(R.color.czxing_line_mask);
        this.f30900O0xOxO = resources.getColor(R.color.czxing_text_normal);
        this.f30907X0IIOO = resources.getColor(R.color.czxing_text_big);
        this.f30892I0oOoX = resources.getColor(R.color.czxing_scan_1);
        this.f30928oxxXoxO = resources.getColor(R.color.czxing_scan_2);
        this.f30916XoX = resources.getColor(R.color.czxing_scan_3);
        this.f30908XI0IXoo = -oI00o.II0xO0.II0xO0(context, 10.0f);
        this.f30909XIxXXX0x0 = oI00o.II0xO0.II0xO0(context, 40.0f);
        this.f30937xxX = resources.getColor(R.color.czxing_line_border);
        this.f30926ooXIXxIX = oI00o.II0xO0.II0xO0(context, 0.5f);
        this.f30930xI = resources.getColor(R.color.czxing_line_corner);
        this.f30925oo0xXOI0I = oI00o.II0xO0.II0xO0(context, 20.0f);
        int II0xO02 = oI00o.II0xO0.II0xO0(context, 3.0f);
        this.f30924oo = II0xO02;
        this.f30898IoOoX = (II0xO02 * 1.0f) / 2.0f;
        this.f30929x0o = oI00o.II0xO0.II0XooXoX(context, 14.0f);
        this.f30911XOxIOxOx = oI00o.II0xO0.II0XooXoX(context, 17.0f);
        this.f30904Oxx0xo.setTextSize(this.f30929x0o);
        this.f30904Oxx0xo.setTextAlign(Paint.Align.CENTER);
        this.f30904Oxx0xo.setColor(-7829368);
        this.f30904Oxx0xo.setStyle(Paint.Style.FILL);
        this.f30899O0Xx = getResources().getText(R.string.czxing_click_open_flash_light).toString();
        this.f30891I0oOIX = getResources().getText(R.string.czxing_click_close_flash_light).toString();
        this.f30936xoxXI = getResources().getText(R.string.czxing_scan_notice).toString();
    }

    public final void x0xO0oo() {
        ValueAnimator valueAnimator = this.f30931xII;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return;
        }
        if (this.f30927oxXx0IX == 0) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, this.f30893IIX0o - (this.f30926ooXIXxIX * 2.0f));
            this.f30931xII = ofFloat;
            ofFloat.addUpdateListener(new oIX0oI());
        } else {
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, this.f30933xXxxox0I - (this.f30926ooXIXxIX * 2.0f));
            this.f30931xII = ofFloat2;
            ofFloat2.addUpdateListener(new II0xO0());
        }
        this.f30931xII.setDuration(2500L);
        this.f30931xII.setInterpolator(new LinearInterpolator());
        this.f30931xII.setRepeatCount(-1);
        this.f30931xII.start();
    }

    public final void xoIox(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.f30903OxI != 0) {
            this.f30896IXxxXO.setStyle(Paint.Style.FILL);
            this.f30896IXxxXO.setColor(this.f30903OxI);
            float f = width;
            canvas.drawRect(0.0f, 0.0f, f, this.f30905OxxIIOOXO.top, this.f30896IXxxXO);
            Rect rect = this.f30905OxxIIOOXO;
            canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.f30896IXxxXO);
            Rect rect2 = this.f30905OxxIIOOXO;
            canvas.drawRect(rect2.right + 1, rect2.top, f, rect2.bottom + 1, this.f30896IXxxXO);
            canvas.drawRect(0.0f, this.f30905OxxIIOOXO.bottom + 1, f, height, this.f30896IXxxXO);
        }
    }

    public void xxIXOIIO(int i, int i2, int i3, int i4) {
        Rect rect = this.f30894IIXOooo;
        if (rect == null) {
            this.f30894IIXOooo = new Rect(i, i2, i3, i4);
        } else if (i3 != 0 && i4 != 0) {
            rect.left = i;
            rect.top = i2;
            rect.right = i3;
            rect.bottom = i4;
            oI00o.II0xO0.oIX0oI("Focus location : left = " + i + " top = " + i2 + " right = " + i3 + " bottom = " + i4);
        }
        this.f30896IXxxXO.setStyle(Paint.Style.STROKE);
        this.f30896IXxxXO.setColor(this.f30937xxX);
        this.f30896IXxxXO.setStrokeWidth(this.f30926ooXIXxIX);
        this.f30920o00.drawRect(this.f30894IIXOooo, this.f30896IXxxXO);
    }

    public ScanBoxView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScanBoxView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f30910XO = oI00o.II0xO0.II0xO0(getContext(), 300.0f);
        this.f30902Oo = oI00o.II0xO0.II0xO0(getContext(), 1.5f);
        x0XOIxOo();
    }
}
