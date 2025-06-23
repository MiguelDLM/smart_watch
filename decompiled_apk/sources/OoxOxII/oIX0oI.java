package OoxOxII;

import java.util.Iterator;
import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.AttributeNotFoundException;
import javax.management.DynamicMBean;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanRegistration;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.RuntimeOperationsException;
import org.apache.log4j.x0xO0oo;

/* loaded from: classes6.dex */
public abstract class oIX0oI implements DynamicMBean, MBeanRegistration {

    /* renamed from: II0xO0, reason: collision with root package name */
    public MBeanServer f2733II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f2734oIX0oI;

    public abstract Object I0Io(String str) throws AttributeNotFoundException, MBeanException, ReflectionException;

    public void II0XooXoX() {
        X0o0xo().xxIXOIIO("postDeregister is called.");
    }

    public ObjectName OOXIXo(MBeanServer mBeanServer, ObjectName objectName) {
        x0xO0oo X0o0xo2 = X0o0xo();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("preRegister called. Server=");
        stringBuffer.append(mBeanServer);
        stringBuffer.append(", name=");
        stringBuffer.append(objectName);
        X0o0xo2.xxIXOIIO(stringBuffer.toString());
        this.f2733II0xO0 = mBeanServer;
        return objectName;
    }

    public abstract Object Oxx0IOOO(String str, Object[] objArr, String[] strArr) throws MBeanException, ReflectionException;

    public abstract x0xO0oo X0o0xo();

    public abstract MBeanInfo XO();

    public abstract void oOoXoXO(Attribute attribute) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException;

    public AttributeList ooOOo0oXI(AttributeList attributeList) {
        if (attributeList != null) {
            AttributeList attributeList2 = new AttributeList();
            if (attributeList.isEmpty()) {
                return attributeList2;
            }
            Iterator it = attributeList.iterator();
            while (it.hasNext()) {
                Attribute attribute = (Attribute) it.next();
                try {
                    oOoXoXO(attribute);
                    String name = attribute.getName();
                    attributeList2.add(new Attribute(name, I0Io(name)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return attributeList2;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("AttributeList attributes cannot be null");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Cannot invoke a setter of ");
        stringBuffer.append(this.f2734oIX0oI);
        throw new RuntimeOperationsException(illegalArgumentException, stringBuffer.toString());
    }

    public AttributeList oxoX(String[] strArr) {
        if (strArr != null) {
            AttributeList attributeList = new AttributeList();
            if (strArr.length == 0) {
                return attributeList;
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    attributeList.add(new Attribute(strArr[i], I0Io(strArr[i])));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return attributeList;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("attributeNames[] cannot be null");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Cannot invoke a getter of ");
        stringBuffer.append(this.f2734oIX0oI);
        throw new RuntimeOperationsException(illegalArgumentException, stringBuffer.toString());
    }

    public void xoIox() {
        X0o0xo().xxIXOIIO("preDeregister called.");
    }

    public void xxIXOIIO(Boolean bool) {
    }
}
