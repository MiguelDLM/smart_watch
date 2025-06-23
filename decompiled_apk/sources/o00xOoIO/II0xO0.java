package o00xOoIO;

import com.univocity.parsers.common.OOXIXo;
import java.util.TreeMap;

/* loaded from: classes13.dex */
public class II0xO0 extends OOXIXo {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public char f31042IIXOooo = '\"';

    /* renamed from: xoXoI, reason: collision with root package name */
    public char f31045xoXoI = '\"';

    /* renamed from: o00, reason: collision with root package name */
    public char f31044o00 = ',';

    /* renamed from: OxI, reason: collision with root package name */
    public Character f31043OxI = null;

    @Override // com.univocity.parsers.common.OOXIXo
    public TreeMap<String, Object> I0Io() {
        TreeMap<String, Object> treeMap = new TreeMap<>();
        treeMap.put("Quote character", Character.valueOf(this.f31042IIXOooo));
        treeMap.put("Quote escape character", Character.valueOf(this.f31045xoXoI));
        treeMap.put("Quote escape escape character", this.f31043OxI);
        treeMap.put("Field delimiter", Character.valueOf(this.f31044o00));
        return treeMap;
    }

    public boolean IIXOooo(char c) {
        if (this.f31042IIXOooo == c) {
            return true;
        }
        return false;
    }

    public char IXxxXO() {
        return this.f31042IIXOooo;
    }

    public void O0xOxO(char c) {
        this.f31042IIXOooo = c;
    }

    public char Oo() {
        return this.f31044o00;
    }

    public void OxI(char c) {
        this.f31044o00 = c;
    }

    public char Oxx0xo() {
        return this.f31045xoXoI;
    }

    public boolean OxxIIOOXO(char c) {
        if (this.f31044o00 == c) {
            return true;
        }
        return false;
    }

    public void X0IIOO(char c) {
        this.f31045xoXoI = c;
    }

    public final void o00(char c) {
        this.f31043OxI = Character.valueOf(c);
    }

    public final boolean oI0IIXIo(char c) {
        char x0xO0oo2 = x0xO0oo();
        if (x0xO0oo2 != 0 && x0xO0oo2 == c) {
            return true;
        }
        return false;
    }

    @Override // com.univocity.parsers.common.OOXIXo
    /* renamed from: oO, reason: merged with bridge method [inline-methods] */
    public final II0xO0 clone() {
        return (II0xO0) super.clone();
    }

    public final char x0xO0oo() {
        Character ch = this.f31043OxI;
        if (ch == null) {
            char c = this.f31042IIXOooo;
            char c2 = this.f31045xoXoI;
            if (c == c2) {
                return (char) 0;
            }
            return c2;
        }
        return ch.charValue();
    }

    public boolean xoXoI(char c) {
        if (this.f31045xoXoI == c) {
            return true;
        }
        return false;
    }
}
