package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;

@Retention(RetentionPolicy.CLASS)
@XxI.I0Io(AnnotationRetention.BINARY)
/* loaded from: classes.dex */
public @interface OnConflictStrategy {
    public static final int ABORT = 3;

    @OXOo.OOXIXo
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int FAIL = 4;
    public static final int IGNORE = 5;
    public static final int NONE = 0;
    public static final int REPLACE = 1;
    public static final int ROLLBACK = 2;

    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int ABORT = 3;
        public static final int FAIL = 4;
        public static final int IGNORE = 5;
        public static final int NONE = 0;
        public static final int REPLACE = 1;
        public static final int ROLLBACK = 2;

        private Companion() {
        }

        @kotlin.OOXIXo(message = "Use ABORT instead.")
        public static /* synthetic */ void getFAIL$annotations() {
        }

        @kotlin.OOXIXo(message = "Use ABORT instead.")
        public static /* synthetic */ void getROLLBACK$annotations() {
        }
    }
}
