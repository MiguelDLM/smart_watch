package com.baidu.navisdk.module.plate.layout;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.plate.e;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNLinearLayout;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.statistic.userop.b;
import com.tencent.connect.common.II0xO0;

/* loaded from: classes7.dex */
public class EnergyMileageLayout extends BNLinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private EditText f7409a;
    private final Context b;
    private e c;

    /* loaded from: classes7.dex */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (EnergyMileageLayout.this.c != null) {
                EnergyMileageLayout.this.c.onTextChanged(charSequence, i, i2, i3);
            }
            String trim = charSequence.toString().trim();
            g gVar = g.CAR_PLATE;
            if (gVar.d()) {
                gVar.e("MileageLayout", "onTextChanged: content " + trim);
            }
            if (TextUtils.isEmpty(trim)) {
                return;
            }
            b.r().a("11.9.3", "1", trim, null);
            if (Integer.parseInt(trim) > 1000) {
                EnergyMileageLayout.this.f7409a.setText(II0xO0.f26842oIX0oI);
                EnergyMileageLayout.this.f7409a.setSelection(trim.length());
                TipTool.onCreateToastDialog(EnergyMileageLayout.this.b, "限制最大值为1000");
            }
            if (trim.length() > 1 && trim.startsWith("0")) {
                String replace = trim.replace("0", "");
                EnergyMileageLayout.this.f7409a.setText(replace);
                EnergyMileageLayout.this.f7409a.setSelection(replace.length());
            }
        }
    }

    public EnergyMileageLayout(Context context) {
        this(context, null);
    }

    public int getEnergyMileage() {
        try {
            EditText editText = this.f7409a;
            if (editText != null && !TextUtils.isEmpty(editText.getText())) {
                return Integer.parseInt(this.f7409a.getText().toString());
            }
            return 300;
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("MileageLayout", "getEnergyMileage,e:" + e);
            }
            return 0;
        }
    }

    public void setAttributionSelectListener(View.OnFocusChangeListener onFocusChangeListener) {
        EditText editText = this.f7409a;
        if (editText != null) {
            editText.setOnFocusChangeListener(onFocusChangeListener);
        }
    }

    public void setEnergyMileageText(String str) {
        if (this.f7409a != null) {
            if (TextUtils.isEmpty(str)) {
                this.f7409a.setText("");
                this.f7409a.setHint("默认300");
            } else {
                this.f7409a.setText(str);
                this.f7409a.setHint("");
            }
        }
    }

    public void setTextChangedListener(e eVar) {
        this.c = eVar;
    }

    public EnergyMileageLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        EditText editText = (EditText) findViewById(R.id.energy_mileage);
        this.f7409a = editText;
        editText.addTextChangedListener(new a());
    }

    public EnergyMileageLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = context;
        LayoutInflater.from(context).inflate(R.layout.nsdk_layout_energy_car_mileage, (ViewGroup) this, true);
        a(context);
    }
}
