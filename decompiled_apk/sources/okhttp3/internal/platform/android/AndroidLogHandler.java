package okhttp3.internal.platform.android;

import OXOo.OOXIXo;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class AndroidLogHandler extends Handler {

    @OOXIXo
    public static final AndroidLogHandler INSTANCE = new AndroidLogHandler();

    private AndroidLogHandler() {
    }

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }

    @Override // java.util.logging.Handler
    public void publish(@OOXIXo LogRecord record) {
        int androidLevel;
        IIX0o.x0xO0oo(record, "record");
        AndroidLog androidLog = AndroidLog.INSTANCE;
        String loggerName = record.getLoggerName();
        IIX0o.oO(loggerName, "record.loggerName");
        androidLevel = AndroidLogKt.getAndroidLevel(record);
        String message = record.getMessage();
        IIX0o.oO(message, "record.message");
        androidLog.androidLog$okhttp(loggerName, androidLevel, message, record.getThrown());
    }
}
