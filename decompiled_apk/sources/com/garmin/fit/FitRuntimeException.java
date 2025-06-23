package com.garmin.fit;

import java.io.IOException;

/* loaded from: classes9.dex */
public class FitRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 970213851171816735L;

    public FitRuntimeException() {
    }

    public FitRuntimeException(IOException iOException) {
        super(iOException);
    }

    public FitRuntimeException(String str) {
        super(str);
    }
}
