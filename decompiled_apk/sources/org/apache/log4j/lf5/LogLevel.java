package org.apache.log4j.lf5;

import com.baidu.mobads.sdk.internal.cb;
import java.awt.Color;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class LogLevel implements Serializable {
    public static final LogLevel CONFIG;
    public static final LogLevel DEBUG;
    public static final LogLevel ERROR;
    public static final LogLevel FATAL;
    public static final LogLevel FINE;
    public static final LogLevel FINER;
    public static final LogLevel FINEST;
    public static final LogLevel INFO;
    public static final LogLevel SEVERE;
    public static final LogLevel WARN;
    public static final LogLevel WARNING;
    private static LogLevel[] _allDefaultLevels;
    private static LogLevel[] _jdk14Levels;
    private static LogLevel[] _log4JLevels;
    private static Map _logLevelColorMap;
    private static Map _logLevelMap;
    private static Map _registeredLogLevelMap;
    protected String _label;
    protected int _precedence;

    static {
        int i = 0;
        LogLevel logLevel = new LogLevel("FATAL", 0);
        FATAL = logLevel;
        LogLevel logLevel2 = new LogLevel(cb.l, 1);
        ERROR = logLevel2;
        LogLevel logLevel3 = new LogLevel("WARN", 2);
        WARN = logLevel3;
        LogLevel logLevel4 = new LogLevel("INFO", 3);
        INFO = logLevel4;
        LogLevel logLevel5 = new LogLevel("DEBUG", 4);
        DEBUG = logLevel5;
        LogLevel logLevel6 = new LogLevel("SEVERE", 1);
        SEVERE = logLevel6;
        LogLevel logLevel7 = new LogLevel("WARNING", 2);
        WARNING = logLevel7;
        LogLevel logLevel8 = new LogLevel("CONFIG", 4);
        CONFIG = logLevel8;
        LogLevel logLevel9 = new LogLevel("FINE", 5);
        FINE = logLevel9;
        LogLevel logLevel10 = new LogLevel("FINER", 6);
        FINER = logLevel10;
        LogLevel logLevel11 = new LogLevel("FINEST", 7);
        FINEST = logLevel11;
        _registeredLogLevelMap = new HashMap();
        _log4JLevels = new LogLevel[]{logLevel, logLevel2, logLevel3, logLevel4, logLevel5};
        _jdk14Levels = new LogLevel[]{logLevel6, logLevel7, logLevel4, logLevel8, logLevel9, logLevel10, logLevel11};
        _allDefaultLevels = new LogLevel[]{logLevel, logLevel2, logLevel3, logLevel4, logLevel5, logLevel6, logLevel7, logLevel8, logLevel9, logLevel10, logLevel11};
        _logLevelMap = new HashMap();
        int i2 = 0;
        while (true) {
            LogLevel[] logLevelArr = _allDefaultLevels;
            if (i2 >= logLevelArr.length) {
                break;
            }
            _logLevelMap.put(logLevelArr[i2].getLabel(), _allDefaultLevels[i2]);
            i2++;
        }
        _logLevelColorMap = new HashMap();
        while (true) {
            LogLevel[] logLevelArr2 = _allDefaultLevels;
            if (i >= logLevelArr2.length) {
                return;
            }
            _logLevelColorMap.put(logLevelArr2[i], Color.black);
            i++;
        }
    }

    public LogLevel(String str, int i) {
        this._label = str;
        this._precedence = i;
    }

    public static List getAllDefaultLevels() {
        return Arrays.asList(_allDefaultLevels);
    }

    public static List getJdk14Levels() {
        return Arrays.asList(_jdk14Levels);
    }

    public static List getLog4JLevels() {
        return Arrays.asList(_log4JLevels);
    }

    public static Map getLogLevelColorMap() {
        return _logLevelColorMap;
    }

    public static LogLevel register(LogLevel logLevel) {
        if (logLevel != null && _logLevelMap.get(logLevel.getLabel()) == null) {
            return (LogLevel) _registeredLogLevelMap.put(logLevel.getLabel(), logLevel);
        }
        return null;
    }

    public static void resetLogLevelColorMap() {
        _logLevelColorMap.clear();
        int i = 0;
        while (true) {
            LogLevel[] logLevelArr = _allDefaultLevels;
            if (i >= logLevelArr.length) {
                return;
            }
            _logLevelColorMap.put(logLevelArr[i], Color.black);
            i++;
        }
    }

    public static LogLevel valueOf(String str) throws LogLevelFormatException {
        LogLevel logLevel;
        if (str != null) {
            str = str.trim().toUpperCase();
            logLevel = (LogLevel) _logLevelMap.get(str);
        } else {
            logLevel = null;
        }
        if (logLevel == null && _registeredLogLevelMap.size() > 0) {
            logLevel = (LogLevel) _registeredLogLevelMap.get(str);
        }
        if (logLevel != null) {
            return logLevel;
        }
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Error while trying to parse (");
        stringBuffer2.append(str);
        stringBuffer2.append(") into");
        stringBuffer.append(stringBuffer2.toString());
        stringBuffer.append(" a LogLevel.");
        throw new LogLevelFormatException(stringBuffer.toString());
    }

    public boolean encompasses(LogLevel logLevel) {
        if (logLevel.getPrecedence() <= getPrecedence()) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof LogLevel) && getPrecedence() == ((LogLevel) obj).getPrecedence()) {
            return true;
        }
        return false;
    }

    public String getLabel() {
        return this._label;
    }

    public int getPrecedence() {
        return this._precedence;
    }

    public int hashCode() {
        return this._label.hashCode();
    }

    public void setLogLevelColorMap(LogLevel logLevel, Color color) {
        _logLevelColorMap.remove(logLevel);
        if (color == null) {
            color = Color.black;
        }
        _logLevelColorMap.put(logLevel, color);
    }

    public String toString() {
        return this._label;
    }

    public static void register(LogLevel[] logLevelArr) {
        if (logLevelArr != null) {
            for (LogLevel logLevel : logLevelArr) {
                register(logLevel);
            }
        }
    }

    public static void register(List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                register((LogLevel) it.next());
            }
        }
    }
}
