package OXIOoo0X0;

import com.univocity.parsers.common.DataProcessingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes13.dex */
public abstract class oIX0oI<T> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final List<xoIox> f2000II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Map<xoIox, xXo.Oxx0IOOO<String, ?>[]> f2001oIX0oI;

    public oIX0oI(List<xoIox> list) {
        this.f2000II0xO0 = list;
    }

    public static void X0o0xo(xoIox xoiox, List<xXo.Oxx0IOOO<?, ?>> list, xXo.Oxx0IOOO<?, ?>[] oxx0IOOOArr) {
        for (xXo.Oxx0IOOO<?, ?> oxx0IOOO : oxx0IOOOArr) {
            Iterator<xXo.Oxx0IOOO<?, ?>> it = list.iterator();
            while (it.hasNext()) {
                if (oxx0IOOO == it.next()) {
                    throw new DataProcessingException("Duplicate conversion " + oxx0IOOO.getClass().getName() + " being applied to " + xoiox.oIX0oI());
                }
            }
        }
    }

    public void I0Io(boolean z, xoIox xoiox, Map<Integer, List<xXo.Oxx0IOOO<?, ?>>> map, String[] strArr) {
        xXo.Oxx0IOOO<String, ?>[] oxx0IOOOArr;
        Map<xoIox, xXo.Oxx0IOOO<String, ?>[]> map2 = this.f2001oIX0oI;
        if (map2 == null || (oxx0IOOOArr = map2.get(xoiox)) == null) {
            return;
        }
        if (!z && (strArr == null || this.f2001oIX0oI.size() > strArr.length)) {
            Iterator<xoIox> it = this.f2001oIX0oI.keySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    xoIox next = it.next();
                    if (!(next instanceof xxIXOIIO) && !(next instanceof Oxx0IOOO)) {
                        break;
                    }
                } else if (strArr != null) {
                    int length = strArr.length;
                    strArr = (String[]) Arrays.copyOf(strArr, this.f2001oIX0oI.size() + 1);
                    Iterator<xoIox> it2 = this.f2001oIX0oI.keySet().iterator();
                    while (it2.hasNext()) {
                        List<T> XO2 = ((OOXIXo) ((xoIox) it2.next())).XO();
                        if (XO2.size() == 1) {
                            String Oo2 = com.univocity.parsers.common.I0Io.Oo(XO2.get(0).toString());
                            if (com.univocity.parsers.common.I0Io.I0Io(strArr, Oo2) == -1) {
                                int i = length + 1;
                                strArr[length] = Oo2;
                                if (i == strArr.length) {
                                    break;
                                } else {
                                    length = i;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
            }
        }
        int[] II0xO02 = xoiox.II0xO0(strArr);
        if (II0xO02 == null) {
            II0xO02 = com.univocity.parsers.common.I0Io.xoXoI(map.keySet());
        }
        for (int i2 : II0xO02) {
            List<xXo.Oxx0IOOO<?, ?>> list = map.get(Integer.valueOf(i2));
            if (list == null) {
                list = new ArrayList<>();
                map.put(Integer.valueOf(i2), list);
            }
            X0o0xo(xoiox, list, oxx0IOOOArr);
            list.addAll(Arrays.asList(oxx0IOOOArr));
        }
    }

    public abstract xoIox II0xO0();

    public boolean oIX0oI() {
        Map<xoIox, xXo.Oxx0IOOO<String, ?>[]> map = this.f2001oIX0oI;
        if (map != null && !map.isEmpty()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OOXIXo<T> oxoX(xXo.Oxx0IOOO<String, ?>... oxx0IOOOArr) {
        com.univocity.parsers.common.I0Io.x0xO0oo("Conversions", oxx0IOOOArr);
        Object II0xO02 = II0xO0();
        if (this.f2001oIX0oI == null) {
            this.f2001oIX0oI = new LinkedHashMap();
        }
        this.f2001oIX0oI.put(II0xO02, oxx0IOOOArr);
        this.f2000II0xO0.add(II0xO02);
        if (II0xO02 instanceof OOXIXo) {
            return (OOXIXo) II0xO02;
        }
        return null;
    }
}
