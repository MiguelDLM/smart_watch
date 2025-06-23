package androidx.room;

import XxI.I0Io;
import XxI.oxoX;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;

@Target({})
@I0Io(AnnotationRetention.BINARY)
@oxoX(allowedTargets = {})
@Retention(RetentionPolicy.CLASS)
public @interface Index {

    public enum Order {
        ASC,
        DESC
    }

    String name() default "";

    Order[] orders() default {};

    boolean unique() default false;

    String[] value();
}
