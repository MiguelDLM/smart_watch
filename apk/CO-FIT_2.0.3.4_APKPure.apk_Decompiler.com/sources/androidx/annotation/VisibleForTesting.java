package androidx.annotation;

import OXOo.OOXIXo;
import XxI.I0Io;
import XxI.oIX0oI;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;

@Documented
@I0Io(AnnotationRetention.BINARY)
@oIX0oI
@Retention(RetentionPolicy.CLASS)
public @interface VisibleForTesting {
    @OOXIXo
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int NONE = 5;
    public static final int PACKAGE_PRIVATE = 3;
    public static final int PRIVATE = 2;
    public static final int PROTECTED = 4;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int NONE = 5;
        public static final int PACKAGE_PRIVATE = 3;
        public static final int PRIVATE = 2;
        public static final int PROTECTED = 4;

        private Companion() {
        }
    }

    int otherwise() default 2;
}
