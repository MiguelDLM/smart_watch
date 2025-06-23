package com.baidu.navisdk.module.plate.layout;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.ReplacementTransformationMethod;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.plate.checker.f;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public class NewEnergyPlateLayout extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private TextView f7415a;
    private TextView b;
    private EditText c;
    private String d;
    private String e;
    private com.baidu.navisdk.module.plate.checker.c f;
    private d g;
    private com.baidu.navisdk.module.plate.e h;

    /* loaded from: classes7.dex */
    public class a implements TextView.OnEditorActionListener {
        public a() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            return false;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (NewEnergyPlateLayout.this.h != null) {
                NewEnergyPlateLayout.this.h.onTextChanged(charSequence, i, i2, i3);
            }
            NewEnergyPlateLayout.this.a(charSequence, i, i2, i3);
        }
    }

    /* loaded from: classes7.dex */
    public class c extends InputFilter.LengthFilter {
        public c(int i) {
            super(i);
        }

        @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            return super.filter(charSequence, i, i2, spanned, i3, i4);
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a(boolean z);
    }

    /* loaded from: classes7.dex */
    public class e extends ReplacementTransformationMethod {
        private e() {
        }

        @Override // android.text.method.ReplacementTransformationMethod
        public char[] getOriginal() {
            return new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        }

        @Override // android.text.method.ReplacementTransformationMethod
        public char[] getReplacement() {
            return new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        }

        public /* synthetic */ e(NewEnergyPlateLayout newEnergyPlateLayout, a aVar) {
            this();
        }
    }

    public NewEnergyPlateLayout(Context context) {
        this(context, null);
    }

    private void f() {
        this.f = new com.baidu.navisdk.module.plate.checker.e();
        this.f7415a = (TextView) findViewById(R.id.plate_attribution_btn);
        this.c = (EditText) findViewById(R.id.new_energy_plate_edit);
        this.b = (TextView) findViewById(R.id.new_energy_plate_error_tip);
        EditText editText = this.c;
        if (editText != null) {
            editText.setOnEditorActionListener(new a());
            this.c.addTextChangedListener(new b());
            this.c.setTransformationMethod(new e(this, null));
            this.c.setFilters(new InputFilter[]{new c(getMaxPlateTailLength())});
        }
    }

    public void b() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("NewEnergyPlateLayout", "check,mAttribution:" + this.d + ",mPlateChars:" + this.e);
        }
        com.baidu.navisdk.module.plate.checker.c cVar = this.f;
        if (cVar != null) {
            f a2 = cVar.a(this.d, this.e, this.d + this.e);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("NewEnergyPlateLayout", "check,ret:" + a2);
            }
            boolean z = a2.b() / 65536 == 1;
            d dVar = this.g;
            if (dVar != null) {
                dVar.a(!z);
            }
            if (this.b != null) {
                if (!TextUtils.isEmpty(a2.a()) && !TextUtils.isEmpty(this.e)) {
                    this.b.setText(a2.a());
                    this.b.setVisibility(0);
                } else {
                    this.b.setText("");
                    this.b.setVisibility(8);
                }
            }
        }
    }

    public void c() {
        this.d = "京";
        this.f7415a.setText("京");
    }

    public void d() {
        EditText editText = this.c;
        if (editText != null) {
            editText.setText("");
            this.c.requestFocus();
            this.c.setHint("请输入车牌号");
        }
        TextView textView = this.f7415a;
        if (textView != null) {
            textView.setText(this.d);
        }
    }

    public void e() {
        this.g = null;
    }

    public String getFullPlate() {
        return this.d + this.e;
    }

    public int getMaxPlateTailLength() {
        return 7;
    }

    public EditText getPlateEditView() {
        EditText editText = this.c;
        if (editText != null) {
            return editText;
        }
        EditText editText2 = (EditText) findViewById(R.id.plate_edit);
        this.c = editText2;
        return editText2;
    }

    public String getRightHalfPlate() {
        return this.e;
    }

    public void setAttributionListener(View.OnClickListener onClickListener) {
        TextView textView = this.f7415a;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void setAttributionSelectListener(View.OnFocusChangeListener onFocusChangeListener) {
        EditText editText = this.c;
        if (editText != null) {
            editText.setOnFocusChangeListener(onFocusChangeListener);
        }
    }

    public void setTextChangedListener(com.baidu.navisdk.module.plate.e eVar) {
        this.h = eVar;
    }

    public NewEnergyPlateLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewEnergyPlateLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.nsdk_layout_new_energy_plate, (ViewGroup) this, true);
        f();
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, int i3) {
        if (TextUtils.isEmpty(charSequence)) {
            this.e = "";
        } else {
            this.e = charSequence.toString().toUpperCase();
        }
        g gVar = g.CAR_PLATE;
        if (gVar.d()) {
            gVar.e("NewEnergyPlateLayout", "onPlateCharChanged:  mRightHalfPlate " + this.e);
        }
        b();
    }

    public boolean a() {
        com.baidu.navisdk.module.plate.checker.c cVar = this.f;
        if (cVar == null) {
            return false;
        }
        String str = this.d;
        String str2 = this.e;
        StringBuilder sb = new StringBuilder();
        sb.append(this.d);
        sb.append(this.e);
        return cVar.a(str, str2, sb.toString()).b() / 65536 != 1;
    }

    public void a(String str) {
        this.d = str;
        this.f7415a.setText(str);
    }

    public void a(d dVar) {
        this.g = dVar;
    }

    public void b(String str) {
        if (this.c == null || this.f7415a == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.c.setText("");
            this.c.requestFocus();
            this.c.setHint("请输入车牌号");
            c();
            return;
        }
        this.c.requestFocus();
        this.c.setText(str.substring(1));
        EditText editText = this.c;
        editText.setSelection(editText.getText().length());
        a(String.valueOf(str.charAt(0)));
    }
}
