package IxX00;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.SdkListener;
import com.sina.weibo.sdk.openapi.WBAPIFactory;
import com.sma.androidthirdpartylogin.R;
import com.sma.androidthirdpartylogin.model.LoginResponse;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes11.dex */
public final class oIX0oI {

    /* renamed from: II0xO0, reason: collision with root package name */
    @oOoXoXO
    public static IWBAPI f1098II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f1099oIX0oI = new oIX0oI();

    /* loaded from: classes11.dex */
    public static final class II0xO0 implements WbAuthListener {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ O00.II0xO0 f1100oIX0oI;

        public II0xO0(O00.II0xO0 iI0xO0) {
            this.f1100oIX0oI = iI0xO0;
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void onCancel() {
            this.f1100oIX0oI.II0xO0(null);
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void onComplete(@OOXIXo Oauth2AccessToken token) {
            IIX0o.x0xO0oo(token, "token");
            if (token.isSessionValid()) {
                O00.II0xO0 iI0xO0 = this.f1100oIX0oI;
                String uid = token.getUid();
                IIX0o.oO(uid, "getUid(...)");
                String accessToken = token.getAccessToken();
                IIX0o.oO(accessToken, "getAccessToken(...)");
                iI0xO0.II0xO0(new LoginResponse(O0xxXxI.oIX0oI.f1502XO, uid, accessToken, null, null, null, 56, null));
                return;
            }
            this.f1100oIX0oI.II0xO0(null);
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void onError(@OOXIXo UiError error) {
            IIX0o.x0xO0oo(error, "error");
            O00.II0xO0 iI0xO0 = this.f1100oIX0oI;
            String errorMessage = error.errorMessage;
            IIX0o.oO(errorMessage, "errorMessage");
            iI0xO0.oIX0oI(errorMessage);
        }
    }

    public final void I0Io(@OOXIXo Activity context, int i, int i2, @oOoXoXO Intent intent) {
        IIX0o.x0xO0oo(context, "context");
        IWBAPI iwbapi = f1098II0xO0;
        if (iwbapi != null) {
            iwbapi.authorizeCallback(context, i, i2, intent);
        }
    }

    public final void II0xO0(@OOXIXo Activity context, @OOXIXo O00.II0xO0 callback) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(callback, "callback");
        IWBAPI iwbapi = f1098II0xO0;
        if (iwbapi != null) {
            iwbapi.authorize(context, new II0xO0(callback));
        }
    }

    public final void oIX0oI(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        AuthInfo authInfo = new AuthInfo(context, context.getString(R.string.wei_bo_key), context.getString(R.string.wei_bo_redirect_uri), "");
        IWBAPI createWBAPI = WBAPIFactory.createWBAPI(context);
        f1098II0xO0 = createWBAPI;
        if (createWBAPI != null) {
            createWBAPI.registerApp(context, authInfo, new C0029oIX0oI());
        }
    }

    /* renamed from: IxX00.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C0029oIX0oI implements SdkListener {
        @Override // com.sina.weibo.sdk.openapi.SdkListener
        public void onInitFailure(@OOXIXo Exception e) {
            IIX0o.x0xO0oo(e, "e");
        }

        @Override // com.sina.weibo.sdk.openapi.SdkListener
        public void onInitSuccess() {
        }
    }
}
