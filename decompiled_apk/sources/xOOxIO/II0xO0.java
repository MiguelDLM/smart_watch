package xOOxIO;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.blankj.utilcode.util.LogUtils;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.sma.androidthirdpartylogin.model.LoginResponse;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import org.json.JSONObject;
import xOOxIO.II0xO0;

@XX({"SMAP\nFacebook.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Facebook.kt\ncom/sma/androidthirdpartylogin/facebook/Facebook\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,94:1\n1#2:95\n*E\n"})
/* loaded from: classes11.dex */
public final class II0xO0 {

    /* renamed from: II0xO0, reason: collision with root package name */
    @oOoXoXO
    public static CallbackManager f34462II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final II0xO0 f34463oIX0oI = new II0xO0();

    /* loaded from: classes11.dex */
    public static final class oIX0oI implements FacebookCallback<LoginResult> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ O00.II0xO0 f34464oIX0oI;

        public oIX0oI(O00.II0xO0 iI0xO0) {
            this.f34464oIX0oI = iI0xO0;
        }

        public static final void I0Io(O00.II0xO0 callback, LoginResult loginResult, JSONObject jSONObject, GraphResponse graphResponse) {
            String optString;
            IIX0o.x0xO0oo(callback, "$callback");
            IIX0o.x0xO0oo(loginResult, "$loginResult");
            if (jSONObject != null) {
                try {
                    optString = jSONObject.optString("id");
                } catch (Exception e) {
                    e.printStackTrace();
                    callback.II0xO0(null);
                    return;
                }
            } else {
                optString = null;
            }
            if (TextUtils.isEmpty(optString)) {
                callback.II0xO0(null);
                return;
            }
            IIX0o.ooOOo0oXI(jSONObject);
            String optString2 = jSONObject.optString("id");
            IIX0o.oO(optString2, "optString(...)");
            callback.II0xO0(new LoginResponse(O0xxXxI.oIX0oI.f1498I0Io, optString2, loginResult.getAccessToken().getToken(), null, null, null, 56, null));
        }

        @Override // com.facebook.FacebookCallback
        /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@OOXIXo final LoginResult loginResult) {
            IIX0o.x0xO0oo(loginResult, "loginResult");
            LogUtils.d(loginResult.toString());
            LogUtils.d(loginResult.getAccessToken().getToken());
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "id");
            GraphRequest.Companion companion = GraphRequest.Companion;
            AccessToken accessToken = loginResult.getAccessToken();
            final O00.II0xO0 iI0xO0 = this.f34464oIX0oI;
            GraphRequest newMeRequest = companion.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() { // from class: xOOxIO.oIX0oI
                @Override // com.facebook.GraphRequest.GraphJSONObjectCallback
                public final void onCompleted(JSONObject jSONObject, GraphResponse graphResponse) {
                    II0xO0.oIX0oI.I0Io(O00.II0xO0.this, loginResult, jSONObject, graphResponse);
                }
            });
            newMeRequest.setParameters(bundle);
            newMeRequest.executeAsync();
        }

        @Override // com.facebook.FacebookCallback
        public void onCancel() {
            LogUtils.d(" Facebook login cancel");
            this.f34464oIX0oI.II0xO0(null);
        }

        @Override // com.facebook.FacebookCallback
        public void onError(@OOXIXo FacebookException error) {
            IIX0o.x0xO0oo(error, "error");
            LogUtils.d(" Facebook login onError " + error);
            this.f34464oIX0oI.oIX0oI(error.toString());
            if ((error instanceof FacebookAuthorizationException) && AccessToken.Companion.getCurrentAccessToken() != null) {
                LoginManager.Companion.getInstance().logOut();
            }
        }
    }

    public final void I0Io(int i, int i2, @oOoXoXO Intent intent) {
        CallbackManager callbackManager = f34462II0xO0;
        if (callbackManager != null) {
            callbackManager.onActivityResult(i, i2, intent);
        }
    }

    public final void II0xO0(@OOXIXo Activity activity, @OOXIXo O00.II0xO0 callback) {
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(callback, "callback");
        LoginManager.Companion companion = LoginManager.Companion;
        LoginManager companion2 = companion.getInstance();
        CallbackManager create = CallbackManager.Factory.create();
        f34462II0xO0 = create;
        companion2.registerCallback(create, new oIX0oI(callback));
        companion.getInstance().logInWithReadPermissions(activity, oI0IIXIo.OOXIXo("public_profile"));
    }

    public final void oIX0oI(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        FacebookSdk.sdkInitialize(context);
        FacebookSdk.setAutoLogAppEventsEnabled(true);
        FacebookSdk.setAutoInitEnabled(true);
        FacebookSdk.fullyInitialize();
    }
}
