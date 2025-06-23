package xoIox;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes.dex */
public class oIX0oI extends AsyncTask<String, Void, Bitmap> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public SoftReference<ImageView> f35039oIX0oI;

    public oIX0oI(ImageView imageView) {
        this.f35039oIX0oI = new SoftReference<>(imageView);
    }

    @Override // android.os.AsyncTask
    /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            if (this.f35039oIX0oI.get() != null) {
                this.f35039oIX0oI.get().setImageBitmap(bitmap);
                return;
            }
            return;
        }
        MediationApiLog.i("download Image", "Error download Image fail...");
    }

    @Override // android.os.AsyncTask
    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(String... strArr) {
        String str = strArr[0];
        if (str == null) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                return null;
            }
            return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
