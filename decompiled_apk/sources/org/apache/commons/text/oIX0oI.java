package org.apache.commons.text;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes6.dex */
public final class oIX0oI {

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f33048oxoX = " -> ";

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f33049I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Map<String, String> f33050II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Map<Integer, String> f33051oIX0oI;

    public oIX0oI(Map<Integer, String> map, Map<String, String> map2, int i) {
        this.f33051oIX0oI = map;
        this.f33050II0xO0 = map2;
        this.f33049I0Io = i;
    }

    public static Integer[] I0Io(Character[] chArr) {
        if (org.apache.commons.lang3.oxoX.XOxxooXI(chArr)) {
            return org.apache.commons.lang3.oxoX.f32768x0XOIxOo;
        }
        Integer[] numArr = new Integer[chArr.length];
        for (int i = 0; i < chArr.length; i++) {
            numArr[i] = Integer.valueOf(chArr[i].charValue());
        }
        return numArr;
    }

    public static String II0xO0(int i) {
        if (Character.charCount(i) == 1) {
            return String.valueOf((char) i);
        }
        return new String(Character.toChars(i));
    }

    public static oIX0oI X0o0xo(Character[] chArr, Character[] chArr2, Character[] chArr3) {
        return oxoX(I0Io(chArr), I0Io(chArr2), I0Io(chArr3));
    }

    public static oIX0oI XO(Map<Integer, String> map) {
        Map unmodifiableMap = Collections.unmodifiableMap(map);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 1;
        for (Map.Entry entry : unmodifiableMap.entrySet()) {
            linkedHashMap.put(entry.getValue(), II0xO0(((Integer) entry.getKey()).intValue()));
            if (((String) entry.getValue()).length() > i) {
                i = ((String) entry.getValue()).length();
            }
        }
        return new oIX0oI(unmodifiableMap, linkedHashMap, i);
    }

    public static oIX0oI oxoX(Integer[] numArr, Integer[] numArr2, Integer[] numArr3) {
        Integer num;
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet(Arrays.asList(numArr));
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(Arrays.asList(numArr2));
        LinkedHashSet<Integer> linkedHashSet3 = new LinkedHashSet(Arrays.asList(numArr3));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        HashMap hashMap = new HashMap();
        for (Integer num2 : linkedHashSet3) {
            int intValue = num2.intValue();
            if (linkedHashSet.contains(num2)) {
                if (linkedHashSet2.contains(num2)) {
                    hashMap.put(num2, II0xO0(intValue));
                } else {
                    throw new IllegalArgumentException("Can not use 'do not encode' list because encoding alphabet does not contain '" + II0xO0(intValue) + "'");
                }
            } else {
                throw new IllegalArgumentException("Can not use 'do not encode' list because original alphabet does not contain '" + II0xO0(intValue) + "'");
            }
        }
        if (linkedHashSet2.size() >= linkedHashSet.size()) {
            Iterator it = linkedHashSet2.iterator();
            for (Integer num3 : linkedHashSet) {
                String II0xO02 = II0xO0(num3.intValue());
                if (hashMap.containsKey(num3)) {
                    linkedHashMap.put(num3, II0xO02);
                    linkedHashMap2.put(II0xO02, II0xO02);
                } else {
                    Object next = it.next();
                    while (true) {
                        num = (Integer) next;
                        if (!linkedHashSet3.contains(num)) {
                            break;
                        }
                        next = it.next();
                    }
                    String II0xO03 = II0xO0(num.intValue());
                    linkedHashMap.put(num3, II0xO03);
                    linkedHashMap2.put(II0xO03, II0xO02);
                }
            }
            return new oIX0oI(linkedHashMap, linkedHashMap2, 1);
        }
        if (linkedHashSet2.size() - linkedHashSet3.size() >= 2) {
            int size = (linkedHashSet.size() - linkedHashSet3.size()) / (linkedHashSet2.size() - linkedHashSet3.size());
            int i = 1;
            while (size / linkedHashSet2.size() >= 1) {
                size /= linkedHashSet2.size();
                i++;
            }
            int i2 = i + 1;
            oIX0oI oix0oi = new oIX0oI(linkedHashMap, linkedHashMap2, i2);
            oix0oi.oIX0oI(i2, "", linkedHashSet2, linkedHashSet.iterator(), hashMap);
            return oix0oi;
        }
        throw new IllegalArgumentException("Must have at least two encoding characters (excluding those in the 'do not encode' list), but has " + (linkedHashSet2.size() - linkedHashSet3.size()));
    }

    public String II0XooXoX(String str) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            int codePointAt = str.codePointAt(i);
            String str2 = this.f33051oIX0oI.get(Integer.valueOf(codePointAt));
            if (str2 != null) {
                sb.append(str2);
                i += Character.charCount(codePointAt);
            } else {
                throw new UnsupportedEncodingException("Couldn't find encoding for '" + II0xO0(codePointAt) + "' in " + str);
            }
        }
        return sb.toString();
    }

    public String Oxx0IOOO(String str) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            int codePointAt = str.codePointAt(i);
            String II0xO02 = II0xO0(codePointAt);
            if (II0xO02.equals(this.f33051oIX0oI.get(Integer.valueOf(codePointAt)))) {
                sb.append(II0xO02);
                i++;
            } else if (this.f33049I0Io + i <= str.length()) {
                String substring = str.substring(i, this.f33049I0Io + i);
                String str2 = this.f33050II0xO0.get(substring);
                if (str2 != null) {
                    sb.append(str2);
                    i += this.f33049I0Io;
                } else {
                    throw new UnsupportedEncodingException("Unexpected string without decoding (" + substring + ") in " + str);
                }
            } else {
                throw new UnsupportedEncodingException("Unexpected end of string while decoding " + str);
            }
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oIX0oI)) {
            return false;
        }
        oIX0oI oix0oi = (oIX0oI) obj;
        if (!this.f33051oIX0oI.equals(oix0oi.f33051oIX0oI) || !this.f33050II0xO0.equals(oix0oi.f33050II0xO0) || this.f33049I0Io != oix0oi.f33049I0Io) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(this.f33051oIX0oI, this.f33050II0xO0, Integer.valueOf(this.f33049I0Io));
    }

    public final void oIX0oI(int i, String str, Collection<Integer> collection, Iterator<Integer> it, Map<Integer, String> map) {
        if (i > 0) {
            for (Integer num : collection) {
                int intValue = num.intValue();
                if (it.hasNext()) {
                    if (i != this.f33049I0Io || !map.containsKey(num)) {
                        oIX0oI(i - 1, str + II0xO0(intValue), collection, it, map);
                    }
                } else {
                    return;
                }
            }
            return;
        }
        Integer next = it.next();
        while (true) {
            Integer num2 = next;
            if (map.containsKey(num2)) {
                String II0xO02 = II0xO0(num2.intValue());
                this.f33051oIX0oI.put(num2, II0xO02);
                this.f33050II0xO0.put(II0xO02, II0xO02);
                if (!it.hasNext()) {
                    return;
                } else {
                    next = it.next();
                }
            } else {
                String II0xO03 = II0xO0(num2.intValue());
                this.f33051oIX0oI.put(num2, str);
                this.f33050II0xO0.put(str, II0xO03);
                return;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, String> entry : this.f33051oIX0oI.entrySet()) {
            sb.append(II0xO0(entry.getKey().intValue()));
            sb.append(f33048oxoX);
            sb.append(entry.getValue());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public Map<Integer, String> xoIox() {
        return Collections.unmodifiableMap(this.f33051oIX0oI);
    }

    public int xxIXOIIO() {
        return this.f33049I0Io;
    }
}
