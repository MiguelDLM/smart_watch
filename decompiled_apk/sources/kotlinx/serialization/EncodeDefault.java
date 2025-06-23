package kotlinx.serialization;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationTarget;

@XxI.oxoX(allowedTargets = {AnnotationTarget.PROPERTY})
@Target({})
@XxI.oIX0oI
@oxoX
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes6.dex */
public @interface EncodeDefault {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @oxoX
    /* loaded from: classes6.dex */
    public static final class Mode {
        private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final Mode ALWAYS = new Mode("ALWAYS", 0);
        public static final Mode NEVER = new Mode("NEVER", 1);

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{ALWAYS, NEVER};
        }

        static {
            Mode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = kotlin.enums.I0Io.I0Io($values);
        }

        private Mode(String str, int i) {
        }

        @OXOo.OOXIXo
        public static kotlin.enums.oIX0oI<Mode> getEntries() {
            return $ENTRIES;
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }

    Mode mode() default Mode.ALWAYS;
}
