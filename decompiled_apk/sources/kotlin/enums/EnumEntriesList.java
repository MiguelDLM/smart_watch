package kotlin.enums;

import OXOo.OOXIXo;
import java.io.Serializable;
import java.lang.Enum;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;

/* JADX INFO: Access modifiers changed from: package-private */
@oxxXoxO(version = "1.8")
/* loaded from: classes6.dex */
public final class EnumEntriesList<T extends Enum<T>> extends kotlin.collections.II0xO0<T> implements oIX0oI<T>, Serializable {

    @OOXIXo
    private final T[] entries;

    public EnumEntriesList(@OOXIXo T[] entries) {
        IIX0o.x0xO0oo(entries, "entries");
        this.entries = entries;
    }

    private final Object writeReplace() {
        return new EnumEntriesSerializationProxy(this.entries);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Enum) {
            return contains((EnumEntriesList<T>) obj);
        }
        return false;
    }

    @Override // kotlin.collections.II0xO0, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.entries.length;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.II0xO0, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Enum) {
            return indexOf((EnumEntriesList<T>) obj);
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.II0xO0, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return lastIndexOf((EnumEntriesList<T>) obj);
        }
        return -1;
    }

    public boolean contains(@OOXIXo T element) {
        IIX0o.x0xO0oo(element, "element");
        return ((Enum) ArraysKt___ArraysKt.IxIOOxO(this.entries, element.ordinal())) == element;
    }

    @Override // kotlin.collections.II0xO0, java.util.List
    @OOXIXo
    public T get(int i) {
        kotlin.collections.II0xO0.Companion.II0xO0(i, this.entries.length);
        return this.entries[i];
    }

    public int indexOf(@OOXIXo T element) {
        IIX0o.x0xO0oo(element, "element");
        int ordinal = element.ordinal();
        if (((Enum) ArraysKt___ArraysKt.IxIOOxO(this.entries, ordinal)) == element) {
            return ordinal;
        }
        return -1;
    }

    public int lastIndexOf(@OOXIXo T element) {
        IIX0o.x0xO0oo(element, "element");
        return indexOf((Object) element);
    }
}
