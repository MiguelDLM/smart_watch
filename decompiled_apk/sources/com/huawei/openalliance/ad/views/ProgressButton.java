package com.huawei.openalliance.ad.views;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.download.app.k;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.w;
import java.util.Locale;

/* loaded from: classes10.dex */
public class ProgressButton extends View implements View.OnClickListener {
    private long A;
    String B;
    int C;
    protected Rect Code;
    protected final byte[] D;
    private Paint E;
    protected Drawable F;
    private boolean G;
    private a H;
    protected CharSequence I;
    protected int L;
    int S;
    protected Paint V;

    /* renamed from: a, reason: collision with root package name */
    protected int f17432a;
    protected int b;
    protected int c;
    protected boolean d;
    protected boolean e;
    protected int f;
    private String n;
    private int o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private int u;
    private float v;
    private Float w;
    private int x;
    private int y;
    private Drawable z;

    /* loaded from: classes10.dex */
    public interface a {
        void Code(int i, int i2);
    }

    public ProgressButton(Context context) {
        this(context, null);
        Z();
    }

    private void B() {
        if (this.d) {
            int i = this.t;
            if (i <= 0) {
                i = getMeasuredHeight();
            }
            if (i <= 0) {
                return;
            }
            boolean z = i < this.L;
            this.f17432a = w.V(getContext(), z ? 24 : 36);
            this.b = w.V(getContext(), z ? 8 : 16);
            this.c = (i / 2) + (w.V(getContext(), 12) / 2) + w.V(getContext(), z ? 4 : 8);
            fb.Code(this.n, "update text safe padding, start: %s, end: %s", Integer.valueOf(this.b), Integer.valueOf(this.c));
        }
    }

    private void C() {
        Paint paint = new Paint();
        paint.setTextSize(this.v);
        Rect rect = new Rect();
        paint.getTextBounds("...", 0, 3, rect);
        this.o = rect.width();
    }

    private float Code(CharSequence charSequence, float f) {
        fb.Code(this.n, "startSize:%s", Float.valueOf(f));
        int paddingSize = getPaddingSize();
        int buttonSize = getButtonSize();
        int Code = w.Code(getContext(), f);
        while (Code > 9 && !Code(charSequence, Code, paddingSize, buttonSize)) {
            Code--;
        }
        float Z = w.Z(getContext(), Code);
        fb.Code(this.n, "resultSize:%s", Float.valueOf(Z));
        return Z;
    }

    private void S() {
        synchronized (this.D) {
            try {
                int[] drawableState = getDrawableState();
                Drawable drawable = this.F;
                if (drawable != null && drawable.isStateful()) {
                    this.F.setState(drawableState);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void Z() {
        Paint paint = new Paint();
        this.V = paint;
        paint.setAntiAlias(true);
        this.V.setTextSize(this.v);
        this.V.setColor(this.u);
        Paint paint2 = new Paint();
        this.E = paint2;
        paint2.setTextSize(this.v);
        int i = this.S;
        if (i != -1) {
            this.B = null;
        }
        Code(this.B, this.C, i);
        setClickable(true);
        Paint paint3 = new Paint();
        paint3.setTextSize(this.v);
        Rect rect = new Rect();
        paint3.getTextBounds("...", 0, 3, rect);
        this.o = rect.width();
        this.G = bc.C();
        this.L = w.V(getContext(), 40.0f);
    }

    private int getButtonSize() {
        if (!this.p) {
            return this.r;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int width = getWidth();
        return width <= 0 ? layoutParams.width : width;
    }

    private int getPaddingSize() {
        return Code(getPaddingStart(), getPaddingLeft(), this.b) + Code(getPaddingEnd(), getPaddingRight(), this.c);
    }

    private void setOriginTextSize(Float f) {
        if (f != null) {
            Float f2 = this.w;
            if (f2 == null || f2.floatValue() == 0.0f) {
                this.w = f;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0081 A[Catch: all -> 0x004f, TryCatch #0 {all -> 0x004f, blocks: (B:4:0x0003, B:6:0x0007, B:9:0x000f, B:11:0x004d, B:14:0x0051, B:16:0x0055, B:17:0x0057, B:19:0x005b, B:20:0x006a, B:22:0x006e, B:23:0x0071, B:24:0x007d, B:26:0x0081, B:27:0x0088, B:29:0x0075, B:31:0x0079, B:32:0x008a), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void I() {
        /*
            r6 = this;
            byte[] r0 = r6.D
            monitor-enter(r0)
            java.lang.CharSequence r1 = r6.I     // Catch: java.lang.Throwable -> L4f
            if (r1 == 0) goto L8a
            int r1 = r1.length()     // Catch: java.lang.Throwable -> L4f
            if (r1 != 0) goto Lf
            goto L8a
        Lf:
            android.graphics.Paint r1 = r6.V     // Catch: java.lang.Throwable -> L4f
            java.lang.CharSequence r2 = r6.I     // Catch: java.lang.Throwable -> L4f
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L4f
            java.lang.CharSequence r3 = r6.I     // Catch: java.lang.Throwable -> L4f
            int r3 = r3.length()     // Catch: java.lang.Throwable -> L4f
            android.graphics.Rect r4 = r6.Code     // Catch: java.lang.Throwable -> L4f
            r5 = 0
            r1.getTextBounds(r2, r5, r3, r4)     // Catch: java.lang.Throwable -> L4f
            int r1 = r6.getPaddingStart()     // Catch: java.lang.Throwable -> L4f
            int r2 = r6.getPaddingLeft()     // Catch: java.lang.Throwable -> L4f
            int r3 = r6.b     // Catch: java.lang.Throwable -> L4f
            int r1 = r6.Code(r1, r2, r3)     // Catch: java.lang.Throwable -> L4f
            int r2 = r6.getPaddingEnd()     // Catch: java.lang.Throwable -> L4f
            int r3 = r6.getPaddingRight()     // Catch: java.lang.Throwable -> L4f
            int r4 = r6.c     // Catch: java.lang.Throwable -> L4f
            int r2 = r6.Code(r2, r3, r4)     // Catch: java.lang.Throwable -> L4f
            android.graphics.Rect r3 = r6.Code     // Catch: java.lang.Throwable -> L4f
            int r3 = r3.width()     // Catch: java.lang.Throwable -> L4f
            int r3 = r3 + r1
            int r3 = r3 + r2
            android.view.ViewGroup$LayoutParams r1 = r6.getLayoutParams()     // Catch: java.lang.Throwable -> L4f
            if (r1 != 0) goto L51
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4f
            return
        L4f:
            r1 = move-exception
            goto L8c
        L51:
            int r2 = r6.t     // Catch: java.lang.Throwable -> L4f
            if (r2 <= 0) goto L57
            r1.height = r2     // Catch: java.lang.Throwable -> L4f
        L57:
            int r2 = r1.height     // Catch: java.lang.Throwable -> L4f
            if (r2 > 0) goto L6a
            float r2 = r6.v     // Catch: java.lang.Throwable -> L4f
            int r2 = (int) r2     // Catch: java.lang.Throwable -> L4f
            int r4 = r6.getPaddingTop()     // Catch: java.lang.Throwable -> L4f
            int r2 = r2 + r4
            int r4 = r6.getPaddingBottom()     // Catch: java.lang.Throwable -> L4f
            int r2 = r2 + r4
            r1.height = r2     // Catch: java.lang.Throwable -> L4f
        L6a:
            boolean r2 = r6.p     // Catch: java.lang.Throwable -> L4f
            if (r2 == 0) goto L75
            r6.V(r3, r1)     // Catch: java.lang.Throwable -> L4f
        L71:
            r6.setLayoutParams(r1)     // Catch: java.lang.Throwable -> L4f
            goto L7d
        L75:
            int r2 = r1.width     // Catch: java.lang.Throwable -> L4f
            if (r3 == r2) goto L7d
            r6.Code(r3, r1)     // Catch: java.lang.Throwable -> L4f
            goto L71
        L7d:
            com.huawei.openalliance.ad.views.ProgressButton$a r2 = r6.H     // Catch: java.lang.Throwable -> L4f
            if (r2 == 0) goto L88
            int r3 = r1.width     // Catch: java.lang.Throwable -> L4f
            int r1 = r1.height     // Catch: java.lang.Throwable -> L4f
            r2.Code(r3, r1)     // Catch: java.lang.Throwable -> L4f
        L88:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4f
            return
        L8a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4f
            return
        L8c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4f
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.views.ProgressButton.I():void");
    }

    public void V() {
        this.t = ((int) this.v) + getPaddingTop() + getPaddingBottom();
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        fb.Code(this.n, "drawableStateChanged");
        super.drawableStateChanged();
        S();
    }

    public int getProgress() {
        int i;
        synchronized (this.D) {
            i = this.x;
        }
        return i;
    }

    public Drawable getProgressDrawable() {
        Drawable drawable;
        synchronized (this.D) {
            drawable = this.F;
        }
        return drawable;
    }

    public Rect getPromptRect() {
        Rect rect;
        synchronized (this.D) {
            rect = this.Code;
        }
        return rect;
    }

    public k getStatus() {
        return null;
    }

    public CharSequence getText() {
        CharSequence charSequence;
        synchronized (this.D) {
            charSequence = this.I;
        }
        return charSequence;
    }

    public int getTextStart() {
        if (bc.C()) {
            return this.c;
        }
        int width = ((getWidth() - this.Code.width()) - this.f17432a) / 2;
        int i = this.b;
        if (width < i) {
            width = i;
        }
        fb.Code(this.n, "safeTextStart: %s", Integer.valueOf(width));
        return width;
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        synchronized (this.D) {
            try {
                super.jumpDrawablesToCurrentState();
                Drawable drawable = this.F;
                if (drawable != null) {
                    drawable.jumpToCurrentState();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        synchronized (this.D) {
            try {
                super.onDraw(canvas);
                Drawable drawable = this.z;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                if (Code(drawable)) {
                    canvas.scale(-1.0f, 1.0f, getWidth() / 2.0f, getHeight() / 2.0f);
                }
                Code(canvas);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(savedState.Code);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState Code;
        synchronized (this.D) {
            Code = SavedState.Code(super.onSaveInstanceState());
            Code.Code = this.x;
        }
        return Code;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Code(i, i2);
    }

    public void setFixedWidth(boolean z) {
        this.p = z;
    }

    public void setFontFamily(String str) {
        this.B = str;
        Code(str, this.C, this.S);
    }

    public void setMax(int i) {
        synchronized (this.D) {
            if (i < 0) {
                i = 0;
            }
            try {
                if (i != this.y) {
                    this.y = i;
                    postInvalidate();
                    if (this.x > i) {
                        this.x = i;
                    }
                    V(this.x, false);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setMaxWidth(int i) {
        synchronized (this.D) {
            this.r = i;
        }
    }

    public void setMinWidth(int i) {
        synchronized (this.D) {
            this.s = i;
        }
    }

    public void setPaintTypeface(Typeface typeface) {
        synchronized (this.D) {
            this.V.setTypeface(typeface);
        }
    }

    public void setProgress(int i) {
        synchronized (this.D) {
            Code(i, false);
        }
    }

    public void setProgressDrawable(Drawable drawable) {
        Code(drawable, 0);
    }

    public void setResetListener(a aVar) {
        this.H = aVar;
    }

    public void setResetWidth(boolean z) {
        this.q = z;
    }

    public void setText(CharSequence charSequence) {
        fb.Code(this.n, "setText:%s, need safepadding: %s", charSequence, Boolean.valueOf(this.d));
        synchronized (this.D) {
            try {
                B();
                this.I = String.valueOf(charSequence).toUpperCase(Locale.getDefault());
                Float f = this.w;
                float Code = Code(this.I, f != null ? f.floatValue() : this.v);
                if (!TextUtils.isEmpty(charSequence) && Math.abs(Code - this.v) >= 0.5f) {
                    setTextSize(Code);
                }
                if (getWidth() <= 0 && !this.q) {
                    post(new Runnable() { // from class: com.huawei.openalliance.ad.views.ProgressButton.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (fb.Code()) {
                                fb.Code(ProgressButton.this.n, "view post, resetButtonSize");
                            }
                            ProgressButton.this.I();
                        }
                    });
                    invalidate();
                }
                I();
                invalidate();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setTextColor(int i) {
        this.u = i;
        Paint paint = this.V;
        if (paint != null) {
            paint.setColor(i);
        }
    }

    public void setTextSize(float f) {
        this.v = f;
        setOriginTextSize(Float.valueOf(f));
        Paint paint = this.V;
        if (paint != null) {
            paint.setAntiAlias(true);
            this.V.setTextSize(this.v);
        }
        C();
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        boolean z;
        synchronized (this.D) {
            try {
                z = drawable == this.F || super.verifyDrawable(drawable);
            } finally {
            }
        }
        return z;
    }

    /* loaded from: classes10.dex */
    public static final class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.huawei.openalliance.ad.views.ProgressButton.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: Code, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: Code, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private static SavedState V;
        int Code;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Code = parcel.readInt();
        }

        public static SavedState Code(Parcelable parcelable) {
            if (V == null) {
                V = new SavedState(parcelable);
            }
            return V;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Code);
        }

        private SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public ProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.progressBarStyle);
        Code(context, attributeSet);
        Z();
    }

    private int Code(int i, int i2, int i3) {
        if (i <= 0) {
            i = i2;
        }
        return (!this.d || i3 <= 0 || i >= i3) ? i : i3;
    }

    private void V(int i, ViewGroup.LayoutParams layoutParams) {
        int width = getWidth();
        if (width <= 0 && this.q) {
            width = layoutParams.width;
        }
        if (i > width && width > 0) {
            CharSequence Code = Code(this.I, i, width);
            this.I = Code;
            this.V.getTextBounds(Code.toString(), 0, this.I.length(), this.Code);
        } else {
            if (width > 0 || !this.q) {
                return;
            }
            layoutParams.width = i;
        }
    }

    public ProgressButton(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
        Code(context, attributeSet);
        Z();
    }

    private CharSequence Code(CharSequence charSequence, int i, int i2) {
        int length = getText().length();
        int ceil = (int) Math.ceil(((i - i2) / getPromptRect().width()) * length);
        int ceil2 = (int) Math.ceil((this.o * length) / getPromptRect().width());
        int i3 = length - ceil;
        if (i3 - ceil2 <= 0) {
            return i3 > 0 ? charSequence.toString().substring(0, i3) : charSequence;
        }
        return charSequence.toString().substring(0, length - (ceil + ceil2)) + "...";
    }

    private void V(int i, boolean z) {
        synchronized (this.D) {
            Code(i, z, true);
        }
    }

    public ProgressButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.n = "ProgressBtn_" + hashCode();
        this.Code = new Rect();
        this.p = false;
        this.q = true;
        this.u = -1;
        this.v = 12.0f;
        this.w = null;
        this.B = null;
        this.C = -1;
        this.S = -1;
        this.x = 0;
        this.y = 100;
        this.D = new byte[0];
        this.d = false;
        setOnClickListener(this);
        Code(context, attributeSet);
        Z();
    }

    public void Code(float f, boolean z) {
    }

    public void Code(int i, int i2) {
        synchronized (this.D) {
            try {
                Drawable drawable = this.F;
                if (drawable != null) {
                    drawable.setBounds(0, 0, i, i2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void Code(int i, ViewGroup.LayoutParams layoutParams) {
        int i2 = this.r;
        if (i <= i2 || i2 <= 0) {
            int i3 = this.s;
            if (i < i3) {
                i = i3;
            }
        } else {
            CharSequence Code = Code(this.I, i, i2);
            this.I = Code;
            this.V.getTextBounds(Code.toString(), 0, this.I.length(), this.Code);
            i = this.r;
        }
        layoutParams.width = i;
    }

    public void Code(int i, boolean z) {
        synchronized (this.D) {
            if (i < 0) {
                i = 0;
            }
            try {
                int i2 = this.y;
                if (i > i2) {
                    i = i2;
                }
                if (i != this.x) {
                    this.x = i;
                    V(i, z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void Code(int i, boolean z, boolean z2) {
        synchronized (this.D) {
            try {
                int i2 = this.y;
                float f = i2 > 0 ? i / i2 : 0.0f;
                Drawable drawable = this.z;
                if (drawable != null) {
                    drawable.setLevel((int) (10000.0f * f));
                } else {
                    invalidate();
                }
                if (z2) {
                    Code(f, z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void Code(Context context, AttributeSet attributeSet) {
        synchronized (this.D) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button);
                TypedArray typedArray = null;
                try {
                    typedArray = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.layout_height});
                    int dimensionPixelSize = typedArray.getDimensionPixelSize(0, -2);
                    this.t = dimensionPixelSize;
                    fb.Code(this.n, "layoutHeight: %s", Integer.valueOf(dimensionPixelSize));
                } catch (Throwable th) {
                    try {
                        fb.I(this.n, "get layout height ex: %s", th.getClass().getSimpleName());
                    } finally {
                        if (typedArray != null) {
                            typedArray.recycle();
                        }
                    }
                }
                try {
                    try {
                        try {
                            this.p = obtainStyledAttributes.getBoolean(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_fixedWidth, false);
                            this.q = obtainStyledAttributes.getBoolean(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_resetWidth, true);
                            this.r = obtainStyledAttributes.getDimensionPixelSize(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_maxWidth, 0);
                            this.s = obtainStyledAttributes.getDimensionPixelSize(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_minWidth, 0);
                            float dimension = obtainStyledAttributes.getDimension(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_textSize, 0.0f);
                            this.v = dimension;
                            setOriginTextSize(Float.valueOf(dimension));
                            this.u = obtainStyledAttributes.getColor(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_textColor, -1);
                            this.B = obtainStyledAttributes.getString(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_fontFamily);
                            this.S = obtainStyledAttributes.getInt(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_styleIndex, -1);
                            this.C = obtainStyledAttributes.getInt(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_typefaceIndex, -1);
                        } finally {
                            obtainStyledAttributes.recycle();
                        }
                    } catch (Exception unused) {
                        fb.I(this.n, "initButtonAttr error");
                    }
                } catch (RuntimeException unused2) {
                    fb.I(this.n, "initButtonAttr RuntimeException");
                }
                if (this.t <= 0) {
                    this.t = ((int) this.v) + getPaddingTop() + getPaddingBottom();
                }
            }
        }
    }

    public void Code(Canvas canvas) {
        Rect rect;
        synchronized (this.D) {
            try {
                CharSequence charSequence = this.I;
                if (charSequence != null && charSequence.length() > 0) {
                    if (this.V != null && (rect = this.Code) != null && rect.width() <= 0) {
                        this.V.getTextBounds(this.I.toString(), 0, this.I.length(), this.Code);
                    }
                    String intern = this.I.toString().intern();
                    int width = (getWidth() / 2) - this.Code.centerX();
                    if (this.d && width < this.f17432a) {
                        width = getTextStart();
                    }
                    canvas.drawText((CharSequence) intern, 0, intern.length(), width, (getHeight() / 2) - this.Code.centerY(), this.V);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void Code(Typeface typeface, int i) {
        if (i <= 0) {
            this.V.setFakeBoldText(false);
            this.V.setTextSkewX(0.0f);
            setPaintTypeface(typeface);
        } else {
            Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i) : Typeface.create(typeface, i);
            setPaintTypeface(defaultFromStyle);
            int i2 = (~(defaultFromStyle != null ? defaultFromStyle.getStyle() : 0)) & i;
            this.V.setFakeBoldText((i2 & 1) != 0);
            this.V.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    public void Code(Drawable drawable, int i) {
        boolean z;
        synchronized (this.D) {
            try {
                Drawable drawable2 = this.F;
                if (drawable2 == null || drawable == drawable2) {
                    z = false;
                } else {
                    drawable2.setCallback(null);
                    this.F.setState(new int[0]);
                    z = true;
                }
                if (drawable != null) {
                    drawable.setCallback(this);
                }
                this.F = drawable;
                this.z = drawable;
                if (z) {
                    Code(getWidth(), getHeight());
                    if (i < 0) {
                        i = 0;
                    }
                    int i2 = this.y;
                    if (i > i2) {
                        i = i2;
                    }
                    this.x = i;
                    Code(i, false, false);
                } else {
                    setProgress(i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void Code(CharSequence charSequence, boolean z) {
        this.d = z;
        setText(charSequence);
    }

    private void Code(String str, int i, int i2) {
        Typeface typeface;
        fb.Code(this.n, "setTypefaceFromAttrs");
        if (str != null) {
            typeface = Typeface.create(str, i2);
            if (typeface != null) {
                fb.Code(this.n, "setTypeface");
                setPaintTypeface(typeface);
                this.V.setTypeface(typeface);
                return;
            }
        } else {
            typeface = null;
        }
        if (i == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i == 2) {
            typeface = Typeface.SERIF;
        } else if (i == 3) {
            typeface = Typeface.MONOSPACE;
        }
        Code(typeface, i2);
    }

    public boolean Code() {
        if (System.currentTimeMillis() - this.A < 500) {
            return true;
        }
        this.A = System.currentTimeMillis();
        return false;
    }

    private boolean Code(Drawable drawable) {
        Drawable findDrawableByLayerId;
        if (drawable == null || !(drawable instanceof LayerDrawable) || (findDrawableByLayerId = ((LayerDrawable) drawable).findDrawableByLayerId(R.id.progress)) == null) {
            return false;
        }
        if ((findDrawableByLayerId instanceof f) || (findDrawableByLayerId instanceof g)) {
            return this.G;
        }
        return false;
    }

    private boolean Code(CharSequence charSequence, int i, int i2, int i3) {
        float Z = w.Z(getContext(), i);
        fb.Code(this.n, "currentSize:%s", Float.valueOf(Z));
        fb.Code(this.n, "buttonSize:%s", Integer.valueOf(i3));
        if (i3 < 0) {
            return true;
        }
        this.E.setTextSize(Z);
        this.E.getTextBounds(charSequence.toString(), 0, charSequence.length(), this.Code);
        int width = this.Code.width() + i2;
        fb.Code(this.n, "textWidth:%s, btnWidth:%s", Integer.valueOf(width), Integer.valueOf(i3));
        return width <= i3;
    }
}
