package com.facebook.login;

import com.facebook.AccessToken;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public enum LoginTargetApp {
    FACEBOOK(AccessToken.DEFAULT_GRAPH_DOMAIN),
    INSTAGRAM("instagram");


    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private final String targetApp;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final LoginTargetApp fromString(@OXOo.oOoXoXO String str) {
            LoginTargetApp[] valuesCustom = LoginTargetApp.valuesCustom();
            int length = valuesCustom.length;
            int i = 0;
            while (i < length) {
                LoginTargetApp loginTargetApp = valuesCustom[i];
                i++;
                if (IIX0o.Oxx0IOOO(loginTargetApp.toString(), str)) {
                    return loginTargetApp;
                }
            }
            return LoginTargetApp.FACEBOOK;
        }

        private Companion() {
        }
    }

    LoginTargetApp(String str) {
        this.targetApp = str;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final LoginTargetApp fromString(@OXOo.oOoXoXO String str) {
        return Companion.fromString(str);
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static LoginTargetApp[] valuesCustom() {
        LoginTargetApp[] valuesCustom = values();
        return (LoginTargetApp[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }

    @Override // java.lang.Enum
    @OXOo.OOXIXo
    public String toString() {
        return this.targetApp;
    }
}
