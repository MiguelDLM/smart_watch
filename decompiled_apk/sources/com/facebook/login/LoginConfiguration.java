package com.facebook.login;

import java.util.Collection;
import java.util.Set;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class LoginConfiguration {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    public static final String OPENID = "openid";

    @OXOo.OOXIXo
    private final String codeVerifier;

    @OXOo.OOXIXo
    private final String nonce;

    @OXOo.OOXIXo
    private final Set<String> permissions;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @XO0OX.xoIox
    public LoginConfiguration(@OXOo.oOoXoXO Collection<String> collection) {
        this(collection, null, 2, 0 == true ? 1 : 0);
    }

    @OXOo.OOXIXo
    public final String getCodeVerifier() {
        return this.codeVerifier;
    }

    @OXOo.OOXIXo
    public final String getNonce() {
        return this.nonce;
    }

    @OXOo.OOXIXo
    public final Set<String> getPermissions() {
        return this.permissions;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ LoginConfiguration(java.util.Collection r1, java.lang.String r2, int r3, kotlin.jvm.internal.IIXOooo r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L11
            java.util.UUID r2 = java.util.UUID.randomUUID()
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "randomUUID().toString()"
            kotlin.jvm.internal.IIX0o.oO(r2, r3)
        L11:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginConfiguration.<init>(java.util.Collection, java.lang.String, int, kotlin.jvm.internal.IIXOooo):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public LoginConfiguration(@OXOo.oOoXoXO Collection<String> collection, @OXOo.OOXIXo String nonce) {
        this(collection, nonce, PKCEUtil.generateCodeVerifier());
        IIX0o.x0xO0oo(nonce, "nonce");
        PKCEUtil pKCEUtil = PKCEUtil.INSTANCE;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ LoginConfiguration(java.util.Collection r1, java.lang.String r2, java.lang.String r3, int r4, kotlin.jvm.internal.IIXOooo r5) {
        /*
            r0 = this;
            r5 = r4 & 1
            if (r5 == 0) goto L5
            r1 = 0
        L5:
            r4 = r4 & 2
            if (r4 == 0) goto L16
            java.util.UUID r2 = java.util.UUID.randomUUID()
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "randomUUID().toString()"
            kotlin.jvm.internal.IIX0o.oO(r2, r4)
        L16:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginConfiguration.<init>(java.util.Collection, java.lang.String, java.lang.String, int, kotlin.jvm.internal.IIXOooo):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public LoginConfiguration(@OXOo.oOoXoXO java.util.Collection<java.lang.String> r2, @OXOo.OOXIXo java.lang.String r3, @OXOo.OOXIXo java.lang.String r4) {
        /*
            r1 = this;
            java.lang.String r0 = "nonce"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            java.lang.String r0 = "codeVerifier"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
            r1.<init>()
            com.facebook.login.NonceUtil r0 = com.facebook.login.NonceUtil.INSTANCE
            boolean r0 = com.facebook.login.NonceUtil.isValidNonce(r3)
            if (r0 == 0) goto L1f
            com.facebook.login.PKCEUtil r0 = com.facebook.login.PKCEUtil.INSTANCE
            boolean r0 = com.facebook.login.PKCEUtil.isValidCodeVerifier(r4)
            if (r0 == 0) goto L1f
            r0 = 1
            goto L20
        L1f:
            r0 = 0
        L20:
            if (r0 == 0) goto L43
            java.util.HashSet r0 = new java.util.HashSet
            if (r2 == 0) goto L2a
            r0.<init>(r2)
            goto L2d
        L2a:
            r0.<init>()
        L2d:
            java.lang.String r2 = "openid"
            r0.add(r2)
            java.util.Set r2 = java.util.Collections.unmodifiableSet(r0)
            java.lang.String r0 = "unmodifiableSet(permissions)"
            kotlin.jvm.internal.IIX0o.oO(r2, r0)
            r1.permissions = r2
            r1.nonce = r3
            r1.codeVerifier = r4
            return
        L43:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Failed requirement."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginConfiguration.<init>(java.util.Collection, java.lang.String, java.lang.String):void");
    }
}
