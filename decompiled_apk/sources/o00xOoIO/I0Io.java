package o00xOoIO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* loaded from: classes13.dex */
public abstract class I0Io implements x0oox0.XO {

    /* renamed from: I0Io, reason: collision with root package name */
    public final char f31032I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final char f31033II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f31034oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final char f31035oxoX;

    /* JADX WARN: Multi-variable type inference failed */
    public I0Io(int i, X0o0xo x0o0xo) {
        this.f31034oIX0oI = i;
        this.f31032I0Io = ((II0xO0) x0o0xo.xxIXOIIO()).Oo();
        this.f31035oxoX = ((II0xO0) x0o0xo.xxIXOIIO()).Oxx0IOOO();
        this.f31033II0xO0 = ((II0xO0) x0o0xo.xxIXOIIO()).II0xO0();
    }

    public static char I0Io(Map<Character, Integer> map, char c, boolean z) {
        int i;
        if (z) {
            i = Integer.MAX_VALUE;
        } else {
            i = Integer.MIN_VALUE;
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int intValue = entry.getValue().intValue();
            if ((z && intValue < i) || (!z && intValue > i)) {
                c = entry.getKey().charValue();
                i = intValue;
            }
        }
        return c;
    }

    public static char Oxx0IOOO(Map<Character, Integer> map, char c) {
        return I0Io(map, c, true);
    }

    public static void X0o0xo(Map<Character, Integer> map, char c, int i) {
        Integer num = map.get(Character.valueOf(c));
        if (num == null) {
            num = 0;
        }
        map.put(Character.valueOf(c), Integer.valueOf(num.intValue() + i));
    }

    public static char XO(Map<Character, Integer> map, char c) {
        return I0Io(map, c, false);
    }

    public static void oxoX(Map<Character, Integer> map, char c) {
        X0o0xo(map, c, 1);
    }

    public abstract void II0xO0(char c, char c2, char c3);

    @Override // x0oox0.XO
    public void oIX0oI(char[] cArr, int i) {
        char c;
        char c2;
        HashSet<Character> hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ArrayList<Map> arrayList = new ArrayList();
        int i2 = 1;
        int i3 = 0;
        boolean z = true;
        char c3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i) {
            char c4 = cArr[i3];
            if (!z || c4 != this.f31033II0xO0) {
                if (c4 != '\"' && c4 != '\'') {
                    if (c3 == 0) {
                        if (!Character.isLetterOrDigit(c4) && (c4 == '\t' || c4 > ' ')) {
                            hashSet.add(Character.valueOf(c4));
                            oxoX(hashMap, c4);
                        } else if ((c4 == '\r' || c4 == '\n' || c4 == this.f31035oxoX) && hashMap.size() > 0) {
                            arrayList.add(hashMap);
                            if (arrayList.size() == this.f31034oIX0oI) {
                                break;
                            }
                            hashMap = new HashMap();
                            z = true;
                        }
                        z = false;
                    }
                } else if (c3 == c4) {
                    if (c4 == '\"') {
                        i5++;
                    } else {
                        i4++;
                    }
                    int i6 = i3 + 1;
                    if (i6 < i) {
                        char c5 = cArr[i6];
                        if (Character.isLetterOrDigit(c5) || c5 <= ' ') {
                            char c6 = cArr[i3 - 1];
                            if (!Character.isLetterOrDigit(c6)) {
                                oxoX(hashMap2, c6);
                            }
                        }
                    }
                    c3 = 0;
                } else {
                    c3 = c4;
                }
                i3++;
                i2 = 1;
            }
            do {
                i3 += i2;
                if (i3 >= i || (c2 = cArr[i3]) == '\r' || c2 == '\n') {
                    break;
                }
            } while (c2 != this.f31035oxoX);
            i3++;
            i2 = 1;
        }
        if (i3 >= i && arrayList.size() > 1) {
            arrayList.remove(arrayList.size() - 1);
        }
        HashMap hashMap3 = new HashMap();
        HashSet hashSet2 = new HashSet();
        for (Map map : arrayList) {
            for (Map map2 : arrayList) {
                for (Character ch : hashSet) {
                    Integer num = (Integer) map.get(ch);
                    Integer num2 = (Integer) map2.get(ch);
                    if (num == null && num2 == null) {
                        hashSet2.add(ch);
                    }
                    if (num != null && num2 != null) {
                        X0o0xo(hashMap3, ch.charValue(), Math.abs(num.intValue() - num2.intValue()));
                    }
                }
            }
        }
        hashMap3.keySet().removeAll(hashSet2);
        char Oxx0IOOO2 = Oxx0IOOO(hashMap3, this.f31032I0Io);
        if (i5 >= i4) {
            c = '\"';
        } else {
            c = '\'';
        }
        hashMap2.remove(Character.valueOf(Oxx0IOOO2));
        II0xO0(Oxx0IOOO2, c, XO(hashMap2, c));
    }
}
