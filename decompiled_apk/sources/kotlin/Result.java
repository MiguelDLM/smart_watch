package kotlin;

import com.facebook.login.LoginLogger;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;

@XO0OX.Oxx0IOOO
@oxxXoxO(version = "1.3")
/* loaded from: classes6.dex */
public final class Result<T> implements Serializable {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);

    @OXOo.oOoXoXO
    private final Object value;

    /* loaded from: classes6.dex */
    public static final class Failure implements Serializable {

        @OXOo.OOXIXo
        @XO0OX.XO
        public final Throwable exception;

        public Failure(@OXOo.OOXIXo Throwable exception) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(exception, "exception");
            this.exception = exception;
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if ((obj instanceof Failure) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.exception, ((Failure) obj).exception)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        @OXOo.OOXIXo
        public String toString() {
            return "Failure(" + this.exception + HexStringBuilder.COMMENT_END_CHAR;
        }
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @XO0OX.xxIXOIIO(name = "success")
        @xx0o0O.XO
        public final <T> Object II0xO0(T t) {
            return Result.m287constructorimpl(t);
        }

        @XO0OX.xxIXOIIO(name = LoginLogger.EVENT_EXTRAS_FAILURE)
        @xx0o0O.XO
        public final <T> Object oIX0oI(Throwable exception) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(exception, "exception");
            return Result.m287constructorimpl(I0oOoX.oIX0oI(exception));
        }

        public oIX0oI() {
        }
    }

    @o0
    private /* synthetic */ Result(Object obj) {
        this.value = obj;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Result m286boximpl(Object obj) {
        return new Result(obj);
    }

    @OXOo.OOXIXo
    @o0
    /* renamed from: constructor-impl, reason: not valid java name */
    public static <T> Object m287constructorimpl(@OXOo.oOoXoXO Object obj) {
        return obj;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m288equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof Result) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(obj, ((Result) obj2).m296unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m289equalsimpl0(Object obj, Object obj2) {
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(obj, obj2);
    }

    @OXOo.oOoXoXO
    /* renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m290exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @xx0o0O.XO
    /* renamed from: getOrNull-impl, reason: not valid java name */
    private static final T m291getOrNullimpl(Object obj) {
        if (m293isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    @o0
    public static /* synthetic */ void getValue$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m292hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m293isFailureimpl(Object obj) {
        return obj instanceof Failure;
    }

    /* renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m294isSuccessimpl(Object obj) {
        return !(obj instanceof Failure);
    }

    @OXOo.OOXIXo
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m295toStringimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).toString();
        }
        return "Success(" + obj + HexStringBuilder.COMMENT_END_CHAR;
    }

    public boolean equals(Object obj) {
        return m288equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m292hashCodeimpl(this.value);
    }

    @OXOo.OOXIXo
    public String toString() {
        return m295toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m296unboximpl() {
        return this.value;
    }
}
