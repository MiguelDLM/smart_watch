package XxXX;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes13.dex */
public class II0xO0 {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static String f4213Oxx0IOOO;

    /* renamed from: I0Io, reason: collision with root package name */
    public long f4214I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public I0Io f4215II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public WeakReference<Activity> f4216X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public Runnable f4217XO = new RunnableC0069II0xO0();

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f4218oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public Handler f4219oxoX;

    /* renamed from: XxXX.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class RunnableC0069II0xO0 implements Runnable {
        public RunnableC0069II0xO0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            xx0.xxIXOIIO.IXxxXO("AsynLoadImg", "saveFileRunnable:");
            String str = "share_qq_" + com.tencent.open.utils.II0xO0.IoOoX(II0xO0.this.f4218oIX0oI) + ".jpg";
            String str2 = II0xO0.f4213Oxx0IOOO + str;
            File file = new File(str2);
            Message obtainMessage = II0xO0.this.f4219oxoX.obtainMessage();
            if (file.exists()) {
                obtainMessage.arg1 = 0;
                obtainMessage.obj = str2;
                xx0.xxIXOIIO.IXxxXO("AsynLoadImg", "file exists: time:" + (System.currentTimeMillis() - II0xO0.this.f4214I0Io));
            } else {
                Bitmap II0xO02 = II0xO0.II0xO0(II0xO0.this.f4218oIX0oI);
                if (II0xO02 != null) {
                    z = II0xO0.this.X0o0xo(II0xO02, str);
                } else {
                    xx0.xxIXOIIO.IXxxXO("AsynLoadImg", "saveFileRunnable:get bmp fail---");
                    z = false;
                }
                if (z) {
                    obtainMessage.arg1 = 0;
                    obtainMessage.obj = str2;
                } else {
                    obtainMessage.arg1 = 1;
                }
                xx0.xxIXOIIO.IXxxXO("AsynLoadImg", "file not exists: download time:" + (System.currentTimeMillis() - II0xO0.this.f4214I0Io));
            }
            II0xO0.this.f4219oxoX.sendMessage(obtainMessage);
        }
    }

    /* loaded from: classes13.dex */
    public class oIX0oI extends Handler {
        public oIX0oI(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            xx0.xxIXOIIO.IXxxXO("AsynLoadImg", "handleMessage:" + message.arg1);
            if (message.arg1 == 0) {
                II0xO0.this.f4215II0xO0.a(message.arg1, (String) message.obj);
            } else {
                II0xO0.this.f4215II0xO0.a(message.arg1, (String) null);
            }
        }
    }

    public II0xO0(Activity activity) {
        this.f4216X0o0xo = new WeakReference<>(activity);
        this.f4219oxoX = new oIX0oI(activity.getMainLooper());
    }

    public static Bitmap II0xO0(String str) {
        xx0.xxIXOIIO.IXxxXO("AsynLoadImg", "getbitmap:" + str);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            xx0.xxIXOIIO.IXxxXO("AsynLoadImg", "image download finished." + str);
            return decodeStream;
        } catch (IOException e) {
            e.printStackTrace();
            xx0.xxIXOIIO.IXxxXO("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            xx0.xxIXOIIO.IXxxXO("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        }
    }

    public boolean X0o0xo(Bitmap bitmap, String str) {
        BufferedOutputStream bufferedOutputStream;
        String str2 = f4213Oxx0IOOO;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdir();
                }
                xx0.xxIXOIIO.IXxxXO("AsynLoadImg", "saveFile:" + str);
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str2 + str)));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
            bufferedOutputStream.flush();
            try {
                bufferedOutputStream.close();
                return true;
            } catch (IOException e2) {
                e2.printStackTrace();
                return true;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedOutputStream2 = bufferedOutputStream;
            e.printStackTrace();
            xx0.xxIXOIIO.xxIXOIIO("AsynLoadImg", "saveFile bmp fail---", e);
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                    return false;
                } catch (IOException e4) {
                    e4.printStackTrace();
                    return false;
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    public void oxoX(String str, I0Io i0Io) {
        String absolutePath;
        xx0.xxIXOIIO.IXxxXO("AsynLoadImg", "--save---");
        if (str != null && !str.equals("")) {
            if (!com.tencent.open.utils.II0xO0.o00()) {
                i0Io.a(2, (String) null);
                return;
            }
            if (this.f4216X0o0xo.get() != null) {
                Activity activity = this.f4216X0o0xo.get();
                File externalFilesDir = activity.getExternalFilesDir("Images");
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                if (externalFilesDir == null) {
                    xx0.xxIXOIIO.II0XooXoX("AsynLoadImg", "externalImageFile is null");
                    i0Io.a(2, (String) null);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                if (Oxx0IOOO.oO(activity)) {
                    absolutePath = externalFilesDir.getAbsolutePath();
                } else {
                    absolutePath = externalStorageDirectory.getAbsolutePath();
                }
                sb.append(absolutePath);
                sb.append("/tmp/");
                f4213Oxx0IOOO = sb.toString();
            }
            this.f4214I0Io = System.currentTimeMillis();
            this.f4218oIX0oI = str;
            this.f4215II0xO0 = i0Io;
            new Thread(this.f4217XO).start();
            return;
        }
        i0Io.a(1, (String) null);
    }
}
