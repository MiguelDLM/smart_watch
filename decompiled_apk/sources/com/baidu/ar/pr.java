package com.baidu.ar;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import orgar.slf4j.impl.StaticLoggerBinder;

/* loaded from: classes7.dex */
public final class pr {
    static volatile int JU;
    static final qc JV = new qc();
    static final pz JW = new pz();
    static boolean JX = qd.cU("slf4j.detectLoggerNameMismatch");
    private static final String[] JY = {"1.6", "1.7"};
    private static String JZ = "orgar/slf4j/impl/StaticLoggerBinder.class";

    private pr() {
    }

    public static pq a(Class<?> cls) {
        Class<?> km;
        pq cO = cO(cls.getName());
        if (JX && (km = qd.km()) != null && a(cls, km)) {
            qd.cV(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", cO.getName(), km.getName()));
            qd.cV("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
        }
        return cO;
    }

    private static void ak(int i) {
        qd.cV("A number (" + i + ") of logging calls during the initialization phase have been intercepted and are");
        qd.cV("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        qd.cV("See also http://www.slf4j.org/codes.html#replay");
    }

    private static void b(Set<URL> set) {
        if (a(set)) {
            qd.cV("Class path contains multiple SLF4J bindings.");
            Iterator<URL> it = set.iterator();
            while (it.hasNext()) {
                qd.cV("Found binding in [" + it.next() + "]");
            }
            qd.cV("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    private static void c(Set<URL> set) {
        if (set == null || !a(set)) {
            return;
        }
        qd.cV("Actual binding is of type [" + StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr() + "]");
    }

    public static pq cO(String str) {
        return ka().cO(str);
    }

    private static boolean cR(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("orgar/slf4j/impl/StaticLoggerBinder") || str.contains("orgar.slf4j.impl.StaticLoggerBinder");
    }

    private static final void jS() {
        jT();
        if (JU == 3) {
            jX();
        }
    }

    private static final void jT() {
        Set<URL> set;
        try {
            if (jZ()) {
                set = null;
            } else {
                set = jY();
                b(set);
            }
            StaticLoggerBinder.getSingleton();
            JU = 3;
            c(set);
            jU();
            jV();
            JV.clear();
        } catch (Exception e) {
            a(e);
            throw new IllegalStateException("Unexpected initialization failure", e);
        } catch (NoClassDefFoundError e2) {
            if (!cR(e2.getMessage())) {
                a(e2);
                throw e2;
            }
            JU = 4;
            qd.cV("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
            qd.cV("Defaulting to no-operation (NOP) logger implementation");
            qd.cV("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
        } catch (NoSuchMethodError e3) {
            String message = e3.getMessage();
            if (message != null && message.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                JU = 2;
                qd.cV("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                qd.cV("Your binding is version 1.5.5 or earlier.");
                qd.cV("Upgrade your binding to version 1.6.x.");
            }
            throw e3;
        }
    }

    private static void jU() {
        qc qcVar = JV;
        synchronized (qcVar) {
            try {
                qcVar.kj();
                for (qb qbVar : qcVar.kh()) {
                    qbVar.a(cO(qbVar.getName()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void jV() {
        LinkedBlockingQueue<pw> ki = JV.ki();
        int size = ki.size();
        ArrayList<pw> arrayList = new ArrayList(128);
        int i = 0;
        while (ki.drainTo(arrayList, 128) != 0) {
            for (pw pwVar : arrayList) {
                a(pwVar);
                int i2 = i + 1;
                if (i == 0) {
                    a(pwVar, size);
                }
                i = i2;
            }
            arrayList.clear();
        }
    }

    private static void jW() {
        qd.cV("The following set of substitute loggers may have been accessed");
        qd.cV("during the initialization phase. Logging calls during this");
        qd.cV("phase were not honored. However, subsequent logging calls to these");
        qd.cV("loggers will work as normally expected.");
        qd.cV("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    private static final void jX() {
        try {
            String str = StaticLoggerBinder.REQUESTED_API_VERSION;
            boolean z = false;
            for (String str2 : JY) {
                if (str.startsWith(str2)) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            qd.cV("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(JY).toString());
            qd.cV("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            qd.c("Unexpected problem occured during version sanity check", th);
        }
    }

    public static Set<URL> jY() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = pr.class.getClassLoader();
            Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources(JZ) : classLoader.getResources(JZ);
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add(systemResources.nextElement());
            }
        } catch (IOException e) {
            qd.c("Error getting resources from path", e);
        }
        return linkedHashSet;
    }

    private static boolean jZ() {
        String cT = qd.cT("java.vendor.url");
        if (cT == null) {
            return false;
        }
        return cT.toLowerCase().contains("android");
    }

    public static pp ka() {
        if (JU == 0) {
            synchronized (pr.class) {
                try {
                    if (JU == 0) {
                        JU = 1;
                        jS();
                    }
                } finally {
                }
            }
        }
        int i = JU;
        if (i == 1) {
            return JV;
        }
        if (i == 2) {
            throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
        }
        if (i == 3) {
            return StaticLoggerBinder.getSingleton().getLoggerFactory();
        }
        if (i == 4) {
            return JW;
        }
        throw new IllegalStateException("Unreachable code");
    }

    private static void a(pw pwVar) {
        if (pwVar == null) {
            return;
        }
        qb kb = pwVar.kb();
        String name = kb.getName();
        if (kb.kf()) {
            throw new IllegalStateException("Delegate logger cannot be null at this state.");
        }
        if (kb.kg()) {
            return;
        }
        if (kb.ke()) {
            kb.a(pwVar);
        } else {
            qd.cV(name);
        }
    }

    private static void a(pw pwVar, int i) {
        if (pwVar.kb().ke()) {
            ak(i);
        } else {
            if (pwVar.kb().kg()) {
                return;
            }
            jW();
        }
    }

    public static void a(Throwable th) {
        JU = 2;
        qd.c("Failed to instantiate SLF4J LoggerFactory", th);
    }

    private static boolean a(Class<?> cls, Class<?> cls2) {
        return !cls2.isAssignableFrom(cls);
    }

    private static boolean a(Set<URL> set) {
        return set.size() > 1;
    }
}
