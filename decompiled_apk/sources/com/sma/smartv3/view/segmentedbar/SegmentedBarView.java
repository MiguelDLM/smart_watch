package com.sma.smartv3.view.segmentedbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.Html;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.sma.smartv3.R;
import java.text.DecimalFormat;
import java.util.List;

/* loaded from: classes12.dex */
public class SegmentedBarView extends View {

    /* renamed from: IIX0, reason: collision with root package name */
    public static final int f25593IIX0 = 1;

    /* renamed from: O0, reason: collision with root package name */
    public static final int f25594O0 = 2;

    /* renamed from: O0X, reason: collision with root package name */
    public static final int f25595O0X = 0;

    /* renamed from: Ox0O, reason: collision with root package name */
    public static final int f25596Ox0O = 1;

    /* renamed from: xOoOIoI, reason: collision with root package name */
    public static final int f25597xOoOIoI = 0;

    /* renamed from: xx0X0, reason: collision with root package name */
    public static final int f25598xx0X0 = 3;

    /* renamed from: I0, reason: collision with root package name */
    public boolean f25599I0;

    /* renamed from: I0X0x0oIo, reason: collision with root package name */
    public TextPaint f25600I0X0x0oIo;

    /* renamed from: I0oOIX, reason: collision with root package name */
    public int f25601I0oOIX;

    /* renamed from: I0oOoX, reason: collision with root package name */
    public int f25602I0oOoX;

    /* renamed from: IIX0o, reason: collision with root package name */
    public int f25603IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public int f25604IIXOooo;

    /* renamed from: IIxOXoOo0, reason: collision with root package name */
    public boolean f25605IIxOXoOo0;

    /* renamed from: IO, reason: collision with root package name */
    public Paint f25606IO;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public RectF f25607IXxxXO;

    /* renamed from: Io, reason: collision with root package name */
    public int f25608Io;

    /* renamed from: IoOoX, reason: collision with root package name */
    public int f25609IoOoX;

    /* renamed from: IoOoo, reason: collision with root package name */
    public int f25610IoOoo;

    /* renamed from: Ioxxx, reason: collision with root package name */
    public int f25611Ioxxx;

    /* renamed from: O00XxXI, reason: collision with root package name */
    public Point f25612O00XxXI;

    /* renamed from: O0Xx, reason: collision with root package name */
    public int f25613O0Xx;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public String f25614O0xOxO;

    /* renamed from: OI0, reason: collision with root package name */
    public String f25615OI0;

    /* renamed from: OO, reason: collision with root package name */
    public int f25616OO;

    /* renamed from: OO0x0xX, reason: collision with root package name */
    public boolean f25617OO0x0xX;

    /* renamed from: OOXIxO0, reason: collision with root package name */
    public Rect f25618OOXIxO0;

    /* renamed from: OX00O0xII, reason: collision with root package name */
    public int f25619OX00O0xII;

    /* renamed from: Oo, reason: collision with root package name */
    public int[] f25620Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public Float f25621OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public Paint f25622Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public Paint f25623OxxIIOOXO;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public String f25624X00IoxXI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public Integer f25625X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public String f25626XI0IXoo;

    /* renamed from: XI0oooXX, reason: collision with root package name */
    public Point f25627XI0oooXX;

    /* renamed from: XIXIX, reason: collision with root package name */
    public int f25628XIXIX;

    /* renamed from: XIo0oOXIx, reason: collision with root package name */
    public boolean f25629XIo0oOXIx;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public Rect f25630XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public int[] f25631XO;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public DecimalFormat f25632XOxIOxOx;

    /* renamed from: XX, reason: collision with root package name */
    public int f25633XX;

    /* renamed from: XX0, reason: collision with root package name */
    public StaticLayout f25634XX0;

    /* renamed from: XX0xXo, reason: collision with root package name */
    public Path f25635XX0xXo;

    /* renamed from: Xo0, reason: collision with root package name */
    public int f25636Xo0;

    /* renamed from: XoI0Ixx0, reason: collision with root package name */
    public int f25637XoI0Ixx0;

    /* renamed from: XoX, reason: collision with root package name */
    public int f25638XoX;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public List<o0Xo.oIX0oI> f25639Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public int f25640XxX0x0xxx;

    /* renamed from: o0, reason: collision with root package name */
    public boolean f25641o0;

    /* renamed from: o00, reason: collision with root package name */
    public int f25642o00;

    /* renamed from: o0xxxXXxX, reason: collision with root package name */
    public Path f25643o0xxxXXxX;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public Paint f25644oI0IIXIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public int f25645oOXoIIIo;

    /* renamed from: oOo, reason: collision with root package name */
    public boolean f25646oOo;

    /* renamed from: oX, reason: collision with root package name */
    public int f25647oX;

    /* renamed from: oXIO0o0XI, reason: collision with root package name */
    public int f25648oXIO0o0XI;

    /* renamed from: oo, reason: collision with root package name */
    public int f25649oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f25650oo0xXOI0I;

    /* renamed from: ooOx, reason: collision with root package name */
    public int f25651ooOx;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public int f25652ooXIXxIX;

    /* renamed from: ox, reason: collision with root package name */
    public Point f25653ox;

    /* renamed from: oxXx0IX, reason: collision with root package name */
    public Paint f25654oxXx0IX;

    /* renamed from: oxxXoxO, reason: collision with root package name */
    public int f25655oxxXoxO;

    /* renamed from: x0o, reason: collision with root package name */
    public Paint f25656x0o;

    /* renamed from: x0xO, reason: collision with root package name */
    public Paint f25657x0xO;

    /* renamed from: xI, reason: collision with root package name */
    public int f25658xI;

    /* renamed from: xII, reason: collision with root package name */
    public Paint f25659xII;

    /* renamed from: xOOOX, reason: collision with root package name */
    public Bitmap f25660xOOOX;

    /* renamed from: xX0IIXIx0, reason: collision with root package name */
    public int f25661xX0IIXIx0;

    /* renamed from: xXOx, reason: collision with root package name */
    public int f25662xXOx;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public float f25663xXxxox0I;

    /* renamed from: xo0x, reason: collision with root package name */
    public int f25664xo0x;

    /* renamed from: xoIxX, reason: collision with root package name */
    public int f25665xoIxX;

    /* renamed from: xoO0xx0, reason: collision with root package name */
    public boolean f25666xoO0xx0;

    /* renamed from: xoXoI, reason: collision with root package name */
    public int f25667xoXoI;

    /* renamed from: xoxXI, reason: collision with root package name */
    public int f25668xoxXI;

    /* renamed from: xxIO, reason: collision with root package name */
    public int f25669xxIO;

    /* renamed from: xxX, reason: collision with root package name */
    public Rect f25670xxX;

    /* loaded from: classes12.dex */
    public class II0xO0 {
        public II0xO0 I0Io(int descriptionBoxHeight) {
            SegmentedBarView.this.f25610IoOoo = descriptionBoxHeight;
            return this;
        }

        public II0xO0 II0XooXoX(int gapWidth) {
            SegmentedBarView.this.f25649oo = gapWidth;
            return this;
        }

        public SegmentedBarView II0xO0() {
            return SegmentedBarView.this;
        }

        public II0xO0 IIXOooo(int width, int height) {
            SegmentedBarView.this.f25667xoXoI = width;
            SegmentedBarView.this.f25604IIXOooo = height;
            return this;
        }

        public II0xO0 IXxxXO(Float value) {
            SegmentedBarView.this.f25621OxI = value;
            SegmentedBarView.this.X0IIOO();
            return this;
        }

        public II0xO0 OOXIXo(List<o0Xo.oIX0oI> segments) {
            SegmentedBarView.this.f25639Xx000oIo = segments;
            return this;
        }

        public II0xO0 Oo(String unit) {
            SegmentedBarView.this.f25624X00IoxXI = unit;
            SegmentedBarView.this.X0IIOO();
            return this;
        }

        public II0xO0 Oxx0IOOO(int emptySegmentColor) {
            SegmentedBarView.this.f25652ooXIXxIX = emptySegmentColor;
            return this;
        }

        public II0xO0 Oxx0xo(Integer valueSegment) {
            SegmentedBarView.this.f25625X0IIOO = valueSegment;
            SegmentedBarView.this.X0IIOO();
            return this;
        }

        public II0xO0 OxxIIOOXO(int valueSignColor) {
            SegmentedBarView.this.f25642o00 = valueSignColor;
            return this;
        }

        public II0xO0 X0o0xo(int descriptionTextSize) {
            SegmentedBarView.this.f25668xoxXI = descriptionTextSize;
            return this;
        }

        public II0xO0 XO(int descriptionTopTextColor) {
            SegmentedBarView.this.f25636Xo0 = descriptionTopTextColor;
            return this;
        }

        public II0xO0 o00(int valueTextSize) {
            SegmentedBarView.this.f25664xo0x = valueTextSize;
            return this;
        }

        public II0xO0 oI0IIXIo(String valueSegmentText) {
            SegmentedBarView.this.f25626XI0IXoo = valueSegmentText;
            SegmentedBarView.this.X0IIOO();
            return this;
        }

        public II0xO0 oIX0oI(int barHeight) {
            SegmentedBarView.this.f25645oOXoIIIo = barHeight;
            return this;
        }

        public II0xO0 oO(int sideStyle) {
            SegmentedBarView.this.f25633XX = sideStyle;
            return this;
        }

        public II0xO0 oOoXoXO(boolean showDescriptionText) {
            SegmentedBarView.this.f25617OO0x0xX = showDescriptionText;
            return this;
        }

        public II0xO0 ooOOo0oXI(boolean showText) {
            SegmentedBarView.this.f25641o0 = showText;
            return this;
        }

        public II0xO0 oxoX(int descriptionTextColor) {
            SegmentedBarView.this.f25647oX = descriptionTextColor;
            return this;
        }

        public II0xO0 x0XOIxOo(int sideRule) {
            SegmentedBarView.this.f25619OX00O0xII = sideRule;
            return this;
        }

        public II0xO0 x0xO0oo(int sideTextStyle) {
            SegmentedBarView.this.f25602I0oOoX = sideTextStyle;
            return this;
        }

        public II0xO0 xoIox(int segmentTextSize) {
            SegmentedBarView.this.f25655oxxXoxO = segmentTextSize;
            return this;
        }

        public II0xO0 xoXoI(int valueTextColor) {
            SegmentedBarView.this.f25662xXOx = valueTextColor;
            return this;
        }

        public II0xO0 xxIXOIIO(int segmentTextColor) {
            SegmentedBarView.this.f25638XoX = segmentTextColor;
            return this;
        }

        public II0xO0() {
        }
    }

    public SegmentedBarView(Context context) {
        super(context);
        this.f25631XO = new int[]{SupportMenu.CATEGORY_MASK, -16776961};
        this.f25620Oo = new int[]{-16776961, -256};
        this.f25663xXxxox0I = -1.0f;
        this.f25608Io = 0;
        this.f25633XX = 1;
        this.f25602I0oOoX = 0;
        this.f25638XoX = -1;
        this.f25662xXOx = -1;
        this.f25647oX = -12303292;
        this.f25636Xo0 = -1;
        this.f25637XoI0Ixx0 = 65536;
        this.f25616OO = -1;
        this.f25605IIxOXoOo0 = false;
        this.f25599I0 = false;
        IO(context, null);
    }

    public static II0xO0 O0xOxO(Context context) {
        return new II0xO0();
    }

    private int getContentHeight() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private int getContentWidth() {
        return ((getWidth() - getPaddingLeft()) - getPaddingRight()) - (getXLeft() * 2);
    }

    private int getXLeft() {
        int i = this.f25611Ioxxx;
        if ((i == 1 || i == 2) && this.f25646oOo && this.f25625X0IIOO == null) {
            return this.f25648oXIO0o0XI / 2;
        }
        return 0;
    }

    private int getXtop() {
        int i;
        int i2 = this.f25628XIXIX;
        int i3 = this.f25645oOXoIIIo;
        if (i2 - i3 > 0) {
            i = (i2 - i3) / 2;
        } else {
            i = 0;
        }
        int i4 = this.f25611Ioxxx;
        if ((i4 != 1 && i4 != 2) || !this.f25646oOo) {
            return 0;
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x05a1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0610  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void IIX0o(android.graphics.Canvas r21, o0Xo.oIX0oI r22, int r23, int r24, float r25) {
        /*
            Method dump skipped, instructions count: 1672
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.view.segmentedbar.SegmentedBarView.IIX0o(android.graphics.Canvas, o0Xo.oIX0oI, int, int, float):void");
    }

    public final void IO(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SegmentedBarView, 0, 0);
        try {
            Resources resources = getResources();
            this.f25669xxIO = obtainStyledAttributes.getResourceId(31, -1);
            this.f25611Ioxxx = obtainStyledAttributes.getInt(32, 0);
            this.f25613O0Xx = obtainStyledAttributes.getInt(3, 0);
            this.f25601I0oOIX = obtainStyledAttributes.getInt(4, 0);
            this.f25655oxxXoxO = obtainStyledAttributes.getDimensionPixelSize(24, resources.getDimensionPixelSize(com.sma.smartv3.co_fit.R.dimen.sbv_segment_text_size));
            this.f25664xo0x = obtainStyledAttributes.getDimensionPixelSize(42, resources.getDimensionPixelSize(com.sma.smartv3.co_fit.R.dimen.sbv_value_text_size));
            this.f25668xoxXI = obtainStyledAttributes.getDimensionPixelSize(10, resources.getDimensionPixelSize(com.sma.smartv3.co_fit.R.dimen.sbv_description_text_size));
            this.f25616OO = obtainStyledAttributes.getDimensionPixelSize(8, -1);
            this.f25645oOXoIIIo = obtainStyledAttributes.getDimensionPixelSize(2, resources.getDimensionPixelSize(com.sma.smartv3.co_fit.R.dimen.sbv_bar_height));
            this.f25604IIXOooo = obtainStyledAttributes.getDimensionPixelSize(39, resources.getDimensionPixelSize(com.sma.smartv3.co_fit.R.dimen.sbv_value_sign_height));
            this.f25667xoXoI = obtainStyledAttributes.getDimensionPixelSize(41, resources.getDimensionPixelSize(com.sma.smartv3.co_fit.R.dimen.sbv_value_sign_width));
            this.f25658xI = obtainStyledAttributes.getDimensionPixelSize(0, resources.getDimensionPixelSize(com.sma.smartv3.co_fit.R.dimen.sbv_arrow_height));
            this.f25650oo0xXOI0I = obtainStyledAttributes.getDimensionPixelSize(1, resources.getDimensionPixelSize(com.sma.smartv3.co_fit.R.dimen.sbv_arrow_width));
            this.f25649oo = obtainStyledAttributes.getDimensionPixelSize(18, resources.getDimensionPixelSize(com.sma.smartv3.co_fit.R.dimen.sbv_segment_gap_width));
            this.f25608Io = obtainStyledAttributes.getDimensionPixelSize(22, 0);
            this.f25609IoOoX = obtainStyledAttributes.getColor(17, -1);
            this.f25640XxX0x0xxx = obtainStyledAttributes.getDimensionPixelSize(40, resources.getDimensionPixelSize(com.sma.smartv3.co_fit.R.dimen.sbv_value_sign_round));
            this.f25610IoOoo = obtainStyledAttributes.getDimensionPixelSize(5, resources.getDimensionPixelSize(com.sma.smartv3.co_fit.R.dimen.sbv_description_box_height));
            this.f25665xoIxX = obtainStyledAttributes.getDimensionPixelSize(6, resources.getDimensionPixelSize(com.sma.smartv3.co_fit.R.dimen.sbv_description_box_height));
            this.f25651ooOx = obtainStyledAttributes.getDimensionPixelSize(38, resources.getDimensionPixelSize(com.sma.smartv3.co_fit.R.dimen.sbv_value_sign_border_size));
            this.f25628XIXIX = obtainStyledAttributes.getDimensionPixelSize(33, (int) (this.f25645oOXoIIIo * 1.3f));
            this.f25648oXIO0o0XI = obtainStyledAttributes.getDimensionPixelSize(34, (int) (this.f25645oOXoIIIo * 1.3f));
            this.f25641o0 = obtainStyledAttributes.getBoolean(27, true);
            this.f25617OO0x0xX = obtainStyledAttributes.getBoolean(25, false);
            this.f25629XIo0oOXIx = obtainStyledAttributes.getBoolean(26, false);
            String string = obtainStyledAttributes.getString(35);
            this.f25626XI0IXoo = string;
            if (string == null) {
                this.f25626XI0IXoo = resources.getString(com.sma.smartv3.co_fit.R.string.sbv_value_segment);
            }
            String string2 = obtainStyledAttributes.getString(13);
            this.f25615OI0 = string2;
            if (string2 == null) {
                this.f25615OI0 = resources.getString(com.sma.smartv3.co_fit.R.string.sbv_empty);
            }
            this.f25605IIxOXoOo0 = obtainStyledAttributes.getBoolean(14, false);
            this.f25599I0 = obtainStyledAttributes.getBoolean(19, false);
            this.f25666xoO0xx0 = obtainStyledAttributes.getBoolean(28, false);
            this.f25661xX0IIXIx0 = obtainStyledAttributes.getColor(37, context.getResources().getColor(com.sma.smartv3.co_fit.R.color.sbv_value_sign_boder_color));
            int color = obtainStyledAttributes.getColor(9, this.f25647oX);
            this.f25647oX = color;
            this.f25636Xo0 = obtainStyledAttributes.getColor(11, color);
            this.f25637XoI0Ixx0 = obtainStyledAttributes.getColor(7, 65536);
            int color2 = obtainStyledAttributes.getColor(16, context.getResources().getColor(com.sma.smartv3.co_fit.R.color.sbv_segment_bg_startcolor));
            int color3 = obtainStyledAttributes.getColor(15, context.getResources().getColor(com.sma.smartv3.co_fit.R.color.sbv_segment_bg_endcolor));
            int[] iArr = this.f25631XO;
            iArr[0] = color2;
            iArr[1] = color3;
            int color4 = obtainStyledAttributes.getColor(21, context.getResources().getColor(com.sma.smartv3.co_fit.R.color.sbv_segment_progress_startcolor));
            int color5 = obtainStyledAttributes.getColor(20, context.getResources().getColor(com.sma.smartv3.co_fit.R.color.sbv_segment_progress_endcolor));
            int[] iArr2 = this.f25620Oo;
            iArr2[0] = color4;
            iArr2[1] = color5;
            this.f25642o00 = obtainStyledAttributes.getColor(36, context.getResources().getColor(com.sma.smartv3.co_fit.R.color.sbv_value_sign_background));
            this.f25652ooXIXxIX = obtainStyledAttributes.getColor(12, context.getResources().getColor(com.sma.smartv3.co_fit.R.color.sbv_empty_segment_background));
            this.f25633XX = obtainStyledAttributes.getInt(29, 1);
            this.f25602I0oOoX = obtainStyledAttributes.getInt(30, 0);
            this.f25619OX00O0xII = obtainStyledAttributes.getInt(23, 1);
            obtainStyledAttributes.recycle();
            if (this.f25669xxIO != -1 || this.f25611Ioxxx == 2) {
                this.f25646oOo = true;
            }
            if (this.f25646oOo) {
                Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), this.f25669xxIO);
                this.f25660xOOOX = decodeResource;
                int i = this.f25611Ioxxx;
                if (i == 1) {
                    this.f25628XIXIX = decodeResource.getWidth();
                    this.f25648oXIO0o0XI = this.f25660xOOOX.getHeight();
                } else if (i == 3) {
                    this.f25660xOOOX = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), this.f25669xxIO), this.f25648oXIO0o0XI, this.f25628XIXIX, true);
                }
            }
            this.f25632XOxIOxOx = new DecimalFormat("##.####");
            TextPaint textPaint = new TextPaint(1);
            this.f25654oxXx0IX = textPaint;
            textPaint.setColor(-1);
            Paint paint = this.f25654oxXx0IX;
            Paint.Style style = Paint.Style.FILL;
            paint.setStyle(style);
            TextPaint textPaint2 = new TextPaint(1);
            this.f25600I0X0x0oIo = textPaint2;
            textPaint2.setColor(-1);
            this.f25600I0X0x0oIo.setStyle(style);
            this.f25600I0X0x0oIo.setTextSize(this.f25664xo0x);
            this.f25600I0X0x0oIo.setColor(this.f25662xXOx);
            TextPaint textPaint3 = new TextPaint(1);
            this.f25657x0xO = textPaint3;
            textPaint3.setColor(-12303292);
            this.f25657x0xO.setStyle(style);
            Paint paint2 = new Paint(1);
            this.f25622Oxx0xo = paint2;
            paint2.setStyle(style);
            this.f25622Oxx0xo.setAntiAlias(true);
            Paint paint3 = new Paint(1);
            this.f25644oI0IIXIo = paint3;
            paint3.setStyle(style);
            this.f25644oI0IIXIo.setAntiAlias(true);
            Paint paint4 = new Paint(1);
            this.f25623OxxIIOOXO = paint4;
            paint4.setStyle(Paint.Style.STROKE);
            this.f25623OxxIIOOXO.setStrokeWidth(this.f25651ooOx);
            this.f25623OxxIIOOXO.setColor(this.f25661xX0IIXIx0);
            this.f25623OxxIIOOXO.setAntiAlias(true);
            Paint paint5 = new Paint(1);
            this.f25606IO = paint5;
            paint5.setStyle(style);
            this.f25606IO.setAntiAlias(true);
            Paint paint6 = new Paint(1);
            this.f25656x0o = paint6;
            paint6.setStyle(style);
            this.f25656x0o.setAntiAlias(true);
            Paint paint7 = new Paint(1);
            this.f25659xII = paint7;
            paint7.setStyle(style);
            this.f25630XIxXXX0x0 = new Rect();
            this.f25607IXxxXO = new RectF();
            this.f25670xxX = new Rect();
            this.f25618OOXIxO0 = new Rect();
            Path path = new Path();
            this.f25635XX0xXo = path;
            path.setFillType(Path.FillType.EVEN_ODD);
            this.f25643o0xxxXXxX = new Path();
            this.f25612O00XxXI = new Point();
            this.f25653ox = new Point();
            this.f25627XI0oooXX = new Point();
            int i2 = this.f25611Ioxxx;
            if (i2 == 1 || i2 == 2) {
                this.f25658xI = 0;
                this.f25604IIXOooo = 0;
            }
            if (!this.f25629XIo0oOXIx) {
                this.f25665xoIxX = 0;
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void Io(Float value, String unitHtml) {
        this.f25621OxI = value;
        this.f25624X00IoxXI = unitHtml;
        if (!o0()) {
            X0IIOO();
        }
        invalidate();
        requestLayout();
    }

    public final void IoOoX(Canvas canvas, Point point1, Point point2, Point point3, Paint paint) {
        this.f25635XX0xXo.reset();
        this.f25635XX0xXo.moveTo(point1.x, point1.y);
        this.f25635XX0xXo.lineTo(point2.x, point2.y);
        this.f25635XX0xXo.lineTo(point3.x, point3.y);
        this.f25635XX0xXo.lineTo(point1.x, point1.y);
        this.f25635XX0xXo.close();
        canvas.drawPath(this.f25635XX0xXo, paint);
    }

    public void OI0(int width, int height) {
        this.f25667xoXoI = width;
        this.f25604IIXOooo = height;
        if (!o0()) {
            X0IIOO();
        }
        invalidate();
        requestLayout();
    }

    public final int X00IoxXI(float fraction, int startColor, int endColor) {
        int red = Color.red(startColor);
        int blue = Color.blue(startColor);
        int green = Color.green(startColor);
        int alpha = Color.alpha(startColor);
        int red2 = Color.red(endColor);
        int blue2 = Color.blue(endColor);
        return Color.argb((int) (alpha + (fraction * (Color.alpha(endColor) - alpha))), (int) (red + ((red2 - red) * fraction)), (int) (green + ((Color.green(endColor) - green) * fraction)), (int) (blue + ((blue2 - blue) * fraction)));
    }

    public final void X0IIOO() {
        String str;
        String str2;
        if (o0()) {
            this.f25634XX0 = null;
            return;
        }
        Float f = this.f25621OxI;
        if (f != null) {
            str = this.f25632XOxIOxOx.format(f);
        } else {
            str = this.f25626XI0IXoo;
        }
        if (this.f25621OxI != null && (str2 = this.f25624X00IoxXI) != null && !str2.isEmpty()) {
            str = str + String.format(" <small>%s</small>", this.f25624X00IoxXI);
        }
        if (!TextUtils.isEmpty(this.f25614O0xOxO)) {
            str = this.f25614O0xOxO;
        }
        this.f25634XX0 = new StaticLayout(Html.fromHtml(str), this.f25600I0X0x0oIo, this.f25667xoXoI, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public final int XI0IXoo() {
        if (o0()) {
            return 0;
        }
        return this.f25665xoIxX;
    }

    public final void XIxXXX0x0(Canvas canvas) {
        float contentWidth = getContentWidth();
        this.f25630XIxXXX0x0.set(getPaddingLeft() + getXLeft(), XX() + getPaddingTop() + XI0IXoo() + getXtop(), getPaddingLeft() + getXLeft() + getContentWidth(), this.f25645oOXoIIIo + XX() + getPaddingTop() + XI0IXoo() + getXtop());
        Rect rect = this.f25630XIxXXX0x0;
        float f = rect.left;
        float f2 = rect.top;
        float f3 = rect.right;
        float f4 = rect.bottom;
        int[] iArr = this.f25631XO;
        this.f25606IO.setShader(new LinearGradient(f, f2, f3, f4, iArr[0], iArr[1], Shader.TileMode.MIRROR));
        int height = this.f25630XIxXXX0x0.height() / 2;
        this.f25608Io = height;
        if (height > contentWidth / 2.0f) {
            this.f25633XX = 0;
        }
        this.f25618OOXIxO0.set(this.f25630XIxXXX0x0);
        int i = this.f25633XX;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    this.f25630XIxXXX0x0.set(this.f25608Io + getPaddingLeft(), XX() + XI0IXoo() + getPaddingTop(), (getWidth() - getPaddingRight()) - this.f25608Io, this.f25645oOXoIIIo + XX() + XI0IXoo() + getPaddingTop());
                    canvas.drawRect(this.f25630XIxXXX0x0, this.f25606IO);
                    Point point = this.f25612O00XxXI;
                    Rect rect2 = this.f25630XIxXXX0x0;
                    int i2 = rect2.left;
                    int i3 = this.f25608Io;
                    point.set(i2 - i3, rect2.top + i3);
                    Point point2 = this.f25653ox;
                    Rect rect3 = this.f25630XIxXXX0x0;
                    point2.set(rect3.left, rect3.top);
                    Point point3 = this.f25627XI0oooXX;
                    Rect rect4 = this.f25630XIxXXX0x0;
                    point3.set(rect4.left, rect4.bottom);
                    IoOoX(canvas, this.f25612O00XxXI, this.f25653ox, this.f25627XI0oooXX, this.f25606IO);
                    Point point4 = this.f25612O00XxXI;
                    Rect rect5 = this.f25630XIxXXX0x0;
                    int i4 = rect5.right;
                    int i5 = this.f25608Io;
                    point4.set(i4 + i5, rect5.top + i5);
                    Point point5 = this.f25653ox;
                    Rect rect6 = this.f25630XIxXXX0x0;
                    point5.set(rect6.right, rect6.top);
                    Point point6 = this.f25627XI0oooXX;
                    Rect rect7 = this.f25630XIxXXX0x0;
                    point6.set(rect7.right, rect7.bottom);
                    IoOoX(canvas, this.f25612O00XxXI, this.f25653ox, this.f25627XI0oooXX, this.f25606IO);
                }
            } else {
                RectF rectF = this.f25607IXxxXO;
                Rect rect8 = this.f25630XIxXXX0x0;
                rectF.set(rect8.left, rect8.top, rect8.right, rect8.bottom);
                RectF rectF2 = this.f25607IXxxXO;
                int i6 = this.f25608Io;
                canvas.drawRoundRect(rectF2, i6, i6, this.f25606IO);
            }
        } else {
            canvas.drawRect(this.f25630XIxXXX0x0, this.f25606IO);
        }
        if (this.f25641o0) {
            String str = this.f25615OI0;
            this.f25654oxXx0IX.setTextSize(this.f25655oxxXoxO);
            Paint paint = this.f25654oxXx0IX;
            Rect rect9 = this.f25618OOXIxO0;
            oo0xXOI0I(canvas, paint, str, rect9.left, rect9.top, rect9.right, rect9.bottom);
        }
    }

    public void XOxIOxOx(float value, String valueText) {
        this.f25614O0xOxO = valueText;
        this.f25621OxI = Float.valueOf(value);
        X0IIOO();
        invalidate();
        requestLayout();
    }

    public final int XX() {
        if (o0()) {
            return 0;
        }
        return this.f25604IIXOooo;
    }

    public final void Xx000oIo(Canvas canvas, int valueSignSpaceHeight, int valueSignCenter) {
        boolean z;
        int i = 0;
        if (valueSignCenter == -1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            valueSignCenter = (getContentWidth() / 2) + getPaddingLeft();
        }
        this.f25670xxX.set(valueSignCenter - (this.f25667xoXoI / 2), getPaddingTop(), (this.f25667xoXoI / 2) + valueSignCenter, (this.f25604IIXOooo - this.f25658xI) + getPaddingTop());
        this.f25644oI0IIXIo.setColor(this.f25642o00);
        if (this.f25670xxX.left < getPaddingLeft()) {
            int paddingLeft = (-this.f25670xxX.left) + getPaddingLeft();
            RectF rectF = this.f25607IXxxXO;
            Rect rect = this.f25670xxX;
            rectF.set(rect.left + paddingLeft, rect.top, rect.right + paddingLeft, rect.bottom);
        } else if (this.f25670xxX.right > getMeasuredWidth() - getPaddingRight()) {
            int measuredWidth = (this.f25670xxX.right - getMeasuredWidth()) + getPaddingRight();
            RectF rectF2 = this.f25607IXxxXO;
            Rect rect2 = this.f25670xxX;
            rectF2.set(rect2.left - measuredWidth, rect2.top, rect2.right - measuredWidth, rect2.bottom);
        } else {
            RectF rectF3 = this.f25607IXxxXO;
            Rect rect3 = this.f25670xxX;
            rectF3.set(rect3.left, rect3.top, rect3.right, rect3.bottom);
        }
        RectF rectF4 = this.f25607IXxxXO;
        int i2 = this.f25640XxX0x0xxx;
        canvas.drawRoundRect(rectF4, i2, i2, this.f25644oI0IIXIo);
        if (this.f25666xoO0xx0) {
            RectF rectF5 = this.f25607IXxxXO;
            int i3 = this.f25640XxX0x0xxx;
            canvas.drawRoundRect(rectF5, i3, i3, this.f25623OxxIIOOXO);
        }
        if (!z) {
            if (valueSignCenter - (this.f25650oo0xXOI0I / 2) < this.f25608Io + getPaddingLeft()) {
                i = getPaddingLeft() + (this.f25608Io - valueSignCenter);
            } else if ((this.f25650oo0xXOI0I / 2) + valueSignCenter > (getMeasuredWidth() - this.f25608Io) - getPaddingRight()) {
                i = ((getMeasuredWidth() - this.f25608Io) - valueSignCenter) - getPaddingRight();
            }
            this.f25612O00XxXI.set((valueSignCenter - (this.f25650oo0xXOI0I / 2)) + i, (valueSignSpaceHeight - this.f25658xI) + getPaddingTop());
            this.f25653ox.set((this.f25650oo0xXOI0I / 2) + valueSignCenter + i, (valueSignSpaceHeight - this.f25658xI) + getPaddingTop());
            this.f25627XI0oooXX.set(valueSignCenter + i, valueSignSpaceHeight + getPaddingTop());
            IoOoX(canvas, this.f25612O00XxXI, this.f25653ox, this.f25627XI0oooXX, this.f25644oI0IIXIo);
            if (this.f25666xoO0xx0) {
                oOXoIIIo(canvas, this.f25612O00XxXI, this.f25653ox, this.f25627XI0oooXX, this.f25623OxxIIOOXO);
            }
        }
        if (this.f25634XX0 != null) {
            RectF rectF6 = this.f25607IXxxXO;
            canvas.translate(rectF6.left, (rectF6.top + (rectF6.height() / 2.0f)) - (this.f25634XX0.getHeight() / 2));
            this.f25634XX0.draw(canvas);
        }
    }

    public final void XxX0x0xxx(Canvas canvas) {
        float contentWidth = getContentWidth();
        this.f25630XIxXXX0x0.set(getPaddingLeft(), XX() + getPaddingTop() + XI0IXoo() + getXtop(), ((int) contentWidth) + getPaddingLeft(), this.f25645oOXoIIIo + XX() + getPaddingTop() + XI0IXoo() + getXtop());
        this.f25606IO.setColor(this.f25652ooXIXxIX);
        int height = this.f25630XIxXXX0x0.height() / 2;
        this.f25608Io = height;
        if (height > contentWidth / 2.0f) {
            this.f25633XX = 0;
        }
        this.f25618OOXIxO0.set(this.f25630XIxXXX0x0);
        int i = this.f25633XX;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    this.f25630XIxXXX0x0.set(this.f25608Io + getPaddingLeft(), XX() + XI0IXoo() + getPaddingTop() + getXtop(), (getWidth() - getPaddingRight()) - this.f25608Io, this.f25645oOXoIIIo + XX() + XI0IXoo() + getPaddingTop() + getXtop());
                    canvas.drawRect(this.f25630XIxXXX0x0, this.f25606IO);
                    Point point = this.f25612O00XxXI;
                    Rect rect = this.f25630XIxXXX0x0;
                    int i2 = rect.left;
                    int i3 = this.f25608Io;
                    point.set(i2 - i3, rect.top + i3);
                    Point point2 = this.f25653ox;
                    Rect rect2 = this.f25630XIxXXX0x0;
                    point2.set(rect2.left, rect2.top);
                    Point point3 = this.f25627XI0oooXX;
                    Rect rect3 = this.f25630XIxXXX0x0;
                    point3.set(rect3.left, rect3.bottom);
                    IoOoX(canvas, this.f25612O00XxXI, this.f25653ox, this.f25627XI0oooXX, this.f25606IO);
                    Point point4 = this.f25612O00XxXI;
                    Rect rect4 = this.f25630XIxXXX0x0;
                    int i4 = rect4.right;
                    int i5 = this.f25608Io;
                    point4.set(i4 + i5, rect4.top + i5);
                    Point point5 = this.f25653ox;
                    Rect rect5 = this.f25630XIxXXX0x0;
                    point5.set(rect5.right, rect5.top);
                    Point point6 = this.f25627XI0oooXX;
                    Rect rect6 = this.f25630XIxXXX0x0;
                    point6.set(rect6.right, rect6.bottom);
                    IoOoX(canvas, this.f25612O00XxXI, this.f25653ox, this.f25627XI0oooXX, this.f25606IO);
                }
            } else {
                RectF rectF = this.f25607IXxxXO;
                Rect rect7 = this.f25630XIxXXX0x0;
                rectF.set(rect7.left, rect7.top, rect7.right, rect7.bottom);
                RectF rectF2 = this.f25607IXxxXO;
                int i6 = this.f25608Io;
                canvas.drawRoundRect(rectF2, i6, i6, this.f25606IO);
            }
        } else {
            canvas.drawRect(this.f25630XIxXXX0x0, this.f25606IO);
        }
        if (this.f25641o0) {
            String str = this.f25615OI0;
            this.f25654oxXx0IX.setTextSize(this.f25655oxxXoxO);
            Paint paint = this.f25654oxXx0IX;
            Rect rect8 = this.f25618OOXIxO0;
            oo0xXOI0I(canvas, paint, str, rect8.left, rect8.top, rect8.right, rect8.bottom);
        }
    }

    public int getCurrentBarColor() {
        return this.f25603IIX0o;
    }

    public Integer getValueSegment() {
        return this.f25625X0IIOO;
    }

    public String getValueSegmentText() {
        return this.f25626XI0IXoo;
    }

    public final boolean o0() {
        if (this.f25621OxI == null && this.f25625X0IIOO == null) {
            return true;
        }
        return false;
    }

    public final void oOXoIIIo(Canvas canvas, Point point1, Point point2, Point point3, Paint paint) {
        this.f25643o0xxxXXxX.reset();
        this.f25643o0xxxXXxX.moveTo(point1.x, point1.y);
        this.f25643o0xxxXXxX.lineTo(point2.x, point2.y);
        paint.setColor(this.f25622Oxx0xo.getColor());
        paint.setStrokeWidth(this.f25651ooOx + 1.0f);
        canvas.drawPath(this.f25643o0xxxXXxX, paint);
        this.f25643o0xxxXXxX.reset();
        paint.setStrokeWidth(this.f25651ooOx);
        float f = this.f25651ooOx / 6;
        this.f25643o0xxxXXxX.moveTo(point1.x - f, point1.y - f);
        this.f25643o0xxxXXxX.lineTo(point3.x, point3.y);
        this.f25643o0xxxXXxX.lineTo(point2.x + f, point2.y - f);
        paint.setColor(this.f25661xX0IIXIx0);
        canvas.drawPath(this.f25643o0xxxXXxX, paint);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int size;
        super.onDraw(canvas);
        this.f25663xXxxox0I = -1.0f;
        if (this.f25605IIxOXoOo0) {
            XIxXXX0x0(canvas);
        }
        if (this.f25599I0) {
            xXxxox0I(canvas);
        }
        List<o0Xo.oIX0oI> list = this.f25639Xx000oIo;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        if (size > 0) {
            List<o0Xo.oIX0oI> list2 = this.f25639Xx000oIo;
            o0Xo.oIX0oI oix0oi = list2.get(list2.size() - 1);
            for (int i = 0; i < size; i++) {
                IIX0o(canvas, this.f25639Xx000oIo.get(i), i, size, oix0oi.oxoX());
            }
        } else {
            XxX0x0xxx(canvas);
        }
        if (!o0()) {
            int i2 = this.f25611Ioxxx;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            if (this.f25646oOo) {
                                int i3 = this.f25630XIxXXX0x0.top;
                                ooXIXxIX(canvas, this.f25660xOOOX, this.f25648oXIO0o0XI, this.f25628XIXIX, this.f25663xXxxox0I, (i3 - (r5 / 2)) - this.f25658xI, this.f25644oI0IIXIo);
                                return;
                            }
                            throw new RuntimeException("plase add sbv_sliderImg!!!!!");
                        }
                        return;
                    }
                    xxX(canvas, this.f25648oXIO0o0XI, this.f25628XIXIX, this.f25663xXxxox0I, (this.f25630XIxXXX0x0.top - getXtop()) + (this.f25628XIXIX / 2), this.f25603IIX0o, this.f25644oI0IIXIo);
                    return;
                }
                if (this.f25646oOo) {
                    ooXIXxIX(canvas, this.f25660xOOOX, this.f25648oXIO0o0XI, this.f25628XIXIX, this.f25663xXxxox0I, (this.f25630XIxXXX0x0.top - getXtop()) + (this.f25628XIXIX / 2), this.f25644oI0IIXIo);
                    return;
                }
                throw new RuntimeException("plase add sbv_sliderImg!!!!!");
            }
            Xx000oIo(canvas, XX(), (int) this.f25663xXxxox0I);
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i = this.f25645oOXoIIIo;
        int i2 = this.f25611Ioxxx;
        if (i2 == 2 || i2 == 1) {
            i = Math.max(i, this.f25628XIXIX);
        }
        int paddingBottom = i + getPaddingBottom() + getPaddingTop();
        if (!o0()) {
            paddingBottom += this.f25604IIXOooo + this.f25658xI;
        }
        if (this.f25617OO0x0xX) {
            paddingBottom += this.f25610IoOoo;
        }
        if (this.f25629XIo0oOXIx) {
            paddingBottom += this.f25665xoIxX;
        }
        setMeasuredDimension(View.resolveSizeAndState(paddingLeft, widthMeasureSpec, 0), View.resolveSizeAndState(paddingBottom, heightMeasureSpec, 0));
    }

    public final void oo(Canvas canvas, Paint paint, String text, float left, float top, float right, float bottom, boolean isLeftSegment, boolean isRightSegment, int index) {
        paint.setTextAlign(Paint.Align.CENTER);
        float descent = ((paint.descent() - paint.ascent()) / 2.0f) - paint.descent();
        float measureText = paint.measureText(text);
        if (isLeftSegment) {
            canvas.drawText(text, left + (measureText / 2.0f), ((top + bottom) / 2.0f) + descent, paint);
            return;
        }
        if (isRightSegment) {
            if (this.f25639Xx000oIo.size() <= 2 && text.contains("&")) {
                String[] split = TextUtils.split(text, "&");
                float f = ((top + bottom) / 2.0f) + descent;
                canvas.drawText(split[0], left, f, paint);
                canvas.drawText(split[1], right - (paint.measureText(split[1]) / 2.0f), f, paint);
                return;
            }
            canvas.drawText(text, right - (measureText / 2.0f), ((top + bottom) / 2.0f) + descent, paint);
            return;
        }
        if (!isLeftSegment && !isRightSegment) {
            if (text.contains("&")) {
                String[] split2 = TextUtils.split(text, "&");
                if (index % 2 == 1) {
                    float f2 = ((top + bottom) / 2.0f) + descent;
                    canvas.drawText(split2[0], left, f2, paint);
                    canvas.drawText(split2[1], right, f2, paint);
                    return;
                }
                canvas.drawText(split2[1], right, ((top + bottom) / 2.0f) + descent, paint);
                return;
            }
            return;
        }
        canvas.drawText(text, right - (measureText / 2.0f), ((top + bottom) / 2.0f) + descent, paint);
    }

    public final void oo0xXOI0I(Canvas canvas, Paint paint, String text, float left, float top, float right, float bottom) {
        paint.setTextAlign(Paint.Align.CENTER);
        float descent = ((paint.descent() - paint.ascent()) / 2.0f) - paint.descent();
        if (TextUtils.isEmpty(text)) {
            return;
        }
        canvas.drawText(text, (left + right) / 2.0f, ((top + bottom) / 2.0f) + descent, paint);
    }

    public final void ooXIXxIX(Canvas canvas, Bitmap bitmap, int thumbW, int thumbH, float centerX, float centerY, Paint paint) {
        canvas.drawBitmap(bitmap, centerX - (thumbW / 2), centerY - (thumbH / 2), paint);
    }

    public void setBarHeight(int barHeight) {
        this.f25645oOXoIIIo = barHeight;
        invalidate();
        requestLayout();
    }

    public void setDescriptionBoxHeight(int descriptionBoxHeight) {
        this.f25610IoOoo = descriptionBoxHeight;
        invalidate();
        requestLayout();
    }

    public void setDescriptionTextColor(int descriptionTextColor) {
        this.f25647oX = descriptionTextColor;
        invalidate();
        requestLayout();
    }

    public void setDescriptionTextSize(int descriptionTextSize) {
        this.f25668xoxXI = descriptionTextSize;
        invalidate();
        requestLayout();
    }

    public void setDescriptionTopTextColor(int descriptionTopTextColor) {
        this.f25636Xo0 = descriptionTopTextColor;
        invalidate();
        requestLayout();
    }

    public void setDrawSegmentBg(boolean drawSegmentBg) {
        this.f25605IIxOXoOo0 = drawSegmentBg;
        invalidate();
        requestLayout();
    }

    public void setEmptySegmentColor(int emptySegmentColor) {
        this.f25652ooXIXxIX = emptySegmentColor;
        invalidate();
        requestLayout();
    }

    public void setGapColor(int gapColor) {
        this.f25609IoOoX = gapColor;
        invalidate();
        requestLayout();
    }

    public void setGapWidth(int gapWidth) {
        this.f25649oo = gapWidth;
        invalidate();
        requestLayout();
    }

    public void setSegmentSideRule(int sideRule) {
        this.f25619OX00O0xII = sideRule;
        invalidate();
        requestLayout();
    }

    public void setSegmentTextColor(int segmentTextColor) {
        this.f25638XoX = segmentTextColor;
        invalidate();
        requestLayout();
    }

    public void setSegmentTextSize(int segmentTextSize) {
        this.f25655oxxXoxO = segmentTextSize;
        invalidate();
        requestLayout();
    }

    public void setSegments(List<o0Xo.oIX0oI> segments) {
        this.f25639Xx000oIo = segments;
        invalidate();
        requestLayout();
    }

    public void setShowDescriptionText(boolean showDescriptionText) {
        this.f25617OO0x0xX = showDescriptionText;
        invalidate();
        requestLayout();
    }

    public void setShowSegmentText(boolean showSegmentText) {
        this.f25641o0 = showSegmentText;
        invalidate();
        requestLayout();
    }

    public void setSideStyle(int sideStyle) {
        this.f25633XX = sideStyle;
        invalidate();
        requestLayout();
    }

    public void setSideTextStyle(int sideTextStyle) {
        this.f25602I0oOoX = sideTextStyle;
        invalidate();
        requestLayout();
    }

    public void setUnit(String unit) {
        this.f25624X00IoxXI = unit;
        X0IIOO();
        invalidate();
        requestLayout();
    }

    public void setValue(Float value) {
        this.f25621OxI = value;
        X0IIOO();
        invalidate();
        requestLayout();
    }

    public void setValueSegment(Integer valueSegment) {
        this.f25619OX00O0xII = 1;
        this.f25625X0IIOO = valueSegment;
        invalidate();
        requestLayout();
    }

    public void setValueSegmentText(String valueSegmentText) {
        this.f25626XI0IXoo = valueSegmentText;
        X0IIOO();
        invalidate();
        requestLayout();
    }

    public void setValueSignColor(int valueSignColor) {
        this.f25642o00 = valueSignColor;
        invalidate();
        requestLayout();
    }

    public void setValueTextColor(int valueTextColor) {
        this.f25662xXOx = valueTextColor;
        this.f25600I0X0x0oIo.setColor(valueTextColor);
        invalidate();
        requestLayout();
    }

    public void setValueTextSize(int valueTextSize) {
        this.f25664xo0x = valueTextSize;
        this.f25600I0X0x0oIo.setTextSize(valueTextSize);
        invalidate();
        requestLayout();
    }

    public void x0o(int startColor, int endColor) {
        int[] iArr = this.f25620Oo;
        iArr[0] = startColor;
        iArr[1] = endColor;
        invalidate();
        requestLayout();
    }

    public final void xI(Canvas canvas, Paint paint, String text, Rect outsideRect) {
        oo0xXOI0I(canvas, paint, text, outsideRect.left, outsideRect.top, outsideRect.right, outsideRect.bottom);
    }

    public void xII(int startColor, int endColor) {
        int[] iArr = this.f25631XO;
        iArr[0] = startColor;
        iArr[1] = endColor;
        invalidate();
        requestLayout();
    }

    public final void xXxxox0I(Canvas canvas) {
        List<o0Xo.oIX0oI> list;
        if (this.f25619OX00O0xII == 0 && (list = this.f25639Xx000oIo) != null && !list.isEmpty()) {
            float X0o0xo2 = this.f25639Xx000oIo.get(0).X0o0xo();
            List<o0Xo.oIX0oI> list2 = this.f25639Xx000oIo;
            float oxoX2 = list2.get(list2.size() - 1).oxoX();
            Float f = this.f25621OxI;
            if (f != null && f.floatValue() >= X0o0xo2 && this.f25621OxI.floatValue() <= oxoX2) {
                int i = 0;
                while (true) {
                    if (i < this.f25639Xx000oIo.size()) {
                        if (this.f25621OxI.floatValue() >= this.f25639Xx000oIo.get(i).X0o0xo() && this.f25621OxI.floatValue() <= this.f25639Xx000oIo.get(i).oxoX()) {
                            break;
                        } else {
                            i++;
                        }
                    } else {
                        i = 0;
                        break;
                    }
                }
                float floatValue = this.f25621OxI.floatValue() - X0o0xo2;
                float f2 = oxoX2 - X0o0xo2;
                float f3 = floatValue / f2;
                float contentWidth = (getContentWidth() * f2) / oxoX2;
                int[] iArr = this.f25620Oo;
                int X00IoxXI2 = X00IoxXI(f3, iArr[0], iArr[1]);
                this.f25630XIxXXX0x0.set(getPaddingLeft() + getXLeft(), XX() + getPaddingTop() + XI0IXoo() + getXtop(), ((int) ((int) (getPaddingLeft() + getXLeft() + (f3 * contentWidth)))) + (this.f25648oXIO0o0XI / 3) + (this.f25649oo * i), this.f25645oOXoIIIo + XX() + getPaddingTop() + XI0IXoo() + getXtop());
                Rect rect = this.f25630XIxXXX0x0;
                this.f25656x0o.setShader(new LinearGradient(rect.left, rect.top, rect.right, rect.bottom, this.f25620Oo[0], X00IoxXI2, Shader.TileMode.MIRROR));
                int height = this.f25630XIxXXX0x0.height() / 2;
                this.f25608Io = height;
                if (height > contentWidth / 2.0f) {
                    this.f25633XX = 0;
                }
                this.f25618OOXIxO0.set(this.f25630XIxXXX0x0);
                int i2 = this.f25633XX;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            this.f25630XIxXXX0x0.set(this.f25608Io + getPaddingLeft(), XX() + XI0IXoo() + getPaddingTop(), (getWidth() - getPaddingRight()) - this.f25608Io, this.f25645oOXoIIIo + XX() + XI0IXoo() + getPaddingTop());
                            canvas.drawRect(this.f25630XIxXXX0x0, this.f25656x0o);
                            Point point = this.f25612O00XxXI;
                            Rect rect2 = this.f25630XIxXXX0x0;
                            int i3 = rect2.left;
                            int i4 = this.f25608Io;
                            point.set(i3 - i4, rect2.top + i4);
                            Point point2 = this.f25653ox;
                            Rect rect3 = this.f25630XIxXXX0x0;
                            point2.set(rect3.left, rect3.top);
                            Point point3 = this.f25627XI0oooXX;
                            Rect rect4 = this.f25630XIxXXX0x0;
                            point3.set(rect4.left, rect4.bottom);
                            IoOoX(canvas, this.f25612O00XxXI, this.f25653ox, this.f25627XI0oooXX, this.f25656x0o);
                            Point point4 = this.f25612O00XxXI;
                            Rect rect5 = this.f25630XIxXXX0x0;
                            int i5 = rect5.right;
                            int i6 = this.f25608Io;
                            point4.set(i5 + i6, rect5.top + i6);
                            Point point5 = this.f25653ox;
                            Rect rect6 = this.f25630XIxXXX0x0;
                            point5.set(rect6.right, rect6.top);
                            Point point6 = this.f25627XI0oooXX;
                            Rect rect7 = this.f25630XIxXXX0x0;
                            point6.set(rect7.right, rect7.bottom);
                            IoOoX(canvas, this.f25612O00XxXI, this.f25653ox, this.f25627XI0oooXX, this.f25656x0o);
                            return;
                        }
                        return;
                    }
                    RectF rectF = this.f25607IXxxXO;
                    Rect rect8 = this.f25630XIxXXX0x0;
                    rectF.set(rect8.left, rect8.top, rect8.right, rect8.bottom);
                    RectF rectF2 = this.f25607IXxxXO;
                    int i7 = this.f25608Io;
                    canvas.drawRoundRect(rectF2, i7, i7, this.f25656x0o);
                    return;
                }
                canvas.drawRect(this.f25630XIxXXX0x0, this.f25656x0o);
            }
        }
    }

    public void xxX(Canvas canvas, int thumbW, int thumbH, float centerX, float centerY, int color, Paint paint) {
        paint.setColor(color);
        int max = Math.max(thumbH, thumbW) / 2;
        paint.setMaskFilter(new BlurMaskFilter(5.0f, BlurMaskFilter.Blur.SOLID));
        canvas.drawCircle(centerX, centerY, max, paint);
        paint.setMaskFilter(null);
    }

    public SegmentedBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f25631XO = new int[]{SupportMenu.CATEGORY_MASK, -16776961};
        this.f25620Oo = new int[]{-16776961, -256};
        this.f25663xXxxox0I = -1.0f;
        this.f25608Io = 0;
        this.f25633XX = 1;
        this.f25602I0oOoX = 0;
        this.f25638XoX = -1;
        this.f25662xXOx = -1;
        this.f25647oX = -12303292;
        this.f25636Xo0 = -1;
        this.f25637XoI0Ixx0 = 65536;
        this.f25616OO = -1;
        this.f25605IIxOXoOo0 = false;
        this.f25599I0 = false;
        IO(context, attrs);
    }
}
