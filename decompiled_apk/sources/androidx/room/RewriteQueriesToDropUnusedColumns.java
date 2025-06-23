package androidx.room;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@XxI.oxoX(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.CLASS})
@Target({ElementType.TYPE, ElementType.METHOD})
@XxI.I0Io(AnnotationRetention.BINARY)
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface RewriteQueriesToDropUnusedColumns {
}
