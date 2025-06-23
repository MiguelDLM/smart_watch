package IxI;

import com.univocity.parsers.fixed.FieldAlignment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes13.dex */
public class ooOOo0oXI {

    /* renamed from: I0Io, reason: collision with root package name */
    public final FieldAlignment[] f1078I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int[] f1079II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final String[] f1080X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final char[] f1081oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final char[] f1082oxoX;

    /* loaded from: classes13.dex */
    public static class oIX0oI implements Comparator<ooOOo0oXI> {
        @Override // java.util.Comparator
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public int compare(ooOOo0oXI ooooo0oxi, ooOOo0oXI ooooo0oxi2) {
            char[] cArr = ooooo0oxi.f1081oIX0oI;
            int length = cArr.length;
            char[] cArr2 = ooooo0oxi2.f1081oIX0oI;
            if (length < cArr2.length) {
                return 1;
            }
            if (cArr.length == cArr2.length) {
                return 0;
            }
            return -1;
        }
    }

    public ooOOo0oXI(String str, XO xo2, Oxx0IOOO oxx0IOOO) {
        this.f1081oIX0oI = str.toCharArray();
        this.f1079II0xO0 = xo2.oOoXoXO();
        this.f1078I0Io = xo2.OOXIXo();
        this.f1080X0o0xo = xo2.ooOOo0oXI();
        this.f1082oxoX = xo2.oO(oxx0IOOO);
    }

    public static ooOOo0oXI[] I0Io(Map<String, XO> map, Oxx0IOOO oxx0IOOO) {
        if (map.isEmpty()) {
            return null;
        }
        ooOOo0oXI[] ooooo0oxiArr = new ooOOo0oXI[map.size()];
        int i = 0;
        for (Map.Entry<String, XO> entry : map.entrySet()) {
            ooooo0oxiArr[i] = new ooOOo0oXI(entry.getKey(), entry.getValue(), oxx0IOOO);
            i++;
        }
        Arrays.sort(ooooo0oxiArr, new oIX0oI());
        return ooooo0oxiArr;
    }

    public static int II0xO0(ooOOo0oXI[]... ooooo0oxiArr) {
        int i = 0;
        for (ooOOo0oXI[] ooooo0oxiArr2 : ooooo0oxiArr) {
            if (ooooo0oxiArr2 != null) {
                for (ooOOo0oXI ooooo0oxi : ooooo0oxiArr2) {
                    char[] cArr = ooooo0oxi.f1081oIX0oI;
                    if (i < cArr.length) {
                        i = cArr.length;
                    }
                }
            }
        }
        return i;
    }

    public static void Oxx0IOOO(String str, String str2, XO xo2, Map<String, XO> map) {
        if (str2 != null && !str2.trim().isEmpty()) {
            if (xo2 != null) {
                map.put(str2, xo2);
                return;
            }
            throw new IllegalArgumentException("Lengths of fields associated to look" + str + " value '" + str2 + "' cannot be null");
        }
        throw new IllegalArgumentException("Look" + str + " value cannot be null");
    }

    public static void X0o0xo(String str, XO xo2, Map<String, XO> map) {
        Oxx0IOOO("ahead", str, xo2, map);
    }

    public static void XO(String str, XO xo2, Map<String, XO> map) {
        Oxx0IOOO("behind", str, xo2, map);
    }

    public static int[] oIX0oI(XO xo2, Map<String, XO> map, Map<String, XO> map2) {
        int i;
        ArrayList<int[]> arrayList = new ArrayList();
        if (xo2 != null) {
            arrayList.add(xo2.oOoXoXO());
        }
        Iterator<XO> it = map.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().oOoXoXO());
        }
        Iterator<XO> it2 = map2.values().iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().oOoXoXO());
        }
        if (!arrayList.isEmpty()) {
            int i2 = -1;
            for (int[] iArr : arrayList) {
                if (i2 < iArr.length) {
                    i2 = iArr.length;
                }
            }
            int[] iArr2 = new int[i2];
            Arrays.fill(iArr2, 0);
            for (int[] iArr3 : arrayList) {
                for (int i3 = 0; i3 < i2; i3++) {
                    if (i3 < iArr3.length && iArr2[i3] < (i = iArr3[i3])) {
                        iArr2[i3] = i;
                    }
                }
            }
            return iArr2;
        }
        throw new IllegalStateException("Cannot determine field lengths to use.");
    }

    public boolean oxoX(char[] cArr) {
        if (this.f1081oIX0oI.length > cArr.length) {
            return false;
        }
        int i = 0;
        while (true) {
            char[] cArr2 = this.f1081oIX0oI;
            if (i < cArr2.length) {
                if (cArr2[i] != cArr[i]) {
                    return false;
                }
                i++;
            } else {
                return true;
            }
        }
    }
}
