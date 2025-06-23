package com.baidu.mobads.sdk.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.bb;
import com.baidu.mobads.sdk.internal.bv;
import com.baidu.mobads.sdk.internal.ct;
import com.baidu.mobads.sdk.internal.cu;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes7.dex */
public final class AdView extends RelativeLayout {
    private static final boolean AUTOPLAY = true;
    private static final float HEIGHT_FACTOR = 0.15f;
    protected static final String P_VERSION = "3.61";
    private AtomicBoolean hasCalledRequestMethod;
    private cu mAdProd;

    public AdView(Context context) {
        super(context);
        this.hasCalledRequestMethod = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callRequest() {
        if (!this.hasCalledRequestMethod.get()) {
            this.hasCalledRequestMethod.set(true);
            this.mAdProd.a();
        }
    }

    public void destroy() {
        cu cuVar = this.mAdProd;
        if (cuVar != null) {
            cuVar.e();
        }
    }

    public void setAppSid(String str) {
        cu cuVar = this.mAdProd;
        if (cuVar != null) {
            cuVar.h(str);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        bv.a().a("AdView.setLayoutParams=", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height), Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        DisplayMetrics f = bb.f(getContext());
        int i3 = f.widthPixels;
        int i4 = f.heightPixels;
        float f2 = f.density;
        bv.a().a("AdView.setLayoutParams", Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2));
        if (i <= 0) {
            i = Math.min(i3, i4);
        } else if (i > 0) {
            float f3 = 200.0f * f2;
            if (i < f3) {
                i = (int) f3;
            }
        }
        if (i2 <= 0) {
            i2 = (int) (Math.min(i3, i4) * 0.15f);
        } else if (i2 > 0) {
            float f4 = f2 * 30.0f;
            if (i2 < f4) {
                i2 = (int) f4;
            }
        }
        layoutParams.width = i;
        layoutParams.height = i2;
        cu cuVar = this.mAdProd;
        if (cuVar != null) {
            cuVar.a(i);
            this.mAdProd.c(i2);
        }
        bv.a().a("AdView.setLayoutParams adapter", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        super.setLayoutParams(layoutParams);
    }

    public void setListener(AdViewListener adViewListener) {
        cu cuVar = this.mAdProd;
        if (cuVar != null) {
            cuVar.a(adViewListener);
        }
    }

    public AdView(Context context, String str) {
        this(context, true, AdSize.Banner, str);
    }

    public AdView(Context context, AdSize adSize, String str) {
        this(context, true, adSize, str);
    }

    public AdView(Context context, boolean z, AdSize adSize, String str) {
        this(context, null, z, adSize, str);
    }

    public AdView(Context context, AttributeSet attributeSet, boolean z, AdSize adSize, String str) {
        super(context, attributeSet);
        this.hasCalledRequestMethod = new AtomicBoolean(false);
        ct ctVar = new ct(context);
        this.mAdProd = new cu(this, context, ctVar, str, z);
        ctVar.a(new ct.a() { // from class: com.baidu.mobads.sdk.api.AdView.1
            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onAttachedToWindow() {
                AdView.this.callRequest();
                AdView.this.mAdProd.o();
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            @SuppressLint({"MissingSuperCall"})
            public void onDetachedFromWindow() {
                AdView.this.mAdProd.p();
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public boolean onKeyDown(int i, KeyEvent keyEvent) {
                return AdView.this.mAdProd.a(i, keyEvent);
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onLayoutComplete(int i, int i2) {
                AdView.this.callRequest();
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onWindowFocusChanged(boolean z2) {
                AdView.this.mAdProd.a(z2);
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onWindowVisibilityChanged(int i) {
                AdView.this.mAdProd.b(i);
            }
        });
        addView(ctVar, new ViewGroup.LayoutParams(-1, -1));
    }
}
