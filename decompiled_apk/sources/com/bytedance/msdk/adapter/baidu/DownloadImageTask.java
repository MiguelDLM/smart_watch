package com.bytedance.msdk.adapter.baidu;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes8.dex */
public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public SoftReference<ImageView> f10463oIX0oI;

    public DownloadImageTask(ImageView imageView) {
        this.f10463oIX0oI = new SoftReference<>(imageView);
    }

    @Override // android.os.AsyncTask
    public Bitmap doInBackground(String... strArr) {
        String str = strArr[0];
        if (str == null) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute((DownloadImageTask) bitmap);
        if (bitmap == null) {
            MediationApiLog.i("download Image", "Error download Image fail...");
        } else if (this.f10463oIX0oI.get() != null) {
            this.f10463oIX0oI.get().setImageBitmap(bitmap);
        }
    }
}
