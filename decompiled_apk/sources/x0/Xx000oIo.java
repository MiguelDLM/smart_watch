package x0;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes11.dex */
public class Xx000oIo {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f33727I0Io = 10000;

    /* renamed from: II0xO0, reason: collision with root package name */
    public I0Io f33728II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public HashMap<II0xO0, String> f33729oIX0oI = new HashMap<>();

    /* loaded from: classes11.dex */
    public interface I0Io {
        void II0xO0();
    }

    /* loaded from: classes11.dex */
    public interface II0xO0 {
        void oIX0oI(Bitmap bitmap);

        void onFail();
    }

    /* loaded from: classes11.dex */
    public class oIX0oI extends AsyncTask<Void, Void, Bitmap> {

        /* renamed from: I0Io, reason: collision with root package name */
        public String f33730I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public WeakReference<II0xO0> f33731II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public WeakReference<Xx000oIo> f33732oIX0oI;

        public oIX0oI(II0xO0 iI0xO0, String str, Xx000oIo xx000oIo) {
            this.f33732oIX0oI = new WeakReference<>(xx000oIo);
            this.f33731II0xO0 = new WeakReference<>(iI0xO0);
            this.f33730I0Io = str;
        }

        @Override // android.os.AsyncTask
        /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            II0xO0 iI0xO0 = this.f33731II0xO0.get();
            Xx000oIo xx000oIo = this.f33732oIX0oI.get();
            if (iI0xO0 != null) {
                if (bitmap == null) {
                    iI0xO0.onFail();
                } else {
                    iI0xO0.oIX0oI(bitmap);
                }
            }
            if (xx000oIo != null) {
                xx000oIo.I0Io(iI0xO0);
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(Void... voidArr) {
            if (isCancelled()) {
                return null;
            }
            try {
                URLConnection openConnection = new URL(this.f33730I0Io).openConnection();
                openConnection.setReadTimeout(10000);
                InputStream inputStream = (InputStream) openConnection.getContent();
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                return decodeStream;
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // android.os.AsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.f33731II0xO0.clear();
            this.f33732oIX0oI.clear();
        }
    }

    public void I0Io(II0xO0 iI0xO0) {
        HashMap<II0xO0, String> hashMap = this.f33729oIX0oI;
        if (hashMap != null && hashMap.containsKey(iI0xO0)) {
            this.f33729oIX0oI.remove(iI0xO0);
            if (this.f33729oIX0oI.size() == 0) {
                this.f33728II0xO0.II0xO0();
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "Images downloading finished.");
                II0xO0();
            }
        }
    }

    public final void II0xO0() {
        this.f33729oIX0oI = null;
        this.f33728II0xO0 = null;
    }

    public void X0o0xo(I0Io i0Io) {
        this.f33728II0xO0 = i0Io;
    }

    public void oIX0oI() {
        if (this.f33728II0xO0 == null) {
            II0xO0();
            return;
        }
        HashMap<II0xO0, String> hashMap = this.f33729oIX0oI;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry<II0xO0, String> entry : this.f33729oIX0oI.entrySet()) {
                oIX0oI oix0oi = new oIX0oI(entry.getKey(), entry.getValue(), this);
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "Downloading image failFrom url: " + ((Object) entry.getValue()));
                oix0oi.execute(new Void[0]);
            }
            return;
        }
        this.f33728II0xO0.II0xO0();
        II0xO0();
    }

    public void oxoX(II0xO0 iI0xO0, String str) {
        if (!x0o.II0XooXoX(str) && iI0xO0 != null) {
            this.f33729oIX0oI.put(iI0xO0, str);
        }
    }
}
