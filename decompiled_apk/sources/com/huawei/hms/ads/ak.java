package com.huawei.hms.ads;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.Toast;
import com.huawei.hms.ads.base.R;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.SafeIntent;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class ak extends ag {
    private static a B = null;
    private static final String Z = "JsbFeedBackClick";

    /* loaded from: classes10.dex */
    public class a extends BroadcastReceiver {
        private AdContentData I;
        private FeedbackInfo V;
        private RemoteCallResultCallback<String> Z;

        public a(FeedbackInfo feedbackInfo, AdContentData adContentData, RemoteCallResultCallback<String> remoteCallResultCallback) {
            this.V = feedbackInfo;
            this.I = adContentData;
            this.Z = remoteCallResultCallback;
        }

        private void Code(Context context) {
            if (context == null) {
                fb.I(ak.Z, "context is null");
            } else {
                ag.Code(this.Z, ak.this.Code, 1000, 1, true);
                context.unregisterReceiver(ak.B);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = new SafeIntent(intent).getAction();
            if (com.huawei.openalliance.ad.utils.ay.Code(action)) {
                return;
            }
            fb.V(ak.Z, "complain action %s", action);
            if (action.equals(com.huawei.openalliance.ad.constant.x.dx + this.I.L())) {
                Code(context, this.I, this.V);
                return;
            }
            if (action.equals(com.huawei.openalliance.ad.constant.x.dy + this.I.L())) {
                Code(context);
            }
        }

        private void Code(Context context, AdContentData adContentData, FeedbackInfo feedbackInfo) {
            if (context == null) {
                fb.I(ak.Z, "context is null");
                return;
            }
            ak.V(context, adContentData, 3, feedbackInfo);
            ag.Code(this.Z, ak.this.Code, 1000, 0, true);
            context.unregisterReceiver(ak.B);
        }
    }

    public ak() {
        super(aj.E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a Code(Context context, AdContentData adContentData, FeedbackInfo feedbackInfo, RemoteCallResultCallback<String> remoteCallResultCallback) {
        a aVar = new a(feedbackInfo, adContentData, remoteCallResultCallback);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.huawei.openalliance.ad.constant.x.dx + adContentData.L());
        intentFilter.addAction(com.huawei.openalliance.ad.constant.x.dy + adContentData.L());
        com.huawei.openalliance.ad.utils.w.Code(context, aVar, intentFilter, com.huawei.openalliance.ad.utils.w.i(context.getApplicationContext()), null);
        return aVar;
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        fb.Code(Z, "start");
        final JSONObject jSONObject = new JSONObject(str);
        Code(context, str, true, new ac() { // from class: com.huawei.hms.ads.ak.1
            @Override // com.huawei.hms.ads.ac
            public void Code(AdContentData adContentData) {
                int optInt = jSONObject.optInt(com.huawei.openalliance.ad.constant.aw.aL, -111111);
                if (adContentData == null) {
                    fb.Code(ak.Z, "ad not exist");
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(com.huawei.openalliance.ad.constant.aw.aM);
                FeedbackInfo feedbackInfo = (FeedbackInfo) com.huawei.openalliance.ad.utils.aa.V(optJSONObject.toString(), FeedbackInfo.class, new Class[0]);
                if (feedbackInfo != null) {
                    long Code = com.huawei.openalliance.ad.utils.ay.Code(optJSONObject.optString("id"), -111111L);
                    if (Code == -111111) {
                        fb.V(ak.Z, "invalid id");
                        return;
                    }
                    feedbackInfo.Code(Code);
                    a unused = ak.B = ak.this.Code(context, adContentData, feedbackInfo, (RemoteCallResultCallback<String>) remoteCallResultCallback);
                    if (optInt != 3) {
                        ak.V(context, adContentData, optInt, feedbackInfo);
                    } else {
                        Code(context, adContentData, feedbackInfo);
                    }
                }
            }

            private boolean Code(Context context2, AdContentData adContentData, FeedbackInfo feedbackInfo) {
                fb.V(ak.Z, "click complain");
                if (feedbackInfo == null || context2 == null || adContentData == null) {
                    return false;
                }
                try {
                    Intent intent = new Intent();
                    intent.putExtra(com.huawei.openalliance.ad.constant.bb.G, context2.getPackageName());
                    intent.putExtra("slotid", adContentData.L());
                    intent.putExtra("content_id", adContentData.a());
                    intent.putExtra("apiVer", adContentData.aF());
                    intent.putExtra(com.huawei.openalliance.ad.constant.bb.aB, feedbackInfo.Code());
                    intent.setAction(com.huawei.openalliance.ad.constant.x.cS);
                    intent.setPackage(com.huawei.openalliance.ad.utils.w.Z(context2));
                    if (!(context2 instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    com.huawei.openalliance.ad.utils.bc.Code(context2, intent);
                } catch (Throwable th) {
                    fb.I(ak.Z, "start ac failed: %s", th.getClass().getSimpleName());
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(final Context context, AdContentData adContentData, int i, FeedbackInfo feedbackInfo) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(feedbackInfo);
            if (i == 1) {
                com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.ak.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, R.string.hiad_feedback_reduce_such_content, 0).show();
                    }
                });
                jc.Code(context, adContentData, arrayList, 1);
                return;
            }
            int i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    fb.Code(Z, "invalid feedback type");
                    return;
                }
                com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.ak.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, R.string.hiad_feedback_reduce_such_content, 0).show();
                    }
                });
            } else {
                com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.ak.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, R.string.hiad_feedback_had_feedback, 0).show();
                    }
                });
            }
            jc.Code(context, adContentData, arrayList, i2);
        } catch (Throwable th) {
            fb.I(Z, "itemClickAction error: %s", th.getClass().getSimpleName());
        }
    }
}
