package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.internal.Validate;
import com.facebook.internal.security.OidcSecurityUtil;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.IOException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class AuthenticationToken implements Parcelable {

    @OXOo.OOXIXo
    public static final String AUTHENTICATION_TOKEN_KEY = "id_token";

    @OXOo.OOXIXo
    private static final String CLAIMS_KEY = "claims";

    @OXOo.OOXIXo
    private static final String EXPECTED_NONCE_KEY = "expected_nonce";

    @OXOo.OOXIXo
    private static final String HEADER_KEY = "header";

    @OXOo.OOXIXo
    private static final String SIGNATURE_KEY = "signature";

    @OXOo.OOXIXo
    private static final String TOKEN_STRING_KEY = "token_string";

    @OXOo.OOXIXo
    private final AuthenticationTokenClaims claims;

    @OXOo.OOXIXo
    private final String expectedNonce;

    @OXOo.OOXIXo
    private final AuthenticationTokenHeader header;

    @OXOo.OOXIXo
    private final String signature;

    @OXOo.OOXIXo
    private final String token;

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final Parcelable.Creator<AuthenticationToken> CREATOR = new Parcelable.Creator<AuthenticationToken>() { // from class: com.facebook.AuthenticationToken$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OXOo.OOXIXo
        public AuthenticationToken createFromParcel(@OXOo.OOXIXo Parcel source) {
            IIX0o.x0xO0oo(source, "source");
            return new AuthenticationToken(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OXOo.OOXIXo
        public AuthenticationToken[] newArray(int i) {
            return new AuthenticationToken[i];
        }
    };

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        public final AuthenticationToken getCurrentAuthenticationToken() {
            return AuthenticationTokenManager.Companion.getInstance().getCurrentAuthenticationToken();
        }

        @XO0OX.x0XOIxOo
        public final void setCurrentAuthenticationToken(@OXOo.oOoXoXO AuthenticationToken authenticationToken) {
            AuthenticationTokenManager.Companion.getInstance().setCurrentAuthenticationToken(authenticationToken);
        }

        private Companion() {
        }
    }

    @XO0OX.xoIox
    public AuthenticationToken(@OXOo.OOXIXo String token, @OXOo.OOXIXo String expectedNonce) {
        IIX0o.x0xO0oo(token, "token");
        IIX0o.x0xO0oo(expectedNonce, "expectedNonce");
        Validate validate = Validate.INSTANCE;
        Validate.notEmpty(token, "token");
        Validate.notEmpty(expectedNonce, "expectedNonce");
        List XXoO0oX2 = StringsKt__StringsKt.XXoO0oX(token, new String[]{FileUtils.FILE_EXTENSION_SEPARATOR}, false, 0, 6, null);
        if (XXoO0oX2.size() == 3) {
            String str = (String) XXoO0oX2.get(0);
            String str2 = (String) XXoO0oX2.get(1);
            String str3 = (String) XXoO0oX2.get(2);
            this.token = token;
            this.expectedNonce = expectedNonce;
            AuthenticationTokenHeader authenticationTokenHeader = new AuthenticationTokenHeader(str);
            this.header = authenticationTokenHeader;
            this.claims = new AuthenticationTokenClaims(str2, expectedNonce);
            if (isValidSignature(str, str2, str3, authenticationTokenHeader.getKid())) {
                this.signature = str3;
                return;
            }
            throw new IllegalArgumentException("Invalid Signature");
        }
        throw new IllegalArgumentException("Invalid IdToken string");
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final AuthenticationToken getCurrentAuthenticationToken() {
        return Companion.getCurrentAuthenticationToken();
    }

    private final boolean isValidSignature(String str, String str2, String str3, String str4) {
        try {
            OidcSecurityUtil oidcSecurityUtil = OidcSecurityUtil.INSTANCE;
            String rawKeyFromEndPoint = OidcSecurityUtil.getRawKeyFromEndPoint(str4);
            if (rawKeyFromEndPoint == null) {
                return false;
            }
            return OidcSecurityUtil.verify(OidcSecurityUtil.getPublicKeyFromString(rawKeyFromEndPoint), str + '.' + str2, str3);
        } catch (IOException | InvalidKeySpecException unused) {
            return false;
        }
    }

    @XO0OX.x0XOIxOo
    public static final void setCurrentAuthenticationToken(@OXOo.oOoXoXO AuthenticationToken authenticationToken) {
        Companion.setCurrentAuthenticationToken(authenticationToken);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationToken)) {
            return false;
        }
        AuthenticationToken authenticationToken = (AuthenticationToken) obj;
        if (IIX0o.Oxx0IOOO(this.token, authenticationToken.token) && IIX0o.Oxx0IOOO(this.expectedNonce, authenticationToken.expectedNonce) && IIX0o.Oxx0IOOO(this.header, authenticationToken.header) && IIX0o.Oxx0IOOO(this.claims, authenticationToken.claims) && IIX0o.Oxx0IOOO(this.signature, authenticationToken.signature)) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public final AuthenticationTokenClaims getClaims() {
        return this.claims;
    }

    @OXOo.OOXIXo
    public final String getExpectedNonce() {
        return this.expectedNonce;
    }

    @OXOo.OOXIXo
    public final AuthenticationTokenHeader getHeader() {
        return this.header;
    }

    @OXOo.OOXIXo
    public final String getSignature() {
        return this.signature;
    }

    @OXOo.OOXIXo
    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        return ((((((((527 + this.token.hashCode()) * 31) + this.expectedNonce.hashCode()) * 31) + this.header.hashCode()) * 31) + this.claims.hashCode()) * 31) + this.signature.hashCode();
    }

    @OXOo.OOXIXo
    public final JSONObject toJSONObject$facebook_core_release() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TOKEN_STRING_KEY, this.token);
        jSONObject.put(EXPECTED_NONCE_KEY, this.expectedNonce);
        jSONObject.put(HEADER_KEY, this.header.toJSONObject$facebook_core_release());
        jSONObject.put(CLAIMS_KEY, this.claims.toJSONObject$facebook_core_release());
        jSONObject.put("signature", this.signature);
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@OXOo.OOXIXo Parcel dest, int i) {
        IIX0o.x0xO0oo(dest, "dest");
        dest.writeString(this.token);
        dest.writeString(this.expectedNonce);
        dest.writeParcelable(this.header, i);
        dest.writeParcelable(this.claims, i);
        dest.writeString(this.signature);
    }

    public AuthenticationToken(@OXOo.OOXIXo Parcel parcel) {
        IIX0o.x0xO0oo(parcel, "parcel");
        String readString = parcel.readString();
        Validate validate = Validate.INSTANCE;
        this.token = Validate.notNullOrEmpty(readString, "token");
        this.expectedNonce = Validate.notNullOrEmpty(parcel.readString(), "expectedNonce");
        Parcelable readParcelable = parcel.readParcelable(AuthenticationTokenHeader.class.getClassLoader());
        if (readParcelable != null) {
            this.header = (AuthenticationTokenHeader) readParcelable;
            Parcelable readParcelable2 = parcel.readParcelable(AuthenticationTokenClaims.class.getClassLoader());
            if (readParcelable2 != null) {
                this.claims = (AuthenticationTokenClaims) readParcelable2;
                this.signature = Validate.notNullOrEmpty(parcel.readString(), "signature");
                return;
            }
            throw new IllegalStateException("Required value was null.");
        }
        throw new IllegalStateException("Required value was null.");
    }

    public AuthenticationToken(@OXOo.OOXIXo JSONObject jsonObject) throws JSONException {
        IIX0o.x0xO0oo(jsonObject, "jsonObject");
        String string = jsonObject.getString(TOKEN_STRING_KEY);
        IIX0o.oO(string, "jsonObject.getString(TOKEN_STRING_KEY)");
        this.token = string;
        String string2 = jsonObject.getString(EXPECTED_NONCE_KEY);
        IIX0o.oO(string2, "jsonObject.getString(EXPECTED_NONCE_KEY)");
        this.expectedNonce = string2;
        String string3 = jsonObject.getString("signature");
        IIX0o.oO(string3, "jsonObject.getString(SIGNATURE_KEY)");
        this.signature = string3;
        JSONObject headerJSONObject = jsonObject.getJSONObject(HEADER_KEY);
        JSONObject claimsJSONObject = jsonObject.getJSONObject(CLAIMS_KEY);
        IIX0o.oO(headerJSONObject, "headerJSONObject");
        this.header = new AuthenticationTokenHeader(headerJSONObject);
        AuthenticationTokenClaims.Companion companion = AuthenticationTokenClaims.Companion;
        IIX0o.oO(claimsJSONObject, "claimsJSONObject");
        this.claims = companion.createFromJSONObject$facebook_core_release(claimsJSONObject);
    }
}
