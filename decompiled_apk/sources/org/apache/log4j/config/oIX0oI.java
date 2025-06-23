package org.apache.log4j.config;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import org.apache.log4j.helpers.xxIXOIIO;

/* loaded from: classes6.dex */
public class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final Object[] f33225I0Io = new Object[0];

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static /* synthetic */ Class f33226X0o0xo;

    /* renamed from: oxoX, reason: collision with root package name */
    public static /* synthetic */ Class f33227oxoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public PropertyDescriptor[] f33228II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Object f33229oIX0oI;

    /* renamed from: org.apache.log4j.config.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1139oIX0oI {
        void oIX0oI(Object obj, String str, String str2, Object obj2);
    }

    public oIX0oI(Object obj) throws IntrospectionException {
        this.f33228II0xO0 = Introspector.getBeanInfo(obj.getClass()).getPropertyDescriptors();
        this.f33229oIX0oI = obj;
    }

    public static void II0xO0(Object obj, InterfaceC1139oIX0oI interfaceC1139oIX0oI, String str) {
        try {
            new oIX0oI(obj).I0Io(interfaceC1139oIX0oI, str);
        } catch (IntrospectionException e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Failed to introspect object ");
            stringBuffer.append(obj);
            xxIXOIIO.oxoX(stringBuffer.toString(), e);
        }
    }

    public static /* synthetic */ Class oIX0oI(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public void I0Io(InterfaceC1139oIX0oI interfaceC1139oIX0oI, String str) {
        int i = 0;
        while (true) {
            PropertyDescriptor[] propertyDescriptorArr = this.f33228II0xO0;
            if (i >= propertyDescriptorArr.length) {
                return;
            }
            Method readMethod = propertyDescriptorArr[i].getReadMethod();
            if (readMethod != null && oxoX(readMethod.getReturnType())) {
                String name = this.f33228II0xO0[i].getName();
                try {
                    Object invoke = readMethod.invoke(this.f33229oIX0oI, f33225I0Io);
                    if (invoke != null) {
                        interfaceC1139oIX0oI.oIX0oI(this.f33229oIX0oI, str, name, invoke);
                    }
                } catch (Exception unused) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Failed to get value of property ");
                    stringBuffer.append(name);
                    xxIXOIIO.Oxx0IOOO(stringBuffer.toString());
                }
            }
            i++;
        }
    }

    public boolean oxoX(Class cls) {
        Class cls2 = f33227oxoX;
        if (cls2 == null) {
            cls2 = oIX0oI("java.lang.String");
            f33227oxoX = cls2;
        }
        if (!cls2.isAssignableFrom(cls) && !Integer.TYPE.isAssignableFrom(cls) && !Long.TYPE.isAssignableFrom(cls) && !Boolean.TYPE.isAssignableFrom(cls)) {
            Class cls3 = f33226X0o0xo;
            if (cls3 == null) {
                cls3 = oIX0oI("org.apache.log4j.Priority");
                f33226X0o0xo = cls3;
            }
            if (!cls3.isAssignableFrom(cls)) {
                return false;
            }
        }
        return true;
    }
}
