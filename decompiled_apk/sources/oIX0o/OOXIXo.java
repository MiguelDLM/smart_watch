package oIX0o;

import org.apache.log4j.helpers.oOoXoXO;
import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public class OOXIXo extends org.apache.log4j.spi.XO {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final String f31624II0XooXoX = "AcceptOnMatch";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final String f31625Oxx0IOOO = "StringToMatch";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f31626X0o0xo = true;

    /* renamed from: XO, reason: collision with root package name */
    public String f31627XO;

    public String II0XooXoX() {
        return this.f31627XO;
    }

    public void OOXIXo(String str) {
        this.f31627XO = str;
    }

    public String[] Oxx0IOOO() {
        return new String[]{f31625Oxx0IOOO, f31624II0XooXoX};
    }

    public boolean X0o0xo() {
        return this.f31626X0o0xo;
    }

    @Override // org.apache.log4j.spi.XO
    public int oIX0oI(LoggingEvent loggingEvent) {
        String str;
        String renderedMessage = loggingEvent.getRenderedMessage();
        if (renderedMessage == null || (str = this.f31627XO) == null || renderedMessage.indexOf(str) == -1) {
            return 0;
        }
        if (!this.f31626X0o0xo) {
            return -1;
        }
        return 1;
    }

    public void xoIox(String str, String str2) {
        if (str.equalsIgnoreCase(f31625Oxx0IOOO)) {
            this.f31627XO = str2;
        } else if (str.equalsIgnoreCase(f31624II0XooXoX)) {
            this.f31626X0o0xo = oOoXoXO.xoIox(str2, this.f31626X0o0xo);
        }
    }

    public void xxIXOIIO(boolean z) {
        this.f31626X0o0xo = z;
    }
}
