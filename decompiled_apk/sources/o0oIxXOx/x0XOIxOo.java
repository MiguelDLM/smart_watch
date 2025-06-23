package o0oIxXOx;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes6.dex */
public class x0XOIxOo extends oIX0oI {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final oIX0oI f31198X0o0xo = new x0XOIxOo();

    /* renamed from: XO, reason: collision with root package name */
    public static final char f31199XO = ':';

    /* renamed from: I0Io, reason: collision with root package name */
    public final OxxIIOOXO f31200I0Io;

    /* renamed from: oxoX, reason: collision with root package name */
    public final Map<String, OxxIIOOXO> f31201oxoX;

    public x0XOIxOo() {
        this((Map) null);
    }

    public static String II0XooXoX(String str) {
        return str.toLowerCase(Locale.ROOT);
    }

    public Map<String, OxxIIOOXO> Oxx0IOOO() {
        return this.f31201oxoX;
    }

    @Override // o0oIxXOx.OxxIIOOXO
    public String lookup(String str) {
        String str2;
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(58);
        if (indexOf >= 0) {
            String II0XooXoX2 = II0XooXoX(str.substring(0, indexOf));
            int i = indexOf + 1;
            String substring = str.substring(i);
            OxxIIOOXO oxxIIOOXO = this.f31201oxoX.get(II0XooXoX2);
            if (oxxIIOOXO != null) {
                str2 = oxxIIOOXO.lookup(substring);
            } else {
                str2 = null;
            }
            if (str2 != null) {
                return str2;
            }
            str = str.substring(i);
        }
        OxxIIOOXO oxxIIOOXO2 = this.f31200I0Io;
        if (oxxIIOOXO2 == null) {
            return null;
        }
        return oxxIIOOXO2.lookup(str);
    }

    public String toString() {
        return super.toString() + " [stringLookupMap=" + this.f31201oxoX + ", defaultStringLookup=" + this.f31200I0Io + "]";
    }

    public x0XOIxOo(Map<String, OxxIIOOXO> map, OxxIIOOXO oxxIIOOXO, boolean z) {
        this.f31200I0Io = oxxIIOOXO;
        this.f31201oxoX = new HashMap(map.size());
        for (Map.Entry<String, OxxIIOOXO> entry : map.entrySet()) {
            this.f31201oxoX.put(II0XooXoX(entry.getKey()), entry.getValue());
        }
        if (z) {
            XIxXXX0x0.f31171oIX0oI.oxoX(this.f31201oxoX);
        }
    }

    public <V> x0XOIxOo(Map<String, V> map) {
        this(XIxXXX0x0.f31171oIX0oI.OxI(map == null ? new HashMap<>() : map));
    }

    public x0XOIxOo(OxxIIOOXO oxxIIOOXO) {
        this(new HashMap(), oxxIIOOXO, true);
    }
}
