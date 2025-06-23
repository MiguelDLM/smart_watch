package org.apache.log4j.spi;

import java.io.Serializable;

/* loaded from: classes6.dex */
public class ThrowableInformation implements Serializable {
    static final long serialVersionUID = -4748765566864322735L;
    private String[] rep;
    private transient Throwable throwable;

    public ThrowableInformation(Throwable th) {
        this.throwable = th;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public String[] getThrowableStrRep() {
        String[] strArr = this.rep;
        if (strArr != null) {
            return (String[]) strArr.clone();
        }
        IXxxXO iXxxXO = new IXxxXO();
        this.throwable.printStackTrace(iXxxXO);
        String[] oIX0oI2 = iXxxXO.oIX0oI();
        this.rep = oIX0oI2;
        return oIX0oI2;
    }
}
