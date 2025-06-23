package com.google.firebase.crashlytics.buildtools.log;

import com.google.firebase.crashlytics.buildtools.log.CrashlyticsLogger;

/* loaded from: classes10.dex */
public class MultiLogger implements CrashlyticsLogger {
    private final CrashlyticsLogger[] _loggers;

    public MultiLogger(CrashlyticsLogger... crashlyticsLoggerArr) {
        this._loggers = crashlyticsLoggerArr;
    }

    @Override // com.google.firebase.crashlytics.buildtools.log.CrashlyticsLogger
    public synchronized void logD(String str) {
        for (CrashlyticsLogger crashlyticsLogger : this._loggers) {
            crashlyticsLogger.logD(str);
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.log.CrashlyticsLogger
    public synchronized void logE(String str, Throwable th) {
        for (CrashlyticsLogger crashlyticsLogger : this._loggers) {
            crashlyticsLogger.logE(str, th);
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.log.CrashlyticsLogger
    public synchronized void logI(String str) {
        for (CrashlyticsLogger crashlyticsLogger : this._loggers) {
            crashlyticsLogger.logI(str);
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.log.CrashlyticsLogger
    public synchronized void logV(String str) {
        for (CrashlyticsLogger crashlyticsLogger : this._loggers) {
            crashlyticsLogger.logV(str);
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.log.CrashlyticsLogger
    public synchronized void logW(String str, Throwable th) {
        for (CrashlyticsLogger crashlyticsLogger : this._loggers) {
            crashlyticsLogger.logW(str, th);
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.log.CrashlyticsLogger
    public void setLevel(CrashlyticsLogger.Level level) {
        for (CrashlyticsLogger crashlyticsLogger : this._loggers) {
            crashlyticsLogger.setLevel(level);
        }
    }
}
