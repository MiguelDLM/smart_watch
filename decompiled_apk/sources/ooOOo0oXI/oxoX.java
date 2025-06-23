package ooOOo0oXI;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import x0XOIxOo.oIX0oI;

/* loaded from: classes.dex */
public class oxoX implements X0o0xo, x0XOIxOo, oIX0oI.II0xO0, x0xO0oo.X0o0xo {

    /* renamed from: I0Io, reason: collision with root package name */
    public final Matrix f32415I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final List<I0Io> f32416II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public RectF f32417II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @Nullable
    public x0XOIxOo.oO f32418OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final boolean f32419Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final RectF f32420X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final String f32421XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Paint f32422oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final Path f32423oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    @Nullable
    public List<x0XOIxOo> f32424xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public final com.airbnb.lottie.xoIox f32425xxIXOIIO;

    public oxoX(com.airbnb.lottie.xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi, IXxxXO.xxIXOIIO xxixoiio) {
        this(xoiox, oix0oi, xxixoiio.I0Io(), xxixoiio.oxoX(), II0xO0(xoiox, oix0oi, xxixoiio.II0xO0()), II0XooXoX(xxixoiio.II0xO0()));
    }

    @Nullable
    public static Oo.oO II0XooXoX(List<IXxxXO.II0xO0> list) {
        for (int i = 0; i < list.size(); i++) {
            IXxxXO.II0xO0 iI0xO0 = list.get(i);
            if (iI0xO0 instanceof Oo.oO) {
                return (Oo.oO) iI0xO0;
            }
        }
        return null;
    }

    public static List<I0Io> II0xO0(com.airbnb.lottie.xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi, List<IXxxXO.II0xO0> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            I0Io oIX0oI2 = list.get(i).oIX0oI(xoiox, oix0oi);
            if (oIX0oI2 != null) {
                arrayList.add(oIX0oI2);
            }
        }
        return arrayList;
    }

    @Override // ooOOo0oXI.X0o0xo
    public void I0Io(Canvas canvas, Matrix matrix, int i) {
        boolean z;
        int intValue;
        if (this.f32419Oxx0IOOO) {
            return;
        }
        this.f32415I0Io.set(matrix);
        x0XOIxOo.oO oOVar = this.f32418OOXIXo;
        if (oOVar != null) {
            this.f32415I0Io.preConcat(oOVar.XO());
            if (this.f32418OOXIXo.II0XooXoX() == null) {
                intValue = 100;
            } else {
                intValue = this.f32418OOXIXo.II0XooXoX().II0XooXoX().intValue();
            }
            i = (int) ((((intValue / 100.0f) * i) / 255.0f) * 255.0f);
        }
        if (this.f32425xxIXOIIO.X00IoxXI() && OOXIXo() && i != 255) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.f32417II0xO0.set(0.0f, 0.0f, 0.0f, 0.0f);
            oIX0oI(this.f32417II0xO0, this.f32415I0Io, true);
            this.f32422oIX0oI.setAlpha(i);
            IIXOooo.xoIox.x0XOIxOo(canvas, this.f32417II0xO0, this.f32422oIX0oI);
        }
        if (z) {
            i = 255;
        }
        for (int size = this.f32416II0XooXoX.size() - 1; size >= 0; size--) {
            I0Io i0Io = this.f32416II0XooXoX.get(size);
            if (i0Io instanceof X0o0xo) {
                ((X0o0xo) i0Io).I0Io(canvas, this.f32415I0Io, i);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    public final boolean OOXIXo() {
        int i = 0;
        for (int i2 = 0; i2 < this.f32416II0XooXoX.size(); i2++) {
            if ((this.f32416II0XooXoX.get(i2) instanceof X0o0xo) && (i = i + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // x0xO0oo.X0o0xo
    public void Oxx0IOOO(x0xO0oo.oxoX oxox, int i, List<x0xO0oo.oxoX> list, x0xO0oo.oxoX oxox2) {
        if (!oxox.II0XooXoX(getName(), i) && !"__container".equals(getName())) {
            return;
        }
        if (!"__container".equals(getName())) {
            oxox2 = oxox2.oIX0oI(getName());
            if (oxox.I0Io(getName(), i)) {
                list.add(oxox2.xoIox(this));
            }
        }
        if (oxox.xxIXOIIO(getName(), i)) {
            int X0o0xo2 = i + oxox.X0o0xo(getName(), i);
            for (int i2 = 0; i2 < this.f32416II0XooXoX.size(); i2++) {
                I0Io i0Io = this.f32416II0XooXoX.get(i2);
                if (i0Io instanceof x0xO0oo.X0o0xo) {
                    ((x0xO0oo.X0o0xo) i0Io).Oxx0IOOO(oxox, X0o0xo2, list, oxox2);
                }
            }
        }
    }

    @Override // ooOOo0oXI.I0Io
    public void X0o0xo(List<I0Io> list, List<I0Io> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f32416II0XooXoX.size());
        arrayList.addAll(list);
        for (int size = this.f32416II0XooXoX.size() - 1; size >= 0; size--) {
            I0Io i0Io = this.f32416II0XooXoX.get(size);
            i0Io.X0o0xo(arrayList, this.f32416II0XooXoX.subList(0, size));
            arrayList.add(i0Io);
        }
    }

    @Override // x0xO0oo.X0o0xo
    public <T> void XO(T t, @Nullable xoXoI.xoIox<T> xoiox) {
        x0XOIxOo.oO oOVar = this.f32418OOXIXo;
        if (oOVar != null) {
            oOVar.I0Io(t, xoiox);
        }
    }

    @Override // ooOOo0oXI.I0Io
    public String getName() {
        return this.f32421XO;
    }

    @Override // ooOOo0oXI.x0XOIxOo
    public Path getPath() {
        this.f32415I0Io.reset();
        x0XOIxOo.oO oOVar = this.f32418OOXIXo;
        if (oOVar != null) {
            this.f32415I0Io.set(oOVar.XO());
        }
        this.f32423oxoX.reset();
        if (this.f32419Oxx0IOOO) {
            return this.f32423oxoX;
        }
        for (int size = this.f32416II0XooXoX.size() - 1; size >= 0; size--) {
            I0Io i0Io = this.f32416II0XooXoX.get(size);
            if (i0Io instanceof x0XOIxOo) {
                this.f32423oxoX.addPath(((x0XOIxOo) i0Io).getPath(), this.f32415I0Io);
            }
        }
        return this.f32423oxoX;
    }

    @Override // ooOOo0oXI.X0o0xo
    public void oIX0oI(RectF rectF, Matrix matrix, boolean z) {
        this.f32415I0Io.set(matrix);
        x0XOIxOo.oO oOVar = this.f32418OOXIXo;
        if (oOVar != null) {
            this.f32415I0Io.preConcat(oOVar.XO());
        }
        this.f32420X0o0xo.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f32416II0XooXoX.size() - 1; size >= 0; size--) {
            I0Io i0Io = this.f32416II0XooXoX.get(size);
            if (i0Io instanceof X0o0xo) {
                ((X0o0xo) i0Io).oIX0oI(this.f32420X0o0xo, this.f32415I0Io, z);
                rectF.union(this.f32420X0o0xo);
            }
        }
    }

    @Override // x0XOIxOo.oIX0oI.II0xO0
    public void oxoX() {
        this.f32425xxIXOIIO.invalidateSelf();
    }

    public Matrix xoIox() {
        x0XOIxOo.oO oOVar = this.f32418OOXIXo;
        if (oOVar != null) {
            return oOVar.XO();
        }
        this.f32415I0Io.reset();
        return this.f32415I0Io;
    }

    public List<x0XOIxOo> xxIXOIIO() {
        if (this.f32424xoIox == null) {
            this.f32424xoIox = new ArrayList();
            for (int i = 0; i < this.f32416II0XooXoX.size(); i++) {
                I0Io i0Io = this.f32416II0XooXoX.get(i);
                if (i0Io instanceof x0XOIxOo) {
                    this.f32424xoIox.add((x0XOIxOo) i0Io);
                }
            }
        }
        return this.f32424xoIox;
    }

    public oxoX(com.airbnb.lottie.xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi, String str, boolean z, List<I0Io> list, @Nullable Oo.oO oOVar) {
        this.f32422oIX0oI = new oOoXoXO.oIX0oI();
        this.f32417II0xO0 = new RectF();
        this.f32415I0Io = new Matrix();
        this.f32423oxoX = new Path();
        this.f32420X0o0xo = new RectF();
        this.f32421XO = str;
        this.f32425xxIXOIIO = xoiox;
        this.f32419Oxx0IOOO = z;
        this.f32416II0XooXoX = list;
        if (oOVar != null) {
            x0XOIxOo.oO II0xO02 = oOVar.II0xO0();
            this.f32418OOXIXo = II0xO02;
            II0xO02.oIX0oI(oix0oi);
            this.f32418OOXIXo.II0xO0(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            I0Io i0Io = list.get(size);
            if (i0Io instanceof xoIox) {
                arrayList.add((xoIox) i0Io);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((xoIox) arrayList.get(size2)).II0xO0(list.listIterator(list.size()));
        }
    }
}
