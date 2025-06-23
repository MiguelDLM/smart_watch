package com.kwad.sdk.crash.handler;

import IXI.oxoX;
import android.os.Build;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.report.e;
import com.kwad.sdk.crash.utils.g;
import java.io.File;
import java.util.concurrent.CountDownLatch;

@Keep
/* loaded from: classes11.dex */
public final class NativeCrashHandler extends b {
    private static final String NATIVE_CRASH_HAPPENED_BEGIN = "------ Native Crash Happened Begin ------\n";
    private static final String TAG = "NativeCrashHandler";
    private static ExceptionMessage mMessage = new NativeExceptionMessage();
    private File mMessageFile;

    /* loaded from: classes11.dex */
    public static class a {
        private static final NativeCrashHandler aHo = new NativeCrashHandler();
    }

    public static native void doCrash();

    public static NativeCrashHandler getInstance() {
        return a.aHo;
    }

    public static native void install(@NonNull String str, boolean z, @NonNull String str2, int i);

    @Keep
    public static void onCallFromNative() {
        com.kwad.sdk.core.e.c.d(TAG, "onCallFromNative NativeCrashHandler.doCrash()");
        File file = getInstance().mLogDir;
        File file2 = getInstance().mMessageFile;
        File file3 = getInstance().mJavaTraceFile;
        File file4 = getInstance().mMemoryInfoFile;
        e uploader = getInstance().getUploader();
        try {
            if (!file.exists() && !file.mkdirs()) {
                StringBuilder sb = new StringBuilder();
                ExceptionMessage exceptionMessage = mMessage;
                sb.append(exceptionMessage.mErrorMessage);
                sb.append("create ");
                sb.append(file.getPath());
                sb.append(" failed!\n");
                exceptionMessage.mErrorMessage = sb.toString();
                if (uploader != null) {
                    mMessage.toJson();
                }
            }
            if (file2 == null) {
                StringBuilder sb2 = new StringBuilder();
                getInstance();
                sb2.append(b.FILE_NAME_BASE);
                sb2.append(oxoX.f655oxoX);
                file2 = new File(file, sb2.toString());
            }
            if (file3 == null) {
                StringBuilder sb3 = new StringBuilder();
                getInstance();
                sb3.append(b.FILE_NAME_BASE);
                sb3.append(".jtrace");
                file3 = new File(file, sb3.toString());
            }
            if (file4 == null) {
                StringBuilder sb4 = new StringBuilder();
                getInstance();
                sb4.append(b.FILE_NAME_BASE);
                sb4.append(".minfo");
                file4 = new File(file, sb4.toString());
            }
            g.b(null, mMessage, com.kwad.sdk.crash.e.If().getContext());
            g.a(mMessage, getInstance().getCrashType());
            if (getInstance().mExceptionListener != null) {
                getInstance().mExceptionListener.a(getInstance().getCrashType(), mMessage);
            }
            try {
                g.a(file2, mMessage.toJson().toString());
                g.G(file3);
                getInstance().backupLogFiles(file);
                g.a(uploader, TAG, getInstance().mDumpFile);
                getInstance().uploadRemainingExceptions();
                g.H(file4);
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                if (uploader != null) {
                    g.r(th);
                }
            }
        } catch (Throwable th2) {
            try {
                StringBuilder sb5 = new StringBuilder();
                ExceptionMessage exceptionMessage2 = mMessage;
                sb5.append(exceptionMessage2.mErrorMessage);
                sb5.append(th2);
                exceptionMessage2.mErrorMessage = sb5.toString();
                com.kwad.sdk.core.e.c.printStackTraceOnly(th2);
            } finally {
                if (file2 != null) {
                    try {
                        g.a(file2, mMessage.toJson().toString());
                    } catch (Throwable th3) {
                        com.kwad.sdk.core.e.c.printStackTraceOnly(th3);
                        if (uploader != null) {
                            g.r(th3);
                        }
                    }
                }
                g.G(file3);
                getInstance().backupLogFiles(file);
                g.a(uploader, TAG, getInstance().mDumpFile);
                getInstance().uploadRemainingExceptions();
                g.H(file4);
            }
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final int getCrashType() {
        return 4;
    }

    public final void init(@NonNull File file, boolean z, @NonNull String str, com.kwad.sdk.crash.report.c cVar) {
        super.init(file, null, cVar);
        if (!com.kwad.sdk.crash.b.HO()) {
            return;
        }
        this.mLogDir = file;
        if (!file.exists()) {
            this.mLogDir.mkdirs();
        }
        StringBuilder sb = new StringBuilder();
        String str2 = b.FILE_NAME_BASE;
        sb.append(str2);
        sb.append(".dump");
        this.mDumpFile = new File(file, sb.toString());
        this.mJavaTraceFile = new File(file, str2 + ".jtrace");
        this.mMemoryInfoFile = new File(file, str2 + ".minfo");
        try {
            com.kwad.sdk.core.e.c.d(TAG, "ANR init2 " + this.mDumpFile.getPath());
            install(this.mDumpFile.getPath(), z, str, Build.VERSION.SDK_INT);
            this.mMessageFile = new File(file, str2 + oxoX.f655oxoX);
        } catch (Throwable unused) {
            getUploader();
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void reportException(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.g gVar = new com.kwad.sdk.crash.report.g();
        gVar.a(getUploader());
        for (File file : fileArr) {
            gVar.a(file, countDownLatch);
        }
    }

    private NativeCrashHandler() {
    }
}
