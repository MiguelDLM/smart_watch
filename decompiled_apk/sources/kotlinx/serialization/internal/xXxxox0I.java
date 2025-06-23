package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import kotlin.collections.ArraysKt___ArraysKt;

@kotlin.jvm.internal.XX({"SMAP\nEnums.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Enums.kt\nkotlinx/serialization/internal/EnumsKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,151:1\n13374#2,2:152\n13309#2,2:154\n13376#2:156\n13309#2,2:157\n13374#2,2:159\n13309#2,2:161\n13376#2:163\n*S KotlinDebug\n*F\n+ 1 Enums.kt\nkotlinx/serialization/internal/EnumsKt\n*L\n70#1:152,2\n73#1:154,2\n70#1:156\n91#1:157,2\n94#1:159,2\n97#1:161,2\n94#1:163\n*E\n"})
/* loaded from: classes6.dex */
public final class xXxxox0I {
    @OXOo.OOXIXo
    @kotlinx.serialization.XO
    public static final <T extends Enum<T>> kotlinx.serialization.Oxx0IOOO<T> I0Io(@OXOo.OOXIXo String serialName, @OXOo.OOXIXo T[] values) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(serialName, "serialName");
        kotlin.jvm.internal.IIX0o.x0xO0oo(values, "values");
        return new EnumSerializer(serialName, values);
    }

    @OXOo.OOXIXo
    @kotlinx.serialization.XO
    public static final <T extends Enum<T>> kotlinx.serialization.Oxx0IOOO<T> II0xO0(@OXOo.OOXIXo String serialName, @OXOo.OOXIXo T[] values, @OXOo.OOXIXo String[] names, @OXOo.OOXIXo Annotation[][] annotations) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(serialName, "serialName");
        kotlin.jvm.internal.IIX0o.x0xO0oo(values, "values");
        kotlin.jvm.internal.IIX0o.x0xO0oo(names, "names");
        kotlin.jvm.internal.IIX0o.x0xO0oo(annotations, "annotations");
        EnumDescriptor enumDescriptor = new EnumDescriptor(serialName, values.length);
        int length = values.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            T t = values[i];
            int i3 = i2 + 1;
            String str = (String) ArraysKt___ArraysKt.IxIOOxO(names, i2);
            if (str == null) {
                str = t.name();
            }
            PluginGeneratedSerialDescriptor.ooOOo0oXI(enumDescriptor, str, false, 2, null);
            Annotation[] annotationArr = (Annotation[]) ArraysKt___ArraysKt.IxIOOxO(annotations, i2);
            if (annotationArr != null) {
                for (Annotation annotation : annotationArr) {
                    enumDescriptor.IXxxXO(annotation);
                }
            }
            i++;
            i2 = i3;
        }
        return new EnumSerializer(serialName, values, enumDescriptor);
    }

    @OXOo.OOXIXo
    @kotlinx.serialization.XO
    public static final <T extends Enum<T>> kotlinx.serialization.Oxx0IOOO<T> oIX0oI(@OXOo.OOXIXo String serialName, @OXOo.OOXIXo T[] values, @OXOo.OOXIXo String[] names, @OXOo.OOXIXo Annotation[][] entryAnnotations, @OXOo.oOoXoXO Annotation[] annotationArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(serialName, "serialName");
        kotlin.jvm.internal.IIX0o.x0xO0oo(values, "values");
        kotlin.jvm.internal.IIX0o.x0xO0oo(names, "names");
        kotlin.jvm.internal.IIX0o.x0xO0oo(entryAnnotations, "entryAnnotations");
        EnumDescriptor enumDescriptor = new EnumDescriptor(serialName, values.length);
        if (annotationArr != null) {
            for (Annotation annotation : annotationArr) {
                enumDescriptor.Oxx0xo(annotation);
            }
        }
        int length = values.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            T t = values[i];
            int i3 = i2 + 1;
            String str = (String) ArraysKt___ArraysKt.IxIOOxO(names, i2);
            if (str == null) {
                str = t.name();
            }
            PluginGeneratedSerialDescriptor.ooOOo0oXI(enumDescriptor, str, false, 2, null);
            Annotation[] annotationArr2 = (Annotation[]) ArraysKt___ArraysKt.IxIOOxO(entryAnnotations, i2);
            if (annotationArr2 != null) {
                for (Annotation annotation2 : annotationArr2) {
                    enumDescriptor.IXxxXO(annotation2);
                }
            }
            i++;
            i2 = i3;
        }
        return new EnumSerializer(serialName, values, enumDescriptor);
    }
}
