package com.huawei.openalliance.ad.views.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.views.PPSBaseDialogContentView;

/* loaded from: classes10.dex */
public class PPSAdvertiserInfoDialog extends PPSBaseDialog {
    public PPSAdvertiserInfoDialog(Context context) {
        super(context);
    }

    @Override // com.huawei.openalliance.ad.views.dialog.PPSBaseDialog
    public void Code() {
        this.S = (RelativeLayout) findViewById(R.id.haid_advertiser_info_dialog_root);
        this.F = findViewById(R.id.margin_view);
        this.D = findViewById(R.id.anchor_view);
        this.c = (PPSBaseDialogContentView) findViewById(R.id.top_advertiser_view);
        this.f = (ImageView) findViewById(R.id.top_advertiser_iv);
        this.d = (PPSBaseDialogContentView) findViewById(R.id.bottom_advertiser_view);
        this.g = (ImageView) findViewById(R.id.bottom_advertiser_iv);
    }

    @Override // com.huawei.openalliance.ad.views.dialog.PPSBaseDialog
    public int getLayoutId() {
        return R.layout.hiad_advertiser_info_dialog;
    }

    public PPSAdvertiserInfoDialog(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PPSAdvertiserInfoDialog(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PPSAdvertiserInfoDialog(Context context, int[] iArr, int[] iArr2) {
        super(context, iArr, iArr2);
    }
}
