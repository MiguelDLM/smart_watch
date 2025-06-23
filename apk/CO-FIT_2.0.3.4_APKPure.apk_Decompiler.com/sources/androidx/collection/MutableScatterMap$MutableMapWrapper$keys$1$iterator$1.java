package androidx.collection;

import OI0IXox.oxoX;
import OXOo.OOXIXo;
import java.util.Iterator;
import kotlin.coroutines.I0Io;
import kotlin.sequences.IXxxXO;

public final class MutableScatterMap$MutableMapWrapper$keys$1$iterator$1 implements Iterator<K>, oxoX {
    private int current = -1;
    @OOXIXo
    private final Iterator<Integer> iterator;
    final /* synthetic */ MutableScatterMap<K, V> this$0;

    public MutableScatterMap$MutableMapWrapper$keys$1$iterator$1(MutableScatterMap<K, V> mutableScatterMap) {
        this.this$0 = mutableScatterMap;
        this.iterator = IXxxXO.oIX0oI(new MutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1(mutableScatterMap, (I0Io<? super MutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1>) null));
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public K next() {
        int intValue = this.iterator.next().intValue();
        this.current = intValue;
        return this.this$0.keys[intValue];
    }

    public void remove() {
        int i = this.current;
        if (i >= 0) {
            this.this$0.removeValueAt(i);
            this.current = -1;
        }
    }
}
