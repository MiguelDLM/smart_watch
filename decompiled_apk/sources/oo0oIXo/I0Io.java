package oo0oIXo;

import XxXX.X0o0xo;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class I0Io {

    /* loaded from: classes13.dex */
    public static class II0xO0 implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Handler f32230Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ String f32231XO;

        public II0xO0(String str, Handler handler) {
            this.f32231XO = str;
            this.f32230Oo = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            String str2;
            try {
                Bitmap I0Io2 = I0Io.I0Io(this.f32231XO, 840);
                if (I0Io2 != null) {
                    File externalFilesDir = X0o0xo.oIX0oI().getExternalFilesDir("Images");
                    String str3 = null;
                    if (externalFilesDir != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(externalFilesDir.getAbsolutePath());
                        String str4 = File.separator;
                        sb.append(str4);
                        sb.append(com.tencent.connect.common.II0xO0.f26764O0OOX0IIx);
                        sb.append(str4);
                        str2 = sb.toString();
                        str = null;
                    } else {
                        File cacheDir = X0o0xo.oIX0oI().getCacheDir();
                        if (cacheDir == null) {
                            xxIXOIIO.oOoXoXO("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() getCacheDir = null,return error");
                            Message obtainMessage = this.f32230Oo.obtainMessage();
                            obtainMessage.arg1 = 102;
                            this.f32230Oo.sendMessage(obtainMessage);
                            return;
                        }
                        String absolutePath = cacheDir.getAbsolutePath();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(absolutePath);
                        String str5 = File.separator;
                        sb2.append(str5);
                        sb2.append(com.tencent.connect.common.II0xO0.f26764O0OOX0IIx);
                        sb2.append(str5);
                        String sb3 = sb2.toString();
                        xxIXOIIO.oOoXoXO("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() use cache dir=" + sb3);
                        str = absolutePath;
                        str2 = sb3;
                    }
                    String str6 = "share2qq_temp" + com.tencent.open.utils.II0xO0.IoOoX(this.f32231XO) + ".jpg";
                    String str7 = this.f32231XO;
                    if (!I0Io.II0XooXoX(str7, 840, 840)) {
                        xxIXOIIO.oOoXoXO("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() not out of bound,not compress!");
                    } else {
                        xxIXOIIO.oOoXoXO("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() out of bound,compress!");
                        String oxoX2 = I0Io.oxoX(I0Io2, str2, str6);
                        if (!TextUtils.isEmpty(oxoX2)) {
                            str7 = oxoX2;
                        }
                    }
                    boolean oxxXoxO2 = com.tencent.open.utils.II0xO0.oxxXoxO(str7);
                    xxIXOIIO.oOoXoXO("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() check file isAppSpecificDir=" + oxxXoxO2);
                    ArrayList arrayList = new ArrayList(2);
                    if (oxxXoxO2) {
                        str3 = str7;
                    } else if (TextUtils.isEmpty(str)) {
                        String str8 = str2 + str6;
                        boolean O0xOxO2 = com.tencent.open.utils.II0xO0.O0xOxO(str7, str8);
                        xxIXOIIO.oOoXoXO("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() sd permission not denied. copy to app sepcific:" + str8 + ",isSuccess=" + O0xOxO2);
                        if (O0xOxO2) {
                            str3 = str8;
                        }
                    }
                    arrayList.add(str7);
                    arrayList.add(str3);
                    if (arrayList.size() >= 2 && (arrayList.get(0) != null || arrayList.get(1) != null)) {
                        xxIXOIIO.oOoXoXO("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return success ! destFilePath=[" + ((String) arrayList.get(0)) + "," + ((String) arrayList.get(1)) + "]");
                        Message obtainMessage2 = this.f32230Oo.obtainMessage(101);
                        obtainMessage2.obj = arrayList;
                        this.f32230Oo.sendMessage(obtainMessage2);
                        return;
                    }
                }
            } catch (Exception e) {
                xxIXOIIO.xxIXOIIO("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage runnable exception e:", e);
            }
            xxIXOIIO.XO("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return failed!");
            Message obtainMessage3 = this.f32230Oo.obtainMessage(102);
            obtainMessage3.arg1 = 3;
            this.f32230Oo.sendMessage(obtainMessage3);
        }
    }

    /* loaded from: classes13.dex */
    public static class oIX0oI extends Handler {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ XxXX.I0Io f32232oIX0oI;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public oIX0oI(Looper looper, XxXX.I0Io i0Io) {
            super(looper);
            this.f32232oIX0oI = i0Io;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 101) {
                if (i != 102) {
                    super.handleMessage(message);
                    return;
                } else {
                    this.f32232oIX0oI.a(message.arg1, (String) null);
                    return;
                }
            }
            this.f32232oIX0oI.a(0, (ArrayList<String>) message.obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final android.graphics.Bitmap I0Io(java.lang.String r6, int r7) {
        /*
            java.lang.String r0 = "openSDK_LOG.AsynScaleCompressImage"
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            r2 = 0
            if (r1 == 0) goto La
            return r2
        La:
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options
            r1.<init>()
            r3 = 1
            r1.inJustDecodeBounds = r3
            android.graphics.BitmapFactory.decodeFile(r6, r1)     // Catch: java.lang.OutOfMemoryError -> L16
            goto L1d
        L16:
            r3 = move-exception
            java.lang.String r4 = "scaleBitmap exception1:"
            xx0.xxIXOIIO.xxIXOIIO(r0, r4, r3)
        L1d:
            int r3 = r1.outWidth
            int r4 = r1.outHeight
            boolean r5 = r1.mCancel
            if (r5 != 0) goto L6d
            r5 = -1
            if (r3 == r5) goto L6d
            if (r4 != r5) goto L2b
            goto L6d
        L2b:
            if (r3 <= r4) goto L2e
            goto L2f
        L2e:
            r3 = r4
        L2f:
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.RGB_565
            r1.inPreferredConfig = r4
            if (r3 <= r7) goto L3d
            int r3 = r7 * r7
            int r3 = oIX0oI(r1, r5, r3)
            r1.inSampleSize = r3
        L3d:
            r3 = 0
            r1.inJustDecodeBounds = r3
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeFile(r6, r1)     // Catch: java.lang.OutOfMemoryError -> L45 java.lang.Exception -> L4d
            goto L55
        L45:
            r6 = move-exception
            java.lang.String r3 = "scaleBitmap OutOfMemoryError:"
            xx0.xxIXOIIO.xxIXOIIO(r0, r3, r6)
            goto L54
        L4d:
            r6 = move-exception
            java.lang.String r3 = "scaleBitmap exception2:"
            xx0.xxIXOIIO.xxIXOIIO(r0, r3, r6)
        L54:
            r6 = r2
        L55:
            if (r6 != 0) goto L5e
            java.lang.String r6 = "scaleBitmap return null"
            xx0.xxIXOIIO.II0XooXoX(r0, r6)
            return r2
        L5e:
            int r0 = r1.outWidth
            int r1 = r1.outHeight
            if (r0 <= r1) goto L65
            goto L66
        L65:
            r0 = r1
        L66:
            if (r0 <= r7) goto L6c
            android.graphics.Bitmap r6 = II0xO0(r6, r7)
        L6c:
            return r6
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: oo0oIXo.I0Io.I0Io(java.lang.String, int):android.graphics.Bitmap");
    }

    public static final boolean II0XooXoX(String str, int i, int i2) {
        int i3;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            xxIXOIIO.xxIXOIIO("openSDK_LOG.AsynScaleCompressImage", "isBitMapNeedToCompress exception:", e);
        }
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        if (options.mCancel || i4 == -1 || i5 == -1) {
            return false;
        }
        if (i4 > i5) {
            i3 = i4;
        } else {
            i3 = i5;
        }
        if (i4 >= i5) {
            i4 = i5;
        }
        xxIXOIIO.XO("openSDK_LOG.AsynScaleCompressImage", "longSide=" + i3 + "shortSide=" + i4);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        if (i3 <= i2 && i4 <= i) {
            return false;
        }
        return true;
    }

    public static Bitmap II0xO0(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            width = height;
        }
        float f = i / width;
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static int Oxx0IOOO(BitmapFactory.Options options, int i, int i2) {
        int ceil;
        int min;
        double d = options.outWidth;
        double d2 = options.outHeight;
        if (i2 == -1) {
            ceil = 1;
        } else {
            ceil = (int) Math.ceil(Math.sqrt((d * d2) / i2));
        }
        if (i == -1) {
            min = 128;
        } else {
            double d3 = i;
            min = (int) Math.min(Math.floor(d / d3), Math.floor(d2 / d3));
        }
        if (min < ceil) {
            return ceil;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        if (i == -1) {
            return ceil;
        }
        return min;
    }

    public static final void X0o0xo(Context context, String str, XxXX.I0Io i0Io) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage()");
        if (TextUtils.isEmpty(str)) {
            i0Io.a(1, (String) null);
        } else if (!com.tencent.open.utils.II0xO0.o00()) {
            i0Io.a(2, (String) null);
        } else {
            new Thread(new II0xO0(str, new oIX0oI(context.getMainLooper(), i0Io))).start();
        }
    }

    public static final int oIX0oI(BitmapFactory.Options options, int i, int i2) {
        int Oxx0IOOO2 = Oxx0IOOO(options, i, i2);
        if (Oxx0IOOO2 <= 8) {
            int i3 = 1;
            while (i3 < Oxx0IOOO2) {
                i3 <<= 1;
            }
            return i3;
        }
        return ((Oxx0IOOO2 + 7) / 8) * 8;
    }

    public static final String oxoX(Bitmap bitmap, String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(str2);
        String stringBuffer2 = stringBuffer.toString();
        File file2 = new File(stringBuffer2);
        if (file2.exists()) {
            file2.delete();
        }
        if (bitmap != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                bitmap.recycle();
                return stringBuffer2;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
