package o0IXXIx;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* loaded from: classes11.dex */
public class OOXIXo {
    public static File oIX0oI(Context context) {
        File file = null;
        if (context == null) {
            return null;
        }
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
                file = context.getExternalFilesDir(null);
            }
            if (file == null) {
                return context.getFilesDir();
            }
            return file;
        } catch (Exception unused) {
            return context.getFilesDir();
        }
    }
}
