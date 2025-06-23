package com.sma.smartv3.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import com.blankj.utilcode.util.SizeUtils;
import com.sma.smartv3.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class SlideLockView extends ViewGroup {

    /* renamed from: IIX0o, reason: collision with root package name */
    public int f25209IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public Paint f25210IIXOooo;

    /* renamed from: IO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f25211IO;

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public SlideIcon f25212IXxxXO;

    /* renamed from: IoOoX, reason: collision with root package name */
    public int f25213IoOoX;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public int f25214O0xOxO;

    /* renamed from: OI0, reason: collision with root package name */
    @OXOo.OOXIXo
    public CustomizeTextView f25215OI0;

    /* renamed from: Oo, reason: collision with root package name */
    public final int f25216Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public int f25217OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f25218Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public II0xO0 f25219OxxIIOOXO;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public int f25220X00IoxXI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public String f25221X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public String f25222XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public int f25223XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public final int f25224XO;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    @OXOo.oOoXoXO
    public I0Io f25225XOxIOxOx;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public int f25226Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public int f25227XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    @OXOo.OOXIXo
    public Paint f25228o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f25229oI0IIXIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public int f25230oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public boolean f25231oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public boolean f25232oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public float f25233ooXIXxIX;

    /* renamed from: x0o, reason: collision with root package name */
    public int f25234x0o;

    /* renamed from: xI, reason: collision with root package name */
    public float f25235xI;

    /* renamed from: xII, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f25236xII;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    @OXOo.oOoXoXO
    public String f25237xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    @OXOo.OOXIXo
    public Paint f25238xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public float f25239xxX;

    /* loaded from: classes12.dex */
    public final class CustomizeTextView extends AppCompatTextView {

        @OXOo.oOoXoXO
        private LinearGradient mLinearGradient;

        @OXOo.oOoXoXO
        private Matrix mMatrix;

        @OXOo.oOoXoXO
        private Paint mPaint;
        private int mTranslate;
        private int mViewWith;
        final /* synthetic */ SlideLockView this$0;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @XO0OX.xoIox
        public CustomizeTextView(@OXOo.OOXIXo SlideLockView slideLockView, Context context) {
            this(slideLockView, context, null, 0, 6, null);
            IIX0o.x0xO0oo(context, "context");
        }

        @Override // android.widget.TextView, android.view.View
        public void onDraw(@OXOo.OOXIXo Canvas canvas) {
            IIX0o.x0xO0oo(canvas, "canvas");
            super.onDraw(canvas);
            Matrix matrix = this.mMatrix;
            if (matrix != null) {
                int i = this.mTranslate;
                int i2 = this.mViewWith;
                int i3 = i + (i2 / 14);
                this.mTranslate = i3;
                if (i3 > i2 * 2) {
                    this.mTranslate = -i2;
                }
                IIX0o.ooOOo0oXI(matrix);
                matrix.setTranslate(this.mTranslate, 0.0f);
                LinearGradient linearGradient = this.mLinearGradient;
                IIX0o.ooOOo0oXI(linearGradient);
                linearGradient.setLocalMatrix(this.mMatrix);
                postInvalidateDelayed(250L);
            }
        }

        @Override // android.view.View
        public void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            if (this.mViewWith == 0) {
                int measuredWidth = getMeasuredWidth();
                this.mViewWith = measuredWidth;
                if (measuredWidth > 0) {
                    this.mPaint = getPaint();
                    this.mLinearGradient = new LinearGradient(0.0f, 0.0f, this.mViewWith, 0.0f, new int[]{this.this$0.f25230oOXoIIIo, this.this$0.f25226Xx000oIo, this.this$0.f25220X00IoxXI}, (float[]) null, Shader.TileMode.MIRROR);
                    Paint paint = this.mPaint;
                    IIX0o.ooOOo0oXI(paint);
                    paint.setShader(this.mLinearGradient);
                    this.mMatrix = new Matrix();
                }
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @XO0OX.xoIox
        public CustomizeTextView(@OXOo.OOXIXo SlideLockView slideLockView, @OXOo.oOoXoXO Context context, AttributeSet attributeSet) {
            this(slideLockView, context, attributeSet, 0, 4, null);
            IIX0o.x0xO0oo(context, "context");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @XO0OX.xoIox
        public CustomizeTextView(@OXOo.OOXIXo SlideLockView slideLockView, @OXOo.oOoXoXO Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            IIX0o.x0xO0oo(context, "context");
            this.this$0 = slideLockView;
        }

        public /* synthetic */ CustomizeTextView(SlideLockView slideLockView, Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
            this(slideLockView, context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
        }
    }

    /* loaded from: classes12.dex */
    public interface I0Io {
        void oIX0oI();
    }

    /* loaded from: classes12.dex */
    public interface II0xO0 {
        void II0xO0(int i);

        void oIX0oI(int i);
    }

    /* loaded from: classes12.dex */
    public final class SlideIcon extends View {

        /* renamed from: IIXOooo, reason: collision with root package name */
        public float f25240IIXOooo;

        /* renamed from: IXxxXO, reason: collision with root package name */
        @OXOo.OOXIXo
        public Paint.FontMetrics f25241IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        @OXOo.OOXIXo
        public Paint f25242Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        @OXOo.oOoXoXO
        public II0xO0 f25243Oxx0xo;

        /* renamed from: OxxIIOOXO, reason: collision with root package name */
        public float f25244OxxIIOOXO;

        /* renamed from: XO, reason: collision with root package name */
        public boolean f25245XO;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public float f25246oI0IIXIo;

        /* renamed from: xoXoI, reason: collision with root package name */
        public final /* synthetic */ SlideLockView f25247xoXoI;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @XO0OX.xoIox
        public SlideIcon(@OXOo.OOXIXo SlideLockView slideLockView, Context context) {
            this(slideLockView, context, null, 0, 6, null);
            IIX0o.x0xO0oo(context, "context");
        }

        public final boolean getEnable() {
            return this.f25245XO;
        }

        public final void oIX0oI() {
            this.f25246oI0IIXIo = 0.0f;
            this.f25240IIXOooo = 0.0f;
            this.f25244OxxIIOOXO = 0.0f;
            this.f25245XO = true;
        }

        @Override // android.view.View
        public void onDraw(@OXOo.OOXIXo Canvas canvas) {
            IIX0o.x0xO0oo(canvas, "canvas");
            super.onDraw(canvas);
            float measuredHeight = getMeasuredHeight();
            Paint.FontMetrics fontMetrics = this.f25241IXxxXO;
            canvas.drawText(String.valueOf(this.f25247xoXoI.f25237xXxxox0I), getMeasuredWidth() / 2.0f, ((measuredHeight - fontMetrics.top) - fontMetrics.bottom) / 2, this.f25242Oo);
        }

        @Override // android.view.View
        public void onMeasure(int i, int i2) {
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int size2 = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode2 == Integer.MIN_VALUE) {
                if (this.f25247xoXoI.f25235xI == 0.0f) {
                    this.f25247xoXoI.f25235xI = r1.f25217OxI / size;
                }
                setMeasuredDimension(View.MeasureSpec.makeMeasureSpec((int) (size * this.f25247xoXoI.f25235xI), mode), View.MeasureSpec.makeMeasureSpec(this.f25247xoXoI.f25217OxI, mode2));
                return;
            }
            if (this.f25247xoXoI.f25235xI == 0.0f) {
                this.f25247xoXoI.f25235xI = size2 / size;
            }
            setMeasuredDimension(View.MeasureSpec.makeMeasureSpec((int) (size * this.f25247xoXoI.f25235xI), mode), View.MeasureSpec.makeMeasureSpec(size2, mode2));
        }

        @Override // android.view.View
        public boolean onTouchEvent(@OXOo.OOXIXo MotionEvent event) {
            IIX0o.x0xO0oo(event, "event");
            if (!this.f25245XO) {
                return true;
            }
            int action = event.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        return false;
                    }
                    this.f25240IIXOooo = event.getRawX() - this.f25246oI0IIXIo;
                    II0xO0 iI0xO0 = this.f25243Oxx0xo;
                    if (iI0xO0 != null) {
                        IIX0o.ooOOo0oXI(iI0xO0);
                        iI0xO0.II0xO0((int) this.f25240IIXOooo);
                    }
                    return true;
                }
                this.f25246oI0IIXIo = 0.0f;
                this.f25244OxxIIOOXO += this.f25240IIXOooo;
                this.f25240IIXOooo = 0.0f;
                II0xO0 iI0xO02 = this.f25243Oxx0xo;
                if (iI0xO02 != null) {
                    IIX0o.ooOOo0oXI(iI0xO02);
                    iI0xO02.oIX0oI((int) this.f25244OxxIIOOXO);
                }
                return true;
            }
            this.f25246oI0IIXIo = event.getRawX();
            return true;
        }

        public final void setEnable(boolean z) {
            this.f25245XO = z;
        }

        public final void setListener(@OXOo.oOoXoXO II0xO0 iI0xO0) {
            this.f25243Oxx0xo = iI0xO0;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @XO0OX.xoIox
        public SlideIcon(@OXOo.OOXIXo SlideLockView slideLockView, @OXOo.oOoXoXO Context context, AttributeSet attributeSet) {
            this(slideLockView, context, attributeSet, 0, 4, null);
            IIX0o.x0xO0oo(context, "context");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @XO0OX.xoIox
        public SlideIcon(@OXOo.OOXIXo SlideLockView slideLockView, @OXOo.oOoXoXO Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            IIX0o.x0xO0oo(context, "context");
            this.f25247xoXoI = slideLockView;
            Paint paint = new Paint();
            this.f25242Oo = paint;
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            IIX0o.oO(fontMetrics, "getFontMetrics(...)");
            this.f25241IXxxXO = fontMetrics;
            this.f25242Oo.setTextAlign(Paint.Align.CENTER);
            this.f25242Oo.setColor(slideLockView.f25209IIX0o);
            this.f25242Oo.setTextSize(slideLockView.f25233ooXIXxIX);
            this.f25245XO = true;
        }

        public /* synthetic */ SlideIcon(SlideLockView slideLockView, Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
            this(slideLockView, context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements II0xO0 {
        public oIX0oI() {
        }

        @Override // com.sma.smartv3.view.SlideLockView.II0xO0
        public void II0xO0(int i) {
            SlideLockView.this.f25229oI0IIXIo = i;
            SlideLockView.this.requestLayout();
            SlideLockView.this.invalidate();
        }

        @Override // com.sma.smartv3.view.SlideLockView.II0xO0
        public void oIX0oI(int i) {
            SlideLockView.this.f25218Oxx0xo = i;
            SlideLockView.this.f25229oI0IIXIo = 0;
            if (SlideLockView.this.f25218Oxx0xo + SlideLockView.this.f25212IXxxXO.getMeasuredWidth() < SlideLockView.this.getMeasuredWidth()) {
                if (SlideLockView.this.f25232oo0xXOI0I) {
                    SlideLockView.this.f25218Oxx0xo = 0;
                    SlideLockView.this.f25212IXxxXO.oIX0oI();
                    SlideLockView.this.requestLayout();
                    SlideLockView.this.invalidate();
                    return;
                }
                return;
            }
            if (!SlideLockView.this.f25231oo) {
                SlideLockView.this.f25212IXxxXO.setEnable(false);
            }
            if (SlideLockView.this.f25225XOxIOxOx != null) {
                I0Io i0Io = SlideLockView.this.f25225XOxIOxOx;
                IIX0o.ooOOo0oXI(i0Io);
                i0Io.oIX0oI();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public SlideLockView(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public final boolean IIXOooo() {
        return this.f25232oo0xXOI0I;
    }

    public final float IXxxXO(int i) {
        return SizeUtils.dp2px(i);
    }

    public final void Oo(@OXOo.oOoXoXO I0Io i0Io) {
        this.f25225XOxIOxOx = i0Io;
    }

    public final void Oxx0xo(boolean z) {
        this.f25231oo = z;
    }

    public final boolean OxxIIOOXO() {
        return this.f25231oo;
    }

    public final void o00(boolean z) {
        this.f25232oo0xXOI0I = z;
    }

    public final void oI0IIXIo(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SlideLockView, 0, 0);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f25232oo0xXOI0I = obtainStyledAttributes.getBoolean(16, true);
        this.f25231oo = obtainStyledAttributes.getBoolean(6, false);
        this.f25214O0xOxO = obtainStyledAttributes.getResourceId(1, com.sma.smartv3.co_fit.R.drawable.shape_slide_lock_bg);
        this.f25227XxX0x0xxx = obtainStyledAttributes.getResourceId(10, com.sma.smartv3.co_fit.R.drawable.icon_screen_lock);
        this.f25217OxI = obtainStyledAttributes.getDimensionPixelSize(15, 240);
        this.f25237xXxxox0I = obtainStyledAttributes.getString(12);
        this.f25209IIX0o = obtainStyledAttributes.getColor(13, -1);
        this.f25233ooXIXxIX = obtainStyledAttributes.getDimensionPixelSize(14, 44);
        this.f25235xI = obtainStyledAttributes.getFloat(11, 0.0f);
        this.f25221X0IIOO = obtainStyledAttributes.getString(2);
        this.f25222XI0IXoo = obtainStyledAttributes.getString(4);
        this.f25223XIxXXX0x0 = obtainStyledAttributes.getColor(3, ViewCompat.MEASURED_STATE_MASK);
        this.f25239xxX = obtainStyledAttributes.getDimensionPixelSize(5, 44);
        this.f25213IoOoX = obtainStyledAttributes.getColor(17, 0);
        this.f25230oOXoIIIo = obtainStyledAttributes.getColor(7, -1);
        this.f25226Xx000oIo = obtainStyledAttributes.getColor(8, -1);
        this.f25220X00IoxXI = obtainStyledAttributes.getColor(9, -1);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onDraw(@OXOo.OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        super.onDraw(canvas);
        canvas.save();
        int i = this.f25218Oxx0xo + this.f25229oI0IIXIo;
        this.f25234x0o = i;
        if (i > 0) {
            if (i < this.f25212IXxxXO.getMeasuredWidth() / 2) {
                this.f25236xII.set(this.f25224XO, this.f25216Oo, this.f25212IXxxXO.getMeasuredWidth(), getMeasuredHeight() - this.f25216Oo);
            } else if (this.f25234x0o < getMeasuredWidth() - this.f25212IXxxXO.getMeasuredWidth()) {
                this.f25236xII.set(this.f25224XO, this.f25216Oo, this.f25234x0o + r1 + this.f25212IXxxXO.getMeasuredWidth(), getMeasuredHeight() - this.f25216Oo);
            } else {
                this.f25236xII.set(this.f25224XO, this.f25216Oo, getMeasuredWidth(), getMeasuredHeight() - this.f25216Oo);
            }
            canvas.drawRoundRect(this.f25236xII, getMeasuredHeight() / 2.0f, getMeasuredHeight() / 2.0f, this.f25228o00);
        }
        if (this.f25218Oxx0xo + this.f25229oI0IIXIo + this.f25212IXxxXO.getMeasuredWidth() >= getMeasuredWidth()) {
            this.f25215OI0.setText(this.f25222XI0IXoo);
        } else {
            this.f25215OI0.setText(this.f25221X0IIOO);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = this.f25218Oxx0xo;
        int i6 = this.f25229oI0IIXIo;
        if (i5 + i6 <= 0) {
            SlideIcon slideIcon = this.f25212IXxxXO;
            int i7 = this.f25224XO;
            slideIcon.layout(i7, this.f25216Oo, slideIcon.getMeasuredWidth() + i7, this.f25212IXxxXO.getMeasuredHeight() - this.f25216Oo);
        } else if (i5 + i6 + this.f25212IXxxXO.getMeasuredWidth() >= getMeasuredWidth()) {
            this.f25212IXxxXO.layout((getMeasuredWidth() - this.f25212IXxxXO.getMeasuredWidth()) - this.f25224XO, this.f25216Oo, getMeasuredWidth() - this.f25224XO, this.f25212IXxxXO.getMeasuredHeight() - this.f25216Oo);
        } else {
            SlideIcon slideIcon2 = this.f25212IXxxXO;
            int i8 = this.f25218Oxx0xo;
            int i9 = this.f25229oI0IIXIo;
            slideIcon2.layout(i8 + i9 + this.f25224XO, this.f25216Oo, i8 + i9 + slideIcon2.getMeasuredWidth() + this.f25224XO, this.f25212IXxxXO.getMeasuredHeight() - this.f25216Oo);
        }
        this.f25215OI0.layout((getMeasuredWidth() / 2) - (this.f25215OI0.getMeasuredWidth() / 2), (getMeasuredHeight() / 2) - (this.f25215OI0.getMeasuredHeight() / 2), (getMeasuredWidth() / 2) + (this.f25215OI0.getMeasuredWidth() / 2), (getMeasuredHeight() / 2) + (this.f25215OI0.getMeasuredHeight() / 2));
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        measureChildren(i, i2);
        View childAt = getChildAt(0);
        IIX0o.x0XOIxOo(childAt, "null cannot be cast to non-null type com.sma.smartv3.view.SlideLockView.CustomizeTextView");
        this.f25215OI0 = (CustomizeTextView) childAt;
        View childAt2 = getChildAt(1);
        IIX0o.x0XOIxOo(childAt2, "null cannot be cast to non-null type com.sma.smartv3.view.SlideLockView.SlideIcon");
        SlideIcon slideIcon = (SlideIcon) childAt2;
        this.f25212IXxxXO = slideIcon;
        setMeasuredDimension(i, slideIcon.getMeasuredHeight());
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f25211IO.set(this.f25224XO, this.f25216Oo, getMeasuredWidth(), getMeasuredHeight());
    }

    public final void xoXoI() {
        this.f25218Oxx0xo = 0;
        this.f25229oI0IIXIo = 0;
        this.f25212IXxxXO.oIX0oI();
        requestLayout();
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public SlideLockView(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ SlideLockView(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public SlideLockView(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.f25212IXxxXO = new SlideIcon(this, context, null, 0, 6, null);
        this.f25210IIXOooo = new Paint();
        this.f25238xoXoI = new Paint();
        this.f25228o00 = new Paint();
        this.f25221X0IIOO = "";
        this.f25222XI0IXoo = "";
        this.f25237xXxxox0I = "";
        this.f25211IO = new RectF();
        this.f25236xII = new RectF();
        this.f25215OI0 = new CustomizeTextView(this, context, null, 0, 6, null);
        oI0IIXIo(context, attributeSet);
        this.f25228o00.setColor(this.f25213IoOoX);
        setBackgroundResource(this.f25214O0xOxO);
        setWillNotDraw(false);
        this.f25215OI0.setText(this.f25221X0IIOO);
        this.f25215OI0.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f25215OI0.setGravity(17);
        this.f25215OI0.setTextColor(-1);
        this.f25215OI0.setTextSize(this.f25239xxX);
        addView(this.f25215OI0);
        this.f25212IXxxXO.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f25212IXxxXO.setBackgroundResource(this.f25227XxX0x0xxx);
        this.f25212IXxxXO.setListener(new oIX0oI());
        addView(this.f25212IXxxXO);
    }
}
