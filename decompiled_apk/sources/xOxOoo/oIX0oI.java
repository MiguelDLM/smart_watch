package xOxOoo;

import OXOo.OOXIXo;
import Oox.IXxxXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.reflect.x0XOIxOo;

/* loaded from: classes6.dex */
public final class oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f34496oIX0oI = new oIX0oI();

    /* JADX INFO: Add missing generic type declarations: [T] */
    @XX({"SMAP\nDelegates.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delegates.kt\nkotlin/properties/Delegates$vetoable$1\n*L\n1#1,73:1\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class II0xO0<T> extends I0Io<T> {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ IXxxXO<x0XOIxOo<?>, T, T, Boolean> f34497II0xO0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public II0xO0(T t, IXxxXO<? super x0XOIxOo<?>, ? super T, ? super T, Boolean> iXxxXO) {
            super(t);
            this.f34497II0xO0 = iXxxXO;
        }

        @Override // xOxOoo.I0Io
        public boolean oxoX(@OOXIXo x0XOIxOo<?> property, T t, T t2) {
            IIX0o.x0xO0oo(property, "property");
            return this.f34497II0xO0.invoke(property, t, t2).booleanValue();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @XX({"SMAP\nDelegates.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delegates.kt\nkotlin/properties/Delegates$observable$1\n*L\n1#1,73:1\n*E\n"})
    /* renamed from: xOxOoo.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1162oIX0oI<T> extends I0Io<T> {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ IXxxXO<x0XOIxOo<?>, T, T, oXIO0o0XI> f34498II0xO0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C1162oIX0oI(T t, IXxxXO<? super x0XOIxOo<?>, ? super T, ? super T, oXIO0o0XI> iXxxXO) {
            super(t);
            this.f34498II0xO0 = iXxxXO;
        }

        @Override // xOxOoo.I0Io
        public void I0Io(@OOXIXo x0XOIxOo<?> property, T t, T t2) {
            IIX0o.x0xO0oo(property, "property");
            this.f34498II0xO0.invoke(property, t, t2);
        }
    }

    @OOXIXo
    public final <T> XO<Object, T> I0Io(T t, @OOXIXo IXxxXO<? super x0XOIxOo<?>, ? super T, ? super T, Boolean> onChange) {
        IIX0o.x0xO0oo(onChange, "onChange");
        return new II0xO0(t, onChange);
    }

    @OOXIXo
    public final <T> XO<Object, T> II0xO0(T t, @OOXIXo IXxxXO<? super x0XOIxOo<?>, ? super T, ? super T, oXIO0o0XI> onChange) {
        IIX0o.x0xO0oo(onChange, "onChange");
        return new C1162oIX0oI(t, onChange);
    }

    @OOXIXo
    public final <T> XO<Object, T> oIX0oI() {
        return new xOxOoo.II0xO0();
    }
}
