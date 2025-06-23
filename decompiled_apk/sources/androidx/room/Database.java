package androidx.room;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@XxI.oxoX(allowedTargets = {AnnotationTarget.CLASS})
@Target({ElementType.TYPE})
@XxI.I0Io(AnnotationRetention.BINARY)
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface Database {
    AutoMigration[] autoMigrations() default {};

    Class<?>[] entities() default {};

    boolean exportSchema() default true;

    int version();

    Class<?>[] views() default {};
}
