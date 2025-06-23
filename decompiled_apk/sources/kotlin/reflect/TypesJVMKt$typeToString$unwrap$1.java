package kotlin.reflect;

import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public /* synthetic */ class TypesJVMKt$typeToString$unwrap$1 extends FunctionReferenceImpl implements Oox.oOoXoXO<Class<?>, Class<?>> {
    public static final TypesJVMKt$typeToString$unwrap$1 INSTANCE = new TypesJVMKt$typeToString$unwrap$1();

    public TypesJVMKt$typeToString$unwrap$1() {
        super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
    }

    @Override // Oox.oOoXoXO
    public final Class<?> invoke(@OXOo.OOXIXo Class<?> p0) {
        IIX0o.x0xO0oo(p0, "p0");
        return p0.getComponentType();
    }
}
