package com.huawei.openalliance.ad.views.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.w;
import com.huawei.openalliance.ad.views.PPSBaseDialogContentView;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.huawei.openalliance.ad.views.dsa.DomesticDsaView;

/* loaded from: classes10.dex */
public class PPSTransparencyDialog extends PPSBaseDialog {
    private com.huawei.openalliance.ad.views.dsa.a n;

    /* loaded from: classes10.dex */
    public class a implements com.huawei.openalliance.ad.views.dsa.a {
        private a() {
        }

        @Override // com.huawei.openalliance.ad.views.dsa.a
        public void Code() {
            PPSTransparencyDialog.this.V();
            if (PPSTransparencyDialog.this.n != null) {
                PPSTransparencyDialog.this.n.Code();
            }
        }
    }

    public PPSTransparencyDialog(Context context) {
        super(context);
    }

    private void F() {
        a aVar = new a();
        PPSBaseDialogContentView pPSBaseDialogContentView = this.d;
        if (pPSBaseDialogContentView instanceof DomesticDsaView) {
            ((DomesticDsaView) pPSBaseDialogContentView).setDsaJumpListener(aVar);
        }
        PPSBaseDialogContentView pPSBaseDialogContentView2 = this.c;
        if (pPSBaseDialogContentView2 instanceof DomesticDsaView) {
            ((DomesticDsaView) pPSBaseDialogContentView2).setDsaJumpListener(aVar);
        }
    }

    @Override // com.huawei.openalliance.ad.views.dialog.PPSBaseDialog
    public void I() {
        this.b = 16.0f;
        super.I();
    }

    public void S() {
        V();
    }

    @Override // com.huawei.openalliance.ad.views.dialog.PPSBaseDialog
    public void Z() {
        ImageView imageView;
        float f;
        if (!B()) {
            V();
            return;
        }
        int V = w.V(this.i, 36.0f);
        int i = this.C;
        int i2 = (this.V - i) - V;
        int V2 = ((this.L[0] + this.f17436a[0]) - w.V(this.i, 6.0f)) - (V / 2);
        if (V2 >= i) {
            i = V2;
        }
        if (i <= i2) {
            i2 = i;
        }
        if (bc.I()) {
            imageView = this.h;
            f = -i2;
        } else {
            imageView = this.h;
            f = i2;
        }
        imageView.setX(f);
    }

    @Override // com.huawei.openalliance.ad.views.dialog.PPSBaseDialog
    public int getLayoutId() {
        return C() ? R.layout.hiad_transparency_dialog_splash : R.layout.hiad_transparency_dialog;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fb.V("PPSTransparencyDialog", "onDetachedFromWindow");
        V();
    }

    public PPSTransparencyDialog(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.huawei.openalliance.ad.views.dialog.PPSBaseDialog
    public void Code() {
        this.S = (RelativeLayout) findViewById(R.id.haid_transparency_dialog_root);
        this.F = findViewById(R.id.margin_view);
        this.D = findViewById(R.id.anchor_view);
        this.c = (PPSBaseDialogContentView) findViewById(R.id.top_dsa_view);
        this.f = (ImageView) findViewById(R.id.top_dsa_iv);
        this.d = (PPSBaseDialogContentView) findViewById(R.id.bottom_dsa_view);
        this.g = (ImageView) findViewById(R.id.bottom_dsa_iv);
        F();
    }

    public PPSTransparencyDialog(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void Code(boolean z, PPSLabelView.d dVar, com.huawei.openalliance.ad.views.dsa.a aVar) {
        PPSBaseDialogContentView pPSBaseDialogContentView = this.e;
        if (pPSBaseDialogContentView instanceof DomesticDsaView) {
            ((DomesticDsaView) pPSBaseDialogContentView).Code(z, dVar);
        }
        this.n = aVar;
    }

    public PPSTransparencyDialog(Context context, int[] iArr, int[] iArr2, int i) {
        super(context, iArr, iArr2, i);
    }
}
