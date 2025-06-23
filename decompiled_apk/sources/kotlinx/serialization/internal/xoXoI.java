package kotlinx.serialization.internal;

import java.util.Collection;
import java.util.Iterator;

@kotlin.o0
/* loaded from: classes6.dex */
public abstract class xoXoI<E, C extends Collection<? extends E>, B> extends IIXOooo<E, C, B> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xoXoI(@OXOo.OOXIXo kotlinx.serialization.Oxx0IOOO<E> element) {
        super(element, null);
        kotlin.jvm.internal.IIX0o.x0xO0oo(element, "element");
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: OxxIIOOXO, reason: merged with bridge method [inline-methods] */
    public int xoIox(@OXOo.OOXIXo C c) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(c, "<this>");
        return c.size();
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: oI0IIXIo, reason: merged with bridge method [inline-methods] */
    public Iterator<E> xxIXOIIO(@OXOo.OOXIXo C c) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(c, "<this>");
        return c.iterator();
    }
}
