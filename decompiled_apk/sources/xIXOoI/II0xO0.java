package xIXOoI;

/* loaded from: classes13.dex */
public class II0xO0 extends com.univocity.parsers.common.oIX0oI<I0Io> {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final boolean f34171IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final boolean f34172Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public final boolean f34173Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public final char f34174OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public final char f34175oI0IIXIo;

    /* JADX WARN: Multi-variable type inference failed */
    public II0xO0(I0Io i0Io) {
        super(i0Io);
        this.f34172Oo = i0Io.oOoXoXO();
        this.f34171IXxxXO = i0Io.OOXIXo();
        this.f34173Oxx0xo = i0Io.I0X0x0oIo();
        this.f34175oI0IIXIo = ((oIX0oI) i0Io.xxIXOIIO()).Oxx0IOOO();
        this.f34174OxxIIOOXO = ((oIX0oI) i0Io.xxIXOIIO()).x0xO0oo();
    }

    @Override // com.univocity.parsers.common.oIX0oI
    public void Oo() {
        this.f27066II0XooXoX.II0xO0('\t');
        this.f27066II0XooXoX.oOoXoXO(this.f34174OxxIIOOXO);
    }

    public final void XX() {
        char c;
        if (this.f34171IXxxXO && (c = this.f27080xxIXOIIO) != '\t' && c <= ' ') {
            this.f27080xxIXOIIO = this.f27066II0XooXoX.XO(c);
        }
        if (this.f27080xxIXOIIO == '\t') {
            this.f27067II0xO0.II0xO0();
            return;
        }
        if (!this.f34172Oo) {
            while (true) {
                char c2 = this.f27080xxIXOIIO;
                if (c2 == '\t' || c2 == this.f34175oI0IIXIo) {
                    break;
                }
                if (c2 == this.f34174OxxIIOOXO) {
                    char Oxx0IOOO2 = this.f27066II0XooXoX.Oxx0IOOO();
                    this.f27080xxIXOIIO = Oxx0IOOO2;
                    if (Oxx0IOOO2 == 't') {
                        this.f27067II0xO0.f27098Oxx0IOOO.append('\t');
                    } else if (Oxx0IOOO2 == 'n') {
                        this.f27067II0xO0.f27098Oxx0IOOO.append('\n');
                    } else if (Oxx0IOOO2 == '\\') {
                        this.f27067II0xO0.f27098Oxx0IOOO.append('\\');
                    } else if (Oxx0IOOO2 == 'r') {
                        this.f27067II0xO0.f27098Oxx0IOOO.append('\r');
                    } else {
                        char c3 = this.f34175oI0IIXIo;
                        if (Oxx0IOOO2 == c3 && this.f34173Oxx0xo) {
                            this.f27067II0xO0.f27098Oxx0IOOO.append(c3);
                        } else {
                            this.f27067II0xO0.f27098Oxx0IOOO.append(this.f34174OxxIIOOXO);
                            char c4 = this.f27080xxIXOIIO;
                            if (c4 == this.f34175oI0IIXIo || c4 == '\t') {
                                break;
                            } else {
                                this.f27067II0xO0.f27098Oxx0IOOO.append(c4);
                            }
                        }
                    }
                    this.f27080xxIXOIIO = this.f27066II0XooXoX.Oxx0IOOO();
                } else {
                    this.f27080xxIXOIIO = this.f27066II0XooXoX.xxIXOIIO(c2, this.f27067II0xO0.f27098Oxx0IOOO);
                }
            }
        } else {
            while (true) {
                char c5 = this.f27080xxIXOIIO;
                if (c5 == '\t' || c5 == this.f34175oI0IIXIo) {
                    break;
                }
                if (c5 == this.f34174OxxIIOOXO) {
                    char Oxx0IOOO3 = this.f27066II0XooXoX.Oxx0IOOO();
                    this.f27080xxIXOIIO = Oxx0IOOO3;
                    if (Oxx0IOOO3 == 't') {
                        this.f27067II0xO0.f27098Oxx0IOOO.xoIox('\t');
                    } else if (Oxx0IOOO3 == 'n') {
                        this.f27067II0xO0.f27098Oxx0IOOO.xoIox('\n');
                    } else if (Oxx0IOOO3 == '\\') {
                        this.f27067II0xO0.f27098Oxx0IOOO.xoIox('\\');
                    } else if (Oxx0IOOO3 == 'r') {
                        this.f27067II0xO0.f27098Oxx0IOOO.xoIox('\r');
                    } else {
                        char c6 = this.f34175oI0IIXIo;
                        if (Oxx0IOOO3 == c6 && this.f34173Oxx0xo) {
                            this.f27067II0xO0.f27098Oxx0IOOO.xoIox(c6);
                        } else {
                            this.f27067II0xO0.f27098Oxx0IOOO.append(this.f34174OxxIIOOXO);
                            char c7 = this.f27080xxIXOIIO;
                            if (c7 == this.f34175oI0IIXIo || c7 == '\t') {
                                break;
                            } else {
                                this.f27067II0xO0.f27098Oxx0IOOO.xoIox(c7);
                            }
                        }
                    }
                    this.f27080xxIXOIIO = this.f27066II0XooXoX.Oxx0IOOO();
                } else {
                    this.f27080xxIXOIIO = this.f27066II0XooXoX.oO(c5, this.f27067II0xO0.f27098Oxx0IOOO);
                }
            }
        }
        this.f27067II0xO0.oOoXoXO();
    }

    @Override // com.univocity.parsers.common.oIX0oI
    public void xII() {
        char c;
        if (this.f34171IXxxXO && (c = this.f27080xxIXOIIO) != '\t' && c <= ' ') {
            this.f27080xxIXOIIO = this.f27066II0XooXoX.XO(c);
        }
        while (this.f27080xxIXOIIO != this.f34175oI0IIXIo) {
            XX();
            if (this.f27080xxIXOIIO != this.f34175oI0IIXIo) {
                char Oxx0IOOO2 = this.f27066II0XooXoX.Oxx0IOOO();
                this.f27080xxIXOIIO = Oxx0IOOO2;
                if (Oxx0IOOO2 == this.f34175oI0IIXIo) {
                    this.f27067II0xO0.II0xO0();
                }
            }
        }
    }
}
