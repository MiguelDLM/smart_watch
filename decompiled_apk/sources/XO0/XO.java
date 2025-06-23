package XO0;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.simple.eventbus.ThreadMode;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes6.dex */
public @interface XO {
    ThreadMode mode() default ThreadMode.MAIN;

    String tag() default "default_tag";
}
