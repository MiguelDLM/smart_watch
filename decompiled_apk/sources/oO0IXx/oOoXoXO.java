package oO0IXx;

import com.univocity.parsers.common.DataProcessingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes13.dex */
public class oOoXoXO<T> {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f31940I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public String[] f31941II0xO0 = null;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public long f31942X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public List<List<T>> f31943oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public long f31944oxoX;

    public oOoXoXO(int i) {
        this.f31940I0Io = 1000;
        if (i > 0) {
            this.f31940I0Io = i;
            return;
        }
        throw new IllegalArgumentException("Expected row count must be positive");
    }

    public List<List<T>> I0Io() {
        return this.f31943oIX0oI;
    }

    public String II0XooXoX(int i) {
        String[] strArr = this.f31941II0xO0;
        if (i < strArr.length) {
            return strArr[i];
        }
        return null;
    }

    public void II0xO0() {
        this.f31942X0o0xo = this.f31944oxoX;
        this.f31943oIX0oI = null;
    }

    public void OOXIXo(Map<Integer, List<T>> map) {
        if (this.f31943oIX0oI == null) {
            return;
        }
        for (int i = 0; i < this.f31943oIX0oI.size(); i++) {
            map.put(Integer.valueOf(i), this.f31943oIX0oI.get(i));
        }
    }

    public Map<String, List<T>> Oxx0IOOO() {
        HashMap hashMap = new HashMap();
        oOoXoXO(hashMap);
        return hashMap;
    }

    public <V> List<V> X0o0xo(String str, Class<V> cls) {
        int I0Io2 = com.univocity.parsers.common.I0Io.I0Io(this.f31941II0xO0, str);
        if (I0Io2 != -1) {
            return oxoX(I0Io2, cls);
        }
        throw new IllegalArgumentException("No column named '" + str + "' has been found. Available column headers: " + Arrays.toString(this.f31941II0xO0));
    }

    public Map<Integer, List<T>> XO() {
        HashMap hashMap = new HashMap();
        OOXIXo(hashMap);
        return hashMap;
    }

    public void oIX0oI(T[] tArr, com.univocity.parsers.common.oO oOVar) {
        if (this.f31943oIX0oI == null) {
            xoIox(oOVar);
        }
        if (this.f31943oIX0oI.size() < tArr.length) {
            int length = tArr.length - this.f31943oIX0oI.size();
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    break;
                }
                long xoIox2 = oOVar.xoIox() - this.f31942X0o0xo;
                int i2 = this.f31940I0Io;
                if (i2 < xoIox2) {
                    i2 = (int) xoIox2;
                }
                ArrayList arrayList = new ArrayList(i2);
                while (true) {
                    xoIox2--;
                    if (xoIox2 > 0) {
                        arrayList.add(null);
                    }
                }
                this.f31943oIX0oI.add(arrayList);
                length = i;
            }
        }
        for (int i3 = 0; i3 < tArr.length; i3++) {
            this.f31943oIX0oI.get(i3).add(tArr[i3]);
        }
        if (tArr.length < this.f31943oIX0oI.size()) {
            for (int length2 = tArr.length; length2 < this.f31943oIX0oI.size(); length2++) {
                this.f31943oIX0oI.get(length2).add(null);
            }
        }
        this.f31944oxoX++;
    }

    public void oOoXoXO(Map<String, List<T>> map) {
        if (this.f31943oIX0oI == null) {
            return;
        }
        for (int i = 0; i < this.f31943oIX0oI.size(); i++) {
            String II0XooXoX2 = II0XooXoX(i);
            if (II0XooXoX2 != null) {
                map.put(II0XooXoX2, this.f31943oIX0oI.get(i));
            } else {
                throw new DataProcessingException("Parsed input does not have header for column at index '" + i + "'. Parsed header names: " + Arrays.toString(xxIXOIIO()), i);
            }
        }
    }

    public void ooOOo0oXI() {
        this.f31943oIX0oI = null;
        this.f31941II0xO0 = null;
        this.f31942X0o0xo = 0L;
        this.f31944oxoX = 0L;
    }

    public <V> List<V> oxoX(int i, Class<V> cls) {
        if (i >= 0) {
            if (i < this.f31943oIX0oI.size()) {
                return this.f31943oIX0oI.get(i);
            }
            throw new IllegalArgumentException("Column index must be less than " + this.f31943oIX0oI.size() + ". Got " + i);
        }
        throw new IllegalArgumentException("Column index must be positive");
    }

    public final void xoIox(com.univocity.parsers.common.oO oOVar) {
        int i;
        if (this.f31941II0xO0 == null) {
            String[] X0o0xo2 = oOVar.X0o0xo();
            if (X0o0xo2 == null) {
                this.f31941II0xO0 = com.univocity.parsers.common.I0Io.f27012oIX0oI;
            } else if (!oOVar.oOoXoXO()) {
                this.f31941II0xO0 = X0o0xo2;
            } else {
                int[] x0XOIxOo2 = oOVar.x0XOIxOo();
                int min = Math.min(X0o0xo2.length, x0XOIxOo2.length);
                this.f31941II0xO0 = new String[x0XOIxOo2.length];
                for (int i2 = 0; i2 < min; i2++) {
                    this.f31941II0xO0[i2] = X0o0xo2[x0XOIxOo2[i2]];
                }
            }
        }
        String[] strArr = this.f31941II0xO0;
        if (strArr.length > 0) {
            i = strArr.length;
        } else {
            i = 10;
        }
        this.f31943oIX0oI = new ArrayList(i);
    }

    public String[] xxIXOIIO() {
        return this.f31941II0xO0;
    }
}
