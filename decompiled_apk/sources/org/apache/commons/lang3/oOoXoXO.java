package org.apache.commons.lang3;

import java.net.URLClassLoader;
import java.util.Arrays;

/* loaded from: classes6.dex */
public class oOoXoXO {
    public static String II0xO0(URLClassLoader uRLClassLoader) {
        return uRLClassLoader + Arrays.toString(uRLClassLoader.getURLs());
    }

    public static String oIX0oI(ClassLoader classLoader) {
        if (classLoader instanceof URLClassLoader) {
            return II0xO0((URLClassLoader) classLoader);
        }
        return classLoader.toString();
    }
}
