package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.fs;
import com.huawei.hms.ads.ft;
import com.huawei.openalliance.ad.inter.data.l;

/* loaded from: classes10.dex */
public abstract class NativeMediaView extends AutoScaleSizeRelativeLayout {
    private static final String S = "NativeMediaView";
    protected l B;
    protected fs C;
    private ft D;
    boolean I;
    boolean V;

    public NativeMediaView(Context context) {
        super(context);
        this.V = false;
        this.I = false;
        this.C = new fs(this) { // from class: com.huawei.openalliance.ad.views.NativeMediaView.1
            @Override // com.huawei.hms.ads.fs
            public void Code() {
                NativeMediaView.this.Code();
            }

            @Override // com.huawei.hms.ads.fs
            public void Code(int i) {
                NativeMediaView.this.Code(i);
            }

            @Override // com.huawei.hms.ads.fs
            public void Code(long j, int i) {
                NativeMediaView.this.Code(0);
            }
        };
    }

    public void B() {
    }

    public void Code() {
    }

    public void I() {
    }

    public void V() {
    }

    public int getAutoPlayAreaPercentageThresshold() {
        return 100;
    }

    public int getHiddenAreaPercentageThreshhold() {
        return 10;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fs fsVar = this.C;
        if (fsVar != null) {
            fsVar.D();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fs fsVar = this.C;
        if (fsVar != null) {
            fsVar.L();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        fs fsVar = this.C;
        if (fsVar != null) {
            fsVar.a();
        }
    }

    public void setNativeAd(com.huawei.openalliance.ad.inter.data.g gVar) {
        this.B = gVar instanceof l ? (l) gVar : null;
    }

    public void setViewShowAreaListener(ft ftVar) {
        this.D = ftVar;
    }

    public NativeMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.V = false;
        this.I = false;
        this.C = new fs(this) { // from class: com.huawei.openalliance.ad.views.NativeMediaView.1
            @Override // com.huawei.hms.ads.fs
            public void Code() {
                NativeMediaView.this.Code();
            }

            @Override // com.huawei.hms.ads.fs
            public void Code(int i) {
                NativeMediaView.this.Code(i);
            }

            @Override // com.huawei.hms.ads.fs
            public void Code(long j, int i) {
                NativeMediaView.this.Code(0);
            }
        };
    }

    public void Code(int i) {
        String str = S;
        fb.V(str, "visiblePercentage is " + i);
        ft ftVar = this.D;
        if (ftVar != null) {
            ftVar.Code(i);
        }
        if (i >= getAutoPlayAreaPercentageThresshold()) {
            this.I = false;
            if (this.V) {
                return;
            }
            this.V = true;
            V();
            return;
        }
        this.V = false;
        int hiddenAreaPercentageThreshhold = getHiddenAreaPercentageThreshhold();
        fb.V(str, "HiddenAreaPercentageThreshhold is " + hiddenAreaPercentageThreshhold);
        if (i > 100 - hiddenAreaPercentageThreshhold) {
            if (this.I) {
                B();
            }
            this.I = false;
        } else {
            if (this.I) {
                return;
            }
            this.I = true;
            I();
        }
    }

    public NativeMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.V = false;
        this.I = false;
        this.C = new fs(this) { // from class: com.huawei.openalliance.ad.views.NativeMediaView.1
            @Override // com.huawei.hms.ads.fs
            public void Code() {
                NativeMediaView.this.Code();
            }

            @Override // com.huawei.hms.ads.fs
            public void Code(int i2) {
                NativeMediaView.this.Code(i2);
            }

            @Override // com.huawei.hms.ads.fs
            public void Code(long j, int i2) {
                NativeMediaView.this.Code(0);
            }
        };
    }
}
