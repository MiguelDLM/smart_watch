package O0;

import com.hp.hpl.sparta.xpath.XPathException;
import java.io.IOException;

/* loaded from: classes10.dex */
public class OxxIIOOXO {

    /* renamed from: oxoX, reason: collision with root package name */
    public static OxxIIOOXO f1106oxoX = new OxxIIOOXO(X0IIOO.f1110oIX0oI, XI0IXoo.f1112oIX0oI);

    /* renamed from: I0Io, reason: collision with root package name */
    public final boolean f1107I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final OOXIXo f1108II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final oO f1109oIX0oI;

    public OxxIIOOXO(oO oOVar, OOXIXo oOXIXo) {
        this.f1109oIX0oI = oOVar;
        this.f1108II0xO0 = oOXIXo;
        this.f1107I0Io = false;
    }

    public boolean I0Io() {
        return this.f1107I0Io;
    }

    public OOXIXo II0xO0() {
        return this.f1108II0xO0;
    }

    public oO oIX0oI() {
        return this.f1109oIX0oI;
    }

    public boolean oxoX() {
        return this.f1109oIX0oI.II0xO0();
    }

    public String toString() {
        return this.f1109oIX0oI.toString() + this.f1108II0xO0.toString();
    }

    public OxxIIOOXO(xxX xxx2, boolean z, oI0IIXIo oi0iixio) throws XPathException, IOException {
        this.f1107I0Io = z;
        int i = oi0iixio.f1125oIX0oI;
        if (i != -3) {
            if (i == 42) {
                this.f1109oIX0oI = oIX0oI.f1128oIX0oI;
            } else if (i != 46) {
                if (i == 64) {
                    if (oi0iixio.oIX0oI() == -3) {
                        this.f1109oIX0oI = new xoIox(oi0iixio.f1119I0Io);
                    } else {
                        throw new XPathException(xxx2, "after @ in node test", oi0iixio, "name");
                    }
                } else {
                    throw new XPathException(xxx2, "at begininning of step", oi0iixio, "'.' or '*' or name");
                }
            } else if (oi0iixio.oIX0oI() == 46) {
                this.f1109oIX0oI = IXxxXO.f1103oIX0oI;
            } else {
                oi0iixio.I0Io();
                this.f1109oIX0oI = X0IIOO.f1110oIX0oI;
            }
        } else if (oi0iixio.f1119I0Io.equals("text")) {
            if (oi0iixio.oIX0oI() == 40 && oi0iixio.oIX0oI() == 41) {
                this.f1109oIX0oI = O0xOxO.f1104oIX0oI;
            } else {
                throw new XPathException(xxx2, "after text", oi0iixio, "()");
            }
        } else {
            this.f1109oIX0oI = new ooOOo0oXI(oi0iixio.f1119I0Io);
        }
        if (oi0iixio.oIX0oI() == 91) {
            oi0iixio.oIX0oI();
            this.f1108II0xO0 = x0XOIxOo.oIX0oI(xxx2, oi0iixio);
            if (oi0iixio.f1125oIX0oI == 93) {
                oi0iixio.oIX0oI();
                return;
            }
            throw new XPathException(xxx2, "after predicate expression", oi0iixio, "]");
        }
        this.f1108II0xO0 = XI0IXoo.f1112oIX0oI;
    }
}
