package com.baidu.navisdk.module.trucknavi.view.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.trucknavi.c;
import com.baidu.navisdk.ui.widget.BNLinearLayout;
import com.baidu.navisdk.util.jar.JarUtils;
import com.tenmeter.smlibrary.utils.FileUtils;

/* loaded from: classes7.dex */
public class TruckCenterViewTempInfoView extends BNLinearLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private TextView f7590a;
    private TextView b;
    private View c;
    private View d;
    private View.OnClickListener e;
    private View.OnClickListener f;

    public TruckCenterViewTempInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.truck_layout_center_view_height_panel, (ViewGroup) this, true);
        this.c = findViewById(R.id.truck_limit_temp_height_button);
        this.d = findViewById(R.id.truck_limit_temp_weight_button);
        this.f7590a = (TextView) findViewById(R.id.tv_height_value);
        this.b = (TextView) findViewById(R.id.tv_weight_value);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        int id = view.getId();
        if (id == R.id.truck_limit_temp_height_button) {
            View.OnClickListener onClickListener2 = this.e;
            if (onClickListener2 != null) {
                onClickListener2.onClick(view);
                return;
            }
            return;
        }
        if (id == R.id.truck_limit_temp_weight_button && (onClickListener = this.f) != null) {
            onClickListener.onClick(view);
        }
    }

    public void setHeight(float f) {
        TextView textView = this.f7590a;
        if (textView != null) {
            textView.setText(String.valueOf(c.a(f)));
        }
    }

    public void setHeightButtonClickListener(View.OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    public void setWeight(float f) {
        int dimensionPixelOffset;
        if (this.b != null) {
            String a2 = c.a(f);
            this.b.setText(a2);
            if (a2.contains(FileUtils.FILE_EXTENSION_SEPARATOR)) {
                dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_10dp);
            } else {
                dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_12dp);
            }
            this.b.setTextSize(0, dimensionPixelOffset);
        }
    }

    public void setWeightButtonClickListener(View.OnClickListener onClickListener) {
        this.f = onClickListener;
    }

    public TruckCenterViewTempInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
