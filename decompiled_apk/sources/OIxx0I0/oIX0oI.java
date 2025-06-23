package OIxx0I0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import xIxooxXX.II0xO0;
import xIxooxXX.X0o0xo;

/* loaded from: classes13.dex */
public class oIX0oI extends com.tencent.connect.common.oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final String f1699I0Io = "video_chat";

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f1700II0XooXoX = -4;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f1701II0xO0 = "audio_chat";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f1702Oxx0IOOO = -3;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f1703X0o0xo = -1;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f1704XO = -2;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f1705oIX0oI = "thirdparty2c";

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f1706oxoX = 0;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f1707xxIXOIIO = -5;

    public oIX0oI(Context context, X0o0xo x0o0xo, II0xO0 iI0xO0) {
        super(x0o0xo, iI0xO0);
    }

    public int ooOOo0oXI(Activity activity, String str, String str2, String str3) {
        if (str != null) {
            if (str.equals(f1705oIX0oI) || str.equals(f1701II0xO0) || str.equals(f1699I0Io)) {
                if (!str.equals(f1701II0xO0)) {
                    str.equals(f1699I0Io);
                }
                if (TextUtils.isEmpty(str2)) {
                    return -1;
                }
                if (str2.length() < 5) {
                    return -3;
                }
                for (int i = 0; i < str2.length(); i++) {
                    if (!Character.isDigit(str2.charAt(i))) {
                        return -4;
                    }
                }
                if (com.tencent.open.utils.II0xO0.oo0xXOI0I(activity)) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(String.format("mqqapi://im/chat?chat_type=%1$s&uin=%2$s&version=1&src_type=app&open_id=%3$s&app_id=%4$s&app_pkg_name=%5$s", str, str2, com.tencent.open.utils.II0xO0.XX(this.c.II0XooXoX()), com.tencent.open.utils.II0xO0.XX(this.c.X0o0xo()), com.tencent.open.utils.II0xO0.XX(str3))));
                    intent.putExtra("pkg_name", str3);
                    activity.startActivity(intent);
                    return 0;
                }
                try {
                    new O0OOX0IIx.X0o0xo(activity, "", I0Io(""), null, this.c).show();
                    return -2;
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    return -2;
                }
            }
            return -5;
        }
        return -5;
    }

    public oIX0oI(Context context, II0xO0 iI0xO0) {
        super(iI0xO0);
    }

    public oIX0oI(II0xO0 iI0xO0) {
        super(iI0xO0);
    }
}
