package OXooXo;

import android.os.AsyncTask;
import com.vtrump.vtble.Oxx0xo;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes13.dex */
public class oIX0oI extends AsyncTask<Void, Void, String> {

    /* renamed from: I0Io, reason: collision with root package name */
    public String f2007I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final I0Io f2008II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f2009oIX0oI;

    public oIX0oI(String str, String str2, I0Io i0Io) {
        this.f2008II0xO0 = i0Io;
        this.f2009oIX0oI = str2;
        this.f2007I0Io = str;
    }

    @Override // android.os.AsyncTask
    /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        I0Io i0Io = this.f2008II0xO0;
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
        String str;
        String str2;
        String str3;
        try {
            if (this.f2007I0Io.equals("device_check")) {
                str = "https://vtutil-factory.vtio.cn/device_check";
            } else {
                str = "https://vtutil-factory.vtio.cn/device_data_decrypt";
            }
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setConnectTimeout(1000);
            httpsURLConnection.setReadTimeout(1000);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=UTF-8");
            if (this.f2007I0Io.equals("device_check")) {
                str2 = "6b51111e8c30477d90cbc025eabfde53";
            } else {
                str2 = "19d8eb2e62004ed6b6072b821f668914";
            }
            httpsURLConnection.setRequestProperty("app_id", str2);
            if (this.f2007I0Io.equals("device_check")) {
                str3 = "060f7f49aa0c4f6e";
            } else {
                str3 = "985560ffea264be9b2255e2639ed6671";
            }
            httpsURLConnection.setRequestProperty("token", str3);
            PrintWriter printWriter = new PrintWriter(httpsURLConnection.getOutputStream());
            printWriter.write(this.f2009oIX0oI);
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
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString("utf-8");
                    StringBuilder sb = new StringBuilder();
                    sb.append("AsyncTaskUtils:61-->doInBackground: ");
                    sb.append(byteArrayOutputStream2);
                    Oxx0xo.II0xO0("AsyncTaskUtils", sb.toString());
                    return byteArrayOutputStream2;
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
