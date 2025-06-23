package org.apache.log4j.lf5.viewer;

import org.apache.log4j.lf5.LogRecord;

/* loaded from: classes6.dex */
public class XxX0x0xxx implements org.apache.log4j.lf5.oxoX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ IoOoX f33400oIX0oI;

    public XxX0x0xxx(IoOoX ioOoX) {
        this.f33400oIX0oI = ioOoX;
    }

    @Override // org.apache.log4j.lf5.oxoX
    public boolean oIX0oI(LogRecord logRecord) {
        String ndc = logRecord.getNDC();
        Oxxo.IIXOooo iIXOooo = new Oxxo.IIXOooo(logRecord.getCategory());
        if (ndc == null || this.f33400oIX0oI.f33362Oxx0IOOO == null || ndc.toLowerCase().indexOf(this.f33400oIX0oI.f33362Oxx0IOOO.toLowerCase()) == -1 || !this.f33400oIX0oI.XX0(logRecord.getLevel()).isSelected() || !this.f33400oIX0oI.f33366X0o0xo.I0Io().II0XooXoX(iIXOooo)) {
            return false;
        }
        return true;
    }
}
