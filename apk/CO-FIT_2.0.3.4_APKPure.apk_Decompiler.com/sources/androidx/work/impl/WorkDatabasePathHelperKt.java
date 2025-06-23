package androidx.work.impl;

import OXOo.OOXIXo;
import androidx.work.Logger;
import kotlin.jvm.internal.IIX0o;

public final class WorkDatabasePathHelperKt {
    /* access modifiers changed from: private */
    @OOXIXo
    public static final String[] DATABASE_EXTRA_FILES = {"-journal", "-shm", "-wal"};
    /* access modifiers changed from: private */
    @OOXIXo
    public static final String TAG;
    @OOXIXo
    public static final String WORK_DATABASE_NAME = "androidx.work.workdb";

    static {
        String tagWithPrefix = Logger.tagWithPrefix("WrkDbPathHelper");
        IIX0o.oO(tagWithPrefix, "tagWithPrefix(\"WrkDbPathHelper\")");
        TAG = tagWithPrefix;
    }
}
