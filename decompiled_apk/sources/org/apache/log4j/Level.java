package org.apache.log4j;

import com.baidu.mobads.sdk.internal.cb;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Rule;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpTrace;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class Level extends OxxIIOOXO implements Serializable {
    public static final int TRACE_INT = 5000;
    static /* synthetic */ Class class$org$apache$log4j$Level = null;
    static final long serialVersionUID = 3491141966387921974L;
    public static final Level OFF = new Level(Integer.MAX_VALUE, "OFF", 0);
    public static final Level FATAL = new Level(50000, "FATAL", 0);
    public static final Level ERROR = new Level(40000, cb.l, 3);
    public static final Level WARN = new Level(30000, "WARN", 4);
    public static final Level INFO = new Level(20000, "INFO", 6);
    public static final Level DEBUG = new Level(10000, "DEBUG", 7);
    public static final Level TRACE = new Level(5000, HttpTrace.METHOD_NAME, 7);
    public static final Level ALL = new Level(Integer.MIN_VALUE, Rule.ALL, 7);

    public Level(int i, String str, int i2) {
        super(i, str, i2);
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.level = objectInputStream.readInt();
        this.syslogEquivalent = objectInputStream.readInt();
        String readUTF = objectInputStream.readUTF();
        this.levelStr = readUTF;
        if (readUTF == null) {
            this.levelStr = "";
        }
    }

    private Object readResolve() throws ObjectStreamException {
        Class<?> cls = getClass();
        Class<?> cls2 = class$org$apache$log4j$Level;
        if (cls2 == null) {
            cls2 = class$("org.apache.log4j.Level");
            class$org$apache$log4j$Level = cls2;
        }
        if (cls == cls2) {
            return toLevel(this.level);
        }
        return this;
    }

    public static Level toLevel(String str) {
        return toLevel(str, DEBUG);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.level);
        objectOutputStream.writeInt(this.syslogEquivalent);
        objectOutputStream.writeUTF(this.levelStr);
    }

    public static Level toLevel(int i) {
        return toLevel(i, DEBUG);
    }

    public static Level toLevel(int i, Level level) {
        if (i == Integer.MIN_VALUE) {
            return ALL;
        }
        if (i == 5000) {
            return TRACE;
        }
        if (i == 10000) {
            return DEBUG;
        }
        if (i == 20000) {
            return INFO;
        }
        if (i == 30000) {
            return WARN;
        }
        if (i == 40000) {
            return ERROR;
        }
        if (i != 50000) {
            return i != Integer.MAX_VALUE ? level : OFF;
        }
        return FATAL;
    }

    public static Level toLevel(String str, Level level) {
        if (str == null) {
            return level;
        }
        String upperCase = str.toUpperCase();
        return upperCase.equals(Rule.ALL) ? ALL : upperCase.equals("DEBUG") ? DEBUG : upperCase.equals("INFO") ? INFO : upperCase.equals("WARN") ? WARN : upperCase.equals(cb.l) ? ERROR : upperCase.equals("FATAL") ? FATAL : upperCase.equals("OFF") ? OFF : upperCase.equals(HttpTrace.METHOD_NAME) ? TRACE : level;
    }
}
