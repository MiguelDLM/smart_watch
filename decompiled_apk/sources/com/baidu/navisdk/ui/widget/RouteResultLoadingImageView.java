package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.ScreenUtil;

/* loaded from: classes8.dex */
public class RouteResultLoadingImageView extends LoadingAnimViewNew {
    public RouteResultLoadingImageView(Context context) {
        super(context);
    }

    @Override // com.baidu.navisdk.ui.widget.LoadingAnimViewNew
    public void setExactlySize(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(ScreenUtil.getInstance().dip2px(60), ScreenUtil.getInstance().dip2px(60));
            this.backWidth = ScreenUtil.getInstance().dip2px(30);
        }
    }

    @Override // com.baidu.navisdk.ui.widget.LoadingAnimViewNew
    public void setInitAttr(@Nullable AttributeSet attributeSet, int i) {
        this.backColor = Color.parseColor("#cccccc");
        this.centerImageId = R.drawable.route_loading_15;
        this.backAnimId = R.anim.normal_back_circle_set;
        this.centerAnimId = R.anim.normal_center_image_set;
        this.isAutoStart = true;
    }

    public RouteResultLoadingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RouteResultLoadingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
