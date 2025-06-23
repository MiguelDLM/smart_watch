package OIII0O;

import java.util.Properties;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public class II0xO0 extends org.apache.log4j.II0xO0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public String f1535II0XooXoX;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public TopicConnection f1536IXxxXO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public String f1537OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public boolean f1538Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public TopicSession f1539Oxx0xo;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public TopicPublisher f1540oI0IIXIo;

    /* renamed from: oO, reason: collision with root package name */
    public String f1541oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public String f1542oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public String f1543ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public String f1544x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public String f1545x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public String f1546xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public String f1547xxIXOIIO;

    public void I0oOoX(String str) {
        this.f1537OOXIXo = str;
    }

    public String IIX0o() {
        return this.f1535II0XooXoX;
    }

    @Override // org.apache.log4j.II0xO0
    public void IIXOooo(LoggingEvent loggingEvent) {
        if (!X0IIOO()) {
            return;
        }
        try {
            ObjectMessage createObjectMessage = this.f1539Oxx0xo.createObjectMessage();
            if (this.f1538Oo) {
                loggingEvent.getLocationInformation();
            }
            createObjectMessage.setObject(loggingEvent);
            this.f1540oI0IIXIo.publish(createObjectMessage);
        } catch (Exception e) {
            org.apache.log4j.spi.X0o0xo x0o0xo = this.f33162oxoX;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not publish message in JMSAppender [");
            stringBuffer.append(this.f33157II0xO0);
            stringBuffer.append("].");
            x0o0xo.OxxIIOOXO(stringBuffer.toString(), e, 0);
        }
    }

    public void IO(String str) {
        this.f1546xoIox = str;
    }

    public void Io(String str) {
        this.f1535II0XooXoX = str;
    }

    public TopicSession IoOoX() {
        return this.f1539Oxx0xo;
    }

    public void OI0(String str) {
        this.f1547xxIXOIIO = str;
    }

    public Object X00IoxXI(Context context, String str) throws NamingException {
        try {
            return context.lookup(str);
        } catch (NameNotFoundException e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not find name [");
            stringBuffer.append(str);
            stringBuffer.append("].");
            org.apache.log4j.helpers.xxIXOIIO.I0Io(stringBuffer.toString());
            throw e;
        }
    }

    public boolean X0IIOO() {
        String str;
        if (this.f1536IXxxXO == null) {
            str = "No TopicConnection";
        } else if (this.f1539Oxx0xo == null) {
            str = "No TopicSession";
        } else if (this.f1540oI0IIXIo == null) {
            str = "No TopicPublisher";
        } else {
            str = null;
        }
        if (str != null) {
            org.apache.log4j.spi.X0o0xo x0o0xo = this.f33162oxoX;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(" for JMSAppender named [");
            stringBuffer.append(this.f33157II0xO0);
            stringBuffer.append("].");
            x0o0xo.error(stringBuffer.toString());
            return false;
        }
        return true;
    }

    public String XI0IXoo() {
        return this.f1546xoIox;
    }

    public boolean XIxXXX0x0() {
        return this.f1538Oo;
    }

    public void XOxIOxOx(String str) {
        this.f1542oOoXoXO = str;
    }

    public void XX(String str) {
        this.f1544x0XOIxOo = str;
    }

    public String Xx000oIo() {
        return this.f1541oO;
    }

    public String XxX0x0xxx() {
        return this.f1542oOoXoXO;
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.oIX0oI
    public synchronized void close() {
        try {
            if (this.f33158Oxx0IOOO) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Closing appender [");
            stringBuffer.append(this.f33157II0xO0);
            stringBuffer.append("].");
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
            this.f33158Oxx0IOOO = true;
            try {
                TopicSession topicSession = this.f1539Oxx0xo;
                if (topicSession != null) {
                    topicSession.close();
                }
                TopicConnection topicConnection = this.f1536IXxxXO;
                if (topicConnection != null) {
                    topicConnection.close();
                }
            } catch (Exception e) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Error while closing JMSAppender [");
                stringBuffer2.append(this.f33157II0xO0);
                stringBuffer2.append("].");
                org.apache.log4j.helpers.xxIXOIIO.oxoX(stringBuffer2.toString(), e);
            }
            this.f1540oI0IIXIo = null;
            this.f1539Oxx0xo = null;
            this.f1536IXxxXO = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void o0(String str) {
        this.f1543ooOOo0oXI = str;
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.spi.OOXIXo
    public void oI0IIXIo() {
        InitialContext initialContext;
        TopicConnection createTopicConnection;
        try {
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI("Getting initial context.");
            if (this.f1546xoIox != null) {
                Properties properties = new Properties();
                properties.put("java.naming.factory.initial", this.f1546xoIox);
                String str = this.f1542oOoXoXO;
                if (str != null) {
                    properties.put("java.naming.provider.url", str);
                } else {
                    org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO("You have set InitialContextFactoryName option but not the ProviderURL. This is likely to cause problems.");
                }
                String str2 = this.f1537OOXIXo;
                if (str2 != null) {
                    properties.put("java.naming.factory.url.pkgs", str2);
                }
                String str3 = this.f1535II0XooXoX;
                if (str3 != null) {
                    properties.put("java.naming.security.principal", str3);
                    String str4 = this.f1547xxIXOIIO;
                    if (str4 != null) {
                        properties.put("java.naming.security.credentials", str4);
                    } else {
                        org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO("You have set SecurityPrincipalName option but not the SecurityCredentials. This is likely to cause problems.");
                    }
                }
                initialContext = new InitialContext(properties);
            } else {
                initialContext = new InitialContext();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Looking up [");
            stringBuffer.append(this.f1544x0XOIxOo);
            stringBuffer.append("]");
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
            TopicConnectionFactory topicConnectionFactory = (TopicConnectionFactory) X00IoxXI(initialContext, this.f1544x0XOIxOo);
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI("About to create TopicConnection.");
            String str5 = this.f1541oO;
            if (str5 != null) {
                createTopicConnection = topicConnectionFactory.createTopicConnection(str5, this.f1545x0xO0oo);
            } else {
                createTopicConnection = topicConnectionFactory.createTopicConnection();
            }
            this.f1536IXxxXO = createTopicConnection;
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI("Creating TopicSession, non-transactional, in AUTO_ACKNOWLEDGE mode.");
            this.f1539Oxx0xo = this.f1536IXxxXO.createTopicSession(false, 1);
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Looking up topic name [");
            stringBuffer2.append(this.f1543ooOOo0oXI);
            stringBuffer2.append("].");
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer2.toString());
            Topic topic = (Topic) X00IoxXI(initialContext, this.f1543ooOOo0oXI);
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI("Creating TopicPublisher.");
            this.f1540oI0IIXIo = this.f1539Oxx0xo.createPublisher(topic);
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI("Starting TopicConnection.");
            this.f1536IXxxXO.start();
            initialContext.close();
        } catch (Exception e) {
            org.apache.log4j.spi.X0o0xo x0o0xo = this.f33162oxoX;
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Error while activating options for appender named [");
            stringBuffer3.append(this.f33157II0xO0);
            stringBuffer3.append("].");
            x0o0xo.OxxIIOOXO(stringBuffer3.toString(), e, 0);
        }
    }

    public String oOXoIIIo() {
        return this.f1537OOXIXo;
    }

    public TopicPublisher oo() {
        return this.f1540oI0IIXIo;
    }

    public String oo0xXOI0I() {
        return this.f1544x0XOIxOo;
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.oIX0oI
    public boolean ooOOo0oXI() {
        return false;
    }

    public String ooXIXxIX() {
        return this.f1543ooOOo0oXI;
    }

    public void oxxXoxO(String str) {
        this.f1541oO = str;
    }

    public void x0o(String str) {
        this.f1545x0xO0oo = str;
    }

    public TopicConnection xI() {
        return this.f1536IXxxXO;
    }

    public void xII(boolean z) {
        this.f1538Oo = z;
    }

    public String xXxxox0I() {
        return this.f1547xxIXOIIO;
    }

    public String xxX() {
        return this.f1545x0xO0oo;
    }
}
