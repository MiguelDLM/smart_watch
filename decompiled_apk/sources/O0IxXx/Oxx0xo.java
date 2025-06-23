package O0IxXx;

import android.content.Context;
import android.os.Environment;
import com.alimm.tanx.core.view.player.cache.ProxyCacheManager;
import java.io.File;

/* loaded from: classes11.dex */
public final class Oxx0xo {
    public static File I0Io(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (!file.exists() && !file.mkdirs()) {
            com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18686IIXOooo, "Unable to create external cache directory");
            return null;
        }
        return file;
    }

    public static File II0xO0(Context context, boolean z) {
        String str;
        File file;
        try {
            str = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            str = "";
        }
        if (z && "mounted".equals(str)) {
            file = I0Io(context);
        } else {
            file = null;
        }
        if (file == null) {
            file = context.getCacheDir();
        }
        if (file == null) {
            String str2 = "/data/data/" + context.getPackageName() + "/cache/";
            com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18686IIXOooo, "Can't define system cache directory! '" + str2 + "%s' will be used.");
            return new File(str2);
        }
        return file;
    }

    public static File oIX0oI(Context context) {
        return new File(II0xO0(context, true), ProxyCacheManager.CACHE_DIR);
    }
}
