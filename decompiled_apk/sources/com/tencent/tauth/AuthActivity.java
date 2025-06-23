package com.tencent.tauth;

import OoOoXO0.xoXoI;
import XxXX.Oxx0IOOO;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.connect.common.AssistActivity;
import com.tencent.connect.common.I0Io;
import com.tencent.open.utils.II0xO0;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class AuthActivity extends Activity {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final String f26981IXxxXO = "sharePrize";

    /* renamed from: Oo, reason: collision with root package name */
    public static int f26982Oo = 0;

    /* renamed from: XO, reason: collision with root package name */
    public static final String f26983XO = "action";

    public final void oIX0oI(Uri uri) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.AuthActivity", "-->handleActionUri--start");
        if (uri != null && uri.toString() != null) {
            String str = "";
            if (!uri.toString().equals("")) {
                String uri2 = uri.toString();
                Bundle I0Io2 = II0xO0.I0Io(uri2.substring(uri2.indexOf(xoXoI.f2670oxoX) + 1));
                if (I0Io2 == null) {
                    xxIXOIIO.oI0IIXIo("openSDK_LOG.AuthActivity", "-->handleActionUri, bundle is null");
                    finish();
                    return;
                }
                String string = I0Io2.getString("action");
                xxIXOIIO.oOoXoXO("openSDK_LOG.AuthActivity", "-->handleActionUri, action: " + string);
                if (string == null) {
                    finish();
                    return;
                }
                if (!string.equals("shareToQQ") && !string.equals("shareToQzone") && !string.equals("sendToMyComputer") && !string.equals("shareToTroopBar")) {
                    if (string.equals("addToQQFavorites")) {
                        Intent intent = getIntent();
                        intent.putExtras(I0Io2);
                        intent.putExtra(com.tencent.connect.common.II0xO0.f26845oOo, "action_share");
                        o0Oo.II0xO0 I0Io3 = I0Io.II0xO0().I0Io(string);
                        if (I0Io3 != null) {
                            I0Io.II0xO0().X0o0xo(intent, I0Io3);
                        }
                        finish();
                        return;
                    }
                    if (string.equals(f26981IXxxXO)) {
                        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
                        try {
                            str = II0xO0.xXxxox0I(I0Io2.getString("response")).getString("activityid");
                        } catch (Exception e) {
                            xxIXOIIO.xxIXOIIO("openSDK_LOG.AuthActivity", "sharePrize parseJson has exception.", e);
                        }
                        if (!TextUtils.isEmpty(str)) {
                            launchIntentForPackage.putExtra(f26981IXxxXO, true);
                            Bundle bundle = new Bundle();
                            bundle.putString("activityid", str);
                            launchIntentForPackage.putExtras(bundle);
                        }
                        startActivity(launchIntentForPackage);
                        finish();
                        return;
                    }
                    if (string.equals("sdkSetAvatar")) {
                        boolean booleanExtra = getIntent().getBooleanExtra(com.tencent.connect.common.II0xO0.f26907xx0X0, false);
                        Intent intent2 = new Intent(this, (Class<?>) AssistActivity.class);
                        intent2.putExtra(com.tencent.connect.common.II0xO0.f26911xxX, 10108);
                        intent2.putExtra(com.tencent.connect.common.II0xO0.f26907xx0X0, booleanExtra);
                        intent2.putExtras(I0Io2);
                        intent2.setFlags(603979776);
                        startActivity(intent2);
                        finish();
                        return;
                    }
                    if ("sdkSetDynamicAvatar".equals(string)) {
                        boolean booleanExtra2 = getIntent().getBooleanExtra(com.tencent.connect.common.II0xO0.f26907xx0X0, false);
                        Intent intent3 = new Intent(this, (Class<?>) AssistActivity.class);
                        intent3.putExtra(com.tencent.connect.common.II0xO0.f26911xxX, 10110);
                        intent3.putExtra(com.tencent.connect.common.II0xO0.f26907xx0X0, booleanExtra2);
                        intent3.putExtras(I0Io2);
                        intent3.setFlags(603979776);
                        startActivity(intent3);
                        finish();
                        return;
                    }
                    if (string.equals("sdkSetEmotion")) {
                        boolean booleanExtra3 = getIntent().getBooleanExtra(com.tencent.connect.common.II0xO0.f26907xx0X0, false);
                        Intent intent4 = new Intent(this, (Class<?>) AssistActivity.class);
                        intent4.putExtra(com.tencent.connect.common.II0xO0.f26911xxX, 10109);
                        intent4.putExtra(com.tencent.connect.common.II0xO0.f26907xx0X0, booleanExtra3);
                        intent4.putExtras(I0Io2);
                        intent4.setFlags(603979776);
                        startActivity(intent4);
                        finish();
                        return;
                    }
                    if (string.equals("bindGroup")) {
                        xxIXOIIO.oOoXoXO("openSDK_LOG.AuthActivity", "-->handleActionUri--bind group callback.");
                        boolean booleanExtra4 = getIntent().getBooleanExtra(com.tencent.connect.common.II0xO0.f26907xx0X0, false);
                        Intent intent5 = new Intent(this, (Class<?>) AssistActivity.class);
                        intent5.putExtra(com.tencent.connect.common.II0xO0.f26911xxX, 10112);
                        intent5.putExtra(com.tencent.connect.common.II0xO0.f26907xx0X0, booleanExtra4);
                        intent5.putExtras(I0Io2);
                        intent5.setFlags(603979776);
                        startActivity(intent5);
                        finish();
                        return;
                    }
                    if (string.equals("joinGroup")) {
                        xxIXOIIO.oOoXoXO("openSDK_LOG.AuthActivity", "-->handleActionUri--join group callback. ");
                        boolean booleanExtra5 = getIntent().getBooleanExtra(com.tencent.connect.common.II0xO0.f26907xx0X0, false);
                        Intent intent6 = new Intent(this, (Class<?>) AssistActivity.class);
                        intent6.putExtra(com.tencent.connect.common.II0xO0.f26911xxX, 10111);
                        intent6.putExtra(com.tencent.connect.common.II0xO0.f26907xx0X0, booleanExtra5);
                        intent6.putExtras(I0Io2);
                        intent6.setFlags(603979776);
                        startActivity(intent6);
                        finish();
                        return;
                    }
                    finish();
                    return;
                }
                if (string.equals("shareToQzone") && Oxx0IOOO.Oxx0IOOO(this, "com.tencent.mobileqq") != null && Oxx0IOOO.x0XOIxOo(this, "5.2.0") < 0) {
                    int i = f26982Oo + 1;
                    f26982Oo = i;
                    if (i == 2) {
                        f26982Oo = 0;
                        finish();
                        return;
                    }
                }
                xxIXOIIO.oOoXoXO("openSDK_LOG.AuthActivity", "-->handleActionUri, most share action, start assistactivity");
                Intent intent7 = new Intent(this, (Class<?>) AssistActivity.class);
                intent7.putExtras(I0Io2);
                intent7.setFlags(603979776);
                startActivity(intent7);
                finish();
                return;
            }
        }
        xxIXOIIO.oI0IIXIo("openSDK_LOG.AuthActivity", "-->handleActionUri, uri invalid");
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Uri uri;
        super.onCreate(bundle);
        if (getIntent() == null) {
            xxIXOIIO.oI0IIXIo("openSDK_LOG.AuthActivity", "-->onCreate, getIntent() return null");
            finish();
            return;
        }
        try {
            uri = getIntent().getData();
        } catch (Exception e) {
            e.printStackTrace();
            uri = null;
        }
        xxIXOIIO.IXxxXO("openSDK_LOG.AuthActivity", "-->onCreate, uri: " + uri);
        try {
            oIX0oI(uri);
        } catch (Exception e2) {
            e2.printStackTrace();
            finish();
        }
    }
}
