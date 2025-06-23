package com.baidu.navisdk.module.vehiclemanager.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public final class BNSettingSwitchItem extends ASettingAddView {
    private ImageView g;
    private boolean h;
    private b i;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            boolean z2 = !BNSettingSwitchItem.this.h;
            if (BNSettingSwitchItem.this.i != null) {
                z = BNSettingSwitchItem.this.i.onChecked(BNSettingSwitchItem.this.getId(), z2);
            } else {
                z = false;
            }
            if (z) {
                BNSettingSwitchItem.this.setChecked(z2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        boolean onChecked(int i, boolean z);
    }

    public BNSettingSwitchItem(Context context) {
        this(context, null);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.widgets.ASettingAddView
    public int getTitleId() {
        return R.id.motor_setting_switch_item_title;
    }

    public void setChecked(boolean z) {
        if (this.h == z) {
            return;
        }
        this.h = z;
        this.g.setSelected(z);
    }

    public void setOnCheckedListener(b bVar) {
        this.i = bVar;
        if (bVar != null) {
            setOnClickListener(new a());
        } else {
            setOnClickListener(null);
        }
    }

    public void setSwitchViewBackground(Drawable drawable) {
        ImageView imageView = this.g;
        if (imageView != null && drawable != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public BNSettingSwitchItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.widgets.ASettingAddView
    public void a(Context context, AttributeSet attributeSet, boolean z) {
        if (context == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("MotorSettingLayoutSettingSwitch", "init: context == null");
            }
        } else {
            a(context, R.layout.nsdk_layout_setting_switch_item, this, true, z);
            this.e = (TextView) findViewById(R.id.setting_switch_item_title);
            this.g = (ImageView) findViewById(R.id.setting_switch_item_image);
        }
    }

    public BNSettingSwitchItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = false;
    }
}
