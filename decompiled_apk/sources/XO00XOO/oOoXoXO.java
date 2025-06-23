package XO00XOO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.lang.model.element.Modifier;

/* loaded from: classes11.dex */
public final class oOoXoXO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final Modifier f3879oIX0oI;

    static {
        Modifier modifier;
        try {
            modifier = Modifier.valueOf("DEFAULT");
        } catch (IllegalArgumentException unused) {
            modifier = null;
        }
        f3879oIX0oI = modifier;
    }

    public static <T> T I0Io(T t, String str, Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    public static <K, V> Map<K, List<V>> II0XooXoX(Map<K, List<V>> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                linkedHashMap.put(entry.getKey(), XO(entry.getValue()));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public static void II0xO0(boolean z, String str, Object... objArr) {
        if (z) {
        } else {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void OOXIXo(Set<Modifier> set, Modifier... modifierArr) {
        boolean z;
        int i = 0;
        for (Modifier modifier : modifierArr) {
            if ((modifier != null || f3879oIX0oI != null) && set.contains(modifier)) {
                i++;
            }
        }
        if (i == 1) {
            z = true;
        } else {
            z = false;
        }
        II0xO0(z, "modifiers %s must contain one of %s", set, Arrays.toString(modifierArr));
    }

    public static <K, V> Map<K, V> Oxx0IOOO(Map<K, V> map) {
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static boolean X0o0xo(Collection<Modifier> collection) {
        Modifier modifier = f3879oIX0oI;
        if (modifier != null && collection.contains(modifier)) {
            return true;
        }
        return false;
    }

    public static <T> List<T> XO(Collection<T> collection) {
        return Collections.unmodifiableList(new ArrayList(collection));
    }

    public static String oIX0oI(char c) {
        if (c != '\f') {
            if (c != '\r') {
                if (c != '\"') {
                    if (c != '\'') {
                        if (c != '\\') {
                            switch (c) {
                                case '\b':
                                    return "\\b";
                                case '\t':
                                    return "\\t";
                                case '\n':
                                    return "\\n";
                                default:
                                    if (Character.isISOControl(c)) {
                                        return String.format("\\u%04x", Integer.valueOf(c));
                                    }
                                    return Character.toString(c);
                            }
                        }
                        return "\\\\";
                    }
                    return "\\'";
                }
                return "\"";
            }
            return "\\r";
        }
        return "\\f";
    }

    public static String oOoXoXO(String str, String str2) {
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append('\"');
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\'') {
                sb.append("'");
            } else if (charAt == '\"') {
                sb.append("\\\"");
            } else {
                sb.append(oIX0oI(charAt));
                if (charAt == '\n' && i + 1 < str.length()) {
                    sb.append("\"\n");
                    sb.append(str2);
                    sb.append(str2);
                    sb.append("+ \"");
                }
            }
        }
        sb.append('\"');
        return sb.toString();
    }

    public static <T> Set<T> ooOOo0oXI(Set<T> set, Set<T> set2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(set);
        linkedHashSet.addAll(set2);
        return linkedHashSet;
    }

    public static void oxoX(boolean z, String str, Object... objArr) {
        if (z) {
        } else {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static String xoIox(String str, List<String> list) {
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            sb.append(str);
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static <T> Set<T> xxIXOIIO(Collection<T> collection) {
        return Collections.unmodifiableSet(new LinkedHashSet(collection));
    }
}
