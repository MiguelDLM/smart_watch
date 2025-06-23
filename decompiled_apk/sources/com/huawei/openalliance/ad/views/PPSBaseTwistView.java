package com.huawei.openalliance.ad.views;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.huawei.hms.ads.eg;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.utils.w;
import java.util.ArrayList;

/* loaded from: classes10.dex */
public class PPSBaseTwistView extends PPSBaseStyleView {
    protected ImageView F;

    public PPSBaseTwistView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        if (this.F == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new eg(0.33f, 0.0f, 0.67f, 1.0f));
        ArrayList arrayList = new ArrayList(4);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.F, "rotation", 0.0f, -7.0f);
        ofFloat.setDuration(150L);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.F, "rotation", -7.0f, 7.0f);
        ofFloat2.setDuration(400L);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.F, "rotation", 7.0f, -4.5f);
        ofFloat3.setDuration(350L);
        arrayList.add(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.F, "rotation", -4.5f, 2.0f);
        ofFloat4.setDuration(350L);
        arrayList.add(ofFloat4);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.F, "rotation", 2.0f, 0.0f);
        ofFloat5.setDuration(250L);
        arrayList.add(ofFloat5);
        this.F.invalidate();
        animatorSet.playSequentially(arrayList);
        animatorSet.start();
    }

    public String getViewTag() {
        return "PPSBaseStyleView";
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        fb.V(getViewTag(), "w=%s, h=%s, oldw=%s, oldh=%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        this.F.post(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSBaseTwistView.1
            @Override // java.lang.Runnable
            public void run() {
                fb.V(PPSBaseTwistView.this.getViewTag(), "imageView %s %s", Integer.valueOf(PPSBaseTwistView.this.F.getWidth()), Integer.valueOf(PPSBaseTwistView.this.F.getHeight()));
                PPSBaseTwistView.this.F.setPivotX(r0.getWidth() / 2.0f);
                PPSBaseTwistView.this.F.setPivotY(r0.getHeight() + w.V(PPSBaseTwistView.this.getContext(), 80.0f));
                PPSBaseTwistView.this.V();
            }
        });
    }

    public PPSBaseTwistView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PPSBaseTwistView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
