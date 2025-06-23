package XxIo;

import XxXX.Oxx0IOOO;
import XxXX.X0o0xo;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.tencent.connect.avatar.ImageActivity;
import com.tencent.connect.common.I0Io;
import xoX.OOXIXo;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class oIX0oI extends com.tencent.connect.common.oIX0oI {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f4203II0xO0 = "FROM_SDK_AVATAR_SET_IMAGE";

    /* renamed from: oIX0oI, reason: collision with root package name */
    public o0Oo.II0xO0 f4204oIX0oI;

    public oIX0oI(xIxooxXX.II0xO0 iI0xO0) {
        super(iI0xO0);
    }

    public void IXxxXO(Activity activity, Uri uri, o0Oo.II0xO0 iI0xO0) {
        o0Oo.II0xO0 iI0xO02 = this.f4204oIX0oI;
        if (iI0xO02 != null) {
            iI0xO02.onCancel();
        }
        this.f4204oIX0oI = iI0xO0;
        if (!Oxx0IOOO.ooOOo0oXI(activity)) {
            Toast.makeText(activity.getApplicationContext(), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
            return;
        }
        if (Oxx0IOOO.x0XOIxOo(activity, "8.0.5") < 0) {
            Toast.makeText(activity.getApplicationContext(), "当前手机QQ版本过低，不支持设置头像功能。", 1).show();
            return;
        }
        String II0XooXoX2 = com.tencent.open.utils.II0xO0.II0XooXoX(activity);
        StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_dynamic_avatar_edit?");
        if (!TextUtils.isEmpty(II0XooXoX2)) {
            if (II0XooXoX2.length() > 20) {
                II0XooXoX2 = II0XooXoX2.substring(0, 20) + "...";
            }
            stringBuffer.append("&app_name=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(II0XooXoX2), 2));
        }
        String X0o0xo2 = this.c.X0o0xo();
        String II0XooXoX3 = this.c.II0XooXoX();
        if (!TextUtils.isEmpty(X0o0xo2)) {
            stringBuffer.append("&share_id=" + X0o0xo2);
        }
        if (!TextUtils.isEmpty(II0XooXoX3)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(II0XooXoX3), 2));
        }
        String xxIXOIIO2 = com.tencent.open.utils.II0xO0.xxIXOIIO(activity, uri);
        if (!TextUtils.isEmpty(xxIXOIIO2)) {
            try {
                activity.grantUriPermission("com.tencent.mobileqq", uri, 3);
                stringBuffer.append("&video_uri=");
                stringBuffer.append(Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(uri.toString()), 2));
            } catch (Exception e) {
                xxIXOIIO.xxIXOIIO("QQAvatar", "Exception", e);
            }
        }
        if (!TextUtils.isEmpty(xxIXOIIO2)) {
            stringBuffer.append("&video_path=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(xxIXOIIO2), 2));
        }
        stringBuffer.append("&sdk_version=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(com.tencent.connect.common.II0xO0.f26901xoIox), 2));
        xxIXOIIO.IXxxXO("QQAVATAR", "-->set dynamic avatar, url: " + stringBuffer.toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtra("FROM_WHERE", f4203II0xO0);
        intent.putExtra("pkg_name", activity.getPackageName());
        intent.setData(Uri.parse(stringBuffer.toString()));
        if (II0XooXoX(intent)) {
            I0Io.II0xO0().Oxx0IOOO(10110, iI0xO0);
            oxoX(activity, 10110, intent, false);
        }
    }

    public void Oo(Activity activity, Uri uri, o0Oo.II0xO0 iI0xO0) {
        o0Oo.II0xO0 iI0xO02 = this.f4204oIX0oI;
        if (iI0xO02 != null) {
            iI0xO02.onCancel();
        }
        this.f4204oIX0oI = iI0xO0;
        if (!Oxx0IOOO.ooOOo0oXI(activity)) {
            Toast.makeText(activity.getApplicationContext(), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
            return;
        }
        if (Oxx0IOOO.x0XOIxOo(activity, "8.0.0") < 0) {
            Toast.makeText(activity.getApplicationContext(), "当前手机QQ版本过低，不支持设置头像功能。", 1).show();
            return;
        }
        String II0XooXoX2 = com.tencent.open.utils.II0xO0.II0XooXoX(activity);
        StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_avatar_edit?");
        if (!TextUtils.isEmpty(II0XooXoX2)) {
            if (II0XooXoX2.length() > 20) {
                II0XooXoX2 = II0XooXoX2.substring(0, 20) + "...";
            }
            stringBuffer.append("&app_name=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(II0XooXoX2), 2));
        }
        String X0o0xo2 = this.c.X0o0xo();
        String II0XooXoX3 = this.c.II0XooXoX();
        if (!TextUtils.isEmpty(X0o0xo2)) {
            stringBuffer.append("&share_id=" + X0o0xo2);
        }
        if (!TextUtils.isEmpty(II0XooXoX3)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(II0XooXoX3), 2));
        }
        String xxIXOIIO2 = com.tencent.open.utils.II0xO0.xxIXOIIO(activity, uri);
        if (!TextUtils.isEmpty(xxIXOIIO2)) {
            try {
                activity.grantUriPermission("com.tencent.mobileqq", uri, 3);
                stringBuffer.append("&set_uri=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(uri.toString()), 2));
            } catch (Exception e) {
                xxIXOIIO.xxIXOIIO("QQAvatar", "Exception", e);
            }
        }
        if (!TextUtils.isEmpty(xxIXOIIO2)) {
            stringBuffer.append("&set_path=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(xxIXOIIO2), 2));
        }
        stringBuffer.append("&sdk_version=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(com.tencent.connect.common.II0xO0.f26901xoIox), 2));
        xxIXOIIO.IXxxXO("QQAVATAR", "-->set avatar, url: " + stringBuffer.toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtra("FROM_WHERE", f4203II0xO0);
        intent.putExtra("pkg_name", activity.getPackageName());
        intent.setData(Uri.parse(stringBuffer.toString()));
        if (II0XooXoX(intent)) {
            I0Io.II0xO0().Oxx0IOOO(10108, iI0xO0);
            oxoX(activity, 10108, intent, false);
        }
    }

    public final void oO(Bundle bundle) {
        xIxooxXX.II0xO0 iI0xO0 = this.c;
        if (iI0xO0 != null) {
            bundle.putString("appid", iI0xO0.X0o0xo());
            if (this.c.xoIox()) {
                bundle.putString(com.tencent.connect.common.II0xO0.f26880x0xO0oo, this.c.oxoX());
                bundle.putString(com.tencent.connect.common.II0xO0.f26783Oo, "0x80");
            }
            String II0XooXoX2 = this.c.II0XooXoX();
            if (II0XooXoX2 != null) {
                bundle.putString("hopenid", II0XooXoX2);
            }
            bundle.putString("platform", "androidqz");
            try {
                bundle.putString(com.tencent.connect.common.II0xO0.f26810XIxXXX0x0, X0o0xo.oIX0oI().getSharedPreferences(com.tencent.connect.common.II0xO0.f26831XxX0x0xxx, 0).getString(com.tencent.connect.common.II0xO0.f26810XIxXXX0x0, com.tencent.connect.common.II0xO0.f26794OxxIIOOXO));
            } catch (Exception e) {
                e.printStackTrace();
                bundle.putString(com.tencent.connect.common.II0xO0.f26810XIxXXX0x0, com.tencent.connect.common.II0xO0.f26794OxxIIOOXO);
            }
        }
        bundle.putString("sdkv", com.tencent.connect.common.II0xO0.f26901xoIox);
        bundle.putString("sdkp", "a");
    }

    public final Intent ooOOo0oXI(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, ImageActivity.class);
        return intent;
    }

    public final void x0XOIxOo(Activity activity, Bundle bundle, Intent intent) {
        oO(bundle);
        intent.putExtra(com.tencent.connect.common.II0xO0.f26845oOo, "action_avatar");
        intent.putExtra(com.tencent.connect.common.II0xO0.f26852oXIO0o0XI, bundle);
        I0Io.II0xO0().Oxx0IOOO(11102, this.f4204oIX0oI);
        X0o0xo(activity, intent, 11102);
    }

    public void x0xO0oo(Activity activity, Uri uri, o0Oo.II0xO0 iI0xO0, int i) {
        o0Oo.II0xO0 iI0xO02 = this.f4204oIX0oI;
        if (iI0xO02 != null) {
            iI0xO02.onCancel();
        }
        this.f4204oIX0oI = iI0xO0;
        Bundle bundle = new Bundle();
        bundle.putString("picture", uri.toString());
        bundle.putInt("exitAnim", i);
        bundle.putString("appid", this.c.X0o0xo());
        bundle.putString("access_token", this.c.oxoX());
        bundle.putLong("expires_in", this.c.Oxx0IOOO());
        bundle.putString("openid", this.c.II0XooXoX());
        Intent ooOOo0oXI2 = ooOOo0oXI(activity);
        if (II0XooXoX(ooOOo0oXI2)) {
            x0XOIxOo(activity, bundle, ooOOo0oXI2);
            OOXIXo.oIX0oI().I0Io(this.c.II0XooXoX(), this.c.X0o0xo(), com.tencent.connect.common.II0xO0.f26887xIx, com.tencent.connect.common.II0xO0.f26834o0IXXIx, "18", "0");
        } else {
            OOXIXo.oIX0oI().I0Io(this.c.II0XooXoX(), this.c.X0o0xo(), com.tencent.connect.common.II0xO0.f26887xIx, com.tencent.connect.common.II0xO0.f26834o0IXXIx, "18", "1");
        }
    }
}
