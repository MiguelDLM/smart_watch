package xOoIIIoXI;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import kotlin.IIX0;
import kotlin.IXxxXO;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.Xo0;
import kotlin.collections.oI0IIXIo;
import kotlin.collections.oX;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.ooOOo0oXI;

/* loaded from: classes6.dex */
public final class oIX0oI {
    @IIX0(markerClass = {IXxxXO.class})
    @oxxXoxO(version = "1.8")
    public static final <T> T I0Io(@OOXIXo Optional<? extends T> optional, @OOXIXo Oox.oIX0oI<? extends T> defaultValue) {
        boolean isPresent;
        Object obj;
        IIX0o.x0xO0oo(optional, "<this>");
        IIX0o.x0xO0oo(defaultValue, "defaultValue");
        isPresent = optional.isPresent();
        if (isPresent) {
            obj = optional.get();
            return (T) obj;
        }
        return defaultValue.invoke();
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oxxXoxO(version = "1.8")
    public static final <T> T II0xO0(@OOXIXo Optional<? extends T> optional, T t) {
        boolean isPresent;
        Object obj;
        IIX0o.x0xO0oo(optional, "<this>");
        isPresent = optional.isPresent();
        if (isPresent) {
            obj = optional.get();
            return (T) obj;
        }
        return t;
    }

    @IIX0(markerClass = {IXxxXO.class})
    @OOXIXo
    @oxxXoxO(version = "1.8")
    public static final <T> Set<T> Oxx0IOOO(@OOXIXo Optional<? extends T> optional) {
        boolean isPresent;
        Object obj;
        IIX0o.x0xO0oo(optional, "<this>");
        isPresent = optional.isPresent();
        if (isPresent) {
            obj = optional.get();
            return oX.XO(obj);
        }
        return Xo0.OOXIXo();
    }

    @IIX0(markerClass = {IXxxXO.class})
    @OOXIXo
    @oxxXoxO(version = "1.8")
    public static final <T, C extends Collection<? super T>> C X0o0xo(@OOXIXo Optional<T> optional, @OOXIXo C destination) {
        boolean isPresent;
        Object obj;
        IIX0o.x0xO0oo(optional, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        isPresent = optional.isPresent();
        if (isPresent) {
            obj = optional.get();
            IIX0o.oO(obj, "get(...)");
            destination.add(obj);
        }
        return destination;
    }

    @IIX0(markerClass = {IXxxXO.class})
    @OOXIXo
    @oxxXoxO(version = "1.8")
    public static final <T> List<T> XO(@OOXIXo Optional<? extends T> optional) {
        boolean isPresent;
        Object obj;
        IIX0o.x0xO0oo(optional, "<this>");
        isPresent = optional.isPresent();
        if (isPresent) {
            obj = optional.get();
            return oI0IIXIo.OOXIXo(obj);
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @IIX0(markerClass = {IXxxXO.class})
    @OOXIXo
    @oxxXoxO(version = "1.8")
    public static final <T> ooOOo0oXI<T> oIX0oI(@OOXIXo Optional<? extends T> optional) {
        boolean isPresent;
        Object obj;
        IIX0o.x0xO0oo(optional, "<this>");
        isPresent = optional.isPresent();
        if (isPresent) {
            obj = optional.get();
            return SequencesKt__SequencesKt.Oo(obj);
        }
        return SequencesKt__SequencesKt.Oxx0IOOO();
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oxxXoxO(version = "1.8")
    @oOoXoXO
    public static final <T> T oxoX(@OOXIXo Optional<T> optional) {
        Object orElse;
        IIX0o.x0xO0oo(optional, "<this>");
        orElse = optional.orElse(null);
        return (T) orElse;
    }
}
