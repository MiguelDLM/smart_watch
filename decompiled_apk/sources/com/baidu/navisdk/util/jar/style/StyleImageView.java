package com.baidu.navisdk.util.jar.style;

import android.view.View;
import android.widget.ImageView;
import com.baidu.navisdk.ui.util.b;

/* loaded from: classes8.dex */
public class StyleImageView extends StyleCommonView {
    private static final String TAG = "StyleImageView";
    public StyleAttr mImageResourceAttr;

    public StyleImageView(View view) {
        super(view);
    }

    public void updateImageResource(ImageView imageView) {
        StyleAttr styleAttr = this.mImageResourceAttr;
        if (styleAttr != null) {
            imageView.setImageDrawable(b.f(styleAttr.mId));
        }
    }

    @Override // com.baidu.navisdk.util.jar.style.StyleCommonView
    public void updateStyle() {
        super.updateStyle();
        ImageView imageView = (ImageView) this.mView.get();
        if (imageView == null) {
            return;
        }
        updateImageResource(imageView);
    }
}
