package x0;

import android.util.Log;
import com.octopus.ad.R;
import com.octopus.ad.internal.utilities.HttpErrorCode;
import com.octopus.ad.internal.xoIox;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import o0IXXIx.II0XooXoX;
import o0IXXIx.Oxx0IOOO;

/* loaded from: classes11.dex */
public abstract class ooXIXxIX {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static String f33761II0xO0 = "HTTPGet";

    /* renamed from: oIX0oI, reason: collision with root package name */
    public boolean f33762oIX0oI;

    /* loaded from: classes11.dex */
    public interface II0xO0 {
        void oIX0oI(boolean z, String str);
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: x0.ooXIXxIX$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class RunnableC1143oIX0oI implements Runnable {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ xI f33765XO;

            public RunnableC1143oIX0oI(xI xIVar) {
                this.f33765XO = xIVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                ooXIXxIX.this.II0XooXoX(this.f33765XO);
            }
        }

        public oIX0oI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            URL url;
            boolean z;
            xI xIVar = new xI();
            HttpURLConnection httpURLConnection = null;
            try {
                try {
                    url = new URL(ooXIXxIX.this.Oxx0IOOO());
                } catch (MalformedURLException unused) {
                    xIVar.xoIox(false);
                    xIVar.XO(HttpErrorCode.URL_FORMAT_ERROR);
                    com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18696X0o0xo, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.http_url_malformed));
                    if (0 == 0) {
                        return;
                    }
                } catch (IOException unused2) {
                    xIVar.xoIox(false);
                    xIVar.XO(HttpErrorCode.TRANSPORT_ERROR);
                    com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18696X0o0xo, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.http_io));
                    if (0 == 0) {
                        return;
                    }
                } catch (Exception unused3) {
                    xIVar.xoIox(false);
                    xIVar.XO(HttpErrorCode.TRANSPORT_ERROR);
                    com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18696X0o0xo, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.http_io));
                    if (0 == 0) {
                        return;
                    }
                }
                if (url.getHost() == null) {
                    com.octopus.ad.internal.utilities.oIX0oI.oo(com.octopus.ad.internal.utilities.oIX0oI.f18696X0o0xo, "An HTTP request with an invalid URL was attempted.", new IllegalStateException("An HTTP request with an invalid URL was attempted."));
                    xIVar.xoIox(false);
                    return;
                }
                Log.i("Octopus_Url", o0IXXIx.oIX0oI.oIX0oI(Oxx0IOOO.oIX0oI(), ooXIXxIX.this.Oxx0IOOO()) + "");
                httpURLConnection = ooXIXxIX.this.X0o0xo(url);
                ooXIXxIX.this.xxIXOIIO(httpURLConnection);
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                II0XooXoX.oIX0oI(ooXIXxIX.f33761II0xO0, "HTTPGet code:" + responseCode);
                InputStream inputStream = httpURLConnection.getInputStream();
                if (!ooXIXxIX.this.f33762oIX0oI) {
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        } else {
                            sb.append(readLine);
                        }
                    }
                    bufferedReader.close();
                    xIVar.xxIXOIIO(sb.toString());
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        } else {
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                    }
                    xIVar.II0XooXoX(byteArrayOutputStream);
                }
                inputStream.close();
                xIVar.Oxx0IOOO(httpURLConnection.getHeaderFields());
                if (httpURLConnection.getResponseCode() != 200 && httpURLConnection.getResponseCode() != 204) {
                    z = false;
                    xIVar.xoIox(z);
                    IO0XoXxO.oIX0oI.I0Io(new RunnableC1143oIX0oI(xIVar));
                    httpURLConnection.disconnect();
                }
                z = true;
                xIVar.xoIox(z);
                IO0XoXxO.oIX0oI.I0Io(new RunnableC1143oIX0oI(xIVar));
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                if (0 != 0) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
    }

    public ooXIXxIX(boolean z) {
        this.f33762oIX0oI = z;
    }

    public abstract void II0XooXoX(xI xIVar);

    public abstract String Oxx0IOOO();

    public final HttpURLConnection X0o0xo(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("GET");
        return httpURLConnection;
    }

    public void XO() {
        IO0XoXxO.oIX0oI.II0xO0(new oIX0oI());
    }

    public final void xxIXOIIO(HttpURLConnection httpURLConnection) throws ProtocolException {
        httpURLConnection.setRequestProperty("User-Agent", xoIox.oIX0oI().Oo());
    }
}
