package no.nordicsemi.android.dfu.internal.exception;

import XXO0.oIX0oI;

/* loaded from: classes6.dex */
public class RemoteDfuExtendedErrorException extends RemoteDfuException {
    private static final long serialVersionUID = -6901728550661937942L;
    private final int mError;

    public RemoteDfuExtendedErrorException(String str, int i) {
        super(str, 11);
        this.mError = i;
    }

    public int getExtendedErrorNumber() {
        return this.mError;
    }

    @Override // no.nordicsemi.android.dfu.internal.exception.RemoteDfuException, java.lang.Throwable
    public String getMessage() {
        return super.getMessage() + " (extended error " + this.mError + oIX0oI.I0Io.f4095I0Io;
    }
}
