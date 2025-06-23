package kotlinx.serialization.internal;

import java.util.HashSet;
import java.util.Set;

@kotlin.o0
/* loaded from: classes6.dex */
public final class X00IoxXI<E> extends xoXoI<E, Set<? extends E>, HashSet<E>> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.descriptors.XO f30691II0xO0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X00IoxXI(@OXOo.OOXIXo kotlinx.serialization.Oxx0IOOO<E> eSerializer) {
        super(eSerializer);
        kotlin.jvm.internal.IIX0o.x0xO0oo(eSerializer, "eSerializer");
        this.f30691II0xO0 = new Xx000oIo(eSerializer.oIX0oI());
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: IIXOooo, reason: merged with bridge method [inline-methods] */
    public HashSet<E> XO() {
        return new HashSet<>();
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: O0xOxO, reason: merged with bridge method [inline-methods] */
    public HashSet<E> x0xO0oo(@OXOo.OOXIXo Set<? extends E> set) {
        HashSet<E> hashSet;
        kotlin.jvm.internal.IIX0o.x0xO0oo(set, "<this>");
        if (set instanceof HashSet) {
            hashSet = (HashSet) set;
        } else {
            hashSet = null;
        }
        if (hashSet == null) {
            return new HashSet<>(set);
        }
        return hashSet;
    }

    @Override // kotlinx.serialization.internal.IIXOooo
    /* renamed from: OxI, reason: merged with bridge method [inline-methods] */
    public void Oxx0xo(@OXOo.OOXIXo HashSet<E> hashSet, int i, E e) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(hashSet, "<this>");
        hashSet.add(e);
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: X0IIOO, reason: merged with bridge method [inline-methods] */
    public Set<E> Oo(@OXOo.OOXIXo HashSet<E> hashSet) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(hashSet, "<this>");
        return hashSet;
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: o00, reason: merged with bridge method [inline-methods] */
    public void II0XooXoX(@OXOo.OOXIXo HashSet<E> hashSet, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(hashSet, "<this>");
    }

    @Override // kotlinx.serialization.internal.IIXOooo, kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return this.f30691II0xO0;
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: xoXoI, reason: merged with bridge method [inline-methods] */
    public int Oxx0IOOO(@OXOo.OOXIXo HashSet<E> hashSet) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(hashSet, "<this>");
        return hashSet.size();
    }
}
