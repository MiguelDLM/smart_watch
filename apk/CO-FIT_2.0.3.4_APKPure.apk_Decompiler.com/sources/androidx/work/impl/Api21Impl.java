package androidx.work.impl;

import OXOo.OOXIXo;
import android.content.Context;
import androidx.annotation.RequiresApi;
import com.huawei.openalliance.ad.constant.bn;
import java.io.File;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(21)
public final class Api21Impl {
    @OOXIXo
    public static final Api21Impl INSTANCE = new Api21Impl();

    private Api21Impl() {
    }

    @OOXIXo
    public final File getNoBackupFilesDir(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, bn.f.o);
        File noBackupFilesDir = context.getNoBackupFilesDir();
        IIX0o.oO(noBackupFilesDir, "context.noBackupFilesDir");
        return noBackupFilesDir;
    }
}
