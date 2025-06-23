package com.baidu.tts.tools;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes8.dex */
public class DataTool {
    public static String[] connect(String[] strArr, String[]... strArr2) {
        if (strArr == null) {
            strArr = new String[0];
        }
        int length = strArr.length;
        for (String[] strArr3 : strArr2) {
            try {
                length += strArr3.length;
            } catch (Exception unused) {
            }
        }
        String[] strArr4 = (String[]) Arrays.copyOf(strArr, length);
        int length2 = strArr.length;
        for (String[] strArr5 : strArr2) {
            try {
                System.arraycopy(strArr5, 0, strArr4, length2, strArr5.length);
                length2 += strArr5.length;
            } catch (Exception unused2) {
            }
        }
        return strArr4;
    }

    public static Set<String> copy(Set<String> set) {
        if (set == null) {
            return null;
        }
        return new HashSet(set);
    }

    public static Set<String> fromArrayToSet(String[] strArr) {
        if (strArr != null) {
            return new HashSet(Arrays.asList(strArr).subList(0, strArr.length));
        }
        return null;
    }

    public static String[] fromSetToArray(Set<String> set) {
        if (set != null) {
            String[] strArr = new String[set.size()];
            set.toArray(strArr);
            return strArr;
        }
        return null;
    }

    public static String getMapInnerValue(Map<String, Map<String, String>> map, String str, String str2) {
        Map<String, String> map2;
        if (map == null || (map2 = map.get(str)) == null) {
            return null;
        }
        return map2.get(str2);
    }

    public static String getMapValue(Map<String, String> map, String str) {
        if (map != null && !map.isEmpty()) {
            return map.get(str);
        }
        return null;
    }

    public static Map<String, Integer> getSuitItem(Map<String, Integer> map, boolean z, int i) {
        if (isMapEmpty(map)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : map.keySet()) {
            Integer num = map.get(str);
            int intValue = num.intValue();
            if (z) {
                if (i == intValue) {
                    hashMap.put(str, num);
                }
            } else if (i != intValue) {
                hashMap.put(str, num);
            }
        }
        return hashMap;
    }

    public static <T extends List<?>> boolean isListEmpty(T t) {
        if (t != null && !t.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean isLong(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static <T extends Map<?, ?>> boolean isMapEmpty(T t) {
        if (t != null && !t.isEmpty()) {
            return false;
        }
        return true;
    }

    public static <T extends Set<?>> boolean isSetEmpty(T t) {
        if (t != null && !t.isEmpty()) {
            return false;
        }
        return true;
    }

    public static Map<String, String> putIfAbsent(Map<String, Map<String, String>> map, String str) {
        Map<String, String> map2 = map.get(str);
        if (map2 == null) {
            HashMap hashMap = new HashMap();
            map.put(str, hashMap);
            return hashMap;
        }
        return map2;
    }

    public static void putMapItem(Map<String, Map<String, String>> map, String str, Map<String, String> map2) {
        Map<String, String> map3 = map.get(str);
        if (map3 == null) {
            map.put(str, map2);
        } else {
            map3.putAll(map2);
        }
    }

    public static void putMapValue(Map<String, Map<String, String>> map, String str, String str2, String str3) {
        putIfAbsent(map, str).put(str2, str3);
    }

    public static Map<String, Map<String, String>> getSuitItem(Map<String, Map<String, String>> map, String str, boolean z, String str2) {
        if (isMapEmpty(map)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str3 : map.keySet()) {
            Map<String, String> map2 = map.get(str3);
            String str4 = map2.get(str);
            if (z) {
                if (str2.equals(str4)) {
                    hashMap.put(str3, map2);
                }
            } else if (!str2.equals(str4)) {
                hashMap.put(str3, map2);
            }
        }
        return hashMap;
    }
}
