package XO0o;

import OXOo.OOXIXo;
import android.content.Context;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.androidthirdpartylogin.R;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes11.dex */
public final class oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f3924oIX0oI = new oIX0oI();

    public final void oIX0oI(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, context.getString(R.string.we_chat_app_id), false);
        if (!createWXAPI.isWXAppInstalled()) {
            ToastUtils.showShort("您还未安装微信客户端！", new Object[0]);
            return;
        }
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = context.getString(R.string.app_name);
        createWXAPI.sendReq(req);
    }
}
