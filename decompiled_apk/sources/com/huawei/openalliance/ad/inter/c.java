package com.huawei.openalliance.ad.inter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.ads.cy;
import com.huawei.hms.ads.ed;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.jd;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.constant.w;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.k;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.bh;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class c extends BroadcastReceiver {
    private ed F;
    private Context S;

    public c(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.S = applicationContext;
        this.F = ed.Code(applicationContext);
    }

    private void V(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("splash_skip_area");
        String optString = jSONObject.optString(bb.J);
        if (fb.Code()) {
            fb.Code("ExLinkedSplashReceiver", "splashSkipArea=%s", Integer.valueOf(optInt));
            fb.Code("ExLinkedSplashReceiver", "globalSwitch=%s", bh.Code(optString));
        }
        ed edVar = this.F;
        if (edVar != null) {
            edVar.C(optInt);
            this.F.I(optString);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        Log.d("ExLinkedSplashReceiver", "onReceive.");
        if (intent == null) {
            return;
        }
        try {
            if (x.bq.equals(intent.getAction())) {
                fb.V("ExLinkedSplashReceiver", "receiver exlinkedsplash action");
                long longExtra = intent.getLongExtra(w.Y, 0L);
                Long valueOf = Long.valueOf(longExtra);
                int intExtra = intent.getIntExtra(w.aa, 0);
                String stringExtra = intent.getStringExtra(w.ab);
                String stringExtra2 = intent.getStringExtra("linked_content_slotId");
                int intExtra2 = intent.getIntExtra(w.ac, 0);
                fb.Code("ExLinkedSplashReceiver", "ExLinkedSplashReceiver, startTime: %s, showTime: %s, contentId: %s", valueOf, Integer.valueOf(intExtra), stringExtra);
                context.removeStickyBroadcast(intent);
                ed edVar = this.F;
                if (edVar != null) {
                    edVar.V(longExtra);
                    this.F.Z(intExtra);
                    this.F.V(stringExtra);
                    this.F.B(intExtra2);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("content_id", stringExtra);
                jSONObject.put(bb.G, this.S.getPackageName());
                jSONObject.put(bb.H, false);
                if (!TextUtils.isEmpty(stringExtra2)) {
                    jSONObject.put("slotid", stringExtra2);
                }
                com.huawei.openalliance.ad.ipc.d.Code(context).Code("reqLinkedVideo", jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.c.1
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        if (callResult.getCode() != 200) {
                            fb.I("ExLinkedSplashReceiver", "call reqExLinked failed");
                            c.this.Code();
                            return;
                        }
                        fb.V("ExLinkedSplashReceiver", "reqExLinkedVideo success");
                        try {
                            final AdContentData Code = c.this.Code(new JSONObject(callResult.getData()));
                            if (Code != null) {
                                Code.C(true);
                                final k Code2 = jd.Code(Code);
                                Code2.Code(true);
                                final com.huawei.openalliance.ad.inter.listeners.f C = g.Code(context).C();
                                if (C != null) {
                                    com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.openalliance.ad.inter.c.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            String str2;
                                            String str3;
                                            boolean Code3 = C.Code(Code2);
                                            fb.V("ExLinkedSplashReceiver", "onReceive, isCanDisplay: %s", Boolean.valueOf(Code3));
                                            if (Code3) {
                                                return;
                                            }
                                            fb.I("ExLinkedSplashReceiver", "isCanDisplay false, start show normal splash. ");
                                            c.this.Code();
                                            k kVar = Code2;
                                            if (kVar != null) {
                                                str3 = kVar.a();
                                                str2 = Code2.o();
                                            } else {
                                                str2 = null;
                                                str3 = null;
                                            }
                                            cy.Code(context, str2, str3, 0L, Code, "82");
                                        }
                                    });
                                    return;
                                }
                                fb.I("ExLinkedSplashReceiver", "exSplashCallback is null");
                            } else {
                                fb.I("ExLinkedSplashReceiver", "content is null");
                            }
                            c.this.Code();
                        } catch (JSONException unused) {
                            fb.I("ExLinkedSplashReceiver", "reqLinkedVideo onRemoteCallResult JSONException ");
                        }
                    }
                }, String.class);
            }
        } catch (JSONException unused) {
            fb.I("ExLinkedSplashReceiver", "reqExLinkedVideo JSONException");
            Code();
        } catch (Throwable th) {
            fb.I("ExLinkedSplashReceiver", "reqLinkedVideo exception: %s", th.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdContentData Code(JSONObject jSONObject) {
        String optString;
        AdContentData adContentData;
        AdContentData adContentData2 = null;
        try {
            optString = jSONObject.optString("contentRecord");
            adContentData = (AdContentData) aa.V(optString, AdContentData.class, new Class[0]);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (fb.Code()) {
                fb.Code("ExLinkedSplashReceiver", " adContent content=%s", bh.Code(optString));
            }
            if (adContentData == null) {
                return adContentData;
            }
            V(jSONObject);
            return adContentData;
        } catch (Throwable th2) {
            th = th2;
            adContentData2 = adContentData;
            fb.I("ExLinkedSplashReceiver", "handleResponse exception: %s", th.getClass().getSimpleName());
            return adContentData2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code() {
        com.huawei.openalliance.ad.ipc.d.Code(this.S).Code("showSplash", null, null, null);
    }
}
