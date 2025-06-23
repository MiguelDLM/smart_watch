package com.goodix.ble.libcomx.logger;

import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.annotation.Nullable;
import com.goodix.ble.libcomx.event.Event;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import oOo.OxxIIOOXO;

/* loaded from: classes9.dex */
public class RingLogger implements Runnable, ILogger {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int EVT_UPDATE = 248;
    public static final int INFO = 4;
    private static final int LVL_INNER_ERR = 100100;
    private static final String TAG = "RingLogger";
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private LogEntry[] entries;
    private int entryCnt;
    private boolean hasPendingClear;
    private boolean hasPendingLog;
    private Executor ioThread;
    private OutputStream logOutputStream;
    private byte[] newLine;
    private int writePos;

    @Nullable
    private ILogger logger = null;

    @Nullable
    private ArrayList<LogEntry> entriesCopy = null;
    private int updateDelay = 200;
    private String defaultTag = TAG;

    @Nullable
    private Event<Void> eventUpdate = null;
    private boolean autoStoreToFile = false;
    private ConcurrentLinkedQueue<LogEntry> storageQueue = null;

    public RingLogger(int i) {
        this.entries = new LogEntry[i < 1 ? 0 : i];
        innerClear();
    }

    private synchronized void innerClear() {
        this.entryCnt = 0;
        this.writePos = 0;
    }

    private synchronized void requestNotify() {
        try {
            if (!this.hasPendingLog) {
                this.hasPendingLog = true;
                if (this.ioThread == null) {
                    this.ioThread = new ThreadPoolExecutor(0, 1, 5000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
                }
                this.ioThread.execute(this);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void clear() {
        synchronized (this) {
            this.hasPendingClear = true;
        }
        requestNotify();
    }

    public void clearSync() {
        innerClear();
        Event<Void> event = this.eventUpdate;
        if (event != null) {
            event.postEvent(null);
        }
    }

    @Override // com.goodix.ble.libcomx.ILogger
    public void d(String str, String str2) {
        log(System.currentTimeMillis(), Thread.currentThread().getId(), 3, str, str2);
        ILogger iLogger = this.logger;
        if (iLogger != null) {
            iLogger.d(str, str2);
        }
    }

    @Override // com.goodix.ble.libcomx.ILogger
    public void e(String str, String str2) {
        log(System.currentTimeMillis(), Thread.currentThread().getId(), 6, str, str2);
        ILogger iLogger = this.logger;
        if (iLogger != null) {
            iLogger.e(str, str2);
        }
    }

    public Event<Void> evtUpdate() {
        if (this.eventUpdate == null) {
            synchronized (this) {
                try {
                    if (this.eventUpdate == null) {
                        this.eventUpdate = new Event<>(this, 248);
                    }
                } finally {
                }
            }
        }
        return this.eventUpdate;
    }

    @Deprecated
    public LogEntry get(int i) {
        int i2 = this.entryCnt;
        LogEntry[] logEntryArr = this.entries;
        if (i2 < logEntryArr.length) {
            return logEntryArr[i];
        }
        return logEntryArr[(this.writePos + i) % logEntryArr.length];
    }

    public int getCapability() {
        return this.entries.length;
    }

    public List<LogEntry> getLogs(List<LogEntry> list) {
        int size;
        int i;
        LogEntry logEntry;
        synchronized (this) {
            if (list == null) {
                try {
                    if (this.entriesCopy == null) {
                        this.entriesCopy = new ArrayList<>(this.entries.length);
                    }
                    list = this.entriesCopy;
                } catch (Throwable th) {
                    throw th;
                }
            }
            size = list.size();
            i = this.entryCnt;
            int i2 = 0;
            while (true) {
                int i3 = this.entryCnt;
                if (i2 >= i3) {
                    break;
                }
                LogEntry[] logEntryArr = this.entries;
                if (i3 < logEntryArr.length) {
                    logEntry = logEntryArr[i2];
                } else {
                    logEntry = logEntryArr[(this.writePos + i2) % logEntryArr.length];
                }
                if (i2 < size) {
                    list.get(i2).copy(logEntry);
                } else {
                    list.add(new LogEntry(logEntry));
                }
                i2++;
            }
        }
        while (i < size) {
            size--;
            list.remove(size);
        }
        return list;
    }

    @Override // com.goodix.ble.libcomx.ILogger
    public void i(String str, String str2) {
        log(System.currentTimeMillis(), Thread.currentThread().getId(), 4, str, str2);
        ILogger iLogger = this.logger;
        if (iLogger != null) {
            iLogger.i(str, str2);
        }
    }

    public RingLogger log(String str) {
        return log(System.currentTimeMillis(), Thread.currentThread().getId(), 3, this.defaultTag, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        OutputStream outputStream;
        int i = this.updateDelay;
        if (i > 0) {
            try {
                Thread.sleep(i);
            } catch (InterruptedException unused) {
            }
        }
        boolean z = this.hasPendingClear;
        synchronized (this) {
            this.hasPendingLog = false;
            this.hasPendingClear = false;
        }
        if (z) {
            innerClear();
        }
        if (this.autoStoreToFile) {
            outputStream = this.logOutputStream;
        } else {
            outputStream = null;
        }
        if (outputStream != null) {
            try {
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormatUtils.YYYY_MM_DD_HH_MM_SS_SSS, Locale.US);
                StringBuilder sb = new StringBuilder(1024);
                while (!this.storageQueue.isEmpty()) {
                    LogEntry poll = this.storageQueue.poll();
                    if (poll != null && poll.level != LVL_INNER_ERR) {
                        sb.delete(0, sb.length());
                        date.setTime(poll.timestamp);
                        sb.append(simpleDateFormat.format(date));
                        sb.append(" ");
                        sb.append(poll.tid);
                        sb.append(" ");
                        sb.append(poll.level);
                        sb.append(" ");
                        sb.append(poll.tag);
                        sb.append(": ");
                        sb.append(poll.msg);
                        outputStream.write(sb.toString().getBytes());
                        outputStream.write(this.newLine);
                    }
                }
                outputStream.flush();
            } catch (Exception e) {
                e.printStackTrace();
                this.autoStoreToFile = false;
                log(LVL_INNER_ERR, TAG, e.getMessage());
            }
        }
        Event<Void> event = this.eventUpdate;
        if (event != null) {
            event.postEvent(null);
        }
    }

    public void saveTo(File file) throws IOException {
        if (file == null) {
            return;
        }
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            file.createNewFile();
        }
        if (file.exists()) {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                saveTo(fileOutputStream);
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
    }

    public RingLogger setAutoStoreToFile(OutputStream outputStream) {
        if (outputStream != null) {
            this.logOutputStream = outputStream;
            this.storageQueue = new ConcurrentLinkedQueue<>();
            this.autoStoreToFile = true;
            this.newLine = "\r\n".getBytes();
        } else {
            this.autoStoreToFile = false;
        }
        return this;
    }

    public RingLogger setLogger(ILogger iLogger) {
        this.logger = iLogger;
        return this;
    }

    public RingLogger setUpdateDelay(int i) {
        if (i < 1) {
            i = 1;
        }
        this.updateDelay = i;
        return this;
    }

    public int size() {
        return this.entryCnt;
    }

    @Override // com.goodix.ble.libcomx.ILogger
    public /* synthetic */ ILogger subLogger() {
        return OxxIIOOXO.oIX0oI(this);
    }

    @Override // com.goodix.ble.libcomx.ILogger
    public void v(String str, String str2) {
        log(System.currentTimeMillis(), Thread.currentThread().getId(), 2, str, str2);
        ILogger iLogger = this.logger;
        if (iLogger != null) {
            iLogger.v(str, str2);
        }
    }

    @Override // com.goodix.ble.libcomx.ILogger
    public void w(String str, String str2) {
        log(System.currentTimeMillis(), Thread.currentThread().getId(), 5, str, str2);
        ILogger iLogger = this.logger;
        if (iLogger != null) {
            iLogger.w(str, str2);
        }
    }

    public RingLogger log(int i, String str, String str2) {
        return log(System.currentTimeMillis(), Thread.currentThread().getId(), i, str, str2);
    }

    public RingLogger log(long j, long j2, int i, String str, String str2) {
        LogEntry logEntry;
        int length = this.entries.length;
        synchronized (this) {
            try {
                LogEntry[] logEntryArr = this.entries;
                int i2 = this.writePos;
                logEntry = logEntryArr[i2];
                if (logEntry != null) {
                    logEntry.timestamp = j;
                    logEntry.tid = j2;
                    logEntry.level = i;
                    logEntry.tag = str;
                    logEntry.msg = str2;
                } else {
                    logEntry = new LogEntry(j, j2, i, str, str2);
                    logEntryArr[i2] = logEntry;
                }
                int i3 = this.writePos + 1;
                this.writePos = i3;
                if (i3 >= length) {
                    this.writePos = i3 - length;
                }
                int i4 = this.entryCnt;
                if (i4 < length) {
                    this.entryCnt = i4 + 1;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.autoStoreToFile) {
            this.storageQueue.add(new LogEntry(logEntry));
        }
        requestNotify();
        return this;
    }

    @Override // com.goodix.ble.libcomx.ILogger
    public void e(String str, String str2, Throwable th) {
        log(System.currentTimeMillis(), Thread.currentThread().getId(), 6, str, str2);
        ILogger iLogger = this.logger;
        if (iLogger != null) {
            iLogger.e(str, str2, th);
        }
    }

    /* loaded from: classes9.dex */
    public static class LogEntry {
        public int level;
        public String msg;
        public String tag;
        public long tid;
        public long timestamp;

        public LogEntry(long j, long j2, int i, String str, String str2) {
            this.timestamp = j;
            this.tid = j2;
            this.level = i;
            this.tag = str;
            this.msg = str2;
        }

        public void copy(LogEntry logEntry) {
            this.timestamp = logEntry.timestamp;
            this.tid = logEntry.tid;
            this.level = logEntry.level;
            this.tag = logEntry.tag;
            this.msg = logEntry.msg;
        }

        public LogEntry(LogEntry logEntry) {
            copy(logEntry);
        }
    }

    public void saveTo(OutputStream outputStream) throws IOException {
        List<LogEntry> logs = getLogs(new ArrayList(getCapability()));
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormatUtils.YYYY_MM_DD_HH_MM_SS_SSS, Locale.US);
        StringBuilder sb = new StringBuilder(1024);
        if (this.newLine == null) {
            this.newLine = "\r\n".getBytes();
        }
        for (LogEntry logEntry : logs) {
            if (logEntry != null) {
                sb.delete(0, sb.length());
                date.setTime(logEntry.timestamp);
                sb.append(simpleDateFormat.format(date));
                sb.append(" ");
                sb.append(logEntry.tid);
                sb.append(" ");
                sb.append(logEntry.level);
                sb.append(" ");
                sb.append(logEntry.tag);
                sb.append(": ");
                sb.append(logEntry.msg);
                outputStream.write(sb.toString().getBytes());
                outputStream.write(this.newLine);
            }
        }
        outputStream.flush();
    }
}
