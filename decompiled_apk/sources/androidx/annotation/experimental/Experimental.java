package androidx.annotation.experimental;

import XxI.I0Io;
import XxI.oxoX;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.OOXIXo;
import kotlin.XX;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@oxoX(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
@Target({ElementType.ANNOTATION_TYPE})
@I0Io(AnnotationRetention.BINARY)
@OOXIXo(message = "This annotation has been replaced by `@RequiresOptIn`", replaceWith = @XX(expression = "RequiresOptIn", imports = {"androidx.annotation.RequiresOptIn"}))
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface Experimental {

    /* loaded from: classes.dex */
    public enum Level {
        WARNING,
        ERROR
    }

    Level level() default Level.ERROR;
}
