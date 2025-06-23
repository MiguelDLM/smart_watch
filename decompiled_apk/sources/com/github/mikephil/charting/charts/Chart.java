package com.github.mikephil.charting.charts;

import IIxOXoOo0.X0o0xo;
import Ioxxx.II0xO0;
import XI0oooXX.XO;
import XI0oooXX.oxoX;
import XIXIX.oOoXoXO;
import XX0xXo.I0Io;
import android.animation.ValueAnimator;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.RequiresApi;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.huawei.openalliance.ad.constant.bf;
import com.huawei.openalliance.ad.constant.bn;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import o0xxxXXxX.OOXIXo;
import ox.II0XooXoX;
import ox.x0xO0oo;
import xX0IIXIx0.Oxx0IOOO;
import xX0IIXIx0.xxIXOIIO;

/* loaded from: classes9.dex */
public abstract class Chart<T extends OOXIXo<? extends X0o0xo<? extends Entry>>> extends ViewGroup implements OOXIxO0.X0o0xo {

    /* renamed from: I0oOoX, reason: collision with root package name */
    public static final int f15856I0oOoX = 7;

    /* renamed from: XX, reason: collision with root package name */
    public static final int f15857XX = 4;

    /* renamed from: XoX, reason: collision with root package name */
    public static final int f15858XoX = 13;

    /* renamed from: o0, reason: collision with root package name */
    public static final String f15859o0 = "MPAndroidChart";

    /* renamed from: oxXx0IX, reason: collision with root package name */
    public static final int f15860oxXx0IX = 14;

    /* renamed from: oxxXoxO, reason: collision with root package name */
    public static final int f15861oxxXoxO = 11;

    /* renamed from: xo0x, reason: collision with root package name */
    public static final int f15862xo0x = 18;

    /* renamed from: IIX0o, reason: collision with root package name */
    public Oxx0IOOO f15863IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public Paint f15864IIXOooo;

    /* renamed from: IO, reason: collision with root package name */
    public oxoX[] f15865IO;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f15866IXxxXO;

    /* renamed from: Io, reason: collision with root package name */
    public boolean f15867Io;

    /* renamed from: IoOoX, reason: collision with root package name */
    public float f15868IoOoX;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public I0Io f15869O0xOxO;

    /* renamed from: OI0, reason: collision with root package name */
    public ArrayList<Runnable> f15870OI0;

    /* renamed from: Oo, reason: collision with root package name */
    public T f15871Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public boolean f15872OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f15873Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public II0XooXoX f15874OxxIIOOXO;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public boolean f15875X00IoxXI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public Legend f15876X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public ooOx.oIX0oI f15877XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public ChartTouchListener f15878XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f15879XO;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public XX0xXo.oxoX f15880XOxIOxOx;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public float f15881Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public com.github.mikephil.charting.listener.II0xO0 f15882XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public XAxis f15883o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public float f15884oI0IIXIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public float f15885oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public float f15886oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public Ioxxx.oIX0oI f15887oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public XO f15888ooXIXxIX;

    /* renamed from: x0o, reason: collision with root package name */
    public boolean f15889x0o;

    /* renamed from: xI, reason: collision with root package name */
    public oOoXoXO f15890xI;

    /* renamed from: xII, reason: collision with root package name */
    public float f15891xII;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public xxIXOIIO f15892xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    public Paint f15893xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public String f15894xxX;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f15895oIX0oI;

        static {
            int[] iArr = new int[Bitmap.CompressFormat.values().length];
            f15895oIX0oI = iArr;
            try {
                iArr[Bitmap.CompressFormat.PNG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15895oIX0oI[Bitmap.CompressFormat.WEBP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15895oIX0oI[Bitmap.CompressFormat.JPEG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class oIX0oI implements ValueAnimator.AnimatorUpdateListener {
        public oIX0oI() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Chart.this.postInvalidate();
        }
    }

    public Chart(Context context) {
        super(context);
        this.f15879XO = false;
        this.f15871Oo = null;
        this.f15866IXxxXO = true;
        this.f15873Oxx0xo = true;
        this.f15884oI0IIXIo = 0.9f;
        this.f15874OxxIIOOXO = new II0XooXoX(0);
        this.f15872OxI = true;
        this.f15894xxX = "No chart data available.";
        this.f15890xI = new oOoXoXO();
        this.f15886oo = 0.0f;
        this.f15868IoOoX = 0.0f;
        this.f15885oOXoIIIo = 0.0f;
        this.f15881Xx000oIo = 0.0f;
        this.f15875X00IoxXI = false;
        this.f15891xII = 0.0f;
        this.f15889x0o = true;
        this.f15870OI0 = new ArrayList<>();
        this.f15867Io = false;
        ooXIXxIX();
    }

    public final void I0oOoX(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i < viewGroup.getChildCount()) {
                    I0oOoX(viewGroup.getChildAt(i));
                    i++;
                } else {
                    viewGroup.removeAllViews();
                    return;
                }
            }
        }
    }

    @RequiresApi(11)
    public void II0XooXoX(int i) {
        this.f15887oo0xXOI0I.oIX0oI(i);
    }

    public void IIX0o(oxoX[] oxoxArr) {
        this.f15865IO = oxoxArr;
        setLastHighlighted(oxoxArr);
        invalidate();
    }

    public void IIXOooo(Canvas canvas) {
        if (this.f15880XOxIOxOx != null && oo() && oxxXoxO()) {
            int i = 0;
            while (true) {
                oxoX[] oxoxArr = this.f15865IO;
                if (i < oxoxArr.length) {
                    oxoX oxox = oxoxArr[i];
                    X0o0xo OOXIXo2 = this.f15871Oo.OOXIXo(oxox.oxoX());
                    Entry Oxx0xo2 = this.f15871Oo.Oxx0xo(this.f15865IO[i]);
                    int oxoX2 = OOXIXo2.oxoX(Oxx0xo2);
                    if (Oxx0xo2 != null && oxoX2 <= OOXIXo2.X0xxXX0() * this.f15887oo0xXOI0I.II0XooXoX()) {
                        float[] OxI2 = OxI(oxox);
                        if (this.f15890xI.IIX0o(OxI2[0], OxI2[1])) {
                            this.f15880XOxIOxOx.I0Io(Oxx0xo2, oxox);
                            this.f15880XOxIOxOx.oIX0oI(canvas, OxI2[0], OxI2[1]);
                        }
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public void IO(Runnable runnable) {
        this.f15870OI0.remove(runnable);
    }

    public void IXxxXO() {
        this.f15870OI0.clear();
    }

    public void Io(float f, float f2, float f3, float f4) {
        setExtraLeftOffset(f);
        setExtraTopOffset(f2);
        setExtraRightOffset(f3);
        setExtraBottomOffset(f4);
    }

    public boolean IoOoX() {
        T t = this.f15871Oo;
        if (t == null || t.IXxxXO() <= 0) {
            return true;
        }
        return false;
    }

    public Paint O0xOxO(int i) {
        if (i != 7) {
            if (i != 11) {
                return null;
            }
            return this.f15864IIXOooo;
        }
        return this.f15893xoXoI;
    }

    public boolean OI0(String str, String str2) {
        Bitmap chartBitmap = getChartBitmap();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(Environment.getExternalStorageDirectory().getPath() + str2 + "/" + str + ".png");
            chartBitmap.compress(Bitmap.CompressFormat.PNG, 40, fileOutputStream);
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequiresApi(11)
    public void OOXIXo(int i, int i2, II0xO0.xxX xxx2) {
        this.f15887oo0xXOI0I.oxoX(i, i2, xxx2);
    }

    public void Oo() {
        this.f15871Oo = null;
        this.f15875X00IoxXI = false;
        this.f15865IO = null;
        this.f15878XIxXXX0x0.XO(null);
        invalidate();
    }

    public float[] OxI(oxoX oxox) {
        return new float[]{oxox.X0o0xo(), oxox.XO()};
    }

    public void Oxx0IOOO(Runnable runnable) {
        if (this.f15890xI.XI0IXoo()) {
            post(runnable);
        } else {
            this.f15870OI0.add(runnable);
        }
    }

    public void Oxx0xo() {
        this.f15871Oo.II0XooXoX();
        invalidate();
    }

    public void OxxIIOOXO(Canvas canvas) {
        float f;
        float f2;
        I0Io i0Io = this.f15869O0xOxO;
        if (i0Io != null && i0Io.XO()) {
            XIXIX.Oxx0IOOO ooOOo0oXI2 = this.f15869O0xOxO.ooOOo0oXI();
            this.f15864IIXOooo.setTypeface(this.f15869O0xOxO.I0Io());
            this.f15864IIXOooo.setTextSize(this.f15869O0xOxO.II0xO0());
            this.f15864IIXOooo.setColor(this.f15869O0xOxO.oIX0oI());
            this.f15864IIXOooo.setTextAlign(this.f15869O0xOxO.oO());
            if (ooOOo0oXI2 == null) {
                f2 = (getWidth() - this.f15890xI.xII()) - this.f15869O0xOxO.oxoX();
                f = (getHeight() - this.f15890xI.X00IoxXI()) - this.f15869O0xOxO.X0o0xo();
            } else {
                float f3 = ooOOo0oXI2.f3771IXxxXO;
                f = ooOOo0oXI2.f3772Oxx0xo;
                f2 = f3;
            }
            canvas.drawText(this.f15869O0xOxO.x0XOIxOo(), f2, f, this.f15864IIXOooo);
        }
    }

    public abstract void X00IoxXI();

    public void X0IIOO(float f, float f2, int i) {
        XI0IXoo(f, f2, i, true);
    }

    public void XI0IXoo(float f, float f2, int i, boolean z) {
        if (i >= 0 && i < this.f15871Oo.ooOOo0oXI()) {
            xXxxox0I(new oxoX(f, f2, i), z);
        } else {
            xXxxox0I(null, z);
        }
    }

    public void XIxXXX0x0(float f, int i) {
        xxX(f, i, true);
    }

    public boolean XOxIOxOx(String str, String str2, String str3, Bitmap.CompressFormat compressFormat, int i) {
        String str4;
        if (i < 0 || i > 100) {
            i = 50;
        }
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/" + str2);
        if (!file.exists() && !file.mkdirs()) {
            return false;
        }
        int i2 = II0xO0.f15895oIX0oI[compressFormat.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                str4 = "image/jpeg";
                if (!str.endsWith(".jpg") && !str.endsWith(".jpeg")) {
                    str = str + ".jpg";
                }
            } else {
                str4 = "image/webp";
                if (!str.endsWith(".webp")) {
                    str = str + ".webp";
                }
            }
        } else {
            boolean endsWith = str.endsWith(".png");
            str4 = bf.Z;
            if (!endsWith) {
                str = str + ".png";
            }
        }
        String str5 = file.getAbsolutePath() + "/" + str;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str5);
            getChartBitmap().compress(compressFormat, i, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            long length = new File(str5).length();
            ContentValues contentValues = new ContentValues(8);
            contentValues.put("title", str);
            contentValues.put("_display_name", str);
            contentValues.put("date_added", Long.valueOf(currentTimeMillis));
            contentValues.put("mime_type", str4);
            contentValues.put("description", str3);
            contentValues.put(bn.f.V, (Integer) 0);
            contentValues.put("_data", str5);
            contentValues.put("_size", Long.valueOf(length));
            if (getContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues) == null) {
                return false;
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void XX(float f, float f2) {
        float max;
        T t = this.f15871Oo;
        if (t != null && t.IXxxXO() >= 2) {
            max = Math.abs(f2 - f);
        } else {
            max = Math.max(Math.abs(f), Math.abs(f2));
        }
        this.f15874OxxIIOOXO.ooOOo0oXI(XIXIX.OOXIXo.IXxxXO(max));
    }

    public boolean Xx000oIo() {
        return this.f15879XO;
    }

    public void XxX0x0xxx(oxoX oxox) {
        xXxxox0I(oxox, false);
    }

    public Ioxxx.oIX0oI getAnimator() {
        return this.f15887oo0xXOI0I;
    }

    public XIXIX.Oxx0IOOO getCenter() {
        return XIXIX.Oxx0IOOO.I0Io(getWidth() / 2.0f, getHeight() / 2.0f);
    }

    @Override // OOXIxO0.X0o0xo
    public XIXIX.Oxx0IOOO getCenterOfView() {
        return getCenter();
    }

    @Override // OOXIxO0.X0o0xo
    public XIXIX.Oxx0IOOO getCenterOffsets() {
        return this.f15890xI.x0xO0oo();
    }

    public Bitmap getChartBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        draw(canvas);
        return createBitmap;
    }

    @Override // OOXIxO0.X0o0xo
    public RectF getContentRect() {
        return this.f15890xI.Oo();
    }

    public T getData() {
        return this.f15871Oo;
    }

    @Override // OOXIxO0.X0o0xo
    public x0xO0oo getDefaultValueFormatter() {
        return this.f15874OxxIIOOXO;
    }

    public I0Io getDescription() {
        return this.f15869O0xOxO;
    }

    public float getDragDecelerationFrictionCoef() {
        return this.f15884oI0IIXIo;
    }

    public float getExtraBottomOffset() {
        return this.f15885oOXoIIIo;
    }

    public float getExtraLeftOffset() {
        return this.f15881Xx000oIo;
    }

    public float getExtraRightOffset() {
        return this.f15868IoOoX;
    }

    public float getExtraTopOffset() {
        return this.f15886oo;
    }

    public oxoX[] getHighlighted() {
        return this.f15865IO;
    }

    public XO getHighlighter() {
        return this.f15888ooXIXxIX;
    }

    public ArrayList<Runnable> getJobs() {
        return this.f15870OI0;
    }

    public Legend getLegend() {
        return this.f15876X0IIOO;
    }

    public xxIXOIIO getLegendRenderer() {
        return this.f15892xXxxox0I;
    }

    public XX0xXo.oxoX getMarker() {
        return this.f15880XOxIOxOx;
    }

    @Deprecated
    public XX0xXo.oxoX getMarkerView() {
        return getMarker();
    }

    @Override // OOXIxO0.X0o0xo
    public float getMaxHighlightDistance() {
        return this.f15891xII;
    }

    public com.github.mikephil.charting.listener.II0xO0 getOnChartGestureListener() {
        return this.f15882XxX0x0xxx;
    }

    public ChartTouchListener getOnTouchListener() {
        return this.f15878XIxXXX0x0;
    }

    public Oxx0IOOO getRenderer() {
        return this.f15863IIX0o;
    }

    public oOoXoXO getViewPortHandler() {
        return this.f15890xI;
    }

    public XAxis getXAxis() {
        return this.f15883o00;
    }

    @Override // OOXIxO0.X0o0xo
    public float getXChartMax() {
        return this.f15883o00.f4006IIX0o;
    }

    @Override // OOXIxO0.X0o0xo
    public float getXChartMin() {
        return this.f15883o00.f4025ooXIXxIX;
    }

    @Override // OOXIxO0.X0o0xo
    public float getXRange() {
        return this.f15883o00.f4028xI;
    }

    public float getYMax() {
        return this.f15871Oo.O0xOxO();
    }

    public float getYMin() {
        return this.f15871Oo.XI0IXoo();
    }

    public void o0(Paint paint, int i) {
        if (i != 7) {
            if (i == 11) {
                this.f15864IIXOooo = paint;
                return;
            }
            return;
        }
        this.f15893xoXoI = paint;
    }

    public oxoX o00(float f, float f2) {
        if (this.f15871Oo == null) {
            Log.e(f15859o0, "Can't select by touch. No data set.");
            return null;
        }
        return getHighlighter().oIX0oI(f, f2);
    }

    public void oI0IIXIo() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public abstract void oO();

    public boolean oOXoIIIo() {
        return this.f15866IXxxXO;
    }

    @RequiresApi(11)
    public void oOoXoXO(int i, int i2, II0xO0.xxX xxx2, II0xO0.xxX xxx3) {
        this.f15887oo0xXOI0I.X0o0xo(i, i2, xxx2, xxx3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f15867Io) {
            I0oOoX(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f15871Oo == null) {
            if (!TextUtils.isEmpty(this.f15894xxX)) {
                XIXIX.Oxx0IOOO center = getCenter();
                canvas.drawText(this.f15894xxX, center.f3771IXxxXO, center.f3772Oxx0xo, this.f15893xoXoI);
                return;
            }
            return;
        }
        if (!this.f15875X00IoxXI) {
            x0xO0oo();
            this.f15875X00IoxXI = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            getChildAt(i5).layout(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int X0o0xo2 = (int) XIXIX.OOXIXo.X0o0xo(50.0f);
        setMeasuredDimension(Math.max(getSuggestedMinimumWidth(), View.resolveSize(X0o0xo2, i)), Math.max(getSuggestedMinimumHeight(), View.resolveSize(X0o0xo2, i2)));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.f15879XO) {
            Log.i(f15859o0, "OnSizeChanged()");
        }
        if (i > 0 && i2 > 0 && i < 10000 && i2 < 10000) {
            if (this.f15879XO) {
                Log.i(f15859o0, "Setting chart dimens, width: " + i + ", height: " + i2);
            }
            this.f15890xI.o0(i, i2);
        } else if (this.f15879XO) {
            Log.w(f15859o0, "*Avoiding* setting chart dimens! width: " + i + ", height: " + i2);
        }
        X00IoxXI();
        Iterator<Runnable> it = this.f15870OI0.iterator();
        while (it.hasNext()) {
            post(it.next());
        }
        this.f15870OI0.clear();
        super.onSizeChanged(i, i2, i3, i4);
    }

    public boolean oo() {
        return this.f15889x0o;
    }

    @Deprecated
    public boolean oo0xXOI0I() {
        return oo();
    }

    @RequiresApi(11)
    public void ooOOo0oXI(int i) {
        this.f15887oo0xXOI0I.XO(i);
    }

    public void ooXIXxIX() {
        setWillNotDraw(false);
        this.f15887oo0xXOI0I = new Ioxxx.oIX0oI(new oIX0oI());
        XIXIX.OOXIXo.ooXIXxIX(getContext());
        this.f15891xII = XIXIX.OOXIXo.X0o0xo(500.0f);
        this.f15869O0xOxO = new I0Io();
        Legend legend = new Legend();
        this.f15876X0IIOO = legend;
        this.f15892xXxxox0I = new xxIXOIIO(this.f15890xI, legend);
        this.f15883o00 = new XAxis();
        this.f15864IIXOooo = new Paint(1);
        Paint paint = new Paint(1);
        this.f15893xoXoI = paint;
        paint.setColor(Color.rgb(247, PsExtractor.PRIVATE_STREAM_1, 51));
        this.f15893xoXoI.setTextAlign(Paint.Align.CENTER);
        this.f15893xoXoI.setTextSize(XIXIX.OOXIXo.X0o0xo(12.0f));
        if (this.f15879XO) {
            Log.i("", "Chart.init()");
        }
    }

    public boolean oxxXoxO() {
        oxoX[] oxoxArr = this.f15865IO;
        if (oxoxArr == null || oxoxArr.length <= 0 || oxoxArr[0] == null) {
            return false;
        }
        return true;
    }

    public void setData(T t) {
        this.f15871Oo = t;
        this.f15875X00IoxXI = false;
        if (t == null) {
            return;
        }
        XX(t.XI0IXoo(), t.O0xOxO());
        for (X0o0xo x0o0xo : this.f15871Oo.Oo()) {
            if (x0o0xo.IXO() || x0o0xo.xxIO() == this.f15874OxxIIOOXO) {
                x0o0xo.O0Xx(this.f15874OxxIIOOXO);
            }
        }
        X00IoxXI();
        if (this.f15879XO) {
            Log.i(f15859o0, "Data is set.");
        }
    }

    public void setDescription(I0Io i0Io) {
        this.f15869O0xOxO = i0Io;
    }

    public void setDragDecelerationEnabled(boolean z) {
        this.f15873Oxx0xo = z;
    }

    public void setDragDecelerationFrictionCoef(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f >= 1.0f) {
            f = 0.999f;
        }
        this.f15884oI0IIXIo = f;
    }

    @Deprecated
    public void setDrawMarkerViews(boolean z) {
        setDrawMarkers(z);
    }

    public void setDrawMarkers(boolean z) {
        this.f15889x0o = z;
    }

    public void setExtraBottomOffset(float f) {
        this.f15885oOXoIIIo = XIXIX.OOXIXo.X0o0xo(f);
    }

    public void setExtraLeftOffset(float f) {
        this.f15881Xx000oIo = XIXIX.OOXIXo.X0o0xo(f);
    }

    public void setExtraRightOffset(float f) {
        this.f15868IoOoX = XIXIX.OOXIXo.X0o0xo(f);
    }

    public void setExtraTopOffset(float f) {
        this.f15886oo = XIXIX.OOXIXo.X0o0xo(f);
    }

    public void setHardwareAccelerationEnabled(boolean z) {
        if (z) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
    }

    public void setHighlightPerTapEnabled(boolean z) {
        this.f15866IXxxXO = z;
    }

    public void setHighlighter(XI0oooXX.II0xO0 iI0xO0) {
        this.f15888ooXIXxIX = iI0xO0;
    }

    public void setLastHighlighted(oxoX[] oxoxArr) {
        oxoX oxox;
        if (oxoxArr != null && oxoxArr.length > 0 && (oxox = oxoxArr[0]) != null) {
            this.f15878XIxXXX0x0.XO(oxox);
        } else {
            this.f15878XIxXXX0x0.XO(null);
        }
    }

    public void setLogEnabled(boolean z) {
        this.f15879XO = z;
    }

    public void setMarker(XX0xXo.oxoX oxox) {
        this.f15880XOxIOxOx = oxox;
    }

    @Deprecated
    public void setMarkerView(XX0xXo.oxoX oxox) {
        setMarker(oxox);
    }

    public void setMaxHighlightDistance(float f) {
        this.f15891xII = XIXIX.OOXIXo.X0o0xo(f);
    }

    public void setNoDataText(String str) {
        this.f15894xxX = str;
    }

    public void setNoDataTextColor(int i) {
        this.f15893xoXoI.setColor(i);
    }

    public void setNoDataTextTypeface(Typeface typeface) {
        this.f15893xoXoI.setTypeface(typeface);
    }

    public void setOnChartGestureListener(com.github.mikephil.charting.listener.II0xO0 iI0xO0) {
        this.f15882XxX0x0xxx = iI0xO0;
    }

    public void setOnChartValueSelectedListener(ooOx.oIX0oI oix0oi) {
        this.f15877XI0IXoo = oix0oi;
    }

    public void setOnTouchListener(ChartTouchListener chartTouchListener) {
        this.f15878XIxXXX0x0 = chartTouchListener;
    }

    public void setRenderer(Oxx0IOOO oxx0IOOO) {
        if (oxx0IOOO != null) {
            this.f15863IIX0o = oxx0IOOO;
        }
    }

    public void setTouchEnabled(boolean z) {
        this.f15872OxI = z;
    }

    public void setUnbindEnabled(boolean z) {
        this.f15867Io = z;
    }

    @RequiresApi(11)
    public void x0XOIxOo(int i, II0xO0.xxX xxx2) {
        this.f15887oo0xXOI0I.Oxx0IOOO(i, xxx2);
    }

    public boolean x0o(String str, int i) {
        return XOxIOxOx(str, "", "MPAndroidChart-Library Save", Bitmap.CompressFormat.PNG, i);
    }

    public abstract void x0xO0oo();

    public boolean xI() {
        return this.f15873Oxx0xo;
    }

    public boolean xII(String str) {
        return XOxIOxOx(str, "", "MPAndroidChart-Library Save", Bitmap.CompressFormat.PNG, 40);
    }

    public void xXxxox0I(oxoX oxox, boolean z) {
        Entry entry = null;
        if (oxox == null) {
            this.f15865IO = null;
        } else {
            if (this.f15879XO) {
                Log.i(f15859o0, "Highlighted: " + oxox.toString());
            }
            Entry Oxx0xo2 = this.f15871Oo.Oxx0xo(oxox);
            if (Oxx0xo2 == null) {
                this.f15865IO = null;
                oxox = null;
            } else {
                this.f15865IO = new oxoX[]{oxox};
            }
            entry = Oxx0xo2;
        }
        setLastHighlighted(this.f15865IO);
        if (z && this.f15877XI0IXoo != null) {
            if (!oxxXoxO()) {
                this.f15877XI0IXoo.II0xO0();
            } else {
                this.f15877XI0IXoo.oIX0oI(entry, oxox);
            }
        }
        invalidate();
    }

    @RequiresApi(11)
    public void xoIox(int i, int i2) {
        this.f15887oo0xXOI0I.I0Io(i, i2);
    }

    public void xoXoI() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    @RequiresApi(11)
    public void xxIXOIIO(int i, II0xO0.xxX xxx2) {
        this.f15887oo0xXOI0I.II0xO0(i, xxx2);
    }

    public void xxX(float f, int i, boolean z) {
        XI0IXoo(f, Float.NaN, i, z);
    }

    public Chart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15879XO = false;
        this.f15871Oo = null;
        this.f15866IXxxXO = true;
        this.f15873Oxx0xo = true;
        this.f15884oI0IIXIo = 0.9f;
        this.f15874OxxIIOOXO = new II0XooXoX(0);
        this.f15872OxI = true;
        this.f15894xxX = "No chart data available.";
        this.f15890xI = new oOoXoXO();
        this.f15886oo = 0.0f;
        this.f15868IoOoX = 0.0f;
        this.f15885oOXoIIIo = 0.0f;
        this.f15881Xx000oIo = 0.0f;
        this.f15875X00IoxXI = false;
        this.f15891xII = 0.0f;
        this.f15889x0o = true;
        this.f15870OI0 = new ArrayList<>();
        this.f15867Io = false;
        ooXIXxIX();
    }

    public Chart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15879XO = false;
        this.f15871Oo = null;
        this.f15866IXxxXO = true;
        this.f15873Oxx0xo = true;
        this.f15884oI0IIXIo = 0.9f;
        this.f15874OxxIIOOXO = new II0XooXoX(0);
        this.f15872OxI = true;
        this.f15894xxX = "No chart data available.";
        this.f15890xI = new oOoXoXO();
        this.f15886oo = 0.0f;
        this.f15868IoOoX = 0.0f;
        this.f15885oOXoIIIo = 0.0f;
        this.f15881Xx000oIo = 0.0f;
        this.f15875X00IoxXI = false;
        this.f15891xII = 0.0f;
        this.f15889x0o = true;
        this.f15870OI0 = new ArrayList<>();
        this.f15867Io = false;
        ooXIXxIX();
    }
}
