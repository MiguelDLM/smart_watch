package androidx.startup;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class StartupLogger {
    static final boolean DEBUG = false;
    private static final String TAG = "StartupLogger";

    private StartupLogger() {
    }

    public static void e(@NonNull String str, @Nullable Throwable th) {
        Log.e(TAG, str, th);
    }

    public static void i(@NonNull String str) {
        Log.i(TAG, str);
    }

    public static void w(@NonNull String str) {
        Log.w(TAG, str);
    }
}
