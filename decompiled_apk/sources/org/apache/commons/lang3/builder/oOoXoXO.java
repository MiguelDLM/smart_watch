package org.apache.commons.lang3.builder;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* loaded from: classes6.dex */
public class oOoXoXO<T> implements oIX0oI<I0Io<T>> {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final DiffBuilder<T> f32657IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final Object f32658Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final Object f32659XO;

    public oOoXoXO(T t, T t2, ToStringStyle toStringStyle) {
        this.f32659XO = t;
        this.f32658Oo = t2;
        this.f32657IXxxXO = new DiffBuilder<>(t, t2, toStringStyle);
    }

    private boolean oIX0oI(Field field) {
        if (field.getName().indexOf(36) != -1 || Modifier.isTransient(field.getModifiers())) {
            return false;
        }
        return !Modifier.isStatic(field.getModifiers());
    }

    @Override // org.apache.commons.lang3.builder.oIX0oI
    /* renamed from: I0Io, reason: merged with bridge method [inline-methods] */
    public I0Io<T> build() {
        if (this.f32659XO.equals(this.f32658Oo)) {
            return this.f32657IXxxXO.build();
        }
        II0xO0(this.f32659XO.getClass());
        return this.f32657IXxxXO.build();
    }

    public final void II0xO0(Class<?> cls) {
        for (Field field : Ox00XOXoo.II0xO0.oIX0oI(cls)) {
            if (oIX0oI(field)) {
                try {
                    this.f32657IXxxXO.Oxx0IOOO(field.getName(), Ox00XOXoo.II0xO0.x0xO0oo(field, this.f32659XO, true), Ox00XOXoo.II0xO0.x0xO0oo(field, this.f32658Oo, true));
                } catch (IllegalAccessException e) {
                    throw new InternalError("Unexpected IllegalAccessException: " + e.getMessage());
                }
            }
        }
    }
}
