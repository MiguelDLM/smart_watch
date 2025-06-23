package com.sma.androidthirdpartylogin.google;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.blankj.utilcode.util.LogUtils;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.sma.androidthirdpartylogin.R;
import com.sma.androidthirdpartylogin.model.LoginResponse;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes11.dex */
public final class I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public static GoogleSignInClient f19702I0Io = null;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f19703II0xO0 = 1111;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final I0Io f19704oIX0oI = new I0Io();

    /* renamed from: oxoX, reason: collision with root package name */
    public static O00.II0xO0 f19705oxoX;

    public static final void Oxx0IOOO(Task it) {
        IIX0o.x0xO0oo(it, "it");
    }

    public static final void xxIXOIIO(Task it) {
        IIX0o.x0xO0oo(it, "it");
    }

    public final void I0Io(Context context) {
        GoogleSignInOptions build = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(context.getString(R.string.google_web_client_id)).build();
        IIX0o.oO(build, "build(...)");
        GoogleSignInClient client = GoogleSignIn.getClient(context, build);
        IIX0o.oO(client, "getClient(...)");
        f19702I0Io = client;
    }

    public final void II0XooXoX(@OXOo.OOXIXo Activity context) {
        IIX0o.x0xO0oo(context, "context");
        GoogleSignInClient googleSignInClient = f19702I0Io;
        if (googleSignInClient == null) {
            IIX0o.XOxIOxOx("mGoogleSignInClient");
            googleSignInClient = null;
        }
        googleSignInClient.signOut().addOnCompleteListener(context, new OnCompleteListener() { // from class: com.sma.androidthirdpartylogin.google.II0xO0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                I0Io.xxIXOIIO(task);
            }
        });
    }

    public final void X0o0xo(int i, @OXOo.oOoXoXO Intent intent) {
        if (i == 1111) {
            Task<GoogleSignInAccount> signedInAccountFromIntent = GoogleSignIn.getSignedInAccountFromIntent(intent);
            IIX0o.oO(signedInAccountFromIntent, "getSignedInAccountFromIntent(...)");
            try {
                GoogleSignInAccount result = signedInAccountFromIntent.getResult(ApiException.class);
                LogUtils.d("SignedInAccountFromIntent getResult -> " + result);
                if (result != null) {
                    O00.II0xO0 iI0xO0 = f19705oxoX;
                    if (iI0xO0 == null) {
                        IIX0o.XOxIOxOx("thirdPartyCallback");
                        iI0xO0 = null;
                    }
                    iI0xO0.II0xO0(new LoginResponse(O0xxXxI.oIX0oI.f1504oxoX, String.valueOf(result.getId()), String.valueOf(result.getIdToken()), null, null, null, 56, null));
                    return;
                }
                O00.II0xO0 iI0xO02 = f19705oxoX;
                if (iI0xO02 == null) {
                    IIX0o.XOxIOxOx("thirdPartyCallback");
                    iI0xO02 = null;
                }
                iI0xO02.II0xO0(null);
            } catch (ApiException e) {
                e.printStackTrace();
                LogUtils.d("SignedInAccountFromIntent error -> " + e.getMessage());
                O00.II0xO0 iI0xO03 = f19705oxoX;
                if (iI0xO03 == null) {
                    IIX0o.XOxIOxOx("thirdPartyCallback");
                    iI0xO03 = null;
                }
                iI0xO03.II0xO0(null);
            }
        }
    }

    public final void XO(@OXOo.OOXIXo Activity context) {
        IIX0o.x0xO0oo(context, "context");
        GoogleSignInClient googleSignInClient = f19702I0Io;
        if (googleSignInClient == null) {
            IIX0o.XOxIOxOx("mGoogleSignInClient");
            googleSignInClient = null;
        }
        googleSignInClient.revokeAccess().addOnCompleteListener(context, new OnCompleteListener() { // from class: com.sma.androidthirdpartylogin.google.oIX0oI
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                I0Io.Oxx0IOOO(task);
            }
        });
    }

    public final void oxoX(@OXOo.OOXIXo Activity context, @OXOo.OOXIXo O00.II0xO0 callback) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(callback, "callback");
        f19705oxoX = callback;
        I0Io(context);
        GoogleSignInClient googleSignInClient = f19702I0Io;
        if (googleSignInClient == null) {
            IIX0o.XOxIOxOx("mGoogleSignInClient");
            googleSignInClient = null;
        }
        context.startActivityForResult(googleSignInClient.getSignInIntent(), 1111);
    }
}
