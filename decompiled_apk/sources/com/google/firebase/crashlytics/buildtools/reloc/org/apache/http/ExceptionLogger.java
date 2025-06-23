package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http;

/* loaded from: classes10.dex */
public interface ExceptionLogger {
    public static final ExceptionLogger NO_OP = new ExceptionLogger() { // from class: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ExceptionLogger.1
        @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ExceptionLogger
        public void log(Exception exc) {
        }
    };
    public static final ExceptionLogger STD_ERR = new ExceptionLogger() { // from class: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ExceptionLogger.2
        @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ExceptionLogger
        public void log(Exception exc) {
            exc.printStackTrace();
        }
    };

    void log(Exception exc);
}
