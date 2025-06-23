package kotlinx.serialization.modules;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
final class SerializerAlreadyRegisteredException extends IllegalArgumentException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SerializerAlreadyRegisteredException(@OOXIXo String msg) {
        super(msg);
        IIX0o.x0xO0oo(msg, "msg");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SerializerAlreadyRegisteredException(@OOXIXo kotlin.reflect.oxoX<?> baseClass, @OOXIXo kotlin.reflect.oxoX<?> concreteClass) {
        this("Serializer for " + concreteClass + " already registered in the scope of " + baseClass);
        IIX0o.x0xO0oo(baseClass, "baseClass");
        IIX0o.x0xO0oo(concreteClass, "concreteClass");
    }
}
