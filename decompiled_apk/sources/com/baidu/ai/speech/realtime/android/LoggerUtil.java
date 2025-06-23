package com.baidu.ai.speech.realtime.android;

import android.os.Message;
import android.util.Log;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* loaded from: classes7.dex */
public class LoggerUtil {

    /* loaded from: classes7.dex */
    public static class AndroidLoggingHandler extends Handler {
        private android.os.Handler handler;

        public AndroidLoggingHandler(android.os.Handler handler) {
            this.handler = handler;
        }

        private int getAndroidLevel(Level level) {
            int intValue = level.intValue();
            if (intValue >= Level.SEVERE.intValue()) {
                return 6;
            }
            if (intValue >= Level.WARNING.intValue()) {
                return 5;
            }
            return 4;
        }

        @Override // java.util.logging.Handler
        public void close() {
        }

        @Override // java.util.logging.Handler
        public void flush() {
        }

        @Override // java.util.logging.Handler
        public void publish(LogRecord record) {
            if (!super.isLoggable(record)) {
                return;
            }
            String loggerName = record.getLoggerName();
            try {
                Level level = record.getLevel();
                if (level.intValue() < Level.INFO.intValue()) {
                    Log.println(getAndroidLevel(level), loggerName + "|" + level.getName(), record.getMessage());
                }
                Message obtainMessage = this.handler.obtainMessage(0, Integer.valueOf(level.intValue()));
                obtainMessage.obj = "[" + loggerName + "] " + record.getMessage() + "\n";
                this.handler.sendMessage(obtainMessage);
            } catch (RuntimeException e) {
                Log.e("AndroidLoggingHandler", "Error logging message.", e);
            }
        }
    }

    public static void addAndroidHandler(android.os.Handler handler) {
        addAndroidHandler(handler, Level.FINE);
    }

    public static void addAndroidHandler(android.os.Handler handler, Level level) {
        Logger logger = Logger.getLogger("");
        logger.setLevel(level);
        logger.addHandler(new AndroidLoggingHandler(handler));
    }
}
