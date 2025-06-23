package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.b;

/* loaded from: classes8.dex */
public final class SettingSwitchWidget extends RelativeLayout {
    private static final String TAG = "SettingSwitchWidget";
    private boolean isChecked;
    private boolean isDay;
    private boolean isShowJump;
    private boolean isShowSelect;
    private boolean isShowSubTitle;
    private boolean isShowSwitch;
    private boolean isShowTips;
    private boolean isShowTitle;
    private SwitchItemOnCheckedListener mCheckedListener;
    private Context mContext;
    private String subTitle;
    private TextView subTitleView;
    private ImageView switchView;
    private String tips;
    private TextView tipsView;
    private String title;
    private TextView titleView;

    /* loaded from: classes8.dex */
    public interface SwitchItemOnCheckedListener {
        boolean onChecked(int i, boolean z);
    }

    public SettingSwitchWidget(Context context) {
        this(context, null);
    }

    private void updateSwitchState() {
        setChecked(false);
    }

    private void updateWindow() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.switch_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        if (this.isShowSubTitle) {
            layoutParams.height = dip2px(this.mContext, 70.0f);
        } else {
            layoutParams.height = dip2px(this.mContext, 40.0f);
        }
        relativeLayout.setLayoutParams(layoutParams);
    }

    public int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void initAndLoadView(Context context) {
        if (context == null) {
            return;
        }
        LayoutInflater.from(context).inflate(R.layout.bnav_layout_switch_item, (ViewGroup) this, true);
        this.titleView = (TextView) findViewById(R.id.setting_switch_item_title);
        this.subTitleView = (TextView) findViewById(R.id.setting_switch_item_subtitle);
        this.tipsView = (TextView) findViewById(R.id.setting_switch_item_tips);
        this.switchView = (ImageView) findViewById(R.id.setting_switch_item_image);
        if (this.isShowSubTitle && !TextUtils.isEmpty(this.subTitle)) {
            this.subTitleView.setVisibility(0);
            this.subTitleView.setText(this.subTitle);
        } else {
            this.subTitleView.setVisibility(8);
        }
        if (this.isShowTitle && !TextUtils.isEmpty(this.title)) {
            this.titleView.setVisibility(0);
            this.titleView.setText(this.title);
        } else {
            this.titleView.setVisibility(8);
        }
        if (this.isShowTips && !TextUtils.isEmpty(this.tips)) {
            this.tipsView.setVisibility(0);
            this.tipsView.setText(this.tips);
        } else {
            this.tipsView.setVisibility(8);
        }
        updateSwitchState();
        updateWindow();
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
        ImageView imageView = this.switchView;
        if (imageView != null) {
            imageView.setSelected(z);
            if (z) {
                if (this.isShowSwitch) {
                    this.switchView.setImageResource(R.drawable.nsdk_set_checkin_icon);
                    return;
                } else if (this.isShowSelect) {
                    this.switchView.setImageResource(R.drawable.nsdk_rg_bluetooth_panel_checkbox_checked);
                    return;
                } else {
                    if (this.isShowJump) {
                        this.switchView.setImageResource(R.drawable.nsdk_drawable_plate_list_right_arrow);
                        return;
                    }
                    return;
                }
            }
            if (this.isShowSwitch) {
                this.switchView.setImageResource(R.drawable.nsdk_set_checkout_icon);
            } else if (this.isShowSelect) {
                this.switchView.setImageResource(R.drawable.nsdk_rg_bluetooth_panel_checkbox_unchecked);
            } else if (this.isShowJump) {
                this.switchView.setImageResource(R.drawable.nsdk_drawable_plate_list_right_arrow);
            }
        }
    }

    public void setOnCheckedListener(SwitchItemOnCheckedListener switchItemOnCheckedListener) {
        this.mCheckedListener = switchItemOnCheckedListener;
        if (switchItemOnCheckedListener != null) {
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.SettingSwitchWidget.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z;
                    boolean z2 = !SettingSwitchWidget.this.isChecked;
                    if (SettingSwitchWidget.this.mCheckedListener != null) {
                        z = SettingSwitchWidget.this.mCheckedListener.onChecked(SettingSwitchWidget.this.getId(), z2);
                    } else {
                        z = false;
                    }
                    Log.d(SettingSwitchWidget.TAG, "onClick: checkedSuccess " + z);
                    if (z) {
                        SettingSwitchWidget.this.setChecked(z2);
                    }
                }
            });
        } else {
            setOnClickListener(null);
        }
    }

    public void setSubTitleViewVisible(int i) {
        TextView textView = this.subTitleView;
        if (textView != null) {
            textView.setVisibility(i);
        }
    }

    public void updateStyle(boolean z) {
        if (this.isDay == z) {
            return;
        }
        this.isDay = z;
        TextView textView = this.titleView;
        if (textView != null) {
            textView.setTextColor(b.a(R.color.nsdk_cl_text_a, z));
        }
        TextView textView2 = this.subTitleView;
        if (textView2 != null) {
            textView2.setTextColor(b.a(R.color.nsdk_cl_text_f, z));
        }
    }

    public SettingSwitchWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SettingSwitchWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isDay = true;
        this.isChecked = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SettingSwitchWidget);
        this.isShowTitle = obtainStyledAttributes.getBoolean(R.styleable.SettingSwitchWidget_nsdk_setting_switch_show_title, true);
        this.isShowSubTitle = obtainStyledAttributes.getBoolean(R.styleable.SettingSwitchWidget_nsdk_setting_switch_show_subtitle, false);
        this.isShowSwitch = obtainStyledAttributes.getBoolean(R.styleable.SettingSwitchWidget_nsdk_setting_switch_show, false);
        this.isShowSelect = obtainStyledAttributes.getBoolean(R.styleable.SettingSwitchWidget_nsdk_setting_switch_show_select, false);
        this.isShowJump = obtainStyledAttributes.getBoolean(R.styleable.SettingSwitchWidget_nsdk_setting_switch_show_jump, false);
        this.isShowTips = obtainStyledAttributes.getBoolean(R.styleable.SettingSwitchWidget_nsdk_setting_switch_show_tips, false);
        this.title = obtainStyledAttributes.getString(R.styleable.SettingSwitchWidget_nsdk_setting_switch_title);
        this.subTitle = obtainStyledAttributes.getString(R.styleable.SettingSwitchWidget_nsdk_setting_switch_subtitle);
        this.tips = obtainStyledAttributes.getString(R.styleable.SettingSwitchWidget_nsdk_setting_switch_tips);
        obtainStyledAttributes.recycle();
        this.mContext = context;
        initAndLoadView(context);
    }
}
