package OIxOX;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes13.dex */
public @interface II0xO0 {
    String[] args() default {};

    Class<? extends xXo.Oxx0IOOO> conversionClass();
}
