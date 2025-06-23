package com.baidu.navisdk.module.vehiclemanager.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public abstract class ASettingAddView extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    private int f7608a;
    private View b;
    private View c;
    private boolean d;
    protected TextView e;
    protected TextView f;

    public ASettingAddView(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArray;
        int resourceId;
        if (context == null) {
            g gVar = g.COMMON_UI;
            if (gVar.c()) {
                gVar.c("MotorSettingLayoutAAddView", "init: context == null");
                return;
            }
            return;
        }
        this.d = false;
        if (attributeSet != null) {
            typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.ASettingAddView);
            int i = R.styleable.ASettingAddView_nsdk_explain_item_day_night;
            if (typedArray.hasValue(i)) {
                this.d = typedArray.getBoolean(i, false);
            }
        } else {
            typedArray = null;
        }
        a(context, attributeSet, this.d);
        if (typedArray != null) {
            int i2 = R.styleable.ASettingAddView_nsdk_add_view_margin_left;
            if (typedArray.hasValue(i2)) {
                this.f7608a = typedArray.getDimensionPixelSize(i2, 0);
            }
            int i3 = R.styleable.ASettingAddView_nsdk_add_view_rightOfTitle;
            if (typedArray.hasValue(i3)) {
                int resourceId2 = typedArray.getResourceId(i3, 0);
                if (resourceId2 > 0) {
                    a(resourceId2);
                }
            } else {
                int i4 = R.styleable.ASettingAddView_nsdk_add_view_rightTopOfTitle;
                if (typedArray.hasValue(i4) && (resourceId = typedArray.getResourceId(i4, 0)) > 0) {
                    b(resourceId);
                }
            }
            Resources resources = context.getResources();
            if (typedArray.hasValue(R.styleable.ASettingAddView_nsdk_add_view_title_textSize) && this.e != null) {
                this.e.setTextSize(0, typedArray.getDimensionPixelSize(r2, resources.getDimensionPixelSize(R.dimen.navi_dimens_18dp)));
            }
            if (typedArray.hasValue(R.styleable.ASettingAddView_nsdk_add_view_tip_textSize) && this.f != null) {
                this.f.setTextSize(0, typedArray.getDimensionPixelSize(r2, resources.getDimensionPixelSize(R.dimen.navi_dimens_14dp)));
            }
            if (this.f != null) {
                int i5 = R.styleable.ASettingAddView_nsdk_add_tip_tag_txt;
                if (typedArray.hasValue(i5)) {
                    String string = typedArray.getString(i5);
                    int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.navi_dimens_12dp);
                    int i6 = R.styleable.ASettingAddView_nsdk_add_tip_tag_size;
                    if (typedArray.hasValue(i6)) {
                        dimensionPixelSize = typedArray.getDimensionPixelSize(i6, dimensionPixelSize);
                    }
                    int color = resources.getColor(R.color.nsdk_cl_click_b);
                    int i7 = R.styleable.ASettingAddView_nsdk_add_tip_tag_color;
                    if (typedArray.hasValue(i7)) {
                        color = typedArray.getColor(i7, color);
                    }
                    int i8 = R.styleable.ASettingAddView_nsdk_add_tip_tag_bg;
                    int resourceId3 = typedArray.hasValue(i8) ? typedArray.getResourceId(i8, 0) : 0;
                    TextView textView = new TextView(context);
                    textView.setTextColor(color);
                    textView.setText(string);
                    textView.setTextSize(0, dimensionPixelSize);
                    if (resourceId3 != 0) {
                        textView.setBackgroundResource(resourceId3);
                        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.navi_dimens_4dp);
                        textView.setPadding(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
                    }
                    a(textView);
                }
            }
            typedArray.recycle();
        }
    }

    public abstract void a(Context context, AttributeSet attributeSet, boolean z);

    public void b(View view) {
        if (view == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("MotorSettingLayoutAAddView", "addViewToRightOfTitle view == null");
                return;
            }
            return;
        }
        this.b = view;
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = this.f7608a;
        layoutParams.startToEnd = getTitleId();
        layoutParams.bottomToBottom = getTitleId();
        layoutParams.topToTop = getTitleId();
        addView(view, layoutParams);
    }

    public void c(View view) {
        if (view == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("MotorSettingLayoutAAddView", "addViewToRightOfTitle view == null");
                return;
            }
            return;
        }
        this.b = view;
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = this.f7608a;
        layoutParams.startToEnd = getTitleId();
        layoutParams.topToTop = getTitleId();
        addView(view, layoutParams);
    }

    @IdRes
    public abstract int getTitleId();

    public void setTitle(CharSequence charSequence) {
        TextView textView = this.e;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }

    public ASettingAddView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ASettingAddView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7608a = 0;
        this.b = null;
        this.d = false;
        a(context, attributeSet);
    }

    public void b(int i) {
        c(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this, false));
    }

    public void a(@LayoutRes int i) {
        b(a(getContext(), i, this, false, this.d));
    }

    public void a() {
        View view = this.b;
        if (view != null) {
            removeView(view);
            this.b = null;
        }
    }

    public void a(View view) {
        if (view != null && this.f != null) {
            this.c = view;
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = this.f7608a;
            layoutParams.startToEnd = this.f.getId();
            layoutParams.topToTop = this.f.getId();
            layoutParams.bottomToBottom = this.f.getId();
            addView(view, layoutParams);
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MotorSettingLayoutAAddView", "addViewToRightOfTitle view:" + view + ", tipView:" + this.f);
        }
    }

    public View a(Context context, int i, ViewGroup viewGroup, boolean z, boolean z2) {
        if (z2) {
            return b.a(context, i, viewGroup, z);
        }
        return LayoutInflater.from(context).inflate(i, viewGroup, z);
    }
}
