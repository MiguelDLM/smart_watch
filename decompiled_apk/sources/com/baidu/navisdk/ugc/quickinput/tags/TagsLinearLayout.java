package com.baidu.navisdk.ugc.quickinput.tags;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class TagsLinearLayout extends LinearLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private TagItemView[] f8230a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private a h;

    public TagsLinearLayout(Context context) {
        super(context);
        this.g = -1;
        a();
    }

    private void a() {
        setOrientation(0);
        setGravity(16);
        setBackgroundResource(R.color.white);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        if (!(view instanceof TagItemView)) {
            return;
        }
        if (view.getTag() instanceof Integer) {
            i = ((Integer) view.getTag()).intValue();
        } else {
            i = -1;
        }
        if (i == -1) {
            return;
        }
        int i2 = this.g;
        if (i == i2) {
            this.f8230a[i].a(false);
            this.g = -1;
            a aVar = this.h;
            if (aVar != null) {
                aVar.a(-1, null, this.f);
                return;
            }
            return;
        }
        if (i2 != -1) {
            this.f8230a[i2].a(false);
            a aVar2 = this.h;
            if (aVar2 != null) {
                aVar2.a(-1, null, this.f);
            }
        }
        this.f8230a[i].a(true);
        this.g = i;
        a aVar3 = this.h;
        if (aVar3 != null) {
            aVar3.a(this.f8230a[i].getType(), this.f8230a[i].getText().toString(), this.f);
        }
    }

    public void setOnTagItemClickListener(a aVar) {
        this.h = aVar;
    }

    public TagsLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = -1;
        a();
    }

    public void a(b[] bVarArr, int i, int i2, int i3) {
        boolean z;
        removeAllViews();
        if (bVarArr != null && bVarArr.length > 0) {
            this.g = -1;
            this.f = i2;
            int min = Math.min(4, bVarArr.length);
            a(min, i);
            this.f8230a = new TagItemView[min];
            for (int i4 = 0; i4 < min; i4++) {
                b bVar = bVarArr[i4];
                if (bVar != null) {
                    int i5 = bVar.b;
                    if (i5 == i3) {
                        this.g = i4;
                        z = true;
                    } else {
                        z = false;
                    }
                    this.f8230a[i4] = a(bVar.f8231a, i5, i4, z);
                }
            }
            return;
        }
        setVisibility(8);
    }

    public TagsLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = -1;
        a();
    }

    private void a(int i, int i2) {
        this.d = ScreenUtil.getInstance().dip2px(8);
        if (i2 == 1) {
            this.c = JarUtils.getResources().getDimensionPixelSize(com.baidu.navisdk.embed.R.dimen.navi_dimens_26dp);
            this.e = JarUtils.getResources().getDimensionPixelSize(com.baidu.navisdk.embed.R.dimen.navi_dimens_15dp);
            this.b = ((ScreenUtil.getInstance().getWidthPixels() - (this.e * 2)) - (this.d * (i - 1))) / i;
        } else {
            this.c = JarUtils.getResources().getDimensionPixelSize(com.baidu.navisdk.embed.R.dimen.navi_dimens_26dp);
            this.e = JarUtils.getResources().getDimensionPixelSize(com.baidu.navisdk.embed.R.dimen.navi_dimens_22dp);
            this.b = ((ScreenUtil.getInstance().getHeightPixels() - (this.e * 2)) - (this.d * (i - 1))) / i;
        }
        setPadding(this.e, getPaddingTop(), this.e, getPaddingBottom());
        setVisibility(0);
    }

    private TagItemView a(String str, int i, int i2, boolean z) {
        TagItemView tagItemView = new TagItemView(getContext());
        tagItemView.setTag(Integer.valueOf(i2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.b, this.c);
        if (i2 == 0) {
            layoutParams.leftMargin = 0;
        } else {
            layoutParams.leftMargin = this.d;
        }
        addView(tagItemView, layoutParams);
        tagItemView.a(str, i, z);
        tagItemView.setOnClickListener(this);
        return tagItemView;
    }
}
