package androidx.annotation;

import XxI.I0Io;
import XxI.oxoX;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.ANNOTATION_TYPE})
@I0Io(AnnotationRetention.BINARY)
@oxoX(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
@Retention(RetentionPolicy.CLASS)
public @interface RequiresOptIn {

    public enum Level {
        WARNING,
        ERROR
    }

    Level level() default Level.ERROR;
}
