package jxl.read.biff;

import com.realsil.sdk.dfu.image.constants.SubBinId;

/* loaded from: classes6.dex */
public class oO extends OoIXo.Xx000oIo {

    /* renamed from: I0Io, reason: collision with root package name */
    public byte[] f28377I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public boolean f28378II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f28379Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f28380X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f28381XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f28382oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public boolean f28383xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f28384xxIXOIIO;

    public oO(xoxXI xoxxi) {
        super(OoIXo.xII.f2456OxxIIOOXO);
        boolean z;
        byte[] I0Io2 = xoxxi.I0Io();
        this.f28377I0Io = I0Io2;
        this.f28382oxoX = OoIXo.oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
        byte[] bArr = this.f28377I0Io;
        this.f28380X0o0xo = OoIXo.oo0xXOI0I.I0Io(bArr[2], bArr[3]);
        byte[] bArr2 = this.f28377I0Io;
        this.f28379Oxx0IOOO = OoIXo.oo0xXOI0I.I0Io(bArr2[4], bArr2[5]);
        byte[] bArr3 = this.f28377I0Io;
        this.f28381XO = OoIXo.oo0xXOI0I.I0Io(bArr3[6], bArr3[7]);
        byte[] bArr4 = this.f28377I0Io;
        int I0Io3 = OoIXo.oo0xXOI0I.I0Io(bArr4[8], bArr4[9]);
        if ((I0Io3 & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f28378II0XooXoX = z;
        this.f28384xxIXOIIO = (I0Io3 & SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE) >> 8;
        this.f28383xoIox = (I0Io3 & 4096) != 0;
    }

    public int I0X0x0oIo() {
        return this.f28384xxIXOIIO;
    }

    public boolean XX0() {
        return this.f28378II0XooXoX;
    }

    public int Xo0() {
        return this.f28379Oxx0IOOO;
    }

    public int XoI0Ixx0() {
        return this.f28381XO;
    }

    public int oX() {
        return this.f28382oxoX;
    }

    public int xXOx() {
        return this.f28380X0o0xo;
    }

    public boolean xo0x() {
        return this.f28383xoIox;
    }
}
