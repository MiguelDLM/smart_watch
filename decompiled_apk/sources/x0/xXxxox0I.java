package x0;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes11.dex */
public class xXxxox0I {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f33796II0xO0 = 8192;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f33797oIX0oI = "download";

    /* loaded from: classes11.dex */
    public interface I0Io {
        @WorkerThread
        boolean oIX0oI(File file);

        @UiThread
        void onFail(int i);

        @UiThread
        void onProgress(long j, long j2);

        @UiThread
        void onSuccess(File file);
    }

    /* loaded from: classes11.dex */
    public interface II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public static final int f33798I0Io = 3;

        /* renamed from: II0xO0, reason: collision with root package name */
        public static final int f33799II0xO0 = 2;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public static final int f33800X0o0xo = 5;

        /* renamed from: XO, reason: collision with root package name */
        public static final int f33801XO = 6;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final int f33802oIX0oI = 1;

        /* renamed from: oxoX, reason: collision with root package name */
        public static final int f33803oxoX = 4;
    }

    /* loaded from: classes11.dex */
    public interface oIX0oI {
        @UiThread
        void II0xO0(I0Io i0Io);

        @UiThread
        void cancel();

        @UiThread
        void destroy();

        @UiThread
        void oIX0oI(X0o0xo x0o0xo);

        @UiThread
        void pause();

        @UiThread
        void resume();
    }

    /* loaded from: classes11.dex */
    public static final class oxoX implements oIX0oI, Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        @Nullable
        public Handler f33812IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        @Nullable
        public I0Io f33813Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public Handler f33814Oxx0xo = new Handler(Looper.getMainLooper());

        /* renamed from: XO, reason: collision with root package name */
        @Nullable
        public HandlerThread f33815XO;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public X0o0xo f33816oI0IIXIo;

        /* loaded from: classes11.dex */
        public class I0Io implements Runnable {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ int f33818XO;

            public I0Io(int i) {
                this.f33818XO = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (oxoX.this.f33813Oo != null) {
                    oxoX.this.f33813Oo.onFail(this.f33818XO);
                }
            }
        }

        /* loaded from: classes11.dex */
        public class II0xO0 implements Runnable {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ File f33820XO;

            public II0xO0(File file) {
                this.f33820XO = file;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (oxoX.this.f33813Oo != null) {
                    oxoX.this.f33813Oo.onSuccess(this.f33820XO);
                }
            }
        }

        /* loaded from: classes11.dex */
        public class oIX0oI implements Runnable {

            /* renamed from: Oo, reason: collision with root package name */
            public final /* synthetic */ long f33822Oo;

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ long f33823XO;

            public oIX0oI(long j, long j2) {
                this.f33823XO = j;
                this.f33822Oo = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (oxoX.this.f33813Oo != null) {
                    oxoX.this.f33813Oo.onProgress(this.f33823XO, this.f33822Oo);
                }
            }
        }

        public oxoX() {
            HandlerThread handlerThread = new HandlerThread("download");
            this.f33815XO = handlerThread;
            handlerThread.start();
            this.f33812IXxxXO = new Handler(this.f33815XO.getLooper());
        }

        @Override // x0.xXxxox0I.oIX0oI
        public void II0xO0(I0Io i0Io) {
            this.f33813Oo = i0Io;
        }

        public final void Oxx0IOOO(File file) {
            this.f33814Oxx0xo.post(new II0xO0(file));
        }

        public final void X0o0xo(int i) {
            this.f33814Oxx0xo.post(new I0Io(i));
        }

        public final void XO(long j, long j2) {
            this.f33814Oxx0xo.post(new oIX0oI(j, j2));
        }

        @Override // x0.xXxxox0I.oIX0oI
        public void cancel() {
            X0o0xo x0o0xo = this.f33816oI0IIXIo;
            if (x0o0xo != null) {
                x0o0xo.f33807Oxx0IOOO = true;
            }
        }

        @Override // x0.xXxxox0I.oIX0oI
        public void destroy() {
            HandlerThread handlerThread = this.f33815XO;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            this.f33812IXxxXO = null;
            this.f33815XO = null;
        }

        @Override // x0.xXxxox0I.oIX0oI
        public void oIX0oI(X0o0xo x0o0xo) {
            if (!x0o0xo.f33809XO) {
                X0o0xo x0o0xo2 = this.f33816oI0IIXIo;
                if (x0o0xo2 != null && !x0o0xo.equals(x0o0xo2)) {
                    this.f33816oI0IIXIo.f33807Oxx0IOOO = true;
                }
                this.f33816oI0IIXIo = x0o0xo;
                x0o0xo.xxIXOIIO();
                Handler handler = this.f33812IXxxXO;
                if (handler != null) {
                    handler.post(this);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Invalid request,it's downloading");
        }

        public final boolean oxoX(File file) {
            I0Io i0Io = this.f33813Oo;
            if (i0Io != null && i0Io.oIX0oI(file)) {
                return true;
            }
            return false;
        }

        @Override // x0.xXxxox0I.oIX0oI
        public void pause() {
            X0o0xo x0o0xo = this.f33816oI0IIXIo;
            if (x0o0xo != null) {
                x0o0xo.f33805II0XooXoX = true;
            }
        }

        @Override // x0.xXxxox0I.oIX0oI
        public void resume() {
            X0o0xo x0o0xo = this.f33816oI0IIXIo;
            if (x0o0xo == null) {
                Log.e("download", "Nothing to resume,skip this request!");
                return;
            }
            if (x0o0xo.f33805II0XooXoX) {
                this.f33816oI0IIXIo.f33805II0XooXoX = false;
                Handler handler = this.f33812IXxxXO;
                if (handler != null) {
                    handler.post(this);
                    return;
                }
                return;
            }
            oIX0oI(new X0o0xo(this.f33816oI0IIXIo));
        }

        @Override // java.lang.Runnable
        @WorkerThread
        public void run() {
            HttpURLConnection httpURLConnection;
            InputStream inputStream;
            long contentLength;
            byte[] bArr;
            RandomAccessFile randomAccessFile;
            X0o0xo x0o0xo = this.f33816oI0IIXIo;
            x0o0xo.f33809XO = true;
            File file = new File(x0o0xo.f33806II0xO0);
            if (!file.exists() && !file.mkdirs()) {
                X0o0xo(3);
                return;
            }
            String str = x0o0xo.f33806II0xO0 + File.separator + x0o0xo.f33804I0Io;
            File file2 = new File(str);
            RandomAccessFile randomAccessFile2 = null;
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(x0o0xo.f33810oIX0oI).openConnection();
                    try {
                        if (x0o0xo.f33808X0o0xo != 0) {
                            httpURLConnection.setRequestProperty("Range", "bytes=" + x0o0xo.f33808X0o0xo + HelpFormatter.DEFAULT_OPT_PREFIX);
                        }
                        httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode != 200 && responseCode != 206) {
                            x0o0xo.f33809XO = false;
                            X0o0xo(2);
                            inputStream = null;
                        } else {
                            String headerField = httpURLConnection.getHeaderField("Content-Disposition");
                            String contentType = httpURLConnection.getContentType();
                            if (Build.VERSION.SDK_INT >= 24) {
                                contentLength = httpURLConnection.getContentLengthLong();
                            } else {
                                contentLength = httpURLConnection.getContentLength();
                            }
                            if (responseCode == 200) {
                                x0o0xo.f33808X0o0xo = 0L;
                                x0o0xo.f33811oxoX = contentLength;
                            }
                            Log.d("download", headerField + contentType);
                            inputStream = httpURLConnection.getInputStream();
                            try {
                                bArr = new byte[8192];
                                randomAccessFile = new RandomAccessFile(str, "rw");
                            } catch (IOException e) {
                                e = e;
                            }
                            try {
                                randomAccessFile.seek(x0o0xo.f33808X0o0xo);
                                int i = 0;
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read != -1) {
                                        i++;
                                        randomAccessFile.write(bArr, 0, read);
                                        X0o0xo.XO(x0o0xo, read);
                                        if (i % 64 == 0) {
                                            if (x0o0xo.f33807Oxx0IOOO) {
                                                x0o0xo.f33809XO = false;
                                                X0o0xo(1);
                                                try {
                                                    randomAccessFile.getFD().sync();
                                                } catch (IOException unused) {
                                                }
                                                try {
                                                    randomAccessFile.close();
                                                } catch (IOException unused2) {
                                                }
                                                try {
                                                    inputStream.close();
                                                } catch (IOException unused3) {
                                                }
                                                httpURLConnection.disconnect();
                                                return;
                                            }
                                            if (x0o0xo.f33805II0XooXoX) {
                                                x0o0xo.f33809XO = false;
                                                X0o0xo(6);
                                                try {
                                                    randomAccessFile.getFD().sync();
                                                } catch (IOException unused4) {
                                                }
                                                try {
                                                    randomAccessFile.close();
                                                } catch (IOException unused5) {
                                                }
                                                try {
                                                    inputStream.close();
                                                } catch (IOException unused6) {
                                                }
                                                httpURLConnection.disconnect();
                                                return;
                                            }
                                            if (i % 16 == 0) {
                                                XO(x0o0xo.f33808X0o0xo, x0o0xo.f33811oxoX);
                                            }
                                        }
                                    } else {
                                        randomAccessFile.getFD().sync();
                                        if (!oxoX(file2)) {
                                            x0o0xo.f33809XO = false;
                                            X0o0xo(4);
                                        } else {
                                            x0o0xo.f33809XO = false;
                                            Oxx0IOOO(file2);
                                        }
                                        randomAccessFile2 = randomAccessFile;
                                    }
                                }
                            } catch (IOException e2) {
                                e = e2;
                                randomAccessFile2 = randomAccessFile;
                                e.printStackTrace();
                                x0o0xo.f33809XO = false;
                                X0o0xo(5);
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.getFD().sync();
                                    } catch (IOException unused7) {
                                    }
                                }
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (IOException unused8) {
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException unused9) {
                                    }
                                }
                                if (httpURLConnection == null) {
                                    return;
                                }
                                httpURLConnection.disconnect();
                            } catch (Throwable th) {
                                th = th;
                                randomAccessFile2 = randomAccessFile;
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.getFD().sync();
                                    } catch (IOException unused10) {
                                    }
                                }
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (IOException unused11) {
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException unused12) {
                                    }
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                    throw th;
                                }
                                throw th;
                            }
                        }
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.getFD().sync();
                            } catch (IOException unused13) {
                            }
                        }
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                            } catch (IOException unused14) {
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused15) {
                            }
                        }
                    } catch (IOException e3) {
                        e = e3;
                        inputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e4) {
                e = e4;
                httpURLConnection = null;
                inputStream = null;
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = null;
                inputStream = null;
            }
            httpURLConnection.disconnect();
        }
    }

    public static oIX0oI oIX0oI() {
        return new oxoX();
    }

    /* loaded from: classes11.dex */
    public static final class X0o0xo {

        /* renamed from: I0Io, reason: collision with root package name */
        public String f33804I0Io;

        /* renamed from: II0XooXoX, reason: collision with root package name */
        public volatile boolean f33805II0XooXoX;

        /* renamed from: II0xO0, reason: collision with root package name */
        public String f33806II0xO0;

        /* renamed from: Oxx0IOOO, reason: collision with root package name */
        public volatile boolean f33807Oxx0IOOO;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public volatile long f33808X0o0xo;

        /* renamed from: XO, reason: collision with root package name */
        public volatile boolean f33809XO;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public String f33810oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public volatile long f33811oxoX;

        public X0o0xo(String str, String str2, String str3) {
            this.f33810oIX0oI = str;
            this.f33806II0xO0 = str2;
            this.f33804I0Io = str3;
            xxIXOIIO();
        }

        public static /* synthetic */ long XO(X0o0xo x0o0xo, long j) {
            long j2 = x0o0xo.f33808X0o0xo + j;
            x0o0xo.f33808X0o0xo = j2;
            return j2;
        }

        public void xxIXOIIO() {
            this.f33811oxoX = 0L;
            this.f33808X0o0xo = 0L;
            this.f33807Oxx0IOOO = false;
            this.f33805II0XooXoX = false;
            this.f33809XO = false;
        }

        public X0o0xo(X0o0xo x0o0xo) {
            this.f33810oIX0oI = x0o0xo.f33810oIX0oI;
            this.f33806II0xO0 = x0o0xo.f33806II0xO0;
            this.f33804I0Io = x0o0xo.f33804I0Io;
            xxIXOIIO();
        }
    }
}
