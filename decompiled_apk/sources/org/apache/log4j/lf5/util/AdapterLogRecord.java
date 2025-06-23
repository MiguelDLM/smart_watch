package org.apache.log4j.lf5.util;

import XXO0.oIX0oI;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.log4j.lf5.LogLevel;
import org.apache.log4j.lf5.LogRecord;

/* loaded from: classes6.dex */
public class AdapterLogRecord extends LogRecord {
    private static LogLevel severeLevel;
    private static StringWriter sw = new StringWriter();
    private static PrintWriter pw = new PrintWriter(sw);

    public static LogLevel getSevereLevel() {
        return severeLevel;
    }

    public static void setSevereLevel(LogLevel logLevel) {
        severeLevel = logLevel;
    }

    public String getLocationInfo(String str) {
        return parseLine(stackTraceToString(new Throwable()), str);
    }

    @Override // org.apache.log4j.lf5.LogRecord
    public boolean isSevereLevel() {
        LogLevel logLevel = severeLevel;
        if (logLevel == null) {
            return false;
        }
        return logLevel.equals(getLevel());
    }

    public String parseLine(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return null;
        }
        String substring = str.substring(indexOf);
        return substring.substring(0, substring.indexOf(oIX0oI.I0Io.f4095I0Io) + 1);
    }

    @Override // org.apache.log4j.lf5.LogRecord
    public void setCategory(String str) {
        super.setCategory(str);
        super.setLocation(getLocationInfo(str));
    }

    public String stackTraceToString(Throwable th) {
        String stringWriter;
        synchronized (sw) {
            th.printStackTrace(pw);
            stringWriter = sw.toString();
            sw.getBuffer().setLength(0);
        }
        return stringWriter;
    }
}
