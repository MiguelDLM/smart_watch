package com.facebook.internal.security;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.util.Base64;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.internal.security.OidcSecurityUtil;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;
import kotlin.text.oxoX;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class OidcSecurityUtil {

    @OOXIXo
    public static final OidcSecurityUtil INSTANCE = new OidcSecurityUtil();

    @OOXIXo
    private static final String OPENID_KEYS_PATH = "/.well-known/oauth/openid/keys/";

    @OOXIXo
    public static final String SIGNATURE_ALGORITHM_SHA256 = "SHA256withRSA";
    public static final long TIMEOUT_IN_MILLISECONDS = 5000;

    private OidcSecurityUtil() {
    }

    @x0XOIxOo
    @OOXIXo
    public static final PublicKey getPublicKeyFromString(@OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        byte[] decode = Base64.decode(OxI.IIOIX(OxI.IIOIX(OxI.IIOIX(key, "\n", "", false, 4, null), "-----BEGIN PUBLIC KEY-----", "", false, 4, null), "-----END PUBLIC KEY-----", "", false, 4, null), 0);
        IIX0o.oO(decode, "decode(pubKeyString, Base64.DEFAULT)");
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decode));
        IIX0o.oO(generatePublic, "kf.generatePublic(x509publicKey)");
        return generatePublic;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @x0XOIxOo
    @oOoXoXO
    public static final String getRawKeyFromEndPoint(@OOXIXo final String kid) {
        IIX0o.x0xO0oo(kid, "kid");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        final URL url = new URL("https", IIX0o.XIxXXX0x0("www.", FacebookSdk.getFacebookDomain()), OPENID_KEYS_PATH);
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition newCondition = reentrantLock.newCondition();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        FacebookSdk.getExecutor().execute(new Runnable() { // from class: XoI0Ixx0.oIX0oI
            @Override // java.lang.Runnable
            public final void run() {
                OidcSecurityUtil.m236getRawKeyFromEndPoint$lambda1(url, objectRef, kid, reentrantLock, newCondition);
            }
        });
        reentrantLock.lock();
        try {
            newCondition.await(5000L, TimeUnit.MILLISECONDS);
            reentrantLock.unlock();
            return (String) objectRef.element;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.String] */
    /* renamed from: getRawKeyFromEndPoint$lambda-1, reason: not valid java name */
    public static final void m236getRawKeyFromEndPoint$lambda1(URL openIdKeyUrl, Ref.ObjectRef result, String kid, ReentrantLock lock, Condition condition) {
        IIX0o.x0xO0oo(openIdKeyUrl, "$openIdKeyUrl");
        IIX0o.x0xO0oo(result, "$result");
        IIX0o.x0xO0oo(kid, "$kid");
        IIX0o.x0xO0oo(lock, "$lock");
        URLConnection openConnection = openIdKeyUrl.openConnection();
        if (openConnection != null) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            try {
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    IIX0o.oO(inputStream, "connection.inputStream");
                    String OOXIXo2 = TextStreamsKt.OOXIXo(new BufferedReader(new InputStreamReader(inputStream, oxoX.f29581II0xO0), 8192));
                    httpURLConnection.getInputStream().close();
                    result.element = new JSONObject(OOXIXo2).optString(kid);
                    httpURLConnection.disconnect();
                    lock.lock();
                } catch (Exception e) {
                    String name = INSTANCE.getClass().getName();
                    String message = e.getMessage();
                    if (message == null) {
                        message = "Error getting public key";
                    }
                    Log.d(name, message);
                    httpURLConnection.disconnect();
                    lock.lock();
                    try {
                        condition.signal();
                        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                    } finally {
                    }
                }
                try {
                    condition.signal();
                    oXIO0o0XI oxio0o0xi2 = oXIO0o0XI.f29392oIX0oI;
                    return;
                } finally {
                }
            } catch (Throwable th) {
                httpURLConnection.disconnect();
                lock.lock();
                try {
                    condition.signal();
                    oXIO0o0XI oxio0o0xi3 = oXIO0o0XI.f29392oIX0oI;
                    throw th;
                } finally {
                }
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
    }

    @x0XOIxOo
    public static final boolean verify(@OOXIXo PublicKey publicKey, @OOXIXo String data, @OOXIXo String signature) {
        IIX0o.x0xO0oo(publicKey, "publicKey");
        IIX0o.x0xO0oo(data, "data");
        IIX0o.x0xO0oo(signature, "signature");
        try {
            Signature signature2 = Signature.getInstance(SIGNATURE_ALGORITHM_SHA256);
            signature2.initVerify(publicKey);
            byte[] bytes = data.getBytes(oxoX.f29581II0xO0);
            IIX0o.oO(bytes, "(this as java.lang.String).getBytes(charset)");
            signature2.update(bytes);
            byte[] decode = Base64.decode(signature, 8);
            IIX0o.oO(decode, "decode(signature, Base64.URL_SAFE)");
            return signature2.verify(decode);
        } catch (Exception unused) {
            return false;
        }
    }

    @OOXIXo
    public final String getOPENID_KEYS_PATH() {
        return OPENID_KEYS_PATH;
    }
}
