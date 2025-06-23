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
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNLinearLayout;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public class DisplacementLayout extends BNLinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private EditText f7405a;
    private final Context b;

    /* loaded from: classes7.dex */
    public class a implements View.OnFocusChangeListener {

        /* renamed from: com.baidu.navisdk.module.plate.layout.DisplacementLayout$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0276a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f7407a;

            public RunnableC0276a(boolean z) {
                this.f7407a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f7407a) {
                    com.baidu.navisdk.module.plate.controller.a.e().a("弹出软键盘");
                    com.baidu.navisdk.module.plate.controller.a.e().a(DisplacementLayout.this.f7405a);
                }
            }
        }

        public a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            DisplacementLayout.this.f7405a.post(new RunnableC0276a(z));
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
            String trim = charSequence.toString().trim();
            g gVar = g.CAR_PLATE;
            if (gVar.d()) {
                gVar.e("DisplacementLayout", "onTextChanged: content " + trim);
            }
            if (TextUtils.isEmpty(trim)) {
                com.baidu.navisdk.module.plate.controller.a.e().b();
                return;
            }
            if (Integer.parseInt(trim) > 10000) {
                DisplacementLayout.this.f7405a.setText("10000");
                TipTool.onCreateToastDialog(DisplacementLayout.this.b, "限制最大值为10000");
            }
            if (trim.length() > 1 && trim.startsWith("0")) {
                String replace = trim.replace("0", "");
                DisplacementLayout.this.f7405a.setText(replace);
                DisplacementLayout.this.f7405a.setSelection(replace.length());
            }
            com.baidu.navisdk.module.plate.controller.a.e().b();
        }
    }

    public DisplacementLayout(Context context) {
        this(context, null);
    }

    public int getDisplacementVal() {
        try {
            EditText editText = this.f7405a;
            if (editText != null && !TextUtils.isEmpty(editText.getText())) {
                return Integer.parseInt(this.f7405a.getText().toString());
            }
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("DisplacementLayout", "getDisplacementVal,e:" + e);
            }
        }
        return 0;
    }

    public DisplacementLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        EditText editText = (EditText) findViewById(R.id.plate_edit_placement);
        this.f7405a = editText;
        editText.setOnFocusChangeListener(new a());
        this.f7405a.addTextChangedListener(new b());
    }

    public DisplacementLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = context;
        LayoutInflater.from(context).inflate(R.layout.nsdk_layout_car_displacement, (ViewGroup) this, true);
        a(context);
    }

    public void a() {
        EditText editText = this.f7405a;
        if (editText != null) {
            editText.setText("");
            this.f7405a.setHint("请输入排量");
        }
    }
}
