package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.utils.ProcessUtils;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.xII;

/* loaded from: classes.dex */
public final class UnfinishedWorkListenerKt {
    private static final int DELAY_MS = 30000;
    private static final long MAX_DELAY_MS;

    @OXOo.OOXIXo
    private static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("UnfinishedWorkListener");
        IIX0o.oO(tagWithPrefix, "tagWithPrefix(\"UnfinishedWorkListener\")");
        TAG = tagWithPrefix;
        MAX_DELAY_MS = TimeUnit.HOURS.toMillis(1L);
    }

    public static final void maybeLaunchUnfinishedWorkListener(@OXOo.OOXIXo xII xii, @OXOo.OOXIXo Context appContext, @OXOo.OOXIXo Configuration configuration, @OXOo.OOXIXo WorkDatabase db) {
        IIX0o.x0xO0oo(xii, "<this>");
        IIX0o.x0xO0oo(appContext, "appContext");
        IIX0o.x0xO0oo(configuration, "configuration");
        IIX0o.x0xO0oo(db, "db");
        if (ProcessUtils.isDefaultProcess(appContext, configuration)) {
            kotlinx.coroutines.flow.Oxx0IOOO.OIOoIIOIx(kotlinx.coroutines.flow.Oxx0IOOO.xxOXOOoIX(kotlinx.coroutines.flow.Oxx0IOOO.Xo0(kotlinx.coroutines.flow.Oxx0IOOO.XX(kotlinx.coroutines.flow.Oxx0IOOO.XoIxOXIXo(db.workSpecDao().hasUnfinishedWorkFlow(), new UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1(null)))), new UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2(appContext, null)), xii);
        }
    }
}
