package org.apache.log4j.lf5.viewer;

import org.apache.log4j.lf5.LogRecord;

/* loaded from: classes6.dex */
public class xxX implements org.apache.log4j.lf5.oxoX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ IoOoX f33444oIX0oI;

    public xxX(IoOoX ioOoX) {
        this.f33444oIX0oI = ioOoX;
    }

    @Override // org.apache.log4j.lf5.oxoX
    public boolean oIX0oI(LogRecord logRecord) {
        Oxxo.IIXOooo iIXOooo = new Oxxo.IIXOooo(logRecord.getCategory());
        if (this.f33444oIX0oI.XX0(logRecord.getLevel()).isSelected() && this.f33444oIX0oI.f33366X0o0xo.I0Io().II0XooXoX(iIXOooo)) {
            return true;
        }
        return false;
    }
}
