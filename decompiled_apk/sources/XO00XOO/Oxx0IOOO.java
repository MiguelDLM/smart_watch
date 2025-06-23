package XO00XOO;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.io.IOException;

/* loaded from: classes11.dex */
public final class Oxx0IOOO {

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f3871I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final String f3872II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Appendable f3876oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f3877oxoX;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final StringBuilder f3874X0o0xo = new StringBuilder();

    /* renamed from: XO, reason: collision with root package name */
    public int f3875XO = 0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f3873Oxx0IOOO = -1;

    public Oxx0IOOO(Appendable appendable, String str, int i) {
        oOoXoXO.I0Io(appendable, "out == null", new Object[0]);
        this.f3876oIX0oI = appendable;
        this.f3872II0xO0 = str;
        this.f3871I0Io = i;
    }

    public final void I0Io(boolean z) throws IOException {
        int i;
        if (z) {
            this.f3876oIX0oI.append('\n');
            int i2 = 0;
            while (true) {
                i = this.f3873Oxx0IOOO;
                if (i2 >= i) {
                    break;
                }
                this.f3876oIX0oI.append(this.f3872II0xO0);
                i2++;
            }
            int length = i * this.f3872II0xO0.length();
            this.f3875XO = length;
            this.f3875XO = length + this.f3874X0o0xo.length();
        } else {
            this.f3876oIX0oI.append(TokenParser.SP);
        }
        this.f3876oIX0oI.append(this.f3874X0o0xo);
        StringBuilder sb = this.f3874X0o0xo;
        sb.delete(0, sb.length());
        this.f3873Oxx0IOOO = -1;
    }

    public void II0xO0() throws IOException {
        if (this.f3873Oxx0IOOO != -1) {
            I0Io(false);
        }
        this.f3877oxoX = true;
    }

    public void oIX0oI(String str) throws IOException {
        int length;
        boolean z;
        if (!this.f3877oxoX) {
            if (this.f3873Oxx0IOOO != -1) {
                int indexOf = str.indexOf(10);
                if (indexOf == -1 && this.f3875XO + str.length() <= this.f3871I0Io) {
                    this.f3874X0o0xo.append(str);
                    this.f3875XO += str.length();
                    return;
                } else {
                    if (indexOf != -1 && this.f3875XO + indexOf <= this.f3871I0Io) {
                        z = false;
                    } else {
                        z = true;
                    }
                    I0Io(z);
                }
            }
            this.f3876oIX0oI.append(str);
            int lastIndexOf = str.lastIndexOf(10);
            if (lastIndexOf != -1) {
                length = (str.length() - lastIndexOf) - 1;
            } else {
                length = str.length() + this.f3875XO;
            }
            this.f3875XO = length;
            return;
        }
        throw new IllegalStateException("closed");
    }

    public void oxoX(int i) throws IOException {
        if (!this.f3877oxoX) {
            if (this.f3873Oxx0IOOO != -1) {
                I0Io(false);
            }
            this.f3875XO++;
            this.f3873Oxx0IOOO = i;
            return;
        }
        throw new IllegalStateException("closed");
    }
}
