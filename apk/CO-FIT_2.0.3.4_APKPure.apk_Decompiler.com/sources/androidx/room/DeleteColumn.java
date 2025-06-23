package androidx.room;

import XxI.I0Io;
import XxI.oxoX;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.TYPE})
@I0Io(AnnotationRetention.BINARY)
@Repeatable(Entries.class)
@oxoX(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.CLASS)
public @interface DeleteColumn {

    @Target({ElementType.TYPE})
    @I0Io(AnnotationRetention.BINARY)
    @oxoX(allowedTargets = {AnnotationTarget.CLASS})
    @Retention(RetentionPolicy.CLASS)
    public @interface Entries {
        DeleteColumn[] value();
    }

    String columnName();

    String tableName();
}
