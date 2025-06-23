package com.jieli.bmp_convert;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.jieli.bmp_convert.BmpConvert;
import com.jieli.bmp_convert.OnConvertListener;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes10.dex */
public class BmpConvert {
    public static final int ERR_INVALID_PARAM = -3584;
    public static final int ERR_IO_EXCEPTION = -3586;
    public static final int ERR_NOT_FOUND_FILE = -3585;
    public static final int TYPE_695N_RBG = 0;
    public static final int TYPE_701N_ARGB = 2;
    public static final int TYPE_701N_ARGB_NO_PACK = 4;
    public static final int TYPE_701N_RGB = 1;
    public static final int TYPE_701N_RGB_NO_PACK = 3;
    public static final int TYPE_707N_ARGB = 6;
    public static final int TYPE_707N_ARGB_NO_PACK = 8;
    public static final int TYPE_707N_RGB = 5;
    public static final int TYPE_707N_RGB_NO_PACK = 7;

    @Deprecated
    public static final int TYPE_BR_23 = 0;

    @Deprecated
    public static final int TYPE_BR_28 = 1;

    @Deprecated
    public static final int TYPE_BR_28_ALPHA = 2;

    @Deprecated
    public static final int TYPE_BR_28_ALPHA_RAW = 4;

    @Deprecated
    public static final int TYPE_BR_28_RAW = 3;
    public static final String c = "BmpConvert";
    public static final int[] d = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    public static boolean isLog = false;

    /* renamed from: a, reason: collision with root package name */
    public ExecutorService f17673a;
    public final Handler b = new Handler(Looper.getMainLooper());

    static {
        try {
            System.loadLibrary("jl_bmp_convert");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BmpConvert() {
        a(String.format(Locale.ENGLISH, "[Init] >>> Library name = %s(%d)", getLibVersionName(), Integer.valueOf(getLibVersionCode())));
        a("[Init] >>> " + this);
    }

    public static int getLibVersionCode() {
        return 10400;
    }

    public static String getLibVersionName() {
        return "1.4.0";
    }

    public void bitmapConvert(String str, String str2, OnConvertListener onConvertListener) {
        bitmapConvert(0, str, str2, onConvertListener);
    }

    public int bitmapConvertBlock(int i, String str, String str2) {
        if (a(i)) {
            a("[bitmapConvertBlock] >>> Unknown Type = " + i);
            return ERR_INVALID_PARAM;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            int height = decodeFile.getHeight() * decodeFile.getWidth();
            int[] iArr = new int[height];
            decodeFile.getPixels(iArr, 0, decodeFile.getWidth(), 0, 0, decodeFile.getWidth(), decodeFile.getHeight());
            byte[] bArr = new byte[height * 4];
            for (int i2 = 0; i2 < height; i2++) {
                int i3 = i2 << 2;
                int i4 = iArr[i2];
                bArr[i3] = (byte) (i4 & 255);
                bArr[i3 + 1] = (byte) ((i4 >> 8) & 255);
                bArr[i3 + 2] = (byte) ((i4 >> 16) & 255);
                bArr[i3 + 3] = (byte) ((i4 >> 24) & 255);
            }
            String str3 = str.substring(0, str.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR)) + ".bin";
            File file2 = new File(str3);
            try {
                if (file2.exists() && !file2.delete()) {
                    a("[bitmapConvertBlock] >>> Failed to delete file. path = " + str3);
                }
                if (!file2.createNewFile()) {
                    a("[bitmapConvertBlock] >>> Failed to create new file. path = " + str3);
                    return ERR_IO_EXCEPTION;
                }
                FileOutputStream fileOutputStream = new FileOutputStream(str3);
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                int bmpConvert_native = bmpConvert_native(i, str3, decodeFile.getWidth(), decodeFile.getHeight(), str2);
                if (bmpConvert_native > 0 && !file2.delete()) {
                    a("[bitmapConvertBlock] >>> Failed to delete cache file. path = " + str3);
                }
                return bmpConvert_native;
            } catch (IOException e) {
                e.printStackTrace();
                a("[bitmapConvertBlock] >>> IOException : " + e);
                return ERR_IO_EXCEPTION;
            }
        }
        a("[bitmapConvertBlock] >>> file not found. path = " + str);
        return ERR_NOT_FOUND_FILE;
    }

    public native int bmpConvert_native(int i, String str, int i2, int i3, String str2);

    public void release() {
        a("[release] >>> " + this);
        ExecutorService executorService = this.f17673a;
        if (executorService != null && !executorService.isShutdown()) {
            this.f17673a.shutdownNow();
        }
        this.f17673a = null;
        this.b.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final OnConvertListener onConvertListener, final String str, int i, final String str2) {
        if (onConvertListener != null) {
            this.b.post(new Runnable() { // from class: o0oIxOo.oIX0oI
                @Override // java.lang.Runnable
                public final void run() {
                    OnConvertListener.this.onStart(str);
                }
            });
        }
        final int bitmapConvertBlock = bitmapConvertBlock(i, str, str2);
        if (onConvertListener != null) {
            this.b.post(new Runnable() { // from class: o0oIxOo.II0xO0
                @Override // java.lang.Runnable
                public final void run() {
                    BmpConvert.a(bitmapConvertBlock, onConvertListener, str2);
                }
            });
        }
    }

    public void bitmapConvert(final int i, final String str, final String str2, final OnConvertListener onConvertListener) {
        ExecutorService executorService = this.f17673a;
        if (executorService == null || executorService.isShutdown()) {
            this.f17673a = Executors.newSingleThreadExecutor();
        }
        this.f17673a.submit(new Runnable() { // from class: o0oIxOo.I0Io
            @Override // java.lang.Runnable
            public final void run() {
                BmpConvert.this.a(onConvertListener, str, i, str2);
            }
        });
    }

    public static /* synthetic */ void a(int i, OnConvertListener onConvertListener, String str) {
        if (i > 0) {
            onConvertListener.onStop(true, str);
        } else {
            onConvertListener.onStop(false, null);
        }
    }

    public final boolean a(int i) {
        for (int i2 : d) {
            if (i2 == i) {
                return false;
            }
        }
        return true;
    }

    public final void a(String str) {
        if (!isLog || str == null || str.length() == 0) {
            return;
        }
        Log.i(c, str);
    }
}
