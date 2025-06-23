package OoxOxII;

import java.util.Enumeration;
import java.util.Vector;
import javax.management.Attribute;
import javax.management.AttributeNotFoundException;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanConstructorInfo;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;
import javax.management.Notification;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.RuntimeOperationsException;
import org.apache.log4j.Level;
import org.apache.log4j.helpers.oOoXoXO;
import org.apache.log4j.x0xO0oo;

/* loaded from: classes6.dex */
public class XO extends oIX0oI implements NotificationListener {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static /* synthetic */ Class f2724OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static /* synthetic */ Class f2725xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static x0xO0oo f2726xxIXOIIO;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public x0xO0oo f2728II0XooXoX;

    /* renamed from: I0Io, reason: collision with root package name */
    public MBeanConstructorInfo[] f2727I0Io = new MBeanConstructorInfo[1];

    /* renamed from: oxoX, reason: collision with root package name */
    public MBeanOperationInfo[] f2732oxoX = new MBeanOperationInfo[1];

    /* renamed from: X0o0xo, reason: collision with root package name */
    public Vector f2730X0o0xo = new Vector();

    /* renamed from: XO, reason: collision with root package name */
    public String f2731XO = getClass().getName();

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public String f2729Oxx0IOOO = "This MBean acts as a management facade for a org.apache.log4j.Logger instance.";

    static {
        Class cls = f2725xoIox;
        if (cls == null) {
            cls = Oo("org.apache.log4j.jmx.LoggerDynamicMBean");
            f2725xoIox = cls;
        }
        f2726xxIXOIIO = x0xO0oo.xo0x(cls);
    }

    public XO(x0xO0oo x0xo0oo) {
        this.f2728II0XooXoX = x0xo0oo;
        x0xO0oo();
    }

    public static /* synthetic */ Class Oo(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private void x0xO0oo() {
        this.f2727I0Io[0] = new MBeanConstructorInfo("HierarchyDynamicMBean(): Constructs a HierarchyDynamicMBean instance", getClass().getConstructors()[0]);
        this.f2730X0o0xo.add(new MBeanAttributeInfo("name", "java.lang.String", "The name of this Logger.", true, false, false));
        this.f2730X0o0xo.add(new MBeanAttributeInfo("priority", "java.lang.String", "The priority of this logger.", true, true, false));
        this.f2732oxoX[0] = new MBeanOperationInfo("addAppender", "addAppender(): add an appender", new MBeanParameterInfo[]{new MBeanParameterInfo("class name", "java.lang.String", "add an appender to this logger"), new MBeanParameterInfo("appender name", "java.lang.String", "name of the appender")}, "void", 1);
    }

    @Override // OoxOxII.oIX0oI
    public Object I0Io(String str) throws AttributeNotFoundException, MBeanException, ReflectionException {
        if (str != null) {
            if (str.equals("name")) {
                return this.f2728II0XooXoX.xxX();
            }
            if (str.equals("priority")) {
                Level XI0IXoo2 = this.f2728II0XooXoX.XI0IXoo();
                if (XI0IXoo2 == null) {
                    return null;
                }
                return XI0IXoo2.toString();
            }
            if (str.startsWith("appender=")) {
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("log4j:");
                    stringBuffer.append(str);
                    return new ObjectName(stringBuffer.toString());
                } catch (Exception unused) {
                    x0xO0oo x0xo0oo = f2726xxIXOIIO;
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Could not create ObjectName");
                    stringBuffer2.append(str);
                    x0xo0oo.ooOOo0oXI(stringBuffer2.toString());
                }
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Cannot find ");
            stringBuffer3.append(str);
            stringBuffer3.append(" attribute in ");
            stringBuffer3.append(this.f2731XO);
            throw new AttributeNotFoundException(stringBuffer3.toString());
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Attribute name cannot be null");
        StringBuffer stringBuffer4 = new StringBuffer();
        stringBuffer4.append("Cannot invoke a getter of ");
        stringBuffer4.append(this.f2731XO);
        stringBuffer4.append(" with null attribute name");
        throw new RuntimeOperationsException(illegalArgumentException, stringBuffer4.toString());
    }

    public void IXxxXO(Notification notification, Object obj) {
        x0xO0oo x0xo0oo = f2726xxIXOIIO;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Received notification: ");
        stringBuffer.append(notification.getType());
        x0xo0oo.xxIXOIIO(stringBuffer.toString());
        Oxx0xo((org.apache.log4j.oIX0oI) notification.getUserData());
    }

    @Override // OoxOxII.oIX0oI
    public Object Oxx0IOOO(String str, Object[] objArr, String[] strArr) throws MBeanException, ReflectionException {
        if (str.equals("addAppender")) {
            x0XOIxOo((String) objArr[0], (String) objArr[1]);
            return "Hello world.";
        }
        return null;
    }

    public void Oxx0xo(org.apache.log4j.oIX0oI oix0oi) {
        String name = oix0oi.getName();
        x0xO0oo x0xo0oo = f2726xxIXOIIO;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Adding AppenderMBean for appender named ");
        stringBuffer.append(name);
        x0xo0oo.xxIXOIIO(stringBuffer.toString());
        try {
            this.f2733II0xO0.registerMBean(new I0Io(oix0oi), new ObjectName("log4j", O0IoXXOx.XO.f1186xxIXOIIO, name));
            Vector vector = this.f2730X0o0xo;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("appender=");
            stringBuffer2.append(name);
            String stringBuffer3 = stringBuffer2.toString();
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("The ");
            stringBuffer4.append(name);
            stringBuffer4.append(" appender.");
            vector.add(new MBeanAttributeInfo(stringBuffer3, "javax.management.ObjectName", stringBuffer4.toString(), true, true, false));
        } catch (Exception e) {
            x0xO0oo x0xo0oo2 = f2726xxIXOIIO;
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("Could not add appenderMBean for [");
            stringBuffer5.append(name);
            stringBuffer5.append("].");
            x0xo0oo2.x0XOIxOo(stringBuffer5.toString(), e);
        }
    }

    @Override // OoxOxII.oIX0oI
    public x0xO0oo X0o0xo() {
        return this.f2728II0XooXoX;
    }

    @Override // OoxOxII.oIX0oI
    public MBeanInfo XO() {
        MBeanAttributeInfo[] mBeanAttributeInfoArr = new MBeanAttributeInfo[this.f2730X0o0xo.size()];
        this.f2730X0o0xo.toArray(mBeanAttributeInfoArr);
        return new MBeanInfo(this.f2731XO, this.f2729Oxx0IOOO, mBeanAttributeInfoArr, this.f2727I0Io, this.f2732oxoX, new MBeanNotificationInfo[0]);
    }

    public void oO() {
        Enumeration OOXIXo2 = this.f2728II0XooXoX.OOXIXo();
        while (OOXIXo2.hasMoreElements()) {
            Oxx0xo((org.apache.log4j.oIX0oI) OOXIXo2.nextElement());
        }
    }

    @Override // OoxOxII.oIX0oI
    public void oOoXoXO(Attribute attribute) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
        Level ooOOo0oXI2;
        if (attribute != null) {
            String name = attribute.getName();
            Object value = attribute.getValue();
            if (name != null) {
                if (name.equals("priority")) {
                    if (value instanceof String) {
                        String str = (String) value;
                        Level XI0IXoo2 = this.f2728II0XooXoX.XI0IXoo();
                        if (str.equalsIgnoreCase(org.apache.log4j.helpers.X0o0xo.f33252II0XooXoX)) {
                            ooOOo0oXI2 = null;
                        } else {
                            ooOOo0oXI2 = oOoXoXO.ooOOo0oXI(str, XI0IXoo2);
                        }
                        this.f2728II0XooXoX.o0(ooOOo0oXI2);
                        return;
                    }
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Attribute ");
                stringBuffer.append(name);
                stringBuffer.append(" not found in ");
                stringBuffer.append(getClass().getName());
                throw new AttributeNotFoundException(stringBuffer.toString());
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Attribute name cannot be null");
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Cannot invoke the setter of ");
            stringBuffer2.append(this.f2731XO);
            stringBuffer2.append(" with null attribute name");
            throw new RuntimeOperationsException(illegalArgumentException, stringBuffer2.toString());
        }
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Attribute cannot be null");
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("Cannot invoke a setter of ");
        stringBuffer3.append(this.f2731XO);
        stringBuffer3.append(" with null attribute");
        throw new RuntimeOperationsException(illegalArgumentException2, stringBuffer3.toString());
    }

    public void x0XOIxOo(String str, String str2) {
        x0xO0oo x0xo0oo = f2726xxIXOIIO;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("addAppender called with ");
        stringBuffer.append(str);
        stringBuffer.append(", ");
        stringBuffer.append(str2);
        x0xo0oo.xxIXOIIO(stringBuffer.toString());
        Class cls = f2724OOXIXo;
        if (cls == null) {
            cls = Oo("org.apache.log4j.Appender");
            f2724OOXIXo = cls;
        }
        org.apache.log4j.oIX0oI oix0oi = (org.apache.log4j.oIX0oI) oOoXoXO.XO(str, cls, null);
        oix0oi.setName(str2);
        this.f2728II0XooXoX.oIX0oI(oix0oi);
    }

    @Override // OoxOxII.oIX0oI
    public void xxIXOIIO(Boolean bool) {
        oO();
    }
}
