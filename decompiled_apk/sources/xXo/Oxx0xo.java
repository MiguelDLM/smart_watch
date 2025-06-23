package xXo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes13.dex */
public class Oxx0xo implements Oxx0IOOO<Object, Object> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final String f34692II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Set<String> f34693oIX0oI;

    public Oxx0xo(String... strArr) {
        HashSet hashSet = new HashSet();
        this.f34693oIX0oI = hashSet;
        com.univocity.parsers.common.I0Io.x0xO0oo("Null representation strings", strArr);
        Collections.addAll(hashSet, strArr);
        this.f34692II0xO0 = strArr[0];
    }

    @Override // xXo.Oxx0IOOO
    public Object II0xO0(Object obj) {
        if (obj == null || this.f34693oIX0oI.contains(String.valueOf(obj))) {
            return null;
        }
        return obj;
    }

    @Override // xXo.Oxx0IOOO
    public Object oIX0oI(Object obj) {
        if (obj == null) {
            return this.f34692II0xO0;
        }
        return obj;
    }
}
