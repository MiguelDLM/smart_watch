package XXoO0oX;

import Xxx0oXX.II0xO0;
import javax.jms.JMSException;
import javax.jms.Message;
import org.apache.log4j.helpers.xxIXOIIO;

/* loaded from: classes6.dex */
public class oIX0oI implements II0xO0 {
    @Override // Xxx0oXX.II0xO0
    public String oIX0oI(Object obj) {
        String str;
        if (obj instanceof Message) {
            StringBuffer stringBuffer = new StringBuffer();
            Message message = (Message) obj;
            try {
                stringBuffer.append("DeliveryMode=");
                int jMSDeliveryMode = message.getJMSDeliveryMode();
                if (jMSDeliveryMode != 1) {
                    if (jMSDeliveryMode != 2) {
                        str = "UNKNOWN";
                    } else {
                        str = "PERSISTENT";
                    }
                } else {
                    str = "NON_PERSISTENT";
                }
                stringBuffer.append(str);
                stringBuffer.append(", CorrelationID=");
                stringBuffer.append(message.getJMSCorrelationID());
                stringBuffer.append(", Destination=");
                stringBuffer.append(message.getJMSDestination());
                stringBuffer.append(", Expiration=");
                stringBuffer.append(message.getJMSExpiration());
                stringBuffer.append(", MessageID=");
                stringBuffer.append(message.getJMSMessageID());
                stringBuffer.append(", Priority=");
                stringBuffer.append(message.getJMSPriority());
                stringBuffer.append(", Redelivered=");
                stringBuffer.append(message.getJMSRedelivered());
                stringBuffer.append(", ReplyTo=");
                stringBuffer.append(message.getJMSReplyTo());
                stringBuffer.append(", Timestamp=");
                stringBuffer.append(message.getJMSTimestamp());
                stringBuffer.append(", Type=");
                stringBuffer.append(message.getJMSType());
            } catch (JMSException e) {
                xxIXOIIO.oxoX("Could not parse Message.", e);
            }
            return stringBuffer.toString();
        }
        return obj.toString();
    }
}
