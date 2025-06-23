package com.bluetrum.abota.log;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bluetrum.abota.log.AppLogger;
import com.bluetrum.abota.time.Timber;
import com.bluetrum.fota.log.ILogger;
import com.bluetrum.fota.log.Logger;

/* loaded from: classes8.dex */
public class AppLogger {
    private static final ILogger fotaLogger = new ILogger() { // from class: Io.II0xO0
        @Override // com.bluetrum.fota.log.ILogger
        public final void log(int i, String str, String str2, Throwable th) {
            AppLogger.lambda$static$0(i, str, str2, th);
        }
    };

    public static void enableVerboseMode() {
        Logger.setLogLevel(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(int i, String str, String str2, Throwable th) {
        if (str == null) {
            Timber.log(i, str2, th);
        } else {
            Timber.tag(str).log(i, str2, th);
        }
    }

    public static void setupLogger(@NonNull Context context) {
        Logger.setLogger(fotaLogger);
    }
}
