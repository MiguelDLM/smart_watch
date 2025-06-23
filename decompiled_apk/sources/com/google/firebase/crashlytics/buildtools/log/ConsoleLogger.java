package com.google.firebase.crashlytics.buildtools.log;

import com.google.firebase.crashlytics.buildtools.log.CrashlyticsLogger;
import java.io.PrintStream;

/* loaded from: classes10.dex */
public class ConsoleLogger implements CrashlyticsLogger {
    private CrashlyticsLogger.Level level;

    public ConsoleLogger() {
        this(CrashlyticsLogger.Level.INFO);
    }

    private void log(CrashlyticsLogger.Level level, String str, PrintStream printStream) {
        if (this.level.logsFor(level)) {
            printStream.println("[CRASHLYTICS LOG " + level.toString() + "] " + str);
        }
    }

    private void logThrowable(Throwable th) {
        if (th != null && this.level.logsFor(CrashlyticsLogger.Level.DEBUG)) {
            th.printStackTrace(System.out);
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.log.CrashlyticsLogger
    public synchronized void logD(String str) {
        log(CrashlyticsLogger.Level.DEBUG, str, System.out);
    }

    @Override // com.google.firebase.crashlytics.buildtools.log.CrashlyticsLogger
    public synchronized void logE(String str, Throwable th) {
        log(CrashlyticsLogger.Level.ERROR, str, System.err);
        logThrowable(th);
    }

    @Override // com.google.firebase.crashlytics.buildtools.log.CrashlyticsLogger
    public synchronized void logI(String str) {
        log(CrashlyticsLogger.Level.INFO, str, System.out);
    }

    @Override // com.google.firebase.crashlytics.buildtools.log.CrashlyticsLogger
    public synchronized void logV(String str) {
        log(CrashlyticsLogger.Level.VERBOSE, str, System.out);
    }

    @Override // com.google.firebase.crashlytics.buildtools.log.CrashlyticsLogger
    public synchronized void logW(String str, Throwable th) {
        log(CrashlyticsLogger.Level.WARNING, str, System.err);
        logThrowable(th);
    }

    @Override // com.google.firebase.crashlytics.buildtools.log.CrashlyticsLogger
    public void setLevel(CrashlyticsLogger.Level level) {
        this.level = level;
    }

    public ConsoleLogger(CrashlyticsLogger.Level level) {
        this.level = level;
    }
}
