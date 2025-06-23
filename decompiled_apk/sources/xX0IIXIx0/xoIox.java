package xX0IIXIx0;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import xX0IIXIx0.I0Io;

/* loaded from: classes9.dex */
public class xoIox extends OOXIXo {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public HashMap<IIxOXoOo0.X0o0xo, II0xO0> f34593IXxxXO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public WeakReference<Bitmap> f34594OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public Path f34595Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public float[] f34596Oxx0xo;

    /* renamed from: oO, reason: collision with root package name */
    public Path f34597oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public Canvas f34598oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public Bitmap.Config f34599ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public Path f34600x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public float[] f34601x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public Paint f34602xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public OOXIxO0.Oxx0IOOO f34603xxIXOIIO;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f34607oIX0oI;

        static {
            int[] iArr = new int[LineDataSet.Mode.values().length];
            f34607oIX0oI = iArr;
            try {
                iArr[LineDataSet.Mode.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34607oIX0oI[LineDataSet.Mode.STEPPED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34607oIX0oI[LineDataSet.Mode.CUBIC_BEZIER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34607oIX0oI[LineDataSet.Mode.HORIZONTAL_BEZIER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public xoIox(OOXIxO0.Oxx0IOOO oxx0IOOO, Ioxxx.oIX0oI oix0oi, XIXIX.oOoXoXO oooxoxo) {
        super(oix0oi, oooxoxo);
        this.f34599ooOOo0oXI = Bitmap.Config.ARGB_8888;
        this.f34600x0XOIxOo = new Path();
        this.f34597oO = new Path();
        this.f34601x0xO0oo = new float[4];
        this.f34595Oo = new Path();
        this.f34593IXxxXO = new HashMap<>();
        this.f34596Oxx0xo = new float[2];
        this.f34603xxIXOIIO = oxx0IOOO;
        Paint paint = new Paint(1);
        this.f34602xoIox = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f34602xoIox.setColor(-1);
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void I0Io(Canvas canvas) {
        IXxxXO(canvas);
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void II0xO0(Canvas canvas) {
        Bitmap bitmap;
        int oO2 = (int) this.f34563oIX0oI.oO();
        int x0XOIxOo2 = (int) this.f34563oIX0oI.x0XOIxOo();
        WeakReference<Bitmap> weakReference = this.f34594OOXIXo;
        if (weakReference == null) {
            bitmap = null;
        } else {
            bitmap = weakReference.get();
        }
        if (bitmap == null || bitmap.getWidth() != oO2 || bitmap.getHeight() != x0XOIxOo2) {
            if (oO2 > 0 && x0XOIxOo2 > 0) {
                bitmap = Bitmap.createBitmap(oO2, x0XOIxOo2, this.f34599ooOOo0oXI);
                this.f34594OOXIXo = new WeakReference<>(bitmap);
                this.f34598oOoXoXO = new Canvas(bitmap);
            } else {
                return;
            }
        }
        bitmap.eraseColor(0);
        for (T t : this.f34603xxIXOIIO.getLineData().Oo()) {
            if (t.isVisible()) {
                OxxIIOOXO(canvas, t);
            }
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.f34529I0Io);
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.github.mikephil.charting.data.Entry, o0xxxXXxX.XO] */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.github.mikephil.charting.data.Entry, o0xxxXXxX.XO] */
    public void IIXOooo(IIxOXoOo0.XO xo2) {
        float xxIXOIIO2 = this.f34530II0xO0.xxIXOIIO();
        XIXIX.xxIXOIIO oxoX2 = this.f34603xxIXOIIO.oxoX(xo2.OX00O0xII());
        this.f34506Oxx0IOOO.oIX0oI(this.f34603xxIXOIIO, xo2);
        this.f34600x0XOIxOo.reset();
        I0Io.oIX0oI oix0oi = this.f34506Oxx0IOOO;
        if (oix0oi.f34507I0Io >= 1) {
            ?? OOXIXo2 = xo2.OOXIXo(oix0oi.f34509oIX0oI);
            this.f34600x0XOIxOo.moveTo(OOXIXo2.xxIXOIIO(), OOXIXo2.I0Io() * xxIXOIIO2);
            int i = this.f34506Oxx0IOOO.f34509oIX0oI + 1;
            Entry entry = OOXIXo2;
            while (true) {
                I0Io.oIX0oI oix0oi2 = this.f34506Oxx0IOOO;
                if (i > oix0oi2.f34507I0Io + oix0oi2.f34509oIX0oI) {
                    break;
                }
                ?? OOXIXo3 = xo2.OOXIXo(i);
                float xxIXOIIO3 = entry.xxIXOIIO() + ((OOXIXo3.xxIXOIIO() - entry.xxIXOIIO()) / 2.0f);
                this.f34600x0XOIxOo.cubicTo(xxIXOIIO3, entry.I0Io() * xxIXOIIO2, xxIXOIIO3, OOXIXo3.I0Io() * xxIXOIIO2, OOXIXo3.xxIXOIIO(), OOXIXo3.I0Io() * xxIXOIIO2);
                i++;
                entry = OOXIXo3;
            }
        }
        if (xo2.OIOoIIOIx()) {
            this.f34597oO.reset();
            this.f34597oO.addPath(this.f34600x0XOIxOo);
            oI0IIXIo(this.f34598oOoXoXO, xo2, this.f34597oO, oxoX2, this.f34506Oxx0IOOO);
        }
        this.f34529I0Io.setColor(xo2.xX0IIXIx0());
        this.f34529I0Io.setStyle(Paint.Style.STROKE);
        oxoX2.oOoXoXO(this.f34600x0XOIxOo);
        this.f34598oOoXoXO.drawPath(this.f34600x0XOIxOo, this.f34529I0Io);
        this.f34529I0Io.setPathEffect(null);
    }

    /* JADX WARN: Type inference failed for: r14v2, types: [com.github.mikephil.charting.data.Entry, o0xxxXXxX.XO] */
    public void IXxxXO(Canvas canvas) {
        boolean z;
        boolean z2;
        II0xO0 iI0xO0;
        Bitmap II0xO02;
        this.f34529I0Io.setStyle(Paint.Style.FILL);
        float xxIXOIIO2 = this.f34530II0xO0.xxIXOIIO();
        float[] fArr = this.f34596Oxx0xo;
        char c = 0;
        float f = 0.0f;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        List<T> Oo2 = this.f34603xxIXOIIO.getLineData().Oo();
        int i = 0;
        while (i < Oo2.size()) {
            IIxOXoOo0.XO xo2 = (IIxOXoOo0.XO) Oo2.get(i);
            if (xo2.isVisible() && xo2.xXOx() && xo2.X0xxXX0() != 0) {
                this.f34602xoIox.setColor(xo2.II0XooXoX());
                XIXIX.xxIXOIIO oxoX2 = this.f34603xxIXOIIO.oxoX(xo2.OX00O0xII());
                this.f34506Oxx0IOOO.oIX0oI(this.f34603xxIXOIIO, xo2);
                float OoO2 = xo2.OoO();
                float I0X0x0oIo2 = xo2.I0X0x0oIo();
                if (xo2.IOoo() && I0X0x0oIo2 < OoO2 && I0X0x0oIo2 > f) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && xo2.II0XooXoX() == 1122867) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                oIX0oI oix0oi = null;
                if (this.f34593IXxxXO.containsKey(xo2)) {
                    iI0xO0 = this.f34593IXxxXO.get(xo2);
                } else {
                    iI0xO0 = new II0xO0(this, oix0oi);
                    this.f34593IXxxXO.put(xo2, iI0xO0);
                }
                if (iI0xO0.I0Io(xo2)) {
                    iI0xO0.oIX0oI(xo2, z, z2);
                }
                I0Io.oIX0oI oix0oi2 = this.f34506Oxx0IOOO;
                int i2 = oix0oi2.f34507I0Io;
                int i3 = oix0oi2.f34509oIX0oI;
                int i4 = i2 + i3;
                while (i3 <= i4) {
                    ?? OOXIXo2 = xo2.OOXIXo(i3);
                    if (OOXIXo2 == 0) {
                        break;
                    }
                    this.f34596Oxx0xo[c] = OOXIXo2.xxIXOIIO();
                    this.f34596Oxx0xo[1] = OOXIXo2.I0Io() * xxIXOIIO2;
                    oxoX2.oO(this.f34596Oxx0xo);
                    if (!this.f34563oIX0oI.oo0xXOI0I(this.f34596Oxx0xo[c])) {
                        break;
                    }
                    if (this.f34563oIX0oI.xI(this.f34596Oxx0xo[c]) && this.f34563oIX0oI.oOXoIIIo(this.f34596Oxx0xo[1]) && (II0xO02 = iI0xO0.II0xO0(i3)) != null) {
                        float[] fArr2 = this.f34596Oxx0xo;
                        canvas.drawBitmap(II0xO02, fArr2[c] - OoO2, fArr2[1] - OoO2, (Paint) null);
                    }
                    i3++;
                    c = 0;
                }
            }
            i++;
            c = 0;
            f = 0.0f;
        }
    }

    public Bitmap.Config O0xOxO() {
        return this.f34599ooOOo0oXI;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.github.mikephil.charting.data.Entry, o0xxxXXxX.XO] */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.github.mikephil.charting.data.Entry, o0xxxXXxX.XO] */
    public final void OxI(IIxOXoOo0.XO xo2, int i, int i2, Path path) {
        boolean z;
        float oIX0oI2 = xo2.ooXIXxIX().oIX0oI(xo2, this.f34603xxIXOIIO);
        float xxIXOIIO2 = this.f34530II0xO0.xxIXOIIO();
        if (xo2.getMode() == LineDataSet.Mode.STEPPED) {
            z = true;
        } else {
            z = false;
        }
        path.reset();
        ?? OOXIXo2 = xo2.OOXIXo(i);
        path.moveTo(OOXIXo2.xxIXOIIO(), oIX0oI2);
        path.lineTo(OOXIXo2.xxIXOIIO(), OOXIXo2.I0Io() * xxIXOIIO2);
        int i3 = i + 1;
        Entry entry = null;
        o0xxxXXxX.XO xo3 = OOXIXo2;
        while (i3 <= i2) {
            ?? OOXIXo3 = xo2.OOXIXo(i3);
            if (z) {
                path.lineTo(OOXIXo3.xxIXOIIO(), xo3.I0Io() * xxIXOIIO2);
            }
            path.lineTo(OOXIXo3.xxIXOIIO(), OOXIXo3.I0Io() * xxIXOIIO2);
            i3++;
            xo3 = OOXIXo3;
            entry = OOXIXo3;
        }
        if (entry != null) {
            path.lineTo(entry.xxIXOIIO(), oIX0oI2);
        }
        path.close();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v5, types: [com.github.mikephil.charting.data.Entry, o0xxxXXxX.XO] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.github.mikephil.charting.data.Entry, o0xxxXXxX.XO] */
    public void Oxx0xo(IIxOXoOo0.XO xo2) {
        float xxIXOIIO2 = this.f34530II0xO0.xxIXOIIO();
        XIXIX.xxIXOIIO oxoX2 = this.f34603xxIXOIIO.oxoX(xo2.OX00O0xII());
        this.f34506Oxx0IOOO.oIX0oI(this.f34603xxIXOIIO, xo2);
        float XIo0oOXIx2 = xo2.XIo0oOXIx();
        this.f34600x0XOIxOo.reset();
        I0Io.oIX0oI oix0oi = this.f34506Oxx0IOOO;
        if (oix0oi.f34507I0Io >= 1) {
            int i = oix0oi.f34509oIX0oI;
            T OOXIXo2 = xo2.OOXIXo(Math.max(i - 1, 0));
            ?? OOXIXo3 = xo2.OOXIXo(Math.max(i, 0));
            if (OOXIXo3 == 0) {
                return;
            }
            this.f34600x0XOIxOo.moveTo(OOXIXo3.xxIXOIIO(), OOXIXo3.I0Io() * xxIXOIIO2);
            Entry entry = OOXIXo3;
            int i2 = this.f34506Oxx0IOOO.f34509oIX0oI + 1;
            int i3 = -1;
            Entry entry2 = OOXIXo3;
            Entry entry3 = OOXIXo2;
            while (true) {
                I0Io.oIX0oI oix0oi2 = this.f34506Oxx0IOOO;
                Entry entry4 = entry2;
                if (i2 > oix0oi2.f34507I0Io + oix0oi2.f34509oIX0oI) {
                    break;
                }
                if (i3 != i2) {
                    entry4 = xo2.OOXIXo(i2);
                }
                int i4 = i2 + 1;
                if (i4 < xo2.X0xxXX0()) {
                    i2 = i4;
                }
                ?? OOXIXo4 = xo2.OOXIXo(i2);
                this.f34600x0XOIxOo.cubicTo(entry.xxIXOIIO() + ((entry4.xxIXOIIO() - entry3.xxIXOIIO()) * XIo0oOXIx2), (entry.I0Io() + ((entry4.I0Io() - entry3.I0Io()) * XIo0oOXIx2)) * xxIXOIIO2, entry4.xxIXOIIO() - ((OOXIXo4.xxIXOIIO() - entry.xxIXOIIO()) * XIo0oOXIx2), (entry4.I0Io() - ((OOXIXo4.I0Io() - entry.I0Io()) * XIo0oOXIx2)) * xxIXOIIO2, entry4.xxIXOIIO(), entry4.I0Io() * xxIXOIIO2);
                entry3 = entry;
                entry = entry4;
                entry2 = OOXIXo4;
                int i5 = i2;
                i2 = i4;
                i3 = i5;
            }
        }
        if (xo2.OIOoIIOIx()) {
            this.f34597oO.reset();
            this.f34597oO.addPath(this.f34600x0XOIxOo);
            oI0IIXIo(this.f34598oOoXoXO, xo2, this.f34597oO, oxoX2, this.f34506Oxx0IOOO);
        }
        this.f34529I0Io.setColor(xo2.xX0IIXIx0());
        this.f34529I0Io.setStyle(Paint.Style.STROKE);
        oxoX2.oOoXoXO(this.f34600x0XOIxOo);
        this.f34598oOoXoXO.drawPath(this.f34600x0XOIxOo, this.f34529I0Io);
        this.f34529I0Io.setPathEffect(null);
    }

    public void OxxIIOOXO(Canvas canvas, IIxOXoOo0.XO xo2) {
        if (xo2.X0xxXX0() < 1) {
            return;
        }
        this.f34529I0Io.setStrokeWidth(xo2.IoOoo());
        this.f34529I0Io.setPathEffect(xo2.oOXoIIIo());
        int i = oIX0oI.f34607oIX0oI[xo2.getMode().ordinal()];
        if (i != 3) {
            if (i != 4) {
                xoXoI(canvas, xo2);
            } else {
                IIXOooo(xo2);
            }
        } else {
            Oxx0xo(xo2);
        }
        this.f34529I0Io.setPathEffect(null);
    }

    public void X0IIOO() {
        Canvas canvas = this.f34598oOoXoXO;
        if (canvas != null) {
            canvas.setBitmap(null);
            this.f34598oOoXoXO = null;
        }
        WeakReference<Bitmap> weakReference = this.f34594OOXIXo;
        if (weakReference != null) {
            Bitmap bitmap = weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f34594OOXIXo.clear();
            this.f34594OOXIXo = null;
        }
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void X0o0xo(Canvas canvas, String str, float f, float f2, int i) {
        this.f34532XO.setColor(i);
        canvas.drawText(str, f, f2, this.f34532XO);
    }

    public void XI0IXoo(Bitmap.Config config) {
        this.f34599ooOOo0oXI = config;
        X0IIOO();
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void XO(Canvas canvas) {
        int i;
        IIxOXoOo0.XO xo2;
        Entry entry;
        if (OOXIXo(this.f34603xxIXOIIO)) {
            List<T> Oo2 = this.f34603xxIXOIIO.getLineData().Oo();
            for (int i2 = 0; i2 < Oo2.size(); i2++) {
                IIxOXoOo0.XO xo3 = (IIxOXoOo0.XO) Oo2.get(i2);
                if (ooOOo0oXI(xo3) && xo3.X0xxXX0() >= 1) {
                    oIX0oI(xo3);
                    XIXIX.xxIXOIIO oxoX2 = this.f34603xxIXOIIO.oxoX(xo3.OX00O0xII());
                    int OoO2 = (int) (xo3.OoO() * 1.75f);
                    if (!xo3.xXOx()) {
                        OoO2 /= 2;
                    }
                    int i3 = OoO2;
                    this.f34506Oxx0IOOO.oIX0oI(this.f34603xxIXOIIO, xo3);
                    float II0XooXoX2 = this.f34530II0xO0.II0XooXoX();
                    float xxIXOIIO2 = this.f34530II0xO0.xxIXOIIO();
                    I0Io.oIX0oI oix0oi = this.f34506Oxx0IOOO;
                    float[] I0Io2 = oxoX2.I0Io(xo3, II0XooXoX2, xxIXOIIO2, oix0oi.f34509oIX0oI, oix0oi.f34508II0xO0);
                    ox.x0xO0oo xxIO2 = xo3.xxIO();
                    XIXIX.Oxx0IOOO oxoX3 = XIXIX.Oxx0IOOO.oxoX(xo3.IO0XoXxO());
                    oxoX3.f3771IXxxXO = XIXIX.OOXIXo.X0o0xo(oxoX3.f3771IXxxXO);
                    oxoX3.f3772Oxx0xo = XIXIX.OOXIXo.X0o0xo(oxoX3.f3772Oxx0xo);
                    int i4 = 0;
                    while (i4 < I0Io2.length) {
                        float f = I0Io2[i4];
                        float f2 = I0Io2[i4 + 1];
                        if (!this.f34563oIX0oI.oo0xXOI0I(f)) {
                            break;
                        }
                        if (!this.f34563oIX0oI.xI(f) || !this.f34563oIX0oI.oOXoIIIo(f2)) {
                            i = i3;
                            xo2 = xo3;
                        } else {
                            int i5 = i4 / 2;
                            Entry OOXIXo2 = xo3.OOXIXo(this.f34506Oxx0IOOO.f34509oIX0oI + i5);
                            if (xo3.xoO0xx0()) {
                                entry = OOXIXo2;
                                i = i3;
                                xo2 = xo3;
                                X0o0xo(canvas, xxIO2.xoIox(OOXIXo2), f, f2 - i3, xo3.x0xO0oo(i5));
                            } else {
                                entry = OOXIXo2;
                                i = i3;
                                xo2 = xo3;
                            }
                            if (entry.II0xO0() != null && xo2.oo0xXOI0I()) {
                                Drawable II0xO02 = entry.II0xO0();
                                XIXIX.OOXIXo.OOXIXo(canvas, II0xO02, (int) (f + oxoX3.f3771IXxxXO), (int) (f2 + oxoX3.f3772Oxx0xo), II0xO02.getIntrinsicWidth(), II0xO02.getIntrinsicHeight());
                            }
                        }
                        i4 += 2;
                        xo3 = xo2;
                        i3 = i;
                    }
                    XIXIX.Oxx0IOOO.II0XooXoX(oxoX3);
                }
            }
        }
    }

    public void o00(Canvas canvas, IIxOXoOo0.XO xo2, XIXIX.xxIXOIIO xxixoiio, I0Io.oIX0oI oix0oi) {
        int i;
        int i2;
        Path path = this.f34595Oo;
        int i3 = oix0oi.f34509oIX0oI;
        int i4 = oix0oi.f34507I0Io + i3;
        int i5 = 0;
        do {
            i = (i5 * 128) + i3;
            i2 = i + 128;
            if (i2 > i4) {
                i2 = i4;
            }
            if (i <= i2) {
                OxI(xo2, i, i2, path);
                xxixoiio.oOoXoXO(path);
                Drawable xxIXOIIO2 = xo2.xxIXOIIO();
                if (xxIXOIIO2 != null) {
                    Oo(canvas, path, xxIXOIIO2);
                } else {
                    x0xO0oo(canvas, path, xo2.XxX0x0xxx(), xo2.I0oOIX());
                }
            }
            i5++;
        } while (i <= i2);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.github.mikephil.charting.data.Entry] */
    public void oI0IIXIo(Canvas canvas, IIxOXoOo0.XO xo2, Path path, XIXIX.xxIXOIIO xxixoiio, I0Io.oIX0oI oix0oi) {
        float oIX0oI2 = xo2.ooXIXxIX().oIX0oI(xo2, this.f34603xxIXOIIO);
        path.lineTo(xo2.OOXIXo(oix0oi.f34509oIX0oI + oix0oi.f34507I0Io).xxIXOIIO(), oIX0oI2);
        path.lineTo(xo2.OOXIXo(oix0oi.f34509oIX0oI).xxIXOIIO(), oIX0oI2);
        path.close();
        xxixoiio.oOoXoXO(path);
        Drawable xxIXOIIO2 = xo2.xxIXOIIO();
        if (xxIXOIIO2 != null) {
            Oo(canvas, path, xxIXOIIO2);
        } else {
            x0xO0oo(canvas, path, xo2.XxX0x0xxx(), xo2.I0oOIX());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.github.mikephil.charting.data.Entry, o0xxxXXxX.XO] */
    @Override // xX0IIXIx0.Oxx0IOOO
    public void oxoX(Canvas canvas, XI0oooXX.oxoX[] oxoxArr) {
        o0xxxXXxX.ooOOo0oXI lineData = this.f34603xxIXOIIO.getLineData();
        for (XI0oooXX.oxoX oxox : oxoxArr) {
            IIxOXoOo0.XO xo2 = (IIxOXoOo0.XO) lineData.OOXIXo(oxox.oxoX());
            if (xo2 != null && xo2.XX0()) {
                ?? Ox0O2 = xo2.Ox0O(oxox.II0XooXoX(), oxox.xoIox());
                if (oOoXoXO(Ox0O2, xo2)) {
                    XIXIX.XO XO2 = this.f34603xxIXOIIO.oxoX(xo2.OX00O0xII()).XO(Ox0O2.xxIXOIIO(), Ox0O2.I0Io() * this.f34530II0xO0.xxIXOIIO());
                    oxox.x0XOIxOo((float) XO2.f3774IXxxXO, (float) XO2.f3775Oxx0xo);
                    x0XOIxOo(canvas, (float) XO2.f3774IXxxXO, (float) XO2.f3775Oxx0xo, xo2);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r12v11, types: [com.github.mikephil.charting.data.Entry, o0xxxXXxX.XO] */
    /* JADX WARN: Type inference failed for: r13v5, types: [com.github.mikephil.charting.data.Entry, o0xxxXXxX.XO] */
    /* JADX WARN: Type inference failed for: r8v22, types: [com.github.mikephil.charting.data.Entry, o0xxxXXxX.XO] */
    /* JADX WARN: Type inference failed for: r8v4, types: [com.github.mikephil.charting.data.Entry, o0xxxXXxX.XO] */
    public void xoXoI(Canvas canvas, IIxOXoOo0.XO xo2) {
        boolean z;
        int i;
        Canvas canvas2;
        int i2;
        int X0xxXX02 = xo2.X0xxXX0();
        if (xo2.getMode() == LineDataSet.Mode.STEPPED) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i = 4;
        } else {
            i = 2;
        }
        XIXIX.xxIXOIIO oxoX2 = this.f34603xxIXOIIO.oxoX(xo2.OX00O0xII());
        float xxIXOIIO2 = this.f34530II0xO0.xxIXOIIO();
        this.f34529I0Io.setStyle(Paint.Style.STROKE);
        if (xo2.XO()) {
            canvas2 = this.f34598oOoXoXO;
        } else {
            canvas2 = canvas;
        }
        this.f34506Oxx0IOOO.oIX0oI(this.f34603xxIXOIIO, xo2);
        if (xo2.OIOoIIOIx() && X0xxXX02 > 0) {
            o00(canvas, xo2, oxoX2, this.f34506Oxx0IOOO);
        }
        if (xo2.OOXIxO0().size() > 1) {
            int i3 = i * 2;
            if (this.f34601x0xO0oo.length <= i3) {
                this.f34601x0xO0oo = new float[i * 4];
            }
            int i4 = this.f34506Oxx0IOOO.f34509oIX0oI;
            while (true) {
                I0Io.oIX0oI oix0oi = this.f34506Oxx0IOOO;
                if (i4 > oix0oi.f34507I0Io + oix0oi.f34509oIX0oI) {
                    break;
                }
                ?? OOXIXo2 = xo2.OOXIXo(i4);
                if (OOXIXo2 != 0) {
                    this.f34601x0xO0oo[0] = OOXIXo2.xxIXOIIO();
                    this.f34601x0xO0oo[1] = OOXIXo2.I0Io() * xxIXOIIO2;
                    if (i4 < this.f34506Oxx0IOOO.f34508II0xO0) {
                        ?? OOXIXo3 = xo2.OOXIXo(i4 + 1);
                        if (OOXIXo3 == 0) {
                            break;
                        }
                        if (z) {
                            this.f34601x0xO0oo[2] = OOXIXo3.xxIXOIIO();
                            float[] fArr = this.f34601x0xO0oo;
                            float f = fArr[1];
                            fArr[3] = f;
                            fArr[4] = fArr[2];
                            fArr[5] = f;
                            fArr[6] = OOXIXo3.xxIXOIIO();
                            this.f34601x0xO0oo[7] = OOXIXo3.I0Io() * xxIXOIIO2;
                        } else {
                            this.f34601x0xO0oo[2] = OOXIXo3.xxIXOIIO();
                            this.f34601x0xO0oo[3] = OOXIXo3.I0Io() * xxIXOIIO2;
                        }
                    } else {
                        float[] fArr2 = this.f34601x0xO0oo;
                        fArr2[2] = fArr2[0];
                        fArr2[3] = fArr2[1];
                    }
                    oxoX2.oO(this.f34601x0xO0oo);
                    if (!this.f34563oIX0oI.oo0xXOI0I(this.f34601x0xO0oo[0])) {
                        break;
                    }
                    if (this.f34563oIX0oI.xI(this.f34601x0xO0oo[2]) && (this.f34563oIX0oI.oo(this.f34601x0xO0oo[1]) || this.f34563oIX0oI.ooXIXxIX(this.f34601x0xO0oo[3]))) {
                        this.f34529I0Io.setColor(xo2.XXoOx0(i4));
                        canvas2.drawLines(this.f34601x0xO0oo, 0, i3, this.f34529I0Io);
                    }
                }
                i4++;
            }
        } else {
            int i5 = X0xxXX02 * i;
            if (this.f34601x0xO0oo.length < Math.max(i5, i) * 2) {
                this.f34601x0xO0oo = new float[Math.max(i5, i) * 4];
            }
            if (xo2.OOXIXo(this.f34506Oxx0IOOO.f34509oIX0oI) != 0) {
                int i6 = this.f34506Oxx0IOOO.f34509oIX0oI;
                int i7 = 0;
                while (true) {
                    I0Io.oIX0oI oix0oi2 = this.f34506Oxx0IOOO;
                    if (i6 > oix0oi2.f34507I0Io + oix0oi2.f34509oIX0oI) {
                        break;
                    }
                    if (i6 == 0) {
                        i2 = 0;
                    } else {
                        i2 = i6 - 1;
                    }
                    ?? OOXIXo4 = xo2.OOXIXo(i2);
                    ?? OOXIXo5 = xo2.OOXIXo(i6);
                    if (OOXIXo4 != 0 && OOXIXo5 != 0) {
                        this.f34601x0xO0oo[i7] = OOXIXo4.xxIXOIIO();
                        int i8 = i7 + 2;
                        this.f34601x0xO0oo[i7 + 1] = OOXIXo4.I0Io() * xxIXOIIO2;
                        if (z) {
                            this.f34601x0xO0oo[i8] = OOXIXo5.xxIXOIIO();
                            this.f34601x0xO0oo[i7 + 3] = OOXIXo4.I0Io() * xxIXOIIO2;
                            this.f34601x0xO0oo[i7 + 4] = OOXIXo5.xxIXOIIO();
                            i8 = i7 + 6;
                            this.f34601x0xO0oo[i7 + 5] = OOXIXo4.I0Io() * xxIXOIIO2;
                        }
                        this.f34601x0xO0oo[i8] = OOXIXo5.xxIXOIIO();
                        this.f34601x0xO0oo[i8 + 1] = OOXIXo5.I0Io() * xxIXOIIO2;
                        i7 = i8 + 2;
                    }
                    i6++;
                }
                if (i7 > 0) {
                    oxoX2.oO(this.f34601x0xO0oo);
                    int max = Math.max((this.f34506Oxx0IOOO.f34507I0Io + 1) * i, i) * 2;
                    this.f34529I0Io.setColor(xo2.xX0IIXIx0());
                    canvas2.drawLines(this.f34601x0xO0oo, 0, max, this.f34529I0Io);
                }
            }
        }
        this.f34529I0Io.setPathEffect(null);
    }

    /* loaded from: classes9.dex */
    public class II0xO0 {

        /* renamed from: II0xO0, reason: collision with root package name */
        public Bitmap[] f34605II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public Path f34606oIX0oI;

        public II0xO0() {
            this.f34606oIX0oI = new Path();
        }

        public boolean I0Io(IIxOXoOo0.XO xo2) {
            int xxX2 = xo2.xxX();
            Bitmap[] bitmapArr = this.f34605II0xO0;
            if (bitmapArr == null) {
                this.f34605II0xO0 = new Bitmap[xxX2];
                return true;
            }
            if (bitmapArr.length != xxX2) {
                this.f34605II0xO0 = new Bitmap[xxX2];
                return true;
            }
            return false;
        }

        public Bitmap II0xO0(int i) {
            Bitmap[] bitmapArr = this.f34605II0xO0;
            return bitmapArr[i % bitmapArr.length];
        }

        public void oIX0oI(IIxOXoOo0.XO xo2, boolean z, boolean z2) {
            int xxX2 = xo2.xxX();
            float OoO2 = xo2.OoO();
            float I0X0x0oIo2 = xo2.I0X0x0oIo();
            for (int i = 0; i < xxX2; i++) {
                int i2 = (int) (OoO2 * 2.1d);
                Bitmap createBitmap = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_4444);
                Canvas canvas = new Canvas(createBitmap);
                this.f34605II0xO0[i] = createBitmap;
                xoIox.this.f34529I0Io.setColor(xo2.xo0x(i));
                if (z2) {
                    this.f34606oIX0oI.reset();
                    this.f34606oIX0oI.addCircle(OoO2, OoO2, OoO2, Path.Direction.CW);
                    this.f34606oIX0oI.addCircle(OoO2, OoO2, I0X0x0oIo2, Path.Direction.CCW);
                    canvas.drawPath(this.f34606oIX0oI, xoIox.this.f34529I0Io);
                } else {
                    canvas.drawCircle(OoO2, OoO2, OoO2, xoIox.this.f34529I0Io);
                    if (z) {
                        canvas.drawCircle(OoO2, OoO2, I0X0x0oIo2, xoIox.this.f34602xoIox);
                    }
                }
            }
        }

        public /* synthetic */ II0xO0(xoIox xoiox, oIX0oI oix0oi) {
            this();
        }
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void xoIox() {
    }
}
