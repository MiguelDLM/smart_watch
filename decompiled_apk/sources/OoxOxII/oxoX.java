package OoxOxII;

import java.util.Vector;
import javax.management.Attribute;
import javax.management.AttributeNotFoundException;
import javax.management.InvalidAttributeValueException;
import javax.management.ListenerNotFoundException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanConstructorInfo;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcaster;
import javax.management.NotificationBroadcasterSupport;
import javax.management.NotificationFilter;
import javax.management.NotificationFilterSupport;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.RuntimeOperationsException;
import org.apache.log4j.helpers.oOoXoXO;
import org.apache.log4j.oO;
import org.apache.log4j.spi.xxIXOIIO;
import org.apache.log4j.x0xO0oo;

/* loaded from: classes6.dex */
public class oxoX extends oIX0oI implements org.apache.log4j.spi.Oxx0IOOO, NotificationBroadcaster {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final String f2735OOXIXo = "threshold";

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static x0xO0oo f2736oOoXoXO = null;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static /* synthetic */ Class f2737ooOOo0oXI = null;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final String f2738xoIox = "addAppender.";

    /* renamed from: I0Io, reason: collision with root package name */
    public MBeanConstructorInfo[] f2739I0Io = new MBeanConstructorInfo[1];

    /* renamed from: oxoX, reason: collision with root package name */
    public MBeanOperationInfo[] f2744oxoX = new MBeanOperationInfo[1];

    /* renamed from: X0o0xo, reason: collision with root package name */
    public Vector f2742X0o0xo = new Vector();

    /* renamed from: XO, reason: collision with root package name */
    public String f2743XO = getClass().getName();

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public String f2741Oxx0IOOO = "This MBean acts as a management facade for org.apache.log4j.Hierarchy.";

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public NotificationBroadcasterSupport f2740II0XooXoX = new NotificationBroadcasterSupport();

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public xxIXOIIO f2745xxIXOIIO = oO.XO();

    static {
        Class cls = f2737ooOOo0oXI;
        if (cls == null) {
            cls = IXxxXO("org.apache.log4j.jmx.HierarchyDynamicMBean");
            f2737ooOOo0oXI = cls;
        }
        f2736oOoXoXO = x0xO0oo.xo0x(cls);
    }

    public oxoX() {
        Oo();
    }

    public static /* synthetic */ Class IXxxXO(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    @Override // OoxOxII.oIX0oI
    public Object I0Io(String str) throws AttributeNotFoundException, MBeanException, ReflectionException {
        String str2;
        if (str != null) {
            x0xO0oo x0xo0oo = f2736oOoXoXO;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Called getAttribute with [");
            stringBuffer.append(str);
            stringBuffer.append("].");
            x0xo0oo.xxIXOIIO(stringBuffer.toString());
            if (str.equals("threshold")) {
                return this.f2745xxIXOIIO.xoIox();
            }
            if (str.startsWith("logger")) {
                int indexOf = str.indexOf("%3D");
                if (indexOf > 0) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(str.substring(0, indexOf));
                    stringBuffer2.append('=');
                    stringBuffer2.append(str.substring(indexOf + 3));
                    str2 = stringBuffer2.toString();
                } else {
                    str2 = str;
                }
                try {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("log4j:");
                    stringBuffer3.append(str2);
                    return new ObjectName(stringBuffer3.toString());
                } catch (Exception unused) {
                    x0xO0oo x0xo0oo2 = f2736oOoXoXO;
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append("Could not create ObjectName");
                    stringBuffer4.append(str2);
                    x0xo0oo2.ooOOo0oXI(stringBuffer4.toString());
                }
            }
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("Cannot find ");
            stringBuffer5.append(str);
            stringBuffer5.append(" attribute in ");
            stringBuffer5.append(this.f2743XO);
            throw new AttributeNotFoundException(stringBuffer5.toString());
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Attribute name cannot be null");
        StringBuffer stringBuffer6 = new StringBuffer();
        stringBuffer6.append("Cannot invoke a getter of ");
        stringBuffer6.append(this.f2743XO);
        stringBuffer6.append(" with null attribute name");
        throw new RuntimeOperationsException(illegalArgumentException, stringBuffer6.toString());
    }

    @Override // org.apache.log4j.spi.Oxx0IOOO
    public void II0xO0(org.apache.log4j.X0o0xo x0o0xo, org.apache.log4j.oIX0oI oix0oi) {
        x0xO0oo x0xo0oo = f2736oOoXoXO;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("addAppenderEvent called: logger=");
        stringBuffer.append(x0o0xo.xxX());
        stringBuffer.append(", appender=");
        stringBuffer.append(oix0oi.getName());
        x0xo0oo.xxIXOIIO(stringBuffer.toString());
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(f2738xoIox);
        stringBuffer2.append(x0o0xo.xxX());
        Notification notification = new Notification(stringBuffer2.toString(), this, 0L);
        notification.setUserData(oix0oi);
        f2736oOoXoXO.xxIXOIIO("sending notification.");
        this.f2740II0XooXoX.sendNotification(notification);
    }

    public final void Oo() {
        this.f2739I0Io[0] = new MBeanConstructorInfo("HierarchyDynamicMBean(): Constructs a HierarchyDynamicMBean instance", getClass().getConstructors()[0]);
        this.f2742X0o0xo.add(new MBeanAttributeInfo("threshold", "java.lang.String", "The \"threshold\" state of the hiearchy.", true, true, false));
        this.f2744oxoX[0] = new MBeanOperationInfo("addLoggerMBean", "addLoggerMBean(): add a loggerMBean", new MBeanParameterInfo[]{new MBeanParameterInfo("name", "java.lang.String", "Create a logger MBean")}, "javax.management.ObjectName", 1);
    }

    @Override // OoxOxII.oIX0oI
    public Object Oxx0IOOO(String str, Object[] objArr, String[] strArr) throws MBeanException, ReflectionException {
        if (str != null) {
            if (str.equals("addLoggerMBean")) {
                return x0XOIxOo((String) objArr[0]);
            }
            NoSuchMethodException noSuchMethodException = new NoSuchMethodException(str);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Cannot find the operation ");
            stringBuffer.append(str);
            stringBuffer.append(" in ");
            stringBuffer.append(this.f2743XO);
            throw new ReflectionException(noSuchMethodException, stringBuffer.toString());
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Operation name cannot be null");
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Cannot invoke a null operation in ");
        stringBuffer2.append(this.f2743XO);
        throw new RuntimeOperationsException(illegalArgumentException, stringBuffer2.toString());
    }

    public MBeanNotificationInfo[] Oxx0xo() {
        return this.f2740II0XooXoX.getNotificationInfo();
    }

    @Override // OoxOxII.oIX0oI
    public x0xO0oo X0o0xo() {
        return f2736oOoXoXO;
    }

    @Override // OoxOxII.oIX0oI
    public MBeanInfo XO() {
        MBeanAttributeInfo[] mBeanAttributeInfoArr = new MBeanAttributeInfo[this.f2742X0o0xo.size()];
        this.f2742X0o0xo.toArray(mBeanAttributeInfoArr);
        return new MBeanInfo(this.f2743XO, this.f2741Oxx0IOOO, mBeanAttributeInfoArr, this.f2739I0Io, this.f2744oxoX, new MBeanNotificationInfo[0]);
    }

    public void oI0IIXIo(NotificationListener notificationListener) throws ListenerNotFoundException {
        this.f2740II0XooXoX.removeNotificationListener(notificationListener);
    }

    @Override // org.apache.log4j.spi.Oxx0IOOO
    public void oIX0oI(org.apache.log4j.X0o0xo x0o0xo, org.apache.log4j.oIX0oI oix0oi) {
        x0xO0oo x0xo0oo = f2736oOoXoXO;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("removeAppenderCalled: logger=");
        stringBuffer.append(x0o0xo.xxX());
        stringBuffer.append(", appender=");
        stringBuffer.append(oix0oi.getName());
        x0xo0oo.xxIXOIIO(stringBuffer.toString());
    }

    public ObjectName oO(x0xO0oo x0xo0oo) {
        XO xo2;
        ObjectName objectName;
        String xxX2 = x0xo0oo.xxX();
        ObjectName objectName2 = null;
        try {
            xo2 = new XO(x0xo0oo);
            objectName = new ObjectName("log4j", "logger", xxX2);
        } catch (Exception e) {
            e = e;
        }
        try {
            this.f2733II0xO0.registerMBean(xo2, objectName);
            NotificationFilterSupport notificationFilterSupport = new NotificationFilterSupport();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(f2738xoIox);
            stringBuffer.append(x0xo0oo.xxX());
            notificationFilterSupport.enableType(stringBuffer.toString());
            x0xO0oo x0xo0oo2 = f2736oOoXoXO;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("---Adding logger [");
            stringBuffer2.append(xxX2);
            stringBuffer2.append("] as listener.");
            x0xo0oo2.xxIXOIIO(stringBuffer2.toString());
            this.f2740II0XooXoX.addNotificationListener(xo2, notificationFilterSupport, (Object) null);
            Vector vector = this.f2742X0o0xo;
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("logger=");
            stringBuffer3.append(xxX2);
            String stringBuffer4 = stringBuffer3.toString();
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("The ");
            stringBuffer5.append(xxX2);
            stringBuffer5.append(" logger.");
            vector.add(new MBeanAttributeInfo(stringBuffer4, "javax.management.ObjectName", stringBuffer5.toString(), true, true, false));
            return objectName;
        } catch (Exception e2) {
            e = e2;
            objectName2 = objectName;
            x0xO0oo x0xo0oo3 = f2736oOoXoXO;
            StringBuffer stringBuffer6 = new StringBuffer();
            stringBuffer6.append("Could not add loggerMBean for [");
            stringBuffer6.append(xxX2);
            stringBuffer6.append("].");
            x0xo0oo3.x0XOIxOo(stringBuffer6.toString(), e);
            return objectName2;
        }
    }

    @Override // OoxOxII.oIX0oI
    public void oOoXoXO(Attribute attribute) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
        if (attribute != null) {
            String name = attribute.getName();
            Object value = attribute.getValue();
            if (name != null) {
                if (name.equals("threshold")) {
                    this.f2745xxIXOIIO.ooOOo0oXI(oOoXoXO.ooOOo0oXI((String) value, this.f2745xxIXOIIO.xoIox()));
                    return;
                }
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Attribute name cannot be null");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Cannot invoke the setter of ");
            stringBuffer.append(this.f2743XO);
            stringBuffer.append(" with null attribute name");
            throw new RuntimeOperationsException(illegalArgumentException, stringBuffer.toString());
        }
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Attribute cannot be null");
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Cannot invoke a setter of ");
        stringBuffer2.append(this.f2743XO);
        stringBuffer2.append(" with null attribute");
        throw new RuntimeOperationsException(illegalArgumentException2, stringBuffer2.toString());
    }

    public ObjectName x0XOIxOo(String str) {
        x0xO0oo oIX0oI2 = oO.oIX0oI(str);
        if (oIX0oI2 != null) {
            return oO(oIX0oI2);
        }
        return null;
    }

    public void x0xO0oo(NotificationListener notificationListener, NotificationFilter notificationFilter, Object obj) {
        this.f2740II0XooXoX.addNotificationListener(notificationListener, notificationFilter, obj);
    }

    @Override // OoxOxII.oIX0oI
    public void xxIXOIIO(Boolean bool) {
        f2736oOoXoXO.xxIXOIIO("postRegister is called.");
        this.f2745xxIXOIIO.II0xO0(this);
        oO(this.f2745xxIXOIIO.oO());
    }
}
