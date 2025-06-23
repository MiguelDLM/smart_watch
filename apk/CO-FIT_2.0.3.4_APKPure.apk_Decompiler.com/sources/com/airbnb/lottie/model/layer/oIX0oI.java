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
import java.util.List;
import ooOOo0oXI.X0o0xo;
import x0XOIxOo.I0Io;
import x0XOIxOo.Oxx0IOOO;
import x0XOIxOo.oIX0oI;
import x0XOIxOo.oO;

public abstract class oIX0oI implements X0o0xo, oIX0oI.II0xO0, x0xO0oo.X0o0xo {

    /* renamed from: O0xOxO  reason: collision with root package name */
    public static final int f925O0xOxO = 2;

    /* renamed from: X0IIOO  reason: collision with root package name */
    public static final int f926X0IIOO = 16;

    /* renamed from: XI0IXoo  reason: collision with root package name */
    public static final int f927XI0IXoo = 1;

    /* renamed from: XIxXXX0x0  reason: collision with root package name */
    public static final int f928XIxXXX0x0 = 19;

    /* renamed from: I0Io  reason: collision with root package name */
    public final Paint f929I0Io = new oOoXoXO.oIX0oI(1);

    /* renamed from: II0XooXoX  reason: collision with root package name */
    public final RectF f930II0XooXoX;

    /* renamed from: II0xO0  reason: collision with root package name */
    public final Matrix f931II0xO0 = new Matrix();

    /* renamed from: IIXOooo  reason: collision with root package name */
    public final oO f932IIXOooo;
    @Nullable

    /* renamed from: IXxxXO  reason: collision with root package name */
    public oIX0oI f933IXxxXO;

    /* renamed from: OOXIXo  reason: collision with root package name */
    public final RectF f934OOXIXo;
    @Nullable

    /* renamed from: Oo  reason: collision with root package name */
    public I0Io f935Oo;
    @Nullable

    /* renamed from: OxI  reason: collision with root package name */
    public Paint f936OxI;

    /* renamed from: Oxx0IOOO  reason: collision with root package name */
    public final Paint f937Oxx0IOOO;
    @Nullable

    /* renamed from: Oxx0xo  reason: collision with root package name */
    public oIX0oI f938Oxx0xo;

    /* renamed from: OxxIIOOXO  reason: collision with root package name */
    public final List<x0XOIxOo.oIX0oI<?, ?>> f939OxxIIOOXO;

    /* renamed from: X0o0xo  reason: collision with root package name */
    public final Paint f940X0o0xo;

    /* renamed from: XO  reason: collision with root package name */
    public final Paint f941XO;

    /* renamed from: o00  reason: collision with root package name */
    public boolean f942o00;

    /* renamed from: oI0IIXIo  reason: collision with root package name */
    public List<oIX0oI> f943oI0IIXIo;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final Path f944oIX0oI = new Path();

    /* renamed from: oO  reason: collision with root package name */
    public final Layer f945oO;

    /* renamed from: oOoXoXO  reason: collision with root package name */
    public final String f946oOoXoXO;

    /* renamed from: ooOOo0oXI  reason: collision with root package name */
    public final Matrix f947ooOOo0oXI;

    /* renamed from: oxoX  reason: collision with root package name */
    public final Paint f948oxoX;

    /* renamed from: x0XOIxOo  reason: collision with root package name */
    public final xoIox f949x0XOIxOo;
    @Nullable

    /* renamed from: x0xO0oo  reason: collision with root package name */
    public Oxx0IOOO f950x0xO0oo;

    /* renamed from: xoIox  reason: collision with root package name */
    public final RectF f951xoIox;

    /* renamed from: xoXoI  reason: collision with root package name */
    public boolean f952xoXoI;

    /* renamed from: xxIXOIIO  reason: collision with root package name */
    public final RectF f953xxIXOIIO;

    public static /* synthetic */ class II0xO0 {

        /* renamed from: II0xO0  reason: collision with root package name */
        public static final /* synthetic */ int[] f954II0xO0;

        /* renamed from: oIX0oI  reason: collision with root package name */
        public static final /* synthetic */ int[] f955oIX0oI;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        static {
            /*
                com.airbnb.lottie.model.content.Mask$MaskMode[] r0 = com.airbnb.lottie.model.content.Mask.MaskMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f954II0xO0 = r0
                r1 = 1
                com.airbnb.lottie.model.content.Mask$MaskMode r2 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f954II0xO0     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.content.Mask$MaskMode r3 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_SUBTRACT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f954II0xO0     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.model.content.Mask$MaskMode r4 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_INTERSECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f954II0xO0     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.airbnb.lottie.model.content.Mask$MaskMode r5 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_ADD     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.airbnb.lottie.model.layer.Layer$LayerType[] r4 = com.airbnb.lottie.model.layer.Layer.LayerType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f955oIX0oI = r4
                com.airbnb.lottie.model.layer.Layer$LayerType r5 = com.airbnb.lottie.model.layer.Layer.LayerType.SHAPE     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f955oIX0oI     // Catch:{ NoSuchFieldError -> 0x004e }
                com.airbnb.lottie.model.layer.Layer$LayerType r4 = com.airbnb.lottie.model.layer.Layer.LayerType.PRE_COMP     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f955oIX0oI     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.SOLID     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f955oIX0oI     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.IMAGE     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f955oIX0oI     // Catch:{ NoSuchFieldError -> 0x006d }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.NULL     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f955oIX0oI     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.TEXT     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f955oIX0oI     // Catch:{ NoSuchFieldError -> 0x0083 }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.oIX0oI.II0xO0.<clinit>():void");
        }
    }

    /* renamed from: com.airbnb.lottie.model.layer.oIX0oI$oIX0oI  reason: collision with other inner class name */
    public class C0017oIX0oI implements oIX0oI.II0xO0 {
        public C0017oIX0oI() {
        }

        public void oxoX() {
            boolean z;
            oIX0oI oix0oi = oIX0oI.this;
            if (oix0oi.f935Oo.x0xO0oo() == 1.0f) {
                z = true;
            } else {
                z = false;
            }
            oix0oi.xI(z);
        }
    }

    public oIX0oI(xoIox xoiox, Layer layer) {
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        this.f948oxoX = new oOoXoXO.oIX0oI(1, mode);
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        this.f940X0o0xo = new oOoXoXO.oIX0oI(1, mode2);
        oOoXoXO.oIX0oI oix0oi = new oOoXoXO.oIX0oI(1);
        this.f941XO = oix0oi;
        this.f937Oxx0IOOO = new oOoXoXO.oIX0oI(PorterDuff.Mode.CLEAR);
        this.f930II0XooXoX = new RectF();
        this.f953xxIXOIIO = new RectF();
        this.f951xoIox = new RectF();
        this.f934OOXIXo = new RectF();
        this.f947ooOOo0oXI = new Matrix();
        this.f939OxxIIOOXO = new ArrayList();
        this.f952xoXoI = true;
        this.f949x0XOIxOo = xoiox;
        this.f945oO = layer;
        this.f946oOoXoXO = layer.Oxx0IOOO() + "#draw";
        if (layer.XO() == Layer.MatteType.INVERT) {
            oix0oi.setXfermode(new PorterDuffXfermode(mode2));
        } else {
            oix0oi.setXfermode(new PorterDuffXfermode(mode));
        }
        oO II0xO02 = layer.OxxIIOOXO().II0xO0();
        this.f932IIXOooo = II0xO02;
        II0xO02.II0xO0(this);
        if (layer.X0o0xo() != null && !layer.X0o0xo().isEmpty()) {
            Oxx0IOOO oxx0IOOO = new Oxx0IOOO(layer.X0o0xo());
            this.f950x0xO0oo = oxx0IOOO;
            for (x0XOIxOo.oIX0oI<IXxxXO.Oxx0IOOO, Path> oIX0oI2 : oxx0IOOO.oIX0oI()) {
                oIX0oI2.oIX0oI(this);
            }
            for (x0XOIxOo.oIX0oI next : this.f950x0xO0oo.I0Io()) {
                xxIXOIIO(next);
                next.oIX0oI(this);
            }
        }
        oo0xXOI0I();
    }

    @Nullable
    public static oIX0oI OxxIIOOXO(Layer layer, xoIox xoiox, com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
        switch (II0xO0.f955oIX0oI[layer.oxoX().ordinal()]) {
            case 1:
                return new Oxx0xo.I0Io(xoiox, layer);
            case 2:
                return new II0xO0(xoiox, layer, oxx0IOOO.oO(layer.OOXIXo()), oxx0IOOO);
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

    public void I0Io(Canvas canvas, Matrix matrix, int i) {
        int i2;
        Paint paint;
        com.airbnb.lottie.X0o0xo.oIX0oI(this.f946oOoXoXO);
        if (!this.f952xoXoI || this.f945oO.IIXOooo()) {
            com.airbnb.lottie.X0o0xo.II0xO0(this.f946oOoXoXO);
            return;
        }
        IXxxXO();
        com.airbnb.lottie.X0o0xo.oIX0oI("Layer#parentMatrix");
        this.f931II0xO0.reset();
        this.f931II0xO0.set(matrix);
        for (int size = this.f943oI0IIXIo.size() - 1; size >= 0; size--) {
            this.f931II0xO0.preConcat(this.f943oI0IIXIo.get(size).f932IIXOooo.XO());
        }
        com.airbnb.lottie.X0o0xo.II0xO0("Layer#parentMatrix");
        if (this.f932IIXOooo.II0XooXoX() == null) {
            i2 = 100;
        } else {
            i2 = this.f932IIXOooo.II0XooXoX().II0XooXoX().intValue();
        }
        int i3 = (int) ((((((float) i) / 255.0f) * ((float) i2)) / 100.0f) * 255.0f);
        if (o00() || xoXoI()) {
            com.airbnb.lottie.X0o0xo.oIX0oI("Layer#computeBounds");
            oIX0oI(this.f930II0XooXoX, this.f931II0xO0, false);
            O0xOxO(this.f930II0XooXoX, matrix);
            this.f931II0xO0.preConcat(this.f932IIXOooo.XO());
            OxI(this.f930II0XooXoX, this.f931II0xO0);
            if (!this.f930II0XooXoX.intersect(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight())) {
                this.f930II0XooXoX.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            com.airbnb.lottie.X0o0xo.II0xO0("Layer#computeBounds");
            if (this.f930II0XooXoX.width() >= 1.0f && this.f930II0XooXoX.height() >= 1.0f) {
                com.airbnb.lottie.X0o0xo.oIX0oI("Layer#saveLayer");
                this.f929I0Io.setAlpha(255);
                IIXOooo.xoIox.x0XOIxOo(canvas, this.f930II0XooXoX, this.f929I0Io);
                com.airbnb.lottie.X0o0xo.II0xO0("Layer#saveLayer");
                Oxx0xo(canvas);
                com.airbnb.lottie.X0o0xo.oIX0oI("Layer#drawLayer");
                oI0IIXIo(canvas, this.f931II0xO0, i3);
                com.airbnb.lottie.X0o0xo.II0xO0("Layer#drawLayer");
                if (xoXoI()) {
                    oO(canvas, this.f931II0xO0);
                }
                if (o00()) {
                    com.airbnb.lottie.X0o0xo.oIX0oI("Layer#drawMatte");
                    com.airbnb.lottie.X0o0xo.oIX0oI("Layer#saveLayer");
                    IIXOooo.xoIox.oO(canvas, this.f930II0XooXoX, this.f941XO, 19);
                    com.airbnb.lottie.X0o0xo.II0xO0("Layer#saveLayer");
                    Oxx0xo(canvas);
                    this.f933IXxxXO.I0Io(canvas, matrix, i3);
                    com.airbnb.lottie.X0o0xo.oIX0oI("Layer#restoreLayer");
                    canvas.restore();
                    com.airbnb.lottie.X0o0xo.II0xO0("Layer#restoreLayer");
                    com.airbnb.lottie.X0o0xo.II0xO0("Layer#drawMatte");
                }
                com.airbnb.lottie.X0o0xo.oIX0oI("Layer#restoreLayer");
                canvas.restore();
                com.airbnb.lottie.X0o0xo.II0xO0("Layer#restoreLayer");
            }
            if (this.f942o00 && (paint = this.f936OxI) != null) {
                paint.setStyle(Paint.Style.STROKE);
                this.f936OxI.setColor(-251901);
                this.f936OxI.setStrokeWidth(4.0f);
                canvas.drawRect(this.f930II0XooXoX, this.f936OxI);
                this.f936OxI.setStyle(Paint.Style.FILL);
                this.f936OxI.setColor(1357638635);
                canvas.drawRect(this.f930II0XooXoX, this.f936OxI);
            }
            XI0IXoo(com.airbnb.lottie.X0o0xo.II0xO0(this.f946oOoXoXO));
            return;
        }
        this.f931II0xO0.preConcat(this.f932IIXOooo.XO());
        com.airbnb.lottie.X0o0xo.oIX0oI("Layer#drawLayer");
        oI0IIXIo(canvas, this.f931II0xO0, i3);
        com.airbnb.lottie.X0o0xo.II0xO0("Layer#drawLayer");
        XI0IXoo(com.airbnb.lottie.X0o0xo.II0xO0(this.f946oOoXoXO));
    }

    public void IIX0o(@Nullable oIX0oI oix0oi) {
        this.f938Oxx0xo = oix0oi;
    }

    public Layer IIXOooo() {
        return this.f945oO;
    }

    public final void IXxxXO() {
        if (this.f943oI0IIXIo == null) {
            if (this.f938Oxx0xo == null) {
                this.f943oI0IIXIo = Collections.emptyList();
                return;
            }
            this.f943oI0IIXIo = new ArrayList();
            for (oIX0oI oix0oi = this.f938Oxx0xo; oix0oi != null; oix0oi = oix0oi.f938Oxx0xo) {
                this.f943oI0IIXIo.add(oix0oi);
            }
        }
    }

    public final void O0xOxO(RectF rectF, Matrix matrix) {
        if (o00() && this.f945oO.XO() != Layer.MatteType.INVERT) {
            this.f951xoIox.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f933IXxxXO.oIX0oI(this.f951xoIox, matrix, true);
            if (!rectF.intersect(this.f951xoIox)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    public final void OOXIXo(Canvas canvas, Matrix matrix, Mask mask, x0XOIxOo.oIX0oI<IXxxXO.Oxx0IOOO, Path> oix0oi, x0XOIxOo.oIX0oI<Integer, Integer> oix0oi2) {
        IIXOooo.xoIox.x0XOIxOo(canvas, this.f930II0XooXoX, this.f948oxoX);
        this.f944oIX0oI.set(oix0oi.II0XooXoX());
        this.f944oIX0oI.transform(matrix);
        this.f929I0Io.setAlpha((int) (((float) oix0oi2.II0XooXoX().intValue()) * 2.55f));
        canvas.drawPath(this.f944oIX0oI, this.f929I0Io);
        canvas.restore();
    }

    public final boolean Oo() {
        if (this.f950x0xO0oo.oIX0oI().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.f950x0xO0oo.II0xO0().size(); i++) {
            if (this.f950x0xO0oo.II0xO0().get(i).oIX0oI() != Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    public final void OxI(RectF rectF, Matrix matrix) {
        this.f953xxIXOIIO.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (xoXoI()) {
            int size = this.f950x0xO0oo.II0xO0().size();
            int i = 0;
            while (i < size) {
                Mask mask = this.f950x0xO0oo.II0xO0().get(i);
                this.f944oIX0oI.set((Path) this.f950x0xO0oo.oIX0oI().get(i).II0XooXoX());
                this.f944oIX0oI.transform(matrix);
                int i2 = II0xO0.f954II0xO0[mask.oIX0oI().ordinal()];
                if (i2 != 1 && i2 != 2) {
                    if ((i2 != 3 && i2 != 4) || !mask.oxoX()) {
                        this.f944oIX0oI.computeBounds(this.f934OOXIXo, false);
                        if (i == 0) {
                            this.f953xxIXOIIO.set(this.f934OOXIXo);
                        } else {
                            RectF rectF2 = this.f953xxIXOIIO;
                            rectF2.set(Math.min(rectF2.left, this.f934OOXIXo.left), Math.min(this.f953xxIXOIIO.top, this.f934OOXIXo.top), Math.max(this.f953xxIXOIIO.right, this.f934OOXIXo.right), Math.max(this.f953xxIXOIIO.bottom, this.f934OOXIXo.bottom));
                        }
                        i++;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (!rectF.intersect(this.f953xxIXOIIO)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    public void Oxx0IOOO(x0xO0oo.oxoX oxox, int i, List<x0xO0oo.oxoX> list, x0xO0oo.oxoX oxox2) {
        oIX0oI oix0oi = this.f933IXxxXO;
        if (oix0oi != null) {
            x0xO0oo.oxoX oIX0oI2 = oxox2.oIX0oI(oix0oi.getName());
            if (oxox.I0Io(this.f933IXxxXO.getName(), i)) {
                list.add(oIX0oI2.xoIox(this.f933IXxxXO));
            }
            if (oxox.xxIXOIIO(getName(), i)) {
                this.f933IXxxXO.xxX(oxox, oxox.X0o0xo(this.f933IXxxXO.getName(), i) + i, list, oIX0oI2);
            }
        }
        if (oxox.II0XooXoX(getName(), i)) {
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
    }

    public final void Oxx0xo(Canvas canvas) {
        com.airbnb.lottie.X0o0xo.oIX0oI("Layer#clearLayer");
        RectF rectF = this.f930II0XooXoX;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f937Oxx0IOOO);
        com.airbnb.lottie.X0o0xo.II0xO0("Layer#clearLayer");
    }

    public final void X0IIOO() {
        this.f949x0XOIxOo.invalidateSelf();
    }

    public void X0o0xo(List<ooOOo0oXI.I0Io> list, List<ooOOo0oXI.I0Io> list2) {
    }

    public final void XI0IXoo(float f) {
        this.f949x0XOIxOo.oI0IIXIo().x0XOIxOo().X0o0xo(this.f945oO.Oxx0IOOO(), f);
    }

    public void XIxXXX0x0(x0XOIxOo.oIX0oI<?, ?> oix0oi) {
        this.f939OxxIIOOXO.remove(oix0oi);
    }

    @CallSuper
    public <T> void XO(T t, @Nullable xoXoI.xoIox<T> xoiox) {
        this.f932IIXOooo.I0Io(t, xoiox);
    }

    public void XxX0x0xxx(@Nullable oIX0oI oix0oi) {
        this.f933IXxxXO = oix0oi;
    }

    public String getName() {
        return this.f945oO.Oxx0IOOO();
    }

    public boolean o00() {
        if (this.f933IXxxXO != null) {
            return true;
        }
        return false;
    }

    public abstract void oI0IIXIo(Canvas canvas, Matrix matrix, int i);

    @CallSuper
    public void oIX0oI(RectF rectF, Matrix matrix, boolean z) {
        this.f930II0XooXoX.set(0.0f, 0.0f, 0.0f, 0.0f);
        IXxxXO();
        this.f947ooOOo0oXI.set(matrix);
        if (z) {
            List<oIX0oI> list = this.f943oI0IIXIo;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f947ooOOo0oXI.preConcat(this.f943oI0IIXIo.get(size).f932IIXOooo.XO());
                }
            } else {
                oIX0oI oix0oi = this.f938Oxx0xo;
                if (oix0oi != null) {
                    this.f947ooOOo0oXI.preConcat(oix0oi.f932IIXOooo.XO());
                }
            }
        }
        this.f947ooOOo0oXI.preConcat(this.f932IIXOooo.XO());
    }

    public final void oO(Canvas canvas, Matrix matrix) {
        com.airbnb.lottie.X0o0xo.oIX0oI("Layer#saveLayer");
        IIXOooo.xoIox.oO(canvas, this.f930II0XooXoX, this.f948oxoX, 19);
        if (Build.VERSION.SDK_INT < 28) {
            Oxx0xo(canvas);
        }
        com.airbnb.lottie.X0o0xo.II0xO0("Layer#saveLayer");
        for (int i = 0; i < this.f950x0xO0oo.II0xO0().size(); i++) {
            Mask mask = this.f950x0xO0oo.II0xO0().get(i);
            x0XOIxOo.oIX0oI oix0oi = this.f950x0xO0oo.oIX0oI().get(i);
            x0XOIxOo.oIX0oI oix0oi2 = this.f950x0xO0oo.I0Io().get(i);
            int i2 = II0xO0.f954II0xO0[mask.oIX0oI().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i == 0) {
                        this.f929I0Io.setColor(ViewCompat.MEASURED_STATE_MASK);
                        this.f929I0Io.setAlpha(255);
                        canvas.drawRect(this.f930II0XooXoX, this.f929I0Io);
                    }
                    if (mask.oxoX()) {
                        x0XOIxOo(canvas, matrix, mask, oix0oi, oix0oi2);
                    } else {
                        x0xO0oo(canvas, matrix, mask, oix0oi, oix0oi2);
                    }
                } else if (i2 != 3) {
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
            } else if (Oo()) {
                this.f929I0Io.setAlpha(255);
                canvas.drawRect(this.f930II0XooXoX, this.f929I0Io);
            }
        }
        com.airbnb.lottie.X0o0xo.oIX0oI("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.X0o0xo.II0xO0("Layer#restoreLayer");
    }

    public final void oOoXoXO(Canvas canvas, Matrix matrix, Mask mask, x0XOIxOo.oIX0oI<IXxxXO.Oxx0IOOO, Path> oix0oi, x0XOIxOo.oIX0oI<Integer, Integer> oix0oi2) {
        IIXOooo.xoIox.x0XOIxOo(canvas, this.f930II0XooXoX, this.f929I0Io);
        canvas.drawRect(this.f930II0XooXoX, this.f929I0Io);
        this.f944oIX0oI.set(oix0oi.II0XooXoX());
        this.f944oIX0oI.transform(matrix);
        this.f929I0Io.setAlpha((int) (((float) oix0oi2.II0XooXoX().intValue()) * 2.55f));
        canvas.drawPath(this.f944oIX0oI, this.f940X0o0xo);
        canvas.restore();
    }

    public final void oo0xXOI0I() {
        boolean z = true;
        if (!this.f945oO.I0Io().isEmpty()) {
            I0Io i0Io = new I0Io(this.f945oO.I0Io());
            this.f935Oo = i0Io;
            i0Io.oOoXoXO();
            this.f935Oo.oIX0oI(new C0017oIX0oI());
            if (((Float) this.f935Oo.II0XooXoX()).floatValue() != 1.0f) {
                z = false;
            }
            xI(z);
            xxIXOIIO(this.f935Oo);
            return;
        }
        xI(true);
    }

    public final void ooOOo0oXI(Canvas canvas, Matrix matrix, Mask mask, x0XOIxOo.oIX0oI<IXxxXO.Oxx0IOOO, Path> oix0oi, x0XOIxOo.oIX0oI<Integer, Integer> oix0oi2) {
        IIXOooo.xoIox.x0XOIxOo(canvas, this.f930II0XooXoX, this.f948oxoX);
        canvas.drawRect(this.f930II0XooXoX, this.f929I0Io);
        this.f940X0o0xo.setAlpha((int) (((float) oix0oi2.II0XooXoX().intValue()) * 2.55f));
        this.f944oIX0oI.set(oix0oi.II0XooXoX());
        this.f944oIX0oI.transform(matrix);
        canvas.drawPath(this.f944oIX0oI, this.f940X0o0xo);
        canvas.restore();
    }

    public void ooXIXxIX(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.f932IIXOooo.xoIox(f);
        if (this.f950x0xO0oo != null) {
            for (int i = 0; i < this.f950x0xO0oo.oIX0oI().size(); i++) {
                this.f950x0xO0oo.oIX0oI().get(i).ooOOo0oXI(f);
            }
        }
        if (this.f945oO.oI0IIXIo() != 0.0f) {
            f /= this.f945oO.oI0IIXIo();
        }
        I0Io i0Io = this.f935Oo;
        if (i0Io != null) {
            i0Io.ooOOo0oXI(f / this.f945oO.oI0IIXIo());
        }
        oIX0oI oix0oi = this.f933IXxxXO;
        if (oix0oi != null) {
            this.f933IXxxXO.ooXIXxIX(oix0oi.f945oO.oI0IIXIo() * f);
        }
        for (int i2 = 0; i2 < this.f939OxxIIOOXO.size(); i2++) {
            this.f939OxxIIOOXO.get(i2).ooOOo0oXI(f);
        }
    }

    public void oxoX() {
        X0IIOO();
    }

    public final void x0XOIxOo(Canvas canvas, Matrix matrix, Mask mask, x0XOIxOo.oIX0oI<IXxxXO.Oxx0IOOO, Path> oix0oi, x0XOIxOo.oIX0oI<Integer, Integer> oix0oi2) {
        IIXOooo.xoIox.x0XOIxOo(canvas, this.f930II0XooXoX, this.f940X0o0xo);
        canvas.drawRect(this.f930II0XooXoX, this.f929I0Io);
        this.f940X0o0xo.setAlpha((int) (((float) oix0oi2.II0XooXoX().intValue()) * 2.55f));
        this.f944oIX0oI.set(oix0oi.II0XooXoX());
        this.f944oIX0oI.transform(matrix);
        canvas.drawPath(this.f944oIX0oI, this.f940X0o0xo);
        canvas.restore();
    }

    public final void x0xO0oo(Canvas canvas, Matrix matrix, Mask mask, x0XOIxOo.oIX0oI<IXxxXO.Oxx0IOOO, Path> oix0oi, x0XOIxOo.oIX0oI<Integer, Integer> oix0oi2) {
        this.f944oIX0oI.set(oix0oi.II0XooXoX());
        this.f944oIX0oI.transform(matrix);
        canvas.drawPath(this.f944oIX0oI, this.f940X0o0xo);
    }

    public final void xI(boolean z) {
        if (z != this.f952xoXoI) {
            this.f952xoXoI = z;
            X0IIOO();
        }
    }

    public void xXxxox0I(boolean z) {
        if (z && this.f936OxI == null) {
            this.f936OxI = new oOoXoXO.oIX0oI();
        }
        this.f942o00 = z;
    }

    public final void xoIox(Canvas canvas, Matrix matrix, Mask mask, x0XOIxOo.oIX0oI<IXxxXO.Oxx0IOOO, Path> oix0oi, x0XOIxOo.oIX0oI<Integer, Integer> oix0oi2) {
        this.f944oIX0oI.set(oix0oi.II0XooXoX());
        this.f944oIX0oI.transform(matrix);
        this.f929I0Io.setAlpha((int) (((float) oix0oi2.II0XooXoX().intValue()) * 2.55f));
        canvas.drawPath(this.f944oIX0oI, this.f929I0Io);
    }

    public boolean xoXoI() {
        Oxx0IOOO oxx0IOOO = this.f950x0xO0oo;
        if (oxx0IOOO == null || oxx0IOOO.oIX0oI().isEmpty()) {
            return false;
        }
        return true;
    }

    public void xxIXOIIO(@Nullable x0XOIxOo.oIX0oI<?, ?> oix0oi) {
        if (oix0oi != null) {
            this.f939OxxIIOOXO.add(oix0oi);
        }
    }

    public void xxX(x0xO0oo.oxoX oxox, int i, List<x0xO0oo.oxoX> list, x0xO0oo.oxoX oxox2) {
    }
}
