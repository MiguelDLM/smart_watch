package com.squareup.javapoet;

import XO00XOO.oOoXoXO;
import XO00XOO.xoIox;
import XXO0.oIX0oI;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor7;
import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes11.dex */
public final class oIX0oI {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Map<String, List<com.squareup.javapoet.II0xO0>> f25899II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final xoIox f25900oIX0oI;

    /* loaded from: classes11.dex */
    public static class I0Io extends SimpleAnnotationValueVisitor7<II0xO0, String> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final II0xO0 f25901oIX0oI;

        public I0Io(II0xO0 iI0xO0) {
            super(iI0xO0);
            this.f25901oIX0oI = iI0xO0;
        }

        /* renamed from: I0Io, reason: merged with bridge method [inline-methods] */
        public II0xO0 oxoX(AnnotationMirror annotationMirror, String str) {
            return this.f25901oIX0oI.oxoX(str, "$L", oIX0oI.Oxx0IOOO(annotationMirror));
        }

        /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
        public II0xO0 II0XooXoX(VariableElement variableElement, String str) {
            return this.f25901oIX0oI.oxoX(str, "$T.$L", variableElement.asType(), variableElement.getSimpleName());
        }

        /* renamed from: X0o0xo, reason: merged with bridge method [inline-methods] */
        public II0xO0 XO(List<? extends AnnotationValue> list, String str) {
            Iterator<? extends AnnotationValue> it = list.iterator();
            while (it.hasNext()) {
                it.next().accept(this, str);
            }
            return this.f25901oIX0oI;
        }

        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public II0xO0 II0xO0(Object obj, String str) {
            return this.f25901oIX0oI.X0o0xo(str, obj);
        }

        /* renamed from: xxIXOIIO, reason: merged with bridge method [inline-methods] */
        public II0xO0 xoIox(TypeMirror typeMirror, String str) {
            return this.f25901oIX0oI.oxoX(str, "$T.class", typeMirror);
        }
    }

    /* loaded from: classes11.dex */
    public static final class II0xO0 {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final Map<String, List<com.squareup.javapoet.II0xO0>> f25902II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final xoIox f25903oIX0oI;

        public /* synthetic */ II0xO0(xoIox xoiox, C1033oIX0oI c1033oIX0oI) {
            this(xoiox);
        }

        public II0xO0 I0Io(String str, com.squareup.javapoet.II0xO0 iI0xO0) {
            List<com.squareup.javapoet.II0xO0> list = this.f25902II0xO0.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.f25902II0xO0.put(str, list);
            }
            list.add(iI0xO0);
            return this;
        }

        public II0xO0 X0o0xo(String str, Object obj) {
            oOoXoXO.I0Io(str, "memberName == null", new Object[0]);
            oOoXoXO.I0Io(obj, "value == null, constant non-null value expected for %s", str);
            if (obj instanceof Class) {
                return oxoX(str, "$T.class", obj);
            }
            if (obj instanceof Enum) {
                return oxoX(str, "$T.$L", obj.getClass(), ((Enum) obj).name());
            }
            if (obj instanceof String) {
                return oxoX(str, "$S", obj);
            }
            if (obj instanceof Float) {
                return oxoX(str, "$Lf", obj);
            }
            if (obj instanceof Character) {
                return oxoX(str, "'$L'", oOoXoXO.oIX0oI(((Character) obj).charValue()));
            }
            return oxoX(str, "$L", obj);
        }

        public oIX0oI XO() {
            return new oIX0oI(this, null);
        }

        public II0xO0 oxoX(String str, String str2, Object... objArr) {
            return I0Io(str, com.squareup.javapoet.II0xO0.X0o0xo(str2, objArr));
        }

        public II0xO0(xoIox xoiox) {
            this.f25902II0xO0 = new LinkedHashMap();
            this.f25903oIX0oI = xoiox;
        }
    }

    /* renamed from: com.squareup.javapoet.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C1033oIX0oI implements Comparator<Method> {
        @Override // java.util.Comparator
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public int compare(Method method, Method method2) {
            return method.getName().compareTo(method2.getName());
        }
    }

    public /* synthetic */ oIX0oI(II0xO0 iI0xO0, C1033oIX0oI c1033oIX0oI) {
        this(iI0xO0);
    }

    public static II0xO0 II0xO0(Class<?> cls) {
        return oIX0oI(XO00XOO.II0xO0.X0IIOO(cls));
    }

    public static oIX0oI Oxx0IOOO(AnnotationMirror annotationMirror) {
        II0xO0 oIX0oI2 = oIX0oI(XO00XOO.II0xO0.XIxXXX0x0(annotationMirror.getAnnotationType().asElement()));
        I0Io i0Io = new I0Io(oIX0oI2);
        for (ExecutableElement executableElement : annotationMirror.getElementValues().keySet()) {
            ((AnnotationValue) annotationMirror.getElementValues().get(executableElement)).accept(i0Io, executableElement.getSimpleName().toString());
        }
        return oIX0oI2.XO();
    }

    public static oIX0oI X0o0xo(Annotation annotation) {
        return XO(annotation, false);
    }

    public static oIX0oI XO(Annotation annotation, boolean z) {
        II0xO0 II0xO02 = II0xO0(annotation.annotationType());
        try {
            Method[] declaredMethods = annotation.annotationType().getDeclaredMethods();
            Arrays.sort(declaredMethods, new C1033oIX0oI());
            for (Method method : declaredMethods) {
                Object invoke = method.invoke(annotation, null);
                if (z || !Objects.deepEquals(invoke, method.getDefaultValue())) {
                    if (invoke.getClass().isArray()) {
                        for (int i = 0; i < Array.getLength(invoke); i++) {
                            II0xO02.X0o0xo(method.getName(), Array.get(invoke, i));
                        }
                    } else if (invoke instanceof Annotation) {
                        II0xO02.oxoX(method.getName(), "$L", X0o0xo((Annotation) invoke));
                    } else {
                        II0xO02.X0o0xo(method.getName(), invoke);
                    }
                }
            }
            return II0xO02.XO();
        } catch (Exception e) {
            throw new RuntimeException("Reflecting " + annotation + " failed!", e);
        }
    }

    public static II0xO0 oIX0oI(XO00XOO.II0xO0 iI0xO0) {
        oOoXoXO.I0Io(iI0xO0, "type == null", new Object[0]);
        return new II0xO0(iI0xO0, null);
    }

    public void I0Io(XO00XOO.oxoX oxox, boolean z) throws IOException {
        String str;
        String str2;
        if (z) {
            str = "";
        } else {
            str = "\n";
        }
        if (z) {
            str2 = ", ";
        } else {
            str2 = ",\n";
        }
        if (this.f25899II0xO0.isEmpty()) {
            oxox.I0Io("@$T", this.f25900oIX0oI);
            return;
        }
        if (this.f25899II0xO0.size() == 1 && this.f25899II0xO0.containsKey("value")) {
            oxox.I0Io("@$T(", this.f25900oIX0oI);
            oxoX(oxox, str, str2, this.f25899II0xO0.get("value"));
            oxox.II0xO0(oIX0oI.I0Io.f4095I0Io);
            return;
        }
        oxox.I0Io("@$T(" + str, this.f25900oIX0oI);
        oxox.Oxx0xo(2);
        Iterator<Map.Entry<String, List<com.squareup.javapoet.II0xO0>>> it = this.f25899II0xO0.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, List<com.squareup.javapoet.II0xO0>> next = it.next();
            oxox.I0Io("$L = ", next.getKey());
            oxoX(oxox, str, str2, next.getValue());
            if (it.hasNext()) {
                oxox.II0xO0(str2);
            }
        }
        oxox.XIxXXX0x0(2);
        oxox.II0xO0(str + oIX0oI.I0Io.f4095I0Io);
    }

    public II0xO0 II0XooXoX() {
        II0xO0 iI0xO0 = new II0xO0(this.f25900oIX0oI, null);
        for (Map.Entry<String, List<com.squareup.javapoet.II0xO0>> entry : this.f25899II0xO0.entrySet()) {
            iI0xO0.f25902II0xO0.put(entry.getKey(), new ArrayList(entry.getValue()));
        }
        return iI0xO0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || oIX0oI.class != obj.getClass()) {
            return false;
        }
        return toString().equals(obj.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public final void oxoX(XO00XOO.oxoX oxox, String str, String str2, List<com.squareup.javapoet.II0xO0> list) throws IOException {
        boolean z = true;
        if (list.size() == 1) {
            oxox.Oxx0xo(2);
            oxox.oIX0oI(list.get(0));
            oxox.XIxXXX0x0(2);
            return;
        }
        oxox.II0xO0("{" + str);
        oxox.Oxx0xo(2);
        for (com.squareup.javapoet.II0xO0 iI0xO0 : list) {
            if (!z) {
                oxox.II0xO0(str2);
            }
            oxox.oIX0oI(iI0xO0);
            z = false;
        }
        oxox.XIxXXX0x0(2);
        oxox.II0xO0(str + ooOOo0oXI.f33074oOoXoXO);
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            new XO00XOO.oxoX(stringWriter).I0Io("$L", this);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    public oIX0oI(II0xO0 iI0xO0) {
        this.f25900oIX0oI = iI0xO0.f25903oIX0oI;
        this.f25899II0xO0 = oOoXoXO.II0XooXoX(iI0xO0.f25902II0xO0);
    }
}
