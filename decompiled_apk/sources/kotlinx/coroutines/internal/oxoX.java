package kotlinx.coroutines.internal;

import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@IgnoreJRERequirement
/* loaded from: classes6.dex */
public final class oxoX extends OOXIXo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oxoX f30307oIX0oI = new oxoX();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f30306II0xO0 = new oIX0oI();

    /* loaded from: classes6.dex */
    public static final class oIX0oI extends ClassValue<Oox.oOoXoXO<? super Throwable, ? extends Throwable>> {
        @Override // java.lang.ClassValue
        @OXOo.OOXIXo
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public Oox.oOoXoXO<Throwable, Throwable> computeValue(@OXOo.oOoXoXO Class<?> cls) {
            Oox.oOoXoXO<Throwable, Throwable> II0xO02;
            kotlin.jvm.internal.IIX0o.x0XOIxOo(cls, "null cannot be cast to non-null type java.lang.Class<out kotlin.Throwable>");
            II0xO02 = ExceptionsConstructorKt.II0xO0(cls);
            return II0xO02;
        }
    }

    @Override // kotlinx.coroutines.internal.OOXIXo
    @OXOo.OOXIXo
    public Oox.oOoXoXO<Throwable, Throwable> oIX0oI(@OXOo.OOXIXo Class<? extends Throwable> cls) {
        Object obj;
        obj = f30306II0xO0.get(cls);
        return (Oox.oOoXoXO) obj;
    }
}
