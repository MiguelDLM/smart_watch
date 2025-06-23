package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.ic;
import com.huawei.hms.ads.kg;
import com.huawei.hms.ads.splash.R;

/* loaded from: classes10.dex */
public class PPSImageView extends PPSBaseView implements kg {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f17423a;

    public PPSImageView(Context context) {
        super(context);
        Code(context);
        this.B = new ic(context, this);
    }

    private void Code(Context context) {
        View.inflate(context, R.layout.hiad_view_image_ad, this);
        this.f17423a = (ImageView) findViewById(R.id.iv_ad_content);
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.km
    public boolean C() {
        return true;
    }

    @Override // com.huawei.hms.ads.kg
    public void Code(Drawable drawable) {
        fb.V("PPSImageView", "onAdImageLoaded - set image to view");
        this.f17423a.setImageDrawable(drawable);
        this.B.Code(this.F);
    }
}
