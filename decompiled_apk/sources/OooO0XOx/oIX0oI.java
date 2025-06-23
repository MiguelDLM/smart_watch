package OooO0XOx;

import XxXX.Oxx0IOOO;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;
import xIxooxXX.II0xO0;
import xIxooxXX.X0o0xo;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class oIX0oI extends com.tencent.connect.common.oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f2682I0Io = 0;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f2683II0XooXoX = -5;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f2684II0xO0 = "21";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f2686Oxx0IOOO = -4;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f2687X0o0xo = -2;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f2688XO = -3;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f2689oIX0oI = "mini_program_or_game";

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final String f2691ooOOo0oXI = "release";

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f2692oxoX = -1;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f2694xoIox = -7;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f2695xxIXOIIO = -6;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final String f2685OOXIXo = "develop";

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final String f2690oOoXoXO = "trial";

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final List<String> f2693x0XOIxOo = Arrays.asList(f2685OOXIXo, f2690oOoXoXO, "release");

    public oIX0oI(Context context, X0o0xo x0o0xo, II0xO0 iI0xO0) {
        super(x0o0xo, iI0xO0);
    }

    public int ooOOo0oXI(Activity activity, String str, String str2, String str3, String str4, String str5) {
        if (activity == null) {
            xxIXOIIO.oOoXoXO("openSDK_LOG.MiniApp", "Result is MINIAPP_CONTEXT_NULL : -6");
            return -6;
        }
        if (!f2689oIX0oI.equals(str)) {
            xxIXOIIO.oOoXoXO("openSDK_LOG.MiniApp", "Result is MINIAPP_UNKNOWN_TYPE : -5");
            return -5;
        }
        if (TextUtils.isEmpty(str2)) {
            xxIXOIIO.oOoXoXO("openSDK_LOG.MiniApp", "Result is MINIAPP_ID_EMPTY : -1");
            return -1;
        }
        for (int i = 0; i < str2.length(); i++) {
            if (!Character.isDigit(str2.charAt(i))) {
                xxIXOIIO.oOoXoXO("openSDK_LOG.MiniApp", "Result is MINIAPP_ID_NOT_DIGIT : -4");
                return -4;
            }
        }
        if (str4 == null) {
            str4 = "";
        }
        if (!f2693x0XOIxOo.contains(str5)) {
            xxIXOIIO.oOoXoXO("openSDK_LOG.MiniApp", "Result is MINIAPP_VERSION_WRONG : -7");
            return -7;
        }
        if (com.tencent.open.utils.II0xO0.oOXoIIIo(activity)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(String.format("mqqapi://connect_miniapp/launch?app_type=%1$s&mini_app_id=%2$s&version=1&src_type=app&app_name=%3$s&app_id=%4$s&src_id=%5$s&mini_app_path=%6$s&mini_app_type=%7$s&open_id=%8$s", str, str2, com.tencent.open.utils.II0xO0.XX(Oxx0IOOO.XO(activity)), com.tencent.open.utils.II0xO0.XX(this.c.X0o0xo()), str3, com.tencent.open.utils.II0xO0.XX(str4), com.tencent.open.utils.II0xO0.XX(str5), com.tencent.open.utils.II0xO0.XX(this.c.II0XooXoX()))));
            intent.putExtra("pkg_name", activity.getPackageName());
            activity.startActivity(intent);
            xxIXOIIO.oOoXoXO("openSDK_LOG.MiniApp", "Result is MINIAPP_SUCCESS : 0");
            return 0;
        }
        try {
            new O0OOX0IIx.X0o0xo(activity, "", I0Io(""), null, this.c).show();
        } catch (RuntimeException e) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.MiniApp", "Show download dialog exception:" + e.getMessage());
        }
        xxIXOIIO.oOoXoXO("openSDK_LOG.MiniApp", "Result is MINIAPP_SHOULD_DOWNLOAD : -2");
        return -2;
    }

    public oIX0oI(Context context, II0xO0 iI0xO0) {
        super(iI0xO0);
    }

    public oIX0oI(II0xO0 iI0xO0) {
        super(iI0xO0);
    }
}
