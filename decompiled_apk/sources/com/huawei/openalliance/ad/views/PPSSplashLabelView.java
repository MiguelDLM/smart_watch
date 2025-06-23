package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.utils.ay;

/* loaded from: classes10.dex */
public class PPSSplashLabelView extends PPSLabelView {
    public PPSSplashLabelView(Context context) {
        super(context);
    }

    @Override // com.huawei.openalliance.ad.views.PPSLabelView
    public void Code(AdSource adSource, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (adSource == null) {
            fb.V("PPSSplashLabelView", "adSource is null");
            setClick(spannableStringBuilder);
            return;
        }
        String V = ay.V(adSource.Code()) == null ? "" : ay.V(adSource.Code());
        if (str == null) {
            str = "";
        }
        String str2 = V + str;
        String V2 = adSource.V();
        if (TextUtils.isEmpty(V) && TextUtils.isEmpty(V2)) {
            setClick(spannableStringBuilder);
        } else if (TextUtils.isEmpty(V) || !TextUtils.isEmpty(V2)) {
            Code(str2, V2);
        } else {
            setClick(new SpannableStringBuilder(str2));
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSLabelView
    public void setTextWhenImgLoadFail(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        if (!TextUtils.isEmpty(str)) {
            spannableStringBuilder.append((CharSequence) str);
        }
        setClick(spannableStringBuilder);
    }

    public PPSSplashLabelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void Code(AdSource adSource, String str, boolean z) {
        this.B = z;
        Code(adSource, str);
    }

    public PPSSplashLabelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.huawei.openalliance.ad.views.PPSLabelView
    public void Code(String str, Drawable drawable) {
        try {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(" ");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            boolean z = !TextUtils.isEmpty(str);
            spannableStringBuilder.append((CharSequence) str);
            ImageSpan Code = Code(drawable, z);
            if (Code != null) {
                spannableStringBuilder.setSpan(Code, 0, 1, 33);
            }
            setClick(spannableStringBuilder);
        } catch (Throwable unused) {
            fb.I("PPSSplashLabelView", "setTextWhenImgLoaded error");
        }
    }
}
