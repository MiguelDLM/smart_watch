package xOI0;

import Xxx0oXX.II0xO0;
import org.xml.sax.Attributes;

/* loaded from: classes6.dex */
public class oIX0oI implements II0xO0 {
    @Override // Xxx0oXX.II0xO0
    public String oIX0oI(Object obj) {
        if (obj instanceof Attributes) {
            StringBuffer stringBuffer = new StringBuffer();
            Attributes attributes = (Attributes) obj;
            int length = attributes.getLength();
            boolean z = true;
            for (int i = 0; i < length; i++) {
                if (z) {
                    z = false;
                } else {
                    stringBuffer.append(", ");
                }
                stringBuffer.append(attributes.getQName(i));
                stringBuffer.append('=');
                stringBuffer.append(attributes.getValue(i));
            }
            return stringBuffer.toString();
        }
        return obj.toString();
    }
}
