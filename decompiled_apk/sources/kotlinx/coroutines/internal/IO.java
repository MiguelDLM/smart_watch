package kotlinx.coroutines.internal;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlinx.coroutines.internal.X00IoxXI;

@XO0OX.Oxx0IOOO
/* loaded from: classes6.dex */
public final class IO<S extends X00IoxXI<S>> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final Object f30228oIX0oI;

    public /* synthetic */ IO(Object obj) {
        this.f30228oIX0oI = obj;
    }

    public static boolean I0Io(Object obj, Object obj2) {
        return (obj2 instanceof IO) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(obj, ((IO) obj2).xoIox());
    }

    public static final boolean II0XooXoX(Object obj) {
        if (obj == XO.f30281II0xO0) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public static <S extends X00IoxXI<S>> Object II0xO0(@OXOo.oOoXoXO Object obj) {
        return obj;
    }

    public static int Oxx0IOOO(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static /* synthetic */ void X0o0xo() {
    }

    @OXOo.OOXIXo
    public static final S XO(Object obj) {
        if (obj != XO.f30281II0xO0) {
            kotlin.jvm.internal.IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
            return (S) obj;
        }
        throw new IllegalStateException("Does not contain segment");
    }

    public static final /* synthetic */ IO oIX0oI(Object obj) {
        return new IO(obj);
    }

    public static final boolean oxoX(Object obj, Object obj2) {
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(obj, obj2);
    }

    public static String xxIXOIIO(Object obj) {
        return "SegmentOrClosed(value=" + obj + HexStringBuilder.COMMENT_END_CHAR;
    }

    public boolean equals(Object obj) {
        return I0Io(this.f30228oIX0oI, obj);
    }

    public int hashCode() {
        return Oxx0IOOO(this.f30228oIX0oI);
    }

    public String toString() {
        return xxIXOIIO(this.f30228oIX0oI);
    }

    public final /* synthetic */ Object xoIox() {
        return this.f30228oIX0oI;
    }
}
