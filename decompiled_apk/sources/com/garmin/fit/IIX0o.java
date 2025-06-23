package com.garmin.fit;

import com.garmin.fit.Fit;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public class IIX0o implements IXIxx0, O0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public xooxxX[] f11430I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public DataOutputStream f11431II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public Fit.ProtocolVersion f11432X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public ByteArrayOutputStream f11433oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public OxIxx0 f11434oxoX;

    @Deprecated
    public IIX0o() {
        this(Fit.ProtocolVersion.V1_0);
    }

    public void II0XooXoX(List<? extends oIXoXx0> list) {
        Iterator<? extends oIXoXx0> it = list.iterator();
        while (it.hasNext()) {
            XO(it.next());
        }
    }

    @Override // com.garmin.fit.IXIxx0
    public void II0xO0(oIXoXx0 oixoxx0) {
        XO(oixoxx0);
    }

    public void Oxx0IOOO(xooxxX xooxxx) {
        if (this.f11434oxoX.oIX0oI(xooxxx)) {
            xooxxx.ooOOo0oXI(this.f11431II0xO0);
            this.f11430I0Io[xooxxx.f15596II0xO0] = xooxxx;
            return;
        }
        throw new FitRuntimeException("Incompatible Protocol Features");
    }

    public void X0o0xo() {
        this.f11433oIX0oI.reset();
        xxIXOIIO();
    }

    public void XO(oIXoXx0 oixoxx0) {
        if (this.f11434oxoX.II0xO0(oixoxx0)) {
            xooxxX xooxxx = this.f11430I0Io[oixoxx0.f14423I0Io];
            if (xooxxx == null || !xooxxx.OOXIXo(oixoxx0)) {
                Oxx0IOOO(new xooxxX(oixoxx0));
            }
            oixoxx0.I0xX0(this.f11431II0xO0, this.f11430I0Io[oixoxx0.f14423I0Io]);
            return;
        }
        throw new FitRuntimeException("Incompatible Protocol Features");
    }

    public byte[] oIX0oI() {
        this.f11433oIX0oI.write(0);
        this.f11433oIX0oI.write(0);
        byte[] byteArray = this.f11433oIX0oI.toByteArray();
        long length = byteArray.length - 16;
        byteArray[4] = (byte) (length & 255);
        byteArray[5] = (byte) ((length >> 8) & 255);
        byteArray[6] = (byte) ((length >> 16) & 255);
        byteArray[7] = (byte) ((length >> 24) & 255);
        int i = 0;
        for (int i2 = 0; i2 < 12; i2++) {
            i = X00IoxXI.oIX0oI(i, byteArray[i2]);
        }
        byteArray[12] = (byte) (i & 255);
        byteArray[13] = (byte) ((i >> 8) & 255);
        int i3 = 0;
        for (int i4 = 0; i4 < byteArray.length - 2; i4++) {
            i3 = X00IoxXI.oIX0oI(i3, byteArray[i4]);
        }
        byteArray[byteArray.length - 2] = (byte) (i3 & 255);
        byteArray[byteArray.length - 1] = (byte) ((i3 >> 8) & 255);
        X0o0xo();
        return byteArray;
    }

    @Override // com.garmin.fit.O0xO0
    public void oxoX(xooxxX xooxxx) {
        Oxx0IOOO(xooxxx);
    }

    public final void xxIXOIIO() {
        this.f11433oIX0oI.write(14);
        this.f11433oIX0oI.write(this.f11432X0o0xo.getVersion());
        this.f11433oIX0oI.write(149);
        this.f11433oIX0oI.write(82);
        this.f11433oIX0oI.write(0);
        this.f11433oIX0oI.write(0);
        this.f11433oIX0oI.write(0);
        this.f11433oIX0oI.write(0);
        this.f11433oIX0oI.write(46);
        this.f11433oIX0oI.write(70);
        this.f11433oIX0oI.write(73);
        this.f11433oIX0oI.write(84);
        this.f11433oIX0oI.write(0);
        this.f11433oIX0oI.write(0);
    }

    public IIX0o(Fit.ProtocolVersion protocolVersion) {
        this.f11430I0Io = new xooxxX[16];
        this.f11432X0o0xo = protocolVersion;
        this.f11434oxoX = IOOXOOOOo.oIX0oI(protocolVersion);
        this.f11433oIX0oI = new ByteArrayOutputStream();
        this.f11431II0xO0 = new DataOutputStream(this.f11433oIX0oI);
        X0o0xo();
    }
}
