package com.microsoft.cognitiveservices.speech.diagnostics.logging;

import com.microsoft.cognitiveservices.speech.Diagnostics;
import com.microsoft.cognitiveservices.speech.diagnostics.logging.Logger;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes11.dex */
public final class MemoryLogger {
    private MemoryLogger() {
    }

    public static List<String> dump() {
        ArrayList arrayList = new ArrayList();
        long memoryLogLineNumNewest = Logger.getMemoryLogLineNumNewest();
        for (long memoryLogLineNumOldest = Logger.getMemoryLogLineNumOldest(); memoryLogLineNumOldest < memoryLogLineNumNewest; memoryLogLineNumOldest++) {
            arrayList.add(Logger.getMemoryLogLine(memoryLogLineNumOldest));
        }
        return arrayList;
    }

    public static void setFilters() {
        Logger.setMemoryLoggingFilters(new String[0]);
    }

    public static void setLevel(Level level) {
        Contracts.throwIfNull(level, "level");
        Logger.setLevel(Logger.Type.Memory, level);
    }

    public static void start() {
        Diagnostics.startMemoryLogging();
    }

    public static void stop() {
        Diagnostics.stopMemoryLogging();
    }

    public static void dump(OutputStream outputStream) throws IOException {
        Contracts.throwIfNull(outputStream, "outStream");
        long memoryLogLineNumNewest = Logger.getMemoryLogLineNumNewest();
        for (long memoryLogLineNumOldest = Logger.getMemoryLogLineNumOldest(); memoryLogLineNumOldest < memoryLogLineNumNewest; memoryLogLineNumOldest++) {
            outputStream.write(Logger.getMemoryLogLine(memoryLogLineNumOldest).getBytes());
        }
    }

    public static void setFilters(String[] strArr) {
        Contracts.throwIfNull(strArr, "filters");
        Logger.setMemoryLoggingFilters(strArr);
    }

    public static void dump(String str) {
        Contracts.throwIfNullOrWhitespace(str, "filePath");
        Diagnostics.dumpMemoryLog(str, "", false, false);
    }
}
