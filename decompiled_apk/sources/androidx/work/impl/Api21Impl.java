package androidx.work.impl;

import android.content.Context;
import androidx.annotation.RequiresApi;
import java.io.File;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class Api21Impl {

    @OXOo.OOXIXo
    public static final Api21Impl INSTANCE = new Api21Impl();

    private Api21Impl() {
    }

    @OXOo.OOXIXo
    public final File getNoBackupFilesDir(@OXOo.OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        File noBackupFilesDir = context.getNoBackupFilesDir();
        IIX0o.oO(noBackupFilesDir, "context.noBackupFilesDir");
        return noBackupFilesDir;
    }
}
