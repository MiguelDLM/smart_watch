package OXooXo;

import android.os.AsyncTask;
import com.baidu.mobads.sdk.internal.an;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes13.dex */
public class II0xO0 extends AsyncTask<Void, Void, String> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final I0Io f2005II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f2006oIX0oI;

    public II0xO0(String str, I0Io i0Io) {
        this.f2005II0xO0 = i0Io;
        this.f2006oIX0oI = str;
    }

    @Override // android.os.AsyncTask
    /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        I0Io i0Io = this.f2005II0xO0;
        if (i0Io != null) {
            if (str != null) {
                i0Io.a(str);
            } else {
                i0Io.a();
            }
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Void... voidArr) {
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL("https://vtbia.vtio.cn/front/parse-data/").openConnection();
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setConnectTimeout(1000);
            httpsURLConnection.setReadTimeout(1000);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setRequestProperty("Content-type", an.d);
            PrintWriter printWriter = new PrintWriter(httpsURLConnection.getOutputStream());
            printWriter.write(this.f2006oIX0oI);
            printWriter.flush();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpsURLConnection.getInputStream());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                    byteArrayOutputStream.flush();
                } else {
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toString("utf-8");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
    }
}
