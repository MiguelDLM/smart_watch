package kotlin.collections.builders;

import OXOo.OOXIXo;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.collections.XO;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public abstract class oIX0oI<E extends Map.Entry<? extends K, ? extends V>, K, V> extends XO<E> {
    public abstract boolean II0xO0(@OOXIXo Map.Entry<? extends K, ? extends V> entry);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return oIX0oI((Map.Entry) obj);
    }

    public final boolean oIX0oI(@OOXIXo E element) {
        IIX0o.x0xO0oo(element, "element");
        return II0xO0(element);
    }

    public /* bridge */ boolean oxoX(Map.Entry<?, ?> entry) {
        return super.remove(entry);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return oxoX((Map.Entry) obj);
    }
}
