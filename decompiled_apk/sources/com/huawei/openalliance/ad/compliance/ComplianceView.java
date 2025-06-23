package com.huawei.openalliance.ad.compliance;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.ey;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.w;
import com.huawei.openalliance.ad.utils.z;
import com.huawei.openalliance.ad.views.PPSBaseDialogContentView;
import java.util.List;

/* loaded from: classes10.dex */
public class ComplianceView extends PPSBaseDialogContentView {
    private static final String f = "ComplianceView";
    private static final String n = ", ";
    private View g;
    private TextView h;
    private RelativeLayout i;
    private AdContentData j;
    private TextView k;
    private ey l;
    private ImageView m;

    public ComplianceView(Context context) {
        super(context);
    }

    private void B() {
        TextView textView;
        if (!w.e(getContext()) || (textView = this.h) == null || this.k == null) {
            return;
        }
        textView.setTextSize(1, 28.0f);
        this.k.setTextSize(1, 28.0f);
    }

    private void I() {
        if (this.g == null || this.i == null) {
            fb.V(f, "partingLine or whyThisAdClick view not init");
            return;
        }
        Boolean bool = this.d;
        if (bool != null && !bool.booleanValue()) {
            fb.V(f, "not need show why this ad");
            return;
        }
        this.g.setVisibility(0);
        this.i.setVisibility(0);
        this.i.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.compliance.ComplianceView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ComplianceView.this.j != null) {
                    w.Code(ComplianceView.this.getContext(), ComplianceView.this.j);
                    if (ComplianceView.this.l != null) {
                        ComplianceView.this.l.Code();
                    }
                }
            }
        });
    }

    private void Z() {
        String value;
        AdContentData adContentData = this.j;
        if (adContentData != null) {
            List<AdvertiserInfo> aL = adContentData.aL();
            StringBuffer stringBuffer = new StringBuffer();
            if (ad.Code(aL)) {
                fb.V(f, "complianceInfo is null");
                return;
            }
            for (int i = 0; i < aL.size(); i++) {
                if (i != aL.size() - 1) {
                    stringBuffer.append(aL.get(i).getValue());
                    value = n;
                } else {
                    value = aL.get(i).getValue();
                }
                stringBuffer.append(value);
            }
            TextView textView = this.h;
            if (textView != null) {
                textView.setText(stringBuffer);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void setAdContentData(AdContentData adContentData) {
        if (adContentData == null) {
            return;
        }
        this.j = adContentData;
        I();
        Z();
        Code();
        B();
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void setViewClickListener(ey eyVar) {
        this.l = eyVar;
    }

    public ComplianceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void Code() {
        try {
            fb.V(f, "adapterView mFeedbackViewPaddingLeft = %s, mFeedbackViewPaddingRight= %s", Integer.valueOf(this.b), Integer.valueOf(this.c));
            if (V()) {
                this.I.setPadding(this.b, 0, this.c, 0);
                this.I.requestLayout();
                this.I.getViewTreeObserver().addOnGlobalLayoutListener(this.e);
            }
        } catch (Throwable th) {
            fb.I(f, "adapterView error, %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void V(Context context) {
        ImageView imageView = (ImageView) findViewById(R.id.right_arrow);
        this.m = imageView;
        if (imageView != null) {
            Drawable drawable = getResources().getDrawable(R.drawable.hiad_feedback_right_arrow);
            if (bc.I()) {
                this.m.setImageBitmap(z.V(drawable));
            }
        }
    }

    public ComplianceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void Code(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.hiad_compliance_choice_view, this);
        this.I = inflate.findViewById(R.id.compliance_view_root);
        this.g = inflate.findViewById(R.id.why_this_ad_line);
        this.h = (TextView) inflate.findViewById(R.id.compliance_info);
        this.i = (RelativeLayout) inflate.findViewById(R.id.why_this_ad_btn);
        this.B = inflate.findViewById(R.id.compliance_scrollview);
        this.k = (TextView) inflate.findViewById(R.id.why_this_ad_tv);
    }
}
