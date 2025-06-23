package org.apache.commons.lang3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes6.dex */
public class oOXoIIIo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final ConcurrentMap<String, List<Locale>> f32743oIX0oI = new ConcurrentHashMap();

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final ConcurrentMap<String, List<Locale>> f32742II0xO0 = new ConcurrentHashMap();

    /* loaded from: classes6.dex */
    public static class oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public static final Set<Locale> f32744II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final List<Locale> f32745oIX0oI;

        static {
            ArrayList arrayList = new ArrayList(Arrays.asList(Locale.getAvailableLocales()));
            f32745oIX0oI = Collections.unmodifiableList(arrayList);
            f32744II0xO0 = Collections.unmodifiableSet(new HashSet(arrayList));
        }
    }

    public static List<Locale> I0Io(String str) {
        if (str == null) {
            return Collections.emptyList();
        }
        List<Locale> list = f32742II0xO0.get(str);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            for (Locale locale : oIX0oI()) {
                if (str.equals(locale.getLanguage()) && !locale.getCountry().isEmpty() && locale.getVariant().isEmpty()) {
                    arrayList.add(locale);
                }
            }
            List<Locale> unmodifiableList = Collections.unmodifiableList(arrayList);
            ConcurrentMap<String, List<Locale>> concurrentMap = f32742II0xO0;
            concurrentMap.putIfAbsent(str, unmodifiableList);
            return concurrentMap.get(str);
        }
        return list;
    }

    public static List<Locale> II0XooXoX(String str) {
        if (str == null) {
            return Collections.emptyList();
        }
        List<Locale> list = f32743oIX0oI.get(str);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            for (Locale locale : oIX0oI()) {
                if (str.equals(locale.getCountry()) && locale.getVariant().isEmpty()) {
                    arrayList.add(locale);
                }
            }
            List<Locale> unmodifiableList = Collections.unmodifiableList(arrayList);
            ConcurrentMap<String, List<Locale>> concurrentMap = f32743oIX0oI;
            concurrentMap.putIfAbsent(str, unmodifiableList);
            return concurrentMap.get(str);
        }
        return list;
    }

    public static Set<Locale> II0xO0() {
        return oIX0oI.f32744II0xO0;
    }

    public static Locale OOXIXo(String str) {
        if (XO(str)) {
            return new Locale(str);
        }
        String[] split = str.split("_", -1);
        String str2 = split[0];
        if (split.length == 2) {
            String str3 = split[1];
            if ((XO(str2) && X0o0xo(str3)) || Oxx0IOOO(str3)) {
                return new Locale(str2, str3);
            }
        } else if (split.length == 3) {
            String str4 = split[1];
            String str5 = split[2];
            if (XO(str2) && ((str4.isEmpty() || X0o0xo(str4) || Oxx0IOOO(str4)) && !str5.isEmpty())) {
                return new Locale(str2, str4, str5);
            }
        }
        throw new IllegalArgumentException("Invalid locale format: " + str);
    }

    public static boolean Oxx0IOOO(String str) {
        if (xXOx.Ox0O(str) && str.length() == 3) {
            return true;
        }
        return false;
    }

    public static boolean X0o0xo(String str) {
        if (xXOx.XI0oooXX(str) && str.length() == 2) {
            return true;
        }
        return false;
    }

    public static boolean XO(String str) {
        if (xXOx.ox(str) && (str.length() == 2 || str.length() == 3)) {
            return true;
        }
        return false;
    }

    public static List<Locale> oIX0oI() {
        return oIX0oI.f32745oIX0oI;
    }

    public static Locale oOoXoXO(String str) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return new Locale("", "");
        }
        if (!str.contains(OoOoXO0.xoXoI.f2670oxoX)) {
            int length = str.length();
            if (length >= 2) {
                if (str.charAt(0) == '_') {
                    if (length >= 3) {
                        char charAt = str.charAt(1);
                        char charAt2 = str.charAt(2);
                        if (Character.isUpperCase(charAt) && Character.isUpperCase(charAt2)) {
                            if (length == 3) {
                                return new Locale("", str.substring(1, 3));
                            }
                            if (length >= 5) {
                                if (str.charAt(3) == '_') {
                                    return new Locale("", str.substring(1, 3), str.substring(4));
                                }
                                throw new IllegalArgumentException("Invalid locale format: " + str);
                            }
                            throw new IllegalArgumentException("Invalid locale format: " + str);
                        }
                        throw new IllegalArgumentException("Invalid locale format: " + str);
                    }
                    throw new IllegalArgumentException("Invalid locale format: " + str);
                }
                return OOXIXo(str);
            }
            throw new IllegalArgumentException("Invalid locale format: " + str);
        }
        throw new IllegalArgumentException("Invalid locale format: " + str);
    }

    public static boolean oxoX(Locale locale) {
        return oIX0oI().contains(locale);
    }

    public static List<Locale> xoIox(Locale locale, Locale locale2) {
        ArrayList arrayList = new ArrayList(4);
        if (locale != null) {
            arrayList.add(locale);
            if (!locale.getVariant().isEmpty()) {
                arrayList.add(new Locale(locale.getLanguage(), locale.getCountry()));
            }
            if (!locale.getCountry().isEmpty()) {
                arrayList.add(new Locale(locale.getLanguage(), ""));
            }
            if (!arrayList.contains(locale2)) {
                arrayList.add(locale2);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static List<Locale> xxIXOIIO(Locale locale) {
        return xoIox(locale, locale);
    }
}
