package com.baidu.navisdk.module.plate.layout;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.BNLinearLayout;

/* loaded from: classes7.dex */
public class EnergyTypeInfoLayout extends BNLinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private TextView f7411a;
    private String b;
    private View c;

    public EnergyTypeInfoLayout(Context context) {
        this(context, null);
    }

    private void initView() {
        this.c = findViewById(R.id.energy_type_info_layout);
        this.f7411a = (TextView) findViewById(R.id.energy_type_edit);
    }

    public String getEnergyInfoText() {
        return this.b;
    }

    public void setCarTypeInfoListener(View.OnClickListener onClickListener) {
        View view = this.c;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setEnergyInfoText(String str) {
        if (this.f7411a != null) {
            if (TextUtils.isEmpty(str)) {
                this.f7411a.setText("");
                this.f7411a.setHint("完善车型，续航预判更准");
            } else {
                this.b = str;
                this.f7411a.setText(str);
                this.f7411a.setHint("");
            }
        }
    }

    public EnergyTypeInfoLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EnergyTypeInfoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.nsdk_layout_energy_car_type, (ViewGroup) this, true);
        initView();
    }
}
