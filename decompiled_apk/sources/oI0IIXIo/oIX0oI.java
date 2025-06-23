package oI0IIXIo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* loaded from: classes.dex */
public class oIX0oI implements I0Io {

    /* renamed from: XO, reason: collision with root package name */
    @NonNull
    public final HttpURLConnection f31365XO;

    public oIX0oI(@NonNull HttpURLConnection httpURLConnection) {
        this.f31365XO = httpURLConnection;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f31365XO.disconnect();
    }

    @Override // oI0IIXIo.I0Io
    @Nullable
    public String error() {
        try {
            if (isSuccessful()) {
                return null;
            }
            return "Unable to fetch " + this.f31365XO.getURL() + ". Failed with " + this.f31365XO.getResponseCode() + "\n" + oIX0oI(this.f31365XO);
        } catch (IOException e) {
            IIXOooo.XO.XO("get error failed ", e);
            return e.getMessage();
        }
    }

    @Override // oI0IIXIo.I0Io
    public boolean isSuccessful() {
        try {
            if (this.f31365XO.getResponseCode() / 100 != 2) {
                return false;
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public final String oIX0oI(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                        sb.append('\n');
                    } else {
                        try {
                            break;
                        } catch (Exception unused) {
                        }
                    }
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }

    @Override // oI0IIXIo.I0Io
    @Nullable
    public String ooOOo0oXI() {
        return this.f31365XO.getContentType();
    }

    @Override // oI0IIXIo.I0Io
    @NonNull
    public InputStream x0xO0oo() throws IOException {
        return this.f31365XO.getInputStream();
    }
}
