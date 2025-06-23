package com.google.common.base;

import XIXIX.OOXIXo;
import com.google.common.annotations.GwtIncompatible;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public final class Defaults {
    private static final Double DOUBLE_DEFAULT = Double.valueOf(OOXIXo.f3760XO);
    private static final Float FLOAT_DEFAULT = Float.valueOf(0.0f);

    private Defaults() {
    }

    @CheckForNull
    public static <T> T defaultValue(Class<T> cls) {
        Preconditions.checkNotNull(cls);
        if (cls.isPrimitive()) {
            if (cls == Boolean.TYPE) {
                return (T) Boolean.FALSE;
            }
            if (cls == Character.TYPE) {
                return (T) (char) 0;
            }
            if (cls == Byte.TYPE) {
                return (T) (byte) 0;
            }
            if (cls == Short.TYPE) {
                return (T) (short) 0;
            }
            if (cls == Integer.TYPE) {
                return (T) 0;
            }
            if (cls == Long.TYPE) {
                return (T) 0L;
            }
            if (cls == Float.TYPE) {
                return (T) FLOAT_DEFAULT;
            }
            if (cls == Double.TYPE) {
                return (T) DOUBLE_DEFAULT;
            }
            return null;
        }
        return null;
    }
}
