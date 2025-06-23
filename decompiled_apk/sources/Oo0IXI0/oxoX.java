package Oo0IXI0;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes6.dex */
public @interface oxoX {
    @OXOo.xoIox
    String prefix() default "";

    @OXOo.xoIox
    String suffix() default "";

    @OXOo.xoIox
    String value();
}
