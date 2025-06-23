package kotlinx.serialization.internal;

import java.util.LinkedHashSet;
import java.util.Set;

@kotlin.o0
/* loaded from: classes6.dex */
public final class xXOx<E> extends xoXoI<E, Set<? extends E>, LinkedHashSet<E>> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.descriptors.XO f30763II0xO0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xXOx(@OXOo.OOXIXo kotlinx.serialization.Oxx0IOOO<E> eSerializer) {
        super(eSerializer);
        kotlin.jvm.internal.IIX0o.x0xO0oo(eSerializer, "eSerializer");
        this.f30763II0xO0 = new xo0x(eSerializer.oIX0oI());
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: IIXOooo, reason: merged with bridge method [inline-methods] */
    public LinkedHashSet<E> XO() {
        return new LinkedHashSet<>();
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: O0xOxO, reason: merged with bridge method [inline-methods] */
    public LinkedHashSet<E> x0xO0oo(@OXOo.OOXIXo Set<? extends E> set) {
        LinkedHashSet<E> linkedHashSet;
        kotlin.jvm.internal.IIX0o.x0xO0oo(set, "<this>");
        if (set instanceof LinkedHashSet) {
            linkedHashSet = (LinkedHashSet) set;
        } else {
            linkedHashSet = null;
        }
        if (linkedHashSet == null) {
            return new LinkedHashSet<>(set);
        }
        return linkedHashSet;
    }

    @Override // kotlinx.serialization.internal.IIXOooo
    /* renamed from: OxI, reason: merged with bridge method [inline-methods] */
    public void Oxx0xo(@OXOo.OOXIXo LinkedHashSet<E> linkedHashSet, int i, E e) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(linkedHashSet, "<this>");
        linkedHashSet.add(e);
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: X0IIOO, reason: merged with bridge method [inline-methods] */
    public Set<E> Oo(@OXOo.OOXIXo LinkedHashSet<E> linkedHashSet) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(linkedHashSet, "<this>");
        return linkedHashSet;
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: o00, reason: merged with bridge method [inline-methods] */
    public void II0XooXoX(@OXOo.OOXIXo LinkedHashSet<E> linkedHashSet, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(linkedHashSet, "<this>");
    }

    @Override // kotlinx.serialization.internal.IIXOooo, kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return this.f30763II0xO0;
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: xoXoI, reason: merged with bridge method [inline-methods] */
    public int Oxx0IOOO(@OXOo.OOXIXo LinkedHashSet<E> linkedHashSet) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(linkedHashSet, "<this>");
        return linkedHashSet.size();
    }
}
