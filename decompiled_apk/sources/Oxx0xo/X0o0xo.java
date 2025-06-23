package Oxx0xo;

import IXxxXO.xxIXOIIO;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.Oxx0IOOO;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.oO;
import com.airbnb.lottie.xoIox;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.xXOx;
import x0XOIxOo.x0XOIxOo;
import x0XOIxOo.x0xO0oo;

/* loaded from: classes.dex */
public class X0o0xo extends com.airbnb.lottie.model.layer.oIX0oI {

    /* renamed from: IIX0o, reason: collision with root package name */
    public final Paint f3038IIX0o;

    /* renamed from: IO, reason: collision with root package name */
    @Nullable
    public x0XOIxOo.oIX0oI<Integer, Integer> f3039IO;

    /* renamed from: Io, reason: collision with root package name */
    @Nullable
    public x0XOIxOo.oIX0oI<Float, Float> f3040Io;

    /* renamed from: IoOoX, reason: collision with root package name */
    public final xoIox f3041IoOoX;

    /* renamed from: OI0, reason: collision with root package name */
    @Nullable
    public x0XOIxOo.oIX0oI<Float, Float> f3042OI0;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    @Nullable
    public x0XOIxOo.oIX0oI<Integer, Integer> f3043X00IoxXI;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    @Nullable
    public x0XOIxOo.oIX0oI<Float, Float> f3044XOxIOxOx;

    /* renamed from: XX, reason: collision with root package name */
    @Nullable
    public x0XOIxOo.oIX0oI<Float, Float> f3045XX;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    @Nullable
    public x0XOIxOo.oIX0oI<Integer, Integer> f3046Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public final RectF f3047XxX0x0xxx;

    /* renamed from: o0, reason: collision with root package name */
    @Nullable
    public x0XOIxOo.oIX0oI<Float, Float> f3048o0;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public final Oxx0IOOO f3049oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public final x0XOIxOo f3050oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public final LongSparseArray<String> f3051oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public final Paint f3052ooXIXxIX;

    /* renamed from: x0o, reason: collision with root package name */
    @Nullable
    public x0XOIxOo.oIX0oI<Float, Float> f3053x0o;

    /* renamed from: xI, reason: collision with root package name */
    public final Map<x0xO0oo.I0Io, List<ooOOo0oXI.oxoX>> f3054xI;

    /* renamed from: xII, reason: collision with root package name */
    @Nullable
    public x0XOIxOo.oIX0oI<Integer, Integer> f3055xII;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public final Matrix f3056xXxxox0I;

    /* renamed from: xxX, reason: collision with root package name */
    public final StringBuilder f3057xxX;

    /* loaded from: classes.dex */
    public static /* synthetic */ class I0Io {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f3058oIX0oI;

        static {
            int[] iArr = new int[DocumentData.Justification.values().length];
            f3058oIX0oI = iArr;
            try {
                iArr[DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3058oIX0oI[DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3058oIX0oI[DocumentData.Justification.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class II0xO0 extends Paint {
        public II0xO0(int i) {
            super(i);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* loaded from: classes.dex */
    public class oIX0oI extends Paint {
        public oIX0oI(int i) {
            super(i);
            setStyle(Paint.Style.FILL);
        }
    }

    public X0o0xo(xoIox xoiox, Layer layer) {
        super(xoiox, layer);
        Oo.X0o0xo x0o0xo;
        Oo.X0o0xo x0o0xo2;
        Oo.oxoX oxox;
        Oo.oxoX oxox2;
        this.f3057xxX = new StringBuilder(2);
        this.f3047XxX0x0xxx = new RectF();
        this.f3056xXxxox0I = new Matrix();
        this.f3038IIX0o = new oIX0oI(1);
        this.f3052ooXIXxIX = new II0xO0(1);
        this.f3054xI = new HashMap();
        this.f3051oo0xXOI0I = new LongSparseArray<>();
        this.f3041IoOoX = xoiox;
        this.f3049oOXoIIIo = layer.oIX0oI();
        x0XOIxOo oIX0oI2 = layer.Oo().oIX0oI();
        this.f3050oo = oIX0oI2;
        oIX0oI2.oIX0oI(this);
        xxIXOIIO(oIX0oI2);
        Oo.x0XOIxOo IXxxXO2 = layer.IXxxXO();
        if (IXxxXO2 != null && (oxox2 = IXxxXO2.f2026oIX0oI) != null) {
            x0XOIxOo.oIX0oI<Integer, Integer> oIX0oI3 = oxox2.oIX0oI();
            this.f3046Xx000oIo = oIX0oI3;
            oIX0oI3.oIX0oI(this);
            xxIXOIIO(this.f3046Xx000oIo);
        }
        if (IXxxXO2 != null && (oxox = IXxxXO2.f2025II0xO0) != null) {
            x0XOIxOo.oIX0oI<Integer, Integer> oIX0oI4 = oxox.oIX0oI();
            this.f3039IO = oIX0oI4;
            oIX0oI4.oIX0oI(this);
            xxIXOIIO(this.f3039IO);
        }
        if (IXxxXO2 != null && (x0o0xo2 = IXxxXO2.f2024I0Io) != null) {
            x0XOIxOo.oIX0oI<Float, Float> oIX0oI5 = x0o0xo2.oIX0oI();
            this.f3053x0o = oIX0oI5;
            oIX0oI5.oIX0oI(this);
            xxIXOIIO(this.f3053x0o);
        }
        if (IXxxXO2 != null && (x0o0xo = IXxxXO2.f2027oxoX) != null) {
            x0XOIxOo.oIX0oI<Float, Float> oIX0oI6 = x0o0xo.oIX0oI();
            this.f3042OI0 = oIX0oI6;
            oIX0oI6.oIX0oI(this);
            xxIXOIIO(this.f3042OI0);
        }
    }

    public final boolean I0oOoX(int i) {
        if (Character.getType(i) != 16 && Character.getType(i) != 27 && Character.getType(i) != 6 && Character.getType(i) != 28 && Character.getType(i) != 19) {
            return false;
        }
        return true;
    }

    public final void IO(String str, DocumentData documentData, Canvas canvas, float f) {
        int i = 0;
        while (i < str.length()) {
            String IoOoX2 = IoOoX(str, i);
            i += IoOoX2.length();
            X00IoxXI(IoOoX2, documentData, canvas);
            canvas.translate(this.f3038IIX0o.measureText(IoOoX2) + f, 0.0f);
        }
    }

    public final List<ooOOo0oXI.oxoX> Io(x0xO0oo.I0Io i0Io) {
        if (this.f3054xI.containsKey(i0Io)) {
            return this.f3054xI.get(i0Io);
        }
        List<xxIXOIIO> oIX0oI2 = i0Io.oIX0oI();
        int size = oIX0oI2.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new ooOOo0oXI.oxoX(this.f3041IoOoX, this, oIX0oI2.get(i)));
        }
        this.f3054xI.put(i0Io, arrayList);
        return arrayList;
    }

    public final String IoOoX(String str, int i) {
        int codePointAt = str.codePointAt(i);
        int charCount = Character.charCount(codePointAt) + i;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!I0oOoX(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j = codePointAt;
        if (this.f3051oo0xXOI0I.containsKey(j)) {
            return this.f3051oo0xXOI0I.get(j);
        }
        this.f3057xxX.setLength(0);
        while (i < charCount) {
            int codePointAt3 = str.codePointAt(i);
            this.f3057xxX.appendCodePoint(codePointAt3);
            i += Character.charCount(codePointAt3);
        }
        String sb = this.f3057xxX.toString();
        this.f3051oo0xXOI0I.put(j, sb);
        return sb;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00ab A[LOOP:0: B:16:0x00a9->B:17:0x00ab, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void OI0(com.airbnb.lottie.model.DocumentData r7, x0xO0oo.II0xO0 r8, android.graphics.Matrix r9, android.graphics.Canvas r10) {
        /*
            r6 = this;
            IIXOooo.xoIox.Oxx0IOOO(r9)
            com.airbnb.lottie.xoIox r9 = r6.f3041IoOoX
            java.lang.String r0 = r8.II0xO0()
            java.lang.String r8 = r8.oxoX()
            android.graphics.Typeface r8 = r9.oo(r0, r8)
            if (r8 != 0) goto L14
            return
        L14:
            java.lang.String r9 = r7.f4837oIX0oI
            com.airbnb.lottie.xoIox r0 = r6.f3041IoOoX
            com.airbnb.lottie.IIXOooo r0 = r0.oo0xXOI0I()
            if (r0 == 0) goto L22
            java.lang.String r9 = r0.II0xO0(r9)
        L22:
            android.graphics.Paint r0 = r6.f3038IIX0o
            r0.setTypeface(r8)
            x0XOIxOo.oIX0oI<java.lang.Float, java.lang.Float> r8 = r6.f3045XX
            if (r8 == 0) goto L36
            java.lang.Object r8 = r8.II0XooXoX()
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            goto L47
        L36:
            x0XOIxOo.oIX0oI<java.lang.Float, java.lang.Float> r8 = r6.f3048o0
            if (r8 == 0) goto L45
            java.lang.Object r8 = r8.II0XooXoX()
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            goto L47
        L45:
            float r8 = r7.f4830I0Io
        L47:
            android.graphics.Paint r0 = r6.f3038IIX0o
            float r1 = IIXOooo.xoIox.X0o0xo()
            float r1 = r1 * r8
            r0.setTextSize(r1)
            android.graphics.Paint r0 = r6.f3052ooXIXxIX
            android.graphics.Paint r1 = r6.f3038IIX0o
            android.graphics.Typeface r1 = r1.getTypeface()
            r0.setTypeface(r1)
            android.graphics.Paint r0 = r6.f3052ooXIXxIX
            android.graphics.Paint r1 = r6.f3038IIX0o
            float r1 = r1.getTextSize()
            r0.setTextSize(r1)
            float r0 = r7.f4836XO
            float r1 = IIXOooo.xoIox.X0o0xo()
            float r0 = r0 * r1
            int r1 = r7.f4835X0o0xo
            float r1 = (float) r1
            r2 = 1092616192(0x41200000, float:10.0)
            float r1 = r1 / r2
            x0XOIxOo.oIX0oI<java.lang.Float, java.lang.Float> r2 = r6.f3040Io
            if (r2 == 0) goto L86
            java.lang.Object r2 = r2.II0XooXoX()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
        L84:
            float r1 = r1 + r2
            goto L95
        L86:
            x0XOIxOo.oIX0oI<java.lang.Float, java.lang.Float> r2 = r6.f3042OI0
            if (r2 == 0) goto L95
            java.lang.Object r2 = r2.II0XooXoX()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            goto L84
        L95:
            float r2 = IIXOooo.xoIox.X0o0xo()
            float r1 = r1 * r2
            float r1 = r1 * r8
            r8 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 / r8
            java.util.List r8 = r6.XX(r9)
            int r9 = r8.size()
            r2 = 0
        La9:
            if (r2 >= r9) goto Le2
            java.lang.Object r3 = r8.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            android.graphics.Paint r4 = r6.f3052ooXIXxIX
            float r4 = r4.measureText(r3)
            int r5 = r3.length()
            int r5 = r5 + (-1)
            float r5 = (float) r5
            float r5 = r5 * r1
            float r4 = r4 + r5
            r10.save()
            com.airbnb.lottie.model.DocumentData$Justification r5 = r7.f4838oxoX
            r6.oo(r5, r10, r4)
            int r4 = r9 + (-1)
            float r4 = (float) r4
            float r4 = r4 * r0
            r5 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 / r5
            float r5 = (float) r2
            float r5 = r5 * r0
            float r5 = r5 - r4
            r4 = 0
            r10.translate(r4, r5)
            r6.IO(r3, r7, r10, r1)
            r10.restore()
            int r2 = r2 + 1
            goto La9
        Le2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: Oxx0xo.X0o0xo.OI0(com.airbnb.lottie.model.DocumentData, x0xO0oo.II0xO0, android.graphics.Matrix, android.graphics.Canvas):void");
    }

    public final void X00IoxXI(String str, DocumentData documentData, Canvas canvas) {
        if (documentData.f4833OOXIXo) {
            oOXoIIIo(str, this.f3038IIX0o, canvas);
            oOXoIIIo(str, this.f3052ooXIXxIX, canvas);
        } else {
            oOXoIIIo(str, this.f3052ooXIXxIX, canvas);
            oOXoIIIo(str, this.f3038IIX0o, canvas);
        }
    }

    @Override // com.airbnb.lottie.model.layer.oIX0oI, x0xO0oo.X0o0xo
    public <T> void XO(T t, @Nullable xoXoI.xoIox<T> xoiox) {
        super.XO(t, xoiox);
        if (t == oO.f4979oIX0oI) {
            x0XOIxOo.oIX0oI<Integer, Integer> oix0oi = this.f3043X00IoxXI;
            if (oix0oi != null) {
                XIxXXX0x0(oix0oi);
            }
            if (xoiox == null) {
                this.f3043X00IoxXI = null;
                return;
            }
            x0xO0oo x0xo0oo = new x0xO0oo(xoiox);
            this.f3043X00IoxXI = x0xo0oo;
            x0xo0oo.oIX0oI(this);
            xxIXOIIO(this.f3043X00IoxXI);
            return;
        }
        if (t == oO.f4961II0xO0) {
            x0XOIxOo.oIX0oI<Integer, Integer> oix0oi2 = this.f3055xII;
            if (oix0oi2 != null) {
                XIxXXX0x0(oix0oi2);
            }
            if (xoiox == null) {
                this.f3055xII = null;
                return;
            }
            x0xO0oo x0xo0oo2 = new x0xO0oo(xoiox);
            this.f3055xII = x0xo0oo2;
            x0xo0oo2.oIX0oI(this);
            xxIXOIIO(this.f3055xII);
            return;
        }
        if (t == oO.f4966Oo) {
            x0XOIxOo.oIX0oI<Float, Float> oix0oi3 = this.f3044XOxIOxOx;
            if (oix0oi3 != null) {
                XIxXXX0x0(oix0oi3);
            }
            if (xoiox == null) {
                this.f3044XOxIOxOx = null;
                return;
            }
            x0xO0oo x0xo0oo3 = new x0xO0oo(xoiox);
            this.f3044XOxIOxOx = x0xo0oo3;
            x0xo0oo3.oIX0oI(this);
            xxIXOIIO(this.f3044XOxIOxOx);
            return;
        }
        if (t == oO.f4963IXxxXO) {
            x0XOIxOo.oIX0oI<Float, Float> oix0oi4 = this.f3040Io;
            if (oix0oi4 != null) {
                XIxXXX0x0(oix0oi4);
            }
            if (xoiox == null) {
                this.f3040Io = null;
                return;
            }
            x0xO0oo x0xo0oo4 = new x0xO0oo(xoiox);
            this.f3040Io = x0xo0oo4;
            x0xo0oo4.oIX0oI(this);
            xxIXOIIO(this.f3040Io);
            return;
        }
        if (t == oO.f4990xxX) {
            x0XOIxOo.oIX0oI<Float, Float> oix0oi5 = this.f3045XX;
            if (oix0oi5 != null) {
                XIxXXX0x0(oix0oi5);
            }
            if (xoiox == null) {
                this.f3045XX = null;
                return;
            }
            x0xO0oo x0xo0oo5 = new x0xO0oo(xoiox);
            this.f3045XX = x0xo0oo5;
            x0xo0oo5.oIX0oI(this);
            xxIXOIIO(this.f3045XX);
        }
    }

    public final void XOxIOxOx(DocumentData documentData, Matrix matrix, x0xO0oo.II0xO0 iI0xO0, Canvas canvas) {
        float f;
        x0XOIxOo.oIX0oI<Float, Float> oix0oi = this.f3045XX;
        if (oix0oi != null) {
            f = oix0oi.II0XooXoX().floatValue();
        } else {
            x0XOIxOo.oIX0oI<Float, Float> oix0oi2 = this.f3048o0;
            if (oix0oi2 != null) {
                f = oix0oi2.II0XooXoX().floatValue();
            } else {
                f = documentData.f4830I0Io;
            }
        }
        float f2 = f / 100.0f;
        float Oxx0IOOO2 = IIXOooo.xoIox.Oxx0IOOO(matrix);
        String str = documentData.f4837oIX0oI;
        float X0o0xo2 = documentData.f4836XO * IIXOooo.xoIox.X0o0xo();
        List<String> XX2 = XX(str);
        int size = XX2.size();
        for (int i = 0; i < size; i++) {
            String str2 = XX2.get(i);
            float o02 = o0(str2, iI0xO0, f2, Oxx0IOOO2);
            canvas.save();
            oo(documentData.f4838oxoX, canvas, o02);
            canvas.translate(0.0f, (i * X0o0xo2) - (((size - 1) * X0o0xo2) / 2.0f));
            x0o(str2, documentData, matrix, iI0xO0, canvas, Oxx0IOOO2, f2);
            canvas.restore();
        }
    }

    public final List<String> XX(String str) {
        return Arrays.asList(str.replaceAll("\r\n", xXOx.f32950X0o0xo).replaceAll("\n", xXOx.f32950X0o0xo).split(xXOx.f32950X0o0xo));
    }

    public final void Xx000oIo(x0xO0oo.I0Io i0Io, Matrix matrix, float f, DocumentData documentData, Canvas canvas) {
        List<ooOOo0oXI.oxoX> Io2 = Io(i0Io);
        for (int i = 0; i < Io2.size(); i++) {
            Path path = Io2.get(i).getPath();
            path.computeBounds(this.f3047XxX0x0xxx, false);
            this.f3056xXxxox0I.set(matrix);
            this.f3056xXxxox0I.preTranslate(0.0f, (-documentData.f4834Oxx0IOOO) * IIXOooo.xoIox.X0o0xo());
            this.f3056xXxxox0I.preScale(f, f);
            path.transform(this.f3056xXxxox0I);
            if (documentData.f4833OOXIXo) {
                xII(path, this.f3038IIX0o, canvas);
                xII(path, this.f3052ooXIXxIX, canvas);
            } else {
                xII(path, this.f3052ooXIXxIX, canvas);
                xII(path, this.f3038IIX0o, canvas);
            }
        }
    }

    public final float o0(String str, x0xO0oo.II0xO0 iI0xO0, float f, float f2) {
        float f3 = 0.0f;
        for (int i = 0; i < str.length(); i++) {
            x0xO0oo.I0Io i0Io = this.f3049oOXoIIIo.I0Io().get(x0xO0oo.I0Io.X0o0xo(str.charAt(i), iI0xO0.II0xO0(), iI0xO0.oxoX()));
            if (i0Io != null) {
                f3 = (float) (f3 + (i0Io.oxoX() * f * IIXOooo.xoIox.X0o0xo() * f2));
            }
        }
        return f3;
    }

    @Override // com.airbnb.lottie.model.layer.oIX0oI
    public void oI0IIXIo(Canvas canvas, Matrix matrix, int i) {
        int intValue;
        canvas.save();
        if (!this.f3041IoOoX.OX00O0xII()) {
            canvas.concat(matrix);
        }
        DocumentData II0XooXoX2 = this.f3050oo.II0XooXoX();
        x0xO0oo.II0xO0 iI0xO0 = this.f3049oOXoIIIo.Oxx0IOOO().get(II0XooXoX2.f4832II0xO0);
        if (iI0xO0 == null) {
            canvas.restore();
            return;
        }
        x0XOIxOo.oIX0oI<Integer, Integer> oix0oi = this.f3043X00IoxXI;
        if (oix0oi != null) {
            this.f3038IIX0o.setColor(oix0oi.II0XooXoX().intValue());
        } else {
            x0XOIxOo.oIX0oI<Integer, Integer> oix0oi2 = this.f3046Xx000oIo;
            if (oix0oi2 != null) {
                this.f3038IIX0o.setColor(oix0oi2.II0XooXoX().intValue());
            } else {
                this.f3038IIX0o.setColor(II0XooXoX2.f4831II0XooXoX);
            }
        }
        x0XOIxOo.oIX0oI<Integer, Integer> oix0oi3 = this.f3055xII;
        if (oix0oi3 != null) {
            this.f3052ooXIXxIX.setColor(oix0oi3.II0XooXoX().intValue());
        } else {
            x0XOIxOo.oIX0oI<Integer, Integer> oix0oi4 = this.f3039IO;
            if (oix0oi4 != null) {
                this.f3052ooXIXxIX.setColor(oix0oi4.II0XooXoX().intValue());
            } else {
                this.f3052ooXIXxIX.setColor(II0XooXoX2.f4840xxIXOIIO);
            }
        }
        if (this.f4926IIXOooo.II0XooXoX() == null) {
            intValue = 100;
        } else {
            intValue = this.f4926IIXOooo.II0XooXoX().II0XooXoX().intValue();
        }
        int i2 = (intValue * 255) / 100;
        this.f3038IIX0o.setAlpha(i2);
        this.f3052ooXIXxIX.setAlpha(i2);
        x0XOIxOo.oIX0oI<Float, Float> oix0oi5 = this.f3044XOxIOxOx;
        if (oix0oi5 != null) {
            this.f3052ooXIXxIX.setStrokeWidth(oix0oi5.II0XooXoX().floatValue());
        } else {
            x0XOIxOo.oIX0oI<Float, Float> oix0oi6 = this.f3053x0o;
            if (oix0oi6 != null) {
                this.f3052ooXIXxIX.setStrokeWidth(oix0oi6.II0XooXoX().floatValue());
            } else {
                this.f3052ooXIXxIX.setStrokeWidth(II0XooXoX2.f4839xoIox * IIXOooo.xoIox.X0o0xo() * IIXOooo.xoIox.Oxx0IOOO(matrix));
            }
        }
        if (this.f3041IoOoX.OX00O0xII()) {
            XOxIOxOx(II0XooXoX2, matrix, iI0xO0, canvas);
        } else {
            OI0(II0XooXoX2, iI0xO0, matrix, canvas);
        }
        canvas.restore();
    }

    @Override // com.airbnb.lottie.model.layer.oIX0oI, ooOOo0oXI.X0o0xo
    public void oIX0oI(RectF rectF, Matrix matrix, boolean z) {
        super.oIX0oI(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.f3049oOXoIIIo.II0xO0().width(), this.f3049oOXoIIIo.II0xO0().height());
    }

    public final void oOXoIIIo(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    public final void oo(DocumentData.Justification justification, Canvas canvas, float f) {
        int i = I0Io.f3058oIX0oI[justification.ordinal()];
        if (i != 2) {
            if (i == 3) {
                canvas.translate((-f) / 2.0f, 0.0f);
                return;
            }
            return;
        }
        canvas.translate(-f, 0.0f);
    }

    public final void x0o(String str, DocumentData documentData, Matrix matrix, x0xO0oo.II0xO0 iI0xO0, Canvas canvas, float f, float f2) {
        float floatValue;
        for (int i = 0; i < str.length(); i++) {
            x0xO0oo.I0Io i0Io = this.f3049oOXoIIIo.I0Io().get(x0xO0oo.I0Io.X0o0xo(str.charAt(i), iI0xO0.II0xO0(), iI0xO0.oxoX()));
            if (i0Io != null) {
                Xx000oIo(i0Io, matrix, f2, documentData, canvas);
                float oxoX2 = ((float) i0Io.oxoX()) * f2 * IIXOooo.xoIox.X0o0xo() * f;
                float f3 = documentData.f4835X0o0xo / 10.0f;
                x0XOIxOo.oIX0oI<Float, Float> oix0oi = this.f3040Io;
                if (oix0oi != null) {
                    floatValue = oix0oi.II0XooXoX().floatValue();
                } else {
                    x0XOIxOo.oIX0oI<Float, Float> oix0oi2 = this.f3042OI0;
                    if (oix0oi2 != null) {
                        floatValue = oix0oi2.II0XooXoX().floatValue();
                    }
                    canvas.translate(oxoX2 + (f3 * f), 0.0f);
                }
                f3 += floatValue;
                canvas.translate(oxoX2 + (f3 * f), 0.0f);
            }
        }
    }

    public final void xII(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }
}
