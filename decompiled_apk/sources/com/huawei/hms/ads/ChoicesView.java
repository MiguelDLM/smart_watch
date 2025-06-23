package com.huawei.hms.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.base.R;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class ChoicesView extends ImageView {

    /* renamed from: com.huawei.hms.ads.ChoicesView$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ String Code;

        /* renamed from: com.huawei.hms.ads.ChoicesView$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C06231 implements RemoteCallResultCallback<String> {
            public C06231() {
            }

            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                String data = callResult.getData();
                SourceParam sourceParam = new SourceParam();
                sourceParam.I(data);
                com.huawei.openalliance.ad.utils.z.Code(ChoicesView.this.getContext(), sourceParam, new com.huawei.openalliance.ad.utils.an() { // from class: com.huawei.hms.ads.ChoicesView.1.1.1
                    @Override // com.huawei.openalliance.ad.utils.an
                    public void Code() {
                        fb.Code("ChoicesView", "download icon fail, use local icon");
                        com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.ChoicesView.1.1.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ChoicesView.this.I();
                            }
                        });
                    }

                    @Override // com.huawei.openalliance.ad.utils.an
                    public void Code(String str2, final Drawable drawable) {
                        if (drawable != null) {
                            com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.ChoicesView.1.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ChoicesView.this.setImageDrawable(drawable);
                                }
                            });
                        }
                    }
                });
            }
        }

        public AnonymousClass1(String str) {
            this.Code = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SourceParam sourceParam = new SourceParam();
            sourceParam.V(false);
            sourceParam.I(true);
            sourceParam.Code(com.huawei.openalliance.ad.constant.x.i);
            sourceParam.I(this.Code);
            sourceParam.I(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("content", com.huawei.openalliance.ad.utils.aa.V(sourceParam));
                com.huawei.openalliance.ad.ipc.g.V(ChoicesView.this.getContext()).Code(com.huawei.openalliance.ad.constant.s.L, jSONObject.toString(), new C06231(), String.class);
            } catch (JSONException unused) {
                fb.I("ChoicesView", "load ad choice icon jsonex");
            }
        }
    }

    public ChoicesView(Context context) {
        super(context, null);
        Code();
    }

    public void Code() {
        Resources resources = getContext().getResources();
        int i = R.dimen.hiad_24_dp;
        int dimensionPixelSize = resources.getDimensionPixelSize(i);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(i);
        fb.Code("ChoicesView", "adChoiceViewWidth = %s", Integer.valueOf(dimensionPixelSize));
        setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2));
        setImageResource(R.drawable.hiad_hm_info);
    }

    public void I() {
        setImageResource(R.drawable.hiad_choices_adchoice);
    }

    public void V() {
        setImageResource(R.drawable.hiad_hm_close_btn);
    }

    public void setAdChoiceIcon(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        fb.Code("ChoicesView", "updateIcon from server.");
        com.huawei.openalliance.ad.utils.h.V(new AnonymousClass1(str));
    }

    @GlobalApi
    public ChoicesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code();
    }

    public void Code(int i) {
        fb.Code("ChoicesView", "changeChoiceViewSize dp = %s", Integer.valueOf(i));
        Resources resources = getContext().getResources();
        setLayoutParams(new RelativeLayout.LayoutParams(resources.getDimensionPixelSize(i), resources.getDimensionPixelSize(i)));
    }

    @GlobalApi
    public ChoicesView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code();
    }

    @GlobalApi
    public ChoicesView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Code();
    }
}
