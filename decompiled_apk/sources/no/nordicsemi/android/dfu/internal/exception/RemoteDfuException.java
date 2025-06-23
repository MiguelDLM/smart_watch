package no.nordicsemi.android.dfu.internal.exception;

import XXO0.oIX0oI;

/* loaded from: classes6.dex */
public class RemoteDfuException extends Exception {
    private static final long serialVersionUID = -6901728550661937942L;
    private final int mState;

    public RemoteDfuException(String str, int i) {
        super(str);
        this.mState = i;
    }

    public int getErrorNumber() {
        return this.mState;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage() + " (error " + this.mState + oIX0oI.I0Io.f4095I0Io;
    }
}
