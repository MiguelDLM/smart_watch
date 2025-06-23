package androidx.work.impl;

import androidx.work.Logger;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class WorkDatabasePathHelperKt {

    @OXOo.OOXIXo
    private static final String[] DATABASE_EXTRA_FILES;

    @OXOo.OOXIXo
    private static final String TAG;

    @OXOo.OOXIXo
    public static final String WORK_DATABASE_NAME = "androidx.work.workdb";

    static {
        String tagWithPrefix = Logger.tagWithPrefix("WrkDbPathHelper");
        IIX0o.oO(tagWithPrefix, "tagWithPrefix(\"WrkDbPathHelper\")");
        TAG = tagWithPrefix;
        DATABASE_EXTRA_FILES = new String[]{"-journal", "-shm", "-wal"};
    }
}
