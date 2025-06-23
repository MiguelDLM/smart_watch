package com.baidu.navisdk.ugc.pictures.show;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.j;

/* loaded from: classes8.dex */
public abstract class ShowPicLayout extends LinearLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    protected int f8219a;
    protected int b;
    protected ImageView[] c;

    public ShowPicLayout(Context context) {
        this(context, null);
    }

    public ImageView a(int i) {
        ImageView imageView = new ImageView(getContext());
        imageView.setTag(R.id.view_tag_first, Integer.valueOf(i));
        imageView.setOnClickListener(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.b, -1);
        if (i != 0) {
            layoutParams.leftMargin = this.f8219a;
        }
        layoutParams.gravity = 17;
        imageView.setLayoutParams(layoutParams);
        addView(imageView);
        return imageView;
    }

    public void b(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        this.b = (((i - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin) - (this.f8219a * 2)) / 3;
    }

    public ShowPicLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShowPicLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(0);
        setGravity(16);
        this.f8219a = context.getResources().getDimensionPixelSize(R.dimen.navi_dimens_6dp);
        this.c = new ImageView[3];
    }

    public void a() {
        ImageView[] imageViewArr = this.c;
        if (imageViewArr != null) {
            for (ImageView imageView : imageViewArr) {
                if (imageView != null) {
                    j.b(imageView);
                }
            }
            this.c = null;
        }
        removeAllViews();
    }
}
