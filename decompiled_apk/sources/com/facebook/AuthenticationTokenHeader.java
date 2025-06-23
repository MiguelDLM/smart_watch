package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import androidx.annotation.VisibleForTesting;
import com.facebook.internal.Validate;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import java.nio.charset.Charset;
import kotlin.jvm.internal.IIX0o;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class AuthenticationTokenHeader implements Parcelable {

    @OXOo.OOXIXo
    private final String alg;

    @OXOo.OOXIXo
    private final String kid;

    @OXOo.OOXIXo
    private final String typ;

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final Parcelable.Creator<AuthenticationTokenHeader> CREATOR = new Parcelable.Creator<AuthenticationTokenHeader>() { // from class: com.facebook.AuthenticationTokenHeader$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OXOo.OOXIXo
        public AuthenticationTokenHeader createFromParcel(@OXOo.OOXIXo Parcel source) {
            IIX0o.x0xO0oo(source, "source");
            return new AuthenticationTokenHeader(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OXOo.OOXIXo
        public AuthenticationTokenHeader[] newArray(int i) {
            return new AuthenticationTokenHeader[i];
        }
    };

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public AuthenticationTokenHeader(@OXOo.OOXIXo String encodedHeaderString) {
        IIX0o.x0xO0oo(encodedHeaderString, "encodedHeaderString");
        if (isValidHeader(encodedHeaderString)) {
            byte[] decodedBytes = Base64.decode(encodedHeaderString, 0);
            IIX0o.oO(decodedBytes, "decodedBytes");
            JSONObject jSONObject = new JSONObject(new String(decodedBytes, kotlin.text.oxoX.f29581II0xO0));
            String string = jSONObject.getString("alg");
            IIX0o.oO(string, "jsonObj.getString(\"alg\")");
            this.alg = string;
            String string2 = jSONObject.getString(ClientData.KEY_TYPE);
            IIX0o.oO(string2, "jsonObj.getString(\"typ\")");
            this.typ = string2;
            String string3 = jSONObject.getString("kid");
            IIX0o.oO(string3, "jsonObj.getString(\"kid\")");
            this.kid = string3;
            return;
        }
        throw new IllegalArgumentException("Invalid Header");
    }

    private final boolean isValidHeader(String str) {
        boolean z;
        boolean z2;
        boolean z3;
        Validate validate = Validate.INSTANCE;
        Validate.notEmpty(str, "encodedHeaderString");
        byte[] decodedBytes = Base64.decode(str, 0);
        IIX0o.oO(decodedBytes, "decodedBytes");
        try {
            JSONObject jSONObject = new JSONObject(new String(decodedBytes, kotlin.text.oxoX.f29581II0xO0));
            String alg = jSONObject.optString("alg");
            IIX0o.oO(alg, "alg");
            if (alg.length() > 0 && IIX0o.Oxx0IOOO(alg, "RS256")) {
                z = true;
            } else {
                z = false;
            }
            String optString = jSONObject.optString("kid");
            IIX0o.oO(optString, "jsonObj.optString(\"kid\")");
            if (optString.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            String optString2 = jSONObject.optString(ClientData.KEY_TYPE);
            IIX0o.oO(optString2, "jsonObj.optString(\"typ\")");
            if (optString2.length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z || !z2 || !z3) {
                return false;
            }
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationTokenHeader)) {
            return false;
        }
        AuthenticationTokenHeader authenticationTokenHeader = (AuthenticationTokenHeader) obj;
        if (IIX0o.Oxx0IOOO(this.alg, authenticationTokenHeader.alg) && IIX0o.Oxx0IOOO(this.typ, authenticationTokenHeader.typ) && IIX0o.Oxx0IOOO(this.kid, authenticationTokenHeader.kid)) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public final String getAlg() {
        return this.alg;
    }

    @OXOo.OOXIXo
    public final String getKid() {
        return this.kid;
    }

    @OXOo.OOXIXo
    public final String getTyp() {
        return this.typ;
    }

    public int hashCode() {
        return ((((527 + this.alg.hashCode()) * 31) + this.typ.hashCode()) * 31) + this.kid.hashCode();
    }

    @OXOo.OOXIXo
    @VisibleForTesting(otherwise = 2)
    public final String toEnCodedString() {
        String authenticationTokenHeader = toString();
        Charset charset = kotlin.text.oxoX.f29581II0xO0;
        if (authenticationTokenHeader != null) {
            byte[] bytes = authenticationTokenHeader.getBytes(charset);
            IIX0o.oO(bytes, "(this as java.lang.String).getBytes(charset)");
            String encodeToString = Base64.encodeToString(bytes, 0);
            IIX0o.oO(encodeToString, "encodeToString(claimsJsonString.toByteArray(), Base64.DEFAULT)");
            return encodeToString;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @OXOo.OOXIXo
    public final JSONObject toJSONObject$facebook_core_release() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("alg", this.alg);
        jSONObject.put(ClientData.KEY_TYPE, this.typ);
        jSONObject.put("kid", this.kid);
        return jSONObject;
    }

    @OXOo.OOXIXo
    public String toString() {
        String jSONObject = toJSONObject$facebook_core_release().toString();
        IIX0o.oO(jSONObject, "headerJsonObject.toString()");
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@OXOo.OOXIXo Parcel dest, int i) {
        IIX0o.x0xO0oo(dest, "dest");
        dest.writeString(this.alg);
        dest.writeString(this.typ);
        dest.writeString(this.kid);
    }

    public AuthenticationTokenHeader(@OXOo.OOXIXo Parcel parcel) {
        IIX0o.x0xO0oo(parcel, "parcel");
        String readString = parcel.readString();
        Validate validate = Validate.INSTANCE;
        this.alg = Validate.notNullOrEmpty(readString, "alg");
        this.typ = Validate.notNullOrEmpty(parcel.readString(), ClientData.KEY_TYPE);
        this.kid = Validate.notNullOrEmpty(parcel.readString(), "kid");
    }

    public AuthenticationTokenHeader(@OXOo.OOXIXo JSONObject jsonObject) throws JSONException {
        IIX0o.x0xO0oo(jsonObject, "jsonObject");
        String string = jsonObject.getString("alg");
        IIX0o.oO(string, "jsonObject.getString(\"alg\")");
        this.alg = string;
        String string2 = jsonObject.getString(ClientData.KEY_TYPE);
        IIX0o.oO(string2, "jsonObject.getString(\"typ\")");
        this.typ = string2;
        String string3 = jsonObject.getString("kid");
        IIX0o.oO(string3, "jsonObject.getString(\"kid\")");
        this.kid = string3;
    }

    @VisibleForTesting(otherwise = 2)
    public AuthenticationTokenHeader(@OXOo.OOXIXo String alg, @OXOo.OOXIXo String typ, @OXOo.OOXIXo String kid) {
        IIX0o.x0xO0oo(alg, "alg");
        IIX0o.x0xO0oo(typ, "typ");
        IIX0o.x0xO0oo(kid, "kid");
        this.alg = alg;
        this.typ = typ;
        this.kid = kid;
    }
}
