package OIII0O;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.x0xO0oo;
import org.apache.log4j.x0XOIxOo;

/* loaded from: classes6.dex */
public class X0o0xo extends org.apache.log4j.II0xO0 {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static /* synthetic */ Class f1589IIXOooo;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public String f1590II0XooXoX;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f1591IXxxXO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public String f1592OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public int f1593Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public org.apache.log4j.helpers.oxoX f1594Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public x0xO0oo f1595OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public Message f1596oI0IIXIo;

    /* renamed from: oO, reason: collision with root package name */
    public String f1597oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public String f1598oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public String f1599ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public String f1600x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public boolean f1601x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public String f1602xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public String f1603xxIXOIIO;

    public X0o0xo() {
        this(new oIX0oI());
    }

    public static /* synthetic */ Class XxX0x0xxx(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public void I0X0x0oIo(String str) {
        this.f1600x0XOIxOo = str;
    }

    public void I0oOoX(String str) {
        this.f1603xxIXOIIO = str;
    }

    public InternetAddress IIX0o(String str) {
        try {
            return new InternetAddress(str);
        } catch (AddressException e) {
            org.apache.log4j.spi.X0o0xo x0o0xo = this.f33162oxoX;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not parse address [");
            stringBuffer.append(str);
            stringBuffer.append("].");
            x0o0xo.OxxIIOOXO(stringBuffer.toString(), e, 6);
            return null;
        }
    }

    @Override // org.apache.log4j.II0xO0
    public void IIXOooo(LoggingEvent loggingEvent) {
        if (!xxX()) {
            return;
        }
        loggingEvent.getThreadName();
        loggingEvent.getNDC();
        loggingEvent.getMDCCopy();
        if (this.f1591IXxxXO) {
            loggingEvent.getLocationInformation();
        }
        this.f1594Oxx0xo.oIX0oI(loggingEvent);
        if (this.f1595OxxIIOOXO.oIX0oI(loggingEvent)) {
            Io();
        }
    }

    public String IO() {
        return this.f1597oO;
    }

    public void Io() {
        String[] throwableStrRep;
        try {
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            StringBuffer stringBuffer = new StringBuffer();
            String X0o0xo2 = this.f33161oIX0oI.X0o0xo();
            if (X0o0xo2 != null) {
                stringBuffer.append(X0o0xo2);
            }
            int X0o0xo3 = this.f1594Oxx0xo.X0o0xo();
            for (int i = 0; i < X0o0xo3; i++) {
                LoggingEvent II0xO02 = this.f1594Oxx0xo.II0xO0();
                stringBuffer.append(this.f33161oIX0oI.oIX0oI(II0xO02));
                if (this.f33161oIX0oI.Oxx0IOOO() && (throwableStrRep = II0xO02.getThrowableStrRep()) != null) {
                    for (String str : throwableStrRep) {
                        stringBuffer.append(str);
                        stringBuffer.append(x0XOIxOo.f33503oIX0oI);
                    }
                }
            }
            String oxoX2 = this.f33161oIX0oI.oxoX();
            if (oxoX2 != null) {
                stringBuffer.append(oxoX2);
            }
            mimeBodyPart.setContent(stringBuffer.toString(), this.f33161oIX0oI.I0Io());
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(mimeBodyPart);
            this.f1596oI0IIXIo.setContent(mimeMultipart);
            this.f1596oI0IIXIo.setSentDate(new Date());
            Transport.send(this.f1596oI0IIXIo);
        } catch (Exception e) {
            org.apache.log4j.helpers.xxIXOIIO.oxoX("Error occured while sending e-mail notification.", e);
        }
    }

    public String IoOoX() {
        return this.f1592OOXIXo;
    }

    public InternetAddress[] OI0(String str) {
        try {
            return InternetAddress.parse(str, true);
        } catch (AddressException e) {
            org.apache.log4j.spi.X0o0xo x0o0xo = this.f33162oxoX;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not parse address [");
            stringBuffer.append(str);
            stringBuffer.append("].");
            x0o0xo.OxxIIOOXO(stringBuffer.toString(), e, 6);
            return null;
        }
    }

    public String X00IoxXI() {
        return this.f1599ooOOo0oXI;
    }

    public void XIxXXX0x0(Message message) throws MessagingException {
        String str = this.f1592OOXIXo;
        if (str != null) {
            message.setFrom(IIX0o(str));
        } else {
            message.setFrom();
        }
        String str2 = this.f1590II0XooXoX;
        if (str2 != null && str2.length() > 0) {
            message.setRecipients(Message.RecipientType.TO, OI0(this.f1590II0XooXoX));
        }
        String str3 = this.f1603xxIXOIIO;
        if (str3 != null && str3.length() > 0) {
            message.setRecipients(Message.RecipientType.CC, OI0(this.f1603xxIXOIIO));
        }
        String str4 = this.f1602xoIox;
        if (str4 != null && str4.length() > 0) {
            message.setRecipients(Message.RecipientType.BCC, OI0(this.f1602xoIox));
        }
    }

    public String XOxIOxOx() {
        return this.f1590II0XooXoX;
    }

    public void XX(int i) {
        this.f1593Oo = i;
        this.f1594Oxx0xo.XO(i);
    }

    public void XX0(String str) {
        this.f1597oO = str;
    }

    public void Xo0(String str) {
        this.f1590II0XooXoX = str;
    }

    public void XoX(String str) {
        this.f1592OOXIXo = str;
    }

    public boolean Xx000oIo() {
        return this.f1601x0xO0oo;
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.oIX0oI
    public synchronized void close() {
        this.f33158Oxx0IOOO = true;
    }

    public void o0(String str) {
        this.f1602xoIox = str;
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.spi.OOXIXo
    public void oI0IIXIo() {
        MimeMessage mimeMessage = new MimeMessage(xXxxox0I());
        this.f1596oI0IIXIo = mimeMessage;
        try {
            XIxXXX0x0(mimeMessage);
            String str = this.f1598oOoXoXO;
            if (str != null) {
                this.f1596oI0IIXIo.setSubject(str);
            }
        } catch (MessagingException e) {
            org.apache.log4j.helpers.xxIXOIIO.oxoX("Could not activate SMTPAppender options.", e);
        }
    }

    public boolean oOXoIIIo() {
        return this.f1591IXxxXO;
    }

    public void oX(String str) {
        this.f1598oOoXoXO = str;
    }

    public String oo() {
        x0xO0oo x0xo0oo = this.f1595OxxIIOOXO;
        if (x0xo0oo == null) {
            return null;
        }
        return x0xo0oo.getClass().getName();
    }

    public String oo0xXOI0I() {
        return this.f1603xxIXOIIO;
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.oIX0oI
    public boolean ooOOo0oXI() {
        return true;
    }

    public String ooXIXxIX() {
        return this.f1602xoIox;
    }

    public void oxXx0IX(boolean z) {
        this.f1591IXxxXO = z;
    }

    public void oxxXoxO(String str) {
        Class cls = f1589IIXOooo;
        if (cls == null) {
            cls = XxX0x0xxx("org.apache.log4j.spi.TriggeringEventEvaluator");
            f1589IIXOooo = cls;
        }
        this.f1595OxxIIOOXO = (x0xO0oo) org.apache.log4j.helpers.oOoXoXO.XO(str, cls, this.f1595OxxIIOOXO);
    }

    public String x0o() {
        return this.f1598oOoXoXO;
    }

    public int xI() {
        return this.f1593Oo;
    }

    public String xII() {
        return this.f1600x0XOIxOo;
    }

    public void xXOx(String str) {
        this.f1599ooOOo0oXI = str;
    }

    public Session xXxxox0I() {
        Properties properties;
        oxoX oxox;
        try {
            properties = new Properties(System.getProperties());
        } catch (SecurityException unused) {
            properties = new Properties();
        }
        String str = this.f1599ooOOo0oXI;
        if (str != null) {
            properties.put("mail.smtp.host", str);
        }
        if (this.f1597oO != null && this.f1600x0XOIxOo != null) {
            properties.put("mail.smtp.auth", "true");
            oxox = new oxoX(this);
        } else {
            oxox = null;
        }
        Session session = Session.getInstance(properties, oxox);
        boolean z = this.f1601x0xO0oo;
        if (z) {
            session.setDebug(z);
        }
        return session;
    }

    public void xo0x(boolean z) {
        this.f1601x0xO0oo = z;
    }

    public boolean xxX() {
        org.apache.log4j.spi.X0o0xo x0o0xo;
        StringBuffer stringBuffer;
        String str;
        String stringBuffer2;
        if (this.f1596oI0IIXIo == null) {
            x0o0xo = this.f33162oxoX;
            stringBuffer2 = "Message object not configured.";
        } else {
            if (this.f1595OxxIIOOXO == null) {
                x0o0xo = this.f33162oxoX;
                stringBuffer = new StringBuffer();
                str = "No TriggeringEventEvaluator is set for appender [";
            } else if (this.f33161oIX0oI == null) {
                x0o0xo = this.f33162oxoX;
                stringBuffer = new StringBuffer();
                str = "No layout set for appender named [";
            } else {
                return true;
            }
            stringBuffer.append(str);
            stringBuffer.append(this.f33157II0xO0);
            stringBuffer.append("].");
            stringBuffer2 = stringBuffer.toString();
        }
        x0o0xo.error(stringBuffer2);
        return false;
    }

    public X0o0xo(x0xO0oo x0xo0oo) {
        this.f1601x0xO0oo = false;
        this.f1593Oo = 512;
        this.f1591IXxxXO = false;
        this.f1594Oxx0xo = new org.apache.log4j.helpers.oxoX(512);
        this.f1595OxxIIOOXO = x0xo0oo;
    }
}
