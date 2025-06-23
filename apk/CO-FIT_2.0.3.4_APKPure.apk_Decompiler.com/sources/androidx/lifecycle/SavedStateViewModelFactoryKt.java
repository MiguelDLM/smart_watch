package androidx.lifecycle;

import O0OOX0IIx.oxoX;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Application;
import androidx.annotation.RestrictTo;
import com.facebook.internal.NativeProtocol;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class SavedStateViewModelFactoryKt {
    /* access modifiers changed from: private */
    @OOXIXo
    public static final List<Class<?>> ANDROID_VIEWMODEL_SIGNATURE;
    /* access modifiers changed from: private */
    @OOXIXo
    public static final List<Class<?>> VIEWMODEL_SIGNATURE;

    static {
        Class<SavedStateHandle> cls = SavedStateHandle.class;
        ANDROID_VIEWMODEL_SIGNATURE = CollectionsKt__CollectionsKt.X00IoxXI(Application.class, cls);
        VIEWMODEL_SIGNATURE = oI0IIXIo.OOXIXo(cls);
    }

    @oOoXoXO
    public static final <T> Constructor<T> findMatchingConstructor(@OOXIXo Class<T> cls, @OOXIXo List<? extends Class<?>> list) {
        IIX0o.x0xO0oo(cls, "modelClass");
        IIX0o.x0xO0oo(list, oxoX.f12565Oxx0IOOO);
        Constructor<T>[] constructors = cls.getConstructors();
        IIX0o.oO(constructors, "modelClass.constructors");
        int length = constructors.length;
        int i = 0;
        while (i < length) {
            Constructor<T> constructor = constructors[i];
            Class[] parameterTypes = constructor.getParameterTypes();
            IIX0o.oO(parameterTypes, "constructor.parameterTypes");
            List IoXOX = ArraysKt___ArraysKt.IoXOX(parameterTypes);
            if (IIX0o.Oxx0IOOO(list, IoXOX)) {
                IIX0o.x0XOIxOo(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
                return constructor;
            } else if (list.size() != IoXOX.size() || !IoXOX.containsAll(list)) {
                i++;
            } else {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final <T extends ViewModel> T newInstance(@OOXIXo Class<T> cls, @OOXIXo Constructor<T> constructor, @OOXIXo Object... objArr) {
        IIX0o.x0xO0oo(cls, "modelClass");
        IIX0o.x0xO0oo(constructor, "constructor");
        IIX0o.x0xO0oo(objArr, NativeProtocol.WEB_DIALOG_PARAMS);
        try {
            return (ViewModel) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to access " + cls, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e3.getCause());
        }
    }
}
