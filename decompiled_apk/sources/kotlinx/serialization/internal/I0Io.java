package kotlinx.serialization.internal;

import kotlin.KotlinNothingValueException;
import kotlinx.serialization.SerializationException;

/* loaded from: classes6.dex */
public final class I0Io {
    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "throwSubtypeNotRegistered")
    public static final Void II0xO0(@OXOo.OOXIXo kotlin.reflect.oxoX<?> subClass, @OXOo.OOXIXo kotlin.reflect.oxoX<?> baseClass) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(subClass, "subClass");
        kotlin.jvm.internal.IIX0o.x0xO0oo(baseClass, "baseClass");
        String xoXoI2 = subClass.xoXoI();
        if (xoXoI2 == null) {
            xoXoI2 = String.valueOf(subClass);
        }
        oIX0oI(xoXoI2, baseClass);
        throw new KotlinNothingValueException();
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "throwSubtypeNotRegistered")
    public static final Void oIX0oI(@OXOo.oOoXoXO String str, @OXOo.OOXIXo kotlin.reflect.oxoX<?> baseClass) {
        String str2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(baseClass, "baseClass");
        String str3 = "in the polymorphic scope of '" + baseClass.xoXoI() + '\'';
        if (str == null) {
            str2 = "Class discriminator was missing and no default serializers were registered " + str3 + '.';
        } else {
            str2 = "Serializer for subclass '" + str + "' is not found " + str3 + ".\nCheck if class with serial name '" + str + "' exists and serializer is registered in a corresponding SerializersModule.\nTo be registered automatically, class '" + str + "' has to be '@Serializable', and the base class '" + baseClass.xoXoI() + "' has to be sealed and '@Serializable'.";
        }
        throw new SerializationException(str2);
    }
}
