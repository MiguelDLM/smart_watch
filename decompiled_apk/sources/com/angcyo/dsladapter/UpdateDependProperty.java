package com.angcyo.dsladapter;

import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public final class UpdateDependProperty<T> implements xOxOoo.XO<DslAdapterItem, T> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.x0xO0oo<T, T, oXIO0o0XI> f5307I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final Object f5308II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public T f5309oIX0oI;

    /* JADX WARN: Multi-variable type inference failed */
    public UpdateDependProperty(T t, @OXOo.oOoXoXO Object obj, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super T, oXIO0o0XI> onValueChanged) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(onValueChanged, "onValueChanged");
        this.f5309oIX0oI = t;
        this.f5308II0xO0 = obj;
        this.f5307I0Io = onValueChanged;
    }

    @OXOo.OOXIXo
    public final Oox.x0xO0oo<T, T, oXIO0o0XI> I0Io() {
        return this.f5307I0Io;
    }

    public final void II0XooXoX(T t) {
        this.f5309oIX0oI = t;
    }

    @Override // xOxOoo.XO
    /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
    public void II0xO0(@OXOo.OOXIXo DslAdapterItem thisRef, @OXOo.OOXIXo kotlin.reflect.x0XOIxOo<?> property, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(thisRef, "thisRef");
        kotlin.jvm.internal.IIX0o.x0xO0oo(property, "property");
        T t2 = this.f5309oIX0oI;
        this.f5309oIX0oI = t;
        if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(t2, t)) {
            this.f5307I0Io.invoke(t2, t);
            thisRef.setItemUpdateFlag(true);
            thisRef.updateItemDepend(new XxX0x0xxx(thisRef, false, false, false, false, true, this.f5308II0xO0, null, 0L, 0L, null, 1950, null));
        }
    }

    public final T X0o0xo() {
        return this.f5309oIX0oI;
    }

    @Override // xOxOoo.XO, xOxOoo.X0o0xo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public T oIX0oI(@OXOo.OOXIXo DslAdapterItem thisRef, @OXOo.OOXIXo kotlin.reflect.x0XOIxOo<?> property) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(thisRef, "thisRef");
        kotlin.jvm.internal.IIX0o.x0xO0oo(property, "property");
        return this.f5309oIX0oI;
    }

    @OXOo.oOoXoXO
    public final Object oxoX() {
        return this.f5308II0xO0;
    }

    public /* synthetic */ UpdateDependProperty(Object obj, Object obj2, Oox.x0xO0oo x0xo0oo, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(obj, (i & 2) != 0 ? 1 : obj2, (i & 4) != 0 ? new Oox.x0xO0oo<T, T, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.UpdateDependProperty.1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(T t, T t2) {
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object obj3, Object obj4) {
                invoke2(obj3, obj4);
                return oXIO0o0XI.f29392oIX0oI;
            }
        } : x0xo0oo);
    }
}
