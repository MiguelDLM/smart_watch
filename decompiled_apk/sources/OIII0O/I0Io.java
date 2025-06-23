package OIII0O;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import org.apache.log4j.IIXOooo;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.x0xO0oo;

/* loaded from: classes6.dex */
public class I0Io implements MessageListener {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static /* synthetic */ Class f1523II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static x0xO0oo f1524oIX0oI;

    static {
        Class cls = f1523II0xO0;
        if (cls == null) {
            cls = oIX0oI("org.apache.log4j.net.JMSSink");
            f1523II0xO0 = cls;
        }
        f1524oIX0oI = x0xO0oo.xo0x(cls);
    }

    public I0Io(String str, String str2, String str3, String str4) {
        try {
            InitialContext initialContext = new InitialContext();
            TopicConnection createTopicConnection = ((TopicConnectionFactory) II0xO0(initialContext, str)).createTopicConnection(str3, str4);
            createTopicConnection.start();
            createTopicConnection.createTopicSession(false, 1).createSubscriber((Topic) initialContext.lookup(str2)).setMessageListener(this);
        } catch (Exception e) {
            f1524oIX0oI.x0XOIxOo("Could not read JMS message.", e);
        }
    }

    public static void I0Io(String[] strArr) throws Exception {
        if (strArr.length != 5) {
            X0o0xo("Wrong number of arguments.");
        }
        String str = strArr[0];
        String str2 = strArr[1];
        String str3 = strArr[2];
        String str4 = strArr[3];
        String str5 = strArr[4];
        if (str5.endsWith(".xml")) {
            new O0IoXXOx.XO();
            O0IoXXOx.XO.I0Io(str5);
        } else {
            new IIXOooo();
            IIXOooo.I0Io(str5);
        }
        new I0Io(str, str2, str3, str4);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Type \"exit\" to quit JMSSink.");
        do {
        } while (!bufferedReader.readLine().equalsIgnoreCase("exit"));
        System.out.println("Exiting. Kill the application if it does not exit due to daemon threads.");
    }

    public static Object II0xO0(Context context, String str) throws NamingException {
        try {
            return context.lookup(str);
        } catch (NameNotFoundException e) {
            x0xO0oo x0xo0oo = f1524oIX0oI;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not find name [");
            stringBuffer.append(str);
            stringBuffer.append("].");
            x0xo0oo.ooOOo0oXI(stringBuffer.toString());
            throw e;
        }
    }

    public static void X0o0xo(String str) {
        PrintStream printStream = System.err;
        printStream.println(str);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Usage: java ");
        Class cls = f1523II0xO0;
        if (cls == null) {
            cls = oIX0oI("org.apache.log4j.net.JMSSink");
            f1523II0xO0 = cls;
        }
        stringBuffer.append(cls.getName());
        stringBuffer.append(" TopicConnectionFactoryBindingName TopicBindingName username password configFile");
        printStream.println(stringBuffer.toString());
        System.exit(1);
    }

    public static /* synthetic */ Class oIX0oI(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public void oxoX(Message message) {
        try {
            if (message instanceof ObjectMessage) {
                LoggingEvent loggingEvent = (LoggingEvent) ((ObjectMessage) message).getObject();
                x0xO0oo.xXOx(loggingEvent.getLoggerName()).I0Io(loggingEvent);
            } else {
                x0xO0oo x0xo0oo = f1524oIX0oI;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Received message is of type ");
                stringBuffer.append(message.getJMSType());
                stringBuffer.append(", was expecting ObjectMessage.");
                x0xo0oo.XoX(stringBuffer.toString());
            }
        } catch (JMSException e) {
            f1524oIX0oI.x0XOIxOo("Exception thrown while processing incoming message.", e);
        }
    }
}
