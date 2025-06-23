package com.airbnb.lottie.model.layer;

import Oo.X0o0xo;
import Oxx0xo.I0Io;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.Oxx0IOOO;
import com.airbnb.lottie.oO;
import com.airbnb.lottie.xoIox;
import java.util.ArrayList;
import java.util.List;
import x0XOIxOo.x0xO0oo;
import x0xO0oo.oxoX;

public class II0xO0 extends oIX0oI {

    /* renamed from: IIX0o  reason: collision with root package name */
    public final RectF f895IIX0o = new RectF();

    /* renamed from: XxX0x0xxx  reason: collision with root package name */
    public final List<oIX0oI> f896XxX0x0xxx = new ArrayList();
    @Nullable

    /* renamed from: oo0xXOI0I  reason: collision with root package name */
    public Boolean f897oo0xXOI0I;

    /* renamed from: ooXIXxIX  reason: collision with root package name */
    public Paint f898ooXIXxIX = new Paint();
    @Nullable

    /* renamed from: xI  reason: collision with root package name */
    public Boolean f899xI;

    /* renamed from: xXxxox0I  reason: collision with root package name */
    public final RectF f900xXxxox0I = new RectF();
    @Nullable

    /* renamed from: xxX  reason: collision with root package name */
    public x0XOIxOo.oIX0oI<Float, Float> f901xxX;

    public static /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI  reason: collision with root package name */
        public static final /* synthetic */ int[] f902oIX0oI;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.airbnb.lottie.model.layer.Layer$MatteType[] r0 = com.airbnb.lottie.model.layer.Layer.MatteType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f902oIX0oI = r0
                com.airbnb.lottie.model.layer.Layer$MatteType r1 = com.airbnb.lottie.model.layer.Layer.MatteType.ADD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f902oIX0oI     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.layer.Layer$MatteType r1 = com.airbnb.lottie.model.layer.Layer.MatteType.INVERT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.II0xO0.oIX0oI.<clinit>():void");
        }
    }

    public II0xO0(xoIox xoiox, Layer layer, List<Layer> list, Oxx0IOOO oxx0IOOO) {
        super(xoiox, layer);
        int i;
        oIX0oI oix0oi;
        X0o0xo Oxx0xo2 = layer.Oxx0xo();
        if (Oxx0xo2 != null) {
            x0XOIxOo.oIX0oI<Float, Float> oIX0oI2 = Oxx0xo2.oIX0oI();
            this.f901xxX = oIX0oI2;
            xxIXOIIO(oIX0oI2);
            this.f901xxX.oIX0oI(this);
        } else {
            this.f901xxX = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(oxx0IOOO.xoIox().size());
        int size = list.size() - 1;
        oIX0oI oix0oi2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            oIX0oI OxxIIOOXO2 = oIX0oI.OxxIIOOXO(layer2, xoiox, oxx0IOOO);
            if (OxxIIOOXO2 != null) {
                longSparseArray.put(OxxIIOOXO2.IIXOooo().II0xO0(), OxxIIOOXO2);
                if (oix0oi2 != null) {
                    oix0oi2.XxX0x0xxx(OxxIIOOXO2);
                    oix0oi2 = null;
                } else {
                    this.f896XxX0x0xxx.add(0, OxxIIOOXO2);
                    int i2 = oIX0oI.f902oIX0oI[layer2.XO().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        oix0oi2 = OxxIIOOXO2;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            oIX0oI oix0oi3 = (oIX0oI) longSparseArray.get(longSparseArray.keyAt(i));
            if (!(oix0oi3 == null || (oix0oi = (oIX0oI) longSparseArray.get(oix0oi3.IIXOooo().II0XooXoX())) == null)) {
                oix0oi3.IIX0o(oix0oi);
            }
        }
    }

    public boolean IoOoX() {
        if (this.f899xI == null) {
            if (o00()) {
                this.f899xI = Boolean.TRUE;
                return true;
            }
            for (int size = this.f896XxX0x0xxx.size() - 1; size >= 0; size--) {
                if (this.f896XxX0x0xxx.get(size).o00()) {
                    this.f899xI = Boolean.TRUE;
                    return true;
                }
            }
            this.f899xI = Boolean.FALSE;
        }
        return this.f899xI.booleanValue();
    }

    public <T> void XO(T t, @Nullable xoXoI.xoIox<T> xoiox) {
        super.XO(t, xoiox);
        if (t != oO.f980XIxXXX0x0) {
            return;
        }
        if (xoiox == null) {
            x0XOIxOo.oIX0oI<Float, Float> oix0oi = this.f901xxX;
            if (oix0oi != null) {
                oix0oi.x0XOIxOo((xoXoI.xoIox<Float>) null);
                return;
            }
            return;
        }
        x0xO0oo x0xo0oo = new x0xO0oo(xoiox);
        this.f901xxX = x0xo0oo;
        x0xo0oo.oIX0oI(this);
        xxIXOIIO(this.f901xxX);
    }

    public void oI0IIXIo(Canvas canvas, Matrix matrix, int i) {
        boolean z;
        boolean z2;
        com.airbnb.lottie.X0o0xo.oIX0oI("CompositionLayer#draw");
        this.f895IIX0o.set(0.0f, 0.0f, (float) this.f945oO.xoIox(), (float) this.f945oO.xxIXOIIO());
        matrix.mapRect(this.f895IIX0o);
        if (!this.f949x0XOIxOo.X00IoxXI() || this.f896XxX0x0xxx.size() <= 1 || i == 255) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.f898ooXIXxIX.setAlpha(i);
            IIXOooo.xoIox.x0XOIxOo(canvas, this.f895IIX0o, this.f898ooXIXxIX);
        } else {
            canvas.save();
        }
        if (z) {
            i = 255;
        }
        for (int size = this.f896XxX0x0xxx.size() - 1; size >= 0; size--) {
            if (!this.f895IIX0o.isEmpty()) {
                z2 = canvas.clipRect(this.f895IIX0o);
            } else {
                z2 = true;
            }
            if (z2) {
                this.f896XxX0x0xxx.get(size).I0Io(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.airbnb.lottie.X0o0xo.II0xO0("CompositionLayer#draw");
    }

    public void oIX0oI(RectF rectF, Matrix matrix, boolean z) {
        super.oIX0oI(rectF, matrix, z);
        for (int size = this.f896XxX0x0xxx.size() - 1; size >= 0; size--) {
            this.f900xXxxox0I.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f896XxX0x0xxx.get(size).oIX0oI(this.f900xXxxox0I, this.f947ooOOo0oXI, true);
            rectF.union(this.f900xXxxox0I);
        }
    }

    public boolean oo() {
        if (this.f897oo0xXOI0I == null) {
            for (int size = this.f896XxX0x0xxx.size() - 1; size >= 0; size--) {
                oIX0oI oix0oi = this.f896XxX0x0xxx.get(size);
                if (oix0oi instanceof I0Io) {
                    if (oix0oi.xoXoI()) {
                        this.f897oo0xXOI0I = Boolean.TRUE;
                        return true;
                    }
                } else if ((oix0oi instanceof II0xO0) && ((II0xO0) oix0oi).oo()) {
                    this.f897oo0xXOI0I = Boolean.TRUE;
                    return true;
                }
            }
            this.f897oo0xXOI0I = Boolean.FALSE;
        }
        return this.f897oo0xXOI0I.booleanValue();
    }

    public void ooXIXxIX(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        super.ooXIXxIX(f);
        if (this.f901xxX != null) {
            f = ((this.f901xxX.II0XooXoX().floatValue() * this.f945oO.oIX0oI().II0XooXoX()) - this.f945oO.oIX0oI().x0xO0oo()) / (this.f949x0XOIxOo.oI0IIXIo().X0o0xo() + 0.01f);
        }
        if (this.f901xxX == null) {
            f -= this.f945oO.x0xO0oo();
        }
        if (this.f945oO.oI0IIXIo() != 0.0f) {
            f /= this.f945oO.oI0IIXIo();
        }
        for (int size = this.f896XxX0x0xxx.size() - 1; size >= 0; size--) {
            this.f896XxX0x0xxx.get(size).ooXIXxIX(f);
        }
    }

    public void xXxxox0I(boolean z) {
        super.xXxxox0I(z);
        for (oIX0oI xXxxox0I2 : this.f896XxX0x0xxx) {
            xXxxox0I2.xXxxox0I(z);
        }
    }

    public void xxX(oxoX oxox, int i, List<oxoX> list, oxoX oxox2) {
        for (int i2 = 0; i2 < this.f896XxX0x0xxx.size(); i2++) {
            this.f896XxX0x0xxx.get(i2).Oxx0IOOO(oxox, i, list, oxox2);
        }
    }
}
