package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class SavedStateViewModelFactoryKt {

    @OXOo.OOXIXo
    private static final List<Class<?>> ANDROID_VIEWMODEL_SIGNATURE = CollectionsKt__CollectionsKt.X00IoxXI(Application.class, SavedStateHandle.class);

    @OXOo.OOXIXo
    private static final List<Class<?>> VIEWMODEL_SIGNATURE = oI0IIXIo.OOXIXo(SavedStateHandle.class);

    public static final /* synthetic */ List access$getANDROID_VIEWMODEL_SIGNATURE$p() {
        return ANDROID_VIEWMODEL_SIGNATURE;
    }

    public static final /* synthetic */ List access$getVIEWMODEL_SIGNATURE$p() {
        return VIEWMODEL_SIGNATURE;
    }

    @OXOo.oOoXoXO
    public static final <T> Constructor<T> findMatchingConstructor(@OXOo.OOXIXo Class<T> modelClass, @OXOo.OOXIXo List<? extends Class<?>> signature) {
        IIX0o.x0xO0oo(modelClass, "modelClass");
        IIX0o.x0xO0oo(signature, "signature");
        Object[] constructors = modelClass.getConstructors();
        IIX0o.oO(constructors, "modelClass.constructors");
        for (Object obj : constructors) {
            Constructor<T> constructor = (Constructor<T>) obj;
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            IIX0o.oO(parameterTypes, "constructor.parameterTypes");
            List IoXOX = ArraysKt___ArraysKt.IoXOX(parameterTypes);
            if (IIX0o.Oxx0IOOO(signature, IoXOX)) {
                IIX0o.x0XOIxOo(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
                return constructor;
            }
            if (signature.size() == IoXOX.size() && IoXOX.containsAll(signature)) {
                throw new UnsupportedOperationException("Class " + modelClass.getSimpleName() + " must have parameters in the proper order: " + signature);
            }
        }
        return null;
    }

    public static final <T extends ViewModel> T newInstance(@OXOo.OOXIXo Class<T> modelClass, @OXOo.OOXIXo Constructor<T> constructor, @OXOo.OOXIXo Object... params) {
        IIX0o.x0xO0oo(modelClass, "modelClass");
        IIX0o.x0xO0oo(constructor, "constructor");
        IIX0o.x0xO0oo(params, "params");
        try {
            return constructor.newInstance(Arrays.copyOf(params, params.length));
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to access " + modelClass, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("A " + modelClass + " cannot be instantiated.", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("An exception happened in constructor of " + modelClass, e3.getCause());
        }
    }
}
