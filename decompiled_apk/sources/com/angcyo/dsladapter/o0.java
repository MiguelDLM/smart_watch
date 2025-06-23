package com.angcyo.dsladapter;

/* loaded from: classes7.dex */
public final class o0<T> implements xOxOoo.XO<DslAdapterItem, T> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final Object f5424II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public T f5425oIX0oI;

    public o0(T t, @OXOo.oOoXoXO Object obj) {
        this.f5425oIX0oI = t;
        this.f5424II0xO0 = obj;
    }

    @OXOo.oOoXoXO
    public final Object I0Io() {
        return this.f5424II0xO0;
    }

    public final void Oxx0IOOO(T t) {
        this.f5425oIX0oI = t;
    }

    @Override // xOxOoo.XO, xOxOoo.X0o0xo
    /* renamed from: X0o0xo, reason: merged with bridge method [inline-methods] */
    public T oIX0oI(@OXOo.OOXIXo DslAdapterItem thisRef, @OXOo.OOXIXo kotlin.reflect.x0XOIxOo<?> property) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(thisRef, "thisRef");
        kotlin.jvm.internal.IIX0o.x0xO0oo(property, "property");
        return this.f5425oIX0oI;
    }

    @Override // xOxOoo.XO
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public void II0xO0(@OXOo.OOXIXo DslAdapterItem thisRef, @OXOo.OOXIXo kotlin.reflect.x0XOIxOo<?> property, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(thisRef, "thisRef");
        kotlin.jvm.internal.IIX0o.x0xO0oo(property, "property");
        T t2 = this.f5425oIX0oI;
        this.f5425oIX0oI = t;
        if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(t2, t)) {
            thisRef.setItemUpdateFlag(true);
            DslAdapterItem.updateAdapterItem$default(thisRef, this.f5424II0xO0, false, 2, null);
        }
    }

    public final T oxoX() {
        return this.f5425oIX0oI;
    }

    public /* synthetic */ o0(Object obj, Object obj2, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(obj, (i & 2) != 0 ? 1 : obj2);
    }
}
