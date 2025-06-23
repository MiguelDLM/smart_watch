package Xx0;

import Ox00XOXoo.XO;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes6.dex */
public class II0XooXoX {

    /* loaded from: classes6.dex */
    public static class oIX0oI implements InvocationHandler {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final Set<String> f4181IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final String f4182Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final Object f4183XO;

        public oIX0oI(Object obj, String str, String[] strArr) {
            this.f4183XO = obj;
            this.f4182Oo = str;
            this.f4181IXxxXO = new HashSet(Arrays.asList(strArr));
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (!this.f4181IXxxXO.isEmpty() && !this.f4181IXxxXO.contains(method.getName())) {
                return null;
            }
            if (oIX0oI(method)) {
                return XO.IIXOooo(this.f4183XO, this.f4182Oo, objArr);
            }
            return XO.OxxIIOOXO(this.f4183XO, this.f4182Oo);
        }

        public final boolean oIX0oI(Method method) {
            if (XO.II0xO0(this.f4183XO.getClass(), this.f4182Oo, method.getParameterTypes()) != null) {
                return true;
            }
            return false;
        }
    }

    public static <L> void II0xO0(Object obj, String str, Object obj2, Class<L> cls, String... strArr) {
        oIX0oI(obj2, cls, cls.cast(Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[]{cls}, new oIX0oI(obj, str, strArr))));
    }

    public static <L> void oIX0oI(Object obj, Class<L> cls, L l) {
        try {
            XO.IIXOooo(obj, "add" + cls.getSimpleName(), l);
        } catch (IllegalAccessException unused) {
            throw new IllegalArgumentException("Class " + obj.getClass().getName() + " does not have an accessible add" + cls.getSimpleName() + " method which takes a parameter of type " + cls.getName() + FileUtils.FILE_EXTENSION_SEPARATOR);
        } catch (NoSuchMethodException unused2) {
            throw new IllegalArgumentException("Class " + obj.getClass().getName() + " does not have a public add" + cls.getSimpleName() + " method which takes a parameter of type " + cls.getName() + FileUtils.FILE_EXTENSION_SEPARATOR);
        } catch (InvocationTargetException e) {
            throw new RuntimeException("Unable to add listener.", e.getCause());
        }
    }
}
