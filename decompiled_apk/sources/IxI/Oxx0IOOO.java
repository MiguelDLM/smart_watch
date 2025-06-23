package IxI;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.util.TreeMap;

/* loaded from: classes13.dex */
public class Oxx0IOOO extends com.univocity.parsers.common.OOXIXo {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public char f1067IIXOooo = TokenParser.SP;

    @Override // com.univocity.parsers.common.OOXIXo
    public TreeMap<String, Object> I0Io() {
        TreeMap<String, Object> treeMap = new TreeMap<>();
        treeMap.put("Padding", Character.valueOf(this.f1067IIXOooo));
        return treeMap;
    }

    public void IXxxXO(char c) {
        this.f1067IIXOooo = c;
    }

    public boolean Oo(char c) {
        if (this.f1067IIXOooo == c) {
            return true;
        }
        return false;
    }

    @Override // com.univocity.parsers.common.OOXIXo
    /* renamed from: oO, reason: merged with bridge method [inline-methods] */
    public final Oxx0IOOO clone() {
        return (Oxx0IOOO) super.clone();
    }

    public char x0xO0oo() {
        return this.f1067IIXOooo;
    }
}
