package com.facebook.login;

import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Set;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class LoginResult {

    @OXOo.OOXIXo
    private final AccessToken accessToken;

    @OXOo.oOoXoXO
    private final AuthenticationToken authenticationToken;

    @OXOo.OOXIXo
    private final Set<String> recentlyDeniedPermissions;

    @OXOo.OOXIXo
    private final Set<String> recentlyGrantedPermissions;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public LoginResult(@OXOo.OOXIXo AccessToken accessToken, @OXOo.OOXIXo Set<String> recentlyGrantedPermissions, @OXOo.OOXIXo Set<String> recentlyDeniedPermissions) {
        this(accessToken, null, recentlyGrantedPermissions, recentlyDeniedPermissions, 2, null);
        IIX0o.x0xO0oo(accessToken, "accessToken");
        IIX0o.x0xO0oo(recentlyGrantedPermissions, "recentlyGrantedPermissions");
        IIX0o.x0xO0oo(recentlyDeniedPermissions, "recentlyDeniedPermissions");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LoginResult copy$default(LoginResult loginResult, AccessToken accessToken, AuthenticationToken authenticationToken, Set set, Set set2, int i, Object obj) {
        if ((i & 1) != 0) {
            accessToken = loginResult.accessToken;
        }
        if ((i & 2) != 0) {
            authenticationToken = loginResult.authenticationToken;
        }
        if ((i & 4) != 0) {
            set = loginResult.recentlyGrantedPermissions;
        }
        if ((i & 8) != 0) {
            set2 = loginResult.recentlyDeniedPermissions;
        }
        return loginResult.copy(accessToken, authenticationToken, set, set2);
    }

    @OXOo.OOXIXo
    public final AccessToken component1() {
        return this.accessToken;
    }

    @OXOo.oOoXoXO
    public final AuthenticationToken component2() {
        return this.authenticationToken;
    }

    @OXOo.OOXIXo
    public final Set<String> component3() {
        return this.recentlyGrantedPermissions;
    }

    @OXOo.OOXIXo
    public final Set<String> component4() {
        return this.recentlyDeniedPermissions;
    }

    @OXOo.OOXIXo
    public final LoginResult copy(@OXOo.OOXIXo AccessToken accessToken, @OXOo.oOoXoXO AuthenticationToken authenticationToken, @OXOo.OOXIXo Set<String> recentlyGrantedPermissions, @OXOo.OOXIXo Set<String> recentlyDeniedPermissions) {
        IIX0o.x0xO0oo(accessToken, "accessToken");
        IIX0o.x0xO0oo(recentlyGrantedPermissions, "recentlyGrantedPermissions");
        IIX0o.x0xO0oo(recentlyDeniedPermissions, "recentlyDeniedPermissions");
        return new LoginResult(accessToken, authenticationToken, recentlyGrantedPermissions, recentlyDeniedPermissions);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoginResult)) {
            return false;
        }
        LoginResult loginResult = (LoginResult) obj;
        return IIX0o.Oxx0IOOO(this.accessToken, loginResult.accessToken) && IIX0o.Oxx0IOOO(this.authenticationToken, loginResult.authenticationToken) && IIX0o.Oxx0IOOO(this.recentlyGrantedPermissions, loginResult.recentlyGrantedPermissions) && IIX0o.Oxx0IOOO(this.recentlyDeniedPermissions, loginResult.recentlyDeniedPermissions);
    }

    @OXOo.OOXIXo
    public final AccessToken getAccessToken() {
        return this.accessToken;
    }

    @OXOo.oOoXoXO
    public final AuthenticationToken getAuthenticationToken() {
        return this.authenticationToken;
    }

    @OXOo.OOXIXo
    public final Set<String> getRecentlyDeniedPermissions() {
        return this.recentlyDeniedPermissions;
    }

    @OXOo.OOXIXo
    public final Set<String> getRecentlyGrantedPermissions() {
        return this.recentlyGrantedPermissions;
    }

    public int hashCode() {
        int hashCode = this.accessToken.hashCode() * 31;
        AuthenticationToken authenticationToken = this.authenticationToken;
        return ((((hashCode + (authenticationToken == null ? 0 : authenticationToken.hashCode())) * 31) + this.recentlyGrantedPermissions.hashCode()) * 31) + this.recentlyDeniedPermissions.hashCode();
    }

    @OXOo.OOXIXo
    public String toString() {
        return "LoginResult(accessToken=" + this.accessToken + ", authenticationToken=" + this.authenticationToken + ", recentlyGrantedPermissions=" + this.recentlyGrantedPermissions + ", recentlyDeniedPermissions=" + this.recentlyDeniedPermissions + HexStringBuilder.COMMENT_END_CHAR;
    }

    @XO0OX.xoIox
    public LoginResult(@OXOo.OOXIXo AccessToken accessToken, @OXOo.oOoXoXO AuthenticationToken authenticationToken, @OXOo.OOXIXo Set<String> recentlyGrantedPermissions, @OXOo.OOXIXo Set<String> recentlyDeniedPermissions) {
        IIX0o.x0xO0oo(accessToken, "accessToken");
        IIX0o.x0xO0oo(recentlyGrantedPermissions, "recentlyGrantedPermissions");
        IIX0o.x0xO0oo(recentlyDeniedPermissions, "recentlyDeniedPermissions");
        this.accessToken = accessToken;
        this.authenticationToken = authenticationToken;
        this.recentlyGrantedPermissions = recentlyGrantedPermissions;
        this.recentlyDeniedPermissions = recentlyDeniedPermissions;
    }

    public /* synthetic */ LoginResult(AccessToken accessToken, AuthenticationToken authenticationToken, Set set, Set set2, int i, IIXOooo iIXOooo) {
        this(accessToken, (i & 2) != 0 ? null : authenticationToken, set, set2);
    }
}
