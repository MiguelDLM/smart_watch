package androidx.lifecycle;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import androidx.annotation.RestrictTo;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.OxI;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class Lifecycling {
    private static final int GENERATED_CALLBACK = 2;
    @OOXIXo
    public static final Lifecycling INSTANCE = new Lifecycling();
    private static final int REFLECTIVE_CALLBACK = 1;
    @OOXIXo
    private static final Map<Class<?>, Integer> callbackCache = new HashMap();
    @OOXIXo
    private static final Map<Class<?>, List<Constructor<? extends GeneratedAdapter>>> classToAdapters = new HashMap();

    private Lifecycling() {
    }

    private final GeneratedAdapter createGeneratedAdapter(Constructor<? extends GeneratedAdapter> constructor, Object obj) {
        try {
            Object newInstance = constructor.newInstance(new Object[]{obj});
            IIX0o.oO(newInstance, "{\n            constructo…tance(`object`)\n        }");
            return (GeneratedAdapter) newInstance;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    private final Constructor<? extends GeneratedAdapter> generatedConstructor(Class<?> cls) {
        String str;
        try {
            Package packageR = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            if (packageR != null) {
                str = packageR.getName();
            } else {
                str = "";
            }
            IIX0o.oO(str, "fullPackage");
            if (str.length() != 0) {
                IIX0o.oO(canonicalName, "name");
                canonicalName = canonicalName.substring(str.length() + 1);
                IIX0o.oO(canonicalName, "this as java.lang.String).substring(startIndex)");
            }
            IIX0o.oO(canonicalName, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
            String adapterName = getAdapterName(canonicalName);
            if (str.length() != 0) {
                adapterName = str + '.' + adapterName;
            }
            Class<?> cls2 = Class.forName(adapterName);
            IIX0o.x0XOIxOo(cls2, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
            Constructor<?> declaredConstructor = cls2.getDeclaredConstructor(new Class[]{cls});
            if (declaredConstructor.isAccessible()) {
                return declaredConstructor;
            }
            declaredConstructor.setAccessible(true);
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final String getAdapterName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "className");
        return OxI.IIOIX(str, FileUtils.FILE_EXTENSION_SEPARATOR, "_", false, 4, (Object) null) + "_LifecycleAdapter";
    }

    private final int getObserverConstructorType(Class<?> cls) {
        Map<Class<?>, Integer> map = callbackCache;
        Integer num = map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int resolveObserverCallbackType = resolveObserverCallbackType(cls);
        map.put(cls, Integer.valueOf(resolveObserverCallbackType));
        return resolveObserverCallbackType;
    }

    private final boolean isLifecycleParent(Class<?> cls) {
        if (cls == null || !LifecycleObserver.class.isAssignableFrom(cls)) {
            return false;
        }
        return true;
    }

    @x0XOIxOo
    @OOXIXo
    public static final LifecycleEventObserver lifecycleEventObserver(@OOXIXo Object obj) {
        IIX0o.x0xO0oo(obj, "object");
        boolean z = obj instanceof LifecycleEventObserver;
        boolean z2 = obj instanceof DefaultLifecycleObserver;
        if (z && z2) {
            return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) obj, (LifecycleEventObserver) obj);
        }
        if (z2) {
            return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) obj, (LifecycleEventObserver) null);
        }
        if (z) {
            return (LifecycleEventObserver) obj;
        }
        Class<?> cls = obj.getClass();
        Lifecycling lifecycling = INSTANCE;
        if (lifecycling.getObserverConstructorType(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List<Constructor<? extends GeneratedAdapter>> list = classToAdapters.get(cls);
        IIX0o.ooOOo0oXI(list);
        List list2 = list;
        if (list2.size() == 1) {
            return new SingleGeneratedAdapterObserver(lifecycling.createGeneratedAdapter((Constructor) list2.get(0), obj));
        }
        int size = list2.size();
        GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[size];
        for (int i = 0; i < size; i++) {
            generatedAdapterArr[i] = INSTANCE.createGeneratedAdapter((Constructor) list2.get(i), obj);
        }
        return new CompositeGeneratedAdaptersObserver(generatedAdapterArr);
    }

    private final int resolveObserverCallbackType(Class<?> cls) {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends GeneratedAdapter> generatedConstructor = generatedConstructor(cls);
        if (generatedConstructor != null) {
            classToAdapters.put(cls, oI0IIXIo.OOXIXo(generatedConstructor));
            return 2;
        } else if (ClassesInfoCache.sInstance.hasLifecycleMethods(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            if (isLifecycleParent(superclass)) {
                IIX0o.oO(superclass, "superclass");
                if (getObserverConstructorType(superclass) == 1) {
                    return 1;
                }
                List<Constructor<? extends GeneratedAdapter>> list = classToAdapters.get(superclass);
                IIX0o.ooOOo0oXI(list);
                arrayList = new ArrayList(list);
            } else {
                arrayList = null;
            }
            Class[] interfaces = cls.getInterfaces();
            IIX0o.oO(interfaces, "klass.interfaces");
            for (Class cls2 : interfaces) {
                if (isLifecycleParent(cls2)) {
                    IIX0o.oO(cls2, "intrface");
                    if (getObserverConstructorType(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    List<Constructor<? extends GeneratedAdapter>> list2 = classToAdapters.get(cls2);
                    IIX0o.ooOOo0oXI(list2);
                    arrayList.addAll(list2);
                }
            }
            if (arrayList == null) {
                return 1;
            }
            classToAdapters.put(cls, arrayList);
            return 2;
        }
    }
}
