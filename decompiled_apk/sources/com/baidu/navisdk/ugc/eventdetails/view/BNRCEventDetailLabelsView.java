package com.baidu.navisdk.ugc.eventdetails.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class BNRCEventDetailLabelsView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private int f8079a;
    private int b;
    private int c;
    private int d;
    private int e;

    public BNRCEventDetailLabelsView(Context context) {
        super(context);
        a();
    }

    private void a() {
        Resources resources = JarUtils.getResources();
        this.f8079a = resources.getDimensionPixelSize(R.dimen.navi_dimens_20dp);
        this.b = resources.getDimensionPixelSize(R.dimen.navi_dimens_5dp);
        this.c = resources.getDimensionPixelSize(R.dimen.navi_dimens_10dp);
        this.e = resources.getDimensionPixelSize(R.dimen.nsdk_ugc_details_label_padding) * 2;
        this.d = 0;
    }

    public BNRCEventDetailLabelsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public BNRCEventDetailLabelsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public boolean a(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            removeAllViews();
            setVisibility(0);
            int i = 0;
            while (true) {
                if (i >= strArr.length) {
                    return true;
                }
                boolean z = i == 0;
                if (!TextUtils.isEmpty(strArr[i])) {
                    a(strArr[i], 0, z);
                }
                i++;
            }
        } else {
            setVisibility(8);
            return false;
        }
    }

    private boolean a(String str, int i, boolean z) {
        TextView textView = (TextView) JarUtils.inflate(getContext(), R.layout.nsdk_layout_ugc_detail_outline_label, null);
        if (z) {
            this.d = 0;
        }
        if (textView == null) {
            return false;
        }
        textView.setText(str);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-2, this.f8079a);
        }
        layoutParams.topMargin = i * (this.c + this.f8079a);
        layoutParams.leftMargin = this.d + (z ? 0 : this.b);
        addView(textView, layoutParams);
        this.d = layoutParams.leftMargin + a(textView, str);
        return true;
    }

    private int a(TextView textView, String str) {
        int measuredWidth = textView.getMeasuredWidth();
        return measuredWidth <= 0 ? Math.round(textView.getPaint().measureText(str)) + this.e : measuredWidth;
    }
}
