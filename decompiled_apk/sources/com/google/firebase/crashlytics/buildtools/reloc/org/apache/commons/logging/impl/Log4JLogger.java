package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.impl;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpTrace;
import java.io.Serializable;
import org.apache.log4j.Level;
import org.apache.log4j.OxxIIOOXO;
import org.apache.log4j.x0xO0oo;

/* loaded from: classes10.dex */
public class Log4JLogger implements Log, Serializable {
    private static final String FQCN;
    static /* synthetic */ Class class$org$apache$commons$logging$impl$Log4JLogger = null;
    static /* synthetic */ Class class$org$apache$log4j$Level = null;
    static /* synthetic */ Class class$org$apache$log4j$Priority = null;
    private static final long serialVersionUID = 5160705895411730424L;
    private static final OxxIIOOXO traceLevel;
    private volatile transient x0xO0oo logger;
    private final String name;

    static {
        OxxIIOOXO oxxIIOOXO;
        Class cls = class$org$apache$commons$logging$impl$Log4JLogger;
        if (cls == null) {
            cls = class$("com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.impl.Log4JLogger");
            class$org$apache$commons$logging$impl$Log4JLogger = cls;
        }
        FQCN = cls.getName();
        Class cls2 = class$org$apache$log4j$Priority;
        if (cls2 == null) {
            cls2 = class$("org.apache.log4j.Priority");
            class$org$apache$log4j$Priority = cls2;
        }
        Class<?> cls3 = class$org$apache$log4j$Level;
        if (cls3 == null) {
            cls3 = class$("org.apache.log4j.Level");
            class$org$apache$log4j$Level = cls3;
        }
        if (cls2.isAssignableFrom(cls3)) {
            try {
                Class cls4 = class$org$apache$log4j$Level;
                if (cls4 == null) {
                    cls4 = class$("org.apache.log4j.Level");
                    class$org$apache$log4j$Level = cls4;
                }
                oxxIIOOXO = (OxxIIOOXO) cls4.getDeclaredField(HttpTrace.METHOD_NAME).get(null);
            } catch (Exception unused) {
                oxxIIOOXO = Level.DEBUG;
            }
            traceLevel = oxxIIOOXO;
            return;
        }
        throw new InstantiationError("Log4J 1.2 not available");
    }

    public Log4JLogger() {
        this.logger = null;
        this.name = null;
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public void debug(Object obj) {
        getLogger().xII(FQCN, Level.DEBUG, obj, null);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public void error(Object obj) {
        getLogger().xII(FQCN, Level.ERROR, obj, null);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public void fatal(Object obj) {
        getLogger().xII(FQCN, Level.FATAL, obj, null);
    }

    public x0xO0oo getLogger() {
        x0xO0oo x0xo0oo = this.logger;
        if (x0xo0oo == null) {
            synchronized (this) {
                try {
                    x0xo0oo = this.logger;
                    if (x0xo0oo == null) {
                        x0xo0oo = x0xO0oo.xXOx(this.name);
                        this.logger = x0xo0oo;
                    }
                } finally {
                }
            }
        }
        return x0xo0oo;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public void info(Object obj) {
        getLogger().xII(FQCN, Level.INFO, obj, null);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public boolean isDebugEnabled() {
        return getLogger().IoOoX();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public boolean isErrorEnabled() {
        return getLogger().oOXoIIIo(Level.ERROR);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public boolean isFatalEnabled() {
        return getLogger().oOXoIIIo(Level.FATAL);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public boolean isInfoEnabled() {
        return getLogger().Xx000oIo();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public boolean isTraceEnabled() {
        return getLogger().oOXoIIIo(traceLevel);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public boolean isWarnEnabled() {
        return getLogger().oOXoIIIo(Level.WARN);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public void trace(Object obj) {
        getLogger().xII(FQCN, traceLevel, obj, null);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public void warn(Object obj) {
        getLogger().xII(FQCN, Level.WARN, obj, null);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public void debug(Object obj, Throwable th) {
        getLogger().xII(FQCN, Level.DEBUG, obj, th);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public void error(Object obj, Throwable th) {
        getLogger().xII(FQCN, Level.ERROR, obj, th);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public void fatal(Object obj, Throwable th) {
        getLogger().xII(FQCN, Level.FATAL, obj, th);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public void info(Object obj, Throwable th) {
        getLogger().xII(FQCN, Level.INFO, obj, th);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public void trace(Object obj, Throwable th) {
        getLogger().xII(FQCN, traceLevel, obj, th);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public void warn(Object obj, Throwable th) {
        getLogger().xII(FQCN, Level.WARN, obj, th);
    }

    public Log4JLogger(String str) {
        this.logger = null;
        this.name = str;
        this.logger = getLogger();
    }

    public Log4JLogger(x0xO0oo x0xo0oo) {
        this.logger = null;
        if (x0xo0oo != null) {
            this.name = x0xo0oo.xxX();
            this.logger = x0xo0oo;
            return;
        }
        throw new IllegalArgumentException("Warning - null logger in constructor; possible log4j misconfiguration.");
    }
}
