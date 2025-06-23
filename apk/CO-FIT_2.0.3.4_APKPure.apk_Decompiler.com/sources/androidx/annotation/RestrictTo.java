package androidx.annotation;

import OXOo.OOXIXo;
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

@oxoX(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FIELD, AnnotationTarget.FILE})
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
@I0Io(AnnotationRetention.BINARY)
@oIX0oI
@Retention(RetentionPolicy.CLASS)
public @interface RestrictTo {

    public enum Scope {
        LIBRARY,
        LIBRARY_GROUP,
        LIBRARY_GROUP_PREFIX,
        GROUP_ID,
        TESTS,
        SUBCLASSES;

        static {
            Scope[] $values;
            $ENTRIES = kotlin.enums.I0Io.I0Io($values);
        }

        @OOXIXo
        public static kotlin.enums.oIX0oI<Scope> getEntries() {
            return $ENTRIES;
        }
    }

    Scope[] value();
}
