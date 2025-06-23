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
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.oO;
import com.airbnb.lottie.xoIox;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import x0XOIxOo.x0xO0oo;
import x0xO0oo.oxoX;

/* loaded from: classes.dex */
public class II0xO0 extends com.airbnb.lottie.model.layer.oIX0oI {

    /* renamed from: IIX0o, reason: collision with root package name */
    public final RectF f4889IIX0o;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public final List<com.airbnb.lottie.model.layer.oIX0oI> f4890XxX0x0xxx;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    @Nullable
    public Boolean f4891oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public Paint f4892ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    @Nullable
    public Boolean f4893xI;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public final RectF f4894xXxxox0I;

    /* renamed from: xxX, reason: collision with root package name */
    @Nullable
    public x0XOIxOo.oIX0oI<Float, Float> f4895xxX;

    /* loaded from: classes.dex */
    public static /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f4896oIX0oI;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f4896oIX0oI = iArr;
            try {
                iArr[Layer.MatteType.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4896oIX0oI[Layer.MatteType.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public II0xO0(xoIox xoiox, Layer layer, List<Layer> list, Oxx0IOOO oxx0IOOO) {
        super(xoiox, layer);
        int i;
        com.airbnb.lottie.model.layer.oIX0oI oix0oi;
        this.f4890XxX0x0xxx = new ArrayList();
        this.f4894xXxxox0I = new RectF();
        this.f4889IIX0o = new RectF();
        this.f4892ooXIXxIX = new Paint();
        X0o0xo Oxx0xo2 = layer.Oxx0xo();
        if (Oxx0xo2 != null) {
            x0XOIxOo.oIX0oI<Float, Float> oIX0oI2 = Oxx0xo2.oIX0oI();
            this.f4895xxX = oIX0oI2;
            xxIXOIIO(oIX0oI2);
            this.f4895xxX.oIX0oI(this);
        } else {
            this.f4895xxX = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(oxx0IOOO.xoIox().size());
        int size = list.size() - 1;
        com.airbnb.lottie.model.layer.oIX0oI oix0oi2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            com.airbnb.lottie.model.layer.oIX0oI OxxIIOOXO2 = com.airbnb.lottie.model.layer.oIX0oI.OxxIIOOXO(layer2, xoiox, oxx0IOOO);
            if (OxxIIOOXO2 != null) {
                longSparseArray.put(OxxIIOOXO2.IIXOooo().II0xO0(), OxxIIOOXO2);
                if (oix0oi2 != null) {
                    oix0oi2.XxX0x0xxx(OxxIIOOXO2);
                    oix0oi2 = null;
                } else {
                    this.f4890XxX0x0xxx.add(0, OxxIIOOXO2);
                    int i2 = oIX0oI.f4896oIX0oI[layer2.XO().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        oix0oi2 = OxxIIOOXO2;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            com.airbnb.lottie.model.layer.oIX0oI oix0oi3 = (com.airbnb.lottie.model.layer.oIX0oI) longSparseArray.get(longSparseArray.keyAt(i));
            if (oix0oi3 != null && (oix0oi = (com.airbnb.lottie.model.layer.oIX0oI) longSparseArray.get(oix0oi3.IIXOooo().II0XooXoX())) != null) {
                oix0oi3.IIX0o(oix0oi);
            }
        }
    }

    public boolean IoOoX() {
        if (this.f4893xI == null) {
            if (o00()) {
                this.f4893xI = Boolean.TRUE;
                return true;
            }
            for (int size = this.f4890XxX0x0xxx.size() - 1; size >= 0; size--) {
                if (this.f4890XxX0x0xxx.get(size).o00()) {
                    this.f4893xI = Boolean.TRUE;
                    return true;
                }
            }
            this.f4893xI = Boolean.FALSE;
        }
        return this.f4893xI.booleanValue();
    }

    @Override // com.airbnb.lottie.model.layer.oIX0oI, x0xO0oo.X0o0xo
    public <T> void XO(T t, @Nullable xoXoI.xoIox<T> xoiox) {
        super.XO(t, xoiox);
        if (t == oO.f4974XIxXXX0x0) {
            if (xoiox == null) {
                x0XOIxOo.oIX0oI<Float, Float> oix0oi = this.f4895xxX;
                if (oix0oi != null) {
                    oix0oi.x0XOIxOo(null);
                    return;
                }
                return;
            }
            x0xO0oo x0xo0oo = new x0xO0oo(xoiox);
            this.f4895xxX = x0xo0oo;
            x0xo0oo.oIX0oI(this);
            xxIXOIIO(this.f4895xxX);
        }
    }

    @Override // com.airbnb.lottie.model.layer.oIX0oI
    public void oI0IIXIo(Canvas canvas, Matrix matrix, int i) {
        boolean z;
        boolean z2;
        com.airbnb.lottie.X0o0xo.oIX0oI("CompositionLayer#draw");
        this.f4889IIX0o.set(0.0f, 0.0f, this.f4939oO.xoIox(), this.f4939oO.xxIXOIIO());
        matrix.mapRect(this.f4889IIX0o);
        if (this.f4943x0XOIxOo.X00IoxXI() && this.f4890XxX0x0xxx.size() > 1 && i != 255) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.f4892ooXIXxIX.setAlpha(i);
            IIXOooo.xoIox.x0XOIxOo(canvas, this.f4889IIX0o, this.f4892ooXIXxIX);
        } else {
            canvas.save();
        }
        if (z) {
            i = 255;
        }
        for (int size = this.f4890XxX0x0xxx.size() - 1; size >= 0; size--) {
            if (!this.f4889IIX0o.isEmpty()) {
                z2 = canvas.clipRect(this.f4889IIX0o);
            } else {
                z2 = true;
            }
            if (z2) {
                this.f4890XxX0x0xxx.get(size).I0Io(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.airbnb.lottie.X0o0xo.II0xO0("CompositionLayer#draw");
    }

    @Override // com.airbnb.lottie.model.layer.oIX0oI, ooOOo0oXI.X0o0xo
    public void oIX0oI(RectF rectF, Matrix matrix, boolean z) {
        super.oIX0oI(rectF, matrix, z);
        for (int size = this.f4890XxX0x0xxx.size() - 1; size >= 0; size--) {
            this.f4894xXxxox0I.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f4890XxX0x0xxx.get(size).oIX0oI(this.f4894xXxxox0I, this.f4941ooOOo0oXI, true);
            rectF.union(this.f4894xXxxox0I);
        }
    }

    public boolean oo() {
        if (this.f4891oo0xXOI0I == null) {
            for (int size = this.f4890XxX0x0xxx.size() - 1; size >= 0; size--) {
                com.airbnb.lottie.model.layer.oIX0oI oix0oi = this.f4890XxX0x0xxx.get(size);
                if (oix0oi instanceof I0Io) {
                    if (oix0oi.xoXoI()) {
                        this.f4891oo0xXOI0I = Boolean.TRUE;
                        return true;
                    }
                } else if ((oix0oi instanceof II0xO0) && ((II0xO0) oix0oi).oo()) {
                    this.f4891oo0xXOI0I = Boolean.TRUE;
                    return true;
                }
            }
            this.f4891oo0xXOI0I = Boolean.FALSE;
        }
        return this.f4891oo0xXOI0I.booleanValue();
    }

    @Override // com.airbnb.lottie.model.layer.oIX0oI
    public void ooXIXxIX(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        super.ooXIXxIX(f);
        if (this.f4895xxX != null) {
            f = ((this.f4895xxX.II0XooXoX().floatValue() * this.f4939oO.oIX0oI().II0XooXoX()) - this.f4939oO.oIX0oI().x0xO0oo()) / (this.f4943x0XOIxOo.oI0IIXIo().X0o0xo() + 0.01f);
        }
        if (this.f4895xxX == null) {
            f -= this.f4939oO.x0xO0oo();
        }
        if (this.f4939oO.oI0IIXIo() != 0.0f) {
            f /= this.f4939oO.oI0IIXIo();
        }
        for (int size = this.f4890XxX0x0xxx.size() - 1; size >= 0; size--) {
            this.f4890XxX0x0xxx.get(size).ooXIXxIX(f);
        }
    }

    @Override // com.airbnb.lottie.model.layer.oIX0oI
    public void xXxxox0I(boolean z) {
        super.xXxxox0I(z);
        Iterator<com.airbnb.lottie.model.layer.oIX0oI> it = this.f4890XxX0x0xxx.iterator();
        while (it.hasNext()) {
            it.next().xXxxox0I(z);
        }
    }

    @Override // com.airbnb.lottie.model.layer.oIX0oI
    public void xxX(oxoX oxox, int i, List<oxoX> list, oxoX oxox2) {
        for (int i2 = 0; i2 < this.f4890XxX0x0xxx.size(); i2++) {
            this.f4890XxX0x0xxx.get(i2).Oxx0IOOO(oxox, i, list, oxox2);
        }
    }
}
