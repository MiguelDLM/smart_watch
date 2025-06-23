package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.bumptech.glide.Glide;

/* loaded from: classes8.dex */
public class BNMultiTabLabelTextView extends BNRelativeLayout {
    protected ImageView labelIcon;
    protected LinearLayout labelLayout2;
    private View labelLine;
    protected TextView labelPartA;
    protected TextView labelPartB;
    protected TextView labelText;

    public BNMultiTabLabelTextView(@NonNull Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(layoutId(), (ViewGroup) this, true);
        initView();
    }

    private void initView() {
        this.labelIcon = (ImageView) findViewById(R.id.label_icon);
        this.labelText = (TextView) findViewById(R.id.label_title);
        this.labelLayout2 = (LinearLayout) findViewById(R.id.label_layout2);
        this.labelPartA = (TextView) findViewById(R.id.label_partA);
        this.labelPartB = (TextView) findViewById(R.id.label_partB);
        this.labelLine = findViewById(R.id.label_line);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getLabelWidth(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            android.widget.TextView r0 = r2.labelText
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L1c
            android.widget.TextView r4 = r2.labelText
            android.text.TextPaint r4 = r4.getPaint()
            float r3 = r4.measureText(r3)
        L1a:
            int r1 = (int) r3
            goto L5d
        L1c:
            android.widget.LinearLayout r0 = r2.labelLayout2
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L5d
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L35
            android.widget.TextView r4 = r2.labelPartA
            android.text.TextPaint r4 = r4.getPaint()
            float r3 = r4.measureText(r3)
            goto L1a
        L35:
            android.widget.TextView r0 = r2.labelPartA
            android.text.TextPaint r0 = r0.getPaint()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r3 = "·"
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            float r3 = r0.measureText(r3)
            android.widget.TextView r0 = r2.labelPartB
            android.text.TextPaint r0 = r0.getPaint()
            float r4 = r0.measureText(r4)
            float r3 = r3 + r4
            goto L1a
        L5d:
            android.view.View r3 = r2.labelLine
            int r3 = r3.getVisibility()
            if (r3 != 0) goto L6f
            com.baidu.navisdk.util.common.ScreenUtil r3 = com.baidu.navisdk.util.common.ScreenUtil.getInstance()
            r4 = 5
            int r3 = r3.dip2px(r4)
            int r1 = r1 + r3
        L6f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.widget.BNMultiTabLabelTextView.getLabelWidth(java.lang.String, java.lang.String):int");
    }

    public int layoutId() {
        return R.layout.bnav_layout_route_multi_tab_label_view;
    }

    public void setLabelIcon(String str) {
        if (TextUtils.isEmpty(str)) {
            this.labelIcon.setVisibility(8);
        } else {
            this.labelIcon.setVisibility(0);
            Glide.with(getContext()).load(str).into(this.labelIcon);
        }
    }

    public void setLabelLineVisible(boolean z) {
        int i;
        View view = this.labelLine;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
    }

    public void setText(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.labelLayout2.setVisibility(8);
        this.labelText.setVisibility(0);
        this.labelText.setText(str);
    }

    public void setTextColor(int i) {
        if (this.labelText.getVisibility() == 0) {
            this.labelText.setTextColor(i);
        }
        if (this.labelLayout2.getVisibility() == 0) {
            this.labelPartA.setTextColor(i);
            this.labelPartB.setTextColor(i);
            this.labelPartB.setAlpha(0.7f);
        }
    }

    public BNMultiTabLabelTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public BNMultiTabLabelTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void setText(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.labelText.setVisibility(8);
            this.labelLayout2.setVisibility(0);
            this.labelPartA.setText(str + "·");
            this.labelPartB.setText(str2);
            return;
        }
        setText(str);
    }
}
