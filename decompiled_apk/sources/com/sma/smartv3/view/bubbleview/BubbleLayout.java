package com.sma.smartv3.view.bubbleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.sma.smartv3.R;

/* loaded from: classes12.dex */
public class BubbleLayout extends FrameLayout {

    /* renamed from: OxI, reason: collision with root package name */
    public static float f25439OxI = -1.0f;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public int f25440IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public float f25441IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public OxO.oIX0oI f25442Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public float f25443Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public float f25444OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public ArrowDirection f25445XO;

    /* renamed from: o00, reason: collision with root package name */
    public int f25446o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public float f25447oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public float f25448xoXoI;

    /* loaded from: classes12.dex */
    public static /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f25449oIX0oI;

        static {
            int[] iArr = new int[ArrowDirection.values().length];
            f25449oIX0oI = iArr;
            try {
                iArr[ArrowDirection.LEFT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25449oIX0oI[ArrowDirection.RIGHT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25449oIX0oI[ArrowDirection.TOP_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25449oIX0oI[ArrowDirection.BOTTOM_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25449oIX0oI[ArrowDirection.TOP_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25449oIX0oI[ArrowDirection.BOTTOM_RIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25449oIX0oI[ArrowDirection.LEFT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f25449oIX0oI[ArrowDirection.RIGHT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f25449oIX0oI[ArrowDirection.TOP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f25449oIX0oI[ArrowDirection.BOTTOM.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public BubbleLayout(Context context) {
        this(context, null, 0);
    }

    public static float oIX0oI(float dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().densityDpi / 160);
    }

    public final void I0Io() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (oIX0oI.f25449oIX0oI[this.f25445XO.ordinal()]) {
            case 1:
            case 7:
                paddingLeft = (int) (paddingLeft + this.f25441IXxxXO);
                break;
            case 2:
            case 8:
                paddingRight = (int) (paddingRight + this.f25441IXxxXO);
                break;
            case 3:
            case 5:
            case 9:
                paddingTop = (int) (paddingTop + this.f25447oI0IIXIo);
                break;
            case 4:
            case 6:
            case 10:
                paddingBottom = (int) (paddingBottom + this.f25447oI0IIXIo);
                break;
        }
        float f = this.f25448xoXoI;
        if (f > 0.0f) {
            paddingLeft = (int) (paddingLeft + f);
            paddingRight = (int) (paddingRight + f);
            paddingTop = (int) (paddingTop + f);
            paddingBottom = (int) (paddingBottom + f);
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public BubbleLayout II0XooXoX(float arrowWidth) {
        oxoX();
        this.f25441IXxxXO = arrowWidth;
        I0Io();
        return this;
    }

    public final void II0xO0(int left, int right, int top, int bottom) {
        float f;
        float f2;
        float f3;
        if (right >= left && bottom >= top) {
            float f4 = right;
            RectF rectF = new RectF(left, top, f4, bottom);
            float f5 = this.f25444OxxIIOOXO;
            switch (oIX0oI.f25449oIX0oI[this.f25445XO.ordinal()]) {
                case 1:
                case 2:
                    f = (bottom - top) / 2.0f;
                    f2 = this.f25447oI0IIXIo;
                    f3 = f - (f2 / 2.0f);
                    break;
                case 3:
                case 4:
                    f = (right - left) / 2.0f;
                    f2 = this.f25441IXxxXO;
                    f3 = f - (f2 / 2.0f);
                    break;
                case 5:
                case 6:
                    f3 = (f4 - this.f25444OxxIIOOXO) - (this.f25441IXxxXO / 2.0f);
                    break;
                default:
                    f3 = f5;
                    break;
            }
            this.f25442Oo = new OxO.oIX0oI(rectF, this.f25441IXxxXO, this.f25443Oxx0xo, this.f25447oI0IIXIo, f3, this.f25448xoXoI, this.f25446o00, this.f25440IIXOooo, this.f25445XO);
        }
    }

    public BubbleLayout OOXIXo(int strokeColor) {
        this.f25446o00 = strokeColor;
        requestLayout();
        return this;
    }

    public BubbleLayout Oxx0IOOO(float arrowPosition) {
        oxoX();
        this.f25444OxxIIOOXO = arrowPosition;
        I0Io();
        return this;
    }

    public BubbleLayout X0o0xo(ArrowDirection arrowDirection) {
        oxoX();
        this.f25445XO = arrowDirection;
        I0Io();
        return this;
    }

    public BubbleLayout XO(float arrowHeight) {
        oxoX();
        this.f25447oI0IIXIo = arrowHeight;
        I0Io();
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        OxO.oIX0oI oix0oi = this.f25442Oo;
        if (oix0oi != null) {
            oix0oi.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    public ArrowDirection getArrowDirection() {
        return this.f25445XO;
    }

    public float getArrowHeight() {
        return this.f25447oI0IIXIo;
    }

    public float getArrowPosition() {
        return this.f25444OxxIIOOXO;
    }

    public float getArrowWidth() {
        return this.f25441IXxxXO;
    }

    public int getBubbleColor() {
        return this.f25440IIXOooo;
    }

    public float getCornersRadius() {
        return this.f25443Oxx0xo;
    }

    public int getStrokeColor() {
        return this.f25446o00;
    }

    public float getStrokeWidth() {
        return this.f25448xoXoI;
    }

    public BubbleLayout oOoXoXO(float strokeWidth) {
        oxoX();
        this.f25448xoXoI = strokeWidth;
        I0Io();
        return this;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        II0xO0(0, getWidth(), 0, getHeight());
    }

    public final void oxoX() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (oIX0oI.f25449oIX0oI[this.f25445XO.ordinal()]) {
            case 1:
            case 7:
                paddingLeft = (int) (paddingLeft - this.f25441IXxxXO);
                break;
            case 2:
            case 8:
                paddingRight = (int) (paddingRight - this.f25441IXxxXO);
                break;
            case 3:
            case 5:
            case 9:
                paddingTop = (int) (paddingTop - this.f25447oI0IIXIo);
                break;
            case 4:
            case 6:
            case 10:
                paddingBottom = (int) (paddingBottom - this.f25447oI0IIXIo);
                break;
        }
        float f = this.f25448xoXoI;
        if (f > 0.0f) {
            paddingLeft = (int) (paddingLeft - f);
            paddingRight = (int) (paddingRight - f);
            paddingTop = (int) (paddingTop - f);
            paddingBottom = (int) (paddingBottom - f);
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public BubbleLayout xoIox(float cornersRadius) {
        this.f25443Oxx0xo = cornersRadius;
        requestLayout();
        return this;
    }

    public BubbleLayout xxIXOIIO(int bubbleColor) {
        this.f25440IIXOooo = bubbleColor;
        requestLayout();
        return this;
    }

    public BubbleLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BubbleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.BubbleLayout);
        this.f25441IXxxXO = obtainStyledAttributes.getDimension(3, oIX0oI(8.0f, context));
        this.f25447oI0IIXIo = obtainStyledAttributes.getDimension(1, oIX0oI(8.0f, context));
        this.f25443Oxx0xo = obtainStyledAttributes.getDimension(5, 0.0f);
        this.f25444OxxIIOOXO = obtainStyledAttributes.getDimension(2, oIX0oI(12.0f, context));
        this.f25440IIXOooo = obtainStyledAttributes.getColor(4, -1);
        this.f25448xoXoI = obtainStyledAttributes.getDimension(7, f25439OxI);
        this.f25446o00 = obtainStyledAttributes.getColor(6, -7829368);
        this.f25445XO = ArrowDirection.fromInt(obtainStyledAttributes.getInt(0, ArrowDirection.LEFT.getValue()));
        obtainStyledAttributes.recycle();
        I0Io();
    }
}
