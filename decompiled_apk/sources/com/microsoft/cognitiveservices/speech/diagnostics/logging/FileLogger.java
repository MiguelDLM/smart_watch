package com.microsoft.cognitiveservices.speech.diagnostics.logging;

import com.microsoft.cognitiveservices.speech.Diagnostics;
import com.microsoft.cognitiveservices.speech.diagnostics.logging.Logger;
import com.microsoft.cognitiveservices.speech.util.Contracts;

/* loaded from: classes11.dex */
public final class FileLogger {
    private FileLogger() {
    }

    public static void setFilters() {
        Logger.fileLoggerSetFilters(new String[0]);
    }

    public static void setLevel(Level level) {
        Contracts.throwIfNull(level, "level");
        Logger.setLevel(Logger.Type.File, level);
    }

    public static void start(String str) {
        Contracts.throwIfNullOrWhitespace(str, "filePath");
        start(str, false);
    }

    public static void stop() {
        Diagnostics.stopFileLogging();
    }

    public static void setFilters(String[] strArr) {
        Contracts.throwIfNull(strArr, "filters");
        Logger.fileLoggerSetFilters(strArr);
    }

    public static void start(String str, boolean z) {
        Contracts.throwIfNullOrWhitespace(str, "filePath");
        Diagnostics.startFileLogging(str, z);
    }
}
