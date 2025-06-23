package oO0IXx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes13.dex */
public class oI0IIXIo extends IIXOooo {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public String[] f31923Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final Class[] f31924X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final List[] f31925XO;

    public oI0IIXIo(Class... clsArr) {
        super(clsArr);
        this.f31924X0o0xo = clsArr;
        this.f31925XO = new List[clsArr.length];
        for (int i = 0; i < clsArr.length; i++) {
            this.f31925XO[i] = new ArrayList(1000);
        }
    }

    public final String[] OOXIXo() {
        return this.f31923Oxx0IOOO;
    }

    @Override // oO0IXx.IIXOooo
    public final void Oxx0IOOO(Map<Class<?>, Object> map, com.univocity.parsers.common.oO oOVar) {
        int i = 0;
        while (true) {
            Class[] clsArr = this.f31924X0o0xo;
            if (i < clsArr.length) {
                this.f31925XO[i].add(map.get(clsArr[i]));
                i++;
            } else {
                return;
            }
        }
    }

    @Override // oO0IXx.IIXOooo, oO0IXx.OxxIIOOXO, oO0IXx.xxX
    public final void XO(com.univocity.parsers.common.oO oOVar) {
        this.f31923Oxx0IOOO = oOVar.X0o0xo();
        super.XO(oOVar);
    }

    @Override // oO0IXx.IIXOooo, oO0IXx.OxxIIOOXO, oO0IXx.xxX
    public final void oO(com.univocity.parsers.common.oO oOVar) {
        super.oO(oOVar);
        for (int i = 0; i < this.f31924X0o0xo.length; i++) {
            this.f31925XO[i] = new ArrayList(1000);
        }
    }

    public Map<Class<?>, List<?>> xoIox() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        while (true) {
            Class[] clsArr = this.f31924X0o0xo;
            if (i < clsArr.length) {
                linkedHashMap.put(clsArr[i], this.f31925XO[i]);
                i++;
            } else {
                return linkedHashMap;
            }
        }
    }

    public <T> List<T> xxIXOIIO(Class<T> cls) {
        int I0Io2 = com.univocity.parsers.common.I0Io.I0Io(this.f31924X0o0xo, cls);
        if (I0Io2 != -1) {
            return this.f31925XO[I0Io2];
        }
        throw new IllegalArgumentException("Unknown bean type '" + cls.getSimpleName() + "'. Available types are: " + Arrays.toString(this.f31924X0o0xo));
    }
}
