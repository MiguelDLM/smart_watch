package OIxOX;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes13.dex */
public @interface II0XooXoX {
    boolean applyDefaultConversion() default true;

    String defaultNullRead() default "null";

    String defaultNullWrite() default "null";

    String field() default "";

    int index() default -1;
}
