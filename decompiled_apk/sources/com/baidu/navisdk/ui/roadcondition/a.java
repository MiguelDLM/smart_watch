package com.baidu.navisdk.ui.roadcondition;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.module.pronavi.model.c;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public View f8410a;
    public TextView b;
    public ImageView c;
    private boolean d = false;

    public boolean a(b bVar, ViewGroup viewGroup) {
        if (b() && viewGroup != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f8410a.getLayoutParams();
            if (layoutParams == null) {
                g gVar = g.COMMON_UI;
                if (gVar.c()) {
                    gVar.c("BNRoadConditionLabelVie", "update lp == null");
                }
                return false;
            }
            if (bVar.g) {
                layoutParams.bottomMargin = bVar.e;
                layoutParams.rightMargin = bVar.f;
                a(bVar);
            } else {
                layoutParams.bottomMargin = bVar.c;
                layoutParams.rightMargin = bVar.d;
                b(bVar);
            }
            layoutParams.gravity = 85;
            this.f8410a.setTag(Integer.valueOf(bVar.b.f));
            if (TextUtils.isEmpty(bVar.b.o)) {
                this.b.setVisibility(8);
            } else {
                this.b.setText(bVar.b.o);
                this.b.setVisibility(0);
            }
            this.b.setTextColor(c(bVar));
            this.c.setImageResource(bVar.b.p);
            if (this.f8410a.getParent() instanceof ViewGroup) {
                return true;
            }
            viewGroup.addView(this.f8410a);
            return true;
        }
        g gVar2 = g.COMMON_UI;
        if (gVar2.c()) {
            gVar2.c("BNRoadConditionLabelVie", "update layout is null");
        }
        return false;
    }

    public boolean b() {
        return (this.f8410a == null || this.b == null || this.c == null) ? false : true;
    }

    public void c() {
        View view = this.f8410a;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f8410a);
                this.f8410a.setOnClickListener(null);
            }
        }
    }

    public void b(b bVar) {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("BNRoadConditionLabelVie", "switchToNormalLabel: " + this.d);
        }
        if (this.d) {
            this.d = false;
            a(bVar, false);
        }
    }

    @ColorInt
    private int c(b bVar) {
        c cVar;
        if (bVar != null && (cVar = bVar.b) != null && cVar.n && !TextUtils.isEmpty(f.p0.c)) {
            try {
                return Color.parseColor(f.p0.c);
            } catch (Exception e) {
                g gVar = g.COMMON_UI;
                if (gVar.b()) {
                    gVar.a("BNRoadConditionLabelVie", e);
                }
            }
        }
        if (!TextUtils.isEmpty(f.p0.b)) {
            try {
                return Color.parseColor(f.p0.b);
            } catch (Exception e2) {
                g gVar2 = g.COMMON_UI;
                if (gVar2.b()) {
                    gVar2.a("BNRoadConditionLabelVie", e2);
                }
            }
        }
        return Color.parseColor("#333333");
    }

    public void a() {
        c();
    }

    public void a(b bVar) {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("BNRoadConditionLabelVie", "switchToBigLabel: " + this.d);
        }
        if (this.d) {
            return;
        }
        this.d = true;
        a(bVar, true);
    }

    private void a(b bVar, boolean z) {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        int dimensionPixelSize3;
        int dimensionPixelSize4;
        int dimensionPixelSize5;
        if (z) {
            dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_16dp);
            dimensionPixelSize2 = JarUtils.getResources().getDimensionPixelSize(R.dimen.bn_rg_road_condition_label_icon_big_width);
            dimensionPixelSize3 = JarUtils.getResources().getDimensionPixelSize(R.dimen.bn_rg_road_condition_label_big_height);
            dimensionPixelSize4 = JarUtils.getResources().getDimensionPixelSize(R.dimen.bn_rg_road_condition_label_big_left_margin_end);
            dimensionPixelSize5 = JarUtils.getResources().getDimensionPixelSize(R.dimen.bn_rg_road_condition_label_big_text_padding_end);
        } else {
            dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_12dp);
            dimensionPixelSize2 = JarUtils.getResources().getDimensionPixelSize(R.dimen.bn_rg_road_condition_label_icon_normal_width);
            dimensionPixelSize3 = JarUtils.getResources().getDimensionPixelSize(R.dimen.bn_rg_road_condition_label_normal_height);
            dimensionPixelSize4 = JarUtils.getResources().getDimensionPixelSize(R.dimen.bn_rg_road_condition_label_left_margin_end);
            dimensionPixelSize5 = JarUtils.getResources().getDimensionPixelSize(R.dimen.bn_rg_road_condition_label_text_padding_end);
        }
        this.b.setTextSize(0, dimensionPixelSize);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.b.getLayoutParams();
        marginLayoutParams.rightMargin = dimensionPixelSize4;
        marginLayoutParams.height = dimensionPixelSize3;
        TextView textView = this.b;
        textView.setPadding(textView.getPaddingLeft(), this.b.getPaddingTop(), dimensionPixelSize5, this.b.getPaddingBottom());
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.c.getLayoutParams();
        marginLayoutParams2.width = dimensionPixelSize2;
        marginLayoutParams2.height = dimensionPixelSize2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f8410a.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.bottomMargin = bVar.e;
                layoutParams.rightMargin = bVar.f;
            } else {
                layoutParams.bottomMargin = bVar.c;
                layoutParams.rightMargin = bVar.d;
            }
        }
        this.f8410a.requestLayout();
    }
}
