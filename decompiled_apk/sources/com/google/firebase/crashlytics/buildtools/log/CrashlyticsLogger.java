package com.google.firebase.crashlytics.buildtools.log;

/* loaded from: classes10.dex */
public interface CrashlyticsLogger {

    /* loaded from: classes10.dex */
    public enum Level {
        ERROR(0),
        WARNING(1),
        INFO(2),
        DEBUG(3),
        VERBOSE(4);

        private final int value;

        Level(int i) {
            this.value = i;
        }

        public boolean logsFor(Level level) {
            if (this.value >= level.value) {
                return true;
            }
            return false;
        }
    }

    void logD(String str);

    void logE(String str, Throwable th);

    void logI(String str);

    void logV(String str);

    void logW(String str, Throwable th);

    void setLevel(Level level);
}
