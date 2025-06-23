package com.huawei.openalliance.ad.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.huawei.hms.ads.AdFeedbackListener;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.cy;
import com.huawei.hms.ads.dg;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.jc;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.activity.a;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.feedback.FeedbackView;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.q;
import com.huawei.openalliance.ad.utils.w;
import java.lang.ref.WeakReference;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@AllApi
/* loaded from: classes10.dex */
public class FeedbackActivity extends com.huawei.openalliance.ad.activity.a implements com.huawei.openalliance.ad.compliance.a {
    private static WeakReference<Context> p;
    private static a r;
    private int s;
    private static Map<Integer, AdFeedbackListener> n = new HashMap();
    private static Map<Integer, AdFeedbackListener> o = new HashMap();
    private static SecureRandom q = new SecureRandom();

    /* loaded from: classes10.dex */
    public static class a extends BroadcastReceiver {
        private String Code;
        private WeakReference<FeedbackActivity> V;

        public a(String str, FeedbackActivity feedbackActivity) {
            this.Code = str;
            this.V = new WeakReference<>(feedbackActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            FeedbackActivity feedbackActivity = this.V.get();
            if (feedbackActivity == null) {
                str = "activity is null";
            } else {
                String action = new SafeIntent(intent).getAction();
                if (!ay.Code(action)) {
                    if (action.equals(x.dx + this.Code)) {
                        feedbackActivity.L();
                        context.unregisterReceiver(FeedbackActivity.r);
                        return;
                    }
                    if (action.equals(x.dy + this.Code)) {
                        context.unregisterReceiver(FeedbackActivity.r);
                        feedbackActivity.finish();
                        return;
                    }
                    return;
                }
                str = "action is null";
            }
            fb.I("FeedbackActivity", str);
        }
    }

    private a Code(Context context, String str) {
        a aVar = new a(str, this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(x.dx + str);
        intentFilter.addAction(x.dy + str);
        w.Code(context, aVar, intentFilter, w.i(getApplicationContext()), null);
        return aVar;
    }

    private void D() {
        this.i.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.activity.FeedbackActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    FeedbackActivity feedbackActivity = FeedbackActivity.this;
                    cy.Code(feedbackActivity, feedbackActivity.b, "3");
                } catch (Throwable th) {
                    fb.I("FeedbackActivity", "onClick error: %s", th.getClass().getSimpleName());
                }
                FeedbackActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        FeedbackInfo feedbackInfo;
        List<FeedbackInfo> aC = this.b.aC();
        if (!ad.Code(aC)) {
            Iterator<FeedbackInfo> it = aC.iterator();
            while (it.hasNext()) {
                feedbackInfo = it.next();
                if (3 == feedbackInfo.V()) {
                    break;
                }
            }
        }
        feedbackInfo = null;
        if (feedbackInfo != null) {
            Code(3, feedbackInfo);
        }
    }

    @Override // com.huawei.openalliance.ad.activity.a
    public boolean B() {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.b = (AdContentData) safeIntent.getSerializableExtra(bb.aU);
        this.s = safeIntent.getIntExtra(bb.aJ, 0);
        if (this.b == null) {
            return false;
        }
        return super.B();
    }

    @Override // com.huawei.openalliance.ad.activity.a
    public void I() {
        C();
        this.e.Code(this.L, this.f17369a);
        this.e.setAdContentData(this.b);
        this.e.setFeedbackListener(this);
    }

    @Override // com.huawei.openalliance.ad.activity.a
    public int V() {
        return R.layout.hiad_activity_feedback;
    }

    @Override // com.huawei.openalliance.ad.activity.a
    public void Z() {
        Code(o.get(Integer.valueOf(this.s)));
    }

    @Override // com.huawei.openalliance.ad.activity.a, com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            D();
            cy.Code(this, this.b, "0");
            WeakReference<Context> weakReference = p;
            if (weakReference != null) {
                bc.Code(this, weakReference.get());
            }
            AdContentData adContentData = this.b;
            if (adContentData != null) {
                r = Code(this, adContentData.L());
            }
            fb.V("FeedbackActivity", "onCreate: %s, instance: %s", Integer.valueOf(hashCode()), Integer.valueOf(this.s));
        } catch (Throwable th) {
            fb.I("FeedbackActivity", "onCreate error: %s", th.getClass().getSimpleName());
            Code(o.get(Integer.valueOf(this.s)));
            finish();
        }
    }

    @Override // com.huawei.openalliance.ad.activity.a, com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        dg.Code(null);
        fb.V("FeedbackActivity", "onDestroy %s, instance: %s", Integer.valueOf(hashCode()), Integer.valueOf(this.s));
        Code(this.s);
    }

    @Override // com.huawei.openalliance.ad.activity.a
    public void Code() {
        this.i = (RelativeLayout) findViewById(R.id.feedback_activity_root);
        this.j = findViewById(R.id.margin_view);
        this.k = findViewById(R.id.feedback_anchor_view);
        this.c = (FeedbackView) findViewById(R.id.top_feedback_view);
        this.f = (ImageView) findViewById(R.id.top_feedback_iv);
        this.d = (FeedbackView) findViewById(R.id.bottom_feedback_view);
        this.g = (ImageView) findViewById(R.id.bottom_feedback_iv);
    }

    private static void Code(int i) {
        n.remove(Integer.valueOf(i));
        o.remove(Integer.valueOf(i));
    }

    @Override // com.huawei.openalliance.ad.compliance.a
    public void Code(int i, FeedbackInfo feedbackInfo) {
        ArrayList arrayList;
        fb.V("FeedbackActivity", "action type: %s", Integer.valueOf(i));
        try {
            arrayList = new ArrayList();
            arrayList.add(feedbackInfo);
        } catch (Throwable th) {
            fb.I("FeedbackActivity", "itemClickAction error: %s", th.getClass().getSimpleName());
        }
        if (i != 1) {
            if (i == 2) {
                Code(arrayList);
            } else if (i != 3) {
                fb.Code("FeedbackActivity", "invalid feedback type");
            }
            finish();
        }
        Code(i, arrayList);
        finish();
    }

    private void Code(int i, List<FeedbackInfo> list) {
        Toast.makeText(getApplicationContext(), R.string.hiad_feedback_reduce_such_content, 0).show();
        jc.Code(this, this.b, list, 1);
        cy.Code(this, this.b, 1 == i ? "2" : "4");
        AdFeedbackListener adFeedbackListener = n.get(Integer.valueOf(this.s));
        AdFeedbackListener adFeedbackListener2 = o.get(Integer.valueOf(this.s));
        fb.V("FeedbackActivity", "neg, innerListener: %s, listener: %s", Boolean.valueOf(adFeedbackListener != null), Boolean.valueOf(adFeedbackListener2 != null));
        if (adFeedbackListener != null) {
            adFeedbackListener.onAdDisliked();
        }
        if (adFeedbackListener2 != null) {
            adFeedbackListener2.onAdDisliked();
        }
    }

    public static void Code(Context context, com.huawei.openalliance.ad.feedback.a aVar) {
        if (aVar == null) {
            return;
        }
        if (q.Code()) {
            fb.V("FeedbackActivity", "fast click");
            return;
        }
        l Code = dg.Code();
        if (Code == null) {
            fb.V("FeedbackActivity", "nativeAd is null");
            return;
        }
        AdFeedbackListener V = aVar.V();
        AdFeedbackListener I = aVar.I();
        AdContentData n2 = Code.n();
        if (n2 == null || aVar.Code() == null || !q.Code(n2.aC()) || V == null) {
            fb.Z("FeedbackActivity", "startFeedbackActivity fail: invalid parameter.");
            Code(I);
            return;
        }
        int nextInt = q.nextInt(Integer.MAX_VALUE);
        n.put(Integer.valueOf(nextInt), V);
        o.put(Integer.valueOf(nextInt), I);
        try {
            View Code2 = aVar.Code();
            int[] iArr = new int[2];
            p = new WeakReference<>(Code2.getContext());
            Code2.getLocationInWindow(iArr);
            fb.V("FeedbackActivity", "startFeedbackActivity, anchorView.getLocationInWindow [x,y]= %d, %d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
            int[] iArr2 = new int[2];
            Code2.getLocationOnScreen(iArr2);
            int[] iArr3 = {Code2.getMeasuredWidth(), Code2.getMeasuredHeight()};
            Code2.getViewTreeObserver().addOnGlobalLayoutListener(new a.ViewTreeObserverOnGlobalLayoutListenerC0658a(Code2, context, iArr2));
            Intent intent = new Intent(context, (Class<?>) FeedbackActivity.class);
            intent.putExtra(bb.av, iArr);
            intent.putExtra(bb.ay, iArr3);
            intent.setFlags(65536);
            intent.putExtra(bb.aU, Code.n());
            intent.putExtra(bb.aJ, nextInt);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.setClipData(x.cM);
            context.startActivity(intent);
        } catch (Throwable th) {
            fb.I("FeedbackActivity", "startFeedbackActivity error: %s", th.getClass().getSimpleName());
            Code(I);
            Code(nextInt);
        }
    }

    private static void Code(AdFeedbackListener adFeedbackListener) {
        if (adFeedbackListener != null) {
            adFeedbackListener.onAdFeedbackShowFailed();
        }
    }

    private void Code(List<FeedbackInfo> list) {
        Toast.makeText(getApplicationContext(), R.string.hiad_feedback_had_feedback, 0).show();
        jc.Code(this, this.b, list, 2);
        cy.Code(this, this.b, "1");
        AdFeedbackListener adFeedbackListener = n.get(Integer.valueOf(this.s));
        AdFeedbackListener adFeedbackListener2 = o.get(Integer.valueOf(this.s));
        fb.V("FeedbackActivity", "pos, innerListener: %s, listener: %s", Boolean.valueOf(adFeedbackListener != null), Boolean.valueOf(adFeedbackListener2 != null));
        if (adFeedbackListener != null) {
            adFeedbackListener.onAdLiked();
        }
        if (adFeedbackListener2 != null) {
            adFeedbackListener2.onAdLiked();
        }
    }
}
