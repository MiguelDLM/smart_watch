package IIoX0OoI;

import android.graphics.Bitmap;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.devilsen.czxing.code.BarcodeFormat;
import me.devilsen.czxing.code.CodeResult;
import me.devilsen.czxing.code.DecodeEngine;

/* loaded from: classes6.dex */
public class oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final DecodeEngine f344oIX0oI;

    /* loaded from: classes6.dex */
    public class I0Io implements Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ int f345IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ byte[] f346Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ int f347Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ oxoX f348XO;

        public I0Io(oxoX oxox, byte[] bArr, int i, int i2) {
            this.f348XO = oxox;
            this.f346Oo = bArr;
            this.f345IXxxXO = i;
            this.f347Oxx0xo = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            oxoX oxox = this.f348XO;
            if (oxox != null) {
                oxox.oIX0oI(oIX0oI.this.II0XooXoX(this.f346Oo, this.f345IXxxXO, this.f347Oxx0xo));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class II0xO0 implements Runnable {

        /* renamed from: IIXOooo, reason: collision with root package name */
        public final /* synthetic */ int f350IIXOooo;

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ int f351IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ int f352Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ int f354Oxx0xo;

        /* renamed from: OxxIIOOXO, reason: collision with root package name */
        public final /* synthetic */ int f355OxxIIOOXO;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ byte[] f356XO;

        /* renamed from: o00, reason: collision with root package name */
        public final /* synthetic */ XO f357o00;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public final /* synthetic */ int f358oI0IIXIo;

        /* renamed from: xoXoI, reason: collision with root package name */
        public final /* synthetic */ X0o0xo f359xoXoI;

        public II0xO0(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, X0o0xo x0o0xo, XO xo2) {
            this.f356XO = bArr;
            this.f352Oo = i;
            this.f351IXxxXO = i2;
            this.f354Oxx0xo = i3;
            this.f358oI0IIXIo = i4;
            this.f355OxxIIOOXO = i5;
            this.f350IIXOooo = i6;
            this.f359xoXoI = x0o0xo;
            this.f357o00 = xo2;
        }

        @Override // java.lang.Runnable
        public void run() {
            XO xo2;
            List<CodeResult> oxoX2 = oIX0oI.this.oxoX(this.f356XO, this.f352Oo, this.f351IXxxXO, this.f354Oxx0xo, this.f358oI0IIXIo, this.f355OxxIIOOXO, this.f350IIXOooo);
            X0o0xo x0o0xo = this.f359xoXoI;
            if (x0o0xo != null) {
                x0o0xo.II0xO0(oxoX2);
            }
            if (oxoX2.isEmpty() && (xo2 = this.f357o00) != null) {
                xo2.I0Io();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface X0o0xo {
        void II0xO0(List<CodeResult> list);
    }

    /* loaded from: classes6.dex */
    public interface XO {
        void I0Io();
    }

    /* renamed from: IIoX0OoI.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC0011oIX0oI implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Bitmap f361Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ X0o0xo f362XO;

        public RunnableC0011oIX0oI(X0o0xo x0o0xo, Bitmap bitmap) {
            this.f362XO = x0o0xo;
            this.f361Oo = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            X0o0xo x0o0xo = this.f362XO;
            if (x0o0xo != null) {
                x0o0xo.II0xO0(oIX0oI.this.II0xO0(this.f361Oo));
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface oxoX {
        void oIX0oI(double d);
    }

    public oIX0oI() {
        this(BarcodeFormat.QR_CODE);
    }

    public void I0Io(Bitmap bitmap, X0o0xo x0o0xo) {
        oOIXoIXXI.oIX0oI.II0xO0().execute(new RunnableC0011oIX0oI(x0o0xo, bitmap));
    }

    @CheckResult
    public double II0XooXoX(byte[] bArr, int i, int i2) {
        return this.f344oIX0oI.oxoX(bArr, i, i2);
    }

    @NonNull
    @CheckResult
    public List<CodeResult> II0xO0(Bitmap bitmap) {
        if (bitmap == null) {
            oI00o.II0xO0.I0Io("bitmap is null");
            return new ArrayList(0);
        }
        if ((bitmap.getHeight() < 2000 || bitmap.getWidth() < 1100) && bitmap.getHeight() < 3000) {
            oI00o.II0xO0.oIX0oI("zoom bitmap");
            bitmap = oI00o.oxoX.II0XooXoX(bitmap);
        }
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, false);
        oI00o.II0xO0.oIX0oI("bitmap width = " + copy.getWidth() + " height = " + copy.getHeight());
        CodeResult[] oIX0oI2 = this.f344oIX0oI.oIX0oI(copy);
        copy.recycle();
        return oIX0oI(oIX0oI2);
    }

    public void OOXIXo(BarcodeFormat... barcodeFormatArr) {
        if (barcodeFormatArr != null && barcodeFormatArr.length != 0) {
            this.f344oIX0oI.XO(xoIox(barcodeFormatArr));
        }
    }

    public void Oxx0IOOO() {
        this.f344oIX0oI.I0Io();
    }

    public void X0o0xo(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, X0o0xo x0o0xo) {
        XO(bArr, i, i2, i3, i4, i5, i6, x0o0xo, null);
    }

    public void XO(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, X0o0xo x0o0xo, XO xo2) {
        oOIXoIXXI.oIX0oI.II0xO0().execute(new II0xO0(bArr, i, i2, i3, i4, i5, i6, x0o0xo, xo2));
    }

    @NonNull
    @CheckResult
    public final List<CodeResult> oIX0oI(CodeResult[] codeResultArr) {
        if (codeResultArr != null) {
            return Arrays.asList(codeResultArr);
        }
        return new ArrayList(0);
    }

    public void oOoXoXO(String str, String str2, String str3, String str4) {
        this.f344oIX0oI.X0o0xo(str, str2, str3, str4);
    }

    @NonNull
    @CheckResult
    public List<CodeResult> oxoX(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        return oIX0oI(this.f344oIX0oI.II0xO0(bArr, i, i2, i3, i4, i5, i6));
    }

    public final int[] xoIox(BarcodeFormat... barcodeFormatArr) {
        int[] iArr = new int[barcodeFormatArr.length];
        for (int i = 0; i < barcodeFormatArr.length; i++) {
            iArr[i] = barcodeFormatArr[i].getValue();
        }
        return iArr;
    }

    public void xxIXOIIO(byte[] bArr, int i, int i2, oxoX oxox) {
        oOIXoIXXI.oIX0oI.X0o0xo().execute(new I0Io(oxox, bArr, i, i2));
    }

    public oIX0oI(BarcodeFormat... barcodeFormatArr) {
        this.f344oIX0oI = new DecodeEngine(xoIox(barcodeFormatArr));
    }
}
