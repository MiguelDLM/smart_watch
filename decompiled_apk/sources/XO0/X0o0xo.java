package XO0;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes6.dex */
public class X0o0xo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Map<I0Io, CopyOnWriteArrayList<Oxx0IOOO>> f3857oIX0oI;

    public X0o0xo(Map<I0Io, CopyOnWriteArrayList<Oxx0IOOO>> map) {
        this.f3857oIX0oI = map;
    }

    public final boolean I0Io(Object obj, Object obj2) {
        if (obj != null && obj.equals(obj2)) {
            return true;
        }
        return false;
    }

    public void II0xO0(Object obj) {
        Class<?>[] parameterTypes;
        if (this.f3857oIX0oI != null) {
            for (Class<?> cls = obj.getClass(); cls != null && !oxoX(cls.getName()); cls = cls.getSuperclass()) {
                for (Method method : cls.getDeclaredMethods()) {
                    XO xo2 = (XO) method.getAnnotation(XO.class);
                    if (xo2 != null && (parameterTypes = method.getParameterTypes()) != null && parameterTypes.length == 1) {
                        I0Io i0Io = new I0Io(oIX0oI(parameterTypes[0]), xo2.tag());
                        XO(i0Io, new II0XooXoX(method, i0Io, xo2.mode()), obj);
                    }
                }
            }
            return;
        }
        throw new NullPointerException("the mSubcriberMap is null. ");
    }

    public void X0o0xo(Object obj) {
        Iterator<CopyOnWriteArrayList<Oxx0IOOO>> it = this.f3857oIX0oI.values().iterator();
        while (it.hasNext()) {
            CopyOnWriteArrayList<Oxx0IOOO> next = it.next();
            if (next != null) {
                LinkedList linkedList = new LinkedList();
                Iterator<Oxx0IOOO> it2 = next.iterator();
                while (it2.hasNext()) {
                    Oxx0IOOO next2 = it2.next();
                    Object obj2 = next2.f3855oIX0oI.get();
                    if (I0Io(obj2, obj) || obj2 == null) {
                        linkedList.add(next2);
                    }
                }
                next.removeAll(linkedList);
            }
            if (next == null || next.size() == 0) {
                it.remove();
            }
        }
    }

    public final void XO(I0Io i0Io, II0XooXoX iI0XooXoX, Object obj) {
        CopyOnWriteArrayList<Oxx0IOOO> copyOnWriteArrayList = this.f3857oIX0oI.get(i0Io);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        }
        Oxx0IOOO oxx0IOOO = new Oxx0IOOO(obj, iI0XooXoX);
        if (copyOnWriteArrayList.contains(oxx0IOOO)) {
            return;
        }
        copyOnWriteArrayList.add(oxx0IOOO);
        this.f3857oIX0oI.put(i0Io, copyOnWriteArrayList);
    }

    public final Class<?> oIX0oI(Class<?> cls) {
        if (cls.equals(Boolean.TYPE)) {
            return Boolean.class;
        }
        if (cls.equals(Integer.TYPE)) {
            return Integer.class;
        }
        if (cls.equals(Float.TYPE)) {
            return Float.class;
        }
        if (cls.equals(Double.TYPE)) {
            return Double.class;
        }
        return cls;
    }

    public final boolean oxoX(String str) {
        if (!str.startsWith("java.") && !str.startsWith("javax.") && !str.startsWith("android.")) {
            return false;
        }
        return true;
    }
}
