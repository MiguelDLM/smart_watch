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
import com.baidu.navisdk.module.plate.checker.g;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class CarPlateLayout extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private TextView f7397a;
    private TextView b;
    private EditText c;
    private String d;
    private String e;
    private com.baidu.navisdk.module.plate.checker.c f;
    private e g;

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
    public class b implements View.OnFocusChangeListener {

        /* loaded from: classes7.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f7400a;

            public a(boolean z) {
                this.f7400a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f7400a) {
                    com.baidu.navisdk.module.plate.controller.a.e().a("弹出软键盘");
                    com.baidu.navisdk.module.plate.controller.a.e().a(CarPlateLayout.this.c);
                }
            }
        }

        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            CarPlateLayout.this.c.postDelayed(new a(z), 200L);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            CarPlateLayout.this.a(charSequence, i, i2, i3);
        }
    }

    /* loaded from: classes7.dex */
    public class d extends InputFilter.LengthFilter {
        public d(int i) {
            super(i);
        }

        @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            return super.filter(charSequence, i, i2, spanned, i3, i4);
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(String str);
    }

    /* loaded from: classes7.dex */
    public class f extends ReplacementTransformationMethod {
        private f() {
        }

        @Override // android.text.method.ReplacementTransformationMethod
        public char[] getOriginal() {
            return new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        }

        @Override // android.text.method.ReplacementTransformationMethod
        public char[] getReplacement() {
            return new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        }

        public /* synthetic */ f(CarPlateLayout carPlateLayout, a aVar) {
            this();
        }
    }

    public CarPlateLayout(Context context) {
        this(context, null);
    }

    public void b() {
        this.d = "京";
        this.f7397a.setText("京");
    }

    public void c() {
        EditText editText = this.c;
        if (editText != null) {
            editText.setText("");
            this.c.requestFocus();
            this.c.setHint("请输入车牌号");
        }
        TextView textView = this.f7397a;
        if (textView != null) {
            textView.setText(this.d);
        }
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.plate_attribution_btn) {
            com.baidu.navisdk.module.plate.controller.a.e().d();
        }
    }

    public void setCurrentPlateChecker(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        this.f = new com.baidu.navisdk.module.plate.checker.b();
                    } else {
                        this.f = new com.baidu.navisdk.module.plate.checker.b();
                    }
                } else {
                    this.f = new g();
                }
            } else {
                this.f = new com.baidu.navisdk.module.plate.checker.d();
            }
        } else {
            this.f = new com.baidu.navisdk.module.plate.checker.b();
        }
        a();
    }

    public void setPlateCharChangListener(e eVar) {
        this.g = eVar;
    }

    public CarPlateLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CarPlateLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.nsdk_layout_car_plate, (ViewGroup) this, true);
        a(context);
        b();
    }

    private void a(Context context) {
        TextView textView = (TextView) findViewById(R.id.plate_attribution_btn);
        this.f7397a = textView;
        textView.setOnClickListener(this);
        this.c = (EditText) findViewById(R.id.plate_edit);
        this.b = (TextView) findViewById(R.id.plate_error_tip);
        EditText editText = this.c;
        if (editText != null) {
            editText.setOnEditorActionListener(new a());
            this.c.setOnFocusChangeListener(new b());
            this.c.addTextChangedListener(new c());
            this.c.setTransformationMethod(new f(this, null));
            this.c.setFilters(new InputFilter[]{new d(getMaxPlateTailLength())});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, int i3) {
        if (TextUtils.isEmpty(charSequence)) {
            this.e = "";
        } else {
            this.e = charSequence.toString().toUpperCase();
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.CAR_PLATE;
        if (gVar.d()) {
            gVar.e("CarPlateLayout", "onPlateCharChanged:  mRightHalfPlate " + this.e);
        }
        a();
        e eVar = this.g;
        if (eVar != null) {
            eVar.a(this.e);
        }
    }

    public void a() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("CarPlateLayout", "check,mAttribution:" + this.d + ",mPlateChars:" + this.e);
        }
        com.baidu.navisdk.module.plate.checker.c cVar = this.f;
        if (cVar != null) {
            com.baidu.navisdk.module.plate.checker.f a2 = cVar.a(this.d, this.e, this.d + this.e);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("CarPlateLayout", "check,ret:" + a2);
            }
            com.baidu.navisdk.module.plate.controller.a.e().a(!(a2.b() / 65536 == 1));
            if (this.b != null) {
                if (TextUtils.isEmpty(a2.a())) {
                    this.b.setText("");
                    this.b.setVisibility(8);
                } else {
                    this.b.setText(a2.a());
                    this.b.setVisibility(0);
                }
            }
        }
    }

    public void a(String str) {
        this.d = str;
        this.f7397a.setText(str);
    }
}
