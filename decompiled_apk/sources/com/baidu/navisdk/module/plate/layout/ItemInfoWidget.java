package com.baidu.navisdk.module.plate.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.TipTool;
import com.tenmeter.smlibrary.utils.FileUtils;

/* loaded from: classes7.dex */
public class ItemInfoWidget extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7412a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private String g;
    private String h;
    private Context i;
    private View j;
    private TextView k;
    private TextView l;
    private EditText m;
    private TextView n;
    private ImageView o;
    private ImageView p;
    private c q;

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
            String trim = charSequence.toString().trim();
            if (charSequence.length() > 1 && charSequence.charAt(0) == '0') {
                if (charSequence.charAt(1) == '0') {
                    ItemInfoWidget.this.m.setText("0");
                    ItemInfoWidget.this.m.setSelection(1);
                    return;
                }
                if (charSequence.charAt(1) != '.') {
                    trim = trim.replace("0", "");
                    ItemInfoWidget.this.m.setText(trim);
                    ItemInfoWidget.this.m.setSelection(trim.length());
                }
                ItemInfoWidget.this.q.a(((Integer) ItemInfoWidget.this.getTag()).intValue(), trim);
                return;
            }
            ItemInfoWidget.this.q.a(((Integer) ItemInfoWidget.this.getTag()).intValue(), charSequence.toString());
        }
    }

    /* loaded from: classes7.dex */
    public class b implements InputFilter {

        /* renamed from: a, reason: collision with root package name */
        private final int f7414a;

        public b(int i) {
            this.f7414a = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = spanned.length();
            int i5 = 0;
            while (true) {
                if (i5 < length) {
                    char charAt = spanned.charAt(i5);
                    if (charAt == '.' || charAt == ',') {
                        break;
                    }
                    i5++;
                } else {
                    i5 = -1;
                    break;
                }
            }
            if (charSequence.equals(FileUtils.FILE_EXTENSION_SEPARATOR) && i3 == 0 && i4 == 0) {
                return "";
            }
            if (i5 >= 0) {
                if (!charSequence.equals(FileUtils.FILE_EXTENSION_SEPARATOR) && !charSequence.equals(",")) {
                    if (i4 > i5 && length - i5 > this.f7414a) {
                        if (!TextUtils.isEmpty(charSequence)) {
                            TipTool.onCreateToastDialog(ItemInfoWidget.this.i, "限制小数点后" + this.f7414a + "位");
                        }
                    }
                }
                return "";
            }
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        boolean a(int i, String str);
    }

    public ItemInfoWidget(Context context) {
        this(context, null);
    }

    public String getTitle() {
        return this.g;
    }

    public String getUnit() {
        return this.h;
    }

    public void setEditHint(String str) {
        this.m.setText("");
        this.m.setHint(str);
    }

    public void setEditText(String str) {
        this.m.setText(str);
        this.m.setSelection(str.length());
    }

    public void setEditTipHint(String str) {
        this.n.setText(str);
        this.n.setTextColor(Color.parseColor("#FF999999"));
    }

    public void setEditTipText(String str) {
        this.n.setText(str);
        this.n.setTextColor(Color.parseColor("#FF333333"));
    }

    public void setHintOnFocusChangedListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.m.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void setOnTextChangedListener(c cVar) {
        this.q = cVar;
        if (cVar != null) {
            this.m.addTextChangedListener(new a());
        } else {
            setOnClickListener(null);
        }
    }

    public void setTitle(String str) {
        this.k.setText(str);
    }

    public void setTitleColor(int i) {
        this.k.setTextColor(i);
    }

    public void setUnit(String str) {
        this.h = str;
        this.l.setText(str);
    }

    public ItemInfoWidget(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        this.j = findViewById(R.id.item_info_container);
        this.k = (TextView) findViewById(R.id.item_info_title);
        this.l = (TextView) findViewById(R.id.item_info_unit);
        this.m = (EditText) findViewById(R.id.item_info_edit_text);
        this.n = (TextView) findViewById(R.id.item_info_tip_text);
        this.o = (ImageView) findViewById(R.id.item_info_tip);
        this.p = (ImageView) findViewById(R.id.item_info_right_arrow);
        this.m.setFilters(new InputFilter[]{new b(1), new InputFilter.LengthFilter(5)});
    }

    private void b() {
        this.k.setVisibility(this.c ? 0 : 8);
        this.l.setVisibility(this.f ? 0 : 8);
        this.n.setVisibility(this.e ? 0 : 8);
        this.m.setVisibility(this.d ? 0 : 8);
        this.m.setEnabled(!this.b);
        this.o.setVisibility(this.f7412a ? 0 : 8);
        this.p.setVisibility(this.b ? 0 : 8);
    }

    public ItemInfoWidget(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.nsdk_layout_item_info, (ViewGroup) this, true);
        this.i = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ItemInfoWidget);
        this.f7412a = obtainStyledAttributes.getBoolean(R.styleable.ItemInfoWidget_nsdk_item_info_tips, false);
        this.b = obtainStyledAttributes.getBoolean(R.styleable.ItemInfoWidget_nsdk_item_info_right_arrow, false);
        this.c = obtainStyledAttributes.getBoolean(R.styleable.ItemInfoWidget_nsdk_item_info_title, true);
        this.e = obtainStyledAttributes.getBoolean(R.styleable.ItemInfoWidget_nsdk_item_info_edit_tip, false);
        this.d = obtainStyledAttributes.getBoolean(R.styleable.ItemInfoWidget_nsdk_item_info_edit_hint, true);
        this.f = obtainStyledAttributes.getBoolean(R.styleable.ItemInfoWidget_nsdk_item_info_unit, true);
        obtainStyledAttributes.recycle();
        a();
        b();
    }
}
