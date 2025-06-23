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
import javax.management.ReflectionException;
import javax.management.RuntimeOperationsException;
import org.apache.log4j.Level;
import org.apache.log4j.helpers.oOoXoXO;
import org.apache.log4j.spi.OOXIXo;
import org.apache.log4j.x0XOIxOo;
import org.apache.log4j.x0xO0oo;

/* loaded from: classes6.dex */
public class X0o0xo extends oIX0oI {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static /* synthetic */ Class f2712OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static /* synthetic */ Class f2713oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static /* synthetic */ Class f2714ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static /* synthetic */ Class f2715x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static x0xO0oo f2716xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public x0XOIxOo f2723xxIXOIIO;

    /* renamed from: I0Io, reason: collision with root package name */
    public MBeanConstructorInfo[] f2717I0Io = new MBeanConstructorInfo[1];

    /* renamed from: oxoX, reason: collision with root package name */
    public Vector f2722oxoX = new Vector();

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String f2720X0o0xo = getClass().getName();

    /* renamed from: XO, reason: collision with root package name */
    public Hashtable f2721XO = new Hashtable(5);

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public MBeanOperationInfo[] f2719Oxx0IOOO = new MBeanOperationInfo[1];

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public String f2718II0XooXoX = "This MBean acts as a management facade for log4j layouts.";

    static {
        Class cls = f2712OOXIXo;
        if (cls == null) {
            cls = oO("org.apache.log4j.jmx.LayoutDynamicMBean");
            f2712OOXIXo = cls;
        }
        f2716xoIox = x0xO0oo.xo0x(cls);
    }

    public X0o0xo(x0XOIxOo x0xoixoo) throws IntrospectionException {
        this.f2723xxIXOIIO = x0xoixoo;
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
        String name;
        boolean z;
        int i = 0;
        this.f2717I0Io[0] = new MBeanConstructorInfo("LayoutDynamicMBean(): Constructs a LayoutDynamicMBean instance", getClass().getConstructors()[0]);
        PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(this.f2723xxIXOIIO.getClass()).getPropertyDescriptors();
        int length = propertyDescriptors.length;
        int i2 = 0;
        while (i2 < length) {
            String name2 = propertyDescriptors[i2].getName();
            Method readMethod = propertyDescriptors[i2].getReadMethod();
            Method writeMethod = propertyDescriptors[i2].getWriteMethod();
            if (readMethod != null) {
                Class<?> returnType = readMethod.getReturnType();
                if (x0xO0oo(returnType)) {
                    Class<?> cls = f2713oOoXoXO;
                    if (cls == null) {
                        cls = oO("org.apache.log4j.Level");
                        f2713oOoXoXO = cls;
                    }
                    if (returnType.isAssignableFrom(cls)) {
                        name = "java.lang.String";
                    } else {
                        name = returnType.getName();
                    }
                    String str = name;
                    Vector vector = this.f2722oxoX;
                    if (writeMethod != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    vector.add(new MBeanAttributeInfo(name2, str, "Dynamic", true, z, false));
                    this.f2721XO.put(name2, new Oxx0IOOO(readMethod, writeMethod));
                }
            }
            i2++;
            i = 0;
        }
        this.f2719Oxx0IOOO[i] = new MBeanOperationInfo("activateOptions", "activateOptions(): add an layout", new MBeanParameterInfo[i], "void", 1);
    }

    private boolean x0xO0oo(Class cls) {
        if (cls.isPrimitive()) {
            return true;
        }
        Class cls2 = f2714ooOOo0oXI;
        if (cls2 == null) {
            cls2 = oO("java.lang.String");
            f2714ooOOo0oXI = cls2;
        }
        if (cls == cls2) {
            return true;
        }
        Class<?> cls3 = f2713oOoXoXO;
        if (cls3 == null) {
            cls3 = oO("org.apache.log4j.Level");
            f2713oOoXoXO = cls3;
        }
        if (cls.isAssignableFrom(cls3)) {
            return true;
        }
        return false;
    }

    @Override // OoxOxII.oIX0oI
    public Object I0Io(String str) throws AttributeNotFoundException, MBeanException, ReflectionException {
        Method method;
        if (str != null) {
            Oxx0IOOO oxx0IOOO = (Oxx0IOOO) this.f2721XO.get(str);
            x0xO0oo x0xo0oo = f2716xoIox;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("----name=");
            stringBuffer.append(str);
            stringBuffer.append(", mu=");
            stringBuffer.append(oxx0IOOO);
            x0xo0oo.xxIXOIIO(stringBuffer.toString());
            if (oxx0IOOO != null && (method = oxx0IOOO.f2711oIX0oI) != null) {
                try {
                    return method.invoke(this.f2723xxIXOIIO, null);
                } catch (Exception unused) {
                    return null;
                }
            }
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Cannot find ");
            stringBuffer2.append(str);
            stringBuffer2.append(" attribute in ");
            stringBuffer2.append(this.f2720X0o0xo);
            throw new AttributeNotFoundException(stringBuffer2.toString());
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Attribute name cannot be null");
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("Cannot invoke a getter of ");
        stringBuffer3.append(this.f2720X0o0xo);
        stringBuffer3.append(" with null attribute name");
        throw new RuntimeOperationsException(illegalArgumentException, stringBuffer3.toString());
    }

    @Override // OoxOxII.oIX0oI
    public Object Oxx0IOOO(String str, Object[] objArr, String[] strArr) throws MBeanException, ReflectionException {
        if (str.equals("activateOptions")) {
            x0XOIxOo x0xoixoo = this.f2723xxIXOIIO;
            if (x0xoixoo instanceof OOXIXo) {
                x0xoixoo.oI0IIXIo();
                return "Options activated.";
            }
            return null;
        }
        return null;
    }

    @Override // OoxOxII.oIX0oI
    public x0xO0oo X0o0xo() {
        return f2716xoIox;
    }

    @Override // OoxOxII.oIX0oI
    public MBeanInfo XO() {
        f2716xoIox.xxIXOIIO("getMBeanInfo called.");
        MBeanAttributeInfo[] mBeanAttributeInfoArr = new MBeanAttributeInfo[this.f2722oxoX.size()];
        this.f2722oxoX.toArray(mBeanAttributeInfoArr);
        return new MBeanInfo(this.f2720X0o0xo, this.f2718II0XooXoX, mBeanAttributeInfoArr, this.f2717I0Io, this.f2719Oxx0IOOO, new MBeanNotificationInfo[0]);
    }

    @Override // OoxOxII.oIX0oI
    public void oOoXoXO(Attribute attribute) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
        Method method;
        if (attribute != null) {
            String name = attribute.getName();
            Object value = attribute.getValue();
            if (name != null) {
                Oxx0IOOO oxx0IOOO = (Oxx0IOOO) this.f2721XO.get(name);
                if (oxx0IOOO != null && (method = oxx0IOOO.f2710II0xO0) != null) {
                    Class<?> cls = method.getParameterTypes()[0];
                    Class<?> cls2 = f2715x0XOIxOo;
                    if (cls2 == null) {
                        cls2 = oO("org.apache.log4j.Priority");
                        f2715x0XOIxOo = cls2;
                    }
                    if (cls == cls2) {
                        value = oOoXoXO.ooOOo0oXI((String) value, (Level) I0Io(name));
                    }
                    try {
                        oxx0IOOO.f2710II0xO0.invoke(this.f2723xxIXOIIO, value);
                        return;
                    } catch (Exception e) {
                        f2716xoIox.x0XOIxOo("FIXME", e);
                        return;
                    }
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
            stringBuffer2.append(this.f2720X0o0xo);
            stringBuffer2.append(" with null attribute name");
            throw new RuntimeOperationsException(illegalArgumentException, stringBuffer2.toString());
        }
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Attribute cannot be null");
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("Cannot invoke a setter of ");
        stringBuffer3.append(this.f2720X0o0xo);
        stringBuffer3.append(" with null attribute");
        throw new RuntimeOperationsException(illegalArgumentException2, stringBuffer3.toString());
    }
}
