package com.garmin.fit;

import com.garmin.fit.Fit;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CheckedOutputStream;

/* loaded from: classes9.dex */
public class OIx00oxx implements IXIxx0, O0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public Xx000oIo f12491I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public CheckedOutputStream f12492II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public Fit.ProtocolVersion f12493X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public OxIxx0 f12494XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public java.io.File f12495oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public xooxxX[] f12496oxoX;

    public OIx00oxx() {
        this.f12496oxoX = new xooxxX[16];
    }

    private void xxIXOIIO() {
        if (this.f12495oIX0oI != null) {
            try {
                Xx000oIo xx000oIo = new Xx000oIo();
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.f12495oIX0oI, "rw");
                long length = this.f12495oIX0oI.length() - 14;
                if (length < 0) {
                    length = 0;
                }
                byte[] bArr = {14, (byte) this.f12493X0o0xo.getVersion(), -107, 82, (byte) (length & 255), (byte) ((length >> 8) & 255), (byte) ((length >> 16) & 255), (byte) ((length >> 24) & 255), 46, 70, 73, 84};
                randomAccessFile.write(bArr);
                xx000oIo.update(bArr, 0, 12);
                long value = xx000oIo.getValue();
                randomAccessFile.write((byte) (value & 255));
                randomAccessFile.write((byte) ((value >> 8) & 255));
                randomAccessFile.close();
                return;
            } catch (IOException e) {
                throw new FitRuntimeException(e);
            }
        }
        throw new FitRuntimeException("File not open.");
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
        if (this.f12495oIX0oI != null) {
            if (this.f12494XO.oIX0oI(xooxxx)) {
                xooxxx.ooOOo0oXI(this.f12492II0xO0);
                this.f12496oxoX[xooxxx.f15596II0xO0] = xooxxx;
                return;
            }
            throw new FitRuntimeException("Incompatible Protocol Features");
        }
        throw new FitRuntimeException("File not open.");
    }

    public void X0o0xo(java.io.File file) {
        file.delete();
        this.f12491I0Io = new Xx000oIo();
        this.f12495oIX0oI = file;
        xxIXOIIO();
        try {
            this.f12492II0xO0 = new CheckedOutputStream(new FileOutputStream(this.f12495oIX0oI, true), this.f12491I0Io);
        } catch (IOException e) {
            throw new FitRuntimeException(e);
        }
    }

    public void XO(oIXoXx0 oixoxx0) {
        if (this.f12495oIX0oI != null) {
            if (this.f12494XO.II0xO0(oixoxx0)) {
                xooxxX xooxxx = this.f12496oxoX[oixoxx0.f14423I0Io];
                if (xooxxx == null || !xooxxx.OOXIXo(oixoxx0)) {
                    Oxx0IOOO(new xooxxX(oixoxx0));
                }
                oixoxx0.I0xX0(this.f12492II0xO0, this.f12496oxoX[oixoxx0.f14423I0Io]);
                return;
            }
            throw new FitRuntimeException("Incompatible Protocol Features");
        }
        throw new FitRuntimeException("File not open.");
    }

    public void oIX0oI() {
        if (this.f12495oIX0oI != null) {
            try {
                xxIXOIIO();
                long value = this.f12492II0xO0.getChecksum().getValue();
                this.f12492II0xO0.write((int) (value & 255));
                this.f12492II0xO0.write((int) ((value >> 8) & 255));
                this.f12492II0xO0.close();
                this.f12495oIX0oI = null;
                return;
            } catch (IOException e) {
                throw new FitRuntimeException(e);
            }
        }
        throw new FitRuntimeException("File not open.");
    }

    @Override // com.garmin.fit.O0xO0
    public void oxoX(xooxxX xooxxx) {
        Oxx0IOOO(xooxxx);
    }

    @Deprecated
    public OIx00oxx(java.io.File file) {
        this(file, Fit.ProtocolVersion.V1_0);
    }

    public OIx00oxx(java.io.File file, Fit.ProtocolVersion protocolVersion) {
        this.f12496oxoX = new xooxxX[16];
        this.f12493X0o0xo = protocolVersion;
        this.f12494XO = IOOXOOOOo.oIX0oI(protocolVersion);
        X0o0xo(file);
    }
}
