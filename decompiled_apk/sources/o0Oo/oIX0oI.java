package o0Oo;

import com.tencent.open.utils.HttpUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public interface oIX0oI {
    void I0Io(Exception exc);

    void II0XooXoX(ConnectTimeoutException connectTimeoutException);

    void II0xO0(SocketTimeoutException socketTimeoutException);

    void Oxx0IOOO(HttpUtils.HttpStatusException httpStatusException);

    void X0o0xo(JSONObject jSONObject);

    void XO(MalformedURLException malformedURLException);

    void oIX0oI(IOException iOException);

    void oxoX(JSONException jSONException);

    void xxIXOIIO(HttpUtils.NetworkUnavailableException networkUnavailableException);
}
