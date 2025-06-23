package com.sma.smartv3.ui.status.item;

import android.view.View;
import android.view.ViewGroup;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.blankj.utilcode.util.SizeUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.sma.smartv3.co_fit.R;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class SpaceItem extends BaseDslItem {
    private int height = 20;
    private View view;

    private final float dp2px(int i) {
        return SizeUtils.dp2px(i);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OXOo.OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.view);
        IIX0o.ooOOo0oXI(v);
        this.view = v;
    }

    public final int getHeight() {
        return this.height;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        View view = this.view;
        View view2 = null;
        if (view == null) {
            IIX0o.XOxIOxOx(ViewHierarchyConstants.VIEW_KEY);
            view = null;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = (int) dp2px(this.height);
        View view3 = this.view;
        if (view3 == null) {
            IIX0o.XOxIOxOx(ViewHierarchyConstants.VIEW_KEY);
        } else {
            view2 = view3;
        }
        view2.setLayoutParams(layoutParams);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.alta_space_item;
    }

    public final void setHeight(int i) {
        this.height = i;
    }
}
