package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Iterator;

@kotlin.o0
/* loaded from: classes6.dex */
public final class XIXIX<ElementKlass, Element extends ElementKlass> extends IIXOooo<Element, Element[], ArrayList<Element>> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.descriptors.XO f30695I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlin.reflect.oxoX<ElementKlass> f30696II0xO0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XIXIX(@OXOo.OOXIXo kotlin.reflect.oxoX<ElementKlass> kClass, @OXOo.OOXIXo kotlinx.serialization.Oxx0IOOO<Element> eSerializer) {
        super(eSerializer, null);
        kotlin.jvm.internal.IIX0o.x0xO0oo(kClass, "kClass");
        kotlin.jvm.internal.IIX0o.x0xO0oo(eSerializer, "eSerializer");
        this.f30696II0xO0 = kClass;
        this.f30695I0Io = new oxoX(eSerializer.oIX0oI());
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: IIXOooo, reason: merged with bridge method [inline-methods] */
    public void II0XooXoX(@OXOo.OOXIXo ArrayList<Element> arrayList, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(arrayList, "<this>");
        arrayList.ensureCapacity(i);
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: O0xOxO, reason: merged with bridge method [inline-methods] */
    public ArrayList<Element> x0xO0oo(@OXOo.OOXIXo Element[] elementArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elementArr, "<this>");
        return new ArrayList<>(kotlin.collections.ooOOo0oXI.oI0IIXIo(elementArr));
    }

    @Override // kotlinx.serialization.internal.IIXOooo
    /* renamed from: OxI, reason: merged with bridge method [inline-methods] */
    public void Oxx0xo(@OXOo.OOXIXo ArrayList<Element> arrayList, int i, Element element) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(arrayList, "<this>");
        arrayList.add(i, element);
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: OxxIIOOXO, reason: merged with bridge method [inline-methods] */
    public int Oxx0IOOO(@OXOo.OOXIXo ArrayList<Element> arrayList) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(arrayList, "<this>");
        return arrayList.size();
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: X0IIOO, reason: merged with bridge method [inline-methods] */
    public Element[] Oo(@OXOo.OOXIXo ArrayList<Element> arrayList) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(arrayList, "<this>");
        return (Element[]) o0xxxXXxX.Oxx0xo(arrayList, this.f30696II0xO0);
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: o00, reason: merged with bridge method [inline-methods] */
    public int xoIox(@OXOo.OOXIXo Element[] elementArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elementArr, "<this>");
        return elementArr.length;
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: oI0IIXIo, reason: merged with bridge method [inline-methods] */
    public ArrayList<Element> XO() {
        return new ArrayList<>();
    }

    @Override // kotlinx.serialization.internal.IIXOooo, kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return this.f30695I0Io;
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: xoXoI, reason: merged with bridge method [inline-methods] */
    public Iterator<Element> xxIXOIIO(@OXOo.OOXIXo Element[] elementArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elementArr, "<this>");
        return kotlin.jvm.internal.II0XooXoX.oIX0oI(elementArr);
    }
}
