package com.facebook.appevents.internal;

import OXOo.OOXIXo;
import android.os.AsyncTask;
import androidx.annotation.VisibleForTesting;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class FileDownloadTask extends AsyncTask<String, Void, Boolean> {

    @OOXIXo
    private final File destFile;

    @OOXIXo
    private final Callback onSuccess;

    @OOXIXo
    private final String uriStr;

    /* loaded from: classes8.dex */
    public interface Callback {
        void onComplete(@OOXIXo File file);
    }

    public FileDownloadTask(@OOXIXo String uriStr, @OOXIXo File destFile, @OOXIXo Callback onSuccess) {
        IIX0o.x0xO0oo(uriStr, "uriStr");
        IIX0o.x0xO0oo(destFile, "destFile");
        IIX0o.x0xO0oo(onSuccess, "onSuccess");
        this.uriStr = uriStr;
        this.destFile = destFile;
        this.onSuccess = onSuccess;
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ Boolean doInBackground(String[] strArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return doInBackground2(strArr);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onPostExecute(Boolean bool) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            onPostExecute(bool.booleanValue());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @OOXIXo
    @VisibleForTesting(otherwise = 4)
    /* renamed from: doInBackground, reason: avoid collision after fix types in other method */
    public Boolean doInBackground2(@OOXIXo String... args) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(args, "args");
            try {
                URL url = new URL(this.uriStr);
                int contentLength = url.openConnection().getContentLength();
                DataInputStream dataInputStream = new DataInputStream(url.openStream());
                byte[] bArr = new byte[contentLength];
                dataInputStream.readFully(bArr);
                dataInputStream.close();
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.destFile));
                dataOutputStream.write(bArr);
                dataOutputStream.flush();
                dataOutputStream.close();
                return Boolean.TRUE;
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public void onPostExecute(boolean z) {
        if (!CrashShieldHandler.isObjectCrashing(this) && z) {
            try {
                this.onSuccess.onComplete(this.destFile);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
