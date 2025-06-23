package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.impl.LogFactoryImpl;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.impl.NoOpLog;
import java.lang.reflect.Constructor;
import java.util.Hashtable;

/* loaded from: classes10.dex */
public class LogSource {
    protected static boolean jdk14IsAvailable;
    protected static boolean log4jIsAvailable;
    protected static Hashtable logs = new Hashtable();
    protected static Constructor logImplctor = null;

    static {
        log4jIsAvailable = false;
        jdk14IsAvailable = false;
        String str = null;
        try {
            Class.forName("org.apache.log4j.x0xO0oo");
            log4jIsAvailable = true;
        } catch (Throwable unused) {
            log4jIsAvailable = false;
        }
        try {
            Class.forName("java.util.logging.Logger");
            Class.forName("com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.impl.Jdk14Logger");
            jdk14IsAvailable = true;
        } catch (Throwable unused2) {
            jdk14IsAvailable = false;
        }
        try {
            str = System.getProperty("com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.log");
            if (str == null) {
                str = System.getProperty(LogFactoryImpl.LOG_PROPERTY);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (str != null) {
                try {
                    setLogImplementation(str);
                } catch (Throwable unused4) {
                    setLogImplementation("com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.impl.NoOpLog");
                }
            }
            try {
                if (log4jIsAvailable) {
                    setLogImplementation("com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.impl.Log4JLogger");
                } else if (jdk14IsAvailable) {
                    setLogImplementation("com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.impl.Jdk14Logger");
                } else {
                    setLogImplementation("com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.impl.NoOpLog");
                }
            } catch (Throwable unused5) {
                setLogImplementation("com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.impl.NoOpLog");
            }
        } catch (Throwable unused6) {
        }
    }

    private LogSource() {
    }

    public static Log getInstance(String str) {
        Log log = (Log) logs.get(str);
        if (log != null) {
            return log;
        }
        Log makeNewLogInstance = makeNewLogInstance(str);
        logs.put(str, makeNewLogInstance);
        return makeNewLogInstance;
    }

    public static String[] getLogNames() {
        return (String[]) logs.keySet().toArray(new String[logs.size()]);
    }

    public static Log makeNewLogInstance(String str) {
        Log log;
        try {
            log = (Log) logImplctor.newInstance(str);
        } catch (Throwable unused) {
            log = null;
        }
        if (log == null) {
            return new NoOpLog(str);
        }
        return log;
    }

    public static void setLogImplementation(String str) throws LinkageError, NoSuchMethodException, SecurityException, ClassNotFoundException {
        try {
            logImplctor = Class.forName(str).getConstructor("".getClass());
        } catch (Throwable unused) {
            logImplctor = null;
        }
    }

    public static Log getInstance(Class cls) {
        return getInstance(cls.getName());
    }

    public static void setLogImplementation(Class cls) throws LinkageError, ExceptionInInitializerError, NoSuchMethodException, SecurityException {
        logImplctor = cls.getConstructor("".getClass());
    }
}
