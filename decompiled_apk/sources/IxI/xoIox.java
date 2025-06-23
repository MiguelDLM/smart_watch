package IxI;

import java.io.Writer;
import o0OO0.oIX0oI;

/* loaded from: classes13.dex */
public class xoIox extends oIX0oI<xxIXOIIO, oOoXoXO> {
    public xoIox() {
        this(null, null);
    }

    @Override // o0OO0.oIX0oI
    public void I0Io(String[] strArr, int[] iArr) {
        xoIox().xo0x(new XO(strArr, iArr));
    }

    @Override // o0OO0.oIX0oI
    /* renamed from: Io, reason: merged with bridge method [inline-methods] */
    public oOoXoXO X0o0xo() {
        return new oOoXoXO();
    }

    @Override // o0OO0.oIX0oI
    /* renamed from: OI0, reason: merged with bridge method [inline-methods] */
    public xxIXOIIO oxoX() {
        return new xxIXOIIO();
    }

    @Override // o0OO0.oIX0oI
    /* renamed from: XX, reason: merged with bridge method [inline-methods] */
    public OOXIXo Oxx0IOOO(Writer writer, oOoXoXO oooxoxo) {
        return new OOXIXo(writer, oooxoxo);
    }

    @Override // o0OO0.oIX0oI
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public II0XooXoX XO(xxIXOIIO xxixoiio) {
        return new II0XooXoX(xxixoiio);
    }

    public xoIox(xxIXOIIO xxixoiio) {
        this(xxixoiio, null);
    }

    public xoIox(oOoXoXO oooxoxo) {
        this(null, oooxoxo);
    }

    public xoIox(xxIXOIIO xxixoiio, oOoXoXO oooxoxo) {
        super("Fixed-width parsing/writing routine", xxixoiio, oooxoxo);
    }
}
