package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.impl;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log;
import org.apache.avalon.framework.logger.Logger;

/* loaded from: classes10.dex */
public class AvalonLogger implements Log {
    private static volatile Logger defaultLogger;
    private final transient Logger logger;

    public AvalonLogger(Logger logger) {
        this.logger = logger;
    }

    public static void setDefaultLogger(Logger logger) {
        defaultLogger = logger;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public void debug(Object obj, Throwable th) {
        if (getLogger().isDebugEnabled()) {
            getLogger().debug(String.valueOf(obj), th);
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public void error(Object obj, Throwable th) {
        if (getLogger().isErrorEnabled()) {
            getLogger().error(String.valueOf(obj), th);
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public void fatal(Object obj, Throwable th) {
        if (getLogger().isFatalErrorEnabled()) {
            getLogger().fatalError(String.valueOf(obj), th);
        }
    }

    public Logger getLogger() {
        return this.logger;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public void info(Object obj, Throwable th) {
        if (getLogger().isInfoEnabled()) {
            getLogger().info(String.valueOf(obj), th);
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public boolean isDebugEnabled() {
        return getLogger().isDebugEnabled();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public boolean isErrorEnabled() {
        return getLogger().isErrorEnabled();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public boolean isFatalEnabled() {
        return getLogger().isFatalErrorEnabled();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public boolean isInfoEnabled() {
        return getLogger().isInfoEnabled();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public boolean isTraceEnabled() {
        return getLogger().isDebugEnabled();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public boolean isWarnEnabled() {
        return getLogger().isWarnEnabled();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public void trace(Object obj, Throwable th) {
        if (getLogger().isDebugEnabled()) {
            getLogger().debug(String.valueOf(obj), th);
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public void warn(Object obj, Throwable th) {
        if (getLogger().isWarnEnabled()) {
            getLogger().warn(String.valueOf(obj), th);
        }
    }

    public AvalonLogger(String str) {
        if (defaultLogger != null) {
            this.logger = defaultLogger.getChildLogger(str);
            return;
        }
        throw new NullPointerException("default logger has to be specified if this constructor is used!");
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public void debug(Object obj) {
        if (getLogger().isDebugEnabled()) {
            getLogger().debug(String.valueOf(obj));
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public void error(Object obj) {
        if (getLogger().isErrorEnabled()) {
            getLogger().error(String.valueOf(obj));
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public void fatal(Object obj) {
        if (getLogger().isFatalErrorEnabled()) {
            getLogger().fatalError(String.valueOf(obj));
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public void info(Object obj) {
        if (getLogger().isInfoEnabled()) {
            getLogger().info(String.valueOf(obj));
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public void trace(Object obj) {
        if (getLogger().isDebugEnabled()) {
            getLogger().debug(String.valueOf(obj));
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
    public void warn(Object obj) {
        if (getLogger().isWarnEnabled()) {
            getLogger().warn(String.valueOf(obj));
        }
    }
}
