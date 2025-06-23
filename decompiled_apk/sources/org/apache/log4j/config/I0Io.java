package org.apache.log4j.config;

import com.tenmeter.smlibrary.utils.FileUtils;
import java.beans.FeatureDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Properties;
import org.apache.log4j.Level;
import org.apache.log4j.helpers.oOoXoXO;
import org.apache.log4j.helpers.xxIXOIIO;
import org.apache.log4j.spi.OOXIXo;

/* loaded from: classes6.dex */
public class I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public static /* synthetic */ Class f33216I0Io;

    /* renamed from: oxoX, reason: collision with root package name */
    public static /* synthetic */ Class f33217oxoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public PropertyDescriptor[] f33218II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Object f33219oIX0oI;

    public I0Io(Object obj) {
        this.f33219oIX0oI = obj;
    }

    public static /* synthetic */ Class II0xO0(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static void XO(Object obj, Properties properties, String str) {
        new I0Io(obj).Oxx0IOOO(properties, str);
    }

    public Object I0Io(String str, Class cls) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        Class cls2 = f33216I0Io;
        if (cls2 == null) {
            cls2 = II0xO0("java.lang.String");
            f33216I0Io = cls2;
        }
        if (cls2.isAssignableFrom(cls)) {
            return str;
        }
        if (Integer.TYPE.isAssignableFrom(cls)) {
            return new Integer(trim);
        }
        if (Long.TYPE.isAssignableFrom(cls)) {
            return new Long(trim);
        }
        if (Boolean.TYPE.isAssignableFrom(cls)) {
            if ("true".equalsIgnoreCase(trim)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(trim)) {
                return Boolean.FALSE;
            }
        } else {
            Class cls3 = f33217oxoX;
            if (cls3 == null) {
                cls3 = II0xO0("org.apache.log4j.Priority");
                f33217oxoX = cls3;
            }
            if (cls3.isAssignableFrom(cls)) {
                return oOoXoXO.ooOOo0oXI(trim, Level.DEBUG);
            }
        }
        return null;
    }

    public void II0XooXoX(PropertyDescriptor propertyDescriptor, String str, String str2) throws PropertySetterException {
        Method writeMethod = propertyDescriptor.getWriteMethod();
        if (writeMethod != null) {
            Class<?>[] parameterTypes = writeMethod.getParameterTypes();
            if (parameterTypes.length == 1) {
                try {
                    Object I0Io2 = I0Io(str2, parameterTypes[0]);
                    if (I0Io2 != null) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Setting property [");
                        stringBuffer.append(str);
                        stringBuffer.append("] to [");
                        stringBuffer.append(I0Io2);
                        stringBuffer.append("].");
                        xxIXOIIO.oIX0oI(stringBuffer.toString());
                        try {
                            writeMethod.invoke(this.f33219oIX0oI, I0Io2);
                            return;
                        } catch (Exception e) {
                            throw new PropertySetterException(e);
                        }
                    }
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Conversion to type [");
                    stringBuffer2.append(parameterTypes[0]);
                    stringBuffer2.append("] failed.");
                    throw new PropertySetterException(stringBuffer2.toString());
                } catch (Throwable th) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("Conversion to type [");
                    stringBuffer3.append(parameterTypes[0]);
                    stringBuffer3.append("] failed. Reason: ");
                    stringBuffer3.append(th);
                    throw new PropertySetterException(stringBuffer3.toString());
                }
            }
            throw new PropertySetterException("#params for setter != 1");
        }
        StringBuffer stringBuffer4 = new StringBuffer();
        stringBuffer4.append("No setter for property [");
        stringBuffer4.append(str);
        stringBuffer4.append("].");
        throw new PropertySetterException(stringBuffer4.toString());
    }

    public void Oxx0IOOO(Properties properties, String str) {
        int length = str.length();
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str2 = (String) propertyNames.nextElement();
            if (str2.startsWith(str) && str2.indexOf(46, length + 1) <= 0) {
                String oxoX2 = oOoXoXO.oxoX(str2, properties);
                String substring = str2.substring(length);
                if (!"layout".equals(substring) || !(this.f33219oIX0oI instanceof org.apache.log4j.oIX0oI)) {
                    xxIXOIIO(substring, oxoX2);
                }
            }
        }
        oIX0oI();
    }

    public void X0o0xo() {
        try {
            this.f33218II0xO0 = Introspector.getBeanInfo(this.f33219oIX0oI.getClass()).getPropertyDescriptors();
        } catch (IntrospectionException e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Failed to introspect ");
            stringBuffer.append(this.f33219oIX0oI);
            stringBuffer.append(": ");
            stringBuffer.append(e.getMessage());
            xxIXOIIO.I0Io(stringBuffer.toString());
            this.f33218II0xO0 = new PropertyDescriptor[0];
        }
    }

    public void oIX0oI() {
        Object obj = this.f33219oIX0oI;
        if (obj instanceof OOXIXo) {
            ((OOXIXo) obj).oI0IIXIo();
        }
    }

    public PropertyDescriptor oxoX(String str) {
        if (this.f33218II0xO0 == null) {
            X0o0xo();
        }
        int i = 0;
        while (true) {
            FeatureDescriptor[] featureDescriptorArr = this.f33218II0xO0;
            if (i >= featureDescriptorArr.length) {
                return null;
            }
            if (str.equals(featureDescriptorArr[i].getName())) {
                return this.f33218II0xO0[i];
            }
            i++;
        }
    }

    public void xxIXOIIO(String str, String str2) {
        if (str2 == null) {
            return;
        }
        String decapitalize = Introspector.decapitalize(str);
        PropertyDescriptor oxoX2 = oxoX(decapitalize);
        if (oxoX2 == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("No such property [");
            stringBuffer.append(decapitalize);
            stringBuffer.append("] in ");
            stringBuffer.append(this.f33219oIX0oI.getClass().getName());
            stringBuffer.append(FileUtils.FILE_EXTENSION_SEPARATOR);
            xxIXOIIO.Oxx0IOOO(stringBuffer.toString());
            return;
        }
        try {
            II0XooXoX(oxoX2, decapitalize, str2);
        } catch (PropertySetterException e) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Failed to set property [");
            stringBuffer2.append(decapitalize);
            stringBuffer2.append("] to value \"");
            stringBuffer2.append(str2);
            stringBuffer2.append("\". ");
            xxIXOIIO.II0XooXoX(stringBuffer2.toString(), e.rootCause);
        }
    }
}
