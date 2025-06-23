package org.apache.log4j.lf5;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;

/* loaded from: classes6.dex */
public abstract class LogRecord implements Serializable {
    protected static long _seqCount;
    protected Throwable _thrown;
    protected String _thrownStackTrace;
    protected long _millis = System.currentTimeMillis();
    protected String _category = "Debug";
    protected String _message = "";
    protected LogLevel _level = LogLevel.INFO;
    protected long _sequenceNumber = getNextId();
    protected String _thread = Thread.currentThread().toString();
    protected String _ndc = "";
    protected String _location = "";

    public static synchronized long getNextId() {
        long j;
        synchronized (LogRecord.class) {
            j = _seqCount + 1;
            _seqCount = j;
        }
        return j;
    }

    public static synchronized void resetSequenceNumber() {
        synchronized (LogRecord.class) {
            _seqCount = 0L;
        }
    }

    public String getCategory() {
        return this._category;
    }

    public LogLevel getLevel() {
        return this._level;
    }

    public String getLocation() {
        return this._location;
    }

    public String getMessage() {
        return this._message;
    }

    public long getMillis() {
        return this._millis;
    }

    public String getNDC() {
        return this._ndc;
    }

    public long getSequenceNumber() {
        return this._sequenceNumber;
    }

    public String getThreadDescription() {
        return this._thread;
    }

    public Throwable getThrown() {
        return this._thrown;
    }

    public String getThrownStackTrace() {
        return this._thrownStackTrace;
    }

    public boolean hasThrown() {
        String th;
        Throwable thrown = getThrown();
        if (thrown == null || (th = thrown.toString()) == null || th.trim().length() == 0) {
            return false;
        }
        return true;
    }

    public boolean isFatal() {
        if (!isSevereLevel() && !hasThrown()) {
            return false;
        }
        return true;
    }

    public abstract boolean isSevereLevel();

    public void setCategory(String str) {
        this._category = str;
    }

    public void setLevel(LogLevel logLevel) {
        this._level = logLevel;
    }

    public void setLocation(String str) {
        this._location = str;
    }

    public void setMessage(String str) {
        this._message = str;
    }

    public void setMillis(long j) {
        this._millis = j;
    }

    public void setNDC(String str) {
        this._ndc = str;
    }

    public void setSequenceNumber(long j) {
        this._sequenceNumber = j;
    }

    public void setThreadDescription(String str) {
        this._thread = str;
    }

    public void setThrown(Throwable th) {
        if (th == null) {
            return;
        }
        this._thrown = th;
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        this._thrownStackTrace = stringWriter.toString();
        try {
            printWriter.close();
            stringWriter.close();
        } catch (IOException unused) {
        }
    }

    public void setThrownStackTrace(String str) {
        this._thrownStackTrace = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("LogRecord: [");
        stringBuffer2.append(this._level);
        stringBuffer2.append(", ");
        stringBuffer2.append(this._message);
        stringBuffer2.append("]");
        stringBuffer.append(stringBuffer2.toString());
        return stringBuffer.toString();
    }
}
