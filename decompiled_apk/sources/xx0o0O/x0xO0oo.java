package xx0o0O;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.DeprecationLevel;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.internal.RequireKotlinVersionKind;
import kotlin.jvm.internal.x0o;
import kotlin.oxxXoxO;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.SOURCE)
@XxI.II0xO0
@XxI.oxoX(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.TYPEALIAS})
@oxxXoxO(version = "1.2")
@XxI.I0Io(AnnotationRetention.SOURCE)
@Repeatable(oIX0oI.class)
/* loaded from: classes6.dex */
public @interface x0xO0oo {

    @XxI.oxoX(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.TYPEALIAS})
    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
    @XxI.I0Io(AnnotationRetention.SOURCE)
    @x0o
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface oIX0oI {
        x0xO0oo[] value();
    }

    int errorCode() default -1;

    DeprecationLevel level() default DeprecationLevel.ERROR;

    String message() default "";

    String version();

    RequireKotlinVersionKind versionKind() default RequireKotlinVersionKind.LANGUAGE_VERSION;
}
