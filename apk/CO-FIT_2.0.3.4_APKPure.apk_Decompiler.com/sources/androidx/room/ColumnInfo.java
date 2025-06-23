package androidx.room;

import OXOo.OOXIXo;
import XxI.I0Io;
import XxI.oxoX;
import androidx.annotation.RequiresApi;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.FIELD, ElementType.METHOD})
@I0Io(AnnotationRetention.BINARY)
@oxoX(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.FUNCTION})
@Retention(RetentionPolicy.CLASS)
public @interface ColumnInfo {
    public static final int BINARY = 2;
    public static final int BLOB = 5;
    @OOXIXo
    public static final Companion Companion = Companion.$$INSTANCE;
    @OOXIXo
    public static final String INHERIT_FIELD_NAME = "[field-name]";
    public static final int INTEGER = 3;
    @RequiresApi(21)
    public static final int LOCALIZED = 5;
    public static final int NOCASE = 3;
    public static final int REAL = 4;
    public static final int RTRIM = 4;
    public static final int TEXT = 2;
    public static final int UNDEFINED = 1;
    @RequiresApi(21)
    public static final int UNICODE = 6;
    public static final int UNSPECIFIED = 1;
    @OOXIXo
    public static final String VALUE_UNSPECIFIED = "[value-unspecified]";

    @RequiresApi(21)
    @I0Io(AnnotationRetention.BINARY)
    @Retention(RetentionPolicy.CLASS)
    public @interface Collate {
    }

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int BINARY = 2;
        public static final int BLOB = 5;
        @OOXIXo
        public static final String INHERIT_FIELD_NAME = "[field-name]";
        public static final int INTEGER = 3;
        @RequiresApi(21)
        public static final int LOCALIZED = 5;
        public static final int NOCASE = 3;
        public static final int REAL = 4;
        public static final int RTRIM = 4;
        public static final int TEXT = 2;
        public static final int UNDEFINED = 1;
        @RequiresApi(21)
        public static final int UNICODE = 6;
        public static final int UNSPECIFIED = 1;
        @OOXIXo
        public static final String VALUE_UNSPECIFIED = "[value-unspecified]";

        private Companion() {
        }
    }

    @I0Io(AnnotationRetention.BINARY)
    @Retention(RetentionPolicy.CLASS)
    public @interface SQLiteTypeAffinity {
    }

    @Collate
    int collate() default 1;

    String defaultValue() default "[value-unspecified]";

    boolean index() default false;

    String name() default "[field-name]";

    @SQLiteTypeAffinity
    int typeAffinity() default 1;
}
