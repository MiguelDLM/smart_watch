package com.kwai.library.ipneigh;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/* loaded from: classes11.dex */
class KwaiIpNeigh {
    private static final String TAG = "KwaiIpNeigh";

    static {
        System.loadLibrary("ipneigh-android");
    }

    private static boolean aA(String str, String str2) {
        if (str == null) {
            return false;
        }
        String[] split = str.split("\\s+");
        if (split.length < 2) {
            return false;
        }
        return split[0].equals(str2);
    }

    private static native int getARPTableFromJni(int i);

    private static native int getARPTableFromJni2(int i);

    public static String i(String str, boolean z) {
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream;
        int aRPTableFromJni;
        String readLine;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            ParcelFileDescriptor parcelFileDescriptor = createPipe[0];
            ParcelFileDescriptor parcelFileDescriptor2 = createPipe[1];
            autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
            int detachFd = parcelFileDescriptor2.detachFd();
            if (z) {
                aRPTableFromJni = getARPTableFromJni2(detachFd);
            } else {
                aRPTableFromJni = getARPTableFromJni(detachFd);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            Log.e(TAG, "getARPResult exception:" + th.getMessage());
        }
        if (aRPTableFromJni != 0) {
            Log.e(TAG, "ARP table reading failed, are you using targetSdk 32 and an Android 13 device?");
            return "";
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(autoCloseInputStream, StandardCharsets.UTF_8));
        do {
            readLine = bufferedReader.readLine();
            if (readLine == null) {
                return "";
            }
        } while (!aA(readLine, str));
        return readLine;
    }
}
