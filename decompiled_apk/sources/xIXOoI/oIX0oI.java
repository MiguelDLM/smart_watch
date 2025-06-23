package xIXOoI;

import com.univocity.parsers.common.OOXIXo;
import java.util.TreeMap;

/* loaded from: classes13.dex */
public class oIX0oI extends OOXIXo {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public char f34182IIXOooo = '\\';

    @Override // com.univocity.parsers.common.OOXIXo
    public TreeMap<String, Object> I0Io() {
        TreeMap<String, Object> treeMap = new TreeMap<>();
        treeMap.put("Escape character", Character.valueOf(this.f34182IIXOooo));
        return treeMap;
    }

    public void IXxxXO(char c) {
        this.f34182IIXOooo = c;
    }

    public boolean Oo(char c) {
        if (this.f34182IIXOooo == c) {
            return true;
        }
        return false;
    }

    @Override // com.univocity.parsers.common.OOXIXo
    /* renamed from: oO, reason: merged with bridge method [inline-methods] */
    public final oIX0oI clone() {
        return (oIX0oI) super.clone();
    }

    public char x0xO0oo() {
        return this.f34182IIXOooo;
    }
}
