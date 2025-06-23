package XO0OX;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@XxI.oxoX(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.TYPE})
@Target({ElementType.TYPE, ElementType.METHOD})
@XxI.oIX0oI
@XxI.I0Io(AnnotationRetention.BINARY)
@Documented
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes6.dex */
public @interface oO {
    boolean suppress() default true;
}
