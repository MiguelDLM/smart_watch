package com.angcyo.dsladapter.internal;

import android.text.TextUtils;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public interface ooOOo0oXI<T> {

    /* loaded from: classes7.dex */
    public static final class oIX0oI {
        @OXOo.oOoXoXO
        public static <T> Object I0Io(@OXOo.OOXIXo ooOOo0oXI<T> ooooo0oxi, @OXOo.OOXIXo T oldData, @OXOo.OOXIXo T newData, int i, int i2) {
            IIX0o.x0xO0oo(oldData, "oldData");
            IIX0o.x0xO0oo(newData, "newData");
            return null;
        }

        public static <T> boolean II0xO0(@OXOo.OOXIXo ooOOo0oXI<T> ooooo0oxi, @OXOo.OOXIXo T oldData, @OXOo.OOXIXo T newData, int i, int i2) {
            IIX0o.x0xO0oo(oldData, "oldData");
            IIX0o.x0xO0oo(newData, "newData");
            if (TextUtils.equals(oldData.getClass().getSimpleName(), newData.getClass().getSimpleName()) && i == i2) {
                return true;
            }
            return false;
        }

        public static <T> boolean oIX0oI(@OXOo.OOXIXo ooOOo0oXI<T> ooooo0oxi, @OXOo.OOXIXo T oldData, @OXOo.OOXIXo T newData, int i, int i2) {
            IIX0o.x0xO0oo(oldData, "oldData");
            IIX0o.x0xO0oo(newData, "newData");
            Class<?> cls = oldData.getClass();
            Class<?> cls2 = newData.getClass();
            if (!cls.isAssignableFrom(cls2) && !cls2.isAssignableFrom(cls) && !TextUtils.equals(cls.getSimpleName(), cls2.getSimpleName())) {
                return false;
            }
            return IIX0o.Oxx0IOOO(oldData, newData);
        }
    }

    boolean I0Io(@OXOo.OOXIXo T t, @OXOo.OOXIXo T t2, int i, int i2);

    boolean II0xO0(@OXOo.OOXIXo T t, @OXOo.OOXIXo T t2, int i, int i2);

    @OXOo.oOoXoXO
    Object oIX0oI(@OXOo.OOXIXo T t, @OXOo.OOXIXo T t2, int i, int i2);
}
