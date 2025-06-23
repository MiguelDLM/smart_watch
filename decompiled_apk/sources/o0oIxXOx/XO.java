package o0oIxXOx;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.ClassUtils;

/* loaded from: classes6.dex */
public class XO extends oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f31181I0Io = new ConcurrentHashMap<>();

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final XO f31182X0o0xo = new XO();

    /* renamed from: oxoX, reason: collision with root package name */
    public static final char f31183oxoX = '.';

    public static void Oxx0IOOO() {
        f31181I0Io.clear();
    }

    public Class<?> II0XooXoX(String str) throws ClassNotFoundException {
        return ClassUtils.Oo(str);
    }

    @Override // o0oIxXOx.OxxIIOOXO
    public synchronized String lookup(String str) {
        if (str == null) {
            return null;
        }
        ConcurrentHashMap<String, String> concurrentHashMap = f31181I0Io;
        String str2 = concurrentHashMap.get(str);
        if (str2 != null) {
            return str2;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return null;
        }
        try {
            Object xxIXOIIO2 = xxIXOIIO(str.substring(0, lastIndexOf), str.substring(lastIndexOf + 1));
            if (xxIXOIIO2 != null) {
                str2 = Objects.toString(xxIXOIIO2, null);
                concurrentHashMap.put(str, str2);
            }
            return str2;
        } catch (Exception unused) {
            return null;
        }
    }

    public Object xxIXOIIO(String str, String str2) throws Exception {
        Class<?> II0XooXoX2 = II0XooXoX(str);
        if (II0XooXoX2 == null) {
            return null;
        }
        return II0XooXoX2.getField(str2).get(null);
    }
}
