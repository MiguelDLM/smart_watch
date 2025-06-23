package kotlin.reflect;

import java.lang.reflect.Type;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public /* synthetic */ class ParameterizedTypeImpl$getTypeName$1$1 extends FunctionReferenceImpl implements Oox.oOoXoXO<Type, String> {
    public static final ParameterizedTypeImpl$getTypeName$1$1 INSTANCE = new ParameterizedTypeImpl$getTypeName$1$1();

    public ParameterizedTypeImpl$getTypeName$1$1() {
        super(1, TypesJVMKt.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
    }

    @Override // Oox.oOoXoXO
    @OXOo.OOXIXo
    public final String invoke(@OXOo.OOXIXo Type p0) {
        String xoIox2;
        IIX0o.x0xO0oo(p0, "p0");
        xoIox2 = TypesJVMKt.xoIox(p0);
        return xoIox2;
    }
}
