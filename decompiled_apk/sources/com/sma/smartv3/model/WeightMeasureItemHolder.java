package com.sma.smartv3.model;

import OXOo.OOXIXo;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.ExpandableLayout;
import com.sma.smartv3.view.segmentedbar.CircleThumbSegmentedBarView;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFMedium;
import java.util.HashSet;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class WeightMeasureItemHolder extends RecyclerView.ViewHolder {

    @OOXIXo
    private final ExpandableLayout expandableLayout;

    @OOXIXo
    private final ImageView ivIcom;

    @OOXIXo
    private final ImageView ivSwitcher;

    @OOXIXo
    private final HashSet<Integer> mExpandedPositionSet;

    @OOXIXo
    private final RecyclerView recyclerView;

    @OOXIXo
    private final CircleThumbSegmentedBarView sbv;

    @OOXIXo
    private final PFMedium tvLevel;

    @OOXIXo
    private final PFMedium tvName;

    @OOXIXo
    private final DINCondBold tvTips;

    @OOXIXo
    private final PFMedium tvValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeightMeasureItemHolder(@OOXIXo View view) {
        super(view);
        IIX0o.x0xO0oo(view, "view");
        this.mExpandedPositionSet = new HashSet<>();
        View findViewById = view.findViewById(R.id.expandable_layout);
        IIX0o.oO(findViewById, "findViewById(...)");
        this.expandableLayout = (ExpandableLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.iv_icon);
        IIX0o.oO(findViewById2, "findViewById(...)");
        this.ivIcom = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_name);
        IIX0o.oO(findViewById3, "findViewById(...)");
        this.tvName = (PFMedium) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_value);
        IIX0o.oO(findViewById4, "findViewById(...)");
        this.tvValue = (PFMedium) findViewById4;
        View findViewById5 = view.findViewById(R.id.tv_level);
        IIX0o.oO(findViewById5, "findViewById(...)");
        this.tvLevel = (PFMedium) findViewById5;
        View findViewById6 = view.findViewById(R.id.sbv);
        IIX0o.oO(findViewById6, "findViewById(...)");
        this.sbv = (CircleThumbSegmentedBarView) findViewById6;
        View findViewById7 = view.findViewById(R.id.tv_tips);
        IIX0o.oO(findViewById7, "findViewById(...)");
        this.tvTips = (DINCondBold) findViewById7;
        View findViewById8 = view.findViewById(R.id.switcher);
        IIX0o.oO(findViewById8, "findViewById(...)");
        this.ivSwitcher = (ImageView) findViewById8;
        View findViewById9 = view.findViewById(R.id.recyclerView);
        IIX0o.oO(findViewById9, "findViewById(...)");
        this.recyclerView = (RecyclerView) findViewById9;
    }

    private final void addExpand(int i) {
        this.mExpandedPositionSet.add(Integer.valueOf(i));
    }

    private final void registerExpand(int i) {
        if (this.mExpandedPositionSet.contains(Integer.valueOf(i))) {
            removeExpand(i);
        } else {
            addExpand(i);
        }
    }

    private final void removeExpand(int i) {
        this.mExpandedPositionSet.remove(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateItem$lambda$0(WeightMeasureItemHolder this$0, int i, boolean z) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.registerExpand(i);
    }

    @OOXIXo
    public final ExpandableLayout getExpandableLayout() {
        return this.expandableLayout;
    }

    @OOXIXo
    public final ImageView getIvIcom() {
        return this.ivIcom;
    }

    @OOXIXo
    public final ImageView getIvSwitcher() {
        return this.ivSwitcher;
    }

    @OOXIXo
    public final HashSet<Integer> getMExpandedPositionSet() {
        return this.mExpandedPositionSet;
    }

    @OOXIXo
    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    @OOXIXo
    public final CircleThumbSegmentedBarView getSbv() {
        return this.sbv;
    }

    @OOXIXo
    public final PFMedium getTvLevel() {
        return this.tvLevel;
    }

    @OOXIXo
    public final PFMedium getTvName() {
        return this.tvName;
    }

    @OOXIXo
    public final DINCondBold getTvTips() {
        return this.tvTips;
    }

    @OOXIXo
    public final PFMedium getTvValue() {
        return this.tvValue;
    }

    public final void updateItem(final int i) {
        this.expandableLayout.setOnExpandListener(new ExpandableLayout.I0Io() { // from class: com.sma.smartv3.model.oIX0oI
            @Override // com.sma.smartv3.view.ExpandableLayout.I0Io
            public final void oIX0oI(boolean z) {
                WeightMeasureItemHolder.updateItem$lambda$0(WeightMeasureItemHolder.this, i, z);
            }
        });
        this.expandableLayout.setExpand(this.mExpandedPositionSet.contains(Integer.valueOf(i)));
    }
}
