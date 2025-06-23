package com.tencent.connect.common;

import OoOoXO0.xoXoI;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import org.apache.log4j.spi.LocationInfo;
import org.json.JSONObject;
import xoX.OOXIXo;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class AssistActivity extends Activity {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final String f26716IIXOooo = "openSDK_LOG.AssistActivity.ExtraIntent";

    /* renamed from: IXxxXO, reason: collision with root package name */
    public String f26717IXxxXO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public II0xO0 f26719Oxx0xo;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f26722oI0IIXIo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f26721XO = false;

    /* renamed from: Oo, reason: collision with root package name */
    public boolean f26718Oo = false;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public Handler f26720OxxIIOOXO = new oIX0oI();

    /* loaded from: classes13.dex */
    public class II0xO0 extends BroadcastReceiver {
        public II0xO0() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str = xoXoI.f2670oxoX;
            Uri uri = (Uri) intent.getParcelableExtra("uriData");
            Intent intent2 = new Intent();
            try {
                String uri2 = uri.toString();
                if (!uri2.contains(xoXoI.f2670oxoX)) {
                    str = LocationInfo.NA;
                }
                for (String str2 : uri2.substring(uri2.indexOf(str) + 1).split("&")) {
                    String[] split = str2.split("=");
                    intent2.putExtra(split[0], split[1]);
                }
            } catch (Exception e) {
                xxIXOIIO.oOoXoXO("openSDK_LOG.AssistActivity", "QQStayReceiver parse uri error : " + e.getMessage());
            }
            intent2.putExtra(com.tencent.connect.common.II0xO0.f26845oOo, "action_share");
            intent2.setData(uri);
            AssistActivity.this.setResult(-1, intent2);
        }

        public /* synthetic */ II0xO0(AssistActivity assistActivity, oIX0oI oix0oi) {
            this();
        }
    }

    /* loaded from: classes13.dex */
    public class oIX0oI extends Handler {
        public oIX0oI() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && !AssistActivity.this.isFinishing()) {
                xxIXOIIO.oI0IIXIo("openSDK_LOG.AssistActivity", "-->finish by timeout");
                AssistActivity.this.finish();
            }
        }
    }

    public static Intent I0Io(Context context) {
        return new Intent(context, (Class<?>) AssistActivity.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void II0xO0(android.os.Bundle r13) {
        /*
            r12 = this;
            java.lang.String r0 = "viaShareType"
            java.lang.String r8 = r13.getString(r0)
            java.lang.String r0 = "callbackAction"
            java.lang.String r0 = r13.getString(r0)
            java.lang.String r1 = "url"
            java.lang.String r1 = r13.getString(r1)
            java.lang.String r2 = "openId"
            java.lang.String r2 = r13.getString(r2)
            java.lang.String r3 = "appId"
            java.lang.String r3 = r13.getString(r3)
            java.lang.String r13 = "shareToQQ"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L30
            java.lang.String r13 = "ANDROIDQQ.SHARETOQQ.XX"
            java.lang.String r4 = "10"
        L2d:
            r5 = r4
            r4 = r13
            goto L42
        L30:
            java.lang.String r13 = "shareToQzone"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L3e
            java.lang.String r13 = "ANDROIDQQ.SHARETOQZ.XX"
            java.lang.String r4 = "11"
            goto L2d
        L3e:
            java.lang.String r13 = ""
            r4 = r13
            r5 = r4
        L42:
            boolean r13 = com.tencent.open.utils.II0xO0.x0xO0oo(r12, r1)
            if (r13 != 0) goto L74
            com.tencent.connect.common.I0Io r13 = com.tencent.connect.common.I0Io.II0xO0()
            o0Oo.II0xO0 r13 = r13.I0Io(r0)
            if (r13 == 0) goto L5f
            o0Oo.I0Io r0 = new o0Oo.I0Io
            java.lang.String r1 = "打开浏览器失败!"
            r6 = 0
            r7 = -6
            r0.<init>(r7, r1, r6)
            r13.oIX0oI(r0)
        L5f:
            xoX.OOXIXo r1 = xoX.OOXIXo.oIX0oI()
            java.lang.String r10 = "2"
            java.lang.String r11 = "0"
            java.lang.String r6 = "3"
            java.lang.String r7 = "1"
            java.lang.String r9 = "0"
            r1.X0o0xo(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r12.finish()
            goto L85
        L74:
            xoX.OOXIXo r1 = xoX.OOXIXo.oIX0oI()
            java.lang.String r10 = "2"
            java.lang.String r11 = "0"
            java.lang.String r6 = "3"
            java.lang.String r7 = "0"
            java.lang.String r9 = "0"
            r1.X0o0xo(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
        L85:
            android.content.Intent r13 = r12.getIntent()
            java.lang.String r0 = "shareH5"
            r13.removeExtra(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.common.AssistActivity.II0xO0(android.os.Bundle):void");
    }

    public void X0o0xo(int i, Intent intent) {
        if (intent == null) {
            xxIXOIIO.oI0IIXIo("openSDK_LOG.AssistActivity", "--setResultData--intent is null, setResult ACTIVITY_CANCEL");
            setResult(0);
            if (i == 11101) {
                OOXIXo.oIX0oI().I0Io("", this.f26717IXxxXO, "2", "1", "7", "2");
                return;
            }
            return;
        }
        try {
            String stringExtra = intent.getStringExtra(com.tencent.connect.common.II0xO0.f26765O0X);
            xxIXOIIO.XO("openSDK_LOG.AssistActivity", "--setResultDataForLogin-- ");
            if (!TextUtils.isEmpty(stringExtra)) {
                JSONObject jSONObject = new JSONObject(stringExtra);
                String optString = jSONObject.optString("openid");
                String optString2 = jSONObject.optString("access_token");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    xxIXOIIO.oOoXoXO("openSDK_LOG.AssistActivity", "--setResultData--openid and token not empty, setResult ACTIVITY_OK");
                    setResult(-1, intent);
                    OOXIXo.oIX0oI().I0Io(optString, this.f26717IXxxXO, "2", "1", "7", "0");
                } else {
                    xxIXOIIO.oI0IIXIo("openSDK_LOG.AssistActivity", "--setResultData--openid or token is empty, setResult ACTIVITY_CANCEL");
                    setResult(0, intent);
                    OOXIXo.oIX0oI().I0Io("", this.f26717IXxxXO, "2", "1", "7", "1");
                }
            } else {
                xxIXOIIO.oI0IIXIo("openSDK_LOG.AssistActivity", "--setResultData--response is empty, setResult ACTIVITY_OK");
                setResult(-1, intent);
            }
        } catch (Exception e) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.AssistActivity", "--setResultData--parse response failed");
            e.printStackTrace();
        }
    }

    public final int oIX0oI() {
        if (getWindowManager() == null) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.AssistActivity", "--getRotation-- getWindowManager() == null");
            return 0;
        }
        if (getWindowManager().getDefaultDisplay() == null) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.AssistActivity", "--getRotation-- etWindowManager().getDefaultDisplay() == null");
            return 0;
        }
        return getWindowManager().getDefaultDisplay().getRotation();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        sb.append("--onActivityResult--requestCode: ");
        sb.append(i);
        sb.append(" | resultCode: ");
        sb.append(i2);
        sb.append("data = null ? ");
        if (intent == null) {
            z = true;
        } else {
            z = false;
        }
        sb.append(z);
        xxIXOIIO.oOoXoXO("openSDK_LOG.AssistActivity", sb.toString());
        super.onActivityResult(i, i2, intent);
        if (i == 0) {
            return;
        }
        if (intent != null) {
            intent.putExtra(com.tencent.connect.common.II0xO0.f26845oOo, "action_login");
        }
        X0o0xo(i, intent);
        try {
            oxoX();
        } catch (Exception e) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.AssistActivity", "restoreEnterOrientation error : " + e.getMessage());
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        int intExtra;
        String stringExtra;
        getWindow().addFlags(67108864);
        requestWindowFeature(1);
        super.onCreate(bundle);
        this.f26722oI0IIXIo = oIX0oI();
        try {
            setRequestedOrientation(3);
        } catch (Exception e) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.AssistActivity", "onCreate setRequestedOrientation error : " + e.getMessage());
        }
        xxIXOIIO.oOoXoXO("openSDK_LOG.AssistActivity", "--onCreate--");
        if (getIntent() == null) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.AssistActivity", "-->onCreate--getIntent() returns null");
            finish();
        }
        Intent intent = (Intent) getIntent().getParcelableExtra(f26716IIXOooo);
        if (intent == null) {
            intExtra = 0;
        } else {
            intExtra = intent.getIntExtra(com.tencent.connect.common.II0xO0.f26911xxX, 0);
        }
        if (intent == null) {
            stringExtra = "";
        } else {
            stringExtra = intent.getStringExtra("appid");
        }
        this.f26717IXxxXO = stringExtra;
        Bundle bundleExtra = getIntent().getBundleExtra("h5_share_data");
        if (bundle != null) {
            this.f26721XO = bundle.getBoolean("RESTART_FLAG");
            this.f26718Oo = bundle.getBoolean("RESUME_FLAG", false);
        }
        if (!this.f26721XO) {
            if (bundleExtra == null) {
                if (intent != null) {
                    xxIXOIIO.oOoXoXO("openSDK_LOG.AssistActivity", "--onCreate--activityIntent not null, will start activity, reqcode = " + intExtra);
                    try {
                        IntentFilter intentFilter = new IntentFilter(com.tencent.connect.common.II0xO0.f26830XxIo + intent.getData().getQueryParameter("share_id"));
                        if (this.f26719Oxx0xo == null) {
                            this.f26719Oxx0xo = new II0xO0(this, null);
                        }
                        registerReceiver(this.f26719Oxx0xo, intentFilter);
                    } catch (Exception e2) {
                        xxIXOIIO.oOoXoXO("openSDK_LOG.AssistActivity", "registerReceiver exception : " + e2.getMessage());
                    }
                    startActivityForResult(intent, intExtra);
                    return;
                }
                xxIXOIIO.II0XooXoX("openSDK_LOG.AssistActivity", "--onCreate--activityIntent is null");
                finish();
                return;
            }
            xxIXOIIO.oI0IIXIo("openSDK_LOG.AssistActivity", "--onCreate--h5 bundle not null, will open browser");
            II0xO0(bundleExtra);
            return;
        }
        xxIXOIIO.XO("openSDK_LOG.AssistActivity", "is restart");
    }

    @Override // android.app.Activity
    public void onDestroy() {
        xxIXOIIO.oOoXoXO("openSDK_LOG.AssistActivity", "-->onDestroy");
        super.onDestroy();
        II0xO0 iI0xO0 = this.f26719Oxx0xo;
        if (iI0xO0 != null) {
            unregisterReceiver(iI0xO0);
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.AssistActivity", "--onNewIntent");
        super.onNewIntent(intent);
        int intExtra = intent.getIntExtra(com.tencent.connect.common.II0xO0.f26911xxX, -1);
        if (intExtra == 10108) {
            intent.putExtra(com.tencent.connect.common.II0xO0.f26845oOo, "action_request_avatar");
            if (intent.getBooleanExtra(com.tencent.connect.common.II0xO0.f26907xx0X0, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (!isFinishing()) {
                finish();
                return;
            }
            return;
        }
        if (intExtra == 10109) {
            intent.putExtra(com.tencent.connect.common.II0xO0.f26845oOo, "action_request_set_emotion");
            if (intent.getBooleanExtra(com.tencent.connect.common.II0xO0.f26907xx0X0, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (!isFinishing()) {
                finish();
                return;
            }
            return;
        }
        if (intExtra == 10110) {
            intent.putExtra(com.tencent.connect.common.II0xO0.f26845oOo, "action_request_dynamic_avatar");
            if (intent.getBooleanExtra(com.tencent.connect.common.II0xO0.f26907xx0X0, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (!isFinishing()) {
                finish();
                return;
            }
            return;
        }
        if (intExtra == 10111) {
            intent.putExtra(com.tencent.connect.common.II0xO0.f26845oOo, "joinGroup");
            if (intent.getBooleanExtra(com.tencent.connect.common.II0xO0.f26907xx0X0, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (!isFinishing()) {
                finish();
                return;
            }
            return;
        }
        if (intExtra == 10112) {
            intent.putExtra(com.tencent.connect.common.II0xO0.f26845oOo, "bindGroup");
            if (intent.getBooleanExtra(com.tencent.connect.common.II0xO0.f26907xx0X0, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (!isFinishing()) {
                finish();
                return;
            }
            return;
        }
        intent.putExtra(com.tencent.connect.common.II0xO0.f26845oOo, "action_share");
        setResult(-1, intent);
        if (!isFinishing()) {
            xxIXOIIO.oOoXoXO("openSDK_LOG.AssistActivity", "--onNewIntent--activity not finished, finish now");
            finish();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        xxIXOIIO.oOoXoXO("openSDK_LOG.AssistActivity", "-->onPause");
        this.f26720OxxIIOOXO.removeMessages(0);
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        xxIXOIIO.oOoXoXO("openSDK_LOG.AssistActivity", "-->onResume");
        super.onResume();
        Intent intent = getIntent();
        if (intent.getBooleanExtra("is_login", false)) {
            return;
        }
        if (!intent.getBooleanExtra("is_qq_mobile_share", false) && this.f26721XO && !isFinishing()) {
            finish();
        }
        if (this.f26718Oo) {
            this.f26720OxxIIOOXO.sendMessage(this.f26720OxxIIOOXO.obtainMessage(0));
        } else {
            this.f26718Oo = true;
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.AssistActivity", "--onSaveInstanceState--");
        bundle.putBoolean("RESTART_FLAG", true);
        bundle.putBoolean("RESUME_FLAG", this.f26718Oo);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onStart() {
        xxIXOIIO.oOoXoXO("openSDK_LOG.AssistActivity", "-->onStart");
        super.onStart();
    }

    @Override // android.app.Activity
    public void onStop() {
        xxIXOIIO.oOoXoXO("openSDK_LOG.AssistActivity", "-->onStop");
        super.onStop();
    }

    public void oxoX() {
        xxIXOIIO.oOoXoXO("openSDK_LOG.AssistActivity", "--restoreEnterOrientation--mEnterRotation: " + this.f26722oI0IIXIo);
        int i = this.f26722oI0IIXIo;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    setRequestedOrientation(1);
                    return;
                } else {
                    setRequestedOrientation(8);
                    return;
                }
            }
            setRequestedOrientation(9);
            return;
        }
        setRequestedOrientation(0);
    }
}
