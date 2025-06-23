package com.facebook.appevents;

import androidx.annotation.RestrictTo;
import com.facebook.internal.Utility;
import java.io.ObjectStreamException;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class AccessTokenAppIdPair implements Serializable {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 1;

    @OXOo.oOoXoXO
    private final String accessTokenString;

    @OXOo.OOXIXo
    private final String applicationId;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class SerializationProxyV1 implements Serializable {

        @OXOo.OOXIXo
        public static final Companion Companion = new Companion(null);
        private static final long serialVersionUID = -2488473066578201069L;

        @OXOo.oOoXoXO
        private final String accessTokenString;

        @OXOo.OOXIXo
        private final String appId;

        /* loaded from: classes8.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            private Companion() {
            }
        }

        public SerializationProxyV1(@OXOo.oOoXoXO String str, @OXOo.OOXIXo String appId) {
            IIX0o.x0xO0oo(appId, "appId");
            this.accessTokenString = str;
            this.appId = appId;
        }

        private final Object readResolve() throws ObjectStreamException {
            return new AccessTokenAppIdPair(this.accessTokenString, this.appId);
        }
    }

    public AccessTokenAppIdPair(@OXOo.oOoXoXO String str, @OXOo.OOXIXo String applicationId) {
        IIX0o.x0xO0oo(applicationId, "applicationId");
        this.applicationId = applicationId;
        Utility utility = Utility.INSTANCE;
        this.accessTokenString = Utility.isNullOrEmpty(str) ? null : str;
    }

    private final Object writeReplace() throws ObjectStreamException {
        return new SerializationProxyV1(this.accessTokenString, this.applicationId);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (!(obj instanceof AccessTokenAppIdPair)) {
            return false;
        }
        Utility utility = Utility.INSTANCE;
        AccessTokenAppIdPair accessTokenAppIdPair = (AccessTokenAppIdPair) obj;
        if (!Utility.areObjectsEqual(accessTokenAppIdPair.accessTokenString, this.accessTokenString) || !Utility.areObjectsEqual(accessTokenAppIdPair.applicationId, this.applicationId)) {
            return false;
        }
        return true;
    }

    @OXOo.oOoXoXO
    public final String getAccessTokenString() {
        return this.accessTokenString;
    }

    @OXOo.OOXIXo
    public final String getApplicationId() {
        return this.applicationId;
    }

    public int hashCode() {
        int hashCode;
        String str = this.accessTokenString;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode ^ this.applicationId.hashCode();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AccessTokenAppIdPair(@OXOo.OOXIXo com.facebook.AccessToken r2) {
        /*
            r1 = this;
            java.lang.String r0 = "accessToken"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
            java.lang.String r2 = r2.getToken()
            com.facebook.FacebookSdk r0 = com.facebook.FacebookSdk.INSTANCE
            java.lang.String r0 = com.facebook.FacebookSdk.getApplicationId()
            r1.<init>(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AccessTokenAppIdPair.<init>(com.facebook.AccessToken):void");
    }
}
