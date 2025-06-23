package O0;

import XXO0.oIX0oI;
import com.hp.hpl.sparta.xpath.XPathException;
import java.io.IOException;

/* loaded from: classes10.dex */
public class x0XOIxOo {
    public static OOXIXo oIX0oI(xxX xxx2, oI0IIXIo oi0iixio) throws XPathException, IOException {
        int parseInt;
        int parseInt2;
        int i = oi0iixio.f1125oIX0oI;
        if (i != -3) {
            if (i != -2) {
                if (i == 64) {
                    if (oi0iixio.oIX0oI() == -3) {
                        String str = oi0iixio.f1119I0Io;
                        int oIX0oI2 = oi0iixio.oIX0oI();
                        if (oIX0oI2 != 33) {
                            switch (oIX0oI2) {
                                case 60:
                                    oi0iixio.oIX0oI();
                                    int i2 = oi0iixio.f1125oIX0oI;
                                    if (i2 != 34 && i2 != 39) {
                                        if (i2 == -2) {
                                            parseInt = oi0iixio.f1121II0xO0;
                                        } else {
                                            throw new XPathException(xxx2, "right hand side of less-than", oi0iixio, "quoted string or number");
                                        }
                                    } else {
                                        parseInt = Integer.parseInt(oi0iixio.f1119I0Io);
                                    }
                                    oi0iixio.oIX0oI();
                                    return new Oxx0IOOO(str, parseInt);
                                case 61:
                                    oi0iixio.oIX0oI();
                                    int i3 = oi0iixio.f1125oIX0oI;
                                    if (i3 != 34 && i3 != 39) {
                                        throw new XPathException(xxx2, "right hand side of equals", oi0iixio, "quoted string");
                                    }
                                    String str2 = oi0iixio.f1119I0Io;
                                    oi0iixio.oIX0oI();
                                    return new I0Io(str, str2);
                                case 62:
                                    oi0iixio.oIX0oI();
                                    int i4 = oi0iixio.f1125oIX0oI;
                                    if (i4 != 34 && i4 != 39) {
                                        if (i4 == -2) {
                                            parseInt2 = oi0iixio.f1121II0xO0;
                                        } else {
                                            throw new XPathException(xxx2, "right hand side of greater-than", oi0iixio, "quoted string or number");
                                        }
                                    } else {
                                        parseInt2 = Integer.parseInt(oi0iixio.f1119I0Io);
                                    }
                                    oi0iixio.oIX0oI();
                                    return new XO(str, parseInt2);
                                default:
                                    return new oxoX(str);
                            }
                        }
                        oi0iixio.oIX0oI();
                        if (oi0iixio.f1125oIX0oI == 61) {
                            oi0iixio.oIX0oI();
                            int i5 = oi0iixio.f1125oIX0oI;
                            if (i5 != 34 && i5 != 39) {
                                throw new XPathException(xxx2, "right hand side of !=", oi0iixio, "quoted string");
                            }
                            String str3 = oi0iixio.f1119I0Io;
                            oi0iixio.oIX0oI();
                            return new II0XooXoX(str, str3);
                        }
                        throw new XPathException(xxx2, "after !", oi0iixio, "=");
                    }
                    throw new XPathException(xxx2, "after @", oi0iixio, "name");
                }
                throw new XPathException(xxx2, "at beginning of expression", oi0iixio, "@, number, or text()");
            }
            int i6 = oi0iixio.f1121II0xO0;
            oi0iixio.oIX0oI();
            return new Oxx0xo(i6);
        }
        if (oi0iixio.f1119I0Io.equals("text")) {
            if (oi0iixio.oIX0oI() == 40) {
                if (oi0iixio.oIX0oI() == 41) {
                    int oIX0oI3 = oi0iixio.oIX0oI();
                    if (oIX0oI3 != 33) {
                        if (oIX0oI3 != 61) {
                            return o00.f1113oIX0oI;
                        }
                        oi0iixio.oIX0oI();
                        int i7 = oi0iixio.f1125oIX0oI;
                        if (i7 != 34 && i7 != 39) {
                            throw new XPathException(xxx2, "right hand side of equals", oi0iixio, "quoted string");
                        }
                        String str4 = oi0iixio.f1119I0Io;
                        oi0iixio.oIX0oI();
                        return new xoXoI(str4);
                    }
                    oi0iixio.oIX0oI();
                    if (oi0iixio.f1125oIX0oI == 61) {
                        oi0iixio.oIX0oI();
                        int i8 = oi0iixio.f1125oIX0oI;
                        if (i8 != 34 && i8 != 39) {
                            throw new XPathException(xxx2, "right hand side of !=", oi0iixio, "quoted string");
                        }
                        String str5 = oi0iixio.f1119I0Io;
                        oi0iixio.oIX0oI();
                        return new OxI(str5);
                    }
                    throw new XPathException(xxx2, "after !", oi0iixio, "=");
                }
                throw new XPathException(xxx2, "after text(", oi0iixio, oIX0oI.I0Io.f4095I0Io);
            }
            throw new XPathException(xxx2, "after text", oi0iixio, oIX0oI.I0Io.f4096II0xO0);
        }
        throw new XPathException(xxx2, "at beginning of expression", oi0iixio, "text()");
    }
}
