package XOo0;

import II0XooXoX.XO;
import Oxx0IOOO.II0xO0;
import android.content.Context;
import android.util.Log;
import com.alibaba.aliagentsdk.callback.IRegisterCallback;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.utils.URLEncodedUtils;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import javax.crypto.Mac;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import org.apache.commons.lang3.xXOx;

/* loaded from: classes6.dex */
public class I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public String f3930I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public String f3931II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Context f3932II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public String f3933Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String f3934X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public String f3935XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public oIX0oI f3936oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public String f3937oxoX;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public String f3938xxIXOIIO;

    /* loaded from: classes6.dex */
    public interface oIX0oI {
    }

    public I0Io(Context context, String str) {
        this.f3930I0Io = "https://iot-auth.cn-shanghai.aliyuncs.com";
        this.f3932II0xO0 = context;
        if (xXOx.xOoOIoI(null)) {
            this.f3930I0Io = null;
        }
    }

    public static void oIX0oI(I0Io i0Io) {
        i0Io.getClass();
        try {
            String str = i0Io.f3930I0Io + "/auth/register/device";
            Log.d("DynamicRegisterHttps", "设备注册地址：" + str);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(i0Io.f3932II0xO0.getAssets().open("srca.cer"));
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            keyStore.setCertificateEntry("cert", generateCertificate);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagers, null);
            SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
            httpsURLConnection.setHostnameVerifier(new II0xO0(i0Io));
            httpsURLConnection.setSSLSocketFactory(socketFactory);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            String str2 = i0Io.f3933Oxx0IOOO;
            String str3 = i0Io.f3935XO;
            if (!xXOx.xOoOIoI(null)) {
                String str4 = "productKey=" + i0Io.f3937oxoX + "&deviceName=" + i0Io.f3934X0o0xo + "&random=" + str2 + "&sign=" + str3 + "&signMethod=hmacsha1";
                Log.e("Alink Proto", "get ds request: content = " + str4);
                httpsURLConnection.getOutputStream().write(str4.getBytes());
                httpsURLConnection.setReadTimeout(5000);
                httpsURLConnection.setConnectTimeout(5000);
                httpsURLConnection.connect();
                InputStream inputStream = httpsURLConnection.getInputStream();
                StringBuilder sb = new StringBuilder();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        sb.append(new String(bArr, 0, read));
                    }
                }
                String sb2 = sb.toString();
                Log.e("DynamicRegisterHttps", "get ds request return = " + sb2);
                JSONObject parseObject = JSON.parseObject(sb2);
                if (parseObject != null) {
                    int intValue = parseObject.getInteger("code").intValue();
                    if (intValue != 200) {
                        Log.e("DynamicRegisterHttps", "resp error:" + intValue);
                        oIX0oI oix0oi = i0Io.f3936oIX0oI;
                        if (oix0oi != null) {
                            String str5 = "resp error:" + sb2;
                            XO.II0xO0("AliLpImpl", "register error ==> " + str5 + " code ==> " + intValue);
                            IRegisterCallback iRegisterCallback = ((II0xO0.oxoX) oix0oi).f3027oIX0oI;
                            if (iRegisterCallback != null) {
                                iRegisterCallback.onRegisterFailed(str5, intValue);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    i0Io.f3938xxIXOIIO = parseObject.getJSONObject("data").getString("deviceSecret");
                    Log.d("DynamicRegisterHttps", "设备密钥是：" + i0Io.f3938xxIXOIIO);
                    oIX0oI oix0oi2 = i0Io.f3936oIX0oI;
                    if (oix0oi2 != null) {
                        ((II0xO0.oxoX) oix0oi2).oIX0oI(i0Io.f3937oxoX, i0Io.f3934X0o0xo, i0Io.f3938xxIXOIIO, i0Io.f3933Oxx0IOOO, i0Io.f3931II0XooXoX);
                        return;
                    }
                    return;
                }
                return;
            }
            String.valueOf(System.currentTimeMillis());
            Mac.getInstance("hmacsha1");
            throw null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
