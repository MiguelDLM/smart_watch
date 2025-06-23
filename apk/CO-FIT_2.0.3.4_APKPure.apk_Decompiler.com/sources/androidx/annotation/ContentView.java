package androidx.annotation;

import XxI.I0Io;
import XxI.oxoX;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.CONSTRUCTOR})
@I0Io(AnnotationRetention.BINARY)
@oxoX(allowedTargets = {AnnotationTarget.CONSTRUCTOR})
@Retention(RetentionPolicy.CLASS)
public @interface ContentView {
}
