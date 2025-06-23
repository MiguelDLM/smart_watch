package o00xOoIO;

import java.util.Arrays;
import java.util.Map;

/* loaded from: classes13.dex */
public class II0XooXoX extends com.univocity.parsers.common.XO<II0xO0> {

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public boolean f31041x0xO0oo = false;

    /* renamed from: Oo, reason: collision with root package name */
    public boolean f31037Oo = false;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f31036IXxxXO = false;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f31038Oxx0xo = true;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public char[] f31040oI0IIXIo = new char[0];

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f31039OxxIIOOXO = false;

    public boolean I0oOoX() {
        return this.f31039OxxIIOOXO;
    }

    public final boolean Io() {
        return this.f31036IXxxXO;
    }

    public boolean OI0() {
        return this.f31041x0xO0oo;
    }

    public boolean XOxIOxOx() {
        return this.f31037Oo;
    }

    public boolean XX(char c) {
        int i = 0;
        while (true) {
            char[] cArr = this.f31040oI0IIXIo;
            if (i >= cArr.length) {
                return false;
            }
            if (cArr[i] == c) {
                return true;
            }
            i++;
        }
    }

    public void XX0(boolean z) {
        this.f31039OxxIIOOXO = z;
    }

    public final void XoX(boolean z) {
        this.f31036IXxxXO = z;
    }

    public boolean o0() {
        return this.f31038Oxx0xo;
    }

    @Override // com.univocity.parsers.common.XO, com.univocity.parsers.common.X0o0xo
    public void oIX0oI(Map<String, Object> map) {
        super.oIX0oI(map);
        map.put("Quote all fields", Boolean.valueOf(this.f31037Oo));
        map.put("Escape unquoted values", Boolean.valueOf(this.f31041x0xO0oo));
        map.put("Normalize escaped line separators", Boolean.valueOf(this.f31038Oxx0xo));
        map.put("Input escaped", Boolean.valueOf(this.f31036IXxxXO));
        map.put("Quote escaping enabled", Boolean.valueOf(this.f31039OxxIIOOXO));
        map.put("Quotation triggers", Arrays.toString(this.f31040oI0IIXIo));
    }

    public void oxXx0IX(boolean z) {
        this.f31038Oxx0xo = z;
    }

    public void oxxXoxO(boolean z) {
        this.f31041x0xO0oo = z;
    }

    public char[] x0o() {
        return this.f31040oI0IIXIo;
    }

    @Override // com.univocity.parsers.common.X0o0xo
    /* renamed from: xII, reason: merged with bridge method [inline-methods] */
    public II0xO0 I0Io() {
        return new II0xO0();
    }

    public void xXOx(boolean z) {
        this.f31037Oo = z;
    }

    public void xo0x(char... cArr) {
        if (cArr == null) {
            cArr = new char[0];
        }
        this.f31040oI0IIXIo = cArr;
    }
}
