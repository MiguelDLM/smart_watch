package androidx.collection;

import OI0IXox.oxoX;
import OXOo.OOXIXo;
import java.util.Iterator;
import kotlin.sequences.IXxxXO;

/* JADX INFO: Add missing generic type declarations: [K] */
/* loaded from: classes.dex */
public final class MutableScatterMap$MutableMapWrapper$keys$1$iterator$1<K> implements Iterator<K>, oxoX {
    private int current = -1;

    @OOXIXo
    private final Iterator<Integer> iterator;
    final /* synthetic */ MutableScatterMap<K, V> this$0;

    public MutableScatterMap$MutableMapWrapper$keys$1$iterator$1(MutableScatterMap<K, V> mutableScatterMap) {
        this.this$0 = mutableScatterMap;
        this.iterator = IXxxXO.oIX0oI(new MutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1(mutableScatterMap, null));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public K next() {
        int intValue = this.iterator.next().intValue();
        this.current = intValue;
        return (K) this.this$0.keys[intValue];
    }

    @Override // java.util.Iterator
    public void remove() {
        int i = this.current;
        if (i >= 0) {
            this.this$0.removeValueAt(i);
            this.current = -1;
        }
    }
}
