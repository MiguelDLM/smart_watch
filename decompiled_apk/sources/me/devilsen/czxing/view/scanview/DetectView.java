package me.devilsen.czxing.view.scanview;

import IIoX0OoI.oIX0oI;
import android.content.Context;
import android.util.AttributeSet;
import java.util.List;
import me.devilsen.czxing.code.BarcodeFormat;
import me.devilsen.czxing.code.CodeResult;

/* loaded from: classes6.dex */
public class DetectView extends CameraView {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public boolean f30880IIXOooo;

    /* renamed from: OxI, reason: collision with root package name */
    public oIX0oI.XO f30881OxI;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public IIoX0OoI.oIX0oI f30882OxxIIOOXO;

    /* renamed from: o00, reason: collision with root package name */
    public oIX0oI.oxoX f30883o00;

    /* renamed from: xoXoI, reason: collision with root package name */
    public oIX0oI.X0o0xo f30884xoXoI;

    /* loaded from: classes6.dex */
    public class I0Io implements oIX0oI.oxoX {
        public I0Io() {
        }

        @Override // IIoX0OoI.oIX0oI.oxoX
        public void oIX0oI(double d) {
            if (!DetectView.this.f30880IIXOooo && DetectView.this.f30883o00 != null) {
                DetectView.this.f30883o00.oIX0oI(d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class II0xO0 implements oIX0oI.XO {
        public II0xO0() {
        }

        @Override // IIoX0OoI.oIX0oI.XO
        public void I0Io() {
            if (!DetectView.this.f30880IIXOooo && DetectView.this.f30881OxI != null) {
                DetectView.this.f30881OxI.I0Io();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class oIX0oI implements oIX0oI.X0o0xo {
        public oIX0oI() {
        }

        @Override // IIoX0OoI.oIX0oI.X0o0xo
        public void II0xO0(List<CodeResult> list) {
            if (list.size() != 0 && !DetectView.this.f30880IIXOooo && DetectView.this.f30884xoXoI != null) {
                DetectView.this.f30884xoXoI.II0xO0(list);
            }
        }
    }

    public DetectView(Context context) {
        this(context, null);
    }

    public void IXxxXO(String str, String str2, String str3, String str4) {
        IIoX0OoI.oIX0oI oix0oi = this.f30882OxxIIOOXO;
        if (oix0oi != null) {
            oix0oi.oOoXoXO(str, str2, str3, str4);
        }
    }

    @Override // me.devilsen.czxing.view.scanview.CameraView
    public void Oxx0IOOO() {
        super.Oxx0IOOO();
        this.f30880IIXOooo = true;
        oOIXoIXXI.oIX0oI.II0xO0().shutdownNow();
        oOIXoIXXI.oIX0oI.X0o0xo().shutdownNow();
        IIoX0OoI.oIX0oI oix0oi = this.f30882OxxIIOOXO;
        if (oix0oi != null) {
            oix0oi.Oxx0IOOO();
            this.f30882OxxIIOOXO = null;
        }
    }

    public void Oxx0xo() {
        this.f30880IIXOooo = false;
    }

    public void oI0IIXIo() {
        this.f30880IIXOooo = true;
    }

    @Override // me.devilsen.czxing.view.scanview.CameraView, IOOXOOOOo.II0xO0.oIX0oI
    public void oIX0oI(byte[] bArr, int i, int i2) {
        if (this.f30880IIXOooo) {
            return;
        }
        this.f30882OxxIIOOXO.XO(bArr, 0, 0, i, i2, i, i2, new oIX0oI(), new II0xO0());
        this.f30882OxxIIOOXO.xxIXOIIO(bArr, i, i2, new I0Io());
    }

    public void setBarcodeFormat(BarcodeFormat... barcodeFormatArr) {
        this.f30882OxxIIOOXO.OOXIXo(barcodeFormatArr);
    }

    public void setOnDetectBrightnessListener(oIX0oI.oxoX oxox) {
        this.f30883o00 = oxox;
    }

    public void setOnDetectCodeListener(oIX0oI.X0o0xo x0o0xo) {
        this.f30884xoXoI = x0o0xo;
    }

    public void setOnFocusListener(oIX0oI.XO xo2) {
        this.f30881OxI = xo2;
    }

    public DetectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DetectView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f30882OxxIIOOXO = new IIoX0OoI.oIX0oI();
    }
}
