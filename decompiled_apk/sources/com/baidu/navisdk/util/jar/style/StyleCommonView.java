package com.baidu.navisdk.util.jar.style;

import android.view.View;
import com.baidu.navisdk.ui.util.b;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public class StyleCommonView {
    private static final String TAG = "StyleCommonView";
    public StyleAttr mBackGroundAttr;
    public int mKey;
    public WeakReference<View> mView;

    public StyleCommonView(View view) {
        this.mView = new WeakReference<>(view);
        this.mKey = view.hashCode();
    }

    private void updateBackground(View view) {
        StyleAttr styleAttr = this.mBackGroundAttr;
        if (styleAttr != null) {
            if ("color".equals(styleAttr.mEntryType)) {
                view.setBackgroundColor(b.b(this.mBackGroundAttr.mId));
            } else if ("drawable".equals(this.mBackGroundAttr.mEntryType)) {
                view.setBackgroundDrawable(b.f(this.mBackGroundAttr.mId));
            }
        }
    }

    public void updateStyle() {
        View view = this.mView.get();
        if (view == null) {
            return;
        }
        updateBackground(view);
    }
}
