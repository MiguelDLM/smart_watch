package androidx.room;

import androidx.annotation.RequiresApi;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@XxI.oxoX(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.FUNCTION})
@Target({ElementType.FIELD, ElementType.METHOD})
@XxI.I0Io(AnnotationRetention.BINARY)
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface ColumnInfo {
    public static final int BINARY = 2;
    public static final int BLOB = 5;

    @OXOo.OOXIXo
    public static final Companion Companion = Companion.$$INSTANCE;

    @OXOo.OOXIXo
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

    @OXOo.OOXIXo
    public static final String VALUE_UNSPECIFIED = "[value-unspecified]";

    @XxI.I0Io(AnnotationRetention.BINARY)
    @RequiresApi(21)
    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface Collate {
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int BINARY = 2;
        public static final int BLOB = 5;

        @OXOo.OOXIXo
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

        @OXOo.OOXIXo
        public static final String VALUE_UNSPECIFIED = "[value-unspecified]";

        private Companion() {
        }
    }

    @Retention(RetentionPolicy.CLASS)
    @XxI.I0Io(AnnotationRetention.BINARY)
    /* loaded from: classes.dex */
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
