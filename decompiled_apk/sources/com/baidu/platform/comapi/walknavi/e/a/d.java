package com.baidu.platform.comapi.walknavi.e.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.npc.ArBridge;
import com.baidu.ar.npc.BaiduArView;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.huawei.openalliance.ad.constant.aw;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class d implements ArBridge.MessageHandler {

    /* renamed from: a, reason: collision with root package name */
    private Context f9721a;
    private BaiduArView b;
    private com.baidu.platform.comapi.walknavi.e.a.b.a c;
    private boolean d = false;
    private boolean e = false;

    public d(Context context, com.baidu.platform.comapi.walknavi.e.a.b.a aVar) {
        this.f9721a = context.getApplicationContext();
        this.c = aVar;
    }

    public BaiduArView a() {
        if (this.b == null) {
            this.b = new BaiduArView(this.f9721a);
        }
        return this.b;
    }

    public void b() {
        com.baidu.platform.comapi.walknavi.e.a.g.a.a(aw.ag);
        this.d = false;
        BaiduArView baiduArView = this.b;
        if (baiduArView != null) {
            baiduArView.onResume();
        }
    }

    public void c() {
        com.baidu.platform.comapi.walknavi.e.a.g.a.a("resumeByUser");
        this.d = false;
        ArBridge.getInstance().onResumeByUser();
    }

    public void d() {
        com.baidu.platform.comapi.walknavi.e.a.g.a.a("pause");
        this.d = true;
        BaiduArView baiduArView = this.b;
        if (baiduArView != null) {
            baiduArView.onPause();
        }
    }

    public void e() {
        com.baidu.platform.comapi.walknavi.e.a.g.a.a("pauseByUser");
        this.d = true;
        ArBridge.getInstance().onPauseByUser();
    }

    public void f() {
        com.baidu.platform.comapi.walknavi.e.a.g.a.a("destroy");
        this.d = true;
        BaiduArView baiduArView = this.b;
        if (baiduArView != null) {
            baiduArView.onPause();
        }
        ArBridge.getInstance().removeMessageHandeler(this);
        ArBridge.getInstance().destroyCase();
        com.baidu.platform.comapi.walknavi.e.a.e.a.a().a("end_ar");
        new Thread(new e(this)).start();
    }

    @Override // com.baidu.ar.npc.ArBridge.MessageHandler
    public void handleMessage(int i, int i2, HashMap<String, Object> hashMap) {
        com.baidu.platform.comapi.walknavi.e.a.g.a.a("aMessageType = " + i + ", aParams = " + hashMap);
        com.baidu.platform.comapi.walknavi.e.a.b.a aVar = this.c;
        if (aVar == null) {
            com.baidu.platform.comapi.walknavi.e.a.g.a.a("ARCallback is null");
            return;
        }
        if (i != 9) {
            if (i != 1001) {
                if (i != 1003) {
                    if (i != 1005) {
                        if (i != 1007) {
                            if (i == 1901) {
                                if ("animation_end".equalsIgnoreCase(hashMap.get(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE).toString())) {
                                    this.c.a(2, hashMap);
                                    return;
                                } else if ("click".equalsIgnoreCase(hashMap.get(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE).toString())) {
                                    this.c.a(3, hashMap);
                                    return;
                                } else {
                                    if ("animation_failed".equalsIgnoreCase(hashMap.get(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE).toString())) {
                                        this.c.a(8, hashMap);
                                        return;
                                    }
                                    return;
                                }
                            }
                            return;
                        }
                        aVar.a(7, hashMap);
                        return;
                    }
                    aVar.a(6, hashMap);
                    return;
                }
                aVar.a(5, hashMap);
                return;
            }
            aVar.a(4, hashMap);
            return;
        }
        if (hashMap != null) {
            try {
                if (Integer.parseInt(String.valueOf(hashMap.get(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED))) == 1) {
                    this.e = true;
                }
            } catch (Exception e) {
                com.baidu.platform.comapi.walknavi.e.a.g.a.a("MSG_CASE_INIT_COMPLETED error: " + e.getMessage());
            }
        }
        this.c.a(1, hashMap);
    }

    public void a(String str, String str2) {
        com.baidu.platform.comapi.walknavi.e.a.g.a.a("runScript, mIsPaused=" + this.d + ", mInitCompleted=" + this.e);
        if (this.d || !this.e) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.platform.comapi.walknavi.e.a.g.a.a("lua is null");
            return;
        }
        com.baidu.platform.comapi.walknavi.e.a.g.a.a("runScript, lua: " + str);
        ArBridge.getInstance().sendLuaScriptToEngine(str.replace("dfk7fghdsf7d33e", str2));
    }

    public void a(float f, float f2, float f3, String str) {
        com.baidu.platform.comapi.walknavi.e.a.g.a.a("setEuler, mIsPaused=" + this.d + ", mInitCompleted=" + this.e);
        if (this.d || !this.e) {
            return;
        }
        ArBridge.getInstance().setEuler(f, f2, f3, str);
    }

    public void a(float f) {
        com.baidu.platform.comapi.walknavi.e.a.g.a.a("setFrustum, mIsPaused=" + this.d + ", mInitCompleted=" + this.e);
        if (this.d || !this.e) {
            return;
        }
        float width = (a().getWidth() == 0 || a().getHeight() == 0) ? 0.0f : a().getWidth() / a().getHeight();
        com.baidu.platform.comapi.walknavi.e.a.g.a.a("setFrustum, aspect=" + width);
        ArBridge.getInstance().setFrustum(f, width);
    }
}
