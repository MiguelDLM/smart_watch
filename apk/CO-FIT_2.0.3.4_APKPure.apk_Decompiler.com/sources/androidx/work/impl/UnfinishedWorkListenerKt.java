package androidx.work.impl;

import O0IoXXOx.XO;
import OXOo.OOXIXo;
import android.content.Context;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.utils.ProcessUtils;
import com.facebook.appevents.UserDataStore;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.I0Io;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.flow.Oxx0IOOO;
import kotlinx.coroutines.xII;

public final class UnfinishedWorkListenerKt {
    private static final int DELAY_MS = 30000;
    /* access modifiers changed from: private */
    public static final long MAX_DELAY_MS = TimeUnit.HOURS.toMillis(1);
    /* access modifiers changed from: private */
    @OOXIXo
    public static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("UnfinishedWorkListener");
        IIX0o.oO(tagWithPrefix, "tagWithPrefix(\"UnfinishedWorkListener\")");
        TAG = tagWithPrefix;
    }

    public static final void maybeLaunchUnfinishedWorkListener(@OOXIXo xII xii, @OOXIXo Context context, @OOXIXo Configuration configuration, @OOXIXo WorkDatabase workDatabase) {
        IIX0o.x0xO0oo(xii, "<this>");
        IIX0o.x0xO0oo(context, "appContext");
        IIX0o.x0xO0oo(configuration, XO.f15419Oxx0IOOO);
        IIX0o.x0xO0oo(workDatabase, UserDataStore.DATE_OF_BIRTH);
        if (ProcessUtils.isDefaultProcess(context, configuration)) {
            Oxx0IOOO.OIOoIIOIx(Oxx0IOOO.xxOXOOoIX(Oxx0IOOO.Xo0(Oxx0IOOO.XX(Oxx0IOOO.XoIxOXIXo(workDatabase.workSpecDao().hasUnfinishedWorkFlow(), new UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1((I0Io<? super UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1>) null)))), new UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2(context, (I0Io<? super UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2>) null)), xii);
        }
    }
}
