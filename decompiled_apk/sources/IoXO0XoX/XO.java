package IoXO0XoX;

import IoXO0XoX.I0Io;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.x0o;

@XxI.oxoX(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.PROPERTY})
@Target({ElementType.TYPE})
@XxI.I0Io(AnnotationRetention.SOURCE)
@Repeatable(oIX0oI.class)
@Retention(RetentionPolicy.SOURCE)
@XxI.II0xO0
/* loaded from: classes6.dex */
public @interface XO<T, P extends I0Io<? super T>> {

    @XxI.oxoX(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.PROPERTY})
    @Target({ElementType.TYPE})
    @XxI.I0Io(AnnotationRetention.SOURCE)
    @x0o
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface oIX0oI {
        XO[] value();
    }
}
