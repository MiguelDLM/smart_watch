package x0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.collection.LruCache;
import com.octopus.ad.internal.xoIox;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import o0IXXIx.X0o0xo;

/* loaded from: classes11.dex */
public class oOXoIIIo {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static oOXoIIIo f33742X0o0xo;

    /* renamed from: oxoX, reason: collision with root package name */
    public static Context f33743oxoX;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public ExecutorService f33746oIX0oI = Executors.newFixedThreadPool(4);

    /* renamed from: II0xO0, reason: collision with root package name */
    public LruCache<String, Bitmap> f33745II0xO0 = new LruCache<>(4194304);

    /* renamed from: I0Io, reason: collision with root package name */
    public Handler f33744I0Io = new Handler();

    /* loaded from: classes11.dex */
    public interface II0xO0 {
        void II0xO0(Bitmap bitmap);

        void oIX0oI();
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ II0xO0 f33756Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ String f33757XO;

        /* loaded from: classes11.dex */
        public class II0xO0 implements Runnable {
            public II0xO0() {
            }

            @Override // java.lang.Runnable
            public void run() {
                oIX0oI.this.f33756Oo.oIX0oI();
            }
        }

        /* renamed from: x0.oOXoIIIo$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class RunnableC1142oIX0oI implements Runnable {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ Bitmap f33760XO;

            public RunnableC1142oIX0oI(Bitmap bitmap) {
                this.f33760XO = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                oIX0oI.this.f33756Oo.II0xO0(this.f33760XO);
            }
        }

        public oIX0oI(String str, II0xO0 iI0xO0) {
            this.f33757XO = str;
            this.f33756Oo = iI0xO0;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f33757XO).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(2000);
                if (httpURLConnection.getResponseCode() == 200) {
                    Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                    httpURLConnection.disconnect();
                    oOXoIIIo.this.f33744I0Io.post(new RunnableC1142oIX0oI(decodeStream));
                    oOXoIIIo.this.f33745II0xO0.put(this.f33757XO, decodeStream);
                    String str = this.f33757XO;
                    decodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(X0o0xo.II0XooXoX(oOXoIIIo.f33743oxoX), oo0xXOI0I.II0xO0(str.substring(str.lastIndexOf("/") + 1)))));
                }
            } catch (Exception unused) {
                oOXoIIIo.this.f33744I0Io.post(new II0xO0());
            }
        }
    }

    public static oOXoIIIo II0XooXoX(Context context) {
        if (xoIox.oIX0oI().f19082x0xO0oo != null) {
            f33743oxoX = xoIox.oIX0oI().f19082x0xO0oo;
        } else {
            f33743oxoX = context;
        }
        return XO();
    }

    public static oOXoIIIo XO() {
        if (f33742X0o0xo == null) {
            synchronized (oOXoIIIo.class) {
                try {
                    if (f33742X0o0xo == null) {
                        f33742X0o0xo = new oOXoIIIo();
                    }
                } finally {
                }
            }
        }
        return f33742X0o0xo;
    }

    public I0Io Oxx0IOOO(String str) {
        return new I0Io(str);
    }

    public void X0o0xo(String str, II0xO0 iI0xO0) {
        Bitmap bitmap;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bitmap bitmap2 = this.f33745II0xO0.get(str);
        if (bitmap2 != null) {
            iI0xO0.II0xO0(bitmap2);
            return;
        }
        File file = new File(X0o0xo.II0XooXoX(f33743oxoX), oo0xXOI0I.II0xO0(str.substring(str.lastIndexOf("/") + 1)));
        if (file.exists() && file.length() > 0) {
            bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            this.f33745II0xO0.put(str, bitmap);
            iI0xO0.II0xO0(bitmap);
        } else {
            this.f33746oIX0oI.submit(new oIX0oI(str, iI0xO0));
        }
    }

    /* loaded from: classes11.dex */
    public class I0Io implements Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public int f33747IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public int f33748Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public ImageView f33749Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public String f33750XO;

        /* loaded from: classes11.dex */
        public class oIX0oI implements Runnable {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ Bitmap f33754XO;

            public oIX0oI(Bitmap bitmap) {
                this.f33754XO = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                I0Io.this.f33749Oxx0xo.setImageBitmap(this.f33754XO);
            }
        }

        public I0Io(String str) {
            this.f33750XO = str;
        }

        public void I0Io(ImageView imageView) {
            this.f33749Oxx0xo = imageView;
            if (TextUtils.isEmpty(this.f33750XO)) {
                return;
            }
            Bitmap bitmap = (Bitmap) oOXoIIIo.this.f33745II0xO0.get(this.f33750XO);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return;
            }
            Bitmap II0xO02 = II0xO0();
            if (II0xO02 != null) {
                imageView.setImageBitmap(II0xO02);
                oOXoIIIo.this.f33745II0xO0.put(this.f33750XO, II0xO02);
            } else {
                oOXoIIIo.this.f33746oIX0oI.submit(this);
            }
        }

        public final Bitmap II0xO0() {
            String str = this.f33750XO;
            File file = new File(X0o0xo.II0XooXoX(oOXoIIIo.f33743oxoX), oo0xXOI0I.II0xO0(str.substring(str.lastIndexOf("/") + 1)));
            if (file.exists() && file.length() > 0) {
                return BitmapFactory.decodeFile(file.getAbsolutePath());
            }
            return null;
        }

        public final void X0o0xo() {
            oOXoIIIo.this.f33744I0Io.post(new II0xO0());
        }

        public I0Io oIX0oI(int i) {
            this.f33747IXxxXO = i;
            return this;
        }

        public I0Io oxoX(int i) {
            this.f33748Oo = i;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f33750XO).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(2000);
                if (httpURLConnection.getResponseCode() == 200) {
                    Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                    oOXoIIIo.this.f33744I0Io.post(new oIX0oI(decodeStream));
                    oOXoIIIo.this.f33745II0xO0.put(this.f33750XO, decodeStream);
                    String str = this.f33750XO;
                    decodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(X0o0xo.II0XooXoX(oOXoIIIo.f33743oxoX), oo0xXOI0I.II0xO0(str.substring(str.lastIndexOf("/") + 1)))));
                } else {
                    X0o0xo();
                }
            } catch (FileNotFoundException unused) {
            } catch (Exception e) {
                e.printStackTrace();
                X0o0xo();
            }
        }

        /* loaded from: classes11.dex */
        public class II0xO0 implements Runnable {
            public II0xO0() {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }
    }
}
