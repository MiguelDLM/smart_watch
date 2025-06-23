package no.nordicsemi.android.dfu.internal.exception;

import XXO0.oIX0oI;

/* loaded from: classes6.dex */
public class DeviceDisconnectedException extends Exception {
    private static final long serialVersionUID = -6901728550661937942L;
    private final int mError;

    public DeviceDisconnectedException(String str, int i) {
        super(str);
        this.mError = i;
    }

    public int getErrorNumber() {
        return this.mError;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage() + " (error " + (this.mError & (-32769)) + oIX0oI.I0Io.f4095I0Io;
    }
}
