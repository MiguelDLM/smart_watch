package oxOXxoXII;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.content.Intent;
import com.blankj.utilcode.util.LogUtils;
import com.sma.androidthirdpartylogin.R;
import com.sma.androidthirdpartylogin.model.LoginResponse;
import com.tencent.tauth.Tencent;
import kotlin.jvm.internal.IIX0o;
import o0Oo.I0Io;
import o0Oo.II0xO0;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class oIX0oI {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static II0xO0 f33564II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f33565oIX0oI = new oIX0oI();

    /* renamed from: oxOXxoXII.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C1141oIX0oI implements II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ O00.II0xO0 f33566oIX0oI;

        public C1141oIX0oI(O00.II0xO0 iI0xO0) {
            this.f33566oIX0oI = iI0xO0;
        }

        @Override // o0Oo.II0xO0
        public void oIX0oI(@OOXIXo I0Io e) {
            IIX0o.x0xO0oo(e, "e");
            O00.II0xO0 iI0xO0 = this.f33566oIX0oI;
            String errorDetail = e.f31121I0Io;
            IIX0o.oO(errorDetail, "errorDetail");
            iI0xO0.oIX0oI(errorDetail);
        }

        @Override // o0Oo.II0xO0
        public void onCancel() {
            this.f33566oIX0oI.II0xO0(null);
        }

        @Override // o0Oo.II0xO0
        public void onComplete(@oOoXoXO Object obj) {
            LogUtils.d(obj);
            if (obj == null) {
                this.f33566oIX0oI.II0xO0(null);
                return;
            }
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject.length() == 0) {
                this.f33566oIX0oI.II0xO0(null);
                return;
            }
            String string = jSONObject.getString("access_token");
            jSONObject.getString("expires_in");
            String string2 = jSONObject.getString("openid");
            O00.II0xO0 iI0xO0 = this.f33566oIX0oI;
            IIX0o.ooOOo0oXI(string2);
            IIX0o.ooOOo0oXI(string);
            iI0xO0.II0xO0(new LoginResponse("QQ", string2, string, null, null, null, 56, null));
        }
    }

    public final void II0xO0(int i, int i2, @oOoXoXO Intent intent) {
        if (i == 10102 || i == 11101) {
            if (f33564II0xO0 == null) {
                IIX0o.XOxIOxOx("listener");
            }
            II0xO0 iI0xO0 = f33564II0xO0;
            if (iI0xO0 == null) {
                IIX0o.XOxIOxOx("listener");
                iI0xO0 = null;
            }
            Tencent.onActivityResultData(i, i2, intent, iI0xO0);
        }
    }

    public final void oIX0oI(@OOXIXo Activity context, @OOXIXo O00.II0xO0 callback) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(callback, "callback");
        f33564II0xO0 = new C1141oIX0oI(callback);
        Tencent createInstance = Tencent.createInstance(context.getString(R.string.qq_id), context);
        II0xO0 iI0xO0 = f33564II0xO0;
        if (iI0xO0 == null) {
            IIX0o.XOxIOxOx("listener");
            iI0xO0 = null;
        }
        createInstance.login(context, "get_user_info", iI0xO0);
    }
}
