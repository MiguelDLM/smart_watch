package org.apache.log4j;

import com.baidu.mobads.sdk.internal.cb;

/* loaded from: classes6.dex */
public class OxxIIOOXO {
    public static final int ALL_INT = Integer.MIN_VALUE;
    public static final int DEBUG_INT = 10000;
    public static final int ERROR_INT = 40000;
    public static final int FATAL_INT = 50000;
    public static final int INFO_INT = 20000;
    public static final int OFF_INT = Integer.MAX_VALUE;
    public static final int WARN_INT = 30000;
    transient int level;
    transient String levelStr;
    transient int syslogEquivalent;
    public static final OxxIIOOXO FATAL = new Level(50000, "FATAL", 0);
    public static final OxxIIOOXO ERROR = new Level(40000, cb.l, 3);
    public static final OxxIIOOXO WARN = new Level(30000, "WARN", 4);
    public static final OxxIIOOXO INFO = new Level(20000, "INFO", 6);
    public static final OxxIIOOXO DEBUG = new Level(10000, "DEBUG", 7);

    public OxxIIOOXO() {
        this.level = 10000;
        this.levelStr = "DEBUG";
        this.syslogEquivalent = 7;
    }

    public static OxxIIOOXO[] getAllPossiblePriorities() {
        return new OxxIIOOXO[]{FATAL, ERROR, Level.WARN, INFO, DEBUG};
    }

    public static OxxIIOOXO toPriority(String str) {
        return Level.toLevel(str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof OxxIIOOXO) || this.level != ((OxxIIOOXO) obj).level) {
            return false;
        }
        return true;
    }

    public final int getSyslogEquivalent() {
        return this.syslogEquivalent;
    }

    public boolean isGreaterOrEqual(OxxIIOOXO oxxIIOOXO) {
        if (this.level >= oxxIIOOXO.level) {
            return true;
        }
        return false;
    }

    public final int toInt() {
        return this.level;
    }

    public final String toString() {
        return this.levelStr;
    }

    public static OxxIIOOXO toPriority(int i) {
        return toPriority(i, DEBUG);
    }

    public static OxxIIOOXO toPriority(int i, OxxIIOOXO oxxIIOOXO) {
        return Level.toLevel(i, (Level) oxxIIOOXO);
    }

    public static OxxIIOOXO toPriority(String str, OxxIIOOXO oxxIIOOXO) {
        return Level.toLevel(str, (Level) oxxIIOOXO);
    }

    public OxxIIOOXO(int i, String str, int i2) {
        this.level = i;
        this.levelStr = str;
        this.syslogEquivalent = i2;
    }
}
