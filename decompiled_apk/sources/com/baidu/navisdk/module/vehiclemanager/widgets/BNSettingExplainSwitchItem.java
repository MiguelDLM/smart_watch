package com.baidu.navisdk.module.vehiclemanager.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public final class BNSettingExplainSwitchItem extends ASettingAddView {
    private ImageView g;
    private boolean h;
    private boolean i;
    private c j;
    private ImageView k;
    private ImageView l;
    private TextView m;
    private View.OnClickListener n;
    private int o;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BNSettingExplainSwitchItem.this.n != null) {
                BNSettingExplainSwitchItem.this.n.onClick(view);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            boolean z2 = !BNSettingExplainSwitchItem.this.i;
            if (BNSettingExplainSwitchItem.this.j != null) {
                z = BNSettingExplainSwitchItem.this.j.onChecked(BNSettingExplainSwitchItem.this.getId(), z2);
            } else {
                z = false;
            }
            if (z) {
                BNSettingExplainSwitchItem.this.setChecked(z2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        boolean onChecked(int i, boolean z);
    }

    public BNSettingExplainSwitchItem(Context context) {
        this(context, null);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.widgets.ASettingAddView
    public int getTitleId() {
        return R.id.motor_setting_switch_item_title;
    }

    public void setChecked(boolean z) {
        if (this.i == z) {
            return;
        }
        this.i = z;
        this.g.setSelected(z);
    }

    public void setFuncExplainClickListener(View.OnClickListener onClickListener) {
        this.n = onClickListener;
    }

    public void setFuncExplainViewVisibility(int i) {
        TextView textView = this.m;
        if (textView != null) {
            textView.setVisibility(i);
        }
        ImageView imageView = this.l;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    public void setOnCheckedListener(c cVar) {
        this.j = cVar;
        if (cVar != null) {
            setOnClickListener(new b());
        } else {
            setOnClickListener(null);
        }
    }

    public void setRedPointVisibleState(boolean z) {
        int i;
        ImageView imageView = this.l;
        if (imageView != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public void setSubText(String str) {
        TextView textView = this.f;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public BNSettingExplainSwitchItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.widgets.ASettingAddView
    public void a(Context context, AttributeSet attributeSet, boolean z) {
        if (context == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("MotorSettingLayoutExplainSwitch", "init: context == null");
                return;
            }
            return;
        }
        a(context, R.layout.motor_layout_setting_explain_switch_item, this, true, z);
        this.e = (TextView) findViewById(R.id.motor_setting_switch_item_title);
        this.f = (TextView) findViewById(R.id.motor_setting_switch_item_explain);
        this.g = (ImageView) findViewById(R.id.motor_setting_switch_item_image);
        this.k = (ImageView) findViewById(R.id.bn_setting_switch_item_expplain_img);
        this.m = (TextView) findViewById(R.id.bn_setting_switch_item_func_explain);
        this.l = (ImageView) findViewById(R.id.bn_setting_switch_red_point);
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BNSettingExplainSwitchItem);
        int i = R.styleable.BNSettingExplainSwitchItem_nsdk_explain_item_title;
        if (obtainStyledAttributes.hasValue(i)) {
            this.e.setText(obtainStyledAttributes.getString(i));
        }
        int i2 = R.styleable.BNSettingExplainSwitchItem_nsdk_explain_item_tip;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.f.setText(obtainStyledAttributes.getString(i2));
        }
        if (this.k != null) {
            int i3 = R.styleable.BNSettingExplainSwitchItem_nsdk_explain_item_img;
            if (obtainStyledAttributes.hasValue(i3)) {
                int resourceId = obtainStyledAttributes.getResourceId(i3, 0);
                this.o = resourceId;
                if (resourceId != 0) {
                    this.k.setVisibility(0);
                    com.baidu.navisdk.ui.util.b.a(this.k, this.o);
                }
            }
        }
        if (this.m != null) {
            int i4 = R.styleable.BNSettingExplainSwitchItem_nsdk_explain_item_func_text;
            if (obtainStyledAttributes.hasValue(i4)) {
                String string = obtainStyledAttributes.getString(i4);
                if (!TextUtils.isEmpty(string)) {
                    this.m.setVisibility(0);
                    this.m.setText(string);
                    this.m.setOnClickListener(new a());
                }
            }
        }
        obtainStyledAttributes.recycle();
    }

    public BNSettingExplainSwitchItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = true;
        this.i = false;
    }

    public void a(boolean z) {
        int i;
        if (this.h == z) {
            return;
        }
        this.h = z;
        TextView textView = this.e;
        if (textView != null) {
            textView.setTextColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_text_a, z));
        }
        TextView textView2 = this.f;
        if (textView2 != null) {
            textView2.setTextColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_text_f, z));
        }
        ImageView imageView = this.k;
        if (imageView == null || (i = this.o) == 0) {
            return;
        }
        com.baidu.navisdk.ui.util.b.a(imageView, i);
    }
}
