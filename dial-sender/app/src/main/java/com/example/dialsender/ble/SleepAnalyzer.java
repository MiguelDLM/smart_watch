package com.example.dialsender.ble;

public class SleepAnalyzer {

    public static class SleepResult {
        public int totalMinutes;
        public int deepMin;
        public int lightMin;
        public int remMin;
        public int awakeMin;
    }

    /**
     * Analyzes a sleep record string (comma-separated "timestamp:mode:soft:strong").
     * Returns the last complete session (MODE_START to MODE_END).
     */
    public static SleepResult analyze(String data) {
        SleepResult result = new SleepResult();
        if (data == null || data.isEmpty()) return result;

        String[] records = data.split(",");
        // Find the last complete session (last MODE_END, then scan back for its MODE_START)
        int endIdx = -1;
        for (int i = records.length - 1; i >= 0; i--) {
            int mode = parseMode(records[i]);
            if (mode == BleSleep.MODE_END) { endIdx = i; break; }
        }
        if (endIdx < 0) return result;

        int startIdx = -1;
        for (int i = endIdx - 1; i >= 0; i--) {
            int mode = parseMode(records[i]);
            if (mode == BleSleep.MODE_START) { startIdx = i; break; }
        }
        if (startIdx < 0) return result;

        long sessionStart = parseTs(records[startIdx]);
        long sessionEnd = parseTs(records[endIdx]);
        result.totalMinutes = (int) ((sessionEnd - sessionStart) / 60);

        // Accumulate phase spans
        int currentMode = BleSleep.MODE_AWAKE;
        long currentTs = sessionStart;

        for (int i = startIdx + 1; i <= endIdx; i++) {
            long ts = parseTs(records[i]);
            int mode = parseMode(records[i]);
            long spanSecs = ts - currentTs;
            int spanMin = (int) (spanSecs / 60);

            switch (currentMode) {
                case BleSleep.MODE_DEEP:       result.deepMin  += spanMin; break;
                case BleSleep.MODE_LIGHT:      result.lightMin += spanMin; break;
                case BleSleep.MODE_REM:        result.remMin   += spanMin; break;
                case BleSleep.MODE_AWAKE:      result.awakeMin += spanMin; break;
                case BleSleep.MODE_PIECEMEAL:  result.lightMin += spanMin; break; // fragmented → light
            }
            currentMode = mode;
            currentTs = ts;
        }
        return result;
    }

    private static long parseTs(String record) {
        try { return Long.parseLong(record.split(":")[0]); }
        catch (Exception e) { return 0; }
    }

    private static int parseMode(String record) {
        try { return Integer.parseInt(record.split(":")[1]); }
        catch (Exception e) { return 0; }
    }
}
