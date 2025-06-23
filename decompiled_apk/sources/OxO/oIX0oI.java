package OxO;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.sma.smartv3.view.bubbleview.ArrowDirection;

/* loaded from: classes12.dex */
public class oIX0oI extends Drawable {

    /* renamed from: I0Io, reason: collision with root package name */
    public Paint f2995I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public float f2996II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Path f2997II0xO0 = new Path();

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public float f2998Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public Paint f2999X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public float f3000XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public RectF f3001oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public Path f3002oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public float f3003xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public float f3004xxIXOIIO;

    /* renamed from: OxO.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static /* synthetic */ class C0043oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f3005oIX0oI;

        static {
            int[] iArr = new int[ArrowDirection.values().length];
            f3005oIX0oI = iArr;
            try {
                iArr[ArrowDirection.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3005oIX0oI[ArrowDirection.LEFT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3005oIX0oI[ArrowDirection.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3005oIX0oI[ArrowDirection.TOP_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3005oIX0oI[ArrowDirection.TOP_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3005oIX0oI[ArrowDirection.RIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3005oIX0oI[ArrowDirection.RIGHT_CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3005oIX0oI[ArrowDirection.BOTTOM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3005oIX0oI[ArrowDirection.BOTTOM_CENTER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3005oIX0oI[ArrowDirection.BOTTOM_RIGHT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public oIX0oI(RectF rect, float arrowWidth, float cornersRadius, float arrowHeight, float arrowPosition, float strokeWidth, int strokeColor, int bubbleColor, ArrowDirection arrowDirection) {
        Paint paint = new Paint(1);
        this.f2995I0Io = paint;
        this.f3001oIX0oI = rect;
        this.f3000XO = arrowWidth;
        this.f2998Oxx0IOOO = cornersRadius;
        this.f2996II0XooXoX = arrowHeight;
        this.f3004xxIXOIIO = arrowPosition;
        this.f3003xoIox = strokeWidth;
        paint.setColor(bubbleColor);
        if (strokeWidth > 0.0f) {
            Paint paint2 = new Paint(1);
            this.f2999X0o0xo = paint2;
            paint2.setColor(strokeColor);
            this.f3002oxoX = new Path();
            X0o0xo(arrowDirection, this.f2997II0xO0, strokeWidth);
            X0o0xo(arrowDirection, this.f3002oxoX, 0.0f);
            return;
        }
        X0o0xo(arrowDirection, this.f2997II0xO0, 0.0f);
    }

    public final void I0Io(RectF rect, Path path, float strokeWidth) {
        path.moveTo(this.f3000XO + rect.left + this.f2998Oxx0IOOO + strokeWidth, rect.top + strokeWidth);
        path.lineTo((rect.width() - this.f2998Oxx0IOOO) - strokeWidth, rect.top + strokeWidth);
        float f = rect.right;
        float f2 = this.f2998Oxx0IOOO;
        float f3 = rect.top;
        path.arcTo(new RectF(f - f2, f3 + strokeWidth, f - strokeWidth, f2 + f3), 270.0f, 90.0f);
        path.lineTo(rect.right - strokeWidth, (rect.bottom - this.f2998Oxx0IOOO) - strokeWidth);
        float f4 = rect.right;
        float f5 = this.f2998Oxx0IOOO;
        float f6 = rect.bottom;
        path.arcTo(new RectF(f4 - f5, f6 - f5, f4 - strokeWidth, f6 - strokeWidth), 0.0f, 90.0f);
        path.lineTo(rect.left + this.f3000XO + this.f2998Oxx0IOOO + strokeWidth, rect.bottom - strokeWidth);
        float f7 = rect.left;
        float f8 = this.f3000XO;
        float f9 = rect.bottom;
        float f10 = this.f2998Oxx0IOOO;
        path.arcTo(new RectF(f7 + f8 + strokeWidth, f9 - f10, f10 + f7 + f8, f9 - strokeWidth), 90.0f, 90.0f);
        float f11 = strokeWidth / 2.0f;
        path.lineTo(rect.left + this.f3000XO + strokeWidth, (this.f2996II0XooXoX + this.f3004xxIXOIIO) - f11);
        path.lineTo(rect.left + strokeWidth + strokeWidth, this.f3004xxIXOIIO + (this.f2996II0XooXoX / 2.0f));
        path.lineTo(rect.left + this.f3000XO + strokeWidth, this.f3004xxIXOIIO + f11);
        path.lineTo(rect.left + this.f3000XO + strokeWidth, rect.top + this.f2998Oxx0IOOO + strokeWidth);
        float f12 = rect.left;
        float f13 = this.f3000XO;
        float f14 = rect.top;
        float f15 = this.f2998Oxx0IOOO;
        path.arcTo(new RectF(f12 + f13 + strokeWidth, strokeWidth + f14, f12 + f15 + f13, f15 + f14), 180.0f, 90.0f);
        path.close();
    }

    public final void II0XooXoX(RectF rect, Path path, float strokeWidth) {
        path.moveTo(rect.left + Math.min(this.f3004xxIXOIIO, this.f2998Oxx0IOOO) + strokeWidth, rect.top + this.f2996II0XooXoX + strokeWidth);
        float f = strokeWidth / 2.0f;
        path.lineTo(rect.left + this.f3004xxIXOIIO + f, rect.top + this.f2996II0XooXoX + strokeWidth);
        path.lineTo(rect.left + (this.f3000XO / 2.0f) + this.f3004xxIXOIIO, rect.top + strokeWidth + strokeWidth);
        path.lineTo(((rect.left + this.f3000XO) + this.f3004xxIXOIIO) - f, rect.top + this.f2996II0XooXoX + strokeWidth);
        path.lineTo((rect.right - this.f2998Oxx0IOOO) - strokeWidth, rect.top + this.f2996II0XooXoX + strokeWidth);
        float f2 = rect.right;
        float f3 = this.f2998Oxx0IOOO;
        float f4 = rect.top;
        float f5 = this.f2996II0XooXoX;
        path.arcTo(new RectF(f2 - f3, f4 + f5 + strokeWidth, f2 - strokeWidth, f3 + f4 + f5), 270.0f, 90.0f);
        path.lineTo(rect.right - strokeWidth, (rect.bottom - this.f2998Oxx0IOOO) - strokeWidth);
        float f6 = rect.right;
        float f7 = this.f2998Oxx0IOOO;
        float f8 = rect.bottom;
        path.arcTo(new RectF(f6 - f7, f8 - f7, f6 - strokeWidth, f8 - strokeWidth), 0.0f, 90.0f);
        path.lineTo(rect.left + this.f2998Oxx0IOOO + strokeWidth, rect.bottom - strokeWidth);
        float f9 = rect.left;
        float f10 = rect.bottom;
        float f11 = this.f2998Oxx0IOOO;
        path.arcTo(new RectF(f9 + strokeWidth, f10 - f11, f11 + f9, f10 - strokeWidth), 90.0f, 90.0f);
        path.lineTo(rect.left + strokeWidth, rect.top + this.f2996II0XooXoX + this.f2998Oxx0IOOO + strokeWidth);
        float f12 = rect.left;
        float f13 = f12 + strokeWidth;
        float f14 = rect.top;
        float f15 = this.f2996II0XooXoX;
        float f16 = f14 + f15 + strokeWidth;
        float f17 = this.f2998Oxx0IOOO;
        path.arcTo(new RectF(f13, f16, f12 + f17, f17 + f14 + f15), 180.0f, 90.0f);
        path.close();
    }

    public final void II0xO0(RectF rect, Path path, float strokeWidth) {
        path.moveTo(rect.left + strokeWidth, rect.top + strokeWidth);
        path.lineTo(rect.right - strokeWidth, rect.top + strokeWidth);
        path.lineTo(rect.right - strokeWidth, (rect.bottom - this.f2996II0XooXoX) - strokeWidth);
        float f = strokeWidth / 2.0f;
        path.lineTo(((rect.left + this.f3000XO) + this.f3004xxIXOIIO) - f, (rect.bottom - this.f2996II0XooXoX) - strokeWidth);
        path.lineTo(rect.left + this.f3004xxIXOIIO + (this.f3000XO / 2.0f), (rect.bottom - strokeWidth) - strokeWidth);
        path.lineTo(rect.left + this.f3004xxIXOIIO + f, (rect.bottom - this.f2996II0XooXoX) - strokeWidth);
        path.lineTo(rect.left + this.f3004xxIXOIIO + strokeWidth, (rect.bottom - this.f2996II0XooXoX) - strokeWidth);
        path.lineTo(rect.left + strokeWidth, (rect.bottom - this.f2996II0XooXoX) - strokeWidth);
        path.lineTo(rect.left + strokeWidth, rect.top + strokeWidth);
        path.close();
    }

    public final void Oxx0IOOO(RectF rect, Path path, float strokeWidth) {
        path.moveTo(rect.left + strokeWidth, rect.top + strokeWidth);
        path.lineTo((rect.width() - this.f3000XO) - strokeWidth, rect.top + strokeWidth);
        float f = strokeWidth / 2.0f;
        path.lineTo((rect.right - this.f3000XO) - strokeWidth, this.f3004xxIXOIIO + f);
        path.lineTo((rect.right - strokeWidth) - strokeWidth, this.f3004xxIXOIIO + (this.f2996II0XooXoX / 2.0f));
        path.lineTo((rect.right - this.f3000XO) - strokeWidth, (this.f3004xxIXOIIO + this.f2996II0XooXoX) - f);
        path.lineTo((rect.right - this.f3000XO) - strokeWidth, rect.bottom - strokeWidth);
        path.lineTo(rect.left + strokeWidth, rect.bottom - strokeWidth);
        path.lineTo(rect.left + strokeWidth, rect.top + strokeWidth);
        path.close();
    }

    public final void X0o0xo(ArrowDirection arrowDirection, Path path, float strokeWidth) {
        switch (C0043oIX0oI.f3005oIX0oI[arrowDirection.ordinal()]) {
            case 1:
            case 2:
                float f = this.f2998Oxx0IOOO;
                if (f <= 0.0f) {
                    oxoX(this.f3001oIX0oI, path, strokeWidth);
                    return;
                } else if (strokeWidth > 0.0f && strokeWidth > f) {
                    oxoX(this.f3001oIX0oI, path, strokeWidth);
                    return;
                } else {
                    I0Io(this.f3001oIX0oI, path, strokeWidth);
                    return;
                }
            case 3:
            case 4:
            case 5:
                float f2 = this.f2998Oxx0IOOO;
                if (f2 <= 0.0f) {
                    xxIXOIIO(this.f3001oIX0oI, path, strokeWidth);
                    return;
                } else if (strokeWidth > 0.0f && strokeWidth > f2) {
                    xxIXOIIO(this.f3001oIX0oI, path, strokeWidth);
                    return;
                } else {
                    II0XooXoX(this.f3001oIX0oI, path, strokeWidth);
                    return;
                }
            case 6:
            case 7:
                float f3 = this.f2998Oxx0IOOO;
                if (f3 <= 0.0f) {
                    Oxx0IOOO(this.f3001oIX0oI, path, strokeWidth);
                    return;
                } else if (strokeWidth > 0.0f && strokeWidth > f3) {
                    Oxx0IOOO(this.f3001oIX0oI, path, strokeWidth);
                    return;
                } else {
                    XO(this.f3001oIX0oI, path, strokeWidth);
                    return;
                }
            case 8:
            case 9:
            case 10:
                float f4 = this.f2998Oxx0IOOO;
                if (f4 <= 0.0f) {
                    II0xO0(this.f3001oIX0oI, path, strokeWidth);
                    return;
                } else if (strokeWidth > 0.0f && strokeWidth > f4) {
                    II0xO0(this.f3001oIX0oI, path, strokeWidth);
                    return;
                } else {
                    oIX0oI(this.f3001oIX0oI, path, strokeWidth);
                    return;
                }
            default:
                return;
        }
    }

    public final void XO(RectF rect, Path path, float strokeWidth) {
        path.moveTo(rect.left + this.f2998Oxx0IOOO + strokeWidth, rect.top + strokeWidth);
        path.lineTo(((rect.width() - this.f2998Oxx0IOOO) - this.f3000XO) - strokeWidth, rect.top + strokeWidth);
        float f = rect.right;
        float f2 = this.f2998Oxx0IOOO;
        float f3 = this.f3000XO;
        float f4 = rect.top;
        path.arcTo(new RectF((f - f2) - f3, f4 + strokeWidth, (f - f3) - strokeWidth, f2 + f4), 270.0f, 90.0f);
        float f5 = strokeWidth / 2.0f;
        path.lineTo((rect.right - this.f3000XO) - strokeWidth, this.f3004xxIXOIIO + f5);
        path.lineTo((rect.right - strokeWidth) - strokeWidth, this.f3004xxIXOIIO + (this.f2996II0XooXoX / 2.0f));
        path.lineTo((rect.right - this.f3000XO) - strokeWidth, (this.f3004xxIXOIIO + this.f2996II0XooXoX) - f5);
        path.lineTo((rect.right - this.f3000XO) - strokeWidth, (rect.bottom - this.f2998Oxx0IOOO) - strokeWidth);
        float f6 = rect.right;
        float f7 = this.f2998Oxx0IOOO;
        float f8 = this.f3000XO;
        float f9 = rect.bottom;
        path.arcTo(new RectF((f6 - f7) - f8, f9 - f7, (f6 - f8) - strokeWidth, f9 - strokeWidth), 0.0f, 90.0f);
        path.lineTo(rect.left + this.f3000XO + strokeWidth, rect.bottom - strokeWidth);
        float f10 = rect.left;
        float f11 = rect.bottom;
        float f12 = this.f2998Oxx0IOOO;
        path.arcTo(new RectF(f10 + strokeWidth, f11 - f12, f12 + f10, f11 - strokeWidth), 90.0f, 90.0f);
        float f13 = rect.left;
        float f14 = rect.top;
        float f15 = this.f2998Oxx0IOOO;
        path.arcTo(new RectF(f13 + strokeWidth, strokeWidth + f14, f13 + f15, f15 + f14), 180.0f, 90.0f);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f3003xoIox > 0.0f) {
            canvas.drawPath(this.f3002oxoX, this.f2999X0o0xo);
        }
        canvas.drawPath(this.f2997II0xO0, this.f2995I0Io);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f3001oIX0oI.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.f3001oIX0oI.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final void oIX0oI(RectF rect, Path path, float strokeWidth) {
        path.moveTo(rect.left + this.f2998Oxx0IOOO + strokeWidth, rect.top + strokeWidth);
        path.lineTo((rect.width() - this.f2998Oxx0IOOO) - strokeWidth, rect.top + strokeWidth);
        float f = rect.right;
        float f2 = this.f2998Oxx0IOOO;
        float f3 = rect.top;
        path.arcTo(new RectF(f - f2, f3 + strokeWidth, f - strokeWidth, f2 + f3), 270.0f, 90.0f);
        path.lineTo(rect.right - strokeWidth, ((rect.bottom - this.f2996II0XooXoX) - this.f2998Oxx0IOOO) - strokeWidth);
        float f4 = rect.right;
        float f5 = this.f2998Oxx0IOOO;
        float f6 = rect.bottom;
        float f7 = this.f2996II0XooXoX;
        path.arcTo(new RectF(f4 - f5, (f6 - f5) - f7, f4 - strokeWidth, (f6 - f7) - strokeWidth), 0.0f, 90.0f);
        float f8 = strokeWidth / 2.0f;
        path.lineTo(((rect.left + this.f3000XO) + this.f3004xxIXOIIO) - f8, (rect.bottom - this.f2996II0XooXoX) - strokeWidth);
        path.lineTo(rect.left + this.f3004xxIXOIIO + (this.f3000XO / 2.0f), (rect.bottom - strokeWidth) - strokeWidth);
        path.lineTo(rect.left + this.f3004xxIXOIIO + f8, (rect.bottom - this.f2996II0XooXoX) - strokeWidth);
        path.lineTo(rect.left + Math.min(this.f2998Oxx0IOOO, this.f3004xxIXOIIO) + strokeWidth, (rect.bottom - this.f2996II0XooXoX) - strokeWidth);
        float f9 = rect.left;
        float f10 = rect.bottom;
        float f11 = this.f2998Oxx0IOOO;
        float f12 = this.f2996II0XooXoX;
        path.arcTo(new RectF(f9 + strokeWidth, (f10 - f11) - f12, f11 + f9, (f10 - f12) - strokeWidth), 90.0f, 90.0f);
        path.lineTo(rect.left + strokeWidth, rect.top + this.f2998Oxx0IOOO + strokeWidth);
        float f13 = rect.left;
        float f14 = rect.top;
        float f15 = this.f2998Oxx0IOOO;
        path.arcTo(new RectF(f13 + strokeWidth, strokeWidth + f14, f13 + f15, f15 + f14), 180.0f, 90.0f);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
    }

    public final void oxoX(RectF rect, Path path, float strokeWidth) {
        path.moveTo(this.f3000XO + rect.left + strokeWidth, rect.top + strokeWidth);
        path.lineTo(rect.width() - strokeWidth, rect.top + strokeWidth);
        path.lineTo(rect.right - strokeWidth, rect.bottom - strokeWidth);
        path.lineTo(rect.left + this.f3000XO + strokeWidth, rect.bottom - strokeWidth);
        float f = strokeWidth / 2.0f;
        path.lineTo(rect.left + this.f3000XO + strokeWidth, (this.f2996II0XooXoX + this.f3004xxIXOIIO) - f);
        path.lineTo(rect.left + strokeWidth + strokeWidth, this.f3004xxIXOIIO + (this.f2996II0XooXoX / 2.0f));
        path.lineTo(rect.left + this.f3000XO + strokeWidth, this.f3004xxIXOIIO + f);
        path.lineTo(rect.left + this.f3000XO + strokeWidth, rect.top + strokeWidth);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.f2995I0Io.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter cf) {
        this.f2995I0Io.setColorFilter(cf);
    }

    public final void xxIXOIIO(RectF rect, Path path, float strokeWidth) {
        path.moveTo(rect.left + this.f3004xxIXOIIO + strokeWidth, rect.top + this.f2996II0XooXoX + strokeWidth);
        float f = strokeWidth / 2.0f;
        path.lineTo(rect.left + this.f3004xxIXOIIO + f, rect.top + this.f2996II0XooXoX + strokeWidth);
        path.lineTo(rect.left + (this.f3000XO / 2.0f) + this.f3004xxIXOIIO, rect.top + strokeWidth + strokeWidth);
        path.lineTo(((rect.left + this.f3000XO) + this.f3004xxIXOIIO) - f, rect.top + this.f2996II0XooXoX + strokeWidth);
        path.lineTo(rect.right - strokeWidth, rect.top + this.f2996II0XooXoX + strokeWidth);
        path.lineTo(rect.right - strokeWidth, rect.bottom - strokeWidth);
        path.lineTo(rect.left + strokeWidth, rect.bottom - strokeWidth);
        path.lineTo(rect.left + strokeWidth, rect.top + this.f2996II0XooXoX + strokeWidth);
        path.lineTo(rect.left + this.f3004xxIXOIIO + strokeWidth, rect.top + this.f2996II0XooXoX + strokeWidth);
        path.close();
    }
}
