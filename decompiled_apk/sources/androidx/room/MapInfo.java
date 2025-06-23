package androidx.room;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@XxI.oxoX(allowedTargets = {AnnotationTarget.FUNCTION})
@Target({ElementType.METHOD})
@XxI.I0Io(AnnotationRetention.BINARY)
@kotlin.OOXIXo(message = "Use @MapColumn instead.")
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface MapInfo {
    String keyColumn() default "";

    String keyTable() default "";

    String valueColumn() default "";

    String valueTable() default "";
}
