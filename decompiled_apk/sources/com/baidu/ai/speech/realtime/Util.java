package com.baidu.ai.speech.realtime;

/* loaded from: classes7.dex */
public class Util {
    public static final int BYTES_PER_FRAME = 5120;
    public static final int BYTES_PER_MS = 32;
    public static final int FRAME_MS = 160;

    public static int bytesToTime(int size) {
        return size / 32;
    }

    public static void sleep(long millis) {
        if (millis <= 0) {
            return;
        }
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static long timeToBytes(long durationMs) {
        return durationMs * 32;
    }
}
