package com.airbnb.lottie.model.layer;

import IIXOooo.XO;
import Oxx0xo.oxoX;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.xoIox;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import ooOOo0oXI.X0o0xo;
import x0XOIxOo.I0Io;
import x0XOIxOo.Oxx0IOOO;
import x0XOIxOo.oIX0oI;
import x0XOIxOo.oO;

/* loaded from: classes.dex */
public abstract class oIX0oI implements X0o0xo, oIX0oI.II0xO0, x0xO0oo.X0o0xo {

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final int f4919O0xOxO = 2;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final int f4920X0IIOO = 16;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final int f4921XI0IXoo = 1;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final int f4922XIxXXX0x0 = 19;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final RectF f4924II0XooXoX;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public final oO f4926IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    @Nullable
    public oIX0oI f4927IXxxXO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public final RectF f4928OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    @Nullable
    public I0Io f4929Oo;

    /* renamed from: OxI, reason: collision with root package name */
    @Nullable
    public Paint f4930OxI;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final Paint f4931Oxx0IOOO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @Nullable
    public oIX0oI f4932Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public final List<x0XOIxOo.oIX0oI<?, ?>> f4933OxxIIOOXO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final Paint f4934X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final Paint f4935XO;

    /* renamed from: o00, reason: collision with root package name */
    public boolean f4936o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public List<oIX0oI> f4937oI0IIXIo;

    /* renamed from: oO, reason: collision with root package name */
    public final Layer f4939oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public final String f4940oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public final Matrix f4941ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final Paint f4942oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public final xoIox f4943x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    @Nullable
    public Oxx0IOOO f4944x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public final RectF f4945xoIox;

    /* renamed from: xoXoI, reason: collision with root package name */
    public boolean f4946xoXoI;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public final RectF f4947xxIXOIIO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Path f4938oIX0oI = new Path();

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Matrix f4925II0xO0 = new Matrix();

    /* renamed from: I0Io, reason: collision with root package name */
    public final Paint f4923I0Io = new oOoXoXO.oIX0oI(1);

    /* loaded from: classes.dex */
    public static /* synthetic */ class II0xO0 {

        /* renamed from: II0xO0, reason: collision with root package name */
        public static final /* synthetic */ int[] f4948II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f4949oIX0oI;

        static {
            int[] iArr = new int[Mask.MaskMode.values().length];
            f4948II0xO0 = iArr;
            try {
                iArr[Mask.MaskMode.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4948II0xO0[Mask.MaskMode.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4948II0xO0[Mask.MaskMode.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4948II0xO0[Mask.MaskMode.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            f4949oIX0oI = iArr2;
            try {
                iArr2[Layer.LayerType.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4949oIX0oI[Layer.LayerType.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4949oIX0oI[Layer.LayerType.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4949oIX0oI[Layer.LayerType.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4949oIX0oI[Layer.LayerType.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4949oIX0oI[Layer.LayerType.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4949oIX0oI[Layer.LayerType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* renamed from: com.airbnb.lottie.model.layer.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0097oIX0oI implements oIX0oI.II0xO0 {
        public C0097oIX0oI() {
        }

        @Override // x0XOIxOo.oIX0oI.II0xO0
        public void oxoX() {
            boolean z;
            oIX0oI oix0oi = oIX0oI.this;
            if (oix0oi.f4929Oo.x0xO0oo() == 1.0f) {
                z = true;
            } else {
                z = false;
            }
            oix0oi.xI(z);
        }
    }

    public oIX0oI(xoIox xoiox, Layer layer) {
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        this.f4942oxoX = new oOoXoXO.oIX0oI(1, mode);
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        this.f4934X0o0xo = new oOoXoXO.oIX0oI(1, mode2);
        oOoXoXO.oIX0oI oix0oi = new oOoXoXO.oIX0oI(1);
        this.f4935XO = oix0oi;
        this.f4931Oxx0IOOO = new oOoXoXO.oIX0oI(PorterDuff.Mode.CLEAR);
        this.f4924II0XooXoX = new RectF();
        this.f4947xxIXOIIO = new RectF();
        this.f4945xoIox = new RectF();
        this.f4928OOXIXo = new RectF();
        this.f4941ooOOo0oXI = new Matrix();
        this.f4933OxxIIOOXO = new ArrayList();
        this.f4946xoXoI = true;
        this.f4943x0XOIxOo = xoiox;
        this.f4939oO = layer;
        this.f4940oOoXoXO = layer.Oxx0IOOO() + "#draw";
        if (layer.XO() == Layer.MatteType.INVERT) {
            oix0oi.setXfermode(new PorterDuffXfermode(mode2));
        } else {
            oix0oi.setXfermode(new PorterDuffXfermode(mode));
        }
        oO II0xO02 = layer.OxxIIOOXO().II0xO0();
        this.f4926IIXOooo = II0xO02;
        II0xO02.II0xO0(this);
        if (layer.X0o0xo() != null && !layer.X0o0xo().isEmpty()) {
            Oxx0IOOO oxx0IOOO = new Oxx0IOOO(layer.X0o0xo());
            this.f4944x0xO0oo = oxx0IOOO;
            Iterator<x0XOIxOo.oIX0oI<IXxxXO.Oxx0IOOO, Path>> it = oxx0IOOO.oIX0oI().iterator();
            while (it.hasNext()) {
                it.next().oIX0oI(this);
            }
            for (x0XOIxOo.oIX0oI<Integer, Integer> oix0oi2 : this.f4944x0xO0oo.I0Io()) {
                xxIXOIIO(oix0oi2);
                oix0oi2.oIX0oI(this);
            }
        }
        oo0xXOI0I();
    }

    @Nullable
    public static oIX0oI OxxIIOOXO(Layer layer, xoIox xoiox, com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
        switch (II0xO0.f4949oIX0oI[layer.oxoX().ordinal()]) {
            case 1:
                return new Oxx0xo.I0Io(xoiox, layer);
            case 2:
                return new com.airbnb.lottie.model.layer.II0xO0(xoiox, layer, oxx0IOOO.oO(layer.OOXIXo()), oxx0IOOO);
            case 3:
                return new oxoX(xoiox, layer);
            case 4:
                return new Oxx0xo.oIX0oI(xoiox, layer);
            case 5:
                return new Oxx0xo.II0xO0(xoiox, layer);
            case 6:
                return new Oxx0xo.X0o0xo(xoiox, layer);
            default:
                XO.X0o0xo("Unknown layer type " + layer.oxoX());
                return null;
        }
    }

    @Override // ooOOo0oXI.X0o0xo
    public void I0Io(Canvas canvas, Matrix matrix, int i) {
        int intValue;
        Paint paint;
        com.airbnb.lottie.X0o0xo.oIX0oI(this.f4940oOoXoXO);
        if (this.f4946xoXoI && !this.f4939oO.IIXOooo()) {
            IXxxXO();
            com.airbnb.lottie.X0o0xo.oIX0oI("Layer#parentMatrix");
            this.f4925II0xO0.reset();
            this.f4925II0xO0.set(matrix);
            for (int size = this.f4937oI0IIXIo.size() - 1; size >= 0; size--) {
                this.f4925II0xO0.preConcat(this.f4937oI0IIXIo.get(size).f4926IIXOooo.XO());
            }
            com.airbnb.lottie.X0o0xo.II0xO0("Layer#parentMatrix");
            if (this.f4926IIXOooo.II0XooXoX() == null) {
                intValue = 100;
            } else {
                intValue = this.f4926IIXOooo.II0XooXoX().II0XooXoX().intValue();
            }
            int i2 = (int) ((((i / 255.0f) * intValue) / 100.0f) * 255.0f);
            if (!o00() && !xoXoI()) {
                this.f4925II0xO0.preConcat(this.f4926IIXOooo.XO());
                com.airbnb.lottie.X0o0xo.oIX0oI("Layer#drawLayer");
                oI0IIXIo(canvas, this.f4925II0xO0, i2);
                com.airbnb.lottie.X0o0xo.II0xO0("Layer#drawLayer");
                XI0IXoo(com.airbnb.lottie.X0o0xo.II0xO0(this.f4940oOoXoXO));
                return;
            }
            com.airbnb.lottie.X0o0xo.oIX0oI("Layer#computeBounds");
            oIX0oI(this.f4924II0XooXoX, this.f4925II0xO0, false);
            O0xOxO(this.f4924II0XooXoX, matrix);
            this.f4925II0xO0.preConcat(this.f4926IIXOooo.XO());
            OxI(this.f4924II0XooXoX, this.f4925II0xO0);
            if (!this.f4924II0XooXoX.intersect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight())) {
                this.f4924II0XooXoX.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            com.airbnb.lottie.X0o0xo.II0xO0("Layer#computeBounds");
            if (this.f4924II0XooXoX.width() >= 1.0f && this.f4924II0XooXoX.height() >= 1.0f) {
                com.airbnb.lottie.X0o0xo.oIX0oI("Layer#saveLayer");
                this.f4923I0Io.setAlpha(255);
                IIXOooo.xoIox.x0XOIxOo(canvas, this.f4924II0XooXoX, this.f4923I0Io);
                com.airbnb.lottie.X0o0xo.II0xO0("Layer#saveLayer");
                Oxx0xo(canvas);
                com.airbnb.lottie.X0o0xo.oIX0oI("Layer#drawLayer");
                oI0IIXIo(canvas, this.f4925II0xO0, i2);
                com.airbnb.lottie.X0o0xo.II0xO0("Layer#drawLayer");
                if (xoXoI()) {
                    oO(canvas, this.f4925II0xO0);
                }
                if (o00()) {
                    com.airbnb.lottie.X0o0xo.oIX0oI("Layer#drawMatte");
                    com.airbnb.lottie.X0o0xo.oIX0oI("Layer#saveLayer");
                    IIXOooo.xoIox.oO(canvas, this.f4924II0XooXoX, this.f4935XO, 19);
                    com.airbnb.lottie.X0o0xo.II0xO0("Layer#saveLayer");
                    Oxx0xo(canvas);
                    this.f4927IXxxXO.I0Io(canvas, matrix, i2);
                    com.airbnb.lottie.X0o0xo.oIX0oI("Layer#restoreLayer");
                    canvas.restore();
                    com.airbnb.lottie.X0o0xo.II0xO0("Layer#restoreLayer");
                    com.airbnb.lottie.X0o0xo.II0xO0("Layer#drawMatte");
                }
                com.airbnb.lottie.X0o0xo.oIX0oI("Layer#restoreLayer");
                canvas.restore();
                com.airbnb.lottie.X0o0xo.II0xO0("Layer#restoreLayer");
            }
            if (this.f4936o00 && (paint = this.f4930OxI) != null) {
                paint.setStyle(Paint.Style.STROKE);
                this.f4930OxI.setColor(-251901);
                this.f4930OxI.setStrokeWidth(4.0f);
                canvas.drawRect(this.f4924II0XooXoX, this.f4930OxI);
                this.f4930OxI.setStyle(Paint.Style.FILL);
                this.f4930OxI.setColor(1357638635);
                canvas.drawRect(this.f4924II0XooXoX, this.f4930OxI);
            }
            XI0IXoo(com.airbnb.lottie.X0o0xo.II0xO0(this.f4940oOoXoXO));
            return;
        }
        com.airbnb.lottie.X0o0xo.II0xO0(this.f4940oOoXoXO);
    }

    public void IIX0o(@Nullable oIX0oI oix0oi) {
        this.f4932Oxx0xo = oix0oi;
    }

    public Layer IIXOooo() {
        return this.f4939oO;
    }

    public final void IXxxXO() {
        if (this.f4937oI0IIXIo != null) {
            return;
        }
        if (this.f4932Oxx0xo == null) {
            this.f4937oI0IIXIo = Collections.emptyList();
            return;
        }
        this.f4937oI0IIXIo = new ArrayList();
        for (oIX0oI oix0oi = this.f4932Oxx0xo; oix0oi != null; oix0oi = oix0oi.f4932Oxx0xo) {
            this.f4937oI0IIXIo.add(oix0oi);
        }
    }

    public final void O0xOxO(RectF rectF, Matrix matrix) {
        if (!o00() || this.f4939oO.XO() == Layer.MatteType.INVERT) {
            return;
        }
        this.f4945xoIox.set(0.0f, 0.0f, 0.0f, 0.0f);
        this.f4927IXxxXO.oIX0oI(this.f4945xoIox, matrix, true);
        if (!rectF.intersect(this.f4945xoIox)) {
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public final void OOXIXo(Canvas canvas, Matrix matrix, Mask mask, x0XOIxOo.oIX0oI<IXxxXO.Oxx0IOOO, Path> oix0oi, x0XOIxOo.oIX0oI<Integer, Integer> oix0oi2) {
        IIXOooo.xoIox.x0XOIxOo(canvas, this.f4924II0XooXoX, this.f4942oxoX);
        this.f4938oIX0oI.set(oix0oi.II0XooXoX());
        this.f4938oIX0oI.transform(matrix);
        this.f4923I0Io.setAlpha((int) (oix0oi2.II0XooXoX().intValue() * 2.55f));
        canvas.drawPath(this.f4938oIX0oI, this.f4923I0Io);
        canvas.restore();
    }

    public final boolean Oo() {
        if (this.f4944x0xO0oo.oIX0oI().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.f4944x0xO0oo.II0xO0().size(); i++) {
            if (this.f4944x0xO0oo.II0xO0().get(i).oIX0oI() != Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    public final void OxI(RectF rectF, Matrix matrix) {
        this.f4947xxIXOIIO.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (!xoXoI()) {
            return;
        }
        int size = this.f4944x0xO0oo.II0xO0().size();
        for (int i = 0; i < size; i++) {
            Mask mask = this.f4944x0xO0oo.II0xO0().get(i);
            this.f4938oIX0oI.set(this.f4944x0xO0oo.oIX0oI().get(i).II0XooXoX());
            this.f4938oIX0oI.transform(matrix);
            int i2 = II0xO0.f4948II0xO0[mask.oIX0oI().ordinal()];
            if (i2 != 1 && i2 != 2) {
                if ((i2 == 3 || i2 == 4) && mask.oxoX()) {
                    return;
                }
                this.f4938oIX0oI.computeBounds(this.f4928OOXIXo, false);
                if (i == 0) {
                    this.f4947xxIXOIIO.set(this.f4928OOXIXo);
                } else {
                    RectF rectF2 = this.f4947xxIXOIIO;
                    rectF2.set(Math.min(rectF2.left, this.f4928OOXIXo.left), Math.min(this.f4947xxIXOIIO.top, this.f4928OOXIXo.top), Math.max(this.f4947xxIXOIIO.right, this.f4928OOXIXo.right), Math.max(this.f4947xxIXOIIO.bottom, this.f4928OOXIXo.bottom));
                }
            } else {
                return;
            }
        }
        if (!rectF.intersect(this.f4947xxIXOIIO)) {
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    @Override // x0xO0oo.X0o0xo
    public void Oxx0IOOO(x0xO0oo.oxoX oxox, int i, List<x0xO0oo.oxoX> list, x0xO0oo.oxoX oxox2) {
        oIX0oI oix0oi = this.f4927IXxxXO;
        if (oix0oi != null) {
            x0xO0oo.oxoX oIX0oI2 = oxox2.oIX0oI(oix0oi.getName());
            if (oxox.I0Io(this.f4927IXxxXO.getName(), i)) {
                list.add(oIX0oI2.xoIox(this.f4927IXxxXO));
            }
            if (oxox.xxIXOIIO(getName(), i)) {
                this.f4927IXxxXO.xxX(oxox, oxox.X0o0xo(this.f4927IXxxXO.getName(), i) + i, list, oIX0oI2);
            }
        }
        if (!oxox.II0XooXoX(getName(), i)) {
            return;
        }
        if (!"__container".equals(getName())) {
            oxox2 = oxox2.oIX0oI(getName());
            if (oxox.I0Io(getName(), i)) {
                list.add(oxox2.xoIox(this));
            }
        }
        if (oxox.xxIXOIIO(getName(), i)) {
            xxX(oxox, i + oxox.X0o0xo(getName(), i), list, oxox2);
        }
    }

    public final void Oxx0xo(Canvas canvas) {
        com.airbnb.lottie.X0o0xo.oIX0oI("Layer#clearLayer");
        RectF rectF = this.f4924II0XooXoX;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f4931Oxx0IOOO);
        com.airbnb.lottie.X0o0xo.II0xO0("Layer#clearLayer");
    }

    public final void X0IIOO() {
        this.f4943x0XOIxOo.invalidateSelf();
    }

    @Override // ooOOo0oXI.I0Io
    public void X0o0xo(List<ooOOo0oXI.I0Io> list, List<ooOOo0oXI.I0Io> list2) {
    }

    public final void XI0IXoo(float f) {
        this.f4943x0XOIxOo.oI0IIXIo().x0XOIxOo().X0o0xo(this.f4939oO.Oxx0IOOO(), f);
    }

    public void XIxXXX0x0(x0XOIxOo.oIX0oI<?, ?> oix0oi) {
        this.f4933OxxIIOOXO.remove(oix0oi);
    }

    @CallSuper
    public <T> void XO(T t, @Nullable xoXoI.xoIox<T> xoiox) {
        this.f4926IIXOooo.I0Io(t, xoiox);
    }

    public void XxX0x0xxx(@Nullable oIX0oI oix0oi) {
        this.f4927IXxxXO = oix0oi;
    }

    @Override // ooOOo0oXI.I0Io
    public String getName() {
        return this.f4939oO.Oxx0IOOO();
    }

    public boolean o00() {
        if (this.f4927IXxxXO != null) {
            return true;
        }
        return false;
    }

    public abstract void oI0IIXIo(Canvas canvas, Matrix matrix, int i);

    @Override // ooOOo0oXI.X0o0xo
    @CallSuper
    public void oIX0oI(RectF rectF, Matrix matrix, boolean z) {
        this.f4924II0XooXoX.set(0.0f, 0.0f, 0.0f, 0.0f);
        IXxxXO();
        this.f4941ooOOo0oXI.set(matrix);
        if (z) {
            List<oIX0oI> list = this.f4937oI0IIXIo;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f4941ooOOo0oXI.preConcat(this.f4937oI0IIXIo.get(size).f4926IIXOooo.XO());
                }
            } else {
                oIX0oI oix0oi = this.f4932Oxx0xo;
                if (oix0oi != null) {
                    this.f4941ooOOo0oXI.preConcat(oix0oi.f4926IIXOooo.XO());
                }
            }
        }
        this.f4941ooOOo0oXI.preConcat(this.f4926IIXOooo.XO());
    }

    public final void oO(Canvas canvas, Matrix matrix) {
        com.airbnb.lottie.X0o0xo.oIX0oI("Layer#saveLayer");
        IIXOooo.xoIox.oO(canvas, this.f4924II0XooXoX, this.f4942oxoX, 19);
        if (Build.VERSION.SDK_INT < 28) {
            Oxx0xo(canvas);
        }
        com.airbnb.lottie.X0o0xo.II0xO0("Layer#saveLayer");
        for (int i = 0; i < this.f4944x0xO0oo.II0xO0().size(); i++) {
            Mask mask = this.f4944x0xO0oo.II0xO0().get(i);
            x0XOIxOo.oIX0oI<IXxxXO.Oxx0IOOO, Path> oix0oi = this.f4944x0xO0oo.oIX0oI().get(i);
            x0XOIxOo.oIX0oI<Integer, Integer> oix0oi2 = this.f4944x0xO0oo.I0Io().get(i);
            int i2 = II0xO0.f4948II0xO0[mask.oIX0oI().ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            if (mask.oxoX()) {
                                oOoXoXO(canvas, matrix, mask, oix0oi, oix0oi2);
                            } else {
                                xoIox(canvas, matrix, mask, oix0oi, oix0oi2);
                            }
                        }
                    } else if (mask.oxoX()) {
                        ooOOo0oXI(canvas, matrix, mask, oix0oi, oix0oi2);
                    } else {
                        OOXIXo(canvas, matrix, mask, oix0oi, oix0oi2);
                    }
                } else {
                    if (i == 0) {
                        this.f4923I0Io.setColor(ViewCompat.MEASURED_STATE_MASK);
                        this.f4923I0Io.setAlpha(255);
                        canvas.drawRect(this.f4924II0XooXoX, this.f4923I0Io);
                    }
                    if (mask.oxoX()) {
                        x0XOIxOo(canvas, matrix, mask, oix0oi, oix0oi2);
                    } else {
                        x0xO0oo(canvas, matrix, mask, oix0oi, oix0oi2);
                    }
                }
            } else if (Oo()) {
                this.f4923I0Io.setAlpha(255);
                canvas.drawRect(this.f4924II0XooXoX, this.f4923I0Io);
            }
        }
        com.airbnb.lottie.X0o0xo.oIX0oI("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.X0o0xo.II0xO0("Layer#restoreLayer");
    }

    public final void oOoXoXO(Canvas canvas, Matrix matrix, Mask mask, x0XOIxOo.oIX0oI<IXxxXO.Oxx0IOOO, Path> oix0oi, x0XOIxOo.oIX0oI<Integer, Integer> oix0oi2) {
        IIXOooo.xoIox.x0XOIxOo(canvas, this.f4924II0XooXoX, this.f4923I0Io);
        canvas.drawRect(this.f4924II0XooXoX, this.f4923I0Io);
        this.f4938oIX0oI.set(oix0oi.II0XooXoX());
        this.f4938oIX0oI.transform(matrix);
        this.f4923I0Io.setAlpha((int) (oix0oi2.II0XooXoX().intValue() * 2.55f));
        canvas.drawPath(this.f4938oIX0oI, this.f4934X0o0xo);
        canvas.restore();
    }

    public final void oo0xXOI0I() {
        boolean z = true;
        if (!this.f4939oO.I0Io().isEmpty()) {
            I0Io i0Io = new I0Io(this.f4939oO.I0Io());
            this.f4929Oo = i0Io;
            i0Io.oOoXoXO();
            this.f4929Oo.oIX0oI(new C0097oIX0oI());
            if (this.f4929Oo.II0XooXoX().floatValue() != 1.0f) {
                z = false;
            }
            xI(z);
            xxIXOIIO(this.f4929Oo);
            return;
        }
        xI(true);
    }

    public final void ooOOo0oXI(Canvas canvas, Matrix matrix, Mask mask, x0XOIxOo.oIX0oI<IXxxXO.Oxx0IOOO, Path> oix0oi, x0XOIxOo.oIX0oI<Integer, Integer> oix0oi2) {
        IIXOooo.xoIox.x0XOIxOo(canvas, this.f4924II0XooXoX, this.f4942oxoX);
        canvas.drawRect(this.f4924II0XooXoX, this.f4923I0Io);
        this.f4934X0o0xo.setAlpha((int) (oix0oi2.II0XooXoX().intValue() * 2.55f));
        this.f4938oIX0oI.set(oix0oi.II0XooXoX());
        this.f4938oIX0oI.transform(matrix);
        canvas.drawPath(this.f4938oIX0oI, this.f4934X0o0xo);
        canvas.restore();
    }

    public void ooXIXxIX(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.f4926IIXOooo.xoIox(f);
        if (this.f4944x0xO0oo != null) {
            for (int i = 0; i < this.f4944x0xO0oo.oIX0oI().size(); i++) {
                this.f4944x0xO0oo.oIX0oI().get(i).ooOOo0oXI(f);
            }
        }
        if (this.f4939oO.oI0IIXIo() != 0.0f) {
            f /= this.f4939oO.oI0IIXIo();
        }
        I0Io i0Io = this.f4929Oo;
        if (i0Io != null) {
            i0Io.ooOOo0oXI(f / this.f4939oO.oI0IIXIo());
        }
        oIX0oI oix0oi = this.f4927IXxxXO;
        if (oix0oi != null) {
            this.f4927IXxxXO.ooXIXxIX(oix0oi.f4939oO.oI0IIXIo() * f);
        }
        for (int i2 = 0; i2 < this.f4933OxxIIOOXO.size(); i2++) {
            this.f4933OxxIIOOXO.get(i2).ooOOo0oXI(f);
        }
    }

    @Override // x0XOIxOo.oIX0oI.II0xO0
    public void oxoX() {
        X0IIOO();
    }

    public final void x0XOIxOo(Canvas canvas, Matrix matrix, Mask mask, x0XOIxOo.oIX0oI<IXxxXO.Oxx0IOOO, Path> oix0oi, x0XOIxOo.oIX0oI<Integer, Integer> oix0oi2) {
        IIXOooo.xoIox.x0XOIxOo(canvas, this.f4924II0XooXoX, this.f4934X0o0xo);
        canvas.drawRect(this.f4924II0XooXoX, this.f4923I0Io);
        this.f4934X0o0xo.setAlpha((int) (oix0oi2.II0XooXoX().intValue() * 2.55f));
        this.f4938oIX0oI.set(oix0oi.II0XooXoX());
        this.f4938oIX0oI.transform(matrix);
        canvas.drawPath(this.f4938oIX0oI, this.f4934X0o0xo);
        canvas.restore();
    }

    public final void x0xO0oo(Canvas canvas, Matrix matrix, Mask mask, x0XOIxOo.oIX0oI<IXxxXO.Oxx0IOOO, Path> oix0oi, x0XOIxOo.oIX0oI<Integer, Integer> oix0oi2) {
        this.f4938oIX0oI.set(oix0oi.II0XooXoX());
        this.f4938oIX0oI.transform(matrix);
        canvas.drawPath(this.f4938oIX0oI, this.f4934X0o0xo);
    }

    public final void xI(boolean z) {
        if (z != this.f4946xoXoI) {
            this.f4946xoXoI = z;
            X0IIOO();
        }
    }

    public void xXxxox0I(boolean z) {
        if (z && this.f4930OxI == null) {
            this.f4930OxI = new oOoXoXO.oIX0oI();
        }
        this.f4936o00 = z;
    }

    public final void xoIox(Canvas canvas, Matrix matrix, Mask mask, x0XOIxOo.oIX0oI<IXxxXO.Oxx0IOOO, Path> oix0oi, x0XOIxOo.oIX0oI<Integer, Integer> oix0oi2) {
        this.f4938oIX0oI.set(oix0oi.II0XooXoX());
        this.f4938oIX0oI.transform(matrix);
        this.f4923I0Io.setAlpha((int) (oix0oi2.II0XooXoX().intValue() * 2.55f));
        canvas.drawPath(this.f4938oIX0oI, this.f4923I0Io);
    }

    public boolean xoXoI() {
        Oxx0IOOO oxx0IOOO = this.f4944x0xO0oo;
        if (oxx0IOOO != null && !oxx0IOOO.oIX0oI().isEmpty()) {
            return true;
        }
        return false;
    }

    public void xxIXOIIO(@Nullable x0XOIxOo.oIX0oI<?, ?> oix0oi) {
        if (oix0oi == null) {
            return;
        }
        this.f4933OxxIIOOXO.add(oix0oi);
    }

    public void xxX(x0xO0oo.oxoX oxox, int i, List<x0xO0oo.oxoX> list, x0xO0oo.oxoX oxox2) {
    }
}
