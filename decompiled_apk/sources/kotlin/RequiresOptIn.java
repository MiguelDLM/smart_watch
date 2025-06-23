package kotlin;

import com.baidu.mobads.sdk.internal.cb;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@XxI.oxoX(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
@Target({ElementType.ANNOTATION_TYPE})
@oxxXoxO(version = "1.3")
@XxI.I0Io(AnnotationRetention.BINARY)
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes6.dex */
public @interface RequiresOptIn {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes6.dex */
    public static final class Level {
        private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
        private static final /* synthetic */ Level[] $VALUES;
        public static final Level WARNING = new Level("WARNING", 0);
        public static final Level ERROR = new Level(cb.l, 1);

        private static final /* synthetic */ Level[] $values() {
            return new Level[]{WARNING, ERROR};
        }

        static {
            Level[] $values = $values();
            $VALUES = $values;
            $ENTRIES = kotlin.enums.I0Io.I0Io($values);
        }

        private Level(String str, int i) {
        }

        @OXOo.OOXIXo
        public static kotlin.enums.oIX0oI<Level> getEntries() {
            return $ENTRIES;
        }

        public static Level valueOf(String str) {
            return (Level) Enum.valueOf(Level.class, str);
        }

        public static Level[] values() {
            return (Level[]) $VALUES.clone();
        }
    }

    Level level() default Level.ERROR;

    String message() default "";
}
