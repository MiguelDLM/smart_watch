package oI0IIXIo;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes.dex */
public class II0xO0 implements X0o0xo {
    @Override // oI0IIXIo.X0o0xo
    @NonNull
    public I0Io oIX0oI(@NonNull String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return new oIX0oI(httpURLConnection);
    }
}
