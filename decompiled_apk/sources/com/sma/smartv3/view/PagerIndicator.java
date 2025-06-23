package com.sma.smartv3.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes12.dex */
public class PagerIndicator extends View {

    /* renamed from: o00, reason: collision with root package name */
    public static final long f25135o00 = 600;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public int f25136IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f25137IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public int f25138Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f25139Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public Paint f25140OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public int f25141XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f25142oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public Runnable f25143xoXoI;

    /* loaded from: classes12.dex */
    public class oIX0oI implements Runnable {
        public oIX0oI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PagerIndicator.I0Io(PagerIndicator.this);
            if (PagerIndicator.this.f25136IIXOooo == PagerIndicator.this.f25137IXxxXO) {
                PagerIndicator.this.f25136IIXOooo = -1;
            }
            PagerIndicator.this.invalidate();
            PagerIndicator.this.postDelayed(this, 600L);
        }
    }

    public PagerIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f25137IXxxXO = 5;
        this.f25139Oxx0xo = 40;
        this.f25142oI0IIXIo = 8;
        this.f25136IIXOooo = -1;
        this.f25143xoXoI = new oIX0oI();
        Paint paint = new Paint();
        this.f25140OxxIIOOXO = paint;
        paint.setAntiAlias(true);
        this.f25140OxxIIOOXO.setDither(true);
        this.f25140OxxIIOOXO.setStrokeWidth(4.0f);
    }

    public static /* synthetic */ int I0Io(PagerIndicator pagerIndicator) {
        int i = pagerIndicator.f25136IIXOooo;
        pagerIndicator.f25136IIXOooo = i + 1;
        return i;
    }

    public void X0o0xo(boolean start) {
        this.f25136IIXOooo = -1;
        invalidate();
        if (start) {
            postDelayed(this.f25143xoXoI, 600L);
        } else {
            removeCallbacks(this.f25143xoXoI);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i = (int) ((this.f25141XO / 2) - ((this.f25142oI0IIXIo * r1) + ((this.f25139Oxx0xo * (this.f25137IXxxXO - 1.0f)) / 2.0f)));
        for (int i2 = 0; i2 < this.f25137IXxxXO; i2++) {
            int i3 = this.f25136IIXOooo;
            if (i3 == -1) {
                this.f25140OxxIIOOXO.setColor(-7829368);
            } else if (i2 <= i3) {
                this.f25140OxxIIOOXO.setColor(-1);
            } else {
                this.f25140OxxIIOOXO.setColor(-7829368);
            }
            canvas.drawCircle(i + r2 + ((this.f25139Oxx0xo + (r2 * 2)) * i2), this.f25138Oo / 2, this.f25142oI0IIXIo, this.f25140OxxIIOOXO);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.f25141XO = w;
        this.f25138Oo = h;
    }

    public PagerIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PagerIndicator(Context context) {
        this(context, null);
    }
}
