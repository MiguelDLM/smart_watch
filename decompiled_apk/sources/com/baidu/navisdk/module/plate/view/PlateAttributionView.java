package com.baidu.navisdk.module.plate.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.ScreenUtil;

/* loaded from: classes7.dex */
public class PlateAttributionView extends LinearLayout {
    private static final String[] b = {"京", "沪", "浙", "苏", "粤", "鲁", "晋", "冀", "豫", "川", "渝", "辽", "吉", "黑", "皖", "鄂", "湘", "赣", "闽", "陕", "甘", "宁", "蒙", "津", "贵", "云", "桂", "琼", "青", "新", "藏"};

    /* renamed from: a, reason: collision with root package name */
    public b f7430a;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CharSequence text = ((TextView) view).getText();
            b bVar = PlateAttributionView.this.f7430a;
            if (bVar != null) {
                bVar.a(text);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(CharSequence charSequence);
    }

    public PlateAttributionView(Context context) {
        super(context);
        a();
    }

    private void a() {
        setBackgroundColor(-1973275);
        setPadding(a(7), a(7), 0, 0);
        setOrientation(1);
        setClickable(true);
        int length = b.length / 9;
        for (int i = 0; i < length + 1; i++) {
            LinearLayout a2 = a(getContext());
            for (int i2 = 0; i2 < 9; i2++) {
                a2.addView(a(getContext(), i, i2));
            }
            addView(a2);
        }
    }

    public void setOnAttributionSelectListener(b bVar) {
        this.f7430a = bVar;
    }

    public PlateAttributionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public PlateAttributionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private LinearLayout a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.setLayoutParams(layoutParams);
        layoutParams.setMargins(0, 0, 0, a(7));
        return linearLayout;
    }

    private TextView a(Context context, int i, int i2) {
        TextView textView = new TextView(context);
        textView.setTextSize(2, 18.0f);
        textView.setBackground(getContext().getResources().getDrawable(R.drawable.bnav_bg_attribution_item));
        textView.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
        layoutParams.setMargins(0, 0, a(5), 0);
        textView.setLayoutParams(layoutParams);
        int i3 = (i * 9) + i2;
        String[] strArr = b;
        if (i3 < strArr.length) {
            textView.setText(strArr[i3]);
            textView.setOnClickListener(new a());
        } else {
            textView.setText("");
            textView.setVisibility(4);
        }
        return textView;
    }

    private int a(int i) {
        return ScreenUtil.getInstance().dip2px(i);
    }
}
