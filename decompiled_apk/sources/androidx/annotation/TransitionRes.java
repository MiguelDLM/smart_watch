package androidx.annotation;

import XxI.I0Io;
import XxI.oIX0oI;
import XxI.oxoX;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@oxoX(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD})
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@oIX0oI
@I0Io(AnnotationRetention.SOURCE)
@Documented
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes.dex */
public @interface TransitionRes {
}
