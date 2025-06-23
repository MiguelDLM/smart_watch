package Oo0IXI0;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes6.dex */
public @interface oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final String f2035I0Io = "This container (if the parameter was annotated) or the return value (if instance method was annotated)";

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f2036II0xO0 = "this";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final String f2037X0o0xo = "this";

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f2038oIX0oI = "The method argument (if parameter was annotated) or this container (if instance method was annotated)";

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f2039oxoX = "The return value of this method";

    String source() default "The method argument (if parameter was annotated) or this container (if instance method was annotated)";

    boolean sourceIsContainer() default false;

    String target() default "This container (if the parameter was annotated) or the return value (if instance method was annotated)";

    boolean targetIsContainer() default false;
}
