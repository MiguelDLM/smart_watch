package XxI;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@oxoX(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes6.dex */
public @interface I0Io {
    AnnotationRetention value() default AnnotationRetention.RUNTIME;
}
