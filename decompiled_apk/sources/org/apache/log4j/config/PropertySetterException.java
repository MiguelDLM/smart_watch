package org.apache.log4j.config;

/* loaded from: classes6.dex */
public class PropertySetterException extends Exception {
    protected Throwable rootCause;

    public PropertySetterException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        Throwable th;
        String message = super.getMessage();
        if (message == null && (th = this.rootCause) != null) {
            return th.getMessage();
        }
        return message;
    }

    public PropertySetterException(Throwable th) {
        this.rootCause = th;
    }
}
