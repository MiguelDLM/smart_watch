package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.List;

@kotlin.o0
@kotlinx.serialization.XO
/* loaded from: classes6.dex */
public final class XO<E> extends xoXoI<E, List<? extends E>, ArrayList<E>> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.descriptors.XO f30703II0xO0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XO(@OXOo.OOXIXo kotlinx.serialization.Oxx0IOOO<E> element) {
        super(element);
        kotlin.jvm.internal.IIX0o.x0xO0oo(element, "element");
        this.f30703II0xO0 = new X0o0xo(element.oIX0oI());
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: IIXOooo, reason: merged with bridge method [inline-methods] */
    public ArrayList<E> XO() {
        return new ArrayList<>();
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: O0xOxO, reason: merged with bridge method [inline-methods] */
    public ArrayList<E> x0xO0oo(@OXOo.OOXIXo List<? extends E> list) {
        ArrayList<E> arrayList;
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        if (list instanceof ArrayList) {
            arrayList = (ArrayList) list;
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            return new ArrayList<>(list);
        }
        return arrayList;
    }

    @Override // kotlinx.serialization.internal.IIXOooo
    /* renamed from: OxI, reason: merged with bridge method [inline-methods] */
    public void Oxx0xo(@OXOo.OOXIXo ArrayList<E> arrayList, int i, E e) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(arrayList, "<this>");
        arrayList.add(i, e);
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: X0IIOO, reason: merged with bridge method [inline-methods] */
    public List<E> Oo(@OXOo.OOXIXo ArrayList<E> arrayList) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(arrayList, "<this>");
        return arrayList;
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: o00, reason: merged with bridge method [inline-methods] */
    public void II0XooXoX(@OXOo.OOXIXo ArrayList<E> arrayList, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(arrayList, "<this>");
        arrayList.ensureCapacity(i);
    }

    @Override // kotlinx.serialization.internal.IIXOooo, kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return this.f30703II0xO0;
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: xoXoI, reason: merged with bridge method [inline-methods] */
    public int Oxx0IOOO(@OXOo.OOXIXo ArrayList<E> arrayList) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(arrayList, "<this>");
        return arrayList.size();
    }
}
