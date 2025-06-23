package X0;

import kotlin.IIX0;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;

/* loaded from: classes6.dex */
public class OxxIIOOXO {
    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Object;R::LX0/Oxx0xo<TT;>;:Ljava/lang/Iterable<+TT;>;>(TR;TT;)Z */
    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.9")
    public static final boolean I0Io(Oxx0xo oxx0xo, Object obj) {
        IIX0o.x0xO0oo(oxx0xo, "<this>");
        if (obj != null && oxx0xo.contains((Comparable) obj)) {
            return true;
        }
        return false;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.9")
    public static Oxx0xo<Float> II0XooXoX(float f, float f2) {
        return new IXxxXO(f, f2);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Object;R::LX0/Oxx0IOOO<TT;>;:Ljava/lang/Iterable<+TT;>;>(TR;TT;)Z */
    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final boolean II0xO0(Oxx0IOOO oxx0IOOO, Object obj) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        if (obj != null && oxx0IOOO.contains((Comparable) obj)) {
            return true;
        }
        return false;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.9")
    public static final Oxx0xo<Double> Oxx0IOOO(double d, double d2) {
        return new x0xO0oo(d, d2);
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.1")
    public static final XO<Float> X0o0xo(float f, float f2) {
        return new X0o0xo(f, f2);
    }

    @OXOo.OOXIXo
    public static final <T extends Comparable<? super T>> Oxx0IOOO<T> XO(@OXOo.OOXIXo T t, @OXOo.OOXIXo T that) {
        IIX0o.x0xO0oo(t, "<this>");
        IIX0o.x0xO0oo(that, "that");
        return new xxIXOIIO(t, that);
    }

    public static final void oIX0oI(boolean z, @OXOo.OOXIXo Number step) {
        IIX0o.x0xO0oo(step, "step");
        if (z) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + step + '.');
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.1")
    public static final XO<Double> oxoX(double d, double d2) {
        return new oxoX(d, d2);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.9")
    public static final <T extends Comparable<? super T>> Oxx0xo<T> xxIXOIIO(@OXOo.OOXIXo T t, @OXOo.OOXIXo T that) {
        IIX0o.x0xO0oo(t, "<this>");
        IIX0o.x0xO0oo(that, "that");
        return new II0XooXoX(t, that);
    }
}
