package org.apache.log4j.lf5.viewer;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class LogTableColumn implements Serializable {
    public static final LogTableColumn CATEGORY;
    public static final LogTableColumn DATE;
    public static final LogTableColumn LEVEL;
    public static final LogTableColumn LOCATION;
    public static final LogTableColumn MESSAGE;
    public static final LogTableColumn MESSAGE_NUM;
    public static final LogTableColumn NDC;
    public static final LogTableColumn THREAD;
    public static final LogTableColumn THROWN;
    private static LogTableColumn[] _log4JColumns;
    private static Map _logTableColumnMap;
    protected String _label;

    static {
        LogTableColumn logTableColumn = new LogTableColumn("Date");
        DATE = logTableColumn;
        LogTableColumn logTableColumn2 = new LogTableColumn("Thread");
        THREAD = logTableColumn2;
        LogTableColumn logTableColumn3 = new LogTableColumn("Message #");
        MESSAGE_NUM = logTableColumn3;
        LogTableColumn logTableColumn4 = new LogTableColumn("Level");
        LEVEL = logTableColumn4;
        LogTableColumn logTableColumn5 = new LogTableColumn("NDC");
        NDC = logTableColumn5;
        LogTableColumn logTableColumn6 = new LogTableColumn("Category");
        CATEGORY = logTableColumn6;
        LogTableColumn logTableColumn7 = new LogTableColumn("Message");
        MESSAGE = logTableColumn7;
        LogTableColumn logTableColumn8 = new LogTableColumn("Location");
        LOCATION = logTableColumn8;
        LogTableColumn logTableColumn9 = new LogTableColumn("Thrown");
        THROWN = logTableColumn9;
        int i = 0;
        _log4JColumns = new LogTableColumn[]{logTableColumn, logTableColumn2, logTableColumn3, logTableColumn4, logTableColumn5, logTableColumn6, logTableColumn7, logTableColumn8, logTableColumn9};
        _logTableColumnMap = new HashMap();
        while (true) {
            LogTableColumn[] logTableColumnArr = _log4JColumns;
            if (i >= logTableColumnArr.length) {
                return;
            }
            _logTableColumnMap.put(logTableColumnArr[i].getLabel(), _log4JColumns[i]);
            i++;
        }
    }

    public LogTableColumn(String str) {
        this._label = str;
    }

    public static LogTableColumn[] getLogTableColumnArray() {
        return _log4JColumns;
    }

    public static List getLogTableColumns() {
        return Arrays.asList(_log4JColumns);
    }

    public static LogTableColumn valueOf(String str) throws LogTableColumnFormatException {
        LogTableColumn logTableColumn;
        if (str != null) {
            str = str.trim();
            logTableColumn = (LogTableColumn) _logTableColumnMap.get(str);
        } else {
            logTableColumn = null;
        }
        if (logTableColumn != null) {
            return logTableColumn;
        }
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Error while trying to parse (");
        stringBuffer2.append(str);
        stringBuffer2.append(") into");
        stringBuffer.append(stringBuffer2.toString());
        stringBuffer.append(" a LogTableColumn.");
        throw new LogTableColumnFormatException(stringBuffer.toString());
    }

    public boolean equals(Object obj) {
        if ((obj instanceof LogTableColumn) && getLabel() == ((LogTableColumn) obj).getLabel()) {
            return true;
        }
        return false;
    }

    public String getLabel() {
        return this._label;
    }

    public int hashCode() {
        return this._label.hashCode();
    }

    public String toString() {
        return this._label;
    }
}
