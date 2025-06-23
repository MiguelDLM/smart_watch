package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.Contract;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.ThreadingBehavior;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Contract(threading = ThreadingBehavior.SAFE)
/* loaded from: classes10.dex */
public class UriPatternMatcher<T> {
    private final Map<String, T> map = new HashMap();

    public synchronized Set<Map.Entry<String, T>> entrySet() {
        return new HashSet(this.map.entrySet());
    }

    @Deprecated
    public synchronized Map<String, T> getObjects() {
        return this.map;
    }

    public synchronized T lookup(String str) {
        T t;
        try {
            Args.notNull(str, "Request path");
            t = this.map.get(str);
            if (t == null) {
                String str2 = null;
                for (String str3 : this.map.keySet()) {
                    if (matchUriRequestPattern(str3, str)) {
                        if (str2 != null) {
                            if (str2.length() >= str3.length()) {
                                if (str2.length() == str3.length() && str3.endsWith("*")) {
                                }
                            }
                        }
                        t = this.map.get(str3);
                        str2 = str3;
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return t;
    }

    public boolean matchUriRequestPattern(String str, String str2) {
        if (str.equals("*")) {
            return true;
        }
        if (str.endsWith("*") && str2.startsWith(str.substring(0, str.length() - 1))) {
            return true;
        }
        if (str.startsWith("*") && str2.endsWith(str.substring(1, str.length()))) {
            return true;
        }
        return false;
    }

    public synchronized void register(String str, T t) {
        Args.notNull(str, "URI request pattern");
        this.map.put(str, t);
    }

    @Deprecated
    public synchronized void setHandlers(Map<String, T> map) {
        Args.notNull(map, "Map of handlers");
        this.map.clear();
        this.map.putAll(map);
    }

    @Deprecated
    public synchronized void setObjects(Map<String, T> map) {
        Args.notNull(map, "Map of handlers");
        this.map.clear();
        this.map.putAll(map);
    }

    public String toString() {
        return this.map.toString();
    }

    public synchronized void unregister(String str) {
        if (str == null) {
            return;
        }
        this.map.remove(str);
    }
}
