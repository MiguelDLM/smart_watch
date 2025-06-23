package OoxOxII;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Hashtable;
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
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.RuntimeOperationsException;
import org.apache.log4j.Level;
import org.apache.log4j.helpers.oOoXoXO;
import org.apache.log4j.spi.OOXIXo;
import org.apache.log4j.x0XOIxOo;
import org.apache.log4j.x0xO0oo;

/* loaded from: classes6.dex */
public class I0Io extends oIX0oI {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static /* synthetic */ Class f2696OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static /* synthetic */ Class f2697oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static /* synthetic */ Class f2698ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static /* synthetic */ Class f2699x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static x0xO0oo f2700xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public org.apache.log4j.oIX0oI f2707xxIXOIIO;

    /* renamed from: I0Io, reason: collision with root package name */
    public MBeanConstructorInfo[] f2701I0Io = new MBeanConstructorInfo[1];

    /* renamed from: oxoX, reason: collision with root package name */
    public Vector f2706oxoX = new Vector();

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String f2704X0o0xo = getClass().getName();

    /* renamed from: XO, reason: collision with root package name */
    public Hashtable f2705XO = new Hashtable(5);

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public MBeanOperationInfo[] f2703Oxx0IOOO = new MBeanOperationInfo[2];

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public String f2702II0XooXoX = "This MBean acts as a management facade for log4j appenders.";

    static {
        Class cls = f2696OOXIXo;
        if (cls == null) {
            cls = oO("org.apache.log4j.jmx.AppenderDynamicMBean");
            f2696OOXIXo = cls;
        }
        f2700xoIox = x0xO0oo.xo0x(cls);
    }

    public I0Io(org.apache.log4j.oIX0oI oix0oi) throws IntrospectionException {
        this.f2707xxIXOIIO = oix0oi;
        x0XOIxOo();
    }

    public static /* synthetic */ Class oO(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private void x0XOIxOo() throws IntrospectionException {
        int i = 0;
        this.f2701I0Io[0] = new MBeanConstructorInfo("AppenderDynamicMBean(): Constructs a AppenderDynamicMBean instance", getClass().getConstructors()[0]);
        PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(this.f2707xxIXOIIO.getClass()).getPropertyDescriptors();
        int length = propertyDescriptors.length;
        int i2 = 0;
        while (true) {
            String str = "java.lang.String";
            boolean z = true;
            if (i2 >= length) {
                this.f2703Oxx0IOOO[i] = new MBeanOperationInfo("activateOptions", "activateOptions(): add an appender", new MBeanParameterInfo[i], "void", 1);
                MBeanParameterInfo[] mBeanParameterInfoArr = new MBeanParameterInfo[1];
                mBeanParameterInfoArr[i] = new MBeanParameterInfo("layout class", "java.lang.String", "layout class");
                this.f2703Oxx0IOOO[1] = new MBeanOperationInfo("setLayout", "setLayout(): add a layout", mBeanParameterInfoArr, "void", 1);
                return;
            }
            String name = propertyDescriptors[i2].getName();
            Method readMethod = propertyDescriptors[i2].getReadMethod();
            Method writeMethod = propertyDescriptors[i2].getWriteMethod();
            if (readMethod != null) {
                Class<?> returnType = readMethod.getReturnType();
                if (x0xO0oo(returnType)) {
                    Class<?> cls = f2697oOoXoXO;
                    if (cls == null) {
                        cls = oO("org.apache.log4j.Priority");
                        f2697oOoXoXO = cls;
                    }
                    if (!returnType.isAssignableFrom(cls)) {
                        str = returnType.getName();
                    }
                    String str2 = str;
                    Vector vector = this.f2706oxoX;
                    if (writeMethod == null) {
                        z = false;
                    }
                    vector.add(new MBeanAttributeInfo(name, str2, "Dynamic", true, z, false));
                    this.f2705XO.put(name, new Oxx0IOOO(readMethod, writeMethod));
                }
            }
            i2++;
            i = 0;
        }
    }

    @Override // OoxOxII.oIX0oI
    public Object I0Io(String str) throws AttributeNotFoundException, MBeanException, ReflectionException {
        Method method;
        if (str != null) {
            x0xO0oo x0xo0oo = f2700xoIox;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("getAttribute called with [");
            stringBuffer.append(str);
            stringBuffer.append("].");
            x0xo0oo.xxIXOIIO(stringBuffer.toString());
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("appender=");
            stringBuffer2.append(this.f2707xxIXOIIO.getName());
            stringBuffer2.append(",layout");
            if (str.startsWith(stringBuffer2.toString())) {
                try {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("log4j:");
                    stringBuffer3.append(str);
                    return new ObjectName(stringBuffer3.toString());
                } catch (Exception e) {
                    f2700xoIox.x0XOIxOo("attributeName", e);
                }
            }
            Oxx0IOOO oxx0IOOO = (Oxx0IOOO) this.f2705XO.get(str);
            if (oxx0IOOO != null && (method = oxx0IOOO.f2711oIX0oI) != null) {
                try {
                    return method.invoke(this.f2707xxIXOIIO, null);
                } catch (Exception unused) {
                    return null;
                }
            }
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("Cannot find ");
            stringBuffer4.append(str);
            stringBuffer4.append(" attribute in ");
            stringBuffer4.append(this.f2704X0o0xo);
            throw new AttributeNotFoundException(stringBuffer4.toString());
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Attribute name cannot be null");
        StringBuffer stringBuffer5 = new StringBuffer();
        stringBuffer5.append("Cannot invoke a getter of ");
        stringBuffer5.append(this.f2704X0o0xo);
        stringBuffer5.append(" with null attribute name");
        throw new RuntimeOperationsException(illegalArgumentException, stringBuffer5.toString());
    }

    @Override // OoxOxII.oIX0oI
    public ObjectName OOXIXo(MBeanServer mBeanServer, ObjectName objectName) {
        x0xO0oo x0xo0oo = f2700xoIox;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("preRegister called. Server=");
        stringBuffer.append(mBeanServer);
        stringBuffer.append(", name=");
        stringBuffer.append(objectName);
        x0xo0oo.xxIXOIIO(stringBuffer.toString());
        this.f2733II0xO0 = mBeanServer;
        Oo(this.f2707xxIXOIIO.Oxx0xo());
        return objectName;
    }

    public void Oo(x0XOIxOo x0xoixoo) {
        if (x0xoixoo == null) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f2707xxIXOIIO.getName());
        stringBuffer.append(",layout=");
        stringBuffer.append(x0xoixoo.getClass().getName());
        String stringBuffer2 = stringBuffer.toString();
        x0xO0oo x0xo0oo = f2700xoIox;
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("Adding LayoutMBean:");
        stringBuffer3.append(stringBuffer2);
        x0xo0oo.xxIXOIIO(stringBuffer3.toString());
        try {
            X0o0xo x0o0xo = new X0o0xo(x0xoixoo);
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("log4j:appender=");
            stringBuffer4.append(stringBuffer2);
            this.f2733II0xO0.registerMBean(x0o0xo, new ObjectName(stringBuffer4.toString()));
            Vector vector = this.f2706oxoX;
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("appender=");
            stringBuffer5.append(stringBuffer2);
            String stringBuffer6 = stringBuffer5.toString();
            StringBuffer stringBuffer7 = new StringBuffer();
            stringBuffer7.append("The ");
            stringBuffer7.append(stringBuffer2);
            stringBuffer7.append(" layout.");
            vector.add(new MBeanAttributeInfo(stringBuffer6, "javax.management.ObjectName", stringBuffer7.toString(), true, true, false));
        } catch (Exception e) {
            x0xO0oo x0xo0oo2 = f2700xoIox;
            StringBuffer stringBuffer8 = new StringBuffer();
            stringBuffer8.append("Could not add DynamicLayoutMBean for [");
            stringBuffer8.append(stringBuffer2);
            stringBuffer8.append("].");
            x0xo0oo2.x0XOIxOo(stringBuffer8.toString(), e);
        }
    }

    @Override // OoxOxII.oIX0oI
    public Object Oxx0IOOO(String str, Object[] objArr, String[] strArr) throws MBeanException, ReflectionException {
        if (str.equals("activateOptions")) {
            org.apache.log4j.oIX0oI oix0oi = this.f2707xxIXOIIO;
            if (oix0oi instanceof OOXIXo) {
                ((OOXIXo) oix0oi).oI0IIXIo();
                return "Options activated.";
            }
        }
        if (str.equals("setLayout")) {
            String str2 = (String) objArr[0];
            Class cls = f2699x0XOIxOo;
            if (cls == null) {
                cls = oO("org.apache.log4j.Layout");
                f2699x0XOIxOo = cls;
            }
            x0XOIxOo x0xoixoo = (x0XOIxOo) oOoXoXO.XO(str2, cls, null);
            this.f2707xxIXOIIO.oxoX(x0xoixoo);
            Oo(x0xoixoo);
        }
        return null;
    }

    @Override // OoxOxII.oIX0oI
    public x0xO0oo X0o0xo() {
        return f2700xoIox;
    }

    @Override // OoxOxII.oIX0oI
    public MBeanInfo XO() {
        f2700xoIox.xxIXOIIO("getMBeanInfo called.");
        MBeanAttributeInfo[] mBeanAttributeInfoArr = new MBeanAttributeInfo[this.f2706oxoX.size()];
        this.f2706oxoX.toArray(mBeanAttributeInfoArr);
        return new MBeanInfo(this.f2704X0o0xo, this.f2702II0XooXoX, mBeanAttributeInfoArr, this.f2701I0Io, this.f2703Oxx0IOOO, new MBeanNotificationInfo[0]);
    }

    @Override // OoxOxII.oIX0oI
    public void oOoXoXO(Attribute attribute) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
        Method method;
        if (attribute != null) {
            String name = attribute.getName();
            Object value = attribute.getValue();
            if (name != null) {
                Oxx0IOOO oxx0IOOO = (Oxx0IOOO) this.f2705XO.get(name);
                if (oxx0IOOO != null && (method = oxx0IOOO.f2710II0xO0) != null) {
                    Class<?> cls = method.getParameterTypes()[0];
                    Class<?> cls2 = f2697oOoXoXO;
                    if (cls2 == null) {
                        cls2 = oO("org.apache.log4j.Priority");
                        f2697oOoXoXO = cls2;
                    }
                    if (cls == cls2) {
                        value = oOoXoXO.ooOOo0oXI((String) value, (Level) I0Io(name));
                    }
                    try {
                        oxx0IOOO.f2710II0xO0.invoke(this.f2707xxIXOIIO, value);
                        return;
                    } catch (Exception e) {
                        f2700xoIox.x0XOIxOo("FIXME", e);
                        return;
                    }
                }
                if (name.endsWith(".layout")) {
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
            stringBuffer2.append(this.f2704X0o0xo);
            stringBuffer2.append(" with null attribute name");
            throw new RuntimeOperationsException(illegalArgumentException, stringBuffer2.toString());
        }
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Attribute cannot be null");
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("Cannot invoke a setter of ");
        stringBuffer3.append(this.f2704X0o0xo);
        stringBuffer3.append(" with null attribute");
        throw new RuntimeOperationsException(illegalArgumentException2, stringBuffer3.toString());
    }

    public final boolean x0xO0oo(Class cls) {
        if (cls.isPrimitive()) {
            return true;
        }
        Class cls2 = f2698ooOOo0oXI;
        if (cls2 == null) {
            cls2 = oO("java.lang.String");
            f2698ooOOo0oXI = cls2;
        }
        if (cls == cls2) {
            return true;
        }
        Class<?> cls3 = f2697oOoXoXO;
        if (cls3 == null) {
            cls3 = oO("org.apache.log4j.Priority");
            f2697oOoXoXO = cls3;
        }
        if (cls.isAssignableFrom(cls3)) {
            return true;
        }
        return false;
    }
}
