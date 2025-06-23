package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.Contracts;

/* loaded from: classes11.dex */
public final class Diagnostics {
    static {
        try {
            Class.forName(SpeechConfig.class.getName());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void dumpMemoryLog(String str, String str2, boolean z, boolean z2) {
        Contracts.throwIfNullOrWhitespace(str, "filename");
        Contracts.throwIfNull(str2, "linePrefix");
        Contracts.throwIfFail(logMemoryDump(str, str2, z, z2));
    }

    public static void dumpMemoryLogOnExit(String str, String str2, boolean z, boolean z2) {
        Contracts.throwIfFail(logMemoryDumpOnExit(str, str2, z, z2));
    }

    private static final native long logConsoleStartLogging(boolean z);

    private static final native long logConsoleStopLogging();

    private static final native long logFileStartLogging(String str, boolean z);

    private static final native long logFileStopLogging();

    private static final native long logMemoryDump(String str, String str2, boolean z, boolean z2);

    private static final native long logMemoryDumpOnExit(String str, String str2, boolean z, boolean z2);

    private static final native long logMemoryStartLogging();

    private static final native long logMemoryStopLogging();

    public static void startConsoleLogging() {
        startConsoleLogging(true);
    }

    public static void startFileLogging(String str, boolean z) {
        Contracts.throwIfNullOrWhitespace(str, "filename");
        Contracts.throwIfFail(logFileStartLogging(str, z));
    }

    public static void startMemoryLogging() {
        Contracts.throwIfFail(logMemoryStartLogging());
    }

    public static void stopConsoleLogging() {
        Contracts.throwIfFail(logConsoleStopLogging());
    }

    public static void stopFileLogging() {
        Contracts.throwIfFail(logFileStopLogging());
    }

    public static void stopMemoryLogging() {
        Contracts.throwIfFail(logMemoryStopLogging());
    }

    public static void startConsoleLogging(boolean z) {
        Contracts.throwIfFail(logConsoleStartLogging(z));
    }
}
