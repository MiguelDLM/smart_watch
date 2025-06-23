package xX0ox;

import com.goodix.ble.gr.libdfu.BuildConfig;
import java.util.Comparator;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;

/* loaded from: classes6.dex */
public class xxIXOIIO extends II0XooXoX {
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> T I0(T t, @OXOo.OOXIXo T[] other, @OXOo.OOXIXo Comparator<? super T> comparator) {
        IIX0o.x0xO0oo(other, "other");
        IIX0o.x0xO0oo(comparator, "comparator");
        for (T t2 : other) {
            if (comparator.compare(t, t2) < 0) {
                t = t2;
            }
        }
        return t;
    }

    @oxxXoxO(version = "1.1")
    public static final <T> T IIxOXoOo0(T t, T t2, @OXOo.OOXIXo Comparator<? super T> comparator) {
        IIX0o.x0xO0oo(comparator, "comparator");
        if (comparator.compare(t, t2) < 0) {
            return t2;
        }
        return t;
    }

    @oxxXoxO(version = "1.1")
    public static final <T> T OOXIxO0(T t, T t2, T t3, @OXOo.OOXIXo Comparator<? super T> comparator) {
        IIX0o.x0xO0oo(comparator, "comparator");
        return (T) IIxOXoOo0(t, IIxOXoOo0(t2, t3, comparator), comparator);
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> T OX00O0xII(T t, @OXOo.OOXIXo T[] other, @OXOo.OOXIXo Comparator<? super T> comparator) {
        IIX0o.x0xO0oo(other, "other");
        IIX0o.x0xO0oo(comparator, "comparator");
        for (T t2 : other) {
            if (comparator.compare(t, t2) > 0) {
                t = t2;
            }
        }
        return t;
    }

    @oxxXoxO(version = "1.1")
    public static final <T> T ooOx(T t, T t2, T t3, @OXOo.OOXIXo Comparator<? super T> comparator) {
        IIX0o.x0xO0oo(comparator, "comparator");
        return (T) xoO0xx0(t, xoO0xx0(t2, t3, comparator), comparator);
    }

    @oxxXoxO(version = "1.1")
    public static final <T> T xoO0xx0(T t, T t2, @OXOo.OOXIXo Comparator<? super T> comparator) {
        IIX0o.x0xO0oo(comparator, "comparator");
        if (comparator.compare(t, t2) > 0) {
            return t2;
        }
        return t;
    }
}
