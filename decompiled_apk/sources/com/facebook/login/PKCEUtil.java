package com.facebook.login;

import X0.IIXOooo;
import android.os.Bundle;
import android.util.Base64;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.digest.MessageDigestAlgorithms;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.random.Random;
import kotlin.text.Regex;

/* loaded from: classes8.dex */
public final class PKCEUtil {

    @OXOo.OOXIXo
    public static final PKCEUtil INSTANCE = new PKCEUtil();

    private PKCEUtil() {
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final GraphRequest createCodeExchangeRequest(@OXOo.OOXIXo String authorizationCode, @OXOo.OOXIXo String redirectUri, @OXOo.OOXIXo String codeVerifier) {
        IIX0o.x0xO0oo(authorizationCode, "authorizationCode");
        IIX0o.x0xO0oo(redirectUri, "redirectUri");
        IIX0o.x0xO0oo(codeVerifier, "codeVerifier");
        Bundle bundle = new Bundle();
        bundle.putString("code", authorizationCode);
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        bundle.putString("client_id", FacebookSdk.getApplicationId());
        bundle.putString("redirect_uri", redirectUri);
        bundle.putString("code_verifier", codeVerifier);
        GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(null, "oauth/access_token", null);
        newGraphPathRequest.setHttpMethod(HttpMethod.GET);
        newGraphPathRequest.setParameters(bundle);
        return newGraphPathRequest;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String generateCodeChallenge(@OXOo.OOXIXo String codeVerifier, @OXOo.OOXIXo CodeChallengeMethod codeChallengeMethod) throws FacebookException {
        IIX0o.x0xO0oo(codeVerifier, "codeVerifier");
        IIX0o.x0xO0oo(codeChallengeMethod, "codeChallengeMethod");
        if (isValidCodeVerifier(codeVerifier)) {
            if (codeChallengeMethod == CodeChallengeMethod.PLAIN) {
                return codeVerifier;
            }
            try {
                byte[] bytes = codeVerifier.getBytes(kotlin.text.oxoX.f29584XO);
                IIX0o.oO(bytes, "(this as java.lang.String).getBytes(charset)");
                MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
                messageDigest.update(bytes, 0, bytes.length);
                String encodeToString = Base64.encodeToString(messageDigest.digest(), 11);
                IIX0o.oO(encodeToString, "{\n      // try to generate challenge with S256\n      val bytes: ByteArray = codeVerifier.toByteArray(Charsets.US_ASCII)\n      val messageDigest = MessageDigest.getInstance(\"SHA-256\")\n      messageDigest.update(bytes, 0, bytes.size)\n      val digest = messageDigest.digest()\n\n      Base64.encodeToString(digest, Base64.URL_SAFE or Base64.NO_PADDING or Base64.NO_WRAP)\n    }");
                return encodeToString;
            } catch (Exception e) {
                throw new FacebookException(e);
            }
        }
        throw new FacebookException("Invalid Code Verifier.");
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String generateCodeVerifier() {
        int xXoOI00O2 = IIXOooo.xXoOI00O(new X0.oOoXoXO(43, 128), Random.Default);
        List OIxOIX0II2 = CollectionsKt___CollectionsKt.OIxOIX0II(CollectionsKt___CollectionsKt.OIxOIX0II(CollectionsKt___CollectionsKt.OIxOIX0II(CollectionsKt___CollectionsKt.OIxOIX0II(CollectionsKt___CollectionsKt.o0xIIX0(CollectionsKt___CollectionsKt.XxIOX(new X0.I0Io('a', 'z'), new X0.I0Io('A', 'Z')), new X0.I0Io('0', '9')), '-'), '.'), '_'), '~');
        ArrayList arrayList = new ArrayList(xXoOI00O2);
        for (int i = 0; i < xXoOI00O2; i++) {
            Character ch = (Character) CollectionsKt___CollectionsKt.ox0(OIxOIX0II2, Random.Default);
            ch.charValue();
            arrayList.add(ch);
        }
        return CollectionsKt___CollectionsKt.OoIXo(arrayList, "", null, null, 0, null, null, 62, null);
    }

    @XO0OX.x0XOIxOo
    public static final boolean isValidCodeVerifier(@OXOo.oOoXoXO String str) {
        if (str != null && str.length() != 0 && str.length() >= 43 && str.length() <= 128) {
            return new Regex("^[-._~A-Za-z0-9]+$").matches(str);
        }
        return false;
    }
}
